import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;



public class HashSetEx01 {

	public static void main(String[] args) {

		Set<String> set = new HashSet<String>();
		
		set.add("toy");
		set.add("box");
		set.add("robot");
		set.add("box");
		set.add("toy");
		
		System.out.println(set.size());
		for(Iterator<String> it = set.iterator(); it.hasNext();)
			System.out.print(it.next() + "\t");
		System.out.println();
		for(String s : set)
			System.out.print(s + "\t");
	}

}
