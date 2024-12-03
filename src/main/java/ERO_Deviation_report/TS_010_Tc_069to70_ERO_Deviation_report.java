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
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.Utils;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class TS_010_Tc_069to70_ERO_Deviation_report extends Keywords{
	public void Scenario10(WebDriver driver, ExtentTest test,ExtentTest test1,String url, int dataset) throws AWTException, IOException, InterruptedException {	
	
	System.out.println("url : "+url);
	
	String Username = Utils.getDataFromTestData("TS_010_Tc_069toTc_070_ERO_Dataset"+dataset, "ERO_Deviation_report", "Username");
	String Password = Utils.getDataFromTestData("TS_010_Tc_069toTc_070_ERO_Dataset"+dataset, "ERO_Deviation_report", "Password");
	String ID = Utils.getDataFromTestData("TS_010_Tc_069toTc_070_ERO_Dataset"+dataset, "ERO_Deviation_report", "Id");
	String Copied_Text = Utils.getDataFromTestData("TS_010_Tc_069toTc_070_ERO_Dataset"+dataset, "ERO_Deviation_report", "Copiedtext");

	
	Actions act = new Actions(driver);
	Robot rbt = new Robot();
	
	
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
		
		wait(driver,"3");
		
		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);
		
		wait(driver,"5");
		
		
		Fluentwait(driver, Search2);
		click(driver, Search2);
		wait(driver,"3");

		
		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);
		
		wait(driver,"5");
		
		Fluentwait(driver, Search3);
		click(driver, Search3);
		
		wait(driver,"3");

		
		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);
		
		wait(driver,"5");
		
		
		Fluentwait(driver, Search4);
		click(driver, Search4);
		wait(driver,"3");

		
		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);
		
		wait(driver,"5");
		
		
		
		
		Extent_cal(test, "Testcase 69 - Ensure Scientific grid allows to paste the copied record in grid itself");

		Fluentwait(driver, Grid_Cell);
		click(driver, Grid_Cell);

		String textToCopy = Copied_Text;
		
		
		
		// Create a StringSelection object with the text
		StringSelection stringSelection = new StringSelection(textToCopy);

		// Get the system clipboard
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

		// Set the content of the clipboard to the string
		clipboard.setContents(stringSelection, null);

		System.out.println("Text copied to clipboard: " + textToCopy);

/*		
		rbt.keyPress(KeyEvent.VK_CONTROL);
	rbt.delay(500);
	rbt.keyPress(KeyEvent.VK_C);
		
		act.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();
		*/
		wait(driver, "2");


Fluentwait(driver, Edit_Field2);
		click(driver,Edit_Field2 );

		wait(driver, "2");

		act.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();

		wait(driver, "2");

		try {
			String inputvalue = getText(driver, Paste_Grid);

			System.out.println("inputvalue : " + inputvalue);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (isDisplayed(driver, Paste_Grid)) {

			System.out.println("Grid filter accept to paste the copied data");
			Extent_pass(driver, "Grid filter accept to paste the copied data", test,test1);

		} else {

			System.out.println("Grid filter not accept to paste the copied data");
			Extent_fail(driver, "Grid filter not accept to paste the copied data", test,test1);
			
		}
		
		act.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
		wait(driver, "2");
		act.sendKeys(Keys.BACK_SPACE).perform();

		System.out.println(" ************************Testcase 69 - Completed *************************");
				
	}
}
