
public class Question2 {

	public static void main(String[] args) {

		Student4 s = new Student4();
		s.setName("홍길동");
		s.setBan(1);
		s.setNo(1);
		s.setKor(100);
		s.setEng(60);
		s.setMath(76);
		
		System.out.println("이름 : " + s.getName());
		System.out.println("총점 : " + s.getTotal());
		System.out.println("평균 : " + s.getAverage());
		
	}

}

class Student4 {
//	Student4(){}
	private String name;
	private int ban;
	private int no;
	private int kor;
	private int eng;
	private int math;
	
	
	int getTotal(){
		return kor + eng + math;
	}
	double getAverage() {
		return getTotal()/3.0;
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
	
	
}