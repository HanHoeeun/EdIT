<%@page import="com.itwillbs.domain.AdminPageDTO"%>
<%@page import="com.itwillbs.domain.ReportDTO"%>
<%@page import="com.itwillbs.domain.WishListDTO"%>
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
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/font-awesome.css" rel="stylesheet"> 
<link href="css/mypage_3.css" rel="stylesheet"> 
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
</head>	
<body>
<!-- 신고내역부분 -->
<%
List<ReportDTO> reportList = (List<ReportDTO>)request.getAttribute("reportList");
AdminPageDTO pageDTO = (AdminPageDTO)request.getAttribute("pageDTO");
SimpleDateFormat format =new SimpleDateFormat("yyyy.MM.dd");
%>	

<!--================================== 헤더 ==================================== -->
<jsp:include page="../inc/top.jsp"></jsp:include>
	
<!--=========================== 상단 네비 ============================================ -->
	<div class="breadcrumbs">
		<div class="container">
			<ol class="breadcrumb breadcrumb1 animated wow slideInLeft" data-wow-delay=".5s">
				<li><a href="index.html"><span class="glyphicon glyphicon-home" aria-hidden="true"></span>홈</a></li>
				<li class="active">마이페이지</li>
				<li class="active">신고내역</li>
			</ol>
		</div>
	</div>
<!--=========================== 본문 헤더 =========================================== -->	
	<div class="top-brands_1">
		<h2>마이페이지</h2>
			<div class="container_2_1">

<!--=========================== 상단 탭 리스트============================================ -->
				<ul class="tabs">
					<li class="tab-link " onclick="location.href='update.me'">나의정보</li>
					<li class="tab-link" onclick="location.href='buylist.po'">전체판매목록</li>
					<li class="tab-link" onclick="location.href='buylist2.po'">판매완료목록</li>
					<li class="tab-link" onclick="location.href='m_wishlist.me'">찜</li>
					<li class="tab-link current" onclick="location.href='m_adminpage.me'">신고내역</li>
				</ul>
			</div>
		

<!--================================== 6탭 신고내역 ==================================== -->		
	<div class="container_3_1">
				<div id="tab-6" class="tab-content current">  
					<table class="_1qna_board_1">
						<tr>
							<th class="_1qna_board_border">신고번호</th>
							<th class="_1qna_board_border">회원번호</th>
							<th class="_1qna_board_subject">제목</th>
							<th class="_1qna_board_border">작성시간</th>
							<th>확인여부</th>
						</tr>
<!-- 				admin 참고 -->
						<%for(ReportDTO reportDTO : reportList) {
							String check = reportDTO.getR_check() == 0 ? "x" : "o";					
						%>
						<tr onclick="window.open('reportContent.ad?r_num=<%=reportDTO.getR_num() %>','신고상세페이지','width=800, height=700, scrollbars=yes')">
							<td class="_1qna_board_border"><%=reportDTO.getR_num() %></td>
							<td class="_1qna_board_border"><%=reportDTO.getR_m_num() %></td>
							<td class="_1qna_board_subject"><%=reportDTO.getR_title() %></td>
							<td class="_1qna_board_border"><%=format.format(reportDTO.getR_date()) %></td>
							<td><%=check %></td>
						</tr>
						<%} %>
						
					</table>
<!-- 				페이징 -->
				    <div class="_1qna_paging">
        				 <ul>
					<%
					// 시작페이지 1페이지 Prev 없음
					// 시작페이지 11,21,31 Prev가 보이게
							if(pageDTO.getStartPage() > pageDTO.getPageBlock()){%>
							<li onclick="location.href='m_adminpage.me?pageNum=<%=pageDTO.getStartPage()-pageDTO.getPageBlock()%>&tab=tab-6'">Prev</li>
						<% } 
						for(int i= pageDTO.getStartPage(); i<=pageDTO.getEndPage(); i++){%>
							<li onclick="location.href='m_adminpage.me?pageNum=<%=i%>&tab=tab-6'"><%=i %></li>
						<%}
						// 끝페이지 번호 전체페이지수 비교 => 전체페이지 수 크면 => next보임
						if(pageDTO.getEndPage() < pageDTO.getPageCount()){%>
							<li onclick="location.href=''m_adminpage.me?pageNum=<%=pageDTO.getStartPage() + pageDTO.getPageBlock() %>&tab=tab-6'">Next</li>
						<%}%>
				    </ul>
				</div>
				</div>
</div>

				
				
<!-- -----------------------------------------------------------------------------				 -->
<!-- <script type="text/javascript" src="script/jquery-3.7.0.js"></script> --> 

				
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