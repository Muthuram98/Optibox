package DeficitAndSurflusLocationIdentification_Scripts;

import java.awt.Robot;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.Utils;

public class TS020_TS021_DeficitandSurplusLocationId_TC329to339 extends Keywords {

	@SuppressWarnings("deprecation")
	public void Scenario20(WebDriver driver, ExtentTest test, ExtentTest test1, String url, int dataset)
			throws Exception {

		String Username = Utils.getDataFromTestData("TS020_DeficitandSurplusLocationIdentification_Dataset" + dataset,
				"DeficitandSurplusLocationId", "Username");
		String Password = Utils.getDataFromTestData("TS020_DeficitandSurplusLocationIdentification_Dataset" + dataset,
				"DeficitandSurplusLocationId", "Password");
		String FromWeek1 = Utils.getDataFromTestData("TS020_DeficitandSurplusLocationIdentification_Dataset" + dataset,
				"DeficitandSurplusLocationId", "FromWeek1");
		String ToWeek1 = Utils.getDataFromTestData("TS020_DeficitandSurplusLocationIdentification_Dataset" + dataset,
				"DeficitandSurplusLocationId", "ToWeek1");
		String Equipment_excel = Utils.getDataFromTestData(
				"TS020_DeficitandSurplusLocationIdentification_Dataset" + dataset, "DeficitandSurplusLocationId",
				"Equipment_excel");
		String Refresh_val = Utils.getDataFromTestData(
				"TS020_DeficitandSurplusLocationIdentification_Dataset" + dataset, "DeficitandSurplusLocationId",
				"Refresh");

		String Import_file = System.getProperty("user.dir") + "\\uploads\\" + Equipment_excel + ".xlsx";
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

		wait(driver, "5");

		Extent_cal(test,
				"Testcase 329 - Ensure in Deficit and Surplus Location Identification Auto generated ID created");

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

		wait(driver, "5");

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

		Extent_cal(test, "Testcase 330 - Ensure in Deficit and Surplus Location Identification screen refresh");

		scrollBottom(driver);

		Fluentwait(driver, Deficittab);
		click(driver, Deficittab);

		wait(driver, "5");

		Fluentwait(driver, Cancel);
		click(driver, Cancel);

		wait(driver, "2");
		Fluentwait(driver, New);
		click(driver, New);

		Fluentwait(driver, New_Popup_Yes);
		click(driver, New_Popup_Yes);

		wait(driver, "2");
		Fluentwait(driver, Show);
		click(driver, Show);

		wait(driver, "2");

		if (isDisplayed(driver, Saved_Yes_Option)) {
			Fluentwait(driver, Saved_Yes_Option);
			click(driver, Saved_Yes_Option);
		}
		wait(driver, "2");
//
//		Fluentwait(driver, Save);
//		click(driver, Save);
//		wait(driver, "2");
//
//		Fluentwait(driver, saved_Conf_Ok);
//		click(driver, saved_Conf_Ok);

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

		Fluentwait(driver, Editbutton);
		click(driver, Editbutton);

		Fluentwait(driver, ColumnFilter);
		click(driver, ColumnFilter);

//		Fluentwait(driver, ColumnFilter_selectall);
		Jsclick(driver, ColumnFilter_selectall);

		Fluentwait(driver, ColumnFilter);
		click(driver, ColumnFilter);

		wait(driver, "2");

		Fluentwait(driver, Save);
		click(driver, Save);

		wait(driver, "5");

		Fluentwait(driver, Refresh);
		click(driver, Refresh);

//		wait(driver, "5");
//
//		String refresh_popup = getText(driver, Refresh_pop);
//	
//		if (refresh_popup.equals(Refresh_val)) {
//			System.out.println("Matched || Expected refresh popup message  : " + Refresh_val + " Actual refresh popup message : " + refresh_popup);
//			Extent_pass(driver, "Matched || Expected refresh popup message: " + Refresh_val + " Actual refresh popup message : " + refresh_popup, test,test1);
//		} else {
//			System.out.println("Not Matched || Expected refresh popup message  : " + Refresh_val + " Actual refresh popup message : " + refresh_popup);
//			Extent_fail(driver, "Not Matched || Expected refresh popup message: " + Refresh_val + " Actual refresh popup message : " + refresh_popup,
//					test,test1);
//			global ="Not Matched || Expected refresh popup message  :" + Refresh_val + " Actual refresh popup message : " + refresh_popup ;
//		}
//		
//		Fluentwait(driver, Refresh_pop_Yes);
//		click(driver, Refresh_pop_Yes);
//		
		wait(driver, "5");

		if (isDisplayed(driver, Location3)) {

			Extent_pass(driver, "Refresh function is working fine", test, test1);
		} else {

			Extent_fail(driver, "Refresh function is not working fine", test, test1);
		}

		Fluentwait(driver, ColumnFilter);
		click(driver, ColumnFilter);

//		Fluentwait(driver, ColumnFilter_selectall);
		Jsclick(driver, ColumnFilter_selectall);

		Fluentwait(driver, ColumnFilter);
		click(driver, ColumnFilter);

		System.out.println("Testcase 330 Completed");

		Extent_cal(test,
				"Testcase 331 - Ensure in Deficit and Surplus Location Identification gird should not be double click");

		Fluentwait(driver, DoubleClick);
		click(driver, DoubleClick);

		wait(driver, "5");

		if (isDisplayed(driver, DoubleClick)) {

			Extent_pass(driver, "Double click is not working on the deficit and surplus location identification grid",
					test, test1);
			System.out.println("Double click is not working on the deficit and surplus location identification grid");
		} else {
			Extent_fail(driver, "Double click is working on the deficit and surplus location identification grid", test,
					test1);
			System.out.println("Double click is working on the deficit and surplus location identification grid");
		}

		Extent_cal(test,
				"Testcase 332 - Check whether system should not allow deficit and surplus identification location id generated");

		Fluentwait(driver, Cancel);
		click(driver, Cancel);

		wait(driver, "3");

		Fluentwait(driver, New);
		click(driver, New);

		Fluentwait(driver, New_Popup_Yes);
		click(driver, New_Popup_Yes);

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

		System.out.println("Testcase 332 - Completed");

		Extent_cal(test,
				"Testcase 333 - Ensure in Deficit and surplus location identification auto generated id created wrongly ");

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
		sendKeys(driver, Toweek_input, ToWeek1);
		wait(driver, "3");

		Fluentwait(driver, Show);
		click(driver, Show);
		wait(driver, "2");

		if (isDisplayed(driver, show_yes)) {
			Fluentwait(driver, show_yes);
			click(driver, show_yes);
		}

//		wait(driver,"2");
//		Fluentwait(driver, Save);
//		click(driver, Save);
//		
//		Fluentwait(driver, Save_popup_ok);
//		click(driver, Save_popup_ok);
//		wait(driver,"2");
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

//				uploadFileRobot(driver,EquimentType_Alphabets1);

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

		String ExpValue = "C" + formattedDate + "-" + FromWeek1 + "-" + ToWeek1;

		String Act = getAttribute(driver, IDField, "value");

		if (!Act.contains(ExpValue)) {
			Extent_pass(driver, "Autogenarated id format correctly genarated and the Id starts with letter E", test,
					test1);

		} else {
			Extent_fail(driver, "Autogenarated id format correctly genarated and the Id not starts with letter E", test,
					test1);
		}

		System.out.println("******************333***************");

		Extent_cal(test,
				"Testcase 334- Ensure in Deficit and surplus location identification auto generated id created from Week not displayed ");

		Fluentwait(driver, Cancel);
		click(driver, Cancel);
		wait(driver, "2");
		Fluentwait(driver, New);
		click(driver, New);
		Fluentwait(driver, New_Popup_Yes);
		click(driver, New_Popup_Yes);
		wait(driver, "2");

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
		sendKeys(driver, Toweek_input, ToWeek1);

		Fluentwait(driver, Show);
		click(driver, Show);
		wait(driver, "2");
		Fluentwait(driver, show_yes);
		click(driver, show_yes);
//		wait(driver,"2");
//		Fluentwait(driver, Save);
//		click(driver, Save);
//		Fluentwait(driver, Save_popup_ok);
//		click(driver, Save_popup_ok);
//		wait(driver,"2");
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

//				uploadFileRobot(driver,EquimentType_Alphabets1);

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

		String Neg_Exp = "E" + formattedDate1 + "--" + ToWeek1;

		if (!Neg_Exp.contains(Act1)) {
			Extent_pass(driver, "Autogenarate id format genarated with From week  ", test, test1);

		} else {
			Extent_fail(driver, "Autogenarate id format Not genarated with from week", test, test1);
		}

		System.out.println("*************334************");

		Extent_cal(test,
				"Testcase 335 - Ensure in Deficit and surplus location identification auto generated id created To Week not displayed ");

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
		sendKeys(driver, Toweek_input, ToWeek1);

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
//		wait(driver,"2");
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

//				uploadFileRobot(driver,EquimentType_Alphabets1);

			String upload_EquimentType_Alphabets1 = System.getProperty("user.dir") + "/driver/MasterDownloadfile.exe "
					+ EquimentType_Alphabets1;

			try {
				Runtime.getRuntime().exec(upload_EquimentType_Alphabets1);
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println(e.getLocalizedMessage());
				Extent_fail(driver, e.getLocalizedMessage(), test, test1);
			}

			wait(driver, "20");

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

		System.out.println("****************335*************");

		Extent_cal(test,
				"Testcase 336 - Ensure in Deficit and surplus location identification auto generated id created Date and month not displayed ");

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
		sendKeys(driver, Toweek_input, ToWeek1);

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
//		wait(driver,"2");
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

//				uploadFileRobot(driver,EquimentType_Alphabets1);

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
		String ExpValue2 = "C" + formattedDate3 + "-" + FromWeek1 + "-" + ToWeek1;

		String Act3 = getAttribute(driver, IDField, "value");
		if (!Act3.contains(ExpValue2)) {
			Extent_pass(driver, "Autogenarated id format correctly genarate with date and month", test, test1);

		} else {
			Extent_fail(driver, "Autogenarated id format wrongly  genarate with date and month", test, test1);
		}

		System.out.println("Testcase 336 Completed");

		Extent_cal(test,
				"Testcase 337 - Ensure in Deficit and Surplus Location Identification screen to identify the Location whether it is Surplus,"
						+ "Deficit,Neutral based on Equipment type");

		WebElement scroller = driver.findElement(By.xpath("//div[@ref='eBodyHorizontalScrollViewport']"));

		int scrollAmount1 = 1000;

		js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller, scrollAmount1);

