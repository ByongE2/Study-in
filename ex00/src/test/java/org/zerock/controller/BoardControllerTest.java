package org.zerock.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.extern.log4j.Log4j;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context2.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@Log4j
public class BoardControllerTest {

	@Autowired
	private WebApplicationContext ctx;
	
	private MockMvc mockMvc;
	
	//@Test 어노테이션 실행 전에 미리 해달라.
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	@Test
	public void testList() throws Exception {
		log.info(									   //겟방식 포스트방식에 따라 바뀌는부분
				mockMvc.perform(MockMvcRequestBuilders.get("/board/list"))
				.andReturn().getModelAndView().getModelMap()
				); //log.info
	}
	
	@Test
	public void testRegister() throws Exception {
		String resultPage = (						   //겟방식 포스트방식에 따라 바뀌는부분
				mockMvc.perform(MockMvcRequestBuilders.post("/board/register")
				.param("title","돈가스")
				.param("content", "왕돈가스")
				.param("writer","홍익돈가스")
				).andReturn().getModelAndView()./*getModelMap()*/getViewName()   //String이라서, 아니면 ModelMap으로 타입.
				); 
		log.info(resultPage);
	}

	@Test
	public void testGet() throws Exception {
		log.info(		 							   //겟방식 포스트방식에 따라 바뀌는부분
				mockMvc.perform(MockMvcRequestBuilders.get("/board/get")
				.param("bno", "27"))
				.andReturn().getModelAndView().getModelMap()
				); //log.info
	}
	
	@Test
	public void testRemove() throws Exception {
		String resultPage = (						   //겟방식 포스트방식에 따라 바뀌는부분
				mockMvc.perform(MockMvcRequestBuilders.post("/board/remove")
						.param("bno","20")
						).andReturn().getModelAndView()./*getModelMap()*/getViewName()   //String이라서, 아니면 ModelMap으로 타입.
				); 
		log.info(resultPage);
	}

	@Test
	public void testModify() throws Exception {
		String resultPage = (						   //겟방식 포스트방식에 따라 바뀌는부분
				mockMvc.perform(MockMvcRequestBuilders.post("/board/modify")
						.param("bno","3")
						.param("title", "수우정")
						.param("content", "내용수우정")
						.param("writer", "작성자수우정")
						).andReturn().getModelAndView()./*getModelMap()*/getViewName()   //String이라서, 아니면 ModelMap으로 타입.
				); 
		log.info(resultPage);
	}
	
}
