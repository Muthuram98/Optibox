package ERO_Optimizer_WHAT_IF_Scripts_New;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.Utils;

public class TS04ERO_Optimizer_WHAT_IF_Scripts_NewTC4To16 extends Keywords {
	
	public void Scenario4(WebDriver driver, ExtentTest test, ExtentTest test1, String url, int dataset) throws AWTException {

		System.out.println("url : " + url);
		String Username = Utils.getDataFromTestData("TS04_EroOptimizer_WHAT_IF_new_Dataset"+dataset, "ERO_Optimizer WHAT_IF",
				"Username");
		String Password = Utils.getDataFromTestData("TS04_EroOptimizer_WHAT_IF_new_Dataset"+dataset, "ERO_Optimizer WHAT_IF",
				"Password");
		String ID = Utils.getDataFromTestData("TS04_EroOptimizer_WHAT_IF_new_Dataset"+dataset, "ERO_Optimizer WHAT_IF", "Id");
		String Containers = Utils.getDataFromTestData("TS04_EroOptimizer_WHAT_IF_new_Dataset"+dataset, "ERO_Optimizer WHAT_IF", "Containers");

		navigateUrl(driver, url);
		Robot rbt = new Robot();
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

		Extent_cal(test, "Testcase 4.1 -Ensure that options get enable when open a optimizer  screen");

		Fluentwait(driver, Optimizer_Globalserach);
		click(driver, Optimizer_Globalserach);

		Fluentwait(driver, Globalserach_IDInput);
		sendKeys(driver, Globalserach_IDInput, "B20240922-01-52-00023");

		wait(driver, "2");

		Fluentwait(driver, Click_Search);
		click(driver, Click_Search);

		wait(driver, "5");

		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);
		wait(driver, "5");
		Fluentwait(driver, OPtimizer_20s);
		click(driver, OPtimizer_20s);

		wait(driver,"2");
		Fluentwait(driver, OPtimizer_sizeStpe);
		click(driver, OPtimizer_sizeStpe);
		
		wait(driver, "5");

		Fluentwait(driver, SizeType_20dy);
		click(driver, SizeType_20dy);

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

