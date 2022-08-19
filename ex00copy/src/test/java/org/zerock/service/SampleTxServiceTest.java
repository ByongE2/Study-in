package org.zerock.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context2.xml")
@Log4j
public class SampleTxServiceTest {

	@Autowired
	private SampleTxService service;
	
	@Test
	public void testing() {
		String str = "TX테스트 위해서";
//				+ "TX테스트 위해서 내용테스트 50자넘고 500자 안넘게!내용테스트 50자넘고 500자 안넘게"
//				+ "TX테스트 위해서 내용테스트 50자넘고 500자 안넘게!내용테스트 50자넘고 500자 안넘게";
		
		log.info("length : " + str.getBytes().length); 
		
		service.addData(str);
	}
	
}
