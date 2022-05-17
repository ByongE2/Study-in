package ex03;

class Box<T extends Number>{
	private T ob;
	
	public void set(T o) {
		ob = o;
	}
	public T get() {
		return ob;
	}
}

public class BoundedBox {

	public static void main(String[] args) {
	Box<Long> aBox = new Box<>();
	aBox.set(100L);
	
	System.out.println(aBox.get());
	
		
	}

}
