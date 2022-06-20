package com.ezen.mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisMain {

	public static void main(String[] args) {
		String resource = "com/ezen/mybatis/mybatis-config.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
												// 오토커밋. true , false
			SqlSession session = sqlSessionFactory.openSession(true);
			//test
			System.out.println("sqlSessionFactory : " +sqlSessionFactory);
			System.out.println("session : " + session);
			
			BoardMethod mapper= session.getMapper(BoardMethod.class);
			BoardVO vo= mapper.selectOne(1);
			//test
//			System.out.println(vo.toString());
			System.out.println(vo.getId());
			System.out.println(vo.getName());
			System.out.println(vo.getPhone());
			System.out.println(vo.getAddress());
			
//			mapper.deleteBoard(6);
			BoardVO vo3 = new BoardVO();
			vo3.setId(10);
			vo3.setName("손흥민");
			vo3.setPhone("010-1010-1010");
			vo3.setAddress("주소");
			
			
			mapper.insertBoard(vo3);
			//JDBC는 auto 커밋이지만, mybatis는 아니라서 커밋해줘야한다네. 오라클에서 직접확인.
//			session.commit();
			
			System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
			List<BoardVO> list = mapper.selectAllMember();
			
			for(BoardVO vo2 : list )
				System.out.println(vo2.toString());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
