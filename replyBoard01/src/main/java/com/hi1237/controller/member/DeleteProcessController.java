package com.hi1237.controller.member;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hi1237.model.MemberDao;
import com.hi1237.model.MemberDto;
import com.hi1237.utils.ScriptWriter;

@WebServlet("/member/deleteProcess")
public class DeleteProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteProcessController() {
        super();
       
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId=request.getParameter("userId");
		String userPw=request.getParameter("userPw");
		
		MemberDto memberDto = new MemberDto();
		memberDto.setId(userId);
		memberDto.setPassword(userPw);
		
		MemberDao memberDao=new MemberDao();
		int result = memberDao.deleteMember(memberDto);
		
		if(result>0) {
			HttpSession session = request.getSession();
			session.invalidate();
			ScriptWriter.alertAndNext(response, "계정이 삭제되었습니다.", "../index/index");
		}else {
			ScriptWriter.alertAndBack(response, "오류가 났어여 정신차리세여");
		}
		
	}

}
