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
				<li class="active">판매목록</li>
			</ol>
		</div>
	</div>
<!-- //breadcrumbs -->

<%
String id = (String)session.getAttribute("m_id");
ProductDTO productDTO = (ProductDTO)request.getAttribute("productDTO");
MemberDTO memberDTO = (MemberDTO)request.getAttribute("memberDTO");
%>

<%
	List<ProductDTO> productList
	   =(List<ProductDTO>)request.getAttribute("productList");
%>

<!-- 판매목록 -->
	<div class="checkout">
		<div class="container">
			<h2> 판매목록 </h2>
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
		if(id != null){
					for(int i=0;i<productList.size();i++){
						productDTO =productList.get(i);
							 if (id.equals(productDTO.getM_id()) && "거래완료".equals(productDTO.getP_status())) {
							
							%>
										
		<tr class="rem1">
			<td class="invert"><%=productDTO.getP_num()%></td>
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
		</div>
	</div>
<!-- // 판매목록 -->






<!-- 푸터 들어가는 곳! -->
<div class="clearfix">
<jsp:include page="../inc/bottom.jsp"></jsp:include>
</div>
<!-- 푸터 들어가는 곳! -->

</body>
</html>
</body>
</html>