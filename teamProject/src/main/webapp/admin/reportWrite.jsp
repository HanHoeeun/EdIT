<%@page import="com.itwillbs.domain.ProductDTO"%>
<%@page import="com.itwillbs.domain.MemberDTO"%>
<%@page import="com.itwillbs.domain.ReportDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%
int m_level = 0;
if (session.getAttribute("m_level") == null) {
    // 사용자의 m_level이 null이면 윈도우 창을 열지 않음
%>
    <script>
        alert("로그인이 필요합니다.");
        window.close();
    </script>
<%
} else {
    // 사용자의 m_level이 null이 아닌 경우 윈도우 창 열기
%>
<title>신고 페이지</title>
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

<body>
	<%
	ReportDTO reportDTO = (ReportDTO)request.getAttribute("reportDTO");

	%>
<!--============================== 바디 ============================================-->
	<div class="report">
		<div class="container">
			<h2>신고하기</h2>
			<form class="report-form-grids_1_1" action="reportWritePro.ad" method="post" enctype="multipart/form-data">		
				<p>신고자 아이디</p>
				<input class="readonly" type="text" name="m_id" value="<%=reportDTO.getR_m_num_id() %>" readonly="readonly"><br>
				<p>신고대상자 아이디</p>
				<input class="readonly" type="text" name="r_m_target" value="<%=reportDTO.getR_m_target_id() %>" readonly="readonly"><br>
				<p>제목</p>
				<input class="title" type="text" name="r_title" placeholder="제목을 입력하세요" required="required"><br>
				<p>첨부파일</p>
				<div>
					<input type="file" name="r_file" accept="image/*">
				</div>
				<br>
				<p>신고내용</p>
				<textarea name="r_content" placeholder="내용을 입력하세요" required="required"></textarea><br>
				<div class="reportbtn">
					<input type="submit" value="신고">
					<button type="button" id="reportbtn_btn_1" onclick="window.close()">취소</button>
				</div>
			</form>
<!-- 			<form class="report-form-grids" action="reportWritePro.ad" method="post" enctype="multipart/form-data"> -->

<!-- 				<p>신고대상자 아이디</p> -->
<%-- 				<input class="readonly" type="text" name="r_m_target" value="<%=reportDTO.getR_m_target_id()%>" readonly="readonly"><br> --%>
				
<!-- 				<p>신고자 아이디</p> -->
<%-- 				<input class="readonly" type="text" name="m_id" value="<%=reportDTO.getR_m_num_id()%>" readonly="readonly"><br> --%>
					
<!-- 				<p>제목</p> -->
<!-- 				<input class="title" type="text" name="r_title" placeholder="제목을 입력하세요" required=" "><br> -->
					
<!-- 				<p>첨부파일</p> -->
<!-- 				<div> -->
<!-- 					<input type="file" name="r_file" accept="image/*"> -->
<!-- 				</div> -->
<!-- 				<br> -->
				
<!-- 				<p>신고내용</p> -->
<!-- 				<textarea name="r_content" placeholder="내용을 입력하세요" required=" "></textarea> -->
<!-- 				<br> -->
<!-- 				<br> -->
				
<!-- 				<div class="reportbtn"> -->
<!-- 					<input type="submit" value="신고">  -->
<!-- 					<input type="button" value="취소" onclick="window.close()"> -->
<!-- 				</div> -->
<!-- 			</form> -->
		</div>
	</div>


	<!--================================== 푸터 ==================================== -->
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script type="text/javascript">
<%}%>

</script>
	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>
	<!-- here stars scrolling icon -->
	<script type="text/javascript">
		$(document).ready(function() {
			$().UItoTop({ easingType: 'easeOutQuart' });
			});
	</script>


</body>
</html>