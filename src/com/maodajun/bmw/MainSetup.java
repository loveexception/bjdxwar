package com.maodajun.bmw;

import org.nutz.dao.Dao;
import org.nutz.dao.util.Daos;
import org.nutz.integration.quartz.NutQuartzCronJobFactory;
import org.nutz.ioc.Ioc;
import org.nutz.mvc.NutConfig;
import org.nutz.mvc.Setup;

import com.maodajun.bmw.bean.User;

public class MainSetup implements Setup {

    // 特别留意一下,是init方法,不是destroy方法!!!!!
    public void init(NutConfig conf) {


          Ioc ioc = conf.getIoc();
          Dao dao = ioc.get(Dao.class);
          // 如果提示没有createTablesInPackage方法,请确认用了最新版的nutz,且老版本的nutz已经删除干净
          Daos.createTablesInPackage(dao, "com.maodajun.bmw", false);

          // 初始化默认根用户
          if (dao.count(User.class) == 0) {
              User user = new User();
              user.setName("admin");
              user.setPassword("123456");

              dao.insert(user);
          }
         ioc.get(NutQuartzCronJobFactory.class);

      }

      public void destroy(NutConfig conf) {
      }


}