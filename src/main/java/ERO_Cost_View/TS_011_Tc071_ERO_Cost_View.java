package ERO_Cost_View;

import java.awt.AWTException;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.Utils;

public class TS_011_Tc071_ERO_Cost_View extends Keywords {
	public void Scenario011(WebDriver driver, ExtentTest test, ExtentTest test1, String url, int dataset)
			throws AWTException, IOException {

		String Username = Utils.getDataFromTestData("TS_011_Tc071_ERO_Cost_View_Dataset" + dataset, "ERO_Cost_View",
				"Username");
		String Password = Utils.getDataFromTestData("TS_011_Tc071_ERO_Cost_View_Dataset" + dataset, "ERO_Cost_View",
				"Password");
		String Confirmation_Popup = Utils.getDataFromTestData("TS_011_Tc071_ERO_Cost_View_Dataset" + dataset,
				"ERO_Cost_View", "ConfirmPopup");

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

		Extent_cal(test, "Testcase 71 - Ensure all button functionalities working");

		Extent_cal(test, "Button1");

		Fluentwait(driver, CancelButton);

		click(driver, CancelButton);

		wait(driver, "3");

		if (IsElementEnabled(driver, New_Button_Cost_View)) {

			System.out.println("After Click Cancel Button, the New button is in enable status");
			Extent_pass(driver, "After Click Cancel Button, the New button is in enable status", test, test1);

		} else {

			System.out.println("After Click Cancel Button, the New button is not in enable status");
			Extent_fail(driver, "After Click Cancel Button, the New button is not in enable status", test, test1);
		}

		Extent_cal(test, "Button2");

		wait(driver, "3");

		Fluentwait(driver, New_Button_Cost_View);

		click(driver, New_Button_Cost_View);

		wait(driver, "3");

		Fluentwait(driver, New_Report_Popup_Msg);
		String Confirm_Popup = getText(driver, New_Report_Popup_Msg);

		if (Confirm_Popup.equals(Confirmation_Popup)) {
			System.out
					.println("Matched || Expected Information popup message of creating new was : " + Confirmation_Popup
							+ " || Actual Information popup message of creating new was : " + Confirm_Popup);
			Extent_pass(driver,
					"Matched || Expected Information popup message of creating new was : " + Confirmation_Popup
							+ " || Actual Information popup message of creating new was : " + Confirm_Popup,
					test, test1);
		} else {
			System.out.println(
					"Not Matched || Expected Information popup message of creating new was : " + Confirmation_Popup
							+ " || Actual Information popup message of creating new was : " + Confirm_Popup);
			Extent_fail2(driver,
					"Not Matched || Expected Information popup message of creating new was : " + Confirmation_Popup
							+ " || Actual Information popup message of creating new was : " + Confirm_Popup,
					test);

		}

		Fluentwait(driver, Click_Yes_Popup);
		click(driver, Click_Yes_Popup);

		wait(driver, "3");

		Extent_cal(test, "Button3");

		if (IsElementEnabled(driver, CancelButton)) {

			System.out.println("After click the New Button, Cancel button is in enable status");
			Extent_pass(driver, "After click the New Button, Cancel button is in enable status", test, test1);

		} else {

			System.out.println("After click the New Button, Cancel button is not in enable status");
			Extent_fail(driver, "After click the New Button, Cancel button is not in enable status", test, test1);
		}

		if (IsElementEnabled(driver, Close_Button_Cost_View)) {

			System.out.println("After click the New Button, the Close tab button is in enable status");
			Extent_pass(driver, "After click the New Button, the Close tab button is in enable status", test, test1);

		} else {

			System.out.println("After click the New Button, the Close tab button is not in enable status");
			Extent_fail(driver, "After click the New Button, the Close tab button is not in enable status", test,
					test1);
		}

		Extent_cal(test, "Button4");

		wait(driver, "5");

		Fluentwait(driver, Plus_Button);
		click(driver, Plus_Button);

		wait(driver, "3");

		if (IsElementEnabled(driver, Select_Loc)) {

			System.out.println("Add Plus Button is Working fine");
			Extent_pass(driver, "Add Plus Button is Working fine", test, test1);

		} else {

			System.out.println("Add Plus Button is Not Working fine");
			Extent_fail(driver, "Add Plus Button is Not Working fine", test, test1);
		}

		wait(driver, "3");

		Fluentwait(driver, Select_Loc);
		doubleClick(driver, Select_Loc);

		wait(driver, "3");

		Extent_cal(test, "Button5");

		click(driver, Cost_View_ShowButton);

		wait(driver, "3");

		if (IsElementEnabled(driver, Grid_Record)) {

			System.out.println("Show Button is Working fine");
			Extent_pass(driver, "Show Plus Button is Working fine", test, test1);

		} else {

			System.out.println("Show Plus Button is Not Working fine");
			Extent_fail(driver, "Show Plus Button is Not Working fine", test, test1);
		}

		System.out.println("******************Testcase 71 Completed ***********************");

	}

}
