<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main.jsp</title>

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
<title>main.jsp</title>
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
	<div class="agileits_header">
		<div class="container">
			<div class="w3l_offers">
				<p><a href="../product/products.jsp">쇼핑하기</a></p>
			</div>
			<div class="agile-login">
				<ul>
					<li><a href="registered.jsp">회원가입</a></li>
					<li><a href="login.jsp">로그인</a></li>
					<li><a href="contact.jsp">문의하기</a></li>
					
				</ul>
			</div>
			<div class="product_list_header">  
					<form action="#" method="post" class="last"> 
						<input type="hidden" name="cmd" value="_cart">
						<input type="hidden" name="display" value="1">
						<button class="w3view-cart" type="submit" name="submit" value=""><i class="fa fa-heart" aria-hidden="true"></i></button>
					</form>  
			</div>
			<div class="clearfix"> </div>
		</div>
	</div>

	<div class="logo_products">
		<div class="container">
		<div class="w3ls_logo_products_left1">
				<!-- <ul class="phone_email">
					<li><i class="fa fa-phone" aria-hidden="true">051-809-0909</i></li>
					
				</ul> -->
			</div>
			<div class="w3ls_logo_products_left">
				<h1><a href="main.jsp">EdIT</a></h1>
			</div>
		<div class="w3l_search">
			<form action="#" method="post">
				<input type="search" name="Search" placeholder="찾으시는 상품을 검색하세요" required="">
				<button type="submit" class="btn btn-default search" aria-label="Left Align">
					<i class="fa fa-search" aria-hidden="true"> </i>
				</button>
				<div class="clearfix"></div>
			</form>
		</div>
			
			<div class="clearfix"> </div>
		</div>
	</div>
<!-- //header -->
<!-- navigation -->
	<div class="navigation-agileits">
		<div class="container">
			<nav class="navbar navbar-default">
							<!-- Brand and toggle get grouped for better mobile display -->
							<div class="navbar-header nav_2">
								<button type="button" class="navbar-toggle collapsed navbar-toggle1" data-toggle="collapse" data-target="#bs-megadropdown-tabs">
									<span class="sr-only">Toggle navigation</span>
									<span class="icon-bar"></span>
									<span class="icon-bar"></span>
									<span class="icon-bar"></span>
								</button>
							</div> 
							<div class="collapse navbar-collapse" id="bs-megadropdown-tabs">
								<ul class="nav navbar-nav">
									<li class="active"><a href="index.jsp" class="act">Home</a></li>	
									<!-- Mega Menu -->
									<!-- Mega Menu -->
									<!-- 노트북 -->
									<li class="dropdown">
										<a href="product/groceries.jsp">노트북</a>
									</li>
									<!-- // 노트북 -->
									
									<!-- 휴대폰 -->
									<li class="dropdown">
										<a href="../product/household.jsp">휴대폰</a>
									</li>
									<!-- // 휴대폰 -->
									
									<!-- 태블릿 -->
									<li class="dropdown">
										<a href="../product/personalcare.jsp">태블릿</a>
									</li>
									<!-- // 태블릿 -->
									
									<!-- //Mega Menu -->
									
									<li><a href="contact.jsp">Contact</a></li>
								</ul>			
							</div>
							</nav>
			</div>
		</div>
		
<!-- //navigation -->
	<!-- main-slider -->
		<ul id="demo1">
			<li>
				<img src="images/11.png" width="1260px" height="800px"  alt="" />
				<!--Slider Description example-->
				<div class="slide-desc">
					<h3></h3>
				</div>
			</li>
			<li>
				<img src="images/22.png" width="1260px" height="800px"alt="" />
				  <div class="slide-desc">
					<h3></h3>
				</div>
			</li>
			
			<li>
				<img src="images/44.png" width="1260px" height="800px" alt="" />
				<div class="slide-desc">
					<h3></h3>
				</div>
			</li>
		</ul>
		<div class="clearfix"></div>
		<hr>

	<!-- //main-slider -->
 <!-- Carousel
    ================================================== -->
	<div id="myCarousel" class="carousel slide" data-ride="carousel">
 
      <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
      </ol>
      <div class="carousel-inner" role="listbox">
        <div class="item active">
         <img class="first-slide" src="images/roleEdit_7.png"  alt="First slide"></a>
       
        </div>
        <div class="item">
         <img class="second-slide " src="images/aboutEdit_7.png" alt="Second slide"></a>
         
        </div>
        <div class="item">
          <img class="third-slide " src="images/editedit_7.png" alt="Third slide"></a>
          
        </div>
      </div>
    
    </div>
    <div class="clearfix"></div> 
    <!-- /.carousel -->	
