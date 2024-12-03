package ERO_Routing_Scripts;

import java.awt.Robot;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentTest;
import com.gargoylesoftware.htmlunit.javascript.host.event.SVGZoomEvent;

import commonMethods.Keywords;
import commonMethods.Utils;

public class ERO_Routing_Scenario33_TC287_288 extends Keywords {

	public void ERO_Scenario33(WebDriver driver, ExtentTest test, ExtentTest test1, String url, int dataset) throws Exception {
	
		String Username = Utils.getDataFromTestData("ERO_Scenario33_Dataset"+dataset, "ERO Routing", "Username");
		String Password = Utils.getDataFromTestData("ERO_Scenario33_Dataset"+dataset, "ERO Routing", "Password");
		String ID = Utils.getDataFromTestData("ERO_Scenario33_Dataset"+dataset, "ERO Routing", "Id");

		navigateUrl(driver, url);

		Fluentwait(driver, Username_input);
		sendKeys(driver, Username_input, Username);

		Fluentwait(driver, Password_input);
		sendKeys(driver, Password_input, Password);

		Fluentwait(driver, SignIn);
		click(driver, SignIn);

		wait(driver, "3");

		if (isDisplayed(driver, session_confirmation)) {
			Fluentwait(driver, session_confirmation);
			click(driver, session_confirmation);
		}

		Fluentwait(driver, Searchbox);
		sendKeys(driver, Searchbox, "Ero Rou");

		Fluentwait(driver, Select_Optimizer);
		click(driver, Select_Optimizer);

		wait(driver, "3");

		Extent_cal(test,
				" 287- Ensure the By cost tab chart wise representation x axis cost details and y axis surplus ports details displayed   ");

		Fluentwait(driver, Routing_GlobalSearch);
		click(driver, Routing_GlobalSearch);

		Fluentwait(driver, Globalserach_IDInput);
		sendKeys(driver, Globalserach_IDInput, ID);

		wait(driver, "2");

		Fluentwait(driver, Click_Search);
		click(driver, Click_Search);

		wait(driver, "5");

		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);

		wait(driver, "5");

		if (isDisplayed(driver, ERO_popup_ok)) {

			click(driver, ERO_popup_ok);
		}

		click(driver, Optimizer_Button);

		click(driver, Ok_Pop);

		wait(driver, "3");

		Fluentwait(driver, ERO_Chat);
		click(driver, ERO_Chat);

		wait(driver, "5");

		WebElement chart = driver.findElement(By.xpath("//object"));
		driver.switchTo().frame(chart);

		wait(driver, "5");

		click(driver, By_Cost);

		wait(driver, "5");
		mouseOverToElement(driver, Fetch_Value_Cost);

		String Count_Graph = getText(driver, Count);

		System.out.println("Count_Graph : " + Count_Graph);
		String[] splivalue = Count_Graph.split("\\$");

		String[] expect_value = splivalue[1].split("\\]");

		String Surplus_count = expect_value[0].trim();

		System.out.println("Surplus_count : " + Surplus_count);

		String Value1 = Surplus_count.replace(",", "");
		System.out.println("Value1 : " + Value1);

		wait(driver, "3");

		wait(driver, "2");

		driver.switchTo().defaultContent();

		wait(driver, "2");

		Fluentwait(driver, Leese_Tab);
		click(driver, Leese_Tab);

		wait(driver, "2");

		Fluentwait(driver, Leese_Filter);
		click(driver, Leese_Filter);

		click(driver, EPO_SelectFilterOption);

		Fluentwait(driver, Load_Loc_Selectall);
		click(driver, Load_Loc_Selectall);

		click(driver, Leese_Search);

		sendKeys(driver, Leese_Search, "AUSYD(OW)");

		Fluentwait(driver, Load_Loc_Selectall);
		click(driver, Load_Loc_Selectall);

		String Cost_Total = getText(driver, Leese_Fetch_Value);

		System.out.println("Cost_Total : " + Cost_Total);

		wait(driver, "3");

		if (Value1.equals(Cost_Total)) {
			System.out
					.println("Matched || Expected ByCost Count was : " + Cost_Total + " Actual Count was : " + Value1);
			Extent_pass(driver, "Matched || Expected ByCost Count  was : " + Cost_Total
					+ " || Actual ByCost Count  was : " + Value1, test, test1);
		} else {
			System.out.println(
					"Not Matched || Expected ByCost Count was : " + Cost_Total + " Actual Count was : " + Value1);
			Extent_fail2(driver,
					"Not Matched || Expected Count was : " + Cost_Total + " || Actual ByCost Count was : " + Value1,
					test);
		}

		System.out.println(
				"//***************************Testcase 287 Completed **************************************//");

		////////////

		Extent_cal(test,
				" 288- Ensure the By cost tab chart wise representation x axis cost details and y axis Deficit ports details displayed   ");

		Fluentwait(driver, ERO_Chat);
		click(driver, ERO_Chat);

		wait(driver, "5");

		WebElement chart1 = driver.findElement(By.xpath("//object"));
		driver.switchTo().frame(chart1);

		wait(driver, "5");

		click(driver, By_Cost);

		wait(driver, "5");
		mouseOverToElement(driver, Leese_Deficit_Fetch_Value);

		String Count_Graph1 = getText(driver, Count);

		System.out.println("Count_Graph1 : " + Count_Graph1);
		String[] splivalue1 = Count_Graph.split("\\$");

		String[] expect_value1 = splivalue1[1].split("\\]");

		String Surplus_count1 = expect_value1[0].trim();

		System.out.println("Surplus_count1 : " + Surplus_count1);

		String Value2 = Surplus_count.replace(",", "");
		System.out.println("Value2 : " + Value2);

		wait(driver, "3");

		wait(driver, "2");

		driver.switchTo().defaultContent();

		wait(driver, "2");

		Fluentwait(driver, Leese_Tab);
		click(driver, Leese_Tab);

		wait(driver, "2");

		Fluentwait(driver, Leese_Filter);
		click(driver, Leese_Filter);

		String Deficit_Cost1 = getText(driver, Leese_Fetch_Value);

		System.out.println("Deficit_Cost1 : " + Deficit_Cost1);

		wait(driver, "3");

		if (Value2.equals(Deficit_Cost1)) {
			System.out.println(
					"Matched || Expected ByCost Count was : " + Deficit_Cost1 + " Actual Count was : " + Value2);
			Extent_pass(driver, "Matched || Expected ByCost Count  was : " + Deficit_Cost1
					+ " || Actual ByCost Count  was : " + Value2, test, test1);
		} else {
			System.out.println(
					"Not Matched || Expected ByCost Count was : " + Deficit_Cost1 + " Actual Count was : " + Value2);
			Extent_fail2(driver,
					"Not Matched || Expected Count was : " + Deficit_Cost1 + " || Actual ByCost Count was : " + Value2,
					test);

		}

	}

}
