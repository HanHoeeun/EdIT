<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EdIT join</title>
<link href= "../css/login.css" rel= "stylesheet" type="text/css">
<link href= "../css/style.css" rel= "stylesheet" type="text/css">
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
<title>register_3.jsp</title>
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
				<li class="active">회원가입</li>
			</ol>
		</div>
	</div>
<!-- //breadcrumbs -->

<!-----------------------------------------------------------회원가입 시작------------------------------------------------------------------ -->
		<div class="register">
		<div class="container">
			<h2>회원가입</h2>
			<div class="login-form-grids">
				<h5>회원정보등록</h5>
				
				<form action="insertPro.me" method="post" id="_6join">
					<input type="text" placeholder="아이디 (영문/숫자, 6~20자)" required=" " id="m_id" name="m_id">
					<input type="text" placeholder="비밀번호 (영문+숫자+특수문자, 8~20자)" required=" " id="m_pass1" name="m_pass1">
					<input type="text" placeholder="비밀번호 확인" required=" "  id="m_pass2" name="m_pass2"> <br>
					<input type="text" placeholder="이름 (최소 2자 이상 입력)" required=" " id="m_name" name="m_name"><br>
					<input type="text" placeholder="닉네임 (최소 2자 이상 입력)" required=" " id="m_nick" name="m_nick"><br>
					<input type="email" placeholder="이메일" required=" " id="_6mail" name="m_email"><br>
					<input type="tel" placeholder="전화번호" required=" " id="_phone" name="m_phone"><br><br>

					<label></label>
					<div class="divdup"></div>
					<br>

					<div class="register-check-box">
						<div class="check">
							<label class="checkbox"><input type="checkbox" name="_6event" value="email"><i> </i>이메일로 소식 받기</label>
						</div>
					</div>
					<div class="register-check-box">
						<div class="check">
							<label class="checkbox"><input type="checkbox" name="_6event" value="sms"><i> </i>SMS로 소식 받기</label>
						</div>
					</div>
					
					<div class="register-check-box">
						<div class="check">
							<label class="checkbox"><input type="checkbox" name="_6check"><i> </i>EdIT의 <span>이용약관 동의</span>하기</label><br>
						</div>
					</div>
					<input type="submit" value="회원가입">
				</form>
			</div>
			<div class="register-home">
				<a href="main.me">Home</a>
			</div>
		</div>
	</div>
	
<!-----------------------------------------------------------회원가입 끝------------------------------------------------------------------ -->


<!-- 제이쿼리 -->
<script type="text/javascript" src="script/jquery-3.7.0.js"></script>
<script type="text/javascript">
 	$(document).ready(function() {
 		$('#_6id').keyup(function() {
 			$.ajax({
 				url:'idCheck.me',
 				data:{'_6id':$('._6id').val() },
 				success:function (result) {
 					$('.divdup').html(result);
 				}
 			}) //$.ajax
 		}) // $('#_6id').keyup
 	}) // $(document)
	
	
	
	
	
</script>


</body>
</html>
</body>
</html>