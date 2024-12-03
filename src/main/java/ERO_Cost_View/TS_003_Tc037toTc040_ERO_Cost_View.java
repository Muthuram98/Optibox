package ERO_Cost_View;

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
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.Utils;

public class TS_003_Tc037toTc040_ERO_Cost_View extends Keywords {
	public void Scenario003(WebDriver driver, ExtentTest test, ExtentTest test1, String url, int dataset)
			throws AWTException, IOException {

		String Username = Utils.getDataFromTestData("TS_003_Tc037toTc040_ERO_Cost_View_Dataset" + dataset,
				"ERO_Cost_View", "Username");
		String Password = Utils.getDataFromTestData("TS_003_Tc037toTc040_ERO_Cost_View_Dataset" + dataset,
				"ERO_Cost_View", "Password");

		Actions act = new Actions(driver);
		Robot rbt = new Robot();

		WebDriverWait wait = new WebDriverWait(driver, 30);

		navigateUrl(driver, url);

		Fluentwait(driver, UsernameInput);
		sendKeys(driver, UsernameInput, Username);

		Fluentwait(driver, PasswordInput);
		sendKeys(driver, PasswordInput, Password);

		Fluentwait(driver, Sign_In);
		click(driver, Sign_In);

		wait(driver, "5");

		if (isDisplayed(driver, sessionConfirmation)) {
			Fluentwait(driver, sessionConfirmation);
			click(driver, sessionConfirmation);
		}

		wait(driver, "5");

		Fluentwait(driver, Searchbox_Cost_View);
		sendKeys(driver, Searchbox_Cost_View, "ERO Cost View");

		Fluentwait(driver, Cost_View_Screen);
		click(driver, Cost_View_Screen);

		wait(driver, "5");

		Extent_cal(test, "Testcase 14 - Ensure Maximize button functionality");

		Fluentwait(driver, CancelButton);

		click(driver, CancelButton);

		wait(driver, "3");

		wait(driver, "3");

		Fluentwait(driver, New_Button_Cost_View);

		click(driver, New_Button_Cost_View);

		wait(driver, "3");

		Fluentwait(driver, Click_Yes_Popup);
		click(driver, Click_Yes_Popup);

		wait(driver, "3");

		wait(driver, "3");

		click(driver, Plus_Button);

		wait(driver, "5");

		Fluentwait(driver, Loc_Search_Cost_View);
		click(driver, Loc_Search_Cost_View);
		wait(driver, "3");

		doubleClick(driver, Select_Loc_Code);

		wait(driver, "3");

		click(driver, Cost_View_ShowButton);
		wait(driver, "2");

		click(driver, Tree_Table_Cost_View);

		wait(driver, "2");

		click(driver, FullScreen_Button);

		wait(driver, "3");

		takescreenshot(driver, "//Expected_screenshot//ERO Cost View//Fullscreen");
		takescreenshot(driver, "//Actual_screenshot//ERO Cost View//Fullscreen");

		if (imageComparison2(driver, "//ERO Cost View//Fullscreen", "//ERO Cost View//Fullscreen") == true) {

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

		takescreenshot(driver, "//Expected_screenshot//ERO Cost View//Minimise");
		takescreenshot(driver, "//Actual_screenshot//ERO Cost View//Minimise");

		if (imageComparison2(driver, "//ERO Cost View//Minimise", "//ERO Cost View//Minimise") == true) {

			System.out.println("Minimise button is working fine");
			Extent_pass(driver, "Minimise button is working fine", test, test1);
		} else {

			System.out.println("Minimise button is not working fine");
			Extent_fail(driver, "Minimise button is not working fine", test, test1);
		}

		System.out
				.println("//***************************Testcase 13 Completed **************************************//");

		Extent_cal(test, "Testcase 15 - Verify the scroll up and down functiobality in grids");

		scrollBottom(driver);
		// WebElement scroller =
		// driver.findElement(By.xpath("//div[@ref='eBodyHorizontalScrollViewport']"));

		wait(driver, "5");

		Fluentwait(driver, Scroll_Grid);

		ScrollBarValidation1(driver, Scroll_Grid, "Grid scroll");

		System.out
				.println("//***************************Testcase 15 Completed **************************************//");

		Extent_cal(test, "Testcase 16 - Ensure Close button functionality");

		scrollUp(driver);
		waitForElement(driver, Close_Button_Cost_View);
		click(driver, Close_Button_Cost_View);

		wait(driver, "3");

		if (!isDisplayed(driver, Cost_View_Tab)) {

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
