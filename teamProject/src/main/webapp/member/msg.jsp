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


<script type="text/javascript">
<%
String error2 =(String)request.getAttribute("error");
%>
//	아이디와 이메일 다르면 나오는 메세지
	<script type="text/javascript">
alert("<%=error2%>");
	
history.back();
	</script>
</body>
</html>