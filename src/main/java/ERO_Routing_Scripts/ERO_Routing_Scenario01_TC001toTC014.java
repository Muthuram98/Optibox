package ERO_Routing_Scripts;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.Utils;

public class ERO_Routing_Scenario01_TC001toTC014 extends Keywords {

	public void ERO_Scenario1(WebDriver driver, ExtentTest test, ExtentTest test1, String url, int dataset) {

		String Username = Utils.getDataFromTestData("TS001_EroRouting_TC01to14_Dataset" + dataset, "ERO Routing",
				"Username");
		String Password = Utils.getDataFromTestData("TS001_EroRouting_TC01to14_Dataset" + dataset, "ERO Routing",
				"Password");
		String ID = Utils.getDataFromTestData("TS001_EroRouting_TC01to14_Dataset" + dataset, "ERO Routing", "Id");

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

		Extent_cal(test, "Testcase 01 - When Open the new screen, Search and close buttons should be in Enable status");

		if (IsElementEnabled(driver, Routing_GlobalSearch)) {

			System.out.println("After opening the new screen, the Global search button is in enable status");
			Extent_pass(driver, "After opening the new screen, the Global search button is in enable status", test,
					test1);

		} else {

			System.out.println("After opening the new screen, the Global search button is not in enable status");
			Extent_fail(driver, "After opening the new screen, the Global search button is not in enable status", test,
					test1);
		}

		if (IsElementEnabled(driver, Close_routing)) {

			System.out.println("After opening the new screen, the Close tab button is in enable status");
			Extent_pass(driver, "fter opening the new screen, the Close tab button is in enable status", test, test1);

		} else {

			System.out.println("After opening the new screen, the Close tab button is not in enable status");
			Extent_fail(driver, "After opening the new screen, the Close tab button is not in enable status", test,
					test1);
		}

		System.out
				.println("//***************************Testcase 1 Completed **************************************//");

		Extent_cal(test,
				"Testcase 03 - Ensure while retrieving record by using global search,new,Edit,search,and close buttons should be in Enable status");

		Fluentwait(driver, Routing_GlobalSearch);
		click(driver, Routing_GlobalSearch);

		Fluentwait(driver, Globalserach_IDInput);
		sendKeys(driver, Globalserach_IDInput, ID);

		wait(driver, "2");

		Fluentwait(driver, Click_Search);
		click(driver, Click_Search);

		wait(driver, "5");

		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);

		wait(driver, "5");

		if (isDisplayed(driver, ERO_popup_ok)) {

			click(driver, ERO_popup_ok);
		}

		if (IsElementEnabled(driver, Routing_Edit)) {

			System.out.println("After retrieving the record using global search, Edit button is enabled");
			Extent_pass(driver, "After retrieving the record using global search, Edit button is enabled", test, test1);

		} else {

			System.out.println("After retrieving the record using global search, Edit button is enabled");
			Extent_fail(driver, "After retrieving the record using global search, Edit button is enabled", test, test1);
		}

		if (IsElementEnabled(driver, Close_routing)) {

			System.out.println("After retrieving the record using global search, Close tab button is enabled");
			Extent_pass(driver, "After retrieving the record using global search, Close tab button is enabled", test,
					test1);

		} else {

			System.out.println("After retrieving the record using global search, Close tab button is not enabled");
			Extent_fail(driver, "After retrieving the record using global search, Close tab button is not enabled",
					test, test1);
		}

		System.out
				.println("//***************************Testcase 3 Completed **************************************//");

		Extent_cal(test,
				"Testcase 04 - Ensure While click grid record, new,Edit and Search and close buttons should be in enable status");

		Fluentwait(driver, Origin_1);
		click(driver, Origin_1);

		wait(driver, "5");

		if (IsElementEnabled(driver, Routing_Edit)) {

			System.out.println("After clicking the grid record, the Edit button is in enable status");
			Extent_pass(driver, "After clicking the grid record, the Edit button is in enable status", test, test1);

		} else {

			System.out.println("After clicking the grid record, the Edit button is not in enable status");
			Extent_fail(driver, "After clicking the grid record, the Edit button is not in enable status", test, test1);
		}

