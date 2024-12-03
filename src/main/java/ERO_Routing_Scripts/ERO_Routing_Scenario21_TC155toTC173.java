package ERO_Routing_Scripts;

import java.awt.Robot;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.Utils;

public class ERO_Routing_Scenario21_TC155toTC173 extends Keywords {
	public void ERO_Routing_Scenario21(WebDriver driver, ExtentTest test, ExtentTest test1, String url, int dataset)
			throws Exception {

		String Username = Utils.getDataFromTestData("ERO_Scenario21_Dataset"+dataset, "ERO Routing", "Username");
		String Password = Utils.getDataFromTestData("ERO_Scenario21_Dataset"+dataset, "ERO Routing", "Password");
		String ID = Utils.getDataFromTestData("ERO_Scenario21_Dataset"+dataset, "ERO Routing", "Id");
		String NO_Records = Utils.getDataFromTestData("ERO_Scenario21_Dataset"+dataset, "ERO Routing", "NoRecords");
		String TotalRecords = Utils.getDataFromTestData("ERO_Scenario21_Dataset"+dataset, "ERO Routing", "Total_Records");

		String EquimentType_Alphabets = System.getProperty("user.dir") + "\\uploads\\Budget_Flow_Applied.xlsx";

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

		Fluentwait(driver, Searchbox);

		Extent_cal(test,
				"Testcase 155,Ensure Deficit and Surplus location identification screen navigate to ERO routing screen ");

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

		if (isDisplayed(driver, Origin_1)) {
			System.out.println("Record is display in ERO Routing page is displayed ");
			Extent_pass(driver, "Record is display in ERO Routing page is displayed ", test, test1);
		} else {

			System.out.println("Record is display in ERO Routing page is not  displayed ");
			Extent_fail(driver, "Record is display in ERO Routing page is not displayed", test, test1);
		}

		Extent_cal(test, "Testcase 158,Ensure ERO Routing screen navigate to Graphical view screen");

		Fluentwait(driver, EPO_map);
		click(driver, EPO_map);

		wait(driver, "2");
		if (isDisplayed(driver, EPO_map_Id_Field)) {
			System.out.println("Graphical representation page is displayed ");
			Extent_pass(driver, "Graphical representation page is displayed ", test, test1);
		} else {

			System.out.println("Graphical representation page is not displayed ");
			Extent_fail(driver, "Graphical representation page is not  displayed ", test, test1);
		}

		System.out.println("Testcase 158, compleated");

		Fluentwait(driver, Defic_cancle1);
		click(driver, Defic_cancle1);
		Fluentwait(driver, EPO_Close);
		click(driver, EPO_Close);

		Extent_cal(test, "Testcase 159,Ensure ERO Routing screen navigate to Equipment reposition solve");

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

//		uploadFileRobot(driver,EquimentType_Alphabets);

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
		if (isDisplayed(driver, ERO_Equipment_Reposition_Solve)) {
			System.out.println("Equipment Reposition Solve page is displayed ");
			Extent_pass(driver, "Equipment Reposition Solve page is displayed ", test, test1);
		} else {

			System.out.println("Equipment Reposition Solve page is not displayed ");
			Extent_fail(driver, "Equipment Reposition Solve page is not displayed", test, test1);
		}
		System.out.println(" Testcase 159,completed");

		Fluentwait(driver, Defic_cancle2);
		click(driver, Defic_cancle2);
		wait(driver, "2");
		Extent_cal(test, "Testcase 163,Ensure  Route Details count field not allow alphabets.");

		Fluentwait(driver, EPO_Route_Details);
		click(driver, EPO_Route_Details);

		Fluentwait(driver, ERO_Total_Count);
		click(driver, ERO_Total_Count);

		String alpha = getText(driver, ERO_Total_Count);
		String Allignmenttype = determineType(alpha);

		if (!Allignmenttype.equals("Alphabetic")) {
			Extent_pass(driver, "Route Details count  field not allow the alphabets ", test, test1);
		} else {
			Extent_fail(driver, "Route Details count  field not allow the alphabets ", test, test1);
		}
		System.out.println(" Testcase 163,completed");

		Extent_cal(test, "Testcase 164,Ensure Route Details count  field allow   numeric.");

		Fluentwait(driver, ERO_Total_Count);
		click(driver, ERO_Total_Count);

		String alpha1 = getText(driver, ERO_Total_Count);
		String Allignmenttype1 = determineType(alpha1);

		if (Allignmenttype1.equals("Numeric")) {
			Extent_pass(driver, "Route Details count  field not allow the numeric ", test, test1);
		} else {

			Extent_fail(driver, "Route Details count  field  allow the numeric", test, test1);
		}
		System.out.println(" Testcase 164,completed");

		Extent_cal(test, "Testcase 165,Ensure  Route Details count not allow   Special character.");

		String alpha2 = getText(driver, ERO_Total_Count);

		String Allignmenttype2 = determineType(alpha2);
		wait(driver, "2");
		if (!Allignmenttype2.equals("Other")) {
			System.out.println("Route Details count  field not allow the special char");
			Extent_pass(driver, "Route Details count  field not allow the special char ", test, test1);
		} else {
			System.out.println("Route Details count  field  allow the special char");
			Extent_fail(driver, "Route Details count  field  allow the special char", test, test1);
		}
		System.out.println(" Testcase 165,completed");

		Extent_cal(test, "Testcase 167,Ensure Unavailable route count field");
		wait(driver, "2");
		Fluentwait(driver, EPO_unavailable);
		click(driver, EPO_unavailable);

		if (isDisplayed(driver, EPO_Un_Select_Filter)) {
			System.out.println("Unavailable route count page is displayed ");
			Extent_pass(driver, "Unavailable route count page is displayed ", test, test1);
		} else {

			System.out.println("Unavailable route count page is not displayed ");
			Extent_fail(driver, "Unavailable route count page is not displayed", test, test1);
		}
		System.out.println(" Testcase 167,completed");

		Extent_cal(test, "Testcase 170,Ensure Unavailable route count field not allow alphabets.");

		String alpha3 = getText(driver, ERO_Un_Total_Count);
		String Allignmenttype3 = determineType(alpha3);

		if (!Allignmenttype3.equals("Alphabetic")) {
			Extent_pass(driver, "Unavailable route Details count  field not allow the alphabets ", test, test1);
		} else {
			Extent_fail(driver, "Unavailable Route Details count  field not allow the alphabets ", test, test1);
		}
		System.out.println(" Testcase 170,completed");

		Extent_cal(test, "Testcase 171,Ensure Unavailable route count  field allow   numeric.");

		String alpha4 = getText(driver, ERO_Un_Total_Count);
		String Allignmenttype4 = determineType(alpha4);

		if (Allignmenttype4.equals("Numeric")) {
			System.out.println("Unavailable Route Details count  field  allow the numeric ");
			Extent_pass(driver, "Unavailable Route Details count  field  allow the numeric ", test, test1);
		} else {
			System.out.println("Unavailable Route Details count  field  not allow the numeric ");
			Extent_fail(driver, "Unavailable Route Details count  field not allow the numeric", test, test1);
		}
		System.out.println(" Testcase 171,completed");

		Extent_cal(test, "Testcase 172,Ensure Unavailable route count field not allow   Special character.");

		String alpha5 = getText(driver, ERO_Un_Total_Count);

		String Allignmenttype5 = determineType(alpha5);
		wait(driver, "2");
		if (!Allignmenttype5.equals("Other")) {
			System.out.println("Unavailable Route Details count  field not allow the special char");
			Extent_pass(driver, "Unavailable Route Details count  field not allow the special char ", test, test1);

		} else {
			System.out.println("Unavailable Route Details count  field allow the special char");
			Extent_fail(driver, "Unavailable Route Details count  field  allow the special char", test, test1);
		}
		System.out.println(" Testcase 172,completed");

		Extent_cal(test,
				"Testcase 173,Ensure Filter the Unavailable route countLoad Region,Load country,Origin,Delivery,Discharge country,Discharge Region,Equipment type  Functionality for unavailable route tab");
		Fluentwait(driver, EPO_unavailable);
		click(driver, EPO_unavailable);
		wait(driver, "2");
		Fluentwait(driver, EPO_Un_Select_Filter);
		click(driver, EPO_Un_Select_Filter);

		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		wait(driver, "2");
		Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver, EPO_SelectFilterSearchBox);

