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

public class TS_010_Tc069toTc070_ERO_Cost_View extends Keywords {
	public void Scenario010(WebDriver driver, ExtentTest test, ExtentTest test1, String url, int dataset)
			throws AWTException, IOException {

		String Username = Utils.getDataFromTestData("TS_010_Tc069toTc070_ERO_Cost_View_Dataset" + dataset,
				"ERO_Cost_View", "Username");
		String Password = Utils.getDataFromTestData("TS_010_Tc069toTc070_ERO_Cost_View_Dataset" + dataset,
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

		wait(driver, "3");

		click(driver, Plus_Button);

		wait(driver, "5");

		Fluentwait(driver, Loc_Search_Cost_View);
		click(driver, Loc_Search_Cost_View);
		wait(driver, "3");

		sendKeys(driver, Loc_Search, "AUSYD");

		wait(driver, "2");

		doubleClick(driver, Select_Loc_Code1);

		wait(driver, "2");

		click(driver, Cost_View_ShowButton);
		wait(driver, "2");

		Extent_cal(test,
				"Testcase 69 - Ensure Scientific grid allows Filter functionality according to the conditions and inputs");

		wait(driver, "5");

		Fluentwait(driver, Location_Cost_View);
		String Option1 = getText(driver, Location_Cost_View);

		wait(driver, "2");
		String Option2 = getText(driver, Location_Cost_View1);

		WebElement location1 = driver.findElement(By.xpath("//div[@col-id='portcode' and text()='" + Option2 + "']"));

		Fluentwait(driver, FilterLocation);
		click(driver, FilterLocation);

		Fluentwait(driver, Filtermenu);
		click(driver, Filtermenu);

		wait(driver, "2");

		Fluentwait(driver, FilterSearch);
		sendKeys(driver, FilterSearch, Option1);

		wait(driver, "2");

		enter(driver);

		wait(driver, "2");

		if (!isDisplayed1(driver, location1)) {

			System.out.println("Grid Filter is working fine and the given filter value was : " + Option1);
			Extent_pass(driver, "Grid Filter is working fine and the given filter value was : " + Option1, test, test1);
		} else {

			System.out.println("Grid Filter is not working and the given filter value was : " + Option1);
			Extent_fail(driver, "Grid Filter is not working and the given filter value was : " + Option1, test, test1);
		}

		System.out.println("******************Testcase 68 Completed ***********************");

		wait(driver, "5");

		act.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
		wait(driver, "2");
		act.sendKeys(Keys.BACK_SPACE).perform();

		wait(driver, "5");

		Fluentwait(driver, Selectall);
		click(driver, Selectall);

		Fluentwait(driver, Filtermenu);
		click(driver, Filtermenu);

		Extent_cal(test, "Testcase 70 - Ensure Scientific grid allows to paste the copied record in grid itself");

		Fluentwait(driver, Tree_Table_Cost_View);
		click(driver, Tree_Table_Cost_View);
		wait(driver, "2");

		Fluentwait(driver, Condition_filter_COst_View);
		click(driver, Condition_filter_COst_View);
		wait(driver, "2");

		String textToCopy = "AUSYD";

		// Create a StringSelection object with the text
		StringSelection stringSelection = new StringSelection(textToCopy);

		// Get the system clipboard
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

		// Set the content of the clipboard to the string
		clipboard.setContents(stringSelection, null);

		System.out.println("Text copied to clipboard: " + textToCopy);

		wait(driver, "2");

		Fluentwait(driver, filter_input_Cost_View);
		click(driver, filter_input_Cost_View);

		wait(driver, "2");

		act.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();

		wait(driver, "2");

		try {
			String inputvalue = getText(driver, Grid_Record);

			System.out.println("inputvalue : " + inputvalue);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String inputvalue = getText(driver, Grid_Record);

		System.out.println("inputvalue : " + inputvalue);

		if (textToCopy.equals(inputvalue)) {

			System.out.println("Grid filter accept to paste the copied data");
			Extent_pass(driver, "Grid filter accept to paste the copied data", test, test1);

		} else {

			System.out.println("Grid filter not accept to paste the copied data");
			Extent_fail(driver, "Grid filter not accept to paste the copied data", test, test1);

		}

		act.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
		wait(driver, "2");
		act.sendKeys(Keys.BACK_SPACE).perform();

		System.out.println("******************Testcase 70Completed ***********************");

	}

}
