package DeficitAndSurflusLocationIdentification_Scripts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.Utils;

public class TS005_DeficitandSurplusLocationId_TC_42toTC_58 extends Keywords {

	public void Scenario5(WebDriver driver, ExtentTest test,ExtentTest test1, String url, int dataset) throws Exception {

		System.out.println("url : " + url); 
		String Username = Utils.getDataFromTestData("TS005_DeficitandSurplusLocationIdentification_Datset"+dataset,
				"DeficitandSurplusLocationId", "Username");
		String Password = Utils.getDataFromTestData("TS005_DeficitandSurplusLocationIdentification_Datset"+dataset,
				"DeficitandSurplusLocationId", "Password");
		String ID = Utils.getDataFromTestData("TS005_DeficitandSurplusLocationIdentification_Datset"+dataset,
				"DeficitandSurplusLocationId", "Id");

		WebDriverWait wait = new WebDriverWait(driver, 60);
		Actions act = new Actions(driver);
		
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
		sendKeys(driver, Searchbox, "Deficit and Surplus Location Identification");

		Fluentwait(driver, Selectdeficit);
		click(driver, Selectdeficit);

		wait(driver, "5");

		Fluentwait(driver, Cancel);
		click(driver, Cancel);

		Extent_cal(test, "Testcase 42 - when we click ALT+N,System should allow to create new record");

		wait(driver, "5");

		act.keyDown(Keys.ALT).sendKeys("n").keyUp(Keys.ALT).build().perform();

		wait(driver, "5");

		if (isDisplayed(driver, createnew_confirm)) {

			Extent_pass(driver, "Shortcut key for `New` button(ALT+N) is functioning and new record was created", test,test1);
			click(driver, createnew_confirm);
		} else {
			Extent_fail(driver, "Shortcut key for `New` button(ALT+N) is not functioning", test,test1);
		}

		System.out
				.println("//***************************Testcase 42 Completed **************************************//");

		Extent_cal(test, "Testcase 43 - When click ALT+S system should save/update the record");

		wait(driver, "5");

		act.keyDown(Keys.ALT).sendKeys("s").keyUp(Keys.ALT).build().perform();

		wait(driver, "5");

		if (isDisplayed(driver, Savepopup)) {

			Extent_pass(driver, "Shortcut key for `Save` button(ALT+S) is functioning and the records are saved", test,test1);
			click(driver, Click_ok);
		} else {
			Extent_fail(driver, "Shortcut key for `Save` button(ALT+S) is not functioning", test,test1);
		}

		System.out
				.println("//***************************Testcase 43 Completed **************************************//");

		Extent_cal(test, "Testcase 47 - When click ALT+H System should open Global search window");

		wait(driver, "5");

//		rbt.keyPress(KeyEvent.VK_ALT);
//		rbt.delay(500);
//		rbt.keyPress(KeyEvent.VK_H);
//		rbt.delay(1000);
//		rbt.keyRelease(KeyEvent.VK_H);
//		rbt.keyRelease(KeyEvent.VK_ALT);
		
		act.keyDown(Keys.ALT).sendKeys("h").keyUp(Keys.ALT).build().perform();

		wait(driver, "5");

		if (IsElementEnabled(driver, Globalserach_IDInput)) {

			System.out.println("Shortcut key for `Globalserach` button (ALT+H) is functioning");
			Extent_pass(driver, "Shortcut key for `Globalserach` button (ALT+H) is functioning", test,test1);

		} else {

			System.out.println("Shortcut key for `Globalserach` button (ALT+H) is not functioning");
			Extent_fail(driver, "Shortcut key for `Globalserach` button (ALT+H) is not functioning", test,test1);
		}

		System.out
				.println("//***************************Testcase 47 Completed **************************************//");

	
		Extent_cal(test,
				"Testcase 44 - When click `ALT+A` System should allow to save as the same record for different period");

		Fluentwait(driver, Globalserach_IDInput);
		sendKeys(driver, Globalserach_IDInput, ID);

		Fluentwait(driver, Click_Search);
		click(driver, Click_Search);

		wait(driver, "3");

		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);

		wait(driver, "5");
		
		act.keyDown(Keys.ALT).sendKeys("a").keyUp(Keys.ALT).build().perform();

		wait(driver, "5");
		
		if (isDisplayed(driver, Saveas_popup)) {
			
			System.out.println("Shortcut key for `save as` button (ALT+A) is working fine");
			Extent_pass(driver, "Shortcut key for `save as` button (ALT+A) is working fine", test,test1);
		}else {
			System.out.println("Shortcut key for `save as` button (ALT+A) is not working");
			Extent_fail(driver, "Shortcut key for `save as` button (ALT+A) is not working", test,test1);
		}

		System.out
				.println("//***************************Testcase 44 Completed **************************************//");


		Extent_cal(test, "Testcase 45 - When click ALT+I system should allow to edit the record");

