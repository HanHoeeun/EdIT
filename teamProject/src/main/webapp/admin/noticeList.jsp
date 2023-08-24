<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>admin/noticeList.jsp</title>
<link href= "../css/top.css" rel= "stylesheet" type="text/css">
<link href= "../css/noticeList.css" rel= "stylesheet" type="text/css">
<link href= "../css/bottom.css" rel="stylesheet" type="text/css">
</head>

<body>
<!--======================================= 헤더 =====================================-->
	<header id="_3header">
		<!-- 액션태그 : jsp문법, 태그처럼 사용, 웹의 경로 지정 -->
		<!-- include 액션태그 : 반복되는 화면을 파일로 만들고 파일을 가져다가 사요 -->
		<jsp:include page="../top.jsp"></jsp:include>
	</header>
<!--======================================= 헤더 =====================================-->
	<div class="_3q_writer">
<!-- ==============================	홈 > 공지사항 > 일반공지 ==================================-->
		<div class="_3line">
			<img class="_3line_img" src="../img/home.png" width="25px" height="25px">
			<p>홈</p>
			<p>></p>
			<p>공지사항</p>
			<p>></p>
			<p>일반공지</p>
		</div>

<!--================================== 사이드메뉴 ====================================  -->
		<div class="_3sidemenu">
			<table>
				<tr>
					<td><a href="test.jsp">일반 공지</a></td>
				</tr>
				<tr>
					<td><a href="test.jsp">개인정보처리방침 및 이용약관</a></td>
				</tr>
			</table>
		</div>
<!--====================================== 게시판 =========================================  -->		
			<div class="_3notice_board" >
			<h1>일반공지</h1>
				<table border="1">
				<tr>				
				<th>번호</th>
				<th>제목</th>
				<th>등록일</th>			
				</tr>
					<tr>
						<td class="_3num">1</td>
						<td class="_3title">거래 시 유의사항</td>
						<td class="_3date">2023-08-20</td>
					</tr>
					<tr>
						<td class="_3num">2</td>
						<td class="_3title">신고 누적 3회 이상 회원 계정 정지됨을 알려드립니다</td>
						<td class="_3date">2023-08-07</td>
					</tr>
					<tr>
						<td class="_3num">2</td>
						<td class="_3title">신고 누적 3회 이상 회원 계정 정지됨을 알려드립니다</td>
						<td class="_3date">2023-08-07</td>
					</tr>
					<tr>
						<td class="_3num">2</td>
						<td class="_3title">신고 누적 3회 이상 회원 계정 정지됨을 알려드립니다</td>
						<td class="_3date">2023-08-07</td>
					</tr>
				</table>
			</div>
		</div>

	<div class="clear">
		<br> <br> <br>
	</div>
<!--====================================== 푸터 ======================================-->
	<footer>
		<jsp:include page="../bottom.jsp"></jsp:include>
	</footer>
</body>
</html>