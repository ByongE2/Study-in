package ex1;


class Box<T>{
private T ob;
public void setOb(T ob) {this.ob=ob;}
public T getOb() {return ob;}
@Override
	public String toString() {return ob.toString();}
}//Box<T>
class BoxFactory{
	//제네릭 메소드 : <T>, Box<T> : 반환형, T o : 매개변수
	
	public static <T> Box<T> makeBox(T o){
		Box<T> box = new Box<T>();
		box.setOb(o);
		return box;
	}
}//BoxFactory




public class GenericMethodBox {

	public static void main(String[] args) {
		Box<String> sBox = BoxFactory.makeBox("Sweet");
		System.out.println(sBox.getOb());
		
		Box<Double> dBox = BoxFactory.makeBox(8.89);
		System.out.println(sBox.getOb());
	}

}
