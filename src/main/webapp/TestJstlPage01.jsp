<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL</title>
</head>
<body>
<c:set var="product">iPhone</c:set>
<c:set var="price" value="36000"/>
名稱：${product}<br/>
價格：${price}<br/>
<c:out value="名稱：${product}"/><br/>
<c:out value="價格：${price}"/><br/>

<c:if test="${price>32000}" var="exp">還是買吧</c:if><br/>

<hr>
<jsp:useBean id="os3" class="my.learning.javabean.OrderSystem" scope="page"></jsp:useBean>
<c:set target="${os3}" property="shipAddress" value="UK" />
<c:set target="${os3}" property="customer" value="Elvis" />
shipAddress：${os3.shipAddress}<br/>
customer：${os3.customer}<br/>
<hr>
<c:set var="month" value="2"/>
<c:choose>
<c:when test="${month==2}">
 Feb has 28-29days.<br/>
</c:when>
<c:otherwise>
other months has30-29days.<br/>
</c:otherwise>
</c:choose>
<hr>
<c:forEach var="i" begin="1" end="10" step="1" varStatus="check">
<c:if test="${check.first}">first<br></c:if>
i=${i}<br>
<c:if test="${check.last}">last<br></c:if>
</c:forEach>
<hr>
<c:set var="sequence" value="Mary/*John*-+Louis" />
<c:forTokens var="result" items="${sequence}" delims="*+-/">
${result}<br>
</c:forTokens>

</body>
</html>