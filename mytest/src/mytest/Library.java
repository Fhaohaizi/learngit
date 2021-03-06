package mytest;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.android.uiautomator.core.Configurator;
import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

import android.graphics.Point;
import android.view.KeyEvent;
import jp.jun_nama.test.utf7ime.helper.Utf7ImeHelper;

@SuppressWarnings("deprecation")
public class Library extends UiAutomatorTestCase{
	public void swipeLeft() {//左滑
		int y = UiDevice.getInstance().getDisplayHeight();
		int x = UiDevice.getInstance().getDisplayWidth();
		UiDevice.getInstance().swipe(x-100, y/2, 100, y/2, 8);
		sleep(150);
		}
	public void swipeRight() {//右滑
		int y = UiDevice.getInstance().getDisplayHeight();
		int x = UiDevice.getInstance().getDisplayWidth();
		UiDevice.getInstance().swipe(100, y/2, x-100, y/2, 8);
		sleep(150);
		}
	public void swipeDown() {//下滑
		int y = UiDevice.getInstance().getDisplayHeight();
		int x = UiDevice.getInstance().getDisplayWidth();
		UiDevice.getInstance().swipe(x/2, 200, x/2, y-200, 8);
		sleep(150);
		}	
	public void swipeUp() {//上滑
		int y = UiDevice.getInstance().getDisplayHeight();
		int x = UiDevice.getInstance().getDisplayWidth();
		UiDevice.getInstance().swipe(x/2, y-200, x/2, 200, 8);
		sleep(150);
		}
	public String getNow() {//获取当前时间
		Date time = new Date();
		SimpleDateFormat now = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String c = now.format(time);
		return c;
		}
	public void screenShot() {//截图并命名为当前时间
		File files = new File("/mnt/sdcard/aaa/"+getNow()+".png");
	    UiDevice.getInstance().takeScreenshot(files);
	    }
	
