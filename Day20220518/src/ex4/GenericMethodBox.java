package ex4;

// 
class Box<T>{
private T ob;
public void setOb(T ob) {this.ob=ob;}
public T getOb() {return ob;}
@Override
	public String toString() {return ob.toString();}
}//Box<T>

class ChBox{
		static <T extends Number> void swapBox(Box<T> boxBefore, Box<T> boxAfter) {
		T tmp = boxBefore.getOb();
		boxBefore.setOb(boxAfter.getOb());
		boxAfter.setOb(tmp);
	}
}
public class GenericMethodBox {

	public static void main(String[] args) {

		Box<Integer> box1 = new Box<>();
		box1.setOb(99);
		Box<Integer> box2 = new Box<>();
		box2.setOb(55);
		System.out.println(box1.getOb() + " & " + box2.getOb());
		
		ChBox.swapBox(box1,box2);
		
		System.out.println("after : " + box1.getOb() + " & " + box2.getOb());
	}
}
//출력 before : 99 & 55
//	  after : 55 & 99
// 위 코드가 실행되도록 swapBox 메서드 정의함 단 Box<T> 인스턴스를 인자로 전달받을 수 있도록 정의
// 그리고 이때 Box<T> 인스턴스는 T는 Number 또는 이를 상속하는 하위 클래스만 올수 있도록 제한.
