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
<title>공지사항</title>
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
<link href="css/faq_1.css" rel="stylesheet"> 
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
</head>
	
<body>
<!--==================================== 상단 네비 ==================================-->
	<div class="breadcrumbs">
		<div class="container">
			<ol class="breadcrumb breadcrumb1 animated wow slideInLeft" data-wow-delay=".5s">
				<li><a href="index.html"><span class="glyphicon glyphicon-home" aria-hidden="true"></span>홈</a></li>
				<li class="active">신고하기</li>
			</ol>
		</div>
	</div>

<!--==================================== 바디 ===========================================================  -->
	<div class="top-brands">
		<h2>공지사항</h2>
		<div class="container_1_1">
			<div class="container_2_1">
<!--======================================== 상단 탭 리스트 ===================================================-->
				<ul class="tabs">
					<li class="tab-link current" data-tab="tab-1">일반공지</li>
					<li class="tab-link current" data-tab="tab-1">이벤트</li>
					<%if (1==1) { %>
					<li class="tab-link" data-tab="tab-2">작성</li>					
				<%}%>
				</ul>
			</div>
<!--======================================== 1탭 일반공지 ===================================================-->			
			<div class="container_3_1">
				<div id="tab-1" class="tab-content current">
					<table class="_1qna_board">
						<tr>
							<th class="_1qna_board_border">번호</th>
							<th class="_1qna_board_border">제목</th>
							<th class="_1qna_board_border">작성일</th>
						</tr>
						<tr>
							<td class="_1qna_board_border">1</td>
							<td class="_1qna_board_subject">거래 시 유의사항 안내</td>
							<td>2023.08.25</td>
						</tr>
						<tr>
							<td class="_1qna_board_border">1</td>
							<td class="_1qna_board_subject">거래 시 유의사항 안내</td>
							<td>2023.08.25</td>
						</tr>
						<tr>
							<td class="_1qna_board_border">1</td>
							<td class="_1qna_board_subject">거래 시 유의사항 안내</td>
							<td>2023.08.25</td>
						</tr>
					</table>
				<!--========================== 1탭 일반공지 페이지 =======================-->	
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
			</div>
			<!-- script for tabs -->
			<script type="text/javascript">
				$(function() {
				
					var menu_ul = $('.faq_1 > li > ul'),
						   menu_a  = $('.faq_1 > li > a');
					
					menu_ul.hide();
				
					menu_a.click(function(e) {
						e.preventDefault();
						if(!$(this).hasClass('active')) {
							menu_a.removeClass('active');
							menu_ul.filter(':visible').slideUp('normal');
							$(this).addClass('active').next().stop(true,true).slideDown('normal');
						} else {
							$(this).removeClass('active');
							$(this).next().stop(true,true).slideUp('normal');
						}
					});
				
				});
			</script>
			<!-- script for tabs -->
				</div>
				<div id="tab-2" class="tab-content">
				
<!--======================================== 2탭 이벤트 ===================================================-->			
			<div class="container_3_1">
				<div id="tab-1" class="tab-content current">
					<table class="_1qna_board">
						<tr>
							<th class="_1qna_board_border">번호</th>
							<th class="_1qna_board_border">제목</th>
							<th class="_1qna_board_border">작성일</th>
						</tr>
						<tr>
							<td class="_1qna_board_border">1</td>
							<td class="_1qna_board_subject">신규가입 회원 이벤트</td>
							<td>2023.08.25</td>
						</tr>
						<tr>
							<td class="_1qna_board_border">1</td>
							<td class="_1qna_board_subject">신규가입 회원 이벤트</td>
							<td>2023.08.25</td>
						</tr>
						<tr>
							<td class="_1qna_board_border">1</td>
							<td class="_1qna_board_subject">신규가입 회원 이벤트</td>
							<td>2023.08.25</td>
						</tr>
					</table>
					<!--=================== 1탭 일반공지 페이지 =====================-->	
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
			</div>
			<!-- script for tabs -->
			<script type="text/javascript">
				$(function() {
				
					var menu_ul = $('.faq_1 > li > ul'),
						   menu_a  = $('.faq_1 > li > a');
					
					menu_ul.hide();
				
					menu_a.click(function(e) {
						e.preventDefault();
						if(!$(this).hasClass('active')) {
							menu_a.removeClass('active');
							menu_ul.filter(':visible').slideUp('normal');
							$(this).addClass('active').next().stop(true,true).slideDown('normal');
						} else {
							$(this).removeClass('active');
							$(this).next().stop(true,true).slideUp('normal');
						}
					});
				
				});
			</script>
			<!-- script for tabs -->
				</div>
				<div id="tab-2" class="tab-content">
								
