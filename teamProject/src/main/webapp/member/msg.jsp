<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member/msg.jsp</title>
</head>
<body>
<%
String error =(String)request.getAttribute("error");
%>
	<script type="text/javascript">
// 		alert("아이디 비밀번호 틀림");
alert("<%=error%>");
		
		// 8.31 진 - 로그인 창에서 아이디 비밀번호 틀렸을때 이전 화면으로 돌아가면서 아이디 창 초기화 시키고 싶은데.. 왜 안되지..??
// 		var idInput = document.getElementById("id"); // 아이디 입력란의 id를 가져옴
//         idInput.value = "";
		
		history.back();
	</script>
</body>
</html>