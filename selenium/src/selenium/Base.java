package selenium;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.Set;
import java.awt.AWTException;
import java.awt.Robot;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Base extends Assert{
	public static Scanner input;//控制器输入
	//输出开始
	public static void outputBegin(String text) {
		System.out.println(text+"..-. ...- 开始！");
	}
	//输出结束
	public static void outputOver(String text) {
		System.out.println(text+"..-. ...- 结束！");
	}
	//明显输出
	public static void output(String text) {
		System.out.println(text);
	}
	//方法重载
	public static void output(int num) {
		System.out.println(num);
	}
	//获取当前时间
	public static String getNow() {
		Date time = new Date();
		SimpleDateFormat now = new SimpleDateFormat("yyyy-MM-dd HH点mm分ss秒");
		String c = now.format(time);
		return(c);
	}
	//输出当前时间
	public static void outputNow() {
		Date time = new Date();
		SimpleDateFormat now = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String c = now.format(time);
		output(c);
	}
	//截图命名为当前时间保存桌面
	public static void takeScreenshotByNow(WebDriver driver) throws IOException {
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String file = "C:\\Users\\user\\Desktop\\"+getNow()+".png";
		FileUtils.copyFile(srcFile,new File(file));
	}
	//截图重命名保存至桌面
	public static void takeScreenshotByName(WebDriver driver, String name) throws IOException {
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String file = "C:\\Users\\user\\Desktop\\"+name+".png";
		FileUtils.copyFile(srcFile,new File(file));
	}
	//通过id获取元素并点击
	public static void findElementByIdAndClick(WebDriver driver ,String id) {
		driver.findElement(By.id(id)).click();
	}
	//根据文本获取元素并点击
	public static void findElementByTextAndClick(WebDriver driver ,String text) {
		driver.findElement(By.linkText(text)).click();
	}
	//根据文本模糊查找
	public static void findElementByPartiaTextAndClick(WebDriver driver, String text) {
		driver.findElement(By.partialLinkText(text)).click();
	}
	//根据xpath获取元素
	public static WebElement findElementByXpath(WebDriver driver ,String xpath) {
		return driver.findElement(By.xpath(xpath));
	}
	//根据id获取元素
	public static WebElement findElementByid(WebDriver driver ,String id) {
		return driver.findElement(By.id(id));
	}
	//根据id获取元素清除文本写入文本
	public static void findElementByIdAndClearSendkeys(WebDriver driver, String id1 , String id2, String text) {
		driver.findElement(By.id(id1)).clear();
		driver.findElement(By.id(id2)).sendKeys(text);
	}
	//通过xpath获取元素点击
	public static void findElementByXpathAndClick(WebDriver driver, String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}
	//通过class获取元素并点击
	public static void findElementByClassNameAndClick(WebDriver driver, String name) {
		driver.findElement(By.className(name)).click();
	}
	//输出cookies信息
	public static void outputCookie(WebDriver driver) {
		Set<Cookie> cookie = driver.manage().getCookies();
		System.out.println(cookie);
	}
	//测试开始
	public static void testBegin() {
		outputBegin("测试");
		outputNow();
	}
	//测试结束
	public static void testOver(WebDriver driver, boolean key) throws InterruptedException {
		Thread.sleep(2000);
		if (key) {
		exit(driver);
		}
		outputNow();
		outputOver("测试");
		driver.quit();
	}
	//退出登录
	public static void exit(WebDriver driver) {
		driver.get("http://www.dz101.com/");
		Actions builder = new Actions(driver); 
		builder.moveToElement((driver.findElement(By.linkText("个人中心")))).perform();  
		findElementByTextAndClick(driver, "退出");
		driver.switchTo().alert().accept();
	}
	//通过url下载图片
	public static void downImg(String strUrl,String fileName){
		URL url = null;
		try {
			url = new URL(strUrl);
			} catch (MalformedURLException e2) {
				e2.printStackTrace();
				}
		InputStream is = null;
		try {
			is = url.openStream();
			} catch (IOException e1) {
				e1.printStackTrace();
				}
		OutputStream os = null;
		File f = new File("C:\\Users\\user\\workspace\\selenium\\");
		f.mkdirs();
		try{
			os = new FileOutputStream("C:\\Users\\user\\workspace\\selenium\\"+fileName+".png");
			int bytesRead = 0;
			byte[] buffer = new byte[8192];
			while((bytesRead = is.read(buffer,0,8192))!=-1){
				os.write(buffer,0,bytesRead);
				}
			}catch(FileNotFoundException e){
				} catch (IOException e) {
					e.printStackTrace();
					}
		}
	//分行读取txt文档
	public static String readTxtFile(String filePath){
		StringBuffer ssss = new StringBuffer("");
		try {
			String encoding="GBK";
			File file=new File(filePath);
			if(file.isFile() && file.exists()){ //判断文件是否存在
				InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);//考虑到编码格式
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				while((lineTxt = bufferedReader.readLine()) != null){
					System.out.println(lineTxt);
					ssss.append(lineTxt);
					}
				read.close();
				}else{
					System.out.println("找不到指定的文件");
					}
			} catch (Exception e) {
				System.out.println("读取文件内容出错");
				e.printStackTrace();
				}
		return ssss.toString();
		}
	//判断元素是否存在
	public static boolean exist(WebDriver driver, By selector) {
		try {
			driver.findElement(selector);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	//通过js点击
	public static void clickByJs(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
//		((JavascriptExecutor) driver).executeScript("arguments[0].click()", question);
	}
	//返回首页
	public static void backHome(WebDriver driver) {
		driver.get("http://www.dz101.com/");
	}
	//通过xpath获取元素用js点击
	public static void clickByjsByxpath(WebDriver driver, String xpath) {
		clickByJs(driver, driver.findElement(By.xpath(xpath)));
	}
	//按物理按键
	public static void pressKeyEvent(int keycode) throws AWTException {
		Robot robot = new Robot();
//		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyPress(keycode);
	}
	//把string类型转化为int
	public static int changeStringToInt (String text) {
		return Integer.parseInt(text);
	}
	//通过xpath获取元素清除文本并写入
	public static void findElementByXpathAndClearSendkeys(WebDriver driver, String xpath, String text) {
		findElementByXpath(driver, xpath).clear();
		findElementByXpath(driver, xpath).sendKeys(text);
	}
	//判断是否有警告框
	public static boolean judgeAlert(WebDriver driver) {
		try {
			driver.switchTo().alert();
			return true;
		} catch (Exception e) {
			output("没有发现警告框！");
			return false;
		}
	}
	//设置固定睡眠时间
	public static void sleep(int key) throws InterruptedException {
		switch (key) {
		case 0:
			Thread.sleep(500);
			break;
		case 1:
			Thread.sleep(2000);
			break;
		case 2:
			Thread.sleep(5000);
			break;
			
		default:
			output("输入错误！");
			break;
		}
	} 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
 