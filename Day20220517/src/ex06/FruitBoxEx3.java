package ex06;

import java.util.ArrayList;

class Fruit{public String toString() {return "과일";}}
class Apple extends Fruit{public String toString() {return "사과";}}
class Grape extends Fruit{public String toString() {return "포도";}}
class Juice{
	String name;
	Juice(String name){ this.name = name + "쥬스";}
	public String toString() {return name;}
}
class Juicer{
	static Juice makeJuice(FruitBox<? extends Fruit> box) {
		String tmp = "";
		for(Fruit f : box.getlist())
			tmp += f + " ";
		return new Juice(tmp);
	}
}
public class FruitBoxEx3 {

	public static void main(String[] args) {
		FruitBox<Fruit> fruitBox = new FruitBox<Fruit>();
		FruitBox<Apple> appleBox = new FruitBox<Apple>();
		
		fruitBox.add(new Apple());
		fruitBox.add(new Grape());
		appleBox.add(new Apple());
		appleBox.add(new Apple());
		
		System.out.println(Juicer.makeJuice(fruitBox));
		System.out.println(Juicer.makeJuice(appleBox));
	}

}
class FruitBox<T extends Fruit> extends Box<T> {}
class Box<T>{
	ArrayList<T> list = new ArrayList<T>();
	void add(T item) {list.add(item);}
	T get(int i) {return list.get(i);}
	ArrayList<T> getlist() {return list;}
	int size() { return list.size();}
	public String toString() {return list.toString();}
}