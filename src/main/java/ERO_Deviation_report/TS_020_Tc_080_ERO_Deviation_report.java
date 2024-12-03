package ERO_Deviation_report;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.Utils;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class TS_020_Tc_080_ERO_Deviation_report extends Keywords {
	public void Scenario020(WebDriver driver, ExtentTest test, ExtentTest test1, String url, int dataset)
			throws AWTException, IOException, InterruptedException {

		System.out.println("url : " + url);

		String Username = Utils.getDataFromTestData("TS_020_Tc_080_ERO_Dataset"+dataset, "ERO_Deviation_report", "Username");
		String Password = Utils.getDataFromTestData("TS_020_Tc_080_ERO_Dataset"+dataset, "ERO_Deviation_report", "Password");
		String ID = Utils.getDataFromTestData("TS_020_Tc_080_ERO_Dataset"+dataset, "ERO_Deviation_report", "Id");

		WebDriverWait wait = new WebDriverWait(driver, 60);
		Actions act = new Actions(driver);

		navigateUrl(driver, url);

		Fluentwait(driver, Username_input1);
		sendKeys(driver, Username_input1, Username);

		Fluentwait(driver, Password_input1);
		sendKeys(driver, Password_input1, Password);

		Fluentwait(driver, SignIn1);
		click(driver, SignIn1);

		wait(driver, "5");

		if (isDisplayed(driver, session_confirmation1)) {
			Fluentwait(driver, session_confirmation1);
			click(driver, session_confirmation1);
		}

		Fluentwait(driver, Searchbox1);
		sendKeys(driver, Searchbox1, "ERO Deviation report");

		Fluentwait(driver, Select_Deviation);
		click(driver, Select_Deviation);

		wait(driver, "3");

		click(driver, Cancel_Report);
		
		
		Fluentwait(driver, New_Report);
		click(driver, New_Report);

		Fluentwait(driver, Create_New_Confirm1);
		click(driver, Create_New_Confirm1);

		wait(driver, "5");

wait(driver,"3");



Extent_cal(test,"Testcase 80 - Ensure in Equipment Deviation Report, System is allowing to Display the difference between  two version No");

		
		
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
		
		wait(driver,"5");

		
		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);
		
		wait(driver,"5");
		
		Fluentwait(driver, Search3);
		click(driver, Search3);
		wait(driver,"5");

		
		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);
		
		wait(driver,"5");
		
		
		Fluentwait(driver, Search4);
		click(driver, Search4);
		wait(driver,"5");

		
		Fluentwait(driver, Select_ID_1);
		doubleClick(driver, Select_ID_1);
		
		wait(driver,"5");
		
		
		
		List<WebElement> Surplus_To_Deficient_Movement = driver.findElements(By.xpath("//tbody[@id='ERD-ERD_Version1DGrid_data']//tr//td[1]"));
		List<String> Surplus_Value1 = new ArrayList<String>();
		for (WebElement Surplus_Location :Surplus_To_Deficient_Movement) {
			String Surplus_Location1 = Surplus_Location.getText();
			Surplus_Value1.add(Surplus_Location1);
		}
		
		List<WebElement> Surplus_To_Deficient_Movement1 = driver.findElements(By.xpath("//tbody[@id='ERD-ERD_Version2DGrid_data']//tr//td[1]"));
		List<String> Surplus_Value2 = new ArrayList<String>();
		for (WebElement Surplus_Location :Surplus_To_Deficient_Movement1) {
			String Surplus_Location1 = Surplus_Location.getText();
			Surplus_Value2.add(Surplus_Location1);
		}	
		
			if(!Surplus_Value2.equals(Surplus_Value1)) {
					System.out.println("Matched || Expected Grid Value was : " + Surplus_Value1
							+ " Actual Grid Value was : " + Surplus_Value2);
					Extent_pass(driver, "Matched || Expected Grid Value was : "
							+ Surplus_Value1 + " Actual Grid Value was : " + Surplus_Value2,
							test,test1);
				} else {
					System.out.println(
							"Not Matched || Expected Grid Value was : " + Surplus_Value1
									+ " Actual Grid Value was : " + Surplus_Value2);
					Extent_fail2(driver, "Not Matched || Expected Grid Value was : "
							+ Surplus_Value1 + " Actual Grid Value was : " + Surplus_Value2,
							test);

				}
			
			
			
			
			System.out
			.println("//***************************Testcase 80 Completed **************************************//");	
			
	}		



		


}
