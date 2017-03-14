package selenium;

import java.awt.AWTException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Case extends Special{
	//检查试题添加到试题篮数量是否正确
	public static void checkTestAddBasketNum(WebDriver driver) throws InterruptedException, AWTException {
		loginWithTeacher(driver);
		findElementByTextAndClick(driver, "组卷系统");
		clickByJs(driver, driver.findElement(By.xpath("html/body/div[5]/ul/li[4]/a")));
		//点击中考真题
		clickByJs(driver, driver.findElement(By.xpath("html/body/div[6]/div[1]/div[1]/dl/dd/a[2]")));
		//点击北京
		clickByJs(driver, driver.findElement(By.xpath("html/body/div[6]/div[1]/div[2]/dl/dd/a[3]")));
		//点击2016
		clickByJs(driver, driver.findElement(By.xpath("html/body/div[6]/div[1]/div[3]/dl/dd/a[3]")));
		Thread.sleep(500);
		String sreach_handle = driver.getWindowHandle();
		WebElement papertestnum = driver.findElement(By.xpath("html/body/div[6]/div[3]/div[2]/table/tbody/tr/td[3]"));
		int testnum = changeStringToInt(papertestnum.getText());
		findElementByTextAndClick(driver, "北京市2016年高级中等学校招生考试");
		driver.navigate().refresh();
		Thread.sleep(1000);
		Set<String> handles = driver.getWindowHandles();
		for(String handle : handles){
			if (handle.equals(sreach_handle) == false){
			//切换到注册页面
			driver.switchTo().window(handle);
			output("转到新页面！");
			Thread.sleep(2000);
			buildPage_addAllQuestion(driver);
			WebElement testbasket = driver.findElement(By.xpath("html/body/div[4]/div/div/a/span/b"));
			int testbasketnum = Integer.parseInt(testbasket.getText());
			assert (testnum == testbasketnum);
			assertEquals("试题未全部加入试题篮", testnum, testbasketnum);
			driver.close();
			}
			}
		for(String handle : handles){
			if (handle.equals(sreach_handle)){
			driver.switchTo().window(handle);
			Thread.sleep(2000);
			backHome(driver);
			driver.quit();
			}
			}
	}
	//新组一套试卷并下载
	public static void buildPaperAndDownload(WebDriver driver) throws InterruptedException, AWTException {
		loginWithTeacher(driver);
		intoPaperSystemChooseSubject(driver);
		buildPage_addAllQuestion(driver);
		paperPage_DownloadFirstPaper(driver);
		driver.quit();
	}
	//登录下载精品资源
	public static void downloadResources(WebDriver driver, boolean key) throws InterruptedException, AWTException {
		if (key) {
			loginWithTeacher(driver);
		}else{
			loginWithStudent(driver);
		}
		findElementByTextAndClick(driver, "精品资源");
		String homehandle = driver.getWindowHandle();
		findElementByXpathAndClick(driver, "html/body/div[3]/ul/li[4]/a");
		Set<String> handles = driver.getWindowHandles();
		for(String handle : handles){
			if (handle.equals(homehandle)==false){
				driver.switchTo().window(handle);
				output("切换到精品资源页面了！");
				Thread.sleep(2000);
				findElementByXpathAndClick(driver, "html/body/div[5]/div[2]/div[1]/div[1]/dl/dd/a[4]");
				findElementByXpathAndClick(driver, "html/body/div[5]/div[2]/div[1]/div[2]/dl/dd/a[3]");
				findElementByXpathAndClick(driver, "html/body/div[5]/div[2]/div[1]/div[4]/dl/dd/a[3]");
				Thread.sleep(2000);
				String news = driver.getWindowHandle();
				findElementByTextAndClick(driver, "点击下载");
				Set<String> handlenews = driver.getWindowHandles();
				for(String newsss : handlenews){
					if (newsss.equals(news)==false && newsss.equals(homehandle) == false) {
						driver.switchTo().window(newsss);
						output("切换到资源页面了！");
						findElementByXpathAndClick(driver, "html/body/div[3]/div[1]/div[2]/table/tbody/tr[3]/td[5]/a");
						Thread.sleep(500);
						driver.switchTo().alert().accept();
						driver.close();
						}
					}
				for(String newsss : handlenews){
					if (newsss.equals(news)) {
						driver.switchTo().window(newsss);
						output("回到精品资源页面了！");
						driver.close();
						}
					}
				}
			}
		for(String handle : handles){
			if (handle.equals(homehandle)){
				driver.switchTo().window(handle);
				output("回到首页了！");
				Thread.sleep(2000);
				driver.quit();
				}
			}
		}
	//辅导用例
	public static void tutorCase(WebDriver driver) throws InterruptedException, AWTException {
		loginWithTeacher(driver);
		String homehandle = driver.getWindowHandle();
		findElementByTextAndClick(driver, "在线辅导");
		Set<String> handles = driver.getWindowHandles();
		for(String handle : handles){
			if (handle.equals(homehandle) == false) {
				driver.switchTo().window(handle);
				output("跳转到新页面了！");
				String newhandle = driver.getWindowHandle();
				Thread.sleep(2000);
				findElementByClassNameAndClick(driver, "photoBtn");
				boolean one = true;
				while(one){
					if (exist(driver, By.linkText("接单"))) {
						findElementByTextAndClick(driver, "接单");
						one = false;
					}
				}
				Thread.sleep(5000);
				Set<String> newhandles = driver.getWindowHandles();
				for(String handle2 : newhandles){
					if (handle2.equals(newhandle) == false && handle2.equals(homehandle) == false) {
						driver.switchTo().window(handle2);
						output("跳转到新页面了！");
						boolean two = true;
						while(two){
							Thread.sleep(1000);
							findElementByXpathAndClick(driver, "html/body/div[1]/div[3]/div/ul/li[2]/p/img");
							Thread.sleep(1000);
							output("已经开始答疑了！");
							boolean three = true;
							while(three){
								Thread.sleep(5000);
								if (exist(driver, By.id("btn1"))) {
									output("已经结束答疑了！");
									three = false;
									}
								}
							two = false;
							}
						driver.close();
						}
					}
				for(String handle2 : newhandles){
					if (handle2.equals(newhandle)) {
						driver.switchTo().window(handle2);
						output(driver.getTitle());
						driver.close();
						}
					}
				}
			}
		for(String handle : handles){
			if (handle.equals(homehandle)) {
				driver.switchTo().window(handle);
				testOver(driver, false);
			}
		}
	}
	//修改姓名
	public static void myInfoPage_AlterName (WebDriver driver) throws InterruptedException {
		String homehandle = driver.getWindowHandle();
		findElementByTextAndClick(driver, "个人中心");
		Thread.sleep(1000);
		Set<String> handles = driver.getWindowHandles();
		for(String handle : handles){
			if (handle.equals(homehandle) == false) {
				driver.switchTo().window(handle);
				output("跳转到新页面了！");
				findElementByTextAndClick(driver, "修改");
				int num = new Random().nextInt(10);
				String name = "DZ王二小"+ num;
				findElementByIdAndClearSendkeys(driver, "fullname", "fullname", name);
				findElementByTextAndClick(driver, "保存");
				String fullname = findElementByXpath(driver, "html/body/div[3]/div[2]/div[2]/div/div[3]/div[1]/span[2]").getText();
				output(fullname);
				assertEquals("修改姓名失败！", "DZ王二小", fullname);
				driver.close();
			}
		}
		for(String handle : handles){
			if (handle.equals(homehandle)) {
				driver.switchTo().window(handle);
				output("跳转到新页面了！");
				testOver(driver, false);
			}
		}
	}
	//提交体现申请
	public static void submitWithdrawApply (WebDriver driver) throws InterruptedException, AWTException {
		loginWithTeacher(driver);
		String homehandle = driver.getWindowHandle();
		findElementByTextAndClick(driver, "个人中心");
		Thread.sleep(1000);
		Set<String> handles = driver.getWindowHandles();
		for(String handle : handles){
			if (handle.equals(homehandle) == false) {
				driver.switchTo().window(handle);
				output("跳转到新页面了！");
				findElementByTextAndClick(driver, "账户信息");
				findElementByTextAndClick(driver, "申请提现");
				String type = "html/body/table/tbody/tr[2]/td/div/table/tbody/tr[3]/td[3]/label[2]/input";
				findElementByXpathAndClick(driver, type);
				String money = "html/body/table/tbody/tr[2]/td/div/table/tbody/tr[4]/td[3]/input";
				findElementByXpathAndClearSendkeys(driver, money, "20");
				String account = "html/body/table/tbody/tr[2]/td/div/table/tbody/tr[5]/td[3]/input";
				findElementByXpathAndClearSendkeys(driver, account, "13120454219");
				String code = "html/body/table/tbody/tr[2]/td/div/table/tbody/tr[6]/td[3]/input";
				findElementByXpathAndClearSendkeys(driver, code, "我是测试，不要处理！");
				findElementByIdAndClick(driver, "submit");
				Thread.sleep(500);
				if (judgeAlert(driver)) {
					output(driver.switchTo().alert().getText());
					driver.switchTo().alert().accept();
					Thread.sleep(500);
					findElementByXpathAndClick(driver, "html/body/table/tbody/tr[1]/td[2]/a");
				}
				outputNow();
				driver.close();
			}
		}
		for(String handle : handles){
			if (handle.equals(homehandle)) {
				driver.switchTo().window(handle);
				output("回到首页了！");
				testOver(driver, false);
			}
		}
	}
	//布置作业
	public static void assignHomework(WebDriver driver) throws InterruptedException, AWTException {
		loginWithTeacher(driver);
		findElementByTextAndClick(driver, "作业系统");
		Thread.sleep(1000);
		findElementByTextAndClick(driver, "布置作业");
		findElementByXpathAndClick(driver, "//td[@class = 'FL' and @title = '自动化测试']");
		String homehandle = driver.getWindowHandle();
		findElementByXpathAndClick(driver, "html/body/div[5]/div[1]/a[2]");
		sleep(1);
		Set<String> handles = driver.getWindowHandles();
		for(String handle : handles){
			if (handle.equals(homehandle) == false) {
				driver.switchTo().window(handle);
				output("跳转到布置作业页面了！");
				//start 布置作业
				//设置班级名字
				findElementByIdAndClearSendkeys(driver, "paper_name", "paper_name", "selenium");
				//设置班级》点击选择班级》选择第一个班级》选择所有人
				findElementByIdAndClick(driver, "BanJi");
				findElementByXpathAndClick(driver, "html/body/div[3]/div[2]/dl[2]/dd/select/option[2]");
				findElementByXpathAndClick(driver, "html/body/table/tbody/tr[2]/td/div/div[2]/input");
				findElementByTextAndClick(driver, "确定");
				//设置分值》设置时间
				findElementByIdAndClearSendkeys(driver, "TS", "TS", "100");
				findElementByIdAndClearSendkeys(driver, "T2", "T2", "90");
				//设置日期》点击日期选框》点击下个月》选择23号
				sleep(1);
				findElementByXpathAndClick(driver, "html/body/div[3]/div[2]/dl[6]/dd/input");
				findElementByXpathAndClick(driver, "//a[@title = 'Next Month']");
				findElementByXpathAndClick(driver, "html/body/div[3]/div[2]/dl[6]/dd/span/div/div[2]/ul[2]/li[26]/a");
				findElementByTextAndClick(driver, "确定发布");
				//end
				sleep(2);
				//获取班级名称》验证》撤销
				String workname = findElementByXpath(driver, "html/body/div[5]/div[2]/div/table/tbody/tr[1]/td[1]/a").getText();
				assertEquals("作业布置成功！", "selenium", workname);
				findElementByXpathAndClick(driver, "html/body/div[5]/div[2]/div/table/tbody/tr[1]/td[6]/a");
				driver.close();
				}
			}
		for(String handle : handles){
			if (handle.equals(homehandle)) {
				driver.switchTo().window(handle);
				output("回到作业管理页面了！");
				testOver(driver, false);
			}
		}
	}
	//注册用户且删除
	public static void registerUserAndDelete(WebDriver driver) throws ClassNotFoundException, SQLException, IOException, InterruptedException {
		String mobile = "13578965425";
		findElementByIdAndClearSendkeys(driver, "UserName", mobile);//输入手机号
		findElementByIdAndClick(driver, "unit_t");//选择学校
		findElementByIdAndClick(driver, "410000");//选择省
		findElementByIdAndClick(driver, "411700");//选择市
		findElementByIdAndClick(driver, "411721");//选择县
		findElementByIdAndClick(driver, "28342");//选择学校
		findElementByPartiaTextAndClick(driver, "点击获取验证码");
		String code = MySql.getMobileCode(mobile);//获取验证码
		findElementByIdAndClearSendkeys(driver, "Vcode", "Vcode", code);//输入验证码
		findElementByIdAndClick(driver, "T_UserPasswordA");//输入密码
		findElementByIdAndClick(driver, "T_UserPasswordB");//确认密码
		findElementByIdAndClick(driver, "RegPostBtn");//确认注册
		sleep(2);
		MySql.deleteUserByMobile(mobile);//删除用户
	}
	//向浏览器添加cookies
	public static void addCookies(WebDriver driver, String mobile) throws ClassNotFoundException, SQLException, IOException {
		Cookie a = new Cookie("MyName", mobile);
		Cookie b = new Cookie("User_token_Session", MySql.getNewToken(mobile));
		driver.manage().addCookie(a);
		driver.manage().addCookie(b);
		driver.navigate().refresh();
		//查看浏览器cookies
//		Set<Cookie> cooies = driver.manage().getCookies();
//		System.out.println(cooies);
	}












}
