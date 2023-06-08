<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@include file = "include/header.jsp" %>

<form action="modify-password-process.jsp" method="post" class="join" name="pwForm">
  <div class="container-sm">
    <div class="row justify-content-center mt-5">
      <!-- bootstrap의 grid는 12개로 나눠서 쓴다.. 12등분으로 쓰고.. 12로 나눠서 떨어지는 수를 쓰면 좋다.-->
      <div class="col-6">
        <div class="mb-3">
          <label for="floatingPassword">기존 비밀번호</label>
          <input type="password" name="userPw" class="form-control" id="floatingPassword01" placeholder="비밀번호를 입력해주세요." />
        </div>
        <div class="mb-3">
          <label for="floatingPassword">새 비밀번호</label>
          <input type="password" name="newUserPw" class="form-control" id="floatingPassword02" placeholder="새 비밀번호를 입력해주세요." />
        </div>
        <div class="mb-3">
          <label for="floatingPassword">새 비번 확인</label>
          <input type="password" name="newUserPw02" class="form-control" id="floatingPassword03" placeholder="비밀번호 확인" />
        </div>

        <div class="text-center">
          <button type="submit" id="btnSubmit" class="btn btn-primary btn-lg">비번 수정하기</button>
        </div>
      </div>
    </div>
  </div>
</form>
<script>


   const pwForm = document.forms.pwForm;
   // body 밑의 form을 모두 찾아라!
  console.log(joinForm);

   btnSubmit.addEventListener("click", (e) => {
     	//console.log(joinForm.elements.newUserPw.value);
    if(joinForm.elements.userPw.value.trim() === ""){
    		if (joinForm.elements.newUserPw.value.trim() === "") {
  	      e.preventDefault();
  	      alert("비번을 입력하세요.");
  	      joinForm.elements.newUserPw.value="";
  	      joinForm.elements.newUserPw.focus();
  	    } else if (joinForm.elements.newUserPw.value !== joinForm.elements.newUserPw02.value){
  	        e.preventDefault();
  	        alert("비밀번호를 재확인하세요.");
  	        joinForm.elements.newUserPw02.value="";
  	        joinForm.elements.newUserPw02.focus();
  	    }
    }
     	  });
</script>

<%@include file = "include/footer.jsp" %>
