package ERO_Optimizer_WHAT_IF_Scripts;

import java.util.Set;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.Utils;

public class TS012_ERO_Optimizer_WHATIF_TC213to253 extends Keywords {
	public void Scenario12(WebDriver driver, ExtentTest test, ExtentTest test1, String url, int dataset) throws Exception {

		String Username = Utils.getDataFromTestData("TS12_EroOptimizer_WHAT_IF", "ERO_Optimizer WHAT_IF", "Username");
		String Password = Utils.getDataFromTestData("TS12_EroOptimizer_WHAT_IF", "ERO_Optimizer WHAT_IF", "Password");
		String ID = Utils.getDataFromTestData("TS12_EroOptimizer_WHAT_IF", "ERO_Optimizer WHAT_IF", "Id");
		String Popup = Utils.getDataFromTestData("TS12_EroOptimizer_WHAT_IF", "ERO_Optimizer WHAT_IF",
				"New_Confirmation_popup");
		String ref_Popup = Utils.getDataFromTestData("TS12_EroOptimizer_WHAT_IF", "ERO_Optimizer WHAT_IF",
				"Refresh pop");
		String search_id = Utils.getDataFromTestData("TS12_EroOptimizer_WHAT_IF", "ERO_Optimizer WHAT_IF","Search_Id");
		
		

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
		Extent_cal(test, "Testcase 213 - Ensure in new button functionality  ");

		Fluentwait(driver, Searchbox);
		sendKeys(driver, Searchbox, "Optimizer WHAT – IF Scenario");

		Fluentwait(driver, SelectOptimizer);
		click(driver, SelectOptimizer);
		wait(driver, "5");

		Fluentwait(driver, Optimizer_cancle);
		click(driver, Optimizer_cancle);

		Fluentwait(driver, Optimizer_new);
		click(driver, Optimizer_new);

		wait(driver, "2");
		String pop = getText(driver, Optimizer_createnew_confirm_message);

		if (pop.equals(Popup)) {
			Extent_pass(driver, "Confirmation popup for create new record was displayed", test, test1);
			Extent_pass(driver, "Expected popup message was : " + Popup + " || Actual popup message was : " + pop, test,
					test1);
		} else {
			Extent_fail(driver, "Confirmation popup for create new record was not displayed", test, test1);
			Extent_fail(driver, "Expected popup message was : " + Popup + " || Actual popup message was : " + pop, test,
					test1);
		}

		Fluentwait(driver, OPtimizer_new_confirm_no);
		click(driver, OPtimizer_new_confirm_no);

		System.out.println("************************Testcase 213 Completed **********************");

		Extent_cal(test, "Testcase 214 - Ensure in new button functionality, when click on Yes button  ");

		Fluentwait(driver, Optimizer_new);
		click(driver, Optimizer_new);
		wait(driver, "2");
		String pop1 = getText(driver, Optimizer_createnew_confirm_message);

		if (pop1.equals(Popup)) {
			Extent_pass(driver, "Confirmation popup for create new record was displayed", test, test1);
			Extent_pass(driver, "Expected popup message was : " + Popup + " || Actual popup message was : " + pop1,
					test, test1);
		} else {
			Extent_fail(driver, "Confirmation popup for create new record was not displayed", test, test1);
			Extent_fail(driver, "Expected popup message was : " + Popup + " || Actual popup message was : " + pop1,
					test, test1);
		}
		Fluentwait(driver, Optimizer_createnew_confirm);
		click(driver, Optimizer_createnew_confirm);

		wait(driver, "2");
		if (IsElementEnabled(driver, Optimizer_Export)) {

			System.out.println("After opening the new screen, the export button is in enable status");
			Extent_pass(driver, "After opening the new screen, the export button is in enable status", test, test1);

		} else {

			System.out.println("After opening the new screen, the export button is not in enable status");
			Extent_fail(driver, "After opening the new screen, the export button is not in enable status", test, test1);
		}

		wait(driver, "2");
		if (IsElementEnabled(driver, Optimizer_cancle)) {

			System.out.println("After opening the new screen, the cancle button is in enable status");
			Extent_pass(driver, "After opening the new screen, the cancle button is in enable status", test, test1);

		} else {

			System.out.println("After opening the new screen, the cancle button is not in enable status");
			Extent_fail(driver, "After opening the new screen, the cancle button is not in enable status", test, test1);
		}

		System.out.println("************************Testcase 214 Completed **********************");

		Extent_cal(test, "Testcase 215 - Ensure in rule imbalance text field ");

		Fluentwait(driver, Searchbox);
		sendKeys(driver, Searchbox, "Ero Rule Builder");

		Fluentwait(driver, Rulebuilder);
		click(driver, Rulebuilder);

		waitForElement(driver, EMS_Formula);
		String EmsFormula = getText(driver, EMS_Formula);

		System.out.println("EmsFormula : " + EmsFormula);

		if (EmsFormula.equals("#IMPORT#-#EXPORT#")) {

			System.out.println("Rule imbalance formula was displayed");
			Extent_pass(driver, "Rule imbalance formula was displayed", test, test1);
		} else {

			System.out.println("Rule imbalance formula was not displayed");
			Extent_fail(driver, "Rule imbalance formula was not displayed", test, test1);
		}

		if (!isClear(driver, EMS_Formula)) {

			System.out.println("Unable to edit the Ems rule imbalance formula");
			Extent_pass(driver, "Unable to edit the Ems rule imbalance formula", test, test1);

		} else {

			System.out.println("User can able to edit the Ems rule imbalance formula");
			Extent_fail(driver, "User can able to edit the Ems rule imbalance formula", test, test1);
		}

		System.out.println("***************Testcase 215 Completed******************");

		Extent_cal(test, "216 Ensure in export excel button functionality (with out records) ");

		Fluentwait(driver, close_2);
		click(driver, close_2);
		
		click(driver, Optimizer_Globalserach);

		Fluentwait(driver, Globalserach_IDInput);
		sendKeys(driver, Globalserach_IDInput, ID);

		wait(driver, "2");

		Fluentwait(driver, Click_Search);
		click(driver, Click_Search);

		wait(driver, "5");

		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);