<!--banner-bottom-->
				<div class="ban-bottom-w3l">
					<div class="container">
					<div class="col-md-6 ban-bottom3">
							<div class="ban-top">
								<img src="images/onebyone_7.png" class="img-responsive" alt=""/>
							</div>
							<div class="ban-img">
								<div class=" ban-bottom1">
									<div class="ban-top">
										
										<img src="images/p2.jpeg" class="img-responsive" alt=""/>
										
									</div>
								</div>
								<hr>
								<div class="ban-bottom2">
									<div class="ban-top">
										<img src="images/commerce.jpg" class="img-responsive" alt=""/>
										
									</div>
								</div>
								<div class="clearfix"></div>
							</div>
						</div>
						<div class="col-md-6 ban-bottom">
							<div class="ban-top">
								<img src="images/social.png" class="img-responsive" alt=""/>
								
								
							</div>
						</div>
						
						<div class="clearfix"></div>
					</div>
				</div>
<!--banner-bottom-->
<!--//brands-->
<!-- new -->
	
<!-- //new -->
<!-- //footer -->
<div class="footer">
		<div class="container">
			<div class="w3_footer_grids">
				<div class="col-md-3 w3_footer_grid">
					<h3>Contact</h3>
					
					<ul class="address">
						<li><i class="glyphicon glyphicon-map-marker" aria-hidden="true"></i>| 부산광역시 부산진구 동천로 109, 삼한골든게이트빌딩 7층</span></li>
						<li><i class="glyphicon glyphicon-info-sign" aria-hidden="true"></i>| 사업자 등록번호 507-85-07103</li>
						<li><i class="glyphicon glyphicon-chevron-right" aria-hidden="true"></i>|  대표자 조인형</li>
						<li><i class="glyphicon glyphicon-chevron-right" aria-hidden="true"></i>| 개인정보책임자 김정현</li>
						<li><i class="glyphicon glyphicon-earphone" aria-hidden="true"></i>| 051-803-0909</li>
					</ul>
				</div>
				<div class="col-md-3 w3_footer_grid">
					<h3>정보</h3>
					<ul class="info"> 
						<!-- <li><i class="fa fa-arrow-right" aria-hidden="true"></i><a href="about.html">About Us</a></li> -->
						<li><i class="fa fa-arrow-right" aria-hidden="true"></i><a href="contact.jsp">문의하기</a></li>
						<!-- <li><i class="fa fa-arrow-right" aria-hidden="true"></i><a href="short-codes.jsp">Short Codes</a></li> -->
						<li><i class="fa fa-arrow-right" aria-hidden="true"></i><a href="faq.jsp">FAQ</a></li>
						<li><i class="fa fa-arrow-right" aria-hidden="true"></i><a href="../product/products.jsp">쇼핑하기</a></li>
					</ul>
				</div>
				<div class="col-md-3 w3_footer_grid">
					<h3>카테고리</h3>
					<ul class="info"> 
						<li><i class="fa fa-arrow-right" aria-hidden="true"></i><a href="main.jsp">홈페이지</a></li>
						<li><i class="fa fa-arrow-right" aria-hidden="true"></i><a href="../prodct/groceries.jsp">노트북</a></li>
						<li><i class="fa fa-arrow-right" aria-hidden="true"></i><a href="../product/household.jsp">휴대폰</a></li>
						<li><i class="fa fa-arrow-right" aria-hidden="true"></i><a href="../personalcare.jsp">태블릿</a></li>
					</ul>
				</div>
				<div class="col-md-3 w3_footer_grid">
					<h3>프로필</h3>
					<ul class="info"> 
						<li><i class="fa fa-arrow-right" aria-hidden="true"></i><a href="../product/checkout.jsp">찜리스트</a></li>
						<li><i class="fa fa-arrow-right" aria-hidden="true"></i><a href="login.jsp">로그인</a></li>
						<li><i class="fa fa-arrow-right" aria-hidden="true"></i><a href="registered.jsp">회원가입</a></li>
					</ul>
				</div>
				<div class="clearfix"> </div>
			</div>
		</div>
		
		<div class="footer-copy">
			
			<div class="container">
				<p>© 2017 Super Market. All rights reserved | Design by <a href="http://w3layouts.com/">W3layouts</a></p>
			</div>
		</div>
		
	</div>	
	<div class="footer-botm">
			<div class="container">
				<div class="w3layouts-foot">
					<ul>
						<li><a href="#" class="w3_agile_facebook"><i class="fa fa-facebook" aria-hidden="true"></i></a></li>
						<li><a href="#" class="agile_twitter"><i class="fa fa-twitter" aria-hidden="true"></i></a></li>
						<li><a href="#" class="w3_agile_dribble"><i class="fa fa-dribbble" aria-hidden="true"></i></a></li>
						<li><a href="#" class="w3_agile_vimeo"><i class="fa fa-vimeo" aria-hidden="true"></i></a></li>
					</ul>
				</div>
				<div class="payment-w3ls">	
					<img src="images/card.png" alt=" " class="img-responsive">
				</div>
				<div class="clearfix"> </div>
			</div>
		</div>
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