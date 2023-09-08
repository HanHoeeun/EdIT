<%@page import="java.sql.ResultSet"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.itwillbs.domain.NoticePageDTO"%>
<%@page import="com.itwillbs.domain.NoticeDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<%
int m_level = 0;
if(session.getAttribute("m_level") != null){
	m_level = (int)session.getAttribute("m_level");
}

%>
<title>공지사항 일반공지</title>
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
<link href="css/faq_1_9.css" rel="stylesheet">  
<link href="css/faq_1.css" rel="stylesheet"> 
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
				<li class="active">일반공지</li>
			</ol>
		</div>
	</div>
	
<!--=========================== 본문 헤더 ========================================= -->
	<div class="top-brands_1">
		<h2>공지사항</h2>
		<div class="container_1_1">
			<div class="container_2_1">

<!--=========================== 상단 탭 리스트============================================ -->
				<%
				List<NoticeDTO> noticeList = (List<NoticeDTO>) request.getAttribute("noticeList");
				NoticePageDTO pageDTO = (NoticePageDTO) request.getAttribute("pageDTO");
				%>
				<ul class="tabs">
					<li class="tab-link current" data-tab="tab-1"
						onclick="location.href='noticelist.no'">일반공지</li>
					<li class="tab-link" data-tab="tab-2"
						onclick="location.href='eventlist.no'">이벤트</li>
					<%
					//세션값이 있으면
					if(m_level == 2){
					%>
					<li class="tab-link" data-tab="tab-3"
						onclick="location.href='noticeWrite.no'">공지글 작성</li>
					<%
						}
					%>
				</ul>
			</div>

<!--================================== 1탭 일반공지==================================== -->
			<div class="container_3_1">
				<div id="tab-1" class="tab-content current">
					<table class="_1qna_board">
						<tr>
							<th class="_1qna_board_border">번호</th>
							<th class="_1qna_board_border">제목</th>
							<th class="_1qna_board_border">작성일</th>
						</tr>
						<%
						SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");
						for (int i = 0; i < noticeList.size(); i++) {
							NoticeDTO noticeDTO = noticeList.get(i);
						%>
						<tr
							onclick="location.href='noticeContent.no?a_num=<%=noticeDTO.getA_num()%>'">
							<td class="_1qna_board_border"><%=noticeDTO.getA_num()%></td>
							<td class="_1qna_board_subject"><%=noticeDTO.getA_title()%></td>
							<td class="_1qna_board_border"><%=format.format(noticeDTO.getA_date())%></td>
						</tr>
						<%
						}
						%>
					</table>

<!--====================================== 1탭 일반공지 검색 ==================================-->
					<div class="w3l_search_1"> 
					<form action="noticelistSearch.no" method="get" id="productSearch">
						<input type="search" name="search" placeholder="" required=""
							onkeyup="enterkey();">
						<button type="submit" class="btn btn-default search_1"
							aria-label="Left Align">
							<i class="fa fa-search" aria-hidden="true"> </i>
						</button>
						<div class="clearfix"></div>
					</form>
				</div>

				<script type="text/javascript">
					function enterKey() {
						if (window.event.keyCode == 13) { // Enter 키 코드값 13
							document.getElementById('productSearch')
									.submit();
						}
					}
				</script>
				</div>
				
<!--======================================= 검색 ==========================================================-->
				<!-- <div class="w3l_search_1">
					<form action="eventlistSearch.no" method="get" id="productSearch">
						<input type="search" name="search" placeholder="" required=""
							onkeyup="enterkey();">
						<button type="submit" class="btn btn-default search_1"
							aria-label="Left Align">
							<i class="fa fa-search" aria-hidden="true"> </i>
						</button>
						<div class="clearfix"></div>
					</form>
				</div>

				<script type="text/javascript">
					function enterKey() {
						if (window.event.keyCode == 13) { // Enter 키 코드값 13
							document.getElementById('productSearch')
									.submit();
						}
					}
				</script> -->

<!--================================= 1탭 일반공지 페이징 ================================= -->
				<div class="_1qna_paging">
					<ul>
						<%
						// 시작페이지 1페이지 Prev 없음
						// 시작페이지 11,21,31 Prev가 보이게
						if (pageDTO.getStartPage() > pageDTO.getPageBlock()) {
						%>
						<li
							onclick="location.href='noticelist.no?pageNum=<%=pageDTO.getStartPage() - pageDTO.getPageBlock()%>&tab=tab-1'">Prev</li>

						<%
						}
						for (int i = pageDTO.getStartPage(); i <= pageDTO.getEndPage(); i++) {
						%>
						<li
							onclick="location.href='noticelist.no?pageNum=<%=i%>&tab=tab-1'"><%=i%></li>
						<%
						}
						// 끝페이지 번호 전체페이지수 비교 => 전체페이지 수 크면 => next보임
						if (pageDTO.getEndPage() < pageDTO.getPageCount()) {
						%>
						<li
							onclick="location.href='noticelist.no?pageNum=<%=pageDTO.getStartPage() + pageDTO.getPageBlock()%>&tab=tab-1'">Next</li>
						<%
						}
						%>
					</ul>
				</div>
			</div>
		</div>
	</div>


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