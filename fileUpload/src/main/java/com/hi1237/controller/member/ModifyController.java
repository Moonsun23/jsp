package com.hi1237.controller.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hi1237.model.MemberDao;
import com.hi1237.model.MemberDto;

@WebServlet("/member/modify")
public class ModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ModifyController() {
        super();
        
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId=request.getParameter("userId");
		
		MemberDao memberDao= new MemberDao();
		MemberDto infoMemberDto=memberDao.getMemberInfo(userId);
		// getMemberInfo를 유효화 하기 위해 memberDao로 보내줌/..
		
		request.setAttribute("infoMemberDto", infoMemberDto);
		
		RequestDispatcher dispatcher= request.getRequestDispatcher("/WEB-INF/member/modify.jsp");
		dispatcher.forward(request, response);
	}

}
