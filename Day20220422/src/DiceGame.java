import java.util.Random;

// 주사위 2개 던진다. 두수의 합이 5가되면 종료.

public class DiceGame {

	public static void main(String[] args) throws InterruptedException {

		Random rand = new Random();
		
		int dice1=0;
		int dice2=0;
		
		System.out.println("두 주사위의 합이 5가 될 때 까지");
		while(true) {
			dice1 = (int)(rand.nextInt(6)) + 1;
			dice2 = (int)(rand.nextInt(6)) + 1;
			Thread.sleep(500);
			System.out.println(dice1 +" " + dice2);
			if(dice1 + dice2 == 5) break;
		}
		System.out.println("종료");
	}

}
