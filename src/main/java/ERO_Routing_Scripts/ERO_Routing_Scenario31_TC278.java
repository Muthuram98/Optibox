package ERO_Routing_Scripts;

import java.awt.Checkbox;
import java.awt.Robot;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.ClickAction;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.Utils;

public class ERO_Routing_Scenario31_TC278 extends Keywords {

	@SuppressWarnings("unlikely-arg-type")
	public void ERO_Scenario31(WebDriver driver, ExtentTest test, ExtentTest test1, String url, int dataset) throws Exception {
		String Username = Utils.getDataFromTestData("ERO_Scenario31_1_Dataset"+dataset, "ERO Routing", "Username");
		String Password = Utils.getDataFromTestData("ERO_Scenario31_1_Dataset"+dataset, "ERO Routing", "Password");
		String ID = Utils.getDataFromTestData("ERO_Scenario31_1_Dataset"+dataset, "ERO Routing", "Id");

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

		wait(driver, "3");

		if (isDisplayed(driver, session_confirmation)) {
			Fluentwait(driver, session_confirmation);
			click(driver, session_confirmation);
		}

		Fluentwait(driver, Searchbox);
		sendKeys(driver, Searchbox, "deficit");

		Fluentwait(driver, DEFI_Search);
		click(driver, DEFI_Search);

		wait(driver, "3");

		Extent_cal(test,
				" 273- Ensure the “All Equipment Reposition solve” screen for all equipment type option and single equipment type option navigate to simulation JSP page it displayed in web browser");

		Fluentwait(driver, Global_Search);
		click(driver, Global_Search);

		Fluentwait(driver, Globalserach_IDInput);
		sendKeys(driver, Globalserach_IDInput, ID);

		wait(driver, "2");

		Fluentwait(driver, Click_Search);
		click(driver, Click_Search);

		wait(driver, "5");

		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);

		wait(driver, "5");

		if (isDisplayed(driver, ERO_popup_ok)) {

			click(driver, ERO_popup_ok);
		}

		click(driver, ERO_route);

		Fluentwait(driver, Optimizer_Button);
		click(driver, Optimizer_Button);

		click(driver, Ok_Pop);

		wait(driver, "3");

		String Size1 = getText(driver, Size1_Emp);

		System.out.println("Size1 : " + Size1);

		String Size2 = getText(driver, Size2_Emp);

		System.out.println("Size2 : " + Size2);

		String Size3 = getText(driver, Size3_Emp);

		System.out.println("Size3 : " + Size3);

		String Size4 = getText(driver, Size4_Emp);

		System.out.println("Size4 : " + Size4);

		String Size5 = getText(driver, Size5_Emp);

		System.out.println("Size5 : " + Size5);

		String Size6 = getText(driver, Size6_Emp);

		System.out.println("Size6 : " + Size6);

		String Size7 = getText(driver, Size7_Emp);

		System.out.println("Size7 : " + Size7);

		String Size8 = getText(driver, Size8_Emp);

		System.out.println("Size8 : " + Size8);

		wait(driver, "3");

		Fluentwait(driver, ERO_Chat);
		click(driver, ERO_Chat);

		wait(driver, "5");

		// WebElement chart = driver.findElement(By.xpath("//object"));
		// driver.switchTo().frame(chart);

		wait(driver, "5");

		String Size1_Chart = getText(driver, Size1_ERO);

		System.out.println("Size1_Chart : " + Size1_Chart);

		String Size2_Chart = getText(driver, Size2_ERO);

		System.out.println("Size2_Chart : " + Size2_Chart);

		String Size3_Chart = getText(driver, Size3_ERO);

		System.out.println("Size3_Chart : " + Size3_Chart);

		String Size4_Chart = getText(driver, Size4_ERO);

		System.out.println("Size4_Chart : " + Size4_Chart);

		String Size5_Chart = getText(driver, Size5_ERO);

		System.out.println("Size5_Chart : " + Size5_Chart);

		String Size6_Chart = getText(driver, Size6_ERO);

		System.out.println("Size6_Chart : " + Size6_Chart);

		String Size7_Chart = getText(driver, Size7_ERO);

		System.out.println("Size7_Chart : " + Size7_Chart);

		String Size8_Chart = getText(driver, Size8_ERO);

		System.out.println("Size8_Chart : " + Size8_Chart);

