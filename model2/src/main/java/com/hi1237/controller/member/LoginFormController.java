package com.hi1237.controller.member;
// 여기는 java 코드는 거의 없고 아래 WEB-INF/ 경로 를 통해 페이지를 연결시켜주는 역할이 있음..
import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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
