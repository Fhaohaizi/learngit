package teacher;

import java.util.Random;

import com.android.uiautomator.core.Configurator;
import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;

import android.R.string;

@SuppressWarnings({ "deprecation", "unused" })
public class Use extends ClassCase{
	public static void main(String[] args){
		new UiAutomatorHelper("Demo", "teacher.Use", "testTest", "1");
	}
	public void testTest() throws UiObjectNotFoundException{
		
		for(int i=0;i<20;i++){
			outputBegin("第"+(i+1)+"次！");
			ClassTest();
//			renameClass();
//			alterClassInfo();
			}
	 
	
	
	}
}