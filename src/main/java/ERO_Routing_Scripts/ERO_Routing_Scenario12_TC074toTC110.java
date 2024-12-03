package ERO_Routing_Scripts;

import java.awt.Robot;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.Utils;

public class ERO_Routing_Scenario12_TC074toTC110 extends Keywords {

	public void ERO_Scenario12(WebDriver driver, ExtentTest test, ExtentTest test1, String url, int dataset)
			throws Exception {

		String Username = Utils.getDataFromTestData("ERO_Scenario12_Dataset" + dataset, "ERO Routing", "Username");
		String Password = Utils.getDataFromTestData("ERO_Scenario12_Dataset" + dataset, "ERO Routing", "Password");
		String ID = Utils.getDataFromTestData("ERO_Scenario12_Dataset" + dataset, "ERO Routing", "Id");
		String Save_Message = Utils.getDataFromTestData("ERO_Scenario12_Dataset" + dataset, "ERO Routing",
				"Save_Message");
		String Calculated_Message = Utils.getDataFromTestData("ERO_Scenario12_Dataset" + dataset, "ERO Routing",
				"Calculated_Message");
		String Calculated_Success = Utils.getDataFromTestData("ERO_Scenario12_Dataset" + dataset, "ERO Routing",
				"Calculated_Success");
		String Total = Utils.getDataFromTestData("ERO_Scenario12_Dataset" + dataset, "ERO Routing", "Total_Value");

		navigateUrl(driver, url);

		Actions act = new Actions(driver);
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

		Extent_cal(test, "Testcase 109 - Ensure Auto Routing button functionality for un available route tab");

		Fluentwait(driver, Route);
		click(driver, Route);

		wait(driver, "5");

		Fluentwait(driver, ERO_Popup_Ok);
		click(driver, ERO_Popup_Ok);

		Fluentwait(driver, EPO_unavailable);
		click(driver, EPO_unavailable);

		if (isDisplayed(driver, Un_region1)) {

			System.out.println("Auto routing button funtionality for unavailable route tab is working fine");
			Extent_pass(driver, "Auto routing button funtionality for unavailable route tab is working fine", test,
					test1);
		} else {

			System.out.println("Auto routing button funtionality for unavailable route tab is not working fine");
			Extent_fail(driver, "Auto routing button funtionality for unavailable route tab is not working fine", test,
					test1);
		}

		Fluentwait(driver, EPO_Route_Details);
		click(driver, EPO_Route_Details);

		Extent_cal(test, "Testcase 75 - Ensure edit button functionality new records not displayed in route details");

		Fluentwait(driver, ERO_Edit);
		click(driver, ERO_Edit);

		wait(driver, "5");

		Fluentwait(driver, ERO_save);
		click(driver, ERO_save);

		wait(driver, "3");
		Fluentwait(driver, ERO_Warning_Message);

		if (isDisplayed(driver, ERO_Warning_Message)) {
			System.out.println("Save popup is displayed");
			Extent_pass(driver, "Save popup is displayed", test, test1);
		} else {

			System.out.println("Save popup is not displayed");
			Extent_fail(driver, "Save popup is not displayed", test, test1);
		}

		String popupmessage = getText(driver, ERO_Warning_Message);

		if (popupmessage.equals(Save_Message)) {

			System.out.println("Expected poup message is displayed : '" + popupmessage + "'");
			Extent_pass(driver, "Expected poup message is displayed : '" + popupmessage + "'", test, test1);
		} else {
			System.out.println("Expected poup message is not displayed : '" + popupmessage + "'");
			Extent_fail(driver, "Expected poup message is not displayed : '" + popupmessage + "'", test, test1);
		}

		Fluentwait(driver, ERO_Popup_Ok);
		click(driver, ERO_Popup_Ok);

		if (IsElementEnabled(driver, Refresh_Routing)) {

			System.out.println("After saving the record, refresh routing button is enabled");
			Extent_pass(driver, "After saving the record, refresh routing button is enabled", test, test1);

		} else {

			System.out.println("After saving the record, refresh routing button is not enabled");
			Extent_fail(driver, "After saving the record, refresh routing button is not enabled", test, test1);
		}

		if (IsElementEnabled(driver, Recalculate_Routing)) {

			System.out.println("After saving the record, recalculate routing button is enabled");
			Extent_pass(driver, "After saving the record, recalculate routing button is enabled", test, test1);

		} else {

			System.out.println("After saving the record, recalculate routing button is not enabled");
			Extent_fail(driver, "After saving the record, recalculate routing button is not enabled", test, test1);
		}

		System.out.println("Testcase 75 completed");

		Extent_cal(test, "Testcase 76 - Ensure Cancel button functionality");

		Fluentwait(driver, ERO_Edit);
		click(driver, ERO_Edit);

		Fluentwait(driver, ERO_cancel);
		click(driver, ERO_cancel);

		wait(driver, "5");

		boolean cancel = true;

		if (!IsElementEnabled(driver, Refresh_Routing)) {

			System.out.println("After click on cancel button, refresh routing button is disabled");
			Extent_pass(driver, "After click on cancel button, refresh routing button is disabled", test, test1);

		} else {

			System.out.println("After click on cancel button, refresh routing button is still enabled");
			Extent_fail(driver, "After click on cancel button, refresh routing button is still enabled", test, test1);
			cancel = false;
		}

		if (!IsElementEnabled(driver, Recalculate_Routing)) {

			System.out.println("After click on cancel button, recalculate routing button is disabled");
			Extent_pass(driver, "After click on cancel button, recalculate routing button is disabled", test, test1);

		} else {

			System.out.println("After click on cancel button, recalculate routing button is still enabled");
			Extent_fail(driver, "After click on cancel button, recalculate routing button is still enabled", test,
					test1);
			cancel = false;

		}

		if (cancel) {

			System.out.println("After click on cancel button, system is displayed in the default view");
			Extent_pass(driver, "After click on cancel button, system is displayed in the default view", test, test1);
		} else {
			System.out.println("After click on cancel button, system is not displayed in the default view");
			Extent_fail(driver, "After click on cancel button, system is not displayed in the default view", test,
					test1);
		}

		System.out.println("Testcase 76 completed");

		Extent_cal(test, "Testcase 77 - Ensure Refresh Routing button functionality");

		Fluentwait(driver, ERO_Edit);
		click(driver, ERO_Edit);

		Fluentwait(driver, EPO_RefreshRouting);
		click(driver, EPO_RefreshRouting);
		wait(driver, "5");

		if (isDisplayed(driver, ERO_Warning_Message)) {
			System.out.println("Refresh button is functioning correctly");
			Extent_pass(driver, "Refresh button is functioning correctly", test, test1);
		} else {

			System.out.println("Refresh button is not functioning correctly");
			Extent_fail(driver, "Refresh button is not functioning correctly", test, test1);
		}

		Fluentwait(driver, ERO_popup_ok);
		click(driver, ERO_popup_ok);

		System.out.println("Testcase 77 completed");

		Extent_cal(test, "Testcase 78 - Ensure Re Calculate button functionality");

//		Fluentwait(driver, ERO_Edit);
//		click(driver, ERO_Edit);

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

		Fluentwait(driver, Calculate_No);
		click(driver, Calculate_No);

		System.out.println("Testcase 78 completed");

		wait(driver, "5");

		Extent_cal(test, "Testcase 79 - Ensure Re Calculate button functionality, when click on yes button");

//		Fluentwait(driver, Grid1_Checkbox);
//		click(driver, Grid1_Checkbox);

		Fluentwait(driver, Recalculate_Routing);
		click(driver, Recalculate_Routing);

		wait(driver, "5");

		String calculated_popup2 = getText(driver, ERO_Warning_Message);

		if (calculated_popup2.equals(Calculated_Message)) {

			System.out
					.println("Expected confirmation popup was displayed and displayed text was : " + calculated_popup2);
			Extent_pass(driver,
					"Expected confirmation popup was displayed and displayed text was : " + calculated_popup2, test,
					test1);
		} else {
			System.out.println(
					"Expected confirmation popup was not displayed and displayed text was : " + calculated_popup2);
			Extent_fail(driver,
					"Expected confirmation popup was not displayed and displayed text was : " + calculated_popup2, test,
					test1);
		}

		Fluentwait(driver, Calculate_Yes);
		click(driver, Calculate_Yes);

		wait(driver, "5");

		Fluentwait(driver, ERO_Popup_Ok2);
		click(driver, ERO_Popup_Ok2);

		wait(driver, "3");

		Fluentwait(driver, ERO_Warning_Message);
		String calculatedsuccess = getText(driver, ERO_Warning_Message);

		if (calculatedsuccess.equals(Calculated_Success)) {

			System.out.println("Expected popup was displayed and displayed text was : " + calculatedsuccess);
			Extent_pass(driver, "Expected popup was displayed and displayed text was : " + calculatedsuccess, test,
					test1);
		} else {
			System.out.println("Expected popup was not displayed and displayed text was : " + calculatedsuccess);
			Extent_fail(driver, "Expected popup was not displayed and displayed text was : " + calculatedsuccess, test,
					test1);
		}

		Fluentwait(driver, ERO_Popup_Ok);
		click(driver, ERO_Popup_Ok);

		System.out.println("Testcase 79 completed");

		Extent_cal(test, "Testcase 80 - Ensure View cost Split-UP button functionality ");

		Fluentwait(driver, ERO_Costsplitup);
		click(driver, ERO_Costsplitup);

		wait(driver, "5");

		List<String> Columnname = Arrays.asList("dLoadCost", "dDischDCost", "dTS1LoadCost", "dTS2LoadCost",
				"dTS3LoadCost", "dTS1DischCost", "dTS2DischCost", "dTS3DischCost", "dFdrCost1", "sLoadSector",
				"dFdrCost2", "sDischSector", "dFdrCost3", "sLoadTCA", "dLoadHlgCost", "dDischHlgCost", "dIntFdrCost1",
				"dIntFdrCost2");

		List<String> Names = Arrays.asList("Load cost", "Disch chart", "TS1 Load cost", "TS2 Load cost",
				"TS3 Load cost", "TS1 Disch cost", "TS2 Disch cost", "TS3 Disch cost", "Feeder cost1", "Feeder 1 Terms",
				"Feeder cost2", "Feeder 2 Terms", "Feeder cost3", "Feeder 3 Terms", "Load haulage cost",
				"Disch haulage cost", "DPH origin cost", "DPH Destination cost");

		int size = Columnname.size();

		WebElement scroller = driver.findElement(By.xpath("(//div[@ref='eBodyHorizontalScrollViewport'])[2]"));

		int scrollAmount = 2500; //

		js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller, scrollAmount);

