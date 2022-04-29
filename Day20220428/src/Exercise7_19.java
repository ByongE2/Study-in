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
		if(money < p.price) {
			System.out.println("잔액부족" + p + "살수없습니다"); return;
		}
		money -= p.price;
		add(p);
	}
	void add(Product p) {
		if(i >= cart.length) {
//			Product[] tmp = new Product[cart.length*2];
//			System.arraycopy(cart, 0, tmp, 0, cart.length);
//			cart = tmp;
			Product[] cart2 = new Product[cart.length*2];
			for(int i=0; i<cart.length; i++)  cart2[i] = cart[i];
			cart = cart2;
		}
		cart[i++]=p;
	}
	void summary() {
		
		int sum = 0;
		for(int i=0; i < cart.length; i++) {
//			if(cart[i]== null) break;
			sum += cart[i].price;
		}
		System.out.println("구매목록 : " + Arrays.toString(cart));  
		// String itemList = ""; 	itemList += cart[i] + ",";
		System.out.println("구입한 물건의 총액 : " + sum);
		System.out.println("잔액은 : " + money);
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
	public String toString() { return "Tv"; }			//objcet 것을 오버라이딩 .
}
class Computer extends Product{		//Computer
	Computer() { super(200); }
	
	public String toString() { return "Computer"; }
}
class Audio extends Product{	//Audio
	Audio(){ super(50); }
	
	public String toString() { return "Audio"; }
}


