package org.zerock.service;


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
@Log4j
public class BoardServiceImplTest {

	@Autowired
	private BoardService service;
	
	@Test
	public void testRegister() {
		log.info("테스트registerㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		
		BoardVO vo = new BoardVO();
		vo.setTitle("서비스임플 제");
		vo.setContent("서비스임플 내");
		vo.setWriter("서비스임플 작");
		service.register(vo);
		log.info("생성된 게시물 번호 : " + vo.getBno());
	}
	
	@Test
	public void testRemove() {
		log.info("삭제테스트ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		log.info("삭제 : " + service.remove(8L));
	}
	
	@Test
	public void testModify() {
		BoardVO vo = new BoardVO();
		vo.setBno(7L);
		vo.setTitle("수원");
		vo.setContent("경기도");
		vo.setWriter("이젠");
		log.info("수정테스트 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		log.info("수정 : " + service.modify(vo));
	}
	
	@Test
	public void get() {
		log.info("get테스트ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		
		service.get(5L);
	}

	@Test
	public void testGetList() {
		log.info("겟리스트테스트ㅡㅡㅡㅡ페이징 후ㅡㅡㅡㅡㅡㅡ");
//		service.getList();
		service.getList(new Criteria(2,10));
	}
	
	
	
	
}
