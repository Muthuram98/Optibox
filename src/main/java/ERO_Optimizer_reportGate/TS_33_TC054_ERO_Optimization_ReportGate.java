package ERO_Optimizer_reportGate;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.Utils;

public class TS_33_TC054_ERO_Optimization_ReportGate extends Keywords {
	
	public void Scenario33(WebDriver driver, ExtentTest test, ExtentTest test1, String url, int dataset)
			throws AWTException, IOException {

		System.out.println("url : " + url);
		String Username = Utils.getDataFromTestData("TS_33_TC054_ERO_Optimization_ReportGate_Dataset"+dataset, "ReportGate",
				"Username");
		String Password = Utils.getDataFromTestData("TS_33_TC054_ERO_Optimization_ReportGate_Dataset"+dataset, "ReportGate",
				"Password");
		String ID = Utils.getDataFromTestData("TS_33_TC054_ERO_Optimization_ReportGate_Dataset"+dataset, "ReportGate", "Id");

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

		Extent_cal(test, "Testcase 54 - Ensure that system is allow to copy, paste function in the grid type");

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

		wait(driver, "3");

		click(driver, Show_Button_ERO);

		wait(driver, "3");

		scrollBottom(driver);

		Fluentwait(driver, Tree_table_ERO);
		click(driver, Tree_table_ERO);

		click(driver, Condition_Filter);

		Fluentwait(driver, Grid_locationfield_ERO);
		click(driver, Grid_locationfield_ERO);

		wait(driver, "3");

		act.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();

		wait(driver, "5");

		String copiedtext = getcopiedText(driver);

		System.out.println("copiedtext : " + copiedtext);

		String gettext = getText(driver, Grid_locationfield_ERO);

		int textlength = gettext.length();

		String actualcopied = copiedtext.substring(0, textlength);

		if (actualcopied.equals(gettext)) {

			System.out.println("Selected data was copied || Expected copied value was : " + gettext
					+ " || Actual copied value was : " + actualcopied);
			Extent_pass(driver, "Selected data was copied || Expected copied value was : " + gettext
					+ " || Actual copied value was : " + actualcopied, test, test1);
		} else {
			System.out.println("Selected data was not copied || Expected copied value was : " + gettext
					+ " || Actual copied value was : " + actualcopied);
			Extent_fail(driver, "Selected data was not copied || Expected copied value was : " + gettext
					+ " || Actual copied value was : " + actualcopied, test, test1);
		}

		try {

			StringSelection stringSelection = new StringSelection(gettext);
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			clipboard.setContents(stringSelection, null);
			System.out.println("Text copied to clipboard: " + gettext);

		} catch (Exception e) {
			e.printStackTrace();
		}

		Fluentwait(driver, Grid_txt_field_ERO);
		click(driver, Grid_txt_field_ERO);

		wait(driver, "3");
		act.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();

		enter(driver);

		wait(driver, "3");

		String Pastetext = getText(driver, Grid_locationfield_ERO);

		System.out.println("Pastetext : " + Pastetext);

		if (Pastetext.equals(gettext)) {
			System.out.println(
					"Matched || Expected pasted value was : " + gettext + " || Actual pasted value was : " + Pastetext);
			Extent_pass(driver, "System allowed to paste the copied data by using shortcut key CTRL+V", test, test1);
			Extent_pass(driver,
					"Matched || Expected pasted value was : " + gettext + " || Actual pasted value was : " + Pastetext,
					test, test1);
		} else {
			System.out.println("Not Matched || Expected pasted value was : " + gettext
					+ " || Actual pasted value was : " + Pastetext);
			Extent_fail(driver, "System not allowed to paste the copied data by using shortcut key CTRL+V", test,
					test1);
			Extent_fail(driver, "Not Matched || Expected pasted value was : " + gettext
					+ " || Actual pasted value was : " + Pastetext, test, test1);

		}

	}
}