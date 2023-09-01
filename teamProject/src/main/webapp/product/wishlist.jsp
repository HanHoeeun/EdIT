ㅠ<%@page import="com.itwillbs.domain.WishListDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.itwillbs.domain.ProductPageDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>  
<head>
<meta charset="UTF-8">
<title>product/wishlist.jsp</title>
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

<!-- 헤더 들어가는 곳! -->
<jsp:include page="../inc/top.jsp"></jsp:include>
<!-- 헤더 들어가는 곳! -->


<!-- breadcrumbs -->
	<div class="breadcrumbs">
		<div class="container">
			<ol class="breadcrumb breadcrumb1">
				<li><a href="main.me"><span class="glyphicon glyphicon-home" aria-hidden="true"></span>홈</a></li>
				<li class="active">찜리스트</li>
			</ol>
		</div>
	</div>
<!-- //breadcrumbs -->
 <!-- 드롭다운과 상품 리스트 -->

<%
String orderBy = (String) request.getAttribute("orderBy");
%>
 <div class="col-md-8 products-right">
            <div class="products-right-grid">
                <div class="products-right-grids">
                    <div class="sorting">
                        <select id="country" onchange="change_country(this.value)" class="frm-field required sect">
                    <option value="wishSell" <% if (orderBy != null && orderBy.equals("wishSell")){%>selected<%}%>><i class="fa fa-arrow-right" aria-hidden="true"></i>판매중</option>                        
                    <option value="wishSold" <% if (orderBy != null && orderBy.equals("wishSold")){%>selected<%}%>><i class="fa fa-arrow-right" aria-hidden="true"></i>판매완료</option>
                </select>
            </div>
           
        </div>
    </div>

<div class="clearfix"> </div>

<!-- 찜리스트 -->
<%
   String id = (String)session.getAttribute("id");
   WishListDTO wishListDTO = (WishListDTO)request.getAttribute("wishListDTO");
   List<WishListDTO> wishList 
   = (List<WishListDTO>)request.getAttribute("wishList");
   ProductPageDTO ppageDTO
   = (ProductPageDTO)request.getAttribute("ppageDTO");
 %> 
	<div class="checkout">
		<div class="container">
			<h2><%= %> 님의 찜리스트</h2>
			<div class="checkout-right">
				<table class="timetable_sub">
					<thead>
						<tr>
							<th>찜 번호</th>	
							<th>상품 이미지</th>
							<th>상품 이름</th>
							<th>상품 상태</th>
							<th>상품 타입</th>
							<th>가격</th>
							<th>삭제</th>
						</tr>
					</thead>
					
					
					<tr class="rem1">
				<%-- <% for (int i = 0; i < wishList.size(); i++){
					WishListDTO wishListDTO = wishList.get(i);
				}
				%> --%>
						<td class="invert"></td>
						<td class="invert-image"><a href="single.po"><img src="../images/1.png" alt=" " class="img-responsive" /></a></td>
						<td class="invert"><a href="single.po">팝니다 </a></td>
						<td class = "invert">판매중</td>
						<td class="invert"><a href="single.po">태블릿</a></td>
						<td class="invert">200만원</td>
						<td class="invert" align="center">
    					<div class="rem" style="display: flex; justify-content: center; align-items: center;">
       					<div class="close1"></div>
   					    </div>
   					 	<script>
        				$(document).ready(function(c) {
            			$('.close1').on('click', function(c){
               		 	$('.rem1').fadeOut('slow', function(c){
                    	$('.rem1').remove();
            	    			});
            				});	  
        				});
    					</script>
						</td>
					</tr>
			
				</table>
			</div>
			
			<!-- 페이지 목록 -->
<!-- 페이징 코드 5개씩 나눠서 페이징 -->
<nav class="numbering">
   <ul class="pagination paging">
      <%
      if(ppageDTO.getP_startPage() > ppageDTO.getP_pageBlock()){
         %>
         <li>
            <a href="products.po?p_pageNum=<%=ppageDTO.getP_startPage()-ppageDTO.getP_pageBlock()%>&orderBy=${orderBy}" aria-label="Previous">
               <span aria-hidden="true">&laquo;</span>
            </a>
         </li>
         <%
      }

      for(int i=ppageDTO.getP_startPage(); i<=ppageDTO.getP_endPage(); i++){
         boolean isCurrentPage = (i == ppageDTO.getP_currentPage());
         boolean isPcurrentPage = (i == ppageDTO.getP_currentPage());
         %>
         <li class="<%= (isCurrentPage || isPcurrentPage) ? "active" : "" %>">
            <a href="products.po?p_pageNum=<%= i %>&orderBy=${orderBy}" class="<%= (isCurrentPage) ? "" : "" %> <%= (isPcurrentPage) ? "custom-class" : "" %>">
            <%= (isPcurrentPage) ? i : i %></a>
         </li>
         <%
      }

      if(ppageDTO.getP_endPage() < ppageDTO.getP_pageCount()){
         %>
         <li>
            <a href="products.po?p_pageNum=<%=ppageDTO.getP_startPage()+ppageDTO.getP_pageBlock()%>&orderBy=${orderBy}" >
               <span aria-hidden="true">&raquo;</span>
            </a>
         </li>
         <%
      }
      %> 
   </ul>
</nav>

         </div>
         <div class="clearfix"> </div>
      </div>
      </div>

			<!-- // 페이지 목록 -->	
			
			<!-- 쇼핑계속하기 버튼 -->
			<div class="checkout-left">	
				<div class="checkout-right-basket">
					<a href="products.po"><span class="glyphicon glyphicon-menu-left" aria-hidden="true"></span>쇼핑 계속하기</a>
				</div>
				<div class="clearfix"> </div>
			</div>
			<!-- // 쇼핑계속하기 버튼 -->
			
		</div>
	</div>
<!-- 찜리스트 -->

<!-- 푸터 들어가는 곳! -->
<div class="clearfix">
<jsp:include page="../inc/bottom.jsp"></jsp:include>
</div>
<!-- 푸터 들어가는 곳! -->

</body>
</html>
</body>
</html>