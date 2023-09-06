<%@page import="com.itwillbs.domain.AdminDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>신고페이지</title>
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
String id = (String)session.getAttribute("m_id");
int m_level = (int)session.getAttribute("m_level");
AdminDTO adminDTO = (AdminDTO)request.getAttribute("adminDTO");

%>
<!--============================== 바디 ============================================-->
<div class="report">
	<div class="container">
			<h2>1 : 1 문의</h2>
			<form action="registeredPro.ad" method="post" class="report-form-grids_1_1">
			<input type="hidden" value="<%=adminDTO.getA_num()%>" name="a_num">
			<p>아이디</p>
			<input class="readonly" type="text" value="<%=adminDTO.getA_m_nick() %>" readonly="readonly"><br>
			<p>제목</p>
			<input class="title" type="text" value="<%=adminDTO.getA_title() %>" readonly="readonly"><br>
			<p>첨부파일</p>
			<div>
				<img src="adminUpload/<%=adminDTO.getA_file() %>" width="200px" height="200px" onclick="window.open('adminUpload/<%=adminDTO.getA_file() %>','이미지','width=500, height=700, scrollbars=yes')">
			</div><br>
			<p>문의내용</p>
			<textarea name="textarea" readonly="readonly"><%=adminDTO.getA_content() %></textarea><br>
			
			<%
			String answer = adminDTO.getA_answer() == null ? "" : adminDTO.getA_answer();
			if(m_level == 2){
			%>
			<p>답변내용</p>
			<textarea name="a_answer1"><%=answer %></textarea><br>
			<%}else{ %>
			<p>답변내용</p>
			<textarea name="a_answer2" readonly="readonly"><%=answer %></textarea><br>
			<%} %>
			<div class="reportbtn">
			<%if(m_level == 2){ %>
			<input type="submit" value="답변등록">
			<%} %>
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