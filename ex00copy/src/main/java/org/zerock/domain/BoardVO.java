package org.zerock.domain;

import java.util.Date;

import lombok.Data;

/*
 * 오라클 > 사용자(systeam) > 테이블 > Model
 * 
 *  bno NUMBER(10,0),
    title VARCHAR2(200) not null,
    content VARCHAR2(2000) not null,
    writer VARCHAR2(50) not null,
    regdate DATE default sysdate,
    updatedate date default sysdate
 */

@Data
public class BoardVO {
	
	private Long bno;
	private String title, content, writer;
	private Date regDate, updateDate;
	
}
