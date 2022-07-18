package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

public interface BoardMapper {

//	@Select("select * from tbl_board where bno > 0")
	public List<BoardVO> getList();

	public BoardVO read(Long bno);
	
	public List<BoardVO> getListWithPagging(Criteria cri);
	
	//key값이 테스트할 때 null로 나옴
	public int insert(BoardVO vo);
	
	//key갑이 나옴. ex: bno=~
	public int insertSelectKey(BoardVO vo);
	
	
	//int하면 delete 카운트 셀 때 로그에서 직관적으로 보인다.
	public int delete(Long bno);
	
	public int update(BoardVO vo);
	
	
	
}
