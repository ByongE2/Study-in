import lombok.ToString;

public class CarTest {
	public static void main(String[] args) {
		Car5 car5 = new Car5(1,1,1);
		Sedan se = new Sedan("white",5,4);
//		se.color = "white";
//		se.passenger = 5;
//		se.tire = 4;
		
		System.out.println(se.color + ", " + se.passenger + "," + se.tire);
		System.out.println(car5.passenger+car5.tire + car5.seat);
		System.out.println();
		se.run();
		Bus bu = new Bus();
		bu.passenger = 15;
		bu.tire = 6;
		System.out.println(bu.passenger + "," + bu.tire);
	}
}

class Sedan extends Car5{
	public Sedan(){}
	String color;
	
	public Sedan(String color, int passenger, int tire) {
		super(passenger,tire,4);		// 상위클래스 생성자 호출
		this.color = color;
//		this.passenger = passenger;		// 이렇게 직접접근하면 되긴한데 안좋다. private 보통 걸기때문에? 부모것 건드릴 이유가?
//		this.tire = tire;
		System.out.println("Sedan() 생성자");
	}
	public Sedan(int passenger, int tire, int seat, String color) {
		super(passenger, tire, seat);
		this.color=color;
	}
}
class Sports extends Sedan{
	public Sports() {}
	int sports ;
	public Sports(int passenger, int tire, int seat, String color, int sports ) {
		super(passenger, tire, seat, color);
		this.sports = sports;
	}
}

class Car5 {
	int passenger;
	int tire;
	int seat;
	public Car5(int passenger, int tire, int seat) {
		this.passenger = passenger;
		this.tire = tire;
		this.seat = seat;
		System.out.println("Car() 생성자");
	}
	public Car5() {}
	
	void run() {
		System.out.println("run()");
	}
	void stop() {}
	
}


@ToString
class Bus extends Car5{
	void passengerLoad() {};
}

@ToString
class Truck extends Car5{
	void objectLoad() {};
}
