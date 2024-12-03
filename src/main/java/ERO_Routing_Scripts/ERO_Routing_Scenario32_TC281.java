package ERO_Routing_Scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.Utils;

public class ERO_Routing_Scenario32_TC281 extends Keywords {
	public void Scenario32(WebDriver driver, ExtentTest test, ExtentTest test1, String url, int dataset) {

		String Username = Utils.getDataFromTestData("ERO_Scenario32_Dataset"+dataset, "ERO Routing", "Username");
		String Password = Utils.getDataFromTestData("ERO_Scenario32_Dataset"+dataset, "ERO Routing", "Password");
		String ID = Utils.getDataFromTestData("ERO_Scenario32_Dataset"+dataset, "ERO Routing", "Id");
		String Template_Name = Utils.getDataFromTestData("ERO_Scenario32_Dataset"+dataset, "ERO Routing", "Template_Name");

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
		
		Extent_cal(test,
				"Testcase 281 - Ensure while clicking save template button, templated buttons should be in Enable status");

		Fluentwait(driver, Searchbox);
		sendKeys(driver, Searchbox, "ERO Routing");

		Fluentwait(driver, SelectERO);
		click(driver, SelectERO);

		wait(driver, "5");
		Fluentwait(driver, Routing_GlobalSearch);
		click(driver, Routing_GlobalSearch);

		Fluentwait(driver, Globalserach_IDInput);
		sendKeys(driver, Globalserach_IDInput, ID);

		Fluentwait(driver, Click_Search);
		click(driver, Click_Search);

		wait(driver, "3");
		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);

		wait(driver, "3");

		Fluentwait(driver, ERO_Save_ok);
		click(driver, ERO_Save_ok);

		wait(driver, "5");
		Fluentwait(driver, ERO_Treetable);
		click(driver, ERO_Treetable);

		wait(driver, "2");

		Fluentwait(driver, SaveTemplate);
		click(driver, SaveTemplate);

		if (isDisplayed(driver, saveTemplate_screen)) {
			System.out.println("After click on save template button , template screen is enable");
			Extent_pass(driver, "After click on save template button , template screen is enable", test, test1);

		} else {
			System.out.println("After click on save template button , template screen is not enable");
			Extent_pass(driver, "After click on save template button , template screen is not enable", test, test1);

		}
		System.out.println("**************281*************");

		Extent_cal(test,
				"Testcase 282 - Ensure while clicking save template cancle button, templated buttons should be in cancle");

		Fluentwait(driver, ERO_Treetable);
		click(driver, ERO_Treetable);
	
		wait(driver,"2");	
		Fluentwait(driver, ERosave_template_as);
		click(driver, ERosave_template_as);

		Fluentwait(driver, EROSaveTemplateInput);
		sendKeys(driver, EROSaveTemplateInput, Template_Name);
		wait(driver, "2");
		click(driver, SaveTemplateCancel);

		if (!isDisplayed(driver, SaveTemplateInput)) {
			System.out.println("After click on save template  cancle button , template screen is cancle sucessfully");
			Extent_pass(driver, "After click on save template  cancle button , template screen is cancle sucessfully",
					test, test1);

		} else {
			System.out.println("After click on save template  cancle button , template screen is not cancle");
			Extent_fail(driver, "After click on save template  cancle button , template screen is not cancle", test,
					test1);

		}

		System.out.println("**************282*************");

		Extent_cal(test,
				"Testcase 283 -- Ensure while provide duplicate value  and click on  save template save button, templated buttons should not be  save");

		Fluentwait(driver, ERO_Treetable);
		click(driver, ERO_Treetable);

		wait(driver, "2");

		Fluentwait(driver, ERosave_template_as);
		click(driver, ERosave_template_as);

		sendKeys(driver, EROSaveTemplateInput, Template_Name);

		wait(driver, "2");

		Fluentwait(driver, save_template);
		alertAccept(driver, save_template);
		wait(driver, "3");
		click(driver, SaveTemplateCancel);
		boolean errorAlert = isAlertPresent(driver);
		if (isDisplayed(driver, save_template)) {
			System.out.println("After provid duplicate value, duplicate value  not accept the value sucessfully");
			Extent_pass(driver, "After provid duplicate value, duplicate value not  accept the value sucessfully", test,
					test1);
		} else {

			System.out.println("After provid duplicate value, duplicate value  accept the value sucessfully");
			Extent_fail(driver, "After click on save template  cancle button , template screen is not cancle", test,
					test1);
		}

		wait(driver, "2");

		System.out.println("**************283*************");

	}
}