package zoo;
// public > protected(상속관계ok) > default(같은 패키지면) > private(같은 클래스)
public class Cat {
	public void makeCat() {
		Cat yaong = new Cat();
	}
}
class Duck {
	public void makeDuck() {
		Duck quack = new Duck();
	}
}