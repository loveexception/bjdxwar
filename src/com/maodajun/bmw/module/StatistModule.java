package com.maodajun.bmw.module;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.dao.QueryResult;
import org.nutz.dao.Sqls;
import org.nutz.dao.pager.Pager;
import org.nutz.dao.sql.Sql;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Strings;
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
import com.maodajun.bmw.bean.Plan;
import com.maodajun.bmw.bean.Statist;

@IocBean
@At("/statist")
@Ok("json:{locked:'password|salt',ignoreNull:true}")
@Fail("http:500") // 抛出异常的话,就走500页面
@Filters(@By(type=CheckSession.class, args={"me", "/"})) // 检查当前Session是否带me这个属性
public class StatistModule {

    @Inject
    protected Dao dao;

    @At
    public int count() {
        return dao.count(Statist.class);
    }

   
    @At
    public Object add(@Param("..")Statist statist) {
        NutMap re = new NutMap();

        statist = dao.insert(statist);
        return re.setv("ok", true).setv("data", statist);
    }
    @At
    public Object update(@Param("..")Statist statist) {
        NutMap re = new NutMap();


        dao.updateIgnoreNull(statist);// 真正更新的其实只有password和salt
        return re.setv("ok", true);
    }
    @At
    public Object delete(@Param("id")int id, @Attr("me")int me) {

        dao.delete(Statist.class, id); // 再严谨一些的话,需要判断是否为>0
        return new NutMap().setv("ok", true);
    }
    @At
    public Object query(@Param("ymd")String ymd, @Param("..")Pager pager) {
        Cnd cnd = null;
        Date day = new Date();
       SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
//       System.out.println(date.format(day));
       System.out.println(ymd);
       if(!Strings.isBlank(ymd)){
    	   cnd = Cnd.where("ymd","like","%"+ymd+"%");
       }else{
    	   cnd = Cnd.where("ymd","like","%"+date.format(day)+"%"); 
       }
        QueryResult qr = new QueryResult();
        qr.setList(dao.query(Statist.class, cnd, null));
        return qr; //默认分页是第1页,每页20条
    }
    
    
    @At
    public int countcontent() {
        return dao.count(Content.class);
    }

   
    @At
    public Object addcontent(@Param("..")Content content) {
        NutMap re = new NutMap();

        content = dao.insert(content);
        return re.setv("ok", true).setv("data", content);
    }
    @At
    public Object updatecontent(@Param("..")Content content) {
        NutMap re = new NutMap();


        dao.updateIgnoreNull(content);// 真正更新的其实只有password和salt
        return re.setv("ok", true);
    }
    @At
    public Object deletecontent(@Param("id")int id, @Attr("me")int me) {

        dao.delete(Content.class, id); // 再严谨一些的话,需要判断是否为>0
        return new NutMap().setv("ok", true);
    }
    @At
    public Object querycontent(@Param("content")String content, @Param("..")Pager pager) {
        Cnd cnd = null;
       if(!Strings.isBlank(content)){
    	   cnd = Cnd.where("content","like","%"+content+"%");
       }else{
    	   cnd = null; 
       }
        QueryResult qr = new QueryResult();
        qr.setList(dao.query(Content.class, cnd, null));
        return qr; //默认分页是第1页,每页20条
    }
    
    @At
    public Object querycomment(){
    	Sql sql = Sqls.create("SELECT   sum(pageview) pageview ,sum(userview) userview ,LEFT(ymd,10) as ymd FROM t_statist GROUP BY LEFT(ymd,10)");
    	sql.setCallback(Sqls.callback.entities());
    	sql.setEntity(dao.getEntity(Statist.class));
    	dao.execute(sql);
    	
    	List<Statist> list = sql.getList(Statist.class);
    	QueryResult qr = new QueryResult();
        qr.setList(list);
        return qr; //默认分页是第1页,每页20条
    }
    
    
    
//    @At
//    public Object query1(@Param("content")String content, @Param("..")Pager pager) {
//        Cnd cnd = Strings.isBlank(content)? null : Cnd.where("name", "like", "%"+content+"%");
//        QueryResult qr = new QueryResult();
//        qr.setList(dao.query(Content.class, cnd, null));
//
//        return qr; //默认分页是第1页,每页20条
//    }

    @At("/main")
    @Ok("jsp:jsp.statist.main") // 真实路径是 /WEB-INF/jsp/user/list.jsp
    public void main() {
    }
 
    @At("/canvas")
	@Ok("jsp:jsp.statist.canvas") // 真实路径是 /WEB-INF/jsp/topic/list.jsp
	public void canvas() {
	}
    
    @At("/content")
   	@Ok("jsp:jsp.statist.content") // 真实路径是 /WEB-INF/jsp/topic/list.jsp
   	public void content() {
   	}
}