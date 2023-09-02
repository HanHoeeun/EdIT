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
// 	아이디 비밀번호 찾기에서 메세지 띄우기
alert("<%=error%>");

history.back();
</script>



	
</body>
</html>