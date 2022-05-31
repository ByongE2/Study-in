<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품정보입력</title>
</head>
<body>
	<form action="itemWriteResult.jsp">
		<table>
			<tr>
				<th>상품제목</th>
				<td>
					<input type="text" name="name">
				</td>
			</tr>
			<tr>
				<th>가격</th>
				<td>
					<input type="text" name="price">
				</td>
			</tr>
			<tr>
				<th>상품설명</th>
				<td>
					<textarea row="5" cols="50" name="description"></textarea>
				</td>
			</tr>
		</table>
		<input type="submit" value="전송">
		<input type="reset" value="취소">
	</form>

</body>
</html>