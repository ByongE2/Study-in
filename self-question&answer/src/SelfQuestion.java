import java.util.Arrays;

public class SelfQuestion {
//  ex)1 ���� 1~100 ������ ���ڰ� 10���ִ� �迭��  ���� �� ������������ ����sort �ϼ���.
//	 //�ֹι�ȣ�� ���� Ȯ��, 2000�� �������� �������� Ȯ��. ��ø switch������.											>>���� ���� p155 ����
//	if�� ����ؼ�, 5�� ���� �Է¹޾Ƽ�, ���� ū ��(�ִ밪)�� ����ϴ� ���α׷�. �Է¹޴� ���ڴ� 0~100���� ����(0~100 �̿��� ���ڴ� ����)     >>���� Aex_0415
//	������� , ���̱���, ������, ������ ���� �������ϰ�. ����� ���ΰ�? ( �⺻��� 1500, ���̴� ����, 0~3�� ������ 100% 4~13�� ������ 50%,  >>���� Aex_0415 
//														14~19�� ������ 25%, 20�� �̻� ������ 0%, 65�� �̻� ������ 100% )
//      *	
//	   **
//	  ***
//	 ****
//	*****  ���� ?																>>���� Aex_0415 �����Դ��� �ٸ������.
//	
//	
//	
//	
//	//총점 평균 구하기. 2차원 배열
//			int[][] arr = {
//						 {5,5,5,5,5}
//						,{10,10,10,10,10}
//						,{20,20,20,20,20}
//						,{30,30,30,30,30}
//					
//						};
//			int total = 0;
//			float avg = 0;
//			int count=0;
//			for(int i=0; i< arr.length; i++) {
//				for(int j=0; j<arr[i].length; j++) {
//					total += arr[i][j];
//					count++;
//				}// end of for j
//			}// end of for i
//			System.out.println("갯수 : "+ count);
//			avg = total / (float)count;
//			System.out.println("총점 : " + total);
//			System.out.println("평균: " + avg);
///		System.out.println(20*(float)16.25);	
	
//	1과 9사이의 중복되지 않은 숫자로 이루어진 3자리 숫자를 만들어내는 프로
//	로그램이다. (1)~(2)에 알맞은 코드를 넣어서 프로그램을 완성하시오.
	
//	int[] ballArr = {1,2,3,4,5,6,7,8,9};
//	int[] ball3 = new int[3];
//	//배열 ballArr의 임의의 요소를 골라서 위치를 바꾼다.
//	for (int i = 0; i < ballArr.length; i++) {
//		int j = (int)(Math.random()*ballArr.length);
//		int tmp = 0;
//		tmp = ballArr[j];
//		ballArr[j] = ballArr[i];
//		ballArr[i] = tmp;
//	}
//	System.out.println(Arrays.toString(ballArr));
//	// 배열 ballArr의 앞 3개의 수를 배열 ball3로 복사한다.
//	for (int i=0; i<ball3.length; i++) {
//		int tmp = 0;
//				tmp = ballArr[i];
//		ballArr[i] = ball3[i];
//		ball3[i] = tmp;
//	}
//	System.out.println(Arrays.toString(ball3));
	
	
//	다음은 거스름돈을 몇 개의 동전으로 지불할 수 잇는지를 계산하는 문제이다. 변수 money의 금액을 동전으로 바꾸었을 때 각각 몇 개의
//	동전이 필요한지 계산해서 출력하라. 단, 가능한 한 적은 수의 동전으로 거슬러 주어야한다.
//	(1)에 알맞은 코드를 넣어서 프로그램을 완성하싱오.
//	힌드: 나눗셈 연산자와 나머지 연산자를 사용해야 한다.
	
//	int[] coinUnit = {500,100,50,10};
//	int money = 2680;
//	System.out.println("money= " + money);
//	
//	int a=0;
//	int b=0;
//	for(int i =0; i<coinUnit.length; i++) {
//		int num = money / coinUnit[i];
//		money %= coinUnit[i];
//		System.out.println(coinUnit[i] + "원 : " + num + "개");
//	}

//	int[] coinUnit = {500, 100, 50, 10};
//	int money = 2680;
//	System.out.println("money = " + money);
//	
//	for(int i = 0; i < coinUnit.length; i++) {
//		int[] coinCount = new int [coinUnit.length];
//			coinCount[i] = money / coinUnit[i];
//			System.out.println(coinUnit[i] + "원 짜리 동전 " + coinCount[i] + "개");
//			money = money % coinUnit[i];
//	}//end of for
//	
//	배열 anser에 담긴 데이터를 읽고 각 숫자의 개수를 세어서 개수만큼'*' *을 
////	찍어서 그래프를 그리는 프로그램이다. (1)~(2)에 *알맞은 코드를 넣어서 완성하시오.
//	
//	int[] answer = {1,4,4,3,1,4,4,2,1,3,2};
//	int[] counter = new int[4];
//	for(int i =0; i<answer.length; i++) {
//		counter[answer[i]-1] ++;				//1~4를 0~3으로.위해 -1
//	}
//	for(int i=0; i<counter.length; i++) {
////		System.out.print(counter[i]);
//		System.out.print((i+1)+ "의 개수" +counter[i]);
//		for(int j=0; j<counter[i]; j++) {
//			System.out.print("*");
//		}
//		System.out.println();
//	}

	
	
	// 오름차순의 선택정렬 [9,6,7,3,5]를 4회전 결과

//	int tmp=0;															//내가 하다가 그만둔것.
//	int[] arr = { 9,6,7,3,5 };
//	for(int i=0; i< arr.length-1; i++) {
//		for(int j=i+1; j < arr.length-2-i; j++) {
//			
//			for(int k = 2; k<arr.length; k++) {
//				if(arr[j] > arr[k])
//					tmp = arr[j];
//				arr[j] = arr[k];
//				arr[k] = tmp;
//			}
//
//			if(arr[i] > arr[j]) {
//				tmp = arr[i];
//				arr[i] = arr[j];
//				arr[j] = tmp;
//			}
//		}//end of for j
//		System.out.println(Arrays.toString(arr));
//	}//end of for i
	
//	int[] nArr = {9,6,7,3,5};									//선생님꺼 		스프링,jsp는 패턴 같아서 거의 비슷하다. 거의암기라 보면된다.
//																			몇년하고 그 이상의 수준으로 갈 때 직접 짜거나..수정하거나..가 가능한가.
//	for(int i=0; i<nArr.length-1; i++) {
//		int index=i;
//		
//		for(int j=i+1; j<nArr.length; j++) {
//			if(nArr[index] > nArr[j]) index=j;
//		}
//		if(index !=i) {
//			int tmp= nArr[index];
//			nArr[index] = nArr[i];
//			nArr[i] = tmp;
//		}
//		System.out.println(i + 1 + "회전" + Arrays.toString(nArr));
//	}
//	System.out.println(Arrays.toString(nArr));
	
	
	
	
	
	
}
