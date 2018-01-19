package com.maodajun.bmw.bean;


import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.nutz.dao.entity.annotation.ColDefine;
import org.nutz.dao.entity.annotation.ColType;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Comment;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.One;
import org.nutz.dao.entity.annotation.Table;

import com.maodajun.bmw.utils.AutoCount;

@Table("t_subtopics")

public class Subtopic  {
    @Id
    private int id;
    
    @Column
    private int tid;
    @One(field="tid")
    private Topic topic;
    
    @Column
    @ColDefine(type=ColType.TEXT)
    private String context;
    
    @Column
    private int pid;
    @One(field = "pid")
    private Person person;
    
    @Column
    private Date send;
    @Column
    private Date plan;
    
    @Column
    @Comment("0立即发布，1按计划发布，9已发布，2连接失败，3服务失败，5暂停")
    private String status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Date getSend() {
		return send;
	}

	public void setSend(Date send) {
		this.send = send;
	}

	public Date getPlan() {
		return plan;
	}

	public void setPlan(Date plan) {
		this.plan = plan;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
    
	/**
	 * 组织 SUB TOPIC 
	 * @param contents
	 * @param persons
	 * @param topic
	 * @return
	 */
	public static Subtopic makeSubtopic(List<Content> contents, List<Person> persons, Topic topic) {
		Subtopic sub = new Subtopic();
		sub.setTid(topic.getId());
		sub.setContext(AutoCount.countrandom(contents));
		sub.setPid(AutoCount.personRandom(persons));
		sub.setSend(null);
		sub.setPlan(AutoCount.randHour(new Date()));
		sub.setStatus("1");
		return sub;
	}
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
   
   
}
