<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="javax.xml.crypto.Data"%>
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
Date date=new Date();
SimpleDateFormat df=new SimpleDateFormat("YYYY/MM/dd a hh:mm:ss");
out.write("The date is：<br>");
out.write(df.format(date)+"<br>");

%>
</body>
</html>