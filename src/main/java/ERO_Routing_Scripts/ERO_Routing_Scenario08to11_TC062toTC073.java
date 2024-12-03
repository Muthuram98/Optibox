package ERO_Routing_Scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.Utils;

public class ERO_Routing_Scenario08to11_TC062toTC073 extends Keywords {

	public void ERO_Scenario8to11(WebDriver driver, ExtentTest test, ExtentTest test1, String url, int dataset) throws Exception {

		String Username = Utils.getDataFromTestData("ERO_Routing_Scenario8to10_Dataset"+dataset, "ERO Routing", "Username");
		String Password = Utils.getDataFromTestData("ERO_Routing_Scenario8to10_Dataset"+dataset, "ERO Routing", "Password");
		String ID = Utils.getDataFromTestData("ERO_Routing_Scenario8to10_Dataset"+dataset, "ERO Routing", "Id");
		String WarningPopup_Message = Utils.getDataFromTestData("ERO_Routing_Scenario8to10_Dataset"+dataset, "ERO Routing",
				"ERO_Warning_Message");
		String informationPopup_Message = Utils.getDataFromTestData("ERO_Routing_Scenario8to10_Dataset"+dataset, "ERO Routing",
				"ERO_information_Message");
		String Calculated_Message = Utils.getDataFromTestData("ERO_Routing_Scenario8to10_Dataset"+dataset, "ERO Routing", "Calculated_Message");

		navigateUrl(driver, url);

		JavascriptExecutor js = (JavascriptExecutor) driver;

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
		sendKeys(driver, Searchbox, "Deficit and Surplus Location Identification");

		Fluentwait(driver, Selectdeficit);
		click(driver, Selectdeficit);

		wait(driver, "5");

		Fluentwait(driver, Globalserach);
		click(driver, Globalserach);

		Fluentwait(driver, Globalserach_IDInput);
		sendKeys(driver, Globalserach_IDInput, ID);

		Fluentwait(driver, Click_Search);
		click(driver, Click_Search);

		wait(driver, "3");
		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);

		wait(driver, "3");

		Fluentwait(driver, Editbutton);
		click(driver, Editbutton);

		Fluentwait(driver, Save);
		click(driver, Save);

		wait(driver, "3");

		Fluentwait(driver, Save_popup_ok);
		click(driver, Save_popup_ok);

		wait(driver, "3");

		Fluentwait(driver, Route);
		click(driver, Route);

		wait(driver, "5");

		Extent_cal(test, "Testcase 62 - Ensure Confirmation pop up window having proper messages with icon(?)");

		Fluentwait(driver, ERO_Popup_Ok);
		click(driver, ERO_Popup_Ok);

		wait(driver, "3");
		Fluentwait(driver, ERO_Edit);
		click(driver, ERO_Edit);

		wait(driver, "3");

		Fluentwait(driver, Grid1_Checkbox);
		click(driver, Grid1_Checkbox);

		Fluentwait(driver, Recalculate_Routing);
		click(driver, Recalculate_Routing);

		wait(driver, "5");

		String calculated_popup = getText(driver, ERO_Warning_Message);

		if (calculated_popup.equals(Calculated_Message)) {

			System.out
					.println("Expected confirmation popup was displayed and displayed text was : " + calculated_popup);
			Extent_pass(driver,
					"Expected confirmation popup was displayed and displayed text was : " + calculated_popup, test,
					test1);
		} else {
			System.out.println(
					"Expected confirmation popup was not displayed and displayed text was : " + calculated_popup);
			Extent_fail(driver,
					"Expected confirmation popup was not displayed and displayed text was : " + calculated_popup, test,
					test1);
		}