		if (Size1.equals(Size1_Chart)) {
			System.out.println("Matched || Expected Total Quantity was : " + Size1_Chart
					+ " Actual Total Quantity was : " + Size1);
			Extent_pass(driver,
					"Matched || Expected Total Quantity was : " + Size1_Chart + " Actual Total Quantity was : " + Size1,
					test, test1);
		} else {
			System.out.println("Not Matched || Expected Total Quantity was : " + Size1_Chart
					+ " || Actual Total Quantity was : " + Size1);
			Extent_fail2(driver, "Not Matched || Expected Total Quantity was : " + Size1_Chart
					+ " || Actual Total Quantity was : " + Size1, test);

		}

		if (Size2.equals(Size2_Chart)) {
			System.out.println("Matched || Expected Total Quantity was : " + Size2_Chart
					+ " Actual Total Quantity was : " + Size2);
			Extent_pass(driver,
					"Matched || Expected Total Quantity was : " + Size2_Chart + " Actual Total Quantity was : " + Size2,
					test, test1);
		} else {
			System.out.println("Not Matched || Expected Total Quantity was : " + Size2_Chart
					+ " || Actual Total Quantity was : " + Size2);
			Extent_fail2(driver, "Not Matched || Expected Total Quantity was : " + Size2_Chart
					+ " || Actual Total Quantity was : " + Size2, test);
		}

		if (Size3.equals(Size3_Chart)) {
			System.out.println("Matched || Expected Total Quantity was : " + Size3_Chart
					+ " Actual Total Quantity was : " + Size3);
			Extent_pass(driver,
					"Matched || Expected Total Quantity was : " + Size3_Chart + " Actual Total Quantity was : " + Size3,
					test, test1);
		} else {
			System.out.println("Not Matched || Expected Total Quantity was : " + Size3_Chart
					+ " || Actual Total Quantity was : " + Size3);
			Extent_fail2(driver, "Not Matched || Expected Total Quantity was : " + Size3_Chart
					+ " || Actual Total Quantity was : " + Size3, test);

		}

		if (Size4.equals(Size4_Chart)) {
			System.out.println("Matched || Expected Total Quantity was : " + Size4_Chart
					+ " Actual Total Quantity was : " + Size4);
			Extent_pass(driver,
					"Matched || Expected Total Quantity was : " + Size4_Chart + " Actual Total Quantity was : " + Size4,
					test, test1);
		} else {
			System.out.println("Not Matched || Expected Total Quantity was : " + Size4_Chart
					+ " || Actual Total Quantity was : " + Size4);
			Extent_fail2(driver, "Not Matched || Expected Total Quantity was : " + Size4_Chart
					+ " || Actual Total Quantity was : " + Size4, test);

		}

		if (Size5.equals(Size5_Chart)) {
			System.out.println("Matched || Expected Total Quantity was : " + Size5_Chart
					+ " Actual Total Quantity was : " + Size1);
			Extent_pass(driver,
					"Matched || Expected Total Quantity was : " + Size5_Chart + " Actual Total Quantity was : " + Size5,
					test, test1);
		} else {
			System.out.println("Not Matched || Expected Total Quantity was : " + Size5_Chart
					+ " || Actual Total Quantity was : " + Size5);
			Extent_fail2(driver, "Not Matched || Expected Total Quantity was : " + Size5_Chart
					+ " || Actual Total Quantity was : " + Size5, test);

		}

		if (Size6.equals(Size6_Chart)) {
			System.out.println("Matched || Expected Total Quantity was : " + Size6_Chart
					+ " Actual Total Quantity was : " + Size6);
			Extent_pass(driver,
					"Matched || Expected Total Quantity was : " + Size6_Chart + " Actual Total Quantity was : " + Size6,
					test, test1);
		} else {
			System.out.println("Not Matched || Expected Total Quantity was : " + Size6_Chart
					+ " || Actual Total Quantity was : " + Size6);
			Extent_fail2(driver, "Not Matched || Expected Total Quantity was : " + Size6_Chart
					+ " || Actual Total Quantity was : " + Size6, test);

		}

		if (Size7.equals(Size7_Chart)) {
			System.out.println("Matched || Expected Total Quantity was : " + Size7_Chart
					+ " Actual Total Quantity was : " + Size7);
			Extent_pass(driver,
					"Matched || Expected Total Quantity was : " + Size7_Chart + " Actual Total Quantity was : " + Size7,
					test, test1);
		} else {
			System.out.println("Not Matched || Expected Total Quantity was : " + Size7_Chart
					+ " || Actual Total Quantity was : " + Size7);
			Extent_fail2(driver, "Not Matched || Expected Total Quantity was : " + Size7_Chart
					+ " || Actual Total Quantity was : " + Size7, test);

		}

