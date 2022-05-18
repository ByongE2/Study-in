package ex05;

class Box<T>{
private T ob;
public void setOb(T ob) {this.ob=ob;}
public T getOb() {return ob;}
@Override
	public String toString() {return ob.toString();}
}//Box<T>

class Toy{
	@Override
	public String toString() {return " 나는 토이 " ;}
}
class Robot extends Toy{}
class BoxHandler{
//	public static void outBox(Box<Toy> box) { // 겟 목적
	public static void outBox(Box<? extends Toy> box) { // 겟 목적
		Toy t = box.getOb();
		System.out.println(t);
		
//		box.setOb(t); // 이것도 겟 목적에 위배. 문법적 오류는 없으나 논리적 오류 있다
		
	}
	public static void inBox(Box<Toy> box, Toy t) {   // 셋 목적의 메서드
		box.setOb(t);
		 
		// 겟 들어와도 문법적 오류는 없으나, 셋목정에 위배된다. 즉 논리적 오류가 일어난다.
//		Toy t2 = box.getOb();       
//		System.out.println(t2);
	}
}
public class BoundeWildCardBase {

	public static void main(String[] args) {
		Box<Toy> box = new Box<>();
		BoxHandler.inBox(box, new Toy());
		BoxHandler.outBox(box);
		
		
	}

}
