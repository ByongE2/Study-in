package org.zerock.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context2.xml") 
@Log4j
public class ReplyMapperTest {

	@Autowired
	private ReplyMapper mapper;
	
	private Long[] bnoArr = { 54324L, 54323L, 54322L, 54321L, 54320L };
	
	//값이 잘 전달 되는지.
	@Test
	public void testMapper() {
		log.info(mapper);
	}
	
	//insert
	@Test
	public void testCreate() {
		//bno 존재하는 값 있어야하는데, 있는걸로 5개정도 미리 bnoArr로 정하고 테스트  bno값 없으면 rno못넣음~ 
		for(int i = 0; i<5; i++) {
		ReplyVO vo = new ReplyVO();
		vo.setBno(bnoArr[i]);
		vo.setReply("홍길동전...." + i + 1);
		vo.setReplyer("길동이" + i + 1);
		mapper.insert(vo);
		}
		
	}
	//read , select	
	@Test
	public void testRead() {
//		ReplyVO vo = mapper.read(6L);
		ReplyVO vo = mapper.read(1L);
		log.info(vo);
	}
	
	//delete
	@Test
	public void testDelete() {
		log.info(mapper.delete(1L));
	}
	
	//update
	@Test
	public void testUpdate() {
		ReplyVO vo = new ReplyVO();
		vo.setReply("수정 중 ...");
		vo.setRno(2L);
		log.info(mapper.update(vo));
	}
	
	//getListWhitPaging
	@Test
	public void testList() {
		Criteria cri = new Criteria();
		List<ReplyVO> replies = mapper.getListWithPaging(cri, bnoArr[2]);
		log.info(replies);
	}
	
	//댓글 페이징 인덱싱 처리 rn 테스트
	@Test
	public void testList2() {
		Criteria cri = new Criteria(1,10);
		List<ReplyVO> replies = mapper.getListWithPaging(cri, 54323L);
		
		replies.forEach(reply -> log.info(reply));
	}
	
	//댓글 페이징처리 위해 bno에서 총 댓글 수 확인.
	@Test
	public void testCount() {
		int num = mapper.getCountByBno(54323L);
		log.info("num : " + num);
	}
}
