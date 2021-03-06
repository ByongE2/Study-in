// CRUD ( Creat, Read, Update, Deleete ) , Realational DBMS 흠..

package com.it.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Database {

	private Connection conn; //mysql 연결
	private PreparedStatement pstmt; // sql 문장 전송
	private final String URL = "jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC";
	
	//드라이버 등록 : 한번만 등록하면된다. 커넥터.
	public Database() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("성공?"); 
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	//연결
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(URL,"root","1234");
//			System.out.println("접속 성공?");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	//연결 해제
	public void disConnection() {
		try {
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	//정보 가져오기
	public void mydbListData() {
		try {
			//1. MySql연결
			getConnection();
			//2. SQL문장 작성
			String sql = "select * from member";
			//3. MySql로 SQL문장 전송
			pstmt = conn.prepareStatement(sql);
			//4.실행결과를 받아 온다.
			ResultSet rs = pstmt.executeQuery();
			//5.결과를 출력
			
//			no integer auto_increment,  						/* auto_increment >> 숫자를 자동 증가 */
//		    name varchar(34) 				not null, 			/*not null >> 빈칸 입력 불가*/
//		    sex varchar(10) 				not null,
//		    content text,
			while(rs.next()) {
				System.out.println(rs.getInt(1) + "," + rs.getString(2) + "," + rs.getString(3) + "," + rs.getString(4) + "");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			disConnection();
		}
	}
	//추가(Insert)
	public void mydbInsert(int no, String name, String sex, String content) {
		try {
			//1.연결
			getConnection();
			//2.SQL문장 작성
			String sql="insert into member(no, name, sex, content) "
					+ "values(?,?,?,?)";
			//3.MySql로 SQL문장 전송
			pstmt = conn.prepareStatement(sql);
			//4.?,?,?,? 에 값을 채움
			pstmt.setInt(1, no);
			pstmt.setString(2, name);
			pstmt.setString(3, sex);
			pstmt.setString(4, content);
			//5.실행
			pstmt.executeUpdate(); // db값 변동시에는 executeUpdate.
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			disConnection();
		}
	}
	//수정
	public void mydbUpdate(int no, String name, String sex, String content) {
		try {
			getConnection();
			String sql = "update member set name = ?, sex = ?, content= ? where no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, sex);
			pstmt.setString(3, content);
			pstmt.setInt(4, no);
			pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			disConnection();
		}
	}
	//삭제
	public void mydbDelete(int no) {
		try {
			getConnection();
			String sql = "delete from member where no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			disConnection();
		}
	}
	//검색
	public void mydbOneSelect(int no) {
		try {
			getConnection();
			String sql = "select * from member where no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			ResultSet rs2 = pstmt.executeQuery();
			rs2.next(); 				//커서를 제일 앞으로 돌린다..?
			System.out.println(rs2.getInt(1) + "," + rs2.getString(2) + "," + rs2.getString(3) + "," + rs2.getString(4) + "");
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			disConnection();
		}
	}
	public static void main(String[] args) {

		Database db = new Database();
		db.getConnection();
		db.mydbListData();
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
//		db.mydbInsert(15, "스프링", "남자", "스프링으로테스트");
//		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
//		db.mydbListData();
//		db.mydbUpdate( 14, "스프링2", "남자", "수정테스트");
//		db.mydbUpdate( 15, "스프링3", "남자", "수정테스트 재확인");
//		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
//		db.mydbDelete(15);
//		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		db.mydbOneSelect(4);
		
	}

}
