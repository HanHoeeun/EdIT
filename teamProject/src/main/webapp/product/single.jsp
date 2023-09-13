<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.itwillbs.domain.MemberDTO"%>
<%@page import="com.itwillbs.domain.ProductDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>product/single.jsp</title>
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
<title>Super Market an Ecommerce Online Shopping Category Flat
	Bootstrap Responsive Website Template | Single Page :: w3layouts</title>
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
<link href="../css/bootstrap.css" rel="stylesheet" type="text/css"
	media="all" />
<link href="../css/style.css" rel="stylesheet" type="text/css"
	media="all" />
<!-- font-awesome icons -->
<link href="../css/font-awesome.css" rel="stylesheet">
<!-- //font-awesome icons -->
<!-- js -->
<script src="../js/jquery-1.11.1.min.js"></script>
<!-- //js -->
<link
	href='//fonts.googleapis.com/css?family=Raleway:400,100,100italic,200,200italic,300,400italic,500,500italic,600,600italic,700,700italic,800,800italic,900,900italic'
	rel='stylesheet' type='text/css'>
<link
	href='//fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic'
	rel='stylesheet' type='text/css'>
<!-- start-smoth-scrolling -->
<script type="text/javascript" src="../js/move-top.js"></script>
<script type="text/javascript" src="../js/easing.js"></script>
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
<!-- start-smoth-scrolling -->

<%
ProductDTO productDTO = (ProductDTO) request.getAttribute("productDTO");
%>

<!-- 삭제하기 버튼 클릭시 확인메시지 -->
<script type="text/javascript">
        function confirmDelete() {
            // confirm 함수를 사용하여 사용자에게 메시지를 표시합니다.
            var result = confirm("정말 삭제하시겠습니까?");
            
            // 사용자가 확인을 눌렀을 때만 폼을 제출합니다.
	            if (result === true) {
	            // 삭제 페이지로 이동
	            window.location.href = "delete.po?p_num=<%=productDTO.getP_num()%>";
	        } else {
	            // 사용자가 취소를 눌렀을 때의 동작을 여기에 추가하세요 (예: 아무 동작 안 함).
	        }
        }
</script>
<!-- // 삭제하기 버튼 클릭시 확인메시지 -->

<!-- 판매확정하기 버튼 클릭시 확인메시지 -->
<script type="text/javascript">
        function confirmComplete() {
            // confirm 함수를 사용하여 사용자에게 메시지를 표시합니다.
            var result = confirm("정말 판매 확정 하시겠습니까?");
            
            // 사용자가 확인을 눌렀을 때만 폼을 제출합니다.
           if (result === true) {
	            // 삭제 페이지로 이동
	            window.location.href = "complete.po?p_num=<%=productDTO.getP_num()%>";
	        } else {
	            // 사용자가 취소를 눌렀을 때의 동작을 여기에 추가하세요 (예: 아무 동작 안 함).
	        }
        }
</script>
<!-- // 판매확정하기 버튼 클릭시 확인메시지 -->

<!-- 수정하기 버튼 클릭시 확인메시지 -->
<script type="text/javascript">
        function confirmUpdate() {
            // confirm 함수를 사용하여 사용자에게 메시지를 표시합니다.
            var result = confirm("정말 수정하시겠습니까?");
            
            // 사용자가 확인을 눌렀을 때만 폼을 제출합니다.
           if (result === true) {
	            // 삭제 페이지로 이동
	            window.location.href = "productUpdate.po?p_num=<%=productDTO.getP_num()%>";
	        } else {
	            // 사용자가 취소를 눌렀을 때의 동작을 여기에 추가하세요 (예: 아무 동작 안 함).
	        }
        }
</script>
<!-- // 수정하기 버튼 클릭시 확인메시지 -->

</head>
<body>

	<div id="modal-background" class="modal-background"></div>

	<!-- 헤더 들어가는 곳! -->
	<jsp:include page="../inc/top.jsp"></jsp:include>
	<!-- 헤더 들어가는 곳! -->

	<!-- breadcrumbs -->
	<div class="breadcrumbs">
		<div class="container">
			<ol class="breadcrumb breadcrumb1 animated wow slideInLeft"
				data-wow-delay=".5s">
				<li><a href="../index.jsp"><span
						class="glyphicon glyphicon-home" aria-hidden="true"></span>홈</a></li>
				<li class="active">상품 상세페이지</li>
			</ol>
		</div>
	</div>
	<!-- //breadcrumbs -->

	<%
	String id = (String) session.getAttribute("m_id");
	
	MemberDTO memberDTO = (MemberDTO) request.getAttribute("memberDTO");
	SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");
	%>



	<!-- 상품그림,제목,설명,관심도 등 -->
	<div class="products">
		<div class="container">
			<div class="agileinfo_single">

				<!-- 사진 -->
				<div class="col-md-4 agileinfo_single_left">
