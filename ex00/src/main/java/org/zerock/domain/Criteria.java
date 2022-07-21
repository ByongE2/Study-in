package org.zerock.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter
@ToString
public class Criteria {

	private int pageNum; //페이지 번호
	private int amount; //페이지 몇개 나타날 것인가
	
	public String type;
	private String keyword;
	
	//BoardMapper.xml에서 typeArr를 가져와야하는데, getTypeArr 또는 setTypeArr 해도 get-set빼고, 첫글자 소문자 바꿔서 찾아옴.
	// 즉, BoardMapper.xml에서 getListWithPagging의 collection의 typeArr를 가져온거임.
	public String[] getTypeArr() {
		return type == null ? new String[] {} : type.split("");
	}
	
	public Criteria() {
		this(1,10); // 1페이지에 10건만 출력하겠다.
	}
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
}
