package com.maodajun.bmw.quartz;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import org.nutz.castor.Castor;
import org.nutz.castor.Castors;
import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.dao.pager.Pager;
import org.nutz.dao.util.cri.Static;
import org.nutz.http.Header;
import org.nutz.http.Http;
import org.nutz.http.Request;
import org.nutz.http.Response;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.json.Json;
import org.nutz.lang.Dumps;
import org.nutz.lang.Strings;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Maps;
import com.google.common.collect.Queues;
import com.maodajun.bmw.bean.Content;
import com.maodajun.bmw.bean.Login;
import com.maodajun.bmw.bean.Person;
import com.maodajun.bmw.bean.Subtopic;
import com.maodajun.bmw.bean.Topic;
import com.maodajun.bmw.module.TopicModule;
import com.maodajun.bmw.utils.AutoCount;





@IocBean
public class SpiderJob implements Job {
	
    private static final Log log = Logs.get();

    @Inject 
    protected Dao dao;
    @Inject
    protected TopicModule modul;
    
    public void execute(JobExecutionContext context) throws JobExecutionException {
    	List<Map<String,String>> topics = modul.makeHttpSpider("0", new Pager(1, 100));
    	List <Topic> newtopics=modul.makeNewOrOld( topics);
    	modul.makeReply(newtopics);
    	

    }
	
   
}