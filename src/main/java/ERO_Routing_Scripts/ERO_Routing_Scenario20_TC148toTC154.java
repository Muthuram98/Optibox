package ERO_Routing_Scripts;

import java.awt.Robot;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.Utils;

public class ERO_Routing_Scenario20_TC148toTC154 extends Keywords {

	public void ERO_Scenario20(WebDriver driver, ExtentTest test, ExtentTest test1, String url, int dataset)
			throws Exception {

		String Username = Utils.getDataFromTestData("ERO_Scenario20_Dataset" + dataset, "ERO Routing", "Username");
		String Password = Utils.getDataFromTestData("ERO_Scenario20_Dataset" + dataset, "ERO Routing", "Password");
		String ID = Utils.getDataFromTestData("ERO_Scenario20_Dataset" + dataset, "ERO Routing", "Id");
		String Id2 = Utils.getDataFromTestData("ERO_Scenario20_Dataset" + dataset, "ERO Routing", "Id2");
		String FRom_week = Utils.getDataFromTestData("ERO_Scenario20_Dataset" + dataset, "ERO Routing", "fromWeek");
		String To_week = Utils.getDataFromTestData("ERO_Scenario20_Dataset" + dataset, "ERO Routing", "toWeek");

		navigateUrl(driver, url);

		Robot rbt = new Robot();
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

		Extent_cal(test, "TestCase_150,Check whether system should not allow ERO Routing id generated");

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

		Fluentwait(driver, Editbutton);
		click(driver, Editbutton);

		Fluentwait(driver, Save);
		click(driver, Save);

		wait(driver, "3");

		Fluentwait(driver, Save_popup_ok);
		click(driver, Save_popup_ok);

		wait(driver, "3");
		String id = getAttribute(driver, Deficit1option, "value");

		Fluentwait(driver, Route);
		click(driver, Route);

		Fluentwait(driver, ERO_Popup_Ok);
		click(driver, ERO_Popup_Ok);

		wait(driver, "2");

		if (isDisplayed(driver, Origin_1)) {
			System.out.println("Record is display in ERO Routing page is displayed ");
			Extent_pass(driver, "Record is display in ERO Routing page is displayed ", test, test1);
		} else {

			System.out.println("Record is display in ERO Routing page is displayed ");
			Extent_fail(driver, "Record is display in ERO Routing page is displayed", test, test1);
		}

		String id1 = getAttribute(driver, Routing_ID, "value");
		System.out.println("Id value :" + id1);

		if (id.equals(id1)) {
			Extent_pass(driver, "Expected value is : " + id + " || Actual value was : " + id1, test, test1);
		} else {
			Extent_fail(driver, "Expected value is : " + id + " || Actual value was : " + id1, test, test1);
		}
		System.out.println("Testcase 150, compleated");

		Extent_cal(test, "Testcase 151,Ensure ERO Routing auto generated id navigated  wrongly");

		wait(driver, "2");

		Fluentwait(driver, ERO_Optimizer_Close5);
		click(driver, ERO_Optimizer_Close5);

		String Ib1 = getAttribute(driver, Deficit1option, "value");

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

		Fluentwait(driver, ERO_Popup_Ok);
		click(driver, ERO_Popup_Ok);

		String Ib2 = getAttribute(driver, id_ERO, "value");

		if (!Ib1.equals(Id2)) {
			Extent_pass(driver, "Expected value is : " + Id2 + " || Actual value is : " + Ib1, test, test1);
		} else {
			Extent_fail(driver, "Expected value is : " + Id2 + " || Actual value is : " + Ib1, test, test1);
		}

		System.out.println("Testcase 151, completed");
		Fluentwait(driver, Defic_cancle1);
		click(driver, Defic_cancle1);
		Fluentwait(driver, Defi_close);
		click(driver, Defi_close);

		Extent_cal(test, "Testcase 152,Ensure ERO Routing auto generated id navigated  and from Week not displayed");

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

		Fluentwait(driver, ERO_Popup_Ok);
		click(driver, ERO_Popup_Ok);

		wait(driver, "2");

		String Ib3 = getAttribute(driver, id_ERO, "value");

		if (!Ib3.equals(FRom_week)) {
			Extent_pass(driver, "Expected value is : " + FRom_week + " || Actual value is : " + Ib3, test, test1);
		} else {
			Extent_fail(driver, "Expected value is : " + FRom_week + " || Actual value is : " + Ib3, test, test1);
		}

		Fluentwait(driver, Defic_cancle2);
		click(driver, Defic_cancle2);

		Fluentwait(driver, ERO_Optimizer_Close);
		click(driver, ERO_Optimizer_Close);

		System.out.println("Testcase 152, completed");

		Extent_cal(test, "Testcase 153,Ensure ERO Routing auto generated id navigated and  To Week not displayed");

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

		Fluentwait(driver, ERO_Popup_Ok);
		click(driver, ERO_Popup_Ok);

		wait(driver, "2");

		String Ib4 = getAttribute(driver, id_ERO, "value");

		if (!Ib4.equals(To_week)) {
			Extent_pass(driver, "Expected value is : " + To_week + " || Actual value is : " + Ib4, test, test1);
		} else {
			Extent_fail(driver, "Expected value is : " + To_week + " || Actual value is : " + Ib4, test, test1);
		}
		System.out.println("Testcase 153, compleated");

		Extent_cal(test, "Testcase 148,Ensure ERO Routing  Auto generated ID should be display");

		Fluentwait(driver, ERO_Optimizer_Close3);
		click(driver, ERO_Optimizer_Close3);

		Fluentwait(driver, Route);
		click(driver, Route);

		Fluentwait(driver, ERO_Popup_Ok);
		click(driver, ERO_Popup_Ok);

		wait(driver, "3");

		String id3 = getAttribute(driver, idval, "value");

		if (isDisplayed(driver, idval)) {

			System.out.println("Auto generated id is displayed");
			Extent_pass(driver, "Auto generated id is displayed :" + id3, test, test1);
		} else {
			System.out.println("Auto generated id is not displayed");
			Extent_fail(driver, "Auto generated id is not displayed :" + id3, test, test1);

		}

		System.out.println("Testcase 148, completed");

		Fluentwait(driver, ERO_Optimizer_Close8);
		click(driver, ERO_Optimizer_Close8);

		Extent_cal(test, "Testcase 149,Ensure ERO Routing gird should not be double click ");

		Fluentwait(driver, Route);
		click(driver, Route);

		Fluentwait(driver, ERO_Popup_Ok);
		click(driver, ERO_Popup_Ok);

		wait(driver, "2");
		Fluentwait(driver, Origin_1);
		doubleClick(driver, Origin_1);

		if (isDisplayed(driver, Origin_1)) {
			System.out.println("After click on  ERO Routing  details not double click");
			Extent_pass(driver, "After click on  ERO Routing  details not double click : AUBWT value  was display",
					test, test1);
		} else {
			System.out.println("After click on  ERO Routing  details  double click");
			Extent_pass(driver, "After click on  ERO Routing  details  double click : AUBWT value  was display", test,
					test1);
		}

		System.out.println("Testcase 149, completed");

		Extent_cal(test, "Testcase 150,Check whether system should not allow ERO Routing id generated ");

		String Ib6 = getAttribute(driver, id_ERO, "value");

		if (!Ib6.isEmpty()) {
			System.out.println("Not allow to generate the id in ERO Routing screen");
			Extent_pass(driver, " Not allow to generate the id in ERO Routing screen", test, test1);
		} else {
			System.out.println("Allow to generate the id in ERO Routing screen");
			Extent_fail(driver, "Allow to generate the id in ERO Routing screen", test, test1);
		}

		System.out.println("Testcase 150, completed");

	}
}