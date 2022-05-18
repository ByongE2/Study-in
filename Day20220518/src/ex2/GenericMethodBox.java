package ex2;


class Box<T>{
private T ob;
public void setOb(T ob) {this.ob=ob;}
public T getOb() {return ob;}
@Override
	public String toString() {return ob.toString();}
}//Box<T>
class UnBoxer{
	//제네릭 메소드 : <T>, Box<T> : 반환형, T o : 매개변수
	
	public static <T> T makeBox(Box<T> box){
		return box.getOb();
	}
}//BoxFactory




public class GenericMethodBox {

	public static void main(String[] args) {
		Box<String> sBox = new Box<>();
		sBox.setOb("제네릭 메서드");

		String str = UnBoxer.makeBox(sBox);
		System.out.println(str);
		
	}

}
