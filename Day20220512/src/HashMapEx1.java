import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

//내림차순 클래스
class AgeDesc implements Comparator<Integer>{
	@Override
	public int compare(Integer o1, Integer o2) {
		return o2 - o1;
	}
}

public class HashMapEx1 {

	public static void main(String[] args) {

		HashMap<Integer, String> map = new HashMap<Integer, String>();
//		TreeMap<Integer, String> map = new TreeMap<Integer, String>(new AgeDesc());
		// 기본형들은 정렬되는데, 직접 객체만들고 할때는 compare 구현해주고, 이퀄스 해쉬코드 오버라이딩 해주고 해야한다.
		
		map.put(17, "Kim");
		map.put(46, "Hong");
		map.put(13, "Lee");
		map.put(66, "Park");
		map.put(10, "Kim");
		map.put(99, "Kim");
		map.put(12, "Kim");
		map.put(13, "Kim");
		map.put(14, "Kim");
		
		
		System.out.println(map);
//		System.out.println(map.entrySet());
		System.out.println(map.get(5));
		
		Set<Integer> set = map.keySet();
		for(Integer n : set) {
			System.out.print(n + " ");
		}
		System.out.println();
		for(Integer n :set) {
			System.out.print(map.get(n) + " ");
		}
//		System.out.println();
//		for(Integer n :set) {
//			System.out.print(map.entrySet(n) + " ");  // 컴파일 에러
//		}
		System.out.println();
		Iterator<Integer> it = set.iterator();
		while(it.hasNext()) {
			System.out.print(it.next() + " ");
		}
		System.out.println();
		it = set.iterator();
		while(it.hasNext()) {
			System.out.print(map.get(it.next()) + " ");
		}
	
	}

}
