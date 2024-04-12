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
<title>공지글 수정</title>
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Super Market Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript">
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<!-- //for-mobile-apps -->
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"
	media="all" />
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- font-awesome icons -->
<link href="css/font-awesome.css" rel="stylesheet">
<link href="css/faq_1_9.css" rel="stylesheet">
<link href="css/notice.css" rel="stylesheet">
<!-- //font-awesome icons -->
<!-- js -->
<script src="js/jquery-1.11.1.min.js"></script>
<!-- //js -->
<link
	href='//fonts.googleapis.com/css?family=Raleway:400,100,100italic,200,200italic,300,400italic,500,500italic,600,600italic,700,700italic,800,800italic,900,900italic'
	rel='stylesheet' type='text/css'>
<link
	href='//fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic'
	rel='stylesheet' type='text/css'>
<!-- start-smoth-scrolling -->
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event) {
			event.preventDefault();
			$('html,body').animate({
				scrollTop : $(this.hash).offset().top
			}, 1000);
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
			<ol class="breadcrumb breadcrumb1 animated wow slideInLeft"
				data-wow-delay=".5s">
				<li><a href="index.html"><span
						class="glyphicon glyphicon-home" aria-hidden="true"></span>홈</a></li>
				<li class="active">공지사항</li>
				<li class="active">공지글 수정</li>
			</ol>
		</div>
	</div>
<!--=========================== 본문 헤더 =========================================== -->
<%
	NoticeDTO noticeDTO = (NoticeDTO) request.getAttribute("noticeDTO");
	%>
	<div class="top-brands_1">
		<h2><%=noticeDTO.getA_notice_type()%> 수정</h2>
	</div>	
	<!--=========================== 본문 =========================================== -->
	<%
String a_m_num = (String)session.getAttribute("a_m_num");

%>	
		<form action="updatePro.no" method="post" enctype="multipart/form-data">
		<input type="hidden" name="a_num" value="<%=noticeDTO.getA_num()%>">
			<table class="_1q_query_tab">
				<tr>
					<td class="_1q_query_tab_1">
					<select class="_1q_query_tab_sel"
						name="a_notice_type" style="border: none;">
						
							<option value="공지" <%if(noticeDTO.getA_notice_type().equals("공지")) {%> selected <%}%>>공지</option>
							<option value="이벤트" <%if(noticeDTO.getA_notice_type().equals("이벤트")) {%> selected <%}%>>이벤트</option>
					</select></td>
					<td>
						<div class="_1q_query_tab_3">
							<label for="imgfile"><img src="images/picture.png"
								width="25px" height="25px">파일 업로드</label>
						</div> <input type="file" name="a_file" id="imgfile" accept="image/*">
						<%=noticeDTO.getA_file() %>
						<input type="hidden" name="a_oldfile" value="<%=noticeDTO.getA_file() %>">
					</td>
				</tr>
			</table>
			<div>
				<br>
			</div>

			<table class="_1q_query_tab">
				<tr>
					<td class="_1q_query_tab_4" colspan="3"><input type="text"
						name="a_title" value="<%=noticeDTO.getA_title() %>" style="border: none;"></td>
				</tr>
			</table>
			<div>
				<br>
			</div>
			<table class="_1q_query_tab">
				<tr>
					<td class="_1q_query_tab_5" colspan="3"><textarea
							name="a_content" style="border: none;" cols="110" rows="20"
							class="noresize"><%=noticeDTO.getA_content() %></textarea></td>
				</tr>
			</table>
			<div class="_1q_query_btn">
				<input type="submit" value="수정" class="modify-button">
			</div>
		</form>
		
<div class="clear"></div>
<div id="page_control"></div>



		<!--================================== 푸터 ==================================== -->
		<div class="clearfix">
			<jsp:include page="../inc/bottom.jsp"></jsp:include>
		</div>
		<!--========================= Bootstrap Core JavaScript =========================-->
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

			$().UItoTop({
				easingType : 'easeOutQuart'
			});

		});
	</script>
		<!-- //here ends scrolling icon -->
		<script src="js/minicart.min.js"></script>
		<script>
		// Mini Cart
		paypal.minicart.render({
			action : '#'
		});

		if (~window.location.search.indexOf('reset=true')) {
			paypal.minicart.reset();
		}
	</script>
		<!-- main slider-banner -->
		<script src="js/skdslider.min.js"></script>
		<link href="css/skdslider.css" rel="stylesheet">
		<script type="text/javascript">
		jQuery(document).ready(function() {
			jQuery('#demo1').skdslider({
				'delay' : 5000,
				'animationSpeed' : 2000,
				'showNextPrev' : true,
				'showPlayButton' : true,
				'autoSlide' : true,
				'animationType' : 'fading'
			});

			jQuery('#responsive').change(function() {
				$('#responsive_wrapper').width(jQuery(this).val());
			});sd

		});
	</script>
		<!-- //main slider-banner -->
</body>
</html>