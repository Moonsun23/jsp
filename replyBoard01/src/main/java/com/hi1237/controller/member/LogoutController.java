package com.hi1237.controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hi1237.model.MemberDto;
import com.hi1237.utils.ScriptWriter;

@WebServlet("/member/logout")
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LogoutController() {
        super();
       
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberDto loggedMember= (MemberDto) session.getAttribute("loggedMember");
		String loggedMemberName=loggedMember.getName();
		session.invalidate();
		ScriptWriter.alertAndNext(response, loggedMemberName+"님 로그아웃 되셨습니다.", "../index/index");
	}

}
