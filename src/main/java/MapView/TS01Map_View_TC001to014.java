package MapView;

import java.awt.Robot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.Utils;

public class TS01Map_View_TC001to014 extends Keywords{
	
	public void Scenario01(WebDriver driver, ExtentTest test,ExtentTest test1, String url, int dataset) throws Exception {
		
		System.out.println("url : " + url);
		String Username = Utils.getDataFromTestData("TS01_Map_View_TC01to14_Dataset"+dataset, "Map view","Username");
		String Password = Utils.getDataFromTestData("TS01_Map_View_TC01to14_Dataset"+dataset, "Map view","Password");
		String ID = Utils.getDataFromTestData("TS01_Map_View_TC01to14_Dataset"+dataset, "Map view", "Id");
		
		Actions act = new Actions(driver);
		Robot rbt = new Robot();

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
		
		Extent_cal(test,"Testcase 01 - When Open the new screen,New,Search and close buttons should be in Enable status");
		
		if (IsElementEnabled(driver, Map_view_Globalserach)) {

			System.out.println("After opening the new screen, the Global search button is in enable status");
			Extent_pass(driver, "fter opening the new screen, the Global search button is in enable status", test, test1);

		} else {

			System.out.println("After opening the new screen, the Global search button is not in enable status");
			Extent_fail(driver, "After opening the new screen, the Global search button is not in enable status", test,
					test1);
		}

		System.out.println("//***************************Testcase 1 Completed **************************************//");

		Extent_cal(test,
				"Testcase 02 - Ensure while click new button,Save,cancel and close button should be in enable Status");

		Fluentwait(driver, MapView_cancel);
		click(driver, MapView_cancel);

		Fluentwait(driver, MapView_new);
		click(driver, MapView_new);

		Fluentwait(driver, MapView_createnew_confirm);
		click(driver, MapView_createnew_confirm);

		wait(driver, "5");

		if (IsElementEnabled(driver, MapView_cancel)) {

			System.out.println("After clicking the New button, the Cancel button is in enable status");
			Extent_pass(driver, "After clicking the New button, the Cancel button is in enable status", test, test1);

		} else {

			System.out.println("After clicking the New button, the Cancel button is not in enable status");
			Extent_fail(driver, "After clicking the New button, the Cancel button is not in enable status", test,
					test1);
		}

		if (IsElementEnabled(driver, MapView_close_tab)) {

			System.out.println("After clicking the New button, the Close tab button is in enable status");
			Extent_pass(driver, "After clicking the New button, the Close tab button is in enable status", test, test1);

		} else {

			System.out.println("After clicking the New button, the Close tab button is not in enable status");
			Extent_fail(driver, "After clicking the New button, the Close tab button is not in enable status", test,
					test1);
		}

		System.out.println("//***************************Testcase 2 Completed **************************************//");

		Extent_cal(test,
				"Testcase 03 - Ensure while retrieving record by using global search,new,Edit,search,and close buttons should be in Enable status");

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

		wait(driver, "5");

		if (IsElementEnabled(driver, MapView_close_tab)) {

			System.out.println("After retrieving the record using global search, Close tab button is enabled");
			Extent_pass(driver, "After retrieving the record using global search, Close tab button is enabled", test,
					test1);

		} else {

			System.out.println("After retrieving the record using global search, Close tab button is not enabled");
			Extent_fail(driver, "After retrieving the record using global search, Close tab button is not enabled",
					test, test1);
		}

		System.out.println("//***************************Testcase 3 Completed **************************************//");
		
		Extent_cal(test, "Testcase 7 - Ensure screen enable New, search and close button  when click cancel button");

		Fluentwait(driver, MapView_cancel);
		click(driver, MapView_cancel);
		
		Fluentwait(driver, MapView_new);
		click(driver, MapView_new);
		
		Fluentwait(driver, MapView_createnew_confirm);
		click(driver, MapView_createnew_confirm);
		
		Fluentwait(driver, MapView_cancel);
		click(driver, MapView_cancel);
		
		if (IsElementEnabled(driver, MapView_new)) {

			System.out.println("After click on cancel button new button  is enabled");
			Extent_pass(driver, "After click on cancel button new button  is enabled", test,
					test1);

		} else {

			System.out.println("After click on cancel button new button  is not enabled");
			Extent_fail(driver, "After click on cancel button new button  is not enabled",
					test, test1);
		}
		System.out.println("//***************************Testcase 7 Completed **************************************//");
		
      Extent_cal(test, "Testcase 014 - Ensure System should close the screen,when click close button");

	
      wait(driver, "2");

		Fluentwait(driver, MapView_close_tab);
		click(driver, MapView_close_tab);

		wait(driver, "2");


		if (!IsElementEnabled(driver, MapView_close_tab)) {

			System.out.println(
					"After clicking the Cancel button once the new record is created, the Close tab button is in enable status");
			Extent_pass(driver,
					"After clicking the Cancel button once the new record is created, the Close tab button is in enable status",
					test, test1);

		} else {

			System.out.println(
					"After clicking the Cancel button once the new record is created, the Close tab button is not in enable status");
			Extent_fail(driver,
					"After clicking the Cancel button once the new record is created, the Close tab button is not in enable status",
					test, test1);
		}

		System.out.println("//***************************Testcase 14 Completed **************************************//");


		 
		 
		 
		
}
}