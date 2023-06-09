package com.hi1237.controller.member;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.hi1237.model.MemberDao;
import com.hi1237.model.MemberDto;
import com.hi1237.utils.ScriptWriter;

@WebServlet("/member/modifyProcess")
public class ModifyProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ModifyProcessController() {
        super();
      
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		request.setCharacterEncoding("utf-8");
		String userId=request.getParameter("userId"); // join.jsp의 name을 가져온 것
		String userPw=request.getParameter("userPw");
		String userName=request.getParameter("userName");
		String userEmail=request.getParameter("userEmail");
		int zonecode=Integer.parseInt(request.getParameter("zonecode"));
		String userAddress=request.getParameter("userAddress");
		String detailAddress=request.getParameter("detailAddress");
		String extraAddress=request.getParameter("extraAddress");
		
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


