import java.util.Arrays;
import java.util.Scanner;

public class Aex_ch5_0413 {
	public static void main(String[] args) {  //jvm 호출

		int[] a = new int[5];
		
			for(int i =0; i<a.length; i++ )
		a[i]=(int)(Math.random()*99)+1; 						// why not 100?
			System.out.println(Arrays.toString(a));
		
		int max =  a[0];
		int min =  a[0];
			for(int i =0; i<a.length; i++ ) {
				if(max < a[i])
				   max = a[i];
				
				if(min > a[i])
			       min = a[i];
			}
			System.out.println("max :"+max);
			System.out.println("min :"+min);

		//Sort(정렬)
		 for(int i =0; i<a.length-1; i++ ) {
			 for( int j=0; j<a.length-1-i; j++)
			 if(a[j] > a[j+1]) {
				 int tmp = a[j];
			 		 a[j]= a[j+1];
			 		 a[j+1]= tmp;
			 	} 
		 	}
		
		 	System.out.println(Arrays.toString(a));
		for(int i=0; i<a.length; i++)
			System.out.printf("%d\t",a[i]);
				
		
	}//main 끝
}//class 끝

//		for(int i=0; i < a.length-1; i++ ) {
//			 for(int j=i; j <a.length; j++)
//			 if(a[i] > a[j]) {
//				 int tmp = a[i];
//			 		 a[i]= a[j];
//			 		 a[i]= tmp;
//}
//}