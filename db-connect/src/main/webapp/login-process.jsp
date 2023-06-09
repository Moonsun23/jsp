<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% 
	String pUserId=request.getParameter("userId");
	String pUserPw=request.getParameter("userPw");
	// jsp는 respond와 request같은 내장객체를 이미 가지고 있어서 선언을 따로 안해도 된다.

	String driver = "oracle.jdbc.OracleDriver";
	String url= "jdbc:oracle:thin:@localhost:1521:xe";
	String id="hi1237";
	String pw= "1234";
	// db로 넘기는 과정..
	
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	String sql="select * from register where id = ? and password= ?";
	
	Class.forName(driver);
	conn=DriverManager.getConnection(url, id, pw);
	pstmt=conn.prepareStatement(sql);
	
	pstmt.setString(1, pUserId);
	pstmt.setString(2, pUserPw);
	rs= pstmt.executeQuery();
	
	// response.setContentType("text/html;charset=utf-8");
	// 위 행을 써줘야 콘솔창에 한글이 뜸
	
	
	// 4개의 scope 가 있음
	// pageContext <request <session <application => 유효범위의 순서...
	// pageContext 한페이지 내에서 처리..
	// request로 속성처리..
	// session-> 내가 없애기 전까지 유효한 서버...(값을 넘길 수 있다..)
	// application -> 계속 같이 가는 ...서버?
			
			// 주로 request랑 session을 주로 쓴다..
	
	
	if(rs.next()){
		String userId= rs.getString("id");
		String userPw= rs.getString("password");
		String userName=rs.getString("name");
		
		// pageContext.setAttribute("pageUserId", userId);
		// 주소창에 안실리고 내부적으로.. 
		//request.setAttribute("userId", userId);
		// userId는 userId 값을 받아서..
		session.setAttribute("loggedUserId", userId);
		// 직접 주소창을 바꾸는거!// 특정 페이지로 넘기는 것.
		// 로그인 상태로 유지시켜줌/./.!
		session.setAttribute("loggedUserName", userName);
		
		
		//request.getRequestDispatcher("login-ok.jsp").forward(request, response);
		// 반드시 forward를 시켜야 값이 넘어간다...
		// forward- 서버가 페이지를 바꿀 수 있다면..
		
		
		
		// response.sendRedirect("login-ok.jsp?userId="+userId);
		//페이지 자체를 바꾸는...sendRedirect		
		
		System.out.println(request.getParameter(userId));
		RequestDispatcher dispatcher = request.getRequestDispatcher("login-ok.jsp");
		// login-ok 파일에 있는 내용을 그대로 가져와서 쓰는 것.
		dispatcher.forward(request, response); //위에 forward 있는 부분과 동일한 내용...
		
		
	//	out.println("로그인 성공");	
	
	}else{
		//out.println("로그인 실패");
	}
	
%>