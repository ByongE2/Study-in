package org.zerock.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.ReplyVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context2.xml")
@Log4j
public class ReplyServiceTest {

	@Autowired
	private ReplyService service;
	
	//NoSuchBeanDefinitionException 에러뜨네 확인.
	//주입 잘 됬나 확인
	@Test
	public void test() {
		log.info(service);
	}
	
	@Test
	public void testRegister() {
		ReplyVO vo = new ReplyVO();
		vo.setBno(2L);
		vo.setReply("수원");
		vo.setReply("이젠");
		service.register(vo);
	}
	
	@Test
	public void testRemove() {
		service.remove(50L);
	}
	
	
}