		String Total_records = getText(driver, Total_record);

		int length = Integer.parseInt(Total_records);

		boolean status = true;

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
					status = false;
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
					status = false;
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
					status = false;
				}

			}

		}

		if (status) {

			System.out
					.println("Status of the deficit,neutral and surplus location calculation was functioned correctly");
			Extent_pass(driver,
					"Status of the deficit,neutral and surplus location calculation was functioned correctly", test,
					test1);
		} else {
			System.out.println(
					"Status of the deficit,neutral and surplus location calculation was not functioned correctly");
			Extent_fail(driver,
					"Status of the deficit,neutral and surplus location calculation was not functioned correctly", test,
					test1);
		}

		System.out.println("Testcase 337 - Completed");

		Extent_cal(test,
				"Testcase 338 - Ensure in Deficit and Surplus Location Identification screen records not fetched from ems history");

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
		sendKeys(driver, Toweek_input, ToWeek1);

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
//		wait(driver,"2");
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

//				uploadFileRobot(driver,EquimentType_Alphabets1);

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

		System.out.println("******************338**************");

		Extent_cal(test,
				"Testcase 339 - Ensure in Deficit and Surplus Location Identification screen records import through import from excel button");

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
//		uploadFileRobot(driver,Import_file);

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

			WebElement columns = driver.findElement(By.xpath("(//div[@col-id='" + columnname + "'])[4]"));

			act.moveToElement(columns).build().perform();

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

		System.out.println("******************339**************");

	}
}
