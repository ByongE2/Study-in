package com.ezen.ex01;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceotionTest01 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("정수 입력 : ");
		int sum=0;
		try {
			int num = sc.nextInt();
			int a = 10/num;
		}catch(ArithmeticException e){
			e.printStackTrace();
		}catch(InputMismatchException e1) {
			e1.printStackTrace();
		}catch(Exception e2) {
			e2.printStackTrace();
		}finally {
			System.out.println("1부터 100까지 수의 합: sum");
		}
		for(int i=0; i<=100; i++)
			sum += i;
		System.out.println("sum = " + sum);
		
		
	}

}
