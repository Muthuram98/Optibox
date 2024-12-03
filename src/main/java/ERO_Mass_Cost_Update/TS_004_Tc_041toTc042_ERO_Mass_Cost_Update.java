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

public class TS_004_Tc_041toTc042_ERO_Mass_Cost_Update extends Keywords{
	public void Scenario004(WebDriver driver, ExtentTest test,ExtentTest test1,String url, int dataset) throws AWTException, IOException, InterruptedException {	
	
	System.out.println("url : "+url);
	
	String Username = Utils.getDataFromTestData("TS_004_Tc_041_Tc_042_ERO_Mass_Cost_Update_Dataset"+dataset, "ero_mass_cost_update", "Username");
	String Password = Utils.getDataFromTestData("TS_004_Tc_041_Tc_042_ERO_Mass_Cost_Update_Dataset"+dataset, "ero_mass_cost_update", "Password");
	String Expected_Version_Xposition = Utils.getDataFromTestData(
			"TS_004_Tc_041_Tc_042_ERO_Mass_Cost_Update_Dataset"+dataset, "ero_mass_cost_update",
			"Created_Xposition");
	String Expected_Version_Yposition = Utils.getDataFromTestData(
			"TS_004_Tc_041_Tc_042_ERO_Mass_Cost_Update_Dataset"+dataset, "ero_mass_cost_update",
			"Created_Yposition");
	
	
	
	
	
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
		
		Scrolltilltheelementvisible(driver, Version_Number_Cost);
		
		
		wait(driver,"3");

		
		try {
			WebElement Versionfield = driver.findElement(By.xpath("//label[contains(text(),'Version :')]"));

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
