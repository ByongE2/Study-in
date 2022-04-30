// Buyer가 제품을 사고. 담고.
// Product , Tv, Audio, Computer, Buyer , Buy , Add, cart[], summary
public class Ex7_17Review {

	public static void main(String[] args) {
//		Product p = new Product();
//		Product tv = new Tv();
//		Product au = new Audio();
//		Product co = new Computer();
		Buyer b = new Buyer();
		
		b.buy(new Tv());
		b.buy(new Computer());
		
		
	}// end of main

}
class Buyer{
	private int money = 1000; //보유금액
	Product cart = new Product();
	void buy(Product p) {
		money -= p.getPrice();
		System.out.println("잔액부족" + p + "을 샀습니다. 남은금액은 : " + money);
	}
	void add() {}
	
}
class Product{
	private int price;
	Product() {}
	Product(int price){
		this.price = price;
	}
	Product(Product p){
		System.out.println(p + "을 샀다");
	}
	
	int getPrice() {
		return price;
	}
	void setPrice(int price) {
		this.price = price;
	}
}
class Tv extends Product{
	Tv(){
		super(100);	
//		System.out.println("tv를 샀습니다.");
	}
	public String toString() { return "Tv"; } 		// 없을 때는 p가 p+주소값을 나타내네.. 허허 ㅠㅠ
//	@Override
//	public String toString() {
//		return super.toString();
//	}
	//	super(100);
	
}
class Computer extends Product{
	Computer(){
		super(300);
		System.out.println("Computer를 샀습니다.");
	}
	
}

