package ERO_Cost_View;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.Utils;

public class TS_005_Tc043toTc059_ERO_Cost_View extends Keywords {
	public void Scenario005(WebDriver driver, ExtentTest test, ExtentTest test1, String url, int dataset)
			throws AWTException, IOException {

		String Username = Utils.getDataFromTestData("TS_005_Tc043toTc059_ERO_Cost_View_Dataset" + dataset,
				"ERO_Cost_View", "Username");
		String Password = Utils.getDataFromTestData("TS_005_Tc043toTc059_ERO_Cost_View_Dataset" + dataset,
				"ERO_Cost_View", "Password");

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

		Fluentwait(driver, CancelButton);

		click(driver, CancelButton);

		wait(driver, "3");

		Extent_cal(test, "Testcase 43 - when we click ALT+N,System should allow to create new record");

		wait(driver, "5");

		Robot rbt = new Robot();

		act.keyDown(Keys.ALT).sendKeys("n").keyUp(Keys.ALT).build().perform();

		wait(driver, "5");

		if (isDisplayed(driver, Click_Yes_Popup)) {
			System.out.println("Shortcut key for `New` button(ALT+N) is functioning and new record was created");
			Extent_pass(driver, "Shortcut key for `New` button(ALT+N) is functioning and new record was created", test,
					test1);
			click(driver, Click_Yes_Popup);
		} else {
			System.out.println("Shortcut key for `New` button(ALT+N) is not functioning");
			Extent_fail(driver, "Shortcut key for `New` button(ALT+N) is not functioning", test, test1);
		}

		wait(driver, "5");

		System.out
				.println("//***************************Testcase 43 Completed **************************************//");

		Extent_cal(test, "Testcase 47 - When click ALT+E system should cancel the last activity");

		wait(driver, "5");

		act.keyDown(Keys.ALT).sendKeys("e").keyUp(Keys.ALT).build().perform();

		wait(driver, "5");

		if (!IsElementEnabled(driver, Grid_Record)) {

			System.out.println("Shortcut key for `Cancel` button (ALT+E) is functioning");
			Extent_pass(driver, "Shortcut key for `Cancel` button (ALT+E) is functioning", test, test1);

		} else {

			System.out.println("Shortcut key for `Cancel` button (ALT+E) is not functioning");
			Extent_fail(driver, "Shortcut key for `Cancel` button (ALT+E) is not functioning", test, test1);
		}

		System.out
				.println("//***************************Testcase 47 Completed **************************************//");

		Extent_cal(test, "Testcase 50 - When click ALT+C System should allow to copy the selected data");

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

		doubleClick(driver, CopyText1);

		wait(driver, "2");

		act.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();

		wait(driver, "3");

		String copiedtext = getcopiedText(driver);

		System.out.println("copiedtext : " + copiedtext);

		String gettext = getText(driver, CopyText1);

		if (copiedtext.equals(gettext)) {

			System.out.println("Selected data was copied || Expected copied value was : " + gettext
					+ " || Actual copied value was : " + copiedtext);
			Extent_pass(driver, "Selected data was copied || Expected copied value was : " + gettext
					+ " || Actual copied value was : " + copiedtext, test, test1);
		} else {
			System.out.println("Selected data was not copied || Expected copied value was : " + gettext
					+ " || Actual copied value was : " + copiedtext);
			Extent_fail(driver, "Selected data was not copied || Expected copied value was : " + gettext
					+ " || Actual copied value was : " + copiedtext, test, test1);
		}

		System.out
				.println("//***************************Testcase 50 Completed **************************************//");

		Extent_cal(test, "Testcase 50 - When click ALT+V System should allow to paste the copied data");

		try {

			StringSelection stringSelection = new StringSelection(gettext);
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			clipboard.setContents(stringSelection, null);
			System.out.println("Text copied to clipboard: " + gettext);

		} catch (Exception e) {
			e.printStackTrace();
		}

		Fluentwait(driver, Searchbox_Cost_View);
		click(driver, Searchbox_Cost_View);

		wait(driver, "3");

		act.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();

		wait(driver, "3");

		String value = getAttribute(driver, Search_module_Field, "value");

		System.out.println("value : " + value);

		if (value.equals(gettext)) {
			System.out.println(
					"Matched || Expected pasted value was : " + gettext + " || Actual pasted value was : " + value);
			Extent_pass(driver, "System allowed to paste the copied data by using shortcut key CTRL+V", test, test1);
			Extent_pass(driver,
					"Matched || Expected pasted value was : " + gettext + " || Actual pasted value was : " + value,
					test, test1);
		} else {
			System.out.println(
					"Not Matched || Expected pasted value was : " + gettext + " || Actual pasted value was : " + value);
			Extent_fail(driver, "System not allowed to paste the copied data by using shortcut key CTRL+V", test,
					test1);
			Extent_fail(driver,
					"Not Matched || Expected pasted value was : " + gettext + " || Actual pasted value was : " + value,
					test, test1);
		}

	}

}
