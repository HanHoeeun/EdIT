<%@page import="com.itwillbs.domain.MemberDTO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.itwillbs.domain.AdminPageDTO"%>
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
<title>Super Market an Ecommerce Online Shopping Category Flat Bootstrap Responsive Website Template | Faq :: w3layouts</title>
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
<!-- start-smoth-scrolling -->
</head>
	
<body>
<%
List<MemberDTO> blackList = (List<MemberDTO>)request.getAttribute("blackList");
AdminPageDTO pageDTO = (AdminPageDTO)request.getAttribute("pageDTO");

%>
<!-- header -->
<jsp:include page="../inc/top.jsp"></jsp:include>
<!-- //header -->
	<!-- breadcrumbs -->
	<div class="breadcrumbs">
		<div class="container">
			<ol class="breadcrumb breadcrumb1 animated wow slideInLeft" data-wow-delay=".5s">
				<li><a href="index.html"><span class="glyphicon glyphicon-home" aria-hidden="true"></span>Home</a></li>
				<li class="active">AdminPage</li>
			</ol>
		</div>
	</div>
	<!-- //breadcrumbs -->
	<!-- top-brands -->
	
	<div class="top-brands">
		<h2>관리자 페이지</h2>
		<div class="container_1_1">
			<div class="container_2_1">
<!-- 				상단 탭 리스트 -->
				<ul class="tabs">
					<li class="tab-link" onclick="location.href='adminPage.ad'" >신고내역</li>
					<li class="tab-link" onclick="location.href='adminMemberPage.ad'">회원관리</li>
					<li class="tab-link current" onclick="location.href='adminBlackPage.ad'">블랙리스트</li>
					
				</ul>
			</div>
			<div class="container_3_1">
<!-- 				2번째 탭 -->
				<div id="tab-3" class="tab-content current">
					<table class="_1qna_board">
						<tr>
							<th class="_1qna_board_border">아이디</th>
							<th class="_1qna_board_border">이름</th>
							<th class="_1qna_board_border">이메일</th>
							<th class="_1qna_board_border">전화번호</th>
						</tr>
						<%for(MemberDTO memberDTO : blackList){ %>
						<tr onclick="window.open('user_content.ad?m_num=<%=memberDTO.getM_num() %>','회원정보 상세','width=800, height=700, scrollbars=yes')">
							<td class="_1qna_board_border"><%=memberDTO.getM_id() %></td>
							<td class="_1qna_board_border"><%=memberDTO.getM_name() %></td>
							<td class="_1qna_board_border"><%=memberDTO.getM_email() %></td>
							<td class="_1qna_board_border"><%=memberDTO.getM_phone() %></td>
						</tr>
						<%} %>
					</table>
					<div class="_1qna_paging">
        				 <ul>
					<%	
						if(pageDTO.getStartPage() > pageDTO.getPageBlock()){%> 
							<li onclick="location.href='adminBlackPage.ad?pageNum=<%=pageDTO.getStartPage()-pageDTO.getPageBlock()%>&search=<%=pageDTO.getSearch()%>'">Prev</li>
							
						<% } 
						for(int i= pageDTO.getStartPage(); i<=pageDTO.getEndPage(); i++){%> 
							<li onclick="location.href='adminBlackPage.ad?pageNum=<%=i%>&search=<%=pageDTO.getSearch()%>'"><%=i %></li>
						<%}
						if(pageDTO.getEndPage() < pageDTO.getPageCount()){%> 
							<li onclick="location.href='adminBlackPage.ad?pageNum=<%=pageDTO.getStartPage() + pageDTO.getPageBlock() %>&search=<%=pageDTO.getSearch()%>'">Next</li>
						<%}%>
				    </ul>
   					 </div>
					<!-- 					검색테이블  -->
					<form action="adminBlackPage.ad" method="post" id="_1admin_search_form">
						<table class="_1admin_search">
						<tr>
							<td>
								<select>
									<option value="1">아이디</option>
									<option value="2">이름</option>
									<option value="3">이메일</option>
								</select>
							</td>
							<td>
								<input type="text" name="search" onkeyup="enterKey();"> 
							</td>
							<td>
								<input type="submit" value="검색">
							</td>
						</tr>
						</table>
					</form>
					<script type="text/javascript">
						function enterKey(){
							if(window.event.keyCode == 13){ // Enter 키 코드값 13
								document.getElementById('_1admin_search_form').submit();
							}
						}
					</script>
				    	
   				</div>
			</div>
		</div>
			<div class="clearfix_1_1"> </div>
	</div>
<!-- //top-brands -->
<!-- //footer -->
<jsp:include page="../inc/bottom.jsp"></jsp:include>
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