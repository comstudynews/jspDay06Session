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

<h1>상품 목록</h1>
<table border="1" width="500">
<c:forEach var="product" items="${pList }">
	<tr>
		<td><c:out value="${product.seq }"></c:out></td>
		<td><a href="detail.do?seq=${product.seq }">${product.title }</a></td>
		<td><c:out value="${product.price }"></c:out></td>
		<td><c:out value="${product.maker }"></c:out></td>
	</tr>
</c:forEach>
</table>
</body>
</html>