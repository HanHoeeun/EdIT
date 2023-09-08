<%@page import="com.itwillbs.service.MemberService"%>
<%@page import="com.itwillbs.service.ProductService"%>
<%@page import="com.itwillbs.domain.MemberDTO"%>
<%@page import="com.itwillbs.domain.ProductDTO"%>
<%@page import="com.itwillbs.domain.WishListDTO"%>
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

<%-- <%
String orderBy = (String) request.getAttribute("orderBy");
%> --%>
 <%-- <div class="col-md-8 products-right">
            <div class="products-right-grid">
                <div class="products-right-grids">
                    <div class="sorting">
                        <select id="country" onchange="change_country(this.value)" class="frm-field required sect">
                    <option value="wishSell" <% if (orderBy != null && orderBy.equals("wishSell")){%>selected<%}%>><i class="fa fa-arrow-right" aria-hidden="true"></i>판매중</option>                        
                    <option value="wishSold" <% if (orderBy != null && orderBy.equals("wishSold")){%>selected<%}%>><i class="fa fa-arrow-right" aria-hidden="true"></i>판매완료</option>
                </select>
            </div>
           
        </div>
    </div> --%>

<div class="clearfix"> </div>

<!-- 찜리스트 -->
 <%
 List<WishListDTO> wishList = (List<WishListDTO>)request.getAttribute("wishList");
 String id = (String)session.getAttribute("m_id");
 MemberDTO memberDTO = (MemberDTO)request.getAttribute("memberDTO"); 
 //ProductDTO	productDTO = (ProductDTO)request.getAttribute("productDTO");
 
 %>
	<div class="checkout">
		<div class="container">
			<h2><%=memberDTO.getM_nick() %>님의 찜리스트</h2>
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
   					    <!-- <tr class="rem1">
						<td class="invert">1</td>
						<td class="invert-image"><a href="single.po"><img src="#" alt=" " class="img-responsive" /></a></td>
						<td class="invert"><a href="single.po">팝니다</a></td>
						<td class = "invert">판매중</td>
						<td class="invert"><a href="single.po">노트북</a></td>
						<td class="invert">500000원</td>
						<td class="invert" align="center">
    					<div class="rem" style="display: flex; justify-content: center; align-items: center;">
       					<div class="close1"></div>
   					    </div> -->
				<% if (wishList.isEmpty()) { %>
 				<tr>
 				<td colspan="7"> 마음에 드는 상품을 추가해보세요! </td>
 				</tr>
				<% } else { %>
					
				 <% for (int i = 0; i < wishList.size(); i++) {
					 WishListDTO wishListDTO = wishList.get(i);
						%>

					<tr class="rem1">
						<td class="w_num" style="display: none;"><%= wishListDTO.getW_num() %></td>
						<td class="invert"><%=i + 1 %></td>
						<td class="invert-image"><a href="single.po?p_num=<%=wishListDTO.getW_p_num()%>"><img src="upload/<%= wishListDTO.getProductDTO().getP_file() %>" width="100px" height="100px" download alt=" " class="img-responsive" /></a></td>
						<td class="invert"><a href="single.po?p_num=<%=wishListDTO.getW_p_num() %>"><%=wishListDTO.getProductDTO().getP_title() %></a></td>
						<td class = "invert"><%=wishListDTO.getProductDTO().getP_status() %></td>
						<td class="invert"><a href="single.po?p_num=<%=wishListDTO.getW_p_num() %>"><%=wishListDTO.getProductDTO().getP_type() %></a></td>
						<td class="invert"><%=wishListDTO.getProductDTO().getP_price() %>원</td>
						<td class="invert" align="center">
    					<div class="rem" style="display: flex; justify-content: center; align-items: center;">
       					<div class="close1"></div>
   					    </div>
   					    <%
   					    }
   					    %>    
   					    <%
   					    }
   					    %> 
   					    
   					 	
   					<script>
    				$(document).ready(function() {
      				  $('.close1').on('click', function() {
     			       var $rem1 = $(this).closest('.rem1');
         			   var w_num = $rem1.find('.w_num').text(); // 항목의 w_num 값을 가져옴

         			   // 서버로 삭제 요청을 보냄 (AJAX를 사용할 수 있음)
         			   $.ajax({
           			   url: 'deletewish.dwi', // 서버에서 삭제를 처리하는 서블릿 주소
             		   type: 'POST', // 또는 GET, 삭제 요청에 맞게 설정
                	   data: { w_num: w_num }, // 삭제할 항목의 식별자를 서버로 전달
               		   success: function(response) {
                       if (response === 'success') {
                        // 삭제가 성공하면 UI에서 항목을 제거
                        $rem1.animate('slow', function() {
                            $rem1.remove();
                        });
                       } else {
                        // 삭제 실패 시 메시지를 표시하거나 다른 조치를 취할 수 있음
                        alert(response);
                        location.reload();
                       }
                },
                error: function() {
                    alert('서버 오류: 삭제 요청을 처리할 수 없습니다.');
                }
            });
        });
    });
</script>

   				
						<!-- <script>
        				/* $(document).ready(function(c) {
            			$('.close1').on('click', function(c){
               		 	$('.rem1').fadeOut('slow', function(c){
                    	$('.rem1').remove();
            	    			});
            				});	  
        				}); 
    					</script> -->
						</td>
					</tr>
			
				</table>
			</div>
			<div class="clearfix"> </div>
			</div>
			</div>
			<!-- 페이지 목록 -->
<!-- 페이징 코드 5개씩 나눠서 페이징 -->
<nav class="numbering">
   <ul class="pagination paging">
      <%
      ProductPageDTO ppageDTO
      = (ProductPageDTO)request.getAttribute("ppageDTO");
      if(ppageDTO.getP_startPage() > ppageDTO.getP_pageBlock()){
         %>
         <li>
            <a href="wishlist.po?p_pageNum=<%=ppageDTO.getP_startPage()-ppageDTO.getP_pageBlock()%>&orderBy=${orderBy}" aria-label="Previous">
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
            <a href="wishlist.po?p_pageNum=<%= i %>&orderBy=${orderBy}" class="<%= (isCurrentPage) ? "" : "" %> <%= (isPcurrentPage) ? "custom-class" : "" %>">
            <%= (isPcurrentPage) ? i : i %></a>
         </li>
         <%
      }

      if(ppageDTO.getP_endPage() < ppageDTO.getP_pageCount()){
         %>
         <li>
            <a href="wishlist.po?p_pageNum=<%=ppageDTO.getP_startPage()+ppageDTO.getP_pageBlock()%>&orderBy=${orderBy}" >
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