package ERO_Optimizer_WHAT_IF_Scripts;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.Utils;

public class TS001_ERO_Optimizer_WHATIF_TC01to14 extends Keywords {
	public void Scenario001(WebDriver driver, ExtentTest test, ExtentTest test1, String url, int dataset) {

		System.out.println("url : " + url);
		String Username = Utils.getDataFromTestData("TS001_EroOptimizer_WHAT_IF_TC01to14", "ERO_Optimizer WHAT_IF",
				"Username");
		String Password = Utils.getDataFromTestData("TS001_EroOptimizer_WHAT_IF_TC01to14", "ERO_Optimizer WHAT_IF",
				"Password");
		String ID = Utils.getDataFromTestData("TS001_EroOptimizer_WHAT_IF_TC01to14", "ERO_Optimizer WHAT_IF", "Id");

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

		Extent_cal(test,
				"Testcase 01 - When Open the new screen,New,Search and close buttons should be in Enable status");

		if (IsElementEnabled(driver, Optimizer_close_tab)) {

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
				"Testcase 02 - Ensure while click new button,Save,cancel and close button should be in enable Status");

		Fluentwait(driver, Optimizer_cancle);
		click(driver, Optimizer_cancle);

		Fluentwait(driver, Optimizer_new);
		click(driver, Optimizer_new);

		Fluentwait(driver, Optimizer_createnew_confirm);
		click(driver, Optimizer_createnew_confirm);

		wait(driver, "5");


		if (IsElementEnabled(driver, Optimizer_cancle)) {

			System.out.println("After clicking the New button, the Cancel button is in enable status");
			Extent_pass(driver, "After clicking the New button, the Cancel button is in enable status", test, test1);

		} else {

			System.out.println("After clicking the New button, the Cancel button is not in enable status");
			Extent_fail(driver, "After clicking the New button, the Cancel button is not in enable status", test,
					test1);
		}

		if (IsElementEnabled(driver, Optimizer_close_tab)) {

			System.out.println("After clicking the New button, the Close tab button is in enable status");
			Extent_pass(driver, "After clicking the New button, the Close tab button is in enable status", test, test1);

		} else {

			System.out.println("After clicking the New button, the Close tab button is not in enable status");
			Extent_fail(driver, "After clicking the New button, the Close tab button is not in enable status", test,
					test1);
		}

		System.out
				.println("//***************************Testcase 2 Completed **************************************//");

		Extent_cal(test,
				"Testcase 03 - Ensure while retrieving record by using global search,new,Edit,search,and close buttons should be in Enable status");

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

		if (IsElementEnabled(driver, Optimizer_close_tab)) {

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

		Fluentwait(driver, Optimizer_Grid_locationfield1);
		click(driver, Optimizer_Grid_locationfield1);

		wait(driver, "5");


		if (IsElementEnabled(driver, Optimizer_close_tab)) {

			System.out.println("After clicking the grid record, the Close tab button is in enable status");
			Extent_pass(driver, "After clicking the grid record, the Close tab button is in enable status", test,
					test1);

		} else {

			System.out.println("After clicking the grid record, the Close tab button is not in enable status");
			Extent_fail(driver, "After clicking the grid record, the Close tab button is not in enable status", test,
					test1);
		}

		System.out
				.println("//***************************Testcase 4 Completed **************************************//");

		Extent_cal(test, "Testcase 06 - Ensure screen enable New, search and close button  when click cancel button");

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

		Fluentwait(driver, Optimizer_Grid_locationfield1);
		click(driver, Optimizer_Grid_locationfield1);

		Fluentwait(driver, Optimizer_cancle);
		doubleClick(driver, Optimizer_cancle);

		wait(driver, "5");

		if (IsElementEnabled(driver, Optimizer_new)) {

			System.out.println(
					"After clicking the Cancel button once edit button is clicked, the New button is in enable status");
			Extent_pass(driver,
					"After clicking the Cancel button once edit button is clicked, the New button is in enable status.",
					test, test1);

		} else {

			System.out.println(
					"After clicking the Cancel button once edit button is clicked, the New button is not in enable status.");
			Extent_fail(driver,
					"After clicking the Cancel button once edit button is clicked, the New button is not in enable status",
					test, test1);
		}

		
		if (IsElementEnabled(driver, Optimizer_close_tab)) {

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
	
		
		Extent_cal(test, "Testcase 7 - Ensure screen enable New, search and close button  when click cancel button");

		Fluentwait(driver, Optimizer_cancle);
		click(driver, Optimizer_cancle);
		
		Fluentwait(driver, Optimizer_new);
		click(driver, Optimizer_new);
		
		Fluentwait(driver, Optimizer_createnew_confirm);
		click(driver, Optimizer_createnew_confirm);
		
		Fluentwait(driver, Optimizer_cancle);
		click(driver, Optimizer_cancle);
		
		if (IsElementEnabled(driver, Optimizer_close_tab)) {

			System.out.println("After click on cancel button new button  is enabled");
			Extent_pass(driver, "After click on cancel button new button  is enabled", test,
					test1);

		} else {

			System.out.println("After click on cancel button new button  is not enabled");
			Extent_fail(driver, "After click on cancel button new button  is not enabled",
					test, test1);
		}
		System.out.println("//***************************Testcase 7 Completed **************************************//");
		
		Extent_cal(test, "Testcase 014 - Ensure screen enable New, search and close button  when click cancel button");

		Fluentwait(driver, Optimizer_close_tab);
		click(driver, Optimizer_close_tab);
		
		if (!IsElementEnabled(driver, Optimizer_close_tab)) {

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
