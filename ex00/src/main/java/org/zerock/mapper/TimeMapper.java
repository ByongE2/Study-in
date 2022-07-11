package org.zerock.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {

	@Select("select sysdate from dual") //xml 대신 이렇게도 쓸 수 있음. 대신, sql이 길어지거나 이렇기 떄문에 효율면에서 .xml에 하는게 더 낫다.
	public String getTime();
	
	public String getTime2();
	
}