		for (int i = 0; i < size; i++) {

			String columns = Columnname.get(i);

			String Column_Name = Names.get(i);
//			wait(driver,"1");
			WebElement element = driver.findElement(By.xpath("//div[@col-id='" + columns + "']"));

			act.moveToElement(element).build().perform();

//			wait(driver,"1");

			if (element.isDisplayed()) {

				System.out.println("After click on show cost splitup " + Column_Name + " was displayed in the grid");
				Extent_pass(driver, "After click on show cost splitup " + Column_Name + " was displayed in the grid",
						test, test1);
			} else {
				System.out
						.println("After click on show cost splitup " + Column_Name + " was not displayed in the grid");
				Extent_fail(driver,
						"After click on show cost splitup " + Column_Name + " was not displayed in the grid", test,
						test1);

			}
		}

		List<String> Columnnames1 = Arrays.asList("dIntFdrCost3", "dIntFdrCost4", "dITT1Cost", "dITT2Cost",
				"dOthersCost");

		List<String> Name1 = Arrays.asList("LCT Origin cost", "LCT destination cost", "On - hire cost", "off-hire cost",
				"In Service Destination Cost");

		int size_v = Columnnames1.size();

		WebElement scroller_v = driver.findElement(By.xpath("(//div[@ref='eBodyHorizontalScrollViewport'])[2]"));

