import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

// 기본형이 아닌, 다른 객체를 HashSet으로 다룰 때, hashCode와 equals 오버라이딩 해야한다. (안하면 중복데이터 들어감)hashCode는 대충?
class Car{
	private String model;
	private String color;
	int price;
	public Car(String model, String color, int price) {
		this.model = model; this.color = color; this.price = price;
		}
	@Override
	public String toString() {
		return "[" + model + "," + color + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(model,color);
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Car) {
			Car tmp = (Car)obj;
			return model.equals(tmp.model) && color.equals(tmp.color) && tmp.price==price;
		}
		return false;
	}
	
}

public class HashSetEx3 {

	public static void main(String[] args) {

		Set<Car> set = new HashSet<Car>();
		
		set.add(new Car("Y201","red",1));
		set.add(new Car("Y202","black",2));
		set.add(new Car("Y201","red",3));
		set.add(new Car("Y201","white",4));
		set.add(new Car("Y203","black",5));
		System.out.println(set.size());
		for(Iterator<Car> it = set.iterator(); it.hasNext();)
			System.out.print(it.next() + " ");
		System.out.println();
		for(Car s : set)
			System.out.print(s + " ");
	}

}
