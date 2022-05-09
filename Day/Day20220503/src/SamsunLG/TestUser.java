package SamsunLG;

public class TestUser {

	public static void main(String[] args) {

		SamsungTV tv = new SamsungTV();
		tv.powerOn();
		tv.powerOff();
		tv.volumeUp();
		tv.volumeDown();
		// 유저가 갑자기 LG tv 원하면 ? 
		// 1: 클래스명 바꾸고 SamsungTV > LgTV ( 2개바꿀거 1개바꾼다.  >>>> TV tv = new SamsungTV(); ) 
		// 2: 메서드 명들도 바꿔야한다. tv.powerOn() > tv.turnOn()
		// >> 추상화하면, 1번만하면된다.
		
		// 메서드명이 서로 같을 때도, 
		// TV tv = new SamsungTV(); 처럼 다룰 수 있따.
		
	}

}
