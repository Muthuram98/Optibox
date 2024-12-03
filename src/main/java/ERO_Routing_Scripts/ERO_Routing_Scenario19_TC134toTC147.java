package ERO_Routing_Scripts;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.Utils;

public class ERO_Routing_Scenario19_TC134toTC147 extends Keywords {

	@SuppressWarnings("deprecation")
	public void ERO_Routing_Scenario19(WebDriver driver, ExtentTest test, ExtentTest test1, String url, int dataset)
			throws Exception {

		String Username = Utils.getDataFromTestData("ERO_Scenario12_Dataset" + dataset, "ERO Routing", "Username");
		String Password = Utils.getDataFromTestData("ERO_Scenario12_Dataset" + dataset, "ERO Routing", "Password");
		String Pink = Utils.getDataFromTestData("ERO_Scenario12_Dataset" + dataset, "ERO Routing", "Pink_Color");
		String green = Utils.getDataFromTestData("ERO_Scenario12_Dataset" + dataset, "ERO Routing", "color");
		String Green = Utils.getDataFromTestData("ERO_Scenario12_Dataset" + dataset, "ERO Routing", "green_color");

		String EquimentType_Alphabets = System.getProperty("user.dir") + "\\uploads\\Budget_Flow_Applied.xlsx";

		navigateUrl(driver, url);

		Actions act = new Actions(driver);

		Fluentwait(driver, Username_input);
		sendKeys(driver, Username_input, Username);

		Fluentwait(driver, Password_input);
		sendKeys(driver, Password_input, Password);

		Fluentwait(driver, SignIn);
		click(driver, SignIn);
		
//		wait(driver, "5");
//
//		if (isDisplayed(driver, session_confirmation)) {
//			Fluentwait(driver, session_confirmation);
//			click(driver, session_confirmation);
//		}
//
//		Fluentwait(driver, Searchbox);
//		sendKeys(driver, Searchbox, "Deficit and Surplus Location Identification");
//
//		Fluentwait(driver, Selectdeficit);
//		click(driver, Selectdeficit);
//
//		wait(driver, "5");
//
//		Fluentwait(driver, Cancel);
//		click(driver, Cancel);
//
//		wait(driver, "2");
//		Fluentwait(driver, New);
//		click(driver, New);
//
//		Fluentwait(driver, New_Popup_Yes);
//		click(driver, New_Popup_Yes);
//		wait(driver, "2");
//
//		Fluentwait(driver, dropdown_option);
//		click(driver, dropdown_option);
//
//		Fluentwait(driver, Budget_Reposition);
//		click(driver, Budget_Reposition);
//
//		Fluentwait(driver, Budget);
//		click(driver, Budget);
//		wait(driver, "4");
//
////		uploadFileRobot(driver, EquimentType_Alphabets);
//
//		String upload_EquimentType_Alphabets = System.getProperty("user.dir") + "/driver/MasterDownloadfile.exe "
//				+ EquimentType_Alphabets;
//
//		try {
//			Runtime.getRuntime().exec(upload_EquimentType_Alphabets);
//		} catch (IOException e) {
//			e.printStackTrace();
//			System.out.println(e.getLocalizedMessage());
//			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
//		}
//
//		wait(driver, "10");
//
//		Fluentwait(driver, Location3);
//
//		if (isDisplayed(driver, click_yes)) {
//
//			click(driver, click_yes);
//
//			Fluentwait(driver, Click_ok);
//			click(driver, Click_ok);
//		}
//
//		wait(driver, "2");
//		Fluentwait(driver, ERO_Save);
//		click(driver, ERO_Save);
//		Fluentwait(driver, ERO_Save_ok);
//		click(driver, ERO_Save_ok);
//		Fluentwait(driver, ERO_route);
//		click(driver, ERO_route);
//		wait(driver, "2");
//
//		Extent_cal(test,
//				"Testcase 143,Ensure Blue color indicates Feeder Contract Records filter the in Route details tab");
//
//		wait(driver, "2");
//		Fluentwait(driver, Optimizer);
//		click(driver, Optimizer);
//		wait(driver, "2");
//		Fluentwait(driver, Optimizer_Ok);
//		click(driver, Optimizer_Ok);
//		wait(driver, "2");
//		String background = getTextBackgroundColor(driver, backround_color);
//		System.out.println("backroung color:" + background);
//
//		for (int i = 1; i < 15; i++) {
//
//			WebElement element = driver
//					.findElement(By.xpath("//tbody[@id='OPT-OPT_treeTable_data']//tr[@data-ri='" + i + "']/td[2]"));
//
//			act.moveToElement(element).build().perform();
//
//			wait(driver, "5");
//
//			if (element.isDisplayed()) {
//
//				System.out.println("Backround color is displayed ");
//				Extent_pass(driver, "Backround color is displayed", test, test1);
//			} else {
//				System.out.println("Backround color is not displayed");
//				Extent_fail(driver, "Backround color is not displayed", test, test1);
//			}
//			if (background.equals(green)) {
//
//				System.out.println("Route Details Count field background color showing as expected");
//				Extent_pass(driver, "Route Details Count field background color showing as expected", test, test1);
//				Extent_pass(driver, "Expected background color code is : " + green
//						+ " || Actual background color was : " + background, test, test1);
//			} else {
//				System.out.println("Route Details Count field background color not showing as expected");
//				Extent_fail(driver, "Route Details Count field background color not showing as expected", test, test1);
//				Extent_fail(driver, "Expected background color code is : " + green
//						+ " || Actual background color was : " + background, test, test1);
//				global = "Expected background color code is : " + green + " || Actual background color was : "
//						+ background;
//			}
//		}
//		System.out.println("Testcase 143 completed");
//
//		Extent_cal(test,
//				"Testcase 144,Ensure Pink color indicates Haulage Contract Records  filter the in Route details tab");
//		String background1 = getTextBackgroundColor(driver, pink_Backroungcolor);
//		System.out.println("backroung color:" + background1);
//
//		WebElement element1 = driver.findElement(By.xpath("(//tr[@data-ri='0']//td)[5]"));
//
//		act.moveToElement(element1).build().perform();
//
//		wait(driver, "5");
//
//		if (element1.isDisplayed()) {
//
//			System.out.println("Backround color is displayed ");
//			Extent_pass(driver, "Backround color is displayed", test, test1);
//		} else {
//			System.out.println("Backround color is not displayed");
//			Extent_fail(driver, "Backround color is not displayed", test, test1);
//			global = "Backround color is not displayed";
//		}
//
//		if (background1.equals(Pink)) {
//
//			System.out.println("Route Details Count field background color showing as expected");
//			Extent_pass(driver, "Route Details Count field background color showing as expected", test, test1);
//			Extent_pass(driver,
//					"Expected background color code is : " + Pink + " || Actual background color was : " + background1,
//					test, test1);
//		} else {
//			System.out.println("Route Details Count field background color not showing as expected");
//			Extent_fail(driver, "Route Details Count field background color not showing as expected", test, test1);
//			Extent_fail(driver,
//					"Expected background color code is : " + Pink + " || Actual background color was : " + background1,
//					test, test1);
//			global = "Expected background color code is : " + Pink + " || Actual background color was : " + background1;
//		}
//		System.out.println("test case 144 , completed");
//
//		Extent_cal(test, "Testcase 135,Ensure Green color indicates Routing records in Route details tab ");
//
//		Scrolltilltheelementvisible(driver, EPO_Color);
//
//		String routedetails_color = getTextBackgroundColor(driver, EPO_Color);
//
//		System.out.println(routedetails_color);
//
//		if (routedetails_color.equals(Green)) {
//
//			System.out.println("Route Details Count field background color showing as expected");
//			Extent_pass(driver, "Route Details Count field background color showing as expected", test, test1);
//			Extent_pass(driver, "Expected background color code is : " + Green + " || Actual background color was : "
//					+ routedetails_color, test, test1);
//		} else {
//			System.out.println("Route Details Count field background color not showing as expected");
//			Extent_fail(driver, "Route Details Count field background color not showing as expected", test, test1);
//			Extent_fail(driver, "Expected background color code is : " + Green + " || Actual background color was : "
//					+ routedetails_color, test, test1);
//			global = "Expected background color code is : " + Green + " || Actual background color was : "
//					+ routedetails_color;
//		}
//
//		System.out.println("Testcase 135 completed");

	}
}
