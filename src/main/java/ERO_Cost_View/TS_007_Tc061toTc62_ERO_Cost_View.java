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

public class TS_007_Tc061toTc62_ERO_Cost_View extends Keywords {
	public void Scenario007(WebDriver driver, ExtentTest test, ExtentTest test1, String url, int dataset)
			throws AWTException, IOException {

		String Username = Utils.getDataFromTestData("TS_007_Tc061toTc62_ERO_Cost_View_Dataset" + dataset,
				"ERO_Cost_View", "Username");
		String Password = Utils.getDataFromTestData("TS_007_Tc061toTc62_ERO_Cost_View_Dataset" + dataset,
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

		Extent_cal(test, "Testcase 61 - Ensure tab function in all the filed");

		click(driver, Tab_Component);

		wait(driver, "3");

		List<By> inutlocators = Arrays.asList(By.id("COV-COV_Toolbarid-btnsave"),
				By.id("COV-COV_Toolbarid-btnTblCancel"));

		List<String> inutfieldnames = Arrays.asList("Save", "Cancel");
		// Iterate through the locators and click the elements

		wait(driver, "2");

		act.sendKeys(Keys.TAB).build().perform();

		wait(driver, "2");

		boolean tab = true;

		for (int i = 0; i < inutlocators.size(); i++) {

			By locator = inutlocators.get(i);
			String fieldname = inutfieldnames.get(i);

			try {
				WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));

				act.moveToElement(element).build().perform();

				wait(driver, "2");

				act.sendKeys(Keys.TAB).build().perform();

				wait(driver, "2");

				String attributevalue = element.getAttribute("class");

				String status1 = extractstatus1(attributevalue);

				System.out.println("status1 :" + status1);

				if (status1.equals("ui-state-hover")) {
					System.out.println("Pass");
					Extent_pass(driver, "After click on tab button, selection cursor got navigated from " + fieldname,
							test, test1);
				} else {
					System.out.println("Fail");
					Extent_fail(driver, "After click on tab button, selection cursor not navigated from " + fieldname,
							test, test1);
				}

			} catch (Exception e) {
				System.out
						.println("Element with locator " + locator + " not found or not clickable: " + e.getMessage());
				Extent_fail(driver,
						"Element with locator " + locator + " not found or not clickable: " + e.getMessage(), test,
						test1);
				tab = false;
			}
		}

		System.out.println("Tab button functionality is working fine");
		Extent_pass(driver, "Tab button functionality is working fine", test, test1);

		System.out.println("**********Testcase 61 completed******************");

	}
}