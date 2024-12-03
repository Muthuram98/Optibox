package ERO_Mass_Cost_Update;

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

public class TS_011_Tc_071_ERO_Mass_Cost_Update extends Keywords{
	public void Scenario011(WebDriver driver, ExtentTest test,ExtentTest test1,String url, int dataset) throws AWTException, IOException, InterruptedException {	
	
	System.out.println("url : "+url);
	
	String Username = Utils.getDataFromTestData("TS_011_Tc_071_ERO_Mass_Cost_Update_Dataset"+dataset, "ero_mass_cost_update", "Username");
	String Password = Utils.getDataFromTestData("TS_011_Tc_071_ERO_Mass_Cost_Update_Dataset"+dataset, "ero_mass_cost_update", "Password");
	String ID = Utils.getDataFromTestData("TS_011_Tc_071_ERO_Mass_Cost_Update_Dataset"+dataset, "ero_mass_cost_update", "Id");
	String Confirmation_Popup = Utils.getDataFromTestData("TS_011_Tc_071_ERO_Mass_Cost_Update_Dataset"+dataset, "ero_mass_cost_update", "ConfirmPopup");

	
	
	 navigateUrl(driver, url);
		
		Fluentwait(driver, Username_input2);
		sendKeys(driver, Username_input2, Username);
		
		Fluentwait(driver, Password_input2);
		sendKeys(driver, Password_input2, Password);
		
		Fluentwait(driver, SignIn2);
		click(driver, SignIn2);
		
		wait(driver,"5");
		
		if(isDisplayed(driver, session_confirmation2)) {
			Fluentwait(driver, session_confirmation2);
			click(driver, session_confirmation2);
		}
		
		Fluentwait(driver, Searchbox2);
		sendKeys(driver, Searchbox2, "ERO Mass Cost Update");
		
		Fluentwait(driver, Select_MassCostUpdate);
		click(driver, Select_MassCostUpdate);
		
		wait(driver,"3");
		
		
		
Extent_cal(test, "Testcase 71 - Ensure all button functionalities working");
		
		
		Extent_cal(test, "Button1");

click(driver, Cancel_Button);
		
wait(driver,"3");



if(IsElementEnabled(driver, NewReport)) {
	
	System.out.println("After click the Cancel Button, New button is in enable status");
	Extent_pass(driver, "After click the Cancel Button, New button is in enable status", test,test1);
	
}else {
	
	System.out.println("After click the Cancel Button, New button is not in enable status");
	Extent_fail(driver, "After click the Cancel Button, New button is not in enable status", test,test1);
}


Extent_cal(test, "Button2");

Fluentwait(driver, NewReport);
click(driver, NewReport);
		
		
		Fluentwait(driver, Popup_Msg_Report1);
		String Confirm_Popup = getText(driver, Popup_Msg_Report1);

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

		
		Extent_cal(test, "Button3");

		
		Fluentwait(driver, Click_Confirm);
		click(driver, Click_Confirm);
		
		wait(driver,"5");
		
if(IsElementEnabled(driver, Cancel_Button)) {
			
			System.out.println("After opening the new Button, the Cancel  button is in enable status");
			Extent_pass(driver, "After opening the new Button, the Cancel button is in enable status", test,test1);
			
		}else {
			
			System.out.println("After opening the  new Button, the Cancel  button  is not in enable status");
			Extent_fail(driver, "After opening  new Button, the Cancel  button  is not in enable status", test,test1);
		}
		
		

if(IsElementEnabled(driver, Click_Save)) {
	
	System.out.println("After opening the new Button, the Save  button is in enable status");
	Extent_pass(driver, "After opening the new Button, the Save button is in enable status", test,test1);
	
}else {
	
	System.out.println("After opening the  new Button, the Save  button  is not in enable status");
	Extent_fail(driver, "After opening  new Button, the Save  button  is not in enable status", test,test1);
}




wait(driver,"5");



Fluentwait(driver, Add_Plus_Button);
click(driver, Add_Plus_Button);


wait(driver,"3");

Fluentwait(driver, Select_Loc);
doubleClick(driver, Select_Loc);

wait(driver,"3");


Extent_cal(test, "Button4");


click(driver, ShowButton);

wait(driver,"3");


if(IsElementEnabled(driver, EditButton)) {
	
	System.out.println("After opening the new Button, the Edit button is in enable status");
	Extent_pass(driver, "fter opening the new Button, the Edit button is in enable status", test,test1);
	
}else {
	
	System.out.println("After opening the  new Button, the Edit button  is not in enable status");
	Extent_fail(driver, "After opening  new Button, the Edit button  is not in enable status", test,test1);
}

if(IsElementEnabled(driver, NewReport)) {
	
	System.out.println("After click the Cancel Button, New button is in enable status");
	Extent_pass(driver, "After click the Cancel Button, New button is in enable status", test,test1);
	
}else {
	
	System.out.println("After click the Cancel Button, New button is not in enable status");
	Extent_fail(driver, "After click the Cancel Button, New button is not in enable status", test,test1);
}



click(driver, EditButton);

wait(driver,"3");


if(IsElementEnabled(driver, Click_Save)) {
	
	System.out.println("After opening the new Button, the Save  button is in enable status");
	Extent_pass(driver, "After opening the new Button, the Save button is in enable status", test,test1);
	
}else {
	
	System.out.println("After opening the  new Button, the Save  button  is not in enable status");
	Extent_fail(driver, "After opening  new Button, the Save  button  is not in enable status", test,test1);
}

if(IsElementEnabled(driver, Cancel_Button)) {
	
	System.out.println("After opening the new Button, the Cancel  button is in enable status");
	Extent_pass(driver, "After opening the new Button, the Cancel button is in enable status", test,test1);
	
}else {
	
	System.out.println("After opening the  new Button, the Cancel  button  is not in enable status");
	Extent_fail(driver, "After opening  new Button, the Cancel  button  is not in enable status", test,test1);
}
System.out.println("******************Testcase 71 Completed ***********************");

		
	}
}
