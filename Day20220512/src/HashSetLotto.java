import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

//로또 번호 생성기
public class HashSetLotto {

	public static void main(String[] args) {

		Set set = new HashSet();  //LinkedHashSet 쓰면 값의 정렬이 아닌, 값의 기입 순서를 지켜준다.
		for(int i=0; set.size() < 6; i++) {   // for(; set.size()<6;)가능
			int num = (int)(Math.random()*45) + 1;
			set.add(num);
		}
		List list = new LinkedList(set);
		Collections.sort(list);
		
		System.out.println(list);
		
	}

}
