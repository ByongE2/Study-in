package org.zerock.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter
@ToString
public class PageDTO {
	
	private int startPage; //시작 페이지. ex: 1
	private int endPage; // 끝 페이지. 총 data수/페이지당 보여줄 수 를 반올림하면 됨.
	private boolean prev, next; // 페이징에서 이전, 다음. 첫 1~10? 은 이전없고, 끝 30~32? 는 다음 없고
	
	private int total;
	private Criteria cri;
	
	public PageDTO(Criteria cri, int total) {
		this.cri = cri;
		this.total = total;
		
		this.endPage = (int)(Math.ceil(cri.getPageNum()/10.0)) * 10; // 현재페이지의 끝페이지. ex: 현재페이지 13 이면 끝페이지 20.
		this.startPage = endPage - 9;
//		this.startPage = (int)((Math.floor(cri.getPageNum()/10.0)) * 10) + 1 ;
		//총 마지막 페이지
		int realEnd = (int)(Math.ceil(total*1.0)/cri.getAmount()); // *1.0으로 한이유 : 정수/정수 = 정수 라서, ex: 315/10 = 31나와버림. 그래서 하나를 실수로.
		
		if(endPage > realEnd) {
			endPage = realEnd;
		}
		//이전 다음 클릭. 
		this.prev = this.startPage > 1;
		this.next = this.endPage < realEnd;
		
	}
	
}
