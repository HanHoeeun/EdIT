<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EdIT update</title>
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
<title>update.jsp</title>
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
				<li class="active">내정보수정</li>
			</ol>
		</div>
	</div>
<!-- //breadcrumbs -->
<!--- --------------------------------------------------회원정보 수정 ---------------------------------------------------------->
	<div class="products">
		<div class="container">
			<div class="col-md-4 products-left">
				<div class="categories">
					<h2>마이페이지</h2>
					<ul class="cate"> <br>
						<li><a href="mypage.jsp"><i class="fa fa-arrow-right" ></i>나의 정보</a></li>
						<li><a href="buylist.jsp"><i class="fa fa-arrow-right"></i>구매 내역</a></li>
						<li><a href="salelist.jsp"><i class="fa fa-arrow-right"></i>판매 내역</a></li>
						<li><a href="product/checkout.jsp"><i class="fa fa-arrow-right"></i>찜♥</a></li>
						<li><a href="qnalist.jsp"><i class="fa fa-arrow-right"></i>문의 내역</a></li>
						<li><a href="delete.jsp"><i class="fa fa-arrow-right"></i>회원 탈퇴</a></li>
 						<li><a href="#"><i class="fa fa-arrow-right"></i>회원 관리</a></li>  
					</ul>
				</div>											
			</div>		
							
			<div class="col-md-8 products-right">
						
					<div class="products-right-grid">
						<div class="products-right-grids">
							<div class="clearfix">
								<div class="categories">
									<h2>나의정보수정</h2>
								</div>		
					 		</div>
						</div>
					</div>
					
	
	
					
				<form action="updatePro.me" method="post">
					<div class="hover14 column">
						<div class="_6clearfix1"> 
							<div class="_6clearfix"> 
								<div align="center">
									<input type="text" placeholder="아이디가 나타날것임 고정" required=" " id="_6id" readonly="readonly"><br>
									<input type="text" placeholder="현재비밀번호" required=" " id="_6pass1"><br>
									<input type="text" placeholder="새비밀번호" required=" "  id="_6pass2"> <br>
									<input type="text" placeholder="새비밀번호 확인" required=" "  id="_6pass2"><br> 
									<input type="text" placeholder="이름 (최소 2자 이상 입력)" required=" " id="_6name"><br>
									<input type="text" placeholder="변경 할 닉네임 (최소 2자 이상 입력)" required=" " id="_6nick"><br>
									<input type="email" placeholder="변경 할 이메일" required=" " id="_6mail"><br>
									<input type="tel" placeholder="변경 할 전화번호" required=" " id="_6tel">
								</div>	
							</div>
						</div>
					</div>
								
					<div class="snipcart-details top_brand_home_details">
						<fieldset>
							<input type="button" name="submit" value="수정" class="button">
						</fieldset>
						</div>
				</form>
			</div> <br><br>
				
						
		
					
						<div class="clearfix"> </div>
				</div>
			</div>

		</div>
	</div>

<!--- --------------------------------------------------회원정보 수정 ---------------------------------------------------------->




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
<!-- //footer -->
<jsp:include page="/inc/bottom.jsp"></jsp:include>
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