		wait(driver, "5");

//		rbt.keyPress(KeyEvent.VK_ALT);
//		rbt.delay(500);
//		rbt.keyPress(KeyEvent.VK_I);
//		rbt.delay(1000);
//		rbt.keyRelease(KeyEvent.VK_I);
//		rbt.keyRelease(KeyEvent.VK_ALT);
		
		act.keyDown(Keys.ALT).sendKeys("i").keyUp(Keys.ALT).build().perform();

		wait(driver, "5");

		if (IsElementEnabled(driver, Save)) {

			System.out.println("Shortcut key for `Edit` button (ALT+I) is functioning");
			Extent_pass(driver, "Shortcut key for `Edit` button (ALT+I) is functioning", test,test1);

		} else {

			System.out.println("Shortcut key for `Edit` button (ALT+I) is not functioning");
			Extent_fail(driver, "Shortcut key for `Edit` button (ALT+I) is not functioning", test,test1);
		}

		System.out
				.println("//***************************Testcase 45 Completed **************************************//");

		Extent_cal(test, "Testcase 46 - When click ALT+E system should cancel the last activity");

		wait(driver, "5");

//		rbt.keyPress(KeyEvent.VK_ALT);
//		rbt.delay(500);
//		rbt.keyPress(KeyEvent.VK_E);
//		rbt.delay(1000);
//		rbt.keyRelease(KeyEvent.VK_E);
//		rbt.keyRelease(KeyEvent.VK_ALT);
		
		act.keyDown(Keys.ALT).sendKeys("e").keyUp(Keys.ALT).build().perform();

		wait(driver, "5");

		if (IsElementEnabled(driver, Globalserach)) {

			System.out.println("Shortcut key for `Cancel` button (ALT+E) is functioning");
			Extent_pass(driver, "Shortcut key for `Cancel` button (ALT+E) is functioning", test,test1);

		} else {

			System.out.println("Shortcut key for `Cancel` button (ALT+E) is not functioning");
			Extent_fail(driver, "Shortcut key for `Cancel` button (ALT+E) is not functioning", test,test1);
		}

		System.out
				.println("//***************************Testcase 46 Completed **************************************//");

		Extent_cal(test, "Testcase 49 - When click ALT+C System should allow to copy the selected data");

		Fluentwait(driver, Globalserach);
		click(driver, Globalserach);

		Fluentwait(driver, Globalserach_IDInput);
		sendKeys(driver, Globalserach_IDInput, ID);

		Fluentwait(driver, Click_Search);
		click(driver, Click_Search);

		wait(driver, "3");
		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);

		wait(driver, "3");

		Fluentwait(driver, Grid_locationfield1);
		click(driver, Grid_locationfield1);

		wait(driver, "3");

//		rbt.keyPress(KeyEvent.VK_CONTROL);
//		rbt.delay(500);
//		rbt.keyPress(KeyEvent.VK_C);
//		rbt.delay(1000);
//		rbt.keyRelease(KeyEvent.VK_C);
//		rbt.keyRelease(KeyEvent.VK_CONTROL);
		
		act.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();

		wait(driver, "5");

		String copiedtext = getcopiedText(driver);

		System.out.println("copiedtext : " + copiedtext);

		String gettext = getText(driver, Grid_locationfield1);
		
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

		System.out.println("Testcase 49 Completed");
		

		Extent_cal(test, "Testcase 50 - When click ALT+V System should allow to paste the copied data");

		try {

			StringSelection stringSelection = new StringSelection(gettext);
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			clipboard.setContents(stringSelection, null);
			System.out.println("Text copied to clipboard: " + gettext);

		} catch (Exception e) {
			e.printStackTrace();
		}

		Fluentwait(driver, Searchbox);
		click(driver, Searchbox);

		wait(driver, "3");

//		rbt.keyPress(KeyEvent.VK_CONTROL);
//		rbt.delay(500);
//		rbt.keyPress(KeyEvent.VK_V);
//		rbt.delay(1000);
//		rbt.keyRelease(KeyEvent.VK_V);
//		rbt.keyRelease(KeyEvent.VK_CONTROL);
		
		act.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();

		wait(driver, "3");

		String value = getAttribute(driver, Search_module, "value");

		System.out.println("value : " + value);

		if (value.equals(gettext)) {
			System.out.println(
					"Matched || Expected pasted value was : " + gettext + " || Actual pasted value was : " + value);
			Extent_pass(driver, "System allowed to paste the copied data by using shortcut key CTRL+V", test,test1);
			Extent_pass(driver,
					"Matched || Expected pasted value was : " + gettext + " || Actual pasted value was : " + value,
					test,test1);
		} else {
			System.out.println(
					"Not Matched || Expected pasted value was : " + gettext + " || Actual pasted value was : " + value);
			Extent_fail(driver, "System not allowed to paste the copied data by using shortcut key CTRL+V", test,test1);
			Extent_fail(driver,
					"Not Matched || Expected pasted value was : " + gettext + " || Actual pasted value was : " + value,
					test,test1);
		}

		System.out.println("Testcase 50 Completed");

		Extent_cal(test, "Testcase 51 - When click ALT+P System should open the jasper window");

		Fluentwait(driver, Globalserach);
		click(driver, Globalserach);

		Fluentwait(driver, Globalserach_IDInput);
		sendKeys(driver, Globalserach_IDInput, ID);

		Fluentwait(driver, Click_Search);
		click(driver, Click_Search);

		wait(driver, "3");
		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);

		wait(driver, "5");

