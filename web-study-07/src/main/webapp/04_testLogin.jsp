<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL과 JSTL</title>
</head>
<body>
	입력한 정보(예전 방식). <hr>
	아이디 : <%request.getParameter("id"); %> <br>
	비밀번호: <%request.getParameter("pwd"); %> <br>
	<br>
	
	입력한 정보(EL)	<hr>
	아이디 : ${param.id}<br>
	비밀번호: ${param["pwd"] } <br>
	비밀번호: ${param.pwd }<br>

</body>
</html>