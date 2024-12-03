package DeficitAndSurflusLocationIdentification_Scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.ExpectedExceptions;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.TestNgXml;
import commonMethods.Utils;

public class TS001_DeficitandSurplusLocationId_TC01to14 extends Keywords{
	
	public void Scenario1(WebDriver driver, ExtentTest test,ExtentTest test1,String url, int dataset) {
		
		System.out.println("url : "+url);
		
		String Username = Utils.getDataFromTestData("TS001_DeficitandSurplusLocationId_TC01to14_Dataset"+dataset, "DeficitandSurplusLocationId", "Username");
		String Password = Utils.getDataFromTestData("TS001_DeficitandSurplusLocationId_TC01to14_Dataset"+dataset, "DeficitandSurplusLocationId", "Password");
		String ID = Utils.getDataFromTestData("TS001_DeficitandSurplusLocationId_TC01to14_Dataset"+dataset, "DeficitandSurplusLocationId", "Id");

		navigateUrl(driver, url);
		
		Fluentwait(driver, Username_input);
		sendKeys(driver, Username_input, Username);
		
		Fluentwait(driver, Password_input);
		sendKeys(driver, Password_input, Password);
		 
		Fluentwait(driver, SignIn);
		click(driver, SignIn);
		
		wait(driver,"5");
		
		if(isDisplayed(driver, session_confirmation)) {
			Fluentwait(driver, session_confirmation);
			click(driver, session_confirmation);
		}
		
		Fluentwait(driver, Searchbox);
		sendKeys(driver, Searchbox, "Deficit and Surplus Location Identification");
		
		Fluentwait(driver, Selectdeficit);
		click(driver, Selectdeficit);
		
		Extent_cal(test, "Testcase 01 - When Open the new screen, Search and close buttons should be in Enable status");
		
		if(IsElementEnabled(driver, Globalserach)) {
			
			System.out.println("After opening the new screen, the Global search button is in enable status");
			Extent_pass(driver, "After opening the new screen, the Global search button is in enable status", test,test1);
			
		}else {
			
			System.out.println("After opening the new screen, the Global search button is not in enable status");
			Extent_fail(driver, "After opening the new screen, the Global search button is not in enable status", test,test1);
		}
		
		if(IsElementEnabled(driver, Closetab)) {
			
			System.out.println("After opening the new screen, the Close tab button is in enable status");
			Extent_pass(driver, "fter opening the new screen, the Close tab button is in enable status", test,test1);
			
		}else {
			
			System.out.println("After opening the new screen, the Close tab button is not in enable status");
			Extent_fail(driver, "After opening the new screen, the Close tab button is not in enable status", test,test1);
		}
		
		System.out.println("//***************************Testcase 1 Completed **************************************//");
		
	
		
		Extent_cal(test, "Testcase 02 - Ensure while click new button,Save,cancel and close button should be in enable Status");
		
		Fluentwait(driver, Cancel);
		click(driver, Cancel);
		
		Fluentwait(driver, New);
		click(driver, New);
		
		Fluentwait(driver, createnew_confirm);
		click(driver, createnew_confirm);
		
		wait(driver,"5");
		
		if(IsElementEnabled(driver, Save)) {
			
			System.out.println("After clicking the New button, the Save button is in enable status");
			Extent_pass(driver, "After clicking the New button, the Save button is in enable status", test,test1);
			
		}else {
			
			System.out.println("After clicking the New button, the Save button is not in enable status");
			Extent_fail(driver, "After clicking the New button, the Save button is not in enable status", test,test1);
		}
		
		if(IsElementEnabled(driver, Cancel)) {
			
			System.out.println("After clicking the New button, the Cancel button is in enable status");
			Extent_pass(driver, "After clicking the New button, the Cancel button is in enable status", test,test1);
			
		}else {
			
			System.out.println("After clicking the New button, the Cancel button is not in enable status");
			Extent_fail(driver, "After clicking the New button, the Cancel button is not in enable status", test,test1);
		}
		
		
		if(IsElementEnabled(driver, Closetab)) {
			
			System.out.println("After clicking the New button, the Close tab button is in enable status");
			Extent_pass(driver, "After clicking the New button, the Close tab button is in enable status", test,test1);
			
		}else {
			
			System.out.println("After clicking the New button, the Close tab button is not in enable status");
			Extent_fail(driver, "After clicking the New button, the Close tab button is not in enable status", test,test1);
		}
		
		System.out.println("//***************************Testcase 2 Completed **************************************//");
		
		
		
		Extent_cal(test, "Testcase 03 - Ensure while retrieving record by using global search,new,Edit,search,and close buttons should be in Enable status");
		
		Fluentwait(driver, Globalserach);
		click(driver, Globalserach);
		
		Fluentwait(driver, Globalserach_IDInput);
		sendKeys(driver, Globalserach_IDInput, ID);
		
		wait(driver,"2");
		
		Fluentwait(driver, Click_Search);
		click(driver, Click_Search);
		
		wait(driver,"5");
		
		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);
		
