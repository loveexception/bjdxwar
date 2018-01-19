package com.maodajun.bmw.module;



import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.dao.QueryResult;
import org.nutz.dao.pager.Pager;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Strings;
import org.nutz.lang.random.R;
import org.nutz.lang.util.NutMap;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Attr;
import org.nutz.mvc.annotation.By;
import org.nutz.mvc.annotation.Fail;
import org.nutz.mvc.annotation.Filters;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;
import org.nutz.mvc.filter.CheckSession;

import com.maodajun.bmw.bean.Content;
import com.maodajun.bmw.bean.Person;
import com.maodajun.bmw.bean.Subtopic;
import com.maodajun.bmw.bean.Topic;
import com.maodajun.bmw.utils.AutoCount;


@IocBean
@At("/topic")
@Ok("json:{ignoreNull:true}")
@Fail("http:500") // 抛出异常的话,就走500页面
@Filters(@By(type = CheckSession.class, args = { "me", "/" })) // 检查当前Session是否带me这个属性
public class TopicModule {

	@Inject
	protected Dao dao;

	@At
	public int count() {
		return dao.count(Topic.class);
	}



	@At
	public Object update(@Param("..") Topic topic) {
		NutMap re = new NutMap();
		
		topic.setName(null);// 不允许更新用户名
		dao.updateIgnoreNull(topic);// 
		return re.setv("ok", true);
	}

	@At
	public Object delete(@Param("id") int id, @Attr("me") int me) {
		dao.delete(Topic.class, id); // 再严谨一些的话,需要判断是否为>0
		return new NutMap().setv("ok", true);
	}

	@At
	public Object query(@Param("name") String name,@Param("type") String type, @Param("..") Pager pager) {
		Cnd cnd = Cnd.where("1","=",1);
		if(Strings.isNotBlank(name)){
			cnd.and("name", "like", "%" + name + "%");
		}
		if(Strings.isBlank(type)){
			//不加条件
		}else if(Strings.equals(type, "0")){
			//全部
		}else{
			cnd.and("type","=",type);
		}
			
		cnd.desc("sort").desc("oldid");
		QueryResult qr = new QueryResult();
		List<Topic> list = dao.query(Topic.class, cnd, pager);

		qr.setList(list);
		pager.setRecordCount(dao.count(Topic.class, cnd));
		qr.setPager(pager);
		return qr; // 默认分页是第1页,每页20条
	}
	@At
	public Object get(@Param("id") String id) {
		Topic obj =dao.fetch(Topic.class,Integer.parseInt(id));
		return obj; // 默认分页是第1页,每页20条
	}
	
	
	
	
	@At
	@Filters
	public Object spider(@Param("name") String name,@Param("type") String type, @Param("..") Pager pager) throws Exception {	
		List<Map<String, String>> spidernews = makeHttpSpider(type, pager);
		List<Topic> newtopic  = makeNewOrOld( spidernews);
		makeReply(newtopic);
        return query(name,type,pager);
	}


	/**
	 * 抓取新闻
	 * @param type
	 * @param pager
	 * @return
	 */
	public List<Map<String, String>> makeHttpSpider(String type, Pager pager) {
		String page = ""+pager.getPageNumber();
		String url = "http://m2.beijingdaxing.cn//Api/News/index17";
				
	    String body = AutoCount.makeHttpBody(type, page);
		String str = AutoCount.makeHttpPost(url,body);
	
		List<Map<String, String>> list = AutoCount.makeJsonList(str);
		return list;
	}


	/**
	 * 区分老贴还是新贴
	 * @param type
	 * @param list
	 * @return
	 */
	public List<Topic> makeNewOrOld( List<Map<String, String>> list) {
		List<Topic> reply = new ArrayList<Topic>();
		for (int i =0 ; i< list.size();i++) {
			Map<String,String> temp  =  list.get(list.size()-i-1);
			Topic topic = dao.fetch(Topic.class, Cnd.where("oldid","=",temp.get("id")));
			if(topic==null){//新加入新闻
				topic = Topic.getInstenceNew( temp);
				dao.insert(topic);
				reply.add(topic);//用于回贴			
			}else{//老新闻
				topic = Topic.getInstenceOld(temp, topic);
				dao.update(topic);				
			}
		}
		return reply;
	}


	/**
	 * 随机回复
	 * @param reply
	 */
	public  void makeReply(List<Topic> reply) {
		List<Content> contents = dao.query(Content.class, null, null);
		List<Person> persons = dao.query(Person.class, null);
		for (Topic topic : reply) {
			int re = R.random(1, 8);
			for(int i = 0 ; i < re ;i++){
				Subtopic sub = Subtopic.makeSubtopic(contents, persons, topic);
				dao.insert(sub);			
			}

		}
	}



	



	

	@At("/main")
	@Ok("jsp:jsp.topic.main") // 真实路径是 /WEB-INF/jsp/topic/list.jsp
	public void main() {
		
	}
	@At("/newone")
	@Ok("jsp:jsp.topic.newone") // 真实路径是 /WEB-INF/jsp/topic/list.jsp
	public void newone() {
	}



	
}