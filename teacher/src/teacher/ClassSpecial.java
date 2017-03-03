package teacher;

import java.util.Date;
import java.util.Random;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;

import android.view.KeyEvent;

@SuppressWarnings({ "deprecation" })
public class ClassSpecial extends ClassBase{
	public void judge() {//检查试题类型
		UiObject b = new UiObject(new UiSelector().className("android.widget.EditText"));
		UiObject c = new UiObject(new UiSelector().description("画布作答 Link"));
		UiObject d = new UiObject(new UiSelector().description("拍照上传 Link"));
		if(b.exists() && c.exists() && d.exists()){
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
	public void login() throws UiObjectNotFoundException{//登录app
		setShort();
		getUiObjextByResourceId("com.dianzhi.teacher.school:id/et_user").setText("18871170065");
		getUiObjextByResourceId("com.dianzhi.teacher.school:id/et_pwd").setText("111111");
		getUiObjectByTextResourceId("登录", "com.dianzhi.teacher.school:id/login").clickAndWaitForNewWindow();
		waitForUiObject("首页");
		outputNotable("登录完成！");
		setLong();
	}	
	public void logout() throws UiObjectNotFoundException{//退出app
		getUiObjectByTextResourceId("我", "com.dianzhi.teacher.school:id/activity_main_rb_my").click();
		getUiScrollabe().getChildByText(new UiSelector().text("设置"), "设置").clickAndWaitForNewWindow();
		getUiObjectByText("退出").clickAndWaitForNewWindow();
	}	
	public void checkLog() throws UiObjectNotFoundException{//检查登录立即登录
		setShort();
		boolean log = true;
		while(log){
			UiObject me = new UiObject(new UiSelector().text("我"));
			if (me.exists()) {//检查是否登录
				outputNotable("已经登录了！");
				log = false;
			}else{
				UiObject login = new UiObject(new UiSelector().resourceId("com.dianzhi.teacher.school:id/et_user"));
			if (login.exists()) {//检查是否进入登录界面
				login();//执行登录方法
				Date start = new Date();
				UiObject me1 = new UiObject(new UiSelector().text("我"));
				while(!me1.exists()){//等待进入首页
					sleep(100);
					Date now = new Date();
					long x = now.getTime() - start.getTime();
					if (x>10000) {//超时提醒失败
						outputNotable("登录失败！");
						break;
					}
				}
			}
			}
		}
		setLong();
	}
	public void sendMassageToOne() throws UiObjectNotFoundException {//给固定好友发送消息
		setShort();
		getUiObjectByText("消息").click();
		getUiObjectByText("通讯录").clickAndWaitForNewWindow();
		getUiScrollabe().getChildByText(new UiSelector().text("正反"), "正反").clickAndWaitForNewWindow();
		for(int i=0;i<10;i++){
			writeText("我是测试！");
			getUiObjectByText("发送").click();
			writeText(getNow());
			getUiObjectByText("发送").click();
		}
		setLong();
	}
	public void classManage() throws UiObjectNotFoundException {//进入班级管理
		setShort();
		getUiObjectByText("首页").clickAndWaitForNewWindow();
		getUiObjectByText("班级管理").clickAndWaitForNewWindow();
		setLong();
	}
	public void searchStudenThrowTel() throws UiObjectNotFoundException {//通过手机号搜索学生
		setShort();
		getUiObjectByText("测试").clickAndWaitForNewWindow();
		getUiObjectByText("添加学生").clickAndWaitForNewWindow();
		writeText("15114668551");
		UiDevice.getInstance().pressEnter();
		String tel = getUiObjextByResourceId("com.dianzhi.teacher.school:id/tel").getText();//获取当年显示账号的手机号
		assertEquals("查找学生失败！", "15114668551", tel);//检查是否是是想要的账号
		outputNotable("查找学生成功！");
		getUiObjectByText("拉进班级").clickAndWaitForNewWindow();
		setLong();
	}
	public void createClass() throws UiObjectNotFoundException {//添加班级
		setShort();
		getUiObjectByText("添加班级").clickAndWaitForNewWindow();
		writeText("测试");
		getUiObjectByText("确定").clickAndWaitForNewWindow();
		String newclassname = getUiObjectByText("该班级还没有学生,请添加学生").getFromParent(new UiSelector().resourceId("com.dianzhi.teacher.school:id/name")).getText();
		assertEquals("创建班级失败！", "测试", newclassname);
		outputNotable("创建班级成功！");
		setLong();
	}
	public void deleteClass() throws UiObjectNotFoundException {//删除班级
		setShort();
		int num = getUiObjextByResourceId("com.dianzhi.teacher.school:id/lv").getChildCount();
		getUiObjextByResourceId("com.dianzhi.teacher.school:id/lv").getChild(new UiSelector().index(num-1)).getChild(new UiSelector().resourceId("com.dianzhi.teacher.school:id/open_or_close_iv")).clickAndWaitForNewWindow();
		getUiObjectByText("删除").clickAndWaitForNewWindow();
		getUiObjectByText("确定").clickAndWaitForNewWindow();
		int newnum = getUiObjextByResourceId("com.dianzhi.teacher.school:id/lv").getChildCount();
		if(num-newnum == 1){
			outputNotable("删除班级成功！");
		}else{
			outputNotable("删除班级失败！");
			}
		setLong();
	}
	public void addStudentIntoClass() throws UiObjectNotFoundException {//从通讯录添加学生
		getUiObjectByText("添加学生").clickAndWaitForNewWindow();
		getUiObjectByText("通讯录添加").clickAndWaitForNewWindow();
		getUiObjectByTextResourceId("保密", "com.dianzhi.teacher.school:id/sex").getFromParent(new UiSelector().className("android.widget.LinearLayout").index(3)).click();
		UiObject success = new UiObject(new UiSelector().text("添加成功"));
		if (success.exists()) {
			outputNotable("添加学生成功！");
		}else{
			outputNotable("添加学生失败！");
		}
		UiDevice.getInstance().pressBack();
	}
	public void remarkStudentInfo() throws UiObjectNotFoundException {//随机输入学生备注信息
		getUiObjectByText("15114668551").clickAndWaitForNewWindow();
		getUiObjectByText("请输入备注信息..").clickAndWaitForNewWindow();
		writeText("我是测试");
		getUiObjectByText("保存").clickAndWaitForNewWindow();
		String remark = getUiObjextByResourceId("com.dianzhi.teacher.school:id/remark").getText();
		assertEquals("修改备注信息失败！", "我是测试", remark);
		outputNotable("修改备注信息成功！");
		UiDevice.getInstance().pressBack();
		UiDevice.getInstance().pressBack();
	}
	public void checkClassNum() throws UiObjectNotFoundException {//检查班级人数
		String studentnum = getUiObjectByText("测试").getFromParent(new UiSelector().resourceId("com.dianzhi.teacher.school:id/student_count_tv")).getText();
		assertEquals("添加学生失败！", "共2名学生", studentnum);
		outputNotable("添加学生成功！");
	}
	public void alterClassInfo() throws UiObjectNotFoundException {//修改班级信息
		setShort();
		getUiObjextByResourceId("com.dianzhi.teacher.school:id/open_or_close_iv").clickAndWaitForNewWindow();
		getUiObjectByText("设置").clickAndWaitForNewWindow();
		getUiObjextByResourceId("com.dianzhi.teacher.school:id/set_class_room_info_tv").clickAndWaitForNewWindow();
		int num = new Random().nextInt(100);
		String info = "info" + num;
		writeText(info);
		getUiObjectByText("完成").clickAndWaitForNewWindow();	
		getUiObjectByText("保存").clickAndWaitForNewWindow();
		getUiObjectByText("设置").clickAndWaitForNewWindow();
		String classInfo = getUiObjextByResourceId("com.dianzhi.teacher.school:id/set_class_room_info_tv").getText();
		assertEquals("修改班级简介失败！", info, classInfo);
		outputNotable("修改班级简介成功！");
		UiDevice.getInstance().pressBack();
		getUiObjextByResourceId("com.dianzhi.teacher.school:id/open_or_close_iv").clickAndWaitForNewWindow();	
		setLong();
	}
	public void setBackground() throws UiObjectNotFoundException {//随机修改首页背景
		setShort();
		getUiObjectByText("首页").click();
		getUiObjextByResourceId("com.dianzhi.teacher.school:id/choose_theme").click();
		int num = new Random().nextInt(6);
		switch (num) {
		case 0:
			getUiObjectByText("默认").click();
			break;
		case 1:
			getUiObjectByText("蓝色").click();
			break;
		case 2:
			getUiObjectByText("绿色").click();
			break;
		case 3:
			getUiObjectByText("桂林印象").click();
			break;
		case 4:
			getUiObjectByText("流金岁月").click();
			break;
		case 5:
			getUiObjectByText("流金岁月").click();
			break;
		default:
			outputNotable("选择背景失败!");
			break;
		}
		setLong();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
