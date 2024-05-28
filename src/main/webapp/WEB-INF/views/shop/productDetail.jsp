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

<h1>상품 상세보기</h1>
<table width="500" border="1">
	<tr>
		<th>번호</th><td>${product.seq }</td>
	</tr>
	<tr>
		<th>상품명</th><td>${product.title }</td>
	</tr>
	<tr>
		<th>가격</th><td>${product.price }</td>
	</tr>
	<tr>
		<th>메이커</th><td>${product.maker }</td>
	</tr>
</table>
<a href="list.do">상품 목록</a>
<a href="cart.do">장바구니 목록</a>
<a href="cart_add.do?seq=${product.seq }">장바구니에 추가</a>

</body>
</html>