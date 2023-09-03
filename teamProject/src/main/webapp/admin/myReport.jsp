<%@page import="com.itwillbs.domain.ReportDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>나의 신고 내역</title>
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
<link href="css/style_1_1.css" rel="stylesheet" type="text/css" media="all" />
<!-- font-awesome icons -->
<link href="css/font-awesome.css" rel="stylesheet"> 
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
</head>
<%
ReportDTO reportDTO = (ReportDTO)request.getAttribute("reportDTO");

%>

<!--============================== 바디 ============================================-->
<div class="report">
	<div class="container">
			<h2>나의 신고 내역</h2>
			<form class="report-form-grids_1_1" action="report_answer.ad" method="post" >		
				<input type="hidden" value="<%=reportDTO.getR_num() %>" name="r_num">
				<p>신고자 아이디</p>
				<input class="readonly" type="text" name="r_m_num_id" value="<%=reportDTO.getR_m_num_id() %>" readonly="readonly"><br>
				<p>신고대상자 아이디</p>
				<input class="readonly" type="text" name="r_m_target_id" value="<%=reportDTO.getR_m_target_id() %>" readonly="readonly"><br>
				<p>제목</p>
				<input class="title" type="text" name="r_title" value="<%=reportDTO.getR_title() %>" readonly="readonly" ><br>
				<p>첨부파일</p>
				<div>
					<img src="adminUpload/<%=reportDTO.getR_file() %>" width="200px" height="200px" onclick="window.open('adminUpload/<%=reportDTO.getR_file() %>','이미지','width=500, height=700, scrollbars=yes')">
				</div><br>
				<p>신고내용</p>
				<textarea name="r_content" readonly="readonly"><%=reportDTO.getR_content() %></textarea><br>
				<p>답변내용</p>
				<textarea name="r_answer" readonly="readonly"><%=reportDTO.getR_answer() %></textarea><br>
				<div class="reportbtn">
					<button type="button" id="reportbtn_btn_1" onclick="window.close()">확인</button>
				</div>
			</form>
	</div>
</div>

	<!--============================================== footer =========================-->

	
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