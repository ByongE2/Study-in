<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String id="asdf1234";
String pwd="1234";
String name="김김김";

if(id.equals(request.getParameter("id")) && pwd.equals(request.getParameter("pwd")) ){
	session.setAttribute("loginUser", name);
	response.sendRedirect("main.jsp");
}
else{response.sendRedirect("loginForm.jsp");
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 테스트</title>
</head>
<body>
	
	
	
</body>
</html>  