		int scrollAmount_v = 1000; //

		js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller_v, scrollAmount_v);

		for (int i = 0; i < size_v; i++) {

			String columns = Columnnames1.get(i);

			String Column_Name = Name1.get(i);

			WebElement element = driver.findElement(By.xpath("//div[@col-id='" + columns + "']"));

			act.moveToElement(element).build().perform();

//			wait(driver,"1");

			if (element.isDisplayed()) {

				System.out.println("After click on show cost splitup " + Column_Name + " was displayed in the grid");
				Extent_pass(driver, "After click on show cost splitup " + Column_Name + " was displayed in the grid",
						test, test1);
			} else {
				System.out
						.println("After click on show cost splitup " + Column_Name + " was not displayed in the grid");
				Extent_fail(driver,
						"After click on show cost splitup " + Column_Name + " was not displayed in the grid", test,
						test1);

			}
		}
		wait(driver, "2");

		System.out.println("Testcase 80, completed");

		Extent_cal(test, "Testcase 81 - Ensure Hide cost Split-UP button functionality ");

		Fluentwait(driver, ERO_Costsplitup);
		click(driver, ERO_Costsplitup);

		wait(driver, "5");

		WebElement scroller_hide = driver.findElement(By.xpath("(//div[@ref='eBodyHorizontalScrollViewport'])[2]"));

		js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller_hide, scrollAmount_v);

		for (int i = 0; i < size; i++) {

			String columns = Columnname.get(i);

			String Column_Name = Names.get(i);
			wait(driver, "1");

			List<WebElement> costfields = driver.findElements(By.xpath("//div[@col-id='" + columns + "']"));

			if (costfields.isEmpty()) {

				System.out
						.println("After click on hide cost splitup " + Column_Name + " was not displayed in the grid");
				Extent_pass(driver,
						"After click on hide cost splitup " + Column_Name + " was not displayed in the grid", test,
						test1);
			} else {
				System.out.println("After click on hide cost splitup " + Column_Name + " was displayed in the grid");
				Extent_fail(driver, "After click on hide cost splitup " + Column_Name + " was displayed in the grid",
						test, test1);

			}
		}

		for (int i = 0; i < size_v; i++) {

			String columns = Columnnames1.get(i);

			String Column_Name = Name1.get(i);

			List<WebElement> costfields2 = driver.findElements(By.xpath("//div[@col-id='" + columns + "']"));

			if (costfields2.isEmpty()) {

				System.out
						.println("After click on hide cost splitup " + Column_Name + " was not displayed in the grid");
				Extent_pass(driver,
						"After click on hide cost splitup " + Column_Name + " was not displayed in the grid", test,
						test1);
			} else {
				System.out.println("After click on hide cost splitup " + Column_Name + " was displayed in the grid");
				Extent_fail(driver, "After click on hide cost splitup " + Column_Name + " was displayed in the grid",
						test, test1);
			}
		}

		System.out.println("Testcase 81, completed");

		Extent_cal(test,
				"Testcase 82, Ensure Origin,Delivery,Size type,Main service,Original Mode, POL, POL Terminal, POL Service,Trans1,Trans1 Terminal,Trans1 Service,Trans2,Trans2 Terminal,Trans2 Service,Trans3,Trans3 Terminal,Trans3 Service,POD,POD Terminal,Delivery,Cost (Amount in USD),Transit Time,Missing cost,Load Cost,discharge cost,Ts1 Load cost,Ts2 Load cost,Ts3 Load cost,Ts1 Discharge cost,Ts2 Discharge cost,Ts3 Discharge cost,Feeder cost1,Feeder cost2,Feeder cost3,ITT cost, Load Haulage cost, Discharge Haulage cost,Others cost Functionality for Route details tab");

		Fluentwait(driver, view_cost);
		click(driver, view_cost);

		Fluentwait(driver, ERO_Filter);
		click(driver, ERO_Filter);

		wait(driver, "2");
		Jsclick(driver, ERO_Filter_box);
		wait(driver, "2");
		Jsclick(driver, ERO_Filter_Search);
		wait(driver, "2");
		Jsclick(driver, ERO_Filter_Search);
		wait(driver, "2");
		Jsclick(driver, ERO_Filter_Origin);
		wait(driver, "2");
		Jsclick(driver, ERO_Filter_Origin);
		wait(driver, "2");
		Jsclick(driver, ERO_Filter_Delivery);
		wait(driver, "2");
		Jsclick(driver, ERO_Filter_Delivery);
		wait(driver, "2");
		Jsclick(driver, ERO_Size_Type);
		wait(driver, "2");
		Jsclick(driver, ERO_Size_Type);
		wait(driver, "2");
		Jsclick(driver, ERO_Cost);
		wait(driver, "2");
		Jsclick(driver, ERO_Cost);
		wait(driver, "2");
		Jsclick(driver, ERO_Main_Service);
		wait(driver, "2");
		Jsclick(driver, ERO_Main_Service);
		wait(driver, "2");
		Jsclick(driver, ERO_Origin_Mode);
		wait(driver, "2");
		Jsclick(driver, ERO_Origin_Mode);
		wait(driver, "2");
		Jsclick(driver, ERO_POL);
		wait(driver, "2");
		Jsclick(driver, ERO_POL);
		wait(driver, "2");
		Jsclick(driver, ERO_POL_Terminal);
		wait(driver, "2");
		Jsclick(driver, ERO_POL_Terminal);
		wait(driver, "2");
		Jsclick(driver, ERO_POL_Service);
		wait(driver, "2");
		Jsclick(driver, ERO_POL_Service);
		wait(driver, "2");
		Jsclick(driver, ERO_Trans1);
		wait(driver, "2");
		Jsclick(driver, ERO_Trans1);
		wait(driver, "2");
		Jsclick(driver, ERO_Trans1_ser);
		wait(driver, "2");
		Jsclick(driver, ERO_Trans1_ser);
		wait(driver, "2");
		Jsclick(driver, ERO_Trans2);
		wait(driver, "2");
		Jsclick(driver, ERO_Trans2);
		wait(driver, "2");
		Jsclick(driver, ERO_Trans2_ser);
		wait(driver, "2");
		Jsclick(driver, ERO_Trans2_ser);
		wait(driver, "2");
		Jsclick(driver, ERO_Trans3);
		wait(driver, "2");
		Jsclick(driver, ERO_Trans3);
		wait(driver, "2");
		Jsclick(driver, ERO_Trans3_ser);
		wait(driver, "2");
		Jsclick(driver, ERO_Trans3_ser);
		wait(driver, "2");
		Jsclick(driver, ERO_POD);
		wait(driver, "2");
		Jsclick(driver, ERO_POD);
		wait(driver, "2");
		Jsclick(driver, ERO_POD_Terminal);
		wait(driver, "2");
		Jsclick(driver, ERO_POD_Terminal);
		wait(driver, "2");
		Jsclick(driver, ERO_Delivery_Mode);
		wait(driver, "2");
		Jsclick(driver, ERO_Delivery_Mode);
		wait(driver, "2");
		Jsclick(driver, ERO_Transit_Days);
		wait(driver, "2");
		Jsclick(driver, ERO_Transit_Days);
		wait(driver, "2");
		Jsclick(driver, ERO_Missing_Cost);
		wait(driver, "2");
		Jsclick(driver, ERO_Missing_Cost);
		wait(driver, "2");
		Jsclick(driver, ERO_Routing_From);
		wait(driver, "2");
		Jsclick(driver, ERO_Routing_From);
		wait(driver, "2");
		Jsclick(driver, ERO_Load_Cost);
		wait(driver, "2");
		Jsclick(driver, ERO_Load_Cost);
		wait(driver, "2");
		Jsclick(driver, ERO_Disch_Cost);
		wait(driver, "2");
		Jsclick(driver, ERO_Disch_Cost);
		wait(driver, "2");
		Jsclick(driver, ERO_Ts1_Load_Cost);
		wait(driver, "2");
		Jsclick(driver, ERO_Ts1_Load_Cost);
		wait(driver, "2");
		Jsclick(driver, ERO_Ts2_Load_Cost);
		wait(driver, "2");
		Jsclick(driver, ERO_Ts2_Load_Cost);
		wait(driver, "2");
		Jsclick(driver, ERO_Ts3_Load_Cost);
		wait(driver, "2");
		Jsclick(driver, ERO_Ts3_Load_Cost);
		wait(driver, "2");
		Jsclick(driver, ERO_TS1_Disch_Cost);
		wait(driver, "2");
		Jsclick(driver, ERO_TS1_Disch_Cost);
		wait(driver, "2");
		Jsclick(driver, ERO_TS2_Disch_Cost);
		wait(driver, "2");
		Jsclick(driver, ERO_TS2_Disch_Cost);
		wait(driver, "2");
		Jsclick(driver, ERO_TS3_Disch_Cost);
		wait(driver, "2");
		Jsclick(driver, ERO_TS3_Disch_Cost);
		wait(driver, "2");
		Jsclick(driver, ERO_Feeder_Cost_1);
		wait(driver, "2");
		Jsclick(driver, ERO_Feeder_Cost_1);
		wait(driver, "2");
		Jsclick(driver, ERO_Feeder_1_terms);
		wait(driver, "2");
		Jsclick(driver, ERO_Feeder_1_terms);
		wait(driver, "2");
		Jsclick(driver, ERO_Feeder_Cost_2);
		wait(driver, "2");
		Jsclick(driver, ERO_Feeder_Cost_2);
		wait(driver, "2");
		Jsclick(driver, ERO_Feeder_2_terms);
		wait(driver, "2");
		Jsclick(driver, ERO_Feeder_2_terms);
		wait(driver, "2");
		Jsclick(driver, ERO_Feeder_Cost_3);
		wait(driver, "2");
		Jsclick(driver, ERO_Feeder_Cost_3);
		wait(driver, "2");
		Jsclick(driver, ERO_Feeder_3_terms);
		wait(driver, "2");
		Jsclick(driver, ERO_Feeder_3_terms);
		wait(driver, "2");
		Jsclick(driver, ERO_Load_Haulage);
		wait(driver, "2");
		Jsclick(driver, ERO_Load_Haulage);
		wait(driver, "2");
		Jsclick(driver, ERO_Disch_Haulage);
		wait(driver, "2");
		Jsclick(driver, ERO_Disch_Haulage);
		wait(driver, "2");
		Jsclick(driver, ERO_DPH_Origin_Haulage);
		wait(driver, "2");
		Jsclick(driver, ERO_DPH_Origin_Haulage);
		wait(driver, "2");
		Jsclick(driver, ERO_DPH_Origin_Destination_Cost);
		wait(driver, "2");
		Jsclick(driver, ERO_DPH_Origin_Destination_Cost);
		wait(driver, "2");
		Jsclick(driver, ERO_LTC_Origin_Cost);
		wait(driver, "2");
		Jsclick(driver, ERO_LTC_Origin_Cost);
		wait(driver, "2");
		Jsclick(driver, ERO_LTC_Destination_Cost);
		wait(driver, "2");
		Jsclick(driver, ERO_LTC_Destination_Cost);
		wait(driver, "2");
		Jsclick(driver, ERO_On_Hire_Cost);
		wait(driver, "2");
		Jsclick(driver, ERO_On_Hire_Cost);
		wait(driver, "2");
		Jsclick(driver, ERO_OFf_Hire_Cost);
		wait(driver, "2");
		Jsclick(driver, ERO_OFf_Hire_Cost);
		wait(driver, "2");
		Jsclick(driver, ERO_Service_Destination_Cost);
		wait(driver, "2");
		Jsclick(driver, ERO_Service_Destination_Cost);

		Fluentwait(driver, ERO_Filter);
		click(driver, ERO_Filter);

		System.out.println("Testcase 82 completed");

		Fluentwait1(driver, ERO_SVM);
		click(driver, ERO_SVM);

		Extent_cal(test,
				"Testcase 83,Ensure Load Region,Load country,Origin,Delivery,Discharge country,Discharge Region,Equipment type  Functionality for unavailable route tab");

		wait(driver, "2");

		Fluentwait(driver, ERO_Un_available_Route);
		click(driver, ERO_Un_available_Route);

		List<String> Columnname3 = Arrays.asList("nfr_sel_col", "sLoadregion", "sLoadcounrty", "origin", "delivery",
				"sDischcounty", "sDischregion", "sizetype");

		List<String> Names3 = Arrays.asList("Select", "Load Region", "Load Country", "Origin", "Delivery",
				"Disch Country", "Disch Region", "Equipment Type");

		int size2 = Columnname3.size();

		for (int i = 0; i < size2; i++) {

			String columns3 = Columnname3.get(i);

			String Column_Name3 = Names3.get(i);

			WebElement element = driver
					.findElement(By.xpath("//div[@id='ERU-ERU_treeTable2']//div[@col-id='" + columns3 + "']"));
			waitForWebElement(driver, element, "Grid fields");
			act.moveToElement(element).build().perform();

			wait(driver, "5");

			if (element.isDisplayed()) {

				System.out.println("After click on show cost splitup " + Column_Name3 + " was displayed in the grid");
				Extent_pass(driver, "After click on show cost splitup " + Column_Name3 + " was displayed in the grid",
						test, test1);
			} else {
				System.out
						.println("After click on show cost splitup " + Column_Name3 + " was not displayed in the grid");
				Extent_fail(driver,
						"After click on show cost splitup " + Column_Name3 + " was not displayed in the grid", test,
						test1);

			}

		}
		System.out.println("Testcase 83 completed");

		Extent_cal(test, "Testcase 84,Ensure Filter OFF button Functionality for ");

		wait(driver, "5");

		Fluentwait1(driver, ERO_SVM);
		click(driver, ERO_SVM);

		Fluentwait(driver, ERO_TreeTable);
		click(driver, ERO_TreeTable);

		Fluentwait(driver, Ero_Codition_Filter);
		click(driver, Ero_Codition_Filter);

		if (isDisplayed(driver, Ero_Codition_Filter_Input_Field)) {
			System.out.println("Condition filed is displayed");
			Extent_pass(driver, "Condition filed is displayed", test, test1);
		} else {

			System.out.println("Condition filed is not displayed");
			Extent_fail(driver, "Condition filed is not displayed", test, test1);
		}
		wait(driver, "2");
		click(driver, ERO_TreeTable);
		wait(driver, "2");
		click(driver, ERO_Distinct_Filter);
		if (!isDisplayed(driver, Ero_Codition_Filter_Input_Field)) {
			System.out.println("Condition filed is not displayed");
			Extent_pass(driver, "Condition filed is not displayed", test, test1);
		} else {

			System.out.println("Condition filed is  displayed");
			Extent_fail(driver, "Condition filed is  displayed", test, test1);
		}
		System.out.println("Testcase 84 completed");

		Extent_cal(test, "TestCase_TC_85, Ensure select the carrier tree structure filter  ");

		Fluentwait1(driver, SVM_Dropdown);
		click(driver, SVM_Dropdown);

		Fluentwait1(driver, SVM_Dropdown);
		click(driver, SVM_Dropdown);

		Fluentwait1(driver, AFR_Dropdown);
		click(driver, AFR_Dropdown);
		wait(driver, "2");
		Fluentwait1(driver, Ad_option);
		click(driver, Ad_option);

		List<WebElement> LoadCountryList = driver
				.findElements(By.xpath("//div[@col-id='sLoadcounrty' and @role='gridcell']"));
		List<WebElement> DischCountryList = driver
				.findElements(By.xpath("//div[@col-id='sDischcounty' and @role='gridcell']"));

		boolean ADFilter = true;
		for (int j = 0; j < LoadCountryList.size(); j++) {
			WebElement LoadCountry = LoadCountryList.get(j);
			wait(driver, "2");
			String LoadCountryString = LoadCountry.getText();

			WebElement DischCountry = DischCountryList.get(j);
			String DischCountryString = DischCountry.getText();

			if (LoadCountryString.equals("AD") || DischCountryString.equals("AD")) {
				Extent_pass(driver, "AD value is displayed in the row : " + j, test, test1);

			} else {
				Extent_fail(driver, "AD value is not displayed in the row : " + j, test, test1);
				ADFilter = false;
			}

		}

		if (ADFilter == true) {
			Extent_pass(driver, "Country filter for AD page is working", test, test1);

		} else {
			Extent_fail(driver, "Country filter for AD page is not working", test, test1);
		}

		System.out.println("Testcase 85 compleated");

		Extent_cal(test, "Testcase 86 - Ensure Filter the records using tree structure Region  ");

		Fluentwait(driver, ERO_AFR_Option);
		click(driver, ERO_AFR_Option);
		wait(driver, "2");

		String TotalValue = getText(driver, ERO_Total_Count);
		if (TotalValue.equals(Total)) {

			System.out.println("Expected value :" + TotalValue + "Actual Value:" + Total);
			Extent_pass(driver, "Expected value : " + TotalValue + "Actual value:" + Total, test, test1);
		} else {
			System.out.println("Expected value :" + TotalValue + "Actual Value:" + Total);
			Extent_fail(driver, "Expected value : " + TotalValue + "Actual value:" + Total, test, test1);
		}

		System.out.println("Testcase 86 completed");

		Extent_cal(test, "TestCase_TC_89, Ensure Filter the records using tree structure Country  ");

		Fluentwait1(driver, SVM_Dropdown);
		click(driver, SVM_Dropdown);
		Fluentwait1(driver, SVM_Dropdown);
		click(driver, SVM_Dropdown);
