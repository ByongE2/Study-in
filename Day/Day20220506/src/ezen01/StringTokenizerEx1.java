package ezen01;

import java.util.StringTokenizer;

public class StringTokenizerEx1 {

	public static void main(String[] args) {

		String src = "100,200,300,400";

		StringTokenizer st= new StringTokenizer(src,",");
		
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
		
//		System.out.println(src.toString());
//		src.split(",");
//		System.out.println(src.split(","));
		
		
	}

}
