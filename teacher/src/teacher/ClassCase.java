package teacher;

import java.util.Random;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.core.UiWatcher;

import android.view.KeyEvent;
import jp.jun_nama.test.utf7ime.helper.Utf7ImeHelper;

@SuppressWarnings({ "deprecation" })
public class ClassCase extends ClassSpecial{
	public void alterUniversity() throws UiObjectNotFoundException {//修改毕业院校
		setShort();
		getUiObjectByText("个人资料 > ").clickAndWaitForNewWindow();
		getUiObjectByText("毕业院校:").clickAndWaitForNewWindow();
		int num = new Random().nextInt(100);
		String info = "info" + num;
		writeText(info);
		getUiObjectByText("完成").clickAndWaitForNewWindow();
		getUiObjectByText("保存").clickAndWaitForNewWindow();
		getUiObjectByText("个人资料 > ").clickAndWaitForNewWindow();
		String university = getUiObjextByResourceId("com.dianzhi.teacher.school:id/ed_school_my_infomation_activity").getText();
		assertEquals("修改毕业院校失败！", info, university);
		outputNotable("修改毕业院校成功！");
		UiDevice.getInstance().pressBack();
		setLong();		
	}
	public void alterIntroduction() throws UiObjectNotFoundException {//修改简介
		setShort();
		getUiObjectByText("个人资料 > ").clickAndWaitForNewWindow();
		getUiScrollabe().getChildByText(new UiSelector().text("简介:"), "简介:").clickAndWaitForNewWindow();
		int num = new Random().nextInt(100);
		String info = "info" + num;
		writeText(info);
		getUiObjectByText("完成").clickAndWaitForNewWindow();
		getUiObjectByText("保存").clickAndWaitForNewWindow();
		getUiObjectByText("个人资料 > ").clickAndWaitForNewWindow();
		String specialty = getUiScrollabe().getChildByText(new UiSelector().text("简介:"), "简介:").getFromParent(new UiSelector().resourceId("com.dianzhi.teacher.school:id/ed_rmarks_my_infomation_activity")).getText();
		assertEquals("修改简介失败！", info, specialty);
		outputNotable("修改简介成功！");
		UiDevice.getInstance().pressBack();
		setLong();
	}
	public void alterTeachingFeature() throws UiObjectNotFoundException {//修改教学特点
		setShort();
		getUiObjectByText("个人资料 > ").clickAndWaitForNewWindow();
		getUiScrollabe().getChildByText(new UiSelector().text("教学特点:"), "教学特点:").clickAndWaitForNewWindow();
		int num = new Random().nextInt(100);
		String info = "info" + num;
		writeText(info);
		getUiObjectByText("完成").clickAndWaitForNewWindow();
		getUiObjectByText("保存").clickAndWaitForNewWindow();
		getUiObjectByText("个人资料 > ").clickAndWaitForNewWindow();
		String specialty = getUiScrollabe().getChildByText(new UiSelector().text("教学特点:"), "教学特点:").getFromParent(new UiSelector().resourceId("com.dianzhi.teacher.school:id/ed_characteristic_my_infomation_activity")).getText();
		assertEquals("修改教学特点失败！", info, specialty);
		outputNotable("修改教学特点成功！");
		UiDevice.getInstance().pressBack();
		setLong();
	}
	public void alterSpecialty() throws UiObjectNotFoundException {//修改专业
		setShort();
		getUiObjectByText("个人资料 > ").clickAndWaitForNewWindow();
		getUiScrollabe().getChildByText(new UiSelector().text("专业:"), "专业:").clickAndWaitForNewWindow();
		int num = new Random().nextInt(100);
		String info = "info" + num;
		writeText(info);
		getUiObjectByText("完成").clickAndWaitForNewWindow();
		getUiObjectByText("保存").clickAndWaitForNewWindow();
		getUiObjectByText("个人资料 > ").clickAndWaitForNewWindow();
		String specialty = getUiScrollabe().getChildByText(new UiSelector().text("专业:"), "专业:").getFromParent(new UiSelector().resourceId("com.dianzhi.teacher.school:id/ed_study_field_my_infomation_activity")).getText();
		assertEquals("修改专业失败！", info, specialty);
		outputNotable("修改专业成功！");
		UiDevice.getInstance().pressBack();
		setLong();
	}
	public void setSex() throws UiObjectNotFoundException {//随机设置性别
		setShort();
		getUiObjectByText("个人资料 > ").clickAndWaitForNewWindow();
		String education = getUiObjextByResourceId("com.dianzhi.teacher.school:id/tv_sex_text_my_infomation_activity").getText();
		getUiObjectByText("性别:").clickAndWaitForNewWindow();
		int num = new Random().nextInt(4);
		switch (num) {
		case 0:	
			getUiObjectByText("保密").clickAndWaitForNewWindow();
			getUiObjectByText("保存").clickAndWaitForNewWindow();
			getUiObjectByText("个人资料 > ").clickAndWaitForNewWindow();
			String sex0 = getUiObjextByResourceId("com.dianzhi.teacher.school:id/tv_sex_text_my_infomation_activity").getText();
			assertEquals("修改性别失败！", "保密", sex0);
			outputNotable("修改性别成功！");
			break;
		case 1:
			getUiObjectByText("男").clickAndWaitForNewWindow();
			getUiObjectByText("保存").clickAndWaitForNewWindow();
			getUiObjectByText("个人资料 > ").clickAndWaitForNewWindow();
			String sex1 = getUiObjextByResourceId("com.dianzhi.teacher.school:id/tv_sex_text_my_infomation_activity").getText();
			assertEquals("修改性别失败！", "男", sex1);
			outputNotable("修改性别成功！");
			break;
		case 2:
			getUiObjectByText("女").clickAndWaitForNewWindow();
			getUiObjectByText("保存").clickAndWaitForNewWindow();
			getUiObjectByText("个人资料 > ").clickAndWaitForNewWindow();
			String sex2 = getUiObjextByResourceId("com.dianzhi.teacher.school:id/tv_sex_text_my_infomation_activity").getText();
			assertEquals("修改性别失败！", "女", sex2);
			outputNotable("修改性别成功！");
			break;
		case 3:
			getUiObjectByText("取消").clickAndWaitForNewWindow();
			getUiObjectByText("保存").clickAndWaitForNewWindow();
			getUiObjectByText("个人资料 > ").clickAndWaitForNewWindow();
			String neweducation = getUiObjextByResourceId("com.dianzhi.teacher.school:id/tv_sex_text_my_infomation_activity").getText();
			assertEquals("修改性别失败！", education, neweducation);
			outputNotable("修改性别成功！");
			break;
		default:
			outputNotable("修改性别失败！");
			break;
		}
		UiDevice.getInstance().pressBack();
		setLong();
	}
	public void alterName() throws UiObjectNotFoundException{//修改名字
		setShort();
		getUiObjectByText("我").clickAndWaitForNewWindow();
		getUiObjectByText("个人资料 > ").clickAndWaitForNewWindow();
		String name = getUiObjextByResourceId("com.dianzhi.teacher.school:id/ed_name_my_infomation_activity").getText();
		getUiObjectByText("老师:").clickAndWaitForNewWindow();
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
			String newname =  getUiObjextByResourceId("com.dianzhi.teacher.school:id/ed_name_my_infomation_activity").getText();
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
			String newname =  getUiObjextByResourceId("com.dianzhi.teacher.school:id/ed_name_my_infomation_activity").getText();
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
			String newname =  getUiObjextByResourceId("com.dianzhi.teacher.school:id/ed_name_my_infomation_activity").getText();
			assertEquals("修改名字失败！", "测试三", newname);
			outputNotable("修改名字成功！");
			UiDevice.getInstance().pressBack();
		} 
		setLong();
	}
	public void alterTeachAge() throws UiObjectNotFoundException {//修改教龄
		setShort();
		getUiObjectByText("个人资料 > ").clickAndWaitForNewWindow();
		getUiObjectByText("教龄:").clickAndWaitForNewWindow();
		int num = new Random().nextInt(100);
		String age = ""+num;
		writeText(age);
		getUiObjectByText("完成").clickAndWaitForNewWindow();
		getUiObjectByText("保存").clickAndWaitForNewWindow();
		getUiObjectByText("个人资料 > ").clickAndWaitForNewWindow();
		String newage = getUiObjextByResourceId("com.dianzhi.teacher.school:id/ed_teaching_age_my_infomation_activity").getText();
		assertEquals("修改教龄失败！", age, newage);
		outputNotable("修改教龄成功！");
		UiDevice.getInstance().pressBack();
		setLong();
	}
	public void setEducation() throws UiObjectNotFoundException {//修改学历
		setShort();
		getUiObjectByText("个人资料 > ").clickAndWaitForNewWindow();
		String education = getUiObjextByResourceId("com.dianzhi.teacher.school:id/tv_degree_my_infomation_activity").getText();
		getUiObjectByText("学历:").clickAndWaitForNewWindow();
		int num = new Random().nextInt(5);
		switch (num) {
		case 0:	
			getUiObjectByText("博士").clickAndWaitForNewWindow();
			getUiObjectByText("保存").clickAndWaitForNewWindow();
			getUiObjectByText("个人资料 > ").clickAndWaitForNewWindow();
			String identity0 = getUiObjextByResourceId("com.dianzhi.teacher.school:id/tv_degree_my_infomation_activity").getText();
			assertEquals("修改身份失败！", "博士", identity0);
			outputNotable("修改学历成功！");
			break;
		case 1:
			getUiObjectByText("硕士").clickAndWaitForNewWindow();
			getUiObjectByText("保存").clickAndWaitForNewWindow();
			getUiObjectByText("个人资料 > ").clickAndWaitForNewWindow();
			String identity1 = getUiObjextByResourceId("com.dianzhi.teacher.school:id/tv_degree_my_infomation_activity").getText();
			assertEquals("修改学历失败！", "硕士", identity1);
			outputNotable("修改学历成功！");
			break;
		case 2:
			getUiObjectByText("本科").clickAndWaitForNewWindow();
			getUiObjectByText("保存").clickAndWaitForNewWindow();
			getUiObjectByText("个人资料 > ").clickAndWaitForNewWindow();
			String identity2 = getUiObjextByResourceId("com.dianzhi.teacher.school:id/tv_degree_my_infomation_activity").getText();
			assertEquals("修改学历失败！", "本科", identity2);
			outputNotable("修改学历成功！");
			break;
		case 3:
			getUiObjectByText("其他").clickAndWaitForNewWindow();
			getUiObjectByText("保存").clickAndWaitForNewWindow();
			getUiObjectByText("个人资料 > ").clickAndWaitForNewWindow();
			String identity4 = getUiObjextByResourceId("com.dianzhi.teacher.school:id/tv_degree_my_infomation_activity").getText();
			assertEquals("修改学历失败！", "其他", identity4);
			outputNotable("修改学历成功！");
			break;
		case 4:
			getUiObjectByText("取消").clickAndWaitForNewWindow();
			getUiObjectByText("保存").clickAndWaitForNewWindow();
			getUiObjectByText("个人资料 > ").clickAndWaitForNewWindow();
			String neweducation = getUiObjextByResourceId("com.dianzhi.teacher.school:id/tv_degree_my_infomation_activity").getText();
			assertEquals("修改身份失败！", education, neweducation);
			outputNotable("修改身份成功！");
			break;
		default:
			break;
		}
		UiDevice.getInstance().pressBack();
		setLong();
	}
	public void setIdentity() throws UiObjectNotFoundException {//随机设置身份
		setShort();
		getUiObjectByText("个人资料 > ").clickAndWaitForNewWindow();
		String identity = getUiObjextByResourceId("com.dianzhi.teacher.school:id/tv_Identity_my_infomation_activity").getText();
		getUiObjectByText("身份:").clickAndWaitForNewWindow();
		int num = new Random().nextInt(6);
		switch (num) {
		case 0:
			getUiObjectByText("特级教师").clickAndWaitForNewWindow();
			getUiObjectByText("保存").clickAndWaitForNewWindow();
			getUiObjectByText("个人资料 > ").clickAndWaitForNewWindow();
			String identity0 = getUiObjextByResourceId("com.dianzhi.teacher.school:id/tv_Identity_my_infomation_activity").getText();
			assertEquals("修改身份失败！", "特级教师", identity0);
			outputNotable("修改身份成功！");
			break;
		case 1:
			getUiObjectByText("高级教师").clickAndWaitForNewWindow();
			getUiObjectByText("保存").clickAndWaitForNewWindow();
			getUiObjectByText("个人资料 > ").clickAndWaitForNewWindow();
			String identity1 = getUiObjextByResourceId("com.dianzhi.teacher.school:id/tv_Identity_my_infomation_activity").getText();
			assertEquals("修改身份失败！", "高级教师", identity1);
			outputNotable("修改身份成功！");
			break;
		case 2:
			getUiObjectByText("高级教师").clickAndWaitForNewWindow();
			getUiObjectByText("保存").clickAndWaitForNewWindow();
			getUiObjectByText("个人资料 > ").clickAndWaitForNewWindow();
			String identity2 = getUiObjextByResourceId("com.dianzhi.teacher.school:id/tv_Identity_my_infomation_activity").getText();
			assertEquals("修改身份失败！", "高级教师", identity2);
			outputNotable("修改身份成功！");
			break;
		case 3:
			getUiObjectByText("专职教师").clickAndWaitForNewWindow();
			getUiObjectByText("保存").clickAndWaitForNewWindow();
			getUiObjectByText("个人资料 > ").clickAndWaitForNewWindow();
			String identity3 = getUiObjextByResourceId("com.dianzhi.teacher.school:id/tv_Identity_my_infomation_activity").getText();
			assertEquals("修改身份失败！", "专职教师", identity3);
			outputNotable("修改身份成功！");
			break;
		case 4:
			getUiObjectByText("在校学生").clickAndWaitForNewWindow();
			getUiObjectByText("保存").clickAndWaitForNewWindow();
			getUiObjectByText("个人资料 > ").clickAndWaitForNewWindow();
			String identity4 = getUiObjextByResourceId("com.dianzhi.teacher.school:id/tv_Identity_my_infomation_activity").getText();
			assertEquals("修改身份失败！", "在校学生", identity4);
			outputNotable("修改身份成功！");
			break;
		case 5:
			getUiObjectByText("其他").clickAndWaitForNewWindow();
			getUiObjectByText("保存").clickAndWaitForNewWindow();
			getUiObjectByText("个人资料 > ").clickAndWaitForNewWindow();
			String identity5 = getUiObjextByResourceId("com.dianzhi.teacher.school:id/tv_Identity_my_infomation_activity").getText();
			assertEquals("修改身份失败！", "其他", identity5);
			outputNotable("修改身份成功！");
			break;
		case 6:
			getUiObjectByText("取消").clickAndWaitForNewWindow();
			getUiObjectByText("保存").clickAndWaitForNewWindow();
			getUiObjectByText("个人资料 > ").clickAndWaitForNewWindow();
			String identity6 = getUiObjextByResourceId("com.dianzhi.teacher.school:id/tv_Identity_my_infomation_activity").getText();
			assertEquals("修改身份失败！", identity, identity6);
			outputNotable("修改身份成功！");
			break;
		default:
			break;
		}
		UiDevice.getInstance().pressBack();
		setLong();
	}
	public void startApp() throws UiObjectNotFoundException {//启动app
		UiDevice.getInstance().pressHome();
		UiDevice.getInstance().pressHome();
		clean();//清理后台程序
		getUiObjectByText("点知教育").clickAndWaitForNewWindow();//打开app
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
	public void setSubject() throws UiObjectNotFoundException {//随机修改科目
		setShort();
		getUiObjectByText("个人资料 > ").clickAndWaitForNewWindow();
		String subjectname = getUiObjextByResourceId("com.dianzhi.teacher.school:id/subject_tv").getText();
		getUiObjectByText("科目:").clickAndWaitForNewWindow();
		int num = new Random().nextInt(10);
		switch (num) {
		case 0:
			getUiObjectByText("语文").clickAndWaitForNewWindow();
			getUiObjectByText("保存").clickAndWaitForNewWindow();
			getUiObjectByText("个人资料 > ").clickAndWaitForNewWindow();
			String newsubject0 = getUiObjextByResourceId("com.dianzhi.teacher.school:id/subject_tv").getText();
			assertEquals("修改学科失败！", "语文", newsubject0);
			outputNotable("修改学科成功！");
			UiDevice.getInstance().pressBack();
			break;
		case 1:
			getUiObjectByText("数学").clickAndWaitForNewWindow();
			getUiObjectByText("保存").clickAndWaitForNewWindow();
			getUiObjectByText("个人资料 > ").clickAndWaitForNewWindow();
			String newsubject1 = getUiObjextByResourceId("com.dianzhi.teacher.school:id/subject_tv").getText();
			assertEquals("修改学科失败！", "数学", newsubject1);
			outputNotable("修改学科成功！");
			UiDevice.getInstance().pressBack();
			break;
		case 2:
			getUiObjectByText("英语").clickAndWaitForNewWindow();
			getUiObjectByText("保存").clickAndWaitForNewWindow();
			getUiObjectByText("个人资料 > ").clickAndWaitForNewWindow();
			String newsubject2 = getUiObjextByResourceId("com.dianzhi.teacher.school:id/subject_tv").getText();
			assertEquals("修改学科失败！", "英语", newsubject2);
			outputNotable("修改学科成功！");
			UiDevice.getInstance().pressBack();
			break;
		case 3:
			getUiObjectByText("物理").clickAndWaitForNewWindow();
			getUiObjectByText("保存").clickAndWaitForNewWindow();
			getUiObjectByText("个人资料 > ").clickAndWaitForNewWindow();
			String newsubject3 = getUiObjextByResourceId("com.dianzhi.teacher.school:id/subject_tv").getText();
			assertEquals("修改学科失败！", "物理", newsubject3);
			outputNotable("修改学科成功！");
			UiDevice.getInstance().pressBack();
			break;
		case 4:
			getUiObjectByText("化学").clickAndWaitForNewWindow();
			getUiObjectByText("保存").clickAndWaitForNewWindow();
			getUiObjectByText("个人资料 > ").clickAndWaitForNewWindow();
			String newsubject4 = getUiObjextByResourceId("com.dianzhi.teacher.school:id/subject_tv").getText();
			assertEquals("修改学科失败！", "化学", newsubject4);
			outputNotable("修改学科成功！");
			UiDevice.getInstance().pressBack();
			break;
		case 5:
			getUiObjectByText("生物").clickAndWaitForNewWindow();
			getUiObjectByText("保存").clickAndWaitForNewWindow();
			getUiObjectByText("个人资料 > ").clickAndWaitForNewWindow();
			String newsubject5 = getUiObjextByResourceId("com.dianzhi.teacher.school:id/subject_tv").getText();
			assertEquals("修改学科失败！", "生物", newsubject5);
			outputNotable("修改学科成功！");
			UiDevice.getInstance().pressBack();
			break;
		case 6:
			getUiObjectByText("政治").clickAndWaitForNewWindow();
			getUiObjectByText("保存").clickAndWaitForNewWindow();
			getUiObjectByText("个人资料 > ").clickAndWaitForNewWindow();
			String newsubject6 = getUiObjextByResourceId("com.dianzhi.teacher.school:id/subject_tv").getText();
			assertEquals("修改学科失败！", "政治", newsubject6);
			outputNotable("修改学科成功！");
			UiDevice.getInstance().pressBack();
			break;
		case 7:
			getUiObjectByText("历史").clickAndWaitForNewWindow();
			getUiObjectByText("保存").clickAndWaitForNewWindow();
			getUiObjectByText("个人资料 > ").clickAndWaitForNewWindow();
			String newsubject7 = getUiObjextByResourceId("com.dianzhi.teacher.school:id/subject_tv").getText();
			assertEquals("修改学科失败！", "历史", newsubject7);
			outputNotable("修改学科成功！");
			UiDevice.getInstance().pressBack();
			break;
		case 8:
			getUiObjectByText("地理").clickAndWaitForNewWindow();
			getUiObjectByText("保存").clickAndWaitForNewWindow();
			getUiObjectByText("个人资料 > ").clickAndWaitForNewWindow();
			String newsubject8 = getUiObjextByResourceId("com.dianzhi.teacher.school:id/subject_tv").getText();
			assertEquals("修改学科失败！", "地理", newsubject8);
			outputNotable("修改学科成功！");
			UiDevice.getInstance().pressBack();
			break;
		case 9:
			getUiObjectByText("取消").clickAndWaitForNewWindow();
			getUiObjectByText("保存").clickAndWaitForNewWindow();
			getUiObjectByText("个人资料 > ").clickAndWaitForNewWindow();
			String newsubject9 = getUiObjextByResourceId("com.dianzhi.teacher.school:id/subject_tv").getText();
			assertEquals("修改学科失败！", subjectname, newsubject9);
			outputNotable("修改学科成功！");
			UiDevice.getInstance().pressBack();
			break;
		default:
			outputNotable("修改学科失败！");;
			break;
		}
		setLong();
	}
	public void setGrade() throws UiObjectNotFoundException{//随机设置年级
		setShort();
		getUiObjectByText("个人资料 > ").clickAndWaitForNewWindow();
		String grade = getUiObjextByResourceId("com.dianzhi.teacher.school:id/class_tv").getText();
		getUiObjectByText("年级:").clickAndWaitForNewWindow();
		int num = new Random().nextInt(3);
		switch (num) {
		case 0:
			getUiObjectByText("初中").clickAndWaitForNewWindow();
			getUiObjectByText("保存").clickAndWaitForNewWindow();
			getUiObjectByText("个人资料 > ").clickAndWaitForNewWindow();
			String grade0 = getUiObjextByResourceId("com.dianzhi.teacher.school:id/class_tv").getText();
			assertEquals("修改年级失败！", "初中", grade0);
			outputNotable("修改年级成功！");
			UiDevice.getInstance().pressBack();
			break;
		case 1:
			getUiObjectByText("高中").clickAndWaitForNewWindow();
			getUiObjectByText("保存").clickAndWaitForNewWindow();
			getUiObjectByText("个人资料 > ").clickAndWaitForNewWindow();
			String grade1 = getUiObjextByResourceId("com.dianzhi.teacher.school:id/class_tv").getText();
			assertEquals("修改年级失败！", "高中", grade1);
			outputNotable("修改年级成功！");
			UiDevice.getInstance().pressBack();
			break;
		case 2:
			getUiObjectByText("取消").clickAndWaitForNewWindow();
			getUiObjectByText("保存").clickAndWaitForNewWindow();
			getUiObjectByText("个人资料 > ").clickAndWaitForNewWindow();
			String newgrade = getUiObjextByResourceId("com.dianzhi.teacher.school:id/class_tv").getText();
			assertEquals("修改年级失败！", grade, newgrade);
			outputNotable("修改年级成功！");
			UiDevice.getInstance().pressBack();
			break;
		
		default:
			outputNotable("修改年级失败！");;
			break;
		}
		setLong();
	}
	public void renameClass() throws UiObjectNotFoundException {//随机修改班级名称
		setShort();
		getUiObjextByResourceId("com.dianzhi.teacher.school:id/open_or_close_iv").clickAndWaitForNewWindow();//点击展开设置栏
		getUiObjectByText("重命名").clickAndWaitForNewWindow();
		int num = new Random().nextInt(90)+10;//生成一个随机数
		String classname = "Test"+num;//生成一个随机的班级名
		writeText(classname);//重命名班级
		//outputNotable(classname);
		getUiObjectByText("确定").clickAndWaitForNewWindow();
		String newclassname = getUiObjextByResourceId("com.dianzhi.teacher.school:id/name").getText();//获取当前班级名
		//outputNotable(newclassname);
		assertEquals("修改班级名称失败！", classname, newclassname);//检查是否重命名成功
		outputNotable("修改班级名称成功！");
		getUiObjextByResourceId("com.dianzhi.teacher.school:id/open_or_close_iv").clickAndWaitForNewWindow();//收回设置栏
		setLong();
	}
	public void ClassTest() throws UiObjectNotFoundException {//班级管理基本功能测试
		startApp();//启动app
		checkLog();//检查登录
		classManage();//进入班级管理
		renameClass();//重命名班级
		createClass();//创建班级
		searchStudenThrowTel();//通过手机号添加学生
		addStudentIntoClass();//通过通讯录添加学生
		remarkStudentInfo();//备注学生信息
		checkClassNum();//检查班级人数
		alterClassInfo();//更改班级备注信息
		deleteClass();//删除班级
	}
	public void myInfoTest() throws UiObjectNotFoundException {//完整个人信息测试
		startApp();//启动app
		checkLog();//检查登录
		alterName();//修改姓名
		setGrade();//修改年级
		setSubject();//修改科目
		setSex();//修改性别
		alterTeachAge();//修改教龄
		setIdentity();//修改身份
		setEducation();//修改学历
		alterUniversity();//修改毕业院校
		alterSpecialty();//修改专业
		alterIntroduction();//修改简介
		alterTeachingFeature();//修改教学特点
	}
	public void setInputUtf() throws UiObjectNotFoundException {//设置输入法为UTF7
		clean();
		UiDevice.getInstance().pressHome();
		swipeLeft();
		getUiObjectByText("设置").clickAndWaitForNewWindow();
		getUiScrollabe().getChildByText(new UiSelector().text("语言和输入法"), "语言和输入法").clickAndWaitForNewWindow();
		UiObject UTF7 = getUiObjectByText("UTF7 IME for UI Testing");
		if (UTF7.isChecked()) {
			outputNotable("已经开启UTF7输入法了！");
		}else{
			UTF7.clickAndWaitForNewWindow();
			waitForUiObject("注意");
			getUiObjectByText("确定").clickAndWaitForNewWindow();
		}
		getUiObjectByTextResourceId("默认", "android:id/title").clickAndWaitForNewWindow();
		getUiObjectByText("UTF7 IME for UI Testing").clickAndWaitForNewWindow();
		String Input = getUiObjextByResourceId("android:id/summary").getText();
		assertEquals("修改默认书法失败！", "UTF7 IME for UI Testing", Input);
		clean();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void testTestS() throws UiObjectNotFoundException {
  		getUiDevice().registerWatcher("Jurisdiction watcher",new UiWatcher(){//监听权限警告
			UiObject warrning = new UiObject(new UiSelector().text("安全警告"));			
			@Override
			public boolean checkForCondition(){	
				if(warrning.exists()){
					System.out.println("the first watcher is begin !");
					UiObject noremind = new UiObject(new UiSelector().text("不再提醒"));
					try {
						noremind.clickAndWaitForNewWindow();
						} catch (UiObjectNotFoundException e1) {
							e1.printStackTrace();
							}
					UiObject allow = new UiObject(new UiSelector().text("允许"));
					try {
						allow.clickAndWaitForNewWindow();
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
						sure.clickAndWaitForNewWindow();
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
