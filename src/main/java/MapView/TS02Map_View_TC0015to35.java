package MapView;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
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

public class TS02Map_View_TC0015to35 extends Keywords {
	
	public void Scenario02(WebDriver driver, ExtentTest test,ExtentTest test1, String url, int dataset) throws Exception {
		
		System.out.println("url : " + url);
		String Username = Utils.getDataFromTestData("TS02_Map_View_Dataset"+dataset, "Map view","Username");
		String Password = Utils.getDataFromTestData("TS02_Map_View_Dataset"+dataset, "Map view","Password");
		String ID = Utils.getDataFromTestData("TS02_Map_View_Dataset"+dataset, "Map view", "Id");	
		String Expected_screencolor = Utils.getDataFromTestData("TS02_Map_View_Dataset"+dataset,"Map view","Screen_background");
		String Expected_Autogeneratedcolorcode = Utils.getDataFromTestData("TS02_Map_View_Dataset"+dataset, "Map view","Autogenerated_Color");
		String Expected_FontFamily = Utils.getDataFromTestData("TS02_Map_View","Map view_Dataset"+dataset, "FontFamily");
		String Expected_Version_Xposition = Utils.getDataFromTestData("TS02_Map_View_Dataset"+dataset, "Map view","Version_Xposition");
		String Expected_Version_Yposition = Utils.getDataFromTestData("TS02_Map_View_Dataset"+dataset, "Map view","Version_Yposition");
		
		
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
		sendKeys(driver, Searchbox, "Map View");

		Fluentwait(driver, Select_mapview);
		click(driver, Select_mapview);
		
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

		Extent_cal(test,"Testcase 20 - Ensure that the auto generated and reference no field should be highlighted with SVM standard color");

		String ID_Backroundcolor = getTextBackgroundColor(driver, MapView_IDField);

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
		
		System.out.println("//***************************Testcase 20 Completed **************************************//");
		
	  Extent_cal(test, "Testcase 24 - Ensure text in all fields specified in the correct screen font");
		
		Fluentwait(driver, Map_view_Globalserach);
		click(driver, Map_view_Globalserach);

		Fluentwait(driver, Globalserach_IDInput);
		sendKeys(driver, Globalserach_IDInput, ID);

		wait(driver, "2");

		Fluentwait(driver, Click_Search);
		click(driver, Click_Search);

		wait(driver, "5");

		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);

		
		String Idfontfamily = Getcssvalue(driver, MapView_IDField, "font-family");

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
		
		System.out.println("//***************************Testcase 24 Completed **************************************//");
		

		Extent_cal(test, "Testcase 35 - Ensure that all windows have a consistent look and feel");

		Fluentwait(driver, MapView_cancel);
		click(driver, MapView_cancel);
	
		Fluentwait(driver, MapView_new);
		click(driver, MapView_new);

		Fluentwait(driver, MapView_createnew_confirm);
		click(driver, MapView_createnew_confirm);

		wait(driver, "3");

		//takescreenshot(driver, "//Expected_screenshot//MapView//screen");
		takescreenshot(driver, "//Actual_screenshot//MapView//screen");

		if (imageComparison2(driver, "//MapView//screen", "//MapView//screen") == true) {

			System.out.println("First windows have a consistent look and feel");
			Extent_pass(driver, "First windows have a consistent look and feel", test,test1);
		} else {

			System.out.println("First window will be showing different look and feel than the expected");
			Extent_fail(driver, "First window will be showing different look and feel than the expected", test,test1);
		}

		Fluentwait(driver, Searchbox);
		sendKeys(driver, Searchbox, "Map View");

		Fluentwait(driver, Select_mapview);
		click(driver, Select_mapview);

		Fluentwait(driver, Newtab_confirm);
		click(driver, Newtab_confirm);

		switchtotab(driver, 1);

	  // takescreenshot(driver, "//Expected_screenshot//MapView//screen2");
		takescreenshot(driver, "//Actual_screenshot//MapView//screen2");

		if (imageComparison2(driver, "//MapView//screen2", "//MapView//screen2") == true) {

			System.out.println("Second window have a consistent look and feel");
			Extent_pass(driver, "Second window have a consistent look and feel", test,test1);
		} else {

			System.out.println("Second window will be showing different look and feel than the expected");
			Extent_fail(driver, "Second window will be showing different look and feel than the expected", test,test1);
		}

		driver.close();
		ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
		wait(driver, "1");
		driver.switchTo().window(tab.get(0));
		System.out.println("*********************Testcase 35 Completed*********************");
		
         Extent_cal(test, "Testcase 36 - Ensure Minimize button functionality");
		
		
		Robot rbt = new Robot();
		
		rbt.keyPress(KeyEvent.VK_ESCAPE);
		
		// takescreenshot(driver, "//Expected_screenshot//MapView//Minimise");
		takescreenshot(driver, "//Actual_screenshot//MapView//Minimise");

		if (imageComparison2(driver, "//MapView//Minimise", "//MapView//Minimise") == true) {

			System.out.println("Minimise button is working fine");
			Extent_pass(driver, "Minimise button is working fine", test,test1);
		} else {

			System.out.println("Minimise button is not working fine");
			Extent_fail(driver, "Minimise button is not working fine", test,test1);
		}
		
		System.out.println("******************Testcase 36 completed*****************");
		
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

	
		System.out.println("//***************************Testcase 40 Completed **************************************//");

		 Extent_cal(test, "Testcase 38 - Ensure Scroll up and down functionality in Grids");	
		 
		takescreenshot(driver, "//Expected_screenshot//MapView//scrollup");
		
		scrollBottom(driver);
		
		wait(driver,"2");
		
		takescreenshot(driver, "//Actual_screenshot//MapView//scrollup");
		
		if (!imageComparison2(driver, "//MapView//scrollup", "//MapView//scrollup") == true) {

			System.out.println("Scrolling button is working fine");
			Extent_pass(driver, "Scrolling button is working fine", test,test1);
		} else {

			System.out.println("Scrolling button is working fine");
			Extent_fail(driver, "Scrolling button is working fine", test,test1);
		}
		
		System.out.println("//***************************Testcase 38 Completed **************************************//");
		
        Extent_cal(test, "Testcase 39 - Ensure Close button functionality");
		
		scrollBottom(driver);
		
		waitForElement(driver, MapView_close_tab);
		click(driver, MapView_close_tab);
		
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
