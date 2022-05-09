package com.it.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Database {

	private Connection con; //mysql 연결
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
			con = DriverManager.getConnection(URL,"root","1234");
			System.out.println("접속 성공?");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	//연결 해제
	public void disConnection() {
		try {
			if(pstmt!=null) pstmt.close();
			if(con!=null) con.close();
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
			pstmt = con.prepareStatement(sql);
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
	
	public static void main(String[] args) {

		Database db = new Database();
		db.getConnection();
		db.mydbListData();
		
	}

}
