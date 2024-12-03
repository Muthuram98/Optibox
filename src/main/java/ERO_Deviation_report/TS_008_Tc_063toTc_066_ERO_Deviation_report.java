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

public class TS_008_Tc_063toTc_066_ERO_Deviation_report extends Keywords{
	public void Scenario08(WebDriver driver, ExtentTest test,ExtentTest test1,String url, int dataset) throws AWTException, IOException, InterruptedException {	
	
	System.out.println("url : "+url);
	
	String Username = Utils.getDataFromTestData("TS_008_Tc_063toTc_066_ERO_Dataset"+dataset, "ERO_Deviation_report", "Username");
	String Password = Utils.getDataFromTestData("TS_008_Tc_063toTc_066_ERO_Dataset"+dataset, "ERO_Deviation_report", "Password");
	String ID = Utils.getDataFromTestData("TS_008_Tc_063toTc_066_ERO_Dataset"+dataset, "ERO_Deviation_report", "Id");
	String New_Popup = Utils.getDataFromTestData("TS_008_Tc_063toTc_066_ERO_Dataset"+dataset, "ERO_Deviation_report", "NewPopup");
	String Info_popup = Utils.getDataFromTestData("TS_008_Tc_063toTc_066_ERO_Dataset"+dataset, "ERO_Deviation_report", "InfoPopup");
	String Invalid_Data = Utils.getDataFromTestData("TS_008_Tc_063toTc_066_ERO_Dataset"+dataset, "ERO_Deviation_report", "InvalidData");
	String InformationPopup_Message = Utils.getDataFromTestData("TS_008_Tc_063toTc_066_ERO_Dataset"+dataset,
			"ERO_Deviation_report", "Information_message");



	
	
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

Extent_cal(test, "Testcase 63 - Ensure Confirmation pop up window having proper messages with icon(?)");

		
		Fluentwait(driver, New_Report);
		click(driver, New_Report);
		
		Fluentwait(driver, Popup_Msg_Report);

		try {
		elementScreenShot_new(driver, Report_Ques_mark, "/Expected_screenshot/Elementscreenshot/Questionmark");
			wait(driver, "2");
			elementScreenShot_new(driver, Report_Ques_mark, "/Actual_screenshot/Elementscreenshot/Questionmark");
			wait(driver, "2");
			imageComparison2(driver, "/Elementscreenshot/Questionmark", "/Elementscreenshot/Questionmark");
			//Extent_pass(driver, "Matched Icon", test,test1);


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Extent_fail(driver, e.getLocalizedMessage(), test,test1);
		}

				
				
		System.out
		.println("//***************************Testcase 63 Completed **************************************//");	
		
		
		
		
		
		Fluentwait(driver, Create_New_Confirm1);
		click(driver, Create_New_Confirm1);
		
		
		Extent_cal(test, "Testcase 65 - Ensure information pop up window having proper messages with icon(i)");

		
		wait(driver,"5");	
		
		Fluentwait(driver, Search1);
		click(driver, Search1);
		
		
		Fluentwait(driver, Globalserach_IDInput);
		sendKeys(driver, Globalserach_IDInput, Invalid_Data);
		
		
		wait(driver,"2");
		
		Fluentwait(driver, Click_Search_Report);
		click(driver, Click_Search_Report);
		
		
		Fluentwait(driver, Information_Icon_Report);

		
		try {
			elementScreenShot_new(driver, Information_Icon_Report, "/Expected_screenshot/Elementscreenshot/Information Icon");
			elementScreenShot_new(driver, Information_Icon_Report, "/Actual_screenshot/Elementscreenshot/Information Icon");
			imageComparison2(driver, "/Elementscreenshot/Information Icon", "/Elementscreenshot/Information Icon");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	
		System.out
		.println("//***************************Testcase 63 Completed **************************************//");		
		
		
		
		Extent_cal(test, "Testcase 66 - Ensure information pop up window having proper messages with icon(x)");
		
		wait(driver, "2");

		
click(driver, Search_Close);

		
		
		Fluentwait(driver, Search1);
		click(driver, Search1);
		
		
		
		wait(driver,"2");
		
		Fluentwait(driver, Click_Search_Report);
		click(driver, Click_Search_Report);
		
		
		Fluentwait(driver, Error_ID_Search_Popup_Deviation);
		String Informationnpopup_text = getText(driver, Error_ID_Search_Popup_Deviation);

		if (Informationnpopup_text.equals(InformationPopup_Message)) {
			Extent_pass(driver, "Information popup message having proper message with icon(x)", test,test1);
			System.out.println(
					"Matched || Expected Information popup message of creating new was : " + InformationPopup_Message
							+ " || Actual Information popup message of creating new was : " + Informationnpopup_text);
			Extent_pass(driver,
					"Matched || Expected Information popup message of creating new was : " + InformationPopup_Message
							+ " || Actual Information popup message of creating new was : " + Informationnpopup_text,
					test,test1);
		} else {
			System.out.println("Not Matched || Expected Information popup message of creating new was : "
					+ InformationPopup_Message + " || Actual Information popup message of creating new was : "
					+ Informationnpopup_text);
			Extent_fail2(driver,
					"Not Matched || Expected Information popup message of creating new was : "
							+ InformationPopup_Message + " || Actual Information popup message of creating new was : "
							+ Informationnpopup_text,
					test);

		}

		wait(driver, "3");

		System.out.println("******************Testcase 65 Completed ***********************");
		
		
		
		
		
		
		
		
		

}
}