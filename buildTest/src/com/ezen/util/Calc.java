package com.ezen.util;


//사칙연산 jar
public class Calc {
	int num1,num2;
	
	public void calc() { 
	}
	public Calc(int x, int y) {
		num1 = x;
		num2 = y;
	}
		
		
	int add() {
		return num1 + num2;
	}
	int sub() {
		return num1 - num2;
	}
	int mul() {
		return num1 * num2;
	}
	double div() {
		return num1/(double)num2;
	}
	public void getInfo() {
		System.out.println("num1 : " + num1 + "num2 : " + num2);
		System.out.println("num1 + num2 : " + (num1 + num2));
		System.out.println("num1 - num2 : " + (num1 - num2));
		System.out.println("num1 * num2 : " + (num1 * num2));
		System.out.println("num1 / num2 : " + (num1/(double)num2));
		
	}
}//Calc
