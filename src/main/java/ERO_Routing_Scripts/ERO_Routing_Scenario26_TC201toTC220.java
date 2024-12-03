package ERO_Routing_Scripts;

import java.awt.Robot;
import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.Utils;

public class ERO_Routing_Scenario26_TC201toTC220 extends Keywords {
	@SuppressWarnings("deprecation")
	public void ERO_Scenario26(WebDriver driver, ExtentTest test, ExtentTest test1, String url, int dataset)
			throws Exception {
		String Username = Utils.getDataFromTestData("ERO_Scenario26_Dataset"+dataset, "ERO Routing", "Username");
		String Password = Utils.getDataFromTestData("ERO_Scenario26_Dataset"+dataset, "ERO Routing", "Password");
		String ID = Utils.getDataFromTestData("ERO_Scenario26_Dataset"+dataset, "ERO Routing", "Id");
		String surplus = Utils.getDataFromTestData("ERO_Scenario26_Dataset"+dataset, "ERO Routing", "Surplus_val");
		String blue = Utils.getDataFromTestData("ERO_Scenario26_Dataset"+dataset, "ERO Routing", "blue_color");
		String Yellow_Col = Utils.getDataFromTestData("ERO_Scenario26_Dataset"+dataset, "ERO Routing", "Yellow");
		String Deficit_val = Utils.getDataFromTestData("ERO_Scenario26_Dataset"+dataset, "ERO Routing", "Deficit");

		String EquimentType_Alphabets = System.getProperty("user.dir") + "\\uploads\\Budget_Flow_Applied.xlsx";
		String EquimentType_Alphabets2 = System.getProperty("user.dir") + "\\uploads\\Budget_Flow20DC.xlsx";

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

		Extent_cal(test,
				"Testcase 203,Ensure the All Equipment Reposition screen blue color indicates surplus container count based on location, equipment type");

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
		Fluentwait(driver, EPO_Close);
		click(driver, EPO_Close);

		Fluentwait(driver, Cancel);
		click(driver, Cancel);

		wait(driver, "2");
		Fluentwait(driver, New);
		click(driver, New);

		Fluentwait(driver, New_Popup_Yes);
		click(driver, New_Popup_Yes);
		wait(driver, "2");

		Fluentwait(driver, dropdown_option);
		click(driver, dropdown_option);

		Fluentwait(driver, Budget_Reposition);
		click(driver, Budget_Reposition);

		Fluentwait(driver, Budget);
		click(driver, Budget);
		wait(driver, "4");

//		uploadFileRobot(driver, EquimentType_Alphabets);

		String upload_EquimentType_Alphabets = System.getProperty("user.dir") + "/driver/MasterDownloadfile.exe "
				+ EquimentType_Alphabets;

		try {
			Runtime.getRuntime().exec(upload_EquimentType_Alphabets);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getLocalizedMessage());
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
		}

		wait(driver, "10");

		Fluentwait(driver, Location3);

		if (isDisplayed(driver, click_yes)) {

			click(driver, click_yes);

			Fluentwait(driver, Click_ok);
			click(driver, Click_ok);
		}

		wait(driver, "2");
		Fluentwait(driver, ERO_Save);
		click(driver, ERO_Save);
		Fluentwait(driver, ERO_Save_ok);
		click(driver, ERO_Save_ok);
		Fluentwait(driver, ERO_route);
		click(driver, ERO_route);
		wait(driver, "2");
		Fluentwait(driver, Optimizer);
		click(driver, Optimizer);
		wait(driver, "2");
		Fluentwait(driver, Optimizer_Ok);
		click(driver, Optimizer_Ok);

		String surplusColor = getTextBackgroundColor(driver, ERO_Surplus_Color);
		System.out.println("surplusColor :" + surplusColor);

		if (blue.equals(surplusColor)) {
			Extent_pass(driver,
					"excepted surplus Color was : " + blue + "and actual surplus color was : " + surplusColor, test,
					test1);
		} else {
			Extent_fail(driver, "surplus Color was : " + blue + "and actual surplus color was : " + surplusColor, test,
					test1);
		}

