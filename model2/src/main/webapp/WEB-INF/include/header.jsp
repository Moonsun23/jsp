<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- 자바코드를 마치 태그처럼 사용하기 위해 jstl을 쓴다. 아래줄 lib는 library// prefix 접두어로 무엇을 쓸건지? 보통 c를 쓴다.. -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <link rel="stylesheet" href="../css/bootstrap.min.css" />
    <script src="../js/bootstrap.bundle.min.js"></script>
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
  </head>
  <body>
    <div class="container">
        <header class="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom">
          <a href="/" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-body-emphasis text-decoration-none">
            hi1237
          </a> 
          
          
          <!--원래 여기에 java코드 <%%> 안에 if문을 썼었음..  를 썼었음.. model2로 쓰면서 if문을 지움  -->
            <ul class="nav nav-pills">
            
            <c:choose>
            	<c:when test="${loggedMember eq null }"> <!-- 다르다 를 쓸때는 ne  -->
            		<li class="nav-item"><a href="../member/login" class="nav-link">login</a></li>
            		<li class="nav-item"><a href="../member/join" class="nav-link">join</a></li>
            	</c:when>
            	<c:otherwise>
            		<li class="nav-item"><a href="../member/logout" class="nav-link">logout</a></li>
                    <li class="nav-item"><a href="../member/info?userId=hi1237" class="nav-link">${loggedMember.name }</a></li>
            	</c:otherwise>
            </c:choose>
            
           <%--  <c:set var= "name" value="장문선" />  <!-- <<= 선언을 해줌// 닫는 태그가 없을 때는 끝에 슬래쉬를 써줌  -->
            <%-- <c:if test="${loggedMember == null }">	 아래 empty를 넣어서 쓸 수 있음--%><!-- if문 안에 ==을 못쓰고 eq를 대신 씀  -->
             <%-- <c:if test="${empty loggedMember}">	 --%>
             <%--
            <!-- c:if는 else 가 없다.. -->
            <li class="nav-item"><a href="login-form.jsp" class="nav-link">login</a></li>
            <li class="nav-item"><a href="join-form.jsp" class="nav-link">join</a></li>
            </c:if>           
            <c:if test="${not empty loggedMember}">
            <li class="nav-item"><a href="logout.jsp" class="nav-link">logout</a></li>
            <li class="nav-item"><a href="info.jsp" class="nav-link">${loggedMemberName }</a></li>
            </c:if> --%> 
            
          </ul>
        </header>
      </div>
      
      
      
      
      
      
      
      
      
