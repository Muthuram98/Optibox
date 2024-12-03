package ERO_Routing_Scripts;

import java.awt.Robot;
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

public class ERO_Routing_Scenario33_TC289_292 extends Keywords {

	public void ERO_Scenario33(WebDriver driver, ExtentTest test, ExtentTest test1, String url, int dataset)
			throws Exception {
		String Username = Utils.getDataFromTestData("ERO_Scenario33_Dataset" + dataset, "ERO Routing", "Username");
		String Password = Utils.getDataFromTestData("ERO_Scenario33_Dataset" + dataset, "ERO Routing", "Password");
		String ID = Utils.getDataFromTestData("ERO_Scenario33_Dataset" + dataset, "ERO Routing", "Id");

		navigateUrl(driver, url);

		Robot rbt = new Robot();
		Actions act = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		Fluentwait(driver, Username_input);
		sendKeys(driver, Username_input, Username);

		Fluentwait(driver, Password_input);
		sendKeys(driver, Password_input, Password);

		Fluentwait(driver, SignIn);
		click(driver, SignIn);

		wait(driver, "3");

		if (isDisplayed(driver, session_confirmation)) {
			Fluentwait(driver, session_confirmation);
			click(driver, session_confirmation);
		}

		Fluentwait(driver, Searchbox);
		sendKeys(driver, Searchbox, "Ero Rou");

		Fluentwait(driver, Select_Optimizer);
		click(driver, Select_Optimizer);

		wait(driver, "3");

		Extent_cal(test,
				" 286- Check whether system should display the web page with By volume,By cost,By region wise, network chart tabs ");

		Fluentwait(driver, Routing_GlobalSearch);
		click(driver, Routing_GlobalSearch);

		Fluentwait(driver, Globalserach_IDInput);
		sendKeys(driver, Globalserach_IDInput, ID);

		wait(driver, "2");

		Fluentwait(driver, Click_Search);
		click(driver, Click_Search);

		wait(driver, "5");

		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);

		wait(driver, "5");

		if (isDisplayed(driver, ERO_popup_ok)) {

			click(driver, ERO_popup_ok);
		}

		click(driver, Optimizer_Button);

		click(driver, Ok_Pop);

		wait(driver, "3");

		Fluentwait(driver, ERO_Chat);
		click(driver, ERO_Chat);

		wait(driver, "5");

		WebElement chart = driver.findElement(By.xpath("//object"));
		driver.switchTo().frame(chart);

//		wait(driver, "10");
//
//		Extent_cal(test,
//				"Testcase 289 Ensure the By cost tab chart wise representation x axis cost details and y axis surplus ports details displayed with “>” button functionality ");
//
//		Fluentwait(driver, ByCOst);
//		click(driver, ByCOst);
//
//		Scrolltilltheelementvisible(driver, Vol_Surplus_Backward1);
//
//		Fluentwait(driver, Vol_Surplus_Backward1);
//
//		if (isDisplayed(driver, Vol_Surplus_Backward1)) {
//			Extent_pass(driver, "Forward Button is Displayed", test, test1);
//		} else {
//			Extent_fail(driver, "Forward Button is Not  Displayed", test, test1);
//			global = " Backward Button is Not Displayed";
//		}
//
//		Extent_cal(test,
//				"Testcase 290 Ensure the By Cost tab chart wise representation x axis quantity details and y axis surplus details displayed with “<” button functionality ");
//
//		Fluentwait(driver, Vol_Surplus_Forward1);
//
//		if (isDisplayed(driver, Vol_Surplus_Forward1)) {
//			Extent_pass(driver, "Forward Button is Displayed", test, test1);
//		} else {
//			Extent_fail(driver, "Forward Button is Not  Displayed", test, test1);
//			global = " Backward Button is Not Displayed";
//		}
//
//		System.out.println(
//				"//***************************Testcase 290 Completed **************************************//");
//
//		Extent_cal(test,
//				"Testcase 291 Ensure the By Cost tab chart wise representation x axis quantity details and y axis deficit details displayed with “>” button functionality  ");
//
//		Fluentwait(driver, Vol_Deficit_Backward1);
//
//		if (isDisplayed(driver, Vol_Deficit_Backward1)) {
//			Extent_pass(driver, "Backward Button is Displayed", test, test1);
//		} else {
//			Extent_fail(driver, "Backward Button is Not  Displayed", test, test1);
//			global = " Backward Button is Not Displayed";
//		}
//
//		System.out.println(
//				"//***************************Testcase 291 Completed **************************************//");
//
//		Extent_cal(test,
//				"Testcase 292 Ensure the By Cost tab chart wise representation x axis quantity details and y axis deficit details displayed with “<” button functionality for one equipment type ");
//
//		Fluentwait(driver, Vol_Deficit_Forward1);
//
//		if (isDisplayed(driver, Vol_Deficit_Forward1)) {
//			Extent_pass(driver, "Forward Button is Displayed", test, test1);
//		} else {
//			Extent_fail(driver, "Forward Button is Not  Displayed", test, test1);
//			global = " Backward Button is Not Displayed";
//		}
//
//		System.out.println(
//				"//***************************Testcase 292 Completed **************************************//");

	}
}
