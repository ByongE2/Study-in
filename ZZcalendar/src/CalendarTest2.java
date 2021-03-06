import java.util.Calendar;
import java.util.Scanner;
// 최종
public class CalendarTest2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	      
	      int year,month,week,day,i;
	      int monthday[] = {31,28,31,30,31,30,31,31,30,31,30,31};		// 1월~12월까지 일수. 2월은 28이 default
	      
	      System.out.print("원하는 년도를 입력하세요. ");
	      year = sc.nextInt();
	      System.out.print("원하는 달을 입력하세요. ");
	      month = sc.nextInt();
	      
	      if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) // 윤년인지 아닌지.
	         monthday[1] = 29;
	      else
	         monthday[1] = 28;
	      
	      day = ((year-1)*365)+((year-1)/4)-((year-1)/100)+((year-1)/400);
	      	 //연도에따른 일수 + 4년마다 윤년+ 100년마다 윤년- 400년마다 윤년+ 
	      	 // day=(year-1)*365.2425로 한다.(실제 지구의 공전주기는 365.2422xxxx) 0.003 오차 있음
	      	 // 전년도 * 365.2425로 전년도 12/31까지 실제 총일수를 구한값
	      
	      for(i=0; i<month-1; i++) { // day + 전월의 일수까지의 합
	         day += monthday[i];
	      }
	      week = (day%7)+1;   // {나머지 0~6 => (일~토)} 						1를 찍을 위치확인
			  				  //1년 1월 1일은 월요일. so 일요일을 앞에두기위해 +1         >>0=일, 1=월, 6=토
	      System.out.printf("----------------------%d년 %d월----------------------%n",year,month);
	      System.out.printf("%s\t%s\t%s\t%s\t%s\t%s\t%s\t\n","일","월","화","수","목","금","토");   
	      for(i = 0; i < week; i++) {
	         System.out.print("\t");   //1이 되기전 공백 넣음
	      }
	         for(i = 1; i <= monthday[month-1]; i++) {   //달의 일수만큼 찍음
	            System.out.printf("%d\t", i);
	            week++;
	            if(week%7 == 0) 
	            System.out.println();   //일주일 지나면 줄바꿈
	      }

    }//end of main
}//end of class
