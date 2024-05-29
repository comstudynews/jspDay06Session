<%@page import="org.comstudy.day06.shop.ProductDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>장바구니 목록</h1>
<%
int eaTotal = 0;
int priceTotal = 0;
%>
<table border="1" width="500">
<tbody>
<c:forEach var="product" items="${cartList }">
	<%
		eaTotal += 0;
		priceTotal += 0;
	%>
	<tr>
		<td><c:out value="${product.seq }"></c:out></td>
		<td><a href="detail.do?seq=${product.seq }">${product.title }</a></td>
		<td><c:out value="${product.ea }"></c:out></td>
		<td><c:out value="${product.price }"></c:out></td>
		<td><button>카트에서 제거</button></td>
	</tr>
</c:forEach>
</tbody>
	<tfoot>
		<tr>
			<th colspan="2">합 계</th>
			<td><c:out value="<%=eaTotal %>"></c:out></td>
			<td><c:out value="<%=priceTotal %>"></c:out></td>
			<td> </td>
		</tr>
	</tfoot>
</table>

</body>
</html>