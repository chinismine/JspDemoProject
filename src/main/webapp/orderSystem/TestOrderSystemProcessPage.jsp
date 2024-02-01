<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:useBean id="os2" class="my.learning.javabean.OrderSystem" scope="page"/>
<jsp:setProperty property="shipAddress" name="os2" param="shipAddress1"/>
<jsp:setProperty property="customer" name="os2" param="userName1"/>
<jsp:setProperty property="phone" name="os2" param="userPhone1"/>
<jsp:setProperty property="amount" name="os2" param="userAmount1"/>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Test Order System Process Page</title>
</head>
<body>

orderNumber：<jsp:getProperty property="orderNumber" name="os2"/><br/>
customer：<jsp:getProperty property="customer" name="os2"/><br/>
shipAddress：<jsp:getProperty property="shipAddress" name="os2"/><br/>
phone：<jsp:getProperty property="phone" name="os2"/><br/>
amount：<jsp:getProperty property="amount" name="os2"/><br/>
</body>
</html>