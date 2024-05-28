<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
if(session.getAttribute("username") == null) {
	response.sendRedirect(request.getContextPath() + "/member/login.do");
}
%>

<h1>Welcome to my home</h1>
<p>${username }님 환영 합니다!</p>
<p><a href= "<%=request.getContextPath() %>/member/login.do">로그아웃</a></p>

</body>
</html>