		wait(driver, "7");

		String Filename = "Optimizer WHAT – IF Scenario";

		deleteFiles(Filename);

		Set<String> oldFiles = getDirectoryFiles();

		wait(driver, "5");

		Fluentwait(driver, Optimizermain_Tree_table);
		click(driver, Optimizermain_Tree_table);

		Fluentwait(driver, Optimizer_Excel_Fi);
		click(driver, Optimizer_Excel_Fi);

		wait(driver, "10");

		String baseFilename = "Optimizer WHAT – IF Scenario.xlsx";

		boolean isDownloaded = isNewFileDownloaded(oldFiles, baseFilename);

		if (isDownloaded == true) {

			System.out.println("New excel file is downloaded in the downloads folder");
			Extent_pass(driver, "New excel file is downloaded in the downloads folder", test, test1);

		} else {
			System.out.println("New excel file is not downloaded");
			Extent_fail(driver, "New excel file is not downloaded", test, test1);
		}

		System.out.println("Is file downloaded: " + isDownloaded);

		System.out.println("************************Testcase 216 Completed **********************");

		Extent_cal(test, "233 Ensure in Refresh button functionality ");

		Fluentwait(driver, Refresh_result);
		click(driver, Refresh_result);
		wait(driver, "5");
		String refresh = getText(driver, refresh_text);
		System.out.println("refresh :" + refresh);

		if (refresh.equals(ref_Popup)) {
			System.out
					.println("Matched || Expected popup message : " + ref_Popup + " Actual popup message : " + refresh);
			Extent_pass(driver,
					"Matched || Expected popup message : " + ref_Popup + " Actual popup message : " + refresh, test,
					test1);
		} else {
			System.out.println(
					"Not Matched || Expected popup message : " + ref_Popup + " Actual popup message : " + refresh);
			Extent_fail(driver,
					"Not Matched || Expected popup message : " + ref_Popup + " Actual popup message : " + refresh, test,
					test1);
		}
		Fluentwait(driver, warning_sym_ok);
		click(driver, warning_sym_ok);

		System.out.println("***********Testcase 233 Completed ***************");

		Extent_cal(test, "234 Ensure in Refresh button functionality with yes button ");

