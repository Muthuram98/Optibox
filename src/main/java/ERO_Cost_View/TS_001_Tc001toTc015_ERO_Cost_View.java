package ERO_Cost_View;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.Utils;

public class TS_001_Tc001toTc015_ERO_Cost_View extends Keywords {
	public void Scenario001(WebDriver driver, ExtentTest test, ExtentTest test1, String url, int dataset)
			throws AWTException, IOException {

		String Username = Utils.getDataFromTestData("TS_01_Tc001toTc015_ERO_Cost_View_Dataset" + dataset,
				"ERO_Cost_View", "Username");
		String Password = Utils.getDataFromTestData("TS_01_Tc001toTc015_ERO_Cost_View_Dataset" + dataset,
				"ERO_Cost_View", "Password");

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

		Fluentwait(driver, CancelButton);

		click(driver, CancelButton);

		wait(driver, "5");

		Extent_cal(test,
				"Testcase 1 - When Open the new screen,New,Search and close buttons should be in Enable status");

		if (IsElementEnabled(driver, New_Button_Cost_View)) {

			System.out.println("After opening the new screen, the New button is in enable status");
			Extent_pass(driver, "After opening the new screen, the New button is in enable status", test, test1);

		} else {

			System.out.println("After opening the new screen, the New button is not in enable status");
			Extent_fail(driver, "After opening the new screen, the New button is not in enable status", test, test1);
		}

		if (IsElementEnabled(driver, Close_Button_Cost_View)) {

			System.out.println("After opening the new screen, the Close tab button is in enable status");
			Extent_pass(driver, "After opening the new screen, the Close tab button is in enable status", test, test1);

		} else {

			System.out.println("After opening the new screen, the Close tab button is not in enable status");
			Extent_fail(driver, "After opening the new screen, the Close tab button is not in enable status", test,
					test1);
		}

		System.out
				.println("//***************************Testcase 1 Completed **************************************//");

		Extent_cal(test,
				"Testcase 2 - Ensure while click new button,Save,cancel and close button should be in enable Status");

		wait(driver, "3");

		Fluentwait(driver, New_Button_Cost_View);

		click(driver, New_Button_Cost_View);

		wait(driver, "3");

		Fluentwait(driver, Click_Yes_Popup);
		click(driver, Click_Yes_Popup);

		wait(driver, "3");

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

		System.out
				.println("//***************************Testcase 2 Completed **************************************//");

		Extent_cal(test,
				"Testcase 2 - Ensure While click grid record, new,Edit and Search and close buttons should be in enable status");

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

		doubleClick(driver, Grid_Record);

		wait(driver, "2");

		if (!IsElementEnabled(driver, New_Button_Cost_View)) {

			System.out.println("After double click the grid record, the New button is Not in enable status");
			Extent_pass(driver, "After double click the grid record, the New button is Not in enable status", test,
					test1);

		} else {

			System.out.println("After double click the grid record, the New button is in enable status");
			Extent_fail(driver, "After double click the grid record, the New button is in enable status", test, test1);
		}

		if (!IsElementEnabled(driver, Global_Search_Cost_View)) {

			System.out.println("After double click the grid record, the Search button is Not in enable status");
			Extent_pass(driver, "After double click the grid record, the Search button is Not in enable status", test,
					test1);

		} else {

			System.out.println("After double click the grid record, the Search button is in enable status");
			Extent_fail(driver, "After double click the grid record, the Search button is in enable status", test,
					test1);
		}

		if (IsElementEnabled(driver, Close_Button_Cost_View)) {

			System.out.println("After double click the grid record, the Close tab button is in enable status");
			Extent_pass(driver, "After double click the grid record, the Close tab button is in enable status", test,
					test1);

		} else {

			System.out.println("After double click the grid record, the Close tab button is not in enable status");
			Extent_fail(driver, "After double click the grid record, the Close tab button is not in enable status",
					test, test1);
		}

		System.out
				.println("//***************************Testcase 4 Completed **************************************//");

		Extent_cal(test, "Testcase 7 - Ensure screen enable New, search and close button  when click cancel button");

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

		if (IsElementEnabled(driver, Close_Button_Cost_View)) {

			System.out.println("After Click Cancel Button, the Close tab button is in enable status");
			Extent_pass(driver, "After Click Cancel Button, the Close tab button is in enable status", test, test1);

		} else {

			System.out.println("After Click Cancel Button, the Close tab button is not in enable status");
			Extent_fail(driver, "After Click Cancel Button, the Close tab button is not in enable status", test, test1);
		}

		System.out
				.println("//***************************Testcase 7 Completed **************************************//");

		Extent_cal(test, "Testcase 15 - Ensure System should close the screen,when click close button");

		Fluentwait(driver, Close_Button_Cost_View);
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
				.println("//***************************Testcase 15 Completed **************************************//");

	}

}
