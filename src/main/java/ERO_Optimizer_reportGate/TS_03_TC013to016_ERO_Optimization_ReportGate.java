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

public class TS_03_TC013to016_ERO_Optimization_ReportGate extends Keywords {

	public void Scenario3(WebDriver driver, ExtentTest test, ExtentTest test1, String url, int dataset)
			throws AWTException, IOException {

		System.out.println("url : " + url);
		String Username = Utils.getDataFromTestData("TS_03_TC013to016_ERO_Optimization_ReportGate_Dataset"+dataset, "ReportGate",
				"Username");
		String Password = Utils.getDataFromTestData("TS_03_TC013to016_ERO_Optimization_ReportGate_Dataset"+dataset, "ReportGate",
				"Password");
		String ID = Utils.getDataFromTestData("TS_03_TC013to016_ERO_Optimization_ReportGate_Dataset"+dataset,
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

		Extent_cal(test, "Testcase 14 - Ensure Maximize button functionality");

		Fluentwait(driver, Tree_table_ERO);
		click(driver, Tree_table_ERO);

		Fluentwait(driver, Full_screen_ERO);
		click(driver, Full_screen_ERO);

		wait(driver, "3");

		takescreenshot(driver, "//Expected_screenshot//ERO Optimization Report Gate//Fullscreen");
		takescreenshot(driver, "//Actual_screenshot//ERO Optimization Report Gate//Fullscreen");

		if (imageComparison2(driver, "//ERO Optimization Report Gate//Fullscreen",
				"//ERO Optimization Report Gate//Fullscreen") == true) {

			System.out.println("Maximise button is working fine");
			Extent_pass(driver, "Maximise button is working fine", test, test1);
		} else {

			System.out.println("Maximise button is not working fine");
			Extent_fail(driver, "Maximise button is not working fine", test, test1);
		}

		System.out
				.println("//***************************Testcase 14 Completed **************************************//");

		Extent_cal(test, "Testcase 13 - Verify the minimize button functionality");

		Robot rbt1 = new Robot();

		rbt.keyPress(KeyEvent.VK_ESCAPE);

		takescreenshot(driver, "//Expected_screenshot//ERO Optimization Report Gate//Minimise");
		takescreenshot(driver, "//Actual_screenshot//ERO Optimization Report Gate//Minimise");

		if (imageComparison2(driver, "//ERO Optimization Report Gate//Minimise",
				"//ERO Optimization Report Gate//Minimise") == true) {

			System.out.println("Minimise button is working fine");
			Extent_pass(driver, "Minimise button is working fine", test, test1);
		} else {

			System.out.println("Minimise button is not working fine");
			Extent_fail(driver, "Minimise button is not working fine", test, test1);
		}

		System.out
				.println("//***************************Testcase 13 Completed **************************************//");

		Extent_cal(test, "Testcase 15 - Verify the scroll up and down functiobality in grids");

		wait(driver, "5");

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

		// WebElement scroller =
		// driver.findElement(By.xpath("//div[@ref='eBodyHorizontalScrollViewport']"));

		wait(driver, "5");

		Fluentwait(driver, Gridscroll_ERO);

		ScrollBarValidation1(driver, Gridscroll_ERO, "Grid scroll");

		System.out
				.println("//***************************Testcase 15 Completed **************************************//");

		Extent_cal(test, "Testcase 16 - Ensure Close button functionality");

		// scrollBottom(driver);

		waitForElement(driver, Close_routing_ERO);
		click(driver, Close_routing_ERO);

		wait(driver, "3");

		if (!isDisplayed(driver, Deficittab_ERO)) {

			System.out.println("After click on close button Current screen was closed");
			Extent_pass(driver, "After click on close button Current screen was closed", test, test1);

		} else {

			System.out.println("After click on close button Current screen was not closed");
			Extent_fail(driver, "After click on close button Current screen was not closed", test, test1);
		}

		System.out
				.println("//***************************Testcase 16 Completed **************************************//");

	}
}
