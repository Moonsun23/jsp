package com.hi1237.controller.board;

import java.io.IOException;
import java.util.ArrayList;



import com.hi1237.model.BoardDao;
import com.hi1237.model.BoardDto;
import com.hi1237.model.PageDto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/list")
public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListController() {
        super();
        
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// board 테이블의 row값을 가지고 오기
		BoardDao boardDao= new BoardDao();
//		String strStart= request.getParameter("start");								// 게시글 페이지 시작과 끝
//		String strEnd = request.getParameter("end");
		int clickPage=0;
		String tempClickPage = request.getParameter("clickPage");
		if(tempClickPage==null) {
			clickPage = 1; 	// null이면 1부터 시작해라..
		}else {
			clickPage = Integer.parseInt(tempClickPage);
		}
		
		double total= boardDao.getTotal();											// 전체 글 개수
		double pagePerList = 10;													// 한번에 보여줄 게시물 개수
		int pageBlock = 4;															// 페이지넘버가 5개까지만 보이도록(pagination 개수)
		
		
		int pageTotal= (int)(Math.ceil(total / pagePerList));						// 소숫점이 안나오게 Math.ceil로 감싸줌 pageTotl - 게시글
		int pageStart= (clickPage-1) / pageBlock*pageBlock +1;						// 1~pageBlock / pageBlock+1 ~ pageBlock
		int pageEnd= pageStart+pageBlock -1;
			if(pageEnd > pageTotal) pageEnd = pageTotal;
		// 마지막 페이지
		
		
		
//		int start= strStart==null? 1: Integer.parseInt(strStart);					// 삼항연산자
//		int end = strEnd==null? (int)  pagePerList: Integer.parseInt(strEnd);
		
		// clickPage=1; // 1 == 1~10; 2 == 11~20
			int start= (clickPage -1)* (int)pagePerList+1;							// 1, 11, 21
			int end = start +(int)pagePerList -1;									// 10, 21, 30	
			
		
		PageDto pageDto = new PageDto();
		pageDto.setPageTotal(pageTotal);
		pageDto.setTotal(total);
		pageDto.setPageBlock(pageBlock);
		pageDto.setPageStart(pageStart);
		pageDto.setPageEnd(pageEnd);
		pageDto.setPagePerList(pagePerList);
		
			
		ArrayList<BoardDto> boardList=boardDao.getList(start, end); 
		request.setAttribute("clickPage", clickPage);
		request.setAttribute("boardList", boardList);
		
//		request.setAttribute("total", (int)total);
//		request.setAttribute("pageTotal", pageTotal);								//boardDao.list에 아래 attribute를 통해 담아줌
//		request.setAttribute("pageBlock", pageBlock);
//		request.setAttribute("pageStart", pageStart);
//		request.setAttribute("pageEnd", pageEnd);
//		request.setAttribute("pagePerList", (int)pagePerList);						// 게시물 수가 날라와야하니까...?
		
		request.setAttribute("pageDto", pageDto);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/board/list.jsp");
		dispatcher.forward(request, response);
	}

}
