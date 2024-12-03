package ERO_Optimizer_WHAT_IF_Scripts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.Utils;

public class TS005_ERO_Optimizer_WHATIF_TC42to58 extends Keywords{
	public void Scenario005(WebDriver driver, ExtentTest test, ExtentTest test1, String url, int dataset) throws AWTException {
		
		System.out.println("url : " + url);
		String Username = Utils.getDataFromTestData("TS005_EroOptimizer_WHAT_IF", "ERO_Optimizer WHAT_IF","Username");
		String Password = Utils.getDataFromTestData("TS005_EroOptimizer_WHAT_IF", "ERO_Optimizer WHAT_IF","Password");
		String ID = Utils.getDataFromTestData("TS005_EroOptimizer_WHAT_IF", "ERO_Optimizer WHAT_IF", "Id");
		
		
		
		
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
		sendKeys(driver, Searchbox, "Optimizer WHAT – IF Scenario");

		Fluentwait(driver, SelectOptimizer);
		click(driver, SelectOptimizer);
		wait(driver, "5");
		
		Fluentwait(driver, Optimizer_cancle);
		click(driver, Optimizer_cancle);
		
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

		if (isDisplayed(driver, Optimizer_createnew_confirm)) {
            
			Extent_pass(driver, "Shortcut key for `New` button(ALT+N) is functioning and new record was created", test,test1);
			click(driver, Optimizer_createnew_confirm);
		} else {
			Extent_fail(driver, "Shortcut key for `New` button(ALT+N) is not functioning", test,test1);
		}

		System.out.println("//***************************Testcase 42 Completed **************************************//");

		
		Extent_cal(test, "Testcase 46 -When click ALT+E system should cancel the last activity");

		wait(driver, "5");
//		Fluentwait(driver, Optimizer_new);
//		click(driver, Optimizer_new);
//		
//		Fluentwait(driver, Optimizer_createnew_confirm);
//		click(driver, Optimizer_createnew_confirm);
//		
//		wait(driver, "5");
		
		Fluentwait(driver, Optimizer_Globalserach);
		click(driver, Optimizer_Globalserach);

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

		if (!IsElementEnabled(driver, first_col)) {

			Extent_pass(driver, "Shortcut key for `Save` button(ALT+E) is functioning and  cancel the last activity", test,test1);


		} else {
			Extent_fail(driver, "Shortcut key for `Save` button(ALT+E) is functioning and not  cancel the last activity", test,test1);
		}

		System.out.println("//***************************Testcase 46 Completed **************************************//");

		Extent_cal(test, "Testcase 49 - When click ALT+C System should allow to copy the selected data");

	
		Fluentwait(driver, Optimizer_new);
		click(driver, Optimizer_new);
		
		Fluentwait(driver, Optimizer_createnew_confirm);
		click(driver, Optimizer_createnew_confirm);
		
		Fluentwait(driver, Optimizer_Globalserach);
		click(driver, Optimizer_Globalserach);

		Fluentwait(driver, Globalserach_IDInput);
		sendKeys(driver, Globalserach_IDInput, ID);

		wait(driver, "2");

		Fluentwait(driver, Click_Search);
		click(driver, Click_Search);

		wait(driver, "5");

		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);
		
		wait(driver, "5");

		Fluentwait(driver, first_col);
		click(driver, first_col);

		wait(driver, "3");

		rbt.keyPress(KeyEvent.VK_CONTROL);
		rbt.delay(500);
		rbt.keyPress(KeyEvent.VK_C);
		rbt.delay(1000);
		rbt.keyRelease(KeyEvent.VK_C);
		rbt.keyRelease(KeyEvent.VK_CONTROL);

		wait(driver, "5");

		String copiedtext = getcopiedText(driver);

		System.out.println("copiedtext : " + copiedtext);

		String gettext = getText(driver, first_col);
		
		int textlength = gettext.length();
		
		String actualcopied = copiedtext.substring(0, textlength);

		if (actualcopied.equals(gettext)) {

			System.out.println("Selected data was copied || Expected copied value was : " + gettext + " || Actual copied value was : "
					+ actualcopied);
			Extent_pass(driver,
					"Selected data was copied || Expected copied value was : " + gettext + " || Actual copied value was : " + actualcopied,
					test,test1);
		} else {
			System.out.println("Selected data was not copied || Expected copied value was : " + gettext
					+ " || Actual copied value was : " + actualcopied);
			Extent_fail(driver, "Selected data was not copied || Expected copied value was : " + gettext
					+ " || Actual copied value was : " + actualcopied, test,test1);
		}

		System.out.println("**************Testcase 49 Completed***************");
	
		
		Extent_cal(test, "Testcase 58 - When click CRTL+F4 System should allow to close the screen ");	
		
		rbt.keyPress(KeyEvent.VK_CONTROL);
		rbt.delay(500);
		rbt.keyPress(KeyEvent.VK_F4);
		rbt.delay(1000);
		rbt.keyRelease(KeyEvent.VK_F4);
		rbt.keyRelease(KeyEvent.VK_CONTROL);
		
		if(!isDisplayed(driver, Optimizer_Tree_table)) {
			
			System.out.println("Shortcut key for close the screen is functioning");
			Extent_pass(driver, "Shortcut key for close the screen is functioning", test,test1);
			
		}else {
			
			System.out.println("Shortcut key for close the screen is not functioning");
			Extent_fail(driver,"Shortcut key for close the screen is not functioning", test,test1);
		}
		System.out.println("************Testcase 58 Completed***************");
		
		
		
		
		
	}

}
