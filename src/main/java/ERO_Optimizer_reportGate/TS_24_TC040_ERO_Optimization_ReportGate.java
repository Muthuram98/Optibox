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

public class TS_24_TC040_ERO_Optimization_ReportGate extends Keywords {

	public void Scenario32(WebDriver driver, ExtentTest test, ExtentTest test1, String url, int dataset)
			throws AWTException, IOException {

		System.out.println("url : " + url);
		String Username = Utils.getDataFromTestData("TS_024_TC040_ERO_Optimization_ReportGate_Dataset"+dataset, "ReportGate",
				"Username");
		String Password = Utils.getDataFromTestData("TS_024_TC040_ERO_Optimization_ReportGate_Dataset"+dataset, "ReportGate",
				"Password");
		String ID = Utils.getDataFromTestData("TS_024_TC040_ERO_Optimization_ReportGate_Dataset"+dataset, "ReportGate",
				"Id");
		String AllocatedQuantity = Utils.getDataFromTestData("TS_024_TC040_ERO_Optimization_ReportGate_Dataset"+dataset, "ReportGate",
				"Allocate_Quantity_Number");

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
				"Testcase 40 - Ensure that while click the allocated quantity field a system is allow to enter a allocate quantity");

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

		wait(driver, "5");
		Fluentwait(driver, Show_Button_ERO);
		click(driver, Show_Button_ERO);

		wait(driver, "3");

		Fluentwait(driver, Detailed_view_ERO);
		click(driver, Detailed_view_ERO);

		wait(driver, "3");

		String Allocateqty_popup_text1 = getText(driver, Allocate_Quantity);
		System.out.println("Allocateqty_popup_text1 : " + Allocateqty_popup_text1);

		wait(driver, "3");

		click(driver, Allocate_Quantity);

		wait(driver, "2");
//		doubleClick(driver, Allocate_Quantity);
		wait(driver, "2");
		
		clearAndType(driver, Allocate_Quantity1, AllocatedQuantity);

		wait(driver, "2");

		enter(driver);
		wait(driver, "3");

		String Allocateqty_popup_text2 = getText(driver, Allocate_Quantity);
		System.out.println("Allocateqty_popup_text2 : " + Allocateqty_popup_text2);

		if (!Allocateqty_popup_text1.equals(Allocateqty_popup_text2)) {
			System.out.println("Matched || Expected Allocated quantity was : " + Allocateqty_popup_text2
					+ " Actual Allocated quantity was : " + Allocateqty_popup_text1);
			Extent_pass(driver, "NotMatched || Expected Allocated quantity was : " + Allocateqty_popup_text2
					+ " Actual Allocated quantity was : " + Allocateqty_popup_text1, test, test1);
		} else {
			System.out.println("Not Matched || Expected Allocated quantity was : " + Allocateqty_popup_text2
					+ " Actual Allocated quantity was : " + Allocateqty_popup_text1);
			Extent_fail2(driver, "Matched || Expected Allocated quantity was : " + Allocateqty_popup_text2
					+ " Actual Allocated quantity was : " + Allocateqty_popup_text1, test);

		}

	}
}