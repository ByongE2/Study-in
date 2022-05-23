<!-- 스크립트 + 표현식 같이. 에러나면 코드 다보임. -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% // 스크립트
		int num1 = 20;
		int num2 = 10;
		int add = num1 + num2;
	%>
	<!-- 표현식 -->
	<%=num1%> + <%=num2%> = <%=add%>

</body>
</html>