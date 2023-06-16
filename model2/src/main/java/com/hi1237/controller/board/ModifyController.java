package com.hi1237.controller.board;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.hi1237.model.BoardDao;
import com.hi1237.model.BoardDto;

@WebServlet("/board/modify")

public class ModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ModifyController() {
        super();
        
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		BoardDao boardDao = new BoardDao();
		BoardDto boardDto=boardDao.getView(id);
		
		request.setAttribute("boardDto", boardDto);
		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/board/modify.jsp"); //modify는 글쓰기랑 똑같
		dispatcher.forward(request, response);
	}

}
