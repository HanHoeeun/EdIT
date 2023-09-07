<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main.jsp</title>
<%
String m_id = null;
if(session.getAttribute("m_id")!=null){
m_id = (String)session.getAttribute("m_id");
}
%>
</head>
<body>    

<!--
author: W3layouts
author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>   
<html>
<head>
<title>top</title>
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
<link href="css/custom_1.css" rel="stylesheet"> 
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
<%
	if(m_id != null){%>
	<script type="text/javascript">
		$(document).ready(function(){
			getInfiniteUnread();
		});
	</script>
<%	}%>
<script type="text/javascript">

function getUnread(){
	$.ajax({
		type:'post',
		url: 'chatUnread.ch',
		data:{
			m_id : encodeURIComponent('<%=m_id%>')
		},
		success: function(result){
			if(result >= 1){
				showUnread(result);
			}else{
				showUnread('');
			}
		}
	});
}
function getInfiniteUnread(){
	setInterval(function(){
		getUnread();
	}, 4000);
}
function showUnread(result){
	$('#unread').html(result);
}
</script>
<!-- start-smoth-scrolling -->

</head>
	
<body>
<!-- header -->
	<div class="agileits_header">
		<div class="container">
			<div class="w3l_offers">
				<p><a href="products.po"><i class="fa fa-shopping-bag" aria-hidden="true"> 쇼핑하기 </i></a></p>
			</div>
			<div class="agile-login">
				<ul>
<% 
					String id = (String)session.getAttribute("m_id"); 
					if (id == null) { %>
					<li><a href="insert.me"><i class="fa fa-sign-in" aria-hidden="true"> 회원가입</i></a></li>
					<li><a href="login.me"><i class="fa fa-user" aria-hidden="true"> 로그인</i></a></li>
<%					
					} else { %>
					<li><a><i class="fa fa-thumbs-up" aria-hidden="true"><%=id %>님 반갑습니다!</i><a></a></li>
					<li><a href="update.me"><i class="fa fa-user" aria-hidden="true"> 마이 페이지</i></a></li>
					<li><a href="logout.me"><i class="fa fa-heart" aria-hidden="true"> 로그아웃 </i></a></li>
					<li><a href="productReg.po"><i class="fa fa-plus-circle" aria-hidden="true"> 상품등록</i></a></li>
					<li><a href="wishlist.po"><i class="fa fa-heart" aria-hidden="true"> 찜리스트 </i></a></li>
					<!-- <li><a href="single.po?p_num=5"><i class="fa fa-question-circle-o" aria-hidden="true"> 상품</i></a></li> -->
					<li><a href="#" onclick="window.open('box.ch','1:1 채팅','width=500, height=800, scrollbars=yes')"><i class="fa fa-question-circle-o" aria-hidden="true"> 채팅<span id="unread" class="label label-info" style="margin-left:2px;"></span></i></a></li>
					<%-- <% if ("admin1".equals(id)) { %> --%>
					<li><a href="adminPage.ad"><i class="fa fa-user" aria-hidden="true"> 관리자 페이지</i></a></li>
  				    <% } %><%-- <% 					
					} 
					%> --%>
<!-- 	---------------혹시 몰라 복사 해놓고 주석처리 -------- -->
					
<%-- 					<%if(1==2){ %> --%>
<!-- 					<li><a href="adminPage.ad"><i class="fa fa-user" aria-hidden="true"> 마이 페이지</i></a></li> -->
<!-- 					<li><a href="../product/productReg.jsp"><i class="fa fa-plus-circle" aria-hidden="true"> 상품등록</i></a></li> -->
					
<%-- 					<%} %> --%>
<%-- 					<%if(1==1){ %> --%>
<!-- 					<li><a href="adminPage.ad"><i class="fa fa-user" aria-hidden="true"> 관리자 페이지</i></a></li> -->
<%-- 					<%} %> --%>
<!-- 					<li><a href="faq.ad"><i class="fa fa-question-circle-o" aria-hidden="true"> 문의하기</i></a></li> -->

					<!-- <li><a href="../product/wishlist.jsp"><i class="fa fa-heart" aria-hidden="true"> 찜리스트 </i></a></li> -->
					
<!-- 	---------------혹시 몰라 복사 해놓고 주석처리 -------- -->
					
					
					
				</ul>
			</div>
			<!-- <!-- 얘도 그냥 위에 처럼 리스트 내에 내장 시켜서 하이퍼링크 거는건 어떤지..?
			 <div class="product_list_header">   
					<form action="wishlist.po" method="post" class="last"> 
						<input type="hidden" name="cmd" value="_cart">
						<input type="hidden" name="display" value="1">
						<button class="w3view-cart" type="submit" name="submit" value=""><i class="fa fa-heart" aria-hidden="true"></i></button>
					</form>  

			</div>   -->
			<div class="clearfix"> </div>
		</div>
	</div>

	<div class="logo_products">
		<div class="container">
		<div class="w3ls_logo_products_left1">
				<!-- <ul class="phone_email">
					<li><i class="fa fa-phone" aria-hidden="true">051-809-0909</i></li>
					
				</ul> -->
			</div>
			<div class="w3ls_logo_products_left">
				<h1><a href="main.me">EdIT</a></h1>
			</div>
		<!-- <div class="w3l_search">
			<form action="#" method="post">
				<input type="search" name="Search" placeholder="찾으시는 상품을 검색하세요" required="">
				<button type="submit" class="btn btn-default search" aria-label="Left Align">
					<i class="fa fa-search" aria-hidden="true"> </i>
				</button>
				<div class="clearfix"></div>
			</form>
		</div> -->
			
			<div class="clearfix"> </div>
		</div>
	</div>
<!-- //header -->
<!-- navigation -->
	<div class="navigation-agileits">
		<div class="container">
			<nav class="navbar navbar-default">
							<!-- Brand and toggle get grouped for better mobile display -->
							<div class="navbar-header nav_2">
								<button type="button" class="navbar-toggle collapsed navbar-toggle1" data-toggle="collapse" data-target="#bs-megadropdown-tabs">
									<span class="sr-only">Toggle navigation</span>
									<span class="icon-bar"></span>
									<span class="icon-bar"></span>
									<span class="icon-bar"></span>
								</button>
							</div> 
							<div class="collapse navbar-collapse" id="bs-megadropdown-tabs">
								<ul class="nav navbar-nav">
									<li class="active"><a href="main.me" class="act">Home</a></li>	
									<!-- Mega Menu -->
									<li class="dropdown">
										<a href="products.po">전체 상품 보기</a>
									</li>
									<!-- 노트북 -->
									<li class="dropdown">
										<a href="laptop.po">노트북</a>
									</li>
									<!-- // 노트북 -->
									
									<!-- 휴대폰 -->
									<li class="dropdown">
										<a href="phone.po">휴대폰</a>
									</li>
									<!-- // 휴대폰 -->
									
									<!-- 태블릿 -->
									<li class="dropdown">
										<a href="tablet.po">태블릿</a>
									</li>
									<!-- // 태블릿 -->
									
									<!-- //Mega Menu -->
									<li><a href="noticelist.no">공지사항</a></li>
									<li><a href="faq.ad">고객센터</a></li>
								</ul>			
							</div>
							</nav>
			</div>
		</div>
</body>
</html>
		