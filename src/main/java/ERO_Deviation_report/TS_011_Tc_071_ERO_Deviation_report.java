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

public class TS_011_Tc_071_ERO_Deviation_report extends Keywords{
	public void Scenario011(WebDriver driver, ExtentTest test,ExtentTest test1,String url, int dataset) throws AWTException, IOException, InterruptedException {	
	
	System.out.println("url : "+url);
	
	String Username = Utils.getDataFromTestData("TS_011_Tc_071_ERO_Dataset"+dataset, "ERO_Deviation_report", "Username");
	String Password = Utils.getDataFromTestData("TS_011_Tc_071_ERO_Dataset"+dataset, "ERO_Deviation_report", "Password");
	String ID = Utils.getDataFromTestData("TS_011_Tc_071_ERO_Dataset"+dataset, "ERO_Deviation_report", "Id");
	String Confirmation_Popup = Utils.getDataFromTestData("TS_011_Tc_071_ERO_Dataset"+dataset, "ERO_Deviation_report", "ConfirmPopup");




	
	
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
		
		
		
		Extent_cal(test, "Testcase 71 - Ensure all button functionalities working");
		
		
		Extent_cal(test, "Button1");

click(driver, Cancel_Report);
wait(driver,"3");



if(IsElementEnabled(driver, New_Report)) {
	
	System.out.println("After click the Cancel Button, New button is in enable status");
	Extent_pass(driver, "After click the Cancel Button, New button is in enable status", test,test1);
	
}else {
	
	System.out.println("After click the Cancel Button, New button is not in enable status");
	Extent_fail(driver, "After click the Cancel Button, New button is not in enable status", test,test1);
}


Extent_cal(test, "Button2");

		Fluentwait(driver, New_Report);
		click(driver, New_Report);
		
		
		
		Fluentwait(driver, Popup_Msg_Report);
		String Confirm_Popup = getText(driver, Popup_Msg_Report);

		if (Confirm_Popup.equals(Confirmation_Popup)) {
			System.out.println(
					"Matched || Expected Information popup message of creating new was : " + Confirmation_Popup
							+ " || Actual Information popup message of creating new was : " + Confirm_Popup);
			Extent_pass(driver,
					"Matched || Expected Information popup message of creating new was : " + Confirmation_Popup
							+ " || Actual Information popup message of creating new was : " + Confirm_Popup,
					test,test1);
		} else {
			System.out.println("Not Matched || Expected Information popup message of creating new was : "
					+ Confirmation_Popup + " || Actual Information popup message of creating new was : "
					+ Confirm_Popup);
			Extent_fail2(driver,
					"Not Matched || Expected Information popup message of creating new was : "
							+ Confirmation_Popup + " || Actual Information popup message of creating new was : "
							+ Confirm_Popup,
					test);

		}

		
		
		
		Fluentwait(driver, Create_New_Confirm1);
		click(driver, Create_New_Confirm1);
		
		wait(driver,"5");
		
if(IsElementEnabled(driver, Cancel_Report)) {
			
			System.out.println("After opening the new Button, the Cancel  button is in enable status");
			Extent_pass(driver, "fter opening the new Button, the Cancel button is in enable status", test,test1);
			
		}else {
			
			System.out.println("After opening the  new Button, the Cancel  button  is not in enable status");
			Extent_fail(driver, "After opening  new Button, the Cancel  button  is not in enable status", test,test1);
		}
		
		
		
		
		
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
		wait(driver,"4");

		
		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);
		
		wait(driver,"5");
		
		
		Fluentwait(driver, Search4);
		click(driver, Search4);
		wait(driver,"5");

		
		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);
		
		wait(driver,"5");
		
		
		
		Extent_cal(test, "Button3");

		wait(driver,"3");

		
		//Verify_FileDownloaded(driver, "ERD", Export_Report);
		
		click(driver, Export_Report);
		
		Verifydownload(driver, "ERD");		
				
		System.out.println("******************Testcase 71 Completed ***********************");
	
		
	}
}
