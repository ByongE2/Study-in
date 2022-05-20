import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

//Predicate 함수형인터페이스
//test() 있고, 반환타입은 boolean 이다.
public class PredicateEx01 {
	public static int sum(Predicate<Integer> p , List<Integer> lst) {
		int sum=0;
		for(int n : lst)
			if(p.test(n))
				sum += n;
		return sum;
	}
	
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,3,5,2,4,6);
		
		int result;
		result = sum(n -> n%2==0, list);
		System.out.println("짝수 합: " + result);
		result = sum(n -> n%2==1, list);
		System.out.println("홀수 합: " + result);
	}
}
