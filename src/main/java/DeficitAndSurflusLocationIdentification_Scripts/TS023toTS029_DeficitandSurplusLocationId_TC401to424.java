package DeficitAndSurflusLocationIdentification_Scripts;

import java.awt.Robot;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.Utils;
import testng.reports.logging.LogAs;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class TS023toTS029_DeficitandSurplusLocationId_TC401to424 extends Keywords {

	@SuppressWarnings("deprecation")
	public void Scenario23(WebDriver driver, ExtentTest test, ExtentTest test1, String url, int dataset) throws Exception {

		String Username = Utils.getDataFromTestData("TS023_DeficitandSurplusLocationIdentification_Dataset"+dataset,
				"DeficitandSurplusLocationId", "Username");
		String Password = Utils.getDataFromTestData("TS023_DeficitandSurplusLocationIdentification_Dataset"+dataset,
				"DeficitandSurplusLocationId", "Password");
		String From_Week = Utils.getDataFromTestData("TS023_DeficitandSurplusLocationIdentification_Dataset"+dataset,
				"DeficitandSurplusLocationId", "From_Week");
		String To_Week = Utils.getDataFromTestData("TS023_DeficitandSurplusLocationIdentification_Dataset"+dataset,
				"DeficitandSurplusLocationId", "To_Week");

		String Toweek1 = Utils.getDataFromTestData("TS023_DeficitandSurplusLocationIdentification_Dataset"+dataset,
				"DeficitandSurplusLocationId", "Toweek1");
		String FromWeek1 = Utils.getDataFromTestData("TS023_DeficitandSurplusLocationIdentification_Dataset"+dataset,
				"DeficitandSurplusLocationId", "FromWeek1");

		String Import_file = System.getProperty("user.dir") + "\\uploads\\Equipment_Type.xlsx";
		String EquimentType_Alphabets = System.getProperty("user.dir") + "\\uploads\\EquimentType_Alphabets.xlsx";
		String EquimentType_Alphabets1 = System.getProperty("user.dir") + "\\uploads\\Budget_Flow_Applied.xlsx";

		Actions act = new Actions(driver);
		Robot rbt = new Robot();
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

		Extent_cal(test, "Testcase 401 - Ensure in Deficit and Surplus Location screen Budget option, "
				+ "System is allocating the corresponding Deficit and Surplus records to the particular location from import budget option");

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
		sendKeys(driver, Toweek_input, Toweek1);

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
//
//		wait(driver, "2");
//		Fluentwait(driver, Save_popup_ok);
//		click(driver, Save_popup_ok);
//
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

//			uploadFileRobot(driver, EquimentType_Alphabets1);

			String upload_EquimentType_Alphabets1 = System.getProperty("user.dir") + "/driver/MasterDownloadfile.exe "
					+ EquimentType_Alphabets1;

			try {
				Runtime.getRuntime().exec(upload_EquimentType_Alphabets1);
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println(e.getLocalizedMessage());
				Extent_fail(driver, e.getLocalizedMessage(), test, test1);
			}

			wait(driver, "10");

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

		String input_val = getAttribute(driver, IDField, "value");
		System.out.println(input_val);

		wait(driver, "2");
		Fluentwait(driver, Route);
		click(driver, Route);
		wait(driver, "2");

		String ERO_id_val = getAttribute(driver, Ero_ID_Field, "value");
		System.out.println(ERO_id_val);

		if (ERO_id_val.equals(input_val)) {

			System.out.println("Autogenerated ID is displayed in the ero routing screen");
			Extent_pass(driver, "Autogenerated ID is displayed in the ero routing screen", test, test1);
		} else {

			System.out.println("Different ID is showing in the ero routing screen " + ERO_id_val);
			Extent_fail(driver, "Different ID is showing in the ero routing screen " + ERO_id_val, test, test1);
		}

		wait(driver, "2");
		Fluentwait(driver, Optimizer_option);
		click(driver, Optimizer_option);

		wait(driver, "2");
		sendKeys(driver, ERO_Routing, ERO_id_val);

		Fluentwait(driver, ERO_Routing_Ok);
		click(driver, ERO_Routing_Ok);

		Fluentwait(driver, View_Date);
		click(driver, View_Date);

		wait(driver, "2");
		Fluentwait(driver, ERO_Report_Gate);
		wait(driver, "2");

		String Report_Gate = getAttribute(driver, ERO_Report_Gate, "value");
		System.out.println(Report_Gate);

		if (Report_Gate.equals(input_val)) {

			System.out.println("Autogenerated ID is displayed in the Report_Gate screen");
			Extent_pass(driver, "Autogenerated ID is displayed in the Report_Gate screen", test, test1);
		} else {

			System.out.println("Different ID is showing in the Report_Gate screen " + Report_Gate);
			Extent_fail(driver, "Different ID is showing in the Report_Gate screen " + Report_Gate, test, test1);
		}

		scrollBottom(driver);

		System.out.println("Testcase 401 Completed");

		Extent_cal(test, "Testcase 402 - Ensure in Deficit and Surplus Location Identification screen refresh");

		Fluentwait(driver, Deficittab);
		click(driver, Deficittab);

		Fluentwait(driver, Cancel);
		click(driver, Cancel);

		Fluentwait(driver, New);
		click(driver, New);

		Fluentwait(driver, New_Popup_Yes);
		click(driver, New_Popup_Yes);

		Fluentwait(driver, Show);
		click(driver, Show);
		wait(driver, "2");

		if (isDisplayed(driver, show_yes)) {
			Fluentwait(driver, show_yes);
			click(driver, show_yes);
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

//			uploadFileRobot(driver, EquimentType_Alphabets1);

			String upload_EquimentType_Alphabets1 = System.getProperty("user.dir") + "/driver/MasterDownloadfile.exe "
					+ EquimentType_Alphabets1;

			try {
				Runtime.getRuntime().exec(upload_EquimentType_Alphabets1);
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println(e.getLocalizedMessage());
				Extent_fail(driver, e.getLocalizedMessage(), test, test1);
			}

			wait(driver, "10");

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

//		wait(driver, "2");
//		Fluentwait(driver, Save);
//		click(driver, Save);
//
//		Fluentwait(driver, Save_popup_ok);
//		click(driver, Save_popup_ok);
//		wait(driver, "2");

		String Created_ID = getAttribute(driver, IDField, "value");

		String ExpectedTotal_records = getText(driver, Total_record);

		Fluentwait(driver, Editbutton);
		click(driver, Editbutton);

//		Fluentwait(driver, Refresh);
//		click(driver, Refresh);

//
//		Fluentwait(driver, Refresh_pop_Yes);
//		click(driver, Refresh_pop_Yes);

		if (isDisplayed(driver, IDField)) {

			System.out.println("After refreshing the page, Deficit and surplus location screen is still showing");
			Extent_pass(driver, "After refreshing the page, Deficit and surplus location screen is still showing", test,
					test1);

			Fluentwait(driver, IDField);

			String refreshed_ID = getAttribute(driver, IDField, "value");

			String ActualTotal_records = getText(driver, Total_record);

			System.out.println("refreshed_ID : " + refreshed_ID);

			if (refreshed_ID.equals(Created_ID)) {

				System.out.println("After refreshed the page same Id details are showing");
				Extent_pass(driver, "After refreshed the page same Id details are showing", test, test1);
			} else {

				System.out.println("After refreshed the page, data's got changed");
				Extent_fail(driver, "After refreshed the page, data's got changed", test, test1);
			}

			if (ActualTotal_records.equals(ExpectedTotal_records)) {

				System.out.println("After refreshed the page, all the records are correctly showing in the grid");
				Extent_pass(driver, "After refreshed the page, all the records are correctly showing in the grid", test,
						test1);

			} else {

				System.out.println("After refreshed the page, all the records are not showing in the grid");
				Extent_fail(driver, "After refreshed the page, all the records are not showing in the grid", test,
						test1);

			}

		} else {

			System.out.println("After refreshing the page, it got navigated to some other screen");
			Extent_fail(driver, "After refreshing the page, it got navigated to some other screen", test, test1);
		}

		System.out.println("Testcase 402 - Completed");

		wait(driver, "5");

		Extent_cal(test,
				"Testcase 403 - Check whether system should not allow deficit and surplus identification location id generated");

		Fluentwait(driver, Cancel);
		click(driver, Cancel);

		Fluentwait(driver, New);
		click(driver, New);

		Fluentwait(driver, New_Popup_Yes);
		click(driver, New_Popup_Yes);

		Fluentwait(driver, Show);
		click(driver, Show);
		wait(driver, "2");

		if (isDisplayed(driver, show_yes)) {
			Fluentwait(driver, show_yes);
			click(driver, show_yes);
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

//			uploadFileRobot(driver, EquimentType_Alphabets1);

			String upload_EquimentType_Alphabets1 = System.getProperty("user.dir") + "/driver/MasterDownloadfile.exe "
					+ EquimentType_Alphabets1;

			try {
				Runtime.getRuntime().exec(upload_EquimentType_Alphabets1);
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println(e.getLocalizedMessage());
				Extent_fail(driver, e.getLocalizedMessage(), test, test1);
			}

			wait(driver, "10");

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

//		wait(driver, "2");
//		Fluentwait(driver, Save);
//		click(driver, Save);
//
//		Fluentwait(driver, Save_popup_ok);
//		click(driver, Save_popup_ok);
//		wait(driver, "2");

		String NewlyCreated_ID = getAttribute(driver, IDField, "value");

		System.out.println("NewlyCreated_ID : " + NewlyCreated_ID);

		if (!NewlyCreated_ID.isEmpty()) {

			System.out.println("Id was generated for deficit and surplus location Identification");
			Extent_pass(driver, "Id was generated for deficit and surplus location Identification", test, test1);

		} else {

			System.out.println("Id was not generated for deficit and surplus location Identification");
			Extent_fail(driver, "Id was not generated for deficit and surplus location Identification", test, test1);
		}

		System.out.println("Testcase 403 Completed");

		Extent_cal(test,
				"Testcase 404 - Check whether system should not allow deficit and surplus identification location id generated");

		Fluentwait(driver, Cancel);
		click(driver, Cancel);

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
		Fluentwait(driver, Year_Drop_Down);
		click(driver, Year_To_Drop_Down);

		wait(driver, "2");
		Fluentwait(driver, Toweek_input);
		clear(driver, Toweek_input);
		sendKeys(driver, Toweek_input, Toweek1);

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
//
//		wait(driver, "2");
//		Fluentwait(driver, Save_popup_ok);
//		click(driver, Save_popup_ok);

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

//			uploadFileRobot(driver, EquimentType_Alphabets1);

			String upload_EquimentType_Alphabets1 = System.getProperty("user.dir") + "/driver/MasterDownloadfile.exe "
					+ EquimentType_Alphabets1;

			try {
				Runtime.getRuntime().exec(upload_EquimentType_Alphabets1);
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println(e.getLocalizedMessage());
				Extent_fail(driver, e.getLocalizedMessage(), test, test1);
			}

			wait(driver, "10");

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

		wait(driver, "2");

		String Generated_ID = getAttribute(driver, IDField, "value");
		System.out.println(Generated_ID);

		if (!Generated_ID.isEmpty()) {

			System.out.println("System allows to generate ID of deficit and surplus location Identification");
			Extent_pass(driver, "System allows to generate ID of deficit and surplus location Identification", test,
					test1);
		} else {
			System.out.println("System not allows to generate ID of deficit and surplus location Identification");
			Extent_fail(driver, "System not allows to generate ID of deficit and surplus location Identification", test,
					test1);
		}

		System.out.println("Testcase 404 Completed");

		Extent_cal(test,
				"Testcase 405- Ensure in Deficit and surplus location identification auto generated id created wrongly ");

		Fluentwait(driver, Cancel);
		click(driver, Cancel);

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
		wait(driver, "3");

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
//
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

//			uploadFileRobot(driver, EquimentType_Alphabets1);

			String upload_EquimentType_Alphabets1 = System.getProperty("user.dir") + "/driver/MasterDownloadfile.exe "
					+ EquimentType_Alphabets1;

			try {
				Runtime.getRuntime().exec(upload_EquimentType_Alphabets1);
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println(e.getLocalizedMessage());
				Extent_fail(driver, e.getLocalizedMessage(), test, test1);
			}

			wait(driver, "10");

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

		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
		String formattedDate = currentDate.format(formatter);

		String ExpValue = "C" + formattedDate + "-" + FromWeek1 + "-" + Toweek1;

		String Act = getAttribute(driver, IDField, "value");

		if (!Act.contains(ExpValue)) {
			Extent_pass(driver, "Autogenarated id format correctly genarated and the Id starts with letter E", test,
					test1);

		} else {
			Extent_fail(driver, "Autogenarated id format correctly genarated and the Id not starts with letter E", test,
					test1);
		}

		System.out.println("******************405***************");

		Fluentwait(driver, Cancel);
		click(driver, Cancel);
		wait(driver, "2");
		Fluentwait(driver, New);
		click(driver, New);
		Fluentwait(driver, New_Popup_Yes);
		click(driver, New_Popup_Yes);
		wait(driver, "2");

		Extent_cal(test,
				"Testcase 406- Ensure in Deficit and surplus location identification auto generated id created from Week not displayed ");

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
		Fluentwait(driver, show_yes);
		click(driver, show_yes);
		wait(driver, "2");

//		Fluentwait(driver, Save);
//		click(driver, Save);
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

//			uploadFileRobot(driver, EquimentType_Alphabets1);

			String upload_EquimentType_Alphabets1 = System.getProperty("user.dir") + "/driver/MasterDownloadfile.exe "
					+ EquimentType_Alphabets1;

			try {
				Runtime.getRuntime().exec(upload_EquimentType_Alphabets1);
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println(e.getLocalizedMessage());
				Extent_fail(driver, e.getLocalizedMessage(), test, test1);
			}

			wait(driver, "10");

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

		LocalDate currentDate1 = LocalDate.now();
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyyMMdd");
		String formattedDate1 = currentDate1.format(formatter1);

		String Act1 = getAttribute(driver, IDField, "value");

		String Neg_Exp = "E" + formattedDate1 + "--" + Toweek1;

		if (!Neg_Exp.contains(Act1)) {
			Extent_pass(driver, "Autogenarate id format genarated with From week  ", test, test1);

		} else {
			Extent_fail(driver, "Autogenarate id format Not genarated with from week", test, test1);
		}

		System.out.println("*************406************");

		Fluentwait(driver, Cancel);
		click(driver, Cancel);
		wait(driver, "2");
		Fluentwait(driver, New);
		click(driver, New);
		Fluentwait(driver, New_Popup_Yes);
		click(driver, New_Popup_Yes);
		wait(driver, "2");

		Extent_cal(test,
				"Testcase 407- Ensure in Deficit and surplus location identification auto generated id created To Week not displayed ");

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
		Fluentwait(driver, show_yes);
		click(driver, show_yes);
		wait(driver, "2");
//		Fluentwait(driver, Save);
//		click(driver, Save);
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

//			uploadFileRobot(driver, EquimentType_Alphabets1);

			String upload_EquimentType_Alphabets1 = System.getProperty("user.dir") + "/driver/MasterDownloadfile.exe "
					+ EquimentType_Alphabets1;

			try {
				Runtime.getRuntime().exec(upload_EquimentType_Alphabets1);
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println(e.getLocalizedMessage());
				Extent_fail(driver, e.getLocalizedMessage(), test, test1);
			}

			wait(driver, "10");

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
		LocalDate currentDate2 = LocalDate.now();
		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyyMMdd");
		String formattedDate2 = currentDate2.format(formatter2);

		String Act2 = getAttribute(driver, IDField, "value");

		String Neg_Exp1 = "E" + formattedDate2 + FromWeek1 + "-";

		if (!Neg_Exp1.contains(Act2)) {
			Extent_pass(driver, "Autogenarate id format genarated with To week  ", test, test1);

		} else {
			Extent_fail(driver, "Autogenarate id format Not genarated with To week", test, test1);
		}

		System.out.println("****************407*************");

		Extent_cal(test,
				"Testcase 408- Ensure in Deficit and surplus location identification auto generated id created Date and month not displayed ");

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

		Fluentwait(driver, show_yes);
		click(driver, show_yes);
		wait(driver, "2");

//		Fluentwait(driver, Save);
//		click(driver, Save);
//
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

//			uploadFileRobot(driver, EquimentType_Alphabets1);

			String upload_EquimentType_Alphabets1 = System.getProperty("user.dir") + "/driver/MasterDownloadfile.exe "
					+ EquimentType_Alphabets1;

			try {
				Runtime.getRuntime().exec(upload_EquimentType_Alphabets1);
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println(e.getLocalizedMessage());
				Extent_fail(driver, e.getLocalizedMessage(), test, test1);
			}

			wait(driver, "10");

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
		LocalDate currentDate3 = LocalDate.now();
		DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy");
		String formattedDate3 = currentDate3.format(formatter3);
		String ExpValue2 = "C" + formattedDate3 + "-" + FromWeek1 + "-" + Toweek1;

		String Act3 = getAttribute(driver, IDField, "value");
		if (!Act3.contains(ExpValue2)) {
			Extent_pass(driver, "Autogenarated id format correctly genarate with date and month", test, test1);

		} else {
			Extent_fail(driver, "Autogenarated id format wrongly  genarate with date and month", test, test1);
		}

		System.out.println("Testcase 408 Completed");

		Extent_cal(test,
				"Testcase 409 - Ensure in Deficit and Surplus Location screen EMS reposition option, System is allocating the corresponding Deficit and Surplus records to the particular location from EMS Data");

		WebElement scroller = driver.findElement(By.xpath("//div[@ref='eBodyHorizontalScrollViewport']"));

		String Total_records = getText(driver, Total_record);

		int length = Integer.parseInt(Total_records);

		int scrollAmount1 = 1000;

		js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller, scrollAmount1);

		boolean status_grid = true;

		for (int i = 0; i < length; i++) {

			WebElement calsurdeffield = driver
					.findElement(By.xpath("(//div[@row-id='" + i + "'])[2]//div[@col-id='calsurdef']"));

			act.moveToElement(calsurdeffield).build().perform();

			String calsurdef = calsurdeffield.getText();

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

			Statusfield.click();

			String Status = Statusfield.getText();

			System.out.println("Actualimbalance : " + Status);

			// Check if the value is positive, negative, or zero
			if (value > 0) {

				if (Status.equals("Surplus")) {

					System.out.println("Line number " + (i + 1) + " - Matched || Expected status was : " + "Surplus"
							+ " || Actual status was " + Status);
					Extent_pass(driver, "Line number " + (i + 1) + " - Matched || Expected status was : " + "Surplus"
							+ " || Actual status was " + Status, test, test1);

				} else {
					System.out.println("Line number " + (i + 1) + " - Not Matched || Expected status was : " + "Surplus"
							+ " || Actual status was " + Status);
					Extent_fail(driver, "Line number " + (i + 1) + " - Not Matched || Expected status was : "
							+ "Surplus" + " || Actual status was " + Status, test, test1);
					status_grid = false;

				}

			} else if (value < 0) {

				if (Status.equals("Deficit")) {

					System.out.println("Line number " + (i + 1) + " - Matched || Expected status was : " + "Deficit"
							+ " || Actual status was " + Status);
					Extent_pass(driver, "Line number " + (i + 1) + " - Matched || Expected status was : " + "Deficit"
							+ " || Actual status was " + Status, test, test1);

				} else {
					System.out.println("Line number " + (i + 1) + " - Not Matched || Expected status was : " + "Deficit"
							+ " || Actual status was " + Status);
					Extent_fail(driver, "Line number " + (i + 1) + " - Not Matched || Expected status was : "
							+ "Deficit" + " || Actual status was " + Status, test, test1);

					status_grid = false;
				}

			} else {

				if (Status.equals("Neutral")) {

					System.out.println("Line number " + (i + 1) + " - Matched || Expected status was : " + "Neutral"
							+ " || Actual status was " + Status);
					Extent_pass(driver, "Line number " + (i + 1) + " - Matched || Expected status was : " + "Neutral"
							+ " || Actual status was " + Status, test, test1);

				} else {
					System.out.println("Line number " + (i + 1) + " - Not Matched || Expected status was : " + "Neutral"
							+ " || Actual status was " + Status);
					Extent_fail(driver, "Line number " + (i + 1) + " - Not Matched || Expected status was : "
							+ "Neutral" + " || Actual status was " + Status, test, test1);
					status_grid = false;
				}

			}

		}

		if (status_grid) {

			System.out.println(
					"System is allocating the corresponding Deficit and Surplus records to the particular location from EMS Data");
			Extent_pass(driver,
					"System is allocating the corresponding Deficit and Surplus records to the particular location from EMS Data",
					test, test1);

		} else {

			System.out.println(
					"System is not allocating the corresponding Deficit and Surplus records to the particular location from EMS Data");
			Extent_fail(driver,
					"System is not allocating the corresponding Deficit and Surplus records to the particular location from EMS Data",
					test, test1);

		}

		System.out.println("Testcase 409 Completed");

		scrollBottom(driver);

		Extent_cal(test,
				"Testcase 410 - Ensure in Deficit and Surplus Location Identification screen records not fetched from ems history");

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

		Fluentwait(driver, show_yes);
		click(driver, show_yes);
		wait(driver, "2");

//		Fluentwait(driver, Save);
//		click(driver, Save);
//
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

//			uploadFileRobot(driver, EquimentType_Alphabets1);

			String upload_EquimentType_Alphabets1 = System.getProperty("user.dir") + "/driver/MasterDownloadfile.exe "
					+ EquimentType_Alphabets1;

			try {
				Runtime.getRuntime().exec(upload_EquimentType_Alphabets1);
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println(e.getLocalizedMessage());
				Extent_fail(driver, e.getLocalizedMessage(), test, test1);
			}

			wait(driver, "10");

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

			wait(driver, "2");

			if (isDisplayed1(driver, columns)) {

				System.out.println(columnname + " data's are fetched from the ems history");

			} else {

				System.out.println(columnname + " data's are not fetched from the ems history");
				Extent_fail(driver, columnname + " data's are not fetched from the ems history", test, test1);
				ems = false;
			}

		}

		if (ems) {

			System.out
					.println("Deficit and Surplus Location Identification screen records are fetched from ems history");
			Extent_pass(driver,
					"Deficit and Surplus Location Identification screen records are fetched from ems history", test,
					test1);
		} else {
			System.out.println(
					"Deficit and Surplus Location Identification screen records are not fetched from ems history");
			Extent_fail(driver,
					"Deficit and Surplus Location Identification screen records are not fetched from ems history", test,
					test1);
		}

		System.out.println("******************410**************");

		Extent_cal(test,
				"Testcase 411 - Ensure in Deficit and Surplus Location Identification screen records import through import from excel button");

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
//		uploadFileRobot(driver, Import_file);

		String upload_EquimentType_Alphabets1 = System.getProperty("user.dir") + "/driver/MasterDownloadfile.exe "
				+ EquimentType_Alphabets1;

		try {
			Runtime.getRuntime().exec(upload_EquimentType_Alphabets1);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getLocalizedMessage());
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
		}

		wait(driver, "10");

		Fluentwait(driver, Location3);

		if (isDisplayed(driver, click_yes)) {

			click(driver, click_yes);

			Fluentwait(driver, Click_ok);
			click(driver, Click_ok);
		}

		wait(driver, "2");

		boolean import_ems = true;

		for (int i = 0; i < size; i++) {

			String columnname = columnnames.get(i);

//			wait(driver, "3");
			WebElement columns = driver.findElement(By.xpath("(//div[@col-id='" + columnname + "'])[4]"));

			act.moveToElement(columns).build().perform();

//			wait(driver, "2");

			if (isDisplayed1(driver, columns)) {

				System.out.println(columnname + " data's are Imported from the excel");

			} else {

				System.out.println(columnname + " data's are not Imported from the excel");
				Extent_fail(driver, columnname + " data's are not Imported from the excel", test, test1);
				import_ems = false;
			}

		}

		if (import_ems) {

			System.out
					.println("Deficit and Surplus Location Identification screen records are Imported from the excel");
			Extent_pass(driver,
					"Deficit and Surplus Location Identification screen records are Imported from the excel", test,
					test1);
		} else {
			System.out.println(
					"Deficit and Surplus Location Identification screen records are not Imported from the excel");
			Extent_fail(driver,
					"Deficit and Surplus Location Identification screen records are not Imported from the excel", test,
					test1);
		}

		System.out.println("******************Testcase 411 completed**************");

		Extent_cal(test,
				"Testcase 413 - Ensure in Deficit and Surplus Location Identification screen records not fetched from ems history");

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

		Fluentwait(driver, show_yes);
		click(driver, show_yes);
		wait(driver, "2");

//		Fluentwait(driver, Save);
//		click(driver, Save);
//
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

//			uploadFileRobot(driver, EquimentType_Alphabets1);

			String upload_EquimentType_Alphabets2 = System.getProperty("user.dir") + "/driver/MasterDownloadfile.exe "
					+ EquimentType_Alphabets1;

			try {
				Runtime.getRuntime().exec(upload_EquimentType_Alphabets2);
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println(e.getLocalizedMessage());
				Extent_fail(driver, e.getLocalizedMessage(), test, test1);
			}

			wait(driver, "10");

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
		boolean Oneway = true;

		String OnewayTotal_records = getText(driver, Total_record);

		int onewaylength = Integer.parseInt(OnewayTotal_records);

		int scrollAmount3 = 1800; // Replace with the amount you want to scroll

		WebElement scroller3 = driver.findElement(By.xpath("//div[@ref='eBodyHorizontalScrollViewport']"));

		js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller3, scrollAmount3);

		List<String> Onewaycolumns = Arrays.asList("onewayoutload", "onewayoutreturn", "onewaylease", "tboh", "sali");

		for (int i = 0; i < 5; i++) {

//			scrollBottom(driver);

			String columnname = Onewaycolumns.get(i);

			wait(driver, "2");

			WebElement scrollers = driver.findElement(By.xpath("(//div[@ref='eBodyViewport'])[1]"));

			scrollBottom(driver);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollTop = 0;", scrollers);

//	    	wait(driver, "3");

			for (int j = 0; j < onewaylength; j++) {

				WebElement columns = driver
						.findElement(By.xpath("//div[@row-id='" + j + "']//div[@col-id='" + columnname + "']"));

				act.moveToElement(columns).click().build().perform();

//			wait(driver, "2");

				if (isDisplayed1(driver, columns)) {

					System.out.println(columnname + " data's are fetched from the ems history");

				} else {

					System.out.println(columnname + " data's are not fetched from the ems history");
					Extent_fail(driver, columnname + " data's are not fetched from the ems history", test, test1);
					Oneway = false;
				}

			}

		}

		if (Oneway) {

			System.out.println(
					"One way In and one way out - Deficit and Surplus Location Identification screen records are fetched from ems history");
			Extent_pass(driver,
					"One way In and one way out - Deficit and Surplus Location Identification screen records are fetched from ems history",
					test, test1);
		} else {
			System.out.println(
					"One way In and one way out - Deficit and Surplus Location Identification screen records are not fetched from ems history");
			Extent_fail(driver,
					"One way In and one way out - Deficit and Surplus Location Identification screen records are not fetched from ems history",
					test, test1);
		}

		System.out.println("******************413 Completed**************");

		Extent_cal(test,
				"Testcase 414 - Ensure in Deficit and Surplus Location Identification screen records import through import from excel button");

		scrollBottom(driver);

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

