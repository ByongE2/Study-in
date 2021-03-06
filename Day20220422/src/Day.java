import java.util.Random;
import java.util.Scanner;

// 일 월 화 수 목 토 일 --> 랜덤하게 이 중 하나가 나오면 
//		그에 맞는 소문자로 요일 이력 

public class Day {

	public static void main(String[] args) {
		
		Random rand = new Random();
		Scanner sc = new Scanner(System.in);

		String[] korDay = new String[] { "일", 	   "월", 	 "화", 	    "수", 	    "목", 	   "금", 	"토"       };
		String[] engDay = new String[] { "sunday", "monday", "tuesday", "wednesday","thursday","friday","saturday"};
		
		int retry = 0;
		int last = -1;
		int countS = 0;
		int countF = 0;
		do {
			int day;
			do {
				day = rand.nextInt(7);
			}while(day == last);
			last = day;
			while(true) {
				System.out.println(korDay[day] + ":");
				String input = sc.nextLine();
				if(input.equals(engDay[day])) {
					break;
				}
				
				System.out.println("오답입니다. 다시입력해주세요");
				countF++;
			}
			System.out.println("정답입니다. 재도전(1), 종료(0)");
			countS ++;
			retry = sc.nextInt();
			sc.nextLine();
			
		}while(retry == 1 );
		System.out.println("성공/실패 횟수 : " + countS + " " + countF);
		System.out.println("프로그램 종료.");
		
	}//end of main

}
