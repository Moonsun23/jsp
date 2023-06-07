<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!-- 전역변수 쓰기 -->
    <%
    String name="장문선";
    String msg="hello";
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- // html 파일 안에 java code 쓰기 = jsp...!  ctrl+shift+/ -->
	<h1>hello jsp</h1>
	<h2><%out.println(name); %></h2>
	<h2><%=name %></h2> <!-- 위처럼 print문을 써주는 대신 "=name" 으로 써줘도 결과가 나온다.. -->
	<% /* 자바코드 쓰는 곳 */
	out.println("hello jsp");
	out.println(name+msg);
	for(int i=0; i<100; i++){
		out.println("hello jsp <br>");
	}
	
	%>
</body>
</html>