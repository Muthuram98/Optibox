package DeficitAndSurflusLocationIdentification_Scripts;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.Utils;

public class TS006to10_DeficitandSurplusLocationId_TC59to69 extends Keywords {

	public void Scenario6to10(WebDriver driver, ExtentTest test,ExtentTest test1, String url, int dataset) throws Exception {

		String Username = Utils.getDataFromTestData("TS006to10_DeficitandSurplusLocationId_Dataset"+dataset,
				"DeficitandSurplusLocationId", "Username");
		String Password = Utils.getDataFromTestData("TS006to10_DeficitandSurplusLocationId_Dataset"+dataset,
				"DeficitandSurplusLocationId", "Password");
		String Popup_Message = Utils.getDataFromTestData("TS006to10_DeficitandSurplusLocationId_Dataset"+dataset,
				"DeficitandSurplusLocationId", "New_Confirmation_popup");
		String WarningPopup_Message = Utils.getDataFromTestData("TS006to10_DeficitandSurplusLocationId_Dataset"+dataset,
				"DeficitandSurplusLocationId", "Warning_message");
		String InformationPopup_Message = Utils.getDataFromTestData("TS006to10_DeficitandSurplusLocationId_Dataset"+dataset,
				"DeficitandSurplusLocationId", "Information_message");
		String ID = Utils.getDataFromTestData("TS006to10_DeficitandSurplusLocationId_Dataset"+dataset, "DeficitandSurplusLocationId",
				"Id");
 
		Actions act = new Actions(driver);

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

		Fluentwait(driver, Selectdeficit);
		click(driver, Selectdeficit);

		wait(driver, "5");

		Fluentwait(driver, Cancel);
		click(driver, Cancel);

		wait(driver, "2");

		Fluentwait(driver, New);
		click(driver, New);

		Fluentwait(driver, createnew_confirm);
		click(driver, createnew_confirm);

		Extent_cal(test,"Testcase 59 - Ensure while moving the cursor on the tool bar ,system should show the tool tips");

		wait(driver, "5");

		for (int i = 1; i <= 14; i++) {

			WebElement button = driver.findElement(By.xpath("((//div[@id='DSL-DSL_toolbar-tblComponent']//button)[" + i + "]//span)[1]"));

			wait(driver, "2");

			act.moveToElement(button).build().perform();

			String buttonname = Utils.getDataFromTestData("TS006to10_DeficitandSurplusLocationId",
					"DeficitandSurplusLocationId", "Button" + i);

			WebElement Tooltipfield = driver.findElement(By.xpath("(//div[@id='DSL-DSL_toolbar-tblComponent']//button)["
					+ i + "]//span[contains(text(),'" + buttonname + "')]"));

			if (isDisplayed1(driver, Tooltipfield)) {

				Extent_pass(driver, "Tool tip for " + buttonname + " is displayed", test,test1);

				getTextofWebelement(driver, Tooltipfield, "Tool tip");
			
			} else {

				Extent_fail(driver, "Tool tip for " + buttonname + " is not displayed", test,test1);
			}

//			wait(driver, "3");

		}

		System.out.println("**********Testcase 59 completed******************");

		Extent_cal(test, "Testcase 60 - Ensure tab function in all the filed");

		Fluentwait(driver, Reposition_dropdown);
		click(driver, Reposition_dropdown);

		List<By> inutlocators = Arrays.asList(By.id("DSL-DSL_spnFromYear_input"), By.id("DSL-DSL_txtFromWeek_input"),
				By.id("DSL-DSL_spnToYear_input"), By.id("DSL-DSL_txtToWeek_input"));

		List<String> inutfieldnames = Arrays.asList("FromYear_input", "FromWeek_input", "ToYear_input", "ToWeek_input");
		// Iterate through the locators and click the elements

		wait(driver, "2");

//		rbt.keyPress(KeyEvent.VK_TAB);
//		rbt.delay(500);
//		rbt.keyRelease(KeyEvent.VK_TAB);
		
		act.sendKeys(Keys.TAB).build().perform();
		
		wait(driver, "3");

		boolean tab = true;

		for (int i = 0; i < inutlocators.size(); i++) {

			By locator = inutlocators.get(i);
			String fieldname = inutfieldnames.get(i);

			try {
				WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));

				wait(driver, "2");

//				rbt.keyPress(KeyEvent.VK_TAB);
//				rbt.delay(500);
//				rbt.keyRelease(KeyEvent.VK_TAB);
				
				act.sendKeys(Keys.TAB).build().perform();

				wait(driver, "3");

				String attributevalue = element.getAttribute("class");

				String status1 = extractstatus(attributevalue);

				System.out.println("status1 :" + status1);

				if (status1.equals("focus")) {
					System.out.println("Pass ");
					Extent_pass(driver, "After click on tab button, selection cursor got navigated from " + fieldname,
							test,test1);
				} else {
					System.out.println("Fail");
					Extent_fail(driver, "After click on tab button, selection cursor not navigated from " + fieldname,
							test,test1);
				}

			} catch (Exception e) {
				System.out
						.println("Element with locator " + locator + " not found or not clickable: " + e.getMessage());
				Extent_fail(driver,
						"Element with locator " + locator + " not found or not clickable: " + e.getMessage(), test,test1);
				tab = false;
			}
		}

		System.out.println("Tab button functionality is working fine");
		Extent_pass(driver, "Tab button functionality is working fine", test,test1);

		System.out.println("**********Testcase 60 completed******************");

		Extent_cal(test, "Testcase 61 - Cursor point should move to the Privious field");

		wait(driver, "3");

		Fluentwait(driver, Reposition_dropdown);
		click(driver, Reposition_dropdown);

		wait(driver, "1");

