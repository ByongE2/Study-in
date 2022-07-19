package org.zerock.service;

import java.util.List;

import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

public interface BoardService {

	public void register(BoardVO vo); //등록
	public BoardVO get(Long bno);	//읽기
	public int modify(BoardVO vo);	//수정
	public int remove(Long bno);	//삭제
//	public List<BoardVO> getList();	//전체 읽기
	public List<BoardVO> getList(Criteria cri);	//전체 읽기
	
	
}
