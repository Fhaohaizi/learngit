package student;

import java.util.HashSet;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;

@SuppressWarnings({ "deprecation"})
public class Test extends ClassCase {
	public static void main(String[] args){
		new UiAutomatorHelper("Desmo", "student.Test", "testTest", "1");
//		new UpdateApp("com.dianzhi.teacher.school", "1", true);
		
	}
	public void testTest() throws UiObjectNotFoundException{
		
		outputBegin("");
		getUiObjectByResourceId("com.example.android.contactmanager:id/contactNameEditText");
		HashSet<UiObject> lss = new HashSet<UiObject>();
		lss.add(getUiObjectByClassName("d"));
		lss.size();
		
		
		
		
		
		
		
		
		
		
		 
	}


	
	
	
	
	
	
	
	
}
