<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script >
function goPopup(){
	var pop = window.open("jusoPopup.jsp","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 
}
	function jusoCallBack(roadFullAddr){
	document.frm.address.value = roadFullAddr;	
}
</script>
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
</head>
<body>
	<form method="post" action="#"  name="frm" >
		<input type="button" class="btn btn-primary" value="주소검색" onClick="goPopup();"><br>
		주소:<input type="text" style="width:500px;" name="address">
	
	</form>

</body>
</html>