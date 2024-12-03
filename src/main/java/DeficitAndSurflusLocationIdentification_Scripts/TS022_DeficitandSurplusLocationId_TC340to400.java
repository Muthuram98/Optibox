package DeficitAndSurflusLocationIdentification_Scripts;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.Utils;

public class TS022_DeficitandSurplusLocationId_TC340to400 extends Keywords {

	@SuppressWarnings("deprecation")
	public void Scenario22(WebDriver driver, ExtentTest test, ExtentTest test1, String url, int dataset) throws Exception {

		String Username = Utils.getDataFromTestData("TS022_DeficitandSurplusLocationIdentification_Dataset"+dataset,
				"DeficitandSurplusLocationId", "Username");
		String Password = Utils.getDataFromTestData("TS022_DeficitandSurplusLocationIdentification_Dataset"+dataset,
				"DeficitandSurplusLocationId", "Password");
		String FromWeek1 = Utils.getDataFromTestData("TS022_DeficitandSurplusLocationIdentification_Dataset"+dataset,
				"DeficitandSurplusLocationId", "FromWeek1");
		String ToWeek1 = Utils.getDataFromTestData("TS022_DeficitandSurplusLocationIdentification_Dataset"+dataset,
				"DeficitandSurplusLocationId", "ToWeek1");
		String Leapyear = Utils.getDataFromTestData("TS022_DeficitandSurplusLocationIdentification_Dataset"+dataset,
				"DeficitandSurplusLocationId", "Leapyear");
		String Fromyear = Utils.getDataFromTestData("TS022_DeficitandSurplusLocationIdentification_Dataset"+dataset,
				"DeficitandSurplusLocationId", "Fromyear");
		String Fromweek = Utils.getDataFromTestData("TS022_DeficitandSurplusLocationIdentification_Dataset"+dataset,
				"DeficitandSurplusLocationId", "Fromweek");
		String Alphabets_excel = Utils.getDataFromTestData("TS022_DeficitandSurplusLocationIdentification_Dataset"+dataset,
				"DeficitandSurplusLocationId", "Alphabets_excel");
		String Numeric_excel = Utils.getDataFromTestData("TS022_DeficitandSurplusLocationIdentification_Dataset"+dataset,
				"DeficitandSurplusLocationId", "Numeric_excel");
		String Specialcharacters_excel = Utils.getDataFromTestData("TS022_DeficitandSurplusLocationIdentification_Dataset"+dataset,
				"DeficitandSurplusLocationId", "Specialcharacters_excel");

		String Import_alphabets = System.getProperty("user.dir") + "\\uploads\\" + Alphabets_excel + ".xlsx";
		String EquimentType_Alphabets = System.getProperty("user.dir") + "\\uploads\\" + Numeric_excel + ".xlsx";
		String Import_specialcharacter = System.getProperty("user.dir") + "\\uploads\\" + Specialcharacters_excel
				+ ".xlsx";
		String EquimentType_Alphabets1 = System.getProperty("user.dir") + "\\uploads\\Budget_Flow_Applied.xlsx";
	
		Actions act = new Actions(driver);

		JavascriptExecutor js = (JavascriptExecutor) driver;

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

		wait(driver, "3");
		Fluentwait(driver, Searchbox);
		sendKeys(driver, Searchbox, "Deficit and Surplus Location Identification");

		wait(driver, "2");
		Fluentwait(driver, Selectdeficit);
		click(driver, Selectdeficit);

		wait(driver, "5");

		Extent_cal(test,
				"Testcase 340 - Ensure in Deficit and Surplus Location Identification screen navigate to Graphical view screen");

		Fluentwait(driver, Year_Drop_Down);
		click(driver, Year_Drop_Down);
		
		Fluentwait(driver, Fromweek_input);
		clear(driver, Fromweek_input);
		sendKeys(driver, Fromweek_input, FromWeek1);
		
		wait(driver, "2");
		Fluentwait(driver, Year_Drop_Down);
		click(driver, Year_To_Drop_Down);
		
		wait(driver, "2");
		Fluentwait(driver, Toweek_input);
		clear(driver, Toweek_input);
		sendKeys(driver, Toweek_input, ToWeek1);
		wait(driver, "2");
		Fluentwait(driver, Show);
		click(driver, Show);
		wait(driver, "2");

		if (isDisplayed(driver, show_yes)) {
			Fluentwait(driver, show_yes);
			click(driver, show_yes);
		}

//		wait(driver, "2");
//		Fluentwait(driver, Save);
//		click(driver, Save);
//		wait(driver, "2");
//		Fluentwait(driver, Save_popup_ok);
//		click(driver, Save_popup_ok);
//		wait(driver, "2");
		wait(driver, "5");

		if (isDisplayed(driver, Warning_popup)) {
			System.out.println("popup shown");
			Fluentwait(driver, click_yes);
			click(driver, click_yes);

			Fluentwait(driver, Click_ok);
			click(driver, Click_ok);

			Fluentwait(driver, Cancel);
			click(driver, Cancel);

			wait(driver, "2");
			Fluentwait(driver, New);
			click(driver, New);

			Fluentwait(driver, New_Popup_Yes);
			click(driver, New_Popup_Yes);
			wait(driver, "2");

			Fluentwait(driver, dropdown_option);
			click(driver, dropdown_option);

			Fluentwait(driver, Budget_Reposition);
			click(driver, Budget_Reposition);

			Fluentwait(driver, Budget);
			click(driver, Budget);

			wait(driver, "4");

//			uploadFileRobot(driver,EquimentType_Alphabets1);

			String upload_EquimentType_Alphabets1 = System.getProperty("user.dir") + "/driver/MasterDownloadfile.exe "
					+ EquimentType_Alphabets1;

			try {
				Runtime.getRuntime().exec(upload_EquimentType_Alphabets1);
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println(e.getLocalizedMessage());
				Extent_fail(driver, e.getLocalizedMessage(), test, test1);
			}

			wait(driver, "25");

			Fluentwait(driver, Location3);

			if (isDisplayed(driver, click_yes)) {

				click(driver, click_yes);

				Fluentwait(driver, Click_ok);
				click(driver, Click_ok);
			}

			wait(driver, "3");
			Fluentwait(driver, ERO_Save);
			click(driver, ERO_Save);
			Fluentwait(driver, ERO_Save_ok);
			click(driver, ERO_Save_ok);
			wait(driver, "2");

		} else {
			System.out.println("popup not shown");
		}

		Fluentwait(driver, Map);
		click(driver, Map);

		if (isDisplayed(driver, Map_field)) {

			System.out.println("After click on map button, screen got navigated to Map view Tab");
			Extent_pass(driver, "After click on map button, screen got navigated to Map view Tab", test, test1);

		} else {

			System.out.println("Map button is not functioning, It still in the deficit and surplus location screen");
			Extent_fail(driver, "Map button is not functioning, It still in the deficit and surplus location screen",
					test, test1);
		}

		System.out.println("Testcasen 340 Completed");

		Extent_cal(test,
				"Testcase 341 - Ensure in Deficit and Surplus Location Identification screen navigate to ERO Routing screen");

		Fluentwait(driver, Deficittab);
		click(driver, Deficittab);

		Fluentwait(driver, Route);
		click(driver, Route);

		wait(driver, "2");

		if (isDisplayed(driver, Route_details)) {

			System.out.println("After click on Route button, screen got navigated to ERO Routing Tab");
			Extent_pass(driver, "After click on Route button, screen got navigated to ERO Routing Tab", test, test1);

		} else {

			System.out.println("Route button is not functioning, It still in the deficit and surplus location screen");
			Extent_fail(driver, "Route button is not functioning, It still in the deficit and surplus location screen",
					test, test1);

		}

		System.out.println("Testcase - 341 Completed");

		Extent_cal(test, "Testcase 344 - Ensure in Surplus Qty field");

		Fluentwait(driver, Deficittab);
		click(driver, Deficittab);

		String Surfqty = getAttribute(driver, SurplusQty, "value");

		if (!Surfqty.isEmpty()) {

			System.out.println("Surplus quantity is autogenerated and the value was present in the Surplus Qty field");
			Extent_pass(driver, "Surplus quantity is autogenerated and the value was present in the Surplus Qty field",
					test, test1);
		} else {

			System.out.println("Surplus quantity was not present in the Surplus Qty field");
			Extent_fail(driver, "Surplus quantity was not present in the Surplus Qty field", test, test1);

		}

		System.out.println("Testcase 344 - Completed");

		Extent_cal(test, "Testcase 347 - Ensure in  Surplus Qty field not allow alphabets");

		String Surplusqty = getAttribute(driver, SurplusQty, "value");

		if (!Pattern.matches("^[a-zA-Z]+$", Surplusqty)) {

			System.out.println("Surplus quantity field not allowed alphabets");
			Extent_pass(driver, "Surplus quantity field not allowed alphabets", test, test1);

		} else {

			System.out.println("Surplus quantity field allowed alphabets");
			Extent_fail(driver, "Surplus quantity field allowed alphabets", test, test1);
		}

		System.out.println("Testcase 347 - Completed");

		Extent_cal(test, "Testcase 348 - Ensure in Surplus Qty  field allow numeric");

		if (Pattern.matches("^[0-9]+$", Surplusqty)) {

			System.out.println("Surplus quantity field allowed numeric values");
			Extent_pass(driver, "Surplus quantity field allowed numeric values", test, test1);

		} else {

			System.out.println("Surplus quantity field not allowed numeric values");
			Extent_fail(driver, "Surplus quantity field not allowed numeric values", test, test1);
		}

		System.out.println("Testcase 348 - Completed");

		Extent_cal(test, "Testcase 349 - Ensure in  Surplus Qty field not allow   Special character");

		if (!Pattern.matches("^[a-zA-Z]+$", Surplusqty)) {

			System.out.println("Surplus quantity field not allowed special characters");
			Extent_pass(driver, "Surplus quantity field not allowed special characters", test, test1);

		} else {

			System.out.println("Surplus quantity field allowed special characters");
			Extent_fail(driver, "Surplus quantity field allowed special characters", test, test1);
		}

		System.out.println("Testcase 349");

		Extent_cal(test,
				"Testcase 350 - Ensure in Filter Surplus Qty the Location,Equipment type,Region,Country,Import,Export,Applied Surplus/Deficit,Sub Lease Qty,One way Qty,New Production Container,Long Term Storage,Stock Status");

		WebElement scroller = driver.findElement(By.xpath("//div[@ref='eBodyHorizontalScrollViewport']"));

		int scrollAmount1 = 1000;

		js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller, scrollAmount1);

