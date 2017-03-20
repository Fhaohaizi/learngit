package teacher;


import java.io.IOException;
import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObjectNotFoundException;

@SuppressWarnings({ "deprecation" })
public class Test extends ClassCase{
	public static void main(String[] args){
		new UiAutomatorHelper("Demo", "teacher.Test", "testTest", "1");
	}
	public void testTest() throws UiObjectNotFoundException, IOException{
		
		 UiDevice.getInstance().pressHome();
		 
	
	}
	
}