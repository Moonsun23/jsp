<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Cookie cookie01 =new Cookie("myCookie01", "짱구");
	cookie01.setPath(request.getContextPath());  // 맥락을 파악하라... dynamic web project 에서 이름 지을때..이름이 contextpath..
	cookie01.setMaxAge(60);		// 얼마뒤에 없애겠냐? - 괄호 안에 60을 쓰면 60초 후에 사라짐..
	response.addCookie(cookie01);
	
	Cookie cookie02 =new Cookie("myCookie02", "썬칩");
	cookie02.setPath(request.getContextPath());  // 맥락을 파악하라... dynamic web project 에서 이름 지을때..이름이 contextpath..
	cookie02.setMaxAge(60);		// 얼마뒤에 없애겠냐? - 괄호 안에 60을 쓰면 60초 후에 사라짐..
	
	response.addCookie(cookie02);
	
	
	System.out.println(request.getContextPath());
%>