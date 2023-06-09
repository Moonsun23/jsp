package com.hi1237.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/login") // 여기 이름은 내가 만들기 나름.. member라고 꼭 쓰지 않아도 된다.
public class LoginFormController extends HttpServlet {			// 파일 하나당 controller 하나씩 만들어줘야 한다.. join.jsp에 joinFormController(servlet)
	// 호출은 controller로 해줘야 한다.
	private static final long serialVersionUID = 1L;
       
    public LoginFormController() {
        super();
        
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/member/login.jsp");	// 이부분은 정확한 폴더명을 적어야 한다
		dispatcher.forward(request, response);
	}

}
