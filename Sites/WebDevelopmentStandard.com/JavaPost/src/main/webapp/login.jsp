<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Form</title>
</head>
<body>
	<form action="loginServlet" method="POST">
		Enter username : <input type="text"     name="txtUsername"> <br>
		Enter password : <input type="password" name="txtUserpass"> <br>
		<input type="submit" value="Login">
	</form>
</body>
</html>
