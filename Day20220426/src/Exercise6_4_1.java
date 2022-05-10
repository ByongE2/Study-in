import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class Exercise6_4_1 {

	public static void main(String[] args) {

		Student2 s = new Student2("손흥민",1,10,90,100,60);
	}
}

@Getter
@Setter
@ToString
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
	public Student2(String name, int ban, int no, int kor, int eng, int math) {
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		System.out.println("생성자 호출");
	}
	int getTotal() {
		int sum = kor+eng+math;
		return sum;
	}
	
	double getAverage() {
		return getTotal()/3.0;
	}
}