		if (IsElementEnabled(driver, Close_routing)) {

			System.out.println("After clicking the grid record, the Close tab button is in enable status");
			Extent_pass(driver, "After clicking the grid record, the Close tab button is in enable status", test,
					test1);

		} else {

			System.out.println("After clicking the grid record, the Close tab button is in enable status");
			Extent_fail(driver, "After clicking the grid record, the Close tab button is in enable status", test,
					test1);
		}

		System.out
				.println("//***************************Testcase 4 Completed **************************************//");

		Extent_cal(test,
				"Testcase 05 - Ensure screen enable save , cancel , close and search button while click Edit buttion");

		Fluentwait(driver, Routing_Edit);
		click(driver, Routing_Edit);

		wait(driver, "5");

		if (IsElementEnabled(driver, Routing_Save)) {

			System.out.println("After clicking the Edit button, the Save button is in enable status");
			Extent_pass(driver, "After clicking the Edit button, the Save button is in enable status", test, test1);

		} else {

			System.out.println("After clicking the Edit button, the Save button is not in enable status");
			Extent_fail(driver, "After clicking the Edit button, the Save button is not in enable status", test, test1);
		}

		if (IsElementEnabled(driver, Routing_Cancel)) {

			System.out.println("After clicking the Edit button, the Cancel button is in enable status");
			Extent_pass(driver, "After clicking the Edit button, the Cancel button is in enable status", test, test1);

		} else {

			System.out.println("After clicking the Edit button, the Cancel button is not in enable status");
			Extent_fail(driver, "After clicking the Edit button, the Cancel button is not in enable status", test,
					test1);
		}

		if (IsElementEnabled(driver, Close_routing)) {

			System.out.println("After clicking the Edit button, the Close tab button is in enable status");
			Extent_pass(driver, "After clicking the Edit button, the Close tab button is in enable status", test,
					test1);

		} else {

			System.out.println("After clicking the Edit button, the Close tab button is not in enable status");
			Extent_fail(driver, "After clicking the Edit button, the Close tab button is not in enable status", test,
					test1);
		}

		System.out
				.println("//***************************Testcase 5 Completed **************************************//");

		Extent_cal(test, "Testcase 06 - Ensure screen enable New, search and close button  when click cancel button");

		Fluentwait(driver, Routing_Cancel);
		click(driver, Routing_Cancel);

		wait(driver, "5");

		if (IsElementEnabled(driver, Close_routing)) {

			System.out.println(
					"After clicking the Cancel button once edit button is clicked, the Close tab button is in enable status");
			Extent_pass(driver,
					"After clicking the Cancel button once edit button is clicked, the Close tab button is in enable status",
					test, test1);

		} else {

			System.out.println(
					"After clicking the Cancel button once edit button is clicked, the Close tab button is not in enable status");
			Extent_fail(driver,
					"After clicking the Cancel button once edit button is clicked, the Close tab button is not in enable status",
					test, test1);
		}

		System.out
				.println("//***************************Testcase 6 Completed **************************************//");

		Extent_cal(test,
				"Testcase 08 - Ensure Screen enable  New, edit , search and close button  when click Search button");

		waitForElement(driver, Close_ero_routing_tab);
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

		wait(driver, "2");

		Fluentwait(driver, Click_Search);
		click(driver, Click_Search);

		wait(driver, "5");

		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);

		wait(driver, "5");

		if (isDisplayed(driver, ERO_popup_ok)) {

			click(driver, ERO_popup_ok);
		}

		if (IsElementEnabled(driver, Routing_Edit)) {

			System.out.println("After retrieving the record using global search, Edit button is enabled");
			Extent_pass(driver, "After retrieving the record using global search, Edit button is enabled", test, test1);

		} else {

			System.out.println("After retrieving the record using global search, Edit button is not enabled");
			Extent_fail(driver, "After retrieving the record using global search, Edit button is not enabled", test,
					test1);
		}

		System.out.println("Testcase 08 completed");

		Extent_cal(test, "Testcase 14 - Ensure System should close the screen,when click close button");

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

	}

}