		wait(driver, "2");
		Fluentwait(driver, EPO_SelectFilterSearchFirstOption);
		click(driver, EPO_SelectFilterSearchFirstOption);

		if (isDisplayed(driver, EPO_SelectFilterSearchFirstOption)) {
			System.out.println("Route Details count option is displayed ");
			Extent_pass(driver, "Route Details count option is displayed ", test, test1);
		} else {

			System.out.println("Route Details count option is displayed ");
			Extent_fail(driver, "Route Details count option is displayed ", test, test1);
		}

		Fluentwait(driver, EPO_SelectFilterSearchFirstOption);
		click(driver, EPO_SelectFilterSearchFirstOption);
		wait(driver, "2");
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);

		click(driver, ERO_SVM);
		wait(driver, "2");
		click(driver, EPO_unavailable);
		wait(driver, "2");
		Fluentwait(driver, EPO_Un_Load);
		click(driver, EPO_Un_Load);

		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);

		Fluentwait(driver, EPO_Un_Load_Input);
		click(driver, EPO_Un_Load_Input);

		if (isDisplayed(driver, EPO_Un_Load_Input)) {
			System.out.println("Route Details count option is displayed ");
			Extent_pass(driver, "Route Details count option is displayed ", test, test1);
		} else {

			System.out.println("Route Details count option is not  displayed ");
			Extent_fail(driver, "Route Details count option is not displayed ", test, test1);
		}
		Fluentwait(driver, EPO_Un_Load_Input);
		click(driver, EPO_Un_Load_Input);

		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		click(driver, ERO_SVM);
		wait(driver, "2");
		click(driver, EPO_unavailable);
		wait(driver, "2");
		click(driver, Load_country);

		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);

		Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver, EPO_SelectFilterSearchBox);

		Fluentwait(driver, Load_country_val);
		click(driver, Load_country_val);
		if (isDisplayed(driver, Load_country_val)) {
			System.out.println("Route Details count option is displayed ");
			Extent_pass(driver, "Route Details count option is displayed ", test, test1);
		} else {

			System.out.println("Route Details count option is not displayed ");
			Extent_fail(driver, "Route Details count option is not displayed ", test, test1);
		}
		Fluentwait(driver, Load_country_val);
		click(driver, Load_country_val);

		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);

		click(driver, ERO_SVM);
		wait(driver, "1");
		click(driver, EPO_unavailable);
		wait(driver, "2");
		Fluentwait(driver, EPO_Un_Load);
		click(driver, EPO_Un_Load);

		Fluentwait(driver, Origin);
		click(driver, Origin);
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);

		Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver, EPO_SelectFilterSearchBox);
		Fluentwait(driver, Origin_val);
		click(driver, Origin_val);
		if (isDisplayed(driver, Origin_val)) {
			System.out.println("Route Details count option is displayed ");
			Extent_pass(driver, "Route Details count option is displayed ", test, test1);
		} else {

			System.out.println("Route Details count option is not displayed ");
			Extent_fail(driver, "Route Details count option is not displayed ", test, test1);
		}
		Fluentwait(driver, Origin_val);
		click(driver, Origin_val);

		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);

		click(driver, ERO_SVM);
		wait(driver, "2");
		click(driver, EPO_unavailable);
		wait(driver, "2");
		Fluentwait(driver, EPO_Un_Load);
		click(driver, EPO_Un_Load);

		Fluentwait(driver, Delivery);
		click(driver, Delivery);
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);

		Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver, EPO_SelectFilterSearchBox);

		Fluentwait(driver, Delivery_val);
		click(driver, Delivery_val);
		if (isDisplayed(driver, Delivery_val)) {
			System.out.println("Route Details count option is displayed ");
			Extent_pass(driver, "Route Details count option is displayed ", test, test1);
		} else {

			System.out.println("Route Details count option is not displayed ");
			Extent_fail(driver, "Route Details count option is not  displayed ", test, test1);
		}

		Fluentwait(driver, Delivery_val);
		click(driver, Delivery_val);

		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);

		click(driver, ERO_SVM);
		wait(driver, "2");
		click(driver, EPO_unavailable);
		wait(driver, "2");
		click(driver, Dissh_Country);
		wait(driver, "2");

		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);

		Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver, EPO_SelectFilterSearchBox);
		Fluentwait(driver, Disch_val);
		click(driver, Disch_val);
		if (isDisplayed(driver, Disch_val)) {
			System.out.println("Route Details count option is displayed ");
			Extent_pass(driver, "Route Details count option is displayed ", test, test1);
		} else {

			System.out.println("Route Details count option is not displayed ");
			Extent_fail(driver, "Route Details count option is not displayed ", test, test1);
		}

		Fluentwait(driver, Disch_val);
		click(driver, Disch_val);

		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);

		click(driver, ERO_SVM);
		wait(driver, "2");
		click(driver, EPO_unavailable);

		wait(driver, "2");
		click(driver, Disch_Region);
		wait(driver, "2");

		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);

		Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver, EPO_SelectFilterSearchBox);
		Fluentwait(driver, Load_Region_val);
		click(driver, Load_Region_val);
		if (isDisplayed(driver, Load_Region_val)) {
			System.out.println("Route Details count option is displayed ");
			Extent_pass(driver, "Route Details count option is displayed ", test, test1);
		} else {

			System.out.println("Route Details count option is not displayed ");
			Extent_fail(driver, "Route Details count option is not  displayed ", test, test1);
		}

		Fluentwait(driver, Load_Region_val);
		click(driver, Load_Region_val);

		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);

		click(driver, ERO_SVM);
		wait(driver, "2");
		click(driver, EPO_unavailable);

		wait(driver, "2");
		click(driver, EquipmentType);
		wait(driver, "2");
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);

		Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver, EPO_SelectFilterSearchBox);
		Fluentwait(driver, Origin_val1);
		click(driver, Origin_val1);
		if (isDisplayed(driver, Origin_val1)) {
			System.out.println("Route Details count option is displayed ");
			Extent_pass(driver, "Route Details count option is displayed ", test, test1);
		} else {

			System.out.println("Route Details count option is not  displayed ");
			Extent_fail(driver, "Route Details count option is not displayed ", test, test1);
		}

		Fluentwait(driver, Origin_val1);
		click(driver, Origin_val1);

		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		System.out.println(" Testcase 173,completed");

		Extent_cal(test,
				"Testcase 166,Ensure Filter Route Details count Origin,Delivery,Size type,Main service,Original Mode, POL, POL Terminal, POL Service,Trans1,Trans1 Terminal,Trans1 Service,Trans2,Trans2 Terminal,Trans2 Service,Trans3,Trans3 Terminal,Trans3 Service,POD,POD Terminal,Delivery,Cost (Amount in USD),Transit Time,Missing cost,Load Cost,discharge cost,Ts1 Load cost,Ts2 Load cost,Ts3 Load cost,Ts1 Discharge cost,Ts2 Discharge cost,Ts3 Discharge cost,Feeder cost1,Feeder cost2,Feeder cost3,ITT cost, Load Haulage cost, Discharge Haulage cost,Others for route details tab");

		Fluentwait(driver, EPO_Route_Details);
		click(driver, EPO_Route_Details);
		click(driver, ERO_SVM);
		wait(driver, "2");
		click(driver, Select_VaL);
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);

		Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver, EPO_SelectFilterSearchBox);
		Fluentwait(driver, Select_VaL1);
		click(driver, Select_VaL1);
		if (isDisplayed(driver, Select_VaL1)) {
			System.out.println("Route Details count option is displayed ");
			Extent_pass(driver, "Route Details count option is displayed ", test, test1);
		} else {

			System.out.println("Route Details count option is not displayed ");
			Extent_fail(driver, "Route Details count option is not  displayed ", test, test1);
		}

		Fluentwait(driver, Select_VaL1);
		click(driver, Select_VaL1);

		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);

		click(driver, ERO_SVM);
		wait(driver, "2");

		click(driver, Route_Origin);
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver, EPO_SelectFilterSearchBox);
		Fluentwait(driver, Route_Origin_Val);
		click(driver, Route_Origin_Val);
		if (isDisplayed(driver, Route_Origin_Val)) {
			System.out.println("Route Details count option is displayed ");
			Extent_pass(driver, "Route Details count option is displayed ", test, test1);
		} else {

			System.out.println("Route Details count option is not displayed ");
			Extent_fail(driver, "Route Details count option is not displayed ", test, test1);
		}
		Fluentwait(driver, Route_Origin_Val);
		click(driver, Route_Origin_Val);
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);

		click(driver, ERO_SVM);
		wait(driver, "2");
		click(driver, Route_Delivery);
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver, EPO_SelectFilterSearchBox);
		Fluentwait(driver, Route_Delivery_val);
		click(driver, Route_Delivery_val);
		if (isDisplayed(driver, Route_Delivery_val)) {
			System.out.println("Route Details count option is displayed ");
			Extent_pass(driver, "Route Details count option is displayed ", test, test1);
		} else {

			System.out.println("Route Details count option is not displayed ");
			Extent_fail(driver, "Route Details count option is not  displayed ", test, test1);
		}
		Fluentwait(driver, Route_Delivery_val);
		click(driver, Route_Delivery_val);
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);

		click(driver, ERO_SVM);
		wait(driver, "2");
		click(driver, Route_Size_Type);
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		wait(driver, "1");
		Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver, EPO_SelectFilterSearchBox);
		Fluentwait(driver, Route_SizrType_val);
		click(driver, Route_SizrType_val);
		if (isDisplayed(driver, Route_SizrType_val)) {
			System.out.println("Route Details count option is displayed ");
			Extent_pass(driver, "Route Details count option is displayed ", test, test1);
		} else {

			System.out.println("Route Details count option is not displayed ");
			Extent_fail(driver, "Route Details count option is not  displayed ", test, test1);
		}
		Fluentwait(driver, Route_SizrType_val);
		click(driver, Route_SizrType_val);
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);

		click(driver, ERO_SVM);
		wait(driver, "2");
		click(driver, Route_Cost);
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver, EPO_SelectFilterSearchBox);
		Fluentwait(driver, Route_Cost_val);
		click(driver, Route_Cost_val);
		if (isDisplayed(driver, Route_Cost_val)) {
			System.out.println("Route Details count option is displayed ");
			Extent_pass(driver, "Route Details count option is displayed ", test, test1);
		} else {

			System.out.println("Route Details count option is not displayed ");
			Extent_fail(driver, "Route Details count option is not displayed ", test, test1);
		}
		Fluentwait(driver, Route_Cost_val);
		click(driver, Route_Cost_val);
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);

		click(driver, ERO_SVM);
		wait(driver, "2");
		click(driver, Route_Main_Service);
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver, EPO_SelectFilterSearchBox);
		Fluentwait(driver, Route_Main_Service_val);
		click(driver, Route_Main_Service_val);
		if (isDisplayed(driver, Route_Main_Service_val)) {
			System.out.println("Route Details count option is displayed ");
			Extent_pass(driver, "Route Details count option is displayed ", test, test1);
		} else {

			System.out.println("Route Details count option is not displayed ");
			Extent_fail(driver, "Route Details count option is not displayed ", test, test1);
		}
		Fluentwait(driver, Route_Main_Service_val);
		click(driver, Route_Main_Service_val);
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);

		click(driver, ERO_SVM);
		wait(driver, "2");
		click(driver, Route_Origin_Mode);
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver, EPO_SelectFilterSearchBox);
		Fluentwait(driver, Route_Origin_Mode_val);
		click(driver, Route_Origin_Mode_val);
		if (isDisplayed(driver, Route_Origin_Mode_val)) {
			System.out.println("Route Details count option is displayed ");
			Extent_pass(driver, "Route Details count option is displayed ", test, test1);
		} else {

			System.out.println("Route Details count option is not displayed ");
			Extent_fail(driver, "Route Details count option is not  displayed ", test, test1);
		}
		Fluentwait(driver, Route_Origin_Mode_val);
		click(driver, Route_Origin_Mode_val);
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);

		click(driver, ERO_SVM);
		wait(driver, "2");
		click(driver, Route_Pol);
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver, EPO_SelectFilterSearchBox);
		Fluentwait(driver, Route_Pol_val);
		click(driver, Route_Pol_val);
		if (isDisplayed(driver, Route_Pol_val)) {
			System.out.println("Route Details count option is displayed ");
			Extent_pass(driver, "Route Details count option is displayed ", test, test1);
		} else {

			System.out.println("Route Details count option is not displayed ");
			Extent_fail(driver, "Route Details count option is not displayed ", test, test1);
		}
		Fluentwait(driver, Route_Pol_val);
		click(driver, Route_Pol_val);
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);

		click(driver, ERO_SVM);
		wait(driver, "2");
		click(driver, Route_Pol_Terminal);
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver, EPO_SelectFilterSearchBox);
		Fluentwait(driver, Route_Pol_Terminal_val);
		click(driver, Route_Pol_Terminal_val);
		if (isDisplayed(driver, Route_Pol_Terminal_val)) {
			System.out.println("Route Details count option is displayed ");
			Extent_pass(driver, "Route Details count option is displayed ", test, test1);
		} else {

			System.out.println("Route Details count option is not displayed ");
			Extent_fail(driver, "Route Details count option is not displayed ", test, test1);
		}
		Fluentwait(driver, Route_Pol_Terminal_val);
		click(driver, Route_Pol_Terminal_val);
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);

		click(driver, ERO_SVM);

		mouseOverAndClick(driver, Route_Pol_Terminal);
		WebElement scroller = driver.findElement(By.xpath("(//div[@ref='eBodyHorizontalScrollViewport'])[2]"));
		int scrollAmount = 1000; //
		js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller, scrollAmount);
		wait(driver, "2");
		click(driver, Route_Pol_Service);
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver, EPO_SelectFilterSearchBox);
		Fluentwait(driver, Route_First_Val);
		click(driver, Route_First_Val);
		if (isDisplayed(driver, Route_First_Val)) {
			System.out.println("Route Details count option is displayed ");
			Extent_pass(driver, "Route Details count option is displayed ", test, test1);
		} else {

			System.out.println("Route Details count option is not displayed ");
			Extent_fail(driver, "Route Details count option is not  displayed ", test, test1);
		}
		Fluentwait(driver, Route_First_Val);
		click(driver, Route_First_Val);
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);

		click(driver, ERO_SVM);
		mouseOverAndClick(driver, Route_Pol_Terminal);
		WebElement scroller2 = driver.findElement(By.xpath("(//div[@ref='eBodyHorizontalScrollViewport'])[2]"));
		int scrollAmount2 = 1000; //
		js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller2, scrollAmount2);
		wait(driver, "2");
		click(driver, Route_Trans1);
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver, EPO_SelectFilterSearchBox);
		Fluentwait(driver, Route_First_Val);
		click(driver, Route_First_Val);
		if (isDisplayed(driver, Route_First_Val)) {
			System.out.println("Route Details count option is displayed ");
			Extent_pass(driver, "Route Details count option is displayed ", test, test1);
		} else {

			System.out.println("Route Details count option is not displayed ");
			Extent_fail(driver, "Route Details count option is not displayed ", test, test1);
		}
		Fluentwait(driver, Route_First_Val);
		click(driver, Route_First_Val);
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);

		click(driver, ERO_SVM);
		mouseOverAndClick(driver, Route_Pol_Terminal);
		WebElement scroller3 = driver.findElement(By.xpath("(//div[@ref='eBodyHorizontalScrollViewport'])[2]"));
		int scrollAmount3 = 1000; //
		js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller3, scrollAmount3);
		wait(driver, "2");
		click(driver, Route_Trans1_Service);
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver, EPO_SelectFilterSearchBox);
		Fluentwait(driver, Route_First_Val);
		click(driver, Route_First_Val);
		if (isDisplayed(driver, Route_First_Val)) {
			System.out.println("Route Details count option is displayed ");
			Extent_pass(driver, "Route Details count option is displayed ", test, test1);
		} else {

			System.out.println("Route Details count option is not displayed ");
			Extent_fail(driver, "Route Details count option is not displayed ", test, test1);
		}
		Fluentwait(driver, Route_First_Val);
		click(driver, Route_First_Val);
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);

		click(driver, ERO_SVM);
		mouseOverAndClick(driver, Route_Pol_Terminal);
		WebElement scroller4 = driver.findElement(By.xpath("(//div[@ref='eBodyHorizontalScrollViewport'])[2]"));
		int scrollAmount4 = 1000; //
		js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller4, scrollAmount4);
		wait(driver, "2");
		click(driver, Route_Trans2);
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver, EPO_SelectFilterSearchBox);
		Fluentwait(driver, Route_First_Val);
		click(driver, Route_First_Val);
		if (isDisplayed(driver, Route_First_Val)) {
			System.out.println("Route Details count option is displayed ");
			Extent_pass(driver, "Route Details count option is displayed ", test, test1);
		} else {

			System.out.println("Route Details count option is not displayed ");
			Extent_fail(driver, "Route Details count option is not displayed ", test, test1);
		}
		Fluentwait(driver, Route_First_Val);
		click(driver, Route_First_Val);
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);

		click(driver, ERO_SVM);
		mouseOverAndClick(driver, Route_Pol_Terminal);
		WebElement scroller5 = driver.findElement(By.xpath("(//div[@ref='eBodyHorizontalScrollViewport'])[2]"));
		int scrollAmount5 = 1000; //
		js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller5, scrollAmount5);
		wait(driver, "2");
		click(driver, Route_Trans2_Service);
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver, EPO_SelectFilterSearchBox);
		Fluentwait(driver, Route_First_Val);
		click(driver, Route_First_Val);
		if (isDisplayed(driver, Route_First_Val)) {
			System.out.println("Route Details count option is displayed ");
			Extent_pass(driver, "Route Details count option is displayed ", test, test1);
		} else {

			System.out.println("Route Details count option is not displayed ");
			Extent_fail(driver, "Route Details count option is not displayed ", test, test1);
		}
		Fluentwait(driver, Route_First_Val);
		click(driver, Route_First_Val);
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);

		click(driver, ERO_SVM);
		mouseOverAndClick(driver, Route_Pol_Terminal);
		WebElement scroller6 = driver.findElement(By.xpath("(//div[@ref='eBodyHorizontalScrollViewport'])[2]"));
		int scrollAmount6 = 1000; //
		js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller6, scrollAmount6);
		wait(driver, "2");
		click(driver, Route_Trans3);
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver, EPO_SelectFilterSearchBox);
		Fluentwait(driver, Route_First_Val);
		click(driver, Route_First_Val);
		if (isDisplayed(driver, Route_First_Val)) {
			System.out.println("Route Details count option is displayed ");
			Extent_pass(driver, "Route Details count option is displayed ", test, test1);
		} else {

			System.out.println("Route Details count option is not displayed ");
			Extent_fail(driver, "Route Details count option is not  displayed ", test, test1);
		}
		Fluentwait(driver, Route_First_Val);
		click(driver, Route_First_Val);
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);

		click(driver, ERO_SVM);
		wait(driver, "1");
		mouseOverAndClick(driver, Route_Pol_Terminal);
		WebElement scroller7 = driver.findElement(By.xpath("(//div[@ref='eBodyHorizontalScrollViewport'])[2]"));
		int scrollAmount7 = 1500; //
		js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller7, scrollAmount7);
		wait(driver, "2");
		click(driver, Route_Trans3_Service);
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver, EPO_SelectFilterSearchBox);
		Fluentwait(driver, Route_First_Val);
		click(driver, Route_First_Val);
		if (isDisplayed(driver, Route_First_Val)) {
			System.out.println("Route Details count option is displayed ");
			Extent_pass(driver, "Route Details count option is displayed ", test, test1);
		} else {

			System.out.println("Route Details count option is not displayed ");
			Extent_fail(driver, "Route Details count option is not displayed ", test, test1);
		}
		Fluentwait(driver, Route_First_Val);
		click(driver, Route_First_Val);
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);

		click(driver, ERO_SVM);
		wait(driver, "1");
		mouseOverAndClick(driver, Route_Pol_Terminal);
		WebElement scroller8 = driver.findElement(By.xpath("(//div[@ref='eBodyHorizontalScrollViewport'])[2]"));
		int scrollAmount8 = 1500; //
		js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller8, scrollAmount8);
		wait(driver, "2");
		click(driver, Route_Pod);
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver, EPO_SelectFilterSearchBox);
		Fluentwait(driver, Route_First_Val);
		click(driver, Route_First_Val);
		if (isDisplayed(driver, Route_First_Val)) {
			System.out.println("Route Details count option is displayed ");
			Extent_pass(driver, "Route Details count option is displayed ", test, test1);
		} else {

			System.out.println("Route Details count option is not displayed ");
			Extent_fail(driver, "Route Details count option is not displayed ", test, test1);
		}
		Fluentwait(driver, Route_First_Val);
		click(driver, Route_First_Val);
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);

		click(driver, ERO_SVM);
		wait(driver, "1");
		mouseOverAndClick(driver, Route_Pol_Terminal);
		WebElement scroller9 = driver.findElement(By.xpath("(//div[@ref='eBodyHorizontalScrollViewport'])[2]"));
		int scrollAmount9 = 1500; //
		js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller9, scrollAmount9);
		wait(driver, "2");
		click(driver, Route_Pod_Terminal);
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver, EPO_SelectFilterSearchBox);
		Fluentwait(driver, Route_First_Val);
		click(driver, Route_First_Val);
		if (isDisplayed(driver, Route_First_Val)) {
			System.out.println("Route Details count option is displayed ");
			Extent_pass(driver, "Route Details count option is displayed ", test, test1);
		} else {

			System.out.println("Route Details count option is not  displayed ");
			Extent_fail(driver, "Route Details count option is not displayed ", test, test1);
		}
		Fluentwait(driver, Route_First_Val);
		click(driver, Route_First_Val);
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);

		click(driver, ERO_SVM);
		wait(driver, "1");
		mouseOverAndClick(driver, Route_Pol_Terminal);
		WebElement scroller10 = driver.findElement(By.xpath("(//div[@ref='eBodyHorizontalScrollViewport'])[2]"));
		int scrollAmount10 = 2000; //
		js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller10, scrollAmount10);
		wait(driver, "2");
		click(driver, Route_Delivery_mode);
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver, EPO_SelectFilterSearchBox);
		Fluentwait(driver, Route_First_Val);
		click(driver, Route_First_Val);
		if (isDisplayed(driver, Route_First_Val)) {
			System.out.println("Route Details count option is displayed ");
			Extent_pass(driver, "Route Details count option is displayed ", test, test1);
		} else {

			System.out.println("Route Details count option is not displayed ");
			Extent_fail(driver, "Route Details count option is not  displayed ", test, test1);
		}
		Fluentwait(driver, Route_First_Val);
		click(driver, Route_First_Val);
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);

		click(driver, ERO_SVM);
		wait(driver, "1");
		mouseOverAndClick(driver, Route_Pol_Terminal);
		WebElement scroller11 = driver.findElement(By.xpath("(//div[@ref='eBodyHorizontalScrollViewport'])[2]"));
		int scrollAmount11 = 2000; //
		js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller11, scrollAmount11);
		wait(driver, "2");
		click(driver, Route_Transit_Day);
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver, EPO_SelectFilterSearchBox);
		Fluentwait(driver, Route_First_Val);
		click(driver, Route_First_Val);
		if (isDisplayed(driver, Route_First_Val)) {
			System.out.println("Route Details count option is displayed ");
			Extent_pass(driver, "Route Details count option is displayed ", test, test1);
		} else {

			System.out.println("Route Details count option is not displayed ");
			Extent_fail(driver, "Route Details count option is not  displayed ", test, test1);
		}
		Fluentwait(driver, Route_First_Val);
		click(driver, Route_First_Val);
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);

		System.out.println("Testcase 173,completed");

		Fluentwait(driver, Ero_cancle1);
		click(driver, Ero_cancle1);

		Extent_cal(test,
				"Testcase 156,Ensure Deficit and Surplus location identification screen navigate to ERO routing screen with no records");

		Fluentwait(driver, Cancel);
		click(driver, Cancel);

		wait(driver, "2");
		Fluentwait(driver, New);
		click(driver, New);

		Fluentwait(driver, New_Popup_Yes);
		click(driver, New_Popup_Yes);

		wait(driver, "2");
		Fluentwait(driver, Defi_From_Dropdown);
		click(driver, Defi_From_Dropdown);
		wait(driver, "2");

		Fluentwait(driver, Defi_From_Dropdown);
		click(driver, Defi_From_Dropdown);
		wait(driver, "2");

		Fluentwait(driver, Defi_To_Dropdown);
		click(driver, Defi_To_Dropdown);

		Fluentwait(driver, Defi_To_Dropdown);
		click(driver, Defi_To_Dropdown);

		Fluentwait(driver, Defi_To_Dropdown);
		click(driver, Defi_To_Dropdown);

		Fluentwait(driver, Defi_To_Week);
		clear(driver, Defi_To_Week);

		wait(driver, "1");
		sendKeys(driver, Defi_To_Week, "52");
		wait(driver, "1");

		Fluentwait(driver, Show_Val);
		click(driver, Show_Val);

		if (No_Record_Pop.equals(NO_Records)) {
			System.out.println("After click on show button  No records message is displayed ");
			Extent_pass(driver, "After click on show button  :" + NO_Records + "message is displayed ", test, test1);
		} else {
			System.out.println("After click on show button  No records message is not  displayed ");
			Extent_pass(driver, "After click on show button  :" + NO_Records + "message is not displayed ", test,
					test1);
		}

		Fluentwait(driver, ERO_Save_ok);
		click(driver, ERO_Save_ok);
		if (!IsElementEnabled(driver, ERO_route)) {

			System.out.println("After click on show button  Routebutton is not enabled ");
			Extent_pass(driver, "After click on show button  Routebutton is not enabled ", test, test1);
		} else {
			System.out.println("After click on show button  Routebutton is  enabled ");
			Extent_fail(driver, "After click on show button  Routebutton is enabled ", test, test1);

		}

		System.out.println("Testcase 156, completed ");

		Extent_cal(test, "Testcase 160,Verify route details tab data fetch from routing screen");

		Fluentwait(driver, Cancel);
		click(driver, Cancel);

		wait(driver, "2");
		Fluentwait(driver, New);
		click(driver, New);

		Fluentwait(driver, New_Popup_Yes);
		click(driver, New_Popup_Yes);
		wait(driver, "2");
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
		String total = getText(driver, ERO_Total_Count);
		System.out.println("total value" + total);
		if (total.equals(TotalRecords)) {
			System.out.println("Route Details count is displayed ");
			Extent_pass(driver, "Route Details count is : " + TotalRecords, test, test1);
		} else {
			System.out.println("Route Details count is not  displayed ");
			Extent_fail(driver, "Route Details count is not : " + TotalRecords, test, test1);
		}

		System.out.println("Testcase 160, completed ");

	}

}
