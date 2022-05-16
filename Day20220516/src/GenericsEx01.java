//class Apple {
//	@Override
//	public String toString() {return "Apple";}
//}
//class Orange{
//	@Override
//	public String toString() {return "Orange";}
//}
////class AppleBox{
////	private Apple ap;
////
////	public Apple getAp() {
////		return ap;
////	}
////
////	public void setAp(Apple ap) {
////		this.ap = ap;
////	}
////	
////}
////class OrangeBox{
////	private Orange or;
////
////	public Orange getOr() {
////		return or;
////	}
////
////	public void setOr(Orange or) {
////		this.or = or;
////	}
////}
//class Box{
//	private Object ob;
//
//	public Object getOb() {
//		return ob;
//	}
//
//	public void setOb(Object ob) {
//		this.ob = ob;
//	}
//}
//
//public class GenericsEx01 {
//
//	public static void main(String[] args) {
//
////		AppleBox aBox = new AppleBox();
////		OrangeBox oBox = new OrangeBox();
////		
////		aBox.setAp(new Apple());
////		oBox.setOr(new Orange());
////		
////		Apple ap = aBox.getAp();
////		System.out.println(ap);
////		Orange or = oBox.getOr();
////		System.out.println(or);
//		Box aBox = new Box();
//		Box oBox = new Box();
//		
//		aBox.setOb(new Apple());
//		oBox.setOb(new Orange());
//		Apple ap = (Apple)aBox.getOb();
////		System.out.println(ap);
//		Orange or = (Orange)oBox.getOb();
////		System.out.println(or);
//		
//		aBox.setOb(new Apple());
//		Apple ap2 = (Apple) aBox.getOb();
//		System.out.println(ap2);
//		
//		aBox.setOb("애플"); // String 입력 > 원하지 않는 타입 들어감.
//		Apple ap3 = (Apple) aBox.getOb(); // 런타임에러
//		// 스트링을 Apple로 받았음.
//		// 타입에는 문제가없어서 컴파일 ok, 런타임에러 난다. 큰문제다.
////		System.out.println(ap3); // 
//		
////		String ap4 =  (String) aBox.getOb(); // 에러안나게는 가능하나, Apple타입을 원했는데 다른게 들어와서..나중에 못찾는다
////		System.out.println(ap4);
//	}
//}
