<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
    <%
    String pUserId=request.getParameter("userId");
	
	String driver = "oracle.jdbc.OracleDriver";
	String url= "jdbc:oracle:thin:@localhost:1521:xe";
	String id="hi1237";
	String pw= "1234";
	// db로 넘기는 과정..
	
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	String sql="select count(*) as count from register where id = ?";
	// count ->조건에 맞는 것이 몇개인지 알려주는 함수..
	
	Class.forName(driver);
	conn=DriverManager.getConnection(url, id, pw);
	pstmt=conn.prepareStatement(sql);
	
	pstmt.setString(1, pUserId);
	// 위 sql에 ?(물음표)가 하나라서.. 
	rs= pstmt.executeQuery();
	
	int result=0;
	boolean isState= true;
	if(rs.next()){
		result=rs.getInt("count");
		// count에 
		if(result<=0){
			isState=true;
			// 내가 입력한 Id를 쓸 수 있으면 true(중복X)
		}else{
			isState=false;
			// 쓸 수 없으면 false(중복되는 것이니 쓸수 없다!)
		}
	}
	
	
	
    %>
{"isOk":<%=isState %>}

