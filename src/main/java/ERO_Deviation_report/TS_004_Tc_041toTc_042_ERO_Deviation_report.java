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
import org.openqa.selenium.Point;
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

public class TS_004_Tc_041toTc_042_ERO_Deviation_report extends Keywords{
	public void Scenario04(WebDriver driver, ExtentTest test,ExtentTest test1,String url, int dataset) throws AWTException, IOException, InterruptedException {	
	
	System.out.println("url : "+url);
	
	String Username = Utils.getDataFromTestData("TS_004_Tc_041toTc_042_ERO_Dataset"+dataset, "ERO_Deviation_report", "Username");
	String Password = Utils.getDataFromTestData("TS_004_Tc_041toTc_042_ERO_Dataset"+dataset, "ERO_Deviation_report", "Password");
	String ID = Utils.getDataFromTestData("TS_004_Tc_041toTc_042_ERO_Dataset"+dataset, "ERO_Deviation_report", "Id");
	String VersionNumber = Utils.getDataFromTestData("TS_004_Tc_041toTc_042_ERO_Dataset"+dataset, "ERO_Deviation_report", "Version_Number1");
	String Expected_Version_Xposition = Utils.getDataFromTestData(
			"TS_004_Tc_041toTc_042_ERO_Dataset"+dataset, "ERO_Deviation_report",
			"Created_Xposition");
	String Expected_Version_Yposition = Utils.getDataFromTestData(
			"TS_004_Tc_041toTc_042_ERO_Dataset"+dataset, "ERO_Deviation_report",
			"Created_Yposition");

	
	
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
		wait(driver,"3");

		
		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);
		
		wait(driver,"5");
		
		Fluentwait(driver, Search3);
		click(driver, Search3);
		
		wait(driver,"3");

		
		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);
		
		wait(driver,"5");
		
		
		Fluentwait(driver, Search4);
		click(driver, Search4);
		wait(driver,"4");

		
		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);
		
		wait(driver,"5");
		
				
		
	
		Extent_cal(test, "Testcase 42 - Ensure Version is placed at bottom of the left corner of the screen");
		
		
		Scrolltilltheelementvisible(driver, Version_Number);
	


		try {
			WebElement Versionfield = driver.findElement(By.xpath("(//div[@id='ERD-ERD_Colorchange']//following::label)[1]"));

			Point Version_Filed_location = Versionfield.getLocation();

			int Versionxposition = Version_Filed_location.getX();

			String actual_Version_XPosition = String.valueOf(Versionxposition);

			System.out.println("xposition :" + actual_Version_XPosition);

			int Versionyposition = Version_Filed_location.getY();

			String actual_version_YPosition = String.valueOf(Versionyposition);

			System.out.println("yposition :" + actual_version_YPosition);

			if (actual_Version_XPosition.equals(Expected_Version_Xposition)
					&& actual_version_YPosition.equals(Expected_Version_Yposition)) {

				System.out.println("Version field is placed at the bottom of the Left corner of the screen");
				Extent_pass(driver, "Version User field is placed at the bottom of the Left corner of the screen", test,test1);
				Extent_pass(driver, "Expected Version  field X position is : " + Expected_Version_Xposition
						+ " || Actual Version field X position is : " + actual_Version_XPosition, test,test1);
				Extent_pass(driver, "Expected Version field Y position is : " + Expected_Version_Yposition
						+ " || Actual Version field Y position is : " + Expected_Version_Yposition, test,test1);

			} else {

				System.out.println("Version field is not placed at the bottom of the Left corner of the screen");
				Extent_fail(driver, "Version field is not placed at the bottom of the Left corner of the screen",
						test,test1);
				Extent_fail(driver, "Expected Version field X position is : " + Expected_Version_Xposition
						+ " || Actual Version field X position is : " + actual_Version_XPosition, test,test1);
				Extent_fail(driver, "Expected Version field Y position is : " + Expected_Version_Yposition
						+ " || Actual Version field Y position is : " + Expected_Version_Yposition, test,test1);
			}

		} catch (Exception e) {
			e.printStackTrace();
			Extent_fail(driver, e.getLocalizedMessage(), test,test1);
		}
			System.out
			.println("//***************************Testcase 41 Completed **************************************//");
				
		
		

		}


	}
		
		


