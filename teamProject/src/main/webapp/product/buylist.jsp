<%@page import="java.util.List"%>
<%@page import="com.itwillbs.domain.MemberDTO"%>
<%@page import="com.itwillbs.domain.ProductDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--  찜리스트 
author: W3layouts
author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>
<html>
<head>
<title>Super Market an Ecommerce Online Shopping Category Flat Bootstrap Responsive Website Template | Checkout :: w3layouts</title>
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
<link href="css/mypage_3.css" rel="stylesheet"> 
<!-- font-awesome icons -->
<link href="../css/font-awesome.css" rel="stylesheet"> 
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

<!-- 헤더 들어가는 곳! -->
<jsp:include page="../inc/top.jsp"></jsp:include>
<!-- 헤더 들어가는 곳! -->

<!-- breadcrumbs -->
	<div class="breadcrumbs">
		<div class="container">
			<ol class="breadcrumb breadcrumb1">
				<li><a href="index.html"><span class="glyphicon glyphicon-home" aria-hidden="true"></span>홈</a></li>
				<li class="active">판매전체목록,완료목록</li>
			</ol>
		</div>
	</div>
<!-- //breadcrumbs -->

<%
String id = (String)session.getAttribute("m_id");
ProductDTO productDTO = (ProductDTO)request.getAttribute("productDTO");
MemberDTO memberDTO = (MemberDTO)request.getAttribute("memberDTO");
%>

<div class="top-brands_1">

			<div class="container_2_1">
				<ul class="tabs">
					<li class="tab-link current" data-tab="tab-1">판매전체목록</li>
					<li class="tab-link" data-tab="tab-2">판매완료목록</li>
				</ul>
			</div>


<div class="container_3_1">
			
<!-- 판매목록 -->

<!-- 1번 -->
<%
List<ProductDTO> productList2
	   =(List<ProductDTO>)request.getAttribute("productList2");
%>
<div id="tab-1" class="tab-content current">
	<div class="checkout">
<!-- 		<div class="container"> -->
						<h2> 상품전체목록 </h2>
			<div class="checkout-right">
				<table class="timetable_sub">
					<thead>
						<tr>
							<th>상품번호</th>	
							<th>상품이미지</th>
							<th>상품제목</th><!-- 나중에 get으로 가져와야함  -->
							<th>가격</th>
						</tr>
					</thead>
				
					
<%				
		//if(id != null){
		//if (productList2 != null) {
		if (productList2 != null && id != null){
					for(int i=0;i<productList2.size();i++){
						productDTO =productList2.get(i);
							if (id.equals(productDTO.getM_id())){
							//if ("거래완료".equals(productDTO.getP_status()) && id.equals(productDTO.getM_id())) {
						%>
										
		<tr class="rem1">
			<td class="invert" style="display: none;"><%=productDTO.getP_num()%></td>
			<td class="invert"><%= i +1 %></td>
			<td class="invert-image"><a href="single.po?p_num=<%=productDTO.getP_num()%>"><img src="upload/<%=productDTO.getP_file() %>" alt=" " class="img-responsive" /></a></td>
			<td class="invert"><%=productDTO.getP_title() %></td>
			<td class="invert"><%=productDTO.getP_price() %></td>
		</tr>
					
<%
							 }
					 }
			}
%>
					
				
				
				
					
				</table>
			
				
			
			</div>
		<!-- 쇼핑계속하기 버튼 --> 
<!-- 		<div class="checkout-left">	 -->
<!-- 			<div class="checkout-right-basket"> -->
<!-- 				<a href="products.po"><span class="glyphicon glyphicon-menu-left" aria-hidden="true"></span>쇼핑 계속하기</a> -->
<!-- 			</div> -->
<!-- 			<div class="clearfix"> </div> -->
<!-- 		</div> -->
	<!-- // 쇼핑계속하기 버튼 -->	
		</div>
<!-- 	</div> -->

</div>
<!-- ------------------------------------------------------------------------------------------------------------ -->
<!-- 2번 -->
<%
	List<ProductDTO> productList
	   =(List<ProductDTO>)request.getAttribute("productList");
%>
<div id="tab-2" class="tab-content">
	<div class="checkout">
<!-- 		<div class="container"> -->
					<h2> 상품완료목록 </h2>
			<div class="checkout-right">
				<table class="timetable_sub">
					<thead>
						<tr>
							<th>상품번호</th>	
							<th>상품이미지</th>
							<th>상품제목</th><!-- 나중에 get으로 가져와야함  -->
							<th>가격</th>
						</tr>
					</thead>
				
					
<%				
		//if(id != null){
		//if (productList2 != null) {
		if (productList != null && id != null){
					for(int i=0;i<productList.size();i++){
						productDTO =productList.get(i);
							if (id.equals(productDTO.getM_id())){
							//if ("거래완료".equals(productDTO.getP_status()) && id.equals(productDTO.getM_id())) {
						%>
										
		<tr class="rem1">
			<td class="invert" style="display: none;"><%=productDTO.getP_num()%></td>
			<td class="invert"><%= i +1 %></td>
			<td class="invert-image"><a href="single.po?p_num=<%=productDTO.getP_num()%>"><img src="upload/<%=productDTO.getP_file() %>" alt=" " class="img-responsive" /></a></td>
			<td class="invert"><%=productDTO.getP_title() %></td>
			<td class="invert"><%=productDTO.getP_price() %></td>
		</tr>
					
<%
							 }
					 }
			}
%>
					
					
					
					
					
				</table>
			
			<!-- 쇼핑계속하기 버튼 -->
<!-- 		<div class="checkout-left">	 -->
<!-- 			<div class="checkout-right-basket"> -->
<!-- 				<a href="products.po"><span class="glyphicon glyphicon-menu-left" aria-hidden="true"></span>쇼핑 계속하기</a> -->
<!-- 			</div> -->
<!-- 			<div class="clearfix"> </div> -->
<!-- 		</div> -->
		<!-- // 쇼핑계속하기 버튼 -->				
			
<!-- 			</div> -->
		</div>
	</div>
</div>

<!-- ----------------------------------------------------------------------------- -->



</div> <!-- 끝 --> 
</div>












				

			
				
			
			
			
			
<!-- // 판매목록 -->



<script type="text/javascript">

<!-- 			탭 jquery -->
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







<!-- 푸터 들어가는 곳! -->
<div class="clearfix">
<jsp:include page="../inc/bottom.jsp"></jsp:include>
</div>
<!-- 푸터 들어가는 곳! -->


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
</body>
</html>