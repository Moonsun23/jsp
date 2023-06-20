package com.hi1237.controller.member;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hi1237.model.MemberDao;
import com.hi1237.model.MemberDto;
import com.hi1237.utils.ScriptWriter;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/member/modifyProcess")
public class ModifyProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ModifyProcessController() {
        super();
      
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		request.setCharacterEncoding("utf-8");
		
		String encoding= "utf-8";
		int fileSize= 1024*1024*10;
		String savePath="upload";								// 폴더
		ServletContext context= this.getServletContext();
		String realPath=context.getRealPath(savePath);
		
		
//		String savaPath="C:\\Users\\y\\Desktop\\upload";						// c드라이브 밑에 저장한다는 뜻
		
		
		File currentDir = new File(realPath);
		if(!currentDir.exists()) {												// 폴더가 없으면 dir을 만들ㄹ
			currentDir.mkdir();
		}
		
		DefaultFileRenamePolicy fileRenamePolicy = new DefaultFileRenamePolicy();
		
		MultipartRequest multipartRequest= new MultipartRequest(request, realPath, fileSize, encoding, fileRenamePolicy);
		// multipart로 쓰면 request 죽음
		String userId=multipartRequest.getParameter("userId"); // join.jsp의 name을 가져온 것
		String userPw=multipartRequest.getParameter("userPw");
		String userName=multipartRequest.getParameter("userName");
		String userEmail=multipartRequest.getParameter("userEmail");
		int zonecode=Integer.parseInt(multipartRequest.getParameter("zonecode"));
		String userAddress=multipartRequest.getParameter("userAddress");
		String detailAddress=multipartRequest.getParameter("detailAddress");
		String extraAddress=multipartRequest.getParameter("extraAddress");
		
		String profile= multipartRequest.getOriginalFileName("profile");
		String realProfile= multipartRequest.getFilesystemName("profile");
		
		MemberDao memberDao= new MemberDao();
		MemberDto memberDto=new MemberDto();
		
		memberDto.setId(userId);
		memberDto.setPassword(userPw);
		memberDto.setName(userName);
		memberDto.setZonecode(zonecode);
		memberDto.setAddress(userAddress);
		memberDto.setExtraAddress(extraAddress);
		memberDto.setDetailAddress(detailAddress);
		memberDto.setEmail(userEmail);
		memberDto.setProfile(profile);
		memberDto.setRealProfile(realProfile);
		
		
		int result = memberDao.modifyMember(memberDto);
		if(result>0) {
			HttpSession session = request.getSession();
			session.invalidate();
			ScriptWriter.alertAndNext(response, "회원정보가 수정 되었습니다. 다시 로그인 해주세요", "../member/login");
			
		} else {
			ScriptWriter.alertAndBack(response, "알 수 없는 오류가 발생 되었습니다. 다시 시도해주세요.");
		}
		
		// business logic
	}
	}


