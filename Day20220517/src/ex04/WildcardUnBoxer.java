package ex04;

class Box<T>{
private T ob;
public void setOb(T ob) {this.ob=ob;}
public T getOb() {return ob;}
@Override
	public String toString() {return ob.toString();}
}//Box<T>
class Unboxer{
	public static <T> T openBox(Box<T> box) {return box.getOb();}
	public static <T> void peekBox(Box<T> box) {
		System.out.println(box);
	}	
}//Unboxer
public class WildcardUnBoxer {

	public static void main(String[] args) {
		Box<String> box = new Box<>();
		box.setOb("apple");
		Unboxer.peekBox(box);
	}
}