		wait(driver,"5");
		
		if(IsElementEnabled(driver, New)) {
			
			System.out.println("After retrieving the record using global search, New button is enabled");
			Extent_pass(driver, "After retrieving the record using global search, New button is enabled", test,test1);
			
		}else {
			
			System.out.println("After retrieving the record using global search, New button is not enabled");
			Extent_fail(driver, "After retrieving the record using global search, New button is notenabled", test,test1);
		}
		
		if(IsElementEnabled(driver, Editbutton)) {
			
			System.out.println("After retrieving the record using global search, Edit button is enabled");
			Extent_pass(driver, "After retrieving the record using global search, Edit button is enabled", test,test1);
			
		}else {
			
			System.out.println("After retrieving the record using global search, Edit button is not enabled");
			Extent_fail(driver, "After retrieving the record using global search, Edit button is not enabled", test,test1);
		}
		
		if(IsElementEnabled(driver, Globalserach)) {
			
			System.out.println("After retrieving the record using global search, Search button is enabled");
			Extent_pass(driver, "After retrieving the record using global search, Search button is enabled", test,test1);
			
		}else {
			
			System.out.println("After retrieving the record using global search, Search button is not enabled");
			Extent_fail(driver, "After retrieving the record using global search, Search button is not enabled", test,test1);
		}
		
		if(IsElementEnabled(driver, Closetab)) {
			
			System.out.println("After retrieving the record using global search, Close tab button is enabled");
			Extent_pass(driver, "After retrieving the record using global search, Close tab button is enabled", test,test1);
			
		}else {
			
			System.out.println("After retrieving the record using global search, Close tab button is not enabled");
			Extent_fail(driver, "After retrieving the record using global search, Close tab button is not enabled", test,test1);
		}
		
		System.out.println("//***************************Testcase 3 Completed **************************************//");
	
		
		
		Extent_cal(test, "Testcase 04 - Ensure While click grid record, new,Edit and Search and close buttons should be in enable status");
		
		Fluentwait(driver, Grid_locationfield1);
		click(driver, Grid_locationfield1);
		
		wait(driver,"5");
		
		if(IsElementEnabled(driver, New)) {
			
			System.out.println("After clicking the grid record, the New button is in enable status");
			Extent_pass(driver, "After clicking the grid record, the New button is in enable status.", test,test1);
			
		}else {
			
			System.out.println("After clicking the grid record, the New button is not in enable status.");
			Extent_fail(driver, "After clicking the grid record, the New button is not in enable status", test,test1);
		}
		
		if(IsElementEnabled(driver, Editbutton)) {
			
			System.out.println("After clicking the grid record, the Edit button is in enable status");
			Extent_pass(driver, "After clicking the grid record, the Edit button is in enable status", test,test1);
			
		}else {
			
			System.out.println("After clicking the grid record, the Edit button is not in enable status");
			Extent_fail(driver, "After clicking the grid record, the Edit button is not in enable status", test,test1);
		}
		
