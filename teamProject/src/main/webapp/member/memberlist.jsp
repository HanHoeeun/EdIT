<%@page import="com.itwillbs.domain.MemberDTO"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>buylist</title>
<link href= "../css/login.css" rel= "stylesheet" type="text/css">
<link href= "../css/style.css" rel= "stylesheet" type="text/css">
<link href= "../css/faq_1_9.css" rel= "stylesheet" type="text/css">
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
<title>buylist.jsp</title>
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
				<li class="active">회원리스트</li>
			</ol>
		</div>
	</div>
<!-- //breadcrumbs -->

<!--- --------------------------------------------------회원리스트 ---------------------------------------------------------->
	<div class="products">
		<div class="container">
			<div class="col-md-4 products-left">
				<div class="categories">
					<h2>마이페이지</h2>
					<ul class="cate"> <br>
						<li><a href="mypage.me"><i class="fa fa-arrow-right" ></i>나의 정보</a></li>
						<li><a href="buylist.me"><i class="fa fa-arrow-right"></i>구매 내역</a></li>
						<li><a href="salelist.me"><i class="fa fa-arrow-right"></i>판매 내역</a></li>
						<li><a href="product/checkout.jsp"><i class="fa fa-arrow-right"></i>찜♥</a></li>
						<li><a href="qnalist.me"><i class="fa fa-arrow-right"></i>문의 내역</a></li>
						<li><a href="delete.me"><i class="fa fa-arrow-right"></i>회원 탈퇴</a></li>
 						<li><a href="list.me"><i class="fa fa-arrow-right"></i>회원 관리(리스트)</a></li>  
					</ul>
				</div>											
			</div>		
			
				
			<div class="col-md-8 products-right">
			
			
				<div class="products-right-grid">
					<div class="products-right-grids">
						<div class="clearfix">
							<div class="categories">
								<h2>회원리스트</h2>
							</div>		
				 		</div>
					</div>
				</div>
				
				
				
				<form action="list.me" method="post">
					<div class="hover14 column">
						<div class="_6clearfix1"> 
								<div align="center">
		
<% 
	List<MemberDTO> memberList = (List<MemberDTO>) request.getAttribute("memberList");	
%>		
		
		
					<table class="_1qna_board">
						<tr>
							<th class="_1qna_board_border">번호</th>
							<th class="_1qna_board_border">이름</th>
							<th class="_1qna_board_border">닉네임</th>
							<th class="_1qna_board_border">메일</th>
							<th class="_1qna_board_border">전화번호</th>
							<th class="_1qna_board_border">가입날짜</th>
						</tr>
						
					
<%
		SimpleDateFormat fotmat = new SimpleDateFormat("yyyy.MM.dd");
		for (int i=0; i<memberList.size(); i++) { 
			MemberDTO memberDTO = memberList.get(i);
%>
		<tr>
			<td class="_1qna_board_border"><%=memberDTO.getM_num() %></td>
			<td class="_1qna_board_border"><%=memberDTO.getM_name() %></td>
			<td class="_1qna_board_border"><%=memberDTO.getM_nick() %></td>
			<td class="_1qna_board_border"><%=memberDTO.getM_email() %></td>
			<td class="_1qna_board_border"><%=memberDTO.getM_phone() %></td>
			<td class="_1qna_board_border"><%=memberDTO.getM_date() %></td>
		</tr>
<% 	
		}
%>						
						
		</table>
		</div>
						</div>
					</div>
								
					<div class="snipcart-details top_brand_home_details">
						<fieldset>
				
				
				---
				
				
						</fieldset>
						</div>
				</form>
			</div> <br><br>
							
					
						<div class="clearfix"> </div>
				</div>
			</div>

		</div>
	</div>

<!--- -------------------------------------------------회원리스 ---------------------------------------------------------->




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
<link href="../css/skdslider.css" rel="stylesheet">
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
<link href="../css/skdslider.css" rel="stylesheet">
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