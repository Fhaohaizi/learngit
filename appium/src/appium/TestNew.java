package appium;

import io.appium.java_client.android.AndroidDriver;
import java.io.File;
import java.net.URL;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.*;

public class TestNew extends Case {
	public AndroidDriver driver; //驱动对象，大家注意，由于新版的APPIUM对驱动做了改动，所以这里就不能再用以前的WEBDRIVER来实现了；
    private String apkName="ContactManager.apk"; //安卓的安装包，被测软件
    private String platformVersion = "4.4.4";//安卓模拟器的版本
    private String serverURL = "http://127.0.0.1:4723/wd/hub";//appium测试服务的地址

    @Before
    public void setUp() throws Exception {
    	//start配置webdriver
    	File classpathRoot = new File(System.getProperty("user.dir"));//获得项目路径
    	File appDir = new File(classpathRoot, "apps");//获得APK所在文件夹名称
    	File app = new File(appDir, apkName);//获得APK文件
    	//设置启动服务端的参数
    	DesiredCapabilities capabilities = new DesiredCapabilities(); 
    	//指定浏览器的名字，我们测试的是APK所以没有浏览器，故而为空；
        capabilities.setCapability(CapabilityType.BROWSER_NAME, ""); 
        //指定平台，为安卓
        capabilities.setCapability("platformName", "Android"); 
        //指定设备，"Android Emulator"这个属性作者认为是“安卓设备即可”
        capabilities.setCapability("deviceName", "Android Emulator"); 
        //指定版本，作者的模拟器是4.4.2的
        capabilities.setCapability("platformVersion", platformVersion); 
        //不自动重装app
        capabilities.setCapability("autoLaunch", true);
        //指定包名
        capabilities.setCapability("appPackage", "com.example.android.contactmanager");
        //指定acitivity名字
        capabilities.setCapability("appActivity", ".ContactManager");
        //指定需要测试的APK，也就是需要安装的APK文件
        capabilities.setCapability("app", app.getAbsolutePath()); 
        //设置输入中文的
        capabilities.setCapability("unicodeKeyboard", "True");  
        capabilities.setCapability("resetKeyboard", "True");  
        //核心关键步骤，创建驱动，指定服务地址，和初始化信息；
        driver = new AndroidDriver (new URL(serverURL), capabilities);
//判断是否安装了app        boolean key = driver.isAppInstalled("com.example.android.contactmanager");
        outputNow();
        //end
    }
 
    @After
    public void tearDown() throws Exception {
    	outputNow();
        driver.quit();
    }

    @Test
    public void testDemo() throws InterruptedException{
    	System.out.println("d");
    	FindElementById(driver, "com.example.android.contactmanager:id/addContactButton").click();
    	driver.findElement(By.id("com.example.android.contactmanager:id/accountSpinner")).click();
    	driver.findElement(By.name("Office")).click();
    	driver.findElement(By.id("com.example.android.contactmanager:id/contactNameEditText")).sendKeys("测试");
    	driver.findElement(By.id("com.example.android.contactmanager:id/contactPhoneEditText")).sendKeys("123456");
    	driver.findElement(By.name("Save")).click();
    	Thread.sleep(2000);
    	
    }
}