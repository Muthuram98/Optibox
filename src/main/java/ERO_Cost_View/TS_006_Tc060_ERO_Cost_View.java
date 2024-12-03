package ERO_Cost_View;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.Utils;

public class TS_006_Tc060_ERO_Cost_View extends Keywords {
	public void Scenario006(WebDriver driver, ExtentTest test, ExtentTest test1, String url, int dataset)
			throws AWTException, IOException {

		String Username = Utils.getDataFromTestData("TS_006_Tc060_ERO_Cost_View_Dataset" + dataset, "ERO_Cost_View",
				"Username");
		String Password = Utils.getDataFromTestData("TS_006_Tc060_ERO_Cost_View_Dataset" + dataset, "ERO_Cost_View",
				"Password");

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

		Extent_cal(test,
				"Testcase 60 - Ensure while moving the cursor on the tool bar ,system should show the tool tips");

		wait(driver, "5");

		for (int i = 1; i <= 14; i++) {

			WebElement button = driver.findElement(
					By.xpath("((//div[@id='COV-COV_Toolbarid-tblComponent']//button)[" + i + "]//span)[1]"));

			wait(driver, "2");

			act.moveToElement(button).build().perform();

			String buttonname = Utils.getDataFromTestData("TS_006_Tc_060_ERO_Mass_Cost_Update_Dataset" + dataset,
					"ero_mass_cost_update", "Button" + i);

			WebElement Tooltipfield = driver
					.findElement(By.xpath("(//div[@id='COV-COV_Toolbarid-tblComponent']//button)[" + i
							+ "]//span[contains(text(),'" + buttonname + "')]"));

			if (isDisplayed1(driver, Tooltipfield)) {

				Extent_pass(driver, "Tool tip for " + buttonname + " is displayed", test, test1);

				getTextofWebelement(driver, Tooltipfield, "Tool tip");

			} else {

				Extent_fail(driver, "Tool tip for " + buttonname + " is not displayed", test, test1);
			}

//				wait(driver, "3");

		}

		System.out
				.println("//***************************Testcase 60 Completed **************************************//");

	}

}
