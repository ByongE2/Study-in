import java.util.Arrays;
import java.util.Random;

public class Aex_ch05_0421 {

	
	public static void main(String[] args) {
		// 세 정수를 입력받아서 최대값 출력(배열x) 조건문 0421 Ezen github
		// 세 정수를 큰 순서대로 출력(배열x) 조건문
		// 첫번쨰꺼 함수로.
		// 숫자만 입력하고, 2자리 정수를 입력하기전까지 무한 반복 10~99
		// 두 배열 요소가 같으면 true, 틀리면 false
		// 달력
		// int[] nArr = new int[10] ; ==> 난수 0~9를 배열입력
		// 단, 붙어있는 아이는 중복되면 안된다.
		
		Random rand = new Random();
		int[] lotto = new int[6];
		
		for(int i=0; i < lotto.length; i++) {
			lotto[i] = rand.nextInt(45)+1;
			for(int j=0; j<i; j++) {
				if(lotto[i] == lotto[j]) {
					i--;
					break;
				}
			}
		}
		for(int tmp : lotto)
			System.out.print(tmp + " ");
//			System.out.println(Arrays.toString(lotto));
		
		
		
		
		
		
		
		
			
	}//end of main
		
		
}//end of class

















