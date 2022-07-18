package org.zerock.mapper;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml") 
//@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context2.xml") 
@Log4j
public class BoardMapperTest {

	@Autowired
	private BoardMapper mapper;
	
	@Test
	public void testGetList() {
//		mapper.getList().forEach(board -> log.info(board)); //스트림
		//for문으로 바꿔보자..
		for(BoardVO vo : mapper.getList()) {
			log.info(vo);
		}
	}//testGetList
	
	@Test
	public void testInsert() {
		
		BoardVO vo = new BoardVO();
//		vo.setBno(null);
		vo.setTitle("제목ㅅㅅㅅㅅㅅㅅㅅㅅㅅㅅ");
		vo.setContent("내용");
		vo.setWriter("작성자");
		
		mapper.insert(vo);
		log.info(vo);
		
	}//testInsert

	@Test
	public void testInsertSelectKey() {
		
		BoardVO vo = new BoardVO();
//		vo.setBno(null);
		vo.setTitle("제목22");
		vo.setContent("내용22");
		vo.setWriter("작성자22");
		
		mapper.insertSelectKey(vo);
		log.info(vo);
		
	}//testInsert
	
	@Test
	public void testRead() {
		BoardVO vo = mapper.read(14L); //롱타입! 접미사 L	
		log.info(vo);
	}//testGetList
	
	@Test
	public void testDelete() {
		log.info("delete count : " + mapper.delete(10L));
	}
	
	@Test
	public void testUpdate() {
		BoardVO vo = new BoardVO();
		vo.setBno(20L);
		vo.setTitle("수정제목3");
		vo.setContent("수정내용3");
		vo.setWriter("수정작성자3");
		log.info("update : " +  mapper.update(vo)); 
	}
	
	@Test
	public void testPaging() {
		Criteria cri = new Criteria();
//		cri.setPageNum(3);
//		cri.setAmount(10);
		List<BoardVO> list = mapper.getListWithPagging(cri);
		log.info(list);
	}
	
	
	
	
	
	
	
	
	
}
