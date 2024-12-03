package DeficitAndSurflusLocationIdentification_Scripts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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

public class Tc_001_DeficitandSurplusLocationId extends Keywords {

	public void Scenario001(WebDriver driver, ExtentTest test, ExtentTest test1, String url, int dataset)
			throws AWTException, IOException, InterruptedException {

		String Username = Utils.getDataFromTestData("Tc_001_DeficitandSurplusLocationId_Datset" + dataset,
				"DeficitandSurplusLocationId", "Username");
		String Password = Utils.getDataFromTestData("Tc_001_DeficitandSurplusLocationId_Datset" + dataset,
				"DeficitandSurplusLocationId", "Password");
		String ID = Utils.getDataFromTestData("Tc_001_DeficitandSurplusLocationId_Datset" + dataset,
				"DeficitandSurplusLocationId", "Id");
		String Error_Msg_popup_ID = Utils.getDataFromTestData("Tc_001_DeficitandSurplusLocationId_Datset" + dataset,
				"DeficitandSurplusLocationId", "ID_Error_msg_popup");
		String Error_Msg_popup_Invalid_Input = Utils.getDataFromTestData(
				"Tc_001_DeficitandSurplusLocationId_Datset" + dataset, "DeficitandSurplusLocationId",
				"Invalid_Msg_Popup");
		String ID_Invalid = Utils.getDataFromTestData("Tc_001_DeficitandSurplusLocationId_Datset" + dataset,
				"DeficitandSurplusLocationId", "Invalid_ID");
		String Data = Utils.getDataFromTestData("Tc_001_DeficitandSurplusLocationId_Datset" + dataset,
				"DeficitandSurplusLocationId", "Empty_Data");
		String Condition_Filter_1 = Utils.getDataFromTestData("Tc_001_DeficitandSurplusLocationId_Datset" + dataset,
				"DeficitandSurplusLocationId", "Filter1");
		String Popup_Message = Utils.getDataFromTestData("Tc_001_DeficitandSurplusLocationId_Datset" + dataset,
				"DeficitandSurplusLocationId", "PopupMessage");
		String Week = Utils.getDataFromTestData("Tc_001_DeficitandSurplusLocationId_Datset" + dataset,
				"DeficitandSurplusLocationId", "Week_Data");
		String Week1 = Utils.getDataFromTestData("Tc_001_DeficitandSurplusLocationId_Datset" + dataset,
				"DeficitandSurplusLocationId", "Week_Data1");
		String Leasing_Popup = Utils.getDataFromTestData("Tc_001_DeficitandSurplusLocationId_Datset" + dataset,
				"DeficitandSurplusLocationId", "Updated_Leasing_Popup");

		String Popup_Week = Utils.getDataFromTestData("Tc_001_DeficitandSurplusLocationId_Datset" + dataset,
				"DeficitandSurplusLocationId", "PopupWeek");
		String Dropdown_Repo = Utils.getDataFromTestData("Tc_001_DeficitandSurplusLocationId_Datset" + dataset,
				"DeficitandSurplusLocationId", "Dropdown_Data");
		String Error_Msg_popup_Save = Utils.getDataFromTestData("Tc_001_DeficitandSurplusLocationId_Datset" + dataset,
				"DeficitandSurplusLocationId", "Save_Error_msg_popup");
		String Input_Data = Utils.getDataFromTestData("Tc_001_DeficitandSurplusLocationId_Datset" + dataset,
				"DeficitandSurplusLocationId", "InputData");

		String EquimentType_Alphabets1 = System.getProperty("user.dir") + "\\uploads\\Budget_Flow.xlsx";
		String one_way_out_load_column = Utils.getDataFromTestData("Tc_001_DeficitandSurplusLocationId",
				"DeficitandSurplusLocationId", "one way out load column");
		String one_way_out_return_column = Utils.getDataFromTestData("Tc_001_DeficitandSurplusLocationId",
				"DeficitandSurplusLocationId", "one way out return column");
		String one_way_in_load_column = Utils.getDataFromTestData("Tc_001_DeficitandSurplusLocationId",
				"DeficitandSurplusLocationId", "one way in load column");
		String one_way_in_return_column = Utils.getDataFromTestData("Tc_001_DeficitandSurplusLocationId",
				"DeficitandSurplusLocationId", "one way in return column");

		Actions act = new Actions(driver);
		Robot rbt = new Robot();
		JavascriptExecutor js = (JavascriptExecutor) driver;

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
		sendKeys(driver, Searchbox, "Deficit and Surplus Location Identification");

		Fluentwait(driver, Selectdeficit);
		click(driver, Selectdeficit);

		wait(driver, "3");

		Extent_cal(test, "Testcase 1 - Ensure that validation get displayed when click save without records");

		Fluentwait(driver, Save);
		click(driver, Save);

		Fluentwait(driver, Save_popup_text);

		String Save_Error_Popup_Msg1 = getText(driver, Save_popup_text);

		if (Save_Error_Popup_Msg1.equals(Error_Msg_popup_Save)) {
			Extent_pass(driver, "Warning popup message having proper message with icon(!)", test, test1);
			System.out.println("Matched || Expected Warning popup message  was : " + Error_Msg_popup_Save
					+ " Actual Warning popup message was : " + Save_Error_Popup_Msg1);
			Extent_pass(driver, "Matched || Expected Warning popup message was : " + Error_Msg_popup_Save
					+ " Actual Warning popup message was : " + Save_Error_Popup_Msg1, test, test1);
		} else {
			System.out.println("Not Matched || Expected Warning popup message was : " + Error_Msg_popup_Save
					+ " Actual Warning popup message was : " + Save_Error_Popup_Msg1);
			Extent_fail2(driver, "Not Matched || Expected Warning popup message was : " + Error_Msg_popup_Save
					+ " Actual Warning popup message was : " + Save_Error_Popup_Msg1, test);

		}

		click(driver, Click_ok);

		System.out
				.println("//***************************Testcase 1 Completed **************************************//");

		Extent_cal(test,
				"Testcase 2 - Ensure that validation displayed when click search without enter data in fields");

		Fluentwait(driver, Globalserach);
		click(driver, Globalserach);

		wait(driver, "2");

		Fluentwait(driver, Click_Search);
		click(driver, Click_Search);

		wait(driver, "3");

		Fluentwait(driver, Error_ID_Search_Popup_Deficit);

		String Errormsgpopup_text = getText(driver, Error_ID_Search_Popup_Deficit);

		if (Errormsgpopup_text.equals(Error_Msg_popup_ID)) {
			Extent_pass(driver, "Warning popup message having proper message with icon(!)", test, test1);
			System.out.println("Matched || Expected Warning popup message  was : " + Error_Msg_popup_ID
					+ " Actual Warning popup message was : " + Errormsgpopup_text);
			Extent_pass(driver, "Matched || Expected Warning popup message was : " + Error_Msg_popup_ID
					+ " Actual Warning popup message was : " + Errormsgpopup_text, test, test1);
		} else {
			System.out.println("Not Matched || Expected Warning popup message was : " + Error_Msg_popup_ID
					+ " Actual Warning popup message was : " + Errormsgpopup_text);
			Extent_fail2(driver, "Not Matched || Expected Warning popup message was : " + Error_Msg_popup_ID
					+ " Actual Warning popup message was : " + Errormsgpopup_text, test);

		}

		System.out
				.println("//***************************Testcase 2 Completed **************************************//");

		Extent_cal(test, "Testcase 3 - Ensure that validation when search invalid data ");

		wait(driver, "3");

		Fluentwait(driver, Globalserach_IDInput);
		sendKeys(driver, Globalserach_IDInput, ID_Invalid);

		wait(driver, "2");

		Fluentwait(driver, Click_Search);
		click(driver, Click_Search);

		wait(driver, "3");

		Fluentwait(driver, Error_ID_Search_Popup_Deficit);

		String Errormsgpopup_text1 = getText(driver, Error_ID_Search_Popup_Deficit_Invalid);

		if (Errormsgpopup_text1.equals(Error_Msg_popup_Invalid_Input)) {
			Extent_pass(driver, "Warning popup message having proper message with icon(!)", test, test1);
			System.out.println("Matched || Expected Warning popup message  was : " + Error_Msg_popup_Invalid_Input
					+ " Actual Warning popup message was : " + Errormsgpopup_text1);
			Extent_pass(driver, "Matched || Expected Warning popup message was : " + Error_Msg_popup_Invalid_Input
					+ " Actual Warning popup message was : " + Errormsgpopup_text1, test, test1);
		} else {
			System.out.println("Not Matched || Expected Warning popup message was : " + Error_Msg_popup_Invalid_Input
					+ " Actual Warning popup message was : " + Errormsgpopup_text1);
			Extent_fail2(driver, "Not Matched || Expected Warning popup message was : " + Error_Msg_popup_Invalid_Input
					+ " Actual Warning popup message was : " + Errormsgpopup_text1, test);

		}

		System.out
				.println("//***************************Testcase 3 Completed **************************************//");

		Extent_cal(test, "Testcase 4 - Ensure that validation get display when From year is greater than To year ");

		wait(driver, "3");

		click(driver, Close_Button);

		wait(driver, "3");

		Fluentwait(driver, Upper_Arrow1);
		click(driver, Upper_Arrow1);

		click(driver, Upper_Arrow1);

		wait(driver, "3");

		click(driver, Show);
		wait(driver, "3");

		String PopupMsg = getText(driver, Popup1);

		System.out.println("PopupMsg : " + PopupMsg);

		if (PopupMsg.equals(Popup_Message)) {
			Extent_pass(driver, "Warning popup message having proper message with icon(!)", test, test1);
			System.out.println("Matched || Expected Warning Message  was : " + Popup_Message
					+ " Actual Warning Message  was : " + PopupMsg);
			Extent_pass(driver, "Matched || Expected Warning Message  was : " + Popup_Message
					+ " Actual Warning Message was : " + PopupMsg, test, test1);
		} else {
			System.out.println("Not Matched || Expected Warning Message  was : " + Popup_Message
					+ " Actual Warning Message  was : " + PopupMsg);
			Extent_fail2(driver, "Not Matched || Expected Warning Message  was : " + Popup_Message
					+ " Actual Warning Message  was : " + PopupMsg, test);

		}

		click(driver, Click_ok);

		click(driver, Cancel);

		System.out
				.println("//***************************Testcase 4 Completed **************************************//");

		Extent_cal(test,
				"Testcase 5 - Ensure that Validation displays when  from week is smaller than To week when same is selected ");

		wait(driver, "3");

		click(driver, New);

		click(driver, Click_ok1);

		wait(driver, "3");

		Fluentwait(driver, To_Week);
		clear(driver, To_Week);
		wait(driver, "3");

		sendKeys(driver, To_Week, Week);

		wait(driver, "3");

		click(driver, Show);
		wait(driver, "3");

		String PopupMsg1 = getText(driver, Popup1);

		System.out.println("PopupMsg1 : " + PopupMsg1);

		wait(driver, "3");

		if (PopupMsg1.equals(Popup_Week)) {
			Extent_pass(driver, "Warning popup message having proper message with icon(!)", test, test1);
			System.out.println("Matched || Expected Warning Message was : " + Popup_Week
					+ " Actual Warning Message was : " + PopupMsg1);
			Extent_pass(driver, "Matched || Expected Warning Message was : " + Popup_Week
					+ " Actual Warning Message was : " + PopupMsg1, test, test1);
		} else {
			System.out.println("Not Matched || Expected Warning Message was : " + Popup_Week
					+ " Actual Warning Message was : " + PopupMsg1);
			Extent_fail2(driver, "Not Matched || Expected Warning Message was : " + Popup_Week
					+ " Actual Warning Message was : " + PopupMsg1, test);

		}

		click(driver, Click_ok);
		click(driver, Cancel);

		System.out
				.println("//***************************Testcase 5 Completed **************************************//");

		Extent_cal(test,
				"Testcase 6 - Ensure that validation get displays when To week is enter greater than current week ");

		wait(driver, "3");

		click(driver, New);

		click(driver, Click_ok1);

		wait(driver, "3");

		Fluentwait(driver, To_Week);
		clear(driver, To_Week);
		wait(driver, "3");

		sendKeys(driver, To_Week, Week1);

		wait(driver, "3");

		click(driver, Show);
		wait(driver, "3");

		String PopupMsg2 = getText(driver, Popup1);

		System.out.println("PopupMsg2 : " + PopupMsg2);

		wait(driver, "3");

		if (PopupMsg2.equals(Popup_Week)) {
			Extent_pass(driver, "Warning popup message having proper message with icon(!)", test, test1);
			System.out.println("Matched || Expected Warning Message was : " + Popup_Week
					+ " Actual Warning Message was : " + PopupMsg2);
			Extent_pass(driver, "Matched || Expected Warning Message was : " + Popup_Week
					+ " Actual Warning Message was : " + PopupMsg2, test, test1);
		} else {
			System.out.println("Not Matched || Expected Warning Message was : " + Popup_Week
					+ " Actual Warning Message was : " + PopupMsg2);
			Extent_fail2(driver, "Not Matched || Expected Warning Message was : " + Popup_Week
					+ " Actual Warning Message was : " + PopupMsg2, test);

		}

		click(driver, Click_ok);

		System.out
				.println("//***************************Testcase 6 Completed **************************************//");

		Extent_cal(test, "Testcase 7 - Ensure that deficit  qty field should not allow to enter inputs");

		// wait(driver,"3");

		// click(driver, Close_Button);

		// wait(driver,"3");

		String Deficit_Qty = getAttribute(driver, DeficitQty, "value");
		System.out.println("Deficit_Qty : " + Deficit_Qty);

		wait(driver, "3");

		Fluentwait(driver, DeficitQty);
		sendKeys(driver, DeficitQty, Data);

		wait(driver, "3");

		String Deficit_Qty_1 = getAttribute(driver, DeficitQty, "value");
		System.out.println("Deficit_Qty_1 : " + Deficit_Qty_1);

		wait(driver, "3");

		if (Deficit_Qty.equals(Deficit_Qty_1)) {
			System.out.println("Matched || Expected Deficit Qty  was : " + Deficit_Qty_1 + " Actual  Deficit Qty was : "
					+ Deficit_Qty);
			Extent_pass(driver, "Matched || Expected  Deficit Qty was : " + Deficit_Qty_1
					+ " Actual  Deficit Qty was : " + Deficit_Qty, test, test1);
		} else {
			System.out.println("Not Matched || Expected  Deficit Qty was : " + Deficit_Qty_1
					+ " Actual  Deficit Qty was : " + Deficit_Qty);
			Extent_fail2(driver, "Not Matched || Expected  Deficit Qty was : " + Deficit_Qty_1
					+ " Actual  Deficit Qty was : " + Deficit_Qty, test);
		}

		System.out
				.println("//***************************Testcase 7 Completed **************************************//");

		Extent_cal(test, "Testcase 8 - Ensure that import button get enable when select Budget reposition in dropdown");

		wait(driver, "2");

		Fluentwait(driver, Globalserach);
		click(driver, Globalserach);

		Fluentwait(driver, Globalserach_IDInput);
		sendKeys(driver, Globalserach_IDInput, ID);

		wait(driver, "2");

		Fluentwait(driver, Click_Search);
		click(driver, Click_Search);

		wait(driver, "3");

		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);

