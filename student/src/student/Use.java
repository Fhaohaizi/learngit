package student;

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
		new UiAutomatorHelper("Demo", "student.Use", "testTest", "1");
	}
	public void testTest() throws UiObjectNotFoundException{
		showAnalysis();
		
		
		
	}
}