
interface Printable2{ void print(String s);}

//class Printer implements Printable{
//	public void print(String s) {
//		System.out.println(s);
//	}
//}

public class Lambda1 {

	public static void main(String[] args) {
		//익명클래스
//		Printable2 prn = new Printable2() {
//			public void print(String s) {
//				System.out.println(s);
//			}
//		};
		//람다
		Printable2 prn = s -> System.out.println(s);
			
		
		
		
		
		prn.print("자바는 람다");

	}

}