		Fluentwait(driver, Status_Filter);
		click(driver, Status_Filter);

		Fluentwait(driver, Locationcode_filtercolumn);
		click(driver, Locationcode_filtercolumn);

		Fluentwait(driver, Selectall);
		click(driver, Selectall);

		Fluentwait(driver, Surplus);
		click(driver, Surplus);

		Fluentwait(driver, Locationcode_filtercolumn);
		click(driver, Locationcode_filtercolumn);

		js.executeScript("arguments[0].scrollLeft = 0;", scroller, scrollAmount1);

		boolean ems = true;

		List<String> columnnames = Arrays.asList("location", "eqp", "region", "country", "importCnt", "export",
				"imbalance", "weeks", "weeklyimbal", "su", "appsurdef", "calsurdef", "defsurstatusflag", "stock",
				"onewayoutload", "onewayoutreturn", "onewaylease", "tboh", "sali");
		int size = columnnames.size();

		for (int i = 0; i < size; i++) {

			String columnname = columnnames.get(i);

			wait(driver, "3");
			WebElement columns = driver.findElement(By.xpath("(//div[@col-id='" + columnname + "'])[4]"));

			act.moveToElement(columns).build().perform();

			if (isDisplayed1(driver, columns)) {

				System.out.println(columnname + " data's are fetched from the ems history");

			} else {

				System.out.println(columnname + " data's are not fetched from the ems history");
				Extent_fail(driver, columnname + " data's are not fetched from the ems history", test, test1);
				ems = false;
			}

		}

		if (ems) {

			System.out.println(
					"Location,Equipment type,Region,Country,Import,Export,Applied Surplus/Deficit,Sub Lease Qty,One way Qty,New Production Container,Long Term Storage,Stock Status fields are showing as per the surplus filter");
			Extent_pass(driver,
					"Location,Equipment type,Region,Country,Import,Export,Applied Surplus/Deficit,Sub Lease Qty,One way Qty,New Production Container,Long Term Storage,Stock Status fields are showing as per the surplus filter",
					test, test1);
		} else {
			System.out.println(
					"Location,Equipment type,Region,Country,Import,Export,Applied Surplus/Deficit,Sub Lease Qty,One way Qty,New Production Container,Long Term Storage,Stock Status fields are not correctly showing as per the surplus filter");
			Extent_fail(driver,
					"Location,Equipment type,Region,Country,Import,Export,Applied Surplus/Deficit,Sub Lease Qty,One way Qty,New Production Container,Long Term Storage,Stock Status fields are not correctly showing as per the surplus filter",
					test, test1);
		}

