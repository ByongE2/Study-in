package com.springbook.ioc.injection;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionBeanClient {
	
	public static void main(String[] args) {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
		CollectionBean bean = (CollectionBean)factory.getBean("collectionBean");
		List<String> addressList = bean.getAddressList();
		for(String address : addressList) {
			System.out.println(address.toString());
		}

		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		Set<String> addressSet = bean.getAddressSet();
		for(String set : addressSet) {
			System.out.println(set);
		}
		
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		
		Map<String,String> addressMap = bean.getAddressMap();
		
		for(String key : addressMap.keySet()) {
			System.out.println(addressMap.get(key));
		}
		
//		Properties pro = bean.getAddressProperties();
//	      for(String key : pro.stringPropertyNames()) {
//	         System.out.println( String.format("key : %s , value:%s", key, pro.get(key)));
//	      }
		Properties addressProperties = bean.getAddressProperties();
		for(String key : addressProperties.stringPropertyNames()) {
			String value = addressProperties.getProperty(key);
			System.out.println("key : " + key + " value : " + value);
		}
		
		
	}
}
