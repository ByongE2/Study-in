package ex3;

class Box<T>{
private T ob;
public void setOb(T ob) {this.ob=ob;}
public T getOb() {return ob;}
@Override
	public String toString() {return ob.toString();}
}//Box<T>
class BoxFactory{
	//제네릭 메소드 : <T>, Box<T> : 반환형, T o : 매개변수
	
	public static <T extends Number> Box<T> makeBox(T o){
		Box<T> box = new Box<T>();
		box.setOb(o);
		System.out.println("박스 data : " + o.intValue());
		return box;
	}
}//BoxFactory
class UnBoxer{
	//제네릭 메소드 : <T>, Box<T> : 반환형, T o : 매개변수
	
	public static <T extends Number> T openBox(Box<T> box){
		System.out.println("언박스 data : " + box.getOb().intValue());
		return box.getOb();
	}
}//UnBoxer
public class GenericMethodBox {

	public static void main(String[] args) {
		Box<Integer> iBox = BoxFactory.makeBox(8989); // new Integer(8989);
		
		int num = UnBoxer.openBox(iBox);
		System.out.println("결과 : " + num);
		
	}

}
