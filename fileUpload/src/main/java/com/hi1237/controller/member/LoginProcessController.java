package com.hi1237.controller.member;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hi1237.model.MemberDao;
import com.hi1237.model.MemberDto;
import com.hi1237.utils.ScriptWriter;

@WebServlet("/member/loginProcess")
public class LoginProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginProcessController() {
        super();
        
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDao memberDao= new MemberDao();
		MemberDto memberDto= new MemberDto();
		String userId=request.getParameter("userId");
		String userPw=request.getParameter("userPw");
		memberDto.setId(userId);
		memberDto.setPassword(userPw);
		MemberDto loggedMember= memberDao.loginMember(memberDto);
		
		HttpSession session = request.getSession();
		if(loggedMember!=null) {
//			session.setAttribute("loggedMemberId", loggedMember.getId());
//			session.setAttribute("loggedMemberName", loggedMember.getName());
//			session.setAttribute("loggedMemberProfile", loggedMember.getRealProfile());
			session.setAttribute("loggedMember", loggedMember);
			// 페이지 넘겨줄때.. request.. 혹은 ScriptWriter..
			ScriptWriter.alertAndNext(response, loggedMember.getName()+"님 안녕하세요.", "../index/index");
		}else {
			ScriptWriter.alertAndBack(response, "알 수 없는 오류가 발생되었습니다. 잠시 후 다시 시도해주세요.");
		}
		
		
		System.out.println(loggedMember.toString());
	}

}
