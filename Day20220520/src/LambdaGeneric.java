@FunctionalInterface
interface Calculate<T>{
	T cal(T a, T b);
}
public class LambdaGeneric {

	public static void main(String[] args) {
		Calculate<Integer> c = (a,b)-> a+b;
		System.out.println(c.cal(5, 10));
		
		Calculate<Double> c1 = (a,b)-> a/b;
		System.out.println(c1.cal(5.0, 10.0));
		
	}

}
