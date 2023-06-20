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
import com.hi1237.model.PasswordDto;
import com.hi1237.utils.ScriptWriter;

@WebServlet("/member/modifyPasswordProcess")
public class PasswordModifyProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PasswordModifyProcessController() {
        super();
      
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userPw=request.getParameter("userPw");
		String newUserPw= request.getParameter("newUserPw");
		String userId= request.getParameter("userId");
		
		PasswordDto passwordDto= new PasswordDto();
		passwordDto.setUserId(userId);
		passwordDto.setUserPw(userPw);
		passwordDto.setNewUserPw(newUserPw);
		
		System.out.println(passwordDto);
		
		MemberDao memberDao=new MemberDao();
		int result=memberDao.modifyPassword(passwordDto);
		if(result>0) {
			HttpSession session = request.getSession();
			session.invalidate();
			ScriptWriter.alertAndNext(response, "새 비밀번호를 사용해 다시 로그인해주세요", "../member/login");
		}else {
			ScriptWriter.alertAndBack(response, "오류가 생겼네여 정신차리세여");
			
		}
	}

}
