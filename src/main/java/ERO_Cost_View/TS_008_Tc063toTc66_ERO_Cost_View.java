package ERO_Cost_View;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.Utils;

public class TS_008_Tc063toTc66_ERO_Cost_View extends Keywords {
	public void Scenario008(WebDriver driver, ExtentTest test, ExtentTest test1, String url, int dataset)
			throws AWTException, IOException {

		String Username = Utils.getDataFromTestData("TS_008_Tc063toTc066_ERO_Cost_View_Dataset" + dataset,
				"ERO_Cost_View", "Username");
		String Password = Utils.getDataFromTestData("TS_008_Tc063toTc066_ERO_Cost_View_Dataset" + dataset,
				"ERO_Cost_View", "Password");

		WebDriverWait wait = new WebDriverWait(driver, 60);

		Actions act = new Actions(driver);

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

		Extent_cal(test, "Testcase 63 - Ensure Confirmation pop up window having proper messages with icon(?)");

		Fluentwait(driver, CancelButton);

		click(driver, CancelButton);

		Fluentwait(driver, New_Button_Cost_View);
		click(driver, New_Button_Cost_View);

		Fluentwait(driver, New_Report_Popup_Msg);

		try {
			// elementScreenShot_new(driver, Cost_View_ques_Mark,
			// "/Expected_screenshot/Elementscreenshot/Questionmark");
			// wait(driver, "2");
			elementScreenShot_new(driver, Cost_View_ques_Mark, "/Actual_screenshot/Elementscreenshot/Questionmark");
			wait(driver, "2");
			imageComparison2(driver, "/Elementscreenshot/Questionmark", "/Elementscreenshot/Questionmark");
			Extent_pass(driver, "Matched Icon", test, test1);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
		}

		click(driver, Click_Yes_Popup);

		System.out
				.println("//***************************Testcase 63 Completed **************************************//");

		Extent_cal(test, "Testcase 65 - Ensure information pop up window having proper messages with icon(i)");

		wait(driver, "5");

		click(driver, Cost_View_ShowButton);

		try {
//	elementScreenShot_new(driver, Info_Icon, "/Expected_screenshot/Elementscreenshot/Infomark");
			// wait(driver, "2");
			elementScreenShot_new(driver, Info_Icon, "/Actual_screenshot/Elementscreenshot/Infomark");
			wait(driver, "2");
			imageComparison2(driver, "/Elementscreenshot/Infomark", "/Elementscreenshot/Infomark");
			Extent_pass(driver, "Matched Icon", test, test1);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
		}

		wait(driver, "5");

		System.out
				.println("//***************************Testcase 65 Completed **************************************//");

	}

}
