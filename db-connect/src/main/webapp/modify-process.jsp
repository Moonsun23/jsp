<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String pUserId=request.getParameter("userId");
	String pUserPw=request.getParameter("userPw");
	String pUserName=request.getParameter("userName");
	String pUserEmail=request.getParameter("userEmail");
	int pZonecode=Integer.parseInt(request.getParameter("zonecode"));
	String pUserAddress=request.getParameter("userAddress");
	String pDetailAddress=request.getParameter("detailAddress");
	String pExtraAddress=request.getParameter("extraAddress");
	
	
	String driver="oracle.jdbc.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String id="hi1237";
	String pw="1234";
	// string id, pw는 db의 사용자 이름을쓰는 것! 다른것과 오해 XX
	
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;

	String sql="update register set name = ?, email = ?, zonecode = ?, address = ?, detailAddress = ?, extraAddress = ? where id = ? and password = ?";
	// jsp에 가져오는건 자동으로 커밋되는 것으로 디폴트 되어있음.
	// 위 물음표는 아래 pstmt.setString~ 개수와 연관있음
	
	Class.forName(driver);
	// 아래.. driver connection을 통해 jsp와 db를 연결시켜 줘야 한다!!! jsp와 db는 직접 연결이 안된다.
	conn= DriverManager.getConnection(url, id, pw);
	pstmt=conn.prepareStatement(sql);
	pstmt.setString(1, pUserName);
	pstmt.setString(2, pUserEmail);
	pstmt.setInt(3, pZonecode); // db의 member 테이블의 열 순서대로 써줘야 한다..
	pstmt.setString(4, pUserAddress);
	pstmt.setString(5, pDetailAddress);
	pstmt.setString(6, pExtraAddress);
	pstmt.setString(7, pUserId);
	pstmt.setString(8, pUserPw);
	
	int result=pstmt.executeUpdate();
	//위 괄호에는 table 의 row에 영향을 끼치는 숫자를 써준다
	// select를 제외한 나머지 update, delete, insert
	if(result > 0){
		response.sendRedirect("login-form.jsp");
	}else{
		out.println("<script>alert('경고경고경고 경고경고경고고고고고고고고고 서 버 오 류류류류류 다시 시도해!'); history.back();</script>");
		
	}
	
	
	//아래는 query를 실행
	// rs=pstmt.executeQuery();
	
	
	// 하나만 찾을거면 if, 여러개 찾을거면 while
	/* if(rs.next()){
		
	} */
	
%>