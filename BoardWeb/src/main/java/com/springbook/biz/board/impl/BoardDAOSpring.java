package com.springbook.biz.board.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;
	@Repository
	public class BoardDAOSpring {
	
		@Autowired
		private JdbcTemplate jdbcTemplate;
		
		//SQL명령어들
		private final String BOARD_INSERT = "insert into board(seq, title, writer, content) "
				+ "values((select nvl(max(seq), 0) + 1 from board), ?, ?, ?)";
		private final String BOARD_UPDATE = "update board set title=?, content=?, where seq=?";
		private final String BOARD_DELETE = "delete board where seq=?";
		private final String BOARD_GET = "select * from board where seq=?";
		private final String BOARD_LIST = "select * from board order by seq desc";
		
//		@Autowired //주로 변수에 사용하나, 메서드에 선언해도 동작한다.
//		//메서드를 스프링컨테이너가 자동으로 호출하고, 매개변수 타입을 확인해서, 타입의 객체가 메모리에 존재하면 그 객체(DataSource)를 인자로 넘겨준다.
//		public void setSuperDataSource(DataSource dataSource) {
//			super.setDataSource(dataSource);
//		}
			
		//CRUD 기능의 메소드 구현
		// 글 등록
		public void insertBoard(BoardVO vo) {
			System.out.println("===> Spring JDBC로 insertBoard() 기능 처리");
			Object[] args = {vo.getTitle(), vo.getWriter(), vo.getContent()};
//			getJdbcTemplate().update(BOARD_INSERT, args);
			jdbcTemplate.update(BOARD_INSERT, args);
		}
		
		// 글 수정
		public void updateBoard(BoardVO vo) {
			System.out.println("===> Spring JDBC로 updateBoard() 기능 처리");
			Object[] args = {vo.getTitle(), vo.getContent(), vo.getSeq()};
			jdbcTemplate.update(BOARD_UPDATE, args);
		}
		
		// 글 삭제
		public void deleteBoard(BoardVO vo) {
			System.out.println("===> Spring JDBC로 deleteBoard() 기능 처리");
			jdbcTemplate.update(BOARD_DELETE, vo.getSeq());
		}
		
		// 글 상세 조회
		public BoardVO getBoard(BoardVO vo) {
			System.out.println("===> Spring JDBC로 getBoard() 기능 처리");
			Object[] args = { vo.getSeq()};
		
			return jdbcTemplate.queryForObject(BOARD_GET, args, new BoardRowMapper());
		}
		
		// 글 목록 조회
		public List<BoardVO> getBoardList(BoardVO vo){
			System.out.println("===> Spring JDBC로 getBoardList() 기능 처리");

				
			return jdbcTemplate.query(BOARD_LIST, new BoardRowMapper());
		}
		
	}//BoardDAOSpring

	class BoardRowMapper implements RowMapper<BoardVO>{
	
		public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException{
			BoardVO board = new BoardVO();
			board.setSeq(rs.getInt("SEQ"));
			board.setTitle(rs.getString("TITLE"));
			board.setWriter(rs.getString("WRITER"));
			board.setContent(rs.getString("CONTENT"));
			board.setRegDate(rs.getDate("REGDATE"));
			board.setCnt(rs.getInt("CNT"));
			
			return board;
			
		}
		
	
	
	}