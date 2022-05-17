package ex01;

class DBox<L,R>{
	private L left;
	private R right;
	
	public void set(L l, R r) {
		left = l;
		right= r;
	}
	@Override
	public String toString() {return left + "&" + right;}
}

public class MutiTypeParam {

	public static void main(String[] args) {
		DBox<String, Integer> box = new DBox<>();
		
		box.set("Apple", 20);
		System.out.println(box);
		box.set("Apple2", new Integer(50));
		System.out.println(box);
		
	}

}
