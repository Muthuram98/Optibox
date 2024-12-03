package ERO_Optimizer_WHAT_IF_Scripts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.Utils;

public class TS002_ERO_Optimizer_WHATIF_TC15to35 extends Keywords{
	public void Scenario002(WebDriver driver, ExtentTest test, ExtentTest test1, String url, int dataset) throws IOException, AWTException {

		System.out.println("url : " + url);
		String Username = Utils.getDataFromTestData("TS002_EroOptimizer_WHAT_IF", "ERO_Optimizer WHAT_IF","Username");
		String Password = Utils.getDataFromTestData("TS002_EroOptimizer_WHAT_IF", "ERO_Optimizer WHAT_IF","Password");
		String ID = Utils.getDataFromTestData("TS002_EroOptimizer_WHAT_IF", "ERO_Optimizer WHAT_IF", "Id");
		String Expected_screencolor = Utils.getDataFromTestData("TS002_EroOptimizer_WHAT_IF","ERO_Optimizer WHAT_IF","Screen_background");
		String Expected_Autogeneratedcolorcode = Utils.getDataFromTestData("TS002_EroOptimizer_WHAT_IF", "ERO_Optimizer WHAT_IF","Autogenerated_Color");
		String Expected_FontFamily = Utils.getDataFromTestData("TS002_EroOptimizer_WHAT_IF","ERO_Optimizer WHAT_IF", "FontFamily");
		String Expected_Version_Xposition = Utils.getDataFromTestData("TS002_EroOptimizer_WHAT_IF", "ERO_Optimizer WHAT_IF","Version_Xposition");
		String Expected_Version_Yposition = Utils.getDataFromTestData("TS002_EroOptimizer_WHAT_IF", "ERO_Optimizer WHAT_IF","Version_Yposition");
		String Expected_Created_Xposition = Utils.getDataFromTestData("TS002_EroOptimizer_WHAT_IF", "ERO_Optimizer WHAT_IF","Created_Xposition");
		String Expected_Created_Yposition = Utils.getDataFromTestData("TS002_EroOptimizer_WHAT_IF", "ERO_Optimizer WHAT_IF","Created_Yposition");
		String Expected_Updated_Yposition = Utils.getDataFromTestData("TS002_EroOptimizer_WHAT_IF", "ERO_Optimizer WHAT_IF","Updated_Yposition");
		String Expected_Updated_Xposition = Utils.getDataFromTestData("TS002_EroOptimizer_WHAT_IF", "ERO_Optimizer WHAT_IF","Updated_Xposition");
		
		
		
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
		sendKeys(driver, Searchbox, "Optimizer WHAT – IF Scenario");

		Fluentwait(driver, SelectOptimizer);
		click(driver, SelectOptimizer);
		Fluentwait(driver, Screen);
		wait(driver,"2");
		
		String actualscreencolor = getTextBackgroundColor(driver, Screen);

		if (actualscreencolor.equals(Expected_screencolor)) {

			System.out.println("Screen Background color Matched || Expected screen color was : " + Expected_screencolor
					+ " || Actual screen color was " + actualscreencolor);
			Extent_pass(driver, "Screen Background color Matched || Expected screen color was : " + Expected_screencolor
					+ " || Actual screen color was " + actualscreencolor, test,test1);
			
		} else {
			System.out.println("Screen Background color Not Matched || Expected screen color was : " + Expected_screencolor
					+ " || Actual screen color was " + actualscreencolor);
			Extent_fail(driver, "Screen Background color Not Matched || Expected screen color was : " + Expected_screencolor
					+ " || Actual screen color was " + actualscreencolor, test,test1);
		}

		System.out
				.println("//***************************Testcase 15 Completed **************************************//");

		Extent_cal(test,
				"Testcase 20 - Ensure that the auto generated and reference no field should be highlighted with SVM standard color");

		String ID_Backroundcolor = getTextBackgroundColor(driver, Optimizer_IDField);

		System.out.println("Fromyear_Backroundcolor : " + ID_Backroundcolor);

		if (ID_Backroundcolor.equals(Expected_Autogeneratedcolorcode)) {

			System.out.println("Id field Background color Matched || Expected ID field color was : " + Expected_Autogeneratedcolorcode
					+ " || Actual ID field color was " + ID_Backroundcolor);
			Extent_pass(driver, "Id field Background color Matched || Expected ID field color was : " + Expected_Autogeneratedcolorcode
					+ " || Actual ID field color was " + ID_Backroundcolor, test,test1);
		} else {
			System.out.println("Id field Background color Not Matched || Expected ID field color was : " + Expected_Autogeneratedcolorcode
					+ " || Actual ID field color was " + ID_Backroundcolor);
			Extent_fail(driver, "Id field Background color Not Matched || Expected ID field color was : " + Expected_Autogeneratedcolorcode
					+ " || Actual ID field color was " + ID_Backroundcolor, test,test1);
		}
		
		System.out
		.println("//***************************Testcase 20 Completed **************************************//");
		
		
		Extent_cal(test, "Testcase 24 - Ensure text in all fields specified in the correct screen font");
		
		Fluentwait(driver, Optimizer_Globalserach);
		click(driver, Optimizer_Globalserach);

		Fluentwait(driver, Globalserach_IDInput);
		sendKeys(driver, Globalserach_IDInput, ID);

		wait(driver, "2");

		Fluentwait(driver, Click_Search);
		click(driver, Click_Search);

		wait(driver, "5");

		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);

		
		String Idfontfamily = Getcssvalue(driver, Optimizer_IDField, "font-family");

