<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Jsp Page</title>
</head>
<body>
WELCoME02
<%!
	public static final double PI=3.1415;
	public String name="Mary";

%>
<%!
	public String getName(){
	return name;
}
%>
<%
	out.write("</br>");	
	int i=5;
	out.write("i="+i+"</br>");
	int sum=0;
	for(int j=1;j<=10;j++){
		sum=sum+j;
		
	}
	
	out.write("sum="+sum+"</br>");
	out.write("name="+getName()+"</br>");
%>
The expression is <%=3*5 %>
<% out.write("</br>");%>
Today:<%=new java.util.Date() %>

</body>
</html>