<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member/login.jsp</title>
<link href= "../css/top.css" rel= "stylesheet" type="text/css">
<link href= "../css/login.css" rel= "stylesheet" type="text/css">
<link href= "../css/bottom.css" rel="stylesheet" type="text/css">
</head>
<body>
<!-- 왜 안되냐고 -->
<div id="test1">
<!-- 헤더 들어가는 곳  -->
<jsp:include page="../top.jsp"></jsp:include>
<!-- 헤더 들어가는 곳  -->

<div class="frame-395">
  <div class="login">
    <div class="from">
      <div class="order-id">
        <div class="">아이디</div>
        <div class="input-field"></div>
      </div>
      <div class="order-id2"></div>
    </div>
    <div class="heading">
      <div class="test2">비밀번호</div>
    </div>
    <div class="input-field2"></div>
    <div class="search">아이디/비밀번호 찾기</div>
    <div class="button">
      <div class="label">로그인</div>
      <svg
        class="regular-arrow-right"
        width="21"
        height="20"
        viewBox="0 0 21 20"
        fill="none"
        xmlns="http://www.w3.org/2000/svg"
      >
        <path
          d="M3.62483 10H17.3748"
          stroke="white"
          stroke-width="2"
          stroke-linecap="round"
          stroke-linejoin="round"
        />
        <path
          d="M11.7498 4.375L17.3748 10L11.7498 15.625"
          stroke="white"
          stroke-width="2"
          stroke-linecap="round"
          stroke-linejoin="round"
        />
      </svg>
    </div>
    <div class="or-login-with">
      <div class="don-t-have-account">
        <div class="line-20"></div>
        <div class="label2">
          <div class="or">or</div>
        </div>
      </div>
    </div>
    <div class="tab">
      <div class="frame-533">
        <div class="tab2">
          <div class="login2">로그인하기</div>
        </div>
      </div>
    </div>
    <div class="login-register-with">
      <div class="login-with-kakao">네이버로 로그인하기</div>
      <img class="naver" src="../img/naver.png" >
    </div>
    <div class="login-register-with2">
      <div class="login-with-kakao">카카오로 로그인하기</div>
      <img class="kakao" src="../img/kakao.png" >
    </div>
  </div>
  </div>
 </div>
<hr>
<!-- 푸터 들어가는 곳! -->
<jsp:include page="../bottom.jsp"></jsp:include>
<!-- 푸터 들어가는 곳! -->
