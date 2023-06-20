<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@include file = "../include/header.jsp" %>
	 <form action="../member/deleteProcess" method="post">
	    <!--  // method는 get과 post가 있는데 비번이 있을땐 포스트!!!! get으로 하면 정보가 다 주소창에 뜸 -->
	    <div class="container-xl">
	      <div class="row mt-5 justify-content-center">
	        <div class="col-6">
	          <div class="form-floating mb-3">
	            <!-- mb -> margin bottom 3 -->
	            <input type="text" name="userId" class="form-control" id="floatingInput" placeholder="아이디를 입력해주세요."
	            value="${loggedMember.id }"/>
	            <label for="floatingInput">ID</label>
	          </div>
	          <div class="form-floating mb-3">
	            <input type="password" name="userPw" class="form-control" id="floatingPassword" placeholder="Password" />
	            <label for="floatingPassword">Password</label>
	          </div>
	          <div class="text-center">
	            <button type="submit" class="btn btn-primary btn-lg">회원탈퇴</button>
	          </div>
	        </div>
	      </div>
	    </div>
	  </form>
 <%@include file = "../include/footer.jsp" %>