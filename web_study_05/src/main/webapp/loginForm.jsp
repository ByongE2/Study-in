<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP로그인화면</title>
</head>
<body>
	<form method="post" action="test_Login.jsp">
		<label for="userid"> 아이디 : </label>
		<input type="text" name="id" id="userid"><br>
		
		<lebel for="userpwd"> 암 &nbsp; 호 : </lebel>
		<input type="password" name="pwd" id="userpwd"><br>
		
		<input type="submit" value="로긴">
	</form>
</body>
</html>