		js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller, scrollAmount1);

		String record = getText(driver, Total_record);

		if (record.equals("39 of 128")) {

			System.out.println("Surplus filter is working fine and all the data's are showing correctly");
			Extent_pass(driver, "Surplus filter is working fine and all the data's are showing correctly", test, test1);

		} else {

			System.out.println("Surplus filter is not working fine, it shows different values");
			Extent_fail(driver, "Surplus filter is not working fine, it shows different values", test, test1);
		}

		System.out.println("Testcase 350 Completed");

		Extent_cal(test, "Testcase 351 - Ensure in Deficit Qty field");

		Fluentwait(driver, Deficittab);
		click(driver, Deficittab);

		String deficitqty = getAttribute(driver, DeficitQty, "value");

		if (!deficitqty.isEmpty()) {

			System.out.println("Deficit quantity is autogenerated and the value was present in the Deficit Qty field");
			Extent_pass(driver, "Deficit quantity is autogenerated and the value was present in the Deficit Qty field",
					test, test1);
		} else {

			System.out.println("Deficit quantity was not present in the Deficit Qty field");
			Extent_fail(driver, "Deficit quantity was not present in the Deficit Qty field", test, test1);
		}

		System.out.println("Testcase 351 - Completed");

		Extent_cal(test, "Testcase 354 - Ensure in  Deficit Qty field not allow alphabets");

		String Defqty = getAttribute(driver, DeficitQty, "value");

		if (!Pattern.matches("^[a-zA-Z]+$", Defqty)) {

			System.out.println("DeficitQty quantity field not allowed alphabets");
			Extent_pass(driver, "DeficitQty quantity field not allowed alphabets", test, test1);

		} else {

			System.out.println("DeficitQty quantity field allowed alphabets");
			Extent_fail(driver, "DeficitQty quantity field allowed alphabets", test, test1);
		}

		System.out.println("Testcase 354 - Completed");

		Extent_cal(test, "Testcase 355 - Ensure in Deficit Qty  field allow numeric");

		if (Pattern.matches("^[0-9]+$", Defqty)) {

			System.out.println("DeficitQty quantity field allowed numeric values");
			Extent_pass(driver, "DeficitQty quantity field allowed numeric values", test, test1);

		} else {

			System.out.println("DeficitQty quantity field not allowed numeric values");
			Extent_fail(driver, "DeficitQty quantity field not allowed numeric values", test, test1);
		}

		System.out.println("Testcase 355 - Completed");

		Extent_cal(test, "Testcase 356 - Ensure in  Deficit Qty field not allow Special character");

		if (!Pattern.matches("^[a-zA-Z]+$", Defqty)) {

			System.out.println("DeficitQty quantity field not allowed special characters");
			Extent_pass(driver, "DeficitQty quantity field not allowed special characters", test, test1);

		} else {

			System.out.println("DeficitQty quantity field allowed special characters");
			Extent_fail(driver, "DeficitQty quantity field allowed special characters", test, test1);
		}

		System.out.println("Testcase 356");

		Extent_cal(test,
				"Testcase 357 - Ensure in Filter the Deficit Qty Location,Equipment type,Region,Country,Import,Export,Applied Surplus/Deficit,Sub Lease Qty,One way Qty,New Production Container,Long Term Storage,Stock Status");

		WebElement scroller2 = driver.findElement(By.xpath("//div[@ref='eBodyHorizontalScrollViewport']"));

		js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller2, scrollAmount1);

		Fluentwait(driver, Status_Filter);
		click(driver, Status_Filter);
//
//		Fluentwait(driver, Locationcode_filtercolumn);
//		click(driver, Locationcode_filtercolumn);

		Fluentwait(driver, Selectall);
		click(driver, Selectall);

		Fluentwait(driver, Surplus);
		click(driver, Surplus);

		Fluentwait(driver, Locationcode_filtercolumn);
		click(driver, Locationcode_filtercolumn);

		js.executeScript("arguments[0].scrollLeft = 0;", scroller2, scrollAmount1);

		boolean ems_deficit = true;

		for (int i = 0; i < size; i++) {

			String columnname = columnnames.get(i);

			wait(driver, "1");
			WebElement columns = driver.findElement(By.xpath("(//div[@col-id='" + columnname + "'])[4]"));

			act.moveToElement(columns).build().perform();

			if (isDisplayed1(driver, columns)) {

				System.out.println(columnname + " data's are fetched from the ems history");

			} else {

				System.out.println(columnname + " data's are not fetched from the ems history");
				Extent_fail(driver, columnname + " data's are not fetched from the ems history", test, test1);
				ems_deficit = false;
			}

		}

		if (ems_deficit) {

			System.out.println(
					"Location,Equipment type,Region,Country,Import,Export,Applied Surplus/Deficit,Sub Lease Qty,One way Qty,New Production Container,Long Term Storage,Stock Status fields are showing as per the deficit filter");
			Extent_pass(driver,
					"Location,Equipment type,Region,Country,Import,Export,Applied Surplus/Deficit,Sub Lease Qty,One way Qty,New Production Container,Long Term Storage,Stock Status fields are showing as per the deficit filter",
					test, test1);
		} else {
			System.out.println(
					"Location,Equipment type,Region,Country,Import,Export,Applied Surplus/Deficit,Sub Lease Qty,One way Qty,New Production Container,Long Term Storage,Stock Status fields are not correctly showing as per the deficit filter");
			Extent_fail(driver,
					"Location,Equipment type,Region,Country,Import,Export,Applied Surplus/Deficit,Sub Lease Qty,One way Qty,New Production Container,Long Term Storage,Stock Status fields are not correctly showing as per the deficit filter",
					test, test1);
		}

		js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller, scrollAmount1);

		String record2 = getText(driver, Total_record);

		if (record2.equals("89 of 128")) {

			System.out.println("deficit filter is working fine and all the data's are showing correctly");
			Extent_pass(driver, "deficit filter is working fine and all the data's are showing correctly", test, test1);

		} else {

			System.out.println("deficit filter is not working fine, it shows different values");
			Extent_fail(driver, "deficit filter is not working fine, it shows different values", test, test1);
		}

		System.out.println("Testcase 350 Completed");

		scrollBottom(driver);

		Extent_cal(test,
				"Testcase 358- Ensure that system should allow to enter 53 in from week incase of the leap year ");

		wait(driver, "2");
		Fluentwait(driver, Deficittab);
		click(driver, Deficittab);

		Fluentwait(driver, Cancel);
		click(driver, Cancel);
		wait(driver, "2");
		Fluentwait(driver, New);
		click(driver, New);
		Fluentwait(driver, New_Popup_Yes);
		click(driver, New_Popup_Yes);

		wait(driver, "5");
		Fluentwait(driver, Year_Drop_Down);
		click(driver, Year_Drop_Down);

		wait(driver, "2");
		Fluentwait(driver, Year_Drop_Down);
		click(driver, Year_Drop_Down);

		wait(driver, "2");
		Fluentwait(driver, Year_Drop_Down);
		click(driver, Year_Drop_Down);

		Fluentwait(driver, Fromweek_input);
		clear(driver, Fromweek_input);
		sendKeys(driver, Fromweek_input, Leapyear);

		Fluentwait(driver, Year_Drop_Down);
		click(driver, Year_To_Drop_Down);

		wait(driver, "2");
		click(driver, Year_To_Drop_Down);

		wait(driver, "2");
		click(driver, Year_To_Drop_Down);

		Fluentwait(driver, Toweek_input);
		clear(driver, Toweek_input);
		sendKeys(driver, Toweek_input, ToWeek1);

		wait(driver, "2");
		Fluentwait(driver, Show);
		click(driver, Show);
		wait(driver, "2");

		if (isDisplayed(driver, show_yes)) {
			Fluentwait(driver, show_yes);
			click(driver, show_yes);
		}

		String leap_year = getAttribute(driver, Fromweek_input, "value");
		System.out.println(leap_year);

		boolean week_Condition = true;

		if (leap_year.equals("53")) {
			System.out.println("Matched || Expected  value was  : " + Leapyear + " Actual   value was : " + leap_year);
			Extent_pass(driver, "Matched || Expected  value was: " + Leapyear + " Actual   value was  : " + leap_year,
					test, test1);
		} else {
			System.out.println(
					"Not Matched || Expected  value was  : " + Leapyear + " Actual   value was : " + leap_year);
			Extent_fail(driver,
					"Not Matched || Expected  value was: " + Leapyear + " Actual   value was  : " + leap_year, test,
					test1);
			week_Condition = false;
		}

		if (week_Condition) {

			Extent_pass(driver, "System allowed to enter 53 in from week incase of the leap year", test, test1);
		} else {

			Extent_fail(driver, "System not allowed to enter 53 in from week incase of the leap year", test, test1);
		}

		System.out.println("*********************358**************");

		Fluentwait(driver, Cancel);
		click(driver, Cancel);
		wait(driver, "2");
		Fluentwait(driver, New);
		click(driver, New);
		Fluentwait(driver, New_Popup_Yes);
		click(driver, New_Popup_Yes);
		wait(driver, "2");

		Extent_cal(test,
				"Testcase 359- Ensure that the system validates the from week based on the selected from year ");

		wait(driver, "3");
		Fluentwait(driver, Year_Drop_Down);
		click(driver, Year_Drop_Down);
		wait(driver, "2");
		Fluentwait(driver, Fromweek_input);
		clear(driver, Fromweek_input);
		sendKeys(driver, Fromweek_input, Leapyear);
		Fluentwait(driver, Year_To_Drop_Down);
		click(driver, Year_To_Drop_Down);
		wait(driver, "2");
		Fluentwait(driver, Toweek_input);
		clear(driver, Toweek_input);
		sendKeys(driver, Toweek_input, ToWeek1);
		wait(driver, "2");
		Fluentwait(driver, Show);
		click(driver, Show);
		wait(driver, "2");

		if (isDisplayed(driver, show_yes)) {
			Fluentwait(driver, show_yes);
			click(driver, show_yes);
		}

		String leap_year1 = getAttribute(driver, Fromweek_input, "value");
		System.out.println(leap_year1);

		if (!leap_year1.equals(Leapyear)) {
			Extent_pass(driver, "Non leap year not accepting the 53 weeks", test, test1);
		} else {
			Extent_fail(driver, "Non leap year accepting the 53 weeks", test, test1);
		}

		System.out.println("*******************359**************");

		Extent_cal(test,
				"Testcase 360- Ensure that system should allow to enter 53 in To week incase of the leap year ");

		Fluentwait(driver, Cancel);
		click(driver, Cancel);
		wait(driver, "2");
		Fluentwait(driver, New);
		click(driver, New);

		Fluentwait(driver, New_Popup_Yes);
		click(driver, New_Popup_Yes);

		wait(driver, "5");
		Fluentwait(driver, Fromyear_input);
		doubleClick(driver, Fromyear_input);
		wait(driver, "2");

