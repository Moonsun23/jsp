<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	int dan=Integer.parseInt(request.getParameter("dan"));
    	
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1><% out.println(dan); %>단을 출력합니다.</h1>
	<%
		for(int i=1; i<10; i++){
			out.println("<p>"+dan+"x"+i+"="+dan*i+"</p>");
		}
	/* 문장 안에서 쓰려면 out.println을 써야한다.. html 태그를 쓰려면 꼭 꺽쇠<>로 감싸줘야 한다. */
	%>
</body>
</html>