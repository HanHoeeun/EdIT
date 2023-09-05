<%@page import="com.itwillbs.domain.MemberDTO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.itwillbs.domain.NoticePageDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.itwillbs.domain.NoticeDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--
author: W3layouts
author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>
<html>
<head>
<title>마이페이지</title>
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
<link href="../css/font-awesome.css" rel="stylesheet"> 
<link href="./css/mypage_3.css" rel="stylesheet"> 
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
<!--================================== 헤더 ==================================== -->
<jsp:include page="../inc/top.jsp"></jsp:include>
	
<!--=========================== 상단 네비 ============================================ -->
	<div class="breadcrumbs">
		<div class="container">
			<ol class="breadcrumb breadcrumb1 animated wow slideInLeft" data-wow-delay=".5s">
				<li><a href="index.html"><span class="glyphicon glyphicon-home" aria-hidden="true"></span>홈</a></li>
				<li class="active">마이페이지</li>
			</ol>
		</div>
	</div>
<!--=========================== 본문 헤더 =========================================== -->	
	<div class="top-brands_1">
		<h2>마이페이지</h2>
			<div class="container_2_1">

<!--=========================== 상단 탭 리스트============================================ -->
				<ul class="tabs">
					<li class="tab-link current" data-tab="tab-1">나의정보</li>
					<li class="tab-link" data-tab="tab-2">구매내역</li>
					<li class="tab-link" data-tab="tab-3">판매내역</li>
					<li class="tab-link" data-tab="tab-4">찜</li>
					<li class="tab-link" data-tab="tab-5">문의내역</li>
					<li class="tab-link" data-tab="tab-6">신고내역</li>
					<li class="tab-link" data-tab="tab-7">회원탈퇴</li>
				</ul>
			</div>
		
<!--================================== 1탭 나의정보==================================== -->
<%
	MemberDTO memberDTO = (MemberDTO)request.getAttribute("memberDTO");
%>

			<div class="container_3_1">
				<div id="tab-1" class="tab-content current">
					<table class="mypage-board">
						<tr>
							<th class="_1qna_board_border1" colspan="2">나의정보</th>
						</tr>
<!-- 		----아이디---- -->
						 <tr>
							<td class="_1qna_board_border2">
								<form action="update.me" method="post">
									<div class="mypage-grids"> 
										<div align="center">
											<input type="text" class="show" placeholder="아이디" readonly="readonly"readonly>
											<input type="text" value="<%=memberDTO.getM_id() %>" id="m_id" name="m_id" readonly="readonly">
										</div>
									</div>
								</form>
							</td>
						</tr>
						
<!-- 		----닉네임---- -->						
						 <tr>
							<td class="_1qna_board_border2">
								<form action="update.me" method="post">
									<div class="mypage-grids"> 
										<div align="center">
											<input type="text" class="show" placeholder="닉네임" readonly="readonly"readonly>
											<input type="text" value="<%=memberDTO.getM_nick() %>" id="m_nick" name="m_nick">
										</div>
									</div>
								</form>
							</td>
							<td class="_1qna_board_border3" width="10">
								<div class="up-button">
									<input type="button" class="up-button" value="수정">
								</div>
							</td>
						</tr>
						
