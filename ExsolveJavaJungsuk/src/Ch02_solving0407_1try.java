
public class Ch02_solving0407_1try {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double NumberOfCorrectAnswers = 2;
		double TotalNumberOfQuestions = 13;
		
		System.out.println("제 점수는 요?");
		System.out.println((int)(NumberOfCorrectAnswers / TotalNumberOfQuestions*100)+"점입니다.");
		
		
//	//	[2-1] boolean , 
//					char, 
//			byte,   short, int, long
//							float, double
//  	[2-2] 주민등록번호를 숫자로 저장하고자 한다. 이 값을 저장하기 위해서는 어떤 자료형
//		(data type)을 선택해야 할까? regNo라는 이름의 변수를 선언하고 자신의 주민등록번호로
//				초기화 하는 한 줄의 코드를 적으시오.
//		String regNo = "880825-1111111";   		 //틀림. 정답: long regNO = 8808251711111
//		System.out.println(regNo);
//				
////		[2-3] 다음의 문장에서 리터럴, 변수, 상수, 키워드를 적으시오.
//		int i = 100;
//		long l =100L;
//		final float PI = 3.14f;
//		- 리터럴 : 100, 100L, 3.14f, PI			틀림. 정답: PI는 안들어간다
//		- 변수 : int i, long l, 					틀림. 정답: i, l 
//		- 키워드 : final							틀림. 정답: int, long, final, float
//		- 상수 :	PI
//		[2-4] 다음 중 기본형(primitive type)이 아닌 것은?
//				a. int
//				b. Byte
//				c. double
//				d. boolean
//	      정답: 다 기본형인다. 				 		틀림.정답: b , 기본형은8개. 그 외 모두 참조형. byte(o)Byte(x)
//		[2-5] 다음 문장들의 출력결과를 적으세요. 오류가 있는 문장의 경우, 괄호 안에 ‘오
//		류’라고 적으시오.
//		System.out.println(“1” + “2”) → ( )
//		System.out.println(true + “”) → ( )
//		System.out.println(‘A' + 'B') → ( )
//		System.out.println('1' + 2) → ( )
//		System.out.println('1' + '2') → ( )
//		System.out.println('J' + “ava”) → ( )
//		System.out.println(true + null) → ( )
//		정답:
//		System.out.println(“1” + “2”) → (12)
//		System.out.println(true + “”) → (true)
//		System.out.println(‘A' + 'B') → (131)
//		System.out.println('1' + 2) → (50)  				틀림.정답:51 , '1'=0이다. 1아님.
//		System.out.println('1' + '2') → (97)				틀림.정답:99 , 같은이유.
//		System.out.println('J' + “ava”) → (Java)
//		System.out.println(true + null) → (오류)  null 메모리값 남아 있을 수 있어서 .java에서는 오류.
//		문자열과 덧셈연산을 하면 그 결과는 항상 문자열이 된다.
//		하지만 문자와 문자의 "덧셈연산"의 결과는 int형 정수값이 된다.	
//		왜냐하면 int형보다 작은 타입(byte, char, short)은 int형으로 변환된 후에 덧셈연산이 진행되기 때문이다.	
//		[2-6] 다음 중 키워드가 아닌 것은?(모두 고르시오)
//				a. if
//				b. True
//				c. NULL
//				d. Class
//				e. System
//		정답: b, c, 								틀림.정답:b,c,d,e
//		[2-7] 다음 중 변수의 이름으로 사용할 수 있는 것은? (모두 고르시오)
//				a. $ystem
//				b. channel#5
//				c. 7eleven
//				d. If
//				e. 자바
//				f. new
//				g. $MAX_NUM
//				h. hello@com
//		정답: a,d,f,g						틀림. 정답:a,d,e,g 	자바 가능, new는 예약어임.
//		[2-8] 참조형 변수(reference type)와 같은 크기의 기본형(primitive type)은? (모두 고
//				르시오)
//				a. int
//				b. long
//				c. short
//				d. float
//				e. double
//		정답: int, float(32bit), long,double(64bit) - 운영체제에 따라서 다르다.
//										틀림.정답:a,d  참조형은4byte임. 내가 말한건 word를 말한거임.
////		[2-9] 다음 중 형변환을 생략할 수 있는 것은? (모두 고르시오)
//		byte b = 10;
//		char ch = 'A';
//		int i = 100;
//		long l = 1000L;
//		a. b = (byte)i;
//		b. ch = (char)b;
//		c. short s = (short)ch;
//		d. float f = (float)l;
//		e. i = (int)ch;
//		정답: e									틀림.정답:d,e  float(4byte)>long(8byte)
//															실수형은 표현형식에 지수와 가수가 들어가서 더큰범위.	
//		[2-10] char타입의 변수에 저장될 수 있는 정수 값의 범위는? (10진수로 적으시오)
//		정답: -2e15 ~ 2e15-1 : 32,768~32,767
//								틀림.정답: 난 short타입 범위 적었다. "0~2e16-1"= char타입의 정수 값 표현범위.
//		[2-11] 다음중 변수를 잘못 초기화 한 것은? (모두 고르시오)
//				a. byte b = 256;
//				b. char c = '';
//				c. char answer = 'no';
//				d. float f = 3.14
//				e. double d = 1.4e3f;
//		정답: a, b, c, d 									와~~ 다맞췄다!
//		 		접미사 있는 자료형: long, float, double(생략가능)  대소문자 구분 안한다.
//		[2-12] 다음 중 main메서드의 선언부로 알맞은 것은? (모두 고르시오)
//				a. public static void main(String[] args)
//				b. public static void main(String args[])
//				c. public static void main(String[] arv)
//				d. public void static main(String[] args)
//				e. static public void main(String[] args)
//		정답: a,b,d,e							틀림.정답: a,b,c,e		배열[]는 타입 뒤ok,변수명 뒤ok
//		[2-13] 다음 중 타입과 기본값이 잘못 연결된 것은? (모두 고르시오)
//				a. boolean - false
//				b. char - '\u0000'				이게 기본값이라네. 
//				c. float - 0.0			0.0f
//				d. int - 0				
//				e. long - 0				0L
//				f. String - ""			null
//		정답: b? , c, e, f 					틀림.정답:c,e,f
//											0.0= 0.0d에서 d가 생략된것.
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
