package mytest;

import java.io.IOException;
import java.util.Date;
import java.util.Random;

import com.android.uiautomator.core.Configurator;
import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.core.UiWatcher;

import android.view.KeyEvent;
import jp.jun_nama.test.utf7ime.helper.Utf7ImeHelper;

@SuppressWarnings({ "deprecation" })
public class ClassCase extends ClassSpecial{
	public void alterHomeAdress() throws UiObjectNotFoundException {//修改家庭地址
		getUiObjectByText("个人资料 > ").clickAndWaitForNewWindow();
		String adress = getUiObjextByResourceId("com.dianzhi.student:id/person_address_tv").getText();
		getUiObjectByText("家庭住址:").clickAndWaitForNewWindow();
		pressTimes(KeyEvent.KEYCODE_DEL, 6);
		int a = new Random().nextInt(120);
		if (a<40 && a >= 0) {
			writeText("测试一");
			getUiObjectByText("完成").clickAndWaitForNewWindow();
			if (adress == "测试一"){
				UiDevice.getInstance().pressBack();
			}else{
				getUiObjectByText("保存").clickAndWaitForNewWindow();
			}			
			getUiObjectByText("个人资料 > ").clickAndWaitForNewWindow();
			String newadress =  getUiObjextByResourceId("com.dianzhi.student:id/person_address_tv").getText();
			assertEquals("修改地址失败！", "测试一", newadress);
			outputNotable("修改地址成功！");
			UiDevice.getInstance().pressBack();
		}else if (a<80 && a >= 40) {
			writeText("测试二");
			getUiObjectByText("完成").clickAndWaitForNewWindow();
			if (adress == "测试二"){
				UiDevice.getInstance().pressBack();
			}else{
				getUiObjectByText("保存").clickAndWaitForNewWindow();
			}
			getUiObjectByText("个人资料 > ").clickAndWaitForNewWindow();
			String newadress =  getUiObjextByResourceId("com.dianzhi.student:id/person_address_tv").getText();
			assertEquals("修改地址失败！", "测试二", newadress);
			outputNotable("修改地址成功！");
			UiDevice.getInstance().pressBack();
		}else if (a<120 && a >= 80) {
			writeText("测试三");
			getUiObjectByText("完成").clickAndWaitForNewWindow();
			if (adress == "测试三"){
				UiDevice.getInstance().pressBack();
			}else{
				getUiObjectByText("保存").clickAndWaitForNewWindow();
			}
			getUiObjectByText("个人资料 > ").clickAndWaitForNewWindow();
			String newadress =  getUiObjextByResourceId("com.dianzhi.student:id/person_address_tv").getText();
			assertEquals("修改地址失败！", "测试三", newadress);
			outputNotable("修改地址成功！");
			UiDevice.getInstance().pressBack();
		} 
	}
	public void setSexRandom() throws UiObjectNotFoundException {//随机设置性别
		getUiObjectByText("个人资料 > ").clickAndWaitForNewWindow();
		String text = getUiObjextByResourceId("com.dianzhi.student:id/person_sex_tv").getText();
		getUiObjectByText("性别:").click();
		int a = new Random().nextInt(160);
		if (a<40 && a >= 0) {
			getUiObjectByText("保密").click();
			if (text == "保密"){
				UiDevice.getInstance().pressBack();
			}else{
				getUiObjectByText("保存").clickAndWaitForNewWindow();
			}			
			getUiObjectByText("个人资料 > ").clickAndWaitForNewWindow();
			assertEquals("修改性别失败！", "保密", getUiObjextByResourceId("com.dianzhi.student:id/person_sex_tv").getText());
			UiDevice.getInstance().pressBack();
		}else if (a<80 && a >= 40) {
			getUiObjectByText("男").click();
			if (text == "男"){
				UiDevice.getInstance().pressBack();
			}else{
				getUiObjectByText("保存").clickAndWaitForNewWindow();
			}
			getUiObjectByText("个人资料 > ").clickAndWaitForNewWindow();
			assertEquals("修改性别失败！", "男", getUiObjextByResourceId("com.dianzhi.student:id/person_sex_tv").getText());
			UiDevice.getInstance().pressBack();
		}else if (a<120 && a >= 80) {
			getUiObjectByText("女").click();
			if (text == "女"){
				UiDevice.getInstance().pressBack();
			}else{
				getUiObjectByText("保存").clickAndWaitForNewWindow();
			}
			getUiObjectByText("个人资料 > ").clickAndWaitForNewWindow();
			assertEquals("修改性别失败！", "女", getUiObjextByResourceId("com.dianzhi.student:id/person_sex_tv").getText());
			UiDevice.getInstance().pressBack();
		} else {
			getUiObjectByText("取消").click();
			UiDevice.getInstance().pressBack();
			getUiObjectByText("个人资料 > ").clickAndWaitForNewWindow();
			assertEquals("修改性别失败！", text, getUiObjextByResourceId("com.dianzhi.student:id/person_sex_tv").getText());
			UiDevice.getInstance().pressBack();
		}
		outputNotable("修改性别成功！");
	}
	public void findTeacher() throws UiObjectNotFoundException{//找-大老师
		UiDevice.getInstance().pressHome();
		UiDevice.getInstance().pressHome();
		clean();		
		getUiObjectByText("点知教育").clickAndWaitForNewWindow();
		outputNotable("开始了！");
		getUiObjectByText("找老师").clickAndWaitForNewWindow();
		boolean teacher = true;
		while(teacher){
			UiDevice.getInstance().swipe(500, 500, 500, 1200, 8);
			UiObject me = new UiObject(new UiSelector().text("大老师"));
			if (me.exists()) {
				me.click();
				teacher = false;
			}
		}
//		getUiObjectByText("我老师").clickAndWaitForNewWindow();
		getUiObjectByText("连线老师").clickAndWaitForNewWindow();
		getUiObjextByResourceId("com.dianzhi.student:id/takepicture").clickAndWaitForNewWindow();
		UiObject ok = new UiObject(new UiSelector().resourceId("oppo:id/OppoOptionMenuBarItemTitle"));
		while(!ok.exists()){
			sleep(200);
			}
		UiObject sure = new UiObject(new UiSelector().text("确定"));
		if (!sure.exists()) {
			int x = UiDevice.getInstance().getDisplayWidth();
			int y = UiDevice.getInstance().getDisplayHeight();
			clickPiont(x-180, y-90);
			}else{
				sure.click();
				}
		Date first = new Date();
		getUiObjectByText("连接老师").clickAndWaitForNewWindow();
		Date second = new Date();
		long differ = (second.getTime() - first.getTime())/1000;
		System.out.println("it runs for "+differ+" s");
	}
	public void photoAndAsk() throws UiObjectNotFoundException{//拍照提问
		UiDevice.getInstance().pressHome();
		UiDevice.getInstance().pressHome();
		clean();		
		getUiObjectByText("点知教育").clickAndWaitForNewWindow();
		outputNotable("开始了！");
		checkLog();
		getUiObjectByTextClassName("首页", "android.widget.RadioButton").clickAndWaitForNewWindow();
		clickCenter();
		getUiObjextByResourceId("com.dianzhi.student:id/takepicture").clickAndWaitForNewWindow();
		UiObject ok = new UiObject(new UiSelector().resourceId("oppo:id/OppoOptionMenuBarItemTitle"));
		while(!ok.exists()){
			sleep(200);
			}
		int x = UiDevice.getInstance().getDisplayWidth();
		int y = UiDevice.getInstance().getDisplayHeight();
		clickPiont(x-180, y-90);
		Configurator.getInstance().setActionAcknowledgmentTimeout(300);
		getUiObjectByText("初中").clickAndWaitForNewWindow();
		getUiObjectByText("数学").clickAndWaitForNewWindow();
		getUiObjectByText("确定").clickAndWaitForNewWindow();
		getUiObjectByText("连接老师").clickAndWaitForNewWindow();
		Configurator.getInstance().setActionAcknowledgmentTimeout(1000);
		
	}
	public void alterName() throws UiObjectNotFoundException{//修改名字
		getUiObjectByText("个人资料 > ").clickAndWaitForNewWindow();
		String name = getUiObjextByResourceId("com.dianzhi.student:id/person_username_tv").getText();
		getUiObjectByText("学生:").clickAndWaitForNewWindow();
		pressTimes(KeyEvent.KEYCODE_DEL, 6);
		
		int a = new Random().nextInt(120);
		if (a<40 && a >= 0) {
			writeText("测试一");
			getUiObjectByText("完成").clickAndWaitForNewWindow();
			if (name == "测试一"){
				UiDevice.getInstance().pressBack();
			}else{
				getUiObjectByText("保存").clickAndWaitForNewWindow();
			}			
			getUiObjectByText("个人资料 > ").clickAndWaitForNewWindow();
			String newname =  getUiObjextByResourceId("com.dianzhi.student:id/person_username_tv").getText();
			assertEquals("修改名字失败！", "测试一", newname);
			outputNotable("修改名字成功！");
			UiDevice.getInstance().pressBack();
		}else if (a<80 && a >= 40) {
			writeText("测试二");
			getUiObjectByText("完成").clickAndWaitForNewWindow();
			if (name == "测试二"){
				UiDevice.getInstance().pressBack();
			}else{
				getUiObjectByText("保存").clickAndWaitForNewWindow();
			}
			getUiObjectByText("个人资料 > ").clickAndWaitForNewWindow();
			String newname =  getUiObjextByResourceId("com.dianzhi.student:id/person_username_tv").getText();
			assertEquals("修改名字失败！", "测试二", newname);
			outputNotable("修改名字成功！");
			UiDevice.getInstance().pressBack();
		}else if (a<120 && a >= 80) {
			writeText("测试三");
			getUiObjectByText("完成").clickAndWaitForNewWindow();
			if (name == "测试三"){
				UiDevice.getInstance().pressBack();
			}else{
				getUiObjectByText("保存").clickAndWaitForNewWindow();
			}
			getUiObjectByText("个人资料 > ").clickAndWaitForNewWindow();
			String newname =  getUiObjextByResourceId("com.dianzhi.student:id/person_username_tv").getText();
			assertEquals("修改名字失败！", "测试三", newname);
			outputNotable("修改名字成功！");
			UiDevice.getInstance().pressBack();
		} 
	}
	public void BuyCardTimes(String text, int times) throws UiObjectNotFoundException{//连续购买课时卡
		for(int t=0;t<times;t++){
			outputNotable("第"+(t+1)+"次开始！");
			getUiScrollabe().getChildByText(new UiSelector().text(text), text).clickAndWaitForNewWindow();
			getUiObjectByText("钱包支付").clickAndWaitForNewWindow();
			getUiObjectByText("自己支付").clickAndWaitForNewWindow();
			sleep(200);
			for(int i=0;i<6;i++){
				clickPiont(200, 1200);
				sleep(100);
				}
			sleep(200);
			getUiObjectByText("完成").clickAndWaitForNewWindow();	
			}
	}
	public void photoOrFindTutor() throws UiObjectNotFoundException{//拍照提问&找老师
		photoAndAsk();
		//findTeacher();
		Date newstart = new Date();
		boolean in = true;
		while(in){
			Date now = new Date();
			long differ = (now.getTime()-newstart.getTime())/1000;
			if(differ>60){
				fail();
			}
			UiObject more_btn = new UiObject(new UiSelector().description("more_btn"));
			if (more_btn.exists()) {
				in = false;
			}
		}
		Date start = new Date();
		outputBegin(getNow());
		boolean time = true;
		while(time){
			Date now = new Date();
			sendMessageOnTutor("Happy New Year!", 1);
			sendMessageOnTutor(getNow(), 1);
			long differ = (now.getTime()-start.getTime())/1000;
			if(differ>600){
				time = false;
			}
		}
		outputOver(getNow());
		exitTutor();
		
	}
	public void timing(long second) throws UiObjectNotFoundException{//定时辅导
		findTeacher();
		boolean in = true;
		while(in){
			UiObject more_btn = new UiObject(new UiSelector().description("more_btn"));
			if (more_btn.exists()) {
				in = false;
			}
		}
		Date start = new Date();
		outputBegin(getNow());
		boolean time = true;
		while(time){
			Date now = new Date();
			sendMessageOnTutor("Happy New Year!", 3);
			long differ = (now.getTime()-start.getTime())/1000;
			if(differ>second){
				time = false;
			}
		}
		outputOver(getNow());
		exitTutor();
	}
	public void photoAndAskTimes() throws UiObjectNotFoundException {//连续拍照提问
		startApp();
		checkLog();
		logout();
		for(int t=0;t<10;t++){
			outputNotable("第"+(t+1)+"次开始！");
			findTeacher();
			login();
			getUiObjectByText("连接老师").clickAndWaitForNewWindow();
			sleep(2000);
			getUiObjectByText("取消").clickAndWaitForNewWindow();
			UiDevice.getInstance().pressBack();
			UiDevice.getInstance().pressBack();
			logout();
			}
		}
	public void startApp() throws UiObjectNotFoundException {//启动app
		UiDevice.getInstance().pressHome();
		UiDevice.getInstance().pressHome();
		clean();		
		getUiObjectByText("点知教育").clickAndWaitForNewWindow();
		outputNotable("app启动了！");
	}
	public void alterPassWord() throws UiObjectNotFoundException {//修改密码再改回来
		getUiScrollabe().getChildByText(new UiSelector().text("设置"), "设置").clickAndWaitForNewWindow();
		getUiObjectByText("修改密码").clickAndWaitForNewWindow();
		writeText("222222");
		getUiObjectByText("下一步").clickAndWaitForNewWindow();
		long word = new Random().nextInt(900000)+100000;
		String password = "" + word;
		outputNotable(password);
		getUiObjextByResourceId("com.dianzhi.student:id/ed_password__password_change").setText(Utf7ImeHelper.e(password));
		getUiObjextByResourceId("com.dianzhi.student:id/ed_esure_p_password_password_change").setText(Utf7ImeHelper.e(password));
		getUiObjectByText("完成").clickAndWaitForNewWindow();
		getUiObjectByText("我的").clickAndWaitForNewWindow();
		getUiObjextByResourceId("com.dianzhi.student:id/activity_login_et_pwd").setText(password);
		getUiObjectByTextResourceId("登录", "com.dianzhi.student:id/user_login_complete").clickAndWaitForNewWindow();
		getUiObjectByText("我的").clickAndWaitForNewWindow();
		getUiScrollabe().getChildByText(new UiSelector().text("设置"), "设置").clickAndWaitForNewWindow();
		getUiObjectByText("修改密码").clickAndWaitForNewWindow();
		writeText(password);
		getUiObjectByText("下一步").clickAndWaitForNewWindow();
		getUiObjextByResourceId("com.dianzhi.student:id/ed_password__password_change").setText(Utf7ImeHelper.e("222222"));
		getUiObjextByResourceId("com.dianzhi.student:id/ed_esure_p_password_password_change").setText(Utf7ImeHelper.e("222222"));
		getUiObjectByText("完成").clickAndWaitForNewWindow();
		login();
	}
	public void qqPraise() throws IOException, UiObjectNotFoundException, InterruptedException {
		//关闭QQ
		Runtime.getRuntime().exec("am force-stop com.tencent.mobileqq");
		sleep(1000);
		//启动QQ
		Runtime.getRuntime().exec("am start -n com.tencent.mobileqq/.activity.SplashActivity");
		waitForUiObject("消息");//等待主页面加载
		swipeRight();//进入右滑页面
		//点赞
		praiseToMe();
		for(int i=0;i<8;i++){
			changeQQAccount();
			praiseToMe();
		}
		//关闭QQ,如果运行中想结束得加上waitfor();
		Runtime.getRuntime().exec("am force-stop com.tencent.mobileqq").waitFor();
	}
	
	
	public void testTest() throws UiObjectNotFoundException {
  		getUiDevice().registerWatcher("Jurisdiction watcher",new UiWatcher(){//监听权限警告
			UiObject warrning = new UiObject(new UiSelector().text("安全警告"));			
			@Override
			public boolean checkForCondition(){	
				if(warrning.exists()){
					System.out.println("the first watcher is begin !");
					UiObject noremind = new UiObject(new UiSelector().text("不再提醒"));
					try {
						noremind.click();
						} catch (UiObjectNotFoundException e1) {
							e1.printStackTrace();
							}
					UiObject allow = new UiObject(new UiSelector().text("允许"));
					try {
						allow.click();
						} catch (UiObjectNotFoundException e2) {
							e2.printStackTrace();
							}
					System.out.println("it is allow");
					return true;}
				System.out.println("the first watcher is not run");
				return false;}});
		getUiDevice().registerWatcher("no challenge watcher",new UiWatcher(){//监听未发现主观题
			UiObject resolution = new UiObject(new UiSelector().text("查看全部解析"));			
			@Override
			public boolean checkForCondition(){
				if(resolution.exists()){
					System.out.println("the second watcher is begin !");
					UiDevice.getInstance().pressBack();
					UiDevice.getInstance().pressBack();
				    UiObject remind = new UiObject(new UiSelector().text("是否确定结束做题?"));
				 	    while(!remind.exists()){//如果不存在
				 	    	UiObject remind1 = new UiObject(new UiSelector().text("是否确定结束做题?"));
				 	    	if(!remind1.exists()){//如果还不存在
				 	    		sleep(100);//等待200ms
				 	    		}
				 	    	}
					UiObject sure = new UiObject(new UiSelector().text("不再提醒"));
					try {
						sure.click();
					} catch (UiObjectNotFoundException e) {
						e.printStackTrace();
					}
					System.out.println("the secong watcher is done");
					return true;}
				System.out.println("the second watcher is not find");
				return false;}});
		getUiDevice().registerWatcher("error", new UiWatcher() {//崩溃监听
			UiObject reboot = new UiObject(new UiSelector().text("错误详情"));
			UiObject error =  new UiObject(new UiSelector().text("重新启动"));
			@Override
			public boolean checkForCondition() {
				if(reboot.exists() && error.exists()){
					System.out.println("this is serious error");
					try {
						error.clickAndWaitForNewWindow();
					} catch (UiObjectNotFoundException e) {
						e.printStackTrace();
					}
					UiObject details = new UiObject(new UiSelector().text("Error details"));
					UiObject copy = new UiObject(new UiSelector().text("Copy to clipboard"));
					if (details.exists() && copy.exists()) {
						try {
							copy.clickAndWaitForNewWindow();
						} catch (UiObjectNotFoundException e) {
							e.printStackTrace();
						}
						UiObject detailstext = new UiObject(new UiSelector().resourceId("android:id/message").className("android.widget.TextView"));
						try {
							System.out.println(detailstext.getText());
						} catch (UiObjectNotFoundException e) {
							e.printStackTrace();
						}
						System.out.println("copy successfully !");
						return true;}}
				System.out.println("copy failed");
				return false;}});

	
	}
}
