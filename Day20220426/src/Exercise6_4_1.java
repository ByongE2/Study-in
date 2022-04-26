public class Exercise6_4_1 {

	public static void main(String[] args) {
		
		int num=10;
		
		Student2 s = new Student2();
		
		s.name = "홍길동";
		s.ban = 10;
		
		System.out.println(s.name);
		System.out.println(s.ban);
		System.out.println(s.math);
		s.getAverage();
		
		System.out.println("---------------------");
		
		Student2 s2 = new Student2();
		s2.name = "이순신";
		s2.kor=90;
		s2.eng=80;
		s2.math = 90;
		System.out.println(s2.name);
		System.out.println(s2.kor);
		System.out.println(s2.eng);
		System.out.println(s2.math);
		System.out.println("총점 : " + s2.getTotal());
		System.out.println("평균 : " + s2.getAverage());
		
		System.out.println("----------------------");
		
		Student2 s3 = new Student2();
		
		s3 = s;
		System.out.println(s3.name);
		System.out.println(s3.ban);
		System.out.println(s3.math);
		s.getAverage();
	}
}

// private < default < protected < public
class Student2{
	//변수>> 인스턴스변수, 클래스변수, 지역변수
	private String name;
	private int ban;
	private int no;
	private int kor;
	private int eng;
	private int math;
	//함수 --> 인스턴스메소드, 클래스메소드
	// getter부터 먼저. 즉 게터를 셋터가 받아서 호출받아도되고, 
	// main 메서드에서 그냥 바로 iv로 받아도되고.프린트ln메서드에 바로받아도된다.
	// 캡슐화로 하기위해 private쓰려면, 셋터 작성하고. 셋터로 호출해야한다.
	int getTotal() {
		int sum = kor+eng+math;
		return sum;
	}
	public String getName() {					
		return name;							
	}											
	public void setName(String name) {
		this.name = name;
	}
	public int getBan() {
		return ban;
	}
	public void setBan(int ban) {
		this.ban = ban;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	double getAverage() {
		return getTotal()/3.0;
	}
}