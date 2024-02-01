<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <jsp:useBean id="orderSystem" class="my.learning.javabean.OrderSystem" scope="page"></jsp:useBean>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
OrderNumber1=<jsp:getProperty property="orderNumber" name="orderSystem"/> <br/>
OrderNumber2=${orderSystem.orderNumber}<br/>
Customer=${orderSystem.customer}<br/>

<%
HashMap<String, String> infos=new HashMap<String, String>();
infos.put("user","Julia");
infos.put("age","14");
request.setAttribute("profiles", infos);

%>
User:${profiles.user} <br/>
User:${profiles.age} <br/>

</body>
</html>