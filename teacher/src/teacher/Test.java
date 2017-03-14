package teacher;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObjectNotFoundException;

import android.graphics.Rect;

@SuppressWarnings({ "deprecation" })
public class Test extends ClassCase{
	public static void main(String[] args){
		new UiAutomatorHelper("Demo", "teacher.Test", "testTest", "1");
	}
	public void testTest() throws UiObjectNotFoundException{
		
		 Rect sss = getUiObjextByResourceId("com.example.android.contactmanager:id/contactNameEditText").getBounds();
		 clickPiont(sss.centerX()+sss.width()/4, sss.centerY());
//		 outputNotable(sss.centerX());
		 UiDevice.getInstance().pressHome();
	
	 
	
	
	
	}
	
}