		System.out.println("fontfamily : " + Idfontfamily);

		if (Idfontfamily.equals(Expected_FontFamily)) {

			System.out.println("From year font family Matched || Expected Font family of From Year field text is : " + Expected_FontFamily
					+ " || Actual font family of From Year field text is : " + Idfontfamily);
			Extent_pass(driver, "From year font family Matched || Expected Font family of From Year field text is : " + Expected_FontFamily
					+ " || Actual font family of From Year field text is : " + Idfontfamily, test,test1);
		} else {
			System.out
					.println("From year font family Not Matched || Expected Font family of From Year field text is : " + Expected_FontFamily
							+ " || Actual font family of From Year field text is : " + Idfontfamily);
			Extent_fail(driver,
					"From year font family Not Matched || Expected Font family of From Year field text is : " + Expected_FontFamily
							+ " || Actual font family of From Year field text is : " + Idfontfamily,
					test,test1);

		}
		String SurplusQtyfontfamily = Getcssvalue(driver, Optimizer_SurplusQty, "font-family");

		System.out.println("fontfamily : " + SurplusQtyfontfamily);

		if (SurplusQtyfontfamily.equals(Expected_FontFamily)) {

			System.out.println("Surplus quantity font family Matched || Expected Font family of SurplusQty text is : " + Expected_FontFamily
					+ " || Actual font family of SurplusQty field text is : " + SurplusQtyfontfamily);
			Extent_pass(driver, "Surplus quantity font family Matched || Expected Font family of SurplusQty field text is : " + Expected_FontFamily
					+ " || Actual font family of SurplusQty field text is : " + SurplusQtyfontfamily, test,test1);
		} else {
			System.out
					.println("Surplus quantity font family Not Matched || Expected Font family of SurplusQty field text is : " + Expected_FontFamily
							+ " || Actual font family of SurplusQty field text is : " + SurplusQtyfontfamily);
			Extent_fail(driver,
					"Surplus quantity font family Not Matched || Expected Font family of SurplusQty field text is : " + Expected_FontFamily
							+ " || Actual font family of SurplusQty field text is : " + SurplusQtyfontfamily,
					test,test1);

		}

		String DeficitQtyfontfamily = Getcssvalue(driver, Optimizer_DeficitQty, "font-family");

		System.out.println("fontfamily : " + DeficitQtyfontfamily);

