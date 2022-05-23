import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.function.IntSupplier;
import java.util.function.IntUnaryOperator;

public class LambdaEx6 {
	IntSupplier s = () -> (int)(Math.random()*100)+1;
	IntConsumer c = i -> System.out.println(i+",");
	IntPredicate p = i -> i%2==0;
	IntUnaryOperator op = i -> i;
}