<!-- 		----비밀번호---- -->						
						<tr>
							<td class="_1qna_board_border2">
								<form action="mypage.me" method="post">
									<div class="mypage-grids"> 
										<div align="center">
											<input type="text" class="show" placeholder="비밀번호" readonly="readonly"readonly>
											<input type="password" value=""			id="m_pass" 	name="m_pass">
											<input type="password" value="" 		id="m_pass2" 	name="m_pass2">
											<input type="password" value="" 		id="m_pass3" 	name="m_pass3">
										</div>
									</div>
								</form>
							</td>
												
							<td class="_1qna_board_border3" width="10">
							<div class="up-button">
							<input type="button" class="up-button" value="수정">
							</div>
							</td>
						</tr>
						
						
						
						
						<tr>	
							<td class="_1qna_board_border2">
								<form action="mypage.me" method="post">
									<div class="mypage-grids"> 
										<div align="center">
											<input type="text" class="show" placeholder="이메일" readonly="readonly"readonly>
											<input type="email" value="<%=memberDTO.getM_email()%>"		id="m_email" 	name="m_email">
										</div>
									</div>
								</form>
							</td>
												
							<td class="_1qna_board_border3" width="10">
							<div class="up-button">
							<input type="button" class="up-button" value="수정">
							</div>
							</td>
						</tr>
						
						
						
						<tr>	
							<td class="_1qna_board_border2">
								<form action="mypage.me" method="post">
									<div class="mypage-grids"> 
										<div align="center">
											<input type="text" class="show" placeholder="전화번호" readonly="readonly"readonly>
											<input type="tel" value="<%=memberDTO.getM_phone() %>"		id="m_phone" 	name="m_phone">
										</div>
									</div>
								</form>
							</td>
												
							<td class="_1qna_board_border3" width="10">
							<div class="up-button">
							<input type="button" class="up-button" value="수정">
							</div>
							</td>
						</tr>
						

						
						
						
						
					</table>
				</div>
<!--================================== 2탭 구매내역 ==================================== -->				
				<div id="tab-2" class="tab-content">
					<table class="_1qna_board">
						<tr>
							<th class="_1qna_board_border">번호</th>
							<th class="_1qna_board_border">제목</th>
							<th class="_1qna_board_border">작성일</th>
						</tr>
						<tr>
							<td class="_1qna_board_border">1</td>
							<td class="_1qna_board_subject">신규가입 회원 혜택이 빵빵! (~09/30)</td>
							<td class="_1qna_board_border">2023.09.01</td>
						</tr>
						
					</table>
					<!--============= 2탭 이벤트 페이징 ==================== -->
				    <div class="_1qna_paging">
				 
					 <ul>
				       <li onclick="location.href='index.html'">◀</li>
				       <li onclick="location.href='about.html'">1</li>
			           <li onclick="location.href='login.html'">2</li>
			           <li onclick="location.href='faq.html'">3</li>
			           <li onclick="location.href='gourmet.html'">4</li>
			           <li onclick="location.href='login.html'">5</li>
			           <li onclick="location.href='products.html'">▶</li>						
			         </ul> 
   					 </div>
				</div>
<!--================================== 3탭 판매내역 ==================================== -->
	
				<div id="tab-3" class="tab-content">
					<table class="_1qna_board">
						<tr>
							<th class="_1qna_board_border">번호</th>
							<th class="_1qna_board_border">제목</th>
							<th class="_1qna_board_border">작성일</th>
						</tr>
						<tr>
							<td class="_1qna_board_border">1</td>
							<td class="_1qna_board_subject">신규가입 회원 혜택이 빵빵! (~09/30)</td>
							<td class="_1qna_board_border">2023.09.01</td>
						</tr>
						
					</table>
		<!--============= 3탭 이벤트 페이징 ==================== -->
				    <div class="_1qna_paging">
				 
					 <ul>
				       <li onclick="location.href='index.html'">◀</li>
				       <li onclick="location.href='about.html'">1</li>
			           <li onclick="location.href='login.html'">2</li>
			           <li onclick="location.href='faq.html'">3</li>
			           <li onclick="location.href='gourmet.html'">4</li>
			           <li onclick="location.href='login.html'">5</li>
			           <li onclick="location.href='products.html'">▶</li>						
			         </ul> 
   					 </div>
				</div>
<!--================================== 4탭 찜 ==================================== -->				
				<div id="tab-4" class="tab-content">
					<table class="_1qna_board">
						<tr>
							<th class="_1qna_board_border">번호</th>
							<th class="_1qna_board_border">제목</th>
							<th class="_1qna_board_border">작성일</th>
						</tr>
						<tr>
							<td class="_1qna_board_border">1</td>
							<td class="_1qna_board_subject">신규가입 회원 혜택이 빵빵! (~09/30)</td>
							<td class="_1qna_board_border">2023.09.01</td>
						</tr>
						
					</table>
				</div>