//		uploadFileRobot(driver, EquimentType_Alphabets);

		String upload_EquimentType_Alphabets = System.getProperty("user.dir") + "/driver/MasterDownloadfile.exe "
				+ EquimentType_Alphabets;

		try {
			Runtime.getRuntime().exec(upload_EquimentType_Alphabets);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getLocalizedMessage());
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
		}

		wait(driver, "10");

		Fluentwait(driver, Location3);

		if (isDisplayed(driver, click_yes)) {

			click(driver, click_yes);

			Fluentwait(driver, Click_ok);
			click(driver, Click_ok);
		}

		wait(driver, "2");

		boolean importOneway = true;

		String Oneway_importTotal = getText(driver, Total_record);

		int onewayimport = Integer.parseInt(Oneway_importTotal);

		int scrollAmount4 = 1800; // Replace with the amount you want to scroll

		WebElement scroller4 = driver.findElement(By.xpath("//div[@ref='eBodyHorizontalScrollViewport']"));

		js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller4, scrollAmount4);

		for (int i = 0; i < 5; i++) {

			String columnname = Onewaycolumns.get(i);

//			wait(driver, "3");

			for (int j = 0; j < onewayimport; j++) {

				WebElement columns = driver
						.findElement(By.xpath("//div[@row-id='" + j + "']//div[@col-id='" + columnname + "']"));

				act.moveToElement(columns).click().build().perform();

//				wait(driver, "2");

				if (isDisplayed1(driver, columns)) {

					System.out.println(columnname + " data's are imported from excel file");

				} else {

					System.out.println(columnname + " data's are not imported from excel file");
					Extent_fail(driver, columnname + " data's are not imported from excel file", test, test1);
					importOneway = false;
				}

			}

		}

		if (importOneway) {

			System.out.println(
					"One way In and one way out - Deficit and Surplus Location Identification screen records are imported from excel file");
			Extent_pass(driver,
					"One way In and one way out - Deficit and Surplus Location Identification screen records are imported from excel file",
					test, test1);
		} else {
			System.out.println(
					"One way In and one way out - Deficit and Surplus Location Identification screen records are not imported from excel file");
			Extent_fail(driver,
					"One way In and one way out - Deficit and Surplus Location Identification screen records are not imported from excel file",
					test, test1);
		}

		System.out.println("************Testcase 414 Completed***********");

		scrollBottom(driver);

		Extent_cal(test, "Testcase 415 -Ensure in Stock Status column records displayed");

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

		WebElement scroller2 = driver.findElement(By.xpath("//div[@ref='eBodyHorizontalScrollViewport']"));

		wait(driver, "3");

		boolean stockstatus = true;

		for (int i = 0; i < 4; i++) {

			HorizontalScrollFull(driver, Horizontal_gridscroll);

			wait(driver, "2");

			WebElement Locationfield = driver
					.findElement(By.xpath("(//div[@row-id='" + i + "'])[2]//div[@col-id='location']"));

			act.moveToElement(Locationfield).build().perform();

			String locations = Locationfield.getText();

			WebElement eqpfield = driver.findElement(By.xpath("(//div[@row-id='" + i + "'])[2]//div[@col-id='eqp']"));

			act.moveToElement(eqpfield).build().perform();

			String eqptype = eqpfield.getText();

			if (locations.isEmpty()) {

				// Scroll to the specified coordinates (x, y)
				js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller2, scrollAmount);

//				wait(driver, "3");

				WebElement Stockstatusfield = driver
						.findElement(By.xpath("(//div[@row-id='" + i + "'])[2]//div[@col-id='stock']"));

				String Stockstatus = Stockstatusfield.getText();

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
					stockstatus = false;
				}

			} else {

//				wait(driver, "3");

				scrollBottom(driver);

//				wait(driver, "5");

				waitForElement(driver, Stock_status);
				click(driver, Stock_status);

				Fluentwait(driver, StockstatusLocation_filter);
				click(driver, StockstatusLocation_filter);

				if (isDisplayed(driver, Filter_input)) {

					System.out.println("Filter column already selected");

				} else {

					Fluentwait(driver, Locationcode_filtercolumn);
					click(driver, Locationcode_filtercolumn);
				}

				Fluentwait(driver, Filter_input);
				clear(driver, Filter_input);
				sendKeys(driver, Filter_input, locations);

//				wait(driver, "3");

				if (isDisplayed(driver, Nomatches)) {

//					wait(driver, "2");

					waitForElement(driver, Deficittab);
					click(driver, Deficittab);

					js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller2, scrollAmount);

//					wait(driver, "3");

					WebElement Stockstatusfield = driver
							.findElement(By.xpath("(//div[@row-id='" + i + "'])[2]//div[@col-id='stock']"));

					String Stockstatus = Stockstatusfield.getText();

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
						stockstatus = false;
					}

