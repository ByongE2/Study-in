package com.tv;
// TV와 VCR로부터 다중상속 받기위해서 interface를 쓴 예제.
// interface로 VCR의 모든 메서드 가져오고, VCR의 iv는 protected로.
// 그냥바로 vcr. 해도 되지만, interface의 다형적 특성을 살릴 수 있다. 내용변경이 일어나도 2군데 고칠거 1군데만 고쳐도된다.
public class TVCR extends Tv implements IVCR{
	public static void main(String[] args) {	//main 만들어서 사용
		
		TVCR tv = new TVCR();
		tv.play();
		tv.stop();
		tv.getcounter();
		System.out.println(tv.volume);
		
	}//main
	VCR vcr = new VCR();
	@Override
	public void play() {
		vcr.play();
	}
	@Override
	public void stop() {
		vcr.stop();
	}
	@Override
	public void reset() {
		vcr.reset();
	}
	@Override
	public int getcounter() {
		return vcr.getCounter();  // iv는 메서드를 통해서 접근. 캡슐화.
	}
	@Override
	public void setCounter(int c) {
		vcr.setCounter(c);		  // // iv는 메서드를 통해서 접근. 캡슐화.
	}
	
}
