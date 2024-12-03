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

public class TS_001_Tc_001toTc_015_ERO_Deviation_report extends Keywords{
	public void Scenario01to15(WebDriver driver, ExtentTest test,ExtentTest test1,String url, int dataset) throws AWTException, IOException, InterruptedException {	
	
	System.out.println("url : "+url);
	
	String Username = Utils.getDataFromTestData("TS_001_Tc_001toTc_015_ERO_Dataset"+dataset, "ERO_Deviation_report", "Username");
	String Password = Utils.getDataFromTestData("TS_001_Tc_001toTc_015_ERO_Dataset"+dataset, "ERO_Deviation_report", "Password");
	String ID = Utils.getDataFromTestData("TS_001_Tc_001toTc_015_ERO_Dataset"+dataset, "ERO_Deviation_report", "Id");
	
	
	
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
		
		
		
		
		
		Extent_cal(test, "Testcase 1 - When Open the new screen,New,Search and close buttons should be in Enable status");
		
		
		
		if(IsElementEnabled(driver, Close_Tab_Report)) {
			
			System.out.println("After opening the new screen, the Close tab button is in enable status");
			Extent_pass(driver, "After opening the new screen, the Close tab button is in enable status", test,test1);
			
		}else {
			
			System.out.println("After opening the new screen, the Close tab button is not in enable status");
			Extent_fail(driver, "After opening the new screen, the Close tab button is not in enable status", test,test1);
		}
		
		System.out.println("//***************************Testcase 1 Completed **************************************//");

	
		
		Extent_cal(test, "Testcase 2 - Ensure while click new button,Save,cancel and close button should be in enable Status");
	
		click(driver, Cancel_Report);
		
		Fluentwait(driver, New_Report);
		click(driver, New_Report);
		
		
		Fluentwait(driver, Create_New_Confirm1);
		click(driver, Create_New_Confirm1);
		
		wait(driver,"5");

		
		
if(IsElementEnabled(driver, Cancel_Report)) {
			
			System.out.println("After Click the new Button, the Cancel  button is in enable status");
			Extent_pass(driver, "After Click the new Button, the Cancel button is in enable status", test,test1);
			
		}else {
			
			System.out.println("After Click the  new Button, the Cancel  button  is not in enable status");
			Extent_fail(driver, "After Click  new Button, the Cancel  button  is not in enable status", test,test1);
		}
		



if(IsElementEnabled(driver, Close_Tab_Report)) {
	
	System.out.println("After Click the new Button, the Close tab button is in enable status");
	Extent_pass(driver, "After Click the new Button, the Close tab button is in enable status", test,test1);
	
}else {
	
	System.out.println("After Click the new Button, the Close tab button is not in enable status");
	Extent_fail(driver, "After Click the new Button, the Close tab button is not in enable status", test,test1);
}

System.out.println("//***************************Testcase 2 Completed **************************************//");


Extent_cal(test, "Testcase 7 - Ensure screen enable New, search and close button  when click cancel button");



click(driver, Cancel_Report);

Fluentwait(driver, New_Report);
click(driver, New_Report);


Fluentwait(driver, Create_New_Confirm1);
click(driver, Create_New_Confirm1);

wait(driver,"5");


click(driver, Cancel_Report);


if(IsElementEnabled(driver, Close_Tab_Report)) {
	
	System.out.println("After click the Cancel Button, the Close tab button is in enable status");
	Extent_pass(driver, "After click the Cancel Button, the Close tab button is in enable status", test,test1);
	
}else {
	
	System.out.println("After click the Cancel Button, the Close tab button is not in enable status");
	Extent_fail(driver, "After click the Cancel Button, the Close tab button is not in enable status", test,test1);
}

System.out.println("//***************************Testcase 7 Completed **************************************//");





Extent_cal(test, "Testcase 8 - Ensure Screen enable New, edit , search and close button when click Search button");






Fluentwait(driver, New_Report);
click(driver, New_Report);


Fluentwait(driver, Create_New_Confirm1);
click(driver, Create_New_Confirm1);



wait(driver,"3");


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



if(IsElementEnabled(driver, Close_Tab_Report)) {
	
	System.out.println("After click Search Button, the Close tab button is in enable status");
	Extent_pass(driver, "After click Search Button, the Close tab button is in enable status", test,test1);
	
}else {
	
	System.out.println("After click Search Button, the Close tab button is not in enable status");
	Extent_fail(driver, "After click Search Button, the Close tab button is not in enable status", test,test1);
}



wait(driver,"3");


if(IsElementEnabled(driver, Search2)) {
	
	System.out.println("After click Search Button, the Second Search button is in enable status");
	Extent_pass(driver, "After click Search Button, the Second Search button is in enable status", test,test1);
	
}else {
	
	System.out.println("After click Search Button, the Second Search is not in enable status");
	Extent_fail(driver, "After click Search Button, the Second Search is not in enable status", test,test1);
}

wait(driver,"3");



if(IsElementEnabled(driver, Search3)) {
	
	System.out.println("After click Search Button, the Third Search button is in enable status");
	Extent_pass(driver, "After click Search Button, the Third Search button is in enable status", test,test1);
	
}else {
	
	System.out.println("After click Search Button, the Third Search is not in enable status");
	Extent_fail(driver, "After click Search Button, the Third Search is not in enable status", test,test1);
}

wait(driver,"3");


if(IsElementEnabled(driver, Search4)) {
	
	System.out.println("After click Search Button, the Fourth Search button is in enable status");
	Extent_pass(driver, "After click Search Button, the Fourth Search button is in enable status", test,test1);
	
}else {
	
	System.out.println("After click Search Button, the Fourth Search is not in enable status");
	Extent_fail(driver, "After click Search Button, the Fourth Search is not in enable status", test,test1);
}




System.out.println("//***************************Testcase 8 Completed **************************************//");



Extent_cal(test, "Testcase 15 - Ensure System should close the screen,when click close button");

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


System.out.println("//***************************Testcase 15 Completed **************************************//");

	
	}
}