		wait(driver, "5");

		String Budjet = getText(driver, Reposition_dropdown);

		System.out.println("Budjet : " + Budjet);
		wait(driver, "3");

		if (Budjet.equals(Dropdown_Repo)) {
			System.out.println(
					"Matched || Expected Deficit Qty  was : " + Dropdown_Repo + " Actual  Deficit Qty was : " + Budjet);
			Extent_pass(driver,
					"Matched || Expected  Deficit Qty was : " + Dropdown_Repo + " Actual  Deficit Qty was : " + Budjet,
					test, test1);
		} else {
			System.out.println("Not Matched || Expected  Deficit Qty was : " + Dropdown_Repo
					+ " Actual  Deficit Qty was : " + Budjet);
			Extent_fail2(driver, "Not Matched || Expected  Deficit Qty was : " + Dropdown_Repo
					+ " Actual  Deficit Qty was : " + Budjet, test);

		}

		wait(driver, "3");

		if (IsElementEnabled(driver, Export)) {

			System.out.println("Export button is in enable status");
			Extent_pass(driver, "Export button is in enable status", test, test1);

		} else {

			System.out.println("Export button is not in enable status");
			Extent_fail(driver, "Export button is not in enable status", test, test1);
		}

		System.out
				.println("//***************************Testcase 8 Completed **************************************//");