		if(IsElementEnabled(driver, Globalserach)) {
			
			System.out.println("After clicking the grid record, the Search button is in enable status");
			Extent_pass(driver, "After clicking the grid record, the Search button is in enable status", test,test1);
			
		}else {
			
			System.out.println("After clicking the grid record, the Search button is not in enable status");
			Extent_fail(driver, "After clicking the grid record, the Search button is not in enable status", test,test1);
		}
		
		if(IsElementEnabled(driver, Closetab)) {
			
			System.out.println("After clicking the grid record, the Close tab button is in enable status");
			Extent_pass(driver, "After clicking the grid record, the Close tab button is in enable status", test,test1);
			
		}else {
			
			System.out.println("After clicking the grid record, the Close tab button is not in enable status");
			Extent_fail(driver, "After clicking the grid record, the Close tab button is not in enable status", test,test1);
		}
		
		System.out.println("//***************************Testcase 4 Completed **************************************//");
		
		
		
		Extent_cal(test, "Testcase 05 - Ensure screen enable save , cancel , close and search button while click Edit buttion");
		
		Fluentwait(driver, Editbutton);
		click(driver, Editbutton);
		
		wait(driver,"5");
		
		if(IsElementEnabled(driver, Save)) {
			
			System.out.println("After clicking the Edit button, the Save button is in enable status");
			Extent_pass(driver, "After clicking the Edit button, the Save button is in enable status", test,test1);
			
		}else {
			
			System.out.println("After clicking the Edit button, the Save button is not in enable status");
			Extent_fail(driver, "After clicking the Edit button, the Save button is not in enable status", test,test1);
		}
		
		if(IsElementEnabled(driver, Cancel)) {
			
			System.out.println("After clicking the Edit button, the Cancel button is in enable status");
			Extent_pass(driver, "After clicking the Edit button, the Cancel button is in enable status", test,test1);
			
		}else {
			
			System.out.println("After clicking the Edit button, the Cancel button is not in enable status");
			Extent_fail(driver, "After clicking the Edit button, the Cancel button is not in enable status", test,test1);
		}
		
		
		if(IsElementEnabled(driver, Closetab)) {
			
			System.out.println("After clicking the Edit button, the Close tab button is in enable status");
			Extent_pass(driver, "After clicking the Edit button, the Close tab button is in enable status", test,test1);
			
		}else {
			
			System.out.println("After clicking the Edit button, the Close tab button is not in enable status");
			Extent_fail(driver, "After clicking the Edit button, the Close tab button is not in enable status", test,test1);
		}
		
		
		System.out.println("//***************************Testcase 5 Completed **************************************//");
		
	
		Extent_cal(test, "Testcase 06 - Ensure screen enable New, search and close button  when click cancel button");
		
		Fluentwait(driver, Cancel);
		click(driver, Cancel);
		
		wait(driver,"5");
		
		if(IsElementEnabled(driver, New)) {
			
			System.out.println("After clicking the Cancel button once edit button is clicked, the New button is in enable status");
			Extent_pass(driver, "After clicking the Cancel button once edit button is clicked, the New button is in enable status.", test,test1);
			
		}else {
			
			System.out.println("After clicking the Cancel button once edit button is clicked, the New button is not in enable status.");
			Extent_fail(driver, "After clicking the Cancel button once edit button is clicked, the New button is not in enable status", test,test1);
		}
		
		if(IsElementEnabled(driver, Globalserach)) {
			
			System.out.println("After clicking the Cancel button once edit button is clicked, the Global search button is in enable status");
			Extent_pass(driver, "After clicking the Cancel button once edit button is clicked, the Global search button is in enable status", test,test1);
			
		}else {
			
			System.out.println("After clicking the Cancel button once edit button is clicked, the Global search button is not in enable status");
			Extent_fail(driver, "After clicking the Cancel button once edit button is clicked, the Global search button is not in enable status", test,test1);
		}
		
		if(IsElementEnabled(driver, Closetab)) {
			
			System.out.println("After clicking the Cancel button once edit button is clicked, the Close tab button is in enable status");
			Extent_pass(driver, "After clicking the Cancel button once edit button is clicked, the Close tab button is in enable status", test,test1);
			
		}else {
			
			System.out.println("After clicking the Cancel button once edit button is clicked, the Close tab button is not in enable status");
			Extent_fail(driver, "After clicking the Cancel button once edit button is clicked, the Close tab button is not in enable status", test,test1);
		}
		
