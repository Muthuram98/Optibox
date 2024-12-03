package DeficitAndSurflusLocationIdentification_Scripts;

import java.awt.Robot;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.IsoFields;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.SendKeys;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.Utils;

public class TS015_DeficitandSurplusLocationId_TC289o305 extends Keywords {

	@SuppressWarnings("deprecation")
	public void Scenario15(WebDriver driver, ExtentTest test, ExtentTest test1, String url, int dataset)
			throws Exception {

		String Username = Utils.getDataFromTestData("TS015_DeficitandSurplusLocationIdentification_Dataset" + dataset,
				"DeficitandSurplusLocationId", "Username");
		String Password = Utils.getDataFromTestData("TS015_DeficitandSurplusLocationIdentification_Dataset" + dataset,
				"DeficitandSurplusLocationId", "Password");
		String From_Week = Utils.getDataFromTestData("TS015_DeficitandSurplusLocationIdentification_Dataset" + dataset,
				"DeficitandSurplusLocationId", "From_Week");
		String To_Week = Utils.getDataFromTestData("TS015_DeficitandSurplusLocationIdentification_Dataset" + dataset,
				"DeficitandSurplusLocationId", "To_Week");
		String Toweek1 = Utils.getDataFromTestData("TS015_DeficitandSurplusLocationIdentification_Dataset" + dataset,
				"DeficitandSurplusLocationId", "Toweek1");
		String FromWeek1 = Utils.getDataFromTestData("TS015_DeficitandSurplusLocationIdentification_Dataset" + dataset,
				"DeficitandSurplusLocationId", "FromWeek1");
		String WeeklyImbalance_formula = Utils.getDataFromTestData(
				"TS015_DeficitandSurplusLocationIdentification_Dataset" + dataset, "DeficitandSurplusLocationId",
				"WeeklyImbalance_formula");

		String Budget_Flow_status = System.getProperty("user.dir") + "\\uploads\\Budget_Flow_status.xlsx";
		String EquimentType_Alphabets1 = System.getProperty("user.dir") + "\\uploads\\Budget_Flow_Applied.xlsx";

		Actions act = new Actions(driver);

		JavascriptExecutor js = (JavascriptExecutor) driver;

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

		Fluentwait(driver, Menu);
		click(driver, Menu);

		Fluentwait(driver, DeficitOption);
		click(driver, DeficitOption);

		wait(driver, "5");

		Extent_cal(test,
				"Testcase 289 - Ensure in Location,Equipment Type,Region,Country,Import,actual Export,export, export columns records displayed");

		Fluentwait(driver, Fromweek_input);
		click(driver, Fromweek_input);
		clear(driver, Fromweek_input);
		wait(driver, "2");
		sendKeys(driver, Fromweek_input, From_Week);

		Fluentwait(driver, Toweek_input);
		click(driver, Toweek_input);
		clear(driver, Toweek_input);
		wait(driver, "2");
		sendKeys(driver, Toweek_input, To_Week);

		Fluentwait(driver, Show);
		click(driver, Show);

		wait(driver, "2");

		if (isDisplayed(driver, Show_Popup_Yes)) {

			Fluentwait(driver, Show_Popup_Yes);
			click(driver, Show_Popup_Yes);
		}

		wait(driver, "3");

		Fluentwait(driver, Save);
		click(driver, Save);

		wait(driver, "2");

		Fluentwait(driver, Save_popup_ok);
		click(driver, Save_popup_ok);

		List<String> Gridfields = Arrays.asList("location", "eqp", "region", "country", "importCnt", "export");

		int size = Gridfields.size();

		for (int i = 0; i < size; i++) {

			String column = Gridfields.get(i);

			WebElement fieldpath = driver.findElement(By.xpath("(//div[@col-id='" + column + "'])[2]"));

			if (isDisplayed1(driver, fieldpath)) {

				System.out.println(column + " field values are showing in the grid");
				Extent_pass(driver, column + " field values are showing in the grid", test, test1);

			} else {

				System.out.println(column + " field values are not showing in the grid");
				Extent_fail(driver, column + " field values are not showing in the grid", test, test1);
			}

		}

		System.out.println("*************Testcase 289 Completed************************");

		Extent_cal(test, "Testcase 290 - Ensure in Imbalance column records displayed ");

		String Total_records = getText(driver, Total_record);

		int length = Integer.parseInt(Total_records);

		boolean imbalance = true;

		for (int i = 0; i < length; i++) {

//		wait(driver,"2");

			WebElement Importfield = driver
					.findElement(By.xpath("(//div[@row-id='" + i + "'])[2]//div[@col-id='importCnt']"));

			act.moveToElement(Importfield).build().perform();

			String Import = getTextofWebelement(driver, Importfield, "Importfield");

//			String Import = Importfield.getText();

			int importqty = Integer.parseInt(Import);

			WebElement Exportfield = driver
					.findElement(By.xpath("(//div[@row-id='" + i + "'])[2]//div[@col-id='export']"));

			String Export = getTextofWebelement(driver, Exportfield, "Exportfield");

			int exportqty = Integer.parseInt(Export);

			int Imbalanceqty = importqty - exportqty;

			String Expected_imbalance = String.valueOf(Imbalanceqty);

			System.out.println("Imbalanceqty : " + Imbalanceqty);

			WebElement imbalancefield = driver
					.findElement(By.xpath("(//div[@row-id='" + i + "'])[2]//div[@col-id='imbalance']"));

			imbalancefield.click();

			String Actualimbalance = getTextofWebelement(driver, imbalancefield, "imbalancefield");

			System.out.println("Actualimbalance : " + Actualimbalance);

			if (Actualimbalance.equals(Expected_imbalance)) {

				System.out.println(
						"Line number " + (i + 1) + " - Imbalance calculation was correct || Expected Imbalance was :"
								+ Expected_imbalance + " || Actual imbalance value was : " + Actualimbalance);
				Extent_pass(driver,
						"Line number " + (i + 1) + " - Imbalance calculation was correct || Expected Imbalance was :"
								+ Expected_imbalance + " || Actual imbalance value was : " + Actualimbalance,
						test, test1);
			} else {

				System.out.println("Line number " + (i + 1)
						+ " - Imbalance calculation was not correct || Expected Imbalance was :" + Expected_imbalance
						+ " || Actual imbalance value was : " + Actualimbalance);
				Extent_fail(driver,
						"Line number " + (i + 1)
								+ " - Imbalance calculation was not correct || Expected Imbalance was :"
								+ Expected_imbalance + " || Actual imbalance value was : " + Actualimbalance,
						test, test1);
				imbalance = false;

			}

		}

		if (imbalance) {
			System.out.println("Imbalance records are correctly calculated and displayed in the grid");
			Extent_pass(driver, "Imbalance records are correctly calculated and displayed in the grid", test, test1);
		} else {
			System.out.println("Imbalance records are not correctly calculated and displayed in the grid");
			Extent_fail(driver, "Imbalance records are not correctly calculated and displayed in the grid", test,
					test1);
		}

		System.out.println("*************Testcase 290 Completed************************");

		Extent_cal(test, "Testcase 291 - Ensure in Weeks column records displayed");

		String fromyear = getAttribute(driver, Fromyear_input, "value");

		String Toyear = getAttribute(driver, Toyear_input, "value");

		int startYear = Integer.parseInt(fromyear);
		int startWeek = Integer.parseInt(From_Week);
		int endYear = Integer.parseInt(Toyear);
		int endWeek = Integer.parseInt(To_Week);

		wait(driver, "5");

		boolean weeks = true;

		for (int i = 0; i < length; i++) {

			WebElement Weeksfield = driver
					.findElement(By.xpath("(//div[@row-id='" + i + "'])[2]//div[@col-id='weeks']"));

			act.moveToElement(Weeksfield).click().build().perform();

//			String AcutalWeeks = Weeksfield.getText();
			String AcutalWeeks = getTextofWebelement(driver, Weeksfield, "Weeksfield");

			// Convert week number and year to LocalDate
			// Convert week number and year to LocalDate
			LocalDate startDate = LocalDate.of(startYear, 1, 1)
					.with(WeekFields.of(Locale.getDefault()).weekOfYear(), startWeek)
					.with(WeekFields.of(Locale.getDefault()).dayOfWeek(), 1);

			// Get the start date for the endYear and endWeek
			LocalDate endDate = LocalDate.of(endYear, 1, 1)
					.with(WeekFields.of(Locale.getDefault()).weekOfYear(), endWeek)
					.with(WeekFields.of(Locale.getDefault()).dayOfWeek(), 1);

			// Calculate the number of weeks between the two dates, inclusive of both weeks
			long weeksBetween = ChronoUnit.WEEKS.between(startDate, endDate) + 1;

			// Output the result
			System.out.println("Number of in-between weeks: " + weeksBetween);

			String Expected_weeks = String.valueOf(weeksBetween);

			if (AcutalWeeks.equals(Expected_weeks)) {

				System.out.println("Line number " + (i + 1) + " - Weeks calculation was correct || Expected Weeks was :"
						+ Expected_weeks + " || Actual Weeks was : " + AcutalWeeks);
				Extent_pass(driver,
						"Line number " + (i + 1) + " - Weeks calculation was correct || Expected Weeks was :"
								+ Expected_weeks + " || Actual Weeks was : " + AcutalWeeks,
						test, test1);
			} else {

				System.out.println(
						"Line number " + (i + 1) + " - Weeks calculation was not correct || Expected Weeks was :"
								+ Expected_weeks + " || Actual Weeks was : " + AcutalWeeks);
				Extent_fail(driver,
						"Line number " + (i + 1) + " - Weeks calculation was not correct || Expected Weeks was :"
								+ Expected_weeks + " || Actual Weeks was : " + AcutalWeeks,
						test, test1);

				weeks = false;

			}

		}

		if (weeks) {
			System.out.println("Weeks calculated was correctly calculated, weeks columns are displayed in the grid");
			Extent_pass(driver, "Weeks calculated was correctly calculated, weeks columns are displayed in the grid",
					test, test1);
		} else {
			System.out
					.println("Weeks calculated was not correctly calculated, weeks columns are displayed in the grid");
			Extent_fail(driver,
					"Weeks calculated was not correctly calculated, weeks columns are displayed in the grid", test,
					test1);

		}

		System.out.println("*************Testcase 291 Completed************************");

		Extent_cal(test, "Testcase 292 - Ensure in Weekly imbalance column records displayed");

		boolean week_imb = true;

		for (int i = 0; i < length; i++) {

			wait(driver, "2");

			WebElement Imbalancefield = driver
					.findElement(By.xpath("(//div[@row-id='" + i + "'])[2]//div[@col-id='imbalance']"));

			act.moveToElement(Imbalancefield).build().perform();

//			String Imbalance = Imbalancefield.getText();
			String Imbalance = getTextofWebelement(driver, Imbalancefield, "Imbalancefield");

			int imbalanceqty = Integer.parseInt(Imbalance);

			WebElement Weeksfield = driver
					.findElement(By.xpath("(//div[@row-id='" + i + "'])[2]//div[@col-id='weeks']"));

			String AcutalWeeks = getTextofWebelement(driver, Weeksfield, "Weeksfield");
//			String AcutalWeeks = Weeksfield.getText();

			int weeks_length = Integer.parseInt(AcutalWeeks);

			int Weekly_imbalance = imbalanceqty / weeks_length;

			System.out.println("Weekly_imbalance : " + Weekly_imbalance);

			String Expected_Weekly_imbalance = String.valueOf(Weekly_imbalance);

			// Convert week number and year to LocalDate
			// Convert week number and year to LocalDate

			WebElement Weekly_imbalancefield = driver
					.findElement(By.xpath("(//div[@row-id='" + i + "'])[2]//div[@col-id='weeklyimbal']"));

			WebElementClick(driver, Weekly_imbalancefield, "Weekly_imbalancefield");

//			Weekly_imbalancefield.click();
			String actual_Weekly_imbalance = getTextofWebelement(driver, Weekly_imbalancefield,
					"Weekly_imbalancefield");
//			String actual_Weekly_imbalance = Weekly_imbalancefield.getText();

			if (actual_Weekly_imbalance.equals(Expected_Weekly_imbalance)) {

				System.out.println("Line number " + (i + 1)
						+ " - WeeklyImbalance calculation was correct || Expected WeeklyImbalance was :"
						+ Expected_Weekly_imbalance + " || Actual WeeklyImbalance was : " + actual_Weekly_imbalance);
				Extent_pass(driver, "Line number " + (i + 1)
						+ " - WeeklyImbalance calculation was correct || Expected WeeklyImbalance was :"
						+ Expected_Weekly_imbalance + " || Actual WeeklyImbalance was : " + actual_Weekly_imbalance,
						test, test1);
			} else {

				System.out.println("Line number " + (i + 1)
						+ " - WeeklyImbalance calculation was not correct || Expected WeeklyImbalance was :"
						+ Expected_Weekly_imbalance + " || Actual WeeklyImbalance was : " + actual_Weekly_imbalance);
				Extent_fail(driver, "Line number " + (i + 1)
						+ " - WeeklyImbalance calculation was not correct || Expected WeeklyImbalance was :"
						+ Expected_Weekly_imbalance + " || Actual WeeklyImbalance was : " + actual_Weekly_imbalance,
						test, test1);
				week_imb = false;
			}

		}

		if (week_imb) {

			System.out.println("Weekly imbalance was displayed in the grid and its calculated correctly");
			Extent_pass(driver, "Weekly imbalance was displayed in the grid and its calculated correctly", test, test1);
		} else {
			System.out.println("Weekly imbalance was displayed in the grid and its correctly calculated");
			Extent_fail(driver, "Weekly imbalance was displayed in the grid and its correctly calculated", test, test1);
		}

		System.out.println("*************Testcase 292 Completed************************");

		Extent_cal(test, "Testcase 293 - Ensure in Weekly imbalance label displayed in screen");

		if (isDisplayed(driver, WeeklyImbalance_label)) {

			String label = getText(driver, WeeklyImbalance_label);

			System.out.println("Weekly Imbalance label was displayed in the screen and the label was : " + label);
			Extent_pass(driver, "Weekly Imbalance label was displayed in the screen and the label was : " + label, test,
					test1);

			if (label.equals(WeeklyImbalance_formula)) {

				System.out.println("Note for weekly Imbalance calculation was correct ");
				Extent_pass(driver, "Note for weekly Imbalance calculation was correct ", test, test1);
			} else {
				System.out.println("Note for weekly Imbalance calculation was not correct - " + label);
				Extent_pass(driver, "Note for weekly Imbalance calculation was not correct - " + label, test, test1);
			}

		} else {

			System.out.println("Weekly Imbalance label was not displayed in the screen");
			Extent_pass(driver, "Weekly Imbalance label was not displayed in the screen", test, test1);
		}

		System.out.println("*************Testcase 293 Completed************************");

		Extent_cal(test, "Testcase 294 - Ensure in Bench mark stock column records displayed ");

		scrollBottom(driver);

		Fluentwait(driver, Cancel);
		click(driver, Cancel);
		wait(driver, "2");

		Fluentwait(driver, New);
		click(driver, New);

		Fluentwait(driver, New_Popup_Yes);
		click(driver, New_Popup_Yes);
		wait(driver, "2");

		Fluentwait(driver, Year_Drop_Down);
		click(driver, Year_Drop_Down);

		Fluentwait(driver, Fromweek_input);
		clear(driver, Fromweek_input);
		sendKeys(driver, Fromweek_input, FromWeek1);
		wait(driver, "2");

		Fluentwait(driver, Year_To_Drop_Down);
		click(driver, Year_To_Drop_Down);

		wait(driver, "2");
		Fluentwait(driver, Toweek_input);
		clear(driver, Toweek_input);
		sendKeys(driver, Toweek_input, Toweek1);

		Fluentwait(driver, Show);
		click(driver, Show);
		wait(driver, "2");

		if (isDisplayed(driver, show_yes)) {

			Fluentwait(driver, show_yes);
			click(driver, show_yes);
			wait(driver, "2");
		}
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

			wait(driver, "3");
			Fluentwait(driver, ERO_Save);
			click(driver, ERO_Save);
			Fluentwait(driver, ERO_Save_ok);
			click(driver, ERO_Save_ok);
			wait(driver, "2");

		} else {
			System.out.println("popup not shown");
		}

