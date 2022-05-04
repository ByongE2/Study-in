package com.ezen.ex01;

public class CardToString {

	public static void main(String[] args) {

		Card c1 = new Card();
		Card c2 = new Card("Heart",10);
		
		System.out.println(c1.toString());
		System.out.println(c2.toString());
		
		
	}

}
class Card {
	String kind;
	int number;
	Card(){
		this("SPADE",1);
	}
	Card(String kind, int number){
		this.kind = kind;
		this.number = number;
	}
	public String toString() {
		return "카드종류: " + kind + "카드숫자: " + number;
	}
}
