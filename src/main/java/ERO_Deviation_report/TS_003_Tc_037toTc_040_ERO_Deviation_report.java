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

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.Utils;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class TS_003_Tc_037toTc_040_ERO_Deviation_report extends Keywords{
	public void Scenario03(WebDriver driver, ExtentTest test,ExtentTest test1,String url, int dataset) throws AWTException, IOException, InterruptedException {	
	
	System.out.println("url : "+url);
	
	String Username = Utils.getDataFromTestData("TS_003_Tc_037toTc_040_ERO_Dataset"+dataset, "ERO_Deviation_report", "Username");
	String Password = Utils.getDataFromTestData("TS_003_Tc_037toTc_040_ERO_Dataset"+dataset, "ERO_Deviation_report", "Password");
	String ID = Utils.getDataFromTestData("TS_003_Tc_037toTc_040_ERO_Dataset"+dataset, "ERO_Deviation_report", "Id");
	
	
	
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
		
		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);
		
		wait(driver,"5");
		
		Fluentwait(driver, Search3);
		click(driver, Search3);
		wait(driver,"5");

		
		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);
		
		wait(driver,"5");
		
		
		Fluentwait(driver, Search4);
		click(driver, Search4);
		
		
		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);
		
		wait(driver,"5");
		
				
		
		
		
		Extent_cal(test, "Testcase 39 - Ensure Scroll up and down functionality in Grids");


		wait(driver, "3");

		//Fluentwait(driver, Scroll_Deficit);

		ScrollBarValidation1(driver, Scroll1, "Grid scroll");
		
		
		
		wait(driver, "3");


		ScrollBarValidation1(driver, Scroll2, "Grid scroll1");
		
		
		
		System.out
		.println("//***************************Testcase 32 Completed **************************************//");

Extent_cal(test, "Testcase 40 - Ensure Close button functionality");

wait(driver, "3");


// scrollBottom(driver);

waitForElement(driver, Close_Tab_Report);
click(driver, Close_Tab_Report);

wait(driver, "3");

if (!isDisplayed(driver, Deviation_Tab)) {

	System.out.println("After click on close button Current screen was closed");
	Extent_pass(driver, "After click on close button Current screen was closed", test, test1);

} else {

	System.out.println("After click on close button Current screen was not closed");
	Extent_fail(driver, "After click on close button Current screen was not closed", test, test1);
}

System.out
		.println("//***************************Testcase 40 Completed **************************************//");





}
}