<%-- 				<a href="upload/<%=productDTO.getP_file()%>" download> </a>  --%>
					<img src="upload/<%=productDTO.getP_file()%>" width="300" height="300" style="margin : 0 auto; display:flex;"
					onclick="window.open('upload/<%=productDTO.getP_file() %>','이미지','width=500, height=700, scrollbars=yes')">
					<!-- 					<img id="example" src="../images/si1.jpg" alt=" " class="img-responsive"> -->

				</div>
				<!-- // 사진 -->
				

				<div class="col-md-8 agileinfo_single_right">

					<input type="hidden" value="<%=productDTO.getP_num()%>"
						name="p_num"> <input type="hidden"
						value="<%=productDTO.getM_id()%>" name="m_id"> <input
						type="hidden" value="<%=productDTO.getM_nick()%>" name="m_nick">

					<!-- 조회수 -->
					<div style="float: right;">
						<img src="images/readcountimg.png" width="20" height=20
							" alt="조회수"><i> : <%=productDTO.getP_readcount()%></i>
					</div>
					<!-- 조회수 -->

					<!-- 상품제목 -->
					<h2><%=productDTO.getP_title()%></h2>
					<!-- // 상품제목 -->

					<!-- 카테고리 -->
					<div class="snipcart-thumb agileinfo_single_right_snipcart">
						<h4 class="m-sing"><%=productDTO.getP_type()%></h4>
					</div>
					<!-- // 카테고리 -->
					
					<!-- 가격 -->
					<div class="snipcart-thumb agileinfo_single_right_snipcart">
						<h4 class="m-sing"><%=productDTO.getP_price()%></h4>
					</div>
					<!-- // 가격 -->

					<hr>

					<!-- 판매ID,상품상태,등록날짜 -->
					<div class="w3agile_description">
						<p>
							판매닉네임 :
							<%=productDTO.getM_nick()%></p>
						<p>
							상품상태 :
							<%=productDTO.getP_status()%></p>
						<p>
							등록날짜 :
							<%=format.format(productDTO.getP_date())%></p>
					</div>
					<!-- 판매ID,상품상태,등록날짜 -->

					<!-- 상품설명 -->
					<div class="w3agile_description">
						<h4>상품 상세설명 :</h4>
						<p>
							<%=productDTO.getP_detail()%>
						</p>
					</div>
					<!-- // 상품설명 -->

					
					<!-- 위시리스트 추가 -->
					<div class="snipcart-item block">
						<div class="snipcart-details agileinfo_single_right_details">
							<table>
								<form action="#" method="post">
								<fieldset>
								  <% 
                                        if(memberDTO != null){
                                        %>
									<input type="button" value="찜 추가하기" class="button addToWishlistButton"
   										 data-p-num="<%= productDTO.getP_num() %>"			
  										 data-m-num="<%= memberDTO.getM_num() %>">
  										  <%
                                        }else {
                                        	%>
                                        	<!-- <a href="login.me"><input type="button" value="로그인 하기" class="button"></button></a> -->
                                        	<%
                                        }
  										 %>
								</fieldset>
								</form>
							</table>
						</div>
					</div>
					<!-- // 위시리스트 추가버튼 -->

					<!--  로그인했을떄 아이디 일치시 수정,삭제,구매확정버튼 나오게하긔 -->
					<div class="checkout-right-basket">

						<%
						if (id != null) {
							if (id.equals(productDTO.getM_id())) {
						%>
						<a href="#" onclick="confirmUpdate()"><span
							class="glyphicon glyphicon-menu-left" aria-hidden="true"></span>상품수정</a>
						<a href="#" onclick="confirmDelete()"><span
							class="glyphicon glyphicon-menu-left" aria-hidden="true"></span>상품삭제</a>
						<a href="#" onclick="confirmComplete()"><span
							class="glyphicon glyphicon-menu-left" aria-hidden="true"></span>판매확정</a>
						<br> <br> <br>
						<!-- // 로그인했을떄 아이디 일치시 수정,삭제,구매확정버튼 나오게하긔 -->
						<!-- 상품등록자는 1:1채팅 신고하기 버튼 안보이게 하기 -->
						<%
						} else {
						%>
						<a href="#"
							onclick="window.open('chat.ch?ch_toID=<%=productDTO.getM_id()%>','1:1 채팅','width=500, height=800, scrollbars=yes')"><span
							class="glyphicon glyphicon-menu-left" aria-hidden="true"></span>1:1
							채팅</a> <a href="#"
							onclick="window.open('reportWrite.ad?r_m_target=<%=productDTO.getM_id()%>','신고하기','width=800, height=700, scrollbars=yes')"><span
							class="glyphicon glyphicon-menu-left" aria-hidden="true"></span>신고하기</a>
						<%
						}
						}
						%>
						<!-- // 상품등록자는 1:1채팅 신고하기 버튼 안보이게 하기 -->
						<!-- 항상보이게상품목록 버튼 -->
						<a href="products.po?p_num=<%=productDTO.getP_num()%>"><span
							class="glyphicon glyphicon-menu-left" aria-hidden="true"></span>상품목록</a>

					</div>
					<!-- //  항상보이게상품목록 버튼 -->

				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!-- // 상품그림,제목,설명,관심도 등 -->
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




	<!-- 푸터 들어가는 곳! -->
	<div class="clearfix">
		<jsp:include page="../inc/bottom.jsp"></jsp:include>
	</div>
	<!-- 푸터 들어가는 곳! -->


</body>
</html>
