interface Printable4{ void print(String s);}

interface Calulate{
	 int cal(int n1, int n2);
}
//class Caltor implements Calulate{
//	public int cal(int n1, int n2) {
//		return n1+n2;
//	}
//}
public class Lambda4 {

	public static void main(String[] args) {
		//람다
		Printable4 prn;
		prn = (String s) -> {System.out.println(s);};
		prn.print("java is lambda");
		
		prn = (String s) -> System.out.println(s);
		prn.print("java is lambda");

		prn = (s) -> System.out.println(s);
		prn.print("java is lambda");

		prn = s -> System.out.println(s);
		prn.print("java is lambda");
	
		Calulate c;
		c = (a,b)-> a+b;
//		Calulate d = new Caltor();
		System.out.println(c.cal(5, 10));
//		c = (n1,n2) -> System.out.println(n1+n2);
//		c.cal(1, 2);
		
	}
	

}
