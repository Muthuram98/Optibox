package ERO_Deviation_report;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
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

public class TS_006_Tc_060_ERO_Deviation_report extends Keywords{
	public void Scenario006(WebDriver driver, ExtentTest test,ExtentTest test1,String url, int dataset) throws AWTException, IOException, InterruptedException {	
	
	System.out.println("url : "+url);
	
	String Username = Utils.getDataFromTestData("TS_006_Tc_060_ERO_Dataset"+dataset, "ERO_Deviation_report", "Username");
	String Password = Utils.getDataFromTestData("TS_006_Tc_060_ERO_Dataset"+dataset, "ERO_Deviation_report", "Password");
	String ID = Utils.getDataFromTestData("TS_006_Tc_060_ERO_Dataset"+dataset, "ERO_Deviation_report", "Id");
	
	
	Actions act = new Actions(driver);
	Robot rbt = new Robot();
	
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
		
	
		
		Extent_cal(test,"Testcase 60 - Ensure while moving the cursor on the tool bar ,system should show the tool tips");

		wait(driver, "5");

		for (int i = 1; i <= 14; i++) {

			WebElement button = driver.findElement(By.xpath("((//div[@id='ERD-ERD_toolbarid-tblComponent']//button)[" + i + "]//span)[1]"));

			wait(driver, "2");

			act.moveToElement(button).build().perform();

			String buttonname = Utils.getDataFromTestData("TS_006_Tc_060_ERO",
					"ERO_Deviation_report", "Button" + i);

			WebElement Tooltipfield = driver.findElement(By.xpath("(//div[@id='ERD-ERD_toolbarid-tblComponent']//button)["
					+ i + "]//span[contains(text(),'" + buttonname + "')]"));

			if (isDisplayed1(driver, Tooltipfield)) {

				Extent_pass(driver, "Tool tip for " + buttonname + " is displayed", test,test1);

				getTextofWebelement(driver, Tooltipfield, "Tool tip");
			
			} else {

				Extent_fail(driver, "Tool tip for " + buttonname + " is not displayed", test,test1);
			}

//			wait(driver, "3");

		}	
		
		
		System.out
		.println("//***************************Testcase 60 Completed **************************************//");	
		
		
	
	
	}
	

}
