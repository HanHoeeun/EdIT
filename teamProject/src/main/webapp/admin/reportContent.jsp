<%@page import="com.itwillbs.domain.ReportDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%
	ReportDTO reportDTO = (ReportDTO)request.getAttribute("reportDTO");
	
// 	자기 자신 또는 관리자만 신고 상세페이지 접근을 해야한다. 
	String m_id = (String)session.getAttribute("m_id");
	int m_level = 0;
    if (session.getAttribute("m_level") != null) {
        m_level = (int)session.getAttribute("m_level");
        // 관리자가 아니고 글쓴이도 아닌 경우
        if (m_level != 2 && !m_id.equals(reportDTO.getR_m_num_id())) {
%>
            <script>
                window.close();
            </script>
<%
        }
    }
%>


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

<!--============================== 바디 ============================================-->
<div class="report">
	<div class="container">
			<h2>신고 상세페이지</h2>
			<form class="report-form-grids_1_1" action="reportAnswer.ad" method="post" >		
				<input type="hidden" value="<%=reportDTO.getR_num() %>" name="r_num">
				<p>신고자 아이디</p>
				<input class="readonly" type="text" name="r_m_num_id" value="<%=reportDTO.getR_m_num_id() %>" readonly="readonly"><br>
				<p>신고대상자 아이디</p>
				<input class="readonly" type="text" name="r_m_target_id" value="<%=reportDTO.getR_m_target_id() %>" readonly="readonly"><br>
				<p>제목</p>
				<input class="title" type="text" name="r_title" value="<%=reportDTO.getR_title() %>" readonly="readonly" ><br>
				<%if(reportDTO.getR_file() != null) {%>
				<p>첨부파일</p>
				<div>
					<img src="upload/<%=reportDTO.getR_file() %>" width="200px" height="200px" onclick="window.open('upload/<%=reportDTO.getR_file() %>','이미지','width=500, height=700, scrollbars=yes')">
				</div><br>
				<%} %>
				<p>신고내용</p>
				<textarea name="r_content" readonly="readonly"><%=reportDTO.getR_content() %></textarea><br>
				<%
				String answer = reportDTO.getR_answer() == null ? "" : reportDTO.getR_answer();

				if(m_level == 2){%>
				<p>답변내용</p>
				<textarea name="r_answer"><%=answer %></textarea><br>
				<%}else{ %>
				<p>답변내용</p>
				<textarea name="r_answer" readonly="readonly"><%=answer %></textarea><br>
				<%} %>
				
				<div class="reportbtn">
					<%if(m_level == 2){%>
					<input type="submit" value="답변등록">
					<button type="button" id="reportbtn_btn_1" onclick="report_check();">신고적용</button>
					<%} %>
					<button type="button" id="reportbtn_btn_1" onclick="window.close()">닫기</button>
				</div>
			</form>
			<div id="reportReasonInput" style="display: none;">
   				<p>신고 사유</p>
   				<textarea id="reportReason"></textarea>
			</div>
	</div>
</div>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
function report_check() {
    var r_num = '<%=reportDTO.getR_num()%>';
    
    $.ajax({
        type: 'post',
        url: 'reportCheck.ad',
        data: {
            r_num: r_num
        },
        success: function(result) {
            if (result == 3) {
            	
                // 이유 입력을 위한 입력 필드 표시
                $("#reportReasonInput").show();
                
                // 사용자에게 신고 이유를 입력하도록 안내
                var reason = prompt("정지 이유를 입력하세요:");
                
                // 입력한 이유를 서버로 전송
                if (reason != null) {
                    $.ajax({
                        type: 'post',
                        url: 'updateBlackReason.ad',
                        data: {
                            r_num: r_num,
                            reason: reason
                        },
                        success: function(response) {
                            if (response == 'success') {
                                alert("블랙리스트 등록이 정상적으로 처리되었습니다.");
                                window.close();
                            } else {
                                alert("신고 처리 중 오류가 발생했습니다.");
                            }
                        }
                    });
                }
            } else {
            	window.opener.location.reload();
                window.close();
            }
        }
    });
}
</script>
<script src="js/bootstrap.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$().UItoTop({ easingType: 'easeOutQuart' });
			});
	</script>


</body>
</html>