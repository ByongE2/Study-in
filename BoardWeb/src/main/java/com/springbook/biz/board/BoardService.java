package com.springbook.biz.board;

import java.util.List;

public interface BoardService {

	// CRUD 기능의 메소드 구현
	// 글 등록
	void insertBoard(BoardVO vo);//insertBoard

	//글 수정
	void updateBoard(BoardVO vo);//updateBoard

	// 글 삭제
	void deleteBoard(BoardVO vo);// deleteBoard

	//글 상세 조회
	BoardVO getBoard(BoardVO vo);//getBoard

	// 글 목록 조회
	List<BoardVO> getBoardList(BoardVO vo);//getBoardList

}