		if (DeficitQtyfontfamily.equals(Expected_FontFamily)) {

			System.out.println("Deficit quantity font family Matched || Expected Font family of DeficitQty text is : " + Expected_FontFamily
					+ " || Actual font family of DeficitQty field text is : " + DeficitQtyfontfamily);
			Extent_pass(driver, "Deficit quantity font family Matched || Expected Font family of DeficitQty field text is : " + Expected_FontFamily
					+ " || Actual font family of DeficitQty field text is : " + DeficitQtyfontfamily, test,test1);
		} else {
			System.out
					.println("Deficit quantity font family Not Matched || Expected Font family of DeficitQty field text is : " + Expected_FontFamily
							+ " || Actual font family of DeficitQty field text is : " + DeficitQtyfontfamily);
			Extent_fail(driver,
					"Deficit quantity font family Not Matched || Expected Font family of DeficitQty field text is : " + Expected_FontFamily
							+ " || Actual font family of DeficitQty field text is : " + DeficitQtyfontfamily,
					test,test1);

		}
        wait(driver,"2");
        
        Fluentwait(driver, Optimizer_cancle);
		click(driver, Optimizer_cancle);

		Fluentwait(driver, Optimizer_new);
		click(driver, Optimizer_new);

		Fluentwait(driver, Optimizer_createnew_confirm);
		click(driver, Optimizer_createnew_confirm);
        
		Fluentwait(driver, Optimizer_Globalserach);
		click(driver, Optimizer_Globalserach);

		Fluentwait(driver, Globalserach_IDInput);
		sendKeys(driver, Globalserach_IDInput, ID);

		wait(driver, "2");

		Fluentwait(driver, Click_Search);
		click(driver, Click_Search);

