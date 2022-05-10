package com.ezen.ex01;

import java.util.LinkedList;
import java.util.Queue;

public class QueueEx {

	public static void main(String[] args) {

		Queue<String> q = new LinkedList<String>();
		q.offer("box");
		q.offer("toy");
		q.offer("robot");
		
		System.out.println(q);
		System.out.println(q.peek());
		
		System.out.println(q);
		
		
		
	}

}
