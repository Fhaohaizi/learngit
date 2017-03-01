package selenium;

import java.awt.AWTException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
public class Abc extends Case{	
	public WebDriver driver;
	
	@BeforeClass
	public void setUp() {
//		ProfilesIni pi = new ProfilesIni();
//		FirefoxProfile profile = pi.getProfile("default");
		FirefoxProfile profile = new FirefoxProfile();
		//是否显示下载进度框
		profile.setPreference("browser.download.manager.showWhenStarting", false);
		//网站保存离线数据时不通知我
		profile.setPreference("browser.offline-apps.notify", false);
		//应用程序设置不询问
		profile.setPreference("browser.helperApps.alwaysAsk.force", false);
		//browser.download.folderList 设置Firefox的默认 下载 文件夹。0是桌面；1是“我的下载”；2是自定义
		profile.setPreference("browser.download.folderList", 0);
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/octet-stream, application/vnd.ms-excel, text/csv, application/zip, application/msword");
		testBegin();
		driver.manage().window().maximize();
		driver = new FirefoxDriver(profile);
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		}
			
	@Test(priority = 1)
	public void testCase() throws IOException, InterruptedException, AWTException {
		driver.get("http://www.dz101.com/");
		output("测试用例！");
		takeScreenshotByNow(driver);
		loginWithTeacher(driver);
		}
	
	@Test(priority = 2)
	public void testAbac() throws InterruptedException, IOException {
		driver.get("http://www.baidu.com/");
		takeScreenshotByNow(driver);
		Thread.sleep(500);
		output("OK！");
	}
	@AfterMethod
	public void testOver() {
		driver.quit();
	}
	
	@AfterClass
	public void tearDown() throws InterruptedException {
		testOver(driver, false);
		}
		
		
		
		
}
