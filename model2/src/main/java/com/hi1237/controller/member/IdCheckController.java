package com.hi1237.controller.member;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import com.hi1237.model.MemberDao;

@WebServlet("/member/idCheck")
public class IdCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public IdCheckController() {
        super();
      
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDao memberDao = new MemberDao();
		String userId = request.getParameter("userId");
		
		int result= memberDao.idCheck(userId);
		request.setAttribute("count", result);
//		HttpSession session = request.getSession();
//		session.setAttribute("count", 2);
		
	
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/member/idCheck.jsp");
		dispatcher.forward(request, response);
	}

}
