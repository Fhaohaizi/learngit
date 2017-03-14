package student;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.android.uiautomator.core.Configurator;
import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

import android.graphics.Point;//设置数组
import jp.jun_nama.test.utf7ime.helper.Utf7ImeHelper;

@SuppressWarnings({ "deprecation" })
public class ClassBase extends UiAutomatorTestCase{
	public static void main(String[] args){//debug调试
		//new UiAutomatorHelper("Demo", "com.Test", "testDemo", "1");
		    String jarName,testClass, testName,androidId;  
		    jarName="test";//生成的jar包名  
		    testClass="com.WholeMethod";//测试包名类名
		    testName="testDemo";//调试方法名  
		    androidId="1";//对应androidSDK版本  
		    new UiAutomatorHelper(jarName, testClass, testName, androidId);  
	}
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
	public void screenshot() {//截图并命名为当前时间
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
	public UiObject getUiObjectByResourceId(String id) {
		return new UiObject(new UiSelector().resourceId(id));
	}
	public UiObject getUiObjectByTextClassName(String text,String classname) {//通过文本和类名获取控件
		return new UiObject(new UiSelector().text(text).className(classname));
	}
	//根据资源id获取控件
	public UiObject getUiObjectByTextResourceId(String text, String id) {
		return new UiObject(new UiSelector().text(text).resourceId(id));
	}
	//根据资源id和classname获取控件
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
	public void writeText(String text) throws UiObjectNotFoundException{//输入文字
		getUiObjectByClassName("android.widget.EditText").setText(Utf7ImeHelper.e(text));
	}
	public void showAnalysis() throws UiObjectNotFoundException {//查看解析
		getUiObjectByText("查看解析").click();
		UiObject close = new UiObject(new UiSelector().text("收起解析"));
		if (close.exists()) {
			UiObject answer = new UiObject(new UiSelector().descriptionStartsWith("答案"));
			if (!answer.exists()) {
				outputNotable("show analysis fail !");
			}
		}else {
			outputNotable("show analysis fail !");
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
				outputNotable(text + "超过10秒没有出现！");
				fail();
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
	public UiScrollable getUiScrollabe() {//获取滚动控件
		return new UiScrollable(new UiSelector().scrollable(true));
	}
	public UiScrollable getUiScrollableByResourceId(String id) {//输出滚动对象的第N个
		return new UiScrollable(new UiSelector().scrollable(true).resourceId(id));
	}
	public void outputQuesionNum() throws UiObjectNotFoundException {//输出试题数量
		UiScrollable choose = new UiScrollable(new UiSelector().resourceId("com.dianzhi.student:id/recyclerView_subject_choose"));
		choose.setAsHorizontalList();
		choose.flingToEnd(5);
		UiObject nums = getUiScrollableByResourceId("com.dianzhi.student:id/recyclerView_subject_choose").getChildByInstance(new UiSelector().resourceId("com.dianzhi.student:id/tv_item_nums"), 3);
		outputNotable("本试卷共"+nums.getText()+"道试题！");
	}
	public UiObject getUiObjectByResourIdIndex(String id, int index) {//通过ID和index获取控件
		return new UiObject(new UiSelector().resourceId(id).index(index));
		
	}
	public void outputBegin(String text) {//输出开始
		System.out.println(text+"------开始！");
	}
	public void outputOver(String text) {//输出结束
		System.out.println(text+"------结束！");
	}
	public void outputNotable(String text) {//明显输出
//		System.out.println("***********************");
		System.out.println("^_^..-. ...- "+text+"..-. ...- ^_^");
//		System.out.println("***********************");
	}
	public void outputNotable(long num) {//方法重载
		System.out.println("========"+num+"========");
	}
	public void pressTimes(int keyCode, int times) {//对于一个按键按多次
		for(int i=0;i<times;i++){
			UiDevice.getInstance().pressKeyCode(keyCode);
		}
	}
	public void clickPiont(int x, int y) {//点击某一个点
		UiDevice.getInstance().click(x, y);
	}
	public void clean() throws UiObjectNotFoundException {//一键加速
		UiDevice.getInstance().pressHome();
		sleep(500);
		UiDevice.getInstance().openQuickSettings();
		getUiObjectByTextResourceId("一键清理", "com.android.systemui:id/statebutton3").click();
		sleep(500);
	}
	public void clickCenter() {//点击屏幕中央
		int x = UiDevice.getInstance().getDisplayWidth();
		int y = UiDevice.getInstance().getDisplayHeight();
		clickPiont(x/2, y/2);
	}
	public void getTrust() throws UiObjectNotFoundException {//一键信任应用
		UiDevice.getInstance().pressHome();
		clean();
		swipeRight();
		swipeRight();
		sleep(200);
		getUiObjectByText("安全中心").clickAndWaitForNewWindow();
		getUiObjectByText("权限隐私").clickAndWaitForNewWindow();
		getUiObjectByResourIdIndex("oppo:id/oppo_preference", 1).clickAndWaitForNewWindow();
		getUiObjectByText("按应用程序管理").clickAndWaitForNewWindow();
		getUiObjectByText("点知教育").clickAndWaitForNewWindow();
		UiObject trust = new UiObject(new UiSelector().resourceId("android:id/checkbox"));
		if (!trust.isChecked()) {
			trust.click();
			outputNotable("信任应用成功！");
		}else{
			outputNotable("已经信任该应用！");
		}
		UiDevice.getInstance().pressHome();
	}
	public void setShort() {//设置短等待
		Configurator.getInstance().setActionAcknowledgmentTimeout(750);
		}
	public void setLong() {//设置长等待
		Configurator.getInstance().setActionAcknowledgmentTimeout(1500);
		}
	public void execCmd(String cmd) {//执行cmd命令
		System.out.println("----execCmd:  " + cmd);
		try {
			Process p = Runtime.getRuntime().exec(cmd);
			// 正确输出流
			InputStream input = p.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			String line = "";
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
				saveToFile(line, "runlog.log", false);
			}
			// 错误输出流
			InputStream errorInput = p.getErrorStream();
			BufferedReader errorReader = new BufferedReader(new InputStreamReader(errorInput));
			String eline = "";
			while ((eline = errorReader.readLine()) != null) {
				System.out.println(eline);
				saveToFile(eline, "runlog.log", false);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void saveToFile(String text, String path, boolean isClose) {//保存日志
		File file = new File("runlog.log");
		BufferedWriter bf = null;
		try {
			FileOutputStream outputStream = new FileOutputStream(file, true);
			OutputStreamWriter outWriter = new OutputStreamWriter(outputStream);
			bf = new BufferedWriter(outWriter);
			bf.append(text);
			bf.newLine();
			bf.flush();

			if (isClose) {
				bf.close();
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

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
