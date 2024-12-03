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

public class TS_001_Tc_001toTc_015_ERO_Mass_Cost_Update extends Keywords{
	public void Scenario001(WebDriver driver, ExtentTest test,ExtentTest test1,String url, int dataset) throws AWTException, IOException, InterruptedException {	
	
	System.out.println("url : "+url);
	
	String Username = Utils.getDataFromTestData("TS_001_Tc_001toTc_015_ERO_Mass_Cost_Update_Dataset"+dataset, "ero_mass_cost_update", "Username");
	String Password = Utils.getDataFromTestData("TS_001_Tc_001toTc_015_ERO_Mass_Cost_Update_Dataset"+dataset, "ero_mass_cost_update", "Password");
	String ID = Utils.getDataFromTestData("TS_001_Tc_001toTc_015_ERO_Mass_Cost_Update_Dataset"+dataset, "ero_mass_cost_update", "Id");
	
	
	
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
		
		
		
		Extent_cal(test, "Testcase 1 - When Open the new screen,New,Search and close buttons should be in Enable status");
		
			if(IsElementEnabled(driver, CloseTab_Update)) {
			
			System.out.println("After opening the new screen, the Close tab button is in enable status");
			Extent_pass(driver, "After opening the new screen, the Close tab button is in enable status", test,test1);
			
		}else {
			
			System.out.println("After opening the new screen, the Close tab button is not in enable status");
			Extent_fail(driver, "After opening the new screen, the Close tab button is not in enable status", test,test1);
		}
		
		System.out.println("//***************************Testcase 1 Completed **************************************//");

	
		Extent_cal(test, "Testcase 2 - Ensure while click new button,Save,cancel and close button should be in enable Status");
		
		click(driver, Cancel_Button);
		
		Fluentwait(driver, NewReport);
		click(driver, NewReport);
		
		
		Fluentwait(driver, Click_Confirm);
		click(driver, Click_Confirm);
		
		wait(driver,"5");

		
if(IsElementEnabled(driver, Click_Save)) {
			
			System.out.println("After opening the new Button, the Save button is in enable status");
			Extent_pass(driver, "After opening the new Button, the Save button is in enable status", test,test1);
			
		}else {
			
			System.out.println("After opening the  new Button, the Save  button  is not in enable status");
			Extent_fail(driver, "After opening  new Button, the Save  button  is not in enable status", test,test1);
		}
		
		
if(IsElementEnabled(driver, Cancel_Button)) {
			
			System.out.println("After opening the new Button, the Cancel  button is in enable status");
			Extent_pass(driver, "After opening the new Button, the Cancel button is in enable status", test,test1);
			
		}else {
			
			System.out.println("After opening the  new Button, the Cancel button  is not in enable status");
			Extent_fail(driver, "After opening  new Button, the Cancel button  is not in enable status", test,test1);
		}
		



if(IsElementEnabled(driver, CloseTab_Update)) {
	
	System.out.println("After opening the new screen, the Close tab button is in enable status");
	Extent_pass(driver, "After opening the new screen, the Close tab button is in enable status", test,test1);
	
}else {
	
	System.out.println("After opening the new screen, the Close tab button is not in enable status");
	Extent_fail(driver, "After opening the new screen, the Close tab button is not in enable status", test,test1);
}

System.out.println("//***************************Testcase 2 Completed **************************************//");




Extent_cal(test, "Testcase 4 - Ensure While click grid record, new,Edit and Search and close buttons should be in enable status");


		Fluentwait(driver, Add_Plus_Button);
		click(driver, Add_Plus_Button);
		
		
		wait(driver,"3");

		Fluentwait(driver, Select_Loc);
		doubleClick(driver, Select_Loc);
		
		wait(driver,"3");

		
		click(driver, ShowButton);
		
		wait(driver,"3");
		
		
		Fluentwait(driver, Grid_Rec1);
		doubleClick(driver, Grid_Rec1);
		
		wait(driver,"3");

		
		
if(IsElementEnabled(driver, NewReport)) {
			
			System.out.println("After click the Grid Record, the New button is in enable status");
			Extent_pass(driver, "After click the Grid Record, the New button is in enable status", test,test1);
			
		}else {
			
			System.out.println("After click the Grid Record, the New  button  is not in enable status");
			Extent_fail(driver, "After click the Grid Record, the New button  is not in enable status", test,test1);
		}
		
		
if(IsElementEnabled(driver, EditButton)) {
			
			System.out.println("After click the Grid Record, the Edit button is in enable status");
			Extent_pass(driver, "After click the Grid Record, the Edit button is in enable status", test,test1);
			
		}else {
			
			System.out.println("After click the Grid Record, the Edit button  is not in enable status");
			Extent_fail(driver, "After click the Grid Record, the Edit button  is not in enable status", test,test1);
		}
		



if(IsElementEnabled(driver, CloseTab_Update)) {
	
	System.out.println("After click the Grid Record, the Close tab button is in enable status");
	Extent_pass(driver, "After click the Grid Record, the Close tab button is in enable status", test,test1);
	
}else {
	
	System.out.println("After click the Grid Record, the Close tab button is not in enable status");
	Extent_fail(driver, "After click the Grid Record, the Close tab button is not in enable status", test,test1);
}	
		

		


System.out.println("//***************************Testcase 4 Completed **************************************//");



Extent_cal(test, "Testcase 5 - Ensure screen enable save , cancel , close and search button while click Edit button");


click(driver, EditButton);

wait(driver,"3");



if(IsElementEnabled(driver, Click_Save)) {
	
	System.out.println("After click the Edit Button, the Save button is in enable status");
	Extent_pass(driver, "After click the Edit Button, the Save button is in enable status", test,test1);
	
}else {
	
	System.out.println("After click the Edit Button, the Save  button  is not in enable status");
	Extent_fail(driver, "After click the Edit Button, the Save  button  is not in enable status", test,test1);
}


if(IsElementEnabled(driver, Cancel_Button)) {
	
	System.out.println("After click the Edit Button, the Cancel  button is in enable status");
	Extent_pass(driver, "After click the Edit Button, the Cancel button is in enable status", test,test1);
	
}else {
	
	System.out.println("After click the Edit Button, the Cancel button  is not in enable status");
	Extent_fail(driver, "After click the Edit Button, the Cancel button  is not in enable status", test,test1);
}



if(IsElementEnabled(driver, Globalsearchcostupdate)) {

System.out.println("After click the Edit Button, the Search button is in enable status");
Extent_pass(driver, "After click the Edit Button, the Search button is in enable status", test,test1);

}else {

System.out.println("After click the Edit Button, the Search button is not in enable status");
Extent_fail(driver, "After click the Edit Button, the Search button is not in enable status", test,test1);
}





if(IsElementEnabled(driver, CloseTab_Update)) {

System.out.println("After click the Edit Button, the Close tab button is in enable status");
Extent_pass(driver, "After click the Edit Button, the Close tab button is in enable status", test,test1);

}else {

System.out.println("After click the Edit Button, the Close tab button is not in enable status");
Extent_fail(driver, "After click the Edit Button, the Close tab button is not in enable status", test,test1);
}



System.out.println("//***************************Testcase 5 Completed **************************************//");



Extent_cal(test, "Testcase 6 - Ensure screen enable New, search and close button  when click cancel button");


Fluentwait(driver, Cancel_Button);
click(driver, Cancel_Button);


if(IsElementEnabled(driver, NewReport)) {
	
	System.out.println("After click the Cancel Button, the New button is in enable status");
	Extent_pass(driver, "After click the Cancel Button, the New button is in enable status", test,test1);
	
}else {
	
	System.out.println("After click the Cancel Button, the New  button  is not in enable status");
	Extent_fail(driver, "After click the Cancel Button, the New button  is not in enable status", test,test1);
}


if(IsElementEnabled(driver, CloseTab_Update)) {

System.out.println("After click the Cancel Button, the Close tab button is in enable status");
Extent_pass(driver, "After click the Cancel Button, the Close tab button is in enable status", test,test1);

}else {

System.out.println("After click the Cancel Button, the Close tab button is not in enable status");
Extent_fail(driver, "After click the Cancel Button, the Close tab button is not in enable status", test,test1);
}



System.out.println("//***************************Testcase 6 Completed **************************************//");




Extent_cal(test, "Testcase 7 - Ensure screen enable New, search and close button  when click cancel button");


wait(driver,"5");

Fluentwait(driver, NewReport);
click(driver, NewReport);


Fluentwait(driver, Click_Confirm);
click(driver, Click_Confirm);

wait(driver,"5");




Fluentwait(driver, Cancel_Button);
click(driver, Cancel_Button);


if(IsElementEnabled(driver, NewReport)) {
	
	System.out.println("After click the Cancel Button, the New button is in enable status");
	Extent_pass(driver, "After click the Cancel Button, the New button is in enable status", test,test1);
	
}else {
	
	System.out.println("After click the Cancel Button, the New  button  is not in enable status");
	Extent_fail(driver, "After click the Cancel Button, the New button  is not in enable status", test,test1);
}


if(IsElementEnabled(driver, CloseTab_Update)) {

System.out.println("After click the Cancel Button, the Close tab button is in enable status");
Extent_pass(driver, "After click the Cancel Button, the Close tab button is in enable status", test,test1);

}else {

System.out.println("After click the Cancel Button, the Close tab button is not in enable status");
Extent_fail(driver, "After click the Cancel Button, the Close tab button is not in enable status", test,test1);
}



System.out.println("//***************************Testcase 7 Completed **************************************//");




Extent_cal(test, "Testcase 10 - Ensure new,save as,Edit,Search,delete and close buttons should be in enable when click print button");




Fluentwait(driver, Print1);
click(driver, Print1);


wait(driver,"3");


if(IsElementEnabled(driver, NewReport)) {
	
	System.out.println("After click the Print Button, the New button is in enable status");
	Extent_pass(driver, "After click the Print Button, the New button is in enable status", test,test1);
	
}else {
	
	System.out.println("After click the Print Button, the New  button  is not in enable status");
	Extent_fail(driver, "After click the Print Button, the New button  is not in enable status", test,test1);
}




if(IsElementEnabled(driver, CloseTab_Update)) {

System.out.println("After click the Print Button, the Close tab button is in enable status");
Extent_pass(driver, "After click the Print Button, the Close tab button is in enable status", test,test1);

}else {

System.out.println("After click the Print Button, the Close tab button is not in enable status");
Extent_fail(driver, "After click the Print Button, the Close tab button is not in enable status", test,test1);
}


if(IsElementEnabled(driver, EditButton)) {
	
	System.out.println("After click the Print Button, the Edit button is in enable status");
	Extent_pass(driver, "After click the Print Button, the Edit button is in enable status", test,test1);
	
}else {
	
	System.out.println("After click the Print Button, the Edit button  is not in enable status");
	Extent_fail(driver, "After click the Print Button, the Edit button  is not in enable status", test,test1);
}


wait(driver, "3");


System.out.println("//***************************Testcase 10 Completed **************************************//");



Extent_cal(test, "Testcase 15 - Ensure System should close the screen,when click close button");

Fluentwait(driver, CloseTab_Update);
click(driver, CloseTab_Update);

wait(driver, "3");

if (!isDisplayed(driver, CostUpdate_Tab)) {

	System.out.println("After click on close button Current screen was closed");
	Extent_pass(driver, "After click on close button Current screen was closed", test, test1);

} else {

	System.out.println("After click on close button Current screen was not closed");
	Extent_fail(driver, "After click on close button Current screen was not closed", test, test1);
}



	}

}