		Extent_cal(test,
				"Testcase 9 - Ensure that actual column data showed proeplry which refered from export column");

		wait(driver, "3");

		String gettext = getText(driver, Actual);

		System.out.println("gettext : " + gettext);

		wait(driver, "3");

		String gettext1 = getText(driver, Export_Col);

		System.out.println("gettext1 : " + gettext1);

		wait(driver, "3");

		if (gettext.equals(gettext1)) {

			System.out.println("Expected both column data was|| Expected Export data value was : " + gettext1

					+ " || Actual Actual Column value was : " + gettext);
			Extent_pass(driver, "Expected both column data was|| Expected Export data value was : " + gettext1
					+ " || Actual Actual Column value was : " + gettext, test, test1);
		} else {
			System.out.println("Expected both column data was not Same || Expected Export data value was : " + gettext1
					+ " || Actual Actual Column value was : " + gettext);
			Extent_fail(driver, "Selected data was not copied || Expected Export value was : " + gettext1
					+ " || Actual Actual Column value was : " + gettext, test, test1);
		}

		wait(driver, "3");

		System.out
				.println("//***************************Testcase 9 Completed **************************************//");

		Extent_cal(test, "Testcase 16 - Ensure that autosize this column works properly");

		dragElement(driver, Resize);

		System.out
				.println("//***************************Testcase 16 Completed **************************************//");

		Extent_cal(test, "Testcase 18 - Ensure that group by location works properly");

		Fluentwait(driver, Location_Filter);
		click(driver, Location_Filter);

		Fluentwait(driver, Group_By_Loc);
		click(driver, Group_By_Loc);

		if (isDisplayed(driver, Expand_Button)) {

			System.out.println("After clicking the Group By Location button, the Expand Button was  Displayed");
			Extent_pass(driver, "After clicking the Group By Location button, the Expand Button was Displayed", test,
					test1);

		} else {

			System.out.println("After clicking the Group By Location button, the Expand Button was Not Displayed");
			Extent_fail(driver, "After clicking the Group By Location button, the Expand Button was Not  Displayed",
					test, test1);
		}

		System.out
				.println("//***************************Testcase 18 Completed **************************************//");

		Extent_cal(test, "Testcase 19 - Ensure that options get enable after click group by locations");

		Fluentwait(driver, Location_Filter);
		click(driver, Location_Filter);

		Extent_cal(test, "Expand All Option");

		if (IsElementEnabled(driver, Expand_All)) {

			System.out.println("After clicking the Group By Location button, the Expand All Option was  Enabled");
			Extent_pass(driver, "After clicking the Group By Location button, the Expand All Option was Enabled", test,
					test1);

		} else {

			System.out.println("After clicking the Group By Location button, the Expand All Option was Not Enabled");
			Extent_fail(driver, "After clicking the Group By Location button, the Expand All Option was Not  Enabled",
					test, test1);
		}

		wait(driver, "3");

		Extent_cal(test, "Collapse All Option");

		if (IsElementEnabled(driver, Collapse_All)) {

			System.out.println("After clicking the Group By Location button, the Collapse All Option was  Enabled");
			Extent_pass(driver, "After clicking the Group By Location button, the Collapse All Option was Enabled",
					test, test1);

		} else {

			System.out.println("After clicking the Group By Location button, the Collapse All Option was Not Enabled");
			Extent_fail(driver, "After clicking the Group By Location button, the Collapse All Option was Not  Enabled",
					test, test1);
		}

		System.out
				.println("//***************************Testcase 19 Completed **************************************//");

		Extent_cal(test, "Testcase 20 - Ensure that expand all option works properly");

		wait(driver, "3");

		Fluentwait(driver, Expand_All);
		click(driver, Expand_All);

		if (isDisplayed(driver, Expand_All_Close_Button)) {

			System.out.println("After clicking the Group By Location button, the Expand Close Button was  Displayed");
			Extent_pass(driver, "After clicking the Group By Location button, the Expand Close Button was Displayed",
					test, test1);

		} else {

			System.out
					.println("After clicking the Group By Location button, the Expand Close Button was Not Displayed");
			Extent_fail(driver,
					"After clicking the Group By Location button, the Expand Close Button was Not  Displayed", test,
					test1);
		}

		System.out
				.println("//***************************Testcase 20 Completed **************************************//");

		Extent_cal(test, "Testcase 21 - Ensure that collapse all option works properly");

		Fluentwait(driver, Location_Filter);
		click(driver, Location_Filter);

		Fluentwait(driver, Collapse_All);
		click(driver, Collapse_All);

		if (isDisplayed(driver, Expand_Button)) {

			System.out.println("After clicking the Group By Location button, the Expand Button was  Displayed");
			Extent_pass(driver, "After clicking the Group By Location button, the Expand Button was Displayed", test,
					test1);

		} else {

			System.out.println("After clicking the Group By Location button, the Expand Button was Not Displayed");
			Extent_fail(driver, "After clicking the Group By Location button, the Expand Button was Not  Displayed",
					test, test1);
		}

		System.out
				.println("//***************************Testcase 21 Completed **************************************//");

		wait(driver, "5");

		// Extent_cal(test, "Testcase 22 - Ensure that Reset columns option works
		// properly");

		click(driver, Tree_table);

		Fluentwait(driver, Reset_Filter);
		click(driver, Reset_Filter);

		// rightClick(driver, Grid1_1);

		// Fluentwait(driver, Reset_All);
		// click(driver, Reset_All);

		wait(driver, "5");

