
public class Aex_ch5_0412_2ver {

	public static void main(String[] args) {
		int n,n2;
		n  = 5;
		n2 = 9;
		System.out.println("����"+n+","+n2);
		double result = divide(n,n2);	
		System.out.println("���Z"+result+","+n2);
		
	}//main ��

	 public static float divide(int x , int y) {
		 if(y==0) {
			 System.out.println("0���� ������ ����");
			 return 0;
		 }
		 else {
		 return x/ y;
		 }
	 }//sub ��
}//Ŭ���� ��
