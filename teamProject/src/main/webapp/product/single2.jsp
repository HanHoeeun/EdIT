<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>  
<meta charset="UTF-8">
<title>product/single.jsp</title>
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
<title>Super Market an Ecommerce Online Shopping Category Flat Bootstrap Responsive Website Template | Single Page :: w3layouts</title>
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
<script src="../js/jquery-1.11.1.min.js"></script>
<!-- //js -->
<link href='//fonts.googleapis.com/css?family=Raleway:400,100,100italic,200,200italic,300,400italic,500,500italic,600,600italic,700,700italic,800,800italic,900,900italic' rel='stylesheet' type='text/css'>
<link href='//fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic' rel='stylesheet' type='text/css'>
<!-- start-smoth-scrolling -->
<script type="text/javascript" src="../js/move-top.js"></script>
<script type="text/javascript" src="../js/easing.js"></script>
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

<!-- 헤더 들어가는 곳! -->
<jsp:include page="../inc/top.jsp"></jsp:include>
<!-- 헤더 들어가는 곳! -->


<!-- breadcrumbs -->
	<div class="breadcrumbs">
		<div class="container">
			<ol class="breadcrumb breadcrumb1 animated wow slideInLeft" data-wow-delay=".5s">
				<li><a href="../index.jsp"><span class="glyphicon glyphicon-home" aria-hidden="true"></span>홈</a></li>
				<li class="active">상품 상세페이지</li>
			</ol>
		</div>
	</div>
<!-- //breadcrumbs -->


<!-- 상품그림,제목,설명,관심도 등 -->
	<div class="products">
		<div class="container">
			<div class="agileinfo_single">
				
				<div class="col-md-4 agileinfo_single_left">
					<img id="example" src="../images/si1.jpg" alt=" " class="img-responsive">
				</div>
				<div class="col-md-8 agileinfo_single_right">
					
					<!-- 조회수 -->
					<div style="float: right;">
					<img src="../images/readcountimg.png" width="20" height=20" alt="조회수"><i> : 236</i>
					</div>
					<!-- 조회수 -->
				
					<!-- 상품제목 -->
					<h2>사과 노트북</h2>
					<!-- // 상품제목 -->
					
					<!-- 가격 -->	
					<div class="snipcart-thumb agileinfo_single_right_snipcart">
						<h4 class="m-sing">200만원</h4>
					</div>
					<!-- // 가격 -->
					
					<hr>
					
					<!-- 판매ID,상품상태,등록날짜 -->
					<div class="w3agile_description">
						<p>판매ID : asgg123</p>
						<p>상품상태 : 판매중</p>
						<p>등록날짜 : </p>
					</div>
					<!-- 판매ID,상품상태,등록날짜 -->
					
					<!-- 상품설명 -->
					<div class="w3agile_description">
						<h4>상품 상세설명 :</h4>
						<p>
						노트북이 빠르고 디자인도 깔끔하게 잘 뽑혔다. 성능이 죽입니다!!!!1
						</p>
					</div>
					<!-- // 상품설명 -->
					
					<!-- 채팅, 신고하기, 상품목록 버튼 -->
					<div class="checkout-right-basket">
					<a href="productUpdate.po"><span class="glyphicon glyphicon-menu-left" aria-hidden="true"></span>상품수정</a>
					<a href="productDelete.po"><span class="glyphicon glyphicon-menu-left" aria-hidden="true"></span>상품삭제</a>
					<a href="products.po"><span class="glyphicon glyphicon-menu-left" aria-hidden="true"></span>상품목록</a>
					</div>
					<!-- // 채팅, 신고하기, 상품목록 버튼 -->
					
				</div>
				<div class="clearfix"> </div>
			</div>
		</div>
	</div>
<!-- // 상품그림,제목,설명,관심도 등 -->
	
<!-- 푸터 들어가는 곳! -->
<div class="clearfix">
<jsp:include page="../inc/bottom.jsp"></jsp:include>
</div>
<!-- 푸터 들어가는 곳! -->


</body>
</html>
</body>
</html>