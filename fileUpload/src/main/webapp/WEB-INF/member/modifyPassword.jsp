<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file = "../include/header.jsp" %>

<form action="../member/modifyPasswordProcess" method="post" class="join" name="pwForm">

<input type="hidden" name="userId" value="${loggedMember.id }" />
<!-- hidden을 쓰면 눈에 보이지는 않지만 name과 값은 넘길 수 있다.  -->

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
<script type="text/javascript">


const btnSubmit = document.querySelector("#btnSubmit");
  btnSubmit.addEventListener("click", (e) => {
    if (pwForm.elements.userPw.value.trim() === "") {
      // userPw.value에 공백이 없다면..
      e.preventDefault(); // 기본기능을 없애주는 코드
      alert("비밀번호를 입력해주세요");
      pwForm.elements.userPw.focus();
    } else if (pwForm.elements.newUserPw.value.trim() === "") {
      // userPw.value에 공백이 없다면..
      e.preventDefault(); // 기본기능을 없애주는 코드
      alert("새 비밀번호를 입력해주세용");
      pwForm.elements.userPw.focus();
    } else if (pwForm.elements.userPw.value === pwForm.elements.newUserPw.value) {
      e.preventDefault();
      alert("기본 비밀번호는 사용 할 수 없습니다.");
      pwForm.elements.userPw.focus();
    } else if (pwForm.elements.newUserPw.value !== pwForm.elements.newUser02.value) {
      e.preventDefault(); // 기본기능을 없애주는 코드
      alert("비밀번호가 같지 않습니다.");
      pwForm.elements.userPw.focus();
    }
  });
  </script>

<%@include file = "../include/footer.jsp" %>