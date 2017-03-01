package student;

import java.util.Date;

import com.android.uiautomator.core.Configurator;
import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;

@SuppressWarnings({ "deprecation" })
public class ClassSpecial extends ClassBase{
	public void judge() {//检查试题类型
		UiObject b = new UiObject(new UiSelector().className("android.widget.EditText"));
		UiObject c = new UiObject(new UiSelector().description("画布作答 Link"));
		UiObject d = new UiObject(new UiSelector().description("拍照上传 Link"));
		if(b.exists() && c.exists() && d.exists() || b.exists()){
			System.out.println("this is a Subjective questions");
			}else{
				System.out.println("this is a Objective questions");
				}
		}
	public void waitForRefresh() {//等待刷新出题
		Date time1 = new Date();
		UiObject a = new UiObject(new UiSelector().className("android.webkit.WebView"));
 	    while(!a.exists()){
 	    	UiObject b = new UiObject(new UiSelector().className("android.webkit.WebView"));
 	    	if(!b.exists()){
 	    		sleep(200);
 	    		}
 	    	}
		Date time2 = new Date();
		long differ = (time2.getTime() - time1.getTime())/1000;
		System.out.println("it runs for"+differ+"s");
	}
	public void exitHomework() {//退出练习
		swipeLeft();
		UiDevice.getInstance().pressBack();
		UiObject sure =new UiObject(new UiSelector().text("确定"));		
		try {
			sure.click();
		} catch (UiObjectNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("exit successfully");
	}
	public void again() {//再来一批
		swipeRight();
		UiObject again = new UiObject(new UiSelector().text("再来一批"));
		try {
			again.click();
		} catch (UiObjectNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("do again successfully");
	}
	public void challenge() {//挑战主观题
		swipeRight();
		UiObject challage= new UiObject(new UiSelector().text("挑战主观题"));
		if(challage.exists()){
			try {
				challage.clickAndWaitForNewWindow();
			} catch (UiObjectNotFoundException e) {
				e.printStackTrace();
			}
			System.out.println("do challage successfully");
			check();
		    again();
		    check();
			}else{
				System.out.println("do challage failed");
			}
		}
	public void check() {//验证试题内容
			waitForRefresh();
			judge();
			swipeLeft();
			waitForRefresh();
			judge();
			swipeLeft();
			swipeLeft();
			swipeLeft();
			swipeLeft();
		}
	public void wholeCheck() {//完整的模块验证
		check();
		again();
		check();
		challenge();
		exitHomework();
		}
	public void login() throws UiObjectNotFoundException{//登录app
		setShort();
		getUiObjextByResourceId("com.dianzhi.student:id/activity_login_et_username").setText("15515639397");
		getUiObjextByResourceId("com.dianzhi.student:id/activity_login_et_pwd").setText("111111");
		getUiObjectByTextResourceId("登录", "com.dianzhi.student:id/user_login_complete").clickAndWaitForNewWindow();
		setLong();
	}	
	public void logout() throws UiObjectNotFoundException{//退出app
		getUiObjectByTextResourceId("我的", "com.dianzhi.student:id/home_rb_my").click();
		getUiScrollabe().getChildByText(new UiSelector().text("设置"), "设置").clickAndWaitForNewWindow();
		getUiObjectByText("退出").clickAndWaitForNewWindow();
	}	
	public void outputTutorTime() throws UiObjectNotFoundException {//输出辅导时间
		getUiObjectByDesc("more_btn").click();
		UiObject a = new UiObject(new UiSelector().descriptionMatches("用时[0-9]*时[0-9]*分"));
		System.out.println(a.exists());
		outputNotable(a.getContentDescription());
		getUiObjectByDesc("more_btn").click();
	}
	public void exitTutor() throws UiObjectNotFoundException{//退出辅导
		UiDevice.getInstance().pressBack();
		getUiObjectByDesc("确认").clickAndWaitForNewWindow();
	}
	public void sendMessageOnTutor(String text, int times) throws UiObjectNotFoundException{//发送文字
		for(int i=0;i<times;i++){
			getUiObjectByText("请输入内容...").click();
			getUiObjectByText("请输入内容...").setText(text);
			getUiObjectByDesc("发送").click();
		}
	}
	public void checkLog() throws UiObjectNotFoundException{//检查登录立即登录
		getUiObjectByTextClassName("我的", "android.widget.RadioButton").clickAndWaitForNewWindow();
		UiObject personalInformation = new UiObject(new UiSelector().text("个人资料 > ").className("android.widget.TextView"));
		if (personalInformation.exists()) {
			outputNotable("已经登录！");
		}else{
			login();
			Date start = new Date();
			UiObject personalInformation1 = new UiObject(new UiSelector().text("个人资料 > ").className("android.widget.TextView"));
			while(!personalInformation1.exists()) {
				sleep(100);
				Date now = new Date();
				long x = now.getTime() - start.getTime();
				if (x>10000) {
					outputNotable("登录失败！");
					fail();
				}
			}
			outputNotable("登录成功！");
		}
	}
	public void sendMassageToOne() throws UiObjectNotFoundException {//给固定好友发送消息
		getUiObjectByText("消息").click();
		getUiObjectByText("通讯录").clickAndWaitForNewWindow();
		getUiScrollabe().getChildByText(new UiSelector().text("正反"), "正反").clickAndWaitForNewWindow();
		Configurator.getInstance().setActionAcknowledgmentTimeout(500);
		for(int i=0;i<10;i++){
			writeText("我是测试！");
			getUiObjectByText("发送").click();
			writeText(getNow());
			getUiObjectByText("发送").click();
		}
		Configurator.getInstance().setActionAcknowledgmentTimeout(1500);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
