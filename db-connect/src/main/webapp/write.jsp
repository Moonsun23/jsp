<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file= "include/header.jsp" %>
	<form action="write-process.jsp" method="post" class="join" name="joinForm">
	  
	  <div class="container-sm">
	    <div class="row justify-content-center mt-5">
	      <!-- bootstrap의 grid는 12개로 나눠서 쓴다.. 12등분으로 쓰고.. 12로 나눠서 떨어지는 수를 쓰면 좋다.-->
	      <div class="col-6">
	        
	        <div class="mb-3">
	        <label for="floatingName">Name</label>
	          <input type="text" name="userName" class="form-control" id="floatingName" placeholder="이름을 입력해주세요." />
	          
	        </div>
	        <div class="mb-3">
	        <label for="floatingMail">Title</label>
	          <input type="text" name="title" class="form-control" id="floatingTitle" placeholder="제목을 입력해주세요." />
	          
	        </div>
	       	<div class="mb-3">
			  <label for="exampleFormControlTextarea1" class="form-label">Content</label>
			  <textarea class="form-control" name="contents" id="exampleFormControlTextarea1" rows="10"></textarea>
			</div>
	
	        <div class="text-center">
	          <button type="submit" id="btnSubmit" class="btn btn-primary btn-lg">Confirm</button>
	          <button type="reset" class="btn btn-secondary btn-lg">Confirm</button>
	        </div>
	      </div>
	    </div>
	  </div>
	</form>




<%@ include file= "include/footer.jsp" %>