		if (!isDisplayed(driver, Location_Tag)) {

			System.out.println("After clicking the Group By Location button, the Tag  was Not Displayed");
			Extent_pass(driver, "After clicking the Group By Location button, the  Tag was Not Displayed", test, test1);

		} else {

			System.out.println("After clicking the Group By Location button, the Tag  was  Displayed");
			Extent_fail(driver, "After clicking the Group By Location button,  the Tag  was  Displayed", test, test1);
		}

		Extent_cal(test, "Testcase 24 - Ensure that conditional filter works properly");

		wait(driver, "5");

		click(driver, Tree_table);

		wait(driver, "3");

		Extent_cal(test, "conditional filter1");

		Fluentwait(driver, Condition_filter);
		click(driver, Condition_filter);

		Fluentwait(driver, Condition_Filter1);
		sendKeys(driver, Condition_Filter1, Condition_Filter_1);

		wait(driver, "3");

		String Filter1 = getText(driver, Verify_Multi_Filter);

		System.out.println("Filter1 : " + Filter1);

		if (Filter1.equals(Condition_Filter_1)) {
			System.out.println("Matched || Expected  Cond_Filter  was : " + Condition_Filter_1
					+ " Actual Cond_Filter was: " + Filter1);
			Extent_pass(driver,
					"Matched || Expected Cond_Filter was : " + Condition_Filter_1 + " Cond_Filter was : " + Filter1,
					test, test1);
		} else {
			System.out.println("Not Matched || Expected  Cond_Filter was : " + Condition_Filter_1
					+ " Actual Cond_Filter was : " + Filter1);
			Extent_fail2(driver, "Not Matched || Expected  Cond_Filter was : " + Condition_Filter_1
					+ " Actual Cond_Filter was : " + Filter1, test);

		}

		System.out
				.println("//***************************Testcase 24 Completed **************************************//");

		Extent_cal(test, "Testcase 26 - Ensure that reset option works properly");
		wait(driver, "3");

		Fluentwait(driver, Tree_table);
		click(driver, Tree_table);

		Fluentwait(driver, Reset_Filter);
		click(driver, Reset_Filter);

		if (!isDisplayed(driver, Condition_Filter1)) {

			System.out.println("After clicking the Reset button, the Conditional Filter is Not Displayed");
			Extent_pass(driver, "After clicking  the Reset button, the Conditional Filter is Not Displayed", test,
					test1);

		} else {

			System.out.println("After clicking  the Reset button, the Conditional Filter is  Displayed");
			Extent_fail(driver, "After  the Reset button, the Conditional Filter is  Displayed", test, test1);
		}

		System.out
				.println("//***************************Testcase 26 Completed **************************************//");

		Extent_cal(test, "Testcase 25 - Ensure that multile filter is accessible and applied in all columns");

		Fluentwait(driver, Tree_table);
		click(driver, Tree_table);

		Fluentwait(driver, Multiple_Filter);
		click(driver, Multiple_Filter);

		wait(driver, "3");


		String textToCopy = "AUBNE";

// Create a StringSelection object with the text
		StringSelection stringSelection = new StringSelection(textToCopy);

// Get the system clipboard
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

// Set the content of the clipboard to the string
		clipboard.setContents(stringSelection, null);

		System.out.println("Text copied to clipboard: " + textToCopy);

		wait(driver, "3");

		click(driver, Location_Filter);

		Fluentwait(driver, Filter_1);
		click(driver, Filter_1);

		wait(driver, "3");

		Fluentwait(driver, Multi_Filter1);
		click(driver, Multi_Filter1);

		act.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();

		wait(driver, "3");

		String Pastetext = getText(driver, Multi_Filter);

		System.out.println("Pastetext : " + Pastetext);
		wait(driver, "3");

		if (Pastetext.equals(Input_Data)) {
			System.out.println("Matched || Expected pasted value was : " + Input_Data + " || Actual pasted value was : "
					+ Pastetext);
			Extent_pass(driver, "System allowed to paste the copied data by using shortcut key CTRL+V", test, test1);
			Extent_pass(driver, "Matched || Expected pasted value was : " + Input_Data
					+ " || Actual pasted value was : " + Pastetext, test, test1);
		} else {
			System.out.println("Not Matched || Expected pasted value was : " + Input_Data
					+ " || Actual pasted value was : " + Pastetext);
			Extent_fail(driver, "System not allowed to paste the copied data by using shortcut key CTRL+V", test,
					test1);
			Extent_fail(driver, "Not Matched || Expected pasted value was : " + Input_Data
					+ " || Actual pasted value was : " + Pastetext, test, test1);

		}

		Fluentwait(driver, Tree_table);
		click(driver, Tree_table);

		Fluentwait(driver, Reset_Filter);
		click(driver, Reset_Filter);

		System.out
				.println("//***************************Testcase 24 Completed **************************************//");

		Extent_cal(test, "Testcase 22 - Ensure that Reset columns option works properly");

		wait(driver, "3");

		if (isDisplayed(driver, Loc_Input)) {

			System.out.println("The Location Column was Displayed");
			Extent_pass(driver, "The Location Column was Displayed", test, test1);

		} else {

			System.out.println("The Location Column was Not Displayed");
			Extent_fail(driver, "The Location Column was Not Displayed", test, test1);
		}

		wait(driver, "3");

		click(driver, Columns);

		Fluentwait(driver, Loc_Checkbox);
		click(driver, Loc_Checkbox);
		wait(driver, "5");

		click(driver, Columns);
		wait(driver, "3");

		if (!isDisplayed(driver, Loc_Input)) {

			System.out.println("The Location Column was Not Displayed");
			Extent_pass(driver, "The Location Column was Not Displayed", test, test1);

		} else {

			System.out.println("The Location Column was  Displayed");
			Extent_fail(driver, "The Location Column was  Displayed", test, test1);
		}

		wait(driver, "10");

		Fluentwait(driver, Grid1_1);
		rightClick(driver, Grid1_1);

		wait(driver, "5");

		Fluentwait(driver, Reset_All);
		click(driver, Reset_All);

		wait(driver, "5");

		if (isDisplayed(driver, Loc_Input)) {

			System.out.println("The Location Column was Displayed");
			Extent_pass(driver, "The Location Column was Displayed", test, test1);

		} else {

			System.out.println("The Location Column was Not Displayed");
			Extent_fail(driver, "The Location Column was Not Displayed", test, test1);
		}

		System.out
				.println("//***************************Testcase 22 Completed **************************************//");

		Extent_cal(test, "Testcase 27 - Ensure that export excel works properly in grid");

		Fluentwait(driver, Grid1_1);
		rightClick(driver, Grid1_1);

		wait(driver, "3");

		scrollUp(driver);
		wait(driver, "5");

		Fluentwait(driver, Export1);
		click(driver, Export1);

		wait(driver, "5");

		Verify_FileDownloaded(driver, "export", Export1_Button);

		System.out
				.println("//***************************Testcase 27 Completed **************************************//");

		Extent_cal(test, "Testcase 28 - Ensure that export excel 2007 works properly in grid");

		Fluentwait(driver, Tree_table);
		click(driver, Tree_table);

		Verify_FileDownloaded(driver, "Deficit and Surplus Location Identification", Excel_2007);

		System.out
				.println("//***************************Testcase 28 Completed **************************************//");

		Extent_cal(test, "Testcase 29 - Ensure that export CSV works properly in grid");

//Fluentwait(driver, Tree_table);
//click(driver, Tree_table);

		Fluentwait(driver, Grid1_1);
		rightClick(driver, Grid1_1);

