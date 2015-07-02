<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome <%=session.getAttribute("name")%></title>  
</head>  
<body>  
    <h3>Login successful!!!</h3>  
    <h4>  Hello, <%=session.getAttribute("name")%></h4>
    
    <form action="addNewPost" method="GET">
		Enter New  Post : <input type="text"  name="txtNewPost"> <br>
		Enter todayDate : <input type="date"  name="txtDate"> <br>
		<input type="hidden" name="username" value=<%=session.getAttribute("name")%>>
		<input type="submit" value="Add Post"><br>
		<a href="./viewPost">View Posts</a>
	</form>
</body>  
</html>  
