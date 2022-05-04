package com.Ch9;


public class EqualsEx1 {

	public static void main(String[] args) {

		Value v1 = new Value(10);
		Value v2 = new Value(10);
		
		if(v1.equals(v2))
			System.out.println("v1과 v2는 같다");
		else
			System.out.println("v1과 v2는 다르다");
		
		if(v2 == v1)
			System.out.println("v1과 v2는 같다");
		else
			System.out.println("v1과 v2는 다르다");
	}

}

class Value { 
	int value;
	Value(int value){
		this.value = value;
	}
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Value))
			return false;
			return value == ((Value)obj).value;
	}
}
