// jungsuk exercise 6-1 ~ 6-2
public class Question {

	public static void main(String[] args) {
		SutdaCard card1 = new SutdaCard(3,false);
		SutdaCard card2 = new SutdaCard();
		
		System.out.println(card1.info());
		System.out.println(card2.info());
	}

}

class SutdaCard {

	int num ;
	boolean isKwang;
	SutdaCard() {
		this(1,true);
//		num=1;
//		isKwang=true;
	}

	SutdaCard(int num, boolean isKwang){
		this.num = num;
		this.isKwang = isKwang;
	}
	String info() {
		return num + (isKwang ? "K" : "");
	}
	
	
}
