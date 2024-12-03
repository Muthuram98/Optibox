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

public class TS_25_TC041_042ERO_Optimization_ReportGate extends Keywords {

	public void Scenario25(WebDriver driver, ExtentTest test, ExtentTest test1, String url, int dataset)
			throws AWTException, IOException {

		String Username = Utils.getDataFromTestData("TS_025_TC041_042ERO_Optimization_ReportGate_Dataset"+dataset, "ReportGate",
				"Username");
		String Password = Utils.getDataFromTestData("TS_025_TC041_042ERO_Optimization_ReportGate_Dataset"+dataset, "ReportGate",
				"Password");
		String ID = Utils.getDataFromTestData("TS_025_TC041_042ERO_Optimization_ReportGate_Dataset"+dataset, "ReportGate", "Id");

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

		Extent_cal(test, "Testcase 41 - Verify the check box");

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

		wait(driver, "3");

		click(driver, Show_Button_ERO);

		wait(driver, "5");

		Fluentwait(driver, Detailed_view_ERO);
		click(driver, Detailed_view_ERO);

		wait(driver, "3");

		Fluentwait(driver, Checkbox_Select);
		click(driver, Checkbox_Select);
		wait(driver, "3");

		
		if (isElementSelected(driver, Checkbox_Select)) {
			System.out.println("After click checkbox, Checkbox was selected");
			Extent_pass(driver, "After click checkbox, Checkbox was selected", test,test1);
		} else {
			System.out.println("After click checkbox, Checkbox was Unselected");

			Extent_fail(driver, "After click checkbox, Checkbox was Unselected", test,test1);
		}
		

		System.out
				.println("//***************************Testcase 41 Completed **************************************//");

		Extent_cal(test, "Testcase 42 - Verify the allocate to agency button is enable");

		wait(driver, "5");

		Fluentwait(driver, Allocate_to_Agency);

		if (IsElementEnabled(driver, Allocate_to_Agency)) {
			Extent_pass(driver, "Allocate to agency button is enabled", test, test1);
		} else {
			Extent_fail(driver, "Allocate to agency is not enabled", test, test1);
		}
		wait(driver, "2");

		System.out
				.println("//***************************Testcase 42 Completed **************************************//");

	}
}
