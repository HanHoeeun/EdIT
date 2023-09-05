<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>findpw.jsp</title>
<link href= "./css/login.css" rel= "stylesheet" type="text/css">
<link href= "./css/style.css" rel= "stylesheet" type="text/css">
</head>
<body>
<!--
author: W3layouts
author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>   
<html>
<head>
<title>findpw.jsp</title>
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Super Market Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //for-mobile-apps -->
<link href="../css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<link href="../css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- font-awesome icons -->
<link href="../css/font-awesome.css" rel="stylesheet"> 
<!-- //font-awesome icons -->
<!-- js -->
<script src="js/jquery-1.11.1.min.js"></script>
<!-- //js -->
<link href='//fonts.googleapis.com/css?family=Raleway:400,100,100italic,200,200italic,300,400italic,500,500italic,600,600italic,700,700italic,800,800italic,900,900italic' rel='stylesheet' type='text/css'>
<link href='//fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic' rel='stylesheet' type='text/css'>
<!-- start-smoth-scrolling -->
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event){		
			event.preventDefault();
			$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
		});
	});
</script>
<!-- start-smoth-scrolling -->
</head>
	
<body>
<!-- header -->
		<jsp:include page="/inc/top.jsp"></jsp:include>
<!-- header -->

<!-- breadcrumbs -->
	<div class="breadcrumbs">
		<div class="container">
			<ol class="breadcrumb breadcrumb1 animated wow slideInLeft" data-wow-delay=".5s">
				<li><a href="index.html"><span class="glyphicon glyphicon-home" aria-hidden="true"></span>홈</a></li>
				<li class="active">비밀번호찾기</li>
			</ol>
		</div>
	</div>
<!-- //breadcrumbs -->


<!-- ================================ 비밀번호찾기 ================================ -->
	<div class="login">
		<div class="container">
		<div style="text-align : center;">
     		<img src="./images/find_5_1.png"><br><br><br>
		</div>
			<h2>비밀번호찾기</h2><br><br>
				<p>회원가입 시 등록하신 아이디, 이메일 주소를 입력해 주세요.</p>
				<p>해당 이메일로 OTP(일회용 비밀번호)를 보내드립니다.</p>
		
			<div class="login-form-grids animated wow slideInUp" data-wow-delay=".5s">
			
<!-- 				<form action = "findpwPro.me"  method = "post">					 -->
				<form action = "forgotPassword.fo"  method = "post">

					<input type="text"  placeholder ="아이디"  required=" "  id = "m_id" name = "m_id" >
					<input type="email"  placeholder ="이메일"  required=" "  id = "m_email" name = "m_email" >
					
					<div class="_5center">
						<input type="submit"  value="새 비밀번호 받기"  class="#">	
						<input type="submit"  value="취소"  onclick="location.href='login.me'" class="#">	
					<hr style="width:100%;height:1px;border:none;background-color:#999;">
					</div>
					
					
<!-- 홈/아이디 찾기/회원가입 -->					
					<div class="_5forgot">
						<a href="main.me">홈</a>
						|   
						<a href="findid.me">아이디 찾기</a>
						|   
						<a href="insert.me">회원가입</a>
					</div>	
<!-- // 홈/아이디 찾기/회원가입 -->	
							
				</form>
			</div>
		</div>
	</div>
<!-- ================================ // 비밀번호찾기 ================================ -->

<!-- 푸터 들어가는 곳! -->
<div class="clearfix">
<jsp:include page="../inc/bottom.jsp"></jsp:include>
</div>
<!-- // 푸터 들어가는 곳! -->

</body>
</html>
</body>
</html>