package com.hi1237.controller.member;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/member/join") // 아래 WEB-INF 로 주소설정을 해줬기때문에 앞으로 /member/join 으로 외부접근이 가능하게 하려면 뒤에 붙는 .jsp를 떼고 붙여야 한다.
// 아래 있는 member/join과 다른 경로의 이름이더라도 열린다.// 내맘대로 정해주면 된다.
public class JoinFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public JoinFormController() {
        super();
        
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher =request.getRequestDispatcher("/WEB-INF/member/join.jsp");
		// dispatcher : 서버가 @WebServlet ..의 주소를 호출했을때 서버가 데이터를 불러다가 꽂아주는 것..
		dispatcher.forward(request, response);
	}

}
