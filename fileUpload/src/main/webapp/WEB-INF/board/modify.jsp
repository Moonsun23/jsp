<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../include/header.jsp" %>
	<div class="container-sm mt-5">
		<form action= "../board/modifyProcess" method="post">
			<input type="hidden" name="id" value="${boardDto.id }">
			<div class="mb-3">
			  <label for="title" class="form-label">제목</label>
			  <input type="text" class="form-control" name="title" value="${boardDto.title }" id="title" placeholder="제목을 입력하세요">
			</div>
			<div class="mb-3">
			  <label for="userName" class="form-label">작성자</label>
			  <input type="text" class="form-control" name="name" value="${boardDto.name }" id="userName" placeholder="이름을 입력하세요">
			</div>
			<div class="mb-3">
			  <label for="contents" class="form-label">내용</label>
			  <textarea class="form-control" id="contents" name="contents" rows="10">${boardDto.contents }</textarea>
			</div>
			<div class="text-center">
	          <button type="submit" id="btnSubmit" class="btn btn-primary btn-lg">수정하기</button>
	          <button type="reset" id="btnCancel" class="btn btn-secondary btn-lg">작성 취소</button>
	          
	          <a href="../board/list" class="btn btn-primary btn-lg">목록</a>
	        </div>
		</form>
		<script>
		      $("#contents").summernote({
		       // placeholder: 'Hello Bootstrap 5',
		        tabsize: 2,
		        height: 100
		      });
         </script>
	</div>

<%@ include file = "../include/footer.jsp" %>