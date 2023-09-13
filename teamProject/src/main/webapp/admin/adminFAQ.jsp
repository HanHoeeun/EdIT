<%@page import="com.itwillbs.domain.AdminDTO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.itwillbs.domain.AdminPageDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%
//	관리자만 관리자 문의 게시판 접근 가능  
	int m_level = 0;
	if (session.getAttribute("m_level") != null) {
		m_level = (int) session.getAttribute("m_level");
		if (m_level != 2) {
			response.sendRedirect("main.me");
			return ;
		}
	}
	List<AdminDTO> adminList = (List<AdminDTO>) request.getAttribute("adminList");
	AdminPageDTO pageDTO = (AdminPageDTO) request.getAttribute("pageDTO");
	SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");
	%>
<title>문의내역 관리자</title>
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
<link href="css/faq_1.css" rel="stylesheet">
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
</head>
<body>
	
	<!-- header -->
	<jsp:include page="../inc/top.jsp"></jsp:include>
	<!-- //header -->
	<div class="breadcrumbs">
		<div class="container">
			<ol class="breadcrumb breadcrumb1 animated wow slideInLeft"
				data-wow-delay=".5s">
				<li><a href="index.html"><span
						class="glyphicon glyphicon-home" aria-hidden="true"></span>홈</a></li>
				<li class="active">관리자 페이지</li>
			</ol>
		</div>
	</div>

	<div class="top-brands">
		<h2>관리자 페이지</h2>
		<div class="container_1_1">
			<div class="container_2_1">
				<!-- 				상단 탭 리스트 -->
				<ul class="tabs">
					<li class="tab-link" onclick="location.href='adminPage.ad'">신고내역</li>
					<li class="tab-link current" onclick="location.href='adminFAQ.ad'">문의내역</li>
					<li class="tab-link" onclick="location.href='adminMemberPage.ad'">회원관리</li>
					<li class="tab-link" onclick="location.href='adminBlackPage.ad'">블랙리스트</li>

				</ul>
			</div>
			<div class="container_3_1">
				<div id="tab-3" class="tab-content current">
					<!-- 				3탭 게시판 테이블  -->
					<table class="_1qna_board">
						<tr>
							<th class="_1qna_board_border"><select id="faqSelect"
								class="faqSelect" name="faq_select"
								style="border: none; text-align: center">
									<option value="전체">전체</option>
									<option value="계정">계정</option>
									<option value="중고거래">중고거래</option>
									<option value="기타">기타</option>
							</select></th>
							<th class="_1qna_board_border">번호</th>
							<th class="_1qna_board_subject">제목</th>
							<th class="_1qna_board_border">작성자</th>
							<th class="_1qna_board_border">작성시간</th>
							<th class="_1qna_board_border">답변여부</th>
						</tr>
						<%
						for (AdminDTO adminDTO : adminList) {
							String a_check = adminDTO.getA_check() == 0 ? "x" : "o";
						%>
						<tr
							onclick="window.open('faqContent.ad?a_num=<%=adminDTO.getA_num()%>','문의상세페이지','width=800, height=700, scrollbars=yes')">
							<td class="_1qna_board_border"><%=adminDTO.getA_cs_type()%></td>
							<td class="_1qna_board_border"><%=adminDTO.getA_num()%></td>
							<td class="_1qna_board_subject"><%=adminDTO.getA_title()%></td>
							<td class="_1qna_board_border"><%=adminDTO.getA_m_nick()%></td>
							<td class="_1qna_board_border"><%=format.format(adminDTO.getA_date())%></td>
							<td><%=a_check%></td>
						</tr>
						<%
						}
						%>
					</table>
					<!-- 				3탭 페이징  -->
					<div class="_1qna_paging">
						<ul>
							<%
							// 시작페이지 1페이지 Prev 없음
							// 시작페이지 11,21,31 Prev가 보이게
							if (pageDTO.getStartPage() > pageDTO.getPageBlock()) {
							%>
							<li
								onclick="location.href='adminFAQ.ad?pageNum=<%=pageDTO.getStartPage() - pageDTO.getPageBlock()%>&select=<%=pageDTO.getSearch()%>'">Prev</li>

							<%
							}
							for (int i = pageDTO.getStartPage(); i <= pageDTO.getEndPage(); i++) {
							%>
							<li
								onclick="location.href='adminFAQ.ad?pageNum=<%=i%>&select=<%=pageDTO.getSearch()%>'"><%=i%></li>
							<%
							}
							// 끝페이지 번호 전체페이지수 비교 => 전체페이지 수 크면 => next보임
							if (pageDTO.getEndPage() < pageDTO.getPageCount()) {
							%>
							<li
								onclick="location.href='adminFAQ.ad?pageNum=<%=pageDTO.getStartPage() + pageDTO.getPageBlock()%>&select=<%=pageDTO.getSearch()%>'">Next</li>
							<%
							}
							%>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<div class="clearfix_1_1"></div>
	</div>

	<!-- //footer -->
	<jsp:include page="../inc/bottom.jsp"></jsp:include>
	<script src="js/bootstrap.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {

			$().UItoTop({
				easingType : 'easeOutQuart'
			});
		});
	</script>

	<script type="text/javascript">
		var selectElement = document.getElementById("faqSelect");

		selectElement.addEventListener("change", function() {
			var selectedValue = selectElement.value;

			location.href = 'adminFAQ.ad?select=' + selectedValue
		});
	</script>
</body>
</html>