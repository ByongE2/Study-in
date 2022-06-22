package polymorphism;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LgTV implements TV{
	@Autowired
	private Speaker speaker;
	
	public LgTV() {
		System.out.println(">>>엘지티비 객체 생성");
	}
	@Override
	public void powerOn() {
		System.out.println("엘지티비 -- 전원 켠다.");
	}
	@Override
	public void powerOff() {
		System.out.println("엘지티비 -- 전원 끈다.");
	}
	@Override
	public void volumeUp() {
//		System.out.println("엘지티비 -- 소리 올린다.");
		speaker.volumeUp();
		
	}
	@Override
	public void volumeDown() {
		speaker.volumeDown();
//		System.out.println("엘지티비 -- 소리 내린다.");
	}
	
}
