


public class Aex_ch2_0407 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

////		[2-5]
//		System.out.println("1"+"2");  // 12
//		System.out.println(true);
//		System.out.println('A'+'B');
//		System.out.println('1'+2);
//		System.out.println('1'+'2');
//		System.out.println('J'+2);                           //나이거 틀림. j가 바뀌기전에 문자열로 바로바뀜.
//   //	System.out.println(true+null); 				 // null은 아무것도 없기떄문에 연산자체도 안됨. error
//		//		12
////		"true"  
////		65+66해서 131  0?
////		'1'반환값에 +2  2?
////		'1'값에 '2' 연산 더한것  0?
////		j값에 ava해서 'j'ava  
////		true
//	
//		[2-9]
//		c, d, e
//		
//		byte b = 10;
//		char ch = 'A';
//		int i = 100;		
//		long l = 1000L;
////		b = (byte)i;
////		ch = (char)b;
////		short s = (short)ch;             //나이거 틀림. >> ch: 0~2e16 , s: -2e15~2e15-1
////		float f = (float)i;
//		i = (int)ch;
//	System.out.println();
//		[2-11] 초기화틀린것은? : a b c d  맞춤.
//		byte b = 256;   
//				char c = '';
//		char answer = 'no';
//		float f = 3.14;
//		double d = 1.4e3f;
// 				System.out.println(d) ;
//	
//		Package ex01; 삼항연산자 이용해서 양수 0 음수 나오게하라. hint 3항연산자 2개 사용.
//		int num = 10; 
//		System.out.println(num >= 0 ? (num==0 ? "0":"양수"):"음수"); // 다른사람 정답
//		System.out.println((num>0) ? "양수" : (num==0) ? "0" : "음수"); // 선생이 원하는 정답. 이게맞다네.
//																	// 흠 난 위에것이 깔끔하긴한데.
	
//		int num = 111;
//		System.out.println((int)(num/100)*100); //내가 낸 답.
//		System.out.println(num/100*100); //답
//	
//		int num = 333;
//				System.out.println(num/10*10+1);
		
		
//		x>num, 가까운 10의 배수 - num 의 나머지%
//		int num = 24;
//		if (num%10==0)
//		System.out.println(10-num % 10);   // 
//	
//	int fahrenheit = 100;
//	float celcius = (int)((5/9f * (fahrenheit - 32))*100 +0.5f )/100f;  //난 5/9에 f안넣었다.
//			System.out.println("Fahrenheit:"+fahrenheit);				//난 0.5f더하지않고 5를 더했다.
//			System.out.println("celcius:"+celcius);						//100으로 나누면안되고 100f로나눠야.
//		
//	
//	char ch = '*';
//	boolean b = ('a'<=ch && ch <= 'z') ||  
//			 	('A'<=ch && ch <='Z')  ||							// 난 &&대신||했다.
//			 	('0'<=ch && ch <= '9');           					// 난 '1'부터 시작했었다
//				System.out.println(b);
	
//	char ch = 'b';
//	char lowerCase = (('A'<=ch && ch <='Z') ? (char)(ch+32) : ch); // 난 형변환 생각못함
//	System.out.println("ch:"+ch);										 
//	System.out.println("ch to lowerCase:"+lowerCase);
		
//	int x = (10 < x && x < 20) ? true : false;
//	char ch1 = (10 < x && x < 20) ? !(" " && \t) : false;         //공백= ' ' , 탭 = '\t'
//	char ch2 = (ch2=='x' || ch2=='X') ? true : false;
//	char ch3 = ('0' <= x && x <= '9') ? true : false;
//	char ch4 = ('a' <= x && x <= 'Z') || ('A' <= x && x <= 'Z') ? true:false ;
//	int year = ((year%400==0 || year%4==0)!(year%100==0)) ? : true:false;      //나틀림.
//	int year = ((year%400==0) || (year%4==0)) &&(year%100!=0)) ? : true:false;      //정답
		//	boolean powerOn = powerOn==0 ? true:false                              //틀린듯?
//			boolean powerOn = false;                        					      //정답
//		System.out.println("7: + "+!powerOn);
//	String str = (str=="yes") ? true:false;									//틀림
//	String str = "yes";													//정답
//		System.out.println("8:"+ str.equals("yes"));
												//난 하는법 싹다 잘못됬다.
												//int x; char ch; 이런거 선언하고 난다음에. 프린트ln에 넣으면된다.
//	ex
//	int x = 0 ;									//조건식은 boolean 하거나 프린트 ln메서드에. 2가지방법.
//	boolean y= 10 < x && x < 20;
//	System.out.println(y);
//	
//	int x1 = 0;
//	System.out.println(10 < x1 && x1 < 20);
//	
	
				
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	
	
	
	}

}
