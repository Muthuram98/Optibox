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

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.Utils;

public class TS_01_TC01to03_ERO_Optimization_ReportGate extends Keywords {

	public void Scenario1(WebDriver driver, ExtentTest test, ExtentTest test1, String url, int dataset)
			throws AWTException, IOException {

		System.out.println("url : " + url);
		String Username = Utils.getDataFromTestData("TS_01_TC01to03_ERO_Optimization_ReportGate_Dataset"+dataset, "ReportGate",
				"Username");
		String Password = Utils.getDataFromTestData("TS_01_TC01to03_ERO_Optimization_ReportGate_Dataset"+dataset, "ReportGate",
				"Password");
		String Expected_screencolor = Utils.getDataFromTestData("TS_01_TC01to03_ERO_Optimization_ReportGate_Dataset"+dataset,
				"ReportGate", "Screen_background");
		String Expected_Autogeneratedcolorcode = Utils.getDataFromTestData("TS_01_TC01to03_ERO_Optimization_ReportGate_Dataset"+dataset,
				"ReportGate", "Autogenerated_Color");
		String ID = Utils.getDataFromTestData("TS_01_TC01to03_ERO_Optimization_ReportGate_Dataset"+dataset, "ReportGate", "Id");

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

		Extent_cal(test, "Testcase 01 - When open a new screen,cancel and export button should be in enable status");

		wait(driver, "5");

		if (IsElementEnabled(driver, Optimizer_cancle_Report_Gate)) {

			System.out.println("Cancel button is in enable status");
			Extent_pass(driver, "Cancel button is in enable status", test, test1);

		} else {

			System.out.println("Cancel button is not in enable status");
			Extent_fail(driver, "Cancel button is not in enable status", test, test1);
		}

		if (IsElementEnabled(driver, Export_Button)) {

			System.out.println("Export button is in enable status");
			Extent_pass(driver, "Export button is in enable status", test, test1);

		} else {

			System.out.println("Export button is not in enable status");
			Extent_fail(driver, "Export button is not in enable status", test, test1);
		}

		System.out
				.println("//***************************Testcase 1 Completed **************************************//");

		Extent_cal(test,
				"Testcase 02 - Ensure that while click the cancel button,a new button should be in enable status");

		Fluentwait(driver, Optimizer_cancle_Report_Gate);
		click(driver, Optimizer_cancle_Report_Gate);

		// Fluentwait(driver, Optimizer_new_ERO);
		// click(driver, Optimizer_new_ERO);

		wait(driver, "5");

		if (IsElementEnabled(driver, Optimizer_new_ERO)) {

			System.out.println("After clicking the Cancel button, the New button is in enable status");
			Extent_pass(driver, "After clicking the Cancel button, the New button is in enable status", test, test1);

		} else {

			System.out.println("After clicking the Cancel button, the New button is not in enable status");
			Extent_fail(driver, "After clicking the Cancel button, the New button is not in enable status", test,
					test1);
		}

		System.out
				.println("//***************************Testcase 2 Completed **************************************//");

		Extent_cal(test,
				"Testcase 03 - Ensure that while click the new button a cancel and export button should be in enable status");

		Fluentwait(driver, Optimizer_new_ERO);
		click(driver, Optimizer_new_ERO);

		Fluentwait(driver, Optimizer_createnew_confirm_ERO);
		click(driver, Optimizer_createnew_confirm_ERO);

		wait(driver, "5");

		if (IsElementEnabled(driver, Optimizer_cancle_Report_Gate)) {

			System.out.println("After clicking the New button, the Cancel button is in enable status");
			Extent_pass(driver, "After clicking the New button, the Cancel button is in enable status", test, test1);

		} else {

			System.out.println("After clicking the New button, the Cancel button is not in enable status");
			Extent_fail(driver, "After clicking the New button, the Cancel button is not in enable status", test,
					test1);
		}

		if (IsElementEnabled(driver, Export_Button)) {

			System.out.println("After clicking the New button, Export button is in enable status");
			Extent_pass(driver, "After clicking the New button, Export button is in enable status", test, test1);

		} else {

			System.out.println("After clicking the New button, Export button is not in enable status");
			Extent_fail(driver, "After clicking the New button, Export button is not in enable status", test, test1);
		}

		System.out
				.println("//***************************Testcase 3 Completed **************************************//");

		Extent_cal(test, "Testcase 04 - Ensure that the screen background should be in correct color.");

		Fluentwait(driver, Screen_ERO);
		wait(driver, "2");

		String actualscreencolor = getTextBackgroundColor(driver, Screen_ERO);

		if (actualscreencolor.equals(Expected_screencolor)) {

			System.out.println("Screen Background color Matched || Expected screen color was : " + Expected_screencolor
					+ " || Actual screen color was " + actualscreencolor);
			Extent_pass(driver, "Screen Background color Matched || Expected screen color was : " + Expected_screencolor
					+ " || Actual screen color was " + actualscreencolor, test, test1);

		} else {
			System.out.println("Screen Background color Not Matched || Expected screen color was : "
					+ Expected_screencolor + " || Actual screen color was " + actualscreencolor);
			Extent_fail(driver, "Screen Background color Not Matched || Expected screen color was : "
					+ Expected_screencolor + " || Actual screen color was " + actualscreencolor, test, test1);
		}

		System.out
				.println("//***************************Testcase 4 Completed **************************************//");

		
	}

}
