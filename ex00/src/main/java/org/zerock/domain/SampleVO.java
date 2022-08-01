package org.zerock.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //게터,세터,이퀄스,해시코드,투스트링
@AllArgsConstructor // 생성자
@NoArgsConstructor // 기본생성자
public class SampleVO {

	private Integer mno;
	private String firstName, lastName;
	
}