		wait(driver, "3");

		scrollUp(driver);
		wait(driver, "5");

		Fluentwait(driver, Export1);
		click(driver, Export1);

		wait(driver, "5");

		Verify_FileDownloaded(driver, "export", CSV_Export);

		System.out
				.println("//***************************Testcase 29 Completed **************************************//");

		Extent_cal(test, "Testcase 30 - Ensure that fullscreen options works properly");

		Fluentwait(driver, Tree_table);
		click(driver, Tree_table);

		Fluentwait(driver, Full_Screen);
		click(driver, Full_Screen);

		wait(driver, "3");

		takescreenshot(driver, "//Expected_screenshot//Deficit//Fullscreen");
		takescreenshot(driver, "//Actual_screenshot//Deficit//Fullscreen");

		if (imageComparison2(driver, "//Deficit//Fullscreen", "//Deficit//Fullscreen") == true) {

			System.out.println("Fullscreen button is working fine");
			Extent_pass(driver, "Fullscreen button is working fine", test, test1);
		} else {

			System.out.println("Fullscreen button is not working fine");
			Extent_fail(driver, "Fullscreen button is not working fine", test, test1);
		}

		Robot rbt1 = new Robot();

		rbt.keyPress(KeyEvent.VK_ESCAPE);

		takescreenshot(driver, "//Expected_screenshot//Deficit//Escape");
		takescreenshot(driver, "//Actual_screenshot//Deficit//Escape");

		if (imageComparison2(driver, "//Deficit//Escape", "//Deficit//Escape") == true) {

			System.out.println("FullScreen button is working fine");
			Extent_pass(driver, "FullScreen button is working fine", test, test1);
		} else {

			System.out.println("FullScreen button is not working fine");
			Extent_fail(driver, "FullScreen button is not working fine", test, test1);
		}

		System.out
				.println("//***************************Testcase 30 Completed **************************************//");

		Extent_cal(test, "Testcase 32 - Ensure that scroll works properly in grid");

		wait(driver, "3");

		ScrollBarValidation1(driver, Scroll_Deficit, "Grid scroll");

		System.out
				.println("//***************************Testcase 32 Completed **************************************//");

		Extent_cal(test,
				"Testcase 11 - Ensure that one way out load column displayes data properly which referred from one way leasing screen ");

		scrollBottom(driver);

		click(driver, Editbutton);

		click(driver, Cancel);

		wait(driver, "3");

		click(driver, New);

		click(driver, Click_ok1);

		wait(driver, "3");
		Fluentwait(driver, dropdown_option);
		click(driver, dropdown_option);

		Fluentwait(driver, Budget_Reposition);
		click(driver, Budget_Reposition);

		Fluentwait(driver, Budget);
		click(driver, Budget);

		wait(driver, "5");

//uploadFileRobot(driver, EquimentType_Alphabets1);

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

		wait(driver, "3");
		Fluentwait(driver, ERO_Save);
		click(driver, ERO_Save);
		Fluentwait(driver, ERO_Save_ok);
		click(driver, ERO_Save_ok);
		wait(driver, "2");

		click(driver, Budjet_Yes);

		click(driver, ERO_Save_ok);

		wait(driver, "3");

		int scrollAmount = 1800; // Replace with the amount you want to scroll

		WebElement scroller2 = driver.findElement(By.xpath("(//div[@ref='eBodyHorizontalScrollViewport'])[1]"));

		js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller2, scrollAmount);

		wait(driver, "3");

		String Outofload = getText(driver, One_Way_Outofload);

		System.out.println("Outofload : " + Outofload);
		wait(driver, "3");

		Fluentwait(driver, Searchbox);
		sendKeys(driver, Searchbox, "One Way Leasing");

		Fluentwait(driver, One_Way_Leasing);
		click(driver, One_Way_Leasing);

		wait(driver, "3");

		Fluentwait(driver, One_Way_Edit);
		click(driver, One_Way_Edit);

		wait(driver, "3");

		clear(driver, One_Way_Out_Qty);

		sendKeys(driver, One_Way_Out_Qty, one_way_out_load_column);

		click(driver, Edit_Leasing);

		wait(driver, "3");

		Fluentwait(driver, OneWay_Leasing_Save);

		click(driver, OneWay_Leasing_Save);

		wait(driver, "3");

		String Popup_Updated = getText(driver, Leasing_Updated_Popup);

		System.out.println("Popup_Updated : " + Popup_Updated);
		wait(driver, "3");

		if (Popup_Updated.equals(Leasing_Popup)) {
			System.out.println("Matched || Expected  popup message  was : " + Leasing_Popup
					+ " Actual popup message was : " + Popup_Updated);
			Extent_pass(driver, "Matched || Expected popup message was : " + Leasing_Popup
					+ " Actual popup message was : " + Popup_Updated, test, test1);
		} else {
			System.out.println("Not Matched || Expected popup message was : " + Leasing_Popup
					+ " Actual popup message was : " + Popup_Updated);
			Extent_fail2(driver, "Not Matched || Expected popup message was : " + Leasing_Popup
					+ " Actual popup message was : " + Popup_Updated, test);

		}

		click(driver, ok_Click);

		click(driver, Tab1);

		scrollBottom(driver);

		click(driver, Editbutton);

		wait(driver, "3");

		click(driver, Cancel);

		wait(driver, "3");

		click(driver, New);

		click(driver, Click_ok1);

		wait(driver, "3");
		Fluentwait(driver, dropdown_option);
		click(driver, dropdown_option);

		Fluentwait(driver, Budget_Reposition);
		click(driver, Budget_Reposition);

		Fluentwait(driver, Budget);
		click(driver, Budget);

		wait(driver, "4");

//uploadFileRobot(driver, EquimentType_Alphabets1);

		String upload_EquimentType_Alphabets2 = System.getProperty("user.dir") + "/driver/MasterDownloadfile.exe "
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

		wait(driver, "3");
		Fluentwait(driver, ERO_Save);
		click(driver, ERO_Save);
		Fluentwait(driver, ERO_Save_ok);
		click(driver, ERO_Save_ok);
		wait(driver, "2");

		click(driver, Budjet_Yes);

		click(driver, ERO_Save_ok);

//HorizontalScrollFull(driver, Horizontal_gridscroll1);

