package selenium;
//web端自动化

import java.awt.AWTException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.*;
//import org.openqa.selenium.ie.*;
import org.openqa.selenium.firefox.*;


public class Test extends Case{	
	public static class Tests {
		public static void main(String[] args) throws InterruptedException, IOException, AWTException {
			testBegin();
			//start 浏览器且访问首页
			/* 谷歌浏览器
			System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("http://www.baidu.com/");
			*/
			// 火狐浏览器
			FirefoxProfile profile = new FirefoxProfile();
			profile.setPreference("browser.download.manager.showWhenStarting", false);//是否显示下载进度框
			profile.setPreference("browser.offline-apps.notify", false);//网站保存离线数据时不通知我
			profile.setPreference("browser.helperApps.alwaysAsk.force", false);//应用程序设置不询问
			profile.setPreference("browser.download.folderList", 0);//设置下载地址0是桌面；1是“我的下载”；2是自定义
			profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/octet-stream, application/vnd.ms-excel, text/csv, application/zip, application/msword");
			profile.setPreference("dom.webnotifications.enabled", false);//允许通知			
			WebDriver driver = new FirefoxDriver(profile);//启动火狐浏览器
			driver.manage().window().maximize();//设置最大化
			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);//设置页面加载超时
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//设置查询组件等待时间5秒
			driver.manage().window().maximize();
			driver.get("http://www.dz101.com/");
			//end
			
			
			
			
			
			
			
			
			
			
			
			
			
			testOver(driver, false);
			
}
}
}
