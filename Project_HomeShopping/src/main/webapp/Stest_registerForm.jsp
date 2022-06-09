<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*, javax.sql.*"%>
    
<%
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String id = "system";
	String pwd = "1234";
	String sql = "insert into member_tbl_02()";
	int custno = 100001;

	try{
		
	Class.forName("oracle.jdbc.driver.OracleDriver");
	conn = DriverManager.getConnection(url, id, pwd);
	pstmt = conn.prepareStatement(sql);
	rs = pstmt.executeQuery();
	
	if(rs.next()){
		custno =rs.getInt(1)+1;
	}
%>    
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="Stest_style.css">
<title>쇼핑몰 회원 관리</title>
</head>
<body>
	<%@include file="Stest_header.jsp"%>
	<section>
		<h2>홈쇼핑 회원 등록</h2>
		<form action="Stest_registerForm_Impl.jsp" method="post">
			<table>
				<tr>
					<th>회원번호(자동발생)</th>
					<td><input type="text" name="custno" value=""></td>
				</tr>		
				<tr>
					<th>회원성명</th>
					<td><input type="text" name="custname" value=""></td>
				</tr>		
				<tr>
					<th>회원전화</th>
					<td><input type="text" name="phone" value=""></td>
				</tr>		
				<tr>
					<th>회원주소</th>
					<td><input type="text" name="address" value=""></td>
				</tr>		
				<tr>
					<th>가입일자</th>
					<td><input type="text" name="joindate" value=""></td>
				</tr>		
				<tr>
					<th>고객등급[A:VIP,B:일반,C:직원]</th>
					<td><input type="text" name="grade" value=""></td>
				</tr>		
				<tr>
					<th>도시코드</th>
					<td><input type="text" name="city" value=""></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="등록">
						<input type="button" value="조회" onclick="location.href='Stest_listForm.jsp'">
					</td>	
				</tr>		
			</table>
		</form>	
	</section>		

	<%@include file="Stest_footer.jsp"%>


</body>
</html>
<%
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(conn != null) conn.close();
	}
%>
