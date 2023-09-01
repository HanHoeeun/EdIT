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
<script type="text/javascript">
function oninputPhone(target) {
    target.value = target.value
        .replace(/[^0-9]/g, '')
        .replace(/(^02.{0}|^01.{1}|[0-9]{3})([0-9]{3,4})([0-9]{4})/g, "$1-$2-$3");
}
</script>
<!-- header -->
	<!-- //breadcrumbs -->
	<!-- top-brands -->
	
	<div class="top-brands_1">
			<h2>회원정보 상세페이지</h2>
		<div class="_1container_1_1">
			<form class="_1report_content_form" action="user_contentPro.ad" method="post">		
			<table class="_1report_content_board">
				<tr>
				<td class="_1report_content_border">회원번호</td>
				<td><input type="text" value="<%=memberDTO.getM_num() %>" name="m_num" readonly="readonly" style="border:none;"></td>
				</tr>				
				<tr>
				<td class="_1report_content_border">아이디</td>
				<td><input type="text" value="<%=memberDTO.getM_id() %>" name="m_id" style="border:none;"></td>
				</tr>				
				<tr>
				<td class="_1report_content_border">이름</td>
				<td><input type="text" value="<%=memberDTO.getM_name() %>" name="m_name" style="border:none;"></td>
				</tr>				
				<tr>
				<td class="_1report_content_border">닉네임</td>
				<td><input type="text" value="<%=memberDTO.getM_nick() %>" name="m_nick" style="border:none;"></td>
				</tr>				
				<tr>
				<td class="_1report_content_border">전화번호</td>
				<td><input type="text" value="<%=memberDTO.getM_phone() %>"  oninput="oninputPhone(this)" name="m_phone" style="border:none;"></td>
				</tr>				
				<tr>
				<td class="_1report_content_border">이메일</td>
				<td><input type="text" value="<%=memberDTO.getM_email() %>" name="m_email" style="border:none;"></td>
				</tr>				
				<tr>
				<%
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				%>
				<td class="_1report_content_border">가입날짜</td>
				<td><input type="text" value="<%=format.format(memberDTO.getM_date()) %>" name="m_date" readonly="readonly" style="border:none;"></td>
				</tr>				
				<tr>
				<td class="_1report_content_border">이벤트</td>
				<td><input type="text" value="<%=memberDTO.getM_event() %>" name="m_event" style="border:none;"></td>
				</tr>				
				<tr>
				<td class="_1report_content_border">회원레벨</td>
				<td><input type="text" value="<%=memberDTO.getM_level() %>" name="m_level" style="border:none;"></td>
				</tr>				
				<tr>
				<td class="_1report_content_border">회원벌점</td>
				<td><input type="text" value="<%=memberDTO.getM_count() %>" name="m_count" style="border:none;"></td>
				</tr>				
				<tr>
				<td class="_1report_content_border">수정 비밀번호</td>
				<td><input type="password" name="admin_pass" style="border:none;" required="required" ></td>
				</tr>				
					
			</table>
					<div class="_1q_query_btn">
							<button type="submit">수정</button>
							<button type="button" onclick="window.close()">닫기</button>
					</div>
			</form>
		</div>
	<div class="clearfix_1_1"> </div>
</div>
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