package selenium;

import java.awt.AWTException;
import java.util.List;
import java.util.Scanner;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class Special extends Base{
	//选择老师身份登录
	public static void loginWithTeacher(WebDriver driver) throws InterruptedException, AWTException {
		findElementByIdAndClick(driver, "IsNoLogin");
		findElementByXpathAndClick(driver, "/html/body/table/tbody/tr[2]/td/div/div/div[1]/span[1]/input");
		findElementByIdAndClearSendkeys(driver, "UserName", "UserName", "18871170065");
		findElementByIdAndClearSendkeys(driver, "T_UserPassword", "UserPasswordA", "111111");
		findElementByIdAndClick(driver, "IsLoginBtn");
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
	}
	//选择学生身份登录
	public static void loginWithStudent(WebDriver driver) throws InterruptedException {
		findElementByIdAndClick(driver, "IsNoLogin");
		findElementByXpathAndClick(driver, "/html/body/table/tbody/tr[2]/td/div/div/div[1]/span[2]/input");
		findElementByIdAndClearSendkeys(driver, "UserName", "UserName", "18436035355");
		findElementByIdAndClearSendkeys(driver, "T_UserPassword", "UserPasswordA", "222222");
		findElementByIdAndClick(driver, "IsLoginBtn");
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
	}
	//进入组卷系统改为初中物理
	public static void intoPaperSystemChooseSubject(WebDriver driver) throws InterruptedException {
		findElementByTextAndClick(driver, "组卷系统");
		Actions subject = new Actions(driver);
		subject.moveToElement(driver.findElement(By.xpath("/html/body/div[5]/ul/li[1]/a"))).perform();
		findElementByXpathAndClick(driver, "/html/body/div[5]/ul/li[1]/ul/li[1]/span/a[4]");
		Thread.sleep(2000);
		
	}
	//组一份试卷命名
	public static void buildPaperByName(WebDriver driver, String name) throws InterruptedException {
		buildPage_addAllQuestion(driver);;
		findElementByIdAndClick(driver, "2");
		buildPage_addAllQuestion(driver);
		findElementByXpathAndClick(driver, "/html/body/div[4]/div/div");
		findElementByTextAndClick(driver, "保存下载");
		findElementByIdAndClearSendkeys(driver, "papername", "papername", name);
		findElementByIdAndClick(driver, "submit");
		Thread.sleep(5000);
	}
	//把本页试题添加入试题篮
	public static void buildPage_addAllQuestion(WebDriver driver) throws InterruptedException {
		List<WebElement> add = driver.findElements(By.linkText("加入试题篮"));
		for(WebElement question : add){
			clickByJs(driver, question);
			Thread.sleep(1000);
		}
	}
	//下载当前第一个试卷
	public static void paperPage_DownloadFirstPaper(WebDriver driver) throws InterruptedException {
		findElementByXpathAndClick(driver, "/html/body/div[3]/div[3]/table/tbody/tr[1]/td[1]/input");
		findElementByXpathAndClick(driver, "/html/body/div[3]/div[2]/a[2]");
		input = new Scanner(System.in);
		boolean success = true;
		while(success){
			findElementByIdAndClearSendkeys(driver, "verifyCode", "verifyCode", input.nextLine());
			findElementByIdAndClick(driver, "submitbtn");
			Thread.sleep(1000);
			if (exist(driver, By.id("docversion"))) {
				output("验证码输入错误！");
			}else{
				output("验证码输入正确！");
				success = false;
				break;
				}
			}
		findElementByTextAndClick(driver, "我知道了");
	}























































}
