<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String pUserId=request.getParameter("userId");
    String pUserPw=request.getParameter("userPw");
    
    String driver = "oracle.jdbc.OracleDriver";
    String url="jdbc:oracle:thin:@localhost:1521:xe";
    String id="hi1237";
    String pw="1234";
    // 여기까지는 기본 중 기본..
    
    
    Connection conn=null;    
    PreparedStatement pstmt=null;
    // 위가 query(결과값)를 날려주는것..?
    		
    ResultSet rs=null;
    String sql= "select * from member where id= ? and password= ?"; // sql이 바뀌는 것..
    // 띄어쓰기 잘해줘야 함..!!!!!!!!!!!!!!!!!!!!!!!!
    // 여기까지가 기본으로 다 써줘야 하는것...?
    
    
    Class.forName(driver);
    // driver 안에 있는 class를 찾고.. 그 다음에
    conn = DriverManager.getConnection(url,id,pw);
    // driver manager를 통해 connection을 찾고..
    pstmt=conn.prepareStatement(sql);
    // sql을 날려주는 것.
    
    pstmt.setString(1, pUserId);
    // 나는 String 하나를 set 해줄건데..
    // 1번째에는 userID를...
    pstmt.setString(2, pUserPw);
    // parameter로 끌고온 애들...
    
    rs=pstmt.executeQuery();
    
    while(rs.next()){
    	String userId= rs.getString("id");
    	String userName= rs.getString("name");
    	String userPw= rs.getString("password");
    	System.out.println(userId+"==="+userName+"==="+userPw);
    }
    
    	// .next()--> 다음에 있으면 true..
    	
   // System.out.println(conn);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>