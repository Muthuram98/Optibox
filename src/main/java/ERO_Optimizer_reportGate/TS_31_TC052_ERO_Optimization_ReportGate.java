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

public class TS_31_TC052_ERO_Optimization_ReportGate extends Keywords{

	public void Scenario31(WebDriver driver, ExtentTest test, ExtentTest test1, String url, int dataset) throws AWTException, IOException {
		
		String Username = Utils.getDataFromTestData("TS_31_TC052_ERO_Optimization_ReportGate_Dataset"+dataset, "ReportGate","Username");
		String Password = Utils.getDataFromTestData("TS_31_TC052_ERO_Optimization_ReportGate_Dataset"+dataset, "ReportGate","Password");
		String ID = Utils.getDataFromTestData("TS_31_TC052_ERO_Optimization_ReportGate_Dataset"+dataset, "ReportGate", "Id");

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
		
		
		Extent_cal(test, "Testcase 52 - Ensure that while click the ID search button a system is allow to display a ID number");	

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
	  
	  
	  Fluentwait(driver, Globalserach_ERO);
		click(driver, Globalserach_ERO);

		Fluentwait(driver, Globalserach_IDInput_ERO);
		sendKeys(driver, Globalserach_IDInput_ERO, ID);

		Fluentwait(driver, Click_Search_ERO);
		click(driver, Click_Search_ERO);

		wait(driver, "3");
		
		
		
      String ID_text = getText(driver, ID_Text);
		
		System.out.println("ID_text : "+ID_text);
		
		
		wait(driver, "3");
		
		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);	
	  
		wait(driver, "3");
		
		
		
String ID_text2 = getAttribute(driver, ERO_ID_Field, "value");
		
		System.out.println("ID_text2 : "+ID_text2);
			
		
		if (ID_text.equals(ID_text2)) {
			System.out.println("Matched || Expected Display ID was : " + ID_text2
					+ " Actual Display ID was : " + ID_text);
			Extent_pass(driver, "Matched || Expected Display ID was : "
					+ ID_text2 + " Actual Display ID was : " + ID_text,
					test,test1);
		} else {
			System.out.println(
					"Not Matched || Expected Display ID was : " + ID_text2
							+ " Actual Display ID was : " + ID_text);
			Extent_fail2(driver, "Not Matched || Expected Display ID was : "
					+ ID_text2 + " Actual Display ID was : " + ID_text,
					test);

		}
		
		
		
		
		
		
		
		
		
		System.out
		.println("//***************************Testcase 52 Completed **************************************//");	
		
	}
}
