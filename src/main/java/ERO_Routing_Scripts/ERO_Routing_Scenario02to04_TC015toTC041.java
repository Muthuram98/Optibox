package ERO_Routing_Scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;
import commonMethods.Utils;

public class ERO_Routing_Scenario02to04_TC015toTC041 extends Keywords {

	public void ERO_Scenario2(WebDriver driver, ExtentTest test, ExtentTest test1, String url, int dataset)
			throws Exception {

		String Username = Utils.getDataFromTestData("TS002toTS004_EroRouting_TC15to41_Dataset" + dataset, "ERO Routing",
				"Username");
		String Password = Utils.getDataFromTestData("TS002toTS004_EroRouting_TC15to41_Dataset" + dataset, "ERO Routing",
				"Password");
		String ID = Utils.getDataFromTestData("TS002toTS004_EroRouting_TC15to41_Dataset" + dataset, "ERO Routing",
				"Id");
		String Expected_Autogeneratedcolorcode = Utils.getDataFromTestData(
				"TS002toTS004_EroRouting_TC15to41_Dataset" + dataset, "ERO Routing", "Autogenerated_Color");
		String Expected_FontFamily2 = Utils.getDataFromTestData("TS002toTS004_EroRouting_TC15to41_Dataset" + dataset,
				"ERO Routing", "FontFamily2");
		String Expected_screencolor = Utils.getDataFromTestData("TS002toTS004_EroRouting_TC15to41_Dataset" + dataset,
				"ERO Routing", "Screen_background");
		String Expected_readonlycolor = Utils.getDataFromTestData("TS002toTS004_EroRouting_TC15to41_Dataset" + dataset,
				"ERO Routing", "Readonly_color");
		String Error_text = Utils.getDataFromTestData("TS002toTS004_EroRouting_TC15to41_Dataset" + dataset,
				"ERO Routing", "Error_text");
		String Expected_Version_Xposition = Utils.getDataFromTestData(
				"TS002toTS004_EroRouting_TC15to41_Dataset" + dataset, "ERO Routing", "Version_Xposition");
		String Expected_Version_Yposition = Utils.getDataFromTestData(
				"TS002toTS004_EroRouting_TC15to41_Dataset" + dataset, "ERO Routing", "Version_Yposition");
		String Expected_XPosition = Utils.getDataFromTestData("TS002toTS004_EroRouting_TC15to41_Dataset" + dataset,
				"ERO Routing", "Sizetype_Xposition");
		String Expected_YPosition = Utils.getDataFromTestData("TS002toTS004_EroRouting_TC15to41_Dataset" + dataset,
				"ERO Routing", "Sizetype_Yposition");

		Actions action = new Actions(driver);

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

		Fluentwait(driver, Searchbox);
		sendKeys(driver, Searchbox, "ERO Routing");

		Fluentwait(driver, SelectERO);
		click(driver, SelectERO);

		wait(driver, "5");

		Extent_cal(test, "Testcase 15 - Ensure that the screen background should be in correct color");

		Fluentwait(driver, Screen);
		String actualscreencolor = getTextBackgroundColor(driver, Screen);

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
				.println("//***************************Testcase 15 Completed **************************************//");

		Extent_pass(driver, "Testcase 18 - Ensure that the read only mode field background should be in correct color",
				test, test1);

		Scrolltilltheelementvisible(driver, Route_detailscount);

		String routedetails_color = getTextBackgroundColor(driver, Route_detailscount);

		System.out.println(routedetails_color);

		if (routedetails_color.equals(Expected_readonlycolor)) {

			System.out.println("Route Details Count field background color showing as expected");
			Extent_pass(driver, "Route Details Count field background color showing as expected", test, test1);
			Extent_pass(driver, "Expected background color code is : " + Expected_readonlycolor
					+ " || Actual background color was : " + routedetails_color, test, test1);
		} else {
			System.out.println("Route Details Count field background color not showing as expected");
			Extent_fail(driver, "Route Details Count field background color not showing as expected", test, test1);
			Extent_fail(driver, "Expected background color code is : " + Expected_readonlycolor
					+ " || Actual background color was : " + routedetails_color, test, test1);
		}

		String unavailable_color = getTextBackgroundColor(driver, UnavailableRoute_scount);

		if (unavailable_color.equals(Expected_readonlycolor)) {

			System.out.println("Un Available Route Count field background color showing as expected");
			Extent_pass(driver, "Un Available Route Count field background color showing as expected", test, test1);
			Extent_pass(driver, "Expected background color code is : " + Expected_readonlycolor
					+ " || Actual background color was : " + routedetails_color, test, test1);
		} else {
			System.out.println("Un Available Route Count field background color not showing as expected");
			Extent_fail(driver, "Un Available Route Count field background color not showing as expected", test, test1);
			Extent_fail(driver, "Expected background color code is : " + Expected_readonlycolor
					+ " || Actual background color was : " + routedetails_color, test, test1);
		}

		System.out.println(unavailable_color);

		System.out.println("Testcase 18 completed");

		scrollBottom(driver);

		Extent_cal(test,
				"Testcase 20 - Ensure that the auto generated and reference no field should be highlighted with SVM standard color");

		Fluentwait(driver, Routing_GlobalSearch);
		click(driver, Routing_GlobalSearch);

		Fluentwait(driver, Globalserach_IDInput);
		sendKeys(driver, Globalserach_IDInput, ID);

		Fluentwait(driver, Click_Search);
		click(driver, Click_Search);

		wait(driver, "3");
		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);