//		rbt.keyPress(KeyEvent.VK_ALT);
//		rbt.delay(500);
//		rbt.keyPress(KeyEvent.VK_P);
//		rbt.delay(1000);
//		rbt.keyRelease(KeyEvent.VK_P);
//		rbt.keyRelease(KeyEvent.VK_ALT);
		
		act.keyDown(Keys.ALT).sendKeys("p").keyUp(Keys.ALT).build().perform();

		wait(driver, "5");

		if (IsElementEnabled(driver, Jasper_popup)) {

			System.out.println("Shortcut key for Jasper_popup button is functioning");
			Extent_pass(driver, "Shortcut key for Jasper_popup button is functioning", test,test1);

		} else {

			System.out.println("Shortcut key for Jasper_popup button is not functioning");
			Extent_fail(driver, "Shortcut key for Jasper_popup button is not functioning", test,test1);
		}

		System.out.println("//***************************Testcase 51 Completed **************************************//");

		
		Extent_cal(test,
				"Testcase 54 - When click ALT+PAGE_UP  System's control should go to First data of the screen");

		Fluentwait(driver, FieldDropdown);
		click(driver, FieldDropdown);

		wait(driver, "5");

//		rbt.keyPress(KeyEvent.VK_ALT);
//		rbt.delay(500);
//		rbt.keyPress(KeyEvent.VK_PAGE_UP);
//		rbt.delay(1000);
//		rbt.keyRelease(KeyEvent.VK_PAGE_UP);
//		rbt.keyRelease(KeyEvent.VK_ALT);
		
		act.keyDown(Keys.ALT).sendKeys(Keys.PAGE_UP).keyUp(Keys.ALT).build().perform();


		wait(driver, "5");

		if (!isDisplayed(driver, FieldDropdown_Inside)) {

			System.out.println("Shortcut key for `Move to first record` button is functioning");
			Extent_pass(driver, "Shortcut key for `Move to first record` button is functioning", test,test1);

		} else {

			System.out.println("Shortcut key for `Move to first record button` is not functioning");
			Extent_fail(driver, "Shortcut key for `Move to first record button` is not functioning", test,test1);
		}

		System.out
				.println("//***************************Testcase 54 Completed **************************************//");

		Extent_cal(test,
				"Testcase 55 - When click ALT+PAGE_DOWN  System's control should go to last data of the screen");

		Fluentwait(driver, FieldDropdown);
		click(driver, FieldDropdown);

		wait(driver, "5");

//		rbt.keyPress(KeyEvent.VK_ALT);
//		rbt.delay(500);
//		rbt.keyPress(KeyEvent.VK_PAGE_DOWN);
//		rbt.delay(1000);
//		rbt.keyRelease(KeyEvent.VK_PAGE_DOWN);
//		rbt.keyRelease(KeyEvent.VK_ALT);
		
		act.keyDown(Keys.ALT).sendKeys(Keys.PAGE_DOWN).keyUp(Keys.ALT).build().perform();

		wait(driver, "5");

		if (!isDisplayed(driver, FieldDropdown_Inside)) {

			System.out.println("Shortcut key for `Move to last record button` is functioning");
			Extent_pass(driver, "Shortcut key for `Move to last record button` is functioning", test,test1);

		} else {

			System.out.println("Shortcut key for `Move to last record button` is not functioning");
			Extent_fail(driver, "Shortcut key for `Move to last record button` is not functioning", test,test1);
		}

		System.out
				.println("//***************************Testcase 55 Completed **************************************//");

			Extent_cal(test, "Testcase 58 - When click CRTL+F4 System should allow to close the screen");
			
			wait(driver,"5");
			
			act.keyDown(Keys.CONTROL).sendKeys(Keys.F4).keyUp(Keys.CONTROL).build().perform();
			
			wait(driver,"5");
			
			if(!isDisplayed(driver, FieldDropdown_Inside)) {
				
				System.out.println("Shortcut key for close the screen is functioning");
				Extent_pass(driver, "Shortcut key for close the screen is functioning", test,test1);
				
			}else {
				
				System.out.println("Shortcut key for close the screen is not functioning");
				Extent_fail(driver,"Shortcut key for close the screen is not functioning", test,test1);
			}
			

	}

}
