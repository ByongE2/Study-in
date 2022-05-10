package com.ezen.ex01;

import java.util.ArrayDeque;
import java.util.Deque;

/* addFrist() 넣기
 * removeFirst 꺼내기
 * getFirst() 확인하기
 * 
 * addLast() 넣기
 * removeLast()꺼내기
 * getLast
 */

public class DequeEx { // interface

	public static void main(String[] args) {
		Deque<String> dq = new ArrayDeque<String>();
		
		dq.offer("1.box");
		dq.offer("2.toy");
		dq.offer("3.robot");
		
		dq.offerFirst("11.box");
		dq.offerLast("111.box");
		dq.remove("11.box");
		dq.removeLast();
		
		System.out.println(dq);
		System.out.println(dq.peek());
		System.out.println(dq.getLast());
		System.out.println(dq);

	}

}
