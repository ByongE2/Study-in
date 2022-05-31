<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%!
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String uid = "scott";
	String pass = "tiger";
	String sql = "select * from member";
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<title>JDBC</title>
</head>
<body>
	<table class="table" width="800" border="1">
		<thead>
			<tr>
				<th>이름</th>
				<th>아이디</th>
				<th>암호</th>
				<th>이메일</th>
				<th>전화번호</th>
				<th>권한(1:관리자, 0:일반회원)</th>
			</tr>
		</thead>
		
		
			<%
			try {
				//1. 드라이브 로드
				Class.forName("oracle.jdbc.driver.OracleDriver");
				//2. 연결
				conn = DriverManager.getConnection(url, uid, pass);
				//3. sql문장 작성
				stmt = conn.createStatement(); //셀렉문 유동적으로 사용x  > pstmt로. 나중엔 쓸것.
				//4. sql문 실행
				rs = stmt.executeQuery(sql);
				//5. 실행된 결과물을 rs를 통해서 출력
				while (rs.next()) {
					
					
					out.println("<tr>");
					out.println("<td>" + rs.getString("name") + "</td>");
					out.println("<td>" + rs.getString("userid") + "</td>");
					out.println("<td>" + rs.getString("pwd") + "</td>");
					out.println("<td>" + rs.getString("email") + "</td>");
					out.println("<td>" + rs.getString("phone") + "</td>");
					out.println("<td>" + rs.getInt("admin") + "</td>");
					out.println("</tr>");
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				//6.실행된거 close.  역순으로, 예외처리도.
				try {
					if (rs != null)
				rs.close();
					if (stmt != null)
				rs.close();
					if (conn != null)
				rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			%>
		
</body>
</html>