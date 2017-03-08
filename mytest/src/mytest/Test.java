package mytest;

import com.android.uiautomator.core.UiObjectNotFoundException;
@SuppressWarnings({ "deprecation"})
public class Test extends ClassCase{
	public static void main(String[] args){
		new UiAutomatorHelper("Demo", "mytest.Test", "testTest", "1");
		new JEBCTest("users", "full_name", 545);
	}
	public void testTest() throws UiObjectNotFoundException{
		
		outputNotable(567);
		
}
}
