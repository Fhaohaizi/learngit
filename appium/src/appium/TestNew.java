package appium;

import io.appium.java_client.android.AndroidDriver;
import java.io.File;
import java.net.URL;
import org.junit.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.*;

public class TestNew {
	public AndroidDriver driver; //驱动对象，大家注意，由于新版的APPIUM对驱动做了改动，所以这里就不能再用以前的WEBDRIVER来实现了；
    private String apkName="ContactManager.apk"; //安卓的安装包，被测软件
    private String platformVersion = "4.4.4";//安卓模拟器的版本
    private String serverURL = "http://127.0.0.1:4723/wd/hub";//appium测试服务的地址

    @Before
    public void setUp() throws Exception {
        //配置webdriver
    	 File classpathRoot = new File(System.getProperty("user.dir"));//获得项目路径
         File appDir = new File(classpathRoot, "apps");//获得APK所在文件夹名称
         File app = new File(appDir, apkName);//获得APK文件

         DesiredCapabilities capabilities = new DesiredCapabilities(); /*新建一个DesiredCapabilities对象，是import org.openqa.selenium.remote.DesiredCapabilities;作者个人赶脚是用来收集驱动初始化信息用的；*/
         capabilities.setCapability(CapabilityType.BROWSER_NAME, ""); //指定浏览器的名字，我们测试的是APK所以没有浏览器，故而为空；
         capabilities.setCapability("platformName", "Android"); // 指定平台，为安卓
         capabilities.setCapability("deviceName", "Android Emulator"); //指定设备，"Android Emulator"这个属性作者认为是“安卓设备即可”
         capabilities.setCapability("platformVersion", platformVersion); //指定版本，作者的模拟器是4.4.2的
         capabilities.setCapability("app", app.getAbsolutePath()); //指定需要测试的APK，也就是需要安装的APK文件；
         //核心关键步骤，创建驱动，指定服务地址，和初始化信息；
         driver = new AndroidDriver (new URL(serverURL), capabilities);
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void taobao_search() throws InterruptedException{
    	System.out.println("d");
        //找输入框并点击
        WebElement text = driver.findElementByClassName("android.widget.EditText");
        text.click();
        //输入要搜索的内容
        text.sendKeys("xiaomi3");
        //找搜索按钮并点击
        WebElement search = driver.findElementByAndroidUIAutomator("new UiSelector().className(\"android.widget.Button\").text(\"搜索\")");        
        search.click();
    }
}