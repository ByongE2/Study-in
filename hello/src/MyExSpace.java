import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
class MyExSpace{
	//	MyExSpace(){}
	public static void main(String[] args) {
		
		Casdf cc = new Casdf(10,20,5550);
		
		System.out.println(cc);
		System.out.println(cc.hashCode());
		System.out.println(cc.getAsd());
		
		
	}
}
@Getter
@Setter
class Aasdf {
	private String asd = "asdfsdfasdf";
	private int a;
	Aasdf(){}
	Aasdf(int a){
		this.a = a;
	}
	
}
@Getter
@Setter
class Basdf extends Aasdf{
	private int b;
	Basdf(){}
	Basdf(int a, int b){
		super(a);
		this.b = b;
	}
}
@Getter
@Setter
class Casdf extends Basdf{
	private int c;
	Casdf(){
		this(0,0,0);
	}
	Casdf(int a, int b){
		this(a,b,0);
	}
	
	Casdf(int a, int b, int c){
		
		super(a,b);
		this.c = c;
	}
	
}