		Fluentwait(driver, Refresh_result);
		click(driver, Refresh_result);
		wait(driver, "5");
		String refresh1 = getText(driver, refresh_text);
		System.out.println("refresh :" + refresh1);

		if (refresh1.equals(ref_Popup)) {
			System.out.println(
					"Matched || Expected popup message : " + ref_Popup + " Actual popup message : " + refresh1);
			Extent_pass(driver,
					"Matched || Expected popup message : " + ref_Popup + " Actual popup message : " + refresh1, test,
					test1);
		} else {
			System.out.println(
					"Not Matched || Expected popup message : " + ref_Popup + " Actual popup message : " + refresh1);
			Extent_fail(driver,
					"Not Matched || Expected popup message : " + ref_Popup + " Actual popup message : " + refresh1,
					test, test1);
		}
		Fluentwait(driver, warning_sym_ok);
		click(driver, warning_sym_ok);

		if (IsElementEnabled(driver, Optimizer_field)) {

			System.out.println("After click on  refresh result screen, the optimizer button is in enable status");
			Extent_pass(driver, "After click on  refresh result screen, the optimizer button is in enable status", test,
					test1);

		} else {

			System.out.println("After click on  refresh result screen, the optimizer button is in not enable status");
			Extent_fail(driver, "After click on  refresh result screen, the optimizer button is in not enable status",
					test, test1);
		}
		System.out.println("***********Testcase 234 Completed ***************");

		Extent_cal(test, "Testcase 235- Ensure in Global search button functionality ");

		Fluentwait(driver, Optimizer_cancle);
		click(driver, Optimizer_cancle);

		Fluentwait(driver, Optimizer_new);
		click(driver, Optimizer_new);
		Fluentwait(driver, Optimizer_createnew_confirm);
		click(driver, Optimizer_createnew_confirm);

		click(driver, Optimizer_Globalserach);

		Fluentwait(driver, Globalserach_IDInput);
		sendKeys(driver, Globalserach_IDInput, search_id);

		wait(driver, "2");

		Fluentwait(driver, Click_Search);
		click(driver, Click_Search);

