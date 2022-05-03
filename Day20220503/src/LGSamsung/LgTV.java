package LGSamsung;

public class LgTV implements TV{

	@Override
	public void powerOn() {
		System.out.println("엘지 TV 온");
	}

	@Override
	public void powerDown() {
		System.out.println("엘지 TV 오프");
	}

	@Override
	public void volumeUp() {
		System.out.println("엘지 TV 볼륨 업");
	}

	@Override
	public void volumeDown() {
		System.out.println("엘지 TV 볼륨 다운");
	}

	
	
}