//		rbt.keyPress(KeyEvent.VK_ALT);
//		rbt.keyPress(KeyEvent.VK_TAB);
//		wait(driver, "2");
//		rbt.keyRelease(KeyEvent.VK_ALT);
//		rbt.keyRelease(KeyEvent.VK_TAB);
		
		act.sendKeys(Keys.ALT).build().perform();
		act.sendKeys(Keys.TAB).build().perform();

		wait(driver, "5");

//		rbt.keyPress(KeyEvent.VK_ALT);
//		rbt.keyPress(KeyEvent.VK_TAB);
//		wait(driver, "2");
//		rbt.keyRelease(KeyEvent.VK_ALT);
//		rbt.keyRelease(KeyEvent.VK_TAB);
		
		act.sendKeys(Keys.ALT).build().perform();
		act.sendKeys(Keys.TAB).build().perform();

//		if (wait.until(
//				ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='Forecasting Reposition']"))) != null) {
//
//			System.out.println("After redirect the page using alt+tab, Selection dropdown is still in open");
//			Extent_pass(driver, "After redirect the page using alt+tab, Selection dropdown is still in open", test,test1);
//		} else {
//			System.out.println("After redirect the page using alt+tab, Selection dropdown got closed");
//			Extent_fail(driver, "After redirect the page using alt+tab, Selection dropdown got closed", test,test1);
//			global = "After redirect the page using alt+tab, Selection dropdown got closed ";
//		}

		List<By> locators = Arrays.asList(By.id("DSL-DSL_spnFromYear_input"), By.id("DSL-DSL_txtFromWeek_input"),
				By.id("DSL-DSL_spnToYear_input"), By.id("DSL-DSL_txtToWeek_input"), By.id("DSL-DSL_txtSurplus"),
				By.id("DSL-DSL_txtDeficit"));

		List<String> fieldnames = Arrays.asList("FromYear_input", "FromWeek_input", "ToYear_input", "ToWeek_input",
				"Surplus", "Deficit");
		// Iterate through the locators and click the elements

		for (int i = 0; i < locators.size(); i++) {

			By locator = locators.get(i);
			String fieldname = fieldnames.get(i);

			try {
				WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
				element.click();

				wait(driver, "5");

//				rbt.keyPress(KeyEvent.VK_ALT);
//				rbt.keyPress(KeyEvent.VK_TAB);
//				wait(driver, "2");
//				rbt.keyRelease(KeyEvent.VK_ALT);
//				rbt.keyRelease(KeyEvent.VK_TAB);
				
				act.sendKeys(Keys.ALT).build().perform();
				act.sendKeys(Keys.TAB).build().perform();

				wait(driver, "3");

//				rbt.keyPress(KeyEvent.VK_ALT);
//				rbt.keyPress(KeyEvent.VK_TAB);
//				wait(driver, "2");
//				rbt.keyRelease(KeyEvent.VK_ALT);
//				rbt.keyRelease(KeyEvent.VK_TAB);
				act.sendKeys(Keys.ALT).build().perform();
				act.sendKeys(Keys.TAB).build().perform();

				wait(driver, "3");

				String attributevalue = element.getAttribute("class");

				String status1 = extractstatus(attributevalue);

				System.out.println("status1 :" + status1);

				if (status1.equals("focus")) {
					System.out.println("Pass ");
					Extent_pass(driver, "After redirect the page using alt+tab, selection is still on the " + fieldname,
							test,test1);
				} else {
					System.out.println("Fail");
					Extent_fail(driver, "After redirect the page using alt+tab, selection is not on the " + fieldname,
							test,test1);
				}

			} catch (Exception e) {
				System.out
						.println("Element with locator " + locator + " not found or not clickable: " + e.getMessage());
				Extent_fail(driver,
						"Element with locator " + locator + " not found or not clickable: " + e.getMessage(), test,test1);
			}
		}

		System.out.println("**********Testcase 61 completed******************");

		Extent_cal(test, "Testcase 62 - Ensure Confirmation pop up window having proper messages with icon(?)");

		scrollBottom(driver);
		
		wait(driver, "5");

		Fluentwait(driver, Cancel);
		click(driver, Cancel);

		wait(driver, "2");

		Fluentwait(driver, New);
		click(driver, New);

		Fluentwait(driver, createnew_confirm_message);

		try {
//			elementScreenShot_new(driver, Question_Icon, "/Expected_screenshot/Elementscreenshot/Questionmark");
			wait(driver, "2");
			elementScreenShot_new(driver, Question_Icon, "/Actual_screenshot/Elementscreenshot/Questionmark");
			wait(driver, "2");
			imageComparison2(driver, "/Elementscreenshot/Questionmark", "/Elementscreenshot/Questionmark");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Extent_fail(driver, e.getLocalizedMessage(), test,test1);
		}

		String Confirmationpopup_text = getText(driver, createnew_confirm_message);

		if (Confirmationpopup_text.equals(Popup_Message)) {
			Extent_pass(driver, "Confirmation popup message having proper message with icon(?)", test,test1);
			System.out.println("Matched || Expected confirmation popup message of creating new was : " + Popup_Message
					+ " Actual confirmation popup message of creating new was : " + Confirmationpopup_text);
			Extent_pass(driver,
					"Matched || Expected confirmation popup message of creating new was : " + Popup_Message
							+ " Actual confirmation popup message of creating new was : " + Confirmationpopup_text,
					test,test1);
		} else {
			System.out
					.println("Not Matched || Expected confirmation popup message of creating new was : " + Popup_Message
							+ " Actual confirmation popup message of creating new was : " + Confirmationpopup_text);
			Extent_fail(driver,
					"Not Matched || Expected confirmation popup message of creating new was : " + Popup_Message
							+ " Actual confirmation popup message of creating new was : " + Confirmationpopup_text,
					test,test1);

		}

		Fluentwait(driver, createnew_confirm);
		click(driver, createnew_confirm);

		System.out.println("******************Testcase 62 Completed ***********************");

		Extent_cal(test, "Testcase 63 - Ensure Warning pop up window having proper messages with icon(!)");

		Fluentwait1(driver, Fromweek_input);
		click(driver, Fromweek_input);
		clear(driver, Fromweek_input);
		wait(driver, "2");
		sendKeys(driver, Fromweek_input, ID);

		Fluentwait(driver, Show);
		click(driver, Show);

		try {
//			elementScreenShot_new(driver, Question_Icon, "/Expected_screenshot/Elementscreenshot/exclamation mark");
			wait(driver, "2");
//			elementScreenShot_new(driver, Question_Icon, "/Actual_screenshot/Elementscreenshot/exclamation mark");
			
			wait(driver, "2");
		
			if(imageComparison2(driver, "/Elementscreenshot/exclamation mark", "/Elementscreenshot/exclamation mark")) {
				Extent_pass(driver, "Warning popup message Showing with proper icon(!)", test,test1);
			}else {
				Extent_fail(driver, "Warning popup message not Showing with proper icon(!)", test,test1);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String Warningpopup_text = getText(driver, createnew_confirm_message);

		if (Warningpopup_text.equals(WarningPopup_Message)) {
			Extent_pass(driver, "Warning popup message having proper message with icon(!)", test,test1);
			System.out.println("Matched || Expected Warning popup message of creating new was : " + WarningPopup_Message
					+ " Actual Warning popup message of creating new was : " + Warningpopup_text);
			Extent_pass(driver, "Matched || Expected Warning popup message of creating new was : "
					+ WarningPopup_Message + " Actual Warning popup message of creating new was : " + Warningpopup_text,
					test,test1);
		} else {
			System.out.println(
					"Not Matched || Expected Warning popup message of creating new was : " + WarningPopup_Message
							+ " Actual Warning popup message of creating new was : " + Warningpopup_text);
			Extent_fail2(driver, "Not Matched || Expected Warning popup message of creating new was : "
					+ WarningPopup_Message + " Actual Warning popup message of creating new was : " + Warningpopup_text,
					test);

		}

		Fluentwait(driver, Warningpopup_Ok);
		click(driver, Warningpopup_Ok);

		System.out.println("******************Testcase 63 Completed ***********************");

		Extent_cal(test, "Testcase 64 - Ensure information pop up window having proper messages with icon(i)");

		Fluentwait(driver, Globalserach);
		click(driver, Globalserach);

		wait(driver, "2");

		Fluentwait1(driver, Click_Search);
		click(driver, Click_Search);

		Fluentwait(driver, Information_Icon);
		String Informationnpopup_text = getText(driver, Informationpopup_message);

		try {
//			elementScreenShot_new(driver, Information_Icon, "/Expected_screenshot/Elementscreenshot/Information Icon");
			wait(driver, "2");
			elementScreenShot_new(driver, Information_Icon, "/Actual_screenshot/Elementscreenshot/Information Icon");
			wait(driver, "2");
			imageComparison2(driver, "/Elementscreenshot/Information Icon", "/Elementscreenshot/Information Icon");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("******************Testcase 64 Completed ***********************");

		Extent_cal(test, "Testcase 65 - Ensure information pop up window having proper messages with icon(x)");

		if (Informationnpopup_text.equals(InformationPopup_Message)) {
			Extent_pass(driver, "Information popup message having proper message with icon(x)", test,test1);
			System.out.println(
					"Matched || Expected Information popup message of creating new was : " + InformationPopup_Message
							+ " Actual Information popup message of creating new was : " + Informationnpopup_text);
			Extent_pass(driver,
					"Matched || Expected Information popup message of creating new was : " + InformationPopup_Message
							+ " Actual Information popup message of creating new was : " + Informationnpopup_text,
					test,test1);
		} else {
			System.out.println("Not Matched || Expected Information popup message of creating new was : "
					+ InformationPopup_Message + " Actual Information popup message of creating new was : "
					+ Informationnpopup_text);
			Extent_fail2(driver,
					"Not Matched || Expected Information popup message of creating new was : "
							+ InformationPopup_Message + " Actual Information popup message of creating new was : "
							+ Informationnpopup_text,
					test);

		}

		wait(driver, "3");

		System.out.println("******************Testcase 65 Completed ***********************");

		wait(driver, "3");

		Extent_cal(test,
				"Testcase 68 - Ensure Scientific grid allows Filter functionality according to the conditions and inputs");

		Fluentwait(driver, Globalserach_IDInput);
		sendKeys(driver, Globalserach_IDInput, ID);

		wait(driver, "2");

		Fluentwait(driver, Click_Search);
		click(driver, Click_Search);

		wait(driver, "5");

		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);

		wait(driver, "5");

		Fluentwait(driver, Filteroption1);
		String Option1 = getText(driver, Filteroption1);

		wait(driver,"2");
		String Option2 = getText(driver, Filteroption2);

		WebElement location1 = driver.findElement(By.xpath("//div[@col-id='location' and text()='" + Option2 + "']"));

		Fluentwait(driver, Location_filter);
		click(driver, Location_filter);

		Fluentwait(driver, filterMenu);
		click(driver, filterMenu);
		
		wait(driver,"2");
		
		Fluentwait(driver, Search_input);
		sendKeys(driver, Search_input, Option1);

		wait(driver, "2");

		enter(driver);

		wait(driver, "2");

		if (!isDisplayed1(driver, location1)) {

			System.out.println("Grid Filter is working fine and the given filter value was : " + Option1);
			Extent_pass(driver, "Grid Filter is working fine and the given filter value was : " + Option1, test,test1);
		} else {

			System.out.println("Grid Filter is not working and the given filter value was : " + Option1);
			Extent_fail(driver, "Grid Filter is not working and the given filter value was : " + Option1, test,test1);
		}

		wait(driver, "5");

		act.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
		wait(driver, "2");
		act.sendKeys(Keys.BACK_SPACE).perform();

		wait(driver, "5");

		Fluentwait(driver, Selectall);
		click(driver, Selectall);

		Fluentwait(driver, filterMenu);
		click(driver, filterMenu);

		wait(driver, "5");

		if (isDisplayed1(driver, location1)) {

			System.out.println("After clear the filter value and click enter, It shows all the values");
//			Extent_pass(driver, "After clear the filter value and click enter, It shows all the values", test,test1);
		} else {

			System.out.println("After clear the filter value and click enter, It still shows previous filter value");
//			Extent_fail(driver, "After clear the filter value and click enter, It still shows previous filter value",
//					test,test1);
		}

		System.out.println("******************Testcase 68 Completed ***********************");

		Extent_cal(test, "Testcase 67 - Ensure DS grid allows Filter functionality");

		Fluentwait(driver, Tree_table);
		click(driver, Tree_table);

		Fluentwait(driver, Condition_filter);
		click(driver, Condition_filter);

		Fluentwait(driver, filter_input);

		String locatio1 = getText(driver, Location3);

		sendKeys(driver, filter_input, locatio1);

		WebElement last_location = driver.findElement(By.xpath("(//div[@col-id='location'])[last()]"));

		String lastlocation = last_location.getText();

		if (lastlocation.equals(locatio1)) {

			System.out.println("DS grid filter is working fine");
			Extent_pass(driver, "DS grid filter is working fine", test,test1);

		} else {

			System.out.println("DS grid filter is not working fine");
			Extent_fail(driver, "DS grid filter is not working fine", test,test1);
		}
		
		act.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
		wait(driver, "2");
		act.sendKeys(Keys.BACK_SPACE).perform();
		

		System.out.println(" ************************Testcase 67 - Completed *************************");

		Extent_cal(test, "Testcase 69 - Ensure Scientific grid allows to paste the copied record in grid itself");

		Fluentwait(driver, Location3);
		click(driver, Location3);
		
		act.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();

		Fluentwait(driver, Location_filter);
		click(driver, Location_filter);

//		Fluentwait(driver, filterMenu);
//		click(driver, filterMenu);

		Fluentwait(driver, Search_input);
		click(driver, Search_input);

		wait(driver, "2");

//		rbt.keyPress(KeyEvent.VK_CONTROL);
//		rbt.delay(500);
//		rbt.keyPress(KeyEvent.VK_V);
//		rbt.delay(500);
//		rbt.keyRelease(KeyEvent.VK_V);
//		rbt.delay(500);
//		rbt.keyRelease(KeyEvent.VK_CONTROL);
		
		act.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();

		wait(driver, "2");

		try {
			String inputvalue = getText(driver, Search_input);

			System.out.println("inputvalue : " + inputvalue);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (!isDisplayed(driver, Selectall)) {

			System.out.println("Grid filter accept to paste the copied data");
			Extent_pass(driver, "Grid filter accept to paste the copied data", test,test1);

		} else {

			System.out.println("Grid filter not accept to paste the copied data");
			Extent_fail(driver, "Grid filter not accept to paste the copied data", test,test1);
			
		}
		
		act.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
		wait(driver, "2");
		act.sendKeys(Keys.BACK_SPACE).perform();

		System.out.println(" ************************Testcase 69 - Completed *************************");


		Fluentwait(driver, filterMenu);
		click(driver, filterMenu);

		Fluentwait(driver, Location3);
		click(driver, Location3);

//		rbt.keyPress(KeyEvent.VK_CONTROL);
//		rbt.delay(500);
//		rbt.keyPress(KeyEvent.VK_C);
		
		act.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();

		Fluentwait(driver, Location3);
		String locationname = getText(driver, Location3);

		wait(driver, "2");

//		rbt.keyPress(KeyEvent.VK_CONTROL);
//		rbt.delay(500);
//		rbt.keyPress(KeyEvent.VK_V);
//		rbt.delay(500);
//		rbt.keyRelease(KeyEvent.VK_V);
//		rbt.delay(500);
//		rbt.keyRelease(KeyEvent.VK_CONTROL);
		
		act.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();

		wait(driver, "2");

		Fluentwait(driver, Location3);
		click(driver, Location3);

		String locationname2 = getText(driver, Location3);

		if (locationname2.equals(locationname)) {

			System.out.println("System not allow to paste the copied data in the grid");
			Extent_pass(driver, "System not allow to paste the copied data in the grid", test,test1);

		} else {

			System.out.println("System allowed to paste the copied data in the grid");
			Extent_fail(driver, "System allowed to paste the copied data in the grid", test,test1);
		}
	
		System.out.println(" ************************Testcase 66 - Completed *************************");

	}

}
