<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EdIT update</title>
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
<title>Super Market an Ecommerce Online Shopping Category Flat Bootstrap Responsive Website Template | Beverages :: w3layouts</title>

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
	
	
	
	
<!-- //header -->
<!-- navigation -->
	
	
	
	
	
<!-- //navigation -->
<!-- breadcrumbs -->
	<div class="breadcrumbs">
		<div class="container">
			<ol class="breadcrumb breadcrumb1 animated wow slideInLeft" data-wow-delay=".5s">
				<li><a href="index.html"><span class="glyphicon glyphicon-home" aria-hidden="true"></span>Home</a></li>
				<li class="active">마이페이지</li>
				<li class="active">나의정보수정</li>
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
						<li><a href="#"><i class="fa fa-arrow-right" ></i>나의 정보</a></li>
						<li><a href="#"><i class="fa fa-arrow-right"></i>구매 내역</a></li>
						<li><a href="#"><i class="fa fa-arrow-right"></i>판매 내역</a></li>
						<li><a href="#"><i class="fa fa-arrow-right"></i>찜♥</a></li>
						<li><a href="#"><i class="fa fa-arrow-right"></i>문의 내역</a></li>
						<li><a href="delete.me"><i class="fa fa-arrow-right"></i>회원 탈퇴</a></li>
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
				
<!-- 				중복, 인증 버튼 수정해야함 -->
				
				<div class="hover14 column">
						<div class="_6clearfix1"> 
							<div class="_6clearfix"> 
								<div align="center">
									<input type="text1" placeholder="아이디"  readonly>
									<input type="text" readonly>
									<input type="text1" placeholder="이름"  readonly>
									<input type="text" readonly>
									<input type="text1" placeholder="현재비밀번호"  readonly>
									<input type="text" >
									<input type="text1" placeholder="새비밀번호"  readonly>
									<input type="text" >
									<input type="text1" placeholder="새비밀번호확인"  readonly>
									<input type="text" >
									<input type="text1" placeholder="닉네임">
									<input type="text" >
									<input type="submit" name="submit1" value="중복확인" class="button">
									<input type="text1" placeholder="전화번호" >
									<input type="text" >
									<input type="submit" name="submit1" value="인증" class="button"><br>
									<input type="text" placeholder="인증번호">
									<input type="submit" name="submit1" value="확인" class="button">
									<input type="text1" placeholder="이메일" >
									<input type="email" >
									<input type="submit" name="submit1" value="중복확인" class="button">
								</div>	
							</div>
						</div>
				</div>
				
				
				<div class="snipcart-details top_brand_home_details">
					<form action="update.jsp" method="post">
						<fieldset>
							<input type="button" name="submit" value="수정" class="button">
						</fieldset>
					</form>
				</div> <br><br>
				
				
			
				
				
				
				
				
				
				
				
				
				<div class="agile_top_brands_grids">
					<div class="col-md-4 top_brand_left">
						<div class="hover14 column">
							<div class="agile_top_brand_left_grid">
								<div class="agile_top_brand_left_grid1">
										<div class="snipcart-item block">
											<div class="snipcart-thumb">
												<a><img class="_6img" src="images/blist_6.png"></a>
											</div>
											<div class="snipcart-details top_brand_home_details">
												<form action="#" method="post">
													<fieldset>
														<input type="submit" name="submit" value="구매 내역" class="button">
													</fieldset>
												</form>
											</div>
										</div>
								</div>
							</div>
						</div>
					</div>
					
					<div class="col-md-4 top_brand_left">
						<div class="hover14 column">
							<div class="agile_top_brand_left_grid">
								<div class="agile_top_brand_left_grid1">
									<figure>
										<div class="snipcart-item block">
											<div class="snipcart-thumb">
												<a><img class="_6img" src="images/slist_6.png"></a>
											</div>
											<div class="snipcart-details top_brand_home_details">
												<form action="#" method="post">
													<fieldset>
															<input type="submit" name="submit" value="판매내역" class="button">
													</fieldset>
												</form>
											</div>
										</div>
									</figure>
								</div>
							</div>
						</div>
					</div>
					
					<div class="col-md-4 top_brand_left">
						<div class="hover14 column">
							<div class="agile_top_brand_left_grid">
								<div class="agile_top_brand_left_grid1">
									<figure>
										<div class="snipcart-item block">
											<div class="_6snipcart-thumb" >
												<a><img class="_6img" src="images/heart_6.png"></a>	<br>
											</div>
											
											<div class="snipcart-details top_brand_home_details">
												<form action="#" method="post">
													<fieldset>
														<input type="submit" name="submit" value="찜♥" class="button">
													</fieldset>
												</form>
											</div>
										</div>
									</figure>
								</div>
							</div>
						</div>
					</div>
						<div class="clearfix"> </div>
				</div>
				
				
				
				
				
				
				
				<div class="agile_top_brands_grids">
					<div class="col-md-4 top_brand_left">
						<div class="hover14 column">
							<div class="agile_top_brand_left_grid">
								<div class="agile_top_brand_left_grid1">
									<figure>
										<div class="snipcart-item block">
											<div class="snipcart-thumb">
												<a><img class="_6img" src="images/qna_6.png"></a>
											</div>
											<div class="snipcart-details top_brand_home_details">
												<form action="#" method="post">
													<fieldset>
														<input type="submit" name="submit" value="문의 내역" class="button">
													</fieldset>
												</form>
											</div>
										</div>
									</figure>
								</div>
							</div>
						</div>
					</div>
					
					
					
					<div class="col-md-4 top_brand_left">
						<div class="hover14 column">
							<div class="agile_top_brand_left_grid">
								<div class="agile_top_brand_left_grid1">
									<figure>
										<div class="snipcart-item block">
											<div class="snipcart-thumb">
												<a><img class="_6img" src="images/x_6.png"></a>
											</div>
											<div class="snipcart-details top_brand_home_details">
												<form action="#" method="post">
													<fieldset>
														<input type="submit" name="submit" value="회원 탈퇴" class="button">
													</fieldset>
												</form>
											</div>
										</div>
									</figure>
								</div>
							</div>
						</div>
					</div>
					
					
					
					
					<div class="col-md-4 top_brand_left">
						<div class="hover14 column">
							<div class="agile_top_brand_left_grid">
								<div class="agile_top_brand_left_grid1">
									<figure>
										<div class="snipcart-item block">
											<div class="snipcart-thumb">
												<a><img class="_6img" src="images/member_6.png"></a>
											</div>
												<div class="snipcart-details top_brand_home_details">
													<form action="#" method="post">
														<fieldset>
															<input type="submit" name="submit" value="회원 관리" class="button">
														</fieldset>
													</form>
												</div>
											</div>
										</figure>
									</div>
								</div>
							</div>
						</div>
					</div>
					
					
					
					
						<div class="clearfix"> </div>
				</div>
			</div>

		</div>
	</div>

<!--- --------------------------------------------------회원정보 수정 ---------------------------------------------------------->
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