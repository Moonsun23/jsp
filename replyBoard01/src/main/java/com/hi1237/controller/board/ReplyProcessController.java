package com.hi1237.controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hi1237.model.BoardDao;
import com.hi1237.model.BoardDto;
import com.hi1237.utils.ScriptWriter;

@WebServlet("/board/replyProcess")
public class ReplyProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReplyProcessController() {
        super();
       
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDao boardDao = new BoardDao(); 		// 정보를 실어나르는 선박// dto는 선박에 실린 컨테이너
		
		request.setCharacterEncoding("utf-8");		
		response.setContentType("text/html; charset=utf-8");
		
		// board write의 정보 3개(제목, 이름, 내용 을 받아오기 위해 request를 씀
		String userName=request.getParameter("userName");
		String userId=request.getParameter("userId");
		String title=request.getParameter("title");
		String contents=request.getParameter("contents");
		int regroup=Integer.parseInt(request.getParameter("regroup"));
		int relevel=Integer.parseInt(request.getParameter("relevel"));
		int restep=Integer.parseInt(request.getParameter("restep"));
		
		BoardDto boardDto = new BoardDto();
		
		boardDto.setRegroup(regroup);
		boardDto.setRelevel(relevel);
		boardDto.setRestep(restep);
		// 위에 값을 받아서 아래로 내려줌...
		
		boardDao.updateRelevel(boardDto);
		
		boardDto.setName(userName);
		boardDto.setUserID(userId);
		boardDto.setTitle(title);
		boardDto.setContents(contents);
		boardDto.setRegroup(regroup);
		boardDto.setRelevel(relevel+1);
		boardDto.setRestep(restep+1);
		
		
		int result=boardDao.replyBoard(boardDto);
		
		if(result>0) {
			// scriptwriter로 alert창 띄우는거 말고 list 페이지로 보내고 싶다면 아래처럼
			response.sendRedirect("../board/list");
		}else {
			ScriptWriter.alertAndBack(response, "오류가 나서 글을 다시 써야겠네 ㅅㄱ");
		}
	
	}

}