//		rbt.keyPress(KeyEvent.VK_BACK_SPACE);

		act.sendKeys(Keys.BACK_SPACE).build().perform();

		sendKeys(driver, Fromyear_input, Fromyear);

		Fluentwait(driver, Fromweek_input);
		click(driver, Fromweek_input);
		clear(driver, Fromweek_input);
		sendKeys(driver, Fromweek_input, Leapyear);

		wait(driver, "2");
		Fluentwait(driver, Toyear_input);
		doubleClick(driver, Toyear_input);
		wait(driver, "2");
		act.sendKeys(Keys.BACK_SPACE).build().perform();

//		click(driver, Toyear_input);
		sendKeys(driver, Toyear_input, Fromyear);

		Fluentwait(driver, Toweek_input);
		clear(driver, Toweek_input);
		sendKeys(driver, Toweek_input, Leapyear);

		wait(driver, "2");
		Fluentwait(driver, Show);
		click(driver, Show);
		wait(driver, "2");

		if (isDisplayed(driver, show_yes)) {
			Fluentwait(driver, show_yes);
			click(driver, show_yes);
		}

		if (isDisplayed(driver, Warningpopup_Ok)) {

			click(driver, Warningpopup_Ok);
		}

		String Toleap_year = getAttribute(driver, Toweek_input, "value");
		System.out.println(Toleap_year);

		boolean Toweek_Condition = true;

		if (Toleap_year.equals("53")) {
			System.out.println("Matched || Expected  value was  : " + "53" + " Actual   value was : " + Toleap_year);
			Extent_pass(driver, "Matched || Expected  value was: " + "53" + " Actual   value was  : " + Toleap_year,
					test, test1);
		} else {
			System.out
					.println("Not Matched || Expected  value was  : " + "53" + " Actual   value was : " + Toleap_year);
			Extent_fail(driver, "Not Matched || Expected  value was: " + "53" + " Actual   value was  : " + Toleap_year,
					test, test1);
			Toweek_Condition = false;
		}

		if (Toweek_Condition) {

			Extent_pass(driver, "System allowed to enter 53 in To week incase of the leap year", test, test1);
		} else {

			Extent_fail(driver, "System not allowed to enter 53 in To week incase of the leap year", test, test1);
		}

		System.out.println("*********************360**************");

		Extent_cal(test, "Testcase 361- Ensure that the system validates the To week based on the selected To year ");

		wait(driver, "3");
//		Fluentwait(driver, Year_Drop_Down);
//		click(driver, Year_Drop_Down);

		Fluentwait(driver, Fromweek_input);
		clear(driver, Fromweek_input);
		sendKeys(driver, Fromweek_input, Fromweek);
		wait(driver, "2");

		Fluentwait(driver, Year_To_Drop_Down);
		click(driver, Year_To_Drop_Down);

		wait(driver, "2");
		Fluentwait(driver, Toweek_input);
		clear(driver, Toweek_input);
		sendKeys(driver, Toweek_input, Leapyear);

		String To_week2 = getAttribute(driver, Toweek_input, "value");
		System.out.println(To_week2);
		if (!To_week2.equals(Leapyear)) {
			Extent_pass(driver, "To week not accepting 53 weeks if the year is not a leap year", test, test1);
		} else {
			Extent_fail(driver, "To week field accepting 53 weeks even if the year is not a leap year", test, test1);
		}
		System.out.println("*****************361**************");

		Extent_cal(test, "Testcase 366 - Ensure in  import from excel, actual Export column not allow alphabets");

		Fluentwait(driver, Cancel);
		click(driver, Cancel);

		wait(driver, "2");
		Fluentwait(driver, New);
		click(driver, New);

		Fluentwait(driver, New_Popup_Yes);
		click(driver, New_Popup_Yes);
		wait(driver, "2");

		Fluentwait(driver, dropdown_option);
		click(driver, dropdown_option);

		Fluentwait(driver, Budget_Reposition);
		click(driver, Budget_Reposition);

		Fluentwait(driver, Budget);
		click(driver, Budget);
		wait(driver, "2");