//horizontalscroll(driver, Horizontal_gridscroll1, 5);

		wait(driver, "3");

		String Weeks_Data = getText(driver, Weeks_Data1);

		System.out.println("Weeks_Data : " + Weeks_Data);

		wait(driver, "3");

		int scrollAmount2 = 1800; // Replace with the amount you want to scroll

		WebElement scroller3 = driver.findElement(By.xpath("(//div[@ref='eBodyHorizontalScrollViewport'])[1]"));

		js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller3, scrollAmount2);

		wait(driver, "3");

		String Outofload1 = getText(driver, One_Way_Outofload);

		System.out.println("Outofload1 : " + Outofload1);
		wait(driver, "3");

		int one_way_Out_load_Data = Integer.parseInt(Weeks_Data) * Integer.parseInt(one_way_out_load_column);

		System.out.println("one_way_Out_load_Data : " + one_way_Out_load_Data);

		wait(driver, "3");

		if (!Outofload.equals(Outofload1)) {
			System.out.println("Matched || Both Value was not matched : " + Outofload1
					+ " Actual Value  was not matched : " + Outofload);
			Extent_pass(driver, "Matched || Both Value was not matched : " + Outofload1
					+ " Both Value was not matched : " + Outofload, test, test1);
		} else {
			System.out.println(
					"Not Matched || Both Value was matched : " + Outofload1 + "Both Value was matched : " + Outofload);
			Extent_fail2(driver,
					"Not Matched || Both Value was matched : " + Outofload1 + " Both Value was matched : " + Outofload,
					test);

		}

		wait(driver, "3");

		if (Integer.toString(one_way_Out_load_Data).equals(Outofload1)) {
			System.out.println("Matched || Both Value was  matched : " + Outofload1 + " Actual popup message was : "
					+ one_way_Out_load_Data);
			Extent_pass(driver, "Matched || Both Value was  matched : " + Outofload1 + " Both Value was  matched : "
					+ one_way_Out_load_Data, test, test1);
		} else {
			System.out.println("Not Matched || Both Value was not matched : " + Outofload1
					+ "Both Value was not matched : " + Outofload);
			Extent_fail2(driver, "Not Matched || Both Value was not matched : " + Outofload1
					+ " Both Value was not matched : " + one_way_Out_load_Data, test);

		}

		System.out
				.println("//***************************Testcase 11 Completed **************************************//");

		Extent_cal(test,
				"Testcase 13 - Ensure that one way in return column displayes data properly which referred from one way leasing screen ");

		scrollBottom(driver);

		click(driver, Editbutton);

		wait(driver, "3");
		click(driver, Cancel);

		wait(driver, "3");

		click(driver, New);

		click(driver, Click_ok1);

		wait(driver, "3");
		Fluentwait(driver, dropdown_option);
		click(driver, dropdown_option);

		Fluentwait(driver, Budget_Reposition);
		click(driver, Budget_Reposition);

		Fluentwait(driver, Budget);
		click(driver, Budget);

		wait(driver, "5");

//uploadFileRobot(driver, EquimentType_Alphabets1);

		String upload_EquimentType_Alphabets3 = System.getProperty("user.dir") + "/driver/MasterDownloadfile.exe "
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

		wait(driver, "3");
		Fluentwait(driver, ERO_Save);
		click(driver, ERO_Save);
		Fluentwait(driver, ERO_Save_ok);
		click(driver, ERO_Save_ok);
		wait(driver, "2");

		click(driver, Budjet_Yes);

		click(driver, ERO_Save_ok);

		wait(driver, "5");

		Fluentwait(driver, Location_Filter);
		click(driver, Location_Filter);

		Fluentwait(driver, Filter_1);
		click(driver, Filter_1);

		click(driver, Checkbox_1);

		wait(driver, "2");

		sendKeys(driver, Search_input, "SGSIN");

		click(driver, Checkbox_1);

//HorizontalScrollFull(driver, Horizontal_gridscroll1);

//horizontalscroll(driver, Horizontal_gridscroll1, 5);

		wait(driver, "3");

		int scrollAmount3 = 1800; // Replace with the amount you want to scroll

		WebElement scroller4 = driver.findElement(By.xpath("(//div[@ref='eBodyHorizontalScrollViewport'])[1]"));

		js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller4, scrollAmount3);

		wait(driver, "3");

		String Onewayinload = getText(driver, One_Way_In_Load);

		System.out.println("Onewayinload : " + Onewayinload);
		wait(driver, "3");

		click(driver, Tab2);

		Fluentwait(driver, Lesein_Tab1);
		click(driver, Lesein_Tab1);

		Fluentwait(driver, Lesein_Edit);
		click(driver, Lesein_Edit);

		wait(driver, "3");

		clear(driver, One_Way_in_Qty);

		sendKeys(driver, One_Way_in_Qty, one_way_in_load_column);

		click(driver, Edit_Leasing);

		Fluentwait(driver, OneWay_Leasing_Save);

		click(driver, OneWay_Leasing_Save);

		wait(driver, "3");

		String Popup_Updated1 = getText(driver, Leasing_Updated_Popup);

		System.out.println("Popup_Updated1 : " + Popup_Updated1);
		wait(driver, "3");

		if (Popup_Updated1.equals(Leasing_Popup)) {
			System.out.println("Matched || Expected  popup message  was : " + Leasing_Popup
					+ " Actual popup message was : " + Popup_Updated1);
			Extent_pass(driver, "Matched || Expected popup message was : " + Leasing_Popup
					+ " Actual popup message was : " + Popup_Updated1, test, test1);
		} else {
			System.out.println("Not Matched || Expected popup message was : " + Leasing_Popup
					+ " Actual popup message was : " + Popup_Updated1);
			Extent_fail2(driver, "Not Matched || Expected popup message was : " + Leasing_Popup
					+ " Actual popup message was : " + Popup_Updated1, test);

		}

		click(driver, ok_Click);

		click(driver, Tab1);

		scrollBottom(driver);

		click(driver, Editbutton);

		wait(driver, "3");

		click(driver, Cancel);

		wait(driver, "3");

		click(driver, New);

		click(driver, Click_ok1);

		wait(driver, "3");
		Fluentwait(driver, dropdown_option);
		click(driver, dropdown_option);

		Fluentwait(driver, Budget_Reposition);
		click(driver, Budget_Reposition);

		Fluentwait(driver, Budget);
		click(driver, Budget);

		wait(driver, "5");

//uploadFileRobot(driver, EquimentType_Alphabets1);

		String upload_EquimentType_Alphabets4 = System.getProperty("user.dir") + "/driver/MasterDownloadfile.exe "
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

		wait(driver, "3");
		Fluentwait(driver, ERO_Save);
		click(driver, ERO_Save);
		Fluentwait(driver, ERO_Save_ok);
		click(driver, ERO_Save_ok);
		wait(driver, "2");

		click(driver, Budjet_Yes);

		click(driver, ERO_Save_ok);

		Fluentwait(driver, Location_Filter);
		click(driver, Location_Filter);

		Fluentwait(driver, Filter_1);
		click(driver, Filter_1);

		click(driver, Checkbox_1);

		wait(driver, "2");

		sendKeys(driver, Search_input, "SGSIN");

		click(driver, Checkbox_1);

//HorizontalScrollFull(driver, Horizontal_gridscroll1);

