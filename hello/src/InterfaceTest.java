class A{
	public void ma(B b) {
		b.mb(); 
	}
}
class B{
	public void mb(){
		System.out.println("BÀÇ m");
	}
}
class C{
	public void mc(){
		System.out.println("CÀÇ m");
	}
}

public class InterfaceTest {

	public static void main(String[] args) {
	
	A a = new A();
	  a.ma(new B());
	 
	}

}
