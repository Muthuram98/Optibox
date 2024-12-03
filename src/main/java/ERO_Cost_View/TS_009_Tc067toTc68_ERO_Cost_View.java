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

public class TS_009_Tc067toTc68_ERO_Cost_View extends Keywords {
	public void Scenario009(WebDriver driver, ExtentTest test, ExtentTest test1, String url, int dataset)
			throws AWTException, IOException {

		String Username = Utils.getDataFromTestData("TS_009_Tc067toTc068_ERO_Cost_View_Dataset" + dataset,
				"ERO_Cost_View", "Username");
		String Password = Utils.getDataFromTestData("TS_009_Tc067toTc068_ERO_Cost_View_Dataset" + dataset,
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
		wait(driver, "5");

		Extent_cal(test, "Testcase 67 - Ensure DS grid allows Filter functionality");

		Fluentwait(driver, Tree_Table_Cost_View);
		click(driver, Tree_Table_Cost_View);
		wait(driver, "2");

		Fluentwait(driver, Condition_filter_COst_View);
		click(driver, Condition_filter_COst_View);
		wait(driver, "2");

		Fluentwait(driver, filter_input_Cost_View);

		String locatio1 = getText(driver, Location_Cost_View);

		sendKeys(driver, filter_input_Cost_View, locatio1);

		WebElement last_location = driver.findElement(By.xpath("(//div[@col-id='portcode'])[last()]"));

		String lastlocation = last_location.getText();

		if (lastlocation.equals(locatio1)) {

			System.out.println("DS grid filter is working fine");
			Extent_pass(driver, "DS grid filter is working fine", test, test1);

		} else {

			System.out.println("DS grid filter is not working fine");
			Extent_fail(driver, "DS grid filter is not working fine", test, test1);
		}

		act.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
		wait(driver, "2");
		act.sendKeys(Keys.BACK_SPACE).perform();

		System.out.println(" ************************Testcase 67 - Completed *************************");

	}

}