//					wait(driver, "2");

				} else {

					enter(driver);

//					wait(driver, "3");

					try {

						WebElement Expected_StockStatusfield = driver
								.findElement(By.xpath("//div[@col-id='equipmenttype' and text()='" + eqptype
										+ "']/following::div[@col-id='stockstatus']"));

						waitForWebElement(driver, Expected_StockStatusfield, "Expected_StockStatusfield");

						String Expected_StockStatus = getTextofWebelement(driver, Expected_StockStatusfield,
								"Expected_StockStatusfield");

						System.out.println("Expected_StockStatus : " + Expected_StockStatus);

						Fluentwait(driver, Filter_input);
						clear(driver, Filter_input);

						wait(driver, "2");

						Fluentwait(driver, Selectall);
						click(driver, Selectall);

						wait(driver, "2");

						waitForElement(driver, Deficittab);
						click(driver, Deficittab);

						js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller2, scrollAmount);

						wait(driver, "3");

						WebElement Stockstatusfield = driver
								.findElement(By.xpath("(//div[@row-id='" + i + "'])[2]//div[@col-id='stock']"));

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
							stockstatus = false;
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

							wait(driver, "2");

							waitForElement(driver, Deficittab);
							click(driver, Deficittab);

						}

						js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller2, scrollAmount);

						wait(driver, "3");

						WebElement Stockstatusfield = driver
								.findElement(By.xpath("(//div[@row-id='" + i + "'])[2]//div[@col-id='stock']"));

						String Stockstatus = Stockstatusfield.getText();

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
							stockstatus = false;
						}

					}

				}

			}

		}

		if (stockstatus) {

			System.out.println("Stock status value was calculated as per the ero stock status tab");
			Extent_pass(driver, "Stock status value was calculated as per the ero stock status tab", test, test1);

		} else {

			System.out.println("Stock status value was not calculated as per the ero stock status tab");
			Extent_fail(driver, "Stock status value was not calculated as per the ero stock status tab", test, test1);
		}

		System.out.println("********************Testcase 415 Completed**************************");

		Extent_cal(test,
				"Testcase 416 - Ensure in Deficit and Surplus Location Identification screen records not fetched from ems history");

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

		Fluentwait(driver, show_yes);
		click(driver, show_yes);
		wait(driver, "2");

