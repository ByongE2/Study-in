
public class Exercise6_4 {

	public static void main(String[] args) {

		Student s = new Student();
		s.name = "홍길동";
		s.ban = 1;
		s.no = 1;
		s.kor = 100;
		s.eng = 60;
		s.math = 76;

		System.out.println("이름 : " + s.name);
		System.out.println("이름 : " + s.getTotal());
		System.out.println("이름 : " + s.getAverage());
		
	}//end of main

}
class Student {
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;
	
	
	int getTotal() {
		return kor + eng + math;
	}
	double getAverage() {
		return (int)(getTotal() / 3.0)*10/10;
	}
}