		wait(driver, "5");

		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);

		wait(driver, "5");
		for (int i = 1; i <= 8; i++) {

			WebElement gridfields = driver.findElement(By.xpath("(//div[@aria-colindex='" + i + "'])[1]"));

			Actions action = new Actions(driver);
			wait(driver, "5");
			action.moveToElement(gridfields).build().perform();
			
			String Grid_field_fonts = Getcssvalue_webelement(driver, gridfields, "font-family");

//			String Grid_field_fonts = gridfields.getCssValue("font-family");

//			String Columname = gridfields.getAttribute("col-id");
			String Columname = getAttribute_webelement(driver, gridfields, "col-id");

			if (Grid_field_fonts.equals(Expected_FontFamily)) {

				System.out.println(
						"Grid fields font family Matched || Expected Font family of Grid field " + Columname + " is : " + Expected_FontFamily
								+ " || Actual font family of Grid field " + Columname + " is : " + Grid_field_fonts);
				Extent_pass(driver,
						"Grid fields font family Matched || Expected Font family of Grid field " + Columname + " is : " + Expected_FontFamily
								+ " || Actual font family of Grid field " + Columname + " is : " + Grid_field_fonts,
						test,test1);
			} else {
				System.out.println("Grid fields font family Not Matched || Expected Font family of Grid field " + Columname + " is : "
						+ Expected_FontFamily + " || Actual font family of Grid field " + Columname + " is : " + Grid_field_fonts);
				Extent_fail(driver,
						"Grid fields font family Not Matched || Expected Font family of Grid field " + Columname + " is : " + Expected_FontFamily + " "
										+ "|| Actual font family of Grid field " + Columname + " is : "+ Grid_field_fonts,test,test1);

			}

		}

		System.out.println("//***************************Testcase 24 Completed **************************************//");
	
		Extent_cal(test," Testcase 30 and Testcase 31 Ensure all character or alphanumeric or numeric fields correctly alligned");
		
		Fluentwait(driver, Optimizer_cancle);
		click(driver, Optimizer_cancle);

		Fluentwait(driver, Optimizer_new);
		click(driver, Optimizer_new);

		Fluentwait(driver, Optimizer_createnew_confirm);
		click(driver, Optimizer_createnew_confirm);

		Fluentwait(driver, Optimizer_Globalserach);
		click(driver, Optimizer_Globalserach);

		Fluentwait(driver, Globalserach_IDInput);
		sendKeys(driver, Globalserach_IDInput, ID);

		wait(driver, "2");

		Fluentwait(driver, Click_Search);
		click(driver, Click_Search);

		wait(driver, "5");

		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);

		wait(driver, "5");
		wait(driver, "5");		

		WebElement scroller = driver.findElement(By.xpath("//div[@ref='eBodyHorizontalScrollViewport']"));

		wait(driver, "3");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollLeft = 0;", scroller);

		Actions action = new Actions(driver);
		List<String> columns = Arrays.asList("Surplus Location","Surplus Count","Deficit Location","Deficit Count","Optimizer Result","Allocate Containers","Size Type","Cost / Unit(in USD)");

		for (int i = 1; i <= 8; i++) {

			WebElement gridfields = driver.findElement(By.xpath("(//div[@aria-colindex='" + i + "'])[1]"));

			action.moveToElement(gridfields).build().perform();

			String Grid_field = getTextofWebelement(driver, gridfields, "gridfields");

			String Allignmenttype = determineType(Grid_field);

			System.out.println("Allignmenttype : " + Allignmenttype);

			String attributevalue = getAttribute_webelement(driver, gridfields, "class");
			
//			String attributevalue = gridfields.getAttribute("class");
		
			String Columname = columns.get(i-1);

			System.out.println("attributevalue : " + attributevalue);

			String allignment = extractDirection(attributevalue);

			if (allignment == null) {
				System.out.println("Unable to determine alignment for column " + Columname);
//		        Extent_fail(driver, "Unable to determine alignment for column " + Columname, test,test1);
				continue;
			}

			System.out.println("allignment : " + allignment);

			if (Allignmenttype.equals("Alphabetic")) {

				if (allignment.equals("left")) {

					System.out.println("Column " + Columname + " is Alphabetic and it aligned on the left side");
					Extent_pass(driver, "Column " + Columname + " is Alphabetic and it aligned on the left side", test,test1);

				} else {
					System.out
							.println("Column " + Columname + " is Alphabetic and it was not aligned on the left side");
					Extent_fail(driver,
							"Column " + Columname + " is Alphabetic and it was not aligned on the left side", test,test1);

				}

			}

			if (Allignmenttype.equals("Numeric")) {

				if (allignment.equals("right")) {

					System.out.println("Column " + Columname + " is Numeric and it aligned on the Right side");
					Extent_pass(driver, "Column " + Columname + " is Numeric and it aligned on the Right side", test,test1);

				} else {
					System.out.println("Column " + Columname + " is Numeric and it was not aligned on the Right side");
					Extent_fail(driver, "Column " + Columname + " is Numeric and it was not aligned on the Right side",
							test,test1);
				}

			}

			if (Allignmenttype.equals("Alphanumeric")) {

				System.out.println("Column " + Columname + " is Alpha Numeric ");

			}
		}

		System.out.println("//***************************Testcase 30 and Testcase 31 Completed **************************************//");

		Extent_cal(test, "Testcase 33 - Ensure all user input captured in UPPER case or lowercase consistently");
		
		Fluentwait(driver, ColumnFilter);
		click(driver, ColumnFilter);

		for (int i = 1; i <= 2; i++) {

			wait(driver, "2");

			String FieldInput_name = Utils.getDataFromTestData("TS002_ERO_Optimizer_WHAT_IF_Field", "ERO_Optimizer WHAT_IF","Fieldvalue" + i);

			Fluentwait(driver, ColumnFilter_Input);
			clear(driver, ColumnFilter_Input);
			sendKeys(driver, ColumnFilter_Input, FieldInput_name);

			wait(driver, "3");
			
		//	elementScreenShot_new(driver, ColumnFilter_field, "/Expected_screenshot/OptimizerWHATIF/filter"+i);
			
			elementScreenShot_new(driver, ColumnFilter_field, "/Actual_screenshot/OptimizerWHATIF/filter"+i);
			
			if (imageComparison2(driver, "//OptimizerWHATIF//filter"+i, "//OptimizerWHATIF//filter"+i) == true) {

				System.out.println("Filter is capturing both Upper case and lower case letters and the given value was : "+ FieldInput_name);
				Extent_pass(driver,	"Filter is capturing both Upper case and lower case letters and the given value was : "+ FieldInput_name,test,test1);
			} else {

				System.out.println("Filter is not capturing both Upper case and lower case letters and the given value was : "	+ FieldInput_name);
				Extent_fail(driver,"Filter is not capturing both Upper case and lower case letters and the given value was : "+ FieldInput_name,test,test1);
			}


		}

		for (int i = 3; i <= 16; i++) {

			wait(driver, "2");

			String FieldInput_name = Utils.getDataFromTestData("TS002_ERO_Optimizer_WHAT_IF_Field", "ERO_Optimizer WHAT_IF","Fieldvalue" + i);

			Fluentwait(driver, ColumnFilter_Input);
			clear(driver, ColumnFilter_Input);
			sendKeys(driver, ColumnFilter_Input, FieldInput_name);

			wait(driver, "3");

	//		elementScreenShot_new(driver, ColumnFilter_field, "/Expected_screenshot/OptimizerWHATIF/filter" + i);

			elementScreenShot_new(driver, ColumnFilter_field, "/Actual_screenshot/OptimizerWHATIF/filter" + i);

			if (imageComparison2(driver, "//OptimizerWHATIF//filter" + i, "//OptimizerWHATIF//filter" + i) == true) {

				System.out
						.println("Filter is capturing both Upper case and lower case letters and the given value was : "
								+ FieldInput_name);
				Extent_pass(driver,
						"Filter is capturing both Upper case and lower case letters and the given value was : "
								+ FieldInput_name,
						test,test1);
			} else {

				System.out.println(
						"Filter is not capturing both Upper case and lower case letters and the given value was : "
								+ FieldInput_name);
				Extent_fail(driver,
						"Filter is not capturing both Upper case and lower case letters and the given value was : "
								+ FieldInput_name,
						test,test1);
			}

		}

		wait(driver, "2");

		Fluentwait(driver, ColumnFilter);
		click(driver, ColumnFilter);

		System.out.println("//***************************Testcase 33 Completed **************************************//");
		
		
		Extent_cal(test, "Testcase 35 - Ensure that all windows have a consistent look and feel");

		Fluentwait(driver, Optimizer_cancle);
		click(driver, Optimizer_cancle);
	
		Fluentwait(driver, Optimizer_new);
		click(driver, Optimizer_new);

		Fluentwait(driver, Optimizer_createnew_confirm);
		click(driver, Optimizer_createnew_confirm);

		wait(driver, "3");

	//	takescreenshot(driver, "//Expected_screenshot//OptimizerWHATIF//screen");
		takescreenshot(driver, "//Actual_screenshot//OptimizerWHATIF//screen");

		if (imageComparison2(driver, "//OptimizerWHATIF//screen", "//OptimizerWHATIF//screen") == true) {

			System.out.println("First windows have a consistent look and feel");
			Extent_pass(driver, "First windows have a consistent look and feel", test,test1);
		} else {

			System.out.println("First window will be showing different look and feel than the expected");
			Extent_fail(driver, "First window will be showing different look and feel than the expected", test,test1);
		}

		Fluentwait(driver, Searchbox);
		sendKeys(driver, Searchbox, "Optimizer WHAT – IF Scenario");

		Fluentwait(driver, SelectOptimizer);
		click(driver, SelectOptimizer);

		Fluentwait(driver, Newtab_confirm);
		click(driver, Newtab_confirm);

		switchtotab(driver, 1);

	//	takescreenshot(driver, "//Expected_screenshot//OptimizerWHATIF//screen2");
		takescreenshot(driver, "//Actual_screenshot//OptimizerWHATIF//screen2");

		if (imageComparison2(driver, "//OptimizerWHATIF//screen2", "//OptimizerWHATIF//screen2") == true) {

			System.out.println("Second window have a consistent look and feel");
			Extent_pass(driver, "Second window have a consistent look and feel", test,test1);
		} else {

			System.out.println("Second window will be showing different look and feel than the expected");
			Extent_fail(driver, "Second window will be showing different look and feel than the expected", test,test1);
		}

		System.out.println("*********************Testcase 35 Completed*********************");
		
       Extent_cal(test, "Testcase 36 - Ensure Minimize button functionality");
		
		
		Robot rbt = new Robot();
		
		rbt.keyPress(KeyEvent.VK_ESCAPE);
		
		// takescreenshot(driver, "//Expected_screenshot//OptimizerWHATIF//Minimise");
		takescreenshot(driver, "//Actual_screenshot//OptimizerWHATIF//Minimise");

		if (imageComparison2(driver, "//OptimizerWHATIF//Minimise", "//OptimizerWHATIF//Minimise") == true) {

			System.out.println("Minimise button is working fine");
			Extent_pass(driver, "Minimise button is working fine", test,test1);
		} else {

			System.out.println("Minimise button is not working fine");
			Extent_fail(driver, "Minimise button is not working fine", test,test1);
		}
		
		System.out.println("******************Testcase 36 completed*****************");
		
		
		Extent_cal(test, "Testcase 37 - Ensure Maximize button functionality");
		
		wait(driver,"3");
		
		Fluentwait(driver, Optimizer_Tree_table);
		click(driver, Optimizer_Tree_table);
		
		Fluentwait(driver, Full_screen);
		click(driver, Full_screen);
		
		wait(driver,"3");
		
	//	takescreenshot(driver, "//Expected_screenshot//OptimizerWHATIF//Fullscreen");
		takescreenshot(driver, "//Actual_screenshot//OptimizerWHATIF//Fullscreen");

		if (imageComparison2(driver, "//OptimizerWHATIF//Fullscreen", "//OptimizerWHATIF//Fullscreen") == true) {

			System.out.println("Maximise button is working fine");
			Extent_pass(driver, "Maximise button is working fine", test,test1);
		} else {

			System.out.println("Maximise button is not working fine");
			Extent_fail(driver, "Maximise button is not working fine", test,test1);
		}
		
		System.out.println("*****************Testcase 37 completed******************");
		
       Extent_cal(test, " Testcase 38 Ensure Scroll up and down functionality in Grids");
		
		wait(driver, "5");

		switchtotab(driver, 0);


		Fluentwait(driver, Optimizer_Globalserach);
		click(driver, Optimizer_Globalserach);

		Fluentwait(driver, Globalserach_IDInput);
		sendKeys(driver, Globalserach_IDInput, ID);

		wait(driver, "2");

		Fluentwait(driver, Click_Search);
		click(driver, Click_Search);

		wait(driver, "5");

		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);

	
		wait(driver, "5");

		Fluentwait(driver, Gridscroll);

		ScrollBarValidation1(driver, Gridscroll, "Grid scroll");

		System.out.println("//***************************Testcase 38 Completed **************************************//");
		
		Extent_cal(test, "Testcase 40 Ensure Version is placed at bottom of the left corner of the screen");

		Scrolltilltheelementvisible(driver, Optimizer_Verionfield);

		try {
			WebElement versionfield = driver.findElement(By.xpath("//label[contains(text(),'Version')]"));

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
				Extent_pass(driver, "Version field is placed at the bottom of the left corner of the screen", test,test1);
				Extent_pass(driver, "Expected Version field X position is : " + Expected_Version_Xposition
						+ " || Actual Version field X position is : " + actual_version_XPosition, test,test1);
				Extent_pass(driver, "Expected Version field Y position is : " + Expected_Version_Yposition
						+ " || Actual Version field Y position is : " + actual_version_YPosition, test,test1);

			} else {

				System.out.println("Version field is not placed at the bottom of the left corner of the screen");
				Extent_fail(driver, "Version field is not placed at the bottom of the left corner of the screen", test,test1);
				Extent_fail(driver, "Expected Version field X position is : " + Expected_Version_Xposition
						+ " || Actual Version field X position is : " + actual_version_XPosition, test,test1);
				Extent_fail(driver, "Expected Version field Y position is : " + Expected_Version_Yposition
						+ " || Actual Version field Y position is : " + actual_version_YPosition, test,test1);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Extent_fail(driver, e.getLocalizedMessage(), test,test1);
		}

		System.out
				.println("//***************************Testcase 40 Completed **************************************//");

		
		
     Extent_cal(test, "Testcase 39 - Ensure Close button functionality");
		
		scrollBottom(driver);
		
		waitForElement(driver, Optimizer_close_tab);
		click(driver, Optimizer_close_tab);
		
		wait(driver,"3");
		
		if (!isDisplayed(driver, current_frame)) {
			
			System.out.println("After click on close button Current screen was closed");
			Extent_pass(driver, "After click on close button Current screen was closed", test,test1);
			
		}else {
			
			System.out.println("After click on close button Current screen was not closed");
			Extent_fail(driver, "After click on close button Current screen was not closed", test,test1);
		}
		
		System.out.println("**************Testcase 39 completed**************");
		
		

}
}