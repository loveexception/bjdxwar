var ioc = {
        dataSource : {
            type : "com.alibaba.druid.pool.DruidDataSource",
            events : {
                create : "init",
                depose : 'close'
            },
            fields : {
//                url : "jdbc:mysql://localhost:3306/bmw?useUnicode=true&characterEncoding=UTF-8",
//                username : "maodajun",
//                password : "maodajun",
//            	url:"jdbc:mysql://rm-2zepv24t1b4z50t59o.mysql.rds.aliyuncs.com:3306/bmw?characterEncoding=UTF-8",
//            	username : "maodajun",
//            	password : "ma0DaJun",
//            	url:"jdbc:mysql://localhost:3306/bjdxselenium?useUnicode=true&characterEncoding=UTF-8",
//            	username : "root",
//            	password : "root",
//            	url:"jdbc:mysql://localhost:3306/bjdxselenium?useUnicode=true&characterEncoding=UTF-8",
//            	username : "root",
//            	password : "aLxSqUbTwO",
            	url:"jdbc:mysql://123.57.94.233:3306/bjdxselenium?useUnicode=true&characterEncoding=UTF-8",
            	username : "dxnews_test",
            	password : "userzxy",
                testWhileIdle : true, // 非常重要,预防mysql的8小时timeout问题
                validationQuery : "select 1" , // Oracle的话需要改一下
                maxActive : 100
            }
        },
        dao : {
            type : "org.nutz.dao.impl.NutDao",
            args : [{refer:"dataSource"}]
        },
        conf : {
        	 type : "org.nutz.ioc.impl.PropertiesProxy",
        	 fields : {
        	  paths : ["custom/"]
        	 }
        }
};