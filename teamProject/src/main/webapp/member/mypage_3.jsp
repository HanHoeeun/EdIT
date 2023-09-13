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

<!-- 회원탈퇴부분 -->


</head>
	
<body>
<!--================================== 헤더 ==================================== -->
<jsp:include page="../inc/top.jsp"></jsp:include>
	
<!--=========================== 상단 네비 ============================================ -->
	<div class="breadcrumbs">
		<div class="container">
			<ol class="breadcrumb breadcrumb1 animated wow slideInLeft" data-wow-delay=".5s">
				<li><a href="index.html"><span class="glyphicon glyphicon-home" aria-hidden="true"></span>홈</a></li>
				<li class="active">마이페이지</li>
				<li class="active">나의정보</li>
			</ol>
		</div>
	</div>
<!--=========================== 본문 헤더 =========================================== -->	
	<div class="top-brands_1">
		<h2>마이페이지</h2>
		
<!--=========================== 상단 탭 리스트============================================ -->
			<div class="container_2_1">

				<ul class="tabs">
					<li class="tab-link current" data-tab="tab-1">나의정보</li>
					<li class="tab-link" onclick="location.href='buylist.po'">전체판매목록</li>
					<li class="tab-link" onclick="location.href='buylist2.po'">판매완료목록</li>
					<li class="tab-link" onclick="location.href='m_wishlist.me'">찜</li>
					<li class="tab-link" onclick="location.href='m_adminpage.me'" >신고내역</li>
				</ul>
			</div>
		
<!--================================== 1탭 나의정보==================================== -->
<%
	MemberDTO memberDTO = (MemberDTO)request.getAttribute("memberDTO");
%>

		<div class="container_3_1">
			<form action="updatePro.me" method="post" id="profileForm">
				<div id="tab-1" class="tab-content current">
					<table class="mypage-board">
						<tr>
							<th class="_1qna_board_border1" colspan="2">나의정보</th>
						</tr>
<!-- 		----아이디---- -->
						 <tr>
							<td class="_1qna_board_border2">
								<div class="mypage-grids"> 
									<div align="center">
										<input type="text" class="show" placeholder="아이디" readonly="readonly"readonly>
										<input type="text" value="<%=memberDTO.getM_id() %>" id="m_id" name="m_id" readonly="readonly" style="background-color: #F5F5F5">
									</div>
								</div>
							</td>
						</tr>
						
<!-- 		----이름---- -->
						 <tr>
							<td class="_1qna_board_border2">
								<div class="mypage-grids"> 
									<div align="center">
										<input type="text" class="show" placeholder="이름" readonly="readonly">
										<input type="text" value="<%=memberDTO.getM_name() %>" id="m_name" name="m_name" readonly="readonly" style="background-color: #F5F5F5">
									</div>
								</div>
							</td>
						</tr>
						
<!-- 		----닉네임---- -->						
						 <tr>
							<td class="_1qna_board_border2">
								<div class="mypage-grids"> 
									<div align="center">
										<input type="text" class="show" placeholder="닉네임" readonly="readonly">
										 <input type="text" value="<%=memberDTO.getM_nick() %>" id="m_nick" name="m_nick" required="" onclick="clearValue('m_nick')">

										<br><div id="nick_error_message" class="nick_error_message"></div>
									</div>
								</div>
							</td>
						</tr>
<!-- 		----이메일---- -->							
						<tr>	
							<td class="_1qna_board_border2">
								<div class="mypage-grids"> 
									<div align="center">
										<input type="text" class="show" placeholder="이메일" readonly="readonly">
										 <input type="email" value="<%=memberDTO.getM_email()%>" id="m_email" name="m_email" required="" onclick="clearValue('m_email')">
										<br><div id="email_error_message" class="email_error_message"></div>
									</div>
								</div>
							</td>
						</tr>
<!-- 		----전화번호---- -->							
						<tr>	
							<td class="_1qna_board_border2">
								<div class="mypage-grids"> 
									<div align="center">
										<input type="text" class="show" placeholder="전화번호" readonly="readonly">
										<input type="tel" value="<%=memberDTO.getM_phone() %>" id="m_phone" name="m_phone" oninput="oninputPhone(this)" required="" onclick="clearValue('m_phone')"> 
										<br><div id="phone_error_message" class="phone_error_message"></div>
									</div>
								</div>
							</td>
						</tr>
						<tr>
							<td class="_1qna_board_border3" width="10">
							<div class="delete-button">
							<input type="submit" class="delete-button" value="수정">
							</div><br>
							<a id="password-change-link" href="#" onclick="window.open('pwupdate.me?m_num=','비밀번호 변경','width=800, height=700, scrollbars=yes')" style="font-size: 15px">비밀번호 변경</a><br>
							<a id="password-change-link" href="#" onclick="window.open('delete.me?m_num=','회원탈퇴','width=800, height=700, scrollbars=yes')" style="font-size: 12px">회원탈퇴</a>
							</td>
						
						</tr>
					</table>
				</div>
			</form>		
	</div>
