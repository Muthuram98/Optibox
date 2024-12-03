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
import org.openqa.selenium.interactions.ClickAndHoldAction;
import org.openqa.selenium.interactions.DoubleClickAction;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.Utils;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class TS_008_Tc_063toTc_066_ERO_Mass_Cost_Update extends Keywords{
	public void Scenario008(WebDriver driver, ExtentTest test,ExtentTest test1,String url, int dataset) throws AWTException, IOException, InterruptedException {	
	
	System.out.println("url : "+url);
	
	String Username = Utils.getDataFromTestData("TS_008_Tc_063toTc_066_ERO_Mass_Cost_Update_Dataset"+dataset, "ero_mass_cost_update", "Username");
	String Password = Utils.getDataFromTestData("TS_008_Tc_063toTc_066_ERO_Mass_Cost_Update_Dataset"+dataset, "ero_mass_cost_update", "Password");
	String ID = Utils.getDataFromTestData("TS_008_Tc_063toTc_066_ERO_Mass_Cost_Update_Dataset"+dataset, "ero_mass_cost_update", "Id");
	
	
	WebDriverWait wait = new WebDriverWait(driver, 60);
	Actions act = new Actions(driver);
	
	
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
		
Extent_cal(test, "Testcase 63 - Ensure Confirmation pop up window having proper messages with icon(?)");

		
click(driver, Cancel_Button);

Fluentwait(driver, NewReport);
click(driver, NewReport);


		
		Fluentwait(driver, Popup_Msg_Report1);

		try {
		elementScreenShot_new(driver, Report_Ques_mark1, "/Expected_screenshot/Elementscreenshot/Questionmark");
			wait(driver, "2");
			elementScreenShot_new(driver, Report_Ques_mark1, "/Actual_screenshot/Elementscreenshot/Questionmark");
			wait(driver, "2");
			imageComparison2(driver, "/Elementscreenshot/Questionmark", "/Elementscreenshot/Questionmark");
			Extent_pass(driver, "Matched Icon", test,test1);


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Extent_fail(driver, e.getLocalizedMessage(), test,test1);
		}

				
		
		
				
		System.out
		.println("//***************************Testcase 63 Completed **************************************//");	
		
		
		Fluentwait(driver, Click_Confirm);
		click(driver, Click_Confirm);
		
		wait(driver,"5");
		
		
		
Extent_cal(test, "Testcase 65 - Ensure information pop up window having proper messages with icon(i)");

		
		wait(driver,"5");	
		
		click(driver, ShowButton);
		
		
		
		Fluentwait(driver, Report_Ques_mark1);

		
		try {
			elementScreenShot_new(driver, Report_Ques_mark1, "/Expected_screenshot/Elementscreenshot/Information Icon");
			elementScreenShot_new(driver, Report_Ques_mark1, "/Actual_screenshot/Elementscreenshot/Information Icon");
			imageComparison2(driver, "/Elementscreenshot/Information Icon", "/Elementscreenshot/Information Icon");
			Extent_pass(driver, "Matched Icon", test,test1);


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		wait(driver,"2");	


		click(driver, ClickOK);
	
		System.out
		.println("//***************************Testcase 65 Completed **************************************//");	
		
		
		
		
		Extent_cal(test, "Testcase 64 - Ensure Warning pop up window having proper messages with icon(!)");
		wait(driver,"2");	

		Fluentwait(driver, Import_Excel1);
		click(driver, Import_Excel1);
		
		wait(driver,"3");	
		
		click(driver, Tab_View);
		
		
Fluentwait(driver, Warning_Icon_Report1);

		
		try {
			elementScreenShot_new(driver, Warning_Icon_Report1, "/Expected_screenshot/Elementscreenshot/Warning Icon");
			elementScreenShot_new(driver, Warning_Icon_Report1, "/Actual_screenshot/Elementscreenshot/Warning Icon");
			imageComparison2(driver, "/Elementscreenshot/Warning Icon", "/Elementscreenshot/Warning Icon");
			Extent_pass(driver, "Matched Icon", test,test1);


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		wait(driver,"3");	
		

		click(driver, Export_Close);
		
		System.out
		.println("//***************************Testcase 64 Completed **************************************//");	
		
		
		wait(driver,"3");	

		
	}
}
