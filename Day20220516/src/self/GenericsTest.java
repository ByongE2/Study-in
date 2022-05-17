package self;

import java.util.ArrayList;

class Fruit implements Eatable{}
class Apple extends Fruit{}
class Grape extends Fruit{}
class Toy implements Eatable{}
interface Eatable{}
class EE implements Eatable{}
class AA extends Toy{}

public class GenericsTest {

	public static void main(String[] args) {

//		FruitBox<Fruit> fb = new FruitBox<Fruit>();
//		FruitBox<Apple> ab = new FruitBox<Apple>();
//		FruitBox<Grape> gb = new FruitBox<Grape>();
//		FruitBox<EE> eb = new FruitBox<EE>();
		FruitBox<Toy> tb = new FruitBox<Toy>();
//		FruitBox.add(new Fruit());
	}

}
class FruitBox<T extends Toy & Eatable> extends Box<T>{}
class Box<T>{
	ArrayList<T> list = new ArrayList<>();
	void add(T item) {list.add(item);}
}