		wait(driver, "2");

//		wait(driver, "3");
		Fluentwait(driver, Searchbox);
		sendKeys(driver, Searchbox, "Ero Bench Mark Stock");

//		wait(driver, "2");
		Fluentwait(driver, Benchmmark_stock);
		click(driver, Benchmmark_stock);

//		WebElement benchstock = driver.findElement(By.xpath("(//div[@col-id='location' and text()='CNQDG']//following::div[@col-id='su'])[1]"));
//
//		String stockvalue = getTextofWebelement(driver, benchstock, "benchstock");

//		System.out.println("stockvalue : " + stockvalue);

		wait(driver, "3");

		Fluentwait(driver, Deficittab);
		click(driver, Deficittab);

		// Scroll to the specified coordinates (x, y)
		int scrollAmount5 = 1000; // Replace with the amount you want to scroll

		WebElement scroller6 = driver.findElement(By.xpath("//div[@ref='eBodyHorizontalScrollViewport']"));

		waitForWebElement(driver, scroller6, "scroller2");

//		wait(driver, "3");

		String totalbench = getText(driver, Total_record);

		int benchstock_count = Integer.parseInt(totalbench);

		boolean benchmark = true;

		for (int i = 0; i < benchstock_count; i++) {

			HorizontalScrollFull(driver, Horizontal_gridscroll);

			WebElement Locationfield = driver
					.findElement(By.xpath("(//div[@row-id='" + i + "'])[2]//div[@col-id='location']"));

			waitForWebElement(driver, Locationfield, "Locationfield");

			act.moveToElement(Locationfield).build().perform();

//			String locations = Locationfield.getText();

			String locations = getTextofWebelement(driver, Locationfield, "Locationfield");

			WebElement eqpfield = driver.findElement(By.xpath("(//div[@row-id='" + i + "'])[2]//div[@col-id='eqp']"));

			act.moveToElement(eqpfield).build().perform();

			String eqptype = eqpfield.getText();

			if (locations.isEmpty()) {

				// Scroll to the specified coordinates (x, y)
				js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller6, scrollAmount5);

//				wait(driver, "3");

				WebElement Stockstatusfield = driver
						.findElement(By.xpath("(//div[@row-id='" + i + "'])[2]//div[@col-id='stock']"));

				String Stockstatus_value = Stockstatusfield.getText();

				if (Stockstatus_value.equals("0")) {

					System.out
							.println("Matched ||  Location name was :" + locations + "  || Expected stock status was : "
									+ "0" + " || Acutal stock status was : " + Stockstatus_value);
					Extent_pass(driver,
							"Matched ||  Location name was :" + locations + "  || Expected stock status was : " + "0"
									+ " || Acutal stock status was : " + Stockstatus_value,
							test, test1);
				} else {
					System.out.println(
							"Not Matched ||  Location name was :" + locations + "  || Expected stock status was : "
									+ "0" + " || Acutal stock status was : " + Stockstatus_value);
					Extent_fail(driver,
							"Not Matched ||  Location name was :" + locations + "  || Expected stock status was : "
									+ "0" + " || Acutal stock status was : " + Stockstatus_value,
							test, test1);

					benchmark = false;
				}

			} else {

//				wait(driver, "2");

				scrollBottom(driver);

//				wait(driver, "2");

				waitForElement(driver, Benchmark_Stock_status);
				click(driver, Benchmark_Stock_status);

				Fluentwait(driver, benchStockstatusLocation_filter);
				click(driver, benchStockstatusLocation_filter);

				if (isDisplayed(driver, Filter_input)) {

					System.out.println("Filter column already selected");

				} else {

					Fluentwait(driver, Locationcode_filtercolumn);
					click(driver, Locationcode_filtercolumn);
				}

				Fluentwait(driver, Filter_input);
				clear(driver, Filter_input);
				sendKeys(driver, Filter_input, locations);

//				wait(driver, "2");

				if (isDisplayed(driver, Nomatches)) {

					waitForElement(driver, Deficittab);
					click(driver, Deficittab);

//					wait(driver, "2");

					js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller6, scrollAmount5);

//					wait(driver, "3");

					WebElement Stockstatusfield = driver
							.findElement(By.xpath("(//div[@row-id='" + i + "'])[2]//div[@col-id='su']"));

					String Stockstatus_value2 = Stockstatusfield.getText();

					if (Stockstatus_value2.equals("0")) {

						System.out.println(
								"Matched ||  Location name was : " + locations + " || Expected bench mark stock was : "
										+ "0" + " || Acutal bench mark stock was : " + Stockstatus_value2);
						Extent_pass(driver,
								"Matched ||  Location name was : " + locations + " || Expected bench mark stock was : "
										+ "0" + " || Acutal bench mark stock was : " + Stockstatus_value2,
								test, test1);
					} else {
						System.out.println("Not Matched ||  Location name was : " + locations
								+ " || Expected bench mark stock was : " + "0" + " || Acutal stock status was : "
								+ Stockstatus_value2);
						Extent_fail(driver,
								"Not Matched ||  Location name was : " + locations
										+ " || Expected bench mark stock was : " + "0"
										+ " || Acutal bench mark stock was : " + Stockstatus_value2,
								test, test1);
						benchmark = false;
					}

				} else {

					enter(driver);

//					wait(driver, "2");

					try {

						WebElement Expected_StockStatusfield = driver
								.findElement(By.xpath("//div[@col-id='equpmentType' and text()='" + eqptype
										+ "']/following::div[@col-id='quantity']"));

						waitForWebElement(driver, Expected_StockStatusfield, "Expected_StockStatusfield");

						String Expected_StockStatus = getTextofWebelement(driver, Expected_StockStatusfield,
								"Expected_StockStatusfield");

						System.out.println("Expected_StockStatus : " + Expected_StockStatus);

						Fluentwait(driver, Filter_input);
						clear(driver, Filter_input);

						Fluentwait(driver, Filter_input);
						sendKeys(driver, Filter_input, "a");

						wait(driver, "1");

						Fluentwait(driver, Filter_input);
						clear(driver, Filter_input);

						wait(driver, "1");

						wait(driver, "5");

						Fluentwait(driver, Selectall);
						click(driver, Selectall);

//						wait(driver, "2");

						waitForElement(driver, Deficittab);
						click(driver, Deficittab);

						js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller6, scrollAmount5);

//						wait(driver, "3");

						WebElement Stockstatusfield = driver
								.findElement(By.xpath("(//div[@row-id='" + i + "'])[2]//div[@col-id='su']"));

						String Stockstatus_value3 = Stockstatusfield.getText();

						if (Stockstatus_value3.equals(Expected_StockStatus)) {

							System.out.println("Matched ||  Location name was : " + locations
									+ "  || Expected bench mark stock was : " + Expected_StockStatus
									+ " || Acutal bench mark stock was : " + Stockstatus_value3);
							Extent_pass(driver,
									"Matched ||  Location name was : " + locations
											+ "  || Expected bench mark stock was : " + Expected_StockStatus
											+ " || Acutal bench mark stock was : " + Stockstatus_value3,
									test, test1);
						} else {
							System.out.println("Not Matched ||  Location name was : " + locations
									+ "  || Expected bench mark stock was : " + Expected_StockStatus
									+ " || Acutal bench mark stock was : " + Stockstatus_value3);
							Extent_fail(driver,
									"Not Matched ||  Location name was : " + locations
											+ "  || Expected bench mark stock was : " + Expected_StockStatus
											+ " || Acutal bench mark stock was : " + Stockstatus_value3,
									test, test1);

							benchmark = false;
						}

					} catch (Exception e) {
						// TODO: handle exception

						if (isDisplayed(driver, Filter_input)) {

							Fluentwait(driver, Filter_input);
							clear(driver, Filter_input);

							Fluentwait(driver, Filter_input);
							sendKeys(driver, Filter_input, "a");

							wait(driver, "1");

							Fluentwait(driver, Filter_input);
							clear(driver, Filter_input);

							wait(driver, "1");

							Fluentwait(driver, Selectall);
							click(driver, Selectall);

//							wait(driver, "2");

							waitForElement(driver, Deficittab);
							click(driver, Deficittab);

						}

						js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller6, scrollAmount5);

//						wait(driver, "3");

