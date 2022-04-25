import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) throws IOException, InterruptedException {

		int count=0;
		{
			File file = new File("Day0408/data1.txt");   // 에러 창에서  java.io 클릭 > import문 생기고 에러 수정됨
			FileInputStream src = new FileInputStream(file); // 에러 창에서 예외처리2가지 방식 뜨는데, 일단은 위에것.
			Scanner sc = new Scanner(src);		// System.in 이 아니라, src가 가리키는 data를 매개변수로 넣은것.
		
			while(sc.hasNext()) {				// 갯수를 몰라서 for 대신 while   // Nextline 대신 next
				String tmp = sc.next();
				System.out.printf("%s ", tmp);								//nextline 대신 next
				count++;
			}
			System.out.println("\ncount: " + count);
		
			sc.close();
			src.close(); 					// 에러창에서 젤위에것. 변환
		}
		int[] nums = new int[count];				// 배열로 바꾸자   , count 만들고 넣어주면됨
		{
			// 배열 공간 data1.txt 내용 넣기
			File file = new File("Day0408/data1.txt");
			FileInputStream src = new FileInputStream(file);
			Scanner sc = new Scanner(src);
			
			for(int i =0; i<count; i++) {
				String tmp = sc.next();
				nums[i] = Integer.parseInt(tmp);
			}
			
			System.out.println("nums : " + Arrays.toString(nums));
			
			sc.close();
			src.close();
		}				
		// 배열에서 특정 숫자를 찾기
		{
			// 반복해서 찾아야 한다. 88번째 몇번째 있는지 출력
			int index = -1; // 0으로 하면 안됭
			for(int i = 0; i<count; i++)
				if (88 == nums[i]) {
					index = i;
					break;
					}
		
			System.out.println("index: " + index);
		}
		// index 위치 변경 >>>> 0 <--> 5 위치 교환
		{
			int tmp;
			tmp = nums[0];
			nums[0]=nums[5];
			nums[5]=tmp;
			System.out.println("nums : " + Arrays.toString(nums));
		}
		//반복적으로 i<> i+1를 교환
		{
			for( int i=0; i<(count-1); i++) {
				int tmp;
				tmp = nums[i];
				nums[i] = nums[i+1];
				nums[i+1] = tmp;
			
				Thread.sleep(1000);			//메서드 예외처리 한번더.	//딜레이. 1000= 1초 (1,000 * 1/1,000,000 = 1
				
				for(int j=0; j<50; j++)
		               System.out.println();
		            
		            for(int j=0; j<count; j++) {
		               if(j == i+1)
		                  System.out.printf("[%d] ", nums[j]);
		               else
		                  System.out.printf("%d ", nums[j]);
		            }
			}
//			System.out.println("nums : " + Arrays.toString(nums));
		}
	}// end of main

}// end of class
