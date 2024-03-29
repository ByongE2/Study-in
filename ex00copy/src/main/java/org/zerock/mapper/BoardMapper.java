package org.zerock.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
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
	
	public int getTotalCount(Criteria cri);
	
	//검색 조건
	public List<BoardVO> searchTest(Map<String, Map<String,String>> map); // Map, 안에 Map
	
	//댓글 수 등록(mybats 2개의 데이터 사용하기 위해서 @param
	public void updateReplyCnt(@Param("bno")Long bno, @Param("amount")int amount);
	
	
	
}
