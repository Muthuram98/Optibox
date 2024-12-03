package ERO_Routing_Scripts;

import java.awt.Robot;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.Utils;

public class ERO_Routing_Scenario13_TC111toTC112 extends Keywords {
	
	public void ERO_Scenario13(WebDriver driver, ExtentTest test, ExtentTest test1, String url, int dataset) throws Exception {

		String Username = Utils.getDataFromTestData("ERO_Scenario13_Dataset"+dataset, "ERO Routing", "Username");
		String Password = Utils.getDataFromTestData("ERO_Scenario13_Dataset"+dataset, "ERO Routing", "Password");
		String ID = Utils.getDataFromTestData("ERO_Scenario13_Dataset"+dataset, "ERO Routing", "Id");
		
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
		Fluentwait(driver, Route);
		click(driver, Route);

		wait(driver, "5");

		Fluentwait(driver, ERO_Popup_Ok);
		click(driver, ERO_Popup_Ok);

		Extent_cal(test, "Testcase 111,Ensure All size type radio button functionality ");

		String alloption = getAttribute(driver, All_option, "checked");

		System.out.println("All option :" + alloption);

		if (IsElementEnabled(driver, All_option)) {
			Extent_pass(driver, "All size type button is enabled", test,test1);
		} else {
			Extent_fail(driver, "All size type button is not enabled", test,test1);
		}
		wait(driver, "2");

		if (!IsElementEnabled(driver, Disable_SizeType)) {
			Extent_pass(driver, "Size type option is disabled", test,test1);
		} else {
			Extent_fail(driver, "All size type button is not disabled", test,test1);
		}

		System.out.println("Testcase 111 completed");

		Extent_cal(test, "Testcase 112,Ensure Single size type radio button functionality  ");

		Fluentwait(driver, All_20s_Option);
		click(driver, All_20s_Option);
		wait(driver, "2");

		if (IsElementEnabled(driver, Disable_SizeType)) {
			Extent_pass(driver, "Size type option is disabled", test,test1);
		} else {
			Extent_fail(driver, "All size type button is not disabled", test,test1);
		}

		Fluentwait(driver, All_40s_Option);
		click(driver, All_40s_Option);
		wait(driver, "2");

		if (IsElementEnabled(driver, Disable_SizeType)) {
			Extent_pass(driver, "Size type option is disabled", test,test1);
		} else {
			Extent_fail(driver, "All size type button is not disabled", test,test1);
		}
		System.out.println("Testcase 112 completed");

	
		
		
	}

}
