<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- 
서블렛에서 forward 해서 사용 
forward하면 주소가 변경 되지 않기때문에 request에 바인딩 된 데이터 사용 가능. 
-->
<!-- EL을 사용해서 바인딩 된 데이터 바로 사용 -->
<p>Name(request) : ${name }</p>
<p>Email(ssession) : ${ sessionScope.email }</p>
<hr/>
<a href="mem_input.jsp">mem_input.jsp로 이동</a>

</body>
</html>