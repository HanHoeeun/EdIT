<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.logging.SimpleFormatter"%>
<%@page import="com.itwillbs.domain.MemberDTO"%>
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
<title>Super Market an Ecommerce Online Shopping Category Flat Bootstrap Responsive Website Template | Faq :: w3layouts</title>
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
<link href="css/faq_1.css" rel="stylesheet"> 
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
<%
MemberDTO memberDTO = (MemberDTO)request.getAttribute("memberDTO");
%>

<!-- header -->
	<!-- //breadcrumbs -->
	<!-- top-brands -->
	
	<div class="top-brands_1">
			<h2>비밀번호 변경</h2>
		<div class="_1container_1_1">
			<form class="_1report_content_form" action="pwupdatePro.me" method="post">		
			<table class="_1report_content_board">
				<tr>
				<td class="_1report_content_border">아이디</td>
				<td><input type="text" value="<%=memberDTO.getM_id() %>" name="m_id" style="border:none;" readonly="readonly"></td>
				</tr>				
				<tr>
				<td class="_1report_content_border">이름</td>
				<td><input type="text" value="<%=memberDTO.getM_name() %>" name="m_name" style="border:none;"></td>
				</tr>	
				<tr>						
				<td class="_1report_content_border">현재비밀번호</td>
				<td><input type="password" value="<%=memberDTO.getM_pass() %>" name="m_pass" style="border:none;"></td>
				</tr>	
				<tr>						
				<td class="_1report_content_border">새비밀번호</td>
				<td><input type="password" placeholder="새비밀번호" name="m_pass2" style="border:none;"></td>
				</tr>	
				<tr>						
				<td class="_1report_content_border">새비밀번호확인</td>
				<td><input type="password" placeholder="새비밀번호확인" name="m_pass3" style="border:none;">
				</td>
				</tr>							
					
			</table>
			<div id="result"></div>
					<div class="_1q_query_btn">
							<button type="submit">수정</button>
							<button type="button" onclick="window.close()">닫기</button>
					</div>
			</form>
		</div>
	<div class="clearfix_1_1"> </div>
</div>


<script type="text/javascript" src="script/jquery-3.7.0.js"></script>
<script type="text/javascript">

/* //수정 버튼 클릭 이벤트 핸들러
document.querySelector('.button[type="submit"]').addEventListener('click', function () {
    // 여기에서 비밀번호 수정을 서버로 요청하고, 성공 여부를 확인합니다.
    // isSuccess 변수에 수정 성공 여부를 할당합니다.
    var isSuccess = requestPasswordUpdate(); // 예시 함수, 실제 구현 필요

    if (isSuccess) {
        // 수정 성공한 경우 윈도우 창을 닫습니다.
        window.close();
    } else {
        // 수정 실패 시 사용자에게 알림 등을 처리할 수 있습니다.
        alert('비밀번호 수정에 실패했습니다.');
    }
}); */


$(document).ready(function() {
	  $('.submit').on('click', function() {
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

<!-- //top-brands -->
<!-- Bootstrap Core JavaScript -->
<script src="js/bootstrap.min.js"></script>
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
<script src="js/minicart.min.js"></script>
<script>
	// Mini Cart
	paypal.minicart.render({
		action: '#'
	});

	if (~window.location.search.indexOf('reset=true')) {
		paypal.minicart.reset();
	}
</script>

<script type="text/javascript" src="script/jquery-3.7.0.js"></script>	
<script type="text/javascript">	




				
				
</script>	


<!-- main slider-banner -->
<script src="js/skdslider.min.js"></script>
<link href="css/skdslider.css" rel="stylesheet">
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