		if (Size8.equals(Size8_Chart)) {
			System.out.println("Matched || Expected Total Quantity was : " + Size8_Chart
					+ " Actual Total Quantity was : " + Size8);
			Extent_pass(driver,
					"Matched || Expected Total Quantity was : " + Size8_Chart + " Actual Total Quantity was : " + Size8,
					test, test1);
		} else {
			System.out.println("Not Matched || Expected Total Quantity was : " + Size8_Chart
					+ " || Actual Total Quantity was : " + Size8);
			Extent_fail2(driver, "Not Matched || Expected Total Quantity was : " + Size8_Chart
					+ " || Actual Total Quantity was : " + Size8, test);

		}

		System.out.println(
				"//***************************Testcase 273 Completed **************************************//");

		Extent_cal(test,
				" 277- Ensure the “All Equipment Reposition report” screen for all equipment type option and single equipment type option navigate to View Gate screen ");

		wait(driver, "3");

		Fluentwait(driver, EMP_Report);
		click(driver, EMP_Report);

		
		wait(driver, "3");

		
		
		Fluentwait(driver, Type_Filter);
		click(driver, Type_Filter);

		click(driver, EPO_SelectFilterOption);
		
		
		

		// Fluentwait(driver, Load_Loc_Selectall);
		// click(driver, Load_Loc_Selectall);

		click(driver, Leese_Search);

		sendKeys(driver, Leese_Search, "20DY");

		String Size1_Report = getText(driver, Report_Size);

		System.out.println("Size1_Report : " + Size1_Report);

		clear(driver, Leese_Search);

		sendKeys(driver, Leese_Search, "20HC");

		String Size2_Report = getText(driver, Report_Size);

		System.out.println("Size2_Report : " + Size2_Report);
		clear(driver, Leese_Search);

		sendKeys(driver, Leese_Search, "20HH");

		String Size3_Report = getText(driver, Report_Size);

		System.out.println("Size3_Report : " + Size3_Report);
		clear(driver, Leese_Search);

		sendKeys(driver, Leese_Search, "20RF");

		String Size4_Report = getText(driver, Report_Size);

		System.out.println("Size4_Report : " + Size4_Report);
		clear(driver, Leese_Search);

		sendKeys(driver, Leese_Search, "40DY");

		String Size5_Report = getText(driver, Report_Size);

		System.out.println("Size5_Report : " + Size5_Report);
		clear(driver, Leese_Search);

		sendKeys(driver, Leese_Search, "40HC");

		String Size6_Report = getText(driver, Report_Size);

		System.out.println("Size6_Report : " + Size6_Report);
		clear(driver, Leese_Search);

		sendKeys(driver, Leese_Search, "40HR");

		String Size7_Report = getText(driver, Report_Size);

		System.out.println("Size7_Report : " + Size7_Report);
		clear(driver, Leese_Search);

		sendKeys(driver, Leese_Search, "40OT");

		String Size8_Report = getText(driver, Report_Size);

		System.out.println("Size8_Report : " + Size8_Report);
		clear(driver, Leese_Search);

		wait(driver, "3");

		Fluentwait(driver, ERO_Chat);
		click(driver, ERO_Chat);

		wait(driver, "5");

		// WebElement chart = driver.findElement(By.xpath("//object"));
		// driver.switchTo().frame(chart);

		wait(driver, "5");

		String Size1_Chart_Report = getText(driver, Size1_ERO);

		System.out.println("Size1_Chart_Report : " + Size1_Chart_Report);

		String Size2_Chart_Report = getText(driver, Size2_ERO);

		System.out.println("Size2_Chart_Report : " + Size2_Chart_Report);

		String Size3_Chart_Report = getText(driver, Size3_ERO);

		System.out.println("Size3_Chart_Report : " + Size3_Chart_Report);

		String Size4_Chart_Report = getText(driver, Size4_ERO);

		System.out.println("Size4_Chart_Report : " + Size4_Chart_Report);

		String Size5_Chart_Report = getText(driver, Size5_ERO);

		System.out.println("Size5_Chart_Report : " + Size5_Chart_Report);

		String Size6_Chart_Report = getText(driver, Size6_ERO);

		System.out.println("Size6_Chart_Report : " + Size6_Chart_Report);

		String Size7_Chart_Report = getText(driver, Size7_ERO);

		System.out.println("Size7_Chart_Report : " + Size7_Chart_Report);

		String Size8_Chart_Report = getText(driver, Size8_ERO);

		System.out.println("Size8_Chart_Report : " + Size8_Chart_Report);