		try {
//		elementScreenShot_new(driver, ERO_Warningicon, "/Expected_screenshot/Elementscreenshot/ERO Confirmation icon");
			wait(driver, "2");
			elementScreenShot_new(driver, ERO_Warningicon,
					"/Actual_screenshot/Elementscreenshot/ERO Confirmation icon");
			wait(driver, "2");
			if (imageComparison2(driver, "/Elementscreenshot/ERO Confirmation icon",
					"/Elementscreenshot/ERO Confirmation icon")) {

				Extent_pass(driver, "Confirmation popup message Showing with proper icon(?)", test, test1);
			} else {
				Extent_fail(driver, "Confirmation message not Showing with proper icon(?)", test, test1);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
		}

		Fluentwait(driver, Calculate_No);
		click(driver, Calculate_No);

		Extent_cal(test, "Testcase 63 - Ensure Warning pop up window having proper messages with icon(!)");

		wait(driver, "5");

		Fluentwait(driver, Close_ero_routing_tab);
		click(driver, Close_ero_routing_tab);

		Fluentwait(driver, Route);
		click(driver, Route);

		Fluentwait(driver, ERO_Popup_Ok);
		click(driver, ERO_Popup_Ok);

		Fluentwait(driver, Optimizer_option);
		click(driver, Optimizer_option);

		wait(driver, "5");
		Fluentwait(driver, ERO_Warningicon);

		try {
//			elementScreenShot_new(driver, ERO_Warningicon, "/Expected_screenshot/Elementscreenshot/ERO Warning icon");
			wait(driver, "2");
			elementScreenShot_new(driver, ERO_Warningicon, "/Actual_screenshot/Elementscreenshot/ERO Warning icon");
			wait(driver, "2");
			if (imageComparison2(driver, "/Elementscreenshot/ERO Warning icon",
					"/Elementscreenshot/ERO Warning icon")) {

				Extent_pass(driver, "Warning popup message Showing with proper icon(!)", test, test1);
			} else {
				Extent_fail(driver, "Warning popup message not Showing with proper icon(!)", test, test1);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String Warningpopup_text = getText(driver, ERO_Warning_Message);

		if (Warningpopup_text.equals(WarningPopup_Message)) {
			Extent_pass(driver, "Warning popup message having proper message with icon(!)", test, test1);
			System.out.println("Matched || Expected Warning popup message of creating new was : " + WarningPopup_Message
					+ " Actual Warning popup message of creating new was : " + Warningpopup_text);
			Extent_pass(driver, "Matched || Expected Warning popup message of creating new was : "
					+ WarningPopup_Message + " Actual Warning popup message of creating new was : " + Warningpopup_text,
					test, test1);
		} else {
			System.out.println(
					"Not Matched || Expected Warning popup message of creating new was : " + WarningPopup_Message
							+ " Actual Warning popup message of creating new was : " + Warningpopup_text);
			Extent_pass(driver, "Not Matched || Expected Warning popup message of creating new was : "
					+ WarningPopup_Message + " Actual Warning popup message of creating new was : " + Warningpopup_text,
					test, test1);
		}

		Fluentwait(driver, ERO_Popup_Ok);
		click(driver, ERO_Popup_Ok);

		System.out.println("Testcase 63 completed");

		Extent_cal(test, "Testcase 64 - Ensure information pop up window having proper messages with icon(i)");

		Fluentwait(driver, ERO_Edit);
		click(driver, ERO_Edit);

		Fluentwait(driver, ERO_save);
		click(driver, ERO_save);

		wait(driver, "5");
		Fluentwait(driver, ERO_Warningicon);

		try {
//			elementScreenShot_new(driver, ERO_Warningicon, "/Expected_screenshot/Elementscreenshot/ERO information icon");
			wait(driver, "2");
			elementScreenShot_new(driver, ERO_Warningicon, "/Actual_screenshot/Elementscreenshot/ERO information icon");
			wait(driver, "2");
			if (imageComparison2(driver, "/Elementscreenshot/ERO information icon",
					"/Elementscreenshot/ERO information icon")) {

				Extent_pass(driver, "information popup message Showing with proper icon(i)", test, test1);
				System.out.println("information popup message Showing with proper icon(i)");
			} else {
				Extent_fail(driver, "information popup message not Showing with proper icon(i)", test, test1);
				System.out.println("information popup message not Showing with proper icon(i)");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String informationpopup_text = getText(driver, ERO_Warning_Message);

		if (informationpopup_text.equals(informationPopup_Message)) {
//			Extent_pass(driver, "information popup message having proper message", test,test1);
			System.out.println("Matched || Expected information popup message was : " + informationPopup_Message
					+ " Actual information popup message of creating new was : " + informationpopup_text);
			Extent_pass(driver, "Matched || Expected information popup message was : " + informationPopup_Message
					+ " Actual information popup message was : " + informationpopup_text, test, test1);
		} else {
			System.out.println("Not Matched || Expected information popup message was : " + informationPopup_Message
					+ " Actual information popup message was : " + informationpopup_text);
			Extent_pass(driver, "Not Matched || Expected information popup message was : " + informationPopup_Message
					+ " Actual information popup message was : " + informationpopup_text, test, test1);
		}

		Fluentwait(driver, ERO_Popup_Ok);
		click(driver, ERO_Popup_Ok);

		System.out.println("Testcase 64 completed");

		Extent_cal(test, "Testcase 70 - Ensure ID search button functionality");

		Fluentwait(driver, Deficittab);
		click(driver, Deficittab);

		Fluentwait(driver, IDField);
		String Deficit_ID = getAttribute(driver, IDField, "value");

		System.out.println("Deficit ID " + Deficit_ID);

		wait(driver, "5");

		Fluentwait(driver, ERO_Tab);
		click(driver, ERO_Tab);

		Fluentwait(driver, ERO_ID);
		String EROID = getAttribute(driver, ERO_ID, "value");

		System.out.println("ERO ID " + EROID);

		if (EROID.equals(Deficit_ID)) {

			System.out.println("ID was fetched from deficit and surplus location identification");
			Extent_pass(driver, "ID was fetched from deficit and surplus location identification", test, test1);
			Extent_pass(driver, "Deficit ID : " + Deficit_ID + " || ERO ID : " + EROID, test, test1);
		} else {
			System.out.println("ID was not fetched from deficit and surplus location identification");
			Extent_fail(driver, "ID was not fetched from deficit and surplus location identification", test, test1);
			Extent_fail(driver, "Deficit ID : " + Deficit_ID + " || ERO ID : " + EROID, test, test1);
		}

		System.out.println("Testcase 70 completed");

		Extent_cal(test, "Testcase 73 - Ensure ID  search field uneditable");

		if (!isClear(driver, ERO_ID)) {

			System.out.println("Id field is uneditable");
			Extent_pass(driver, "Id field is uneditable", test, test1);
		} else {
			System.out.println("Id field is uneditable");
			Extent_fail(driver, "Id field is uneditable", test, test1);
		}

		System.out.println("Testcase 73 completed");

		Extent_cal(test, "Testcase 67 - Ensure DS grid allows Filter functionality");

		wait(driver, "2");
		click(driver, ERo_origin_filter);

		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);

		Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver, EPO_SelectFilterSearchBox);

		Fluentwait(driver, Optimizer_First_val);
		click(driver, Optimizer_First_val);
		if (isDisplayed(driver, Optimizer_First_val)) {
			System.out.println("After click on Filter option Filter button is working  ");
			Extent_pass(driver, "After click on Filter option Filter button is working ", test, test1);
		} else {

			System.out.println("After click on Filter option Filter button is not working ");
			Extent_fail2(driver, "After click on Filter option Filter button is not working", test);
		}
		
		Fluentwait(driver, Optimizer_First_val);
		click(driver, Optimizer_First_val);
		
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		
		Fluentwait(driver, ERO_SVM);
		click(driver, ERO_SVM);

		wait(driver, "5");
		Fluentwait(driver, ero_Delivery);
		click(driver, ero_Delivery);
		
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		
		Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver, EPO_SelectFilterSearchBox);

		Fluentwait(driver, Optimizer_First_val);
		click(driver, Optimizer_First_val);
		
		if (isDisplayed(driver, Optimizer_First_val)) {
			System.out.println("After click on Filter option Filter button is working  ");
			Extent_pass(driver, "After click on Filter option Filter button is working ", test, test1);
		} else {

			System.out.println("After click on Filter option Filter button is not working ");
			Extent_fail2(driver, "After click on Filter option Filter button is not working", test);

		}
		
		Fluentwait(driver, Optimizer_First_val);
		click(driver, Optimizer_First_val);
		
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		
		Fluentwait(driver, ERO_SVM);
		click(driver, ERO_SVM);

		wait(driver, "5");
		Fluentwait(driver, ero_sizetype);
		click(driver, ero_sizetype);
		
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		
		Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver, EPO_SelectFilterSearchBox);

		Fluentwait(driver, Optimizer_First_val);
		click(driver, Optimizer_First_val);
	
		if (isDisplayed(driver, Optimizer_First_val)) {
			System.out.println("After click on Filter option Filter button is working  ");
			Extent_pass(driver, "After click on Filter option Filter button is working ", test, test1);
		} else {
			System.out.println("After click on Filter option Filter button is not working ");
			Extent_fail2(driver, "After click on Filter option Filter button is not working", test);
		}
		
		Fluentwait(driver, Optimizer_First_val);
		click(driver, Optimizer_First_val);
		
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		
		Fluentwait(driver, ERO_SVM);
		click(driver, ERO_SVM);

		wait(driver, "5");
		Fluentwait(driver, ero_cost);
		click(driver, ero_cost);
		
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		
		Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver, EPO_SelectFilterSearchBox);

