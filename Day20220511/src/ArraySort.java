import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArraySort {

	public static void main(String[] args) {

		Map<String, Integer> m = new HashMap<String, Integer>();
//		System.out.println(p);
		m.put("김씨", 20);
		m.put("박씨", 30);
		m.put("이씨", 40);
		System.out.println(m);
		System.out.println(m.get("김씨")); // 
	
	}

}

//이름넣고 나이넣고 출력되게끔
class Person{
	private String name;
	private int age;
	
	public Person() {
		this("",0);
	}
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
}