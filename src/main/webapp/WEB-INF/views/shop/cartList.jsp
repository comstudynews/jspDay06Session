<%@page import="org.comstudy.day06.shop.ProductDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
function removeCartFn(btn) {
	var seq = btn.dataset.seq;
	var url = "cart_remove.do?seq=" + seq;
	location.href = url;
}

window.onload = function() {
	
}
</script>
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
		ProductDTO product = (ProductDTO) pageContext.getAttribute("product");
		eaTotal += product.getEa();
		priceTotal += product.getPrice() * product.getEa();
	%>
	<tr>
		<td><c:out value="${product.seq }"></c:out></td>
		<td width="300"><a href="detail.do?seq=${product.seq }">${product.title }</a></td>
		<td><c:out value="${product.ea }"></c:out></td>
		<td><c:out value="${product.price * product.ea }"></c:out></td>
		<td><button data-seq="${product.seq }" onclick="removeCartFn(this)">카트에서 제거</button></td>
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
<a href="list.do">상품목록</a>
</body>
</html>