						WebElement Stockstatusfield = driver
								.findElement(By.xpath("(//div[@row-id='" + i + "'])[2]//div[@col-id='su']"));

						String Stockstatus3 = Stockstatusfield.getText();

						if (Stockstatus3.equals("0")) {

							System.out.println("Matched ||  Location name was : " + locations
									+ "  || Expected bench mark stock was : " + "0"
									+ " || Acutal bench mark stock was : " + Stockstatus3);
							Extent_pass(driver,
									"Matched ||  Location name was : " + locations
											+ "  || Expected bench mark stock was : " + "0"
											+ " || Acutal bench mark stock was : " + Stockstatus3,
									test, test1);
						} else {
							System.out.println("Not Matched ||  Location name was : " + locations
									+ "  || Expected bench mark stock was : " + "0"
									+ " || Acutal bench mark stock was : " + Stockstatus3);
							Extent_fail(driver,
									"Not Matched ||  Location name was : " + locations
											+ "  || Expected bench mark stock was : " + "0"
											+ " || Acutal bench mark stock was : " + Stockstatus3,
									test, test1);

							benchmark = false;
						}

					}

				}

			}

		}

		if (benchmark) {
			System.out.println("Bench mark stock column was displayed correctly");
			Extent_pass(driver, "Bench mark stock column was displayed correctly", test, test1);
		} else {
			System.out.println("Bench mark stock column was not displayed correctly");
			Extent_fail(driver, "Bench mark stock column was not displayed correctly", test, test1);
		}

		System.out.println("Testcase 294 Completed");

		Extent_cal(test, "Testcase 295 - Ensure in Applied Surplus/Deficit column records displayed ");

		if (isDisplayed(driver, Appliedsurplus)) {

			System.out.println("Applied surplus/deficit column values are displayed in the grid");
			Extent_pass(driver, "Applied surplus/deficit column values are displayed in the grid", test, test1);

		} else {

			System.out.println("Applied surplus/deficit column values are displayed in the grid");
			Extent_fail(driver, "Applied surplus/deficit column values are displayed in the grid", test, test1);
		}

