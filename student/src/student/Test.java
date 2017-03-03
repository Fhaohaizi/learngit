package student;

import java.util.Random;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObjectNotFoundException;

@SuppressWarnings({ "deprecation"})
public class Test extends ClassCase{
	public static void main(String[] args){
		new UiAutomatorHelper("Desmo", "student.Test", "testTest", "1");
//		new UpdateApp("com.dianzhi.student", "1", true);
	}
	public void testTest() throws UiObjectNotFoundException{
		checkLog();
		getTrust();
		photoOrFindTutor();
		/*
		while(true){
			UiObject input = new UiObject(new UiSelector().resourceId("android:id/checkbox").checked(false));
			if (input.exists()) {
				input.click();
				waitForUiObject("注意");
				getUiObjectByText("确定").clickAndWaitForNewWindow();
			}else{
				break;
			}
		}
		*/
//		login();
		for(int i=0; i < 500;i++){
			int maxx = UiDevice.getInstance().getDisplayWidth();
			int maxy = UiDevice.getInstance().getDisplayHeight();
			int x = new Random().nextInt(maxx);
			int y = new Random().nextInt(maxy);
			outputNotable(x+"--"+y);
			clickPiont(x, y);
			}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
