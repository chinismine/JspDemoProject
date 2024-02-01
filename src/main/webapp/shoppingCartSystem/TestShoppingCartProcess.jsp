<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="TestShoppingCartPage.jsp" %>
<jsp:useBean id="cart" class="my.learning.javabean.ShoppingCart" scope="session"/>
<jsp:setProperty property="submit" name="cart" param="submit"/>
<jsp:setProperty property="item" name="cart" param="product"/>

<!DOCTYPE html>
<html>
<% cart.processRequest(); %>
<font size="3" color="#ff0000">
	My Shopping Cart List：<br/>
	<%
	int i=1;
	for(String productitem:cart.getItems()){
		out.write((i++)+". "+productitem+"<br/>");
	}
	%>
	
</font>

</html>