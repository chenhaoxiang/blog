package cn.chenhaoxiang;

import cn.chenhaoxiang.entity.BlogDataEntity;
import cn.chenhaoxiang.entity.BlogEntity;
import cn.chenhaoxiang.utils.FileUtils;
import cn.chenhaoxiang.utils.JSONUtils;
import org.apache.log4j.Logger;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import javax.swing.*;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by 陈浩翔 on 2017/7/27 0027.
 */
public class SaveBlogDataEntity implements PageProcessor {
	private static Logger logger = Logger.getLogger(SaveBlogDataEntity.class);
	// 部分一：抓取网站的相关配置，包括编码、抓取间隔、重试次数等
	private static Site site;
	private static JTextArea textArea;
	private static List<String> blogIdList = null;
	public static BlogDataEntity json2BlogDataEntity(String str){
        BlogEntity blogEntity  = JSONUtils.json2obj(str,BlogEntity.class);
        String data = blogEntity.getData();
        BlogDataEntity blogDataEntity = JSONUtils.json2obj(data,BlogDataEntity.class);
        return blogDataEntity;
    }
	@Override
	public void process(Page page) {
		logger.info(page.getJson().toString());
		BlogDataEntity blogDataEntity = json2BlogDataEntity(page.getJson().toString());
		if (blogDataEntity == null) {
			if(textArea!=null)
			textArea.append("返回值为空，文章不存在!\n");
			return;
		}
		// 开始写入文件
		String file = blogDataEntity.getCreate().substring(0, 7);
		String title = blogDataEntity.getTitle();
		title = title.replaceAll("[/,\\\\,:,*,?,|,<,>]", " ");
		blogDataEntity.setTitle(title);
		String fileName = FileUtils.basePath + "\\" + file + "\\" + blogDataEntity.getCreate().substring(0, 10) + "-"
				+ blogDataEntity.getTitle() + ".markdown";
		logger.info(fileName);
		try {
			// logger.debug(blogDataEntity.getMarkdowncontent());
			if (blogDataEntity.getMarkdowncontent() != null) {
				FileUtils.saveStringToFile(blogDataEntity.getMarkdowncontent(), fileName, "utf-8");
			} else {
				//修复原来的一个BUG，也是自己没有考虑全面出现的
				FileUtils.saveStringToFile(blogDataEntity.getContent(), fileName, "utf-8");
			}

			logger.info("存储博客《" + blogDataEntity.getTitle() + "》成功");
			if(textArea!=null)
			textArea.append("存储博客《" + blogDataEntity.getTitle() + "》成功\n");
		} catch (UnsupportedEncodingException e) {
			logger.info("存储博客《" + blogDataEntity.getTitle() + "》出现异常，" + e.getMessage());
			if(textArea!=null)
			textArea.append("存储博客《" + blogDataEntity.getTitle() + "》出现异常，" + e.getMessage() + "\n");
		}
		if(blogIdList!=null&&blogIdList.size()>0)
			page.addTargetRequests(blogIdList);
	}

	@Override
	public Site getSite() {
		return site;
	}

	public static void main(String[] args) {
		site = Site.me().setRetryTimes(3).setSleepTime(3000).setCharset("utf-8").setDomain("write.blog.csdn.net")
				//.addCookie("userName", "u012017783");
				.addCookie("userName", "qq_26525215");
		Spider.create(new SaveBlogDataEntity())
				// 从"https://github.com/code4craft"开始抓
				.addUrl("http://write.blog.csdn.net/mdeditor/getArticle?id=76254851")
				// 开启5个线程抓取
				.thread(1)
				// 启动爬虫
				.start();

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(FileUtils.basePath);
	}

	public static void startGetBlogandSave(long begin, JButton btnNewButton, JTextArea textArea1, Set<String> blogIdSet, int threadNum) {
		textArea = textArea1;
		if(blogIdList!=null)
			blogIdList.clear();
		blogIdList=null;
		blogIdList = new ArrayList<String>();
		site = Site.me().setRetryTimes(3).setSleepTime(3000).setCharset("utf-8").setDomain("write.blog.csdn.net")
				.addCookie("userName", CSDNBlogExport.name);
		Iterator<String> iterator = blogIdSet.iterator();
		Boolean frist =true;
		String id="";
		while (iterator.hasNext()) {
			if(frist){
				frist=false;
				id = iterator.next();
				logger.debug("此次存储的文章ID:" + id);
			}else{
				String idString = iterator.next();
				blogIdList.add("http://write.blog.csdn.net/mdeditor/getArticle?id="+idString);
			}
		}
		Spider.create(new SaveBlogDataEntity())
		// 从"https://github.com/code4craft"开始抓
		.addUrl("http://write.blog.csdn.net/mdeditor/getArticle?id=" + id)
		// 开启50个线程抓取
		.thread(threadNum)
		// 启动爬虫
		.run();
		
		textArea.append("您的全部博客导出成功!\n"); 
		btnNewButton.setEnabled(true);
        //执行你需要操作的定时任务 
        long end = System.currentTimeMillis(); 
		textArea.append("本次导出博客耗时:["+ ((end - begin)/1000)+"]秒\n");
	}

}
