package LGSamsung;

public class SamsungTV implements TV{

	@Override
	public void powerOn() {
		System.out.println("삼성 전원 On");
	}
	@Override
	public void powerDown() {
		System.out.println("삼성 전원 off");
	}
	@Override
	public void volumeUp() {
		System.out.println("삼성 볼륨 업");
	}
	@Override
	public void volumeDown() {
		System.out.println("삼성 볼륨 다운");
	}

	
}
