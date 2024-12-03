package MapView;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.Utils;

public class TS05_MapViewTC42to58 extends Keywords{
public void Scenario05(WebDriver driver, ExtentTest test, ExtentTest test1, String url, int dataset) throws AWTException {
		
		System.out.println("url : " + url);

		String Username = Utils.getDataFromTestData("TS05_Map_View_Dataset"+dataset, "Map view","Username");
		String Password = Utils.getDataFromTestData("TS05_Map_View_Dataset"+dataset, "Map view","Password");
		String ID = Utils.getDataFromTestData("TS05_Map_View_Dataset"+dataset, "Map view", "Id");
		
		navigateUrl(driver, url);

		Fluentwait(driver, Username_input);
		sendKeys(driver, Username_input, Username);

		Fluentwait(driver, Password_input);
		sendKeys(driver, Password_input, Password);

		Fluentwait(driver, SignIn);
		click(driver, SignIn);

		wait(driver, "5");

		if (isDisplayed(driver, session_confirmation)) {
			Fluentwait(driver, session_confirmation);
			click(driver, session_confirmation);
		}

		Fluentwait(driver, Searchbox);
		sendKeys(driver, Searchbox, "Map View");

		Fluentwait(driver, Select_mapview);
		click(driver, Select_mapview);
		
		Fluentwait(driver, MapView_cancel);
		click(driver, MapView_cancel);
		
		Extent_cal(test, "Testcase 42 - when we click ALT+N,System should allow to create new record");

		wait(driver, "7");

		Robot rbt = new Robot();

		rbt.keyPress(KeyEvent.VK_ALT);
		rbt.delay(500);
		rbt.keyPress(KeyEvent.VK_N);
		rbt.delay(1000);
		rbt.keyRelease(KeyEvent.VK_N);
		rbt.keyRelease(KeyEvent.VK_ALT);

		wait(driver, "5");
		
     if (isDisplayed(driver, MapView_createnew_confirm)) {
            
			Extent_pass(driver, "Shortcut key for `New` button(ALT+N) is functioning and new record was created", test,test1);
			click(driver, MapView_createnew_confirm);
		} else {
			Extent_fail(driver, "Shortcut key for `New` button(ALT+N) is not functioning", test,test1);
		}

		System.out.println("//***************************Testcase 42 Completed **************************************//");

		Extent_cal(test, "Testcase 46 -When click ALT+E system should cancel the last activity");

		wait(driver, "5");
		
		Fluentwait(driver, Map_view_Globalserach);
		click(driver, Map_view_Globalserach);

		Fluentwait(driver, Globalserach_IDInput);
		sendKeys(driver, Globalserach_IDInput, ID);

		wait(driver, "2");

		Fluentwait(driver, Click_Search);
		click(driver, Click_Search);

		wait(driver, "5");

		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);
		
		wait(driver, "7");
		
		rbt.keyPress(KeyEvent.VK_ALT);
		rbt.delay(500);
		rbt.keyPress(KeyEvent.VK_E);
		rbt.delay(1000);
		rbt.keyRelease(KeyEvent.VK_E);
		rbt.keyRelease(KeyEvent.VK_ALT);

		wait(driver, "5");

		if (!IsElementEnabled(driver, Map_20DY)) {

			Extent_pass(driver, "Shortcut key for `Save` button(ALT+E) is functioning and  cancel the last activity", test,test1);


		} else {
			Extent_fail(driver, "Shortcut key for `Save` button(ALT+E) is functioning and not  cancel the last activity", test,test1);
		}

		System.out.println("//***************************Testcase 46 Completed **************************************//");

		

		Extent_cal(test, "Testcase 58 - When click CRTL+F4 System should allow to close the screen ");	
		
		rbt.keyPress(KeyEvent.VK_CONTROL);
		rbt.delay(500);
		rbt.keyPress(KeyEvent.VK_F4);
		rbt.delay(1000);
		rbt.keyRelease(KeyEvent.VK_F4);
		rbt.keyRelease(KeyEvent.VK_CONTROL);
		
		if(!isDisplayed(driver, Map_20DY)) {
			
			System.out.println("Shortcut key for close the screen is functioning");
			Extent_pass(driver, "Shortcut key for close the screen is functioning", test,test1);
			
		}else {
			
			System.out.println("Shortcut key for close the screen is not functioning");
			Extent_fail(driver,"Shortcut key for close the screen is not functioning", test,test1);
		}
		System.out.println("************Testcase 58 Completed***************");
		
		
}
}