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

public class TS_003_Tc_037toTc_040_ERO_Mass_Cost_Update extends Keywords{
	public void Scenario003(WebDriver driver, ExtentTest test,ExtentTest test1,String url, int dataset) throws AWTException, IOException, InterruptedException {	
	
	System.out.println("url : "+url);
	
	String Username = Utils.getDataFromTestData("TS_003_Tc_037toTc_040_ERO_Mass_Cost_Update_Dataset"+dataset, "ero_mass_cost_update", "Username");
	String Password = Utils.getDataFromTestData("TS_003_Tc_037toTc_040_ERO_Mass_Cost_Update_Dataset"+dataset, "ero_mass_cost_update", "Password");
	String ID = Utils.getDataFromTestData("TS_003_Tc_037toTc_040_ERO_Mass_Cost_Update_Dataset"+dataset, "ero_mass_cost_update", "Id");
	
	
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
		
		
click(driver, Cancel_Button);
		
		Fluentwait(driver, NewReport);
		click(driver, NewReport);
		
		
		Fluentwait(driver, Click_Confirm);
		click(driver, Click_Confirm);
		
		wait(driver,"5");

		
		
		Fluentwait(driver, Add_Plus_Button);
		click(driver, Add_Plus_Button);
		
		
		wait(driver,"5");
		
		

		Fluentwait(driver, Loc_Search);
		click(driver, Loc_Search);
		wait(driver,"3");

		sendKeys(driver, Loc_Search, "AEAUH");
		
		wait(driver,"2");

		
		doubleClick(driver, Select_Loc1);
		
		wait(driver,"2");

		
		Fluentwait(driver, Add_Plus_Button);
		click(driver, Add_Plus_Button);
		
		
		wait(driver,"5");
		
		
		click(driver, Loc_Search);
        wait(driver,"2");


		sendKeys(driver, Loc_Search, "AUSYD");
		
         wait(driver,"2");

		
		doubleClick(driver, Select_Loc1);
		wait(driver,"2");

		
		
		wait(driver,"3");

		
		click(driver, ShowButton);
		
		
		wait(driver,"3");

		
		Extent_cal(test, " Testcase 39 Ensure Scroll up and down functionality in Grids");
		

	//	switchtotab(driver, 0);



		Fluentwait(driver, Scroll_1);

		ScrollBarValidation1(driver, Scroll_1, "Grid scroll");
		
		
	System.out.println("//***************************Testcase 39 Completed **************************************//");
	
	
	Extent_cal(test, "Testcase 40 - Ensure Close button functionality");

	wait(driver, "3");

scrollBottom(driver);
	
	
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
	System.out
			.println("//***************************Testcase 40 Completed **************************************//");

	
	
	
		
	}
}
