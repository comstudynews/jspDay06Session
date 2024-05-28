<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 이름과 이메일 입력</title>
</head>
<body>

<h1>회원 이름과 이메일 입력</h1>
<form action="result" method="POST">
	Name: <input type="text" name="name" value="user01" /><br/>
	Email: <input type="text" name="email" value="user01@comstudy.com" /><br/>
	<input type="submit" value="Send" />
</form>

</body>
</html>