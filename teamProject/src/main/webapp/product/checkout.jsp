ㅠ<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>  
<head>
<meta charset="UTF-8">
<title>product/checkout.jsp</title>
</head>
<body>
<!--  찜리스트 
author: W3layouts
author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>
<html>
<head>
<title>Super Market an Ecommerce Online Shopping Category Flat Bootstrap Responsive Website Template | Checkout :: w3layouts</title>
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
			<ol class="breadcrumb breadcrumb1">
				<li><a href="index.html"><span class="glyphicon glyphicon-home" aria-hidden="true"></span>홈</a></li>
				<li class="active">찜리스트</li>
			</ol>
		</div>
	</div>
<!-- //breadcrumbs -->


<!-- 찜리스트 -->
	<div class="checkout">
		<div class="container">
			<h2>나의 찜리스트</h2>
			<div class="checkout-right">
				<table class="timetable_sub">
				
					<thead>
						<tr>
							<th>찜 번호</th>	
							<th>상품 이미지</th>
							<th>상품 이름</th>
							<th>가격</th>
							<th>삭제</th>
						</tr>
					</thead>
					
					<!-- 1번상품 -->
					<tr class="rem1">
					
						<!-- 찜 번호 -->
						<td class="invert">1</td>
						<!-- // 찜 번호 -->
						
						<!-- 상품 이미지 -->
						<td class="invert-image"><a href="single.po"><img src="../images/1.png" alt=" " class="img-responsive" /></a></td>
						<!-- // 상품 이미지 -->
						
						<!-- 상품 이름 -->
						<td class="invert"><a href="single.po">태블릿</a></td>
						<!-- // 상품 이름 -->
						
						<!-- 상품 가격 -->
						<td class="invert">200만원</td>
						<!-- // 상품 가격 -->
						
						<!-- 삭제하기 -->
						<td class="invert">
							<div class="rem">
								<div class="close1"> </div>
							</div>
							<script>$(document).ready(function(c) {
								$('.close1').on('click', function(c){
									$('.rem1').fadeOut('slow', function(c){
										$('.rem1').remove();
									});
									});	  
								});
						   </script>
						</td>
						<!-- // 삭제하기 -->
						
					</tr>
					<!-- // 1번상품 -->
					
					<!-- 2번상품 -->
					<tr class="rem2">
					
						<!-- 찜 번호 -->
						<td class="invert">2</td>
						<!-- // 찜 번호 -->
						
						<!-- 상품이미지 -->
						<td class="invert-image"><a href="single.po"><img src="../images/2.png" alt=" " class="img-responsive" /></a></td>
						<!-- // 상품이미지 -->
						
						<!-- 상품 이름 -->
						<td class="invert"><a href="single.po">노트북</a></td>
						<!-- // 상품 이름 -->
						
						<!-- 가격 -->
						<td class="invert">202만원</td>
						<!-- // 가격 -->
						
						<!-- 삭제하기 -->
						<td class="invert">
							<div class="rem">
								<div class="close2"> </div>
							</div>
							<script>$(document).ready(function(c) {
								$('.close2').on('click', function(c){
									$('.rem2').fadeOut('slow', function(c){
										$('.rem2').remove();
									});
									});	  
								});
						   </script>
						</td>
						<!-- // 삭제하기 -->
						
					</tr>
					<!-- // 2번상품 -->
					
					<!-- 3번상품 -->
					<tr class="rem3">
						
						<!-- 찜 번호 -->
						<td class="invert">3</td>
						<!-- // 찜 번호 -->
						
						<!-- 상품이미지 -->
						<td class="invert-image"><a href="single.po"><img src="../images/3.png" alt=" " class="img-responsive" /></a></td>
						<!-- // 상품이미지 -->
						
						<!-- 상품 이름 -->
						<td class="invert"><a href="single.po">휴대폰</a></td>
						<!-- // 상품 이름 -->
						
						<!-- 가격 -->
						<td class="invert">150만원</td>
						<!-- 가격 -->
						
						<!-- 삭제하기 -->
						<td class="invert">
							<div class="rem">
								<div class="close3"> </div>
							</div>
							<script>$(document).ready(function(c) {
								$('.close3').on('click', function(c){
									$('.rem3').fadeOut('slow', function(c){
										$('.rem3').remove();
									});
									});	  
								});
						   </script>
						</td>
						<!-- 삭제하기 -->
						
					</tr>
					<!-- // 3번상품 -->
					
				</table>
			</div>
			
			<!-- 페이지 목록 -->
			<nav class="numbering">
					<ul class="pagination paging">
						<li>
							<a href="#" aria-label="Previous">
								<span aria-hidden="true">&laquo;</span>
							</a>
						</li>
						<li class="active"><a href="#">1<span class="sr-only">(current)</span></a></li>
						<li><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li><a href="#">4</a></li>
						<li><a href="#">5</a></li>
						<li>
							<a href="#" aria-label="Next">
							<span aria-hidden="true">&raquo;</span>
							</a>
						</li>
					</ul>
			</nav>
			<!-- // 페이지 목록 -->	
			
			<!-- 쇼핑계속하기 버튼 -->
			<div class="checkout-left">	
				<div class="checkout-right-basket">
					<a href="products.po"><span class="glyphicon glyphicon-menu-left" aria-hidden="true"></span>쇼핑 계속하기</a>
				</div>
				<div class="clearfix"> </div>
			</div>
			<!-- // 쇼핑계속하기 버튼 -->
			
		</div>
	</div>
<!-- 찜리스트 -->

<!-- 푸터 들어가는 곳! -->
<div class="clearfix">
<jsp:include page="../inc/bottom.jsp"></jsp:include>
</div>
<!-- 푸터 들어가는 곳! -->

</body>
</html>
</body>
</html>