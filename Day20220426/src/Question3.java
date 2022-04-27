
public class Question3 {

	public static void main(String[] args) {

		Student5 s = new Student5("홍길동", 1, 1, 100, 60, 76);
		
		
//		s.setName("홍길동");
//		s.setBan(1);
//		s.setNo(1);
//		s.setKor(100);
//		s.setEng(60);
//		s.setMath(76);
//		System.out.println("이름 : " + s.getName());
//		System.out.println("총점 : " + s.getTotal());
//		System.out.println("평균 : " + s.getAverage());
		
		System.out.println(s.info());
//		
	}

}

class Student5 {
//	Student4(){}
	private String name;
	private int ban;
	private int no;
	private int kor;
	private int eng;
	private int math;
	
//	info(){
//		System.out.println(this.name,this.ban,this.no,kor,eng,math);
//	}
	
	Student5(String name, int ban, int no, int kor, int eng, int math){
		this.name=name;
		this.ban=ban;
		this.no=no;
		this.kor=kor;
		this.eng=eng;
		this.math=math;
	}
	
	String info() {
		return name +","+ ban +","+ no + "," + kor + "," + eng + "," + math + ","
			+ getTotal() + "," + getAverage();
	}
	
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