import lombok.ToString;

class Car5{
	int passenger;
	int tire;
	int seat;
	void run() {
		System.out.println("run()");
	}
	void stop() {}
	Car5(){
		System.out.println("Car5() 생성자");
	}
}
@ToString
class Sedan extends Car5{
	Sedan(){
		System.out.println("Sedan() 생성자");
	}
	String color;
}
class Bus extends Car5{
	void passengerLoad() {}
}
class Truck extends Car5{
	void objectLoad() {}
}

public class CarTest {

	public static void main(String[] args) {
		Sedan se = new Sedan();
		se.color = "white";
		se.passenger = 5;
		se.tire = 4;
		System.out.println(se.color + "," + se.passenger + "," +  se.tire);
		System.out.println(se.toString());
		
		Bus bu = new Bus();
		bu.passenger = 15;
		bu.tire = 6;
		System.out.println(bu.passenger + "," + bu.tire);
		System.out.println(bu.toString());
	}

}
