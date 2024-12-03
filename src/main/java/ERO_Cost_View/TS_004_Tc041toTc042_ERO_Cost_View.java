package ERO_Cost_View;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.Utils;

public class TS_004_Tc041toTc042_ERO_Cost_View extends Keywords {
	public void Scenario004(WebDriver driver, ExtentTest test, ExtentTest test1, String url, int dataset)
			throws AWTException, IOException {

		String Username = Utils.getDataFromTestData("TS_004_Tc041toTc042_ERO_Cost_View_Dataset" + dataset,
				"ERO_Cost_View", "Username");
		String Password = Utils.getDataFromTestData("TS_004_Tc041toTc042_ERO_Cost_View_Dataset" + dataset,
				"ERO_Cost_View", "Password");
		String Expected_Version_Xposition = Utils.getDataFromTestData(
				"TS_004_Tc041toTc042_ERO_Cost_View_Dataset" + dataset, "ERO_Cost_View", "Created_Xposition");
		String Expected_Version_Yposition = Utils.getDataFromTestData(
				"TS_004_Tc041toTc042_ERO_Cost_View_Dataset" + dataset, "ERO_Cost_View", "Created_Yposition");

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

		Extent_cal(test, "Testcase 41 - Ensure Version is placed at bottom of the left corner of the screen");

		wait(driver, "3");

		Scrolltilltheelementvisible(driver, Version_Cost_Number);

		wait(driver, "3");

		try {
			WebElement Versionfield = driver.findElement(By.xpath("//label[contains(text(),'Version :')]"));

			Point Version_Filed_location = Versionfield.getLocation();

			int Versionxposition = Version_Filed_location.getX();

			String actual_Version_XPosition = String.valueOf(Versionxposition);

			System.out.println("xposition :" + actual_Version_XPosition);

			int Versionyposition = Version_Filed_location.getY();

			String actual_version_YPosition = String.valueOf(Versionyposition);

			System.out.println("yposition :" + actual_version_YPosition);

			if (actual_Version_XPosition.equals(Expected_Version_Xposition)
					&& actual_version_YPosition.equals(Expected_Version_Yposition)) {

				System.out.println("Version field is placed at the bottom of the Left corner of the screen");
				Extent_pass(driver, "Version User field is placed at the bottom of the Left corner of the screen", test,
						test1);
				Extent_pass(driver, "Expected Version  field X position is : " + Expected_Version_Xposition
						+ " || Actual Version field X position is : " + actual_Version_XPosition, test, test1);
				Extent_pass(driver,
						"Expected Version field Y position is : " + Expected_Version_Yposition
								+ " || Actual Version field Y position is : " + Expected_Version_Yposition,
						test, test1);

			} else {

				System.out.println("Version field is not placed at the bottom of the Left corner of the screen");
				Extent_fail(driver, "Version field is not placed at the bottom of the Left corner of the screen", test,
						test1);
				Extent_fail(driver, "Expected Version field X position is : " + Expected_Version_Xposition
						+ " || Actual Version field X position is : " + actual_Version_XPosition, test, test1);
				Extent_fail(driver,
						"Expected Version field Y position is : " + Expected_Version_Yposition
								+ " || Actual Version field Y position is : " + Expected_Version_Yposition,
						test, test1);
			}

		} catch (Exception e) {
			e.printStackTrace();
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
		}

		System.out
				.println("//***************************Testcase 41 Completed **************************************//");

	}
}