<!--============================================= 3탭 작성 =====================================================  -->
					<form action="writePro.bo" method="post" enctype="multipart/form-data">
						<table class="_1q_query_tab">
							<tr>
							<td class="_1q_query_tab_1">
								<select class="_1q_query_tab_sel" style="border:none;">
									<option value="">일반공지</option>
									<option value="">이벤트</option>
								</select>
							</td>
							<td class="_1q_query_tab_2"><input type="text" name="id" value="작성자" style="border:none;" readonly="readonly"></td>
							<td>
								<div class="_1q_query_tab_3"><label for="imgfile"><img src="images/picture.png" width="25px" height="25px">파일 업로드</label></div>
								<input type="file" name="imgfile" id="imgfile" accept="image/*">
							</td>
							</tr>
						</table>
						<div><br></div>
						<table class="_1q_query_tab">
							<tr>
							<td class="_1q_query_tab_4" colspan="3" ><input type="text" name="subject" placeholder="제목을 작성 해주세요" style="border:none;"></td>
							</tr>
						</table>
						<div><br></div>
						<table class="_1q_query_tab">
							<tr>
							<td class="_1q_query_tab_5" colspan="3"><textarea name="content" style="border:none;" cols="110" rows="20" class="noresize" placeholder="내용을 작성 해주세요" ></textarea></td>
							</tr>
						</table>
						<div class="_1q_query_btn">
								<button type="submit">작성</button>
								<button type="reset">취소</button>
						</div>
				</form>
				</div>
				<%if(1 == 1){ %>
				<div id="tab-3" class="tab-content">
<!-- 				3탭 게시판 테이블  -->
					<table class="_1qna_board">
						<tr>
							<th class="_1qna_board_border">번호</th>
							<th class="_1qna_board_border">제목</th>
							<th class="_1qna_board_border">작성자</th>
							<th class="_1qna_board_border">작성시간</th>
						</tr>
						<tr>
							<td class="_1qna_board_border">1</td>
							<td class="_1qna_board_subject">2</td>
							<td class="_1qna_board_border">3</td>
							<td>4</td>
						</tr>
						<tr>
							<td class="_1qna_board_border">1</td>
							<td class="_1qna_board_subject">2</td>
							<td class="_1qna_board_border">3</td>
							<td>4</td>
						</tr>
						<tr>
							<td class="_1qna_board_border">1</td>
							<td class="_1qna_board_subject">2</td>
							<td class="_1qna_board_border">3</td>
							<td>4</td>
						</tr>
						<tr>
							<td class="_1qna_board_border">1</td>
							<td class="_1qna_board_subject">2</td>
							<td class="_1qna_board_border">3</td>
							<td>4</td>
						</tr>
						<tr>
							<td class="_1qna_board_border">1</td>
							<td class="_1qna_board_subject">2</td>
							<td class="_1qna_board_border">3</td>
							<td>4</td>
						</tr>
						<tr>
							<td class="_1qna_board_border">1</td>
							<td class="_1qna_board_subject">2</td>
							<td class="_1qna_board_border">3</td>
							<td>4</td>
						</tr>
					</table>
<!-- 				3탭 페이징  -->
				    <div class="_1qna_paging">
        				<ul>
				            <a href="index.html"><li>prev</li></a>
				            <a href="about.html"><li>1</li></a>
				            <a href="contact.html"><li>2</li></a>
				            <a href="faq.html"><li>3</li></a>
				            <a href="gourmet.html"><li>4</li></a>
				            <a href="login.html"><li>5</li></a>
				            <a href="products.html"><li>next</li></a>
						    </ul>
   					 </div>
				</div>
				<%} %>
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
				})

			})
			</script>
			
		</div>
			<div class="clearfix_1_1"> </div>
	</div>
<!-- //top-brands -->
<!-- //footer -->
<div class="footer">
		<div class="container">
			<div class="w3_footer_grids">
				<div class="col-md-3 w3_footer_grid">
					<h3>Contact</h3>
					
					<ul class="address">
						<li><i class="glyphicon glyphicon-map-marker" aria-hidden="true"></i>1234k Avenue, 4th block, <span>New York City.</span></li>
						<li><i class="glyphicon glyphicon-envelope" aria-hidden="true"></i><a href="mailto:info@example.com">info@example.com</a></li>
						<li><i class="glyphicon glyphicon-earphone" aria-hidden="true"></i>+1234 567 567</li>
					</ul>
				</div>
				<div class="col-md-3 w3_footer_grid">
					<h3>Information</h3>
					<ul class="info"> 
						<li><i class="fa fa-arrow-right" aria-hidden="true"></i><a href="about.html">About Us</a></li>
						<li><i class="fa fa-arrow-right" aria-hidden="true"></i><a href="contact.html">Contact Us</a></li>
						<li><i class="fa fa-arrow-right" aria-hidden="true"></i><a href="short-codes.html">Short Codes</a></li>
						<li><i class="fa fa-arrow-right" aria-hidden="true"></i><a href="faq.html">FAQ's</a></li>
						<li><i class="fa fa-arrow-right" aria-hidden="true"></i><a href="products.html">Special Products</a></li>
					</ul>
				</div>
				<div class="col-md-3 w3_footer_grid">
					<h3>Category</h3>
					<ul class="info"> 
						<li><i class="fa fa-arrow-right" aria-hidden="true"></i><a href="groceries.html">Groceries</a></li>
						<li><i class="fa fa-arrow-right" aria-hidden="true"></i><a href="household.html">Household</a></li>
						<li><i class="fa fa-arrow-right" aria-hidden="true"></i><a href="personalcare.html">Personal Care</a></li>
						<li><i class="fa fa-arrow-right" aria-hidden="true"></i><a href="packagedfoods.html">Packaged Foods</a></li>
						<li><i class="fa fa-arrow-right" aria-hidden="true"></i><a href="beverages.html">Beverages</a></li>
					</ul>
				</div>
				<div class="col-md-3 w3_footer_grid">
					<h3>Profile</h3>
					<ul class="info"> 
						<li><i class="fa fa-arrow-right" aria-hidden="true"></i><a href="products.html">Store</a></li>
						<li><i class="fa fa-arrow-right" aria-hidden="true"></i><a href="checkout.html">My Cart</a></li>
						<li><i class="fa fa-arrow-right" aria-hidden="true"></i><a href="login.html">Login</a></li>
						<li><i class="fa fa-arrow-right" aria-hidden="true"></i><a href="registered.html">Create Account</a></li>
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