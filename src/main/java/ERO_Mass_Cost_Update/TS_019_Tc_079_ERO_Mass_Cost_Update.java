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

public class TS_019_Tc_079_ERO_Mass_Cost_Update extends Keywords{
	public void Scenario019(WebDriver driver, ExtentTest test,ExtentTest test1,String url, int dataset) throws AWTException, IOException, InterruptedException {	
	
	System.out.println("url : "+url);
	
	String Username = Utils.getDataFromTestData("TS_019_Tc_079_ERO_Mass_Cost_Update_Dataset"+dataset, "ero_mass_cost_update", "Username");
	String Password = Utils.getDataFromTestData("TS_019_Tc_079_ERO_Mass_Cost_Update_Dataset"+dataset, "ero_mass_cost_update", "Password");
	String ID = Utils.getDataFromTestData("TS_019_Tc_079_ERO_Mass_Cost_Update_Dataset"+dataset, "ero_mass_cost_update", "Id");
	String Validation_Msg2 = Utils.getDataFromTestData("TS_019_Tc_079_ERO_Mass_Cost_Update_Dataset"+dataset, "ero_mass_cost_update", "ValidationMsg2");
	String Validation_Msg1 = Utils.getDataFromTestData("TS_019_Tc_079_ERO_Mass_Cost_Update_Dataset"+dataset, "ero_mass_cost_update", "ValidationMsg1");
	String Validation_Msg3 = Utils.getDataFromTestData("TS_019_Tc_079_ERO_Mass_Cost_Update_Dataset"+dataset, "ero_mass_cost_update", "ValidationMsg3");

	
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
		
		
		
		
		Extent_cal(test, "Testcase 76 - Ensure the validation message displayed");

		
	
click(driver, Cancel_Button);

Extent_cal(test, "Validation Message1");

		
		Fluentwait(driver, NewReport);
		click(driver, NewReport);
		
		wait(driver,"3");
		
		
		String Validation_Text1 = getText(driver,Popup_Msg_Report1 );

		System.out.println("Validation_Text1 : "+Validation_Text1);
		
	
	
	
		if (Validation_Text1.equals(Validation_Msg1)) {
			System.out.println("Matched || Expected Validation Message was : " + Validation_Msg1
					+ " Actual Validation Message was : " + Validation_Text1);
			Extent_pass(driver, "Matched || Expected Validation Message was : "
					+ Validation_Msg1 + " Actual Validation Message was : " + Validation_Text1,
					test,test1);
		} else {
			System.out.println(
					"Not Matched || Expected Validation Message was : " + Validation_Msg1
							+ " Actual Validation Message was : " + Validation_Text1);
			Extent_fail2(driver, "Not Matched || Expected Validation Message was : "
					+ Validation_Msg1 + " Actual Validation Message was : " + Validation_Text1,
					test);

		}
	
	
		Fluentwait(driver, Click_Confirm);
		click(driver, Click_Confirm);
		
		
	wait(driver,"3");

		
		
		
		Extent_cal(test, "Validation Message2");


		
		click(driver, ShowButton);

		wait(driver,"3");

		String Validation_Text2 = getText(driver,Popup_Msg_Report1 );

		System.out.println("Validation_Text2 : "+Validation_Text2);
		
	
	
	
		if (Validation_Text2.equals(Validation_Msg2)) {
			System.out.println("Matched || Expected Validation Message was : " + Validation_Msg2
					+ " Actual Validation Message was : " + Validation_Text2);
			Extent_pass(driver, "Matched || Expected Validation Message was : "
					+ Validation_Msg2 + " Actual Validation Message was : " + Validation_Text2,
					test,test1);
		} else {
			System.out.println(
					"Not Matched || Expected Validation Message was : " + Validation_Msg2
							+ " Actual Validation Message was : " + Validation_Text2);
			Extent_fail2(driver, "Not Matched || Expected Validation Message was : "
					+ Validation_Msg2 + " Actual Validation Message was : " + Validation_Text2,
					test);

		}
	
	
	click(driver, ClickOK);
	
	wait(driver,"3");

	
	
	
	Extent_cal(test, "Validation Message3");
	
	
	
	
	Fluentwait(driver, Add_Plus_Button);
	click(driver, Add_Plus_Button);
	
	
	wait(driver,"3");
	
	
	Fluentwait(driver, Select_Click);
	click(driver, Select_Click);
	
	
	
	String Validation_Text3 = getText(driver,Validation_Message1 );

	System.out.println("Validation_Text3 : "+Validation_Text3);
	



	if (Validation_Text3.equals(Validation_Msg3)) {
		System.out.println("Matched || Expected Validation Message was : " + Validation_Msg3
				+ " Actual Validation Message was : " + Validation_Text3);
		Extent_pass(driver, "Matched || Expected Validation Message was : "
				+ Validation_Msg3 + " Actual Validation Message was : " + Validation_Text3,
				test,test1);
	} else {
		System.out.println(
				"Not Matched || Expected Validation Message was : " + Validation_Msg3
						+ " Actual Validation Message was : " + Validation_Text3);
		Extent_fail2(driver, "Not Matched || Expected Validation Message was : "
				+ Validation_Msg3 + " Actual Validation Message was : " + Validation_Text3,
				test);

	}

	
	click(driver, Validation_Close);
	
	

	
	
	
	
	}
	
	
	
}
