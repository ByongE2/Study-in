
public class Test01 {

	public static void main(String[] args) {

		Test01_1 t1 = new Test01_1();
		Test01_1 t2 = new Test01_1(1);
		Test01_1 t3 = new Test01_1(1,2);
		Test01_1 t4 = new Test01_1(1,2,3);
		
		System.out.println(t1.toString());
		System.out.println(t2.toString());
		System.out.println(t3.toString());
		System.out.println(t4.toString());
	}
}

class Test01_1{
	private int a,b,c;
	
	public Test01_1() {
		this(0,0,0);
	}
	public Test01_1(int a) {
		this(a,0,0);
	}
	public Test01_1(int a, int b) {
		this(a,b,0);
	}
	public Test01_1(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	@Override
	public String toString() {
		return "a : " + a + ", b : " + b + ", c : " + c;
	}
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}
	public int getC() {
		return c;
	}
	public void setC(int c) {
		this.c = c;
	}
	
}