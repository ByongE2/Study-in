
public class Aex_ch5_0412_2ver {

	public static void main(String[] args) {
		int n,n2;
		n  = 5;
		n2 = 9;
		System.out.println("비포"+n+","+n2);
		double result = divide(n,n2);	
		System.out.println("에픝"+result+","+n2);
		
	}//main 끝

	 public static float divide(int x , int y) {
		 if(y==0) {
			 System.out.println("0으로 나눌수 없다");
			 return 0;
		 }
		 else {
		 return x/ y;
		 }
	 }//sub 끝
}//클래스 끝
