package com.ezen.ex01;

import java.util.HashSet;

public class HashSetEqualTest {

	public static void main(String[] args) {
		HashSet<Num> set = new HashSet<>();
		String set2 = "ABC";
		set.add(new Num(100));
		set.add(new Num(200));
		set.add(new Num(300));
		set.add(new Num(100));
		set.add(new Num(500));
		
		System.out.println(set2.toString());
		for(Num n : set)
			System.out.println(n);
	}//main
}

class Num{
	private int num;
	public Num(int n) {
		num = n;
	}
	@Override
	public int hashCode() {
		System.out.println("해쉬");
		return num%3 ;
	}
	@Override
	public boolean equals(Object obj) {
		System.out.println("이퀄스");
		return ((Num)obj).num == num;
	}
//	@Override
//	public String toString() {
//		return set.tostring();
//	}
}
