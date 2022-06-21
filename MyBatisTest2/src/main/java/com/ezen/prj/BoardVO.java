package com.ezen.prj;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Setter@Getter@ToString
public class BoardVO {
	private int id;
	private String name, phone, address;
	
}
