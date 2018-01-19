package com.maodajun.bmw.bean;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.nutz.json.Json;
import org.nutz.json.JsonFormat;

public class BasePojo implements Comparable{
	   public String toString() {
	        // 这不是必须的, 只是为了debug的时候方便看
	        return Json.toJson(this, JsonFormat.compact());
	    }

	@Override
	public int compareTo(Object o) {
		return CompareToBuilder.reflectionCompare(o, this);
	}
}
