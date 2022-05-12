import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Person2{
	private String name;
	private int age;
	Person2(String name, int age){
		this.name=name;
		this.age=age;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name,age);
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Person2) {
			Person2 tmp = (Person2)obj;
			return name.equals(tmp.name) && age==tmp.age;
		}
		return false;
	}
	@Override
	public String toString() {
		return "이름 : " + name + "나이 : " + age;
	}
}

public class HashSetEx4 {

	public static void main(String[] args) {

		Set set = new HashSet();
		set.add("abc");
		set.add("abc");
		set.add(new Person2("kim",10));
		set.add(new Person2("kim",10));
		
		System.out.println(set);
	}

}
