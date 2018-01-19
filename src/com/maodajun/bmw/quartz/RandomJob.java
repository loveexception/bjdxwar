package com.maodajun.bmw.quartz;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.random.ListRandom;
import org.nutz.lang.random.R;
import org.nutz.lang.random.Random;
import org.nutz.lang.util.NutMap;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Attr;
import org.nutz.mvc.annotation.Param;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.maodajun.bmw.bean.Login;
import com.maodajun.bmw.bean.Person;
import com.maodajun.bmw.bean.Plan;

@IocBean
public class RandomJob implements Job{

	 private static final Log log = Logs.get();

	    @Inject 
	    protected Dao dao;
	    public void execute(JobExecutionContext context) throws JobExecutionException {
	
	    	log.info("RandomJob Done");
		List<Plan> plans = dao.query(Plan.class, null);
		
		List<Person> persons = dao.query(Person.class,null);
		Random<Person> r = new ListRandom<Person>(persons);

		List<Login> logins = new ArrayList<Login>();
		for (Plan plan : plans) {
			for(int i = 0 ; i < plan.getCount();i++ ){
				Login tmp = new Login();
				Person one = r.next();
				if(one==null){
					continue;
				}
		        
				Date today = new Date();
				Date d = randDay(plan, today);
				
				tmp.setPid(one.getId());
				tmp.setStauts("1");
	            
				tmp.setPlan(d);
				logins.add(tmp);
			}
		}
		for (Login tmp : logins) {
			dao.insert(tmp);
		}
		NutMap re = new NutMap();
	}

	    
	
	    private Date randDay(Plan plan, Date today) {
			Calendar cal  = Calendar.getInstance();
			cal.setTime(today);
			cal.set(Calendar.HOUR_OF_DAY, Integer.parseInt(plan.getName()));
			cal.set(Calendar.MINUTE, R.random(0, 59));
			cal.set(Calendar.SECOND, 0);
			cal.add(Calendar.DATE, 1);
			Date d = cal.getTime();
			return d;
		}
	    
	    
}
