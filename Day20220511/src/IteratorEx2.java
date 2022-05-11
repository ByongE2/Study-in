import java.util.ArrayList;
import java.util.Iterator;

public class IteratorEx2 {

	public static void main(String[] args) {

		ArrayList original = new ArrayList(10);
		ArrayList copy1 = new ArrayList(10);
		ArrayList copy2 = new ArrayList(10);
		
		for(int i=0; i<10; i++)
			original.add(i+"");
		
		Iterator it = original.iterator();
		while(it.hasNext()) 
			copy1.add(it.next());
		System.out.println("오리지날에서 카피1로 복사 = ");
		System.out.println("오리지날:" + original);
		System.out.println("카피1: " + copy1);
		System.out.println();
		
		it = original.iterator();
		while(it.hasNext()) {
			copy2.add(it.next());
			it.remove();
		}//end of while
		System.out.println("오리지날에서 카피2로 복사 = ");
		System.out.println("오리지날:" + original);
		System.out.println("카피2: " + copy2);
		System.out.println();
	}

}