//		HorizontalScrollFull(driver, Horizontal_gridscroll);

		WebElement dropdown = driver.findElement(By.xpath("(//div[@ref='eBodyViewport'])[1]"));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollTop = 0;", dropdown);

		for (int i = 0; i < length; i++) {

			WebElement element = driver
					.findElement(By.xpath("(//div[@row-id='" + i + "'])[2]//div[@col-id='appsurdef']"));

			element.click();

			String num = generateUniqueString();

			act.moveToElement(element).doubleClick().build().perform();

			act.moveToElement(element).click().keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
					.sendKeys(Keys.BACK_SPACE).build().perform();

			act.moveToElement(element).sendKeys(num).build().perform();

			enter(driver);

			String changedvalue = getText(driver, Appliedsurplus);

			System.out.println("changedvalue : " + changedvalue);

		}

		System.out.println("*************Testcase 295 Completed************************");

		Extent_cal(test, "Testcase 296 - Ensure in Calculated surplus/deficit column records displayed");

		for (int i = 0; i < length; i++) {

			wait(driver, "2");

			WebElement Imbalancefield = driver
					.findElement(By.xpath("(//div[@row-id='" + i + "'])[2]//div[@col-id='imbalance']"));

			act.moveToElement(Imbalancefield).build().perform();

			String Imbalance = getTextofWebelement(driver, Imbalancefield, "Imbalancefield");
//			String Imbalance = Imbalancefield.getText();

			int imbalanceqty = Integer.parseInt(Imbalance);

			WebElement appsurdeffield = driver
					.findElement(By.xpath("(//div[@row-id='" + i + "'])[2]//div[@col-id='appsurdef']"));

			String appsurdef = getTextofWebelement(driver, appsurdeffield, "appsurdeffield");
//			String appsurdef = appsurdeffield.getText();

			int appsurdefqty = Integer.parseInt(appsurdef);

			int CalculatedSurplus = imbalanceqty + appsurdefqty;

			String Expected_CalculatedSurplus = String.valueOf(CalculatedSurplus);

			System.out.println("Expected_CalculatedSurplus : " + Expected_CalculatedSurplus);

			WebElement calsurdeffield = driver
					.findElement(By.xpath("(//div[@row-id='" + i + "'])[2]//div[@col-id='calsurdef']"));

			WebElementClick(driver, calsurdeffield, "calsurdeffield");

//			calsurdeffield.click();
			String Actualcalsurdef = getTextofWebelement(driver, calsurdeffield, "calsurdeffield");
//			String Actualcalsurdef = calsurdeffield.getText();

			System.out.println("Actualimbalance : " + Actualcalsurdef);

			if (Actualcalsurdef.equals(Expected_CalculatedSurplus)) {

				System.out.println(
						"Line number " + (i + 1) + " - calsurdef calculation was correct || Expected calsurdef was :"
								+ Expected_CalculatedSurplus + " || Actual calsurdef value was : " + Actualcalsurdef);
				Extent_pass(driver,
						"Line number " + (i + 1) + " - calsurdef calculation was correct || Expected calsurdef was :"
								+ Expected_CalculatedSurplus + " || Actual calsurdef value was : " + Actualcalsurdef,
						test, test1);
			} else {

				System.out.println("Line number " + (i + 1)
						+ " - calsurdef calculation was not correct || Expected calsurdef was :"
						+ Expected_CalculatedSurplus + " || Actual calsurdef value was : " + Actualcalsurdef);
				Extent_fail(driver,
						"Line number " + (i + 1)
								+ " - calsurdef calculation was not correct || Expected calsurdef was :"
								+ Expected_CalculatedSurplus + " || Actual calsurdef value was : " + Actualcalsurdef,
						test, test1);

			}

		}

		System.out.println("*************Testcase 296 Completed************************");

		Extent_cal(test, "Testcase 297 - Ensure in status column records displayed");

		WebElement scroller = driver.findElement(By.xpath("//div[@ref='eBodyHorizontalScrollViewport']"));

		int scrollAmount1 = 1000;

		js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller, scrollAmount1);

		for (int i = 0; i < length; i++) {

			wait(driver, "2");

			WebElement calsurdeffield = driver
					.findElement(By.xpath("(//div[@row-id='" + i + "'])[2]//div[@col-id='calsurdef']"));

			act.moveToElement(calsurdeffield).build().perform();

			String calsurdef = getTextofWebelement(driver, calsurdeffield, "calsurdeffield");
//			String calsurdef = calsurdeffield.getText();

			System.out.println("Actualimbalance : " + calsurdef);

			double value;

			try {
				value = Double.parseDouble(calsurdef);
			} catch (NumberFormatException e) {
				System.out.println("The value is not a valid number: " + calsurdef);
				Extent_fail(driver, e.getLocalizedMessage(), test, test1);
				return;
			}

			WebElement Statusfield = driver
					.findElement(By.xpath("(//div[@row-id='" + i + "'])[2]//div[@col-id='defsurstatusflag']"));

			WebElementClick(driver, Statusfield, "Statusfield");

//			Statusfield.click();
			String Status = getTextofWebelement(driver, Statusfield, "Statusfield");
//			String Status = Statusfield.getText();

			System.out.println("Actualimbalance : " + Status);

			// Check if the value is positive, negative, or zero
			if (value > 0) {

				if (Status.equals("Surplus")) {

					System.out.println("Line number " + (i + 1) + " - Matched || Expected status was : " + "Surplus"
							+ " || Actual statu was " + Status);
					Extent_pass(driver, "Line number " + (i + 1) + " - Matched || Expected status was : " + "Surplus"
							+ " || Actual statu was " + Status, test, test1);

				} else {
					System.out.println("Line number " + (i + 1) + " - Not Matched || Expected status was : " + "Surplus"
							+ " || Actual statu was " + Status);
					Extent_fail(driver, "Line number " + (i + 1) + " - Not Matched || Expected status was : "
							+ "Surplus" + " || Actual statu was " + Status, test, test1);
				}

			} else if (value < 0) {

				if (Status.equals("Deficit")) {

					System.out.println("Line number " + (i + 1) + " - Matched || Expected status was : " + "Deficit"
							+ " || Actual statu was " + Status);
					Extent_pass(driver, "Line number " + (i + 1) + " - Matched || Expected status was : " + "Deficit"
							+ " || Actual statu was " + Status, test, test1);

				} else {
					System.out.println("Line number " + (i + 1) + " - Not Matched || Expected status was : " + "Deficit"
							+ " || Actual statu was " + Status);
					Extent_fail(driver, "Line number " + (i + 1) + " - Not Matched || Expected status was : "
							+ "Deficit" + " || Actual statu was " + Status, test, test1);
				}

			} else {

				if (Status.equals("Neutral")) {

					System.out.println("Line number " + (i + 1) + " - Matched || Expected status was : " + "Neutral"
							+ " || Actual statu was " + Status);
					Extent_pass(driver, "Line number " + (i + 1) + " - Matched || Expected status was : " + "Neutral"
							+ " || Actual statu was " + Status, test, test1);

				} else {
					System.out.println("Line number " + (i + 1) + " - Not Matched || Expected status was : " + "Neutral"
							+ " || Actual statu was " + Status);
					Extent_fail(driver, "Line number " + (i + 1) + " - Not Matched || Expected status was : "
							+ "Neutral" + " || Actual statu was " + Status, test, test1);
				}

			}

		}

		System.out.println("*************Testcase 297 Completed************************");

		Extent_cal(test, "Testcase 303 -Ensure in Stock Status column records displayed");

		scrollBottom(driver);

		Fluentwait(driver, Cancel);
		click(driver, Cancel);
		wait(driver, "2");

		Fluentwait(driver, New);
		click(driver, New);

		Fluentwait(driver, New_Popup_Yes);
		click(driver, New_Popup_Yes);
		wait(driver, "2");

		Fluentwait(driver, Year_Drop_Down);
		click(driver, Year_Drop_Down);

		Fluentwait(driver, Fromweek_input);
		clear(driver, Fromweek_input);
		sendKeys(driver, Fromweek_input, FromWeek1);
		wait(driver, "2");

		Fluentwait(driver, Year_To_Drop_Down);
		click(driver, Year_To_Drop_Down);

		wait(driver, "2");
		Fluentwait(driver, Toweek_input);
		clear(driver, Toweek_input);
		sendKeys(driver, Toweek_input, Toweek1);

		Fluentwait(driver, Show);
		click(driver, Show);
		wait(driver, "2");

		if (isDisplayed(driver, show_yes)) {

			Fluentwait(driver, show_yes);
			click(driver, show_yes);
			wait(driver, "2");
		}
		wait(driver, "5");

		if (isDisplayed(driver, Warning_popup)) {
			System.out.println("popup shown");

			Fluentwait(driver, click_yes);
			click(driver, click_yes);

			Fluentwait(driver, Click_ok);
			click(driver, Click_ok);

//				Fluentwait(driver, Cancel);
//				click(driver, Cancel);
//
//				wait(driver, "2");
//				Fluentwait(driver, New);
//				click(driver, New);
//
//				Fluentwait(driver, New_Popup_Yes);
//				click(driver, New_Popup_Yes);
//				wait(driver, "2");
//				
//				Fluentwait(driver, dropdown_option);
//				click(driver, dropdown_option);
//				
//				Fluentwait(driver, Budget_Reposition);
//				click(driver, Budget_Reposition);
//				
//				Fluentwait(driver, Budget);
//				click(driver, Budget);
//				
//				wait(driver,"4");
//				
//				uploadFileRobot(driver,EquimentType_Alphabets1);
//				
//				wait(driver,"3");
//				Fluentwait(driver, ERO_Save);
//				click(driver, ERO_Save);
//				Fluentwait(driver, ERO_Save_ok);
//				click(driver, ERO_Save_ok);
//				wait(driver,"2");

		} else {
			System.out.println("popup not shown");
		}

		Fluentwait(driver, Save);
		click(driver, Save);

		Fluentwait(driver, Save_popup_ok);
		click(driver, Save_popup_ok);
		wait(driver, "2");

		Fluentwait(driver, Menu);
		click(driver, Menu);

		Fluentwait(driver, Stockstatustab);
		click(driver, Stockstatustab);

		wait(driver, "3");

		Fluentwait(driver, Deficittab);
		click(driver, Deficittab);

		wait(driver, "3");

		// Scroll to the specified coordinates (x, y)
		int scrollAmount = 1800; // Replace with the amount you want to scroll

		wait(driver, "3");

		String Total_records5 = getText(driver, Total_record);

		int length5 = Integer.parseInt(Total_records5);

		for (int i = 0; i < length5; i++) {

			HorizontalScrollFull(driver, Horizontal_gridscroll);

			wait(driver, "5");

			WebElement Locationfield = driver
					.findElement(By.xpath("(//div[@row-id='" + i + "'])[2]//div[@col-id='location']"));

			act.moveToElement(Locationfield).build().perform();

			String locations = getTextofWebelement(driver, Locationfield, "Locationfield");
//			String locations = Locationfield.getText();

			WebElement eqpfield = driver.findElement(By.xpath("(//div[@row-id='" + i + "'])[2]//div[@col-id='eqp']"));

			act.moveToElement(eqpfield).build().perform();

			String eqptype = getTextofWebelement(driver, eqpfield, "eqpfield");
//			String eqptype = eqpfield.getText();

			WebElement scroller2 = driver.findElement(By.xpath("//div[@ref='eBodyHorizontalScrollViewport']"));

			int scrollAmount2 = 1000;

			js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller2, scrollAmount2);

			if (locations.isEmpty()) {

				// Scroll to the specified coordinates (x, y)
				js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller2, scrollAmount);

				wait(driver, "3");

				WebElement Stockstatusfield = driver
						.findElement(By.xpath("(//div[@row-id='" + i + "'])[2]//div[@col-id='stock']"));

				String Stockstatus = getTextofWebelement(driver, Stockstatusfield, "Stockstatusfield");

				if (Stockstatus.equals("0")) {

					System.out
							.println("Matched ||  Location name was :" + locations + "  || Expected stock status was : "
									+ "0" + " || Acutal stock status was : " + Stockstatus);
					Extent_pass(driver,
							"Matched ||  Location name was :" + locations + "  || Expected stock status was : " + "0"
									+ " || Acutal stock status was : " + Stockstatus,
							test, test1);
				} else {
					System.out.println(
							"Not Matched ||  Location name was :" + locations + "  || Expected stock status was : "
									+ "0" + " || Acutal stock status was : " + Stockstatus);
					Extent_fail(driver,
							"Not Matched ||  Location name was :" + locations + "  || Expected stock status was : "
									+ "0" + " || Acutal stock status was : " + Stockstatus,
							test, test1);
				}

			} else {

				wait(driver, "3");

				scrollBottom(driver);

				wait(driver, "5");

				waitForElement(driver, Location_stockstatus);
				click(driver, Location_stockstatus);

				wait(driver, "3");

				Fluentwait(driver, Locationcode_filter);
				click(driver, Locationcode_filter);

				if (isDisplayed(driver, Filter_input)) {

					System.out.println("Filter column already selected");

				} else {

					Fluentwait(driver, Locationcode_filtercolumn);
					click(driver, Locationcode_filtercolumn);
				}

				Fluentwait(driver, Filter_input);
				clear(driver, Filter_input);
				sendKeys(driver, Filter_input, locations);

				wait(driver, "3");

				if (isDisplayed(driver, Nomatches)) {

					wait(driver, "2");

					waitForElement(driver, Deficittab);
					click(driver, Deficittab);

					js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller2, scrollAmount);

					wait(driver, "3");

					WebElement Stockstatusfield = driver
							.findElement(By.xpath("(//div[@row-id='" + i + "'])[2]//div[@col-id='stock']"));

					String Stockstatus = getTextofWebelement(driver, Stockstatusfield, "Stockstatusfield");
//					String Stockstatus = Stockstatusfield.getText();

					if (Stockstatus.equals("0")) {

						System.out.println(
								"Matched ||  Location name was : " + locations + " || Expected stock status was : "
										+ "0" + " || Acutal stock status was : " + Stockstatus);
						Extent_pass(driver,
								"Matched ||  Location name was : " + locations + " || Expected stock status was : "
										+ "0" + " || Acutal stock status was : " + Stockstatus,
								test, test1);
					} else {
						System.out.println(
								"Not Matched ||  Location name was : " + locations + " || Expected stock status was : "
										+ "0" + " || Acutal stock status was : " + Stockstatus);
						Extent_fail(driver,
								"Not Matched ||  Location name was : " + locations + " || Expected stock status was : "
										+ "0" + " || Acutal stock status was : " + Stockstatus,
								test, test1);
					}

					wait(driver, "2");

				} else {

					enter(driver);

					wait(driver, "3");

					try {

						WebElement Expected_StockStatusfield = driver
								.findElement(By.xpath("//div[@col-id='equipmenttype' and text()='" + eqptype
										+ "']/following::div[@col-id='stockstatus']"));

						waitForWebElement(driver, Expected_StockStatusfield, "Expected_StockStatusfield");

						// Locate all elements matching the given XPath
						List<WebElement> elements = driver
								.findElements(By.xpath("//div[@col-id='equipmenttype' and text()='" + eqptype
										+ "']/following-sibling::div[@col-id='stockstatus']"));

						// Initialize the sum variable
						int sum = 0;

						// Loop through the elements and add the integer values
						for (WebElement element : elements) {
							// Get the text value, trim any spaces, and convert it to an integer
							int value = Integer.parseInt(element.getText().trim());

							// Add the value to the sum
							sum += value;
						}

						// Print the sum
						System.out.println("The sum of the values is: " + sum);

						String Expected_StockStatus = String.valueOf(sum);

//						String Expected_StockStatus = getTextofWebelement(driver, Expected_StockStatusfield,
//								"Expected_StockStatusfield");

						System.out.println("Expected_StockStatus : " + Expected_StockStatus);

						Fluentwait(driver, Filter_input);
						clear(driver, Filter_input);

						wait(driver, "2");

						Fluentwait(driver, Selectall);
						click(driver, Selectall);

						waitForElement(driver, Deficittab);
						click(driver, Deficittab);

						js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller2, scrollAmount);

						wait(driver, "2");

						WebElement Stockstatusfield = driver
								.findElement(By.xpath("(//div[@row-id='" + i + "'])[2]//div[@col-id='stock']"));

						waitForWebElement(driver, Stockstatusfield, "Stockstatusfield");

						String Stockstatus = Stockstatusfield.getText();

						if (Stockstatus.equals(Expected_StockStatus)) {

							System.out.println(
									"Matched ||  Location name was : " + locations + "  || Expected stock status was : "
											+ Expected_StockStatus + " || Acutal stock status was : " + Stockstatus);
							Extent_pass(driver,
									"Matched ||  Location name was : " + locations + "  || Expected stock status was : "
											+ Expected_StockStatus + " || Acutal stock status was : " + Stockstatus,
									test, test1);
						} else {
							System.out.println("Not Matched ||  Location name was : " + locations
									+ "  || Expected stock status was : " + Expected_StockStatus
									+ " || Acutal stock status was : " + Stockstatus);
							Extent_fail(driver,
									"Not Matched ||  Location name was : " + locations
											+ "  || Expected stock status was : " + Expected_StockStatus
											+ " || Acutal stock status was : " + Stockstatus,
									test, test1);
						}

					} catch (Exception e) {
						// TODO: handle exception

						wait(driver, "3");

						if (isDisplayed(driver, Filter_input)) {

							Fluentwait(driver, Filter_input);
							clear(driver, Filter_input);

							wait(driver, "2");

							Fluentwait(driver, Selectall);
							click(driver, Selectall);

							waitForElement(driver, Deficittab);
							click(driver, Deficittab);

						}

						js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller2, scrollAmount);

						wait(driver, "3");

						WebElement Stockstatusfield = driver
								.findElement(By.xpath("(//div[@row-id='" + i + "'])[2]//div[@col-id='stock']"));

						String Stockstatus = getTextofWebelement(driver, Stockstatusfield, "Stockstatusfield");

						if (Stockstatus.equals("0")) {

							System.out.println(
									"Matched ||  Location name was : " + locations + "  || Expected stock status was : "
											+ "0" + " || Acutal stock status was : " + Stockstatus);
							Extent_pass(driver,
									"Matched ||  Location name was : " + locations + "  || Expected stock status was : "
											+ "0" + " || Acutal stock status was : " + Stockstatus,
									test, test1);
						} else {
							System.out.println("Not Matched ||  Location name was : " + locations
									+ "  || Expected stock status was : " + "0" + " || Acutal stock status was : "
									+ Stockstatus);
							Extent_fail(driver,
									"Not Matched ||  Location name was : " + locations
											+ "  || Expected stock status was : " + "0"
											+ " || Acutal stock status was : " + Stockstatus,
									test, test1);
						}

					}

				}

			}

		}

		System.out.println("********************Testcase 303 Completed**************************");

		Extent_cal(test,
				"Testcase 305 - Ensure in Import from excel sheet upload the records  Location,Equipment type,Region,Country,Import,Export,Applied Surplus/Deficit,Sub Lease Qty,One way Qty,New Production Container,Long Term Storage,Stock Status Functionality ");

		Fluentwait(driver, Cancel);
		click(driver, Cancel);
		wait(driver, "2");

		Fluentwait(driver, New);
		click(driver, New);

		Fluentwait(driver, New_Popup_Yes);
		click(driver, New_Popup_Yes);

		wait(driver, "3");
		Fluentwait(driver, dropdown_option);
		click(driver, dropdown_option);

		Fluentwait(driver, Budget_Reposition);
		click(driver, Budget_Reposition);

		Fluentwait(driver, Budget);
		click(driver, Budget);
		wait(driver, "2");

