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
			  
			   	<c:forEach items = "${boardList}" var="boardDto" varStatus="status">		<!-- ListController의 key값을 가져온다// var 값의 이름은 아무렇게나 가능 -->
			    <tr>
			      <th>${pageDto.total - pageDto.pagePerList * (clickPage - 1) - status.index}</th> <!--index를 쓰면 0부터 시작../count 쓰면 1부터  -->
			      <td>
			      		<c:choose>
			      			<c:when test="${boardDto.available eq 1}">
			      			<a href="../board/view?id=${boardDto.id }&clickPage=${clickPage}" class="step step${boardDto.restep }">${boardDto.title}</a>
			      			</c:when>
			      			<c:otherwise>
			      			<a href="" class="step step${boardDto.restep } notAvailable">삭제 된 글 입니다.</a>
			      			</c:otherwise>
			      		
			      		</c:choose>
			      </td>
			      <td>${boardDto.name }</td>
			      <td>${boardDto.regDate }</td>
			      <td>${boardDto.hit }</td>
			    </tr>
			    </c:forEach>
			  </tbody>
			  <!-- param = web 에 있는 값을 바로 가지고 올 수 있음. 그래서 clickPage가 몇이 뜨는지에 따라 그 데이터를 가지고 올 수 있음 -->
		</table>
		<nav aria-label="Page navigation example">
			  <ul class="pagination justify-content-center">
			 
			    <c:if test="${pageDto.pageStart ne 1 }">						<!-- 페이지 처음과 끝이 더 없으면 넘어가는 버튼 없애주려고 쓰는 코드 // ne=not equal -->
				    <li class="page-item">
				      <a class="page-link" href="../board/list?clickPage=${pageDto.pageStart-pageDto.pageBlock + (pageDto.pageBlock-1)}" aria-label="Previous">
				        <span aria-hidden="true">&laquo;</span>
				      </a>
				    </li>					<!-- 게시글에 따라  -->
			    </c:if>
			    <c:forEach begin="${pageDto.pageStart }" end= "${pageDto.pageEnd }" step="1" var="page" varStatus="status">		<!-- for문의 조건을 대신 써줌.. begin~ end // 원래는 for(int i=1; i<=pageTotal; i++) -->
			       <li class="page-item ${page == clickPage?'active':''}">
			       <a class="page-link" href="../board/list?clickPage=${page}">${page}</a>
			       </li>
			    </c:forEach>
			    				<!-- ${page == 1?'active':''} 부분은 게시글 페이지번호에 불 들어오게 해주는 조건문  -->
			    <c:if test="${pageDto.pageEnd ne pageDto.pageTotal}">
				    <li class="page-item">
				      <a class="page-link" 
				      href="../board/list?clickPage=${pageDto.pageStart+pageDto.pageBlock }" aria-label="Next">
				        <span aria-hidden="true">&raquo;</span>
					  </a>
					</li>
				</c:if>
			
		     </ul>
		 </nav>
		<div class="mt-5">
			<a href="../board/write" class="btn btn-primary">Write </a>
		<!-- 	<a href="" class="btn btn-danger">Delete</a> -->
		</div>
	</div>

<%@ include file = "../include/footer.jsp" %>