package mytest;

import com.android.uiautomator.core.UiObjectNotFoundException;

@SuppressWarnings({ "deprecation"})
public class Test extends ClassCase{
	public static void main(String[] args){
		new UiAutomatorHelper("Demo", "mytest.Test", "testTest", "1");
	}
	public void testTest() throws UiObjectNotFoundException{
		
		
		writeText("香香莉女鞋");//填写口令
		sleep(2000);
		getUiObjextByResourceId("com.jingdong.app.mall:id/rt").click();
		
		
		
		
		
}
}