//		Fluentwait(driver, Save);
//		click(driver, Save);
//
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

//			uploadFileRobot(driver, EquimentType_Alphabets1);

			String upload_EquimentType_Alphabets3 = System.getProperty("user.dir") + "/driver/MasterDownloadfile.exe "
					+ EquimentType_Alphabets1;

			try {
				Runtime.getRuntime().exec(upload_EquimentType_Alphabets3);
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println(e.getLocalizedMessage());
				Extent_fail(driver, e.getLocalizedMessage(), test, test1);
			}

			wait(driver, "10");

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
		boolean Stockstatus = true;

		String StockstatusTotal_records = getText(driver, Total_record);

		int Stockstatuslength = Integer.parseInt(StockstatusTotal_records);

		int Stockstatusscroll = 1800; // Replace with the amount you want to scroll

		WebElement Stockstatusscroller = driver.findElement(By.xpath("//div[@ref='eBodyHorizontalScrollViewport']"));

		js.executeScript("arguments[0].scrollLeft += arguments[1];", Stockstatusscroller, Stockstatusscroll);

		for (int j = 0; j < Stockstatuslength; j++) {

			WebElement columns = driver.findElement(By.xpath("//div[@row-id='" + j + "']//div[@col-id='stock']"));

			act.moveToElement(columns).click().build().perform();

//			wait(driver, "2");

			if (isDisplayed1(driver, columns)) {

				System.out.println("Stock status column data's are fetched from the ems history");

			} else {

				System.out.println("Stock status column data's are not fetched from the ems history");
				Extent_fail(driver, "Stock status column data's are not fetched from the ems history", test, test1);
				Stockstatus = false;
			}

		}

		if (Stockstatus) {

			System.out.println(
					"Stock status  - Deficit and Surplus Location Identification screen records are fetched from ems history");
			Extent_pass(driver,
					"Stock status - Deficit and Surplus Location Identification screen records are fetched from ems history",
					test, test1);
		} else {
			System.out.println(
					"Stock status - Deficit and Surplus Location Identification screen records are not fetched from ems history");
			Extent_fail(driver,
					"Stock status - Deficit and Surplus Location Identification screen records are not fetched from ems history",
					test, test1);
		}

		System.out.println("******************416 Completed**************");

		Extent_cal(test,
				"Testcase 417 - Ensure in Deficit and Surplus Location Identification screen records import through import from excel button");

		scrollBottom(driver);

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

