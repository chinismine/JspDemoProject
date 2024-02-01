<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order System</title>
</head>
<body>
<h2>Order System</h2>
<form action="../OrderSysyemAction.do" method="post">
Customer：<input type="text" name="userName"><br/>
ShipAddress：<input type="text" name="shipAddress"><br/>
phone：<input type="text" name="userPhone"><br/>
amount：<input type="text" name="userAmount"><br/>
<p></p>
<button type="submit">send</button>

</form>


</body>
</html>