		wait(driver, "5");

		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);

		wait(driver, "7");
		wait(driver, "3");
		String id_value = getAttribute(driver, Optimizer_id_filed, "value");
		System.out.println(id_value);
		wait(driver, "2");

		if (id_value.equals(search_id)) {
			System.out.println("Matched || Expected After navigated searched records was displayed: "+ search_id + " Actual  After navigated searched records was displayed : "+ id_value);
			Extent_pass(driver,
					"Matched ||Expected After navigated searched records  was displayed : "+ search_id + " Actual After navigated searched records was displayed: "+ id_value,test,test1);
		} else {
			System.out.println("Not Matched ||After navigated searched records was  not displayed: " + search_id+ " After navigated searched records was  not displayed  : " + id_value);
			Extent_fail(driver,"Not Matched ||After navigated searched records was  not displayed: " + search_id+ " Actual After navigated searched records was  not displayed : " + id_value,test,test1);
		}

		System.out.println("*****************235**************");
		
		Extent_cal(test, "Testcase 236- Ensure in Cancel button functionality  ");	
		
		Fluentwait(driver, Optimizer_close_tab);
		click(driver, Optimizer_close_tab);
		
		
		Fluentwait(driver, Searchbox);
		sendKeys(driver, Searchbox, "Optimizer WHAT – IF Scenario");
	
		wait(driver, "2");
		Fluentwait(driver, SelectOptimizer);
		click(driver, SelectOptimizer);
		wait(driver, "5");

		wait(driver, "2");
		Fluentwait(driver, Optimizer_cancle);
		click(driver, Optimizer_cancle);

		wait(driver, "5");
		//takescreenshot(driver, "/Expected_screenshot/Optimizer/Optimizer_WHAT_IF_homePage");

		takescreenshot(driver, "/Actual_screenshot/Optimizer/Optimizer_WHAT_IF_homePage");

		try {
			boolean chartDiff = imageComparison2(driver, "/Optimizer/Optimizer_WHAT_IF_homePage", "/Optimizer/Optimizer_WHAT_IF_homePage");
			wait(driver, "2");
			if (chartDiff == true) {
				Extent_pass(driver, "Home page is displayed in default view", test,test1);

			} else {
				Extent_fail(driver, "Home page is  not displayed in default view", test,test1);
			}
		} catch (Exception e1) {
			Extent_fail(driver, "Unable to compare the Images for Optimizer WHAT IF home page", test,test1);
		}

		System.out.println("******************236***************");
		
		Extent_cal(test, "Testcase 245- Ensure in Cancel button functionality  ");		
		
		Fluentwait(driver, Optimizer_new);
		click(driver, Optimizer_new);
		Fluentwait(driver, Optimizer_createnew_confirm);
		click(driver, Optimizer_createnew_confirm);
		
		click(driver, Optimizer_Globalserach);

		Fluentwait(driver, Globalserach_IDInput);
		sendKeys(driver, Globalserach_IDInput, ID);

		wait(driver, "2");

		Fluentwait(driver, Click_Search);
		click(driver, Click_Search);

		wait(driver, "5");

		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);
		wait(driver,"4");
		
		click(driver,Optimizer_surplus_location);
		
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver,EPO_SelectFilterOption);
		
		Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver,EPO_SelectFilterSearchBox);
		
		Fluentwait(driver, Optimizer_First_val);
		click(driver,Optimizer_First_val);
		if (isDisplayed(driver, Optimizer_First_val)) {
			System.out.println("After click on Filter option Filter button is working  ");
			Extent_pass(driver, "After click on Filter option Filter button is working ", test, test1);
		} else {

			System.out.println("After click on Filter option Filter button is not working ");
			Extent_fail2(driver, "After click on Filter option Filter button is not working", test);
		}
		Fluentwait(driver, Optimizer_First_val);
		click(driver, Optimizer_First_val);
		
		Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver,EPO_SelectFilterSearchBox);
		
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		
		
		wait(driver,"3");
        click(driver,Optimizer_surplus_Count);
			
		Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver,EPO_SelectFilterSearchBox);
		
		Fluentwait(driver, Optimizer_First_val);
		click(driver,Optimizer_First_val);
		if (isDisplayed(driver, Optimizer_First_val)) {
			System.out.println("After click on Filter option Filter button is working  ");
			Extent_pass(driver, "After click on Filter option Filter button is working ", test, test1);
		} else {

			System.out.println("After click on Filter option Filter button is not working ");
			Extent_fail2(driver, "After click on Filter option Filter button is not working", test);
		}
		Fluentwait(driver, Optimizer_First_val);
		click(driver, Optimizer_First_val);
		
		Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver,EPO_SelectFilterSearchBox);
		
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		
		wait(driver,"3");
		Fluentwait(driver, Optimizer_deficit_location);
        click(driver,Optimizer_deficit_location);
		
        Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver,EPO_SelectFilterSearchBox);
		
		Fluentwait(driver, Optimizer_First_val);
		click(driver,Optimizer_First_val);
		if (isDisplayed(driver, Optimizer_First_val)) {
			System.out.println("After click on Filter option Filter button is working  ");
			Extent_pass(driver, "After click on Filter option Filter button is working ", test, test1);
		} else {

			System.out.println("After click on Filter option Filter button is not working ");
			Extent_fail2(driver, "After click on Filter option Filter button is not working", test);
		}
		Fluentwait(driver, Optimizer_First_val);
		click(driver, Optimizer_First_val);
		
		Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver,EPO_SelectFilterSearchBox);
		
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		
		wait(driver,"3");
        click(driver,Optimizer_deficit_Count);
		
        Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver,EPO_SelectFilterSearchBox);
		
		Fluentwait(driver, Optimizer_First_val);
		click(driver,Optimizer_First_val);
		if (isDisplayed(driver, Optimizer_First_val)) {
			System.out.println("After click on Filter option Filter button is working  ");
			Extent_pass(driver, "After click on Filter option Filter button is working ", test, test1);
		} else {

			System.out.println("After click on Filter option Filter button is not working ");
			Extent_fail2(driver, "After click on Filter option Filter button is not working", test);
		}
		Fluentwait(driver, Optimizer_First_val);
		click(driver, Optimizer_First_val);
		
		Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver,EPO_SelectFilterSearchBox);
		
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		
		
		wait(driver,"3");
        click(driver,Optimizer_result);
		
        Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver,EPO_SelectFilterSearchBox);
		
		Fluentwait(driver, Optimizer_First_val);
		click(driver,Optimizer_First_val);
		if (isDisplayed(driver, Optimizer_First_val)) {
			System.out.println("After click on Filter option Filter button is working  ");
			Extent_pass(driver, "After click on Filter option Filter button is working ", test, test1);
		} else {

			System.out.println("After click on Filter option Filter button is not working ");
			Extent_fail2(driver, "After click on Filter option Filter button is not working", test);
		}
		Fluentwait(driver, Optimizer_First_val);
		click(driver, Optimizer_First_val);
		
		Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver,EPO_SelectFilterSearchBox);
		
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		
		wait(driver,"3");
        click(driver,Optimizer_allocate_container);
		
        Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver,EPO_SelectFilterSearchBox);
		
		Fluentwait(driver, Optimizer_First_val);
		click(driver,Optimizer_First_val);
		if (isDisplayed(driver, Optimizer_First_val)) {
			System.out.println("After click on Filter option Filter button is working  ");
			Extent_pass(driver, "After click on Filter option Filter button is working ", test, test1);
		} else {

			System.out.println("After click on Filter option Filter button is not working ");
			Extent_fail2(driver, "After click on Filter option Filter button is not working", test);
		}
		Fluentwait(driver, Optimizer_First_val);
		click(driver, Optimizer_First_val);
		
		Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver,EPO_SelectFilterSearchBox);
		
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		
		wait(driver,"3");
        click(driver,Optimizer_size_type);
		
        Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver,EPO_SelectFilterSearchBox);
		
		Fluentwait(driver, Optimizer_First_val);
		click(driver,Optimizer_First_val);
		if (isDisplayed(driver, Optimizer_First_val)) {
			System.out.println("After click on Filter option Filter button is working  ");
			Extent_pass(driver, "After click on Filter option Filter button is working ", test, test1);
		} else {

			System.out.println("After click on Filter option Filter button is not working ");
			Extent_fail2(driver, "After click on Filter option Filter button is not working", test);
		}
		Fluentwait(driver, Optimizer_First_val);
		click(driver, Optimizer_First_val);
		
		Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver,EPO_SelectFilterSearchBox);
		
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		
		wait(driver,"3");
        click(driver,Optimizer_cost_unit);
		
        Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver,EPO_SelectFilterSearchBox);
		
		Fluentwait(driver, Optimizer_First_val);
		click(driver,Optimizer_First_val);
		if (isDisplayed(driver, Optimizer_First_val)) {
			System.out.println("After click on Filter option Filter button is working  ");
			Extent_pass(driver, "After click on Filter option Filter button is working ", test, test1);
		} else {

			System.out.println("After click on Filter option Filter button is not working ");
			Extent_fail2(driver, "After click on Filter option Filter button is not working", test);
		}
		Fluentwait(driver, Optimizer_First_val);
		click(driver, Optimizer_First_val);
		
		Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver,EPO_SelectFilterSearchBox);
		
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		
		System.out.println("******************245***************");
		
		Extent_cal(test, "Testcase 246- Ensure in Filter OFF button Functionality   ");		
		
		Fluentwait(driver, Optimizer_Tree_table);
		click(driver, Optimizer_Tree_table);
		
		Fluentwait(driver, OPtimizer_condition_filter);
		click(driver, OPtimizer_condition_filter);
		

		Fluentwait(driver, Optimizer_Tree_table);
		click(driver, Optimizer_Tree_table);
		
		Fluentwait(driver, Optimizer_Distint_filter);
		click(driver, Optimizer_Distint_filter);
		wait(driver,"2");
		if (!isDisplayed(driver, surplus_location_input_Filed)) {

			System.out.println("Filter turned off");
			Extent_pass(driver, "Filter turn off button functionality is working fine", test,test1);

		} else {

			System.out.println("Filter turned off");
			Extent_fail(driver, "Filter turn off button functionality is not working", test,test1);

		}
		
		System.out.println("******************testcase 246***************");
		
		
		
		
		
	}
}