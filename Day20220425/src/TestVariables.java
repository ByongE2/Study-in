class Variables {
	int iv; // 인스턴스변수
	static int cv;	// 클래스 변수
	void method() {
		int lv = 0;		//지역변수
	}
	
}


public class TestVariables {

	public static void main(String[] args) {

		Variables2 var = new Variables2();
		var.iv++;
		var.cv++;
		System.out.println("var.iv : " + var.iv);
		System.out.println("   var.cv : " + var.cv);

		Variables2 var2 = new Variables2();
		var2.iv++;
		
		Variables2.cv++;					//객체생성 없이 사용가능,   var2.cv 보다는 Variables.cv로 쓰는걸 권장. 직관적으로 느껴지게끔.
								
		System.out.println("var.iv : " + var2.iv);			//참조변수가 참조하는 인스턴스(객체)는 별개로 존재한다.
		System.out.println("   var.cv : " + var2.cv);
	
		Variables2 var3 = new Variables2();
		var3.iv++;
		var3.cv++;
		System.out.println("var.iv : " + var3.iv);
		System.out.println("   var.cv : " + var3.cv);
		

		
	}

}
