import java.util.Scanner;

public class CalendarTest1 {  		//https://kyleyj.tistory.com/11 참고

// 4로 나누어떨어지는 해, 400으로 나누어 떨어지는 해는 윤년 (ex: 4,8,12,2000,2400)
//	4로 나누어 떨어지지만, 100으로도 나누어 떨어지는 해는 평년

//	1	
// 특정 년도의 "1월 1일의 요일"에서 그 다음 년도의 1월 1일의 요일은 "평년일 때 1일, 윤년일 때 2일 오른쪽으로 이동"
// (ex:2019년 1월1일이 화요일이면 > 2020년 1월1일은 수요일  -- 평년
//	   2020년 1월1일이 수요일이면 > 2021년 1월1일은 금요일  -- 윤년)
//	2
// 특정 월의 1일의 요일에서 그 다음 월의 1일의 요일은 해당 월의 총 일수를 7로 나눈 나머지만큼 오른쪽으로 이동한다.
//	(ex: 1월 1일이 수요일이라면, 2월 1일은 토요일이다. (1월은 31일까지 있기 때문에, 31 % 7 == 3)
//		2월 1일이 토요일이고 윤년이 아니라면(즉 28일까지만 있다면), 3월 1일도 토요일이다. (28 % 7 == 0) )
	
// 1+2로 "기준점을 정하면" 어느 년도의 어느 월이든 1일의 요일을 알 수 있다.
	
	public static int monthDay(int year, int month) { 				// 각 월의 끝나는 일수를 알 수 있는 메서드
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
			return 31;
		} else if (month == 4 || month == 6 || month == 9 || month == 11) {
			return 30;
		} else {
			if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
				return 29;											//윤년
			} else {
				return 28;											//평년
			}
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);				//Scanner 선언 및 생성
		System.out.println("년도를 입력하세요: ");			
		int year = scanner.nextInt();							//변수 year에 입력받은 숫자 저장
		System.out.println("월을 입력하세요: ");
		int month = scanner.nextInt();							//변수 month에 입력받은 숫자 저장
		System.out.println();

		System.out.println(year + "년 " + month + "월의 달력");

		int sum = 0;

		for (int i = 1583; i < year; i++) {								//기준일을 1583년 1월1일로 지정. 실제 달력이 제대로 사용된 시기. 그레고리력
			if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {			
						// 윤년이라면 
				sum += 2;
			} else {
						// 평년이라면
				sum += 1;
			}
		}

		int first = (sum + 6) % 7; 										// 1583년 1월1일을 기준으로 Scanner에 입력한 year의 1월 1일의 요일 알아내기

		for (int j = 1; j < month; j++) {
			first += monthDay(year, j) % 7;
		}

		int day = first % 7; 											// 입력한 month의 1일의 요일
		int num = 1;												    //month의 일 표시
		int max = monthDay(year, month); 								// 해당 month가 가지는 최대 일 수
		boolean start = false;

		System.out.println(" Sun  Mon  Tue  Wed  Thu  Fri  Sat ");

		loop: for (int row = 0; row <= 5; row++) {						// 행
			for (int column = 0; column <= 6; column++) {				// 열
				if (row == 0 && !start) {
																		// 첫행에 시작일이 없는 경우를 위해서.
					if (column == day) {
						// 시작 일에 도달하면
						start = true;
					} else {
						// 시작 일에 도달 전에는 공백
						System.out.print("     ");
						continue;
					}
				}

				System.out.printf("  %02d ", num);
				num++;

				if (num > max) {
					// 최대 일 수에 도달하면 break loop
					break loop;
				}
			}
			System.out.println("");
		}

	}

}