//		uploadFileRobot(driver, Import_alphabets);

		String upload_EquimentType_Alphabets1 = System.getProperty("user.dir") + "/driver/MasterDownloadfile.exe "
				+ Import_alphabets;

		try {
			Runtime.getRuntime().exec(upload_EquimentType_Alphabets1);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getLocalizedMessage());
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
		}

		wait(driver, "25");

		Fluentwait(driver, Location3);

		if (isDisplayed(driver, click_yes)) {

			click(driver, click_yes);

			Fluentwait(driver, Click_ok);
			click(driver, Click_ok);
		}

		wait(driver, "2");

		waitForElement(driver, Total_record);

		boolean allPassedexport1 = true;

		String Total_records1 = getText(driver, Total_record);

		int length2 = Integer.parseInt(Total_records1);

		for (int i = 0; i < length2; i++) {

			WebElement element = driver.findElement(By.xpath("(//div[@row-id='" + i + "'])[2]//div[@col-id='export']"));

			act.moveToElement(element).click().build().perform();
			// Get the text from the element
			String text = element.getText();
			// Check if the text contains any alphabetic characters
			if (!containsAlphabetic(text)) {
				System.out.println("The Export column does not allow alphabetic characters");
			} else {
				System.out.println("The Export column allowed to enter the alphabetic characters - " + text);
				Extent_fail(driver, "The Export column allowed to enter the alphabetic characters - " + text, test,
						test1);
				allPassedexport1 = false;

			}
		}

		scrollBottom(driver);

		if (allPassedexport1) {
			Extent_pass(driver, "The Export column does not allow to import alphabetic characters into the grid", test,
					test1);
		} else {
			Extent_fail(driver, "The Export column allowed to import the alphabetic characters into the grid", test,
					test1);
		}

		System.out.println("************Testcase 366 Completed***********");

		Extent_cal(test, "Testcase 367 - Ensure in  import from excel, actual Export column  allow numeric");

		Fluentwait(driver, Cancel);
		click(driver, Cancel);

		wait(driver, "2");
		Fluentwait(driver, New);
		click(driver, New);

		Fluentwait(driver, New_Popup_Yes);
		click(driver, New_Popup_Yes);
		wait(driver, "2");

		wait(driver, "2");

		Fluentwait(driver, dropdown_option);
		click(driver, dropdown_option);

		Fluentwait(driver, Budget_Reposition);
		click(driver, Budget_Reposition);

		Fluentwait(driver, Budget);
		click(driver, Budget);

		wait(driver, "3");

//		uploadFileRobot(driver, EquimentType_Alphabets);

		String upload_EquimentType_Alphabets2 = System.getProperty("user.dir") + "/driver/MasterDownloadfile.exe "
				+ EquimentType_Alphabets;

		try {
			Runtime.getRuntime().exec(upload_EquimentType_Alphabets2);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getLocalizedMessage());
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
		}

		wait(driver, "25");

		Fluentwait(driver, Location3);

		if (isDisplayed(driver, click_yes)) {

			click(driver, click_yes);

			Fluentwait(driver, Click_ok);
			click(driver, Click_ok);
		}

		wait(driver, "3");

		boolean exportnumeric = true;

		for (int i = 0; i < length2; i++) {

			WebElement element = driver.findElement(By.xpath("(//div[@row-id='" + i + "'])[2]//div[@col-id='export']"));

			act.moveToElement(element).click().build().perform();
			// Get the text from the element
			String text = element.getText();
			// Check if the text contains any alphabetic characters
			if (containsNumeric(text)) {
				System.out.println("The Export column allowed to import the numeric data's into the grid");
			} else {
				System.out.println("The Export column does not allow numeric data's into the grid");
				Extent_fail(driver, "The Export column does not allow numeric data's into the grid", test, test1);
				exportnumeric = false;

			}
		}

		if (exportnumeric) {
			Extent_pass1(test, "Export column allowed to import the numeric values into the grid");
		} else {

			Extent_fail(driver, "Export column not allowed to import the numeric values into the grid", test, test1);
		}

		System.out.println("************Testcase 367 Completed***********");

		scrollBottom(driver);

		Extent_cal(test, "Testcase 368 - Ensure in  import from excel  Export column not allow Special character");

		Fluentwait(driver, Cancel);
		waitclick(driver, Cancel);
		wait(driver, "2");

		Fluentwait(driver, New);
		click(driver, New);

		Fluentwait(driver, New_Popup_Yes);
		click(driver, New_Popup_Yes);
		wait(driver, "2");

		wait(driver, "2");
		Fluentwait(driver, dropdown_option);
		click(driver, dropdown_option);

		Fluentwait(driver, Budget_Reposition);
		click(driver, Budget_Reposition);

		Fluentwait(driver, Budget);
		click(driver, Budget);
		wait(driver, "2");

