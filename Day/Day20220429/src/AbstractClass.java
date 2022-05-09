
public class AbstractClass {

	public static void main(String[] args) {

		Product pro = new Audio();
		System.out.println(pro.price);
		pro.test();
		pro.func();
	}

}

 interface ab {
	
}

abstract class Product{
	public Product() {}
	int price;
	Product(int price){
		this.price = price;
	}
	void test() {
		System.out.println("Product");
	}
	abstract void func(); // 추상메서드
}//end of Product
class Tv extends Product{		// Tv
	Tv(){ super(100);}
	public String toString() { return "Tv"; }			//objcet 것을 오버라이딩 .
	@Override
	void func() {
		System.out.println("Tv");
	}
}
class Computer extends Product{		//Computer
	Computer() { super(200); }
	
	public String toString() { return "Computer"; }

	@Override
	void func() {
		System.out.println("Computer");
	}
}
class Audio extends Product{	//Audio
	Audio(){ super(50); }
	
	public String toString() { return "Audio"; }

	@Override
	void func() {
		System.out.println("Audio");
	}
}