//horizontalscroll(driver, Horizontal_gridscroll1, 5);

		wait(driver, "3");

		String Weeks_Data3 = getText(driver, Weeks_Data1);

		System.out.println("Weeks_Data3 : " + Weeks_Data3);
		wait(driver, "3");

		int scrollAmount4 = 1800; // Replace with the amount you want to scroll

		WebElement scroller5 = driver.findElement(By.xpath("(//div[@ref='eBodyHorizontalScrollViewport'])[1]"));

		js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller5, scrollAmount4);

		wait(driver, "3");

		String Onewayinload1 = getText(driver, One_Way_In_Load);

		System.out.println("Onewayinload1 : " + Onewayinload1);
		wait(driver, "3");

		int one_way_in_load_Data = Integer.parseInt(Weeks_Data3) * Integer.parseInt(one_way_in_load_column);

		System.out.println("one_way_in_load_Data : " + one_way_in_load_Data);

		if (!Onewayinload.equals(Onewayinload1)) {
			System.out.println("Matched || Both Value was not matched : " + Onewayinload1
					+ " Actual popup message was : " + Onewayinload);
			Extent_pass(driver, "Matched || Both Value was not matched : " + Onewayinload1
					+ " Both Value was not matched : " + Onewayinload, test, test1);
		} else {
			System.out.println("Not Matched || Both Value was matched : " + Onewayinload1 + "Both Value was matched : "
					+ Onewayinload);
			Extent_fail2(driver, "Not Matched || Both Value was matched : " + Onewayinload1
					+ " Both Value was matched : " + Onewayinload, test);

		}

		wait(driver, "3");

		if (Integer.toString(one_way_in_load_Data).equals(Onewayinload1)) {
			System.out.println("Matched || Both Value was matched : " + Onewayinload1 + " Actual popup message was : "
					+ one_way_in_load_Data);
			Extent_pass(driver, "Matched || Both Value was matched : " + Onewayinload1 + " Both Value was matched : "
					+ one_way_in_load_Data, test, test1);
		} else {
			System.out.println("Not Matched || Both Value was not matched : " + Onewayinload1
					+ "Both Value was matched : " + one_way_in_load_Data);
			Extent_fail2(driver, "Not Matched || Both Value was not matched : " + Onewayinload1
					+ " Both Value was matched : " + one_way_in_load_Data, test);

		}

		System.out
				.println("//***************************Testcase 13 Completed **************************************//");

		Extent_cal(test,
				"Testcase 12 - Ensure that one way in return column displayes data properly which referred from one way leasing screen ");

		scrollBottom(driver);

		click(driver, Editbutton);

		wait(driver, "3");
		click(driver, Cancel);

		wait(driver, "3");

		click(driver, New);

		click(driver, Click_ok1);

		wait(driver, "3");
		Fluentwait(driver, dropdown_option);
		click(driver, dropdown_option);

		Fluentwait(driver, Budget_Reposition);
		click(driver, Budget_Reposition);

		Fluentwait(driver, Budget);
		click(driver, Budget);

		wait(driver, "4");

//uploadFileRobot(driver, EquimentType_Alphabets1);

		String upload_EquimentType_Alphabets5 = System.getProperty("user.dir") + "/driver/MasterDownloadfile.exe "
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

		wait(driver, "3");
		Fluentwait(driver, ERO_Save);
		click(driver, ERO_Save);
		Fluentwait(driver, ERO_Save_ok);
		click(driver, ERO_Save_ok);
		wait(driver, "2");

		click(driver, Budjet_Yes);

		click(driver, ERO_Save_ok);

//HorizontalScrollFull(driver, Horizontal_gridscroll1);

//horizontalscroll(driver, Horizontal_gridscroll1, 5);

		wait(driver, "3");

		int scrollAmount5 = 1800; // Replace with the amount you want to scroll

		WebElement scroller6 = driver.findElement(By.xpath("(//div[@ref='eBodyHorizontalScrollViewport'])[1]"));

		js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller6, scrollAmount5);

		wait(driver, "3");

		String Onewayoutreturn = getText(driver, One_Way_Out_Return);

		System.out.println("Onewayoutreturn : " + Onewayoutreturn);
		wait(driver, "3");

		click(driver, Tab2);

		Fluentwait(driver, One_Way_Leease_Out);
		click(driver, One_Way_Leease_Out);

		Fluentwait(driver, One_Way_Out_Return_Edit);
		click(driver, One_Way_Out_Return_Edit);

		wait(driver, "3");

		clear(driver, One_Way_Out_Qty);

		sendKeys(driver, One_Way_Out_Qty, one_way_out_return_column);

		click(driver, Edit_Leasing);

		Fluentwait(driver, OneWay_Leasing_Save);

		click(driver, OneWay_Leasing_Save);

		wait(driver, "3");

		String Popup_Updated3 = getText(driver, Leasing_Updated_Popup);

		System.out.println("Popup_Updated3 : " + Popup_Updated3);
		wait(driver, "3");

		if (Popup_Updated3.equals(Leasing_Popup)) {
			System.out.println("Matched || Expected  popup message  was : " + Leasing_Popup
					+ " Actual popup message was : " + Popup_Updated3);
			Extent_pass(driver, "Matched || Expected popup message was : " + Leasing_Popup
					+ " Actual popup message was : " + Popup_Updated3, test, test1);
		} else {
			System.out.println("Not Matched || Expected popup message was : " + Leasing_Popup
					+ " Actual popup message was : " + Popup_Updated3);
			Extent_fail2(driver, "Not Matched || Expected popup message was : " + Leasing_Popup
					+ " Actual popup message was : " + Popup_Updated3, test);

		}

		click(driver, ok_Click);

		click(driver, Tab1);

		scrollBottom(driver);

		click(driver, Editbutton);

		wait(driver, "3");

		click(driver, Cancel);

		wait(driver, "3");

		click(driver, New);

		click(driver, Click_ok1);

		wait(driver, "3");
		Fluentwait(driver, dropdown_option);
		click(driver, dropdown_option);

		Fluentwait(driver, Budget_Reposition);
		click(driver, Budget_Reposition);

		Fluentwait(driver, Budget);
		click(driver, Budget);

		wait(driver, "4");

//uploadFileRobot(driver, EquimentType_Alphabets1);

		String upload_EquimentType_Alphabets6 = System.getProperty("user.dir") + "/driver/MasterDownloadfile.exe "
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

		wait(driver, "3");
		Fluentwait(driver, ERO_Save);
		click(driver, ERO_Save);
		Fluentwait(driver, ERO_Save_ok);
		click(driver, ERO_Save_ok);
		wait(driver, "2");

		click(driver, Budjet_Yes);

		click(driver, ERO_Save_ok);

//HorizontalScrollFull(driver, Horizontal_gridscroll1);

//horizontalscroll(driver, Horizontal_gridscroll1, 5);

		wait(driver, "3");

		String Weeks_Data2 = getText(driver, Weeks_Data1);

		System.out.println("Weeks_Data2 : " + Weeks_Data2);

		wait(driver, "3");

		int scrollAmount6 = 1800; // Replace with the amount you want to scroll

		WebElement scroller7 = driver.findElement(By.xpath("(//div[@ref='eBodyHorizontalScrollViewport'])[1]"));

		js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller7, scrollAmount6);

		wait(driver, "3");

		String Onewayoutreturn1 = getText(driver, One_Way_Out_Return);

		System.out.println("Onewayoutreturn1 : " + Onewayoutreturn1);
		wait(driver, "3");

		int one_way_Out_Return_Data = Integer.parseInt(Weeks_Data2) * Integer.parseInt(one_way_out_return_column);

		System.out.println("one_way_Out_Return_Data : " + one_way_Out_Return_Data);

		if (!Onewayoutreturn.equals(Onewayoutreturn1)) {
			System.out.println("Matched || Both Value was not matched : " + Onewayoutreturn1
					+ " Actual Value was not matched : " + Onewayoutreturn);
			Extent_pass(driver, "Matched || Both Value was not matched : " + Onewayoutreturn1
					+ " Both Value was not matched : " + Onewayoutreturn, test, test1);
		} else {
			System.out.println("Not Matched || Both Value was matched : " + Onewayoutreturn1
					+ "Both Value was matched : " + Onewayoutreturn);
			Extent_fail2(driver, "Not Matched || Both Value was matched : " + Onewayoutreturn1
					+ " Both Value was matched : " + Onewayoutreturn, test);

		}

		wait(driver, "3");

		if (Integer.toString(one_way_Out_Return_Data).equals(Onewayoutreturn1)) {
			System.out.println("Matched || Both Value was matched : " + Onewayoutreturn1
					+ " Actual popup message was : " + one_way_Out_Return_Data);
			Extent_pass(driver, "Matched || Both Value was matched : " + Onewayoutreturn1 + " Both Value was matched : "
					+ one_way_Out_Return_Data, test, test1);
		} else {
			System.out.println("Not Matched || Both Value was not matched : " + Onewayoutreturn1
					+ "Both Value was not matched : " + one_way_Out_Return_Data);
			Extent_fail2(driver, "Not Matched || Both Value was not matched : " + Onewayoutreturn1
					+ " Both Value was not matched : " + one_way_Out_Return_Data, test);

		}

		System.out
				.println("//***************************Testcase 12 Completed **************************************//");

		Extent_cal(test,
				"Testcase 14 - Ensure that one way in return column displayes data properly which referred from one way leasing screen ");

		scrollBottom(driver);

		click(driver, Editbutton);

		wait(driver, "3");
		click(driver, Cancel);

		wait(driver, "3");

		click(driver, New);

		click(driver, Click_ok1);

		wait(driver, "3");
		Fluentwait(driver, dropdown_option);
		click(driver, dropdown_option);

		Fluentwait(driver, Budget_Reposition);
		click(driver, Budget_Reposition);

		Fluentwait(driver, Budget);
		click(driver, Budget);

		wait(driver, "4");

