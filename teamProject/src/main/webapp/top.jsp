<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- <meta name="viewport" content="width=device-width, initial-scale=1"> -->
<link rel="stylesheet" href="css/top.css">

<title>Insert title here</title>
</head>
<body>
	<div class="_01">
		<div class="navigation">
			<div class="logo_search">
				<form action="test.jsp" id="search_form">
					<div class="logo">
					<a href="test.jsp">
					<img class="logo_img" src="img/logo.png" width="245px" height="63px" />
					</a>						
					</div>
					<div class="search">
						<input type="text" placeholder="검색어 입력" onkeyup="enterKey();">
						<img class="search_img" src="img/search.png" onclick="fun1()">
					</div>
				</form>
			</div>
		</div>
		<%
		// 로그인 하면 -> 로그인한 정보를 세션에 저장
		// 세션에 로그인 정보 가져오기
		String id = (String) session.getAttribute("id");
		// 세션에 로그인 정보가 없으면 => 로그인 | 회원가입
		// 세션에 로그인 정보가 있으면 => ..님 로그아웃 logout, 회원정보 수정 update
		%><div class="icon">
			<%
			if (id == null) {
			%>
			<div id="login">
				<img src="img/user1.png" width="20px" height="20px"><a href="login.me">LOGIN</a> 
				<img src="img/join.png" width="20px" height="20px"><a href="login.me">JOIN US</a>
				<img src="img/mypage.png" width="20px" height="20px"><a href="login.me">MY PAGE</a> 
				<img src="img/wishlist.png" width="20px" height="20px"><a href="login.me">WISHLIST</a> 
				<img src="img/chat.png" width="20px" height="20px"><a href="login.me">1:1 CHAT</a>
			</div>
			<%
			} else {
			%>
			<div id="login">
				<a href="logout.me"><%=id%>님 logout</a> | <a href="update.me">update</a>
				| <a href="delete.me">delete</a> | <a href="update.me">update</a>
			</div>
			<%
			}
			%>
		</div>
		<div class="category">
			<div class="category2">
				<div class="need-help">
					<a href="">노트북</a>
				</div>
				<div class="need-help">
					<a href="">테블릿</a>
				</div>
				<div class="need-help">
					<a href="">휴대폰</a>
				</div>
				<div class="need-help">
					<a href="">공지사항</a>
				</div>
				<div class="need-help">
					<a href="">고객센터</a>
				</div>
			</div>
		</div>
	</div>
<script type="text/javascript">
function fun1(){
	document.getElementById('search_form').submit();
}
function enterKey(){
	if(window.event.keyCode == 13){ // Enter 키 코드값 13
		fun1();
	}
}
</script>

</body>
</html>