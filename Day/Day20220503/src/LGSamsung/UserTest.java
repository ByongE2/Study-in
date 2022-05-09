package LGSamsung;

public class UserTest {

	public static void main(String[] args) {

//		LgTV tv = new LgTV();
//		tv.powerDown();
//		tv.powerOn();
//		tv.volumeDown();
//		tv.volumeUp();
		
//		SamsungTV tv = new SamsungTV();
//		tv.powerDown();
//		tv.powerOn();
//		tv.volumeDown();
//		tv.volumeUp();							// 클래스명만 바꾼다. 
		
//		TV tv = new SamsungTV();				// 인터페이스로만 다룬다. 껍데기.
//		tv.powerDown();
//		tv.powerOn();
//		tv.volumeDown();
//		tv.volumeUp();
		
		BeanFactory factory = new BeanFactory();	// 클래스명 자체도 바꾸기 귀찮을 때. 즉 1개라도 바꾸려면 컴파일을 다시해야하니까..
		TV tv = (TV)factory.getBean(args[0]);		// 디자인패턴 중 팩토리메서드? 사용. BeanFactory 클래스에서 패턴사용.
		tv.powerDown();
		tv.powerOn();
		tv.volumeDown();
		tv.volumeUp();
		
	}

}
