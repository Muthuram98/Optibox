package ERO_Optimizer_WHAT_IF_Scripts_New;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.Utils;

public class TS01To02ERO_Optimizer_WHAT_IF_Scripts_New extends Keywords {
	public void Scenario1(WebDriver driver, ExtentTest test, ExtentTest test1, String url, int dataset) {

		System.out.println("url : " + url);
		String Username = Utils.getDataFromTestData("TS01_EroOptimizer_WHAT_IF_new_Dataset"+dataset, "ERO_Optimizer WHAT_IF",
				"Username");
		String Password = Utils.getDataFromTestData("TS01_EroOptimizer_WHAT_IF_new_Dataset"+dataset, "ERO_Optimizer WHAT_IF",
				"Password");
		String ID = Utils.getDataFromTestData("TS01_EroOptimizer_WHAT_IF_new_Dataset"+dataset, "ERO_Optimizer WHAT_IF", "Id");
		
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
		Extent_cal(test, "Testcase 01 -Ensure that  Optimizer WHAT – IF Scenario module open properly");

		Fluentwait(driver, Searchbox);
		sendKeys(driver, Searchbox, "Optimizer WHAT – IF Scenario");

		Fluentwait(driver, SelectOptimizer);
		click(driver, SelectOptimizer);

		if (isDisplayed(driver, grid_table)) {
			System.out.println("After clcik the enter ,Optimizer WHAT – IF Scenario page is display ");
			Extent_pass(driver, "After clcik the enter ,Optimizer WHAT – IF Scenario page is display", test, test1);
		} else {
			System.out.println("After clcik the enter ,Optimizer WHAT – IF Scenario page is not display ");
			Extent_fail(driver, "After clcik the enter ,Optimizer WHAT – IF Scenario page is not display", test, test1);
		}

		System.out.println("**********Testcase_1.1**************");

		Extent_cal(test, "Testcase 1.2-Ensure that options get enable when open a screen");

		if (IsElementEnabled(driver, Optimizer_cancle)) {

			System.out.println("After opening Optimizer WHAT IF page , the cancle  button is  enable status");
			Extent_pass(driver, "After opening Optimizer WHAT IF page , the cancle  button is  enable status", test,
					test1);

		} else {

			System.out.println("After opening Optimizer WHAT IF page , the cancle  button is not enable status");
			Extent_fail(driver, "After opening Optimizer WHAT IF page , the cancle  button is not enable status", test,
					test1);
		}
		wait(driver, "2");

		if (IsElementEnabled(driver, Optimizer_Export)) {

			System.out.println("After opening Optimizer WHAT IF page , the Export  button is  enable status");
			Extent_pass(driver, "After opening Optimizer WHAT IF page , the Export  button is  enable status", test,
					test1);

		} else {

			System.out.println("After opening Optimizer WHAT IF page , the Export  button is  not enable status");
			Extent_fail(driver, "After opening Optimizer WHAT IF page , the Export  button is  not enable status", test,
					test1);
		}
		wait(driver, "2");
		if (!IsElementEnabled(driver, Optimizer_new)) {

			System.out.println("After opening Optimizer WHAT IF page , the new  button is in not enable status");
			Extent_pass(driver, "After opening Optimizer WHAT IF page , the new  button is in not enable status", test,
					test1);

		} else {

			System.out.println("After opening Optimizer WHAT IF page , the new  button is in  enable status");
			Extent_fail(driver, "After opening Optimizer WHAT IF page , the new  button is in  enable status", test,
					test1);
		}
		wait(driver, "2");
		if (!IsElementEnabled(driver, Optimizer_save)) {

			System.out.println("After opening Optimizer WHAT IF page , the save  button is in not enable status");
			Extent_pass(driver, "After opening Optimizer WHAT IF page , the save  button is in not enable status", test,
					test1);

		} else {

			System.out.println("After opening Optimizer WHAT IF page , the save  button is in  enable status");
			Extent_fail(driver, "After opening Optimizer WHAT IF page , the save  button is in  enable status", test,
					test1);
		}

		if (!IsElementEnabled(driver, Optimizer_search)) {

			System.out.println("After opening Optimizer WHAT IF page , the search  button is in not enable status");
			Extent_pass(driver, "After opening Optimizer WHAT IF page , the search  button is in not enable status",
					test, test1);

		} else {

			System.out.println("After opening Optimizer WHAT IF page , the search  button is in  enable status");
			Extent_fail(driver, "After opening Optimizer WHAT IF page , the search  button is in  enable status", test,
					test1);
		}
		wait(driver, "2");
		if (!IsElementEnabled(driver, Optimizer_edit1)) {

			System.out.println("After opening Optimizer WHAT IF page , the edit  button is in not enable status");
			Extent_pass(driver, "After opening Optimizer WHAT IF page , the edit button is in not enable status", test,
					test1);

		} else {

			System.out.println("After opening Optimizer WHAT IF page , the edit  button is in  enable status");
			Extent_fail(driver, "After opening Optimizer WHAT IF page , the edit  button is in  enable status", test,
					test1);
		}
		wait(driver, "2");
		if (!IsElementEnabled(driver, OPtimizer_delete)) {

			System.out.println("After opening Optimizer WHAT IF page , the delete button is in not enable status");
			Extent_pass(driver, "After opening Optimizer WHAT IF page , the delete button is in not enable status",
					test, test1);

		} else {

			System.out.println("After opening Optimizer WHAT IF page , the delete  button is in  enable status");
			Extent_fail(driver, "After opening Optimizer WHAT IF page , the delete  button is in  enable status", test,
					test1);
		}
		wait(driver, "2");
		if (!IsElementEnabled(driver, OPtimizer_saveas)) {

			System.out.println("After opening Optimizer WHAT IF page , the Save as button is in not enable status");
			Extent_pass(driver, "After opening Optimizer WHAT IF page , the Save as button is in not enable status",
					test, test1);

		} else {

			System.out.println("After opening Optimizer WHAT IF page , the Save as  button is in  enable status");
			Extent_fail(driver, "After opening Optimizer WHAT IF page , the Save as  button is in  enable status", test,
					test1);
		}

		wait(driver, "2");
		if (!IsElementEnabled(driver, OPtimizer_print)) {

			System.out.println("After opening Optimizer WHAT IF page , the print button is in not enable status");
			Extent_pass(driver, "After opening Optimizer WHAT IF page , the print button is in not enable status", test,
					test1);

		} else {

			System.out.println("After opening Optimizer WHAT IF page , the print  button is in  enable status");
			Extent_fail(driver, "After opening Optimizer WHAT IF page , the print  button is in  enable status", test,
					test1);
		}
		wait(driver, "2");
		if (!IsElementEnabled(driver, OPtimizer_MoveToFirstRecord)) {

			System.out.println(
					"After opening Optimizer WHAT IF page , the Move to First Record button is in not enable status");
			Extent_pass(driver,
					"After opening Optimizer WHAT IF page , the Move to First Record  button is in not enable status",
					test, test1);

		} else {

			System.out.println(
					"After opening Optimizer WHAT IF page , the Move to First Record   button is in  enable status");
			Extent_fail(driver,
					"After opening Optimizer WHAT IF page , the Move to First Record   button is in  enable status",
					test, test1);
		}
		wait(driver, "2");
		if (!IsElementEnabled(driver, OPtimizer_MoveToPrevious_Record)) {

			System.out.println(
					"After opening Optimizer WHAT IF page , the Move to previous Record button is in not enable status");
			Extent_pass(driver,
					"After opening Optimizer WHAT IF page , the Move to previous Record  button is in not enable status",
					test, test1);

		} else {

			System.out.println(
					"After opening Optimizer WHAT IF page , the Move to previous Record   button is in  enable status");
			Extent_fail(driver,
					"After opening Optimizer WHAT IF page , the Move to previous Record   button is in  enable status",
					test, test1);
		}
		wait(driver, "2");
		if (!IsElementEnabled(driver, OPtimizer_MoveToNexrRecord)) {

			System.out.println(
					"After opening Optimizer WHAT IF page , the Move to next Record button is in not enable status");
			Extent_pass(driver,
					"After opening Optimizer WHAT IF page , the Move to next Record  button is in not enable status",
					test, test1);

		} else {

			System.out.println(
					"After opening Optimizer WHAT IF page , the Move to next Record   button is in  enable status");
			Extent_fail(driver,
					"After opening Optimizer WHAT IF page , the Move to next Record   button is in  enable status",
					test, test1);
		}

		wait(driver, "2");
		if (!IsElementEnabled(driver, OPtimizer_MoveToLastRecord)) {

			System.out.println(
					"After opening Optimizer WHAT IF page , the Move to last Record button is in not enable status");
			Extent_pass(driver,
					"After opening Optimizer WHAT IF page , the Move to last Record  button is in not enable status",
					test, test1);

		} else {

			System.out.println(
					"After opening Optimizer WHAT IF page , the Move to last Record   button is in  enable status");
			Extent_fail(driver,
					"After opening Optimizer WHAT IF page , the Move to last Record   button is in  enable status",
					test, test1);
		}
		wait(driver, "2");
		if (!IsElementEnabled(driver, OPtimizer_Magicsave)) {

			System.out.println("After opening Optimizer WHAT IF page , the Magic Save button is in not enable status");
			Extent_pass(driver,
					"After opening Optimizer WHAT IF page , the Magic Save   button is in not enable status", test,
					test1);

		} else {

			System.out.println("After opening Optimizer WHAT IF page , the Magic Save    button is in  enable status");
			Extent_fail(driver, "After opening Optimizer WHAT IF page , the Magic Save    button is in  enable status",
					test, test1);
		}

		System.out.println("**********Testcase_1.2**************");

		Extent_cal(test, "Testcase 2.1-Ensure that fields avialable in Optimizer WHAT – IF Scenario");
		wait(driver, "2");
		if (isDisplayed(driver, Optimizer_IDField)) {
			System.out.println("After navigating to Optimizer WHAT IF page, ID filed is available");
			Extent_pass(driver, "After navigating to Optimizer WHAT IF page, ID filed is available", test, test1);
		} else {
			System.out.println("After navigating to Optimizer WHAT IF page, ID filed is not available");
			Extent_fail(driver, "After navigating to Optimizer WHAT IF page, ID filed is not available", test, test1);
		}
		wait(driver, "2");
		if (isDisplayed(driver, OPtimizer_refreshResult)) {
			System.out.println("After navigating to Optimizer WHAT IF page, Refresh result filed is available");
			Extent_pass(driver, "After navigating to Optimizer WHAT IF page, Refresh result filed is available", test, test1);
		} else {
			System.out.println("After navigating to Optimizer WHAT IF page, Refresh result filed is not available");
			Extent_fail(driver, "After navigating to Optimizer WHAT IF page, Refresh result filed is not available", test, test1);
		}
		
		wait(driver, "2");
		if (isDisplayed(driver, OPtimizer_all)) {
			System.out.println("After navigating to Optimizer WHAT IF page, All filed is available");
			Extent_pass(driver, "After navigating to Optimizer WHAT IF page, All filed is available", test, test1);
		} else {
			System.out.println("After navigating to Optimizer WHAT IF page, All filed is not available");
			Extent_fail(driver, "After navigating to Optimizer WHAT IF page, All filed is not available", test, test1);
		}
		
		wait(driver, "2");
		if (isDisplayed(driver, OPtimizer_20s)) {
			System.out.println("After navigating to Optimizer WHAT IF page, 20s filed is available");
			Extent_pass(driver, "After navigating to Optimizer WHAT IF page, 20s filed is available", test, test1);
		} else {
			System.out.println("After navigating to Optimizer WHAT IF page, 20s filed is not available");
			Extent_fail(driver, "After navigating to Optimizer WHAT IF page, 20s filed is not available", test, test1);
		}
			
		wait(driver, "2");
		if (isDisplayed(driver, OPtimizer_40s)) {
			System.out.println("After navigating to Optimizer WHAT IF page, 40s filed is available");
			Extent_pass(driver, "After navigating to Optimizer WHAT IF page, 40s filed is available", test, test1);
		} else {
			System.out.println("After navigating to Optimizer WHAT IF page, 40s filed is not available");
			Extent_fail(driver, "After navigating to Optimizer WHAT IF page, 40s filed is not available", test, test1);
		}	
		
		wait(driver, "2");
		if (isDisplayed(driver, OPtimizer_sizeStpe)) {
			System.out.println("After navigating to Optimizer WHAT IF page, Size type filed is available");
			Extent_pass(driver, "After navigating to Optimizer WHAT IF page,Size type filed is available", test, test1);
		} else {
			System.out.println("After navigating to Optimizer WHAT IF page, Size type filed is not available");
			Extent_fail(driver, "After navigating to Optimizer WHAT IF page,Size type filed is not available", test, test1);
		}		
		
		System.out.println("**********Testcase_2.1**************");
	
		Extent_cal(test, "Testcase 2.2-Ensure that all fields and button are accessible when id is not selected");
		wait(driver, "2");
		
		if (!IsElementEnabled(driver, OPtimizer_all)) {
			System.out.println("Fields All are not accessible without entering an ID");
			Extent_pass(driver, "Fields All are not accessible without entering an ID", test, test1);
			
		} else {
			System.out.println("FieldsAll  accessible without entering an ID");
			Extent_fail(driver, "Fields All are  accessible without entering an ID", test, test1);
		}
		
       wait(driver, "2");
		
		if (!IsElementEnabled(driver, OPtimizer_20s)) {
			System.out.println("Fields 20S are not accessible without entering an ID");
			Extent_pass(driver, "Fields 20S are not accessible without entering an ID", test, test1);
			
		} else {
			System.out.println("Fields 20S are  accessible without entering an ID");
			Extent_fail(driver, "Fields 20Sare  accessible without entering an ID", test, test1);
		}
		wait(driver,"2");
		if (!IsElementEnabled(driver, OPtimizer_40s)) {
			System.out.println("Fields 40S are not accessible without entering an ID");
			Extent_pass(driver, "Fields 40S are not accessible without entering an ID", test, test1);
			
		} else {
			System.out.println("Fields 40S are  accessible without entering an ID");
			Extent_fail(driver, "Fields 40S are  accessible without entering an ID", test, test1);
		}
		
		wait(driver,"2");
		if (!IsElementEnabled(driver, OPtimizer_refreshResult)) {
			System.out.println("Refresh result button are not accessible without entering an ID");
			Extent_pass(driver, "Refresh result button are not accessible without entering an ID", test, test1);
			
		} else {
			System.out.println("Refresh result button are  accessible without entering an ID");
			Extent_fail(driver, "Refresh result button are  accessible without entering an ID", test, test1);
		}	
		
		wait(driver,"2");
		if (!IsElementEnabled(driver, OPtimizer_option)) {
			System.out.println("Optimizer button are not accessible without entering an ID");
			Extent_pass(driver, "Optimizer button are not accessible without entering an ID", test, test1);
			
		} else {
			System.out.println("Optimizer button are  accessible without entering an ID");
			Extent_fail(driver, "Optimizer button are  accessible without entering an ID", test, test1);
		}	
		System.out.println("**********Testcase_2.2**************");
		
		Extent_cal(test, "Testcase 2.4-Ensure that id field search option is accessible");	
		
		Fluentwait(driver, Optimizer_Globalserach);
		click(driver, Optimizer_Globalserach);
		
		Fluentwait(driver, Globalserach_IDInput);
		sendKeys(driver, Globalserach_IDInput, ID);

		wait(driver, "2");

		Fluentwait(driver, Click_Search);
		click(driver, Click_Search);


		wait(driver, "7");
		if (isDisplayed(driver, SelectID)) {
			System.out.println("After navigating to Optimizer WHAT IF page, id field search option is accessible");
			Extent_pass(driver, "After navigating to Optimizer WHAT IF page, id field search option is accessible", test, test1);
		} else {
			System.out.println("After navigating to Optimizer WHAT IF page, id field search option is not  accessible");
			Extent_fail(driver, "After navigating to Optimizer WHAT IF page, id field search option is not accessible", test, test1);
		}
		wait(driver, "5");	
		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);
		
		System.out.println("**********Testcase_2.4**************");
		
		Extent_cal(test, "Testcase 2.3-Ensure that id field allow manual entry ");	
		
		wait(driver, "5");	
		String Id_val= getAttribute(driver, Optimizer_IDField,"value");
		System.out.println("Id_val :"+Id_val);
		
		
		sendKeys(driver, Optimizer_IDField, "123");
		
		String Id_val1= getAttribute(driver, Optimizer_IDField,"value");
		System.out.println("Id_val :"+Id_val1);
		
		if(Id_val1.equals(Id_val)) {
			System.out.println("After navigating to Optimizer WHAT IF page, Manually Id  field  option is not accessible");
			Extent_pass(driver, "After navigating to Optimizer WHAT IF page, Manually Id  field  option is not accessible", test, test1);
		}else {
			System.out.println("After navigating to Optimizer WHAT IF page, Manually Id  field  option is not accessible");
			Extent_fail(driver, "After navigating to Optimizer WHAT IF page, Manually Id  field  option is not accessible", test, test1);
		}
		
		System.out.println("**********Testcase_2.3**************");
		
	}
}