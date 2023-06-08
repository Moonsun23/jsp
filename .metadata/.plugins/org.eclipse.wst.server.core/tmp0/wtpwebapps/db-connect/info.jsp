<!-- prettier-ignore -->
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@include file="include/header.jsp" %>

<!-- <p><%= session.getAttribute("loggedUserName") %></p> -->
<!-- prettier-ignore -->
<%
	String pLoggedUserId= (String)session.getAttribute("loggedUserId");

	String driver="oracle.jdbc.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String id="hi1237";
	String pw="1234";
	// string id, pw는 db의 사용자 이름을쓰는 것! 닫른것과 오해 XX
	
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;

	String sql= "select id, name, email, address, lpad(zonecode, 5, '0') as changeZonecode, detailAddress  from register where id = ?";
	// ? 를 써줘야 preparedstatement에서 정보를 가져온다?
			// zonecode의 앞자리 0을 유효하게 하기 위해 앞에 별명을 써준다.. lpad(zonecode, 5, '0') as를 추가....거꾸로는 rpad.. 오른쪽 빈곳을 0으로 채움!
			// zonecode는 무조건 5자리로 하는데, 만약 5자리가 안된다면 0으로 채워넣어라..
			
	Class.forName(driver);
	conn=DriverManager.getConnection(url, id, pw);
	pstmt=conn.prepareStatement(sql);
	pstmt.setString(1, pLoggedUserId);
	rs=pstmt.executeQuery();
	String address=null;
	String detailAddress=null;
	String zonecode=null;
	String name=null;
	String email=null;
	
	
	if(rs.next()){
		address=rs.getString("address");
		zonecode=rs.getString("changeZonecode");
		detailAddress=rs.getString("detailAddress");
		name=rs.getString("name");
		email=rs.getString("email");
	}
	if(detailAddress==null) detailAddress="상세주소 없음";
	
%>
<div class="container-sm mt-5">
  <table class="table">
    <div></div>
    <tbody>
      <tr>
        <th scope="row">ID</th>
        <td><%=pLoggedUserId %></td>
      </tr>
      <tr>
        <th scope="row">Name</th>
        <td><%=name %></td>
      </tr>
      <tr>
        <th scope="row">Email</th>
        <td><%=email %></td>
      </tr>
      <tr>
        <th scope="row">주소</th>
        <td><%=address %>/<%=detailAddress %></td>
      </tr>
      <tr>
        <th scope="row">우편번호</th>
        <td><%=zonecode %></td>
      </tr>
    </tbody>
  </table>
  <div class="mt-5">
    <a href="modify.jsp" class="btn btn-info">회원정보수정</a>
     <a href="modify-password.jsp" class="btn btn-info">비밀번호 변경</a>
    <a href="delete.jsp" class="btn btn-danger">회원탈퇴</a>
  </div>
</div>
<%@include file="include/footer.jsp"%>
<!-- prettier-ignore -->
