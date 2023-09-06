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
// 	메세지 띄우고 뒤로 가기
alert("<%=error%>");

history.back();
</script>



	
</body>
</html>