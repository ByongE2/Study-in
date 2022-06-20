package com.ezen.mybatis;

import lombok.Data;
import lombok.ToString;

/*create table board(
	    id number(5),
	    name varchar(20),
	    phone varchar2(20),
	    address varchar(50),
	    primary key(id)
	);*/
@Data
@ToString
public class BoardVO {
	private int id;
	private String name;
	private String phone;
	private String address;
}
