<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");
	String pUserId=request.getParameter("userId");
	String pUserPw=request.getParameter("userPw");
	
	String driver="oracle.jdbc.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String id="hi1237";
	String pw="1234";
			
	Connection conn=null;
	PreparedStatement pstmt=null;
	
	
	String sql="delete from register where id = ? and password = ?";
	
	Class.forName(driver);
	conn=DriverManager.getConnection(url, id, pw);
	pstmt=conn.prepareStatement(sql);
	
	pstmt.setString(1, pUserId);
	pstmt.setString(2, pUserPw);
	int result=pstmt.executeUpdate();
	
	if(result>0){
		//join-process.jsp 파일 참조		
		response.sendRedirect("login-form.jsp");
	}else{
		out.println("<script>alert('경고경고경고 경고경고경고고고고고고고고고 서 버 오 류류류류류 다시 시도해!'); history.back();</script>");
		
	}

%>