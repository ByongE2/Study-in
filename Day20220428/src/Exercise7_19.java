import java.util.Arrays;

public class Exercise7_19 {

	public static void main(String[] args) {

		Buyer b = new Buyer();
		b.buy(new Tv3());
		b.buy(new Computer());
		b.buy(new Tv3());
		b.buy(new Audio());
		b.buy(new Computer());
		b.buy(new Computer());
		b.buy(new Computer());
		
		b.summary();
	}
}

class Buyer {
	int money = 1000;
	Product[] cart = new Product[3];				//구입한 제품을 저장하기 위한 배열
	int i = 0;										// Product배열 cart에 사용될 index
	
	void buy(Product p) {
		
	}
	void add(Product p) {
		
	}
	void summary() {
//		System.out.println(Arrays.toString(cart));
//		System.out.println(cart[0].price+cart[1].price+cart[2].price);
//		System.out.println(money-);
	}
}//end of Buyer
class Product{
	int price;
	Product(int price){
		this.price = price;
	}
}//end of Product
class Tv3 extends Product{		// Tv
	Tv3(){ super(100);}
	public String toString() { return "Tv"; }
}
class Computer extends Product{		//Computer
	Computer() { super(200); }
	
	public String toString() { return "Computer"; }
}
class Audio extends Product{	//Audio
	Audio(){ super(50); }
	
	public String toString() { return "Audio"; }
}


