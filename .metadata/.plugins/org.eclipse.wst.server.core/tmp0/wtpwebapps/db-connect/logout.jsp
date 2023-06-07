<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	session.invalidate();
	
	// 정보를 바꿀 필요없으니까
	response.sendRedirect("login-form.jsp");
%>