package com.maodajun.bmw.module;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.nutz.http.Http;

import com.maodajun.bmw.utils.AutoCount;

public class AutoCountTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testHttp() {
		//Http.setHttpProxy("127.0.0.1", 8888);//打开花瓶可以测试

		String str =AutoCount.makeHttpPost("http://m2.beijingdaxing.cn/Api/News/index17", 
				"{\"head\": {    }"
				+ ",  \"data\":{    \"category_id\":133  }"
				+ ",  \"page\":{    \"pageNo\":1,    \"pageSize\":20  }}"); 
		
		assertTrue(str.length()>1000);
	}
	@Test
	public void testJsonToList() {
		String str ="{ \"head\": {    \"error\": \"100000\",    \"msg\": \"操作成功！\"  },  \"data\": {    \"news\": [      {        \"id\": \"20277\",        \"title\": \"@大兴人，高层火灾逃生应该这样做\",        \"name\": \"学习消防知识，为自己和他人的生命安全负责。\",        \"image\": \"http://m2.beijingdaxing.cn/Uploads/News/2017/12/25/5a4068624e3a1.png\",        \"source\": \"\",        \"tag\": \"逃生,大兴人\",        \"category_id\": \"1,1\",        \"focus_category_id\": \"\",        \"type\": \"8\",        \"top\": \"0\",        \"focus_image\": \"\",        \"focus\": \"0\",        \"content\": \"\",        \"intro\": \"\",        \"is_comment\": \"1\",        \"view\": \"33\",        \"comment\": \"1\",        \"collection\": null,        \"create_time\": \"1514168842\",        \"update_time\": \"1514189012\",        \"status\": \"1\",        \"seo_title\": \"\",        \"seo_keywords\": \"\",        \"seo_description\": \"\",        \"remark\": null,        \"sort\": \"6\",        \"author\": \"\",        \"uid\": \"43\",        \"url\": \"http://m2.beijingdaxing.cn/Home/News/detail/id/1\",        \"reprint\": null,        \"category_sub_id\": null,        \"is_original\": \"0\",        \"record_share\": \"0\",        \"bind_mobile\": \"0\",        \"share_time\": null,        \"audiourl\": \"\",        \"videourl\": \"\",        \"during\": \"01:16\",        \"video_img\": \"\",        \"liveurl\": \"\",        \"sub\": null,        \"category_title\": \"要闻\",        \"ztnews\": [],        \"url_share\": \"http://m2.beijingdaxing.cn/Home/News2017/share/id/1\",        \"headerurl\": \"http://m2.beijingdaxing.cn/logo.jpg\",        \"authorname\": \"\"      },      {        \"id\": \"20268\",        \"title\": \"@大兴人，你知道如何从高层火灾中逃生吗？\",        \"name\": \"如何从高层火灾中逃生。\",        \"image\": \"http://m2.beijingdaxing.cn/Uploads/News/2017/12/24/5a3f0afec56d1.png\",        \"source\": \"\",        \"tag\": \"逃生,大兴人\",        \"category_id\": \"1,1\",        \"focus_category_id\": \"\",        \"type\": \"8\",        \"top\": \"0\",        \"focus_image\": \"\",        \"focus\": \"0\",        \"content\": \"\",        \"intro\": \"如何从高层火灾中逃生。\",        \"is_comment\": \"1\",        \"view\": \"33\",        \"comment\": \"0\",        \"collection\": null,        \"create_time\": \"1514080660\",        \"update_time\": \"1514170684\",        \"status\": \"1\",        \"seo_title\": \"\",        \"seo_keywords\": \"\",        \"seo_description\": \"\",        \"remark\": null,        \"sort\": \"0\",        \"author\": \"\",        \"uid\": \"33\",        \"url\": \"http://m2.beijingdaxing.cn/Home/News/detail/id/1\",        \"reprint\": null,        \"category_sub_id\": null,        \"is_original\": \"0\",        \"record_share\": \"0\",        \"bind_mobile\": \"0\",        \"share_time\": null,        \"audiourl\": \"\",        \"videourl\": \"\",        \"during\": \"01:23\",        \"video_img\": \"\",        \"liveurl\": \"\",        \"sub\": null,        \"category_title\": \"要闻\",        \"ztnews\": [],        \"url_share\": \"http://m2.beijingdaxing.cn/Home/News2017/share/id/1\",        \"headerurl\": \"http://m2.beijingdaxing.cn/logo.jpg\",        \"authorname\": \"\"      },      {        \"id\": \"20259\",        \"title\": \"@大兴人，你知道电瓶车安全使用六提示吗\",        \"name\": \"怎样才能安全的使用电瓶车呢？ \",        \"image\": \"http://m2.beijingdaxing.cn/Uploads/News/2017/12/23/5a3e1c02b10ac.png\",        \"source\": \"\",        \"tag\": \"提示,大兴人\",        \"category_id\": \"1,1\",        \"focus_category_id\": \"\",        \"type\": \"8\",        \"top\": \"0\",        \"focus_image\": \"\",        \"focus\": \"0\",        \"content\": \"\",        \"intro\": \"\",        \"is_comment\": \"1\",        \"view\": \"106\",        \"comment\": \"1\",        \"collection\": null,        \"create_time\": \"1514019827\",        \"update_time\": \"1514081478\",        \"status\": \"1\",        \"seo_title\": \"\",        \"seo_keywords\": \"\",        \"seo_description\": \"\",        \"remark\": null,        \"sort\": \"0\",        \"author\": \"\",        \"uid\": \"43\",        \"url\": \"http://m2.beijingdaxing.cn/Home/News/detail/id/1\",        \"reprint\": null,        \"category_sub_id\": null,        \"is_original\": \"0\",        \"record_share\": \"0\",        \"bind_mobile\": \"0\",        \"share_time\": null,        \"audiourl\": \"\",        \"videourl\": \"\",        \"during\": \"00:50\",        \"video_img\": \"\",        \"liveurl\": \"\",        \"sub\": null,        \"category_title\": \"\",        \"ztnews\": [],        \"url_share\": \"http://m2.beijingdaxing.cn/Home/News2017/share/id/1\",        \"headerurl\": \"http://m2.beijingdaxing.cn/logo.jpg\",        \"authorname\": \"\"      },      {        \"id\": \"20231\",        \"title\": \"大兴人，花点时间来学习一下消防知识吧\",        \"name\": \"如何保证身边的消防安全？ \",        \"image\": \"http://m2.beijingdaxing.cn/Uploads/News/2017/12/22/5a3c9a9fb2554.png\",        \"source\": \"\",        \"tag\": \"消防,大兴人\",        \"category_id\": \"1,1\",        \"focus_category_id\": \"\",        \"type\": \"8\",        \"top\": \"0\",        \"focus_image\": \"\",        \"focus\": \"0\",        \"content\": \"\",        \"intro\": \"如何保证身边的消防安全？ \",        \"is_comment\": \"1\",        \"view\": \"134\",        \"comment\": \"2\",        \"collection\": null,        \"create_time\": \"1513921206\",        \"update_time\": \"1514081502\",        \"status\": \"1\",        \"seo_title\": \"\",        \"seo_keywords\": \"\",        \"seo_description\": \"\",        \"remark\": null,        \"sort\": \"0\",        \"author\": \"\",        \"uid\": \"43\",        \"url\": \"http://m2.beijingdaxing.cn/Home/News/detail/id/1\",        \"reprint\": null,        \"category_sub_id\": null,        \"is_original\": \"0\",        \"record_share\": \"0\",        \"bind_mobile\": \"0\",        \"share_time\": null,        \"audiourl\": \"\",        \"videourl\": \"\",        \"during\": \"01:01\",        \"video_img\": \"http://m2.beijingdaxing.cn1\",        \"liveurl\": \"\",        \"sub\": null,        \"category_title\": \"便民\",        \"ztnews\": [],        \"url_share\": \"http://m2.beijingdaxing.cn/Home/News2017/share/id/1\",        \"headerurl\": \"http://m2.beijingdaxing.cn/logo.jpg\",        \"authorname\": \"\"      },      {        \"id\": \"20220\",        \"title\": \"大兴人，和家人做一张消防安全疏散图吧\",        \"name\": \"做一张家庭消防疏散图，有备，方能无患。\",        \"image\": \"http://m2.beijingdaxing.cn/Uploads/News/2017/12/21/5a3b7db5f36bf.png\",        \"source\": \"\",        \"tag\": \"消防,大兴人\",        \"category_id\": \"1,1\",        \"focus_category_id\": \"\",        \"type\": \"8\",        \"top\": \"0\",        \"focus_image\": \"\",        \"focus\": \"0\",        \"content\": \"\",        \"intro\": \"做一张家庭消防疏散图，有备，方能无患。\",        \"is_comment\": \"1\",        \"view\": \"104\",        \"comment\": \"0\",        \"collection\": null,        \"create_time\": \"1513848229\",        \"update_time\": \"1513999773\",        \"status\": \"1\",        \"seo_title\": \"\",        \"seo_keywords\": \"\",        \"seo_description\": \"\",        \"remark\": null,        \"sort\": \"0\",        \"author\": \"\",        \"uid\": \"43\",        \"url\": \"http://m2.beijingdaxing.cn/Home/News/detail/id/1\",        \"reprint\": null,        \"category_sub_id\": null,        \"is_original\": \"0\",        \"record_share\": \"0\",        \"bind_mobile\": \"0\",        \"share_time\": null,        \"audiourl\": \"\",        \"videourl\": \"\",        \"during\": \"00:30\",        \"video_img\": \"\",        \"liveurl\": \"\",        \"sub\": null,        \"category_title\": \"\",        \"ztnews\": [],        \"url_share\": \"http://m2.beijingdaxing.cn/Home/News2017/share/id/1\",        \"headerurl\": \"http://m2.beijingdaxing.cn/logo.jpg\",        \"authorname\": \"\"      },      {        \"id\": \"20177\",        \"title\": \"暖人心！大兴志愿者为环卫工人送去志愿服务\",        \"name\": \"大兴区学雷锋志愿服务协会自1987年成立至今，服务对象累计超过100万人次。\",        \"image\": \"http://m2.beijingdaxing.cn/Uploads/News/2017/12/20/5a39db9217c0d.png\",        \"source\": \"\",        \"tag\": \"志愿者,环卫\",        \"category_id\": \"1,1\",        \"focus_category_id\": \"\",        \"type\": \"8\",        \"top\": \"0\",        \"focus_image\": \"\",        \"focus\": \"0\",        \"content\": \"\",        \"intro\": \"大兴区学雷锋志愿服务协会自1987年成立至今，服务对象累计超过100万人次。\",        \"is_comment\": \"1\",        \"view\": \"127\",        \"comment\": \"2\",        \"collection\": null,        \"create_time\": \"1513741207\",        \"update_time\": \"1513999894\",        \"status\": \"1\",        \"seo_title\": \"\",        \"seo_keywords\": \"\",        \"seo_description\": \"\",        \"remark\": null,        \"sort\": \"0\",        \"author\": \"\",        \"uid\": \"43\",        \"url\": \"http://m2.beijingdaxing.cn/Home/News/detail/id/1\",        \"reprint\": null,        \"category_sub_id\": null,        \"is_original\": \"0\",        \"record_share\": \"0\",        \"bind_mobile\": \"0\",        \"share_time\": null,        \"audiourl\": \"\",        \"videourl\": \"\",        \"during\": \"00:44\",        \"video_img\": \"\",        \"liveurl\": \"\",        \"sub\": null,        \"category_title\": \"\",        \"ztnews\": [],        \"url_share\": \"http://m2.beijingdaxing.cn/Home/News2017/share/id/1\",        \"headerurl\": \"http://m2.beijingdaxing.cn/logo.jpg\",        \"authorname\": \"\"      },      {        \"id\": \"20163\",        \"title\": \"说唱算什么，我们有快板儿！消防知识的快板儿Style，我觉得很OK\",        \"name\": \"这位老师以消防安全为主题，编排了一段快板儿。\",        \"image\": \"http://m2.beijingdaxing.cn/Uploads/News/2017/12/19/5a38ea3aa56bd.png\",        \"source\": \"\",        \"tag\": \"消防\",        \"category_id\": \"1,1\",        \"focus_category_id\": \"\",        \"type\": \"8\",        \"top\": \"0\",        \"focus_image\": \"\",        \"focus\": \"0\",        \"content\": \"\",        \"intro\": \"这位老师以消防安全为主题，编排了一段快板儿。\",        \"is_comment\": \"1\",        \"view\": \"261\",        \"comment\": \"1\",        \"collection\": null,        \"create_time\": \"1513668769\",        \"update_time\": \"1514041154\",        \"status\": \"1\",        \"seo_title\": \"\",        \"seo_keywords\": \"\",        \"seo_description\": \"\",        \"remark\": null,        \"sort\": \"0\",        \"author\": \"\",        \"uid\": \"43\",        \"url\": \"http://m2.beijingdaxing.cn/Home/News/detail/id/1\",        \"reprint\": null,        \"category_sub_id\": null,        \"is_original\": \"0\",        \"record_share\": \"0\",        \"bind_mobile\": \"0\",        \"share_time\": null,        \"audiourl\": \"\",        \"videourl\": \"\",        \"during\": \"02:14\",        \"video_img\": \"http://m2.beijingdaxing.cn1\",        \"liveurl\": \"\",        \"sub\": null,        \"category_title\": \"\",        \"ztnews\": [],        \"url_share\": \"http://m2.beijingdaxing.cn/Home/News2017/share/id/1\",        \"headerurl\": \"http://m2.beijingdaxing.cn/logo.jpg\",        \"authorname\": \"\"      },      {        \"id\": \"20146\",        \"title\": \"遇见庞各庄|老佟种的西瓜真甜啊～\",        \"name\": \"老佟种的瓜真甜~\",        \"image\": \"http://m2.beijingdaxing.cn/Uploads/News/2017/12/18/5a3761e42286b.png\",        \"source\": \"\",        \"tag\": \"庞各庄,西瓜\",        \"category_id\": \"1,1\",        \"focus_category_id\": \"\",        \"type\": \"8\",        \"top\": \"0\",        \"focus_image\": \"\",        \"focus\": \"0\",        \"content\": \"\",        \"intro\": \"老佟种的瓜真甜~\",        \"is_comment\": \"1\",        \"view\": \"210\",        \"comment\": \"7\",        \"collection\": null,        \"create_time\": \"1513579016\",        \"update_time\": \"1514027697\",        \"status\": \"1\",        \"seo_title\": \"\",        \"seo_keywords\": \"\",        \"seo_description\": \"\",        \"remark\": null,        \"sort\": \"0\",        \"author\": \"\",        \"uid\": \"1\",        \"url\": \"http://m2.beijingdaxing.cn/Home/News/detail/id/1\",        \"reprint\": null,        \"category_sub_id\": null,        \"is_original\": \"0\",        \"record_share\": \"0\",        \"bind_mobile\": \"0\",        \"share_time\": null,        \"audiourl\": \"\",        \"videourl\": \"\",        \"during\": \"02:00\",        \"video_img\": \"\",        \"liveurl\": \"\",        \"sub\": null,        \"category_title\": \"\",        \"ztnews\": [],        \"url_share\": \"http://m2.beijingdaxing.cn/Home/News2017/share/id/1\",        \"headerurl\": \"http://m2.beijingdaxing.cn/logo.jpg\",        \"authorname\": \"\"      },      {        \"id\": \"20145\",        \"title\": \"大兴西瓜节|庞各庄的西瓜，皮薄瓤甜，放心吃！\",        \"name\": \"咱庞各庄的西瓜，皮薄瓤甜，放心吃！\",        \"image\": \"http://m2.beijingdaxing.cn/Uploads/News/2017/12/18/5a375fd754715.png\",        \"source\": \"\",        \"tag\": \"庞各庄,吃,西瓜\",        \"category_id\": \"1,1\",        \"focus_category_id\": \"\",        \"type\": \"8\",        \"top\": \"0\",        \"focus_image\": \"\",        \"focus\": \"0\",        \"content\": \"\",        \"intro\": \"咱庞各庄的西瓜，皮薄瓤甜，放心吃！\",        \"is_comment\": \"1\",        \"view\": \"123\",        \"comment\": \"4\",        \"collection\": null,        \"create_time\": \"1513578457\",        \"update_time\": \"1514004962\",        \"status\": \"1\",        \"seo_title\": \"\",        \"seo_keywords\": \"\",        \"seo_description\": \"\",        \"remark\": null,        \"sort\": \"0\",        \"author\": \"\",        \"uid\": \"1\",        \"url\": \"http://m2.beijingdaxing.cn/Home/News/detail/id/1\",        \"reprint\": null,        \"category_sub_id\": null,        \"is_original\": \"0\",        \"record_share\": \"0\",        \"bind_mobile\": \"0\",        \"share_time\": null,        \"audiourl\": \"\",        \"videourl\": \"\",        \"during\": \"02:45\",        \"video_img\": \"\",        \"liveurl\": \"\",        \"sub\": null,        \"category_title\": \"\",        \"ztnews\": [],        \"url_share\": \"http://m2.beijingdaxing.cn/Home/News2017/share/id/1\",        \"headerurl\": \"http://m2.beijingdaxing.cn/logo.jpg\",        \"authorname\": \"\"      },      {        \"id\": \"20144\",        \"title\": \"绿色大兴 大兴邦绿色骑行 将快乐传递你我\",        \"name\": \"绿色出行，快乐骑行！\",        \"image\": \"http://m2.beijingdaxing.cn/Uploads/News/2017/12/18/5a376ea1cef66.png\",        \"source\": \"\",        \"tag\": \"绿色\",        \"category_id\": \"1,1\",        \"focus_category_id\": \"\",        \"type\": \"8\",        \"top\": \"0\",        \"focus_image\": \"\",        \"focus\": \"0\",        \"content\": \"\",        \"intro\": \"绿色出行，快乐骑行！\",        \"is_comment\": \"1\",        \"view\": \"84\",        \"comment\": \"4\",        \"collection\": null,        \"create_time\": \"1513577375\",        \"update_time\": \"1513615120\",        \"status\": \"1\",        \"seo_title\": \"\",        \"seo_keywords\": \"\",        \"seo_description\": \"\",        \"remark\": null,        \"sort\": \"0\",        \"author\": \"\",        \"uid\": \"1\",        \"url\": \"http://m2.beijingdaxing.cn/Home/News/detail/id/1\",        \"reprint\": null,        \"category_sub_id\": null,        \"is_original\": \"0\",        \"record_share\": \"0\",        \"bind_mobile\": \"0\",        \"share_time\": null,        \"audiourl\": \"\",        \"videourl\": \"\",        \"during\": \"04:16\",        \"video_img\": \"\",        \"liveurl\": \"\",        \"sub\": null,        \"category_title\": \"\",        \"ztnews\": [],        \"url_share\": \"http://m2.beijingdaxing.cn/Home/News2017/share/id/1\",        \"headerurl\": \"http://m2.beijingdaxing.cn/logo.jpg\",        \"authorname\": \"\"      },      {        \"id\": \"15572\",        \"title\": \"《三分钟谈消费》咱大兴人因买电视送手机引发的消费问题！\",        \"name\": \"2016年4月9日，消费者王先生看到某超市宣传的“购买某品牌电视送手机”的促销活动。\",        \"image\": \"http://m2.beijingdaxing.cn/Uploads/News/2017/06/30/5955ac1111e77.jpg\",        \"source\": \"\",        \"tag\": \"手机,大兴人\",        \"category_id\": \"1,1\",        \"focus_category_id\": \"\",        \"type\": \"8\",        \"top\": \"0\",        \"focus_image\": \"\",        \"focus\": \"0\",        \"content\": \"\",        \"intro\": \"2016年4月9日，消费者王先生看到某超市宣传的“购买某品牌电视送手机”的促销活动，花一样的钱，既有电视、又有手机，让王先生非常动心，于是花6800元购买了一台电视，并获得超市赠送的某品牌手机一部。\",        \"is_comment\": \"1\",        \"view\": \"861\",        \"comment\": \"6\",        \"collection\": null,        \"create_time\": \"1498786903\",        \"update_time\": \"1513582726\",        \"status\": \"1\",        \"seo_title\": \"\",        \"seo_keywords\": \"\",        \"seo_description\": \"\",        \"remark\": null,        \"sort\": \"0\",        \"author\": \"\",        \"uid\": \"8\",        \"url\": \"http://m2.beijingdaxing.cn/Home/News/detail/id/1\",        \"reprint\": null,        \"category_sub_id\": null,        \"is_original\": \"0\",        \"record_share\": \"0\",        \"bind_mobile\": \"0\",        \"share_time\": null,        \"audiourl\": \"\",        \"videourl\": \"http://p0jf704xi.bkt.clouddn.com/x0520cy1j01.m701.mp4\",        \"during\": \"03:20\",        \"video_img\": \"http://m2.beijingdaxing.cn1\",        \"liveurl\": \"\",        \"sub\": null,        \"category_title\": \"要闻\",        \"ztnews\": [],        \"url_share\": \"http://m2.beijingdaxing.cn/Home/News2017/share/id/1\",        \"headerurl\": \"http://m2.beijingdaxing.cn/logo.jpg\",        \"authorname\": \"\"      },      {        \"id\": \"14830\",        \"title\": \"《三分钟谈消费》咱大兴人因一张预付卡引发的消费问题！\",        \"name\": \"2016年10月，张女士在某理发店办理了一张面值300元的会员卡。\",        \"image\": \"http://m2.beijingdaxing.cn/Uploads/News/2017/06/07/59375194120f6.jpg\",        \"source\": \"\",        \"tag\": \"大兴人\",        \"category_id\": \"1,1\",        \"focus_category_id\": \"\",        \"type\": \"8\",        \"top\": \"0\",        \"focus_image\": \"\",        \"focus\": \"0\",        \"content\": \"\",        \"intro\": \"2016年10月，张女士在某理发店办理了一张面值300元的会员卡。\",        \"is_comment\": \"1\",        \"view\": \"286\",        \"comment\": \"6\",        \"collection\": null,        \"create_time\": \"1496797605\",        \"update_time\": \"1513582665\",        \"status\": \"1\",        \"seo_title\": \"\",        \"seo_keywords\": \"\",        \"seo_description\": \"\",        \"remark\": null,        \"sort\": \"0\",        \"author\": \"\",        \"uid\": \"8\",        \"url\": \"http://m2.beijingdaxing.cn/Home/News/detail/id/1\",        \"reprint\": null,        \"category_sub_id\": null,        \"is_original\": \"0\",        \"record_share\": \"0\",        \"bind_mobile\": \"0\",        \"share_time\": null,        \"audiourl\": \"\",        \"videourl\": \"http://p0jf704xi.bkt.clouddn.com/e0511kp9hdq.m701.mp4\",        \"during\": \"03:41\",        \"video_img\": \"http://m2.beijingdaxing.cn1\",        \"liveurl\": \"\",        \"sub\": null,        \"category_title\": \"要闻\",        \"ztnews\": [],        \"url_share\": \"http://m2.beijingdaxing.cn/Home/News2017/share/id/1\",        \"headerurl\": \"http://m2.beijingdaxing.cn/logo.jpg\",        \"authorname\": \"\"      },      {        \"id\": \"14294\",        \"title\": \"《三分钟谈消费》咱大兴人因一台电视机引发的消费问题！\",        \"name\": \"2016年8月5日李先生在某电器城购买了一台电视机，商家承诺免费送货和安装。\",        \"image\": \"http://m2.beijingdaxing.cn/Uploads/News/2017/05/22/5922addf233c4.png\",        \"source\": \"\",        \"tag\": \"大兴人\",        \"category_id\": \"1,1\",        \"focus_category_id\": \"\",        \"type\": \"8\",        \"top\": \"0\",        \"focus_image\": \"http://m2.beijingdaxing.cn1\",        \"focus\": \"0\",        \"content\": \"\",        \"intro\": \"2016年8月5日李先生在某电器城购买了一台电视机，商家承诺免费送货和安装。\",        \"is_comment\": \"1\",        \"view\": \"391\",        \"comment\": \"3\",        \"collection\": null,        \"create_time\": \"1495445204\",        \"update_time\": \"1513597880\",        \"status\": \"1\",        \"seo_title\": \"\",        \"seo_keywords\": \"\",        \"seo_description\": \"\",        \"remark\": null,        \"sort\": \"0\",        \"author\": \"\",        \"uid\": \"8\",        \"url\": \"http://m2.beijingdaxing.cn/Home/News/detail/id/1\",        \"reprint\": null,        \"category_sub_id\": null,        \"is_original\": \"0\",        \"record_share\": \"0\",        \"bind_mobile\": \"0\",        \"share_time\": null,        \"audiourl\": \"\",        \"videourl\": \"http://p0jf704xi.bkt.clouddn.com/g0506y5d4sv.m701.mp4\",        \"during\": \"03:23\",        \"video_img\": \"http://m2.beijingdaxing.cn1\",        \"liveurl\": \"\",        \"sub\": null,        \"category_title\": \"要闻,便民\",        \"ztnews\": [],        \"url_share\": \"http://m2.beijingdaxing.cn/Home/News2017/share/id/1\",        \"headerurl\": \"http://m2.beijingdaxing.cn/logo.jpg\",        \"authorname\": \"\"      },      {        \"id\": \"13553\",        \"title\": \"《三分钟谈消费》咱大兴人因一合约机引发的消费问题！\",        \"name\": \"大兴区王先生被商家欺瞒事实下购买了合约机。\",        \"image\": \"http://m2.beijingdaxing.cn/Uploads/News/2017/05/02/590826393d8f8.png\",        \"source\": \"\",        \"tag\": \"\",        \"category_id\": \"1,1\",        \"focus_category_id\": \"\",        \"type\": \"8\",        \"top\": \"0\",        \"focus_image\": \"\",        \"focus\": \"0\",        \"content\": \"\",        \"intro\": \"大兴区王先生被商家欺瞒事实下购买了合约机，这件购机维权事件的背后有哪些咱们消费者需要注意的地方呢？\",        \"is_comment\": \"1\",        \"view\": \"604\",        \"comment\": \"7\",        \"collection\": null,        \"create_time\": \"1493707724\",        \"update_time\": \"1513582768\",        \"status\": \"1\",        \"seo_title\": \"\",        \"seo_keywords\": \"\",        \"seo_description\": \"\",        \"remark\": null,        \"sort\": \"0\",        \"author\": \"\",        \"uid\": \"8\",        \"url\": \"http://m2.beijingdaxing.cn/Home/News/detail/id/1\",        \"reprint\": null,        \"category_sub_id\": null,        \"is_original\": \"1\",        \"record_share\": \"0\",        \"bind_mobile\": \"0\",        \"share_time\": null,        \"audiourl\": \"\",        \"videourl\": \"http://p0jf704xi.bkt.clouddn.com/f0398h8err9.m701.mp4\",        \"during\": \"03:56\",        \"video_img\": \"http://m2.beijingdaxing.cn1\",        \"liveurl\": \"\",        \"sub\": null,        \"category_title\": \"要闻,科普\",        \"ztnews\": [],        \"url_share\": \"http://m2.beijingdaxing.cn/Home/News2017/share/id/1\",        \"headerurl\": \"http://m2.beijingdaxing.cn/logo.jpg\",        \"authorname\": \"\"      },      {        \"id\": \"10255\",        \"title\": \"《舌尖上的大兴》之团圆饭\",        \"name\": \"在大兴，有家人的地方就是年。\",        \"image\": \"http://m2.beijingdaxing.cn/Uploads/News/2017/01/24/5886ce06b9ff5.jpg\",        \"source\": \"\",        \"tag\": \"团圆饭\",        \"category_id\": \"1,1\",        \"focus_category_id\": \"\",        \"type\": \"8\",        \"top\": \"0\",        \"focus_image\": \"\",        \"focus\": \"0\",        \"content\": \"\",        \"intro\": \"在大兴，有家人的地方就是年。\",        \"is_comment\": \"1\",        \"view\": \"7130\",        \"comment\": \"7\",        \"collection\": null,        \"create_time\": \"1485219946\",        \"update_time\": \"1513582500\",        \"status\": \"1\",        \"seo_title\": \"\",        \"seo_keywords\": \"\",        \"seo_description\": \"\",        \"remark\": null,        \"sort\": \"0\",        \"author\": \"\",        \"uid\": \"27\",        \"url\": \"http://m2.beijingdaxing.cn/Home/News/detail/id/1\",        \"reprint\": null,        \"category_sub_id\": null,        \"is_original\": \"1\",        \"record_share\": \"0\",        \"bind_mobile\": \"0\",        \"share_time\": null,        \"audiourl\": \"\",        \"videourl\": \"http://p0jf704xi.bkt.clouddn.com/o0369uykz3p.m701.mp4\",        \"during\": \"05:40\",        \"video_img\": \"http://m2.beijingdaxing.cn1\",        \"liveurl\": \"\",        \"sub\": null,        \"category_title\": \"要闻,快讯,文体\",        \"ztnews\": [],        \"url_share\": \"http://m2.beijingdaxing.cn/Home/News2017/share/id/1\",        \"headerurl\": \"http://m2.beijingdaxing.cn/logo.jpg\",        \"authorname\": \"\"      },      {        \"id\": \"7102\",        \"title\": \"《舌尖上的大兴》之家的味道\",        \"name\": \"不管走到哪儿，家的味道，始终都是大兴人踏上征程与归途的原始动力\",        \"image\": \"http://m2.beijingdaxing.cn/Uploads/News/2016/10/27/5811ea5730fc6.jpg\",        \"source\": \"\",        \"tag\": \"\",        \"category_id\": \"1,1\",        \"focus_category_id\": \"\",        \"type\": \"8\",        \"top\": \"0\",        \"focus_image\": \"http://m2.beijingdaxing.cn1\",        \"focus\": \"0\",        \"content\": \"\",        \"intro\": \"不管走到哪儿，家的味道，始终都是大兴人踏上征程与归途的原始动力\",        \"is_comment\": \"0\",        \"view\": \"25686\",        \"comment\": \"1\",        \"collection\": null,        \"create_time\": \"1477648718\",        \"update_time\": \"1513582513\",        \"status\": \"1\",        \"seo_title\": \"\",        \"seo_keywords\": \"\",        \"seo_description\": \"\",        \"remark\": null,        \"sort\": \"0\",        \"author\": \"\",        \"uid\": \"27\",        \"url\": \"http://m2.beijingdaxing.cn/Home/News/detail/id/1\",        \"reprint\": null,        \"category_sub_id\": null,        \"is_original\": \"1\",        \"record_share\": \"0\",        \"bind_mobile\": \"0\",        \"share_time\": null,        \"audiourl\": \"\",        \"videourl\": \"http://p0jf704xi.bkt.clouddn.com/z0340b3xynn.m701.mp4\",        \"during\": \"05:24\",        \"video_img\": \"http://m2.beijingdaxing.cn1\",        \"liveurl\": \"\",        \"sub\": null,        \"category_title\": \"要闻,快讯\",        \"ztnews\": [],        \"url_share\": \"http://m2.beijingdaxing.cn/Home/News2017/share/id/1\",        \"headerurl\": \"http://m2.beijingdaxing.cn/logo.jpg\",        \"authorname\": \"\"      },      {        \"id\": \"6217\",        \"title\": \"《舌尖上的大兴》之东辛屯手擀面\",        \"name\": \"或许是因为数百年前始于“世界面食之根”山西的那次大移民，大兴人尤其是爱吃面条，手擀面无疑是最受欢迎的面食之一。\",        \"image\": \"http://m2.beijingdaxing.cn/Uploads/News/2016/09/21/57e23bd75f523.png\",        \"source\": \"\",        \"tag\": \"\",        \"category_id\": \"1,1\",        \"focus_category_id\": \"\",        \"type\": \"8\",        \"top\": \"0\",        \"focus_image\": \"http://m2.beijingdaxing.cn1\",        \"focus\": \"0\",        \"content\": \"\",        \"intro\": \"或许是因为数百年前始于“世界面食之根”山西的那次大移民，大兴人尤其是爱吃面条，手擀面无疑是最受欢迎的面食之一。\",        \"is_comment\": \"1\",        \"view\": \"27550\",        \"comment\": \"2\",        \"collection\": null,        \"create_time\": \"1474438500\",        \"update_time\": \"1513600846\",        \"status\": \"1\",        \"seo_title\": \"\",        \"seo_keywords\": \"\",        \"seo_description\": \"\",        \"remark\": null,        \"sort\": \"0\",        \"author\": \"\",        \"uid\": \"27\",        \"url\": \"http://m2.beijingdaxing.cn/Home/News/detail/id/1\",        \"reprint\": null,        \"category_sub_id\": null,        \"is_original\": \"1\",        \"record_share\": \"0\",        \"bind_mobile\": \"0\",        \"share_time\": null,        \"audiourl\": \"\",        \"videourl\": \"http://p0jf704xi.bkt.clouddn.com/i03339tcfne.m701.mp4\",        \"during\": \"05:21\",        \"video_img\": \"http://m2.beijingdaxing.cn1\",        \"liveurl\": \"\",        \"sub\": null,        \"category_title\": \"文体\",        \"ztnews\": [],        \"url_share\": \"http://m2.beijingdaxing.cn/Home/News2017/share/id/1\",        \"headerurl\": \"http://m2.beijingdaxing.cn/logo.jpg\",        \"authorname\": \"\"      }    ],    \"update_no\": 17,    \"dxmember\": [],    \"recommend\": 0  },  \"page\": {    \"pageNo\": 1,    \"pageSize\": 20  }}";
		List list = AutoCount.makeJsonList(str);
		assertTrue(list.size()>5);
	}
	@Test
	public void testRandHour() throws Exception {
		for(int i = 0 ; i < 20 ; i++){
			Date d = AutoCount.randHour(new Date());
			String sendday =DateFormatUtils.format(d, "dd");
			String nowday = DateFormatUtils.format(new Date(), "dd");
			int isnextday=Integer.parseInt(sendday) - Integer.parseInt(nowday) ;
			System.out.println(DateFormatUtils.format(d, "ddHH"));
			assertTrue(isnextday >=0 );
			assertTrue(isnextday <=1 );
			long isnotlate =  d.getTime() - (new Date().getTime()); 
			System.out.println(isnotlate);
			assertTrue (isnotlate >0);
		}

	}

}
