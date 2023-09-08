<%@page import="com.itwillbs.domain.ProductPageDTO"%>
<%@page import="com.itwillbs.domain.AdminPageDTO"%>
<%@page import="com.itwillbs.domain.ReportDTO"%>
<%@page import="com.itwillbs.domain.WishListDTO"%>
<%@page import="com.itwillbs.domain.MemberDTO"%>
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
<title>마이페이지</title>
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
<link href="css/font-awesome.css" rel="stylesheet"> 
<link href="css/mypage_3.css" rel="stylesheet"> 
<link href="css/faq_1.css" rel="stylesheet"> 
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
</head>
<body>
<!-- 찜리스트 부분 -->
 <%
 List<WishListDTO> wishList = (List<WishListDTO>)request.getAttribute("wishList");
 String id = (String)session.getAttribute("m_id");
 MemberDTO memberDTO = (MemberDTO)request.getAttribute("memberDTO"); 
 
 ProductPageDTO ppageDTO = (ProductPageDTO)request.getAttribute("ppageDTO");
 %>

<!--================================== 헤더 ==================================== -->
<jsp:include page="../inc/top.jsp"></jsp:include>
	
<!--=========================== 상단 네비 ============================================ -->
	<div class="breadcrumbs">
		<div class="container">
			<ol class="breadcrumb breadcrumb1 animated wow slideInLeft" data-wow-delay=".5s">
				<li><a href="index.html"><span class="glyphicon glyphicon-home" aria-hidden="true"></span>홈</a></li>
				<li class="active">마이페이지</li>
			</ol>
		</div>
	</div>
<!--=========================== 본문 헤더 =========================================== -->	
	<div class="top-brands_1">
		<h2>마이페이지</h2>
			<div class="container_2_1">

<!--=========================== 상단 탭 리스트============================================ -->
				<ul class="tabs">
					<li class="tab-link " onclick="location.href='update.me'">나의정보</li>
					<li class="tab-link" onclick="location.href='buylist.me'">판매내역</li>
					<li class="tab-link current" onclick="location.href='m_wishlist.me'">찜</li> 
					<li class="tab-link" onclick="location.href='m_adminpage.me'" >신고내역</li>
<!-- 					<li class="tab-link" data-tab="tab-7">회원탈퇴</li> -->
					<li class="tab-link" onclick="location.href='update.me?tab=tab-2'">회원탈퇴</li> 
				</ul>
			</div>
		
<!--================================== 4탭 찜 ==================================== -->		
	<div class="container_3_1">
<!-- 	class = "tab-content" 일때는 화면에 찜 테이블이 안 보였음 / current를 입력하니 보임!!!! -->
				<div id="tab-4" class="tab-content current">
					<table class="_1qna_board">
						<tr>
							<th class="_1qna_board_border">찜 번호</th>
							<th class="_1qna_board_border">상품 이미지</th>
							<th class="_1qna_board_border">상품 이름</th>
							<th class="_1qna_board_border">상품 상태</th>
							<th class="_1qna_board_border">상품 타입</th>
							<th class="_1qna_board_border">가격</th>
							<th class="_1qna_board_border">삭제</th>
						</tr>
<!-- 						product 참고  -->
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
						<td class="_1qna_board_border"><%=i + 1 %></td>
						<td class="_1qna_board_border"><a href="single.po?p_num=<%=wishListDTO.getProductDTO().getP_num()%>"><img src="upload/<%= wishListDTO.getProductDTO().getP_file() %>" width="100px" height="100px" download alt=" " class="img-responsive" /></a></td>
						<td class="_1qna_board_border"><a href="single.po?p_num=<%=wishListDTO.getProductDTO().getP_num()%>"><%=wishListDTO.getProductDTO().getP_title() %></a></td>
						<td class = "_1qna_board_border"><%=wishListDTO.getProductDTO().getP_status() %></td>
						<td class="_1qna_board_border"><a href="single.po?p_num=<%=wishListDTO.getProductDTO().getP_num()%>"><%=wishListDTO.getProductDTO().getP_type() %></a></td>
						<td class="_1qna_board_border"><%=wishListDTO.getProductDTO().getP_price() %>원</td>
						<td class="_1qna_board_border" align="center">
    					<div class="rem" style="display: flex; justify-content: center; align-items: center;">
       					<div class="close1"></div>
   					    </div>
   					    </td>
   					    </tr>
   					    <% } %>    
   					    <% } %> 
  
  				 	


</table>
<!-- <div class="clearfix_1_1"> </div> -->


<!-- 페이징 -->
<div class="_1qna_paging">
    <ul>
        <%
        // 시작 페이지에서 이전 페이지로 이동하는 링크를 표시
        if (ppageDTO.getP_startPage() > ppageDTO.getP_pageBlock()) {
        %>
        <li onclick="location.href='m_wishlist.me?p_pageNum=<%= ppageDTO.getP_startPage() - ppageDTO.getP_pageBlock() %>&orderBy=${orderBy}'">Prev</li>
        <%
        }
        
        // 페이지 번호 링크를 표시
        for (int i = ppageDTO.getP_startPage(); i <= ppageDTO.getP_endPage(); i++) {
            boolean isCurrentPage = (i == ppageDTO.getP_currentPage());
            boolean isPcurrentPage = (i == ppageDTO.getP_currentPage());
        %>
        <li class="<%= (isCurrentPage || isPcurrentPage) ? "active" : "" %>"
            onclick="location.href='m_wishlist.me?p_pageNum=<%= i %>&orderBy=${orderBy}'">
            <%= (isPcurrentPage) ? i : i %>
        </li>
        <%
        }
        
        // 끝 페이지에서 다음 페이지로 이동하는 링크를 표시
        if (ppageDTO.getP_endPage() < ppageDTO.getP_pageCount()) {
        %>
        <li onclick="location.href='m_wishlist.me?p_pageNum=<%= ppageDTO.getP_startPage() + ppageDTO.getP_pageBlock() %>&orderBy=${orderBy}'">Next</li>
        <%
        }
        %>
    </ul>
</div>
</div>
</div>

<!-- // 페이징 -->

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

<!-- 			탭 jquery -->
<script type="text/javascript">
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