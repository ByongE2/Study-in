package com.saeyan.dto;

import lombok.Getter;
import lombok.Setter;

/*create table product(
	    code number(5),
	    name varchar2(100),
	    price number(8),
	    pictureurl varchar(50),
	    description varchar(1000),
	    primary key(code)
	);*/

@Setter
@Getter
public class ProductVO {

	private Integer code;
	private String name;
	private Integer price;
	private String pictureUrl;
	private String description;
	
}
