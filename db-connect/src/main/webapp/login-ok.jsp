<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file = "include/header.jsp" %>
<%-- <%
	String paramUserId= request.getParameter("userId");

	String pageUserId=(String)pageContext.getAttribute("pageUserId");
	String requestUserId= (String)request.getAttribute("userId");
	// attribute 는 object 객체라서 형변환을 해줘야 한다...
	String sessionUserId= (String)session.getAttribute("userId");
	// attribute를 통해 값이 날아간다...
%>
 --%>
<%-- <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- <p>로그인 성공공공</p> -->
	
	<p><%=paramUserId %>님 안녕하세요?</p>
	<p><%=requestUserId %>님 안녕하세요?</p>
	<p><%=pageUserId %>님 안녕하세요?</p>
	<p><%=sessionUserId %>님 안녕하세요?</p>
	
</body> --%>
<%@include file = "include/footer.jsp" %>