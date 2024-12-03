package ERO_Optimizer_reportGate;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.Utils;

public class TS_07toTS14_ReportGate extends Keywords{
	
	public void Testcase07(WebDriver driver, ExtentTest test, ExtentTest test1, String url, int dataset) {
		
		String Username = Utils.getDataFromTestData("TS007_ReportGate_Dataset"+dataset, "ReportGate","Username");
		String Password = Utils.getDataFromTestData("TS007_ReportGate_Dataset"+dataset, "ReportGate","Password");
		
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
		
		Extent_cal(test, "Testcase 21 - Verify that system is allowing to display the validation msg  while trying to add a load location without entering a ID");
		
		Fluentwait(driver, Searchbox);
		sendKeys(driver, Searchbox, "ERO Optimization Report Gate");
		
		Fluentwait(driver, Report_gate);
		click(driver, Report_gate);
		
		Fluentwait(driver, Load_location);
		click(driver, Load_location);
				
		Fluentwait(driver, Report_gate_popup);
		
		String popup_message = getText(driver, Report_gate_popup);
		
		if(popup_message.equals("Select the ID")) {
			
			System.out.println("Validation popup message is displayed, when the user click the load location button without selecting the ID");
			Extent_pass(driver, "Validation popup message is displayed, when the user click the load location button without selecting the ID", test, test1);
		}else {
			
			System.out.println("Validation popup message is not displayed");
			Extent_fail(driver, "Validation popup message is not displayed", test, test1);
		}
		
		System.out.println("Testcase 21 completed");
		
		
		Extent_cal(test, "Testcase 22 - Verify the system is allowing to display a load location while click the add button");
		
		Fluentwait(driver, Popup_ok);
		click(driver, Popup_ok);
		
		Fluentwait(driver, ID_Searchbutton);
		click(driver, ID_Searchbutton);
		
		Fluentwait(driver, ID_inputfield);
		sendKeys(driver, ID_inputfield, "E20240513-20-19-00001");
		
		Fluentwait(driver, Click_search);
		click(driver, Click_search);
		
		wait(driver,"2");
		
		Fluentwait(driver, Select_first);
		doubleClick(driver, Select_first);
		
		wait(driver,"5");
		
		Fluentwait(driver, Load_region);
		click(driver, Load_region);
		
		wait(driver,"5");
		
		Fluentwait(driver, Select_first);
		doubleClick(driver, Select_first);
		
		wait(driver,"5");
		
		Fluentwait(driver, Load_location);
		click(driver, Load_location);
		
		wait(driver,"2");
		
		Fluentwait(driver, Select_first);
		
		String Location1 = getText(driver, Select_first);
		
		doubleClick(driver, Select_first);
		
		System.out.println("Location1 : "+Location1);
		
		wait(driver,"2");
		
		Fluentwait(driver, Selected_location);
		
		String Selected_location1 = getText(driver, Selected_location);
		
		if(Location1.equals(Selected_location1)) {
			
			System.out.println("Selected load location was displayed in the input field");
			Extent_pass(driver, "Selected load location was displayed in the input field", test, test1);
			Extent_pass(driver, "Expected location : "+Selected_location1+" Actual location : "+Location1, test, test1);
		}else {
			System.out.println("Selected load location was not displayed in the input field");
			Extent_fail(driver, "Selected load location was not displayed in the input field", test, test1);
			Extent_fail(driver, "Expected location : "+Selected_location1+" Actual location : "+Location1, test, test1);
		}
		
		System.out.println("Testcase 22 completed");
		
		Extent_cal(test, "Testcase 23 - Verify the load location add button");
		
		Fluentwait(driver, Reportgate_cancel);
		click(driver, Reportgate_cancel);
		
		Fluentwait(driver, Reportgate_new);
		click(driver, Reportgate_new);
		
		Fluentwait(driver, Click_Yes);
		click(driver, Click_Yes);
		
		Fluentwait(driver, ID_Searchbutton);
		click(driver, ID_Searchbutton);
		
		Fluentwait(driver, ID_inputfield);
		sendKeys(driver, ID_inputfield, "E20240513-20-19-00001");
		
		Fluentwait(driver, Click_search);
		click(driver, Click_search);
		
		wait(driver,"5");
		
		Fluentwait(driver, Select_first);
		doubleClick(driver, Select_first);
		
		wait(driver,"5");
		
		Fluentwait(driver, Load_region);
		click(driver, Load_region);
		
		wait(driver,"2");
		
		Fluentwait(driver, Select_first);
		doubleClick(driver, Select_first);
		
		wait(driver,"5");
		
		Fluentwait(driver, Load_location);
		click(driver, Load_location);
		
		wait(driver,"2");
		
		Fluentwait(driver, Select_first);
		
		String Load_Location = getText(driver, Select_first);
		
		doubleClick(driver, Select_first);
		
		System.out.println("Location1 : "+Load_Location);
		
		wait(driver,"2");
		
		Fluentwait(driver, Selected_location);
		
		String Selected_Loadlocation1 = getText(driver, Selected_location);
		
		if(Load_Location.equals(Selected_Loadlocation1)) {
			
			System.out.println("Selected load location was displayed in the input field");
			Extent_pass(driver, "Selected load location was displayed in the input field", test, test1);
			Extent_pass(driver, "Expected location : "+Selected_Loadlocation1+" Actual location : "+Load_Location, test, test1);
		}else {
			System.out.println("Selected load location was not displayed in the input field");
			Extent_fail(driver, "Selected load location was not displayed in the input field", test, test1);
			Extent_fail(driver, "Expected location : "+Selected_Loadlocation1+" Actual location : "+Load_Location, test, test1);
		}
		
		System.out.println("Testcase 23 completed");
		
		Extent_cal(test, "Testcase 24 - Verify the system is allowing to reduce a load location while click the reduce button");
		
		Fluentwait(driver, Selected_location);
		click(driver, Selected_location);
		
		Fluentwait(driver, Reduce_location);
		click(driver, Reduce_location);
		
		wait(driver,"5");
		
		if(!isDisplayed(driver, Selected_location)) {
			
			System.out.println("Location was correctly removed");
			Extent_pass(driver, "Location was correctly removed", test, test1);
		}else {
			
			System.out.println("Location was not removed");
			Extent_fail(driver, "Location was not removed", test, test1);
		}
		
		System.out.println("Testcase 24 completed");
		
		Extent_cal(test, "Testcase 25 - Verify that while clicking the ID filed a system is not allow to type the IB number in that field");
		
		Fluentwait(driver, ID_input);
		sendKeys(driver, ID_input, "E20240513-20-19-10001");
		
		String Current_Id = getAttribute(driver, ID_input, "value");
		
		if(!Current_Id.equals("E20240513-20-19-10001")) {
			
			System.out.println("Id field is not allowing to type the ID number");
			Extent_pass(driver, "Id field is not allowing to type the ID number", test, test1);
		}else {
			
			System.out.println("Id field is allowing to type the ID number");
			Extent_fail(driver, "Id field is allowing to type the ID number", test, test1);	
		}
		
		System.out.println("Testcase 25 completed");
		
		Extent_cal(test, "Testcase 26 - Verify that while clicking the load region filed system is allow to editable the location character in that filed");
		
		Fluentwait(driver, Load_region_input);
		clear(driver, Load_region_input);
		
		Fluentwait(driver, Load_region);
		click(driver,Load_region);
		
		wait(driver,"5");
		
		Fluentwait(driver, Select_first);
		
		String region_Id = getText(driver, Select_first);
		
		String region_name = getText(driver, Region_name);
		
		Fluentwait(driver, Region_close);
		click(driver, Region_close);
		
		Fluentwait(driver, Load_region_input);
		sendKeys(driver, Load_region_input, region_Id);
		
		wait(driver,"5");
		
		String Entered_region = getAttribute(driver, Load_region_input, "value");
		
		if(Entered_region.equals(region_Id)) {
			
			System.out.println("Region ID field is allowing to enter the 3 characters");
			Extent_pass(driver, "Region ID field is allowing to enter the 3 characters", test, test1);
		}else {
			
			System.out.println("Region ID field is not allowing to enter the values");
			Extent_fail(driver, "Region ID field is not allowing to enter the values", test, test1);
		}
		
		System.out.println("Testcase 26 completed");
		
		
		Extent_cal(test, "Testcase 27 - Verify the load region name displaying the field of load region");
		
		enter(driver);
		
		wait(driver,"5");
		
		String Autoselected_region = getAttribute(driver, Region_name_input, "value");
		
		if(Autoselected_region.equals(region_name)) {
			
			System.out.println("Load region name field is displaying the load region Id's respective name");
			Extent_pass(driver, "Load region name field is displaying the load region Id's respective name", test, test1);
		}else {
			System.out.println("Load region name field is not displaying the load region Id's respective name");
			Extent_fail(driver, "Load region name field is not displaying the load region Id's respective name", test, test1);		
		}
		
		System.out.println("Testcase 27 completed");
		
		
		Extent_cal(test, "Testcase 28 - Verify that while clicking the load region search button a system is allowing to display the load region code and name");
		
		Fluentwait(driver, Load_region);
		click(driver,Load_region);
		
		wait(driver,"5");
		
		Fluentwait(driver, Searchcode_input);
		sendKeys(driver, Searchcode_input, region_Id);
		
		wait(driver,"5");
		
		String Searched_region_name = getText(driver, Region_name);
		
		if(Searched_region_name.equals(region_name)) {			
			System.out.println("Load region name is displayed in the field of load region");
			Extent_pass(driver, "Load region name is displayed in the field of load region", test, test1);
		}else {
			System.out.println("Load region name is not displayed in the field of load region");
			Extent_fail(driver, "Load region name is not displayed in the field of load region", test, test1);
		}
		
		System.out.println("Testcase 28 completed");
		
		
		Extent_cal(test, "Testcase 29 - Ensure that while double clicking a load region code and name and its allow to display in load region field");
		
		Fluentwait(driver, Region_close);
		click(driver, Region_close);
		
		Fluentwait(driver, Load_region);
		click(driver,Load_region);
		
		wait(driver,"5");
		
		Fluentwait(driver, Select_first);
		String firstname = getText(driver, Select_first);
		doubleClick(driver, Select_first);
		
		wait(driver,"5");
		
		String Selected_region = getAttribute(driver, Load_region_input, "value");
		
		if (Selected_region.equals(firstname)) {
			
			System.out.println("After double click on load region code, it displayed in the load region code field code");
			Extent_pass(driver, "After double click on load region code, it displayed in the load region code field code", test, test1);
		}else {
			
			System.out.println("After double click on load region code, it's not displayed in the load region code field code");
			Extent_fail(driver, "After double click on load region code, it's not displayed in the load region code field code", test, test1);
		}
		
		System.out.println("Testcase 29 completed");
		
		
		Extent_cal(test, "Testcase 30 - Ensure that system is allowing to display the validation message while clicking the show button without entering the ID");
		
		Fluentwait(driver, Reportgate_cancel);
		click(driver, Reportgate_cancel);
		
		Fluentwait(driver, Reportgate_new);
		click(driver, Reportgate_new);
		
		Fluentwait(driver, Click_Yes);
		click(driver, Click_Yes);
		
		wait(driver,"5");
		
		Fluentwait(driver, LoadLocation_search);
		click(driver, LoadLocation_search);
		
		wait(driver,"5");
		
		String show_popup_message = getText(driver, Report_gate_popup);
		
		if(show_popup_message.equals("Select the ID")) {
			
			System.out.println("Validation popup message is displayed, when the user click the load location button without selecting the ID");
			Extent_pass(driver, "Validation popup message is displayed, when the user click the load location button without selecting the ID", test, test1);
		}else {
			
			System.out.println("Validation popup message is not displayed");
			Extent_fail(driver, "Validation popup message is not displayed", test, test1);
		}
		
		Fluentwait(driver, Popup_ok);
		click(driver, Popup_ok);
		
		System.out.println("Testcase 30 completed");
		
		
		
		
	}
	
}
