<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
String success =(String)request.getAttribute("success");
%>
	<script type="text/javascript">
// 메세지 띄우고 뒤로 가기
alert("<%=success%>");
history.back();
</script>

<!-- 이렇게 하면 또 css로 화면 꾸며줘야 해서 위처럼 메세지 띄우기로 수정함 -->
<%-- <% --%>
<!-- String findid=(String)request.getAttribute("foundid"); -->
<%-- %> --%>
<%-- 찾은 아이디<%=findid %> --%>
</body>
</html>