		if (Size1_Report.equals(Size1_Chart_Report)) {
			System.out.println("Matched || Expected Total Quantity was : " + Size1_Chart_Report
					+ " Actual Total Quantity was : " + Size1_Report);
			Extent_pass(driver, "Matched || Expected Total Quantity was : " + Size1_Chart_Report
					+ " Actual Total Quantity was : " + Size1_Report, test, test1);
		} else {
			System.out.println("Not Matched || Expected Total Quantity was : " + Size1_Chart_Report
					+ " || Actual Total Quantity was : " + Size1_Report);
			Extent_fail2(driver, "Not Matched || Expected Total Quantity was : " + Size1_Chart_Report
					+ " || Actual Total Quantity was : " + Size1_Report, test);

		}

		if (Size2_Report.equals(Size2_Chart_Report)) {
			System.out.println("Matched || Expected Total Quantity was : " + Size2_Chart_Report
					+ " Actual Total Quantity was : " + Size2_Report);
			Extent_pass(driver, "Matched || Expected Total Quantity was : " + Size2_Chart_Report
					+ " Actual Total Quantity was : " + Size2_Report, test, test1);
		} else {
			System.out.println("Not Matched || Expected Total Quantity was : " + Size2_Chart_Report
					+ " || Actual Total Quantity was : " + Size2_Report);
			Extent_fail2(driver, "Not Matched || Expected Total Quantity was : " + Size2_Chart_Report
					+ " || Actual Total Quantity was : " + Size2_Report, test);

		}

		if (Size3_Report.equals(Size3_Chart_Report)) {
			System.out.println("Matched || Expected Total Quantity was : " + Size3_Chart_Report
					+ " Actual Total Quantity was : " + Size3_Report);
			Extent_pass(driver, "Matched || Expected Total Quantity was : " + Size3_Chart_Report
					+ " Actual Total Quantity was : " + Size3_Report, test, test1);
		} else {
			System.out.println("Not Matched || Expected Total Quantity was : " + Size3_Chart_Report
					+ " || Actual Total Quantity was : " + Size3_Report);
			Extent_fail2(driver, "Not Matched || Expected Total Quantity was : " + Size3_Chart_Report
					+ " || Actual Total Quantity was : " + Size3_Report, test);

		}

		if (Size4_Report.equals(Size4_Chart_Report)) {
			System.out.println("Matched || Expected Total Quantity was : " + Size4_Chart_Report
					+ " Actual Total Quantity was : " + Size4_Report);
			Extent_pass(driver, "Matched || Expected Total Quantity was : " + Size4_Chart_Report
					+ " Actual Total Quantity was : " + Size4_Report, test, test1);
		} else {
			System.out.println("Not Matched || Expected Total Quantity was : " + Size4_Chart_Report
					+ " || Actual Total Quantity was : " + Size4_Report);
			Extent_fail2(driver, "Not Matched || Expected Total Quantity was : " + Size4_Chart_Report
					+ " || Actual Total Quantity was : " + Size4_Report, test);

		}

		if (Size5_Report.equals(Size5_Chart_Report)) {
			System.out.println("Matched || Expected Total Quantity was : " + Size5_Chart_Report
					+ " Actual Total Quantity was : " + Size5_Report);
			Extent_pass(driver, "Matched || Expected Total Quantity was : " + Size5_Chart_Report
					+ " Actual Total Quantity was : " + Size5_Report, test, test1);
		} else {
			System.out.println("Not Matched || Expected Total Quantity was : " + Size5_Chart_Report
					+ " || Actual Total Quantity was : " + Size5_Report);
			Extent_fail2(driver, "Not Matched || Expected Total Quantity was : " + Size5_Chart_Report
					+ " || Actual Total Quantity was : " + Size5_Report, test);

		}

		if (Size6_Report.equals(Size6_Chart_Report)) {
			System.out.println("Matched || Expected Total Quantity was : " + Size6_Chart_Report
					+ " Actual Total Quantity was : " + Size6_Report);
			Extent_pass(driver, "Matched || Expected Total Quantity was : " + Size6_Chart_Report
					+ " Actual Total Quantity was : " + Size6_Report, test, test1);
		} else {
			System.out.println("Not Matched || Expected Total Quantity was : " + Size6_Chart_Report
					+ " || Actual Total Quantity was : " + Size6_Report);
			Extent_fail2(driver, "Not Matched || Expected Total Quantity was : " + Size6_Chart_Report
					+ " || Actual Total Quantity was : " + Size6_Report, test);

		}