//		uploadFileRobot(driver, Import_specialcharacter);

		String upload_Import_specialcharacter = System.getProperty("user.dir") + "/driver/MasterDownloadfile.exe "
				+ Import_specialcharacter;

		try {
			Runtime.getRuntime().exec(upload_Import_specialcharacter);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getLocalizedMessage());
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
		}

		wait(driver, "25");

		Fluentwait(driver, Location3);

		if (isDisplayed(driver, click_yes)) {

			click(driver, click_yes);

			Fluentwait(driver, Click_ok);
			click(driver, Click_ok);
		}

		wait(driver, "2");

		boolean exportallPassed2 = true;

		for (int i = 0; i < length2; i++) {

			WebElement element = driver.findElement(By.xpath("(//div[@row-id='" + i + "'])[2]//div[@col-id='export']"));

			act.moveToElement(element).click().build().perform();
			// Get the text from the element
			String text = element.getText();
			// Check if the text contains any alphabetic characters
			if (!containsSpecialCharacter(text)) {
				System.out.println("The Export column does not allow Special characters");

			} else {
				System.out.println("The Export column allowed to enter the Special characters - " + text);
				Extent_fail(driver, "The Export column allowed to enter the Special characters - " + text, test, test1);
				exportallPassed2 = false;

			}
		}

		scrollBottom(driver);

		if (exportallPassed2) {
			Extent_pass(driver, "The Export column does not allow import the Special characters into the grid ", test,
					test1);
		} else {
			Extent_fail(driver, "The Export column allowed to import the Special characters in the grid", test, test1);
		}

		System.out.println("************Testcase 368 Completed***********");

		Extent_cal(test, "Testcase 376 - Ensure in  import from excel on hire qty Qty column not allow alphabets");

		Fluentwait(driver, Searchbox);
		sendKeys(driver, Searchbox, "On Off Hire Stock");

		Fluentwait(driver, OnOFF_Hire);
		click(driver, OnOFF_Hire);

		Fluentwait(driver, Total_columnrecord);
		String OnOFF_Total_records = getText(driver, Total_columnrecord);

		int OnOFF_length = Integer.parseInt(OnOFF_Total_records);

		boolean onhire_alpha = true;

		for (int i = 0; i < 10; i++) {

			WebElement element = driver.findElement(By.xpath("(//div[@row-id='" + i + "'])[11]//div[@col-id='count']"));
			act.moveToElement(element).click().build().perform();
			String text = element.getText();

			if (!containsAlphabetic(text)) {
				System.out.println("The On hire column does not allow alphabetic characters");

			} else {
				System.out.println("The On hire column allowed to enter the alphabetic characters - " + text);
				Extent_fail(driver, "The On hire column allowed to enter the alphabetic characters - " + text, test,
						test1);
				onhire_alpha = false;
			}
		}

		if (onhire_alpha) {

			System.out.println("On hire Column not allow alphabet characters");
			Extent_pass(driver, "On hire Column not allow alphabet characters", test, test1);
		} else {

			System.out.println("On hire column allows alphabet characters");
			Extent_fail(driver, "On hire column allows alphabet characters", test, test1);
		}

		scrollBottom(driver);

		System.out.println("Testcase 376 Completed");

		Extent_cal(test, "Testcase 377 - Ensure in  import from excel  on hire qty Qty column  allow numeric");

		boolean onhire_numeric = true;

		for (int i = 0; i < 10; i++) {

			WebElement element = driver.findElement(By.xpath("(//div[@row-id='" + i + "'])[11]//div[@col-id='count']"));
			act.moveToElement(element).click().build().perform();
			String text = element.getText();

			if (containsNumeric(text)) {
				System.out.println("The On hire column allowed to enter the numeric values - " + text);

			} else {
				System.out.println("The On hire column does not allow numeric values - " + text);
				Extent_fail(driver, "The On hire column does not allow numeric values - " + text, test, test1);
				onhire_numeric = false;
			}
		}

		if (onhire_numeric) {

			System.out.println("On hire column allows numeric values");
			Extent_pass(driver, "On hire column allows numeric values", test, test1);

		} else {
			System.out.println("On hire Column not allow numeric values");
			Extent_fail(driver, "On hire Column not allow numeric values", test, test1);

		}

		scrollBottom(driver);

		System.out.println("Testcase 377 Completed");

		Extent_cal(test,
				"Testcase 378 - Ensure in  import from excel on hire qty Qty column not allow   Special character");

		boolean onhire_special = true;

		for (int i = 0; i < 10; i++) {

			WebElement element = driver.findElement(By.xpath("(//div[@row-id='" + i + "'])[11]//div[@col-id='count']"));
			act.moveToElement(element).click().build().perform();
			String text = element.getText();

			if (!containsAlphabetic(text)) {
				System.out.println("The On hire column does not allow alphabetic characters");

			} else {
				System.out.println("The On hire column allowed to enter the alphabetic characters - " + text);
				Extent_fail(driver, "The On hire column allowed to enter the alphabetic characters - " + text, test,
						test1);
				onhire_special = false; // Set the flag to false if any condition fails
			}
		}

		if (onhire_special) {

			System.out.println("On hire Column not allow alphabet characters");
			Extent_pass(driver, "On hire Column not allow alphabet characters", test, test1);
		} else {

			System.out.println("On hire column allows alphabet characters");
			Extent_fail(driver, "On hire column allows alphabet characters", test, test1);
		}

		scrollBottom(driver);

		System.out.println("Testcase 378 Completed");

		Extent_cal(test, "Testcase 381 - Ensure in  import from excel off hire qty Qty column not allow alphabets");

		Fluentwait(driver, OnOFF_Hire_dropdown);
		click(driver, OnOFF_Hire_dropdown);

		Fluentwait(driver, OFF_Hire_option);
		click(driver, OFF_Hire_option);

		Fluentwait(driver, Total_columnrecord);
		String offhire_Total_records = getText(driver, Total_columnrecord);

		int OFF_length = Integer.parseInt(offhire_Total_records);

		boolean offhire_alpha = true;

		for (int i = 0; i < 10; i++) {

			WebElement element = driver.findElement(By.xpath("(//div[@row-id='" + i + "'])[11]//div[@col-id='count']"));
			act.moveToElement(element).click().build().perform();
			String text = element.getText();

			if (!containsAlphabetic(text)) {
				System.out.println("The Off hire column does not allow alphabetic characters");

			} else {
				System.out.println("The Off hire column allowed to enter the alphabetic characters - " + text);
				Extent_fail(driver, "The Off hire column allowed to enter the alphabetic characters - " + text, test,
						test1);
				offhire_alpha = false;
			}
		}

		if (offhire_alpha) {

			System.out.println("Off hire Column not allow alphabet characters");
			Extent_pass(driver, "Off hire Column not allow alphabet characters", test, test1);
		} else {

			System.out.println("Off hire column allows alphabet characters");
			Extent_fail(driver, "Off hire column allows alphabet characters", test, test1);
		}

		scrollBottom(driver);

		System.out.println("Testcase 376 Completed");

		Extent_cal(test, "Testcase 377 - Ensure in  import from excel  on hire qty Qty column  allow numeric");

		boolean offhire_numeric = true;

		for (int i = 0; i < 10; i++) {

			WebElement element = driver.findElement(By.xpath("(//div[@row-id='" + i + "'])[11]//div[@col-id='count']"));
			act.moveToElement(element).click().build().perform();
			String text = element.getText();

			if (containsNumeric(text)) {
				System.out.println("The Off hire column allowed to enter the numeric values - " + text);

			} else {
				System.out.println("The Off hire column does not allow numeric values - " + text);
				Extent_fail(driver, "The Off hire column does not allow numeric values - " + text, test, test1);
				offhire_numeric = false;
			}
		}

		if (offhire_numeric) {

			System.out.println("Off hire column allows numeric values");
			Extent_pass(driver, "Off hire column allows numeric values", test, test1);

		} else {
			System.out.println("Off hire Column not allow numeric values");
			Extent_fail(driver, "Off hire Column not allow numeric values", test, test1);

		}

		scrollBottom(driver);

		System.out.println("Testcase 377 Completed");

		Extent_cal(test,
				"Testcase 378 - Ensure in  import from excel on hire qty Qty column not allow   Special character");

		boolean offhire_special = true;

		for (int i = 0; i < 10; i++) {

			WebElement element = driver.findElement(By.xpath("(//div[@row-id='" + i + "'])[11]//div[@col-id='count']"));
			act.moveToElement(element).click().build().perform();
			String text = element.getText();

			if (!containsAlphabetic(text)) {
				System.out.println("The Off hire column does not allow alphabetic characters");

			} else {
				System.out.println("The Off hire column allowed to enter the alphabetic characters - " + text);
				Extent_fail(driver, "The Off hire column allowed to enter the alphabetic characters - " + text, test,
						test1);
				offhire_special = false; // Set the flag to false if any condition fails
			}
		}

		if (offhire_special) {

			System.out.println("Off hire Column not allow alphabet characters");
			Extent_pass(driver, "Off hire Column not allow alphabet characters", test, test1);
		} else {

			System.out.println("Off hire column allows alphabet characters");
			Extent_fail(driver, "Off hire column allows alphabet characters", test, test1);
		}

		scrollBottom(driver);

		System.out.println("Testcase 378 Completed");

		Extent_cal(test,
				"Testcase 390 - Check whether the ems reposition selection button selection functions correct");

		Fluentwait(driver, Deficittab);
		click(driver, Deficittab);

		Fluentwait(driver, Cancel);
		click(driver, Cancel);

		Fluentwait(driver, New);
		click(driver, New);

		Fluentwait(driver, createnew_confirm);
		click(driver, createnew_confirm);

		wait(driver, "5");

		Fluentwait(driver, Fromweek_input);
		clear(driver, Fromweek_input);
		sendKeys(driver, Fromweek_input, FromWeek1);
		wait(driver, "2");

		Fluentwait(driver, Toweek_input);
		clear(driver, Toweek_input);
		sendKeys(driver, Toweek_input, ToWeek1);
		wait(driver, "2");

		Fluentwait(driver, Show);
		click(driver, Show);
		wait(driver, "2");

		if (isDisplayed(driver, show_yes)) {
			Fluentwait(driver, show_yes);
			click(driver, show_yes);
		}

		wait(driver, "2");
		if (isDisplayed(driver, click_yes)) {

			click(driver, click_yes);

			Fluentwait(driver, Click_ok);
			click(driver, Click_ok);
		}

		boolean emsfunction = true;

		for (int i = 0; i < size; i++) {

			String columnname = columnnames.get(i);

			wait(driver, "1");
			WebElement columns = driver.findElement(By.xpath("(//div[@col-id='" + columnname + "'])[4]"));

			act.moveToElement(columns).build().perform();

			if (isDisplayed1(driver, columns)) {

				System.out.println("After click on the show button, Records of the " + columnname
						+ " for ems reposition was displayed");
				Extent_pass(driver, "After click on the show button, Records of the " + columnname
						+ "  for ems reposition was displayed", test, test1);
			} else {

				System.out.println("After click on the show button, Records of the " + columnname
						+ "  for ems reposition was not displayed");
				Extent_fail(driver, "After click on the show button, Records of the " + columnname
						+ "  for ems reposition was not displayed", test, test1);
				emsfunction = false;
			}

		}

		if (emsfunction) {

			Extent_pass(driver, "After click on ems position records are displayed", test, test1);
		} else {

			Extent_fail(driver, "After click on ems position records are not displayed", test, test1);
		}

		System.out.println("Testcase 390 - Completed");

		Extent_cal(test, "Testcase 391 - Check whether the forecasting reposition button selection functions correct");

		wait(driver, "5");

		Fluentwait(driver, Cancel);
		click(driver, Cancel);

		wait(driver, "3");

		Fluentwait(driver, New);
		click(driver, New);

		Fluentwait(driver, createnew_confirm);
		click(driver, createnew_confirm);

		wait(driver, "2");

		Fluentwait(driver, Reposition_dropdown);
		click(driver, Reposition_dropdown);

		Fluentwait(driver, Forecasting_reposition);
		click(driver, Forecasting_reposition);

		wait(driver, "3");
		Fluentwait(driver, Fromweek_input);
		clear(driver, Fromweek_input);
		sendKeys(driver, Fromweek_input, FromWeek1);
		wait(driver, "2");

		Fluentwait(driver, Toyear_Increase);
		click(driver, Toyear_Increase);

		Fluentwait(driver, Toweek_input);
		clear(driver, Toweek_input);
		sendKeys(driver, Toweek_input, ToWeek1);
		wait(driver, "2");

		Fluentwait(driver, Show);
		click(driver, Show);
		wait(driver, "2");

		if (isDisplayed(driver, show_yes)) {
			Fluentwait(driver, show_yes);
			click(driver, show_yes);
		}

		wait(driver, "2");
		if (isDisplayed(driver, click_yes)) {

			click(driver, click_yes);

			Fluentwait(driver, Click_ok);
			click(driver, Click_ok);
		}

		for (int j = 0; j < size; j++) {

			String columnname1 = columnnames.get(j);

			WebElement columns1 = driver.findElement(By.xpath("(//div[@col-id='" + columnname1 + "'])[4]"));

			act.moveToElement(columns1).build().perform();

			if (isDisplayed1(driver, columns1)) {

				System.out.println("After click on the show button, Records of the " + columnname1
						+ " for Forecasting reposition was displayed");
				Extent_pass(driver, "After click on the show button, Records of the " + columnname1
						+ "  for Forecasting reposition was displayed", test, test1);
			} else {

				System.out.println("After click on the show button, Records of the " + columnname1
						+ "  for Forecasting reposition was not displayed");
				Extent_fail(driver, "After click on the show button, Records of the " + columnname1
						+ "  for Forecasting reposition was not displayed", test, test1);

			}

		}

		System.out.println("Testcase 391 - Completed");

		Extent_cal(test, "Testcase 392 - Check whether the default formula shown for forecasting reposition");

		Fluentwait(driver, Searchbox);
		sendKeys(driver, Searchbox, "Ero Rule Builder");

		Fluentwait(driver, Rulebuilder);
		click(driver, Rulebuilder);

		Fluentwait(driver, Forecasting);
		click(driver, Forecasting);

		waitForElement(driver, EMS_Formula);
		String EmsFormula = getText(driver, EMS_Formula);

		System.out.println("EmsFormula : " + EmsFormula);

		if (EmsFormula.equals("(#IMPORTLDN#+#STOCKSTS#)-#TM1#")) {

			System.out.println("Rule imbalance formula for Forecasting reposition was displayed");
			Extent_pass(driver, "Rule imbalance formula was displayed", test, test1);
		} else {

			System.out.println("Rule imbalance formula for Forecasting reposition was not displayed");
			Extent_fail(driver, "Rule imbalance formula for Forecasting reposition was not displayed", test, test1);
		}

		if (!isClear(driver, EMS_Formula)) {

			System.out.println("Unable to edit the Forecasting reposition rule imbalance formula");
			Extent_pass(driver, "Unable to edit the Forecasting reposition rule imbalance formula", test, test1);

		} else {

			System.out.println("User can able to edit the Forecasting reposition rule imbalance formula");
			Extent_fail(driver, "User can able to edit the Forecasting reposition rule imbalance formula", test, test1);
		}

		System.out.println("Testcase 392 Completed");

		Extent_cal(test, "Testcase 393 - Check whether future weeks are allowed for forecasting reposition");

		Fluentwait(driver, Deficittab);
		click(driver, Deficittab);

		Fluentwait(driver, Cancel);
		click(driver, Cancel);

		wait(driver, "3");

		Fluentwait(driver, New);
		click(driver, New);

		Fluentwait(driver, createnew_confirm);
		click(driver, createnew_confirm);

		wait(driver, "5");

		Fluentwait(driver, Reposition_dropdown);
		click(driver, Reposition_dropdown);

		Fluentwait(driver, Forecasting_reposition);
		click(driver, Forecasting_reposition);

		wait(driver, "5");

		Fluentwait(driver, Fromweek_input);
		clear(driver, Fromweek_input);
		sendKeys(driver, Fromweek_input, FromWeek1);
		wait(driver, "2");

		Fluentwait(driver, Toyear_Increase);
		click(driver, Toyear_Increase);

		Fluentwait(driver, Toweek_input);
		clear(driver, Toweek_input);
		sendKeys(driver, Toweek_input, ToWeek1);
		wait(driver, "2");

		Fluentwait(driver, Show);
		click(driver, Show);
		wait(driver, "2");

		if (isDisplayed(driver, show_yes)) {
			Fluentwait(driver, show_yes);
			click(driver, show_yes);
		}

		wait(driver, "2");
		if (isDisplayed(driver, click_yes)) {

			click(driver, click_yes);

			Fluentwait(driver, Click_ok);
			click(driver, Click_ok);
		}

		if (isDisplayed(driver, Grid_locationfield1)) {

			System.out.println("Future weeks are allowed for Forecasting reposition");
			Extent_pass(driver, "Future weeks are allowed for Forecasting reposition", test, test1);
		} else {

			System.out.println("Future weeks are not allowed for Forecasting reposition");
			Extent_fail(driver, "Future weeks are not allowed for Forecasting reposition", test, test1);
		}

		System.out.println("Testcase 393 - Completed");

		Extent_cal(test, "Testcase 395 - Check whether the forecasting reposition ID starts with F");

		wait(driver, "2");
		Fluentwait(driver, Cancel);
		click(driver, Cancel);
		wait(driver, "2");

		Fluentwait(driver, New);
		click(driver, New);
		Fluentwait(driver, New_Popup_Yes);
		click(driver, New_Popup_Yes);
		wait(driver, "2");
		Fluentwait(driver, dropdown_option);
		click(driver, dropdown_option);
		Fluentwait(driver, Forecasting_reposition);
		click(driver, Forecasting_reposition);
		wait(driver, "2");
		Fluentwait(driver, Show);
		click(driver, Show);
		wait(driver, "2");

		if (isDisplayed(driver, Show_Popup_Yes)) {

			Fluentwait(driver, Show_Popup_Yes);
			click(driver, Show_Popup_Yes);

		}

		wait(driver, "2");
		if (isDisplayed(driver, click_yes)) {

			click(driver, click_yes);

			Fluentwait(driver, Click_ok);
			click(driver, Click_ok);
		}

		wait(driver, "2");
		Fluentwait(driver, Save);
		click(driver, Save);
		Fluentwait(driver, Save_popup_ok);
		click(driver, Save_popup_ok);
		wait(driver, "2");
		String first_letter = getAttribute(driver, IDField, "value");
		if (first_letter.charAt(0) == 'F') {
			Extent_pass(driver, "Autogenarated id value for the forecasting reposition was start with F  ", test,
					test1);
			System.out.println("Matched || Expected   was  : F , Actual was : " + first_letter.charAt(0));
			Extent_pass(driver, "Matched || Expected   was: F , Actual was  : " + first_letter.charAt(0), test, test1);
		} else {
			Extent_pass(driver, "Autogenarated id value for the forecasting reposition was not start with F  ", test,
					test1);
			System.out.println("Not Matched || Expected   was  : F , Actual was : " + first_letter.charAt(0));
			Extent_fail(driver, "Not Matched || Expected   was: F , Actual was  : " + first_letter.charAt(0), test,
					test1);
		}
		System.out.println("*****************395**************");

		wait(driver, "2");
		Fluentwait(driver, Cancel);
		click(driver, Cancel);
		wait(driver, "2");

		Extent_cal(test, "Testcase 396- Check whether the reference field data is updated and saved correctly ");

		wait(driver, "2");
		Fluentwait(driver, New);
		click(driver, New);
		Fluentwait(driver, New_Popup_Yes);
		click(driver, New_Popup_Yes);
		wait(driver, "2");
		Fluentwait(driver, dropdown_option);
		click(driver, dropdown_option);
		Fluentwait(driver, Forecasting_reposition);
		click(driver, Forecasting_reposition);
		wait(driver, "2");
		Fluentwait(driver, Show);
		click(driver, Show);
		wait(driver, "2");

		if (isDisplayed(driver, Show_Popup_Yes)) {

			Fluentwait(driver, Show_Popup_Yes);
			click(driver, Show_Popup_Yes);

		}

		wait(driver, "2");
		if (isDisplayed(driver, click_yes)) {

			click(driver, click_yes);

			Fluentwait(driver, Click_ok);
			click(driver, Click_ok);
		}

		wait(driver, "2");
		String from_week4 = getAttribute(driver, Fromweek_input, "value");
		wait(driver, "2");
		String To_week4 = getAttribute(driver, Toweek_input, "value");
		Fluentwait(driver, Save);
		click(driver, Save);
		Fluentwait(driver, Save_popup_ok);
		click(driver, Save_popup_ok);
		wait(driver, "2");
		String from_week5 = getAttribute(driver, Fromweek_input, "value");
		wait(driver, "2");
		String To_week5 = getAttribute(driver, Toweek_input, "value");

		boolean preference = true;

		if (from_week5.equals(from_week4)) {
			System.out.println("Matched || Expected week was  : " + from_week4 + " Actual week was : " + from_week5);
			Extent_pass(driver, "Matched || Expected week was: " + from_week4 + " Actual week was  : " + from_week5,
					test, test1);
		} else {
			System.out
					.println("Not Matched || Expected week was  : " + from_week4 + " Actual week was : " + from_week5);
			Extent_fail(driver, "NOt Matched || Expected week was: " + from_week4 + " Actual week was  : " + from_week5,
					test, test1);
			preference = false;
		}

		wait(driver, "2");
		if (To_week5.equals(To_week4)) {
			System.out.println("Matched || Expected  week was  : " + To_week4 + " Actual week was : " + To_week5);
			Extent_pass(driver, "Matched || Expected  week was: " + To_week4 + " Actual  popup week was  : " + To_week5,
					test, test1);
		} else {
			System.out.println("Not Matched || Expected  week was  : " + To_week4 + " Actual week was : " + To_week5);
			Extent_fail(driver, "Not Matched || Expected  week was: " + To_week4 + " Actual week was  : " + To_week5,
					test, test1);
			preference = false;
		}

		if (preference) {

			Extent_pass(driver, "Reference data field is updated and saved correctly", test, test1);
		} else {

			Extent_fail(driver, "Reference data field is not updated", test, test1);
		}

		System.out.println("**********************396************");

		Extent_cal(test, "Testcase 399 - Check whether the xlsx type is allowed to import in deficit screen");

		Fluentwait(driver, Cancel);
		click(driver, Cancel);

		wait(driver, "2");
		Fluentwait(driver, New);
		click(driver, New);

		Fluentwait(driver, New_Popup_Yes);
		click(driver, New_Popup_Yes);
		wait(driver, "2");

		Fluentwait(driver, dropdown_option);
		click(driver, dropdown_option);

		Fluentwait(driver, Budget_Reposition);
		click(driver, Budget_Reposition);

		Fluentwait(driver, Budget);
		click(driver, Budget);
		wait(driver, "2");

