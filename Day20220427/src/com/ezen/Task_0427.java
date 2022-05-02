package com.ezen;					//패키지
import lombok.Getter;				//롬복 게터 
import lombok.Setter;				//롬복 세터
public class Task_0427 {
   public static void main(String[] args) {
      
//      Sedan se = new Sedan();			// Sedan(class)타입 선언 > 인스턴스 Sedan 생성 > 생성자Sedan() 호출 > 
//      se.setColor("red"); 									// 생성자Sedan() 초기화 > 참조변수 se에 저장 			
//      System.out.println(se.getColor());						// 생성자 호출 초기화 루틴은 최고조상클래스까지. 
//      														// 
//      se.setPassenger(4);										
//      System.out.println(se.getPassenger() + "명");
//      
//      
//      Sports sp = new Sports();		
//      sp.setColor("red");
//      System.out.println(sp.getColor());
//      sp.run();												
//      
//      Sports sp2 = new Sports("yollow", 2, 4, 1, 5000);
//      sp2.run();
      Sports sp3 = new Sports();								
      sp3.run();										// 오버라이딩 했을 때 자손클래스(Sports)의 메서드구현부가 구현됨.
//      Sedan se2 = new Sedan("bule", 2, 4, 3);
      Sedan se2 = new Sedan();
      System.out.println(se2.getColor() + "명");
      System.out.println(se2.getColor());
   }
}

@Getter													//생성자는 인스턴스가 생성될 때 호출되는 '인스턴스 초기화 메서드'
@Setter													//생성자는 한 클래스 내에 최소한 1개는 존재해야한다
class Car{
   private int passenger;								// 클래스 내에서만 접근가능한(private) 정수타입 instance 변수 3개 선언
   private int tire;
   private int seat;
   
   public Car() {										//Car 기본 생성자 생성 ( 안에 super(); 생략되어있음 )
      System.out.println("car");						//상속 관계에 있는 클래스에서 기본 생성자 생성 순서 확인하는 print메서드 
   }
   public Car(int passenger ,int tire, int seat ) {		// Car생성자 매개변수3개 오버로딩
      System.out.println("Car()생성자");
      this.passenger  = passenger;						// 매개변수와 iv가 이름이 같아서
      this.tire  = tire;								//  구분하기위해 참조변수 this , 
      this.seat = seat;									// 매개변수(lv)를 iv로.
   }
   void run() {											// 입력(x) , 출력(x) run 메서드
      System.out.println("달료!!!!");
   }
   void stop() {}										// 입력(x) , 출력(x) stop 메서드
}

class Sedan extends Car {								// Car를 조상으로하는 Sedan class
   
   private String color;								//클래스 내에서만 접근가능한(private) String타입 instance 변수 선언
   
   public Sedan() {										//Sedan 기본생성자
      System.out.println("sedan");						//상속 관계에 있는 클래스에서 기본 생성자 생성 순서 확인하는 print메서드 
      //"bule", 2, 4, 3
      setColor("blue");									// 세터에 data값 직접 입력.
//      setPassenger(2);
//      setTire(4);
//      setSeat(2);
   } 
   public Sedan(String color, int passenger, int tire, int seat) {		// 매개변수 4개 입력받는 생성자
      super(passenger, tire, seat);  					// 조상클래스(Car) 매개변수3개(타입도 일치해야 한다) 받는 생성자 호출.
      System.out.println("Sedan()생성자");			
      this.color = color;								// 참조변수 this이용해서 lv iv 구분. iv로					
//      setPassenger(passenger);										
//      setTire(tire);									// private 변수에 접근하기 위해 세터메서드 이용. 
//      setSeat(seat);
   }
   public String getColor() {							// String타입 iv Color의 게터
      return color;
   }

   public void setColor(String color) {					//String타입 매개변수 받아서 iv로. 세터 
      this.color = color;
   }

   void gas() {}										// 입력(x),출력(x) 메서드 gas
}

class Sports extends  Sedan{							// Sedan을 조상으로하는 Sports class
   int horsepower;										// 접근제어자 default가 생략된 정수타입 변수 선언 
   public Sports() {									// Sports 기본생성자 생성
      System.out.println("sprots");						//상속 관계에 있는 클래스에서 기본 생성자 생성 순서 확인하는 print메서드 
   }
   public Sports(String color, int passenger, int tire, int seat,int horsepower ) {	// 매개변수5개 받는 Sports 생성자
      super(color, passenger,  tire, seat );			// 조상클래스(Sedan) 생성자 호출. 매개변수 4개받는 생성자
      this.horsepower = horsepower;						// lv를 iv로 
   }
   void run() {											// 조상클래스(Sedan)의 메서드run(Car로 부터 받은)을 오버라이딩.
      System.out.println("스포츠카 달료!!!!");				// 오버라이딩은 조상클래스의 메서드와 선언부가 같을 때 구현부만 다르게 할 때를 말함.
   }													// 선언부(이름,매개변수,반환타입), 
}														// 오버라이딩 제약조건 : 접근 제어자의 범위, 예외의 갯수-범위

class Bus extends Car{									// Car를 조상으로하는 Bus class
   int passengerCount;									// 접근제어자 default가 생략된 정수타입 변수 선언
   void passengerLoad() {}								// 입력(x)출력(x) 메서드 passengerLoad
}

class Truck extends Car{								// Car를 조상으로하는 Truck class
   int load;											// 접근제어자 default가 생략된 정수타입 변수 선언
   void ObjectLoad() {}									// 입력(x)출력(x) 메서드 ObjectLoad
}