
public class Ex7_10 {

	public static void main(String[] args) {

		MyTv2 t = new MyTv2();
		
		t.setChannel(10);
		System.out.println("채널 : " + t.getChannel());
		t.setVolume(20);
		System.out.println("볼륨 : " + t.getVolume());
		t.setChannel(20);
		System.out.println("채널 : " + t.getChannel());
		t.gotoPrevChannel();
		System.out.println("채널 : " + t.getChannel());
		t.gotoPrevChannel();
		System.out.println("채널 : " + t.getChannel());
		
	}//main
}
class MyTv2{
	private boolean isPoweron;
	private int channel;
	private int volume;
	private int prevChannel;
	
	final int MAX_VOLUME = 100;
	final int MIN_VOLUME = 100;
	final int MAX_CHANNEL = 100;
	final int MIN_CHANNEL = 100;
	
	void gotoPrevChannel() {
//		return prevChannel;  				//void 빼고 이리하면 안바뀐다
		 setChannel(prevChannel);
	}
	
	boolean getIspoweron() {
		return isPoweron;
	}
	void setIsPoweron(boolean isPoweron) {
		this.isPoweron = isPoweron;
	}
	int getChannel() {
		return channel;
	}
	void setChannel(int channel) {
		prevChannel = this.channel;			
		this.channel = channel;
		//위부터아래로 흐름.. 
	}
	int getVolume() {
		return volume;
	}
	void setVolume(int volume) {
		this.volume = volume;
	}
	
}