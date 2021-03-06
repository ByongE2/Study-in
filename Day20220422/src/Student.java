import java.util.Scanner;

// 2차원배열, 5명 학생 두과목(영어,수학)을 입력받아서 과목별 평균, 학생별 평균을 구하는 프로그램

public class Student {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int number = 5;
		int[][] subject = new int[number][2];
		int[] totalStudent = new int[number];
		int[] totalSubject = new int[2];
		
		System.out.printf("%d명 영어,수학 점수 입력.\n",number);
		
		for(int i=0; i<number; i++) {
			System.out.printf("%d번 영어:",i+1);
			subject[i][0] = sc.nextInt(); // 영어
			System.out.println("   수학:");
			subject[i][1] = sc.nextInt(); // 수학
			
			totalStudent[i] = subject[i][0] + subject[i][1]; // 
			totalSubject[0] += subject[i][0]; // 영어합계
			totalSubject[1] += subject[i][1]; // 수학합계
		}
		System.out.println("No.   영어          수학         평균");
		for(int i=0; i<number; i++) 
			System.out.printf("%2d %6d %6d %6.1f\n", i+1, subject[i][0], 
								subject[i][1], (double)totalStudent[i]/2);

			System.out.printf("평균 %11.1f %6.1f\n",(double)totalSubject[0]/number, 
								(double)totalSubject[1]/number );
		
		
	}//end of main

}