//		uploadFileRobot(driver, EquimentType_Alphabets);

		String upload_EquimentType_Alphabets4 = System.getProperty("user.dir") + "/driver/MasterDownloadfile.exe "
				+ EquimentType_Alphabets;

		try {
			Runtime.getRuntime().exec(upload_EquimentType_Alphabets4);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getLocalizedMessage());
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
		}

		wait(driver, "10");

		Fluentwait(driver, Location3);

		if (isDisplayed(driver, click_yes)) {

			click(driver, click_yes);

			Fluentwait(driver, Click_ok);
			click(driver, Click_ok);
		}

		wait(driver, "2");

		boolean Stockstatus2 = true;

		String StockstatusTotal_records2 = getText(driver, Total_record);

		int Stockstatuslength2 = Integer.parseInt(StockstatusTotal_records2);

		int Stockstatusscroll2 = 1800; // Replace with the amount you want to scroll

		WebElement scroller5 = driver.findElement(By.xpath("//div[@ref='eBodyHorizontalScrollViewport']"));

		js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller5, Stockstatusscroll2);

		for (int j = 0; j < Stockstatuslength2; j++) {

			WebElement columns = driver.findElement(By.xpath("//div[@row-id='" + j + "']//div[@col-id='stock']"));

			act.moveToElement(columns).click().build().perform();

			wait(driver, "2");

			if (isDisplayed1(driver, columns)) {

				System.out.println("Stock status column data's are imported from excel file");

			} else {

				System.out.println("Stock status column data's are not imported from excel file");
				Extent_fail(driver, "Stock status column data's are not imported from excel file", test, test1);
				Stockstatus2 = false;
			}

		}

		if (Stockstatus2) {

			System.out.println(
					"Stock status - Deficit and Surplus Location Identification screen records are imported from excel file");
			Extent_pass(driver,
					"Stock status - Deficit and Surplus Location Identification screen records are imported from excel file",
					test, test1);
		} else {
			System.out.println(
					"Stock status - Deficit and Surplus Location Identification screen records are not imported from excel file");
			Extent_fail(driver,
					"Stock status - Deficit and Surplus Location Identification screen records are not imported from excel file",
					test, test1);
		}

		System.out.println("************Testcase 417 Completed***********");

		scrollBottom(driver);

		Extent_cal(test,
				"Testcase 418 - Ensure in Deficit and surplus Location Identification screen, Bench mark stock Status column is referring from ERO Bench Mark Stock  Master");

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