		wait(driver, "1");
		String fjltk = getText(driver, ERO_FJLTK);
		System.out.println("value :" + fjltk);

		String DY_val = getText(driver, ERO_20);
		System.out.println("value :" + DY_val);

		Fluentwait(driver, ERO_Optimizer_Close);
		click(driver, ERO_Optimizer_Close);

		Fluentwait(driver, Defic_cancle1);
		click(driver, Defic_cancle1);
		wait(driver, "1");

		Fluentwait(driver, filter_main);
		click(driver, filter_main);

		Fluentwait(driver, Deficit_Condition_Filter);
		click(driver, Deficit_Condition_Filter);

		click(driver, Deficit_Location_Field);
		sendKeys(driver, Deficit_Location_Field, fjltk);
		wait(driver, "1");

		click(driver, Deficit_Equipment_Type);
		sendKeys(driver, Deficit_Equipment_Type, DY_val);

		WebElement scroller_val = driver.findElement(By.xpath("(//div[@ref='eBodyHorizontalScrollViewport'])[1]"));

		int scrollAmount_val = 2000;

		js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller_val, scrollAmount_val);

		String Surplus_val = getText(driver, Defict_surplus);
		System.out.println("value :" + Surplus_val);

		if (surplus.equals(Surplus_val)) {
			Extent_pass(driver,
					"surplus container count was :" + surplus + "  actual container count  was :" + Surplus_val, test,
					test1);
		} else {
			Extent_fail(driver,
					"surplus container count  was :" + surplus + " actual container count  was :" + Surplus_val, test,
					test1);
		}
		System.out.println("Testcase 203, completed");

		Fluentwait(driver, Defi_close);
		click(driver, Defi_close);

		Extent_cal(test,
				"Testcase 204,Ensure in All Equipment Reposition screen blue color indicates deficit container count based on location, equipment type");

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
		Fluentwait(driver, EPO_Close);
		click(driver, EPO_Close);

		Fluentwait(driver, Cancel);
		click(driver, Cancel);

		wait(driver, "2");
		Fluentwait(driver, New);
		click(driver, New);

		Fluentwait(driver, New_Popup_Yes);
		click(driver, New_Popup_Yes);
		wait(driver, "2");

		Fluentwait(driver, dropdown_option);
		click(driver, dropdown_option);

		Fluentwait(driver, Budget_Reposition);
		click(driver, Budget_Reposition);

		Fluentwait(driver, Budget);
		click(driver, Budget);
		wait(driver, "4");

