<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL과 JSTL</title>
</head>
<body>
\${5+2} : ${5+2 } <br>
\${5/2} : ${5/2 } <br>
\${5 mod 2 } : ${5 mod 2} <br>
\${5>2 } : ${5>2 }<br>
\${2 gt 10 } : ${2 gt 10 }<br>

<%
String input = "";
String input2 = "dd";
%>
\${empty input} : ${empty input }<br>
\${empty input2} : ${empty input2 }<br>

</body>
</html>