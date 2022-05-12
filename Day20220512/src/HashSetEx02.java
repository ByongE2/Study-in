import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// 기본형이 아닌, 다른 객체를 HashSet으로 다룰 때, hashCode와 equals 오버라이딩 해야한다.(안하면 중복데이터 들어감) hashCode는 대충?
class Num{
	private int num;
	public Num(int num) {this.num = num;}
	@Override
	public String toString() {
		return String.valueOf(num);
	}
	@Override
	public int hashCode() {
		return num%3;
	}
	@Override
	public boolean equals(Object obj) {
		if(this.num == ((Num)obj).num) 
			return true; else return false;
	}
	
}

public class HashSetEx02 {

	public static void main(String[] args) {

		Set<Num> set = new HashSet<Num>();
		
		set.add(new Num(5));
		set.add(new Num(5));
		set.add(new Num(1));
		set.add(new Num(3));
		set.add(new Num(2));
		System.out.println(set.size());
		for(Iterator<Num> it = set.iterator(); it.hasNext();)
			System.out.print(it.next() + "\t");
		System.out.println();
		for(Num s : set)
			System.out.print(s+ "\t");
	}

}
