<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.itwillbs.domain.NoticePageDTO"%>
<%@page import="com.itwillbs.domain.NoticeDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>공지사항 글 작성</title>
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
<script type="text/javascript" src="../js/move-top.js"></script>
<script type="text/javascript" src="../js/easing.js"></script>
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
				<li class="active">공지글 작성</li>
			</ol>
		</div>
	</div>
<!--=========================== 본문 헤더 ========================================= -->

	<div class="top-brands_1">
		<h2>공지사항</h2>
		<div class="container_1_1">
			<div class="container_2_1">
<!--=========================== 상단 탭 리스트============================================ -->
				<ul class="tabs">
					<li class="tab-link current" data-tab="tab-1">일반공지</li>
					<li class="tab-link" data-tab="tab-2">이벤트</li>
					<%
					if (1 == 1) {
					%>
					<li class="tab-link" data-tab="tab-3">공지글 작성</li>
					<%
					}
					%>
				</ul>
			</div>

<!--================================== 3탭 공지글 작성 ==================================== -->
			<%
			if (1 == 1) {
			%>
			<div id="tab-3" class="tab-content">
				<form action="write.no" method="post" enctype="multipart/form-data">
					<table class="_1q_query_tab">
						<tr>
							<td class="_1q_query_tab_1"><select
								class="_1q_query_tab_sel" name="a_notice_type"
								style="border: none;">
									<option value="1">일반공지</option>
									<option value="2">이벤트</option>
							</select></td>
							<td>
								<div class="_1q_query_tab_3">
									<label for="imgfile"><img src="images/picture.png"
										width="25px" height="25px">첨부파일</label>
								</div> <input type="file" name="a_file" id="imgfile" accept="image/*">
							</td>
						</tr>
					</table>
					<div>
						<br>
					</div>

					<table class="_1q_query_tab">
						<tr>
							<td class="_1q_query_tab_4" colspan="3"><input type="text"
								name="a_title" placeholder="제목을 작성 해주세요" style="border: none;"></td>
						</tr>
					</table>
					<div>
						<br>
					</div>
					<table class="_1q_query_tab">
						<tr>
							<td class="_1q_query_tab_5" colspan="3"><textarea
									name="a_content" style="border: none;" cols="110" rows="20"
									class="noresize" placeholder="내용을 작성 해주세요"></textarea></td>
						</tr>
					</table>
					<div class="_1q_query_btn">
						<button type="submit">작성</button>
						<button type="reset">취소</button>
					</div>
				</form>
			</div>
			<%
			}
			%>
<!--====================================== 탭 jquery =================================-->
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
		</div>
	</div>
	<div class="clearfix_1_1"> </div>
	<!--================================== 푸터 ==================================== -->
	<jsp:include page="../inc/bottom.jsp"></jsp:include>

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

			$().UItoTop({
				easingType : 'easeOutQuart'
			});

		});
	</script>
	<!-- //here ends scrolling icon -->
	<script src="../js/minicart.min.js"></script>
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
	<script src="../js/skdslider.min.js"></script>
	<link href="../css/skdslider.css" rel="stylesheet">
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