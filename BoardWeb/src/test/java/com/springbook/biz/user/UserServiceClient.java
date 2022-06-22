package com.springbook.biz.user;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UserServiceClient {

	public static void main(String[] args) {
		
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		
		UserService userService = container.getBean("userService", UserService.class);
		
		//로그인 기능 테스트
		UserVO vo = new UserVO();
		vo.setId("tset");
		vo.setPassword("test123");
		
		UserVO user = userService.getUser(vo);
		if(user != null) {
			System.out.println(user.getName() + "님 환영합니다.");
		}else {
			System.out.println("로그인 실패.");
		}
		
		//컨테이너 종료.
		container.close();
		
	}
	
}
