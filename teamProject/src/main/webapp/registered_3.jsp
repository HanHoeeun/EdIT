<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>findid.jsp</title>
<link href= "css/login.css" rel= "stylesheet" type="text/css">
<link href= "css/style.css" rel= "stylesheet" type="text/css">
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
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- font-awesome icons -->
<link href="css/font-awesome.css" rel="stylesheet"> 
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
				<li class="active">로그인</li>
			</ol>
		</div>
	</div>
<!-- //breadcrumbs -->





<!-- !!!!!!!!!!!!!!!!!!회원가입!!!!!!!!!!!!!!!!!!!!!!!!!!!! -->
	<div class="register">
		<div class="container">
			<h2>회원가입</h2>
			<div class="_6join-form-grids">
				<h5>회원정보등록</h5><br>
				<form action="#" method="post">
					아이디
					<input type="text" placeholder="영문/숫자, 6~20자" required=" " >
					<input type="submit" name="submit1" value="중복확인" class="button"><br><br>
					
					비밀번호
					<input type="text" placeholder="영문+숫자+특수문자, 8~20자" required=" " ><br>
					
					비밀번호 확인
					<input type="text" placeholder="영문+숫자+특수문자, 8~20자" required=" " ><br>
					이름
					<input type="text" placeholder="최소 2자 이상 입력" required=" " ><br>
					닉네임
					<input type="text" placeholder="최소 2자 이상 입력" required=" " >
					<input type="submit" name="submit1" value="중복확인" class="button"><br><br>
					이메일
					<input type="email" placeholder="Email Address" required=" " >
					<input type="submit" name="submit1" value="중복확인" class="button"><br><br>
					전화번호
					<input type="text" placeholder="Password" required=" " >
					<input type="submit" name="submit1" value="인증" class="button"><br>
					<input type="password" placeholder="Password Confirmation" required=" " >
					<input type="submit" name="submit1" value="확인" class="button"><br><br>
				 <br>
			
				<div class="register-check-box">
					<div class="check">
					<p type="text" class="_6marketing">마케팅 수신  동의 	
						<label class="checkbox"><input type="checkbox" name="checkbox" id="emailcheck"> <i> </i>이메일</label>
						<label class="checkbox"><input type="checkbox" name="checkbox" id="smscheck"> <i> </i>SMS</label>
					</div>
				</div> <br>
					<div class="register-check-box">
						<div class="check">
							<label class="checkbox"><input type="checkbox" name="checkbox"><i> </i>EdIT의 <span>이용약관 동의</span>하기</label>
						</div>
					</div>
					<input type="submit" name="submit2"value="회원가입">
				</form>
			</div>
			<div class="register-home">
			
				<a href="index.html">홈</a>
			</div>
		</div>
	</div>
<!-- //register -->
<!-- //footer -->



<!-- //footer -->	
<!-- Bootstrap Core JavaScript -->
<script src="js/bootstrap.min.js"></script>
<!-- top-header and slider -->
<!-- here stars scrolling icon -->
	<script type="text/javascript">
		$(document).ready(function() {
			/*
				var defaults = {
				containerID: 'toTop', // fading element id
				containerHoverID: 'toTopHover', // fading element hover id
				scrollSpeed: 1200,
				easingType: 'linear' 
				};
			*/
								
			$().UItoTop({ easingType: 'easeOutQuart' });
								
			});
	</script>
<!-- //here ends scrolling icon -->
<script src="js/minicart.min.js"></script>
<script>
	// Mini Cart
	paypal.minicart.render({
		action: '#'
	});

	if (~window.location.search.indexOf('reset=true')) {
		paypal.minicart.reset();
	}
</script>
<!-- main slider-banner -->
<script src="js/skdslider.min.js"></script>
<link href="css/skdslider.css" rel="stylesheet">
<script type="text/javascript">
		jQuery(document).ready(function(){
			jQuery('#demo1').skdslider({'delay':5000, 'animationSpeed': 2000,'showNextPrev':true,'showPlayButton':true,'autoSlide':true,'animationType':'fading'});
						
			jQuery('#responsive').change(function(){
			  $('#responsive_wrapper').width(jQuery(this).val());
			});
			
		});
</script>	
<!-- //main slider-banner --> 

</body>
</html>

</body>
</html>