package com.hi1237.controller.board;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.hi1237.model.BoardDao;
import com.hi1237.utils.ScriptWriter;

@WebServlet("/board/delete")

public class DeleteProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public DeleteProcessController() {
        super();
       
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		BoardDao boardDao= new BoardDao();
		int result = boardDao.deleteBoard(id);
		if(result>0) {
			ScriptWriter.alertAndNext(response, "게시물이 삭제되었습니다.", "../board/list");
		}else {
			ScriptWriter.alertAndBack(response, "오류가 발생되었네요? 다시 시도해보세요");
		}
	}

}
