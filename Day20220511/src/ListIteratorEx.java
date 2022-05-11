import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

import javax.swing.text.html.HTMLDocument.Iterator;

public class ListIteratorEx {

	public static void main(String[] args) {
		
		List<String> list = Arrays.asList("toy", "box", "robot", "box");
		
		System.out.println("3" + list);
		
		list = new ArrayList<String>(list);
		
		ListIterator<String> it = list.listIterator(); // 양방향
		
		while(it.hasNext()) {
			String str = it.next();
			System.out.print("1"+ str + '\t');
		}
		System.out.println();
		while(it.hasPrevious()) {
			String str = it.previous();
			System.out.print("2" + str + '\t');
		}
		
		
	}
	
}
