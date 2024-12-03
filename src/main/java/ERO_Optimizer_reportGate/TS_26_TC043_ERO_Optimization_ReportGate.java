package ERO_Optimizer_reportGate;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
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

public class TS_26_TC043_ERO_Optimization_ReportGate extends Keywords {

	public void Scenario26(WebDriver driver, ExtentTest test, ExtentTest test1, String url, int dataset)
			throws AWTException, IOException {

		System.out.println("url : " + url);
		String Username = Utils.getDataFromTestData("TS_26_TC043_ERO_Optimization_ReportGate_Dataset"+dataset, "ReportGate", "Username");
		String Password = Utils.getDataFromTestData("TS_26_TC043_ERO_Optimization_ReportGate_Dataset"+dataset, "ReportGate", "Password");
		String ID = Utils.getDataFromTestData("TS_26_TC043_ERO_Optimization_ReportGate_Dataset"+dataset, "ReportGate", "Id");
		String SelectAll = Utils.getDataFromTestData("TS_26_TC043_ERO_Optimization_ReportGate_Dataset"+dataset, "ReportGate", "Checked");


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
				" 43- Ensure that while click the  select all check  box a system is allow to  select the all check box");

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
		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);
		wait(driver, "2");

		click(driver, Show_Button_ERO);

		wait(driver, "3");

		click(driver, Detailed_view_ERO);

		wait(driver, "3");

		Fluentwait(driver, Checkbox_Selectall);
		click(driver, Checkbox_Selectall);
		

		
		

		wait(driver, "5");
		
		
		//String Validation_Checkbox = "";
	//	try {
		List<WebElement> Checkbox_Clicked = driver
				.findElements(By.xpath("//tbody[@id='ORG-ORG_treeOPE_data']//input[@type='checkbox']"));
		for (WebElement Checkbox : Checkbox_Clicked) {
			//Validation_Checkbox = Checkbox.getAttribute("checked");
				//System.out.println("Validation_Checkbox : "+Validation_Checkbox);

			if (Checkbox.isSelected()) {
				System.out.println("After select all check  box a system is allow to select the Table check box");
				Extent_pass(driver, "After select all check  box a system is allow to select the Table check box", test, test1);

			} else {

				System.out.println("After select all check  box a system is allow to Unselect the Table check box");
				Extent_fail(driver, "After select all check  box a system is allow to Unselect the Table check box", test, test1);
			}

		}
				
			
		
	//	}catch (Exception e) {
			//System.out.println(
			//		"Not Matched || Expected Data was : " + Validation_Checkbox
			//				+ " Actual Data was : " + SelectAll);
		//	Extent_fail(driver, "Not Matched || Expected Data was : "+ Validation_Checkbox + " Actual Data was : " + SelectAll,
					//test,test1);
		//}
//		System.out.println("Checkboxchecked : "+Checkboxchecked);
		
		
		

			
				


		
		
		
		
		
		
		
		
		
		/*

		if (isDisplayed(driver, Checked_Box)) {
			Extent_pass(driver, "Select All Checkbox is Selected", test, test1);
		} else {
			Extent_fail(driver, "Select All Checkbox is Not Selected", test, test1);
		}

*/
		

		}
	}


