package com.maodajun.bmw.bean;


import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Table;

@Table("t_statist")
public class Statist  {
    @Id
    private int id;
    @Name
    @Column
    private String ymd;
    
    @Column
    private int pageview;
    
    @Column
    private int userview;
   
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getYmd() {
		return ymd;
	}
	public void setYmd(String ymd) {
		this.ymd = ymd;
	}
	public int getPageview() {
		return pageview;
	}
	public void setPageview(int pageview) {
		this.pageview = pageview;
	}
	public int getUserview() {
		return userview;
	}
	public void setUserview(int userview) {
		this.userview = userview;
	}
	
	
}
