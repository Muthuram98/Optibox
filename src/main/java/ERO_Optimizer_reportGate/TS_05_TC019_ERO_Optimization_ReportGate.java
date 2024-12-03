package ERO_Optimizer_reportGate;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.Utils;

public class TS_05_TC019_ERO_Optimization_ReportGate extends Keywords{
	
	public void Scenario5(WebDriver driver, ExtentTest test, ExtentTest test1, String url, int dataset) throws AWTException, IOException {
		
		System.out.println("url : " + url);
		String Username = Utils.getDataFromTestData("TS_05_TC019_ERO_Optimization_ReportGate_Dataset"+dataset, "ReportGate","Username");
		String Password = Utils.getDataFromTestData("TS_05_TC019_ERO_Optimization_ReportGate_Dataset"+dataset, "ReportGate","Password");
		
    	String Error_Msg_popup_Location1 = Utils.getDataFromTestData("TS_05_TC019_ERO_Optimization_ReportGate_Dataset"+dataset, "ReportGate", "Error_Msg_popup_Region");

		
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
		
		
		
		Extent_cal(test,
				"Testcase 019 - Verify that system is allowing to display the validation msg while trying to click the load region search field without entering the ID");
		
		wait(driver, "5");
		
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
			
			
			Fluentwait(driver, Load_Region);
			click(driver, Load_Region);
			
			Fluentwait(driver, Error_msg_ERO_1);
			
			String Errormsgpopup_text = getText(driver, Error_msg_ERO_1);
		
			if (Errormsgpopup_text.equals(Error_Msg_popup_Location1)) {
				Extent_pass(driver, "Warning popup message having proper message with icon(!)", test,test1);
				System.out.println("Matched || Expected Warning popup message of creating new was : " + Error_Msg_popup_Location1
						+ " Actual Warning popup message of creating new was : " + Errormsgpopup_text);
				Extent_pass(driver, "Matched || Expected Warning popup message of creating new was : "
						+ Error_Msg_popup_Location1 + " Actual Warning popup message of creating new was : " + Errormsgpopup_text,
						test,test1);
			} else {
				System.out.println(
						"Not Matched || Expected Warning popup message of creating new was : " + Error_Msg_popup_Location1
								+ " Actual Warning popup message of creating new was : " + Errormsgpopup_text);
				Extent_fail2(driver, "Not Matched || Expected Warning popup message of creating new was : "
						+ Error_Msg_popup_Location1 + " Actual Warning popup message of creating new was : " + Errormsgpopup_text,
						test);

			}

		
			System.out
			.println("//***************************Testcase 19 Completed **************************************//");
		
	}
}