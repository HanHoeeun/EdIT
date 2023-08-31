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
String findid=(String)request.getAttribute("foundid");
%>
찾은 아이디<%=findid %>
</body>
</html>