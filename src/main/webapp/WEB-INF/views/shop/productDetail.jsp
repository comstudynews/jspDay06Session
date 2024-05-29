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
	<tr>
		<th>수량</th>
		<td>
			<select id="ea">
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
			</select>
		</td>
	</tr>
</table>

<script>
	var eaElement = document.getElementById("ea");
	function addCartFn(btn) {
		var ea = eaElement.value;
		var url = "cart_add.do?seq="+ btn.dataset.seq +"&ea="+ea;
		location.href = url;
	}
</script>
<a href="list.do">상품목록</a> | 
<a href="cart.do">장바구니목록</a> | 
<button data-seq="${product.seq }" onclick="addCartFn(this)">카트에추가</button>

</body>
</html>