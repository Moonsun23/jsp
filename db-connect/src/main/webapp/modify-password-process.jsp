<!-- prettier-ignore -->
<%@page import="com.hi1237.utils.ScriptWriter"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- prettier-ignore -->
<%
	request.setCharacterEncoding("utf-8");
	
	String pLoggedUserId=(String)session.getAttribute("loggedUserId");
	String pUserPw = request.getParameter("userPw");
	String pNewPw=request.getParameter("newUserPw");
	
	String driver="oracle.jdbc.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String id="hi1237";
	String pw="1234";
	// string id, pw는 db의 사용자 이름을쓰는 것! 다른것과 오해 XX
	
	Connection conn=null;
	PreparedStatement pstmt=null;
	// result에는 set만 써주는거라 지움..

	String sql="update register set password = ? where id = ? and password = ?";
	// jsp에 가져오는건 자동으로 커밋되는 것으로 디폴트 되어있음.
	// 위 물음표는 아래 pstmt.setString~ 개수와 연관있음
	
	Class.forName(driver);
	// 아래.. driver connection을 통해 jsp와 db를 연결시켜 줘야 한다!!! jsp와 db는 직접 연결이 안된다.
	conn= DriverManager.getConnection(url, id, pw);
	pstmt=conn.prepareStatement(sql);
	pstmt.setString(1, pNewPw);
	pstmt.setString(2, pLoggedUserId);
	pstmt.setString(3, pUserPw);
	
	
	int result=pstmt.executeUpdate();
	//위 괄호에는 table 의 row에 영향을 끼치는 숫자를 써준다
	// select를 제외한 나머지 update, delete, insert
	if(result > 0){
		session.invalidate();		// session을 끊어야 함.. 
		//ScriptWriter.alertAndNext(response, "비밀번호가 변경되었습니다. 다시 로그인 ㄱㄱ", "login-form.jsp");
		
		out.println("<script>alert('비밀번호가 변경되었습니다. 다시 로그인해주세요.'); location.href='login-form.jsp';</script>"); 
	} else{
		//ScriptWriter.alertAndBack(response, "비밀번호가 맞지않습니다.");
		out.println("<script>alert('비밀번호가 맞지 않습니다.'); history.back(); </script>");
	}
	
	//아래는 query를 실행 // rs=pstmt.executeQuery(); // 하나만 찾을거면 if, 여러개 찾을거면 while /* if(rs.next()){ } */ %>
<!-- prettier-ignore -->