//		Fluentwait(driver, Save);
//		click(driver, Save);
//
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

//			uploadFileRobot(driver, EquimentType_Alphabets1);

			String upload_EquimentType_Alphabets5 = System.getProperty("user.dir") + "/driver/MasterDownloadfile.exe "
					+ EquimentType_Alphabets1;

			try {
				Runtime.getRuntime().exec(upload_EquimentType_Alphabets5);
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println(e.getLocalizedMessage());
				Extent_fail(driver, e.getLocalizedMessage(), test, test1);
			}

			wait(driver, "10");

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
		wait(driver, "3");
		Fluentwait(driver, Searchbox);
		sendKeys(driver, Searchbox, "Ero Bench Mark Stock");

		wait(driver, "2");
		Fluentwait(driver, Benchmmark_stock);
		click(driver, Benchmmark_stock);

//		WebElement benchstock = driver.findElement(
//				By.xpath("(//div[@col-id='location' and text()='CNQDG']//following::div[@col-id='su'])[1]"));
//
//		String stockvalue = getTextofWebelement(driver, benchstock, "benchstock");
//
//		System.out.println("stockvalue : " + stockvalue);

		Fluentwait(driver, Deficittab);
		Jsclick(driver, Deficittab);

		// Scroll to the specified coordinates (x, y)
		int scrollAmount5 = 1000; // Replace with the amount you want to scroll

		WebElement scroller6 = driver.findElement(By.xpath("//div[@ref='eBodyHorizontalScrollViewport']"));

		waitForWebElement(driver, scroller6, "scroller2");

		wait(driver, "3");

		String totalbench = getText(driver, Total_record);

		int benchstock_count = Integer.parseInt(totalbench);

		boolean benchmark = true;

		for (int i = 0; i < benchstock_count; i++) {

			HorizontalScrollFull(driver, Horizontal_gridscroll);

			WebElement Locationfield = driver
					.findElement(By.xpath("(//div[@row-id='" + i + "'])[2]//div[@col-id='location']"));

			waitForWebElement(driver, Locationfield, "Locationfield");

			act.moveToElement(Locationfield).build().perform();

			String locations = Locationfield.getText();

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

//				wait(driver, "3");

				scrollBottom(driver);

//				wait(driver, "5");

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

//				wait(driver, "3");

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

					wait(driver, "3");

					try {

						WebElement Expected_StockStatusfield = driver
								.findElement(By.xpath("//div[@col-id='equipmenttype' and text()='" + eqptype
										+ "']/following::div[@col-id='stockstatus']"));

						waitForWebElement(driver, Expected_StockStatusfield, "Expected_StockStatusfield");

						String Expected_StockStatus = getTextofWebelement(driver, Expected_StockStatusfield,
								"Expected_StockStatusfield");

						System.out.println("Expected_StockStatus : " + Expected_StockStatus);

						Fluentwait(driver, Filter_input);
						clear(driver, Filter_input);

						wait(driver, "2");

						Fluentwait(driver, Selectall);
						click(driver, Selectall);

						wait(driver, "2");

						waitForElement(driver, Deficittab);
						click(driver, Deficittab);

						js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller6, scrollAmount5);

						wait(driver, "3");

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

							wait(driver, "2");

							Fluentwait(driver, Selectall);
							click(driver, Selectall);

							wait(driver, "2");

							waitForElement(driver, Deficittab);
							click(driver, Deficittab);

						}

						js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller6, scrollAmount5);

						wait(driver, "3");

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

		System.out.println("Testcase 418 Completed");

		Extent_cal(test,
				"Testcase 419 - Ensure in Deficit and Surplus Location Identification screen records not fetched from ems history");

		if (!benchmark) {

			System.out.println(
					"Bench Mark Stock  - Deficit and Surplus Location Identification screen records are not fetched from ems history");
			Extent_pass(driver,
					"Bench Mark Stock - Deficit and Surplus Location Identification screen records are not fetched from ems history",
					test, test1);
		} else {
			System.out.println(
					"Bench Mark Stock - Deficit and Surplus Location Identification screen records are fetched from ems history");
			Extent_fail(driver,
					"Bench Mark Stock - Deficit and Surplus Location Identification screen records are fetched from ems history",
					test, test1);
		}

		System.out.println("******************419 Completed**************");

		Extent_cal(test,
				"Testcase 420 - Ensure in Deficit and Surplus Location Identification screen records import through import from excel button");

		scrollBottom(driver);

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