//		uploadFileRobot(driver, Import_alphabets);

		String upload_Import_alphabets = System.getProperty("user.dir") + "/driver/MasterDownloadfile.exe "
				+ Import_alphabets;

		try {
			Runtime.getRuntime().exec(upload_Import_alphabets);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getLocalizedMessage());
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
		}

		wait(driver, "25");

		Fluentwait(driver, Location3);

		if (isDisplayed(driver, click_yes)) {

			click(driver, click_yes);

			Fluentwait(driver, Click_ok);
			click(driver, Click_ok);
		}

		wait(driver, "2");

		WebElement excelscroller = driver.findElement(By.xpath("//div[@ref='eBodyHorizontalScrollViewport']"));

		int excelscrollAmount1 = 1000;

		boolean excel = true;

		for (int i = 0; i < size; i++) {

			String columnname = columnnames.get(i);

			wait(driver, "3");
			WebElement columns = driver.findElement(By.xpath("(//div[@col-id='" + columnname + "'])[4]"));

			act.moveToElement(columns).build().perform();

			if (isDisplayed1(driver, columns)) {

				System.out.println(columnname + " data's are fetched from the ems history");

			} else {

				System.out.println(columnname + " data's are not fetched from the ems history");
				Extent_fail(driver, columnname + " data's are not fetched from the ems history", test, test1);
				excel = false;
			}

		}

		if (excel) {

			System.out.println("Xlsx file is allowed to import in deficit screen");
			Extent_pass(driver, "Xlsx file is allowed to import in deficit screen", test, test1);
		} else {
			System.out.println("Xlsx file is not allowed to import in deficit screen");
			Extent_fail(driver, "Xlsx file is not allowed to import in deficit screen", test, test1);
		}

		js.executeScript("arguments[0].scrollLeft += arguments[1];", excelscroller, excelscrollAmount1);

		System.out.println("Testcase 399 Completed");

	}

}