		wait(driver, "3");

		Fluentwait(driver, ERO_popup_ok);
		click(driver, ERO_popup_ok);

		wait(driver, "2");

		String ID_Backroundcolor = getTextBackgroundColor(driver, Routing_ID);

		System.out.println("Fromyear_Backroundcolor : " + ID_Backroundcolor);

		if (ID_Backroundcolor.equals(Expected_Autogeneratedcolorcode)) {

			System.out.println("Id field Background color Matched || Expected ID field color was : "
					+ Expected_Autogeneratedcolorcode + " || Actual ID field color was " + ID_Backroundcolor);
			Extent_pass(driver,
					"Id field Background color Matched || Expected ID field color was : "
							+ Expected_Autogeneratedcolorcode + " || Actual ID field color was " + ID_Backroundcolor,
					test, test1);
		} else {
			System.out.println("Id field Background color Not Matched || Expected ID field color was : "
					+ Expected_Autogeneratedcolorcode + " || Actual ID field color was " + ID_Backroundcolor);
			Extent_fail(driver,
					"Id field Background color Not Matched || Expected ID field color was : "
							+ Expected_Autogeneratedcolorcode + " || Actual ID field color was " + ID_Backroundcolor,
					test, test1);
		}

		System.out.println("Testcase 20 completed");

		Extent_cal(test, "Testcase 24 - Ensure text in all fields specified in the correct screen font");

		String FromYearfontfamily = Getcssvalue(driver, Routing_ID, "font-family");

		System.out.println("fontfamily : " + FromYearfontfamily);

		if (FromYearfontfamily.equals(Expected_FontFamily2)) {

			System.out.println("From year font family Matched || Expected Font family of From Year field text is : "
					+ Expected_FontFamily2 + " || Actual font family of From Year field text is : "
					+ FromYearfontfamily);
			Extent_pass(driver,
					"From year font family Matched || Expected Font family of From Year field text is : "
							+ Expected_FontFamily2 + " || Actual font family of From Year field text is : "
							+ FromYearfontfamily,
					test, test1);
		} else {
			System.out.println("From year font family Not Matched || Expected Font family of From Year field text is : "
					+ Expected_FontFamily2 + " || Actual font family of From Year field text is : "
					+ FromYearfontfamily);
			Extent_fail(driver,
					"From year font family Not Matched || Expected Font family of From Year field text is : "
							+ Expected_FontFamily2 + " || Actual font family of From Year field text is : "
							+ FromYearfontfamily,
					test, test1);
		}

		System.out.println("Testcase 24 completed");

		Extent_cal(test, "Testcase 33 - Ensure all user input captured in UPPER case or lowercase consistently");

