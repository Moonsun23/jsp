<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file = "../include/header.jsp" %>
	<div class="container-sm mt-5">
		<table class="table">
			<colgroup>
				<col style="width:50px">
				<col >
				<col style="width:150px">
				<col style="width:250px">
				<col style="width:50px">
			</colgroup>
			  <thead>
			    <tr>
			      <th scope="col">No.</th>
			      <th scope="col">Title</th>
			      <th scope="col">Name</th>
			      <th scope="col">Date</th>
			      <th scope="col">Hit</th>
			    </tr>
			  </thead>
			  <tbody>
			  
			   	<c:forEach items = "${boardList}" var="boardDto">		<!-- ListController의 key값을 가져온다// var 값의 이름은 아무렇게나 가능 -->
			    <tr>
			      <th>${boardDto.id }</th>
			      <td><a href="../board/view?id=${boardDto.id }">${boardDto.title}</a></td>
			      <td>${boardDto.name }</td>
			      <td>${boardDto.regDate }</td>
			      <td>${boardDto.hit }</td>
			    </tr>
			    </c:forEach>
			  </tbody>
		</table>
	</div>

<%@ include file = "../include/footer.jsp" %>