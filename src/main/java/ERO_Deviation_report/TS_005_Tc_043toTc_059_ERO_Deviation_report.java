package ERO_Deviation_report;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.Utils;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class TS_005_Tc_043toTc_059_ERO_Deviation_report extends Keywords{
	public void Scenario005(WebDriver driver, ExtentTest test,ExtentTest test1,String url, int dataset) throws AWTException, IOException, InterruptedException {	
	
	System.out.println("url : "+url);
	
	String Username = Utils.getDataFromTestData("TS_005_Tc_043toTc_059_ERO_Dataset"+dataset, "ERO_Deviation_report", "Username");
	String Password = Utils.getDataFromTestData("TS_005_Tc_043toTc_059_ERO_Dataset"+dataset, "ERO_Deviation_report", "Password");
	String ID = Utils.getDataFromTestData("TS_005_Tc_043toTc_059_ERO_Dataset"+dataset, "ERO_Deviation_report", "Id");
	

	WebDriverWait wait = new WebDriverWait(driver, 60);
	Actions act = new Actions(driver);
	
	 navigateUrl(driver, url);
		
		Fluentwait(driver, Username_input1);
		sendKeys(driver, Username_input1, Username);
		
		Fluentwait(driver, Password_input1);
		sendKeys(driver, Password_input1, Password);
		
		Fluentwait(driver, SignIn1);
		click(driver, SignIn1);
		
		wait(driver,"5");
		
		if(isDisplayed(driver, session_confirmation1)) {
			Fluentwait(driver, session_confirmation1);
			click(driver, session_confirmation1);
		}
		
		Fluentwait(driver, Searchbox1);
		sendKeys(driver, Searchbox1, "ERO Deviation report");
		
		Fluentwait(driver, Select_Deviation);
		click(driver, Select_Deviation);
		
		wait(driver,"3");
		
		click(driver, Cancel_Report);

		//Fluentwait(driver, New_Report);
		//click(driver, New_Report);
		
		
		Extent_cal(test, "Testcase 43 - when we click ALT+N,System should allow to create new record");

		
		wait(driver, "5");

		Robot rbt = new Robot();
//		wait(driver,"3");
//		rbt.keyPress(KeyEvent.VK_ALT);
//		rbt.delay(500);
//		rbt.keyPress(KeyEvent.VK_N);
//		rbt.delay(1000);
//		rbt.keyRelease(KeyEvent.VK_N);
//		rbt.keyRelease(KeyEvent.VK_ALT);
		
		act.keyDown(Keys.ALT).sendKeys("n").keyUp(Keys.ALT).build().perform();

		wait(driver, "5");

		if (isDisplayed(driver, Create_New_Confirm1)) {

			Extent_pass(driver, "Shortcut key for `New` button(ALT+N) is functioning and new record was created", test,test1);
			click(driver, Create_New_Confirm1);
		} else {
			Extent_fail(driver, "Shortcut key for `New` button(ALT+N) is not functioning", test,test1);
		}
		
		

		System.out
				.println("//***************************Testcase 43 Completed **************************************//");
		
		
		Extent_cal(test, "Testcase 47 - When click ALT+E system should cancel the last activity");

		wait(driver, "5");

//		rbt.keyPress(KeyEvent.VK_ALT);
//		rbt.delay(500);
//		rbt.keyPress(KeyEvent.VK_E);
//		rbt.delay(1000);
//		rbt.keyRelease(KeyEvent.VK_E);
//		rbt.keyRelease(KeyEvent.VK_ALT);
		
		act.keyDown(Keys.ALT).sendKeys("e").keyUp(Keys.ALT).build().perform();

		wait(driver, "5");

		if (IsElementEnabled(driver, New_Report)) {

			System.out.println("Shortcut key for `Cancel` button (ALT+E) is functioning");
			Extent_pass(driver, "Shortcut key for `Cancel` button (ALT+E) is functioning", test,test1);

		} else {

			System.out.println("Shortcut key for `Cancel` button (ALT+E) is not functioning");
			Extent_fail(driver, "Shortcut key for `Cancel` button (ALT+E) is not functioning", test,test1);
		}

		System.out
				.println("//***************************Testcase 47 Completed **************************************//");
		
		
		/*
	
		Extent_cal(test, "Testcase 59 - When click CRTL+F4 System should allow to close the screen");
		
		wait(driver,"5");
		
//		rbt.keyPress(KeyEvent.VK_CONTROL);
//		rbt.delay(500);
//		rbt.keyPress(KeyEvent.VK_F4);
//		rbt.delay(1000);
//		rbt.keyRelease(KeyEvent.VK_F4);
//		rbt.keyRelease(KeyEvent.VK_CONTROL);
		
		act.keyDown(Keys.CONTROL).sendKeys(Keys.F4).keyUp(Keys.CONTROL).build().perform();
		
		wait(driver,"5");
		
		if(!isDisplayed(driver, New_Report)) {
			
			System.out.println("Shortcut key for close the screen is functioning");
			Extent_pass(driver, "Shortcut key for close the screen is functioning", test,test1);
			
		}else {
			
			System.out.println("Shortcut key for close the screen is not functioning");
			Extent_fail(driver,"Shortcut key for close the screen is not functioning", test,test1);
		}
		
		
				*/
		
		
		Extent_cal(test, "Testcase 50 - When click ALT+C System should allow to copy the selected data");

		
		
		
		Fluentwait(driver, New_Report);
		click(driver, New_Report);
		
		
		Fluentwait(driver, Create_New_Confirm1);
		click(driver, Create_New_Confirm1);
		
		wait(driver,"5");
		
		
		
		Fluentwait(driver, Search1);
		click(driver, Search1);
		
		
		Fluentwait(driver, Globalserach_IDInput);
		sendKeys(driver, Globalserach_IDInput, ID);
		
		wait(driver,"2");	
		
		Fluentwait(driver, Click_Search);
		click(driver, Click_Search);
		
		
		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);
		
		wait(driver,"5");
		
		
		
		Fluentwait(driver,Search_Filed1);
doubleClick(driver, Search_Filed1);


act.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();

wait(driver,"3");

		
	act.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();
		
		
		

		wait(driver, "5");

		String copiedtext = getcopiedText(driver);

		System.out.println("copiedtext : " + copiedtext);

		String gettext = getAttribute(driver, Search_Filed1, "value");
		
		
		String actualcopied = copiedtext;

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

		System.out
		.println("//***************************Testcase 50 Completed **************************************//");
		
		
		
		Extent_cal(test, "Testcase 51 - When click ALT+V System should allow to paste the copied data");

		
		try {

			StringSelection stringSelection = new StringSelection(gettext);
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			clipboard.setContents(stringSelection, null);
			System.out.println("Text copied to clipboard: " + gettext);

		} catch (Exception e) {
			e.printStackTrace();
		}

		
		
wait(driver,"3");
		
		
Fluentwait(driver, Searchbox1);
click(driver, Searchbox1);
wait(driver, "3");


act.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();

wait(driver, "3");

String value = getAttribute(driver, Search_module_Report, "value");

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

System.out
.println("//***************************Testcase 51 Completed **************************************//");
		

		
		

}

}