		Fluentwait(driver, ColumnFilter);
		click(driver, ColumnFilter);

		boolean filter = true;

		for (int i = 1; i <= 2; i++) {

			wait(driver, "2");

			String FieldInput_name = Utils.getDataFromTestData("TS002_ERO_Routing_Field", "ERO Routing",
					"Filterfield" + i);

			Fluentwait(driver, ColumnFilter_Input);
			clear(driver, ColumnFilter_Input);
			sendKeys(driver, ColumnFilter_Input, FieldInput_name);

			elementScreenShot_new(driver, ColumnFilter_field, "/Actual_screenshot/ERO/ERO_filter" + i);

			if (imageComparison2(driver, "//ERO//ERO_filter" + i, "//ERO//ERO_filter" + i) == true) {

				System.out
						.println("Filter is capturing both Upper case and lower case letters and the given value was : "
								+ FieldInput_name);
				Extent_pass(driver,
						"Filter is capturing both Upper case and lower case letters and the given value was : "
								+ FieldInput_name,
						test, test1);
			} else {

				System.out.println(
						"Filter is not capturing both Upper case and lower case letters and the given value was : "
								+ FieldInput_name);
				Extent_fail(driver,
						"Filter is not capturing both Upper case and lower case letters and the given value was : "
								+ FieldInput_name,
						test, test1);
				filter = false;
			}

		}

		if (filter) {

			System.out.println("Filter input is capturing both upper and lower case consistently");
			Extent_pass(driver, "Filter input is capturing both upper and lower case consistently", test, test1);
		} else {
			System.out.println("Filter input is not capturing upper/lower case values");
			Extent_fail(driver, "Filter input is not capturing upper/lower case values", test, test1);
		}

		wait(driver, "2");

		Fluentwait(driver, ColumnFilter);
		click(driver, ColumnFilter);

		Extent_cal(test, "Testcase 26 - Ensure all the field edits boxes aligned perfectly on the screen");

		wait(driver, "3");

		WebElement Editfield = driver.findElement(By.xpath("//label[@id='ERU-ERU_cmbSizetype_label']"));

		Point Editfieldlocation = Editfield.getLocation();

		int Editfield_xposition = Editfieldlocation.getX();

		String actual_Editfield_XPosition = String.valueOf(Editfield_xposition);

		System.out.println("xposition :" + actual_Editfield_XPosition);

		int Editfield_yposition = Editfieldlocation.getY();

		String actual_Editfield_YPosition = String.valueOf(Editfield_yposition);

		System.out.println("yposition :" + actual_Editfield_YPosition);

		if (actual_Editfield_XPosition.equals(Expected_XPosition)
				&& actual_Editfield_YPosition.equals(Expected_YPosition)) {

			Extent_pass(driver,
					"Expected Size type X position is : " + Expected_XPosition
							+ " || Actual Size type Edit field X position is : " + actual_Editfield_XPosition,
					test, test1);
			Extent_pass(driver,
					"Expected Size type Edit field Y position is : " + Expected_YPosition
							+ " || Actual Size type Edit field Y position is : " + actual_Editfield_YPosition,
					test, test1);
			Extent_pass(driver, "Size type field is placed at correct position", test, test1);

		} else {

			Extent_fail(driver,
					"Expected Size type Edit field X position is : " + Expected_XPosition
							+ " || Actual Size type Edit field X position is : " + actual_Editfield_XPosition,
					test, test1);
			Extent_fail(driver,
					"Expected Size type Edit field Y position is : " + Expected_YPosition
							+ " || Actual Size type Edit field Y position is : " + actual_Editfield_YPosition,
					test, test1);
			Extent_fail(driver, "Size type field is not placed at correct position", test, test1);

		}

		System.out.println("Testcase 26 completed");

		Extent_cal(test,
				" Testcase 30 and Testcase 31 Ensure all character or alphanumeric or numeric fields correctly alligned");

