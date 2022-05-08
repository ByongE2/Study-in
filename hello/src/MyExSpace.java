import java.util.Arrays;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
class MyExSpace{
	//	MyExSpace(){}
	public static void main(String[] args) {
	
		//정렬
		String[] arr = {"Ab","ab","56","34","12"};
		System.out.println(Arrays.toString(arr));	
		
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));	
			
		
	
		
	}
}

