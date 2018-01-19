package com.maodajun.bmw.utils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.time.DateUtils;
import org.nutz.http.Header;
import org.nutz.http.Http;
import org.nutz.http.Response;
import org.nutz.json.Json;
import org.nutz.lang.random.ArrayRandom;
import org.nutz.lang.random.R;
import org.nutz.lang.random.Random;
import org.nutz.lang.random.RecurArrayRandom;

import com.maodajun.bmw.bean.Content;
import com.maodajun.bmw.bean.Person;
import com.maodajun.bmw.bean.Subtopic;
import com.maodajun.bmw.bean.Topic;





public class AutoCount {

	public static String countrandom(List<Content> contents) {
		Random<Content> r = new RecurArrayRandom(contents.toArray());
		Content content = r.next();
		return content.getContent();

	}


	public static int personRandom(List<Person> persons) {
		Random<Person> r = new RecurArrayRandom(persons.toArray());
		Person person = r.next();		
		return person.getId();
	}


	/**
	 * 自动时间戳
	 * @param date 当时时间
	 * @return
	 */
	public static Date randHour(Date date){
		
		 Calendar c = Calendar.getInstance();
		 c.setTime(date);
		 c.set(Calendar.MINUTE, R.random(0, 59));//随机分钟
		 c.set(Calendar.SECOND, 0);
		 
		Integer[] myweekup = new  Integer []{
				9,10,11,
				13,14,15,
				17,18,19,
				19,20,21,
				22,23
		} ;
		Date d = new Date();
		int hour = new RecurArrayRandom<Integer>(myweekup).next();
		int day =  R.random(0, 1);
		c.add(Calendar.DATE,day );// 今天或明天
        c.set(Calendar.HOUR_OF_DAY, hour);// 指定发贴时间
        d = c.getTime();
        
        if( d.getTime() < date.getTime() ){
        	c.add(Calendar.DATE,1);
        	d = c.getTime();
        }
        
	         
		
		return d;
		
	}


	public static String makeHttpBody(String type, String page) {
		String body = "{\"head\": {    }"
				+ ",  \"data\":{    \"category_id\":"
				+type
				+ "  }"
				+ ",  \"page\":{    \"pageNo\":"
				+ page
				+ ",    \"pageSize\":100  }}";
		return body;
	}



	
	
	public static List<Map<String,String>> makeJsonList(String str) {
		Map<String, Object> map = (Map<String, Object>) Json.fromJson( str/* 其他源也可以 */);
		Map<String,List<Map<String,String>>> data = (Map<String,List<Map<String,String>>>) map.get("data");
		List<Map<String,String>> news=data.get("news");
		List<Map<String,String>> result = new ArrayList<Map<String, String>>();
		for (Map<String,String> e : news) {						
			result.add(e);
		}
		return result;

	}
	public static String makeHttpPost(String url,String body) {
		Map map = new HashMap();
		map.put("Content-Type", "application/json");
		Object obj =  Json.fromJson(body); 
		Header header= Header.create(map);
		Response response = Http.post3(url,
				  					   body ,
				  					   header, 
				  						60000);
		String str = response.getContent();
		return str;
	}


	
}
