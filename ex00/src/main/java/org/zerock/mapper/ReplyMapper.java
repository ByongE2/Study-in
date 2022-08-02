package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;

public interface ReplyMapper {

	public int insert(ReplyVO vo);
	
	public ReplyVO read(Long rno);
	
	public int delete(Long rno);
	
	public int update(ReplyVO vo);
	
	public List<ReplyVO> getListWithPaging(
			//2종류의 데이터를 arg로 넘겨주고 싶으면 @Param으로 해서 해주면된다.
			@Param("cri") Criteria cri,
			@Param("bno") Long bno
			);
}
