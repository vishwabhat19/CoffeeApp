<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Products</title>
</head>
<body>
	<h1>Products</h1>
	
	<table>
	
		
			<tr>
				<th>Name</th>
				<th>Price</th>
			</tr>
			<c:forEach var="product" items="${products}">
			<tr>
				<td>${product.productName}</td>
				<td>${product.productPrice}</td>
			</tr>
			
		
		
	</table>
	
</body>
</html>