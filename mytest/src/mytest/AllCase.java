package mytest;

import com.android.uiautomator.core.UiObjectNotFoundException;

import java.io.IOException;
import java.util.HashSet;
import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiSelector;

@SuppressWarnings("deprecation")
public class AllCase extends ClassCase{
	public static void main(String[] args){
		new UiAutomatorHelper("Demo", "mytest.AllCase", "qqTest", "1");
	}
	public void checkForFlow() throws UiObjectNotFoundException{
		//京东签到领流量
		clean();//清理后台
		UiDevice.getInstance().pressHome();
		getUiObjectByText("手机京东").clickAndWaitForNewWindow();
		waitForUiObject("充值中心");
		getUiObjectByTextResourceId("全部", "com.jingdong.app.mall:id/g0").click();
		getUiObjectByText("领流量").clickAndWaitForNewWindow();
		waitForUiObject("流量加油站");//等待页面出现
		//这里无法获取页面信息，只能用点击坐标来实现了
		sleep(2000);
		clickPiont(250, 800);//点击签到
		sleep(2000);
		clickPiont(120, 1100);//点击领口令流量
		sleep(2000);
		getUiScrollabe().waitForExists(10000);
		getUiScrollabe().scrollForward();//这里得先向下滑动一次，不然会直接向上滑动导致用例失败
		UiObject lqld = new UiObject(new UiSelector().textStartsWith("流量口令"));
		getUiScrollabe().scrollIntoView(lqld);//滑动到口令
		String key = lqld.getText();//获取口令空间文本
		String keytrue = key.substring(6, key.length());//提取口令
		outputNotable(keytrue);
		getUiScrollabe().scrollToBeginning(100, 8);//滚动到最上面
		sleep(5000);
		writeText(keytrue);//填写口令
		sleep(2000);
		getUiObjextByResourceId("com.jingdong.app.mall:id/rt").click();
		clean();
		}
	public void sendMassageToAllFriend() throws UiObjectNotFoundException {
		//给微信好友发一条祝福信息
		clean();
		UiDevice.getInstance().pressHome();
		//打开微信
		getUiObjectByText("微信").clickAndWaitForNewWindow();
		getUiObjectByText("通讯录").clickAndWaitForNewWindow();
		//建立一个朋友名字的数组
		HashSet<String> friends = new HashSet<String>();
		//滚动到顶部
		getUiScrollableByResourceId("com.tencent.mm:id/hr").scrollToBeginning(5);
		boolean key = true;
		boolean one = false;
		while(key){
			//获取当前页面好友个数
			int num = getUiScrollableByResourceId("com.tencent.mm:id/hr").getChildCount();
			//把好友的姓名添加到数组中
			for(int i=0;i<num-1;i++){
				UiObject friend = getUiObjectByResourceIdIntance("com.tencent.mm:id/i_", i);
				String name =  friend.getText();
				//排除微信团队和文件传输助手两个好友可以以后在数组中删除
				if (name.equalsIgnoreCase("微信团队") || name.equalsIgnoreCase("文件传输助手")) {
					outputNotable(name);
				}else{
					friends.add(name);
				}
			}
			//为了滚动到底部时，再次执行上面的循环把余下的好友也添加到数组
			if (one) {
				break;
			}
			//滚动到底部时one改为true
			if (!getUiScrollableByResourceId("com.tencent.mm:id/hr").scrollForward()) {
				one = true;
			}
		}
		//这个是先转换成String[]数组在向每个好友发送消息
		String[] de =  (String[])(friends.toArray(new String[0]));
		for(int i=0;i<10;i++){
			outputNotable(de[i]);
			sendMassageToFriend(de[i], "你好，"+de[i]+"祝你情人节快乐！");
			}
		//这个直接遍历friends中的名字发送消息
		for(String x : friends){
			sendMassageToFriend(x, "你好，"+x+"祝你情人节快乐！");
			}
		}
	
	public void qqTest() throws IOException, UiObjectNotFoundException, InterruptedException {

		qqPraise();
		
		
	
	
	
	
	
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
	
