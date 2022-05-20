import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


class StrCmp implements Comparator<String>{
	
	@Override
	public int compare(String o1, String o2) {
		return o1.length() - o2.length();
	}
	
}

public class AnonymoucClass2 {

	public static void main(String[] args) {
	
		List<String> list = new ArrayList<String>();
		
		list.add("robot");
		list.add("apple");
		list.add("toy");
		
		//익명클래스
		Comparator<String> cmp = new Comparator<String>() {
			public int compare(String o1, String o2) {
				return o1.length() - o2.length();
			}
		};
		
		StrCmp sc = new StrCmp();
		Collections.sort(list,sc);
//		Collections.sort(list);
		System.out.println(list);
	}

}