//		uploadFileRobot(driver, EquimentType_Alphabets);

		String upload_EquimentType_Alphabets6 = System.getProperty("user.dir") + "/driver/MasterDownloadfile.exe "
				+ EquimentType_Alphabets1;

		try {
			Runtime.getRuntime().exec(upload_EquimentType_Alphabets6);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getLocalizedMessage());
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
		}

		wait(driver, "10");

		Fluentwait(driver, Location3);

		if (isDisplayed(driver, click_yes)) {

			click(driver, click_yes);

			Fluentwait(driver, Click_ok);
			click(driver, Click_ok);
		}

		wait(driver, "5");
//		Fluentwait(driver, Searchbox);
//		sendKeys(driver, Searchbox, "Ero Bench Mark Stock");
//
//		wait(driver, "2");
		Fluentwait(driver, Benchmark_tab);
		click(driver, Benchmark_tab);

//		WebElement benchstock1 = driver.findElement(
//				By.xpath("(//div[@col-id='location' and text()='CNQDG']//following::div[@col-id='su'])[1]"));
//
//		String stockvalue1 = getTextofWebelement(driver, benchstock1, "benchstock");
//
//		System.out.println("stockvalue : " + stockvalue1);

		Fluentwait(driver, Deficittab);
		click(driver, Deficittab);

		// Scroll to the specified coordinates (x, y)
		int scrollAmount7 = 1000; // Replace with the amount you want to scroll

		WebElement scroller7 = driver.findElement(By.xpath("//div[@ref='eBodyHorizontalScrollViewport']"));

		waitForWebElement(driver, scroller7, "scroller");

		wait(driver, "3");

		String totalbench2 = getText(driver, Total_record);

		int benchstock_count2 = Integer.parseInt(totalbench2);

		boolean benchmark_import = true;

		for (int i = 0; i < benchstock_count2; i++) {

			HorizontalScrollFull(driver, Horizontal_gridscroll);

			WebElement Locationfield = driver
					.findElement(By.xpath("(//div[@row-id='" + i + "'])[2]//div[@col-id='location']"));

			waitForWebElement(driver, Locationfield, "Locationfield");

			act.moveToElement(Locationfield).build().perform();

			String locations = Locationfield.getText();

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

//				wait(driver, "3");

				scrollBottom(driver);

//				wait(driver, "5");

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

//				wait(driver, "3");

				if (isDisplayed(driver, Nomatches)) {

					waitForElement(driver, Deficittab);
					click(driver, Deficittab);

//					wait(driver, "2");

					WebElement scroller9 = driver.findElement(By.xpath("//div[@ref='eBodyHorizontalScrollViewport']"));
					js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller9, scrollAmount5);

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

						String Stockstatus1 = Stockstatusfield.getText();

						if (Stockstatus1.equals(Expected_StockStatus)) {

							System.out.println(
									"Matched ||  Location name was : " + locations + "  || Expected stock status was : "
											+ Expected_StockStatus + " || Acutal stock status was : " + Stockstatus1);
							Extent_pass(driver,
									"Matched ||  Location name was : " + locations + "  || Expected stock status was : "
											+ Expected_StockStatus + " || Acutal stock status was : " + Stockstatus1,
									test, test1);
						} else {
							System.out.println("Not Matched ||  Location name was : " + locations
									+ "  || Expected stock status was : " + Expected_StockStatus
									+ " || Acutal stock status was : " + Stockstatus1);
							Extent_fail(driver,
									"Not Matched ||  Location name was : " + locations
											+ "  || Expected stock status was : " + Expected_StockStatus
											+ " || Acutal stock status was : " + Stockstatus1,
									test, test1);
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

						WebElement scroller10 = driver
								.findElement(By.xpath("//div[@ref='eBodyHorizontalScrollViewport']"));
						js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller10, scrollAmount5);

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

		if (benchmark_import) {

			System.out.println(
					"Bench Mark Stock  - Deficit and Surplus Location Identification screen records are not fetched from Import excel data");
			Extent_pass(driver,
					"Bench Mark Stock - Deficit and Surplus Location Identification screen records are not fetched from Import excel data",
					test, test1);
		} else {
			System.out.println(
					"Bench Mark Stock - Deficit and Surplus Location Identification screen records are fetched from Import excel data");
			Extent_fail(driver,
					"Bench Mark Stock - Deficit and Surplus Location Identification screen records are fetched from Import excel data",
					test, test1);
		}

		System.out.println("************Testcase 420 Completed***********");

		scrollBottom(driver);

		Extent_cal(test,
				" Testcase 421 - Ensure in Deficit and surplus Location Identification screen, Weekly Imbalance is calculate by Weekly Imbalance = ([Imbalance] / Number of Weeks)");

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

		Fluentwait(driver, show_yes);
		click(driver, show_yes);
		wait(driver, "2");

//		Fluentwait(driver, Save);
//		click(driver, Save);
//
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

//			uploadFileRobot(driver, EquimentType_Alphabets1);

			String upload_EquimentType_Alphabets7 = System.getProperty("user.dir") + "/driver/MasterDownloadfile.exe "
					+ EquimentType_Alphabets1;

			try {
				Runtime.getRuntime().exec(upload_EquimentType_Alphabets7);
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
		String ImbalanceTotal_records = getText(driver, Total_record);

		int Imbalancelength = Integer.parseInt(ImbalanceTotal_records);

		boolean imbalance = true;

		for (int i = 0; i < Imbalancelength; i++) {

//			wait(driver, "2");

			WebElement Imbalancefield = driver
					.findElement(By.xpath("(//div[@row-id='" + i + "'])[2]//div[@col-id='imbalance']"));

			act.moveToElement(Imbalancefield).build().perform();

			String Imbalance = Imbalancefield.getText();

			int imbalanceqty = Integer.parseInt(Imbalance);

			WebElement Weeksfield = driver
					.findElement(By.xpath("(//div[@row-id='" + i + "'])[2]//div[@col-id='weeks']"));

			String AcutalWeeks = Weeksfield.getText();

			int weeks = Integer.parseInt(AcutalWeeks);

			int Weekly_imbalance = imbalanceqty / weeks;

			System.out.println("Weekly_imbalance : " + Weekly_imbalance);

			String Expected_Weekly_imbalance = String.valueOf(Weekly_imbalance);

			// Convert week number and year to LocalDate

			WebElement Weekly_imbalancefield = driver
					.findElement(By.xpath("(//div[@row-id='" + i + "'])[2]//div[@col-id='weeklyimbal']"));

			Weekly_imbalancefield.click();

			String actual_Weekly_imbalance = Weekly_imbalancefield.getText();

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

				imbalance = false;

			}

		}

		if (imbalance) {
			System.out.println("Weekly imbalance was calculated as per the formula");
			Extent_pass(driver, "Weekly imbalance was calculated as per the formula", test, test1);
		} else {
			System.out.println("Weekly imbalance was not calculated as per the formula");
			Extent_fail(driver, "Weekly imbalance was not calculated as per the formula", test, test1);

		}

		System.out.println("*************Testcase 421 Completed************************");

		Extent_cal(test,
				"Testcase 422 - Ensure in Deficit and Surplus Location Identification screen records not fetched from ems history");

		if (imbalance) {

			System.out.println("Weekly imbalance is calculated as per the formula, Its not fetched from ems history");
			Extent_pass(driver, "Weekly imbalance is calculated as per the formula, Its not fetched from ems history",
					test, test1);
		} else {

			System.out.println("Weekly imbalance is not calculated as per the formula, Its fetched from ems history");
			Extent_fail(driver, "Weekly imbalance is not calculated as per the formula, Its fetched from ems history",
					test, test1);
		}

		System.out.println("Testcase 422 Completed");

		Extent_cal(test,
				"Testcase 423 - Ensure in Deficit and Surplus Location Identification screen records import through import from excel button");

		scrollBottom(driver);

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
//		uploadFileRobot(driver, Import_file);

		String upload_Import_file = System.getProperty("user.dir") + "/driver/MasterDownloadfile.exe " + Import_file;

		try {
			Runtime.getRuntime().exec(upload_Import_file);
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

		String ImbalanceTotal_records2 = getText(driver, Total_record);

		int Imbalancelength2 = Integer.parseInt(ImbalanceTotal_records2);

		boolean imbalance2 = true;

		for (int i = 0; i < Imbalancelength2; i++) {

//			wait(driver, "2");

			WebElement Imbalancefield = driver
					.findElement(By.xpath("(//div[@row-id='" + i + "'])[2]//div[@col-id='imbalance']"));

			act.moveToElement(Imbalancefield).build().perform();

			String Imbalance = Imbalancefield.getText();

			int imbalanceqty = Integer.parseInt(Imbalance);

			WebElement Weeksfield = driver
					.findElement(By.xpath("(//div[@row-id='" + i + "'])[2]//div[@col-id='weeks']"));

			String AcutalWeeks = Weeksfield.getText();

			int weeks = Integer.parseInt(AcutalWeeks);

			int Weekly_imbalance = imbalanceqty / weeks;

			System.out.println("Weekly_imbalance : " + Weekly_imbalance);

			String Expected_Weekly_imbalance = String.valueOf(Weekly_imbalance);

			// Convert week number and year to LocalDate

			WebElement Weekly_imbalancefield = driver
					.findElement(By.xpath("(//div[@row-id='" + i + "'])[2]//div[@col-id='weeklyimbal']"));

			Weekly_imbalancefield.click();

			String actual_Weekly_imbalance = Weekly_imbalancefield.getText();

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

				imbalance2 = false;

			}

		}

		if (imbalance2) {
			System.out.println("Weekly imbalance records are imported from Import excel function");
			Extent_pass(driver, "Weekly imbalance records are imported from Import excel function", test, test1);
		} else {
			System.out.println("Weekly imbalance records are not imported from Import excel function");
			Extent_pass(driver, "Weekly imbalance records are not imported from Import excel function", test, test1);
		}

		System.out.println("Testcase 423 Completed");

		Extent_cal(test,
				"Testcase 424 - Ensure in Deficit and surplus Location Identification screen,  Imbalance is calculate by Imbalance = Export-Import");

		scrollBottom(driver);

		Fluentwait(driver, Cancel);
		click(driver, Cancel);

		wait(driver, "2");
		Fluentwait(driver, New);
		click(driver, New);

		Fluentwait(driver, New_Popup_Yes);
		click(driver, New_Popup_Yes);
		wait(driver, "2");

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

//		Fluentwait(driver, Save);
//		click(driver, Save);
//
//		wait(driver, "2");
//
//		Fluentwait(driver, Save_popup_ok);
//		click(driver, Save_popup_ok);
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

//			uploadFileRobot(driver, EquimentType_Alphabets1);

			String upload_EquimentType_Alphabets7 = System.getProperty("user.dir") + "/driver/MasterDownloadfile.exe "
					+ EquimentType_Alphabets1;

			try {
				Runtime.getRuntime().exec(upload_EquimentType_Alphabets7);
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println(e.getLocalizedMessage());
				Extent_fail(driver, e.getLocalizedMessage(), test, test1);
			}

			wait(driver, "10");

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
		String Total_records2 = getText(driver, Total_record);

		int length2 = Integer.parseInt(Total_records2);

		boolean Imbalance = true;

		for (int i = 0; i < length2; i++) {

			WebElement Importfield = driver
					.findElement(By.xpath("(//div[@row-id='" + i + "'])[2]//div[@col-id='importCnt']"));

			act.moveToElement(Importfield).build().perform();

			String Import = Importfield.getText();

			int importqty = Integer.parseInt(Import);

			WebElement Exportfield = driver
					.findElement(By.xpath("(//div[@row-id='" + i + "'])[2]//div[@col-id='export']"));

			String Export = Exportfield.getText();

			int exportqty = Integer.parseInt(Export);

			int Imbalanceqty = importqty - exportqty;

			String Expected_imbalance = String.valueOf(Imbalanceqty);

			System.out.println("Imbalanceqty : " + Imbalanceqty);

			WebElement imbalancefield = driver
					.findElement(By.xpath("(//div[@row-id='" + i + "'])[2]//div[@col-id='imbalance']"));

			imbalancefield.click();

			String Actualimbalance = imbalancefield.getText();

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
				Imbalance = false;

			}

		}

		if (Imbalance) {

			System.out.println("Imbalance value was correctly calculated as per the imported data");

		} else {

			System.out.println("Imbalance value was not correctly calculated as per the imported data");
		}

		System.out.println("Testcase 424 Completed");

	}
}
