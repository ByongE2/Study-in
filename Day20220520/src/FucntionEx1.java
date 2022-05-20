import java.util.ArrayList;
import java.util.function.Function;

public class FucntionEx1 {
	public static void main(String[] args) {
		Function<String, Integer> f = s->s.length();
		System.out.println(f.apply("abcd"));
		ArrayList<Integer> e = new ArrayList<>();
	}
	
	
}
