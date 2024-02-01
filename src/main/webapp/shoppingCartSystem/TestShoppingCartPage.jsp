<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shopping Cart</title>
</head>
<body>
<h2>Welcome to My Shopping Mall</h2>
Please select an item to add or delete.
<form action="TestShoppingCartProcess.jsp" method="post">
<p>
<select name="product">
<option value="movie">Movie</option>
<option value="banana">Banana</option>
<option value="book">Book</option>
<option value="flower">Flower</option>
<option value="chocolate">Chocolate</option>
<option value="drink">Drink</option>

</select>
</p>
<input type="submit" value="add"/>
<input type="submit" value="delete"/>
</form>

</body>
</html>