			System.out.println("After opening Optimizer WHAT IF page , the new  button is  enable status");
			Extent_fail(driver, "After opening Optimizer WHAT IF page , the new  button is enable status", test, test1);
		}
		wait(driver, "2");
		if (!IsElementEnabled(driver, Optimizer_save)) {

			System.out.println("After opening Optimizer WHAT IF page , the save  button is  not enable status");
			Extent_pass(driver, "After opening Optimizer WHAT IF page , the save  button is  not enable status", test,
					test1);

		} else {

			System.out.println("After opening Optimizer WHAT IF page , the save  button is enable status");
			Extent_fail(driver, "After opening Optimizer WHAT IF page , the save  button is  enable status", test,
					test1);

		}

		if (!IsElementEnabled(driver, Optimizer_search)) {

			System.out.println("After opening Optimizer WHAT IF page , the search  button is  not enable status");
			Extent_pass(driver, "After opening Optimizer WHAT IF page , the search  button is  not enable status", test,
					test1);

		} else {

			System.out.println("After opening Optimizer WHAT IF page , the search  button is  enable status");
			Extent_fail(driver, "After opening Optimizer WHAT IF page , the search  button is   enable status", test,
					test1);
		}
		wait(driver, "2");
		if (!IsElementEnabled(driver, Optimizer_edit1)) {

			System.out.println("After opening Optimizer WHAT IF page , the edit  button is  not enable status");
			Extent_pass(driver, "After opening Optimizer WHAT IF page , the edit button is  not enable status", test,
					test1);

		} else {

			System.out.println("After opening Optimizer WHAT IF page , the edit  button is  enable status");
			Extent_fail(driver, "After opening Optimizer WHAT IF page , the edit  button is  enable status", test,
					test1);
		}
		wait(driver, "2");
		if (!IsElementEnabled(driver, OPtimizer_delete)) {

			System.out.println("After opening Optimizer WHAT IF page , the delete button is not enable status");
			Extent_pass(driver, "After opening Optimizer WHAT IF page , the delete button is not enable status", test,
					test1);

		} else {

			System.out.println("After opening Optimizer WHAT IF page , the delete  button is  enable status");
			Extent_fail(driver, "After opening Optimizer WHAT IF page , the delete  button is  enable status", test,
					test1);
		}
		wait(driver, "2");
		if (!IsElementEnabled(driver, OPtimizer_saveas)) {

			System.out.println("After opening Optimizer WHAT IF page , the Save as button is not enable status");
			Extent_pass(driver, "After opening Optimizer WHAT IF page , the Save as button is  not enable status", test,
					test1);

		} else {

			System.out.println("After opening Optimizer WHAT IF page , the Save as  button is  enable status");
			Extent_fail(driver, "After opening Optimizer WHAT IF page , the Save as  button is  enable status", test,
					test1);
		}

		wait(driver, "2");
		if (!IsElementEnabled(driver, OPtimizer_print)) {

			System.out.println("After opening Optimizer WHAT IF page , the print button is not enable status");
			Extent_pass(driver, "After opening Optimizer WHAT IF page , the print button is  not enable status", test,
					test1);

		} else {

			System.out.println("After opening Optimizer WHAT IF page , the print  button is enable status");
			Extent_fail(driver, "After opening Optimizer WHAT IF page , the print  button is  enable status", test,
					test1);
		}
		wait(driver, "2");
		if (!IsElementEnabled(driver, OPtimizer_MoveToFirstRecord)) {

			System.out.println(
					"After opening Optimizer WHAT IF page , the Move to First Record button is not enable status");
			Extent_pass(driver,
					"After opening Optimizer WHAT IF page , the Move to First Record  button is  not enable status",
					test, test1);

		} else {

			System.out.println(
					"After opening Optimizer WHAT IF page , the Move to First Record   button is enable status");
			Extent_fail(driver,
					"After opening Optimizer WHAT IF page , the Move to First Record   button is enable status", test,
					test1);
		}
		wait(driver, "2");
		if (!IsElementEnabled(driver, OPtimizer_MoveToPrevious_Record)) {

			System.out.println(
					"After opening Optimizer WHAT IF page , the Move to previous Record button is  not enable status");
			Extent_pass(driver,
					"After opening Optimizer WHAT IF page , the Move to previous Record  button is  not enable status",
					test, test1);

		} else {

			System.out.println(
					"After opening Optimizer WHAT IF page , the Move to previous Record   button is  enable status");
			Extent_fail(driver,
					"After opening Optimizer WHAT IF page , the Move to previous Record   button is  enable status",
					test, test1);
		}
		wait(driver, "2");
		if (!IsElementEnabled(driver, OPtimizer_MoveToNexrRecord)) {

			System.out.println(
					"After opening Optimizer WHAT IF page , the Move to next Record button is not enable status");
			Extent_pass(driver,
					"After opening Optimizer WHAT IF page , the Move to next Record  button is not enable status", test,
					test1);

		} else {

			System.out.println(
					"After opening Optimizer WHAT IF page , the Move to next Record   button is  enable status");
			Extent_fail(driver,
					"After opening Optimizer WHAT IF page , the Move to next Record   button is  enable status", test,
					test1);
		}

		wait(driver, "2");
		if (!IsElementEnabled(driver, OPtimizer_MoveToLastRecord)) {

			System.out.println(
					"After opening Optimizer WHAT IF page , the Move to last Record button is not enable status");
			Extent_pass(driver,
					"After opening Optimizer WHAT IF page , the Move to last Record  button is  not enable status",
					test, test1);

		} else {

			System.out.println(
					"After opening Optimizer WHAT IF page , the Move to last Record   button is  enable status");
			Extent_fail(driver,
					"After opening Optimizer WHAT IF page , the Move to last Record   button is  enable status", test,
					test1);
		}
		wait(driver, "2");
		if (!IsElementEnabled(driver, OPtimizer_Magicsave)) {

			System.out.println("After opening Optimizer WHAT IF page , the Magic Save button is not enable status");
			Extent_pass(driver, "After opening Optimizer WHAT IF page , the Magic Save   button is  not enable status",
					test, test1);

		} else {

			System.out.println("After opening Optimizer WHAT IF page , the Magic Save   button is   enable status");
			Extent_fail(driver, "After opening Optimizer WHAT IF page , the Magic Save   button is  enable status",
					test, test1);
		}

		wait(driver, "2");

		Fluentwait(driver, Optimizer_Allocate_Containers);
		doubleClick(driver, Optimizer_Allocate_Containers);

		wait(driver, "2");
		sendKeys(driver, Optimizer_Allocate_Containers1, "1");

		enter(driver);

		Fluentwait(driver, Optimizer_button);
		click(driver, Optimizer_button);

		Fluentwait(driver, Optimizer_Ok1);
		click(driver, Optimizer_Ok1);

		Fluentwait(driver, close_2);
		click(driver, close_2);

		System.out.println("**********Testcase_4.1**************");

		Fluentwait(driver, Optimizer_cancle);
		click(driver, Optimizer_cancle);

		Extent_cal(test, "Testcase 4.2 -Ensure that sections avialable in optimizer screen");

		Fluentwait(driver, Optimizer_new);
		click(driver, Optimizer_new);
		wait(driver, "2");
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
		wait(driver, "8");
		Fluentwait(driver, OPtimizer_20s);
		click(driver, OPtimizer_20s);

		Fluentwait(driver, OPtimizer_sizeStpe);
		click(driver, OPtimizer_sizeStpe);

		wait(driver, "5");
		
		Fluentwait(driver, SizeType_20dy);
		click(driver, SizeType_20dy);

		Fluentwait(driver, Optimizer_Allocate_Containers);
		doubleClick(driver, Optimizer_Allocate_Containers);

		sendKeys(driver, Optimizer_Allocate_Containers1, "1");

		enter(driver);

		Fluentwait(driver, Optimizer_button);
		click(driver, Optimizer_button);

		Fluentwait(driver, Optimizer_Ok1);
		click(driver, Optimizer_Ok1);
		wait(driver, "5");

		wait(driver, "2");
		if (isDisplayed(driver, Optimizer_Equipment_Resolve)) {

			System.out.println("After opening Optimizer WHAT IF page , Equipment Reposition Solve is displayed");
			Extent_pass(driver, "After opening Optimizer WHAT IF page ,Equipment Reposition Solve is displayed", test,
					test1);

		} else {

			System.out.println("After opening Optimizer WHAT IF page , Equipment Reposition Solve is displayed");
			Extent_fail(driver, "After opening Optimizer WHAT IF page , Equipment Reposition Solve is displayed", test,
					test1);
		}

		wait(driver, "2");
		if (isDisplayed(driver, Optimizer_Equipment_Report)) {

			System.out.println("After opening Optimizer WHAT IF page , Equipment Reposition Report is displayed");
			Extent_pass(driver, "After opening Optimizer WHAT IF page ,Equipment Reposition Report is displayed", test,
					test1);

		} else {

			System.out.println("After opening Optimizer WHAT IF page , Equipment Reposition Report is displayed");
			Extent_fail(driver, "After opening Optimizer WHAT IF page , Equipment Reposition Report is displayed", test,
					test1);
		}

		wait(driver, "2");
		if (isDisplayed(driver, Optimizer_Unsatisfied_Report)) {

			System.out.println("After opening Optimizer WHAT IF page , Unsatisfied Report is displayed");
			Extent_pass(driver, "After opening Optimizer WHAT IF page , Unsatisfied Report is displayed", test, test1);

		} else {

			System.out.println("After opening Optimizer WHAT IF page , Unsatisfied Report  is displayed");
			Extent_fail(driver, "After opening Optimizer WHAT IF page ,  Unsatisfied Report is displayed", test, test1);
		}

		wait(driver, "2");
		if (isDisplayed(driver, Optimizer_Lease_Report)) {

			System.out.println("After opening Optimizer WHAT IF page , Lease Report is displayed");
			Extent_pass(driver, "After opening Optimizer WHAT IF page , Lease Report is displayed", test, test1);

		} else {

			System.out.println("After opening Optimizer WHAT IF page , Lease Report  is displayed");
			Extent_fail(driver, "After opening Optimizer WHAT IF page ,  Lease Report is displayed", test, test1);
		}

		wait(driver, "2");
		if (isDisplayed(driver, Optimizer_Hire_Report)) {

			System.out.println("After opening Optimizer WHAT IF page , Hire Report is displayed");
			Extent_pass(driver, "After opening Optimizer WHAT IF page , Hire Report is displayed", test, test1);

		} else {

			System.out.println("After opening Optimizer WHAT IF page , Hire Report  is displayed");
			Extent_fail(driver, "After opening Optimizer WHAT IF page ,  Hire Report is displayed", test, test1);
		}

		wait(driver, "2");
		if (isDisplayed(driver, Optimizer_Ero_Chart)) {

			System.out.println("After opening Optimizer WHAT IF page ,ERO Chart is displayed");
			Extent_pass(driver, "After opening Optimizer WHAT IF page , ERO Chart is displayed", test, test1);

		} else {

			System.out.println("After opening Optimizer WHAT IF page , ERO Chart is displayed");
			Extent_fail(driver, "After opening Optimizer WHAT IF page , ERO Chart is displayed", test, test1);
		}

		System.out.println("**********Testcase_4.2**************");

		Fluentwait(driver, close_2);
		click(driver, close_2);

		Extent_cal(test, "Testcase 4.3 -Ensure that containers get displayed in Equipment Reposition Solve section");

		Fluentwait(driver, OPtimizer_all);
		click(driver, OPtimizer_all);
		wait(driver, "2");
		Fluentwait(driver, Optimizer_button);
		click(driver, Optimizer_button);

		Fluentwait(driver, Optimizer_Ok1);
		click(driver, Optimizer_Ok1);
	
		wait(driver, "5");
		wait(driver, "2");
		if (isDisplayed(driver, Optimizer_Equipment_Reposition_Resolve_20DY)) {
			System.out.println("After navigating Equipment Reposition Solve, 20DY section is displayed ");
			Extent_pass(driver, "After navigating Equipment Reposition Solve, 20DY section is displayed ", test, test1);
		} else {
			System.out.println("After navigating Equipment Reposition Solve, 20DY section is not displayed ");
			Extent_fail(driver, "After navigating Equipment Reposition Solve, 20DY section is not displayed ", test,
					test1);
		}
		wait(driver, "2");
		if (isDisplayed(driver, Optimizer_Equipment_Reposition_Resolve_20HC)) {
			System.out.println("After navigating Equipment Reposition Solve, 20HC section is displayed ");
			Extent_pass(driver, "After navigating Equipment Reposition Solve, 20HC section is displayed ", test, test1);
		} else {
			System.out.println("After navigating Equipment Reposition Solve, 20HC section is not displayed ");
			Extent_fail(driver, "After navigating Equipment Reposition Solve, 20HC section is not displayed ", test,
					test1);
		}

		wait(driver, "2");
		if (isDisplayed(driver, Optimizer_Equipment_Reposition_Resolve_40HH)) {
			System.out.println("After navigating Equipment Reposition Solve, 20HH section is displayed ");
			Extent_pass(driver, "After navigating Equipment Reposition Solve, 20HH section is displayed ", test, test1);
		} else {
			System.out.println("After navigating Equipment Reposition Solve, 20HH section is not displayed ");
			Extent_fail(driver, "After navigating Equipment Reposition Solve, 20HH section is not displayed ", test,
					test1);
		}

		wait(driver, "2");
		if (isDisplayed(driver, Optimizer_Equipment_Reposition_Resolve_40RF)) {
			System.out.println("After navigating Equipment Reposition Solve, 20RF section is displayed ");
			Extent_pass(driver, "After navigating Equipment Reposition Solve, 20RF section is displayed ", test, test1);
		} else {
			System.out.println("After navigating Equipment Reposition Solve, 20RF section is not displayed ");
			Extent_fail(driver, "After navigating Equipment Reposition Solve, 20RF section is not displayed ", test,
					test1);
		}
		wait(driver, "2");
		if (isDisplayed(driver, Optimizer_Equipment_Reposition_Resolve_40HC)) {
			System.out.println("After navigating Equipment Reposition Solve, 40HC section is displayed ");
			Extent_pass(driver, "After navigating Equipment Reposition Solve, 40HC section is displayed ", test, test1);
		} else {
			System.out.println("After navigating Equipment Reposition Solve, 40HC section is not displayed ");
			Extent_fail(driver, "After navigating Equipment Reposition Solve, 40HC section is not displayed ", test,
					test1);
		}

		wait(driver, "2");
		if (isDisplayed(driver, Optimizer_Equipment_Reposition_Resolve_40HR)) {
			System.out.println("After navigating Equipment Reposition Solve, 40HR section is displayed ");
			Extent_pass(driver, "After navigating Equipment Reposition Solve, 40HR section is displayed ", test, test1);
		} else {
			System.out.println("After navigating Equipment Reposition Solve, 40HR section is not displayed ");
			Extent_fail(driver, "After navigating Equipment Reposition Solve, 40HR section is not displayed ", test,
					test1);
		}

		wait(driver, "2");
		if (isDisplayed(driver, Optimizer_Equipment_Reposition_Resolve_40OT)) {
			System.out.println("After navigating Equipment Reposition Solve, 40OT section is displayed ");
			Extent_pass(driver, "After navigating Equipment Reposition Solve, 40OT section is displayed ", test, test1);
		} else {
			System.out.println("After navigating Equipment Reposition Solve, 40OT section is not displayed ");
			Extent_fail(driver, "After navigating Equipment Reposition Solve, 40OT section is not displayed ", test,
					test1);
		}
		System.out.println("**********Testcase_4.3**************");

		Extent_cal(test, "Testcase 4.4 -Esure that data get displayed properly in each containers type");

		Fluentwait(driver, close_2);
		click(driver, close_2);

		wait(driver, "2");

		Fluentwait(driver, Optimizer_Allocate_Containers);
		doubleClick(driver, Optimizer_Allocate_Containers);

		clear(driver, Optimizer_Allocate_Containers1);

		wait(driver, "2");

		Fluentwait(driver, Optimizer_Allocate_Containers5);
		doubleClick(driver, Optimizer_Allocate_Containers5);

		wait(driver, "2");
		sendKeys(driver, Optimizer_Allocate_Containers_input, Containers);

		enter(driver);

		String surplus_Location = getText(driver, Optimizer_Grid_locationfield5);

		String Deficit_LocationName = getText(driver, Deficit_Location_name);

		wait(driver, "2");
		Fluentwait(driver, Optimizer_button);
		click(driver, Optimizer_button);

		Fluentwait(driver, Optimizer_Ok1);
		click(driver, Optimizer_Ok1);
		wait(driver, "5");

		List<WebElement> headers = driver.findElements(By.xpath("//thead[@id='OPT-OPT_treeTable_head']//th"));

		int size = headers.size();

		int columnnumber = 0;

		for (int i = 1; i < size; i++) {

			String DeficitName = driver.findElement(By.xpath("(//thead[@id='OPT-OPT_treeTable_head']//th)[" + i + "]"))
					.getAttribute("aria-label");

			if (DeficitName.equals(Deficit_LocationName)) {

				break;
			} else {

				columnnumber++;
			}

		}

		System.out.println("columnnumber : " + columnnumber);

		List<WebElement> Bodycontent = driver.findElements(By.xpath("//tbody[@id='OPT-OPT_treeTable_data']//tr"));

		int size2 = Bodycontent.size();

		String SurplusName = driver
				.findElement(By.xpath("(//tbody[@id='OPT-OPT_treeTable_data']//tr/following::td[contains(text(),'"
						+ surplus_Location + "')]//following::td)[" + columnnumber + "]"))
				.getText();

		System.out.println("SurplusName : " + SurplusName);

		String[] countt = SurplusName.split("\\[");

		String count = countt[1].trim().substring(0, 1);

		System.out.println("count : " + count);

		if (count.equals(Containers)) {

			System.out.println("Allocated count was correctly showing in the optimizer ");
			Extent_pass(driver, "Allocated count was correctly showing in the optimizer ", test, test1);
		} else {
			System.out.println("Allocated count was not correctly showing in the optimizer ");
			Extent_fail(driver, "Allocated count was not correctly showing in the optimizer ", test, test1);
		}