<!--================================== 5탭 문의내역 ==================================== -->				
				<div id="tab-5" class="tab-content">
					<table class="_1qna_board">
						<tr>
							<th class="_1qna_board_border">번호</th>
							<th class="_1qna_board_border">제목</th>
							<th class="_1qna_board_border">작성일</th>
						</tr>
						<tr>
							<td class="_1qna_board_border">1</td>
							<td class="_1qna_board_subject">신규가입 회원 혜택이 빵빵! (~09/30)</td>
							<td class="_1qna_board_border">2023.09.01</td>
						</tr>
						
					</table>
				</div>
<!--================================== 6탭 신고내역 ==================================== -->				
				<div id="tab-6" class="tab-content">
					<table class="_1qna_board">
						<tr>
							<th class="_1qna_board_border">번호</th>
							<th class="_1qna_board_border">제목</th>
							<th class="_1qna_board_border">신고일</th>
							<th class="_1qna_board_border">처리상태</th>
						</tr>
						<tr>
							<td class="_1qna_board_border">1</td>
							<td class="_1qna_board_subject">신규가입 회원 혜택이 빵빵! (~09/30)</td>
							<td class="_1qna_board_border">2023.09.01</td>
							<td class="_1qna_board_border">2023.09.01</td>
						</tr>
						
					</table>
				</div>
<!--================================== 7탭 회원탈퇴 ==================================== -->				
<%
	String m_id = (String)request.getAttribute("m_id");
%>	
				<div id="tab-7" class="tab-content">
					<table class="_1qna_board">
						<tr><th class="_1qna_board_border1">회원탈퇴</th></tr>

						 <tr ><td class="_1qna_board_border2">
								<form action="deletePro.me" method="post">
									<div class="mypage-grids">  
										<div align="center">
											<input type="text" class="show" placeholder="아이디" readonly="readonly"readonly>
											<input type="text" value="<%=m_id %>" name="m_id"  readonly="readonly"readonly>
											<input type="text" class="show" placeholder="비밀번호" readonly="readonly"readonly >
											<input type="password" name="m_pass" required=" " id="m_pass"> <br>
											<div class="divdub"></div>
										</div>	
									</div>
								
								
								
								<div class="delete-button">
									<input type="submit" class="del-button" value="탈퇴하기">
								</div>
											
								</form>
							</td></tr>
					</table>
				</div>
				
				
</div>
</div>
				
				
				
				
				
				
				
				
				
				
				
				
<!-- 			탭 jquery -->
<script type="text/javascript">
$(document).ready(function(){
   $('ul.tabs li').click(function(){
      var tab_id = $(this).attr('data-tab');
      $('ul.tabs li').removeClass('current');
      $('.tab-content').removeClass('current');
	  $(this).addClass('current');
      $("#"+tab_id).addClass('current');
      // Add parameter to URL
      var url = window.location.href.split('?')[0];
      history.pushState(null, null, url + '?tab=' + tab_id);
   });

      // Check URL for tab parameter on page load
      var urlParams = new URLSearchParams(window.location.search);
      if (urlParams.has('tab')) {
      	var tabParam = urlParams.get('tab');
      	$('.tabs li').removeClass('current');
     	$('.tab-content').removeClass('current');
     	$('[data-tab="' + tabParam + '"]').addClass('current');
    	$('#' + tabParam).addClass('current');
      }
});
</script>


<div class="clearfix_1_1"> </div>
<!--================================== 푸터 ==================================== -->
<div class="clearfix">
<jsp:include page="../inc/bottom.jsp"></jsp:include>
</div>	
<!--========================= Bootstrap Core JavaScript =========================-->
<script src="../js/bootstrap.min.js"></script>
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
<script src="../js/minicart.min.js"></script>
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
<script src="../js/skdslider.min.js"></script>
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