//		uploadFileRobot(driver, EquimentType_Alphabets);

		String upload_EquimentType_Alphabets1 = System.getProperty("user.dir") + "/driver/MasterDownloadfile.exe "
				+ EquimentType_Alphabets;

		try {
			Runtime.getRuntime().exec(upload_EquimentType_Alphabets1);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getLocalizedMessage());
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
		}

		wait(driver, "10");

		Fluentwait(driver, Location3);

		if (isDisplayed(driver, click_yes)) {

			click(driver, click_yes);

			Fluentwait(driver, Click_ok);
			click(driver, Click_ok);
		}

		wait(driver, "2");
		Fluentwait(driver, ERO_Save);
		click(driver, ERO_Save);
		Fluentwait(driver, ERO_Save_ok);
		click(driver, ERO_Save_ok);
		Fluentwait(driver, ERO_route);
		click(driver, ERO_route);
		wait(driver, "2");
		Fluentwait(driver, Optimizer);
		click(driver, Optimizer);
		wait(driver, "2");
		Fluentwait(driver, Optimizer_Ok);
		click(driver, Optimizer_Ok);

		String DeficitColor = getTextBackgroundColor(driver, Dedicit_val);
		System.out.println("DeficitColor :" + DeficitColor);

		if (Yellow_Col.equals(DeficitColor)) {
			Extent_pass(driver,
					"excepted Deficit Color was : " + Yellow_Col + "and actual Deficit color was : " + DeficitColor,
					test, test1);
		} else {
			Extent_fail(driver, "Deficit Color was : " + Yellow_Col + "and actual Deficit color was : " + DeficitColor,
					test, test1);
		}

		wait(driver, "1");

		String ausyd_val = getText(driver, ERO_AUSYD);
		String ausy = ausyd_val.substring(0, 5);
		System.out.println(ausy);

		System.out.println("ausyd_val: " + ausyd_val);

		String DY_val1 = getText(driver, ERO_20);
		System.out.println("value :" + DY_val1);
		Fluentwait(driver, ERO_Optimizer_Close8);
		click(driver, ERO_Optimizer_Close8);

		Fluentwait(driver, ERO_Optimizer_Close3);
		click(driver, ERO_Optimizer_Close3);
		wait(driver, "1");

		Fluentwait(driver, filter_main);
		click(driver, filter_main);

		Fluentwait(driver, Deficit_Condition_Filter);
		click(driver, Deficit_Condition_Filter);

		click(driver, Deficit_Location_Field);
		sendKeys(driver, Deficit_Location_Field, ausy);
		wait(driver, "1");

		click(driver, Deficit_Equipment_Type);
		sendKeys(driver, Deficit_Equipment_Type, DY_val1);

		WebElement scroller_val1 = driver.findElement(By.xpath("(//div[@ref='eBodyHorizontalScrollViewport'])[1]"));

		int scrollAmount_val1 = 2000;

		js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller_val1, scrollAmount_val1);

		String deficit_val = getText(driver, Defict_val);
		System.out.println("value :" + deficit_val);
		if (Deficit_val.equals(deficit_val)) {
			Extent_pass(driver,
					"deficit container count was :" + Deficit_val + "  actual container count  was :" + deficit_val,
					test, test1);
		} else {
			Extent_fail(driver,
					"deficit container count  was :" + Deficit_val + " actual container count  was :" + deficit_val,
					test, test1);
		}
		System.out.println("Testcase 204, completed");

		Fluentwait(driver, Route);
		click(driver, Route);
		Fluentwait(driver, Optimizer_option);
		click(driver, Optimizer_option);
		wait(driver, "2");
		Fluentwait(driver, Optimizer_Ok);
		click(driver, Optimizer_Ok);

		Extent_cal(test,
				"Testcase 202, Ensure the optimization of all equipment size type based on location,equipment type with minimum cost containers moved from surplus location to the deficit location");

		if (isDisplayed(driver, DY_First)) {

			System.out.println("20DY value is displayed ");
			Extent_pass(driver, "20DY value is displayed", test, test1);
		} else {
			System.out.println("20DY value is not displayed");
			Extent_fail(driver, "20DY value is not displayed", test, test1);
		}

		Fluentwait(driver, Optimizer_hc);
		click(driver, Optimizer_hc);
		wait(driver, "2");
		if (isDisplayed(driver, Optimizer_hc_FirstVal)) {

			System.out.println("20HC value is displayed ");
			Extent_pass(driver, "20HC value is displayed", test, test1);
		} else {
			System.out.println("20HC value is not displayed");
			Extent_fail(driver, "20HC value is not displayed", test, test1);
		}
		wait(driver, "1");
		Fluentwait(driver, Optimizer_hh);
		click(driver, Optimizer_hh);
		if (isDisplayed(driver, Optimizer_hc_FirstVal)) {

			System.out.println("20HC value is displayed ");
			Extent_pass(driver, "20HC value is displayed", test, test1);
		} else {
			System.out.println("20HC value is not displayed");
			Extent_fail(driver, "20HC value is not displayed", test, test1);
		}
		wait(driver, "1");
		Fluentwait(driver, Optimizer_RF);
		click(driver, Optimizer_RF);
		if (isDisplayed(driver, Optimizer_hc_FirstVal)) {

			System.out.println("20HC value is displayed ");
			Extent_pass(driver, "20HC value is displayed", test, test1);
		} else {
			System.out.println("20HC value is not displayed");
			Extent_fail(driver, "20HC value is not displayed", test, test1);
		}
		wait(driver, "1");
		Fluentwait(driver, Optimizer_Dy);
		click(driver, Optimizer_Dy);
		if (isDisplayed(driver, Optimizer_hc_FirstVal)) {

			System.out.println("20HC value is displayed ");
			Extent_pass(driver, "20HC value is displayed", test, test1);
		} else {
			System.out.println("20HC value is not displayed");
			Extent_fail(driver, "20HC value is not displayed", test, test1);
		}
		wait(driver, "1");
		Fluentwait(driver, Optimizer_Hc);
		click(driver, Optimizer_Hc);
		if (isDisplayed(driver, Optimizer_hc_FirstVal)) {

			System.out.println("20HC value is displayed ");
			Extent_pass(driver, "20HC value is displayed", test, test1);
		} else {
			System.out.println("20HC value is not displayed");
			Extent_fail(driver, "20HC value is not displayed", test, test1);
		}
		wait(driver, "1");
		Fluentwait(driver, Optimizer_Hr);
		click(driver, Optimizer_Hr);
		if (isDisplayed(driver, Optimizer_hc_FirstVal)) {

			System.out.println("20HC value is displayed ");
			Extent_pass(driver, "20HC value is displayed", test, test1);
		} else {
			System.out.println("20HC value is not displayed");
			Extent_fail(driver, "20HC value is not displayed", test, test1);
		}
		wait(driver, "1");
		Fluentwait(driver, Optimizer_Ot);
		click(driver, Optimizer_Ot);
		if (isDisplayed(driver, Optimizer_hc_FirstVal)) {

			System.out.println("20HC value is displayed ");
			Extent_pass(driver, "20HC value is displayed", test, test1);
		} else {
			System.out.println("20HC value is not displayed");
			Extent_fail(driver, "20HC value is not displayed", test, test1);
		}
		System.out.println("202, compleated");

		Extent_cal(test,
				"208,Ensure the All Equipment Reposition solve screen (Surplus qty = Deficit qty) based on constrains, containers moved surplus location to deficit location ");

		wait(driver, "2");
		Scrolltilltheelementvisible(driver, surplus_qty);

		String surplus1_val = getAttribute(driver, surplus_qty, "value");
		System.out.println("surplus1 : " + surplus1_val);

		String deficir_val1 = getAttribute(driver, Deficit_qty, "value");
		System.out.println("deficir_val1 : " + deficir_val1);

		if (surplus1_val.equals(deficir_val1)) {
			System.out.println(" surplus qty is equals than deficit qty");
			Extent_pass(driver, "surplus qty" + surplus1_val + "is equals than deficit qty" + deficir_val1, test,
					test1);
		} else {
			System.out.println(" surplus qty is not equals than deficit qty");
			Extent_fail(driver, "surplus qty" + surplus1_val + "is not equals than deficit qty" + deficir_val1, test,
					test1);
		}
		System.out.println("Testcase 208 completed");

		Fluentwait(driver, Ero_cancle1);
		mouseOverAndClick(driver, Ero_cancle1);
		Fluentwait(driver, EPO_Close);
		click(driver, EPO_Close);
		Extent_cal(test,
				"TestCase_213, Ensure the ERO Routing screen navigate to  All Equipment Reposition screen, when clicked optimizer  not allow heap memory full");

		Fluentwait(driver, Cancel);
		click(driver, Cancel);

		wait(driver, "2");
		Fluentwait(driver, New);
		click(driver, New);

		Fluentwait(driver, New_Popup_Yes);
		click(driver, New_Popup_Yes);
		wait(driver, "2");

		Fluentwait(driver, dropdown_option);
		click(driver, dropdown_option);

		Fluentwait(driver, Budget_Reposition);
		click(driver, Budget_Reposition);

		Fluentwait(driver, Budget);
		click(driver, Budget);
		wait(driver, "4");

