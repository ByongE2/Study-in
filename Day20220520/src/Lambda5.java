import java.util.Random;
@FunctionalInterface // 함수형 인터페이스.. 추상메서드 1개만 존재
interface Generator{
	int rand();
}

public class Lambda5 {

	public static void main(String[] args) {
		Generator gen = ()-> {
			Random rand = new Random();
			return rand.nextInt(50);
		};
		int num = gen.rand();
		System.out.println(num);
		
	}

}
