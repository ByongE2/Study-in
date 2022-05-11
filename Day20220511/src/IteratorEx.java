import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class IteratorEx {

	public static void main(String[] args) {

		List<String> list = new LinkedList<>();
		
		list.add("toy");
		list.add("box");
		list.add("rotob");
		list.add("toy");
		
		//list, set, map
		for(String e : list)
			System.out.print(e + '\t');
		
		System.out.println("\nㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		//hasNext(); >> 가져올 데이터 있는지?
		//next() >> 다음값 반환
		//removes next()호출 통해 반환된 인스턴스 삭제 .. 
		Iterator<String> it = list.iterator();
		while(it.hasNext()) {
			String tmp = it.next();
//			if(tmp.equals(it)) it.remove();
			System.out.print(tmp + '\t');
		}
		System.out.println();
		it = list.iterator();
		while(it.hasNext()) {
			String tmp = it.next();
//			if(tmp.equals(it)) it.remove();
			System.out.print(tmp + '\t');
		}
	}

}
