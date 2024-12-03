package ERO_Deviation_report;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.Utils;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class TS_002_Tc_016toTc_036_ERO_Deviation_report extends Keywords {
	public void Scenario002(WebDriver driver, ExtentTest test, ExtentTest test1, String url, int dataset)
			throws AWTException, IOException, InterruptedException {

		System.out.println("url : " + url);

		String Username = Utils.getDataFromTestData("TS_002_Tc_016toTc_036_ERO_Dataset" + dataset,
				"ERO_Deviation_report", "Username");
		String Password = Utils.getDataFromTestData("TS_002_Tc_016toTc_036_ERO_Dataset" + dataset,
				"ERO_Deviation_report", "Password");
		String ID = Utils.getDataFromTestData("TS_002_Tc_016toTc_036_ERO_Dataset"+ dataset, "ERO_Deviation_report",
				"Id");
		String Expected_screencolor = Utils.getDataFromTestData("TS_002_Tc_016toTc_036_ERO_Dataset" + dataset,
				"ERO_Deviation_report", "Screen_background");
		String Expected_FieldColor = Utils.getDataFromTestData("TS_002_Tc_016toTc_036_ERO_Dataset" + dataset,
				"ERO_Deviation_report", "Fieldcolor1");
		String Expected_FontFamily = Utils.getDataFromTestData("TS_002_Tc_016toTc_036_ERO_Dataset" + dataset,
				"ERO_Deviation_report", "FontFamily1");
		String SurplusLocation_X = Utils.getDataFromTestData("TS_002_Tc_016toTc_036_ERO_Dataset" + dataset,
				"ERO_Deviation_report", "Surplus_Location_X");
		String DeficitLocation_X = Utils.getDataFromTestData("TS_002_Tc_016toTc_036_ERO_Dataset" + dataset,
				"ERO_Deviation_report", "Deficit_Location_X");
		String Quantity_X = Utils.getDataFromTestData("TS_002_Tc_016toTc_036_ERO_Dataset" + dataset,
				"ERO_Deviation_report", "QuantityX");
		String CostperQtyUSD_X = Utils.getDataFromTestData("TS_002_Tc_016toTc_036_ERO_Dataset" + dataset,
				"ERO_Deviation_report", "Costper_QtyUSD_X");
		String SurplusLocation_Y = Utils.getDataFromTestData("TS_002_Tc_016toTc_036_ERO_Dataset" + dataset,
				"ERO_Deviation_report", "Surplus_Location_Y");
		String DeficitLocation_Y = Utils.getDataFromTestData("TS_002_Tc_016toTc_036_ERO_Dataset" + dataset,
				"ERO_Deviation_report", "Deficit_Location_Y");
		String Quantity_Y = Utils.getDataFromTestData("TS_002_Tc_016toTc_036_ERO_Dataset" + dataset,
				"ERO_Deviation_report", "QuantityY");
		String CostperQtyUSD_Y = Utils.getDataFromTestData("TS_002_Tc_016toTc_036_ERO_Dataset" + dataset,
				"ERO_Deviation_report", "Costper_QtyUSD_Y");
		String Messagetext = Utils.getDataFromTestData("TS_002_Tc_016toTc_036_ERO_Dataset" + dataset,
				"ERO_Deviation_report", "Message_text");
		String FieldInput_name = Utils.getDataFromTestData("TS1_002_Tc_016toTc_036_ERO_Dataset"+dataset,
				"ERO_Deviation_report", "Fieldvalue1");
		String FieldInput_name1 = Utils.getDataFromTestData("TS1_002_Tc_016toTc_036_ERO_Dataset"+dataset,
				"ERO_Deviation_report", "Fieldvalue2");
		String FieldInput_name2 = Utils.getDataFromTestData("TS1_002_Tc_016toTc_036_ERO_Dataset"+dataset,
				"ERO_Deviation_report", "Fieldvalue3");
		String FieldInput_name3 = Utils.getDataFromTestData("TS1_002_Tc_016toTc_036_ERO_Dataset"+dataset,
				"ERO_Deviation_report", "Fieldvalue4");

		navigateUrl(driver, url);

		Fluentwait(driver, Username_input1);
		sendKeys(driver, Username_input1, Username);

		Fluentwait(driver, Password_input1);
		sendKeys(driver, Password_input1, Password);

		Fluentwait(driver, SignIn1);
		click(driver, SignIn1);

		wait(driver, "5");

		if (isDisplayed(driver, session_confirmation1)) {
			Fluentwait(driver, session_confirmation1);
			click(driver, session_confirmation1);
		}

		Fluentwait(driver, Searchbox1);
		sendKeys(driver, Searchbox1, "ERO Deviation report");

		Fluentwait(driver, Select_Deviation);
		click(driver, Select_Deviation);

		wait(driver, "3");

		Extent_cal(test, "Testcase 16 - Ensure that the screen background should be in correct color");

		Fluentwait(driver, Screen_Deviation);
		String actualscreencolor = getTextBackgroundColor(driver, Screen_Deviation);

		if (actualscreencolor.equals(Expected_screencolor)) {

			System.out.println("Screen Background color Matched || Expected screen color was : " + Expected_screencolor
					+ " || Actual screen color was " + actualscreencolor);
			Extent_pass(driver, "Screen Background color Matched || Expected screen color was : " + Expected_screencolor
					+ " || Actual screen color was " + actualscreencolor, test, test1);

		} else {
			System.out.println("Screen Background color Not Matched || Expected screen color was : "
					+ Expected_screencolor + " || Actual screen color was " + actualscreencolor);
			Extent_fail(driver, "Screen Background color Not Matched || Expected screen color was : "
					+ Expected_screencolor + " || Actual screen color was " + actualscreencolor, test, test1);
		}

		System.out
				.println("//***************************Testcase 16 Completed **************************************//");

		click(driver, Cancel_Report);

		Fluentwait(driver, New_Report);
		click(driver, New_Report);

		Fluentwait(driver, Create_New_Confirm1);
		click(driver, Create_New_Confirm1);

		wait(driver, "5");

		Fluentwait(driver, Search1);
		click(driver, Search1);

		Fluentwait(driver, Globalserach_IDInput);
		sendKeys(driver, Globalserach_IDInput, ID);

		wait(driver, "2");

		Fluentwait(driver, Click_Search);
		click(driver, Click_Search);

		wait(driver, "3");

		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);

		wait(driver, "5");

		Fluentwait(driver, Search2);
		click(driver, Search2);

		wait(driver, "3");

		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);

		wait(driver, "5");

		Fluentwait(driver, Search3);
		click(driver, Search3);

		wait(driver, "3");

		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);

		wait(driver, "5");

		Fluentwait(driver, Search4);
		click(driver, Search4);
		wait(driver, "3");

		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);

		wait(driver, "5");

		Extent_cal(test, "Testcase 18 - Ensure that the read only mode field background should be in correct color");

		String SearchField1 = getTextBackgroundColor(driver, Search_Filed1);

		System.out.println("SearchField1 : " + SearchField1);

		if (SearchField1.equals(Expected_FieldColor)) {

			System.out.println("Search1 field Background color Matched || Expected Search1 field color was : "
					+ Expected_FieldColor + " || Actual Search1 field color was " + SearchField1);
			Extent_pass(driver, "Search1 field Background color Matched || Expected Search1 field color was : "
					+ Expected_FieldColor + " || Actual Search1 field color was " + SearchField1, test, test1);
		} else {
			System.out.println("Search1 field Background color Not Matched || Expected Search1 field color was : "
					+ Expected_FieldColor + " || Actual Search1 field color was " + SearchField1);
			Extent_fail(driver, "Search1 field Background color Not Matched || Expected Search1 field color was : "
					+ Expected_FieldColor + " || Actual Search1 field color was " + SearchField1, test, test1);
		}

		String SearchField2 = getTextBackgroundColor(driver, Search_Filed2);

		System.out.println("SearchField2 : " + SearchField2);

		if (SearchField2.equals(Expected_FieldColor)) {

			System.out.println("Search2 field Background color Matched || Expected Search2 field color was : "
					+ Expected_FieldColor + " || Actual Search2 field color was " + SearchField2);
			Extent_pass(driver, "Search2 field Background color Matched || Expected Search2 field color was : "
					+ Expected_FieldColor + " || Actual Search2 field color was " + SearchField2, test, test1);
		} else {
			System.out.println("Surplus field Background color Not Matched || Expected Search2 field color was : "
					+ Expected_FieldColor + " || Actual Search2 field color was " + SearchField2);
			Extent_fail(driver, "Search2 field Background color Not Matched || Expected Search2 field color was : "
					+ Expected_FieldColor + " || Actual Search2 field color was " + SearchField2, test, test1);
		}

		System.out
				.println("//***************************Testcase 18 Completed **************************************//");

		Extent_cal(test, "Testcase 19 - Ensure that the mandatory field should be highlighted with SVM standard color");

		String SearchField1_1 = getTextBackgroundColor(driver, Search_Filed1);

		System.out.println("SearchField1_1 : " + SearchField1_1);

		if (SearchField1_1.equals(Expected_FieldColor)) {

			System.out.println("Search1 field Background color Matched || Expected Search1 field color was : "
					+ Expected_FieldColor + " || Actual Search1 field color was " + SearchField1_1);
			Extent_pass(driver,
					"Search1 field Background color Matched || Expected Search1 field color was : "
							+ Expected_FieldColor + " || Actual Search1 field color was " + SearchField1_1,
					test, test1);
		} else {
			System.out.println("Search1 field Background color Not Matched || Expected Search1 field color was : "
					+ Expected_FieldColor + " || Actual Search1 field color was " + SearchField1_1);
			Extent_fail(driver,
					"Search1 field Background color Not Matched || Expected Search1 field color was : "
							+ Expected_FieldColor + " || Actual Search1 field color was " + SearchField1_1,
					test, test1);
		}

		String SearchField2_1 = getTextBackgroundColor(driver, Search_Filed2);

		System.out.println("SearchField2_1 : " + SearchField2_1);

		if (SearchField2.equals(Expected_FieldColor)) {

			System.out.println("Search2 field Background color Matched || Expected Search2 field color was : "
					+ Expected_FieldColor + " || Actual Search2 field color was " + SearchField2_1);
			Extent_pass(driver,
					"Search2 field Background color Matched || Expected Search2 field color was : "
							+ Expected_FieldColor + " || Actual Search2 field color was " + SearchField2_1,
					test, test1);
		} else {
			System.out.println("Surplus field Background color Not Matched || Expected Search2 field color was : "
					+ Expected_FieldColor + " || Actual Search2 field color was " + SearchField2_1);
			Extent_fail(driver,
					"Search2 field Background color Not Matched || Expected Search2 field color was : "
							+ Expected_FieldColor + " || Actual Search2 field color was " + SearchField2_1,
					test, test1);
		}

		String SearchField3 = getTextBackgroundColor(driver, Search_Filed3);

		System.out.println("SearchField3 : " + SearchField3);

		if (SearchField3.equals(Expected_FieldColor)) {

			System.out.println("Search1 field Background color Matched || Expected Search1 field color was : "
					+ Expected_FieldColor + " || Actual Search1 field color was " + SearchField3);
			Extent_pass(driver, "Search1 field Background color Matched || Expected Search1 field color was : "
					+ Expected_FieldColor + " || Actual Search1 field color was " + SearchField3, test, test1);
		} else {
			System.out.println("Search1 field Background color Not Matched || Expected Search1 field color was : "
					+ Expected_FieldColor + " || Actual Search1 field color was " + SearchField3);
			Extent_fail(driver, "Search1 field Background color Not Matched || Expected Search1 field color was : "
					+ Expected_FieldColor + " || Actual Search1 field color was " + SearchField3, test, test1);
		}

		String SearchField4 = getTextBackgroundColor(driver, Search_Filed4);

		System.out.println("SearchField4 : " + SearchField4);

		if (SearchField4.equals(Expected_FieldColor)) {

			System.out.println("Search2 field Background color Matched || Expected Search2 field color was : "
					+ Expected_FieldColor + " || Actual Search2 field color was " + SearchField4);
			Extent_pass(driver, "Search2 field Background color Matched || Expected Search2 field color was : "
					+ Expected_FieldColor + " || Actual Search2 field color was " + SearchField4, test, test1);
		} else {
			System.out.println("Surplus field Background color Not Matched || Expected Search2 field color was : "
					+ Expected_FieldColor + " || Actual Search2 field color was " + SearchField4);
			Extent_fail(driver, "Search2 field Background color Not Matched || Expected Search2 field color was : "
					+ Expected_FieldColor + " || Actual Search2 field color was " + SearchField4, test, test1);
		}

		System.out
				.println("//***************************Testcase 19 Completed **************************************//");

		Extent_cal(test, " Testcase 31 Ensure all character or alphanumeric fields left justified");

		wait(driver, "5");

		Fluentwait(driver, Grid_1_Report);

		try {
			elementScreenShot_new(driver, Grid_1_Report, "/Expected_screenshot/Elementscreenshot/Alphabetic");
			elementScreenShot_new(driver, Grid_1_Report, "/Actual_screenshot/Elementscreenshot/Alphabetic");
			// imageComparison2(driver, "/Elementscreenshot/Alphabetic",
			// "/Elementscreenshot/Alphabetic");

			if (imageComparison(driver, "/Elementscreenshot/Alphabetic", "/Elementscreenshot/Alphabetic") == true) {

				System.out.println("Alphabetic and it aligned on the left side");
				Extent_pass(driver, "Alphabetic and it aligned on the left side", test, test1);

			} else {

				System.out.println("Alphabetic and it was not aligned on the left side");
				Extent_fail(driver, "Alphabetic and it was not aligned on the left side", test, test1);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		wait(driver, "5");

		Fluentwait(driver, Grid_3_Report);

		try {
			elementScreenShot_new(driver, Grid_3_Report, "/Expected_screenshot/Elementscreenshot/Numeric");
			elementScreenShot_new(driver, Grid_3_Report, "/Actual_screenshot/Elementscreenshot/Numeric");
			// imageComparison2(driver, "/Elementscreenshot/Alphabetic",
			// "/Elementscreenshot/Alphabetic");

			if (imageComparison(driver, "/Elementscreenshot/Numeric", "/Elementscreenshot/Numeric") == true) {

				System.out.println("Numeric and it aligned on the Right side");
				Extent_pass(driver, "Numeric and it aligned on the Right side", test, test1);

			} else {

				System.out.println("Numeric and it was not aligned on the Right side");
				Extent_fail(driver, "Numeric and it was not aligned on the Right side", test, test1);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out
				.println("//***************************Testcase 31 Completed **************************************//");

		Extent_cal(test, " Testcase 32 Ensure  all numeric fields right justified");

		click(driver, Cancel_Report);

		Fluentwait(driver, New_Report);
		click(driver, New_Report);

		Fluentwait(driver, Create_New_Confirm1);
		click(driver, Create_New_Confirm1);

		wait(driver, "5");

		Fluentwait(driver, Search1);
		click(driver, Search1);

		Fluentwait(driver, Globalserach_IDInput);
		sendKeys(driver, Globalserach_IDInput, ID);

		wait(driver, "2");

		Fluentwait(driver, Click_Search);
		click(driver, Click_Search);

		wait(driver, "3");

		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);

		wait(driver, "5");

		Fluentwait(driver, Search2);
		click(driver, Search2);

		wait(driver, "3");

		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);

		wait(driver, "5");

		Fluentwait(driver, Search3);
		click(driver, Search3);

		wait(driver, "3");

		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);

		wait(driver, "5");

		Fluentwait(driver, Search4);
		click(driver, Search4);
		wait(driver, "3");

		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);

		wait(driver, "5");

		Fluentwait(driver, Grid_3_Report);

		try {
			elementScreenShot_new(driver, Grid_3_Report, "/Expected_screenshot/Elementscreenshot/Numeric");
			elementScreenShot_new(driver, Grid_3_Report, "/Actual_screenshot/Elementscreenshot/Numeric");
			// imageComparison2(driver, "/Elementscreenshot/Alphabetic",
			// "/Elementscreenshot/Alphabetic");

			if (imageComparison(driver, "/Elementscreenshot/Numeric", "/Elementscreenshot/Numeric") == true) {

				System.out.println("Numeric and it aligned on the Right side");
				Extent_pass(driver, "Numeric and it aligned on the Right side", test, test1);

			} else {

				System.out.println("Numeric and it was not aligned on the Right side");
				Extent_fail(driver, "Numeric and it was not aligned on the Right side", test, test1);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out
				.println("//***************************Testcase 32 Completed **************************************//");

		wait(driver, "5");

		Extent_cal(test, "Testcase 25 - Ensure text in all fields specified in the correct screen font");

		String SearchFieldFont1 = Getcssvalue(driver, Search_Filed1, "font-family");

		System.out.println("fontfamily : " + SearchFieldFont1);

		if (SearchFieldFont1.equals(Expected_FontFamily)) {

			System.out.println("Search1 font family Matched || Expected Font family of Search1 field text is : "
					+ Expected_FontFamily + " || Actual font family of Search1 field text is : " + SearchFieldFont1);
			Extent_pass(driver, "From year Search1 Matched || Expected Font family of Search1 field text is : "
					+ Expected_FontFamily + " || Actual font family of Search1 field text is : " + SearchFieldFont1,
					test, test1);
		} else {
			System.out.println("Search1 font family Not Matched || Expected Font family of Search1 field text is : "
					+ Expected_FontFamily + " || Actual font family of Search1 field text is : " + SearchFieldFont1);
			Extent_fail(driver, " Search1 font family Not Matched || Expected Font family of Search1 field text is : "
					+ Expected_FontFamily + " || Actual font family of Search1 field text is : " + SearchFieldFont1,
					test, test1);

		}

		String SearchFieldFont2 = Getcssvalue(driver, Search_Filed2, "font-family");

		System.out.println("fontfamily : " + SearchFieldFont2);

		if (SearchFieldFont2.equals(Expected_FontFamily)) {

			System.out.println("Search2 font family Matched || Expected Font family of Search2 field text is : "
					+ Expected_FontFamily + " || Actual font family of Search2 field text is : " + SearchFieldFont2);
			Extent_pass(driver, "Search2 font family Matched || Expected Font family of Search2 field text is : "
					+ Expected_FontFamily + " || Actual font family of Search2 field text is : " + SearchFieldFont2,
					test, test1);
		} else {
			System.out.println("Search2 font family Not Matched || Expected Font family of Search2 field text is : "
					+ Expected_FontFamily + " || Actual font family of Search2 field text is : " + SearchFieldFont2);
			Extent_fail(driver, "Search2 font family Not Matched || Expected Font family of Search2 field text is : "
					+ Expected_FontFamily + " || Actual font family of Search2 field text is : " + SearchFieldFont2,
					test, test1);

		}

		String SearchFieldFont3 = Getcssvalue(driver, Search_Filed3, "font-family");

		System.out.println("fontfamily : " + SearchFieldFont3);

		if (SearchFieldFont3.equals(Expected_FontFamily)) {

			System.out.println("Search3 font family Matched || Expected Font family of Search3 field text is : "
					+ Expected_FontFamily + " || Actual font family of Search3 field text is : " + SearchFieldFont3);
			Extent_pass(driver, "Search3 font family Matched || Expected Font family of Search3 field text is : "
					+ Expected_FontFamily + " || Actual font family of Search3 field text is : " + SearchFieldFont3,
					test, test1);
		} else {
			System.out.println("Search3 font family Not Matched || Expected Font family of Search3 field text is : "
					+ Expected_FontFamily + " || Actual font family of Search3 field text is : " + SearchFieldFont3);
			Extent_fail(driver, "  font family Not Matched || Expected Font family of Search3 field text is : "
					+ Expected_FontFamily + " || Actual font family of From Search3 text is : " + SearchFieldFont3,
					test, test1);

		}

		String SearchFieldFont4 = Getcssvalue(driver, Search_Filed4, "font-family");

		System.out.println("fontfamily : " + SearchFieldFont4);

		if (SearchFieldFont4.equals(Expected_FontFamily)) {

			System.out.println("Search4 font family Matched || Expected Font family of Search4 field text is : "
					+ Expected_FontFamily + " || Actual font family of Search4 field text is : " + SearchFieldFont4);
			Extent_pass(driver, "Search4 font family Matched || Expected Font family of Search4 field text is : "
					+ Expected_FontFamily + " || Actual font family of Search4 field text is : " + SearchFieldFont4,
					test, test1);
		} else {
			System.out.println("Search4 font family Not Matched || Expected Font family of Search4 field text is : "
					+ Expected_FontFamily + " || Actual font family of Search4 field text is : " + SearchFieldFont4);
			Extent_fail(driver, "Search4 font family Not Matched || Expected Font family of Search4 field text is : "
					+ Expected_FontFamily + " || Actual font family of Search4 field text is : " + SearchFieldFont4,
					test, test1);

		}

		wait(driver, "5");

		for (int i = 1; i <= 19; i++) {

			WebElement gridfields = driver.findElement(By.xpath("(//tr[@data-ri='" + i + "'])[1]"));

			Actions action1 = new Actions(driver);

			action1.moveToElement(gridfields).build().perform();

			String Grid_field_fonts = Getcssvalue_webelement(driver, gridfields, "font-family");

			String Columname = getAttribute_webelement(driver, gridfields, "data-ri");

			if (Grid_field_fonts.equals(Expected_FontFamily)) {

				System.out.println("Grid fields font family Matched || Expected Font family of Grid field " + Columname
						+ " is : " + Expected_FontFamily + " || Actual font family of Grid field " + Columname
						+ " is : " + Grid_field_fonts);
				Extent_pass(driver,
						"Grid fields font family Matched || Expected Font family of Grid field " + Columname + " is : "
								+ Expected_FontFamily + " || Actual font family of Grid field " + Columname + " is : "
								+ Grid_field_fonts,
						test, test1);
			} else {
				System.out.println("Grid fields font family Not Matched || Expected Font family of Grid field "
						+ Columname + " is : " + Expected_FontFamily + " || Actual font family of Grid field "
						+ Columname + " is : " + Grid_field_fonts);
				Extent_fail(driver,
						"Grid fields font family Not Matched || Expected Font family of Grid field " + Columname
								+ " is : " + Expected_FontFamily + " " + "|| Actual font family of Grid field "
								+ Columname + " is : " + Grid_field_fonts,
						test, test1);

			}

		}

		System.out
				.println("//***************************Testcase 25 Completed **************************************//");

		Extent_cal(test, "Testcase 27 - Ensure all the field edits boxes aligned perfectly on the screen");

		// Fluentwait(driver, New);
		// click(driver, New);

		// Fluentwait(driver, createnew_confirm);
		// click(driver, createnew_confirm);

		wait(driver, "3");

		List<String> editfields = Arrays.asList("Surplus Location", "Deficit Location", "Quantity", "Cost per Qty(USD");

		List<String> Xposition = Arrays.asList(SurplusLocation_X, DeficitLocation_X, Quantity_X, CostperQtyUSD_X);

		List<String> Yposition = Arrays.asList(SurplusLocation_Y, DeficitLocation_Y, Quantity_Y, CostperQtyUSD_Y);

		boolean editfield = true;

		for (int i = 0; i < 4; i++) {

			String field1 = editfields.get(i);

			String Expected_XPosition = Xposition.get(i);

			String Expected_YPosition = Yposition.get(i);

			WebElement Editfield = driver
					.findElement(By.xpath("(//span[text()='" + field1 + "']/following::input)[1]"));

			Point Editfieldlocation = Editfield.getLocation();

			int Editfield_xposition = Editfieldlocation.getX();

			String actual_Editfield_XPosition = String.valueOf(Editfield_xposition);

			System.out.println("xposition :" + actual_Editfield_XPosition);

			int Editfield_yposition = Editfieldlocation.getY();

			String actual_Editfield_YPosition = String.valueOf(Editfield_yposition);

			System.out.println("yposition :" + actual_Editfield_YPosition);

			if (actual_Editfield_XPosition.equals(Expected_XPosition)
					&& actual_Editfield_YPosition.equals(Expected_YPosition)) {

				Extent_pass(
						driver, "Expected " + field1 + " Edit field X position is : " + Expected_XPosition
								+ " || Actual " + field1 + " Edit field X position is : " + actual_Editfield_XPosition,
						test, test1);
				Extent_pass(
						driver, "Expected " + field1 + " Edit field Y position is : " + Expected_YPosition
								+ " || Actual " + field1 + " Edit field Y position is : " + actual_Editfield_YPosition,
						test, test1);

			} else {

				Extent_fail(
						driver, "Expected " + field1 + " Edit field X position is : " + Expected_XPosition
								+ " || Actual " + field1 + " Edit field X position is : " + actual_Editfield_XPosition,
						test, test1);
				Extent_fail(
						driver, "Expected " + field1 + " Edit field Y position is : " + Expected_YPosition
								+ " || Actual " + field1 + " Edit field Y position is : " + actual_Editfield_YPosition,
						test, test1);

				editfield = false;
			}

		}

		if (editfield) {
			Extent_pass(driver, "Edit field boxes are alligned properly in the screen", test, test1);
		} else {
			Extent_fail(driver, "Edit field boxes are not alligned properly in the screen", test, test1);
		}

		System.out
				.println("//***************************Testcase 27 Completed **************************************//");

		Extent_cal(test, "Testcase 33 - Ensure all the error message text spell correctly on this screen");

		Extent_cal(test, "Error message1 text spell correctly on this screen");

		Fluentwait(driver, Cancel_Report);
		click(driver, Cancel_Report);

		Fluentwait(driver, New_Report);
		click(driver, New_Report);

		Fluentwait(driver, Create_New_Confirm1);
		click(driver, Create_New_Confirm1);

		wait(driver, "3");

		click(driver, Search4);

		wait(driver, "3");

		String Message_text = getText(driver, Popup_Msg_Report);

		System.out.println("Message_text : " + Message_text);
		wait(driver, "3");

		if (Message_text.equals(Messagetext)) {
			System.out.println("Matched || Expected Message Text was : " + Messagetext
					+ " || Actual Message Text was : " + Message_text);
			Extent_pass(driver, "Matched || Expected Message Text was : " + Messagetext
					+ " || Actual Message Text was : " + Message_text, test, test1);
		} else {
			System.out.println("Not Matched || Expected Message Text was : " + Messagetext
					+ " || Actual Message Text was : " + Message_text);
			Extent_fail2(driver, "Not Matched || Expected Message Text was : " + Messagetext
					+ " || Actual Message Text was : " + Message_text, test);

		}

		wait(driver, "3");

		click(driver, Click_Ok_Report);

		System.out
				.println("//***************************Testcase 33 Completed **************************************//");

		Extent_cal(test, "Testcase 34 - Ensure all user input captured in UPPER case or lowercase consistently");

		wait(driver, "5");

		Fluentwait(driver, Search1);
		click(driver, Search1);

		Fluentwait(driver, Globalserach_IDInput);
		sendKeys(driver, Globalserach_IDInput, ID);

		wait(driver, "2");

		Fluentwait(driver, Click_Search);
		click(driver, Click_Search);

		wait(driver, "3");

		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);

		wait(driver, "5");

		Fluentwait(driver, Search2);
		click(driver, Search2);

		wait(driver, "3");

		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);

		wait(driver, "5");

		Fluentwait(driver, Search3);
		click(driver, Search3);

		wait(driver, "3");

		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);

		wait(driver, "5");

		Fluentwait(driver, Search4);
		click(driver, Search4);
		wait(driver, "3");

		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);

		wait(driver, "5");
		
		Extent_cal(test, "Grid1");


		sendKeys(driver, Surplus_Location_Textfield, FieldInput_name);
		
		String Field_name = FieldInput_name.toUpperCase();
		System.out.println("Field_name :" + Field_name);


		wait(driver, "3");
		
		List<WebElement> Surplus_To_Deficient_Movement = driver.findElements(By.xpath("//tbody[@id='ERD-ERD_Version1DGrid_data']//tr//td[1]"));
		for (WebElement Data_1 :Surplus_To_Deficient_Movement) {
             String Data1 = Data_1.getText();
			if(Data1.equals(Field_name)) {
				System.out.println("Matched ||Grid is Capturing both Upper case and lower case letters|| Expected Grid Value was : " + Data1
						+ "  || Actual Grid Value was : " + Field_name);
				Extent_pass(driver, "Matched ||Grid is Capturing both Upper case and lower case letters|| Expected Grid Value was : "
						+ Data1 + "  || Actual Grid Value was : " + Field_name,
						test,test1);
			} else {
				System.out.println(
						"Not Matched || Grid is not capturing both Upper case and lower case letters|| Expected Grid Value was : " + Data1
								+ "  || Actual Grid Value was : " + Field_name);
				Extent_fail2(driver, "Not Matched || Grid is not capturing both Upper case and lower case letters|| Expected Grid Value was : "
						+ Data1 + "  || Actual Grid Value was : " + Field_name,
						test);

			}
		
		}
		
		clear(driver, Surplus_Location_Textfield);
		
		
		Extent_cal(test, "Grid2");


		sendKeys(driver, Edit_Field2, FieldInput_name1);
		
		String Field_name1 = FieldInput_name1.toUpperCase();
		System.out.println("Field_name1 :" + Field_name1);


		wait(driver, "3");
		
		List<WebElement> Surplus_To_Deficient_Movement1 = driver.findElements(By.xpath("//tbody[@id='ERD-ERD_Version1DGrid_data']//tr//td[2]"));
		for (WebElement Data_2 :Surplus_To_Deficient_Movement1) {
             String Data2 = Data_2.getText();
			if(Data2.equals(Field_name1)) {
				System.out.println("Matched ||Grid is Capturing both Upper case and lower case letters|| Expected Grid Value was : " + Data2
						+ "  || Actual Grid Value was : " + Field_name1);
				Extent_pass(driver, "Matched ||Grid is Capturing both Upper case and lower case letters|| Expected Grid Value was : "
						+ Data2 + "  || Actual Grid Value was : " + Field_name1,
						test,test1);
			} else {
				System.out.println(
						"Not Matched || Grid is not capturing both Upper case and lower case letters|| Expected Grid Value was : " + Data2
								+ "  || Actual Grid Value was : " + Field_name1);
				Extent_fail2(driver, "Not Matched || Grid is not capturing both Upper case and lower case letters|| Expected Grid Value was : "
						+ Data2 + "  || Actual Grid Value was : " + Field_name1,
						test);

			}
		
		}
		
		clear(driver, Edit_Field2);
		
		
		
		System.out
				.println("//***************************Testcase 34 Completed **************************************//");

		Extent_cal(test, "Testcase 36 - Ensure that all windows have a consistent look and feel");

		// click(driver, Cancel_Report);

		wait(driver, "5");

		takescreenshot(driver, "//Expected_screenshot//ERO Devation Report//screen");
		takescreenshot(driver, "//Actual_screenshot//ERO Devation Report//screen");

		if (imageComparison2(driver, "//ERO Devation Report//screen", "//ERO Devation Report//screen") == true) {

			System.out.println("First windows have a consistent look and feel");
			Extent_pass(driver, "First windows have a consistent look and feel", test, test1);
		} else {

			System.out.println("First window will be showing different look and feel than the expected");
			Extent_fail(driver, "First window will be showing different look and feel than the expected", test, test1);
		}

		Fluentwait(driver, Searchbox);
		sendKeys(driver, Searchbox, "ERO Deviation report");

		Fluentwait(driver, Select_Deviation);
		click(driver, Select_Deviation);

		wait(driver, "3");

		Fluentwait(driver, Newtab_confirm_Report);
		click(driver, Newtab_confirm_Report);

		switchtotab(driver, 1);

		takescreenshot(driver, "//Expected_screenshot//ERO Devation Report//screen2");
		takescreenshot(driver, "//Actual_screenshot//ERO Devation Report//screen2");

		if (imageComparison2(driver, "//ERO Devation Report//screen2", "//ERO Devation Report//screen2") == true) {

			System.out.println("Second window have a consistent look and feel");
			Extent_pass(driver, "Second window have a consistent look and feel", test, test1);
		} else {

			System.out.println("Second window will be showing different look and feel than the expected");
			Extent_fail(driver, "Second window will be showing different look and feel than the expected", test, test1);
		}

		System.out
				.println("//***************************Testcase 36 Completed **************************************//");

	}

}
