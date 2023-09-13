<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.itwillbs.domain.AdminDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.itwillbs.domain.AdminPageDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<%
String m_id = (String) session.getAttribute("m_id");
List<AdminDTO> adminList = null;
AdminPageDTO pageDTO = null;
	if(m_id != null){
		adminList = (List<AdminDTO>) request.getAttribute("adminList");
		pageDTO = (AdminPageDTO) request.getAttribute("pageDTO");
	}

SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");
%>
<title>고객센터</title>
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
<link href="css/style_1_2.css" rel="stylesheet" type="text/css"
	media="all" />
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
	<!-- header -->
	<div class="breadcrumbs">
		<div class="container">
			<ol class="breadcrumb breadcrumb1 animated wow slideInLeft"
				data-wow-delay=".5s">
				<li><a href="index.html"><span
						class="glyphicon glyphicon-home" aria-hidden="true"></span>홈</a></li>
				<li class="active">고객센터</li>
			</ol>
		</div>
	</div>

	<div class="top-brands_1">
		<h2>고객센터</h2>
		<div class="container_1_1">
			<div class="container_2_1">
				<!-- 				상단 탭 리스트 -->
				<ul class="tabs">
					<li class="tab-link current" data-tab="tab-1">자주 묻는 질문</li>
					<%
					if (m_id != null) {
					%>
					<li class="tab-link" data-tab="tab-2">문의 하기</li>
					<li class="tab-link" data-tab="tab-3">내 문의 내역</li>
					<%
					}
					%>
				</ul>
			</div>
			<div class="container_3_1">
				<div id="tab-1" class="tab-content current">
					<ul class="faq_1">
						<li class="item01"><a href="#" title="click here">1. 고객센터 문의는 어떻게 하나요?</a>
							<ul>
								<li class="subitem1"><p>로그인 후에 고객센터 문의가 가능합니다.</p></li>
							</ul></li>
						<li class="item02"><a href="#" title="click here">2. 물건 등록은
								어떻게 하나요?</a>
							<ul>
								<li class="subitem1"><p>회원 가입 후, 물건을
										등록할 수 있는 기능을 제공합니다. 로그인 후에 등록 절차를 따라서 물건을 등록할 수 있습니다.</p></li>
							</ul></li>
						<li class="item03"><a href="#" title="click here">3. 물건을 팔려면
								어떤 정보를 제공해야 하나요?</a>
							<ul>
								<li class="subitem1"><p>판매하려는 물건의 사진, 제목, 가격, 설명 등 필요한
										정보를 입력해야 합니다. 물건의 상태와 가격은 정확하게 기재하는 것이 중요합니다.</p></li>
							</ul></li>
						<li class="item04"><a href="#" title="click here">4. 물건 가격을
								어떻게 정해야 하나요?</a>
							<ul>
								<li class="subitem1"><p>시장 가격 조사를 통해 유사한 물건의 가격을 확인하고,
										물건의 상태, 브랜드, 모델 등을 고려하여 합리적인 가격을 설정하세요.</p></li>
							</ul></li>
						<li class="item05"><a href="#" title="click here">5. 거래 방법은
								어떤 것이 있나요?</a>
							<ul>
								<li class="subitem1"><p>직거래와 택배거래 두 가지 주요
										방법을 사용합니다. 어떤 방법을 사용할지 판매자와 구매자가 합의해야 합니다.</p></li>
							</ul></li>
						<li class="item06"><a href="#" title="click here">6. 안전한 거래를
								위해 어떤 주의사항이 있나요?</a>
							<ul>
								<li class="subitem1"><p>안전한 거래를 위해 공공장소에서 직거래를 하거나, 항상
										신뢰할 수 있는 결제 방법을 사용하세요. 또한 사기나 사기꾼을 피하기 위한 주의사항을 알고 있어야 합니다.</p></li>
							</ul></li>
						<li class="item07"><a href="#" title="click here">7. 가격을 깎을 수
								있나요?</a>
							<ul>
								<li class="subitem1"><p>판매자와 구매자 간의 협상이 가능합니다. 가격을 깍으려면
										상대방과 합리적인 가격에 대해 협상해야 합니다.</p></li>
							</ul></li>
						<li class="item08"><a href="#" title="click here">8. 상품의 상태를
								어떻게 확인하나요?</a>
							<ul>
								<li class="subitem1"><p>사진을 통해 상품의 상태를 확인할 수 있고, 직거래인
										경우에는 직접 상태를 확인할 수 있습니다.</p></li>
							</ul></li>
						<li class="item09"><a href="#" title="click here">9. 신고 기능을
								어떻게 사용하나요?</a>
							<ul>
								<li class="subitem1"><p>부적절한 게시물이나 사용자를 신고하려면 중고거래
										사이트에서 제공하는 신고 기능을 사용하세요.</p></li>
							</ul></li>
						<li class="item10"><a href="#" title="click here">10. 판매자나 구매자 사기를 당한 경우 어떻게 대처해야 하나요?</a>
							<ul>
								<li class="subitem1"><p>사기를 당한 경우 즉시 플랫폼의 고객센터나 신고 기능을 통해 도움을 요청하세요.</p></li>
							</ul></li>
						<li class="item11"><a href="#" title="click here">11. 물건 판매 시 수수료가 부과되나요?</a>
							<ul>
								<li class="subitem1"><p>저희 Edit은 판매자 구매자에게 수수료를 부과하지 않습니다.</p></li>
							</ul></li>
						<li class="item11"><a href="#" title="click here">12. 물건 등록에 필요한 최소 사진 수는 어떻게 되나요?</a>
							<ul>
								<li class="subitem1"><p>현재 최소, 최대 1장의 사진을 등록 가능합니다. 추후 여러장의 사진을 등록할 수 있도록 업데이트 예정입니다.</p></li>
							</ul></li>
					</ul>
					<!-- script for tabs -->
					<script type="text/javascript">
						$(function() {

							var menu_ul = $('.faq_1 > li > ul'), menu_a = $('.faq_1 > li > a');

							menu_ul.hide();

							menu_a.click(function(e) {
								e.preventDefault();
								if (!$(this).hasClass('active')) {
									menu_a.removeClass('active');
									menu_ul.filter(':visible')
											.slideUp('normal');
									$(this).addClass('active').next().stop(
											true, true).slideDown('normal');
								} else {
									$(this).removeClass('active');
									$(this).next().stop(true, true).slideUp(
											'normal');
								}
							});

						});
					</script>
					<!-- script for tabs -->
				</div>
				<%
				if (m_id != null) {
				%>
				<div id="tab-2" class="tab-content">
					<!-- 				2탭 문의글 작성 -->
					<form action="faqWritePro.ad" method="post"
						enctype="multipart/form-data">
						<table class="_1q_query_tab">
							<tr>
								<td class="_1q_query_tab_1"><select
									class="_1q_query_tab_sel" name="faq_select"
									style="border: none;">
										<option value="기타">문의선택</option>
										<option value="계정">계정</option>
										<option value="중고거래">중고거래</option>
										<option value="기타">기타</option>
								</select></td>
								<td class="_1q_query_tab_2"><input type="text" name="m_id"
									value="<%=m_id%>" style="border: none;" readonly="readonly"></td>
								<td>
									<div class="_1q_query_tab_3">
										<label for="imgfile" id="fileLabel"><img
											src="images/picture.png" width="25px" height="25px">파일
											업로드</label>
									</div> <input type="file" name="imgfile" id="imgfile"
									accept="image/*">
								</td>
							</tr>
						</table>
						<script>
							const fileInput = document
									.getElementById('imgfile');
							const fileLabel = document
									.getElementById('fileLabel');

							fileInput
									.addEventListener(
											'change',
											function() {
												const selectedFileName = fileInput.files[0].name;
												fileLabel.textContent = selectedFileName;
											});
						</script>
						<div>
							<br>
						</div>
						<table class="_1q_query_tab">
							<tr>
								<td class="_1q_query_tab_4" colspan="3"><input type="text"
									name="subject" placeholder="제목을 작성 해주세요" required="required"
									style="border: none;"></td>
							</tr>
						</table>
						<div>
							<br>
						</div>
						<table class="_1q_query_tab">
							<tr>
								<td class="_1q_query_tab_5" colspan="3"><textarea
										name="content" style="border: none;" cols="110" rows="20"
										class="noresize" placeholder="내용을 작성 해주세요" required="required"></textarea></td>
							</tr>
						</table>
						<div class="_1q_query_btn">
							<button type="submit">작성</button>
							<button type="reset">취소</button>
						</div>
					</form>
				</div>

				<div id="tab-3" class="tab-content">
					<!-- 				3탭 게시판 테이블  -->
					<table class="_1qna_board">
						<tr>
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
								onclick="location.href='faq.ad?pageNum=<%=pageDTO.getStartPage() - pageDTO.getPageBlock()%>&tab=tab-3'">Prev</li>

							<%
							}
							for (int i = pageDTO.getStartPage(); i <= pageDTO.getEndPage(); i++) {
							%>
							<li onclick="location.href='faq.ad?pageNum=<%=i%>&tab=tab-3'"><%=i%></li>
							<%
							}
							// 끝페이지 번호 전체페이지수 비교 => 전체페이지 수 크면 => next보임
							if (pageDTO.getEndPage() < pageDTO.getPageCount()) {
							%>
							<li
								onclick="location.href='faq.ad?pageNum=<%=pageDTO.getStartPage() + pageDTO.getPageBlock()%>&tab=tab-3'">Next</li>
							<%
							}
							%>
						</ul>
					</div>
				</div>
				<%
				}
				%>
			</div>
			<!-- 			탭 jquery -->
			<script type="text/javascript">
				$(document).ready(
						function() {
							$('ul.tabs li').click(
									function() {
										var tab_id = $(this).attr('data-tab');

										$('ul.tabs li').removeClass('current');
										$('.tab-content')
												.removeClass('current');

										$(this).addClass('current');
										$("#" + tab_id).addClass('current');

										// Add parameter to URL
										var url = window.location.href
												.split('?')[0];
										history.pushState(null, null, url
												+ '?tab=' + tab_id);
									});

							// Check URL for tab parameter on page load
							var urlParams = new URLSearchParams(
									window.location.search);
							if (urlParams.has('tab')) {
								var tabParam = urlParams.get('tab');
								$('.tabs li').removeClass('current');
								$('.tab-content').removeClass('current');
								$('[data-tab="' + tabParam + '"]').addClass(
										'current');
								$('#' + tabParam).addClass('current');
							}
						});
			</script>
		</div>
	</div>
	<div class="clearfix_1_1"></div>
	<!-- //footer -->
	<jsp:include page="../inc/bottom.jsp"></jsp:include>
	<!-- //footer -->
	<script src="js/bootstrap.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {

			$().UItoTop({
				easingType : 'easeOutQuart'
			});

		});
	</script>
</body>
</html>