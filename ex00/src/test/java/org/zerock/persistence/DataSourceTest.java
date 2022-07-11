package org.zerock.persistence;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class) // 단위테스트 하겠다
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml") //
@Log4j //화면성 로그 찍겠다
public class DataSourceTest {

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	@Test
	public void testConnection() {
		try(Connection con = dataSource.getConnection()){
			System.out.println("========로그전");
			log.info(con);
			System.out.println("========로그후");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testMybatis() {
		try(SqlSession session = sqlSessionFactory.openSession();
			Connection con = session.getConnection()){
			System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ전");
			log.info("Connection : " + con);
			log.info("session : " + session);
			System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ후");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
