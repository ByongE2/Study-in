<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true"%>    
<!DOCTYPE html PUBLIC " - //W3C//DTD HTML 4.01 Transitional//EN"
					  " - http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="test/html; charset=UTF-8">
<title>기본 에러 화면</title>
</head>
<body bgcolor="#ffffff" text="#000000">
<!-- 타이틀 시작 -->
기본 에러 화면 입니다.
<br><br>
<!-- 에러 메시지 -->

${exception.message}

</body>
</html>