//  	    Fluentwait1(driver, AFR_Dropdown);
// 	    click(driver,AFR_Dropdown); 
		wait(driver, "2");
		Fluentwait1(driver, Ad_Dropdown);
		click(driver, Ad_Dropdown);
		wait(driver, "2");
		Fluentwait1(driver, Adsfc_Option);
		click(driver, Adsfc_Option);

		List<WebElement> originList = driver.findElements(By.xpath("//div[@col-id='origin' and @role='gridcell']"));
		boolean Filter = true;
		for (int j = 0; j < originList.size(); j++) {
			WebElement Load = originList.get(j);
			String LoadString = Load.getText();

			if (LoadString.equals("ADSFC(OW)")) {
				Extent_pass(driver, "ADSFC(OW) value is displayed ", test, test1);
			} else {
				Extent_fail(driver, "ADSFC(OW) value is not displayed ", test, test1);
				Filter = false;
			}

		}

		if (Filter == true) {
			Extent_pass(driver, "Country filter for ADSFC(OW) page is working", test, test1);

		} else {
			Extent_fail(driver, "Country filter for ADSFC(OW) page is not working", test, test1);
		}
		System.out.println("*******Testcase 89 completed");

		Extent_cal(test, "TestCase_TC_90,Ensure Filter the records using tree structure Location  ");

		Fluentwait1(driver, SVM_Dropdown);
		click(driver, SVM_Dropdown);
		Fluentwait1(driver, SVM_Dropdown);
		click(driver, SVM_Dropdown);
		wait(driver, "2");
		Fluentwait1(driver, AFR_Dropdown);
		click(driver, AFR_Dropdown);
		Fluentwait1(driver, Ero_Afr_drop);
		click(driver, Ero_Afr_drop);

		Fluentwait1(driver, Ar_d);
		click(driver, Ar_d);
		Fluentwait1(driver, Arrga_Option);
		click(driver, Arrga_Option);

		List<WebElement> DischList = driver
				.findElements(By.xpath("//div[@col-id='sDischcounty' and @role='gridcell']"));
		boolean Filter1 = true;
		for (int j = 0; j < DischList.size(); j++) {
			WebElement Disch = DischList.get(j);
			String DischString = Disch.getText();

			if (DischString.equals("ARRGA(OF)")) {
				Extent_pass(driver, "ARRGA(OF) value is displayed ", test, test1);
			} else {
				Extent_fail(driver, "ARRGA(OF) value is not displayed ", test, test1);
				Filter1 = false;
			}

		}

		if (Filter1 == true) {
			Extent_pass(driver, "Country filter for ARRGA(OF) page is working", test, test1);

		} else {
			Extent_fail(driver, "Country filter for ARRGA(OF) page is not working", test, test1);
		}
		System.out.println("Testcase 90 completed");

	}
}