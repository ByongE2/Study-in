package ezen01;

import java.util.StringTokenizer;

public class StringTokenizerEx2 {

	public static void main(String[] args) {
		
		String exp = "x=100*(200+300)/2";
		StringTokenizer st = new StringTokenizer(exp,"+-*/=()", true);
		
		while(st.hasMoreTokens()) {
		System.out.print(st.nextToken());
		}
		
		
	}

}
