class Papers2{
	private String con;
	public Papers2(String s) {con = s;}

	public Printable getPrinter() {
		//local class
		class Printer implements Printable{
			public void print() {
				System.out.println(con);
			}
		}
		return new Printer();//Printer 클래스
	}// getPrinter 메서드
}


public class LocalClass1 {

	public static void main(String[] args) {
		Papers2 p = new Papers2("message java!!");
		Printable prn = p.getPrinter();
		prn.print();
		
	}

}
