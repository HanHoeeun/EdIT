<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html> 
<head>
<title>bottom</title>
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
<div class="footer">
		<div class="container">
			<div class="w3_footer_grids">
				<div class="col-md-3 w3_footer_grid">
					<h3>Contact</h3>
					
					<ul class="address">
						<li><i class="glyphicon glyphicon-map-marker" aria-hidden="true"></i>부산광역시 부산진구 동천로 109,<br>삼한골든게이트빌딩 7층</span></li>
						<li><i class="glyphicon glyphicon-info-sign" aria-hidden="true"></i>사업자 등록번호 507-85-07103</li>
						<li><i class="glyphicon glyphicon-chevron-right" aria-hidden="true"></i>대표자 조인형</li>
						<li><i class="glyphicon glyphicon-chevron-right" aria-hidden="true"></i>개인정보책임자 김정현</li>
						<li><i class="glyphicon glyphicon-earphone" aria-hidden="true"></i>051-803-0909</li>
					</ul>
				</div>
				
				<div class="col-md-3 w3_footer_grid">
					<h3>홈<a href="main.me"></a></h3>
					<ul class="info"> 
						<li><i class="fa fa-arrow-right" aria-hidden="true"></i><a href="products.po">전체 상품</a></li>
						<li><i class="fa fa-arrow-right" aria-hidden="true"></i><a href="laptop.po">노트북</a></li>
						<li><i class="fa fa-arrow-right" aria-hidden="true"></i><a href="tablet.po">태블릿</a></li>
						<li><i class="fa fa-arrow-right" aria-hidden="true"></i><a href="phone.po">휴대폰</a></li>
					</ul>
				</div>
				
				<div class="col-md-3 w3_footer_grid">
					<h3>공지사항</h3>
					<ul class="info"> 
						<!-- <li><i class="fa fa-arrow-right" aria-hidden="true"></i><a href="about.html">About Us</a></li> -->
						<li><i class="fa fa-arrow-right" aria-hidden="true"></i><a href="noticelist.no">공지</a></li>
						<!-- <li><i class="fa fa-arrow-right" aria-hidden="true"></i><a href="short-codes.jsp">Short Codes</a></li> -->
						<li><i class="fa fa-arrow-right" aria-hidden="true"></i><a href="eventlist.no">이벤트</a></li>
					</ul>
				</div>
				
				<div class="col-md-3 w3_footer_grid">
					<h3>고객센터</h3>
					<ul class="info"> 
						<!-- <li><i class="fa fa-arrow-right" aria-hidden="true"></i><a href="about.html">About Us</a></li> -->
						<li><i class="fa fa-arrow-right" aria-hidden="true"></i><a href="faq.ad">자주 묻는 질문</a></li>
						<!-- <li><i class="fa fa-arrow-right" aria-hidden="true"></i><a href="short-codes.jsp">Short Codes</a></li> -->
						<% 
						String id = (String)session.getAttribute("m_id");
						if(id != null){
						%>
						<li><i class="fa fa-arrow-right" aria-hidden="true"></i><a href="faq.ad?tab=tab-2">1 : 1 문의</a></li>
						<%} %>
					</ul>
				</div>
				
				<%-- <div class="col-md-3 w3_footer_grid">
					<h3>프로필</h3>
					<ul class="info"> 
						<% 
						String id = (String)session.getAttribute("m_id");
						if(id == null){
						%>
						<li><i class="fa fa-arrow-right" aria-hidden="true"></i><a href="login.me">로그인</a></li>
						<li><i class="fa fa-arrow-right" aria-hidden="true"></i><a href="insert.me">회원가입</a></li>
						<%
						} else{
							%>
						<li><i class="fa fa-arrow-right" aria-hidden="true"></i><a href="logout.me">로그아웃</a></li>
						<li><i class="fa fa-arrow-right" aria-hidden="true"></i><a href="update.me">마이페이지</a></li>
						<li><i class="fa fa-arrow-right" aria-hidden="true"></i><a href="wishlist.po">찜리스트</a></li>
							<%
						}
						%>
					</ul>
				</div> --%>
				<div class="clearfix"> </div>
			</div>
		</div>
		
		<div class="footer-copy">
			
			<div class="container">
				<p>EDIT 회원이 올린 이미지가 저작권에 위배될 경우 신고하시면 검토 후삭제하겠습니다.<br>
				EDIT는 통신판매의 당사자가 아닌 통신판매중개자로서 상품, 상품정보, 거래에 대한 책임이 제한될 수 있으므로, 각 상품 페이지에서 구체적인 내용을 확인하시기 바랍니다. 
				<br>본사에 등록된 모든 광고와 저작권 및 법적책임은 자료제공사(또는 회원)에게 있으므로 본사는광고에 대한 책임을 지지 않습니다.</p>
			</div>
		</div>
		
	</div>	
	 <!-- 이미지 출력 -->
    <img src="${imagePath}" alt="Image">
    <!--  이미지 출력  -->
</body>
</html>