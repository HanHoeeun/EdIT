<%@page import="java.text.SimpleDateFormat"%>
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
<title>공지사항 상세게시물</title>
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
				<li class="active">일반공지</li>
			</ol>
		</div>
	</div>
<!--=========================== 본문 헤더 =========================================== -->
	<div class="top-brands_1">
		<h2>일반공지</h2>
		</div>
	<!--=========================== 본문 =========================================== -->
    <div class="container_notice">
			<%
			/* String id = (String) session.getAttribute("id"); */
			NoticeDTO noticeDTO = (NoticeDTO) request.getAttribute("noticeDTO");
			SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");
			%>
			<h1><%=noticeDTO.getA_title()%></h1>
        <p class="author"><%=format.format(noticeDTO.getA_date())%></p>
       
       
       
       <!--============================ 첨부파일==================================  -->
        <hr>
        <div class="attachment-section">
        <% /* 첨부파일이 없으면 본문에 안보이게 */
    String attachmentFile = noticeDTO.getA_file();
    if (attachmentFile != null && !attachmentFile.isEmpty()) {
%>
    <p>
        첨부 파일 
        <a href="upload/<%= attachmentFile %>" download>
            <%= attachmentFile %>
        </a> <br>
        <img src="upload/<%= attachmentFile %>" >
    </p>
<%
    }
%>
   		 </div>
        <p><%=noticeDTO.getA_content()%></p>

			<%
			// 로그인, 글쓴이 일치
			if (1==1){ %>
			<hr>
			<input type="button" value="수정" class="modify-button" onclick="location.href='update.no?a_num=<%=noticeDTO.getA_num()%>'">
			<input type="button" value="삭제" class="delete-button" onclick="location.href='delete.no?a_num=<%=noticeDTO.getA_num()%>'">
			<%} %>
			<input type="button" value="목록" class="list-button" onclick="location.href='noticelist.no?tab=tab-1'">
			
		</div>
	<div class="clear"></div>
	<div id="page_control"></div>
    <script>
    </script>
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
			});

		});
	</script>
	<!-- //main slider-banner -->
</body>
</html>