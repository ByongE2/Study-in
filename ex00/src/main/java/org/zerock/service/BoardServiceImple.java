package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@AllArgsConstructor
public class BoardServiceImple implements BoardService{

	private BoardMapper mapper;
	
	@Override
	public void register(BoardVO vo) {
		log.info("registerㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ......................");
//		 mapper.insert(vo); 
		mapper.insertSelectKey(vo);

	}

	@Override
	public int modify(BoardVO vo) {
		log.info("수정ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		int a = mapper.update(vo);
		return a;
	}

	@Override
	public int remove(Long bno) {
		log.info("삭제ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ" + bno);
		
		log.info(mapper.delete(bno));
		
		return 0;
	}

	@Override
	public BoardVO get(Long bno) {
		log.info("getㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		
		return mapper.read(bno);
	}

	@Override
	public List<BoardVO> getList() {
		log.info("겟리스트ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		return mapper.getList();
	}

	
}
