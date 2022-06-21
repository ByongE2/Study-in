package polymorphism;

public class SamsungTV implements TV {
	private Speaker speaker;
	private int price;

	SamsungTV(){
		System.out.println(">>>삼성티비(1) 객체 생성");
	}
	
	public SamsungTV(Speaker speaker) {
		System.out.println("===> 삼성TV(2) 객체 생성");
		this.speaker = speaker;
	}
	public SamsungTV(Speaker speaker, int price) {
		System.out.println("===> 삼성TV(3) 객체 생성");
		this.speaker = speaker;
		this.price = price;
	}
	
	
	public Speaker getSpeaker() {
		return speaker;
	}

	public void setSpeaker(Speaker speaker) {
		System.out.println("===> setSpeaker() 호출");
		this.speaker = speaker;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		System.out.println("===> setPrice() 호출");
		this.price = price;
	}

	@Override
	public void volumeUp() {
		speaker.volumeUp();
	}
	@Override
	public void volumeDown() {
		speaker.volumeDown();
	}
	
//	@Override
//	public void volumeUp() {
//		speaker = new SonySpeaker();
//		speaker.volumeUp();
//	}
//	@Override
//	public void volumeDown() {
//		speaker = new SonySpeaker();
//		speaker.volumeDown();
//	}
	
//	void AAA() {
//		System.out.println("AAA 초기화 메소드");
//	}
//	void BBB() {
//		System.out.println("BBB 소멸 전 메소드");
//	}
	
	@Override
	public void powerOn() {
		System.out.println("삼성티비 -- 전원 켠다. (가격 : " + price + ")");
	}
	@Override
	public void powerOff() {
		System.out.println("삼성티비 -- 전원 끈다.");
	}
//	@Override
//	public void volumeUp() {
//		System.out.println("삼성티비 -- 소리 올린다.");
//	}
//	@Override
//	public void volumeDown() {
//		System.out.println("삼성티비 -- 소리 내린다.");
//	}
}