		Fluentwait(driver, Optimizer_First_val);
		click(driver, Optimizer_First_val);
		if (isDisplayed(driver, Optimizer_First_val)) {
			System.out.println("After click on Filter option Filter button is working  ");
			Extent_pass(driver, "After click on Filter option Filter button is working ", test, test1);
		} else {

			System.out.println("After click on Filter option Filter button is not working ");
			Extent_fail2(driver, "After click on Filter option Filter button is not working", test);
		}
		
		Fluentwait(driver, Optimizer_First_val);
		click(driver, Optimizer_First_val);
		
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		
		Fluentwait(driver, ERO_SVM);
		click(driver, ERO_SVM);

		wait(driver, "5");
		Fluentwait(driver, Main_service);
		click(driver, Main_service);
		
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		
		Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver, EPO_SelectFilterSearchBox);

		Fluentwait(driver, Optimizer_First_val);
		click(driver, Optimizer_First_val);
		if (isDisplayed(driver, Optimizer_First_val)) {
			System.out.println("After click on Filter option Filter button is working  ");
			Extent_pass(driver, "After click on Filter option Filter button is working ", test, test1);
		} else {

			System.out.println("After click on Filter option Filter button is not working ");
			Extent_fail2(driver, "After click on Filter option Filter button is not working", test);
		}
		
		Fluentwait(driver, Optimizer_First_val);
		click(driver, Optimizer_First_val);
		
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		
		Fluentwait(driver, ERO_SVM);
		click(driver, ERO_SVM);

		wait(driver, "5");
		Fluentwait(driver, Main_service);
		click(driver, Main_service);
		
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		
		Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver, EPO_SelectFilterSearchBox);

		Fluentwait(driver, Optimizer_First_val);
		click(driver, Optimizer_First_val);
		
		if (isDisplayed(driver, Optimizer_First_val)) {
			System.out.println("After click on Filter option Filter button is working  ");
			Extent_pass(driver, "After click on Filter option Filter button is working ", test, test1);
		} else {

			System.out.println("After click on Filter option Filter button is not working ");
			Extent_fail2(driver, "After click on Filter option Filter button is not working", test);
		}
	
		Fluentwait(driver, Optimizer_First_val);
		click(driver, Optimizer_First_val);
		
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		
		Fluentwait(driver, ERO_SVM);
		click(driver, ERO_SVM);

		wait(driver, "5");
		Fluentwait(driver, Pol_ero);
		click(driver, Pol_ero);
		
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		
		Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver, EPO_SelectFilterSearchBox);

		Fluentwait(driver, Optimizer_First_val);
		click(driver, Optimizer_First_val);
		if (isDisplayed(driver, Optimizer_First_val)) {
			System.out.println("After click on Filter option Filter button is working  ");
			Extent_pass(driver, "After click on Filter option Filter button is working ", test, test1);
		} else {

			System.out.println("After click on Filter option Filter button is not working ");
			Extent_fail2(driver, "After click on Filter option Filter button is not working", test);
		}
		
		Fluentwait(driver, Optimizer_First_val);
		click(driver, Optimizer_First_val);
		
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		
		Fluentwait(driver, ERO_SVM);
		click(driver, ERO_SVM);

		wait(driver, "5");
		Fluentwait(driver, Pol_terminal);
		click(driver, Pol_terminal);
		
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		
		Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver, EPO_SelectFilterSearchBox);

		Fluentwait(driver, Optimizer_First_val);
		click(driver, Optimizer_First_val);
		
		if (isDisplayed(driver, Optimizer_First_val)) {
			System.out.println("After click on Filter option Filter button is working  ");
			Extent_pass(driver, "After click on Filter option Filter button is working ", test, test1);
		} else {

			System.out.println("After click on Filter option Filter button is not working ");
			Extent_fail2(driver, "After click on Filter option Filter button is not working", test);
		}
		
		Fluentwait(driver, Optimizer_First_val);
		click(driver, Optimizer_First_val);
		
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		
		Fluentwait(driver, ERO_SVM);
		click(driver, ERO_SVM);

		mouseOverToElement(driver, Pol_terminal);
		
		wait(driver, "5");
		WebElement scroller = driver.findElement(By.xpath("(//div[@ref='eBodyHorizontalScrollViewport'])[2]"));
		int scrollAmount = 1000; //
		js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller, scrollAmount);
		wait(driver, "2");
		click(driver, Pol_service);
	
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		
		Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver, EPO_SelectFilterSearchBox);

		Fluentwait(driver, Optimizer_First_val);
		click(driver, Optimizer_First_val);
		
		if (isDisplayed(driver, Optimizer_First_val)) {
			System.out.println("After click on Filter option Filter button is working  ");
			Extent_pass(driver, "After click on Filter option Filter button is working ", test, test1);
		} else {

			System.out.println("After click on Filter option Filter button is not working ");
			Extent_fail2(driver, "After click on Filter option Filter button is not working", test);
		}
		
		Fluentwait(driver, Optimizer_First_val);
		click(driver, Optimizer_First_val);
		
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		
		Fluentwait(driver, ERO_SVM);
		click(driver, ERO_SVM);

		mouseOverToElement(driver, Pol_terminal);
		
		wait(driver, "5");
		
		WebElement scroller1 = driver.findElement(By.xpath("(//div[@ref='eBodyHorizontalScrollViewport'])[2]"));
		int scrollAmount1 = 1000; //
		js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller1, scrollAmount1);
		wait(driver, "2");
		click(driver, Pol_trans1);
		
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		
		Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver, EPO_SelectFilterSearchBox);

		Fluentwait(driver, Optimizer_First_val);
		click(driver, Optimizer_First_val);
		if (isDisplayed(driver, Optimizer_First_val)) {
			System.out.println("After click on Filter option Filter button is working  ");
			Extent_pass(driver, "After click on Filter option Filter button is working ", test, test1);
		} else {

			System.out.println("After click on Filter option Filter button is not working ");
			Extent_fail2(driver, "After click on Filter option Filter button is not working", test);
		}
		
		Fluentwait(driver, Optimizer_First_val);
		click(driver, Optimizer_First_val);
		
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		
		Fluentwait(driver, ERO_SVM);
		click(driver, ERO_SVM);

		mouseOverToElement(driver, Pol_terminal);
		
		wait(driver, "5");
		
		WebElement scroller2 = driver.findElement(By.xpath("(//div[@ref='eBodyHorizontalScrollViewport'])[2]"));
		int scrollAmount2 = 1000; //
		js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller2, scrollAmount2);
		wait(driver, "2");
		click(driver, Pol_trans1Service);
		
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		
		Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver, EPO_SelectFilterSearchBox);

		Fluentwait(driver, Optimizer_First_val);
		click(driver, Optimizer_First_val);
		if (isDisplayed(driver, Optimizer_First_val)) {
			System.out.println("After click on Filter option Filter button is working  ");
			Extent_pass(driver, "After click on Filter option Filter button is working ", test, test1);
		} else {

			System.out.println("After click on Filter option Filter button is not working ");
			Extent_fail2(driver, "After click on Filter option Filter button is not working", test);
		}
		
		Fluentwait(driver, Optimizer_First_val);
		click(driver, Optimizer_First_val);
		
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		
		Fluentwait(driver, ERO_SVM);
		click(driver, ERO_SVM);

		mouseOverToElement(driver, Pol_terminal);
		
		wait(driver, "4");
		
		WebElement scroller3 = driver.findElement(By.xpath("(//div[@ref='eBodyHorizontalScrollViewport'])[2]"));
		int scrollAmount3 = 1100; //
		js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller3, scrollAmount3);
		wait(driver, "4");
		click(driver, Pol_trans2);
		
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		
		Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver, EPO_SelectFilterSearchBox);

		Fluentwait(driver, Optimizer_First_val);
		click(driver, Optimizer_First_val);
		if (isDisplayed(driver, Optimizer_First_val)) {
			System.out.println("After click on Filter option Filter button is working  ");
			Extent_pass(driver, "After click on Filter option Filter button is working ", test, test1);
		} else {

			System.out.println("After click on Filter option Filter button is not working ");
			Extent_fail2(driver, "After click on Filter option Filter button is not working", test);
		}
		
		Fluentwait(driver, Optimizer_First_val);
		click(driver, Optimizer_First_val);
		
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		
		Fluentwait(driver, ERO_SVM);
		click(driver, ERO_SVM);

		mouseOverToElement(driver, Pol_terminal);
		
		wait(driver, "5");
		
		WebElement scroller4 = driver.findElement(By.xpath("(//div[@ref='eBodyHorizontalScrollViewport'])[2]"));
		int scrollAmount4 = 1100; //
		js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller4, scrollAmount4);
		wait(driver, "4");
		click(driver, Pol_trans2Service);
		
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		
		Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver, EPO_SelectFilterSearchBox);

		Fluentwait(driver, Optimizer_First_val);
		click(driver, Optimizer_First_val);
		if (isDisplayed(driver, Optimizer_First_val)) {
			System.out.println("After click on Filter option Filter button is working  ");
			Extent_pass(driver, "After click on Filter option Filter button is working ", test, test1);
		} else {

			System.out.println("After click on Filter option Filter button is not working ");
			Extent_fail2(driver, "After click on Filter option Filter button is not working", test);
		}
		
		Fluentwait(driver, Optimizer_First_val);
		click(driver, Optimizer_First_val);
		
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		
		Fluentwait(driver, ERO_SVM);
		click(driver, ERO_SVM);

		mouseOverToElement(driver, Pol_terminal);
		
		wait(driver, "5");
		
		WebElement scroller5 = driver.findElement(By.xpath("(//div[@ref='eBodyHorizontalScrollViewport'])[2]"));
		int scrollAmount5 = 1000; //
		js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller5, scrollAmount5);
		wait(driver, "2");
		click(driver, Pol_trans3);
		
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		
		Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver, EPO_SelectFilterSearchBox);

		Fluentwait(driver, Optimizer_First_val);
		click(driver, Optimizer_First_val);
		if (isDisplayed(driver, Optimizer_First_val)) {
			System.out.println("After click on Filter option Filter button is working  ");
			Extent_pass(driver, "After click on Filter option Filter button is working ", test, test1);
		} else {

			System.out.println("After click on Filter option Filter button is not working ");
			Extent_fail2(driver, "After click on Filter option Filter button is not working", test);
		}
		
		Fluentwait(driver, Optimizer_First_val);
		click(driver, Optimizer_First_val);
		
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		
		Fluentwait(driver, ERO_SVM);
		click(driver, ERO_SVM);

		mouseOverToElement(driver, Pol_terminal);
		
		wait(driver, "5");
		
		WebElement scroller6 = driver.findElement(By.xpath("(//div[@ref='eBodyHorizontalScrollViewport'])[2]"));
		int scrollAmount6 = 1000; //
		js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller6, scrollAmount6);
		wait(driver, "2");
		click(driver, Pol_trans3Service);
		
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		
		Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver, EPO_SelectFilterSearchBox);

		Fluentwait(driver, Optimizer_First_val);
		click(driver, Optimizer_First_val);
	
		if (isDisplayed(driver, Optimizer_First_val)) {
			System.out.println("After click on Filter option Filter button is working  ");
			Extent_pass(driver, "After click on Filter option Filter button is working ", test, test1);
		} else {

			System.out.println("After click on Filter option Filter button is not working ");
			Extent_fail2(driver, "After click on Filter option Filter button is not working", test);
		}
		
		Fluentwait(driver, Optimizer_First_val);
		click(driver, Optimizer_First_val);
		
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		
		Fluentwait(driver, ERO_SVM);
		click(driver, ERO_SVM);

		mouseOverToElement(driver, Pol_terminal);

		wait(driver, "5");
		
		WebElement scroller7 = driver.findElement(By.xpath("(//div[@ref='eBodyHorizontalScrollViewport'])[2]"));
		int scrollAmount7 = 1000; //
		js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller7, scrollAmount7);
		
		wait(driver, "2");
		click(driver, Pod);
		
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		
		Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver, EPO_SelectFilterSearchBox);

		Fluentwait(driver, Optimizer_First_val);
		click(driver, Optimizer_First_val);
		if (isDisplayed(driver, Optimizer_First_val)) {
			System.out.println("After click on Filter option Filter button is working  ");
			Extent_pass(driver, "After click on Filter option Filter button is working ", test, test1);
		} else {

			System.out.println("After click on Filter option Filter button is not working ");
			Extent_fail2(driver, "After click on Filter option Filter button is not working", test);
		}
		
		Fluentwait(driver, Optimizer_First_val);
		click(driver, Optimizer_First_val);
		
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		
		Fluentwait(driver, ERO_SVM);
		click(driver, ERO_SVM);

		mouseOverToElement(driver, Pol_terminal);
		
		wait(driver, "5");
		
		WebElement scroller8 = driver.findElement(By.xpath("(//div[@ref='eBodyHorizontalScrollViewport'])[2]"));
		int scrollAmount8 = 1000; 
		js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller8, scrollAmount8);
		wait(driver, "2");
		click(driver, Pod_terminal);
		
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		
		Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver, EPO_SelectFilterSearchBox);

		Fluentwait(driver, Optimizer_First_val);
		click(driver, Optimizer_First_val);
		if (isDisplayed(driver, Optimizer_First_val)) {
			System.out.println("After click on Filter option Filter button is working  ");
			Extent_pass(driver, "After click on Filter option Filter button is working ", test, test1);
		} else {

			System.out.println("After click on Filter option Filter button is not working ");
			Extent_fail2(driver, "After click on Filter option Filter button is not working", test);
		}
		
		Fluentwait(driver, Optimizer_First_val);
		click(driver, Optimizer_First_val);
		
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		
		Fluentwait(driver, ERO_SVM);
		click(driver, ERO_SVM);

		mouseOverToElement(driver, Pol_terminal);
		
		wait(driver, "5");
		
		WebElement scroller9 = driver.findElement(By.xpath("(//div[@ref='eBodyHorizontalScrollViewport'])[2]"));
		int scrollAmount9 = 2100; //
		js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller9, scrollAmount9);
		wait(driver, "4");
		click(driver, Pod_Delivery_mode);
		
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		
		Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver, EPO_SelectFilterSearchBox);

		Fluentwait(driver, Optimizer_First_val);
		click(driver, Optimizer_First_val);
		if (isDisplayed(driver, Optimizer_First_val)) {
			System.out.println("After click on Filter option Filter button is working  ");
			Extent_pass(driver, "After click on Filter option Filter button is working ", test, test1);
		} else {

			System.out.println("After click on Filter option Filter button is not working ");
			Extent_fail2(driver, "After click on Filter option Filter button is not working", test);
		}
		
		Fluentwait(driver, Optimizer_First_val);
		click(driver, Optimizer_First_val);
		
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		
		Fluentwait(driver, ERO_SVM);
		click(driver, ERO_SVM);

		mouseOverToElement(driver, Pol_terminal);
		
		wait(driver, "5");
		
		WebElement scroller19 = driver.findElement(By.xpath("(//div[@ref='eBodyHorizontalScrollViewport'])[2]"));
		int scrollAmount19 = 2100; //
		js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller19, scrollAmount19);
		wait(driver, "4");
		click(driver, Pod_Transit);
	
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		
		Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver, EPO_SelectFilterSearchBox);

		Fluentwait(driver, Optimizer_First_val);
		click(driver, Optimizer_First_val);
		if (isDisplayed(driver, Optimizer_First_val)) {
			System.out.println("After click on Filter option Filter button is working  ");
			Extent_pass(driver, "After click on Filter option Filter button is working ", test, test1);
		} else {

			System.out.println("After click on Filter option Filter button is not working ");
			Extent_fail2(driver, "After click on Filter option Filter button is not working", test);
		}
		
		Fluentwait(driver, Optimizer_First_val);
		click(driver, Optimizer_First_val);
		
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		
		Fluentwait(driver, ERO_SVM);
		click(driver, ERO_SVM);

		mouseOverToElement(driver, Pol_terminal);
		
		wait(driver, "5");
		
		WebElement scroller10 = driver.findElement(By.xpath("(//div[@ref='eBodyHorizontalScrollViewport'])[2]"));
		int scrollAmount10 = 2100; //
		js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller10, scrollAmount10);
		wait(driver, "4");
		click(driver, Pod_missingcost);
		wait(driver, "2");
		
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		
		Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver, EPO_SelectFilterSearchBox);

		Fluentwait(driver, Optimizer_First_val);
		click(driver, Optimizer_First_val);
		if (isDisplayed(driver, Optimizer_First_val)) {
			System.out.println("After click on Filter option Filter button is working  ");
			Extent_pass(driver, "After click on Filter option Filter button is working ", test, test1);
		} else {

			System.out.println("After click on Filter option Filter button is not working ");
			Extent_fail2(driver, "After click on Filter option Filter button is not working", test);
		}
		
		Fluentwait(driver, Optimizer_First_val);
		click(driver, Optimizer_First_val);
		
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		
		Fluentwait(driver, ERO_SVM);
		click(driver, ERO_SVM);

		mouseOverToElement(driver, Pol_terminal);
		
		wait(driver, "5");
		
		WebElement scroller11 = driver.findElement(By.xpath("(//div[@ref='eBodyHorizontalScrollViewport'])[2]"));
		int scrollAmount11 = 2100; //
		js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller11, scrollAmount11);
		wait(driver, "4");
		click(driver, Pod_routing);
		
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		
		Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver, EPO_SelectFilterSearchBox);

		Fluentwait(driver, Optimizer_First_val);
		click(driver, Optimizer_First_val);
		
		if (isDisplayed(driver, Optimizer_First_val)) {
			System.out.println("After click on Filter option Filter button is working  ");
			Extent_pass(driver, "After click on Filter option Filter button is working ", test, test1);
		} else {

			System.out.println("After click on Filter option Filter button is not working ");
			Extent_fail2(driver, "After click on Filter option Filter button is not working", test);
		}
		
		Fluentwait(driver, Optimizer_First_val);
		click(driver, Optimizer_First_val);
		
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		
		Fluentwait(driver, ERO_SVM);
		click(driver, ERO_SVM);

		System.out.println("*********Testcase 67 completed************");

	}

}
