package ezen01;

public class StringBufferEx1 {

	public static void main(String[] args) {

		StringBuffer sb = new StringBuffer("abc");
		StringBuffer sb2 = new StringBuffer("abc");
		
		sb.append("A");
		sb.append("asdfasdfasdfasdfsadf");
		
		System.out.println("sb==sb2 ? " + (sb==sb2));
		System.out.println("sb.equals(sb2) ? " + sb.equals(sb2));
		
		String s = sb.toString();
		String s2 = sb2.toString();
		
		System.out.println("s.equals(s2) ? " + s.equals(s2));
		
		System.out.println(sb.length());
		System.out.println(sb.capacity()); // 자동적으로 arraycopy 써서 해주네.. data 수가 많거나 할때는 성능 저하.
		
		
		System.out.println(Math.ceil(1.91));
		System.out.println(Math.floor(1.99));
		
	}

}
