package com.tv;

public class VCR {

	protected int counter; // VCR의 카운터.
	public void play() {
		// Tape을 재생한다
	}
	public void stop() {
		// 재생을 멈춘다
	}
	public void reset() {
		 counter=0;
	}
	public int getCounter() {
		 return counter;
	}
	public void setCounter(int c) {
		counter = c;
	}
	
}
