<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL과 SJTL</title>
</head>
<body>
<c:set var="msg" value="Hello"/>
\${msg} = ${msg}<br>
<c:set var="age">
30
</c:set>
\${age} = ${age}<hr>

<c:set var="member" value=
	"<%= new com.saeyan.javabeans.MemberBean() %>"/>
<c:set target="${member}" property="name" value="전수빈"/>
<c:set target="${member}" property="userid" value="pinksubin"/>
\${member} = ${member}<hr>
\${name} = ${name}<hr>
\${name} = ${member.name}<hr>
\${userid} = ${userid}<hr>
\${userid} = ${member.userid}<hr>


	


</body>
</html>