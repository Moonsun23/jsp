<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="loginResult.jsp" method="post"> <!--@WebServlet의 /주소 부분을 따와야 한다.  -->
		<label><span>id</span><input type="text" name="userId"></label>
		<label><span>id</span><input type="password" name="userPw"></label>
		<button>로그인</button>
	</form>
</body>
</html>