		try {
			for (int i = 2; i <= 22; i++) {

				WebElement gridfields = driver.findElement(By.xpath("(//div[@aria-colindex='" + i + "'])[1]"));

				String gridheader = driver.findElement(By.xpath("(//span[@aria-colindex='" + i + "'])[1]")).getText();

				action.moveToElement(gridfields).build().perform();

				String Grid_field = getTextofWebelement(driver, gridfields, "gridfields");

				String Allignmenttype = determineType(Grid_field);

				System.out.println("Allignmenttype : " + Allignmenttype);

				String attributevalue = getAttribute_webelement(driver, gridfields, "class");

//			String attributevalue = gridfields.getAttribute("class");

				System.out.println("attributevalue : " + attributevalue);

				String allignment = extractDirection(attributevalue);

				if (allignment == null) {
					System.out.println("Unable to determine alignment for column " + gridheader);
//		        Extent_fail(driver, "Unable to determine alignment for column " + Columname, test,test1);
					allignment = "left";
				}

				System.out.println("allignment : " + allignment);

				if (Allignmenttype.equals("Alphabetic")) {

					if (allignment.equals("left")) {

						System.out.println("Column " + gridheader + " is Alphabetic and it aligned on the left side");
						Extent_pass(driver, "Column " + gridheader + " is Alphabetic and it aligned on the left side",
								test, test1);

					} else {
						System.out.println(
								"Column " + gridheader + " is Alphabetic and it was not aligned on the left side");
						Extent_fail(driver,
								"Column " + gridheader + " is Alphabetic and it was not aligned on the left side", test,
								test1);

					}

				}

				if (Allignmenttype.equals("Numeric")) {

					if (allignment.equals("right")) {

						System.out.println("Column " + gridheader + " is Numeric and it aligned on the Right side");
						Extent_pass(driver, "Column " + gridheader + " is Numeric and it aligned on the Right side",
								test, test1);

					} else {
						System.out.println(
								"Column " + gridheader + " is Numeric and it was not aligned on the Right side");
						Extent_fail(driver,
								"Column " + gridheader + " is Numeric and it was not aligned on the Right side", test,
								test1);

					}

				}

				if (Allignmenttype.equals("Alphanumeric")) {

					System.out.println("Column " + gridheader + " is Alpha Numeric ");

				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
		}

		System.out.println("Testcase 30 and 31 completed");

		Extent_cal(test, "Testcase 32 - Ensure all the error message text spelt correctly on this screen");

		Fluentwait(driver, Optimizer);
		click(driver, Optimizer);

		wait(driver, "5");

		Fluentwait(driver, Popup_text);

		String error_text = getText(driver, Popup_text);

		System.out.println("error_text : " + error_text);

		if (error_text.equals(Error_text)) {

			System.out.println("Error message text was spelled correctly");
			Extent_pass(driver, "Error message text was spelled correctly", test, test1);
		} else {

			System.out.println("Error message text was not  spelled correctly");
			Extent_fail(driver, "Error message text was not spelled correctly", test, test1);
		}

		Fluentwait(driver, ERO_Popup_Ok);
		click(driver, ERO_Popup_Ok);

		System.out.println("Testcase 32 completed");

		Extent_cal(test, "Testcase 35 - Ensure that all windows have a consistent look and feel");

		Fluentwait(driver, Close_ero_routing_tab);
		click(driver, Close_ero_routing_tab);

		Fluentwait(driver, Searchbox);
		sendKeys(driver, Searchbox, "ERO Routing");

		Fluentwait(driver, SelectERO);
		click(driver, SelectERO);

		wait(driver, "5");

		Fluentwait(driver, Routing_GlobalSearch);
		click(driver, Routing_GlobalSearch);

		Fluentwait(driver, Globalserach_IDInput);
		sendKeys(driver, Globalserach_IDInput, ID);

		Fluentwait(driver, Click_Search);
		click(driver, Click_Search);

		wait(driver, "3");
		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);

		wait(driver, "3");

		Fluentwait(driver, ERO_popup_ok);
		click(driver, ERO_popup_ok);

		wait(driver, "2");

//		takescreenshot(driver, "//Expected_screenshot//ERO//screen");
		takescreenshot(driver, "//Actual_screenshot//ERO//screen");

		if (imageComparison2(driver, "//Deficit//screen", "//Deficit//screen") == true) {

			System.out.println("Ero routing windows have a consistent look and feel");
			Extent_pass(driver, "First windows have a consistent look and feel", test, test1);
		} else {

			System.out.println("Ero routing window will be showing different look and feel than the expected");
			Extent_fail(driver, "Ero routing window will be showing different look and feel than the expected", test,
					test1);
		}

		System.out.println("Testcase 35 completed");


		Extent_cal(test, " Testcase 38 Ensure Scroll up and down functionality in Grids");

		wait(driver, "5");

//		Fluentwait(driver, Globalserach);
//		click(driver, Globalserach);
//
//		Fluentwait(driver, Globalserach_IDInput);
//		sendKeys(driver, Globalserach_IDInput, ID);
//
//		Fluentwait(driver, Click_Search);
//		click(driver, Click_Search);
//
//		wait(driver, "3");
//		Fluentwait(driver, SelectID);
//		doubleClick(driver, SelectID);
//
//		wait(driver, "5");

		Fluentwait(driver, Gridscroll);

		ScrollBarValidation1(driver, Gridscroll, "Grid scroll");

		System.out
				.println("//***************************Testcase 38 Completed **************************************//");

		Extent_cal(test, "Testcase 39 - Ensure Close button functionality");

		scrollBottom(driver);

		waitForElement(driver, Close_ero_routing_tab);
		click(driver, Close_ero_routing_tab);

		wait(driver, "3");

		if (!isDisplayed(driver, Routing_Tab)) {

			System.out.println("After click on close button Current screen was closed");
			Extent_pass(driver, "After click on close button Current screen was closed", test, test1);

		} else {

			System.out.println("After click on close button Current screen was not closed");
			Extent_fail(driver, "After click on close button Current screen was not closed", test, test1);
		}

		System.out.println("Testcase 39 completed");

		Extent_cal(test, "Testcase 40 Ensure Version is placed at bottom of the left corner of the screen");

		Fluentwait(driver, Searchbox);
		sendKeys(driver, Searchbox, "ERO Routing");

		Fluentwait(driver, SelectERO);
		click(driver, SelectERO);

		wait(driver, "5");

		Scrolltilltheelementvisible(driver, Version);

		try {
			WebElement versionfield = driver.findElement(By.xpath("//label[contains(text(),'Version :')]"));

			Point location = versionfield.getLocation();

			int xposition = location.getX();

			String actual_version_XPosition = String.valueOf(xposition);

			System.out.println("xposition :" + actual_version_XPosition);

			int yposition = location.getY();

			String actual_version_YPosition = String.valueOf(yposition);

			System.out.println("yposition :" + actual_version_YPosition);

			if (actual_version_XPosition.equals(Expected_Version_Xposition)
					&& actual_version_YPosition.equals(Expected_Version_Yposition)) {

				System.out.println("Version field is placed at the bottom of the left corner of the screen");
				Extent_pass(driver, "Expected Version field X position is : " + Expected_Version_Xposition
						+ " || Actual Version field X position is : " + actual_version_XPosition, test, test1);
				Extent_pass(driver, "Expected Version field Y position is : " + Expected_Version_Yposition
						+ " || Actual Version field Y position is : " + actual_version_YPosition, test, test1);
				Extent_pass(driver, "Version field is placed at the bottom of the left corner of the screen", test,
						test1);

			} else {

				System.out.println("Version field is not placed at the bottom of the left corner of the screen");
				Extent_fail(driver, "Expected Version field X position is : " + Expected_Version_Xposition
						+ " || Actual Version field X position is : " + actual_version_XPosition, test, test1);
				Extent_fail(driver, "Expected Version field Y position is : " + Expected_Version_Yposition
						+ " || Actual Version field Y position is : " + actual_version_YPosition, test, test1);
				Extent_fail(driver, "Version field is not placed at the bottom of the left corner of the screen", test,
						test1);
			}

		} catch (Exception e) {
			e.printStackTrace();
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
		}

		System.out
				.println("//***************************Testcase 40 Completed **************************************//");

	}

}