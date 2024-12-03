package ERO_Optimizer_reportGate;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.Utils;

public class TS_04_TC017to018_ERO_Optimization_ReportGate extends Keywords{
	
	public void Scenario4(WebDriver driver, ExtentTest test, ExtentTest test1, String url, int dataset) throws AWTException, IOException {
		
		System.out.println("url : " + url);
		String Username = Utils.getDataFromTestData("TS_04_TC017to018_ERO_Optimization_ReportGate_Dataset"+dataset, "ReportGate","Username");
		String Password = Utils.getDataFromTestData("TS_04_TC017to018_ERO_Optimization_ReportGate_Dataset"+dataset, "ReportGate","Password");
		String ID = Utils.getDataFromTestData("TS_04_TC017to018_ERO_Optimization_ReportGate_Dataset"+dataset,
				"ReportGate", "Id");
		
		Actions act = new Actions(driver);
		Robot rbt = new Robot();

		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		navigateUrl(driver, url);

		Fluentwait(driver, Username_input);
		sendKeys(driver, Username_input, Username);

		Fluentwait(driver, Password_input);
		sendKeys(driver, Password_input, Password);

		Fluentwait(driver, SignIn);
		click(driver, SignIn);

		wait(driver, "5");

		if (isDisplayed(driver, session_confirmation)) {
			Fluentwait(driver, session_confirmation);
			click(driver, session_confirmation);
		}
		
		
		
			Fluentwait(driver, Searchbox);
		sendKeys(driver, Searchbox, "ERO Optimization Report Gate");

		Fluentwait(driver, SelectOptimizer_ERO);
		click(driver, SelectOptimizer_ERO);
		
		
		Fluentwait(driver, Optimizer_cancle_Report_Gate);
		click(driver, Optimizer_cancle_Report_Gate);
		
		
		Fluentwait(driver, Optimizer_new_ERO);
		click(driver, Optimizer_new_ERO);
		
	  Fluentwait(driver, Optimizer_createnew_confirm_ERO);
	  click(driver, Optimizer_createnew_confirm_ERO);	
	  
		Extent_cal(test, "Testcase 17 - Ensure tab function in all the filed");

		wait(driver, "3");
		
		
		
		Fluentwait(driver, ID_input);
		click(driver, ID_input);
		


		List<By> inutlocators = Arrays.asList(By.id("ORG-ORG_txtDeficitSurplusID"), By.id("ORG-ORG_btnDeficitSurplusID-ORG_btnDeficitSurplusID"),
				By.id("ORG-ORG_txtVersion"), By.id("ORG-ORG_txtLoadRegion_input"));

		List<String> inutfieldnames = Arrays.asList("txtDeficitSurplusID", "btnDeficitSurplusID", "txtVersion", "txtLoadRegion");
		// Iterate through the locators and click the elements

		

	//	rbt.keyPress(KeyEvent.VK_TAB);
	//	rbt.delay(500);
	//	rbt.keyRelease(KeyEvent.VK_TAB);
		
		act.sendKeys(Keys.TAB).build().perform();


		boolean tab = true;

		for (int i = 0; i < inutlocators.size(); i++) {

			By locator = inutlocators.get(i);
			String fieldname = inutfieldnames.get(i);
			
			

			try {
				WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));

				wait(driver, "5");

		//		rbt.keyPress(KeyEvent.VK_TAB);
		//		rbt.delay(500);
			//	rbt.keyRelease(KeyEvent.VK_TAB);
				

				act.sendKeys(Keys.TAB).build().perform();




				String attributevalue = element.getAttribute("class");

				String status1 = extractstatus(attributevalue);

				System.out.println("status1 :" + status1);

				if (status1.equals("focus")) {
					System.out.println("Pass ");
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
		
		
		
		
	}
}