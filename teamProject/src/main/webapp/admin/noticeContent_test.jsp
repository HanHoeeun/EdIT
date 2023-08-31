<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.itwillbs.domain.NoticePageDTO"%>
<%@page import="com.itwillbs.domain.NoticeDTO"%>
<%@page import="java.util.List"%>
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
<title>공지사항 게시물</title>
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
<link href="css/style_1_2_1.css" rel="stylesheet" type="text/css" media="all" />
<!-- font-awesome icons -->
<link href="css/font-awesome.css" rel="stylesheet"> 
<link href="css/faq_1_9.css" rel="stylesheet"> 
<!-- //font-awesome icons -->
<!-- js -->
<script src="js/jquery-1.11.1.min.js"></script>
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
				<li class="active">공지사항</li>
			</ol>
		</div>
	</div><br><br>
	
<!--=========================== 본문 헤더 ========================================= -->	
	
	<div class="../top-brands_1">
		<h2>공지사항</h2>
		<div class="container">
			<div class="container_2_1">
<!--================================== 공지사항 게시물 ==================================== -->
				<%
				String id = (String) session.getAttribute("id");
				NoticeDTO noticeDTO = (NoticeDTO) request.getAttribute("noticeDTO");
				SimpleDateFormat format =new SimpleDateFormat("yyyy.MM.dd");
				%>
				<article>
				<h1><%=noticeDTO.getA_title()%></h1><!-- 제목 -->
				<table>
				<tr><td><%=format.format(noticeDTO.getA_date())%></td></tr><!-- 작성일 -->
				<tr><td><a href="upload/<%=noticeDTO.getA_file()%>" download>
						<%=noticeDTO.getA_file()%></a> 
						<img src="upload/<%=noticeDTO.getA_file()%>" width="200" height="200"></td></tr><!--첨부파일-->
				<tr><td><%=noticeDTO.getA_content()%></td></tr><!-- 내용 -->
				</table>
				
						<div id="table_search">
							<%
							// 로그인, 글쓴이 일치
							if (1==1){ %>
							<input type="button" value="수정" class="btn"
								onclick="location.href='update.no?a_num=<%=noticeDTO.getA_num()%>'">
							<input type="button" value="삭제" class="btn"
								onclick="location.href='delete.no?a_num=<%=noticeDTO.getA_num()%>'">
							<input type="button" value="파일 수정" class="btn"
								onclick="
								location.href='fupdate.no?a_num=<%=noticeDTO.getA_num()%>'">
							<%	}
							 %>
							<input type="button" value="목록" class="btn"
								onclick="location.href='list.no?tab=tab-1'">
						</div>


						<div class="clear"></div>
						<div id="page_control"></div>
					
				</div></article> 
				
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
//                 $('ul.tabs li').click(function(){
//                     var tab_id = $(this).attr('data-tab');

//                     $('ul.tabs li').removeClass('current');
//                     $('.tab-content').removeClass('current');

//                     $(this).addClass('current');
//                     $("#"+tab_id).addClass('current');
//                 })


            </script>
			</div>
		</div>
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