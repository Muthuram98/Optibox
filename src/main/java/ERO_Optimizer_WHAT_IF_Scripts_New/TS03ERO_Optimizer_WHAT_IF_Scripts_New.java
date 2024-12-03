package ERO_Optimizer_WHAT_IF_Scripts_New;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.SendKeys;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.Utils;

public class TS03ERO_Optimizer_WHAT_IF_Scripts_New extends Keywords {

	public void Scenario3(WebDriver driver, ExtentTest test, ExtentTest test1, String url, int dataset) {

		System.out.println("url : " + url);
		String Username = Utils.getDataFromTestData("TS03_EroOptimizer_WHAT_IF_new_Dataset" + dataset,
				"ERO_Optimizer WHAT_IF", "Username");
		String Password = Utils.getDataFromTestData("TS03_EroOptimizer_WHAT_IF_new_Dataset" + dataset,
				"ERO_Optimizer WHAT_IF", "Password");
		String ID = Utils.getDataFromTestData("TS03_EroOptimizer_WHAT_IF_new_Dataset" + dataset,
				"ERO_Optimizer WHAT_IF", "Id");
		String Allocate1 = Utils.getDataFromTestData("TS03_EroOptimizer_WHAT_IF_new_Dataset" + dataset,
				"ERO_Optimizer WHAT_IF", "Allocate");

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

		Extent_cal(test, "Testcase 3.1 -Ensure that searched data  id get get displayed properly in id field");

		Fluentwait(driver, Searchbox);
		sendKeys(driver, Searchbox, "Optimizer WHAT – IF Scenario");

		Fluentwait(driver, SelectOptimizer);
		click(driver, SelectOptimizer);

		Fluentwait(driver, Optimizer_Globalserach);
		click(driver, Optimizer_Globalserach);

		Fluentwait(driver, Globalserach_IDInput);
		sendKeys(driver, Globalserach_IDInput, ID);

		wait(driver, "2");

		Fluentwait(driver, Click_Search);
		click(driver, Click_Search);

		wait(driver, "5");

		String Id = getText(driver, SelectID);
		System.out.println("Id value :" + Id);

		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);

		wait(driver, "7");

		String Actual_id = getAttribute(driver, Optimizer_id_filed, "value");
		System.out.println("Actual_id :" + Actual_id);
		wait(driver, "2");

		if (Actual_id.equals(Id)) {
			Extent_pass(driver, "Expected Id Value was  : " + Id + " Actual Id value was : " + Actual_id, test, test1);
		} else {
			Extent_fail(driver, "Expected Id Value was  : " + Id + " Actual Id value was : " + Actual_id, test, test1);
		}

//		wait(driver, "2");
//		if (IsElementEnabled(driver, OPtimizer_refreshResult)) {
//			System.out.println("After navigating to Optimizer WHAT IF page, Refresh result filed is enable");
//			Extent_pass(driver, "After navigating to Optimizer WHAT IF page, Refresh result filed is enable", test,
//					test1);
//		} else {
//			System.out.println("After navigating to Optimizer WHAT IF page, Refresh result filed is not enable");
//			Extent_fail(driver, "After navigating to Optimizer WHAT IF page, Refresh result filed is not enable", test,
//					test1);
//			global = "After navigating to Optimizer WHAT IF page, Refresh result filed is not enable";
//		}
//
//		wait(driver, "2");
//		if (IsElementEnabled(driver, OPtimizer_option)) {
//			System.out.println("After navigating to Optimizer WHAT IF page, Optimizer filed is enable");
//			Extent_pass(driver, "After navigating to Optimizer WHAT IF page, Optimizer filed is enable", test, test1);
//
//		} else {
//			System.out.println("After navigating to Optimizer WHAT IF page, Optimizer filed is not  enable");
//			Extent_fail(driver, "After navigating to Optimizer WHAT IF page, Optimizer filed is not enable", test,
//					test1);
//			global = "After navigating to Optimizer WHAT IF page, Optimizer filed is not enable";
//		}
//
//		wait(driver, "2");
//		if (IsElementEnabled(driver, OPtimizer_all)) {
//			System.out.println("After navigating to Optimizer WHAT IF page, All filed is enable");
//			Extent_pass(driver, "After navigating to Optimizer WHAT IF page, All filed is enable", test, test1);
//		} else {
//			System.out.println("After navigating to Optimizer WHAT IF page, All filed is not  enable");
//			Extent_fail(driver, "After navigating to Optimizer WHAT IF page, All filed is not  enable", test, test1);
//			global = "After navigating to Optimizer WHAT IF page, All filed is not  enable";
//		}
//
//		wait(driver, "2");
//		if (IsElementEnabled(driver, OPtimizer_20s)) {
//			System.out.println("After navigating to Optimizer WHAT IF page, 20s filed is enable");
//			Extent_pass(driver, "After navigating to Optimizer WHAT IF page, 20s filed is enable", test, test1);
//		} else {
//			System.out.println("After navigating to Optimizer WHAT IF page, 20s filed is not enable");
//			Extent_fail(driver, "After navigating to Optimizer WHAT IF page, 20s filed is not enable", test, test1);
//			global = "After navigating to Optimizer WHAT IF page, 20s filed is not enable";
//		}
//
//		wait(driver, "2");
//		if (IsElementEnabled(driver, OPtimizer_40s)) {
//			System.out.println("After navigating to Optimizer WHAT IF page, 40s filed is enable");
//			Extent_pass(driver, "After navigating to Optimizer WHAT IF page, 40s filed is enable", test, test1);
//		} else {
//			System.out.println("After navigating to Optimizer WHAT IF page, 40s filed is not enable");
//			Extent_fail(driver, "After navigating to Optimizer WHAT IF page, 40s filed is not enable", test, test1);
//			global = "After navigating to Optimizer WHAT IF page, 40s filed is not enable";
//		}
//
//		wait(driver, "2");
//		if (IsElementEnabled(driver, OPtimizer_sizeStpe)) {
//			System.out.println("After navigating to Optimizer WHAT IF page, Size type filed is enable");
//			Extent_pass(driver, "After navigating to Optimizer WHAT IF page,Size type filed is enable", test, test1);
//		} else {
//			System.out.println("After navigating to Optimizer WHAT IF page, Size type filed is not enable");
//			Extent_fail(driver, "After navigating to Optimizer WHAT IF page,Size type filed is not enable", test,
//					test1);
//			global = "After navigating to Optimizer WHAT IF page, Size type filed is not enable";
//		}

