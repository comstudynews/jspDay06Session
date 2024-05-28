<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>BindingGet.jsp</h1>
<%
//페이지 이동 이전에 "/ex01setattr" 요청 할때 바인딩 된 데이터 읽어서 사용
// setAttribute()에 저장 된것은 모두 Object형
// getAttribute() 할때 형변환 필수.
String appName = (String)application.getAttribute("appName");
String userName = (String)session.getAttribute("userName");

// JSP에 application, session, request, out등의 내장객체가 미리 준비 되었다.
out.println("App name은 " + appName + "<br/>");
out.println("User name은 " + userName + "<br/>");
// request는 URL이 변경되면 바인딩 된 데이터가 사라진다.
out.println("주소는 " + request.getAttribute("address") + "<br/>");
%>
</body>
</html>