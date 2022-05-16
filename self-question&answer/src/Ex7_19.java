class buyer{
	private int money = 1000;
	Product[] cart = new Product[3]; // 카트배열. 물품저장
	int i = 0;			//cart에 사용될 index
	
	void buy (Product p) {
		
	}
	void add (Product p) {
		
	}
	void summary() {
		
	}
}//buyer
class Product{
	private int price;
	
	int getPrice() {
		return price;
	}
	void setPrice(int price) {
		this.price = price;
	}
	Product(){}
	Product(int price){
		this.price = price;
	}
}//Product
class Tv extends Product{
	Tv(){ super(100); } 
	@Override
	public String toString() {return "Tv";}
}//Tv
class Computer extends Product{
	Computer() { super(200);
	}
	@Override
	public String toString() {
		return "Computer";}
}

public class Ex7_19 {

	public static void main(String[] args) {
		
		
	}//main

}