		System.out.println("//***************************Testcase 6 Completed **************************************//");

		
		
		Extent_cal(test, "Testcase 07 - Ensure screen enable New, search and close button  when click cancel button");
		
		Fluentwait(driver, New);
		click(driver, New);
		
		Fluentwait(driver, createnew_confirm);
		click(driver, createnew_confirm);
		
		wait(driver,"5");
		
		Fluentwait(driver, Cancel);
		click(driver, Cancel);
		
		wait(driver,"5");
		
		if(IsElementEnabled(driver, New)) {
			
			System.out.println("After clicking the Cancel button once the new record is created, the New is in enable status");
			Extent_pass(driver, "After clicking the Cancel button once the new record is created, the New is in enable status", test,test1);
			
		}else {
			
			System.out.println("After clicking the Cancel button once the new record is created, the New is not in enable status");
			Extent_fail(driver, "After clicking the Cancel button once the new record is created, the New is not in enable status", test,test1);
		}
		
		if(IsElementEnabled(driver, Globalserach)) {
			
			System.out.println("After clicking the Cancel button once the new record is created, the Global search button is in enable status");
			Extent_pass(driver, "After clicking the Cancel button once the new record is created, the Global search button is in enable status", test,test1);
			
		}else {
			
			System.out.println("After clicking the Cancel button once the new record is created, the Global search button is not in enable status");
			Extent_fail(driver, "After clicking the Cancel button once the new record is created, the Global search button is not in enable status", test,test1);
		}
		
		if(IsElementEnabled(driver, Closetab)) {
			
			System.out.println("After clicking the Cancel button once the new record is created, the Close tab button is in enable status");
			Extent_pass(driver, "After clicking the Cancel button once the new record is created, the Close tab button is in enable status", test,test1);
			
		}else {
			
			System.out.println("After clicking the Cancel button once the new record is created, the Close tab button is not in enable status");
			Extent_fail(driver, "After clicking the Cancel button once the new record is created, the Close tab button is not in enable status", test,test1);
		}
		
		System.out.println("//***************************Testcase 07 Completed **************************************//");
		
	
		
		Extent_cal(test, "Testcase 09 - Ensure new,save as,Edit,Search,delete and close buttons should be in enable when click print button");
		
		wait(driver,"3");
		
		Fluentwait(driver, Globalserach);
		click(driver, Globalserach);
		
		Fluentwait(driver, Globalserach_IDInput);
		sendKeys(driver, Globalserach_IDInput, ID);
		
		wait(driver,"3");
		
		Fluentwait(driver, Click_Search);
		click(driver, Click_Search);
		
