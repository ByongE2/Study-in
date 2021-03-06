import java.util.Scanner;

public class CalendarTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	      
	      int year,month,day,firstDay,i;
	      int monthday[] = {31,28,31,30,31,30,31,31,30,31,30,31};		// 1월~12월까지 마지막 일수.
	      
	      while(true) {
	    	  System.out.println("원하는 연도를 입력하세요. (종료:0)");
	    	  year = sc.nextInt();
	    	  if(year==0) {
	    		  break;
	    	  }
	    	  System.out.println("원하는 달을 입력하세요.");
	    	  month = sc.nextInt();
	    	  if(month<1 || month>12) {
	    		  System.out.println("1월에서 12월 사이의 달을 입력해주세요.");
	    		  return;
	    	  }
	    	 
	    	  if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) // 윤년 평년 구분
	    		  monthday[1] = 29;
	    	  else
	    		  monthday[1] = 28;
	    	 
	    	  day = ((year-1)*365)+((year-1)/4)-((year-1)/100)+((year-1)/400); // 전년도 * 365.2425
	    	  //	한 해의 일수 		+4년마다 윤년	-100년마다 평년		+400년마다 윤년 
	    	  
	    	  // day=(year-1)*365.2425로 한다.(실제 지구의 공전주기는 365.2422) 
	    	  //	0.003 오차 , 정수형으로 전환할 때의 오차. 오차 2개 있음.
	    	
	    	  for(i=0; i<month-1; i++) { // day + 전월의 일수까지의 합
	    		  day += monthday[i];
	    	  }
	    	  firstDay = (day%7)+1; 	    // 	1을 찍을 위치확인
	    	  							
	    	  System.out.printf("----------------------%d년 %d월----------------------%n",year,month);
	    	  System.out.printf("%s\t%s\t%s\t%s\t%s\t%s\t%s\t\n","일","월","화","수","목","금","토");   
	    	  for(i = 0; i < firstDay; i++) {
	    		  System.out.print("\t");   //1이 되기전 공백 넣음
	    	  }
	    	  for(i = 1; i <= monthday[month-1]; i++) {   //달의 일수만큼 찍음
	    		  System.out.printf("%d\t", i);
	    		  firstDay++;
	    		  if(firstDay%7 == 0) 
	    			  System.out.println();   // 줄바꿈.
	    	  }
	      }//end of while
	      System.out.println("프로그램이 종료됩니다.");
    }//end of main
}//end of class CalendarTest