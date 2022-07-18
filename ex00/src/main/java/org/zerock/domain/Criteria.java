package org.zerock.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter
@ToString
public class Criteria {

	private int pageNum; //페이지 번호
	private int amount; //페이지 몇개 나타날 것인가
	
	public Criteria() {
		this(1,10); // 1페이지에 10건만 출력하겠다.
	}
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
}
