
public class Test {

	public static void main(String[] args) {
		
		A aa = new B();
		B bbb = new B ();
		
		
		B bb = (B)aa;
		A aaa = bbb; 
		
		bb.funcA();
		bb.funcB();
		aaa.funcA();
	}

}

class A{
	int a ;
	void funcA() {
		System.out.println("함수a");
	}
	
}
class B extends A{
	int b;
	void funcB() {
		System.out.println("함수b");
		
	}
}

