package com.ezen.ex01;

public class CloneEx1 {
	public static void main(String[] args) {

		Point original = new Point(3, 5);
		Point copy = (Point)original.clone();
//		Point copy2 = original;
		System.out.println(original);
		System.out.println(copy);

	}//main
}
class Point implements Cloneable{

	int x, y;
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	
	public Object clone()  {
		Object obj = null;
		try {
			obj = super.clone();
		}catch (CloneNotSupportedException e) {
		}
		return obj;
	}
}
