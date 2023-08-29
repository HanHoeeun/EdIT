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
<title>공지사항</title>
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
<link href="../css/faq_1_9.css" rel="stylesheet"> 
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
				<li class="active">공지사항</li>
			</ol>
		</div>
	</div><br><br>
<!--=========================== 본문 헤더 =========================================== -->	
	<div class="../top-brands_1">
		<h2>공지사항</h2>
		<div class="container_1_1">
			<div class="container_2_1">

<!--=========================== 상단 탭 리스트============================================ -->
				<ul class="tabs">
					<li class="tab-link current" data-tab="tab-1">일반공지</li>
					<li class="tab-link" data-tab="tab-2">이벤트</li>
					<%if(1==1){ %>
					<li class="tab-link" data-tab="tab-3">글 작성</li>
					<%} %>
				</ul>
			</div>
<!--================================== 1탭 일반공지==================================== -->
<%
List<NoticeDTO> noticeList = (List<NoticeDTO>)request.getAttribute("noticeList");
NoticePageDTO pageDTO=(NoticePageDTO)request.getAttribute("pageDTO");
%>	
			<div class="container_3_1">
				<div id="tab-1" class="tab-content current">
				<table class="_1qna_board">
						<tr>
							<th class="_1qna_board_border">번호</th>
							<th class="_1qna_board_border">제목</th>
							<th class="_1qna_board_border">작성일</th>
						</tr>
 <%
SimpleDateFormat format =new SimpleDateFormat("yyyy.MM.dd");
    for(int i=0;i<noticeList.size();i++){
    	NoticeDTO noticeDTO=noticeList.get(i);
    	%>	
						 <tr onclick="location.href='content.no?num=<%=noticeDTO.getA_num()%>'">
							<td class="_1qna_board_border"><%=noticeDTO.getA_num() %></td>
							<td class="_1qna_board_subject"><%=noticeDTO.getA_title() %></td>
							<td class="_1qna_board_border"><%=format.format(noticeDTO.getA_date()) %></td>
						</tr>
						<%
    }
    %>
					</table>
					<!--============= 1탭 일반공지 페이징 ==================== -->
					<div class="_1qna_paging">
						<% if(pageDTO.getStartPage() > pageDTO.getPageBlock()){ %>
						<a
							href="list.no?pageNum=<%=pageDTO.getStartPage()-pageDTO.getPageBlock()%>">◀</a>
						<%
}
%>

						<%
for(int i=pageDTO.getStartPage();i<=pageDTO.getEndPage();i++){
	%>
						<a href="list.no?pageNum=<%=i%>"><%=i %></a>
						<%
}
%>

						<%
//끝페이지번호  전체페이지수 비교 => 전체페이지수 크면 => Next보임
if(pageDTO.getEndPage() < pageDTO.getPageCount()){
	%>
						<a
							href="list.no?pageNum=<%=pageDTO.getStartPage()+pageDTO.getPageBlock()%>">▶</a>
						<%
}
%>
						<!-- <ul>
							<li onclick="location.href='index.html'">◀</li>
							<li onclick="location.href='about.html'">1</li>
							<li onclick="location.href='login.html'">2</li>
							<li onclick="location.href='faq.html'">3</li>
							<li onclick="location.href='gourmet.html'">4</li>
							<li onclick="location.href='login.html'">5</li>
							<li onclick="location.href='products.html'">▶</li>
						</ul> -->
					</div>

				</div>
<!--================================== 2탭 이벤트 ==================================== -->				
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
				    <% if(pageDTO.getStartPage() > pageDTO.getPageBlock()){ %>
						<a
							href="list.no?pageNum=<%=pageDTO.getStartPage()-pageDTO.getPageBlock()%>">◀</a>
						<%
}
%>

						<%
for(int i=pageDTO.getStartPage();i<=pageDTO.getEndPage();i++){
	%>
						<a href="list.no?pageNum=<%=i%>"><%=i %></a>
						<%
}
%>

						<%
//끝페이지번호  전체페이지수 비교 => 전체페이지수 크면 => Next보임
if(pageDTO.getEndPage() < pageDTO.getPageCount()){
	%>
						<a
							href="list.no?pageNum=<%=pageDTO.getStartPage()+pageDTO.getPageBlock()%>">▶</a>
						<%
}
%>
        				<!-- <ul>
				           <li onclick="location.href='index.html'">◀</li>
				           <li onclick="location.href='about.html'">1</li>
				           <li onclick="location.href='login.html'">2</li>
				           <li onclick="location.href='faq.html'">3</li>
				           <li onclick="location.href='gourmet.html'">4</li>
				           <li onclick="location.href='login.html'">5</li>
				           <li onclick="location.href='products.html'">▶</li>
						</ul> -->
   					 </div>
				</div>
<!--================================== 3탭 글작성 ==================================== -->
				<%
String a_m_num = (String)session.getAttribute("a_m_num");
if(a_m_num != null){
	%>
				<div id="tab-3" class="tab-content">
					<form action="index.html" method="post" enctype="multipart/form-data">
						<table class="_1q_query_tab">
							<tr>
							<td class="_1q_query_tab_1">
								<select class="_1q_query_tab_sel" style="border:none;">
									<option value="">유형</option>
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