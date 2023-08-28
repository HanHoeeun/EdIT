<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html> 
<head>
<meta charset="UTF-8">
<title>productUpdate.jsp</title>
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
				<li class="active">상품 수정</li>
			</ol>
		</div>
	</div>
<!-- //breadcrumbs -->


<!-- register -->
	<div class="register">
		<div class="container">
		
			<h2>상품수정</h2>
			
			<div class="login-form-grids">
				<h5>상품 정보</h5>
				
				<!-- 상품 제목, 가격, 상품설명 -->
				<form action="#" method="post">
					<input type="text" name="_title" placeholder="제목을 입력하세요..." required=" " >
					<input type="text" name="_2price" placeholder="가격을 입력하세요..." required=" " >
					<textarea name="_2detail" placeholder="상품설명을 입력하세요... " id="_2detail" rows="10" cols="50" style="width: 428px" maxlength="400" required=" "></textarea>
				<!-- // 상품 제목, 가격, 상품설명 -->

				<!-- 상품카테고리, 상품상태 -->
				<div class="register-check-box">
					<div style="display: flex;">
						<select name="_2type" id="_2type" required style="width: 122px; height: 38px; padding: 10px 10px 10px 10px;  margin: 1em 0;">
						    <option value="">카테고리</option>
						    <option value="1">노트북</option>
						    <option value="2">테블릿</option>
						    <option value="3">휴대폰</option>
						</select>
						
						<select name="_2status" id="_2status" required style="width: 122px; height: 38px; margin: 1em 10px;">
						    <option value="">상품상태</option>
						    <option value="1" selected>판매중</option>
						    <option value="2">거래완료</option>
						</select>
					</div>
				</div>
				<!-- // 상품카테고리, 상품상태 -->
					

					<br>
					<b>★상품이미지 첨부</b>
					<br>
					<input type="file" name="_2iname" id="_2iname" maxlength="4000" style="padding: 10px 10px 10px 10px;">
				
					<!-- 수정하기 버튼 -->
					<input type="submit" value="수정하기">
					<!-- //수정하기 버튼 -->
					
				</form>
				
			</div>
			
			<!-- 뒤로가기 버튼 -->
			<div class="register-home">
				<a href="javascript:history.back();">뒤로가기</a>
			</div>
			<!-- // 뒤로가기 버튼 -->
			
		</div>
	</div>
<!-- //register -->

<!-- 푸터 들어가는 곳! -->
<div class="clearfix">
<jsp:include page="../inc/bottom.jsp"></jsp:include>
</div>
<!-- 푸터 들어가는 곳! -->

</body>
</html>
</body>
</html>