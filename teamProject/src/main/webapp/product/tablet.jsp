<%@page import="com.itwillbs.domain.MemberDTO"%>
<%@page import="com.itwillbs.domain.WishListDTO"%>
<%@page import="com.itwillbs.domain.ProductPageDTO"%>
<%@page import="com.itwillbs.domain.ProductDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>  
<head>
<meta charset="UTF-8">
<title>product/tablet.jsp</title>
<style type="text/css">
/* Breadcrumbs 스타일 */
.breadcrumbs {
    padding: 20px 0; /* 위아래로 20px의 여백 추가 */
    background-color: #f5f5f5;
}

/* 카테고리 스타일 */
.categories {
    margin-top: 20px; /* 위쪽으로 20px의 여백 추가 */
    border: 1px solid #999;
    padding: 10px;
}

</style>
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
<title>product/tablet.jsp</title>
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
         <ol class="breadcrumb breadcrumb1 animated wow slideInLeft" data-wow-delay=".5s">
            <li><a href="main.jsp"><span class="glyphicon glyphicon-home" aria-hidden="true"></span>Home</a></li>
            <li class="active">태블릿 보기</li>
         </ol>
      </div>
   </div>
<!-- //breadcrumbs -->
<!--- products --->
<!-- 카테고리  -->
  <div class="container">
    <div class="row">
        <!-- 카테고리 -->
        <div class="col-md-4 products-left">
            <div class="categories">
                <h2>카테고리</h2>
                <ul class="cate">
                    <li><a href="products.po"><i class="fa fa-arrow-right" aria-hidden="true"></i>전체 상품 보기</a></li>
                    <li><a href="laptop.po"><i class="fa fa-arrow-right" aria-hidden="true"></i>노트북</a></li>
                    <li><a href="phone.po"><i class="fa fa-arrow-right" aria-hidden="true"></i>휴대폰</a></li>
                    <li><a href="tablet.po"><i class="fa fa-arrow-right" aria-hidden="true"></i>태블릿</a></li>
                </ul>
            </div>
        </div>
        
 <!-- 카테고리  -->
 <!-- 드롭다운과 상품 리스트 -->

<%
String orderBy = (String) request.getAttribute("orderBy");
%>
 <div class="col-md-8 products-right">
            <div class="products-right-grid">
                <div class="products-right-grids">
                    <div class="sorting">
                        <select id="country" onchange="change_country(this.value)" class="frm-field required sect">
                    <option value="tabletLatest" <% if (orderBy != null && orderBy.equals("tabletLatest")){%>selected<%}%>><i class="fa fa-arrow-right" aria-hidden="true"></i>최신순</option>
                    <option value="tabletPopular" <% if (orderBy != null && orderBy.equals("tabletPopular")){%>selected<%}%>><i class="fa fa-arrow-right" aria-hidden="true"></i>인기순</option> 
                    <option value="tabletHighPrice" <% if (orderBy != null && orderBy.equals("tabletHighPrice")){%>selected<%}%>><i class="fa fa-arrow-right" aria-hidden="true"></i>가격 높은 순</option>               
                    <option value="tabletLowPrice" <% if (orderBy != null && orderBy.equals("tabletLowPrice")){%>selected<%}%>><i class="fa fa-arrow-right" aria-hidden="true"></i>가격 낮은 순</option>                        
                    <option value="tabletSell" <% if (orderBy != null && orderBy.equals("tabletSell")){%>selected<%}%>><i class="fa fa-arrow-right" aria-hidden="true"></i>판매중</option>                        
                    <option value="tabletSold" <% if (orderBy != null && orderBy.equals("tabletSold")){%>selected<%}%>><i class="fa fa-arrow-right" aria-hidden="true"></i>판매완료</option>                        
                </select>
            </div>
           
        </div>
    </div>