//		uploadFileRobot(driver, EquimentType_Alphabets);

		String upload_EquimentType_Alphabets2 = System.getProperty("user.dir") + "/driver/MasterDownloadfile.exe "
				+ EquimentType_Alphabets;

		try {
			Runtime.getRuntime().exec(upload_EquimentType_Alphabets2);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getLocalizedMessage());
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
		}

		wait(driver, "10");

		Fluentwait(driver, Location3);

		if (isDisplayed(driver, click_yes)) {

			click(driver, click_yes);

			Fluentwait(driver, Click_ok);
			click(driver, Click_ok);
		}

		wait(driver, "2");
		Fluentwait(driver, ERO_Save);
		click(driver, ERO_Save);
		Fluentwait(driver, ERO_Save_ok);
		click(driver, ERO_Save_ok);
		Fluentwait(driver, ERO_route);
		click(driver, ERO_route);
		wait(driver, "7");
		Fluentwait(driver, Optimizer);
		click(driver, Optimizer);
		wait(driver, "2");
		Fluentwait(driver, Optimizer_Ok);
		click(driver, Optimizer_Ok);
		if (isDisplayed(driver, ERO_Equipment_Reposition_Solve)) {
			System.out.println("Equipment Reposition Solve page is displayed ");
			Extent_pass(driver, "Equipment Reposition Solve page is displayed ", test, test1);
		} else {

			System.out.println("Equipment Reposition Solve page is not displayed ");
			Extent_fail(driver, "Equipment Reposition Solve page is not displayed", test, test1);
		}
		System.out.println("TestCase 213 compleated");

		Extent_cal(test,
				"TestCase_214, Ensure the ERO Routing screen navigate to  All Equipment Reposition screen, when clicked optimizer  with single size type Functionality with feasible");

		Fluentwait(driver, EPO_Close);
		click(driver, EPO_Close);

		Fluentwait(driver, cancel_Op);
		click(driver, cancel_Op);

		wait(driver, "2");
		Fluentwait(driver, New);
		click(driver, New);

		Fluentwait(driver, New_Popup_Yes);
		click(driver, New_Popup_Yes);
		wait(driver, "2");

		Fluentwait(driver, dropdown_option);
		click(driver, dropdown_option);

		Fluentwait(driver, Budget_Reposition);
		click(driver, Budget_Reposition);

		Fluentwait(driver, Budget);
		click(driver, Budget);
		wait(driver, "4");

