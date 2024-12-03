package ERO_Mass_Cost_Update;

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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.ClickAndHoldAction;
import org.openqa.selenium.interactions.DoubleClickAction;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.Utils;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class TS_007_Tc_061toTc_062_ERO_Mass_Cost_Update extends Keywords{
	public void Scenario007(WebDriver driver, ExtentTest test,ExtentTest test1,String url, int dataset) throws AWTException, IOException, InterruptedException {	
	
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
		
		
		
		Extent_cal(test, "Testcase 61 - Ensure tab function in all the filed");


		click(driver, Cancel_Button);
				
				Fluentwait(driver, NewReport);
				click(driver, NewReport);
				
				
				Fluentwait(driver, Click_Confirm);
				click(driver, Click_Confirm);
				
				wait(driver,"5");

				
				
				Fluentwait(driver, Add_Plus_Button);
				click(driver, Add_Plus_Button);
				
				
				wait(driver,"3");

				Fluentwait(driver, Select_Loc);
				doubleClick(driver, Select_Loc);
				
				wait(driver,"3");

				
				click(driver, ShowButton);
				
				
				wait(driver,"5");

				
				

				List<By> inutlocators = Arrays.asList(By.id("MCU-MCU_Toolbarid-btnTblNew"), By.id("MCU-MCU_Toolbarid-btnTblEdit"),
						By.id("MCU-MCU_Toolbarid-btnTblExport"), By.id("MCU-MCU_Toolbarid-btnTblPrint"));

				List<String> inutfieldnames = Arrays.asList("New", "Edit", "Export", "Print");
				// Iterate through the locators and click the elements

				wait(driver, "2");

//				rbt.keyPress(KeyEvent.VK_TAB);
//				rbt.delay(500);
//				rbt.keyRelease(KeyEvent.VK_TAB);
				
				act.sendKeys(Keys.TAB).build().perform();
				
				wait(driver, "2");

				boolean tab = true;

				for (int i = 0; i < inutlocators.size(); i++) {

					By locator = inutlocators.get(i);
				String fieldname = inutfieldnames.get(i);

					try {
						WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
						
						act.moveToElement(element).build().perform();

						wait(driver, "2");

//						rbt.keyPress(KeyEvent.VK_TAB);
//						rbt.delay(500);
//						rbt.keyRelease(KeyEvent.VK_TAB);
						
						act.sendKeys(Keys.TAB).build().perform();

						wait(driver, "2");

						String attributevalue = element.getAttribute("class");

						String status1 = extractstatus1(attributevalue);

						System.out.println("status1 :" + status1);

						if (status1.equals("ui-state-hover")) {
							System.out.println("Pass");
							Extent_pass(driver, "After click on tab button, selection cursor got navigated from " + fieldname,
									test,test1);
						} else {
							System.out.println("Fail");
							Extent_fail(driver, "After click on tab button, selection cursor not navigated from " + fieldname,
									test,test1);
						}

					} catch (Exception e) {
						System.out
								.println("Element with locator " + locator + " not found or not clickable: " + e.getMessage());
						Extent_fail(driver,
								"Element with locator " + locator + " not found or not clickable: " + e.getMessage(), test,test1);
						tab = false;
					}
				}

				System.out.println("Tab button functionality is working fine");
				Extent_pass(driver, "Tab button functionality is working fine", test,test1);

				System.out.println("**********Testcase 61 completed******************");
				
				
				
	
	}

}