//uploadFileRobot(driver, EquimentType_Alphabets1);

		String upload_EquimentType_Alphabets7 = System.getProperty("user.dir") + "/driver/MasterDownloadfile.exe "
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

		Fluentwait(driver, ERO_Save);
		click(driver, ERO_Save);
		Fluentwait(driver, ERO_Save_ok);
		click(driver, ERO_Save_ok);
		wait(driver, "2");

		click(driver, Budjet_Yes);

		click(driver, ERO_Save_ok);

//HorizontalScrollFull(driver, Horizontal_gridscroll1);

//horizontalscroll(driver, Horizontal_gridscroll1, 5);

		wait(driver, "3");

		int scrollAmount8 = 1800; // Replace with the amount you want to scroll

		WebElement scroller8 = driver.findElement(By.xpath("(//div[@ref='eBodyHorizontalScrollViewport'])[1]"));

		js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller8, scrollAmount8);

		wait(driver, "3");

		String Onewayintreturn = getText(driver, One_Way_in_Return);

		System.out.println("Onewayintreturn : " + Onewayintreturn);
		wait(driver, "3");

		click(driver, Tab2);

		Fluentwait(driver, Lesein_Tab1);
		click(driver, Lesein_Tab1);

		Fluentwait(driver, One_Way_in_Return_Edit);
		click(driver, One_Way_in_Return_Edit);

		wait(driver, "3");

		clear(driver, One_Way_in_Qty);

		sendKeys(driver, One_Way_in_Qty, one_way_in_return_column);

		click(driver, Edit_Leasing);

		Fluentwait(driver, OneWay_Leasing_Save);

		click(driver, OneWay_Leasing_Save);

		wait(driver, "3");

		String Popup_Updated7 = getText(driver, Leasing_Updated_Popup);

		System.out.println("Popup_Updated7 : " + Popup_Updated7);
		wait(driver, "3");

		if (Popup_Updated7.equals(Leasing_Popup)) {
			System.out.println("Matched || Expected  popup message  was : " + Leasing_Popup
					+ " Actual popup message was : " + Popup_Updated7);
			Extent_pass(driver, "Matched || Expected popup message was : " + Leasing_Popup
					+ " Actual popup message was : " + Popup_Updated7, test, test1);
		} else {
			System.out.println("Not Matched || Expected popup message was : " + Leasing_Popup
					+ " Actual popup message was : " + Popup_Updated7);
			Extent_fail2(driver, "Not Matched || Expected popup message was : " + Leasing_Popup
					+ " Actual popup message was : " + Popup_Updated7, test);

		}

		click(driver, ok_Click);

		click(driver, Tab1);

		scrollBottom(driver);

		click(driver, Editbutton);

		wait(driver, "3");

		click(driver, Cancel);

		wait(driver, "3");

		click(driver, New);

		click(driver, Click_ok1);

		wait(driver, "3");
		Fluentwait(driver, dropdown_option);
		click(driver, dropdown_option);

		Fluentwait(driver, Budget_Reposition);
		click(driver, Budget_Reposition);

		Fluentwait(driver, Budget);
		click(driver, Budget);

		wait(driver, "4");

//uploadFileRobot(driver, EquimentType_Alphabets1);

		String upload_EquimentType_Alphabets8 = System.getProperty("user.dir") + "/driver/MasterDownloadfile.exe "
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

		Fluentwait(driver, ERO_Save);
		click(driver, ERO_Save);
		Fluentwait(driver, ERO_Save_ok);
		click(driver, ERO_Save_ok);
		wait(driver, "2");

		click(driver, Budjet_Yes);

		click(driver, ERO_Save_ok);

		wait(driver, "3");

		String Weeks_Data4 = getText(driver, Weeks_Data1);

		System.out.println("Weeks_Data4 : " + Weeks_Data4);

//HorizontalScrollFull(driver, Horizontal_gridscroll1);

//horizontalscroll(driver, Horizontal_gridscroll1, 5);

		wait(driver, "3");

		int scrollAmount7 = 1800; // Replace with the amount you want to scroll

		WebElement scroller9 = driver.findElement(By.xpath("(//div[@ref='eBodyHorizontalScrollViewport'])[1]"));

		js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller9, scrollAmount7);

		wait(driver, "3");

		String Onewayintreturn1 = getText(driver, One_Way_in_Return);

		System.out.println("Onewayintreturn1 : " + Onewayintreturn1);
		wait(driver, "3");

		int one_way_in_Return_Data = Integer.parseInt(Weeks_Data4) * Integer.parseInt(one_way_in_return_column);

		System.out.println("one_way_in_Return_Data : " + one_way_in_Return_Data);

		wait(driver, "3");

		if (!Onewayintreturn.equals(Onewayintreturn1)) {
			System.out.println("Matched || Both Value was not matched : " + Onewayintreturn1
					+ " Actual  Both value  was : " + Onewayintreturn);
			Extent_pass(driver, "Matched || Both Value was not matched : " + Onewayintreturn1
					+ " Both Value was not matched : " + Onewayintreturn, test, test1);
		} else {
			System.out.println("Not Matched || Both Value was matched : " + Onewayintreturn1
					+ "Both Value was matched : " + Onewayintreturn);
			Extent_fail2(driver, "Not Matched || Both Value was matched : " + Onewayintreturn1
					+ " Both Value was matched : " + Onewayintreturn, test);

		}

		wait(driver, "3");

		if (Integer.toString(one_way_in_Return_Data).equals(Onewayintreturn1)) {
			System.out.println("Matched || Both Value was  matched : " + Onewayintreturn1 + " Actual Both Value  was : "
					+ one_way_in_Return_Data);
			Extent_pass(driver, "Matched || Both Value was  matched : " + Onewayintreturn1
					+ " Both Value was  matched : " + one_way_in_Return_Data, test, test1);
		} else {
			System.out.println("Not Matched || Both Value was not matched : " + Onewayintreturn1
					+ "Both Value was not matched : " + one_way_in_Return_Data);
			Extent_fail2(driver, "Not Matched || Both Value was not matched : " + Onewayintreturn1
					+ " Both Value was not matched : " + one_way_in_Return_Data, test);

		}

		System.out
				.println("//***************************Testcase 14 Completed **************************************//");

	}
}
