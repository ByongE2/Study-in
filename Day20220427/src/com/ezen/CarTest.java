package com.ezen;

import lombok.Getter;
import lombok.Setter;

public class CarTest {

	public static void main(String[] args) {
		Sedan se = new Sedan();
		se.setColor("red");
		System.out.println(se.getColor());
		
		se.setPassenger(4);
		System.out.println(se.getPassenger()+"명");
		
		Sedan se2 = new Sedan("blue",2,4,3);
		System.out.println(se2.getPassenger() + "명");
		System.out.println(se2.getColor());
		
		Sports sp = new Sports();
		sp.setColor("red");
		System.out.println(sp.getColor());
		
		Sports sp2 = new Sports("yellow", 2, 4, 1, 5000);
		System.out.println(sp2.getColor() + "," +sp2.getPassenger() + "," + sp2.getTire() + "," +
		sp2.getSeat() + "," + sp2.horsepower);
		sp2.run();
		
	}

}
@Getter
@Setter
class Car{
	private int passenger;
	private int tire;
	private int seat;
	
	Car(){}
	Car(int passenger, int tire, int seat){
		this.passenger = passenger; 			
		this.tire = tire;
		this.seat = seat;
	}
	void run() {
		System.out.println("달려~!");
	}
	void stop() {}
}
class Sports extends Sedan{
	Sports(){}
	int horsepower;
	Sports(String color, int passenger, int tire, int seat , int horsepower){
		super(color, passenger, tire, seat);
		this.horsepower = horsepower;
	}
	void run() {
		System.out.println("스포츠카 달려~!");
	}
}//end Sports

class Sedan extends Car{
	private String color;
	public String getColor() {
		return color;
	}
	public Sedan() {}
	public Sedan(String color, int passenger, int tire, int seat ) {
		super(passenger,tire,seat);
		this.color = color;
//		setPassenger(passenger);			//좋지않아. outline로 확인한번더.
//		setTire(tire);
//		setSeat(seat);
	}
	public void setColor(String color) {
		this.color = color;
	}
	public void gas() {}
}

class Bus extends Car {
	private int color;
	void gas() {}
}
class Truck extends Car{
	private int load;
	void objectLoad() {}
}