package appium;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import io.appium.java_client.android.AndroidDriver;

public class Base {
	public static void swipeLeft(AndroidDriver driver) {//左滑
		int x = driver.manage().window().getSize().width;
		int y = driver.manage().window().getSize().height;
		driver.swipe(x-200, y/2, 200, y/2, 10);
	}
	public void swipeRight(AndroidDriver driver) {//右滑
		int x = driver.manage().window().getSize().width;
		int y = driver.manage().window().getSize().height;
		driver.swipe(200, y/2, x-200, y/2, 10);
	}
	public void swipeUp(AndroidDriver driver) {//下滑
		int x = driver.manage().window().getSize().width;
		int y = driver.manage().window().getSize().height;
		driver.swipe(x/2, y-200, x/2, 200, 10);
	}
	public void swipeDown(AndroidDriver driver) {//上滑
		int x = driver.manage().window().getSize().width;
		int y = driver.manage().window().getSize().height;
		driver.swipe(x/2, 200, x/2, y-200, 10);
	}
	//根据id获取元素
	public WebElement FindElementById(AndroidDriver driver, String id) {
		return driver.findElement(By.id(id));
	}
	//根据classname获取元素
	public WebElement FindElementByClassname(AndroidDriver driver, String classname) {
		return driver.findElement(By.className(classname));
	}
	//根据desc获取元素
	public WebElement FindElementByDesc(AndroidDriver driver, String using) {
		return driver.findElementByAccessibilityId(using);
	}
	//根据xpath获取元素
	public static WebElement findElementByXpath(AndroidDriver driver ,String xpath) {
		return driver.findElement(By.xpath(xpath));
	}
	//根据text文本获取元素编辑手机
	public void FindElementByName(AndroidDriver driver, String name) {
		driver.findElement(By.name(name));
	}
	//输出开始
	public void outputBegin(String text) {
		System.out.println(text+"..-. ...- 开始！");
	}
	//输出结束
	public void outputOver(String text) {
		System.out.println(text+"..-. ...- 结束！");
	}
	//明显输出
	public static void output(String text) {
		System.out.println(text);
	}
	//方法重载
	public void output(int num) {
		System.out.println(num);
	}
	//获取当前时间
	public static String getNow() {
		Date time = new Date();
		SimpleDateFormat now = new SimpleDateFormat("yyyy-MM-dd HH点mm分ss秒");
		String c = now.format(time);
		return(c);
	}
	//按物理按键
	public void pressKeyEvent(AndroidDriver driver, int key) {
		driver.sendKeyEvent(key);;
//		driver.sendKeyEvent(KeyEvent.VK_A);
	}
	//输出当前时间
	public static void outputNow() {
		Date time = new Date();
		SimpleDateFormat now = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String c = now.format(time);
		output(c);
	}
	//截图命名为当前时间保存桌面
	public static void takeScreenshotByNow(AndroidDriver driver) throws IOException {
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String file = "C:\\Users\\user\\Desktop\\"+getNow()+".png";
		FileUtils.copyFile(srcFile,new File(file));
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
	public static boolean exist(AndroidDriver driver, By selector) {
		try {
			driver.findElement(selector);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	//把string类型转化为int
	public static int changeStringToInt (String text) {
		return Integer.parseInt(text);
	}
	//通过xpath获取元素清除文本并写入
	public static void findElementByXpathAndClearSendkeys(AndroidDriver driver, String xpath, String text) {
		findElementByXpath(driver, xpath).clear();
		findElementByXpath(driver, xpath).sendKeys(text);
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
