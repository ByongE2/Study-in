package polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {
	public static void main(String[] args) {

		//높은 결합도
//		SamsungTV tv = new SamsungTV();
//		tv.powerOn();
//		tv.volumeUp();
//		tv.volumeDown();
//		tv.powerOff();
	
//		LgTV tv = new LgTV();
//		tv.turnOn();
//		tv.soundUp();
//		tv.soundDown();
//		tv.turnOff();
		
		//java 다형성 이용. 조금 더 나아짐.
//		TV tv = new SamsungTV();
//		tv.powerOn();
//		tv.volumeUp();
//		tv.volumeDown();
//		tv.powerOff();
		
		//디자인 패턴 - factory
//		BeanFactory factory = new BeanFactory();
//		TV tv = (TV)factory.getBean(args[0]); // run configurations에 명령행 매개변수 입력.
//		tv.powerOn();
//		tv.volumeDown();
//		tv.volumeUp();
//		tv.powerOff();
		// 스프링 컨테이너 - 
		// 1. 스프링 컨테이너 구동.
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		// 2. 스프링 컨테이너로부터 필요한 객체 lookup
		TV tv = (TV)factory.getBean("tv");
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		// 3. 스프링 컨테이너 종료
		factory.close();
	}
}
