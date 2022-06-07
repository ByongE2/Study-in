//커넥션 풀 사용 안하고.

package com.it.dao;

import java.util.*; // List쓸때
import java.sql.*;  // Connection, PreparedStatement, ResultSet


public class BoardDAO {
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	
	private final String URL = "jdbc:mysql://localhost:3306/db0416?serverTimezone=UTC";
	private final String USERNAME = "root";
	private final String PASSWORD = "1234";

	//드라이버 등록
	public BoardDAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); //드라이브 메모리 할당
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//BoardDAO
	
	//MySql 연결
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//getConnection
	
	//MySql 해제
	public void disConnection() {
		try {
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//disConnection
	
	//1.목록출력
	// 게시물 정보 한개 : BoardVO, 게시물 여러개 : (LIST)
	public List<BoardVO> boardListData(int page){
		
		List<BoardVO> list = new ArrayList<>();
		
		try {
			//1. 연결
			getConnection();
			//2. sql문장 작성?제작?
			int rowSize = 10;
				// 10*1 - 10 = 0, ... , 10*2-10=10 , ... , 10*3-10=20 .....
			int start = (rowSize*page) - rowSize;
			String sql = "select no, subject, name, DATE_FORMAT(regdate,'%y-%m-%d'), hit " // 줄바꿈 시 마지막 공백 습관 들이자.
						+ "from jspBoard order by no desc limit ?,?";
			//3. 전송
			pstmt = conn.prepareStatement(sql);
			//4. 데이터 채우기
			pstmt.setInt(1, start);
			pstmt.setInt(2, rowSize);
			//5. 데이터 실행
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setNo(rs.getInt(1)); // vo.setNo(rs.getInt(no));
				vo.setSubject(rs.getString(2));
				vo.setName(rs.getString(3));
				vo.setDbday(rs.getString(4));
				vo.setHit(rs.getInt(5));
				list.add(vo);
			}
			//6. 닫기
			rs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				
			} catch (Exception e) {
				disConnection();
			}
		}
		return list;
	}//boardListData
	
	//2. 총페이지()
	public int boardTotalPage() {
		
		int total = 0;
		
		try {
			
			getConnection();
			String sql = "select ceil(count(*)/10.0) from jspBoard";
			
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				total = rs.getInt(1);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disConnection();
		}
		return total;
	}//boardTotalpage
	
	//3. 새 글 입력. 글쓰기> 입력
	public void boardInsert(BoardVO vo) {
		try {
			getConnection();
//			String sql = "insert into jspBoard values(?,?,?,?,now())";
			String sql = "insert into jspBoard(name,subject,content,pwd,regdate) " + "values(?,?,?,?,now())";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getSubject());
			pstmt.setString(3, vo.getContent());
			pstmt.setString(4, vo.getPwd());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disConnection();
		}
	}//boardInsert
	
	//상세보기(조회수 담당)
	public BoardVO boardDetailData(int no) {
		BoardVO vo = new BoardVO();
		
		try {
			getConnection();
			//hit, 조회수 증가
			String sql = "update jspBoard set hit = hit+1 where no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.executeUpdate();
			
			sql = "select no, name, subject, content, DATE_FORMAT(regdate,'%Y-%m-%d'), hit from jspBoard where no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo.setNo(rs.getInt(1));
				vo.setName(rs.getString(2));
				vo.setSubject(rs.getString(3));
				vo.setContent(rs.getString(4));
				vo.setDbday(rs.getString(5));
				vo.setHit(rs.getInt(6));
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disConnection();
		}
		return vo;
	}//boardDetailDate
	
	//5. 게시판 수정하기(Update)
	public BoardVO boardUpdateData(int no) {
		BoardVO vo = new BoardVO();
		
		try {
			getConnection();
			
			String sql = "select no, name, subject, content, DATE_FORMAT(regdate,'%Y-%m-%d'), hit from jspBoard where no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo.setNo(rs.getInt(1));
				vo.setName(rs.getString(2));
				vo.setSubject(rs.getString(3));
				vo.setContent(rs.getString(4));
				vo.setDbday(rs.getString(5));
				vo.setHit(rs.getInt(6));
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disConnection();
		}
		return vo;
	}//boardUpdateData
	
	public boolean boardUpdate(BoardVO vo) {
		boolean check = false;
		
		try {
			getConnection();
			
			String sql = "select pwd from jspBoard where no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getNo());
			ResultSet rs = pstmt.executeQuery();
			String check_pwd="";
			
			if(rs.next()) {
				check_pwd = rs.getString(1);
				
				rs.close();
			}
			if(check_pwd.equals(vo.getPwd())) {
				check = true;
				sql = "update jspBoard set name=?, subject=?, content=? where no=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, vo.getName());
				pstmt.setString(2, vo.getSubject());
				pstmt.setString(3, vo.getContent());
				pstmt.setInt(4, vo.getNo());
				pstmt.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disConnection();
		}
		return check;
	}//boardUpdate
	
	public int boadrDelete(int no, String pwd) {
		int result = 0;
		
		try {
			//연걸
			getConnection();
			//sql문장
			String sql = "select pwd from jspBoard where no=?";
			//전송
			pstmt = conn.prepareStatement(sql);
			//빈칸 채우기
			pstmt.setInt(1, no);
			//실행
			ResultSet rs = pstmt.executeQuery();
			String check_pwd="";
			
			if(rs.next()) {
				check_pwd = rs.getString(1);
				
				rs.close();
			}
			if(check_pwd.equals(pwd)) {
				result = 1;
				sql = "delete from jspBoard where no=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, no);
				pstmt.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disConnection();
		}
		return result;
	}//boadrDelete
}
