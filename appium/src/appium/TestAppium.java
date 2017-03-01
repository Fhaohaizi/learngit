package appium;  
  
import io.appium.java_client.android.AndroidDriver;  
import java.io.File;  
import java.net.MalformedURLException;  
import java.net.URL;  
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;  
import org.testng.annotations.AfterMethod;  
import org.testng.annotations.AfterSuite;  
import org.testng.annotations.BeforeMethod;  
import org.testng.annotations.BeforeSuite;  
import org.testng.annotations.Test;  
  
public class TestAppium {  
    private AndroidDriver driver;  
  
    @BeforeSuite  
    public void beforeSuite() throws MalformedURLException {  
      //设置apk的路径
    	File clasPathRoot = new File(System.getProperty("user.dir"));
    	File appDir = new File(clasPathRoot,"apps");
  		File app = new File(appDir,"ContactManager.apk");
  		//设置自动化相关参数
  		DesiredCapabilities capabilities = new DesiredCapabilities();
  		capabilities.setCapability("deviceName", "Android Emulator");
  		capabilities.setCapability(CapabilityType.BROWSER_NAME,"");
  		//设置安卓系统版本和平台
  		capabilities.setCapability("platformVersion", "4.4.4");
  		capabilities.setCapability("platformName", "Android");
  		//设置apk路径
  		capabilities.setCapability("app", app.getAbsolutePath());
  		//设置app的主包名和主类名
  		capabilities.setCapability("appPackage", "com.dianzhi.student");
  		capabilities.setCapability("appActivity", ".activity.SplashActivity");
        capabilities.setCapability("sessionOverride", true);    //每次启动时覆盖session，否则第二次后运行会报错不能新建session  
        capabilities.setCapability("unicodeKeyboard", true);    //设置键盘  
        capabilities.setCapability("resetKeyboard", false);     //设置默认键盘为appium的键盘  
        capabilities.setCapability("appPackage", "com.example.android.contactmanager");
        capabilities.setCapability("appActivity", ".ContactManager");
        capabilities.setCapability("unicodeKeyboard", "True");
        capabilities.setCapability("resetKeyboard", "True");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);  
            

    }  
  
    @AfterSuite  
    public void afterSuite() {  
        driver.quit();  
    }  
  
    @BeforeMethod  
    public void beforeMethod() throws Exception {  
        System.out.println("beforeMethod");  
    }  
  
    @AfterMethod  
    public void afterMethod() throws Exception {  
        System.out.println("afterMethod"); 
        
    }  
  
    @Test  
    public void test1() {  
        System.out.println("mainTest");  
        WebElement sss = driver.findElement(By.className("android.widget.ImageView"));
        sss.click();
//        int i;  
//        for (i = 0; i < 4; i++) {  
//            // 通过UI界面上的文字获取控件  
//            driver.findElementByName("按钮").click();  
//        }  
//        // 通过Id获取控件  
//        String result = driver.findElementById("tv").getText();  
//        Assert.assertEquals("点击次数:" + i, result);  
//        // 等待  
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);  
//        // 通过控件类型获取控件列表  
//        List<WebElement> textFieldsList = driver  
//                .findElementsByClassName("android.widget.EditText");  
//        textFieldsList.get(0).sendKeys("123456789");  
//        // driver.findElementById("et").sendKeys("123456789");  
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);  
//        driver.findElementByName("跳转").click();  
    }  
  
} 