		System.out.println("************Testcase 3.1*************");

		Fluentwait(driver, Optimizer_cancle);
		click(driver, Optimizer_cancle);
		Fluentwait(driver, Optimizer_new);
		click(driver, Optimizer_new);
		wait(driver, "2");
		Fluentwait(driver, Optimizer_createnew_confirm);
		click(driver, Optimizer_createnew_confirm);

		Extent_cal(test, "Testcase 3.2-Ensure that columns avialable in grid");

		Fluentwait(driver, Optimizer_Globalserach);
		click(driver, Optimizer_Globalserach);

		Fluentwait(driver, Globalserach_IDInput);
		sendKeys(driver, Globalserach_IDInput, ID);

		wait(driver, "2");

		Fluentwait(driver, Click_Search);
		click(driver, Click_Search);

		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);

		wait(driver, "7");

		if (isDisplayed(driver, Optimizer_Grid_locationfield1)) {
			System.out.println("After navigating to Optimizer WHAT IF page , Surplus location column is enable");
			Extent_pass(driver, "After navigating to Optimizer WHAT IF page,Surplus location column is enable", test,
					test1);
		} else {
			System.out.println("After navigating to Optimizer WHAT IF page , Surplus location  column is not  enable");
			Extent_fail(driver, "After navigating to Optimizer WHAT IF page,Surplus location column is not enable",
					test, test1);
		}

		wait(driver, "2");
		if (isDisplayed(driver, OPtimizer_SurplusCount)) {
			System.out.println("After navigating to Optimizer WHAT IF page , Surplus count column is enable");
			Extent_pass(driver, "After navigating to Optimizer WHAT IF page,Surplus count column is enable", test,
					test1);
		} else {
			System.out.println("After navigating to Optimizer WHAT IF page , Surplus count  column is not  enable");
			Extent_fail(driver, "After navigating to Optimizer WHAT IF page,Surplus count column is not enable", test,
					test1);
		}

		wait(driver, "2");
		if (isDisplayed(driver, OPtimizer_Deficit_location)) {
			System.out.println("After navigating to Optimizer WHAT IF page , Deficit location column is enable");
			Extent_pass(driver, "After navigating to Optimizer WHAT IF page, Deficit location column is enable", test,
					test1);
		} else {
			System.out.println("After navigating to Optimizer WHAT IF page , Deficit location  column is not  enable");
			Extent_fail(driver, "After navigating to Optimizer WHAT IF page, Deficit location column is not enable",
					test, test1);
		}

		wait(driver, "2");
		if (isDisplayed(driver, OPtimizer_Deficit_Count)) {
			System.out.println("After navigating to Optimizer WHAT IF page ,Deficit Count column is enable");
			Extent_pass(driver, "After navigating to Optimizer WHAT IF page,Deficit Count column is enable", test,
					test1);
		} else {
			System.out.println("After navigating to Optimizer WHAT IF page ,Deficit Count  column is not  enable");
			Extent_fail(driver, "After navigating to Optimizer WHAT IF page,Deficit Count  column is not enable", test,
					test1);
		}

		wait(driver, "2");
		if (isDisplayed(driver, OPtimizer_OptimizerResult)) {
			System.out.println("After navigating to Optimizer WHAT IF page , Optimizer Result column is enable");
			Extent_pass(driver, "After navigating to Optimizer WHAT IF page, Optimizer Result  column is enable", test,
					test1);
		} else {
			System.out.println("After navigating to Optimizer WHAT IF page ,Optimizer Result   column is not  enable");
			Extent_fail(driver, "After navigating to Optimizer WHAT IF page,Optimizer Result   column is not enable",
					test, test1);
		}

		wait(driver, "2");
		if (isDisplayed(driver, Optimizer_Allocate_Containers)) {
			System.out.println("After navigating to Optimizer WHAT IF page , Allocate containers column is enable");
			Extent_pass(driver, "After navigating to Optimizer WHAT IF page, Allocate containers  column is enable",
					test, test1);
		} else {
			System.out
					.println("After navigating to Optimizer WHAT IF page , Allocate containers  column is not  enable");
			Extent_fail(driver,
					"After navigating to Optimizer WHAT IF page, Allocate containers   column is not enable", test,
					test1);
		}

		wait(driver, "2");
		if (isDisplayed(driver, Optimizer_Size_Type_Val)) {
			System.out.println("After navigating to Optimizer WHAT IF page , Size Type column is enable");
			Extent_pass(driver, "After navigating to Optimizer WHAT IF page, Size Type containers  column is enable",
					test, test1);
		} else {
			System.out.println(
					"After navigating to Optimizer WHAT IF page , Size Type containers  column is not  enable");
			Extent_fail(driver,
					"After navigating to Optimizer WHAT IF page, Size Type containers   column is not enable", test,
					test1);
		}

		wait(driver, "2");
		if (isDisplayed(driver, OPtimizer_units)) {
			System.out.println("After navigating to Optimizer WHAT IF page , cost/units column is enable");
			Extent_pass(driver, "After navigating to Optimizer WHAT IF page, cost/units containers  column is enable",
					test, test1);
		} else {
			System.out.println(
					"After navigating to Optimizer WHAT IF page , cost/units containers  column is not  enable");
			Extent_fail(driver,
					"After navigating to Optimizer WHAT IF page, cost/units containers   column is not enable", test,
					test1);
		}

		System.out.println("************Testcase 3.2*************");

		Fluentwait(driver, Optimizer_cancle);
		click(driver, Optimizer_cancle);
		Fluentwait(driver, Optimizer_new);
		click(driver, Optimizer_new);
		wait(driver, "2");
		Fluentwait(driver, Optimizer_createnew_confirm);
		click(driver, Optimizer_createnew_confirm);

		Extent_cal(test, "Testcase 3.3-Ensure that conditional filter works properly in grid");

		Fluentwait(driver, Optimizer_Globalserach);
		click(driver, Optimizer_Globalserach);

		Fluentwait(driver, Globalserach_IDInput);
		sendKeys(driver, Globalserach_IDInput, ID);

		wait(driver, "2");

		Fluentwait(driver, Click_Search);
		click(driver, Click_Search);

		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);

		wait(driver, "7");

		Fluentwait(driver, Optimizermain_Tree_table);
		click(driver, Optimizermain_Tree_table);

		Fluentwait(driver, Optimizer_Condition_filter);
		click(driver, Optimizer_Condition_filter);

		Fluentwait(driver, Optimizer_filter_input);
		sendKeys(driver, Optimizer_filter_input, "ASPPG");

		if (isDisplayed(driver, Optimizer_Grid_locationfield1)) {
			System.out.println("Condition Filter is working fine");
			Extent_pass(driver, "Condition Filter is working fine", test, test1);
		} else {
			System.out.println("Condition Filter is not working");
			Extent_fail(driver, "Condition Filter is not working", test, test1);
		}
		System.out.println("************Testcase 3.3*************");

		wait(driver, "3");

		Fluentwait(driver, Optimizer_cancle);
		click(driver, Optimizer_cancle);
		Fluentwait(driver, Optimizer_new);
		click(driver, Optimizer_new);
		wait(driver, "2");
		Fluentwait(driver, Optimizer_createnew_confirm);
		click(driver, Optimizer_createnew_confirm);

		Extent_cal(test, "Testcase 3.4-Ensure that conditional filter get removed when click reset");
		Fluentwait(driver, Optimizer_Globalserach);
		click(driver, Optimizer_Globalserach);

		Fluentwait(driver, Globalserach_IDInput);
		sendKeys(driver, Globalserach_IDInput, ID);

		wait(driver, "2");

		Fluentwait(driver, Click_Search);
		click(driver, Click_Search);

		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);

		wait(driver, "7");

		Fluentwait(driver, Optimizermain_Tree_table);
		click(driver, Optimizermain_Tree_table);

		Fluentwait(driver, Optimizer_Condition_filter);
		click(driver, Optimizer_Condition_filter);

		Fluentwait(driver, Optimizer_filter_input);
		sendKeys(driver, Optimizer_filter_input, "ASPPG");
		if (isDisplayed(driver, Optimizer_Grid_locationfield1)) {
			System.out.println("Condition Filter is working fine");
			Extent_pass(driver, "Condition Filter is working fine", test, test1);
		} else {
			System.out.println("Condition Filter is not working");
			Extent_fail(driver, "Condition Filter is not working", test, test1);
		}

		wait(driver, "2");
		Fluentwait(driver, Optimizermain_Tree_table);
		click(driver, Optimizermain_Tree_table);
		Fluentwait(driver, Optimizer_Reset);
		click(driver, Optimizer_Reset);

		wait(driver, "2");
		if (!isDisplayed(driver, Optimizer_filter_input)) {
			System.out.println("Condition Filter is removed ");
			Extent_pass(driver, "Condition Filter is removed", test, test1);
		} else {
			System.out.println("Condition Filter is not removed");
			Extent_fail(driver, "Condition Filter is not removed", test, test1);
		}
		System.out.println("************Testcase 3.4*************");

		Extent_cal(test, "Testcase 3.6-Ensure that allocate containers field is editable");

		wait(driver, "4");

		Fluentwait(driver, Optimizer_Allocate_Containers);
		doubleClick(driver, Optimizer_Allocate_Containers);

		wait(driver, "2");

		sendKeys(driver, Optimizer_Allocate_Containers1, "2");
		enter(driver);

		wait(driver, "2");
		String Surplus_Location = getText(driver, Optimizer_Grid_locationfield1);
		System.out.println("Surplus_Location :" + Surplus_Location);
		wait(driver, "2");
		String Surplus_Count = getText(driver, OPtimizer_SurplusCount);
		System.out.println("Surplus_Count :" + Surplus_Count);
		wait(driver, "2");
		String Deficit_location = getText(driver, OPtimizer_Deficit_location);
		System.out.println("Deficit_location :" + Deficit_location);

		wait(driver, "2");
		String Deficit_Count = getText(driver, OPtimizer_Deficit_Count);
		System.out.println("Deficit_Count :" + Deficit_Count);

		wait(driver, "2");
		String OptimizerResult = getText(driver, OPtimizer_OptimizerResult);
		System.out.println("OptimizerResult :" + OptimizerResult);

		wait(driver, "2");
		String Size_Type_Val = getText(driver, Optimizer_Size_Type_Val);
		System.out.println("Size_Type_Val :" + Size_Type_Val);
		wait(driver, "2");
		String units = getText(driver, OPtimizer_units);
		System.out.println("units :" + units);

		wait(driver, "2");
		sendKeys(driver, Optimizer_Grid_locationfield1, "abc");
		wait(driver, "2");

		String Surplus_Location1 = getText(driver, Optimizer_Grid_locationfield1);
		System.out.println("Surplus_Location1 :" + Surplus_Location1);
		if (Surplus_Location.equals(Surplus_Location1)) {
			System.out.println("Surplus location columns fields are not editable");
			Extent_pass(driver, "Expected Surplus location Value was  : " + Surplus_Location1
					+ " ActualSurplus location value was : " + Surplus_Location, test, test1);
		} else {
			System.out.println("Surplus location columns fields are  editable");
			Extent_fail(driver, "Expected Surplus location Value was  : " + Surplus_Location1
					+ " ActualSurplus location value was : " + Surplus_Location, test, test1);
		}
		wait(driver, "2");
		sendKeys(driver, OPtimizer_SurplusCount, "2");
		wait(driver, "2");
		String Surplus_Count1 = getText(driver, OPtimizer_SurplusCount);
		System.out.println("Surplus_Count :" + Surplus_Count1);
		wait(driver, "2");
		if (Surplus_Count1.equals(Surplus_Count)) {
			System.out.println("Surplus Count columns fields are not editable");
			Extent_pass(driver, "Expected Surplus Count Value was  : " + Surplus_Count
					+ " Actual Surplus Count value was : " + Surplus_Count1, test, test1);
		} else {
			System.out.println("Surplus Count columns fields are  editable");
			Extent_fail(driver, "Expected Surplus Count Value was  : " + Surplus_Count
					+ " Actual Surplus Count value was : " + Surplus_Count1, test, test1);
		}

		wait(driver, "2");
		sendKeys(driver, OPtimizer_Deficit_location, "kj");
		wait(driver, "2");
		String Deficit_location1 = getText(driver, OPtimizer_Deficit_location);
		System.out.println("Deficit_location1 :" + Deficit_location1);
		wait(driver, "2");
		if (Deficit_location1.equals(Deficit_location)) {
			System.out.println("deficit location Count columns fields are not editable");
			Extent_pass(driver, "Expecteddeficit location Count Value was  : " + Surplus_Count
					+ " Actual deficit location value was : " + Deficit_location1, test, test1);
		} else {
			System.out.println("deficit location columns fields are  editable");
			Extent_fail(driver, "Expected deficit locationt Value was  : " + Surplus_Count
					+ " Actual deficit location value was : " + Deficit_location1, test, test1);
		}

		wait(driver, "2");
		sendKeys(driver, OPtimizer_Deficit_Count, "9");
		wait(driver, "2");
		String Deficit_Count1 = getText(driver, OPtimizer_Deficit_Count);
		System.out.println("Deficit_Count1 :" + Deficit_Count1);
		wait(driver, "2");
		if (Deficit_Count1.equals(Deficit_Count)) {
			System.out.println("Defit Count columns fields are not editable");
			Extent_pass(driver,
					"Defit  Count Value was  : " + Deficit_Count + " Actual Defit Count value was : " + Deficit_Count1,
					test, test1);
		} else {
			System.out.println("Defit Count columns fields are  editable");
			Extent_fail(driver,
					"Defit  Count Value was  : " + Deficit_Count + " Actual Defit Count value was : " + Deficit_Count1,
					test, test1);
		}

		sendKeys(driver, OPtimizer_OptimizerResult, "7");

		wait(driver, "2");
		String OptimizerResult1 = getText(driver, OPtimizer_OptimizerResult);
		System.out.println("OptimizerResult :" + OptimizerResult1);
		if (OptimizerResult1.equals(OptimizerResult)) {
			System.out.println("OPtimizer Result columns fields are not editable");
			Extent_pass(driver, "OPtimizer Result Count Value was  : " + OptimizerResult
					+ " Actual OPtimizer Result value was : " + OptimizerResult1, test, test1);
		} else {
			System.out.println("OPtimizer Result columns fields are  editable");
			Extent_fail(driver, "OPtimizer Result Count Value was  : " + OptimizerResult
					+ " Actual OPtimizer Result value was : " + OptimizerResult1, test, test1);
		}
		sendKeys(driver, Optimizer_Size_Type_Val, "30hc");
		wait(driver, "2");
		String Size_Type_Val1 = getText(driver, Optimizer_Size_Type_Val);
		System.out.println("Size_Type_Val :" + Size_Type_Val1);
		if (Size_Type_Val1.equals(Size_Type_Val)) {
			System.out.println("Size Type columns fields are not editable");
			Extent_pass(driver, "Size Type Count Value was  : " + Size_Type_Val
					+ " Actual OPtimizer Result value was : " + Size_Type_Val1, test, test1);
		} else {
			System.out.println("Size Type columns fields are  editable");
			Extent_fail(driver, "Size Type Count Value was  : " + Size_Type_Val
					+ " Actual OPtimizer Result value was : " + Size_Type_Val1, test, test1);
		}

		sendKeys(driver, OPtimizer_units, "6");
		wait(driver, "2");
		String units1 = getText(driver, OPtimizer_units);
		System.out.println("units :" + units1);
		if (units1.equals(units)) {
			System.out.println("Size Type columns fields are not editable");
			Extent_pass(driver,
					"Size Type Count Value was  : " + units + " Actual OPtimizer Result value was : " + units1, test,
					test1);
		} else {
			System.out.println("Size Type columns fields are  editable");
			Extent_fail(driver,
					"Size Type Count Value was  : " + units + " Actual OPtimizer Result value was : " + units1, test,
					test1);
		}
		System.out.println("************Testcase 3.6*************");

		Extent_cal(test, "Testcase 3.7-Ensure that all check box field is accessible");

		Fluentwait(driver, OPtimizer_20s);
		click(driver, OPtimizer_20s);
		wait(driver, "2");

		Fluentwait(driver, OPtimizer_all);
		click(driver, OPtimizer_all);

		isElementSelected(driver, OPtimizer_all);
		if (IsElementEnabled(driver, OPtimizer_all)) {
			System.out.println("All check box is  accessible");
			Extent_pass(driver, "All check box is  accessible", test, test1);
		} else {
			System.out.println("All check box is not accessible");
			Extent_pass(driver, "All check box is  not accessible", test, test1);
		}
		System.out.println("************Testcase 3.7*************");

		Extent_cal(test, "Testcase 3.8-Ensure that all check box field is accessible");

		click(driver, OPtimizer_all);
		wait(driver, "2");

		if (!IsElementEnabled(driver, OPtimizer_sizeStpe_disabled)) {
			System.out.println("Size type field is disabled");
			Extent_pass(driver, "Size type field is disabled", test, test1);
		} else {
			System.out.println("Size type field is not disabled");
			Extent_fail(driver, "Size type field is not disabled", test, test1);
		}

		System.out.println("************Testcase 3.8*************");

		Extent_cal(test,
				"Testcase 3.9-Ensure that optimizer get run when alphanumeric and special characters in allocated containers field");

		Fluentwait(driver, Optimizer_Allocate_Containers);
		doubleClick(driver, Optimizer_Allocate_Containers);

		wait(driver, "2");

		sendKeys(driver, Optimizer_Allocate_Containers1, "r@");

		enter(driver);

		Fluentwait(driver, Optimizer_button);
		click(driver, Optimizer_button);
		wait(driver, "2");

		if (!isDisplayed(driver, Optimizer_EquipmentRepositionSolve)) {
			System.out.println("After click on Optimizer, the Optimize page is not open");
			Extent_pass(driver, "After click on Optimizer, the Optimize page is not open", test, test1);
		} else {
			System.out.println("After click on Optimizer, the OPtimize page is open");
			Extent_fail(driver, "After click on Optimizer, the OPtimize page is open", test, test1);
		}

		System.out.println("************Testcase 3.9*************");

		Fluentwait(driver, Optimizer_cancle);
		click(driver, Optimizer_cancle);
		Fluentwait(driver, Optimizer_new);
		click(driver, Optimizer_new);
		wait(driver, "2");
		Fluentwait(driver, Optimizer_createnew_confirm);
		click(driver, Optimizer_createnew_confirm);

		Extent_cal(test, "Testcase 3.11 -Ensure that size type get enable when 20s and 40s container is selected");
		Fluentwait(driver, Optimizer_Globalserach);
		click(driver, Optimizer_Globalserach);

		Fluentwait(driver, Globalserach_IDInput);
		sendKeys(driver, Globalserach_IDInput, ID);

		wait(driver, "2");

		Fluentwait(driver, Click_Search);
		click(driver, Click_Search);

		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);

		wait(driver, "7");

		Fluentwait(driver, OPtimizer_20s);
		click(driver, OPtimizer_20s);

		Fluentwait(driver, Optimizer_Allocate_Containers);
		doubleClick(driver, Optimizer_Allocate_Containers);

		wait(driver, "2");

		sendKeys(driver, Optimizer_Allocate_Containers1, "1");
		enter(driver);
		wait(driver, "2");

		if (IsElementEnabled(driver, OPtimizer_sizeStpe)) {
			System.out.println("Size type field is Enabled");
			Extent_pass(driver, "Size type field is Enabled", test, test1);
		} else {
			System.out.println("Size type field is not Enabled");
			Extent_fail(driver, "Size type field is not Enabled", test, test1);
		}

		System.out.println("************Testcase 3.11*************");

		Fluentwait(driver, Optimizer_cancle);
		click(driver, Optimizer_cancle);
		Fluentwait(driver, Optimizer_new);
		click(driver, Optimizer_new);
		wait(driver, "2");
		Fluentwait(driver, Optimizer_createnew_confirm);
		click(driver, Optimizer_createnew_confirm);

		Extent_cal(test,
				"Testcase 3.12 -Ensure that 20 s type of containers only get displayed in size type when 20s container is selcted");

		Fluentwait(driver, Optimizer_Globalserach);
		click(driver, Optimizer_Globalserach);

		Fluentwait(driver, Globalserach_IDInput);
		sendKeys(driver, Globalserach_IDInput, ID);

		wait(driver, "2");

		Fluentwait(driver, Click_Search);
		click(driver, Click_Search);

		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);

		wait(driver, "7");

		Fluentwait(driver, OPtimizer_20s);
		click(driver, OPtimizer_20s);

		Fluentwait(driver, OPtimizer_sizeStpe);
		click(driver, OPtimizer_sizeStpe);

		wait(driver, "2");

		if (isDisplayed(driver, SizeType_20dy)) {
			System.out.println("20DY Size type field value is displayed");
			Extent_pass(driver, "20DY Size type field value is displayed", test, test1);
		} else {
			System.out.println("20DY Size type field value is not displayed");
			Extent_fail(driver, "20DY Size type field value is not displayed", test, test1);
		}
		wait(driver, "2");
		if (isDisplayed(driver, SizeType_20FF)) {
			System.out.println("20RF Size type field value is displayed");
			Extent_pass(driver, "20RF Size type field value is displayed", test, test1);
		} else {
			System.out.println("20RF Size type field value is not displayed");
			Extent_fail(driver, "20RF Size type field value is not displayed", test, test1);
		}
		wait(driver, "2");
		if (isDisplayed(driver, SizeType_20HB)) {
			System.out.println("20HB Size type field value is displayed");
			Extent_pass(driver, "20HB Size type field value is displayed", test, test1);
		} else {
			System.out.println("20HB Size type field value is not displayed");
			Extent_fail(driver, "20HB Size type field value is not displayed", test, test1);
		}
		wait(driver, "2");
		if (isDisplayed(driver, SizeType_20HC)) {
			System.out.println("20HC Size type field value is displayed");
			Extent_pass(driver, "20HC Size type field value is displayed", test, test1);
		} else {
			System.out.println("20HC Size type field value is not displayed");
			Extent_fail(driver, "20HC Size type field value is not displayed", test, test1);
		}

		wait(driver, "2");
		if (isDisplayed(driver, SizeType_20HH)) {
			System.out.println("20HH Size type field value is displayed");
			Extent_pass(driver, "20HH Size type field value is displayed", test, test1);
		} else {
			System.out.println("20HH Size type field value is not displayed");
			Extent_fail(driver, "20HH Size type field value is not displayed", test, test1);
		}
		wait(driver, "2");
		if (isDisplayed(driver, SizeType_20OT)) {
			System.out.println("20OT Size type field value is displayed");
			Extent_pass(driver, "20OT Size type field value is displayed", test, test1);
		} else {
			System.out.println("20OT Size type field value is not displayed");
			Extent_fail(driver, "20OT Size type field value is not displayed", test, test1);
		}

		wait(driver, "2");
		if (isDisplayed(driver, SizeType_20TK)) {
			System.out.println("20TK Size type field value is displayed");
			Extent_pass(driver, "20TK Size type field value is displayed", test, test1);
		} else {
			System.out.println("20TK Size type field value is not displayed");
			Extent_fail(driver, "20TK Size type field value is not displayed", test, test1);
		}
		wait(driver, "2");
		if (isDisplayed(driver, SizeType_20WW)) {
			System.out.println("20WW Size type field value is displayed");
			Extent_pass(driver, "20WW Size type field value is displayed", test, test1);
		} else {
			System.out.println("20WW Size type field value is not displayed");
			Extent_fail(driver, "20WW Size type field value is not displayed", test, test1);
		}

		System.out.println("************Testcase 3.12*************");

		Fluentwait(driver, Optimizer_cancle);
		click(driver, Optimizer_cancle);
		Fluentwait(driver, Optimizer_new);
		click(driver, Optimizer_new);
		wait(driver, "2");
		Fluentwait(driver, Optimizer_createnew_confirm);
		click(driver, Optimizer_createnew_confirm);

		Extent_cal(test,
				"Testcase 3.13 -Ensure that 40 s type of containers only get displayed in size type when 40s container is selcted");
		Fluentwait(driver, Optimizer_Globalserach);
		click(driver, Optimizer_Globalserach);

		Fluentwait(driver, Globalserach_IDInput);
		sendKeys(driver, Globalserach_IDInput, ID);

		wait(driver, "2");

		Fluentwait(driver, Click_Search);
		click(driver, Click_Search);

		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);

		wait(driver, "7");

		Fluentwait(driver, OPtimizer_40s);
		click(driver, OPtimizer_40s);

		Fluentwait(driver, OPtimizer_sizeStpe);
		click(driver, OPtimizer_sizeStpe);

		wait(driver, "2");

		if (isDisplayed(driver, SizeType_20dy)) {
			System.out.println("40DY Size type field value is displayed");
			Extent_pass(driver, "40DY Size type field value is displayed", test, test1);
		} else {
			System.out.println("40DY Size type field value is not displayed");
			Extent_fail(driver, "40DY Size type field value is not displayed", test, test1);
		}
		wait(driver, "2");
		if (isDisplayed(driver, SizeType_20FF)) {
			System.out.println("40HC Size type field value is displayed");
			Extent_pass(driver, "40HC Size type field value is displayed", test, test1);
		} else {
			System.out.println("40HC Size type field value is not displayed");
			Extent_fail(driver, "40HC Size type field value is not displayed", test, test1);
		}
		wait(driver, "2");
		if (isDisplayed(driver, SizeType_20HB)) {
			System.out.println("20HB Size type field value is displayed");
			Extent_pass(driver, "20HB Size type field value is displayed", test, test1);
		} else {
			System.out.println("20HR Size type field value is not displayed");
			Extent_fail(driver, "20HR Size type field value is not displayed", test, test1);
		}
		wait(driver, "2");
		if (isDisplayed(driver, SizeType_20HC)) {
			System.out.println("20OT Size type field value is displayed");
			Extent_pass(driver, "20OT Size type field value is displayed", test, test1);
		} else {
			System.out.println("40OT Size type field value is not displayed");
			Extent_fail(driver, "40OT Size type field value is not displayed", test, test1);
		}

		wait(driver, "2");
		if (isDisplayed(driver, SizeType_20HH)) {
			System.out.println("40DY Size type field value is displayed");
			Extent_pass(driver, "40DY Size type field value is displayed", test, test1);
		} else {
			System.out.println("40DY Size type field value is not displayed");
			Extent_fail(driver, "40DY Size type field value is not displayed", test, test1);
		}
		wait(driver, "2");
		if (isDisplayed(driver, SizeType_20OT)) {
			System.out.println("40FF Size type field value is displayed");
			Extent_pass(driver, "40FF Size type field value is displayed", test, test1);
		} else {
			System.out.println("40FF Size type field value is not displayed");
			Extent_fail(driver, "40FF Size type field value is not displayed", test, test1);
		}

		wait(driver, "2");
		if (isDisplayed(driver, SizeType_20TK)) {
			System.out.println("40HH Size type field value is displayed");
			Extent_pass(driver, "40HH Size type field value is displayed", test, test1);
		} else {
			System.out.println("40HH Size type field value is not displayed");
			Extent_fail(driver, "40HH Size type field value is not displayed", test, test1);
		}
		wait(driver, "2");
		if (isDisplayed(driver, SizeType_20WW)) {
			System.out.println("40OT Size type field value is displayed");
			Extent_pass(driver, "40OT Size type field value is displayed", test, test1);
		} else {
			System.out.println("40OT Size type field value is not displayed");
			Extent_fail(driver, "40OT Size type field value is not displayed", test, test1);
		}

		System.out.println("************Testcase 3.13*************");

		Fluentwait(driver, Optimizer_cancle);
		click(driver, Optimizer_cancle);
		Fluentwait(driver, Optimizer_new);
		click(driver, Optimizer_new);
		wait(driver, "2");
		Fluentwait(driver, Optimizer_createnew_confirm);
		click(driver, Optimizer_createnew_confirm);

		Extent_cal(test,
				"Testcase 3.10 -Ensure that optimizer should get  optimize for all type of containers when all check box is selected");

		wait(driver, "2");
		Fluentwait(driver, Optimizer_Globalserach);
		click(driver, Optimizer_Globalserach);

		Fluentwait(driver, Globalserach_IDInput);
		sendKeys(driver, Globalserach_IDInput, "B20240905-01-52-00012");

		wait(driver, "2");
		Fluentwait(driver, Click_Search);
		click(driver, Click_Search);

		wait(driver, "2");
		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);

		wait(driver, "7");

		String surplus = getText(driver, Optimizer_surplus_Location);
		System.out.println("surplus : " + surplus);

		wait(driver, "2");

		String Deficit = getText(driver, Optimizer_deficit_location3);
		System.out.println("Deficit : " + Deficit);

		wait(driver, "2");
		Fluentwait(driver, Optimizer_Allocate_Containers);
		doubleClick(driver, Optimizer_Allocate_Containers);

		wait(driver, "2");

		sendKeys(driver, Optimizer_Allocate_Containers1, Allocate1);
		wait(driver, "2");
		enter(driver);
		wait(driver, "2");
		Fluentwait(driver, Optimizer_button);
		click(driver, Optimizer_button);

		Fluentwait(driver, Optimizer_Ok1);
		click(driver, Optimizer_Ok1);
		wait(driver, "7");

		List<WebElement> all_row = driver.findElements(By.xpath("//*[@id='OPT-OPT_treeTable_head']//th"));

		int value = all_row.size();

		int header = 0;

		for (int i = 0; i < value; i++) {
			String headerCellValue = all_row.get(i).getAttribute("aria-label");
			if (headerCellValue.equals(Deficit)) {
				header = i + 1;
				break;
			}
		}

		WebElement ExpectedCell = driver.findElement(By.xpath(
				"//*[@id='OPT-OPT_treeTable_data']//tr[contains(@data-rk,'" + surplus + ",')]//td[" + header + "]"));
		String ExpectedCellText = ExpectedCell.getText();
		System.out.println("ExpectedCellText :" + ExpectedCellText);

		int startIndex = ExpectedCellText.indexOf('[');
		int endIndex = ExpectedCellText.indexOf(']');
		String CellContainer = ExpectedCellText.substring(startIndex + 1, endIndex);

		if (Allocate1.equals(CellContainer)) {
			System.out.println("After click the optimizer,All type of containers is display");
			Extent_pass(driver, "Expected  Value was  : " + CellContainer + " Actual  value was : " + Allocate1, test,
					test1);
		} else {
			Extent_fail(driver, "Expected  Value was  : " + CellContainer + " Actual  value was : " + Allocate1, test,
					test1);
		}
		System.out.println("************Testcase 3.10*************");
		wait(driver, "2");
		Fluentwait(driver, close_2);
		click(driver, close_2);
		Fluentwait(driver, Optimizer_cancle);
		click(driver, Optimizer_cancle);
		Fluentwait(driver, Optimizer_new);
		click(driver, Optimizer_new);
		wait(driver, "2");
		Fluentwait(driver, Optimizer_createnew_confirm);
		click(driver, Optimizer_createnew_confirm);

		Extent_cal(test,
				"Testcase 3.14 -Ensure that optimizer should get  optimize for 20 s type of containers when 20s check box is selected");
		wait(driver, "2");
		Fluentwait(driver, Optimizer_Globalserach);
		click(driver, Optimizer_Globalserach);

		Fluentwait(driver, Globalserach_IDInput);
		sendKeys(driver, Globalserach_IDInput, "B20240905-01-52-00012");

		wait(driver, "2");
		Fluentwait(driver, Click_Search);
		click(driver, Click_Search);

		wait(driver, "2");
		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);

		wait(driver, "5");

		Fluentwait(driver, OPtimizer_20s);
		click(driver, OPtimizer_20s);
		Fluentwait(driver, OPtimizer_sizeStpe);
		click(driver, OPtimizer_sizeStpe);
		Fluentwait(driver, SizeType_20HC);
		click(driver, SizeType_20HC);
		wait(driver, "2");

		String surplus1 = getText(driver, Optimizer_surplus_Location_5Row);
		System.out.println("surplus1 : " + surplus1);

		wait(driver, "2");

		String Deficit1 = getText(driver, Optimizer_deficit_location5row);
		System.out.println("Deficit1 : " + Deficit1);

		wait(driver, "2");
		Fluentwait(driver, Optimizer_Allocate_Containers);
		doubleClick(driver, Optimizer_Allocate_Containers);

		wait(driver, "2");

		sendKeys(driver, Optimizer_Allocate_Containers1, Allocate1);
		wait(driver, "2");
		enter(driver);

		Fluentwait(driver, Optimizer_button);
		click(driver, Optimizer_button);

		Fluentwait(driver, Optimizer_Ok1);
		click(driver, Optimizer_Ok1);
		wait(driver, "7");
		List<WebElement> all_row1 = driver.findElements(By.xpath("//*[@id='OPT-OPT_treeTable_head']//th"));

		int value1 = all_row1.size();

		int header1 = 0;

		for (int i = 0; i < value1; i++) {
			String headerCellValue = all_row1.get(i).getAttribute("aria-label");
			if (headerCellValue.equals(Deficit1)) {
				header1 = i + 1;
				break;
			}
		}

		WebElement ExpectedCell1 = driver.findElement(By.xpath(
				"//*[@id='OPT-OPT_treeTable_data']//tr[contains(@data-rk,'" + surplus + ",')]//td[" + header + "]"));
		String ExpectedCellText1 = ExpectedCell1.getText();
		System.out.println("ExpectedCellText1 :" + ExpectedCellText1);

		int startIndex1 = ExpectedCellText1.indexOf('[');
		int endIndex1 = ExpectedCellText1.indexOf(']');

		String CellContainer1 = ExpectedCellText1.substring(startIndex1 + 1, endIndex1);
		if (Allocate1.equals(CellContainer1)) {
			System.out.println("After click the optimizer ,20S  containers is display");
			Extent_pass(driver, "Expected  Value was  : " + CellContainer1 + " Actual  value was : " + Allocate1, test,
					test1);
		} else {
			Extent_fail(driver, "Expected  Value was  : " + CellContainer1 + " Actual  value was : " + Allocate1, test,
					test1);
		}

		System.out.println("************Testcase 3.14*************");

		wait(driver, "2");
		Fluentwait(driver, close_2);
		click(driver, close_2);

		Fluentwait(driver, Optimizer_cancle);
		click(driver, Optimizer_cancle);
		Fluentwait(driver, Optimizer_new);
		click(driver, Optimizer_new);
		wait(driver, "2");
		Fluentwait(driver, Optimizer_createnew_confirm);
		click(driver, Optimizer_createnew_confirm);

		Extent_cal(test,
				"Testcase 3.15 -Ensure that optimizer should get  optimize for 40 s type of containers when 40s check box is selected");

		wait(driver, "2");
		Fluentwait(driver, Optimizer_Globalserach);
		click(driver, Optimizer_Globalserach);

		Fluentwait(driver, Globalserach_IDInput);
		sendKeys(driver, Globalserach_IDInput, "B20240905-01-52-00012");

		wait(driver, "2");
		Fluentwait(driver, Click_Search);
		click(driver, Click_Search);

		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);

		wait(driver, "7");

		Fluentwait(driver, OPtimizer_40s);
		click(driver, OPtimizer_40s);
		Fluentwait(driver, OPtimizer_sizeStpe);
		click(driver, OPtimizer_sizeStpe);
		Fluentwait(driver, SizeType_20FF);
		click(driver, SizeType_20FF);
		wait(driver, "2");

		String surplus2 = getText(driver, Optimizer_surplus_Location_5Row);
		System.out.println("surplus2 : " + surplus2);

		wait(driver, "2");

		String Deficit2 = getText(driver, Optimizer_deficit_location5row);
		System.out.println("Deficit2 : " + Deficit2);

		wait(driver, "2");
		Fluentwait(driver, Optimizer_Allocate_Containers);
		doubleClick(driver, Optimizer_Allocate_Containers);

		wait(driver, "2");

		sendKeys(driver, Optimizer_Allocate_Containers1, Allocate1);
		wait(driver, "2");
		enter(driver);

		Fluentwait(driver, Optimizer_button);
		click(driver, Optimizer_button);

		Fluentwait(driver, Optimizer_Ok1);
		click(driver, Optimizer_Ok1);
		wait(driver, "7");

		List<WebElement> all_row2 = driver.findElements(By.xpath("//*[@id='OPT-OPT_treeTable_head']//th"));

		int value2 = all_row2.size();

		int header2 = 0;

		for (int i = 0; i < value2; i++) {
			String headerCellValue = all_row2.get(i).getAttribute("aria-label");
			if (headerCellValue.equals(Deficit2)) {
				header2 = i + 1;
				break;
			}
		}
		wait(driver, "2");
		WebElement ExpectedCell2 = driver.findElement(By.xpath(
				"//*[@id='OPT-OPT_treeTable_data']//tr[contains(@data-rk,'" + surplus + ",')]//td[" + header + "]"));
		String ExpectedCellText2 = ExpectedCell2.getText();
		System.out.println("ExpectedCellText2 :" + ExpectedCellText2);

		int startIndex2 = ExpectedCellText2.indexOf('[');
		int endIndex2 = ExpectedCellText2.indexOf(']');

		String CellContainer3 = ExpectedCellText2.substring(startIndex2 + 1, endIndex2);
		if (Allocate1.equals(CellContainer3)) {
			System.out.println("After click the optimizer ,20S  containers is display");
			Extent_pass(driver, "Expected  Value was  : " + CellContainer3 + " Actual  value was : " + Allocate1, test,
					test1);
		} else {
			Extent_fail(driver, "Expected  Value was  : " + CellContainer3 + " Actual  value was : " + Allocate1, test,
					test1);
		}

		System.out.println("************Testcase 3.15************");

	}
}