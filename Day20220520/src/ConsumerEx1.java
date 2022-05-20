import java.util.function.Consumer;

public class ConsumerEx1 {
	public static void main(String[] args) {
		Consumer<Integer> c = s->System.out.println(10);
		c.accept(10);
	}
}
