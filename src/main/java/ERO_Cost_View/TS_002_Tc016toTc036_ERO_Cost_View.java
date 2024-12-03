package ERO_Cost_View;

import java.awt.AWTException;
import java.io.IOException;
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

public class TS_002_Tc016toTc036_ERO_Cost_View extends Keywords {
	public void Scenario002(WebDriver driver, ExtentTest test, ExtentTest test1, String url, int dataset)
			throws AWTException, IOException {

		String Username = Utils.getDataFromTestData("TS_002_Tc016toTc036_ERO_Cost_View_Dataset" + dataset,
				"ERO_Cost_View", "Username");
		String Password = Utils.getDataFromTestData("TS_002_Tc016toTc036_ERO_Cost_View_Dataset" + dataset,
				"ERO_Cost_View", "Password");
		String Expected_screencolor = Utils.getDataFromTestData("TS_002_Tc016toTc036_ERO_Cost_View_Dataset" + dataset,
				"ERO_Cost_View", "Screen_background");
		String Expected_FieldColor = Utils.getDataFromTestData("TS_002_Tc016toTc036_ERO_Cost_View_Dataset" + dataset,
				"ERO_Cost_View", "Fieldcolor1");
		String Expected_FontFamily = Utils.getDataFromTestData("TS_002_Tc016toTc036_ERO_Cost_View_Dataset" + dataset,
				"ERO_Cost_View", "FontFamily1");

		WebDriverWait wait = new WebDriverWait(driver, 30);

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

		Extent_cal(test, "Testcase 16 - Ensure that the screen background should be in correct color");

		Fluentwait(driver, Screen_Background);
		String actualscreencolor = getTextBackgroundColor(driver, Screen_Background);

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

		Extent_cal(test, "Testcase 19 - Ensure that the read only mode field background should be in correct color");

		wait(driver, "3");

		click(driver, Plus_Button);

		wait(driver, "5");

		Fluentwait(driver, Loc_Search_Cost_View);
		click(driver, Loc_Search_Cost_View);
		wait(driver, "3");

		doubleClick(driver, Select_Loc_Code);

		wait(driver, "3");

		click(driver, Cost_View_ShowButton);
		wait(driver, "2");

		String Field1 = getTextBackgroundColor(driver, Location_Field1);

		System.out.println("Field1 : " + Field1);

		if (Field1.equals(Expected_FieldColor)) {

			System.out.println("Field1 Background color Matched || Expected Field1 color was : " + Expected_FieldColor
					+ " || Actual Field1 color was " + Field1);
			Extent_pass(driver, "Search1 Field1 Background color Matched || Expected Field1 color was : "
					+ Expected_FieldColor + " || Actual Field1 color was " + Field1, test, test1);
		} else {
			System.out.println("Field1 color Not Matched || Expected Field1 color was : " + Expected_FieldColor
					+ " || Actual Field1 color was " + Field1);
			Extent_fail(driver, "Field1 Background color Not Matched || Expected Search1 field color was : "
					+ Expected_FieldColor + " || Actual Field1 color was " + Field1, test, test1);
		}

		String Field2 = getTextBackgroundColor(driver, Location_Field2);

		System.out.println("Field2 : " + Field2);

		if (Field2.equals(Expected_FieldColor)) {

			System.out.println("Field1 Background color Matched || Expected Field1 color was : " + Expected_FieldColor
					+ " || Actual Field1 color was " + Field2);
			Extent_pass(driver, "Search1 Field1 Background color Matched || Expected Field1 color was : "
					+ Expected_FieldColor + " || Actual Field1 color was " + Field2, test, test1);
		} else {
			System.out.println("Field1 color Not Matched || Expected Field1 color was : " + Expected_FieldColor
					+ " || Actual Field1 color was " + Field2);
			Extent_fail(driver, "Field1 Background color Not Matched || Expected Search1 field color was : "
					+ Expected_FieldColor + " || Actual Field1 color was " + Field2, test, test1);
		}
		System.out
				.println("//***************************Testcase 19 Completed **************************************//");

		Extent_cal(test, "Testcase 24 - Ensure text in all fields specified in the correct screen font");

		wait(driver, "3");

		String Font_Field1 = Getcssvalue(driver, Location_Field1, "font-family");

		System.out.println("fontfamily : " + Font_Field1);

		if (Font_Field1.equals(Expected_FontFamily)) {

			System.out.println("Font_Field1 font family Matched || Expected Font family of Font_Field1 field text is : "
					+ Expected_FontFamily + " || Actual font family of Font_Field1 field text is : " + Font_Field1);
			Extent_pass(driver, "From year Search1 Matched || Expected Font family of Font_Field1 field text is : "
					+ Expected_FontFamily + " || Actual font family of Font_Field1 field text is : " + Font_Field1,
					test, test1);
		} else {
			System.out.println(
					"Font_Field1 font family Not Matched || Expected Font family of Font_Field1 field text is : "
							+ Expected_FontFamily + " || Actual font family of Font_Field1 field text is : "
							+ Font_Field1);
			Extent_fail(driver,
					" Font_Field1 font family Not Matched || Expected Font family of Font_Field1 field text is : "
							+ Expected_FontFamily + " || Actual font family of Search1 field text is : " + Font_Field1,
					test, test1);

		}

		String Font_Field2 = Getcssvalue(driver, Location_Field1, "font-family");

		System.out.println("fontfamily : " + Font_Field2);

		if (Font_Field2.equals(Expected_FontFamily)) {

			System.out.println("Search2 font family Matched || Expected Font family of Font_Field2 field text is : "
					+ Expected_FontFamily + " || Actual font family of Font_Field2 field text is : " + Font_Field2);
			Extent_pass(driver, "Search2 font family Matched || Expected Font family of Font_Field2 field text is : "
					+ Expected_FontFamily + " || Actual font family of Font_Field2 field text is : " + Font_Field2,
					test, test1);
		} else {
			System.out.println("Search2 font family Not Matched || Expected Font family of Font_Field2 field text is : "
					+ Expected_FontFamily + " || Actual font family of Font_Field2 field text is : " + Font_Field2);
			Extent_fail(driver,
					"Search2 font family Not Matched || Expected Font family of Font_Field2 field text is : "
							+ Expected_FontFamily + " || Actual font family of Font_Field2 field text is : "
							+ Font_Field2,
					test, test1);

		}

		wait(driver, "5");

		for (int i = 1; i <= 17; i++) {

			WebElement gridfields1 = driver.findElement(By.xpath("(//div[@ref='eLabel'])['" + i + "']"));

			Actions action1 = new Actions(driver);

			action1.moveToElement(gridfields1).build().perform();

			String Grid_field_fonts = Getcssvalue_webelement(driver, gridfields1, "font-family");

			String Columname = getAttribute_webelement(driver, gridfields1, "ref");

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

		wait(driver, "5");

		for (int i = 1; i <= 17; i++) {

			WebElement gridfields = driver.findElement(By.xpath("(//div[@aria-colindex='" + i + "'])[1]"));

			Actions action1 = new Actions(driver);

			action1.moveToElement(gridfields).build().perform();

			String Grid_field_fonts2 = Getcssvalue_webelement(driver, gridfields, "font-family");

			String Columname2 = getAttribute_webelement(driver, gridfields, "aria-colindex");

			if (Grid_field_fonts2.equals(Expected_FontFamily)) {

				System.out.println("Grid fields font family Matched || Expected Font family of Grid field " + Columname2
						+ " is : " + Expected_FontFamily + " || Actual font family of Grid field " + Columname2
						+ " is : " + Grid_field_fonts2);
				Extent_pass(driver,
						"Grid fields font family Matched || Expected Font family of Grid field " + Columname2 + " is : "
								+ Expected_FontFamily + " || Actual font family of Grid field " + Columname2 + " is : "
								+ Grid_field_fonts2,
						test, test1);
			} else {
				System.out.println("Grid fields font family Not Matched || Expected Font family of Grid field "
						+ Columname2 + " is : " + Expected_FontFamily + " || Actual font family of Grid field "
						+ Columname2 + " is : " + Grid_field_fonts2);
				Extent_fail(driver,
						"Grid fields font family Not Matched || Expected Font family of Grid field " + Columname2
								+ " is : " + Expected_FontFamily + " " + "|| Actual font family of Grid field "
								+ Columname2 + " is : " + Grid_field_fonts2,
						test, test1);

			}

		}

		System.out
				.println("//***************************Testcase 24 Completed **************************************//");

		Extent_cal(test, "Testcase 33 - Ensure all user input captured in UPPER case or lowercase consistently");

		wait(driver, "3");

		Fluentwait(driver, Columns_Cost_View);
		click(driver, Columns_Cost_View);

		wait(driver, "2");

		for (int i = 1; i <= 2; i++) {

			String FieldInput_name_Data = Utils.getDataFromTestData("TS_002_Fieldvalue_Dataset" + dataset,
					"ERO_Cost_View", "Fieldvalue" + i);
			wait(driver, "2");

			Fluentwait(driver, ColumnFilter_Input_CostView);
			clear(driver, ColumnFilter_Input_CostView);
			sendKeys(driver, ColumnFilter_Input_CostView, FieldInput_name_Data);

			wait(driver, "3");

			// elementScreenShot_new(driver, ColumnFilter_field_CostView,
			// "/Expected_screenshot/ERO Cost View/filter"+i);

			elementScreenShot_new(driver, ColumnFilter_field_CostView, "/Actual_screenshot/ERO Cost View/filter" + i);

			if (imageComparison2(driver, "//ERO Cost View//filter" + i, "//ERO Cost View//filter" + i) == true) {

				System.out
						.println("Filter is capturing both Upper case and lower case letters and the given value was : "
								+ FieldInput_name_Data);
				Extent_pass(driver,
						"Filter is capturing both Upper case and lower case letters and the given value was : "
								+ FieldInput_name_Data,
						test, test1);
			} else {

				System.out.println(
						"Filter is not capturing both Upper case and lower case letters and the given value was : "
								+ FieldInput_name_Data);
				Extent_fail(driver,
						"Filter is not capturing both Upper case and lower case letters and the given value was : "
								+ FieldInput_name_Data,
						test, test1);
			}

			WebElement columnfilter = driver
					.findElement(By.xpath("((//span[text()='Columns'])[1]/following::span[text()='Cost Type'])[2]"));

			if (!isDisplayed1(driver, columnfilter)) {

				System.out
						.println("Filter is capturing both Upper case and lower case letters and the given value was : "
								+ FieldInput_name_Data);
				Extent_pass(driver,
						"Filter is capturing both Upper case and lower case letters and the given value was : "
								+ FieldInput_name_Data,
						test, test1);
			} else {

				System.out.println(
						"Filter is not capturing both Upper case and lower case letters and the given value was : "
								+ FieldInput_name_Data);
				Extent_fail(driver,
						"Filter is not capturing both Upper case and lower case letters and the given value was : "
								+ FieldInput_name_Data,
						test, test1);
			}

		}

		for (int i = 3; i <= 17; i++) {

			wait(driver, "2");

			String FieldInput_name_Data = Utils.getDataFromTestData("TS_002_Fieldvalue_Dataset" + dataset,
					"ERO_Cost_View", "Fieldvalue" + i);

			Fluentwait(driver, ColumnFilter_Input_CostView);
			clear(driver, ColumnFilter_Input_CostView);
			sendKeys(driver, ColumnFilter_Input_CostView, FieldInput_name_Data);

			wait(driver, "3");

//				elementScreenShot_new(driver, ColumnFilter_field, "/Expected_screenshot/Deficit/filter" + i);

			elementScreenShot_new(driver, ColumnFilter_field_CostView, "/Actual_screenshot/CostView/filter" + i);

			if (imageComparison2(driver, "//CostView//filter" + i, "//CostView//filter" + i) == true) {

				System.out
						.println("Filter is capturing both Upper case and lower case letters and the given value was : "
								+ FieldInput_name_Data);
				Extent_pass(driver,
						"Filter is capturing both Upper case and lower case letters and the given value was : "
								+ FieldInput_name_Data,
						test, test1);
			} else {

				System.out.println(
						"Filter is not capturing both Upper case and lower case letters and the given value was : "
								+ FieldInput_name_Data);
				Extent_fail(driver,
						"Filter is not capturing both Upper case and lower case letters and the given value was : "
								+ FieldInput_name_Data,
						test, test1);
			}

		}

		wait(driver, "2");

		Fluentwait(driver, Columns_Cost_View);
		click(driver, Columns_Cost_View);

		System.out
				.println("//***************************Testcase 33 Completed **************************************//");

	}

}
