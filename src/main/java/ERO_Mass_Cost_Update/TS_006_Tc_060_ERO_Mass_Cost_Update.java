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

public class TS_006_Tc_060_ERO_Mass_Cost_Update extends Keywords{
	public void Scenario006(WebDriver driver, ExtentTest test,ExtentTest test1,String url, int dataset) throws AWTException, IOException, InterruptedException {	
	
	System.out.println("url : "+url);
	
	String Username = Utils.getDataFromTestData("TS_006_Tc_060_ERO_Mass_Cost_Update_Dataset"+dataset, "ero_mass_cost_update", "Username");
	String Password = Utils.getDataFromTestData("TS_006_Tc_060_ERO_Mass_Cost_Update_Dataset"+dataset, "ero_mass_cost_update", "Password");
	String ID = Utils.getDataFromTestData("TS_006_Tc_060_ERO_Mass_Cost_Update_Dataset"+dataset, "ero_mass_cost_update", "Id");
	
	
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
		
		
		Extent_cal(test,"Testcase 60 - Ensure while moving the cursor on the tool bar ,system should show the tool tips");

		wait(driver, "5");

		for (int i = 1; i <= 14; i++) {

			WebElement button = driver.findElement(By.xpath("((//div[@id='MCU-MCU_Toolbarid-tblComponent']//button)[" + i + "]//span)[1]"));

			wait(driver, "2");

			act.moveToElement(button).build().perform();

			String buttonname = Utils.getDataFromTestData("TS_006_Tc_060_ERO_Mass_Cost_Update_Dataset"+dataset,
					"ero_mass_cost_update", "Button" + i);

			WebElement Tooltipfield = driver.findElement(By.xpath("(//div[@id='MCU-MCU_Toolbarid-tblComponent']//button)["
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