//		Extent_cal(test,
//				"Testcase 4.5 -Ensure that container size get displayed under location field which size type is selected");
//
//		Fluentwait(driver, close_2);
//		click(driver, close_2);
//		wait(driver, "2");
//		Fluentwait(driver, Optimizer_cancle);
//		click(driver, Optimizer_cancle);
//		Fluentwait(driver, Optimizer_new);
//		click(driver, Optimizer_new);
//		wait(driver, "2");
//		Fluentwait(driver, Optimizer_createnew_confirm);
//		click(driver, Optimizer_createnew_confirm);
//		Fluentwait(driver, Optimizer_Globalserach);
//		click(driver, Optimizer_Globalserach);
//
//		Fluentwait(driver, Globalserach_IDInput);
//		sendKeys(driver, Globalserach_IDInput, "B20240829-01-52-00016");
//
//		wait(driver, "2");
//
//		Fluentwait(driver, Click_Search);
//		click(driver, Click_Search);
//
//		wait(driver, "5");
//
//		Fluentwait(driver, SelectID);
//		doubleClick(driver, SelectID);
//		wait(driver, "8");
//
//		Fluentwait(driver, Optimizer_button);
//		click(driver, Optimizer_button);
//
//		Fluentwait(driver, Optimizer_Ok1);
//		click(driver, Optimizer_Ok1);
//		wait(driver, "5");
//
//		String EXp_OPti_20DY = getText(driver, Optimizer_Equipment_Reposition_Resolve_20DY);
//		System.out.println("OPti_20DY :" + EXp_OPti_20DY);
//		wait(driver, "2");
//
//		String Act_OPti_20DY = getText(driver, Optimizer_Equipment_container);
//		System.out.println("OPti_20DY :" + Act_OPti_20DY);
//		wait(driver, "2");
//		if (Act_OPti_20DY.equals(EXp_OPti_20DY)) {
//			System.out.println("After click on Equipment Reposition Solve,containers type value display correctly");
//			Extent_pass(driver, "Expected value was:" + EXp_OPti_20DY + "Actual value was :" + Act_OPti_20DY, test,
//					test1);
//		} else {
//			System.out.println("After click on Equipment Reposition Solve,containers type value display wrongly");
//			Extent_fail(driver, "Expected value was:" + EXp_OPti_20DY + "Actual value was :" + Act_OPti_20DY, test,
//					test1);
//			global = "After click on Equipment Reposition Solve,containers type value display wrongly";
//		}
//
//		wait(driver, "2");
//		Fluentwait(driver, Optimizer_Equipment_Reposition_Resolve_20HC);
//		click(driver, Optimizer_Equipment_Reposition_Resolve_20HC);
//		wait(driver, "2");
//		String EXp_OPti_20hc = getText(driver, Optimizer_Equipment_Reposition_Resolve_20HC);
//		System.out.println("OPti_20DY :" + EXp_OPti_20hc);
//		wait(driver, "2");
//
//		String Act_OPti_20HC = getText(driver, Optimizer_Equipment_container);
//		System.out.println("OPti_20DY :" + Act_OPti_20HC);
//		wait(driver, "2");
//		if (Act_OPti_20HC.equals(EXp_OPti_20hc)) {
//			System.out.println("After click on Equipment Reposition Solve,containers type value display correctly");
//			Extent_pass(driver, "Expected value was:" + EXp_OPti_20hc + "Actual value was :" + Act_OPti_20HC, test,
//					test1);
//		} else {
//			System.out.println("After click on Equipment Reposition Solve,containers type value display wrongly");
//			Extent_fail(driver, "Expected value was:" + EXp_OPti_20hc + "Actual value was :" + Act_OPti_20HC, test,
//					test1);
//			global = "After click on Equipment Reposition Solve,containers type value display wrongly";
//		}
//
//		wait(driver, "2");
//		Fluentwait(driver, Optimizer_Equipment_Reposition_Resolve_40HH);
//		click(driver, Optimizer_Equipment_Reposition_Resolve_40HH);
//		wait(driver, "2");
//		String EXp_OPti_20HH = getText(driver, Optimizer_Equipment_Reposition_Resolve_40HH);
//		System.out.println("EXp_OPti_20HH :" + EXp_OPti_20HH);
//		wait(driver, "2");
//
//		String Act_OPti_20HH = getText(driver, Optimizer_Equipment_container);
//		System.out.println("Act_OPti_20HH :" + Act_OPti_20HH);
//		wait(driver, "2");
//		if (Act_OPti_20HH.equals(EXp_OPti_20HH)) {
//			System.out.println("After click on Equipment Reposition Solve,containers type value display correctly");
//			Extent_pass(driver, "Expected value was:" + EXp_OPti_20HH + "Actual value was :" + Act_OPti_20HH, test,
//					test1);
//		} else {
//			System.out.println("After click on Equipment Reposition Solve,containers type value display wrongly");
//			Extent_fail(driver, "Expected value was:" + EXp_OPti_20HH + "Actual value was :" + Act_OPti_20HH, test,
//					test1);
//			global = "After click on Equipment Reposition Solve,containers type value display wrongly";
//		}
//
//		wait(driver, "2");
//		Fluentwait(driver, Optimizer_Equipment_Reposition_Resolve_40RF);
//		click(driver, Optimizer_Equipment_Reposition_Resolve_40RF);
//		wait(driver, "2");
//		String EXp_OPti_20RF = getText(driver, Optimizer_Equipment_Reposition_Resolve_40RF);
//		System.out.println("EXp_OPti_20RF :" + EXp_OPti_20RF);
//		wait(driver, "2");
//
//		String Act_OPti_20RF = getText(driver, Optimizer_Equipment_container);
//		System.out.println("Act_OPti_20RF :" + Act_OPti_20RF);
//		wait(driver, "2");
//		if (Act_OPti_20RF.equals(EXp_OPti_20RF)) {
//			System.out.println("After click on Equipment Reposition Solve,containers type value display correctly");
//			Extent_pass(driver, "Expected value was:" + EXp_OPti_20RF + "Actual value was :" + Act_OPti_20RF, test,
//					test1);
//		} else {
//			System.out.println("After click on Equipment Reposition Solve,containers type value display wrongly");
//			Extent_fail(driver, "Expected value was:" + EXp_OPti_20RF + "Actual value was :" + Act_OPti_20RF, test,
//					test1);
//			global = "After click on Equipment Reposition Solve,containers type value display wrongly";
//		}
//
//		wait(driver, "2");
//		Fluentwait(driver, Optimizer_Equipment_Reposition_Resolve_40DY);
//		click(driver, Optimizer_Equipment_Reposition_Resolve_40DY);
//		wait(driver, "2");
//		String EXp_OPti_40DY = getText(driver, Optimizer_Equipment_Reposition_Resolve_40DY);
//		System.out.println("EXp_OPti_40DY :" + EXp_OPti_40DY);
//		wait(driver, "2");
//
//		String Act_OPti_40DY = getText(driver, Optimizer_Equipment_container);
//		System.out.println("Act_OPti_40DY :" + Act_OPti_40DY);
//		wait(driver, "2");
//		if (Act_OPti_40DY.equals(EXp_OPti_40DY)) {
//			System.out.println("After click on Equipment Reposition Solve,containers type value display correctly");
//			Extent_pass(driver, "Expected value was:" + EXp_OPti_40DY + "Actual value was :" + Act_OPti_40DY, test,
//					test1);
//		} else {
//			System.out.println("After click on Equipment Reposition Solve,containers type value display wrongly");
//			Extent_fail(driver, "Expected value was:" + EXp_OPti_40DY + "Actual value was :" + Act_OPti_40DY, test,
//					test1);
//			global = "After click on Equipment Reposition Solve,containers type value display wrongly";
//		}
//
//		wait(driver, "2");
//		Fluentwait(driver, Optimizer_Equipment_Reposition_Resolve_40HC);
//		click(driver, Optimizer_Equipment_Reposition_Resolve_40HC);
//		wait(driver, "2");
//		String EXp_OPti_40HC = getText(driver, Optimizer_Equipment_Reposition_Resolve_40HC);
//		System.out.println("EXp_OPti_40HC :" + EXp_OPti_40HC);
//		wait(driver, "2");
//
//		String Act_OPti_40HC = getText(driver, Optimizer_Equipment_container);
//		System.out.println("Act_OPti_40HC :" + Act_OPti_40HC);
//		wait(driver, "2");
//		if (Act_OPti_40HC.equals(EXp_OPti_40HC)) {
//			System.out.println("After click on Equipment Reposition Solve,containers type value display correctly");
//			Extent_pass(driver, "Expected value was:" + EXp_OPti_40HC + "Actual value was :" + Act_OPti_40HC, test,
//					test1);
//		} else {
//			System.out.println("After click on Equipment Reposition Solve,containers type value display wrongly");
//			Extent_fail(driver, "Expected value was:" + EXp_OPti_40HC + "Actual value was :" + Act_OPti_40HC, test,
//					test1);
//			global = "After click on Equipment Reposition Solve,containers type value display wrongly";
//		}
//
//		wait(driver, "2");
//		Fluentwait(driver, Optimizer_Equipment_Reposition_Resolve_40HR);
//		click(driver, Optimizer_Equipment_Reposition_Resolve_40HR);
//		wait(driver, "2");
//		String EXp_OPti_40HR = getText(driver, Optimizer_Equipment_Reposition_Resolve_40HR);
//		System.out.println("EXp_OPti_40HR :" + EXp_OPti_40HR);
//		wait(driver, "2");
//
//		String Act_OPti_40HR = getText(driver, Optimizer_Equipment_container);
//		System.out.println("Act_OPti_40HR :" + Act_OPti_40HR);
//		wait(driver, "2");
//		if (Act_OPti_40HR.equals(EXp_OPti_40HR)) {
//			System.out.println("After click on Equipment Reposition Solve,containers type value display correctly");
//			Extent_pass(driver, "Expected value was:" + EXp_OPti_40HR + "Actual value was :" + Act_OPti_40HR, test,
//					test1);
//		} else {
//			System.out.println("After click on Equipment Reposition Solve,containers type value display wrongly");
//			Extent_fail(driver, "Expected value was:" + EXp_OPti_40HR + "Actual value was :" + Act_OPti_40HR, test,
//					test1);
//			global = "After click on Equipment Reposition Solve,containers type value display wrongly";
//		}
//
//		wait(driver, "2");
//		Fluentwait(driver, Optimizer_Equipment_Reposition_Resolve_40OT);
//		click(driver, Optimizer_Equipment_Reposition_Resolve_40OT);
//		wait(driver, "2");
//		String EXp_OPti_40OT = getText(driver, Optimizer_Equipment_Reposition_Resolve_40OT);
//		System.out.println("EXp_OPti_40OT :" + EXp_OPti_40OT);
//		wait(driver, "2");
//
//		String Act_OPti_40OT = getText(driver, Optimizer_Equipment_container);
//		System.out.println("Act_OPti_40OT :" + Act_OPti_40OT);
//		wait(driver, "2");
//		if (Act_OPti_40OT.equals(EXp_OPti_40OT)) {
//			System.out.println("After click on Equipment Reposition Solve,containers type value display correctly");
//			Extent_pass(driver, "Expected value was:" + EXp_OPti_40OT + "Actual value was :" + Act_OPti_40OT, test,
//					test1);
//		} else {
//			System.out.println("After click on Equipment Reposition Solve,containers type value display wrongly");
//			Extent_fail(driver, "Expected value was:" + EXp_OPti_40OT + "Actual value was :" + Act_OPti_40OT, test,
//					test1);
//			global = "After click on Equipment Reposition Solve,containers type value display wrongly";
//		}
//		System.out.println("**********Testcase_4.5**************");
//
//		Extent_cal(test, "Testcase 4.6 -Ensure that deficit quantity are highlighted in green colour");
//
//		Fluentwait(driver, Optimizer_Equipment_Reposition_Resolve_20DY);
//		click(driver, Optimizer_Equipment_Reposition_Resolve_20DY);
//
//		wait(driver, "3");
//		mouseOverAndClick(driver, OPtimizer_deficit_colour);
//		wait(driver, "3");
//		String deficit_color = getTextBackgroundColor(driver, OPtimizer_deficit_colour);
//		System.out.println("deficit_color :" + deficit_color);
//		wait(driver, "2");
//
//		if (deficit_color.equals(Deficit)) {
//			System.out.println("deficit quantity are highlighted in green colour");
//			Extent_pass(driver, "Expected colour was:" + deficit_color + "Actual value was :" + Deficit, test, test1);
//		} else {
//			Extent_fail(driver, "Expected colour was:" + deficit_color + "Actual value was :" + Deficit, test, test1);
//			global = "Expected colour was:" + deficit_color + "Actual value was :" + Deficit;
//		}
//		System.out.println("**********Testcase_4.6**************");
//
//		Extent_cal(test, "Testcase 4.7 -Ensure that surplus quantity are highlighted in red colour");
//
//		wait(driver, "3");
//		String surplus_color = getTextBackgroundColor(driver, Optimizer_surplus_color);
//		System.out.println("surplus_color :" + surplus_color);
//		wait(driver, "2");
//
//		if (surplus_color.equals(Surplus_colour)) {
//			System.out.println("surplus quantity are highlighted in red colour");
//			Extent_pass(driver, "Expected colour was:" + surplus_color + "Actual value was :" + Surplus_colour, test,
//					test1);
//		} else {
//			Extent_fail(driver, "Expected colour was:" + surplus_color + "Actual value was :" + Surplus_colour, test,
//					test1);
//			global = "Expected colour was:" + surplus_color + "Actual value was :" + Surplus_colour;
//		}
//
//		System.out.println("**********Testcase_4.7**************");
//
//		Extent_cal(test, "Testcase 4.8 -Ensure that Reposition allocated are highlighted in sky blue colour");
//
//		wait(driver, "3");
//		String Reposition_Allocate = getTextBackgroundColor(driver, OPtimizer_Reposition_Allocated);
//		System.out.println("Reposition_Allocated :" + Reposition_Allocate);
//		wait(driver, "3");
//		if (Reposition_Allocate.equals(Reposition_Allocated)) {
//			System.out.println("Reposition allocated are highlighted in sky blue colour");
//			Extent_pass(driver,
//					"Expected colour was:" + Reposition_Allocate + "Actual value was :" + Reposition_Allocated, test,
//					test1);
//		} else {
//			Extent_fail(driver,
//					"Expected colour was:" + Reposition_Allocate + "Actual value was :" + Reposition_Allocated, test,
//					test1);
//			global = "Expected colour was:" + Reposition_Allocate + "Actual value was :" + Reposition_Allocated;
//		}
//
//		System.out.println("**********Testcase_4.8**************");
//
//		Extent_cal(test, "Testcase 4.9 -Ensure that on /off hire allocated are highlighted in light green colour");
//
//		wait(driver, "3");
//		String Reposition_OnandOf = getTextBackgroundColor(driver, OPtimizer_onAndOff);
//		System.out.println("Reposition_OnandOf :" + Reposition_OnandOf);
//
//		if (Reposition_OnandOf.equals(OnAndOff_colour)) {
//			System.out.println("on /off hire allocated are highlighted in light green colour");
//			Extent_pass(driver, "Expected colour was:" + Reposition_OnandOf + "Actual value was :" + OnAndOff_colour,
//					test, test1);
//		} else {
//			Extent_fail(driver, "Expected colour was:" + Reposition_OnandOf + "Actual value was :" + OnAndOff_colour,
//					test, test1);
//			global = "Expected colour was:" + Reposition_OnandOf + "Actual value was :" + OnAndOff_colour;
//		}
//		System.out.println("**********Testcase_4.9**************");
//
//		Extent_cal(test, "Testcase 4.10-Ensure that One-Way Lease Allocated are highlighted in yellow colour");
//
//		wait(driver, "3");
//		String OnewayLease = getTextBackgroundColor(driver, OPtimizer_One_Way_Lease);
//		System.out.println("OnewayLease :" + OnewayLease);
//
//		if (OnewayLease.equals(One_waylease)) {
//			System.out.println("One-Way Lease allocated are highlighted in light yellow colour");
//			Extent_pass(driver, "Expected colour was:" + OnewayLease + "Actual value was :" + One_waylease, test,
//					test1);
//		} else {
//			Extent_fail(driver, "Expected colour was:" + OnewayLease + "Actual value was :" + One_waylease, test,
//					test1);
//			global = "Expected colour was:" + OnewayLease + "Actual value was :" + One_waylease;
//		}
//		System.out.println("**********Testcase_4.10**************");
//
//		Extent_cal(test, "Testcase 4.12-Ensure that surplus quantity displayed properly");
//
//		wait(driver, "2");
//		Actions action=new Actions(driver);
//		
//		int totalAmountAct = 0;
//	
//		boolean loopRun=true;
//		int l=0;
//		while(loopRun) {
//			try {
//				WebElement cellEle=driver.findElement(By.xpath("//tbody[@id='OPT-OPT_treeTable_data']/tr[@data-ri='"+l+"']/td[2]"));
//				String CellText = cellEle.getText();
//				if (!CellText.isEmpty() || !CellText.equals("")) {
//					int cellNum = Integer.parseInt(CellText);
//					totalAmountAct=totalAmountAct+cellNum;
//				}
//				action.moveToElement(cellEle).build().perform();
//				
//			}catch(Exception e) {
//				loopRun=false;
//			}
//			l++;
//		}
//		
//		wait(driver, "2");
//
//		Fluentwait(driver, Optimizer_surplus_qty);
//		String Exe = getAttribute(driver, Optimizer_surplus_qty, "value");
//		int Exe_val = Integer.parseInt(Exe);
//
//		if (totalAmountAct == Exe_val) {
//
//			Extent_pass(driver, "Expected value was:" + Exe_val + "Actual value was :" + totalAmountAct, test, test1);
//		} else {
//
//			Extent_fail(driver, "Expected value was:" + Exe_val + "Actual value was :" + totalAmountAct, test, test1);
//			global = "Expected value was:" + Exe_val + "Actual value was :" + totalAmountAct;
//		}
//
//		
//		System.out.println("**********Testcase_4.12**************");
//
//		Extent_cal(test, "Testcase 4.13-Ensure that deficit quantity displayed properly");
//		wait(driver, "2");
//
//		List<WebElement> deficit = driver.findElements(By.xpath("//tbody[@id='OPT-OPT_treeTable_data']/tr[@data-ri='0']/td"));
//		int Deficit_val = deficit.size();
//		int deficit_totalval = 0;
//
//		for (int i = 2; i < Deficit_val; i++) {
//			WebElement val = deficit.get(i);
//
//			String celltext = val.getText();
//			if (!celltext.isEmpty() || !celltext.equals("")) {
//				int cellNum = Integer.parseInt(celltext);
//				deficit_totalval = deficit_totalval + cellNum;
//
//			}
//		}
//
//		wait(driver, "2");
//
//		Fluentwait(driver, Optimizer_Deficit_qty);
//		String Exe1 = getAttribute(driver, Optimizer_Deficit_qty, "value");
//		int Exe_val1 = Integer.parseInt(Exe1);
//		System.out.println("Exe_val1 :" + Exe_val1);
//
//		if (deficit_totalval == Exe_val1) {
//
//			Extent_pass(driver, "Expected value was:" + Exe_val1 + "Actual value was :" + deficit_totalval, test,test1);
//		} else {
//
//			Extent_fail(driver, "Expected value was:" + Exe_val1 + "Actual value was :" + deficit_totalval, test,test1);
//			global = "Expected value was:" + Exe_val1 + "Actual value was :" + deficit_totalval;
//		}
//
//		System.out.println("**********Testcase_4.13**************");
//
//		Extent_cal(test, "Testcase 4.14-Ensure that total quantity displayed properly");
//
//		wait(driver, "4");
//
//		List<WebElement> ave = driver.findElements(By.xpath("//tbody[@id='OPT-OPT_treeTable_data']//tr/td[@class='sm-bg-aqua ' or contains(@class,'yellow')]"));
//		int ave_val = ave.size();
//		System.out.println("ave_val size : "+ave_val);
//		int ave_totalval=0;
//		int multiplyValue=0;
//		
//		for (int i = 0; i < ave_val; i++) {
//			WebElement val = ave.get(i);
//			String CellText = val.getText();
//			int startIndex = CellText.indexOf('[');
//			int endIndex = CellText.indexOf(']');
//			String CellContainer = CellText.substring(startIndex + 1, endIndex);
//			String CellPriceText = CellText.substring(0, startIndex).trim();
//
//		    int numericValue = Integer.parseInt(CellContainer);
//		    int priceValue=Integer.parseInt(CellPriceText);
//		    System.out.println(i+" :  "+numericValue+"  "+priceValue);
//		    multiplyValue=multiplyValue+(numericValue*priceValue);
//		    
//		    ave_totalval=ave_totalval+numericValue;
//		}
//
//		
//		
//		wait(driver, "2");
//		Fluentwait(driver, Optimzer_Total_cost);
//		String Ave_Exe = getAttribute(driver, Optimzer_Total_cost, "value");
//		int AveExe_val = Integer.parseInt(Ave_Exe);
//		System.out.println("AveExe_val :" + AveExe_val);
//
//		if (ave_totalval == AveExe_val) {
//
//			Extent_pass(driver, "Expected value was:" + AveExe_val + "Actual value was :" + ave_totalval, test,
//					test1);
//		} else {
//
//			Extent_fail(driver, "Expected value was:" + AveExe_val + "Actual value was :" + ave_totalval, test,
//					test1);
//			global = "Expected value was:" + AveExe_val + "Actual value was :" + ave_totalval;
//		}
//		
//			
//		double Average_Act=(multiplyValue/ave_totalval);
//		System.out.println("multiplyValue : "+multiplyValue);
//		System.out.println("ave_totalval : "+ave_totalval);
//		System.out.println("Average_Act : "+Average_Act);
//		
//		wait(driver,"2");
//		
//		System.out.println("**********Testcase_4.14**************");	
//		
//		Extent_cal(test, "Testcase 4.15-Ensure that Average Cost Per Box  displayed properly");
//		wait(driver,"2");
//		String avg_cost=getAttribute(driver, Optimzer_Aveage_cost, "value");
//		double avg_cost1 = Double.parseDouble(avg_cost);
//		System.out.println("avg_cost :"+avg_cost);
//		
//		if (avg_cost1 == Average_Act) {
//
//			Extent_pass(driver, "Expected value was:" + Average_Act + "Actual value was :" + avg_cost1, test,
//					test1);
//		} else {
//
//			Extent_fail(driver, "Expected value was:" + Average_Act + "Actual value was :" + avg_cost1, test,
//					test1);
//			global = "Expected value was:" + Average_Act + "Actual value was :" + avg_cost1;
//		}
//		
//		System.out.println("**********Testcase_4.15**************");	
//		
//		Extent_cal(test, "Testcase 4.16-Ensure that Grand total displayed properly");
//		
//		wait(driver,"3");
//		String Total_cost=getAttribute(driver, Optimzer_Total_cost, "value");
//		double Total_cost1 = Double.parseDouble(Total_cost);
//		System.out.println("total_cost :"+Total_cost);
//		
//		if (Total_cost1 == multiplyValue) {
//
//			Extent_pass(driver, "Expected value was:" + multiplyValue + "Actual value was :" + Total_cost1, test,
//					test1);
//		} else {
//
//			Extent_fail(driver, "Expected value was:" + multiplyValue + "Actual value was :" + Total_cost1, test,
//					test1);
//			global = "Expected value was:" + multiplyValue + "Actual value was :" + Total_cost1;
//		}
//		
//		System.out.println("**********Testcase_4.16**************");	

	}
}