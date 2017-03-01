package student;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;

@SuppressWarnings({ "deprecation"})
public class Test extends ClassCase{
	public static void main(String[] args){
		new UiAutomatorHelper("Desmo", "student.Test", "testTest", "1");
//		new UpdateApp("com.dianzhi.student", "1", true);
	}
	public void testTest() throws UiObjectNotFoundException{
//		checkLog();
//		getTrust();
//		photoOrFindTutor();
		
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
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
