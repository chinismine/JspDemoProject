<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isErrorPage="true" import="java.io.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Error info：<%=exception %><br/>
Exception PrintStackTraceInfo：<br/>
<%
	exception.printStackTrace(new PrintWriter(out));
%>
</body>
</html>