	public void circle(int x, int y, int r) {//画圆的方法
		double d = (double) (Math.PI/30);//角度		
		double[] xxx = new double[61];
		for(int i=0;i<61;i++){
			xxx[i]=Math.cos(i*d);
		}
		//获取x坐标
		double[] yyy = new double[61];
		for(int i=1;i<61;i++){
			yyy[i]=Math.sin(i*d);
		}
		//获取y坐标
		int[] xxx1 = new int[61];
		for(int i=0;i<61;i++){
			xxx1[i]=(int) (xxx[i]*200);
		}
		//转化坐标值类型
		int[] yyy1 = new int[61];
		for(int i=0;i<61;i++){
			yyy1[i]=(int) (yyy[i]*200);
		}
		//转化坐标值类型
		Point[] p = new Point[61];		
		for(int i=0;i<61;i++){
			p[i]=new Point();
			p[i].x = xxx1[i]+x;
			p[i].y = y-yyy1[i]+50;
		}
		//建立点数组
		UiDevice.getInstance().swipe(p, 2);
		}
	public void heart(int x, int y,int r) {//画心形的方法
		double d = (double) (Math.PI/30);
		double[] angle = new double[61];//设置角度差
		for(int i=0;i<61;i++){
			angle[i]=i*d;
		}
		//建立一个角度差double数组
		double[] ox = new double[61];
		for(int i=0;i<61;i++){
			ox[i]= r*(2*Math.cos(angle[i])-Math.cos(2*angle[i]));
		}
		//计算x坐标
		double[] oy = new double[61];
		for(int i=0;i<61;i++){
			oy[i]=r*(2*Math.sin(angle[i])-Math.sin(2*angle[i]));
		}
		//计算y坐标
		Point[] heart = new Point[61];
		for(int i=0;i<61;i++){
			heart[i] = new Point();
			heart[i].x = (int) oy[i]+x;
			heart[i].y = -(int) ox[i]+y;
		}
		//建立一个点数组，这里坐标一定要转化一下，不然是倒着的心形
		UiDevice.getInstance().swipe(heart, 2);
		}
	public UiObject getUiObjectByText(String text) {//通过文本获取控件
		return new UiObject(new UiSelector().text(text));
	}
	public UiObject getUiObjectByTextClassName(String text,String classname) {//通过文本和类名获取控件
		return new UiObject(new UiSelector().text(text).className(classname));
	}
	public UiObject getUiObjectByTextResourceId(String text, String id) {//通过文本和id获取对象
		return new UiObject(new UiSelector().text(text).resourceId(id));
	}
	public UiObject getUiObjectByResourceIdClassName(String id, String classname) {
		return new UiObject(new UiSelector().resourceId(id).className(classname));
	}
	public UiObject getUiObjextByResourceId(String id) {//通过资源ID获取控件
		return new UiObject(new UiSelector().resourceId(id));
	}
	public UiObject getUiObjectByDesc(String desc) {//通过desc获取控件
		return new UiObject(new UiSelector().description(desc));
	}
	public UiObject getUiObjectByClassName(String type) {//通过classname获取控件
		return new UiObject(new UiSelector().className(type));
	}
	public UiObject getUiObjectByResourceIdIntance(String id, int instance) {//通过id和instance获取控件
		return new UiObject(new UiSelector().resourceId(id).instance(instance));
	}
	public void writeText(String text) throws UiObjectNotFoundException{//输入文字
		getUiObjectByClassName("android.widget.EditText").setText(Utf7ImeHelper.e(text));
	}
	public UiScrollable getUiScrollabe() {//获取滚动控件
		return new UiScrollable(new UiSelector().scrollable(true));
	}
	public UiScrollable getUiScrollableByResourceId(String id) {//获取滚动对象
		return new UiScrollable(new UiSelector().scrollable(true).resourceId(id));
	}
	public UiObject getUiObjectByResourIdIndex(String id, int index) {//通过ID和index获取控件
		return new UiObject(new UiSelector().resourceId(id).index(index));
		
	}
	public void outputBegin(String text) {//输出开始
		System.out.println(text+"..-. ...- 开始！");
	}
	public void outputOver(String text) {//输出结束
		System.out.println(text+"..-. ...- 结束！");
	}
	public void outputNotable(String text) {//明显输出
		System.out.println("^_^..-. ...- "+text+"..-. ...- ^_^");
	}
	public void outputNotable(long num) {//方法重载
		System.out.println("========"+num+"========");
	}
	public void pressTimes(int keyCode, int times) {//对于一个按键按多次
		for(int i=0;i<times;i++){
			UiDevice.getInstance().pressKeyCode(keyCode);
		}
	}
	public void waitForUiObject(String text) {//等待对象出现
		Date start = new Date();
		boolean key = true;
		while(key){
			sleep(200);
			UiObject it = new UiObject(new UiSelector().text(text));
			if (it.exists()) {
				key = false;
			}
			Date end = new Date();
			long time = end.getTime() - start.getTime();
			if (time>10000) {
				outputNotable("超过10s没有出现！");
				key = false;
			}
		}
	}
	public void waitForUiObject(UiSelector selector) {//等待对象出现
		Date start = new Date();
		boolean key = true;
		while(key){
			sleep(200);
			UiObject it = new UiObject(selector);
			if (it.exists()) {
				key = false;
				}
			Date end = new Date();
			long time = end.getTime() - start.getTime();
			if (time>10000) {
				outputNotable("超过10秒没有出现！");
				key = false;
				}
			}
		}
	public void clickPiont(int x, int y) {//点击某一个点
		UiDevice.getInstance().click(x, y);
	}
	public void setShort() {//设置短等待
		Configurator.getInstance().setActionAcknowledgmentTimeout(750);
	}
	public void setLong() {//设置长等待
		Configurator.getInstance().setActionAcknowledgmentTimeout(1500);
	}
	//清除中文文本
	public void clearText() throws UiObjectNotFoundException {
		String name = getUiObjextByResourceId("com.dianzhi.teacher.school:id/edit_content_change").getText();
		outputNotable(name.length());
//		UiDevice.getInstance().pressKeyCode(KeyEvent.KEYCODE_MOVE_END);
//		UiDevice.getInstance().pressKeyCode(KeyEvent.KEYCODE_MOVE_HOME);
		//如果光标在最后
		pressTimes(KeyEvent.KEYCODE_DEL, name.length());
		//如果光标在最开始
//		pressTimes(KeyEvent.KEYCODE_FORWARD_DEL, name.length());
	}
	//匹配短信验证码
	public int findCode(String message) {
		Pattern r = Pattern.compile("[0-9]{6}");
		Matcher m = r.matcher(message);
		if (m.find()) {
			outputNotable("匹配成功");
			for(int i=0;i<=m.groupCount();i++){
				System.out.println(m.group(i));
				}
			}
		return changeStringToInt(m.group(0));
		}
	//把string类型转化为int
	public int changeStringToInt (String text) {
		return Integer.parseInt(text);
	}
	//等待文本控件并点击
	public void waitForTextAndClick(String text) throws UiObjectNotFoundException {
		waitForUiObject(text);
//		getUiObjectByText(text).waitForExists(10000);
		getUiObjectByText(text).clickAndWaitForNewWindow();	
	}
	//等待资源id并点击
	public void waitForResourceIdAndClick(String id) throws UiObjectNotFoundException {
		waitForUiObject(id);
		getUiObjectByText(id).clickAndWaitForNewWindow();	
	}
	//等待desc并点击
	public void waitForDescAndClick(String desc) throws UiObjectNotFoundException {
		waitForUiObject(desc);
		getUiObjectByText(desc).clickAndWaitForNewWindow();	
	}
	//等待classname并点击
	public void waitForClassNameAndClick(String name, boolean key) throws UiObjectNotFoundException {
		if (key) {
			Date start = new Date();
			waitForUiObject(name);
			getUiObjectByText(name).clickAndWaitForNewWindow();
			Date end = new Date();
			long time = (start.getTime() - end.getTime())/1000;
			outputNotable("寻找"+name+"控件共用去"+time+"秒！");
		}else{
			waitForUiObject(name);
			getUiObjectByText(name).clickAndWaitForNewWindow();
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
