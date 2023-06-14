<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../include/header.jsp" %>
	

<div class="container-sm mt-5">
  <table class="table">
    
    <tbody>
      <tr>
        <th scope="row">ID</th>
        <td>${infoMemberDto.id }</td>
      </tr>
      <tr>
        <th scope="row">Name</th>
        <td>${infoMemberDto.name }</td>
      </tr>
      <tr>
        <th scope="row">Email</th>
        <td>${infoMemberDto.email }</td>
      </tr>
      <tr>
        <th scope="row">주소</th>
        <td>${infoMemberDto.address }</td>
      </tr>
      <tr>
        <th scope="row">우편번호</th>
        <td>${infoMemberDto.zonecode }</td>
      </tr>
      <tr>
        <th scope="row">상세주소</th>
        <td>${infoMemberDto.detailAddress }</td>
      </tr>
      <tr>
        <th scope="row">기타</th>
        <td>${infoMemberDto.extraAddress }</td>
      </tr>
     
    </tbody>
  </table>
  <div class="mt-5">
    <a href="../member/modify?userId=${infoMemberDto.id}" class="btn btn-info">회원정보수정</a>			<!-- rest API  -->
     <a href="../member/modifyPassword" class="btn btn-info">비밀번호 변경</a>
    <a href="../member/delete" class="btn btn-danger">회원탈퇴</a>
  </div>
</div>

<%@ include file = "../include/footer.jsp" %>