//		uploadFileRobot(driver, EquimentType_Alphabets2);

		String upload_EquimentType_Alphabets3 = System.getProperty("user.dir") + "/driver/MasterDownloadfile.exe "
				+ EquimentType_Alphabets2;

		try {
			Runtime.getRuntime().exec(upload_EquimentType_Alphabets3);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getLocalizedMessage());
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
		}

		wait(driver, "10");

		Fluentwait(driver, Location3);

		if (isDisplayed(driver, click_yes)) {

			click(driver, click_yes);

			Fluentwait(driver, Click_ok);
			click(driver, Click_ok);
		}

		wait(driver, "2");
		Fluentwait(driver, ERO_Save);
		click(driver, ERO_Save);
		Fluentwait(driver, ERO_Save_ok);
		click(driver, ERO_Save_ok);
		Fluentwait(driver, ERO_route);
		click(driver, ERO_route);
		wait(driver, "7");
		Fluentwait(driver, Optimizer);
		click(driver, Optimizer);
		wait(driver, "2");
		Fluentwait(driver, Optimizer_Ok);
		click(driver, Optimizer_Ok);
		if (isDisplayed(driver, ERO_Equipment_Reposition_Solve)) {
			System.out.println("Equipment Reposition Solve page is displayed ");
			Extent_pass(driver, "Equipment Reposition Solve page is displayed ", test, test1);
		} else {

			System.out.println("Equipment Reposition Solve page is not displayed ");
			Extent_fail(driver, "Equipment Reposition Solve page is not displayed", test, test1);
		}
		wait(driver, "2");
		if (isDisplayed(driver, ERS_DC_Option)) {
			System.out.println("2ODC page is displayed ");
			Extent_pass(driver, "2ODC is displayed ", test, test1);
		} else {

			System.out.println("2ODC page is not displayed ");
			Extent_fail(driver, "2ODC page is not displayed", test, test1);
		}
		wait(driver, "2");
		if (isDisplayed(driver, DY_First)) {
			System.out.println("2ODC data are  is displayed ");
			Extent_pass(driver, "2ODC  data are is displayed ", test, test1);
		} else {

			System.out.println("2ODC  data are is not displayed ");
			Extent_fail(driver, "2ODC  data are is not displayed", test, test1);
		}

		System.out.println("TestCase 214 completed");

		Fluentwait(driver, ERO_Optimizer_Close8);
		click(driver, ERO_Optimizer_Close8);

		Extent_cal(test,
				"TestCase_201,Ensure the ERO Routing screen navigate to  All Equipment Reposition screen, when clicked optimizer button with all size type Functionality with feasible");

		Fluentwait(driver, Optimizer);
		click(driver, Optimizer);

		wait(driver, "2");

		if (isDisplayed(driver, Ok_Pop)) {
			System.out.println("After click on optimizer button popup is displayed ");
			Extent_pass(driver, "After click on optimizer button popup is displayed  ", test, test1);
		} else {
			System.out.println("After click on optimizer button popup is not displayed ");
			Extent_fail(driver, "After click on optimizer button popup is not displayed  ", test, test1);
		}

		Fluentwait(driver, Optimizer_Ok);
		click(driver, Optimizer_Ok);

		System.out.println("TestCase 201 completed");

		Fluentwait(driver, Optimizer_Clo);
		click(driver, Optimizer_Clo);

		Extent_cal(test,
				"TestCase_212,Ensure the ERO Routing screen navigate to  All Equipment Reposition screen, when clicked optimizer with all size type Functionality  with infeasible");

		Fluentwait(driver, Optimizer);
		click(driver, Optimizer);

		wait(driver, "2");

		if (isDisplayed(driver, Ok_Pop)) {
			System.out.println("After click on optimizer button infeasible solution is  displayed  ");
			Extent_pass(driver, "After click on optimizer buttoninfeasible solution is  displayed ", test, test1);
		} else {
			System.out.println("After click on optimizer button infeasible solution is not  displayed ");
			Extent_fail(driver, "After click on optimizer button infeasible solution is not displayed", test, test1);
		}

		Fluentwait(driver, Optimizer_Ok);
		click(driver, Optimizer_Ok);

		System.out.println("TestCase 212, completed");

		Fluentwait(driver, Optimizer_Clo);
		click(driver, Optimizer_Clo);

		Extent_cal(test,
				"TestCase_219,Ensure the  Optimize single equipment size type equipment reposition solve displayed ");

		Fluentwait(driver, All_20s_Option);
		click(driver, All_20s_Option);

		Fluentwait(driver, ERO_Size_Type_Label);
		click(driver, ERO_Size_Type_Label);

		Fluentwait(driver, ERO_Size_Type_Label_1);
		click(driver, ERO_Size_Type_Label_1);

		Fluentwait(driver, Routing_Edit);
		click(driver, Routing_Edit);

		Fluentwait(driver, Routing_Save);
		click(driver, Routing_Save);

		if (isDisplayed(driver, ERO_Save_ok)) {
			System.out.println("After click on save button data was saved");
			Extent_pass(driver, "After click on save button data was saved  ", test, test1);
		} else {
			System.out.println("After click on save button data was not saved");
			Extent_fail(driver, "After click on save button data was not  saved  ", test, test1);
		}
		Fluentwait(driver, ERO_Save_ok);
		click(driver, ERO_Save_ok);

		System.out.println("TestCase 219, completed");

		Extent_cal(test, "TestCase_220,Ensure the Optimize All size type equipment reposition solve displayed ");

		Fluentwait(driver, All_option);
		click(driver, All_option);

		Fluentwait(driver, Routing_Edit);
		click(driver, Routing_Edit);

		Fluentwait(driver, Routing_Save);
		click(driver, Routing_Save);

		if (isDisplayed(driver, ERO_Save_ok)) {
			System.out.println("After click on save button data was saved");
			Extent_pass(driver, "After click on save button data was saved  ", test, test1);
		} else {
			System.out.println("After click on save button data was not saved");
			Extent_fail(driver, "After click on save button data was not  saved  ", test, test1);
		}

		System.out.println("TestCase 220, completed");

	}

}