//		uploadFileRobot(driver,Budget_Flow_status);

		String upload_Budget_Flow_status = System.getProperty("user.dir") + "/driver/MasterDownloadfile.exe "
				+ Budget_Flow_status;

		try {
			Runtime.getRuntime().exec(upload_Budget_Flow_status);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getLocalizedMessage());
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
		}

		wait(driver, "25");

		if (isDisplayed(driver, click_yes)) {

			click(driver, click_yes);

			Fluentwait(driver, Click_ok);
			click(driver, Click_ok);
		}

		Fluentwait(driver, Location3);

		wait(driver, "5");

		String Total_records3 = getText(driver, Total_record);

		int length3 = Integer.parseInt(Total_records3);

		List<String> ems_columnnames = Arrays.asList("location", "eqp", "region", "country", "importCnt", "export",
				"imbalance", "weeks", "weeklyimbal", "su", "appsurdef", "calsurdef", "defsurstatusflag", "stock",
				"onewayoutload", "onewayoutreturn", "onewaylease", "tboh", "sali");

		int ems_size = ems_columnnames.size();

		boolean records = true;

		for (int i = 0; i < ems_size; i++) {

			String columnname = ems_columnnames.get(i);

			wait(driver, "3");
			WebElement columns = driver.findElement(By.xpath("(//div[@col-id='" + columnname + "'])[4]"));

			act.moveToElement(columns).build().perform();

			if (isDisplayed1(driver, columns)) {

				System.out.println("After import the excel file, Records of the " + columnname
						+ " for ems reposition was displayed");
				Extent_pass(driver, "After import the excel file, Records of the " + columnname
						+ "  for ems reposition was displayed", test, test1);
			} else {

				System.out.println("After import the excel file, Records of the " + columnname
						+ "  for ems reposition was not displayed");
				Extent_fail(driver, "After import the excel file, Records of the " + columnname
						+ "  for ems reposition was not displayed", test, test1);
				records = false;
			}

		}

		if (records) {

			System.out.println(
					"After import the excel, Location,Equipment type,Region,Country,Import,Export,Applied Surplus/Deficit,Sub Lease Qty,One way Qty,New Production Container,Long Term Storage,Stock Status column values are displayed");
			Extent_pass1(test,
					"After import the excel, Location,Equipment type,Region,Country,Import,Export,Applied Surplus/Deficit,Sub Lease Qty,One way Qty,New Production Container,Long Term Storage,Stock Status column values are displayed");

		} else {

			System.out.println(
					"After import the excel, Location,Equipment type,Region,Country,Import,Export,Applied Surplus/Deficit,Sub Lease Qty,One way Qty,New Production Container,Long Term Storage,Stock Status column values are not displayed");
			Extent_fail(driver,
					"After import the excel, Location,Equipment type,Region,Country,Import,Export,Applied Surplus/Deficit,Sub Lease Qty,One way Qty,New Production Container,Long Term Storage,Stock Status column values are not displayed",
					test, test1);
		}

		WebElement scroller2 = driver.findElement(By.xpath("//div[@ref='eBodyHorizontalScrollViewport']"));

		int scrollAmount2 = 1000;

		js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller2, scrollAmount2);

		boolean status = true;

		for (int i = 0; i < length3; i++) {

			WebElement calsurdeffield = driver
					.findElement(By.xpath("(//div[@row-id='" + i + "'])[2]//div[@col-id='calsurdef']"));

			act.moveToElement(calsurdeffield).build().perform();

			String calsurdef = getTextofWebelement(driver, calsurdeffield, "calsurdeffield");
//			String calsurdef = calsurdeffield.getText();

			System.out.println("Actualimbalance : " + calsurdef);

			double value;

			try {
				value = Double.parseDouble(calsurdef);
			} catch (NumberFormatException e) {
				System.out.println("The value is not a valid number: " + calsurdef);
				Extent_fail(driver, e.getLocalizedMessage(), test, test1);
				return;
			}

			WebElement Statusfield = driver
					.findElement(By.xpath("(//div[@row-id='" + i + "'])[2]//div[@col-id='defsurstatusflag']"));

			WebElementClick(driver, Statusfield, "Statusfield");
//			Statusfield.click();

//			String Status = Statusfield.getText();
			String Status = getTextofWebelement(driver, Statusfield, "Statusfield");

			System.out.println("Actualimbalance : " + Status);

			// Check if the value is positive, negative, or zero
			if (value > 0) {

				if (Status.equals("Surplus")) {

					System.out.println("Line number " + (i + 1) + " - Matched || Expected status was : " + "Surplus"
							+ " || Actual statu was " + Status);
					Extent_pass(driver, "Line number " + (i + 1) + " - Matched || Expected status was : " + "Surplus"
							+ " || Actual statu was " + Status, test, test1);

				} else {
					System.out.println("Line number " + (i + 1) + " - Not Matched || Expected status was : " + "Surplus"
							+ " || Actual statu was " + Status);
					Extent_fail(driver, "Line number " + (i + 1) + " - Not Matched || Expected status was : "
							+ "Surplus" + " || Actual statu was " + Status, test, test1);
					status = false;

				}

			} else if (value < 0) {

				if (Status.equals("Deficit")) {

					System.out.println("Line number " + (i + 1) + " - Matched || Expected status was : " + "Deficit"
							+ " || Actual statu was " + Status);
					Extent_pass(driver, "Line number " + (i + 1) + " - Matched || Expected status was : " + "Deficit"
							+ " || Actual statu was " + Status, test, test1);

				} else {
					System.out.println("Line number " + (i + 1) + " - Not Matched || Expected status was : " + "Deficit"
							+ " || Actual statu was " + Status);
					Extent_fail(driver, "Line number " + (i + 1) + " - Not Matched || Expected status was : "
							+ "Deficit" + " || Actual statu was " + Status, test, test1);
					status = false;

				}

			} else {

				if (Status.equals("Neutral")) {

					System.out.println("Line number " + (i + 1) + " - Matched || Expected status was : " + "Neutral"
							+ " || Actual statu was " + Status);
					Extent_pass(driver, "Line number " + (i + 1) + " - Matched || Expected status was : " + "Neutral"
							+ " || Actual statu was " + Status, test, test1);

				} else {
					System.out.println("Line number " + (i + 1) + " - Not Matched || Expected status was : " + "Neutral"
							+ " || Actual statu was " + Status);
					Extent_fail(driver, "Line number " + (i + 1) + " - Not Matched || Expected status was : "
							+ "Neutral" + " || Actual statu was " + Status, test, test1);
					status = false;

				}

			}

		}

		if (status) {
			System.out.println("Status for each row's are calculated as per the rule imbalance");
			Extent_pass1(test, "Status for each row's are calculated as per the rule imbalance");
		} else {
			System.out.println("Status for each row's are not calculated as per the rule imbalance");
			Extent_fail(driver, "Status for each row's are not calculated as per the rule imbalance", test, test1);

		}

	}

}
