import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class HashMapEx2 {

	public static void main(String[] args) {

		HashMap<Integer, String> map = new HashMap<Integer, String>();
//		TreeMap<Integer, String> map = new TreeMap<Integer, String>();
		// 기본형들은 정렬되는데, 직접 객체만들고 할때는 compare 구현해주고, 이퀄스 해쉬코드 오버라이딩 해주고 해야한다.
		
		map.put(3, "Kim");
		map.put(4, "Hong");
		map.put(4, "Lee");
		map.put(5, "Park");
		map.put(6, "Kim");
		map.put(1, "Kim");
		map.put(2, "Kim");
		map.put(10, "Kim");
		map.put(7, "Kim");
		
		
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