		if (Size7_Report.equals(Size7_Chart_Report)) {
			System.out.println("Matched || Expected Total Quantity was : " + Size7_Chart_Report
					+ " Actual Total Quantity was : " + Size7_Report);
			Extent_pass(driver, "Matched || Expected Total Quantity was : " + Size7_Chart_Report
					+ " Actual Total Quantity was : " + Size7_Report, test, test1);
		} else {
			System.out.println("Not Matched || Expected Total Quantity was : " + Size7_Chart_Report
					+ " || Actual Total Quantity was : " + Size7_Report);
			Extent_fail2(driver, "Not Matched || Expected Total Quantity was : " + Size7_Chart_Report
					+ " || Actual Total Quantity was : " + Size7_Report, test);

		}

		if (Size8_Report.equals(Size8_Chart_Report)) {
			System.out.println("Matched || Expected Total Quantity was : " + Size8_Chart_Report
					+ " Actual Total Quantity was : " + Size8_Report);
			Extent_pass(driver, "Matched || Expected Total Quantity was : " + Size8_Chart_Report
					+ " Actual Total Quantity was : " + Size8_Report, test, test1);
		} else {
			System.out.println("Not Matched || Expected Total Quantity was : " + Size8_Chart_Report
					+ " || Actual Total Quantity was : " + Size8_Report);
			Extent_fail2(driver, "Not Matched || Expected Total Quantity was : " + Size8_Chart_Report
					+ " || Actual Total Quantity was : " + Size8_Report, test);

		}

		System.out.println(
				"//***************************Testcase 277 Completed **************************************//");

		Extent_cal(test,
				" 278- Ensure the “All Equipment Reposition report” screen for all equipment type option and single equipment type option navigate to View Gate screen ");

		Fluentwait(driver, EMP_Report);
		click(driver, EMP_Report);

		Fluentwait(driver, Filter_Loc);
		click(driver, Filter_Loc);

	//click(driver, EPO_SelectFilterOption);

		Fluentwait(driver, Load_Loc_Selectall);
		click(driver, Load_Loc_Selectall);

		click(driver, Leese_Search);

		sendKeys(driver, Leese_Search, "PGGUR");

		Fluentwait(driver, Load_Loc_Selectall);
		click(driver, Load_Loc_Selectall);

		String Quantity1 = getText(driver, Qty_1);

		System.out.println("Quantity1 : " + Quantity1);

		String Quantity2 = getText(driver, Qty_2);

		System.out.println("Quantity2 : " + Quantity2);

		String Quantity3 = getText(driver, Qty_3);

		System.out.println("Quantity3 : " + Quantity3);

		int TotalCount = Integer.parseInt(Quantity1) + Integer.parseInt(Quantity2) + Integer.parseInt(Quantity3);
		System.out.println("TotalCount : " + TotalCount);

//Scrolltilltheelementvisible(driver, View_GAte);		

		click(driver, View_GAte);

		wait(driver, "5");

		// Scrolltilltheelementvisible(driver, Load_Region_ERO);

		scrollBottom(driver);

		scrollUp(driver);

		click(driver, Load_Region_ERO);

		click(driver, Searchcode_input_ERO);

		sendKeys(driver, Searchcode_input_ERO, "PNG");

		click(driver, Select_Region);

		wait(driver, "5");

		//click(driver, Show_Button_ERO1);

		//wait(driver, "5");

		click(driver, Load_Location_ERO);
		wait(driver, "5");


		click(driver, Load_Location_Search);

		sendKeys(driver, Load_Location_Search, "PGGUR");

		wait(driver, "5");

		doubleClick(driver, Load_Location_Select_1);
		wait(driver, "2");

		//click(driver, Load_Location_Select);

		wait(driver, "3");

		click(driver, Show_Button_ERO1);

		wait(driver, "3");

		String Total_Gate_QTY = getAttribute(driver, Total_Qty, "value");
		System.out.println("Total_Gate_QTY : " + Total_Gate_QTY);

		String Quality_Count = String.valueOf(TotalCount);

		if (Total_Gate_QTY.equals(Quality_Count)) {
			System.out.println("Matched || Expected Total Quantity was : " + Quality_Count
					+ " Actual Total Quantity was : " + Total_Gate_QTY);
			Extent_pass(driver, "Matched || Expected Total Quantity was : " + Quality_Count
					+ " Actual Total Quantity was : " + Total_Gate_QTY, test, test1);
		} else {
			System.out.println("Not Matched || Expected Total Quantity was : " + Quality_Count
					+ " || Actual Total Quantity was : " + Total_Gate_QTY);
			Extent_fail2(driver, "Not Matched || Expected Total Quantity was : " + Quality_Count
					+ " || Actual Total Quantity was : " + Total_Gate_QTY, test);

		}

		System.out.println(
				"//***************************Testcase 278 Completed **************************************//");

	}
}