		wait(driver,"5");
	
		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);
		
		Fluentwait(driver, Print);
		click(driver, Print);
		
		wait(driver,"5");
		
		if(IsElementEnabled(driver, New)) {
			
			System.out.println("After clicking the print button, the New button is in enable status");
			Extent_pass(driver, "After clicking the print button, the New button is in enable status.", test,test1);
			
		}else {
			
			System.out.println("After clicking the print button, the New button is not in enable status.");
			Extent_fail(driver, "After clicking the print button, the New button is not in enable status", test,test1);
		}
		
		if(IsElementEnabled(driver, Saveas)) {
			
			System.out.println("After clicking the print button, the Saveas button is in enable status");
			Extent_pass(driver, "After clicking the print button, the Saveas button is in enable status.", test,test1);
			
		}else {
			
			System.out.println("After clicking the print button, the Saveas button is not in enable status.");
			Extent_fail(driver, "After clicking the print button, the Saveas button is not in enable status", test,test1);
		}
		
		if(IsElementEnabled(driver, Editbutton)) {
			
			System.out.println("After clicking the print button, the Edit button is in enable status");
			Extent_pass(driver, "After clicking the print button, the Edit button is in enable status.", test,test1);
			
		}else {
			
			System.out.println("After clicking the print button, the Edit button is not in enable status.");
			Extent_fail(driver, "After clicking the print button, the Edit button is not in enable status", test,test1);
		}
		
		if(IsElementEnabled(driver, Globalserach)) {
			
			System.out.println("After clicking the print button, the Globalserach button is in enable status");
			Extent_pass(driver, "After clicking the print button, the Globalserach button is in enable status.", test,test1);
			
		}else {
			
			System.out.println("After clicking the print button, the Globalserach button is not in enable status.");
			Extent_fail(driver, "After clicking the print button, the Globalserach button is not in enable status", test,test1);
		}
		
		
		if(IsElementEnabled(driver, Closetab)) {
			
			System.out.println("After clicking the print button, the Close button is in enable status");
			Extent_pass(driver, "After clicking the print button, the Close button is in enable status", test,test1);
			
		}else {
			
			System.out.println("After clicking the print button, the Close button is not in enable status");
			Extent_fail(driver, "After clicking the print button, the Close button is not in enable status", test,test1);
		}
		
		System.out.println("//***************************Testcase 09 Completed **************************************//");
		
		
		Extent_cal(test, "Testcase 10 - Ensure new,Edit, search,Delete,print ,move to previous,move to next,move to last buttons should be enable when click move to first button");
		
		Fluentwait(driver, MovetoFirst);
		click(driver, MovetoFirst);
		
		wait(driver,"5");
		
		if(IsElementEnabled(driver, New)) {
			
			System.out.println("After clicking the move to first button, the New button is in enable status");
			Extent_pass(driver, "After clicking the move to first button, the New button is in enable status.", test,test1);
			
		}else {
			
			System.out.println("After clicking the move to first button, the New button is not in enable status.");
			Extent_fail(driver, "After clicking the move to first button, the New button is not in enable status", test,test1);
		}
		
		if(IsElementEnabled(driver, Editbutton)) {
			
			System.out.println("After clicking the move to first button, the Edit button is in enable status");
			Extent_pass(driver, "After clicking the move to first button, the Edit button is in enable status.", test,test1);
			
		}else {
			
			System.out.println("After clicking the move to first button, the Edit button is not in enable status.");
			Extent_fail(driver, "After clicking the move to first button, the Edit button is not in enable status", test,test1);
		}
		
		if(IsElementEnabled(driver, Globalserach)) {
			
			System.out.println("After clicking the move to first button, the Globalserach button is in enable status");
			Extent_pass(driver, "After clicking the move to first button, the Globalserach button is in enable status.", test,test1);
			
		}else {
			
			System.out.println("After clicking the move to first button, the Globalserach button is not in enable status.");
			Extent_fail(driver, "After clicking the move to first button, the Globalserach button is not in enable status", test,test1);
		}
		
		if(IsElementEnabled(driver, Print)) {
			
			System.out.println("After clicking the move to first button, the Print button is in enable status");
			Extent_pass(driver, "After clicking the move to first button, the Print button is in enable status.", test,test1);
			
		}else {
			
			System.out.println("After clicking the move to first button, the Print button is not in enable status.");
			Extent_fail(driver, "After clicking the move to first button, the Print button is not in enable status", test,test1);
		}
		
		if(IsElementEnabled(driver, MovetoPrevious)) {
			
			System.out.println("After clicking the move to first button, the Move to previous button is in enable status");
			Extent_pass(driver, "After clicking the move to first button, the Move to previous button is in enable status.", test,test1);
			
		}else {
			
			System.out.println("After clicking the move to first button, the Move to previous button is not in enable status.");
			Extent_fail(driver, "After clicking the move to first button, the Move to previous button is not in enable status", test,test1);
		}
	
		if(IsElementEnabled(driver, MovetoNext)) {
			
			System.out.println("After clicking the move to first button, the Move to Next button is in enable status");
			Extent_pass(driver, "After clicking the move to first button, the Move to Next button is in enable status.", test,test1);
			
		}else {
			
			System.out.println("After clicking the move to first button, the Move to Next button is not in enable status.");
			Extent_fail(driver, "After clicking the move to first button, the Move to Next button is not in enable status", test,test1);
		}
		
		if(IsElementEnabled(driver, MovetoLast)) {
			
			System.out.println("After clicking the move to first button, the Move to last button is in enable status");
			Extent_pass(driver, "After clicking the move to first button, the Move to last button is in enable status.", test,test1);
			
		}else {
			
			System.out.println("After clicking the move to first button, the Move to last button is not in enable status.");
			Extent_fail(driver, "After clicking the move to first button, the Move to last button is not in enable status", test,test1);
		}
		
		System.out.println("//***************************Testcase 10 Completed **************************************//");
		
		
		
		Extent_cal(test, "Testcase 11 - Ensure new,Edit, search,Delete,print ,move to previous,move to next,move to first buttons should be enable when click move to last button");
		
		Fluentwait(driver, MovetoLast);
		click(driver, MovetoLast);
		
		wait(driver,"5");
		
		if(IsElementEnabled(driver, New)) {
			
			System.out.println("After clicking the move to last button, the New button is in enable status");
			Extent_pass(driver, "After clicking the move to last button, the New button is in enable status.", test,test1);
			
		}else {
			
			System.out.println("After clicking the move to last button, the New button is not in enable status.");
			Extent_fail(driver, "After clicking the move to last button, the New button is not in enable status", test,test1);
		}
		
		if(IsElementEnabled(driver, Editbutton)) {
			
			System.out.println("After clicking the move to last button, the Edit button is in enable status");
			Extent_pass(driver, "After clicking the move to last button, the Edit button is in enable status.", test,test1);
			
		}else {
			
			System.out.println("After clicking the move to last button, the Edit button is not in enable status.");
			Extent_fail(driver, "After clicking the move to last button, the Edit button is not in enable status", test,test1);
		}
		
		if(IsElementEnabled(driver, Globalserach)) {
			
			System.out.println("After clicking the move to last button, the Globalserach button is in enable status");
			Extent_pass(driver, "After clicking the move to last button, the Globalserach button is in enable status.", test,test1);
			
		}else {
			
			System.out.println("After clicking the move to last button, the Globalserach button is not in enable status.");
			Extent_fail(driver, "After clicking the move to last button, the Globalserach button is not in enable status", test,test1);
		}
		
		if(IsElementEnabled(driver, Print)) {
			
			System.out.println("After clicking the move to last button, the Print button is in enable status");
			Extent_pass(driver, "After clicking the move to last button, the Print button is in enable status.", test,test1);
			
		}else {
			
			System.out.println("After clicking the move to last button, the Print button is not in enable status.");
			Extent_fail(driver, "After clicking the move to last button, the Print button is not in enable status", test,test1);
		}
		
		if(IsElementEnabled(driver, MovetoPrevious)) {
			
			System.out.println("After clicking the move to last button, the Move to previous button is in enable status");
			Extent_pass(driver, "After clicking the move to last button, the Move to previous button is in enable status.", test,test1);
			
		}else {
			
			System.out.println("After clicking the move to last button, the Move to previous button is not in enable status.");
			Extent_fail(driver, "After clicking the move to last button, the Move to previous button is not in enable status", test,test1);
		}
	
		if(IsElementEnabled(driver, MovetoNext)) {
			
			System.out.println("After clicking the move to last button, the Move to Next button is in enable status");
			Extent_pass(driver, "After clicking the move to last button, the Move to Next button is in enable status.", test,test1);
			
		}else {
			
			System.out.println("After clicking the move to last button, the Move to Next button is not in enable status.");
			Extent_fail(driver, "After clicking the move to last button, the Move to Next button is not in enable status", test,test1);
		}
		
		if(IsElementEnabled(driver, MovetoFirst)) {
			
			System.out.println("After clicking the move to last button, the Move to first button is in enable status");
			Extent_pass(driver, "After clicking the move to last button, the Move to first button is in enable status.", test,test1);
			
		}else {
			
			System.out.println("After clicking the move to last button, the Move to first button is not in enable status.");
			Extent_fail(driver, "After clicking the move to last button, the Move to first button is not in enable status", test,test1);
		}
		
		System.out.println("//***************************Testcase 11 Completed **************************************//");
		
		
		
		Extent_cal(test, "Testcase 12 - Ensure new,Edit,Search,Delete,print,move to last,move to next,move to first buttons should be enable when click move to next");
		
		Fluentwait(driver, MovetoNext);
		click(driver, MovetoNext);
		
		wait(driver,"5");
		
		if(IsElementEnabled(driver, New)) {
			
			System.out.println("After clicking the move to Next button, the New button is in enable status");
			Extent_pass(driver, "After clicking the move to Next button, the New button is in enable status.", test,test1);
			
		}else {
			
			System.out.println("After clicking the move to Next button, the New button is not in enable status.");
			Extent_fail(driver, "After clicking the move to Next button, the New button is not in enable status", test,test1);
		}
		
		if(IsElementEnabled(driver, Editbutton)) {
			
			System.out.println("After clicking the move to Next button, the Edit button is in enable status");
			Extent_pass(driver, "After clicking the move to Next button, the Edit button is in enable status.", test,test1);
			
		}else {
			
			System.out.println("After clicking the move to Next button, the Edit button is not in enable status.");
			Extent_fail(driver, "After clicking the move to Next button, the Edit button is not in enable status", test,test1);
		}
		
		if(IsElementEnabled(driver, Globalserach)) {
			
			System.out.println("After clicking the move to Next button, the Globalserach button is in enable status");
			Extent_pass(driver, "After clicking the move to Next button, the Globalserach button is in enable status.", test,test1);
			
		}else {
			
			System.out.println("After clicking the move to Next button, the Globalserach button is not in enable status.");
			Extent_fail(driver, "After clicking the move to Next button, the Globalserach button is not in enable status", test,test1);
		}
		
		
		if(IsElementEnabled(driver, Print)) {
			
			System.out.println("After clicking the move to Next button, the Print button is in enable status");
			Extent_pass(driver, "After clicking the move to Next button, the Print button is in enable status.", test,test1);
			
		}else {
			
			System.out.println("After clicking the move to Next button, the Print button is not in enable status.");
			Extent_fail(driver, "After clicking the move to Next button, the Print button is not in enable status", test,test1);
		}
		
		if(IsElementEnabled(driver, MovetoLast)) {
			
			System.out.println("After clicking the move to Next button, the Move to last button is in enable status");
			Extent_pass(driver, "After clicking the move to Next button, the Move to last button is in enable status.", test,test1);
			
		}else {
			
			System.out.println("After clicking the move to Next button, the Move to last button is not in enable status.");
			Extent_fail(driver, "After clicking the move to Next button, the Move to last button is not in enable status", test,test1);
		}
		
		if(IsElementEnabled(driver, MovetoNext)) {
			
			System.out.println("After clicking the move to Next button, the Move to next button is in enable status");
			Extent_pass(driver, "After clicking the move to Next button, the Move to next button is in enable status.", test,test1);
			
		}else {
			
			System.out.println("After clicking the move to Next button, the Move to next button is not in enable status.");
			Extent_fail(driver, "After clicking the move to Next button, the Move to next button is not in enable status", test,test1);
		}
		
		if(IsElementEnabled(driver, MovetoFirst)) {
			
			System.out.println("After clicking the move to Next button, the Move to first button is in enable status");
			Extent_pass(driver, "After clicking the move to Next button, the Move to first button is in enable status.", test,test1);
			
		}else {
			
			System.out.println("After clicking the move to Next button, the Move to first button is not in enable status.");
			Extent_fail(driver, "After clicking the move to Next button, the Move to first button is not in enable status", test,test1);
		}
		
		
		System.out.println("//***************************Testcase 12 Completed **************************************//");
		
	
		
		Extent_cal(test, "Testcase 13 - Ensure new,Edit,Search,Delete,print,move to last,move to next,move to first buttons should be enable when click move to previous");
		
		Fluentwait(driver, MovetoPrevious);
		click(driver, MovetoPrevious);
		
		wait(driver,"5");
		
		if(IsElementEnabled(driver, New)) {
			
			System.out.println("After clicking the move to previous button, the New button is in enable status");
			Extent_pass(driver, "After clicking the move to previous button, the New button is in enable status.", test,test1);
			
		}else {
			
			System.out.println("After clicking the move to previous button, the New button is not in enable status.");
			Extent_fail(driver, "After clicking the move to previous button, the New button is not in enable status", test,test1);
		}
		
		if(IsElementEnabled(driver, Editbutton)) {
			
			System.out.println("After clicking the move to previous button, the Edit button is in enable status");
			Extent_pass(driver, "After clicking the move to previous button, the Edit button is in enable status.", test,test1);
			
		}else {
			
			System.out.println("After clicking the move to previous button, the Edit button is not in enable status.");
			Extent_fail(driver, "After clicking the move to previous button, the Edit button is not in enable status", test,test1);
		}
		
		if(IsElementEnabled(driver, Globalserach)) {
			
			System.out.println("After clicking the move to previous button, the Globalserach button is in enable status");
			Extent_pass(driver, "After clicking the move to previous button, the Globalserach button is in enable status.", test,test1);
			
		}else {
			
			System.out.println("After clicking the move to previous button, the Globalserach button is not in enable status.");
			Extent_fail(driver, "After clicking the move to previous button, the Globalserach button is not in enable status", test,test1);
		}
		
		if(IsElementEnabled(driver, Print)) {
			
			System.out.println("After clicking the move to previous button, the Print button is in enable status");
			Extent_pass(driver, "After clicking the move to previous button, the Print button is in enable status.", test,test1);
			
		}else {
			
			System.out.println("After clicking the move to previous button, the Print button is not in enable status.");
			Extent_fail(driver, "After clicking the move to previous button, the Print button is not in enable status", test,test1);
		}
		
		if(IsElementEnabled(driver, MovetoLast)) {
			
			System.out.println("After clicking the move to previous button, the Move to last button is in enable status");
			Extent_pass(driver, "After clicking the move to previous button, the Move to last button is in enable status.", test,test1);
			
		}else {
			
			System.out.println("After clicking the move to previous button, the Move to last button is not in enable status.");
			Extent_fail(driver, "After clicking the move to previous button, the Move to last button is not in enable status", test,test1);
		}
		
		if(IsElementEnabled(driver, MovetoNext)) {
			
			System.out.println("After clicking the move to previous button, the Move to next button is in enable status");
			Extent_pass(driver, "After clicking the move to previous button, the Move to next button is in enable status.", test,test1);
			
		}else {
			
			System.out.println("After clicking the move to previous button, the Move to next button is not in enable status.");
			Extent_fail(driver, "After clicking the move to previous button, the Move to next button is not in enable status", test,test1);
		}
		
		if(IsElementEnabled(driver, MovetoFirst)) {
			
			System.out.println("After clicking the move to previous button, the Move to first button is in enable status");
			Extent_pass(driver, "After clicking the move to previous button, the Move to first button is in enable status.", test,test1);
			
		}else {
			
			System.out.println("After clicking the move to previous button, the Move to first button is not in enable status.");
			Extent_fail(driver, "After clicking the move to previous button, the Move to first button is not in enable status", test,test1);
		}
		
		
		System.out.println("//***************************Testcase 13 Completed **************************************//");
		
	
		
		Extent_cal(test, "Testcase 14 - Ensure System should close the screen,when click close button");
		
		waitForElement(driver, Closetab);
		click(driver, Closetab);
		
		wait(driver,"3");
		
		if (!isDisplayed(driver, Deficittab)) {
			
			System.out.println("After click on close button Current screen was closed");
			Extent_pass(driver, "After click on close button Current screen was closed", test,test1);
			
		}else {
			
			System.out.println("After click on close button Current screen was not closed");
			Extent_fail(driver, "After click on close button Current screen was not closed", test,test1);
		}
		
		System.out.println("Testcase 14 completed");
		
		
		
		
	}
	

}