</div>				
				
<!-- -----------------------------------------------------------------------------				 -->
<script type="text/javascript" src="script/jquery-3.7.0.js"></script>
<script type="text/javascript">

//전화번호 - 자동 생성
function oninputPhone(target) {
    target.value = target.value
        .replace(/[^0-9]/g, '')
        .replace(/(^02.{0}|^01.{1}|[0-9]{3})([0-9]{3,4})([0-9]{4})/g, "$1-$2-$3");
}
	

$(document).ready(function() {
//	닉네임 조건 + 중복검사		
    $('#m_nick').on('input', function() {
        var userNick = $(this).val();
        var userNickPattern = /^[a-zA-Z0-9ㄱ-힣]{2,}$/;
        var nick_error_message = $('#nick_error_message');

        if (userNick === "") {
            nick_error_message.text("닉네임을 입력하세요").css("color", "red");
            $('#m_nick').focus();
            return false;
        } else if (!userNickPattern.test(userNick)) {
            nick_error_message.text("최소 2자 입력하세요").css("color", "red");
            $('#m_nick').focus();
            return false;
        }

        $.ajax({
            type: 'POST', // 또는 'GET'에 따라 서버 측에서 처리 방식을 설정합니다.
            url: 'nickCheck.me', // 실제 서버 엔드포인트 URL을 지정합니다.
            data: {'m_nick': $('#m_nick').val() }, // 서버에 보낼 데이터를 설정합니다.
            success: function(result) {
                $('.nick_error_message').html(result);
                checkFormValidity();
            }
        });
    });
  


    
//	이메일 조건 + 중복검사		----성공
	$('#m_email').on('input', function() {
	    var userEmail = $(this).val();
	    var emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/; // 이메일 형식 검사
	    var email_error_message = $('#email_error_message');
	
	    if (userEmail === "") {
	        email_error_message.text("이메일을 입력하세요").css("color", "red");
	        $('#m_email').focus();
	        return false;
	    } else if (!emailPattern.test(userEmail)) {
	        email_error_message.text("유효한 이메일 형식이 아닙니다").css("color", "red");
	        $('#m_email').focus();
	        return false;
	    } else {
	        // 유효한 경우 에러 메시지를 지웁니다.
	        email_error_message.text("");
	    }
	
	    $.ajax({
	        type: 'POST', // 또는 'GET'에 따라 서버 측에서 처리 방식을 설정합니다.
	        url: 'emailCheck.me', // 실제 서버 엔드포인트 URL을 지정합니다.
	        data: {'m_email': $('#m_email').val() }, // 서버에 보낼 데이터를 설정합니다.
	        success: function(result) {
	            $('.email_error_message').html(result);
	            checkFormValidity();
	        }
	    });
	});
    
    
//	전화번호 중복체크
    $('#m_phone').on('input', function() {
        var userPhone = $(this).val(); // 입력된 전화번호
        var phone_error_message = $('#phone_error_message');

        if (userPhone === "") {
            phone_error_message.text("전화번호를 입력하세요").css("color", "red");
            $('#m_phone').focus();
            return false;
        } else if (!isValidPhoneNumber(userPhone)) {
            phone_error_message.text("유효한 전화번호 형식이 아닙니다").css("color", "red");
            $('#m_phone').focus();
            return false;
        } else {
            // 유효한 경우 에러 메시지를 지웁니다.
            phone_error_message.text("");
        }

        $.ajax({
            type: 'POST', // 또는 'GET'에 따라 서버 측에서 처리 방식을 설정합니다.
            url: 'phoneCheck.me', // 실제 서버 엔드포인트 URL을 지정합니다.
            data: {'m_phone': $('#m_phone').val() }, // 서버에 보낼 데이터를 설정합니다.
            success: function(result) {
                $('.phone_error_message').html(result);
                checkFormValidity();
            }
        });

        // 전화번호 유효성 검사 함수 (숫자 10자 또는 11자인지 확인)
        function isValidPhoneNumber(phoneNumber) {
            return /^[0-9-]{10,13}$/.test(phoneNumber); // 하이픈(-) 포함 형식으로 수정
        }
    });
    
    
})

 function clearValue(fieldId) {
    var inputField = document.getElementById(fieldId);
    inputField.value = ""; // 값을 지움
}

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