package com.saeyan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.saeyan.dto.BoardVO;

import util.DBManager;

public class BoardDAO {

	private BoardDAO() {}
	
	private static BoardDAO instance = new BoardDAO();
	
	public static BoardDAO getInstance() {
		return instance;
	}// getInstance
	
	public List<BoardVO> selectAllBoard(){
		String sql = "select * from board order by num desc";
		
		List<BoardVO> list = new ArrayList<BoardVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				BoardVO bVo = new BoardVO();
				bVo.setNum(rs.getInt(1));
				bVo.setName(rs.getString("name"));
				bVo.setEmail(rs.getString(3));
				bVo.setPass(rs.getString(4));
				bVo.setTitle(rs.getString(5));
				bVo.setContent(rs.getString(6));
				bVo.setReadcount(rs.getInt(7));
				bVo.setWritedate(rs.getTimestamp(8));
				
				list.add(bVo);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.closeConnection(conn, stmt, rs);
		}
		return list;
	}//selectAllBoard
	
	public void insertBoard(BoardVO bVo) {
		String sql = "insert into board(num, name, email, pass, title, content) values(board_seq.nextval, ?, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bVo.getName());
			pstmt.setString(2, bVo.getEmail());
			pstmt.setString(3, bVo.getPass());
			pstmt.setString(4, bVo.getTitle());
			pstmt.setString(5, bVo.getContent());
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally{
			DBManager.closeConnection(conn, pstmt);
		}
	}// insertBoard
	
	
	
	public void updateReadCount(String num) {
		String sql = "update board set readcount = readcount+1 where num=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.closeConnection(conn, pstmt);
		}
	}//updateReadCount
	
	// 게시판 글 상세 내용 보기 : 글번호로 찾아온다. : 실패 null,
	public BoardVO selectOneBoardByNum(String num) {
		String sql = "select * from board where num = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardVO bVo = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
			bVo = new BoardVO();
			
			bVo.setNum(rs.getInt("num"));
			bVo.setName(rs.getString("name"));
			bVo.setEmail(rs.getString("email"));
			bVo.setPass(rs.getString("pass"));
			bVo.setTitle(rs.getString("title"));
			bVo.setContent(rs.getString("content"));
			bVo.setReadcount(rs.getInt("readcount"));
			bVo.setWritedate(rs.getTimestamp("writedate"));
			}
		}catch(SQLException e) {
			
		}finally {
			DBManager.closeConnection(conn, pstmt, rs);
		}
		return bVo;
	}// selectOneBoardByNum
	
	public void updateBoard(BoardVO bVo) {
		String sql = "update board set name=?, email=?, pass=?, title=?, content=? where num=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bVo.getName());
			pstmt.setString(2, bVo.getEmail());
			pstmt.setString(3, bVo.getPass());
			pstmt.setString(4, bVo.getTitle());
			pstmt.setString(5, bVo.getContent());
			pstmt.setInt(6, bVo.getNum());
			
			pstmt.executeUpdate();
		}catch(SQLException e) {
			
		}finally {
			DBManager.closeConnection(conn, pstmt);
		}
		
	}//updateBoard
	
	
	public BoardVO checkPassWord(String pass, String num) {
		String sql = "select * from board where pass=? and num=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardVO bVo = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pass);
			pstmt.setString(2, num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
			bVo = new BoardVO();
			
			bVo.setNum(rs.getInt(1));
			bVo.setName(rs.getString("name"));
			bVo.setEmail(rs.getString(3));
			bVo.setPass(rs.getString(4));
			bVo.setTitle(rs.getString(5));
			bVo.setContent(rs.getString(6));
			bVo.setReadcount(rs.getInt(7));
			bVo.setWritedate(rs.getTimestamp(8));
			}
		}catch(SQLException e) {
			
		}finally {
			DBManager.closeConnection(conn, pstmt, rs);
		}
		return bVo;
	}//checkPassWord
	
	public void deleteBoard(String num) {
		String sql = "delete board where num=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, num);
			
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}//deleteBoard
	
}//BoardDAO
