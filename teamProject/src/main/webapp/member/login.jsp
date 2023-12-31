<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login.jsp</title>
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
<title>login.jsp</title>
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

<!-- ==================================== 카카오로 로그인하기 ============================ -->

<!-- // 카카오 테스트1 -->

<!-- <script src="https://developers.kakao.com/sdk/js/kakao.js"></script> -->
<!-- <script> -->
<!-- // 내 고유 토큰키-> API 키를 넣으니깐 오류 뜸. -->
<!-- // 오류가 난다... -> 카카오 로그인 버튼 누르면 처음에는 잘 되다가 다음번에는 그냥 꺼짐... -->
<!-- Kakao.init('abe7984fd16d1fc768372dce3dec7c60'); // 발급받은 키 중 자바스크립트 키 사용 -->
<!-- console.log(Kakao.isInitialized()); // sdk초기화 여부 판단 -->
<!-- //카카오로그인 -->
<!-- function kakaoLogin() { -->
<!--     Kakao.Auth.login({ -->
<!--       success: function (response) { -->
<!--         Kakao.API.request({ -->
<!--           url: '/v2/user/me', -->
<!--           success: function (response) { -->
<!--         	  	     console.log(response) -->
<!--           } , -->
<!--           fail: function (errer){ -->
<!--         	  console.log(error) -->
<!--           } , -->
<!--         }) -->
<!--       }, -->
<!--       fail: function (error) { -->
<!--           console.log(error) -->
<!--         }, -->
<!--       }) -->
<!--     } -->
<!-- //카카오로그아웃   -->
<!-- function kakaoLogout() { -->
<!--     if (Kakao.Auth.getAccessToken()) { -->
<!--       Kakao.API.request({ -->
<!--         url: '/v1/user/unlink', -->
<!--         success: function (response) { -->
<!--         	console.log(response) -->
<!--         }, -->
<!--         fail: function (error) { -->
<!--           console.log(error) -->
<!--         }, -->
<!--       }) -->
<!--       Kakao.Auth.setAccessToken(undefined) -->
<!--     } -->
<!--   }   -->
<!-- </script> -->

<!-- // 카카오 테스트1 -->

<!-- ====================================  // 카카오로 로그인하기 ============================ -->

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
				<li class="active">로그인</li>
			</ol>
		</div>
	</div>
<!-- //breadcrumbs -->



<!-- ================================ 로그인 화면 ================================ -->
	<div class="login">
		<div class="container">
			<h2>로그인</h2><br>
			<p>아이디와 비밀번호를 입력해 주세요.</p>

			<div class="login-form-grids animated wow slideInUp" data-wow-delay=".5s">
				<form action="loginPro.me" method="post">
					<input type="text" placeholder="아이디" required=" " id="m_id" name="m_id">
					<input type="password" placeholder="비밀번호" required=" " id="m_pass" name="m_pass">
					<input type="submit" value="로그인"><br>
				</form>
				
				
				
				
<!-- 아이디/비밀번호 찾기/회원가입 -->					
					<div class="_5forgot">
						<a href="findid.me">아이디 찾기</a>
						|
						<a href="findpw.me">비밀번호 찾기</a>
						|
						<a href="insert.me">회원가입</a>
					</div>	
<!-- // 아이디/비밀번호 찾기/회원가입 -->		


				
<!-- or 표시 -->				
<!-- 					<div class="_5or-login-with"> -->
<!--   						<div class="_5don-t-have-account"> -->
<!--     					<div class="_5line-20"></div> -->
<!--     					<div class="_5label"> -->
<!--       					<div class="_5or">or</div> -->
<!--     				</div> -->
<!--   					</div> -->
<!-- 					</div> -->
					
<!--  or 표시			 -->

<!-- <div class="_5login-kakao">	 -->


<!-- 카카오 로그인 버튼 -->
<!-- 	<div class="_5login-kakao"> -->
<!-- 	<a href="javascript:void(0)"> -->
<!--       <img onclick="kakaoLogin();" src="//k.kakaocdn.net/14/dn/btqbjxsO6vP/KPiGpdnsubSq3a0PHEGUK1/o.jpg"   -->
<!--       width="90%;" height="50%;"  style="margin-top: -60px; padding-inline: 50px;"> -->
<!--       </a> -->
<!-- </div>			 -->


</div>
<!-- </form>		 -->
</div>
</div>
		
<script>
    // 로그인 성공 시 m_num 값을 JavaScript 변수에 설정
    int loggedInMNum = <%= session.getAttribute("m_num") %>;
</script>
	
		
<!-- sns로그인 -->
<!-- 					<div class="_5login-naver"> -->
<!-- 						<a href="#"><img class="_5naver" src="../images/naver_5.png">네이버로 로그인하기</a> -->
<!-- 					</div> -->
		
<!-- 					<div class="_5login-kakao">	 -->
<!-- 						<a href="#"><img class="_5kakao" src="../images/kakao_5.png">카카오로 로그인하기</a> -->
<!-- 					</div>				 -->
<!-- 				</form> -->
<!-- 			</div> -->
			
	

<!-- 			이거는 넣을지 말지 고민 좀... -->
<!-- 			<p><a href="registered.jsp">회원가입</a> <a href="index.jsp">홈<span class="glyphicon glyphicon-menu-right" aria-hidden="true"></span></a></p> -->
	
<!-- ================================ // 로그인 화면 ================================ -->

<!-- 푸터 들어가는 곳! -->
<div class="clearfix">
<jsp:include page="../inc/bottom.jsp"></jsp:include>
</div>
<!-- // 푸터 들어가는 곳! -->

</body>
</html>
</body>
</html>