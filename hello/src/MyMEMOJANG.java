import java.util.Scanner;

public class MyMEMOJANG {

	public static void main(String[] args) {

		 int year=0;
	        int month=0;
	        int first=0;
	        int days=0;
	        Scanner sc=new Scanner(System.in);
	        
	        // year와 month의 값을 입력받는다
	        System.out.println("년도를 입력 하세요");
	        year=sc.nextInt();
	        System.out.println("월을 입력하세요");
	        month=sc.nextInt();
	        
	        //상위 입력값과 요일 출력단위
	        System.out.println(year+" 년 "+month+" 월 ");
	        System.out.println("일"+"\t"+"월"+"\t"+"화"+"\t"+"수"+"\t"+"목"+"\t"+"금"+"\t"+"토"+"\t");

	        //전년도 총날 수 구하는 알고리즘
	        int day=(year-1)*365+(year-1)/4-(year-1)/100+(year-1)/400;
	        
	        //전달에 관하여 계산하는 공식 (윤년과 편년 계산)
	        int[] lastday= {31,28,31,30,31,30,31,31,30,31,30,31};
	        if((year%4==0&&year%100!=0)||(year%400==0)) {
	           lastday[1]=29;
	        }else {
	           lastday[1]=28;
	        }
	        
	        for(int i=0;i<month-1;i++) {
	        day+=lastday[i];
	        }
	        //1일 시작하는 요일 구하는 공식
	        day++;
	        days=day%7;
	        
	        //출력단계
	        System.out.println();
	        //i를 last배열에 -1만큼 돌리는데
	        for(int i=1;i<=lastday[month-1];i++) {
	           //i값이 1이 올경우 탭을 하여 빈 여백을 만드는 형식
	           if(i==1) {
	              for(int j=0;j<days;j++) {
	                 System.out.print("\t");
	              }
	           }
	           //if 문을 통과하여 1부터 글자를 출력하고 days를 더하게 하며 만약 days가 6까지 출력되면 다음 행으로 가는 문장
	           System.out.print(i+"\t");
	           days++;
	           if(days>6) {
	              days=0;
	              System.out.println();
	            
	           }
	        }

  
	}//main��
}//class ��