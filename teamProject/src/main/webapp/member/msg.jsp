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
// 	이름과 이메일이 다르면 나오는 메세지
alert("<%=error%>");

history.back();
</script>



	
</body>
</html>