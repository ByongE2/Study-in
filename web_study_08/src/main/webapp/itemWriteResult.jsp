<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String uid = "scott";
	String pass = "tiger";
	
	String sql = "insert into item values(?, ?, ?)";    
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품정보입력</title>
</head>
<body>
<%
request.setCharacterEncoding("UTF-8");

String name = request.getParameter("name");
String price = request.getParameter("price");
String description = request.getParameter("description");
try {
	//1. JDBC 드라이버 로드
	Class.forName("oracle.jdbc.driver.OracleDriver");
	//2. 데이터베이스 연결 객체인 Connetion 생성
	conn = DriverManager.getConnection(url, uid, pass);
	//3. PreparedStatement 객체 생성하기
	pstmt = conn.prepareStatement(sql);
	//4. 바인딩 변수 채우기
	pstmt.setString(1, name);
	pstmt.setInt(2, Integer.parseInt(price));
	pstmt.setString(3, description);
	//5. SQL문을 실행하여 결과 처리
	pstmt.executeUpdate();
} catch (Exception e) {
	e.printStackTrace();
} finally {
	//6. 사용한 리소스 해제
	try {
		if (pstmt != null)
	pstmt.close();
		if (conn != null)
	conn.close();
	} catch (Exception e) {
		e.printStackTrace();
	}

} //finally
%>
<h3>상품정보 등록이 완료되었습니다</h3>
<a href="itemWrite.jsp">전체 상품목록 보기</a>


</body>
</html>