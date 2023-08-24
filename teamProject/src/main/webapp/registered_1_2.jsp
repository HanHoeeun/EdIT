<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>관리자 문의글 답변</title>
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
<!-- js  -->
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
</head>
	
<body>
<!--==================================== 상단 네비 ==================================-->
	<div class="breadcrumbs">
		<div class="container">
			<ol class="breadcrumb breadcrumb1 animated wow slideInLeft" data-wow-delay=".5s">
				<li><a href="index.html"><span class="glyphicon glyphicon-home" aria-hidden="true"></span>홈</a></li>
				<li class="active">고객센터</li>
				<li class="active">1 : 1 문의내역</li>
			</ol>
		</div>
	</div>
<!-- <!-- -================================= 사이드 메뉴 ====================================-
	<div class="products">
		<div class="container">
			<div class="col-md-4 products-left">
				<div class="categories">
					<h2>고객센터</h2>
					<ul class="cate">
						<li><a href="products.html"><i class="fa fa-arrow-right" aria-hidden="true"></i>자주 하는 질문</a></li>
						<li><a href="products.html"><i class="fa fa-arrow-right" aria-hidden="true"></i>1 : 1 문의</a></li>
							<ul>
								<li><a href="products.html"><i class="fa fa-arrow-right" aria-hidden="true"></i>문의하기</a></li>
								<li><a href="products.html"><i class="fa fa-arrow-right" aria-hidden="true"></i>문의 내역</a></li>
							</ul>	 --> 
	
<!--==================================== 바디 ==================================-->
<!-- 문의글 -->
<div class="register">
	<div class="container">
			<h2>1 : 1 문의 답변</h2>
			<form class="login-form-grids">		
			<p>아이디</p>
			<input type="text" value="hong12" readonly="readonly"><br>
			<p>제목</p>
			<input type="text" value="사기당했는데요;;" readonly="readonly"><br>
			<p>첨부파일</p>
			<input type="text" value="빈박스.jpg" readonly="readonly"><br>
			<p>문의내용</p>
			<textarea name="textarea" placeholder="아이패드 샀는데 벽돌보냈어요ㅡㅡ" readonly="readonly"></textarea><br><br>
			<p>답변내용</p>
			<textarea name="textarea" placeholder="내용을 입력하세요"></textarea><br><br>
			<input type="submit" value="답변"> 
			<input type="submit" value="취소">
			</form>
	</div>
</div>

			
	
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


</body>
</html>