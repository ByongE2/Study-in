<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quiz_8</title>
</head>
<body>
<%
java.util.List<String> seasonList = new java.util.ArrayList<String>();
seasonList.add("봄");
seasonList.add("여름");
seasonList.add("가을");
seasonList.add("겨울");
request.setAttribute("list", seasonList);
%>
	<select name="season">
		<option value="봄">봄</option>
		<option value="여름">여름</option>
		<option value="가을">가을</option>
	</select>


</body>
</html>