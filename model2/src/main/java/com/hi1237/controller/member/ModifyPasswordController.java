package com.hi1237.controller.member;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.hi1237.model.MemberDao;
import com.hi1237.model.MemberDto;

@WebServlet("/member/modifyPassword")
public class ModifyPasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ModifyPasswordController() {
        super();
        
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/member/modifyPassword.jsp");
		dispatcher.forward(request, response);
		
//		request.setCharacterEncoding("utf-8");
//		String userId=request.getParameter("userId"); // join.jsp의 name을 가져온 것
//		String userPw=request.getParameter("userPw");
//		
//		MemberDao memberDao= new MemberDao();
//		MemberDto memberDto=new MemberDto();
//		
//		memberDto.setId(userId);
//		memberDto.setPassword(userPw);
//		
//		MemberDto modifiedMember = memberDao.modifyPasswordMember(memberDto);
//	}

	}
}