<div class="clearfix"> </div>

 <!-- 드롭다운  -->
 <!-- 상품 리스트 -->
            <%
            List<ProductDTO> tabletList 
            = (List<ProductDTO>)request.getAttribute("tabletList");
            ProductPageDTO ppageDTO
            = (ProductPageDTO)request.getAttribute("ppageDTO");
            List<WishListDTO> wishList
            = (List<WishListDTO>)request.getAttribute("wishList");
            String id = (String)session.getAttribute("m_id");
            MemberDTO memberDTO = (MemberDTO)request.getAttribute("memberDTO"); 
           
            %>
            
              <div class="agile_top_brands_grids">
    <% for (int i = 0; i < tabletList.size(); i++) {
       ProductDTO productDTO = tabletList.get(i);%>
    <div class="col-md-4 top_brand_left">
        <div class="hover14 column">
            <div class="agile_top_brand_left_grid">
                <!-- <div class="agile_top_brand_left_grid_pos">
                    You can customize this part
                </div> -->
                <div class="agile_top_brand_left_grid1">
                    <figure>
                         <div class="snipcart-item block">
                            <div class="snipcart-thumb">
                                <a href="single.po?p_num=<%=productDTO.getP_num()%>"><img title=" " alt=" " src="upload/<%=productDTO.getP_file() %>"  width="150px" height="150px" download></a>
                                <p><%=productDTO.getP_title() %></p>
                                <h4><%= productDTO.getP_price() %>원</h4>
                                <h4><%= productDTO.getP_status() %></h4>
                                <h4><%= productDTO.getP_type() %></h4>
                            </div>
                            <div class="snipcart-details top_brand_home_details">
                                <form action="#" method="post">
                                    <fieldset>
                                        <input type="hidden" name="cmd" value="_cart">
                                        <input type="hidden" name="add" value="1">
                                        <input type="hidden" name="business" value=" ">
                                        <input type="hidden" name="item_name" value="Fortune Sunflower Oil">
                                        <input type="hidden" name="amount" value="35.99">
                                        <input type="hidden" name="currency_code" value="KRW">
                                        <input type="hidden" name="return" value=" ">
                                        <input type="hidden" name="cancel_return" value=" ">
                                       <% 
                                        if(memberDTO != null){
                                        
                                        %>
                                       <input type="button" value="찜 추가하기" class="button addToWishlistButton"
   										 data-p-num="<%= productDTO.getP_num() %>"			
  										 data-m-num="<%= memberDTO.getM_num() %>">
  										 <%
                                        }else {
                                        	%>
                                        	<a href="login.me"><input type="button" value="로그인 하기" class="button">로그인 시<br> 찜 추가 가능!</button></a>
                                        	
                                        	<%
                                        }
  										 %>
  										 
									 </fieldset>
                                </form>
                            </div>
                        </div> 
                    </figure>
                </div>
            </div>
        </div>
    </div>
    <% 
    }
    
    %>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="../js/jquery-1.11.1.min.js"></script>
<script>
$(document).ready(function() {
    $('.addToWishlistButton').click(function() {
        // 버튼의 data-p-num와 data-m-num 속성 값을 가져오기
       var $button = $(this);
        var w_p_num = $button.data('p-num');
        var w_m_num = $button.data('m-num');


        // productDTO와 memberDTO 객체가 null인지 확인
        if (w_p_num == undefined || w_m_num == undefined) {
            alert('로그인 먼저 해주세요 :) ');
            return; // 함수 실행 중지
        }
        

        // p_num과 m_num 값이 정상적으로 가져와지는지 console.log로 확인
        console.log("p_num:", w_p_num);
        console.log("m_num:", w_m_num);

        $.ajax({
            type: 'POST',
            url: 'addwish.wi',
            data: {w_p_num: w_p_num, w_m_num: w_m_num},
            success: function(response) {
                alert(response);
                
            },
            error: function() {
                alert('오류 발생');
            }
        });
    });
    
});
</script>
    <div class="clearfix"> </div>
</div>

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
      
  
<!--- products --->
<!-- 푸터 들어가는 곳! -->
<div class="clearfix">
<jsp:include page="../inc/bottom.jsp"></jsp:include>
</div>
<!-- 푸터 들어가는 곳! -->
<!-- <script type="text/javascript">
function change_country(l) {
	location.href="products.po?ord="+l;
} -->
<script type="text/javascript">
function change_country(l) {
    location.href = "tablet.po?ord=" + l;
}
</script>


<!-- </script> -->
</body>
</html>
</body>
</html>