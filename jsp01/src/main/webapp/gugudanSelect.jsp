<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="gugudanResult.jsp">
				<select name="dan">
	<%
		for(int i=1; i<10; i++){
			out.println("<option value='"+i+"'>"+i+"</option>");
			
		}
	%>
				<!-- <option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				<option value="6">6</option>
				<option value="7">7</option>
				<option value="8">8</option>
				<option value="9">9</option> -->
				</select>
				<button>구구단 출력 부탁.</button>
				</form>
</body>
</html>