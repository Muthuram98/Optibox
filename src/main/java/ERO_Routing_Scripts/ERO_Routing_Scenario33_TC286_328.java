package ERO_Routing_Scripts;

import java.awt.Robot;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentTest;
import com.gargoylesoftware.htmlunit.javascript.host.event.SVGZoomEvent;

import commonMethods.Keywords;
import commonMethods.Utils;

public class ERO_Routing_Scenario33_TC286_328 extends Keywords {

	public void ERO_Scenario33(WebDriver driver, ExtentTest test, ExtentTest test1, String url, int dataset) throws Exception {
		String Username = Utils.getDataFromTestData("ERO_Scenario33_Dataset"+dataset, "ERO Routing", "Username");
		String Password = Utils.getDataFromTestData("ERO_Scenario33_Dataset"+dataset, "ERO Routing", "Password");
		String ID = Utils.getDataFromTestData("ERO_Scenario33_Dataset"+dataset, "ERO Routing", "Id");
		String Default_Filter_ByRegion = Utils.getDataFromTestData("ERO_Scenario33_Dataset"+dataset, "ERO Routing",
				"Default_Filter_By_Volume");
		String Surplus_Graph = Utils.getDataFromTestData("ERO_Scenario33_Dataset"+dataset, "ERO Routing", "Surplus_Text");
		String Deficit_Graph = Utils.getDataFromTestData("ERO_Scenario33_Dataset"+dataset, "ERO Routing", "Deficit_Text");
		String Deficit_Graph_1 = Utils.getDataFromTestData("ERO_Scenario33_Dataset"+dataset, "ERO Routing", "Deficit_Text1_1");
		String Deficit_Graph1 = Utils.getDataFromTestData("ERO_Scenario33_Dataset"+dataset, "ERO Routing", "Deficit_Text1");
		String Deficit_Graph1_1 = Utils.getDataFromTestData("ERO_Scenario33_Dataset"+dataset, "ERO Routing", "Deficit_Text1_11");

		String Deficit_Graph2 = Utils.getDataFromTestData("ERO_Scenario33_Dataset"+dataset, "ERO Routing", "Deficit_Text2");
		String Deficit_Graph2_1 = Utils.getDataFromTestData("ERO_Scenario33_Dataset"+dataset, "ERO Routing", "Deficit_Text2_1");

		String Surplus_Graph2 = Utils.getDataFromTestData("ERO_Scenario33_Dataset"+dataset, "ERO Routing", "Surplus_Text1");
		String Surplus_Graph2_2 = Utils.getDataFromTestData("ERO_Scenario33_Dataset"+dataset, "ERO Routing", "Surplus_Text1_2");

		String ANZ_Surplus_Graph = Utils.getDataFromTestData("ERO_Scenario33_Dataset"+dataset, "ERO Routing", "ANZ_GRAPH");
		String SPI_Surplus_Graph = Utils.getDataFromTestData("ERO_Scenario33_Dataset"+dataset, "ERO Routing", "SPI_GRAPH");
		String PNG_Surplus_Graph = Utils.getDataFromTestData("ERO_Scenario33_Dataset"+dataset, "ERO Routing", "PNG_GRAPH");
		String Expected_screencolor_PNG_Graph = Utils.getDataFromTestData("ERO_Scenario33_Dataset"+dataset, "ERO Routing",
				"Background_PNG_Graph");
		String Expected_screencolor_SPI_Graph = Utils.getDataFromTestData("ERO_Scenario33_Dataset"+dataset, "ERO Routing",
				"Background_SPI_Graph");
		String Expected_screencolor_ANZ_Graph = Utils.getDataFromTestData("ERO_Scenario33_Dataset"+dataset, "ERO Routing",
				"Background_ANZ_Graph");
		String Network_Chart_Filter = Utils.getDataFromTestData("ERO_Scenario33_Dataset"+dataset, "ERO Routing", "Network_Chart_Orgin");
		String Network_Chart_Filter1 = Utils.getDataFromTestData("ERO_Scenario33_Dataset"+dataset, "ERO Routing",
				"Network_Chart_Orgin1");
		String Expected_screencolor_SEA_Graph = Utils.getDataFromTestData("ERO_Scenario33_Dataset"+dataset, "ERO Routing",
				"Expected_Color_SEA_Graph");

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
		
		wait(driver, "5");

		Fluentwait(driver, Searchbox);
		sendKeys(driver, Searchbox, "Ero Rou");

		Fluentwait(driver, Select_Optimizer);
		click(driver, Select_Optimizer);

		wait(driver, "3");

		Extent_cal(test,
				" 286- Check whether system should display the web page with By volume,By cost,By region wise, network chart tabs ");

		Fluentwait(driver, Routing_GlobalSearch);
		click(driver, Routing_GlobalSearch);

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

		click(driver, Optimizer_Button);

		click(driver, Ok_Pop);

		wait(driver, "3");

		Fluentwait(driver, ERO_Chat);
		click(driver, ERO_Chat);

		wait(driver, "5");

		WebElement chart = driver.findElement(By.xpath("//object"));
		driver.switchTo().frame(chart);

		wait(driver, "10");

		// waitForElement(driver, Table);

		if (isDisplayed(driver, By_Volume)) {
			Extent_pass(driver, "Web Page By Volume is Displayed", test, test1);
		} else {
			Extent_fail(driver, "Web Page By Volume is Not  Displayed", test, test1);
		}

		wait(driver, "3");

		if (isDisplayed(driver, By_Cost)) {
			Extent_pass(driver, "Web Page  By Cost is Displayed", test, test1);
		} else {
			Extent_fail(driver, "Web Page  By Cost is Not  Displayed", test, test1);
		}

		wait(driver, "3");

		if (isDisplayed(driver, By_Region)) {
			Extent_pass(driver, "Web Page  By Region is Displayed", test, test1);
		} else {
			Extent_fail(driver, "Web Page is  By Region Not  Displayed", test, test1);
		}
		wait(driver, "3");

		if (isDisplayed(driver, Network_Chart)) {
			Extent_pass(driver, "Web Page Network Chart is Displayed", test, test1);
		} else {
			Extent_fail(driver, "Web Page is Network Chart Not  Displayed", test, test1);
		}

		Extent_cal(test,
				"Testcase 287 Ensure the By volume tab chart wise representation x axis quantity details and y axis surplus details displayed for one equipment type");

		wait(driver, "2");

		driver.switchTo().defaultContent();

		wait(driver, "2");

		Fluentwait(driver, Emp_Repo);
		click(driver, Emp_Repo);

		wait(driver, "2");

		String Count1 = getText(driver, Fetch_Value1);

		System.out.println("Count1 : " + Count1);

		String[] splivalue1 = Count1.split("\\[");

		String[] expect_value1 = splivalue1[1].split("\\]");

		String Surplus_count1 = expect_value1[0];

		System.out.println("Surplus_count1 : " + Surplus_count1);

		wait(driver, "3");

		Fluentwait(driver, ERO_Chat);
		click(driver, ERO_Chat);

		wait(driver, "5");

		WebElement chart1 = driver.findElement(By.xpath("//object"));
		driver.switchTo().frame(chart1);

		mouseOverToElement(driver, Details);

		String Count_Graph = getText(driver, Count);

		System.out.println("Count_Graph : " + Count_Graph);
		String[] splivalue = Count_Graph.split("\\:");

		String[] expect_value = splivalue[1].split("\\]");

		String Surplus_count = expect_value[0].trim();

		System.out.println("Surplus_count : " + Surplus_count);

		wait(driver, "3");

		if (Surplus_count1.equals(Surplus_count)) {
			// Extent_pass(driver, "Warning popup message having proper message with
			// icon(!)", test,test1);
			System.out.println(
					"Matched || Expected Count was : " + Surplus_count + " Actual Count was : " + Surplus_count1);
			Extent_pass(driver,
					"Matched || Expected Count  was : " + Surplus_count + " || Actual Count  was : " + Surplus_count1,
					test, test1);
		} else {
			System.out.println(
					"Not Matched || Expected Count was : " + Surplus_count + " Actual Count was : " + Surplus_count1);
			Extent_fail2(driver,
					"Not Matched || Expected Count was : " + Surplus_count + " || Actual Count was : " + Surplus_count1,
					test);

		}
		System.out.println(
				"//***************************Testcase 287 Completed **************************************//");

		Extent_cal(test,
				"Testcase 288 Ensure the By volume tab chart wise representation x axis quantity details and y axis Deficit details displayed for one equipment type");

		driver.switchTo().defaultContent();

		wait(driver, "2");

		Fluentwait(driver, Emp_Repo);
		click(driver, Emp_Repo);

		wait(driver, "2");

		String Count_Deficit = getText(driver, Fetch_Value_Deficit);

		System.out.println("Count_Deficit : " + Count_Deficit);

		String[] splivalue2 = Count_Deficit.split("\\[");

		String[] expect_value2 = splivalue2[1].split("\\]");

		String Surplus_count2 = expect_value2[0];

		System.out.println("Surplus_count2 : " + Surplus_count2);

		wait(driver, "3");

		Fluentwait(driver, ERO_Chat);
		click(driver, ERO_Chat);

		wait(driver, "5");

		WebElement chart2 = driver.findElement(By.xpath("//object"));
		driver.switchTo().frame(chart2);
		wait(driver, "3");

		mouseOverToElement(driver, Details1);

		String Count_Graph_Deficit = getText(driver, Count);

		System.out.println("Count_Graph_Deficit : " + Count_Graph_Deficit);
		String[] splivalue3 = Count_Graph_Deficit.split("\\:");

		String[] expect_value3 = splivalue3[1].split("\\]");

		String Surplus_count3 = expect_value3[0].trim();

		System.out.println("Surplus_count3 : " + Surplus_count3);

		wait(driver, "3");

		if (Surplus_count2.equals(Surplus_count3)) {
			System.out.println(
					"Matched || Expected Count was : " + Surplus_count3 + " Actual Count was : " + Surplus_count2);
			Extent_pass(driver,
					"Matched || Expected Count  was : " + Surplus_count3 + " || Actual Count  was : " + Surplus_count2,
					test, test1);
		} else {
			System.out.println(
					"Not Matched || Expected Count was : " + Surplus_count3 + " Actual Count was : " + Surplus_count2);
			Extent_fail2(driver, "Not Matched || Expected Count was : " + Surplus_count3 + " || Actual Count was : "
					+ Surplus_count2, test);

		}
		System.out.println(
				"//***************************Testcase 288 Completed **************************************//");

		Extent_cal(test, "Testcase 293 Ensure the filter the Region wise ASR,MER,EUR,NAM and default it set as ASR ");

		wait(driver, "3");

		// scrollBottom(driver);

		// Scrolltilltheelementvisible(driver, Region_Dropdown);

		String DefaultFilter = getText(driver, Default_Filter);

		System.out.println("DefaultFilter : " + DefaultFilter);

		if (DefaultFilter.equals(Default_Filter_ByRegion)) {
			System.out.println("Matched || Expected Default Filter was : " + Default_Filter_ByRegion
					+ " Actual Warning Default Filter  was : " + DefaultFilter);
			Extent_pass(driver, "Matched || Expected Default Filter was : " + Default_Filter_ByRegion
					+ " Actual Default Filter was : " + DefaultFilter, test, test1);
		} else {
			System.out.println("Not Matched || Expected Default Filter was : " + Default_Filter_ByRegion
					+ " || Actual Default Filter was : " + DefaultFilter);
			Extent_fail2(driver, "Not Matched || Expected Default Filter was : " + Default_Filter_ByRegion
					+ " || Actual Default Filter was : " + DefaultFilter, test);

		}

		System.out.println(
				"//***************************Testcase 293 Completed **************************************//");

		Extent_cal(test,
				"Testcase-294 Ensure the filter the Region wise ASR surplus ports and deficit port chart wise representation displayed ");

		wait(driver, "5");

		// Scrolltilltheelementvisible(driver, Surplus_ports);
		String SurplusPort = getText(driver, Surplus_ports);

		System.out.println("SurplusPort : " + SurplusPort);

		if (SurplusPort.equals(Surplus_Graph)) {
			System.out
					.println("Matched || Expected Graph was : " + Surplus_Graph + " Actual Graph was : " + SurplusPort);
			Extent_pass(driver,
					"Matched || Expected Graph was : " + Surplus_Graph + " Actual Graph was : " + SurplusPort, test,
					test1);
		} else {
			System.out.println(
					"Not Matched || Expected Graph was : " + Surplus_Graph + " || Actual Graph was : " + SurplusPort);
			Extent_fail2(driver,
					"Not Matched || Expected Graph was : " + Surplus_Graph + " || Actual Graph was : " + SurplusPort,
					test);
		}

		wait(driver, "10");

		String Deficit_Graph_Text = getText(driver, Deficit_Port);

		System.out.println("Deficit_Graph_Text : " + Deficit_Graph_Text);

		if (Deficit_Graph_Text.equals(Deficit_Graph)) {
			System.out.println(
					"Matched || Expected Graph was : " + Deficit_Graph + " Actual Graph was : " + Deficit_Graph_Text);
			Extent_pass(driver,
					"Matched || Expected Graph was : " + Deficit_Graph + " Actual Graph was : " + Deficit_Graph_Text,
					test, test1);
		} else {
			System.out.println("Not Matched || Expected Graph was : " + Deficit_Graph + " || Actual Graph was : "
					+ Deficit_Graph_Text);
			Extent_fail2(driver, "Not Matched || Expected Graph was : " + Deficit_Graph + " || Actual Graph was : "
					+ Deficit_Graph_Text, test);

		}

		System.out.println(
				"//***************************Testcase 294 Completed **************************************//");

		Extent_cal(test,
				"Testcase-295 Ensure the filter the Region wise MER surplus ports and deficit port chart wise representation displayed ");

		click(driver, Region_Dropdown);

		selectByText(driver, Region_Dropdown, "MES");

		scrollUp(driver);

		String Deficit_Graph_Text2 = getText(driver, Deficit_Port);

		System.out.println("Deficit_Graph_Text2 : " + Deficit_Graph_Text2);

		if (Deficit_Graph_Text2.equals(Deficit_Graph1)) {
			System.out.println(
					"Matched || Expected Graph was : " + Deficit_Graph1 + " Actual Graph was : " + Deficit_Graph_Text2);
			Extent_pass(driver,
					"Matched || Expected Graph was : " + Deficit_Graph1 + " Actual Graph was : " + Deficit_Graph_Text2,
					test, test1);
		} else {
			System.out.println("Not Matched || Expected Graph was : " + Deficit_Graph1 + " || Actual Graph was : "
					+ Deficit_Graph_Text2);
			Extent_fail2(driver, "Not Matched || Expected Graph was : " + Deficit_Graph1 + " || Actual Graph was : "
					+ Deficit_Graph_Text2, test);

		}

		System.out.println(
				"//***************************Testcase 295 Completed **************************************//");

		Extent_cal(test,
				"Testcase-296 Ensure the filter the Region wise EUR surplus ports and deficit port chart wise representation displayed  ");

		wait(driver, "3");

		Fluentwait(driver, Region_Dropdown);
		click(driver, Region_Dropdown);

		selectByText(driver, Region_Dropdown, "NEA");

		scrollBottom(driver);

		String Deficit_Graph_Text3 = getText(driver, Deficit_Port);

		System.out.println("Deficit_Graph_Text3 : " + Deficit_Graph_Text3);

		if (Deficit_Graph_Text3.equals(Deficit_Graph2)) {
			System.out.println(
					"Matched || Expected Graph was : " + Deficit_Graph2 + " Actual Graph was : " + Deficit_Graph_Text3);
			Extent_pass(driver,
					"Matched || Expected Graph was : " + Deficit_Graph2 + " Actual Graph was : " + Deficit_Graph_Text3,
					test, test1);
		} else {
			System.out.println("Not Matched || Expected Graph was : " + Deficit_Graph2 + " || Actual Graph was : "
					+ Deficit_Graph_Text3);
			Extent_fail2(driver, "Not Matched || Expected Graph was : " + Deficit_Graph2 + " || Actual Graph was : "
					+ Deficit_Graph_Text3, test);

		}

		System.out.println(
				"//***************************Testcase 296 Completed **************************************//");

		Extent_cal(test,
				"Testcase-297 Ensure the filter the Region wise NAM surplus ports and deficit port chart wise representation displayed  ");

		wait(driver, "3");

		Fluentwait(driver, Region_Dropdown);
		click(driver, Region_Dropdown);

		selectByText(driver, Region_Dropdown, "PNG");

		scrollBottom(driver);

		String Deficit_Graph_Text4 = getText(driver, Surplus_ports);

		System.out.println("Deficit_Graph_Text4 : " + Deficit_Graph_Text4);

		if (Deficit_Graph_Text4.equals(Surplus_Graph2)) {
			System.out.println(
					"Matched || Expected Graph was : " + Surplus_Graph2 + " Actual Graph was : " + Deficit_Graph_Text4);
			Extent_pass(driver,
					"Matched || Expected Graph was : " + Surplus_Graph2 + " Actual Graph was : " + Deficit_Graph_Text4,
					test, test1);
		} else {
			System.out.println("Not Matched || Expected Graph was : " + Surplus_Graph2 + " || Actual Graph was : "
					+ Deficit_Graph_Text4);
			Extent_fail2(driver, "Not Matched || Expected Graph was : " + Surplus_Graph2 + " || Actual Graph was : "
					+ Deficit_Graph_Text4, test);

		}

		System.out.println(
				"//***************************Testcase 297 Completed **************************************//");

		Extent_cal(test,
				"Testcase-293 Ensure the By cost tab chart wise representation x axis cost details and y axis surplus ports details displayed   ");

		driver.switchTo().defaultContent();

		wait(driver, "3");

		click(driver, Close_Optimize);

		Fluentwait(driver, Optimizer_Button);
		click(driver, Optimizer_Button);

		click(driver, Ok_Pop);

		wait(driver, "3");

		Fluentwait(driver, ERO_Chat);
		click(driver, ERO_Chat);

		wait(driver, "5");

		WebElement chart3 = driver.findElement(By.xpath("//object"));
		driver.switchTo().frame(chart3);

		wait(driver, "3");

		Fluentwait(driver, By_Cost);
		click(driver, By_Cost);

		wait(driver, "10");

		String DefaultFilter1 = getText(driver, Default_Filter);

		System.out.println("DefaultFilter : " + DefaultFilter1);

		if (DefaultFilter1.equals(Default_Filter_ByRegion)) {
			System.out.println("Matched || Expected Default Filter was : " + Default_Filter_ByRegion
					+ " Actual Warning Default Filter  was : " + DefaultFilter1);
			Extent_pass(driver, "Matched || Expected Default Filter was : " + Default_Filter_ByRegion
					+ " Actual Default Filter was : " + DefaultFilter1, test, test1);
		} else {
			System.out.println("Not Matched || Expected Default Filter was : " + Default_Filter_ByRegion
					+ " || Actual Default Filter was : " + DefaultFilter1);
			Extent_fail2(driver, "Not Matched || Expected Default Filter was : " + Default_Filter_ByRegion
					+ " || Actual Default Filter was : " + DefaultFilter1, test);

		}

		System.out.println(
				"//***************************Testcase 293 Completed **************************************//");

///////////////////////////////	
		Extent_cal(test,
				"Testcase-294 Ensure the filter the Region wise ASR surplus ports and deficit port chart wise representation displayed ");

		wait(driver, "10");
		scrollBottom(driver);

		String SurplusPort1 = getText(driver, Surplus_ports);

		System.out.println("SurplusPort1 : " + SurplusPort1);

		if (SurplusPort1.equals(Surplus_Graph)) {
			System.out.println(
					"Matched || Expected Graph was : " + Surplus_Graph + " Actual Graph was : " + SurplusPort1);
			Extent_pass(driver,
					"Matched || Expected Graph was : " + Surplus_Graph + " Actual Graph was : " + SurplusPort1, test,
					test1);
		} else {
			System.out.println(
					"Not Matched || Expected Graph was : " + Surplus_Graph + " || Actual Graph was : " + SurplusPort1);
			Extent_fail2(driver,
					"Not Matched || Expected Graph was : " + Surplus_Graph + " || Actual Graph was : " + SurplusPort1,
					test);

		}

		wait(driver, "3");

		String Deficit_Graph_Text1 = getText(driver, Deficit_Port1);

		System.out.println("Deficit_Graph_Text1 : " + Deficit_Graph_Text1);

		if (Deficit_Graph_Text1.equals(Deficit_Graph_1)) {
			System.out.println("Matched || Expected Graph was : " + Deficit_Graph_1 + " Actual Graph was : "
					+ Deficit_Graph_Text1);
			Extent_pass(driver,
					"Matched || Expected Graph was : " + Deficit_Graph_1 + " Actual Graph was : " + Deficit_Graph_Text1,
					test, test1);
		} else {
			System.out.println("Not Matched || Expected Graph was : " + Deficit_Graph_1 + " || Actual Graph was : "
					+ Deficit_Graph_Text1);
			Extent_fail2(driver, "Not Matched || Expected Graph was : " + Deficit_Graph_1 + " || Actual Graph was : "
					+ Deficit_Graph_Text1, test);

		}

		System.out.println(
				"//***************************Testcase 294 Completed **************************************//");

		Extent_cal(test,
				"Testcase-295 Ensure the filter the Region wise MER surplus ports and deficit port chart wise representation displayed ");

		wait(driver, "3");
		Fluentwait(driver, Region_Dropdown);
		click(driver, Region_Dropdown);

		selectByText(driver, Region_Dropdown, "MES");

		scrollBottom(driver);

		String Deficit_Graph_Text5 = getText(driver, Deficit_Port);

		System.out.println("Deficit_Graph_Text5 : " + Deficit_Graph_Text5);

		if (Deficit_Graph_Text5.equals(Deficit_Graph1_1)) {
			System.out.println("Matched || Expected Graph was : " + Deficit_Graph1_1 + " Actual Graph was : "
					+ Deficit_Graph_Text5);
			Extent_pass(driver, "Matched || Expected Graph was : " + Deficit_Graph1_1 + " Actual Graph was : "
					+ Deficit_Graph_Text5, test, test1);
		} else {
			System.out.println("Not Matched || Expected Graph was : " + Deficit_Graph1_1 + " || Actual Graph was : "
					+ Deficit_Graph_Text5);
			Extent_fail2(driver, "Not Matched || Expected Graph was : " + Deficit_Graph1_1 + " || Actual Graph was : "
					+ Deficit_Graph_Text5, test);

		}

		System.out.println(
				"//***************************Testcase 295 Completed **************************************//");

		Extent_cal(test,
				"Testcase-296 Ensure the filter the Region wise EUR surplus ports and deficit port chart wise representation displayed  ");

		wait(driver, "3");

		Fluentwait(driver, Region_Dropdown);
		click(driver, Region_Dropdown);

		selectByText(driver, Region_Dropdown, "NEA");

		scrollBottom(driver);

		String Deficit_Graph_Text6 = getText(driver, Deficit_Port);

		System.out.println("Deficit_Graph_Text6 : " + Deficit_Graph_Text6);

		if (Deficit_Graph_Text6.equals(Deficit_Graph2_1)) {
			System.out.println("Matched || Expected Graph was : " + Deficit_Graph2_1 + " Actual Graph was : "
					+ Deficit_Graph_Text6);
			Extent_pass(driver, "Matched || Expected Graph was : " + Deficit_Graph2_1 + " Actual Graph was : "
					+ Deficit_Graph_Text6, test, test1);
		} else {
			System.out.println("Not Matched || Expected Graph was : " + Deficit_Graph2_1 + " || Actual Graph was : "
					+ Deficit_Graph_Text6);
			Extent_fail2(driver, "Not Matched || Expected Graph was : " + Deficit_Graph2_1 + " || Actual Graph was : "
					+ Deficit_Graph_Text6, test);

		}

		System.out.println(
				"//***************************Testcase 296 Completed **************************************//");

		Extent_cal(test,
				"Testcase-297 Ensure the filter the Region wise NAM surplus ports and deficit port chart wise representation displayed  ");

		wait(driver, "3");

		Fluentwait(driver, Region_Dropdown);
		click(driver, Region_Dropdown);

		selectByText(driver, Region_Dropdown, "PNG");

		scrollBottom(driver);

		String Deficit_Graph_Text7 = getText(driver, Surplus_ports);

		System.out.println("Deficit_Graph_Text7 : " + Deficit_Graph_Text7);

		if (Deficit_Graph_Text7.equals(Surplus_Graph2_2)) {
			System.out.println("Matched || Expected Graph was : " + Surplus_Graph2_2 + " Actual Graph was : "
					+ Deficit_Graph_Text7);
			Extent_pass(driver, "Matched || Expected Graph was : " + Surplus_Graph2_2 + " Actual Graph was : "
					+ Deficit_Graph_Text7, test, test1);
		} else {
			System.out.println("Not Matched || Expected Graph was : " + Surplus_Graph2_2 + " || Actual Graph was : "
					+ Deficit_Graph_Text7);
			Extent_fail2(driver, "Not Matched || Expected Graph was : " + Surplus_Graph2_2 + " || Actual Graph was : "
					+ Deficit_Graph_Text7, test);

		}

		System.out.println(
				"//***************************Testcase 297 Completed **************************************//");

		Extent_cal(test, "Testcase-299 Ensure the By Region wise tab surplus chart ASR,EUR,MER,NAM ");

		Extent_cal(test, "Ensure the By Region wise tab surplus chart ANZ Graph");

		wait(driver, "3");

		Fluentwait(driver, By_Region);
		click(driver, By_Region);

		// ANZ
		wait(driver, "2");

		mouseOverToElement(driver, ANZ_PieChart);

		wait(driver, "5");

		String Count2 = getText(driver, Count);

		System.out.println("Count2 : " + Count2);

		String region = Count2.substring(0, 3);

		System.out.println("region : " + region);

		if (region.equals(ANZ_Surplus_Graph)) {
			System.out
					.println("Matched || Expected Graph was : " + ANZ_Surplus_Graph + " Actual Graph was : " + region);
			Extent_pass(driver,
					"Matched || Expected Graph was : " + ANZ_Surplus_Graph + " Actual Graph was : " + region, test,
					test1);
		} else {
			System.out.println(
					"Not Matched || Expected Graph was : " + ANZ_Surplus_Graph + " || Actual Graph was : " + region);
			Extent_fail2(driver,
					"Not Matched || Expected Graph was : " + ANZ_Surplus_Graph + " || Actual Graph was : " + region,
					test);

		}

		Extent_cal(test, "Ensure the By Region wise tab surplus chart SPI Graph");

		scrollBottom(driver);
		wait(driver, "2");
		mouseOverToElement(driver, SPI_PieChart);

		wait(driver, "5");

		String Count3 = getText(driver, Count);

		System.out.println("Count3 : " + Count3);

		String region1 = Count3.substring(0, 3);

		System.out.println("region1 : " + region1);

		if (region1.equals(SPI_Surplus_Graph)) {
			System.out
					.println("Matched || Expected Graph was : " + SPI_Surplus_Graph + " Actual Graph was : " + region1);
			Extent_pass(driver,
					"Matched || Expected Graph was : " + SPI_Surplus_Graph + " Actual Graph was : " + region1, test,
					test1);
		} else {
			System.out.println(
					"Not Matched || Expected Graph was : " + SPI_Surplus_Graph + " || Actual Graph was : " + region1);
			Extent_fail2(driver,
					"Not Matched || Expected Graph was : " + SPI_Surplus_Graph + " || Actual Graph was : " + region1,
					test);
		}

		Extent_cal(test, "Ensure the By Region wise tab surplus chart PNG Graph");

		scrollBottom(driver);

		wait(driver, "2");
		mouseOverToElement(driver, PNG_PieChart);

		wait(driver, "5");

		String Count4 = getText(driver, Count);

		System.out.println("Count4 : " + Count4);

		String region2 = Count4.substring(0, 3);

		System.out.println("region2 : " + region2);

		if (region2.equals(PNG_Surplus_Graph)) {
			System.out
					.println("Matched || Expected Graph was : " + PNG_Surplus_Graph + " Actual Graph was : " + region2);
			Extent_pass(driver,
					"Matched || Expected Graph was : " + PNG_Surplus_Graph + " Actual Graph was : " + region2, test,
					test1);
		} else {
			System.out.println(
					"Not Matched || Expected Graph was : " + PNG_Surplus_Graph + " || Actual Graph was : " + region2);
			Extent_fail2(driver,
					"Not Matched || Expected Graph was : " + PNG_Surplus_Graph + " || Actual Graph was : " + region2,
					test);

		}

		System.out.println(
				"//***************************Testcase 299 Completed **************************************//");

		Extent_cal(test,
				"Testcase-300 Ensure the By Region wise tab surplus chart ASR wise indicates the gray color for one equipment type ");

		String actualscreencolor = getAttribute(driver, PNG_PieChart_Color, "fill");

		if (actualscreencolor.equals(Expected_screencolor_PNG_Graph)) {

			System.out.println("Screen Background color Matched || Expected screen color was : "
					+ Expected_screencolor_PNG_Graph + " || Actual screen color was " + actualscreencolor);
			Extent_pass(
					driver, "Screen Background color Matched || Expected screen color was : "
							+ Expected_screencolor_PNG_Graph + " || Actual screen color was " + actualscreencolor,
					test, test1);

		} else {
			System.out.println("Screen Background color Not Matched || Expected screen color was : "
					+ Expected_screencolor_PNG_Graph + " || Actual screen color was " + actualscreencolor);
			Extent_fail(driver,
					"Screen Background color Not Matched || Expected screen color was : "
							+ Expected_screencolor_PNG_Graph + " || Actual screen color was " + actualscreencolor,
					test, test1);
		}

		System.out.println(
				"//***************************Testcase 300 Completed **************************************//");

		Extent_cal(test,
				"Testcase-301 Ensure the By Region wise tab surplus chart EUR wise indicates the brown color (SPI) ");

		String actualscreencolor_SPI = getAttribute(driver, SPI_PieChart_Color, "fill");

		if (actualscreencolor_SPI.equals(Expected_screencolor_SPI_Graph)) {

			System.out.println("Screen Background color Matched || Expected screen color was : "
					+ Expected_screencolor_SPI_Graph + " || Actual screen color was " + actualscreencolor_SPI);
			Extent_pass(
					driver, "Screen Background color Matched || Expected screen color was : "
							+ Expected_screencolor_SPI_Graph + " || Actual screen color was " + actualscreencolor_SPI,
					test, test1);

		} else {
			System.out.println("Screen Background color Not Matched || Expected screen color was : "
					+ Expected_screencolor_SPI_Graph + " || Actual screen color was " + actualscreencolor_SPI);
			Extent_fail(driver,
					"Screen Background color Not Matched || Expected screen color was : "
							+ Expected_screencolor_SPI_Graph + " || Actual screen color was " + actualscreencolor_SPI,
					test, test1);
		}

		System.out.println(
				"//***************************Testcase 301 Completed **************************************//");

		Extent_cal(test,
				"Testcase-302 Ensure the By Region wise tab surplus chart MER wise indicates the orange color  (ANZ) ");

		String actualscreencolor_ANZ = getAttribute(driver, ANZ_PieChart_Color, "fill");

		if (actualscreencolor_ANZ.equals(Expected_screencolor_ANZ_Graph)) {

			System.out.println("Screen Background color Matched || Expected screen color was : "
					+ Expected_screencolor_ANZ_Graph + " || Actual screen color was " + actualscreencolor_ANZ);
			Extent_pass(
					driver, "Screen Background color Matched || Expected screen color was : "
							+ Expected_screencolor_ANZ_Graph + " || Actual screen color was " + actualscreencolor_ANZ,
					test, test1);

		} else {
			System.out.println("Screen Background color Not Matched || Expected screen color was : "
					+ Expected_screencolor_ANZ_Graph + " || Actual screen color was " + actualscreencolor_ANZ);
			Extent_fail(driver,
					"Screen Background color Not Matched || Expected screen color was : "
							+ Expected_screencolor_ANZ_Graph + " || Actual screen color was " + actualscreencolor_ANZ,
					test, test1);
		}

		System.out.println(
				"//***************************Testcase 302 Completed **************************************//");

		Extent_cal(test,
				"Testcase-303 Ensure the By Region wise tab surplus chart NAM wise indicates the blue color for one equipment type ");

		click(driver, ANZ_PieChart_Color_Picker);
		click(driver, SPI_PieChart_Color_Picker);
		click(driver, PNG_PieChart_Color_Picker);

		String actualscreencolor_SEA = getAttribute(driver, SEA_PieChart_Color, "fill");

		if (actualscreencolor_SEA.equals(Expected_screencolor_SEA_Graph)) {

			System.out.println("Screen Background color Matched || Expected screen color was : "
					+ Expected_screencolor_SEA_Graph + " || Actual screen color was " + actualscreencolor_SEA);
			Extent_pass(
					driver, "Screen Background color Matched || Expected screen color was : "
							+ Expected_screencolor_SEA_Graph + " || Actual screen color was " + actualscreencolor_SEA,
					test, test1);

		} else {
			System.out.println("Screen Background color Not Matched || Expected screen color was : "
					+ Expected_screencolor_SEA_Graph + " || Actual screen color was " + actualscreencolor_SEA);
			Extent_fail(driver,
					"Screen Background color Not Matched || Expected screen color was : "
							+ Expected_screencolor_SEA_Graph + " || Actual screen color was " + actualscreencolor_SEA,
					test, test1);
		}

		click(driver, ANZ_PieChart_Color_Picker);
		click(driver, SPI_PieChart_Color_Picker);
		click(driver, PNG_PieChart_Color_Picker);

		System.out.println(
				"//***************************Testcase 303 Completed **************************************//");

		Extent_cal(test,
				"Testcase 309 Ensure the By Region wise tab, when click the Gray color filter  ASR Region for surplus and deficit chart ");

		click(driver, PNG_PieChart_Color_Picker);

		Extent_cal(test, "SPI Graph Surplus");

		wait(driver, "5");

		mouseOverToElement(driver, SPI_Graph);

		String Graph_1 = getText(driver, Count);

		System.out.println("Graph_1 : " + Graph_1);

		String region3 = Graph_1.substring(0, 3);

		System.out.println("region3 : " + region3);

		if (region3.equals(SPI_Surplus_Graph)) {
			System.out
					.println("Matched || Expected Graph was : " + SPI_Surplus_Graph + " Actual Graph was : " + region3);
			Extent_pass(driver,
					"Matched || Expected Graph was : " + SPI_Surplus_Graph + " Actual Graph was : " + region3, test,
					test1);
		} else {
			System.out.println(
					"Not Matched || Expected Graph was : " + SPI_Surplus_Graph + " || Actual Graph was : " + region3);
			Extent_fail2(driver,
					"Not Matched || Expected Graph was : " + SPI_Surplus_Graph + " || Actual Graph was : " + region3,
					test);

		}

		Extent_cal(test, "ANZ Graph Surplus");

		wait(driver, "5");

		mouseOverToElement(driver, ANZ_Graph);
		String Graph_2 = getText(driver, Count);

		System.out.println("Graph_2 : " + Graph_2);

		String region4 = Graph_2.substring(0, 3);

		System.out.println("region4 : " + region4);

		if (region4.equals(ANZ_Surplus_Graph)) {
			System.out
					.println("Matched || Expected Graph was : " + ANZ_Surplus_Graph + " Actual Graph was : " + region4);
			Extent_pass(driver,
					"Matched || Expected Graph was : " + ANZ_Surplus_Graph + " Actual Graph was : " + region4, test,
					test1);
		} else {
			System.out.println(
					"Not Matched || Expected Graph was : " + ANZ_Surplus_Graph + " || Actual Graph was : " + region4);
			Extent_fail2(driver,
					"Not Matched || Expected Graph was : " + ANZ_Surplus_Graph + " || Actual Graph was : " + region4,
					test);

		}

		click(driver, PNG_PieChart_Color_Picker);

		System.out.println(
				"//***************************Testcase 309 Completed **************************************//");

		Extent_cal(test,
				"Testcase 310 Ensure the By Region wise tab, when click the brown color filter  EUR Region for surplus and deficit chart (SPI)");

		click(driver, SPI_PieChart_Color_Picker);

		Extent_cal(test, "PNG Graph Surplus");

		wait(driver, "5");

		mouseOverToElement(driver, PNG_Graph);

		String Graph_3 = getText(driver, Count);

		System.out.println("Graph_3 : " + Graph_3);

		String region5 = Graph_3.substring(0, 3);

		System.out.println("region5 : " + region5);

		if (region5.equals(PNG_Surplus_Graph)) {
			System.out
					.println("Matched || Expected Graph was : " + PNG_Surplus_Graph + " Actual Graph was : " + region5);
			Extent_pass(driver,
					"Matched || Expected Graph was : " + PNG_Surplus_Graph + " Actual Graph was : " + region5, test,
					test1);
		} else {
			System.out.println(
					"Not Matched || Expected Graph was : " + PNG_Surplus_Graph + " || Actual Graph was : " + region5);
			Extent_fail2(driver,
					"Not Matched || Expected Graph was : " + PNG_Surplus_Graph + " || Actual Graph was : " + region5,
					test);

		}

		Extent_cal(test, "ANZ Graph Surplus");

		wait(driver, "5");

		mouseOverToElement(driver, ANZ_Graph1);
		String Graph_4 = getText(driver, Count);

		System.out.println("Graph_4 : " + Graph_4);

		String region6 = Graph_4.substring(0, 3);

		System.out.println("region6 : " + region6);

		if (region6.equals(ANZ_Surplus_Graph)) {
			System.out
					.println("Matched || Expected Graph was : " + ANZ_Surplus_Graph + " Actual Graph was : " + region6);
			Extent_pass(driver,
					"Matched || Expected Graph was : " + ANZ_Surplus_Graph + " Actual Graph was : " + region6, test,
					test1);
		} else {
			System.out.println(
					"Not Matched || Expected Graph was : " + ANZ_Surplus_Graph + " || Actual Graph was : " + region6);
			Extent_fail2(driver,
					"Not Matched || Expected Graph was : " + ANZ_Surplus_Graph + " || Actual Graph was : " + region6,
					test);

		}

		click(driver, SPI_PieChart_Color_Picker);

		System.out.println(
				"//***************************Testcase 310 Completed **************************************//");

		Extent_cal(test,
				"Testcase 311 Ensure the By Region wise tab, when click the Orange color filter  MER Region for surplus and deficit chart (ANZ)");

		click(driver, ANZ_PieChart_Color_Picker);

		Extent_cal(test, "PNG Graph Surplus");

		wait(driver, "5");

		mouseOverToElement(driver, PNG_Graph);

		String Graph_5 = getText(driver, Count);

		System.out.println("Graph_5 : " + Graph_5);

		String region7 = Graph_5.substring(0, 3);

		System.out.println("region7 : " + region7);

		if (region7.equals(PNG_Surplus_Graph)) {
			System.out
					.println("Matched || Expected Graph was : " + PNG_Surplus_Graph + " Actual Graph was : " + region7);
			Extent_pass(driver,
					"Matched || Expected Graph was : " + PNG_Surplus_Graph + " Actual Graph was : " + region7, test,
					test1);
		} else {
			System.out.println(
					"Not Matched || Expected Graph was : " + PNG_Surplus_Graph + " || Actual Graph was : " + region7);
			Extent_fail2(driver,
					"Not Matched || Expected Graph was : " + PNG_Surplus_Graph + " || Actual Graph was : " + region7,
					test);

		}

		Extent_cal(test, "SPI Graph Surplus");

		wait(driver, "5");

		mouseOverToElement(driver, SPI_Graph);
		String Graph_6 = getText(driver, Count);

		System.out.println("Graph_6 : " + Graph_6);

		String region8 = Graph_6.substring(0, 3);

		System.out.println("region8 : " + region8);

		if (region8.equals(SPI_Surplus_Graph)) {
			System.out
					.println("Matched || Expected Graph was : " + SPI_Surplus_Graph + " Actual Graph was : " + region8);
			Extent_pass(driver,
					"Matched || Expected Graph was : " + SPI_Surplus_Graph + " Actual Graph was : " + region8, test,
					test1);
		} else {
			System.out.println(
					"Not Matched || Expected Graph was : " + SPI_Surplus_Graph + " || Actual Graph was : " + region8);
			Extent_fail2(driver,
					"Not Matched || Expected Graph was : " + SPI_Surplus_Graph + " || Actual Graph was : " + region8,
					test);

		}

		click(driver, ANZ_PieChart_Color_Picker);

		System.out.println(
				"//***************************Testcase 311 Completed **************************************//");

		Extent_cal(test,
				"Testcase 312 Ensure the By Region wise tab, when click the blue color filter  NAM Region for surplus and deficit chart (SEA)");

		click(driver, SEA_PieChart_Color_Picker);

		Extent_cal(test, "PNG Graph Surplus");

		wait(driver, "5");

		mouseOverToElement(driver, PNG_Graph);

		String Graph_7 = getText(driver, Count);

		System.out.println("Graph_7 : " + Graph_7);

		String region9 = Graph_7.substring(0, 3);

		System.out.println("region9 : " + region9);

		if (region9.equals(PNG_Surplus_Graph)) {
			System.out
					.println("Matched || Expected Graph was : " + PNG_Surplus_Graph + " Actual Graph was : " + region9);
			Extent_pass(driver,
					"Matched || Expected Graph was : " + PNG_Surplus_Graph + " Actual Graph was : " + region9, test,
					test1);
		} else {
			System.out.println(
					"Not Matched || Expected Graph was : " + PNG_Surplus_Graph + " || Actual Graph was : " + region9);
			Extent_fail2(driver,
					"Not Matched || Expected Graph was : " + PNG_Surplus_Graph + " || Actual Graph was : " + region9,
					test);

		}

		Extent_cal(test, "SPI Graph Surplus");

		wait(driver, "5");

		mouseOverToElement(driver, SPI_Graph);
		String Graph_8 = getText(driver, Count);

		System.out.println("Graph_8 : " + Graph_8);

		String region10 = Graph_8.substring(0, 3);

		System.out.println("region10 : " + region10);

		if (region10.equals(SPI_Surplus_Graph)) {
			System.out.println(
					"Matched || Expected Graph was : " + SPI_Surplus_Graph + " Actual Graph was : " + region10);
			Extent_pass(driver,
					"Matched || Expected Graph was : " + SPI_Surplus_Graph + " Actual Graph was : " + region10, test,
					test1);
		} else {
			System.out.println(
					"Not Matched || Expected Graph was : " + SPI_Surplus_Graph + " || Actual Graph was : " + region10);
			Extent_fail2(driver,
					"Not Matched || Expected Graph was : " + SPI_Surplus_Graph + " || Actual Graph was : " + region10,
					test);

		}

		Extent_cal(test, "ANZ Graph Surplus");

		wait(driver, "5");

		mouseOverToElement(driver, ANZ_Graph2);
		String Graph_9 = getText(driver, Count);

		System.out.println("Graph_9 : " + Graph_9);

		String region11 = Graph_9.substring(0, 3);

		System.out.println("region11 : " + region11);

		if (region11.equals(ANZ_Surplus_Graph)) {
			System.out.println(
					"Matched || Expected Graph was : " + ANZ_Surplus_Graph + " Actual Graph was : " + region11);
			Extent_pass(driver,
					"Matched || Expected Graph was : " + ANZ_Surplus_Graph + " Actual Graph was : " + region11, test,
					test1);
		} else {
			System.out.println(
					"Not Matched || Expected Graph was : " + ANZ_Surplus_Graph + " || Actual Graph was : " + region11);
			Extent_fail2(driver,
					"Not Matched || Expected Graph was : " + ANZ_Surplus_Graph + " || Actual Graph was : " + region11,
					test);

		}

		click(driver, SEA_PieChart_Color_Picker);

		System.out.println(
				"//***************************Testcase 312 Completed **************************************//");

		Extent_cal(test,
				"Testcase 317 Ensure the By Region wise tab, region wise filter graphical view will displayed surplus chart for ASR Region x axis quantity,y axis ports (ANZ) ");

		Fluentwait(driver, Region_Dropdown);
		click(driver, Region_Dropdown);

		selectByText(driver, Region_Dropdown, "ANZ");

		scrollBottom(driver);

		Scrolltilltheelementvisible(driver, PNG_Region);

		// click(driver, Fetch_Graph_ANZ);

		mouseOverToElement(driver, Fetch_Graph1);
		
		wait(driver,"3");

		String Count_Graph_Surplus = getText(driver, Fetch_Graph);

		System.out.println("Count_Graph_Surplus : " + Count_Graph_Surplus);

		String[] splivalue4 = Count_Graph_Surplus.split("\\: ");

		String[] expect_value4 = splivalue4[1].split("\\]");

		String Surplus_count4 = expect_value4[0];

		System.out.println("Surplus_count4 : " + Surplus_count4);

		wait(driver, "3");

		scrollBottom(driver);

		Scrolltilltheelementvisible(driver, By_Region);
		wait(driver, "3");

		driver.switchTo().defaultContent();

		scrollBottom(driver);

		scrollUp(driver);

		wait(driver, "5");

		Fluentwait(driver, Emp_Repo);
		click(driver, Emp_Repo);

		wait(driver, "2");

		String Count5 = getText(driver, Fetch_Graph1_ANZ);

		System.out.println("Count5 : " + Count5);

		if (Surplus_count4.equals(Count5)) {
			System.out.println("Matched || Expected Count was : " + Count5 + " Actual Count was : " + Surplus_count4);
			Extent_pass(driver,
					"Matched || Expected Count  was : " + Count5 + " || Actual Count  was : " + Surplus_count4, test,
					test1);
		} else {
			System.out
					.println("Not Matched || Expected Count was : " + Count5 + " Actual Count was : " + Surplus_count4);
			Extent_fail2(driver,
					"Not Matched || Expected Count was : " + Count5 + " || Actual Count was : " + Surplus_count4, test);

		}

		System.out.println(
				"//***************************Testcase 317 Completed **************************************//");

		Extent_cal(test,
				"Testcase 318 Ensure the By Region wise tab, region wise filter graphical view will displayed surplus chart for EUR Region x axis quantity,y axis ports (MES) ");

		wait(driver, "3");

		Fluentwait(driver, ERO_Chat);
		click(driver, ERO_Chat);

		wait(driver, "5");

		WebElement chart4 = driver.findElement(By.xpath("//object"));
		driver.switchTo().frame(chart4);
		wait(driver, "3");

		Fluentwait(driver, By_Region);
		click(driver, By_Region);

		Fluentwait(driver, Region_Dropdown);
		click(driver, Region_Dropdown);

		selectByText(driver, Region_Dropdown, "MES");

		scrollBottom(driver);

		// scrolltill(driver);

		Scrolltilltheelementvisible(driver, PNG_Region);

		// click(driver, Fetch_Graph_ANZ);

		mouseOverToElement(driver, Fetch_Graph1);

		String Count_Graph_Surplus1 = getText(driver, Fetch_Graph);

		System.out.println("Count_Graph_Surplus1 : " + Count_Graph_Surplus1);

		String[] splivalue5 = Count_Graph_Surplus1.split("\\: ");

		String[] expect_value5 = splivalue5[1].split("\\]");

		String Surplus_count5 = expect_value5[0];

		System.out.println("Surplus_count5 : " + Surplus_count5);

		wait(driver, "3");

		scrollBottom(driver);

		Scrolltilltheelementvisible(driver, By_Region);
		wait(driver, "3");

		// scrollUp(driver);
		// driver.switchTo().defaultContent();

		// VerticalScrollFull(driver, By_Region);

		// VerticalScrollFull(driver, ERO_Chat);

		driver.switchTo().defaultContent();

		scrollBottom(driver);

		scrollUp(driver);

		wait(driver, "5");

		Fluentwait(driver, Emp_Repo);
		click(driver, Emp_Repo);

		wait(driver, "2");

		String Count6 = getText(driver, Fetch_Graph1_ANZ);

		System.out.println("Count6 : " + Count6);

		if (Surplus_count5.equals(Count6)) {
			System.out.println("Matched || Expected Count was : " + Count6 + " Actual Count was : " + Surplus_count5);
			Extent_pass(driver,
					"Matched || Expected Count  was : " + Count6 + " || Actual Count  was : " + Surplus_count5, test,
					test1);
		} else {
			System.out
					.println("Not Matched || Expected Count was : " + Count6 + " Actual Count was : " + Surplus_count5);
			Extent_fail2(driver,
					"Not Matched || Expected Count was : " + Count6 + " || Actual Count was : " + Surplus_count5, test);

		}

		System.out.println(
				"//***************************Testcase 318 Completed **************************************//");

		Extent_cal(test,
				"Testcase 319 Ensure the By Region wise tab, region wise filter graphical view will displayed surplus chart for MER Region x axis quantity,y axis ports (NEA) ");

		wait(driver, "3");

		Fluentwait(driver, ERO_Chat);
		click(driver, ERO_Chat);

		wait(driver, "5");

		WebElement chart5 = driver.findElement(By.xpath("//object"));
		driver.switchTo().frame(chart5);
		wait(driver, "3");

		Fluentwait(driver, By_Region);
		click(driver, By_Region);

		Fluentwait(driver, Region_Dropdown);
		click(driver, Region_Dropdown);

		selectByText(driver, Region_Dropdown, "NEA");

		scrollBottom(driver);

		// scrolltill(driver);

		Scrolltilltheelementvisible(driver, PNG_Region);

		// click(driver, Fetch_Graph_ANZ);

		mouseOverToElement(driver, Fetch_Graph1);

		String Count_Graph_Surplus2 = getText(driver, Fetch_Graph);

		System.out.println("Count_Graph_Surplus1 : " + Count_Graph_Surplus2);

		String[] splivalue6 = Count_Graph_Surplus2.split("\\: ");

		String[] expect_value6 = splivalue6[1].split("\\]");

		String Surplus_count6 = expect_value6[0];

		System.out.println("Surplus_count6 : " + Surplus_count6);

		wait(driver, "3");

		scrollBottom(driver);

		Scrolltilltheelementvisible(driver, By_Region);
		wait(driver, "3");

		// scrollUp(driver);
		// driver.switchTo().defaultContent();

		// VerticalScrollFull(driver, By_Region);

		// VerticalScrollFull(driver, ERO_Chat);

		driver.switchTo().defaultContent();

		scrollBottom(driver);

		scrollUp(driver);

		wait(driver, "5");

		Fluentwait(driver, Emp_Repo);
		click(driver, Emp_Repo);

		wait(driver, "2");

		String Count7 = getText(driver, Fetch_Graph1_ANZ);

		System.out.println("Count7 : " + Count7);

		if (Surplus_count6.equals(Count7)) {
			System.out.println("Matched || Expected Count was : " + Count7 + " Actual Count was : " + Surplus_count6);
			Extent_pass(driver,
					"Matched || Expected Count  was : " + Count7 + " || Actual Count  was : " + Surplus_count6, test,
					test1);
		} else {
			System.out
					.println("Not Matched || Expected Count was : " + Count7 + " Actual Count was : " + Surplus_count6);
			Extent_fail2(driver,
					"Not Matched || Expected Count was : " + Count7 + " || Actual Count was : " + Surplus_count6, test);

		}

		System.out.println(
				"//***************************Testcase 319 Completed **************************************//");

		Extent_cal(test,
				"Testcase 320 Ensure the By Region wise tab, region wise filter graphical view will displayed surplus chart for NAM Region x axis quantity,y axis ports (PNG) ");

		wait(driver, "3");

		Fluentwait(driver, ERO_Chat);
		click(driver, ERO_Chat);

		wait(driver, "5");

		WebElement chart6 = driver.findElement(By.xpath("//object"));
		driver.switchTo().frame(chart6);
		wait(driver, "3");

		Fluentwait(driver, By_Region);
		click(driver, By_Region);

		Fluentwait(driver, Region_Dropdown);
		click(driver, Region_Dropdown);

		selectByText(driver, Region_Dropdown, "PNG");

		wait(driver, "3");

		scrollBottom(driver);

		// scrolltill(driver);

		Scrolltilltheelementvisible(driver, PNG_Region);

		// click(driver, Fetch_Graph_ANZ);
		wait(driver, "3");

		mouseOverToElement(driver, Fetch_Graph1);

		String Count_Graph_Surplus3 = getText(driver, Fetch_Graph);

		System.out.println("Count_Graph_Surplus3 : " + Count_Graph_Surplus3);

		String[] splivalue7 = Count_Graph_Surplus3.split("\\: ");

		String[] expect_value7 = splivalue7[1].split("\\]");

		String Surplus_count7 = expect_value7[0];

		System.out.println("Surplus_count7 : " + Surplus_count7);

		wait(driver, "3");

		scrollBottom(driver);

		Scrolltilltheelementvisible(driver, By_Region);
		wait(driver, "3");

		// scrollUp(driver);
		// driver.switchTo().defaultContent();

		// VerticalScrollFull(driver, By_Region);

		// VerticalScrollFull(driver, ERO_Chat);

		driver.switchTo().defaultContent();

		scrollBottom(driver);

		scrollUp(driver);

		wait(driver, "5");

		Fluentwait(driver, Emp_Repo);
		click(driver, Emp_Repo);

		wait(driver, "2");

		String Count8 = getText(driver, Fetch_Graph1_PNG);

		System.out.println("Count8 : " + Count8);

		if (Surplus_count7.equals(Count8)) {
			System.out.println("Matched || Expected Count was : " + Count8 + " Actual Count was : " + Surplus_count7);
			Extent_pass(driver,
					"Matched || Expected Count  was : " + Count8 + " || Actual Count  was : " + Surplus_count7, test,
					test1);
		} else {
			System.out
					.println("Not Matched || Expected Count was : " + Count8 + " Actual Count was : " + Surplus_count7);
			Extent_fail2(driver,
					"Not Matched || Expected Count was : " + Count8 + " || Actual Count was : " + Surplus_count7, test);

		}

		System.out.println(
				"//***************************Testcase 320 Completed **************************************//");

		Extent_cal(test, "Testcase 327 Ensure the Network chart tab to select origin wise “All” ");

		wait(driver, "3");

		Fluentwait(driver, ERO_Chat);
		click(driver, ERO_Chat);

		wait(driver, "5");

		WebElement chart7 = driver.findElement(By.xpath("//object"));
		driver.switchTo().frame(chart7);
		wait(driver, "3");

		Fluentwait(driver, Network_Chart);
		click(driver, Network_Chart);

		wait(driver, "3");

		String Orgin_Wise = getText(driver, Network_Orgin_Wise);

		System.out.println("Orgin_Wise : " + Orgin_Wise);

		if (Orgin_Wise.equals(Network_Chart_Filter)) {
			System.out.println("Matched || Expected Default Filter was : " + Network_Chart_Filter
					+ " Actual Warning Default Filter  was : " + Orgin_Wise);
			Extent_pass(driver, "Matched || Expected Default Filter was : " + Network_Chart_Filter
					+ " Actual Default Filter was : " + Orgin_Wise, test, test1);
		} else {
			System.out.println("Not Matched || Expected Default Filter was : " + Network_Chart_Filter
					+ " || Actual Default Filter was : " + Orgin_Wise);
			Extent_fail2(driver, "Not Matched || Expected Default Filter was : " + Network_Chart_Filter
					+ " || Actual Default Filter was : " + Orgin_Wise, test);

		}

		System.out.println(
				"//***************************Testcase 327 Completed **************************************//");

		Extent_cal(test, "Testcase 328 Ensure the Network chart tab to select origin wise “PGLAE” ");

		wait(driver, "3");

		click(driver, Network_Orgin_Wise_Dropdown);

		selectByText(driver, Network_Orgin_Wise_Dropdown, "PGLAE");

		String Orgin_Wise1 = defaultSelectedValue(driver, Network_Orgin_Wise_Dropdown);

		System.out.println("Orgin_Wise1 : " + Orgin_Wise1);

		if (Orgin_Wise1.equals(Network_Chart_Filter1)) {
			System.out.println("Matched || Expected Default Filter was : " + Network_Chart_Filter1
					+ " Actual Warning Default Filter  was : " + Orgin_Wise1);
			Extent_pass(driver, "Matched || Expected Default Filter was : " + Network_Chart_Filter1
					+ " Actual Default Filter was : " + Orgin_Wise1, test, test1);
		} else {
			System.out.println("Not Matched || Expected Default Filter was : " + Network_Chart_Filter1
					+ " || Actual Default Filter was : " + Orgin_Wise1);
			Extent_fail2(driver, "Not Matched || Expected Default Filter was : " + Network_Chart_Filter1
					+ " || Actual Default Filter was : " + Orgin_Wise1, test);

		}

		System.out.println(
				"//***************************Testcase 328 Completed **************************************//");

		//////////////////

		Extent_cal(test,
				"Testcase 289 Ensure the By volume tab chart wise representation x axis quantity details and y axis surplus details displayed with “>” button functionality ");

		Fluentwait(driver, By_Volume);
		click(driver, By_Volume);

		Scrolltilltheelementvisible(driver, Vol_Surplus_Backward);

		Fluentwait(driver, Vol_Surplus_Backward);

		if (isDisplayed(driver, Vol_Surplus_Backward)) {
			System.out.println("***Backward Button is Displayed***");
			Extent_pass(driver, "Backward Button is Displayed", test, test1);
		} else {
			Extent_fail(driver, "Backward Button is Not  Displayed", test, test1);
		}

		System.out.println(
				"//***************************Testcase 289 Completed **************************************//");

		Extent_cal(test,
				"Testcase 290 Ensure the By volume tab chart wise representation x axis quantity details and y axis surplus details displayed with “>” button functionality ");

		Fluentwait(driver, Vol_Surplus_Forward);

		if (isDisplayed(driver, Vol_Surplus_Forward)) {
			System.out.println("***Forward Button is Displayed***");

			Extent_pass(driver, "Forward Button is Displayed", test, test1);
		} else {
			Extent_fail(driver, "Forward Button is Not  Displayed", test, test1);
		}

		System.out.println(
				"//***************************Testcase 290 Completed **************************************//");

		Extent_cal(test,
				"Testcase 291 Ensure the By volume tab chart wise representation x axis quantity details and y axis deficit details displayed with “>” button functionality  ");

		Fluentwait(driver, Vol_Deficit_Backward);

		if (isDisplayed(driver, Vol_Deficit_Backward)) {
			System.out.println("***Backward Button is Displayed***");

			Extent_pass(driver, "Backward Button is Displayed", test, test1);
		} else {
			Extent_fail(driver, "Backward Button is Not  Displayed", test, test1);
		}

		System.out.println(
				"//***************************Testcase 291 Completed **************************************//");

		Extent_cal(test,
				"Testcase 292 Ensure the By volume tab chart wise representation x axis quantity details and y axis deficit details displayed with “<” button functionality for one equipment type ");

		Fluentwait(driver, Vol_Deficit_Forward);

		if (isDisplayed(driver, Vol_Deficit_Forward)) {
			System.out.println("***Forward Button is Displayed***");

			Extent_pass(driver, "Forward Button is Displayed", test, test1);
		} else {
			Extent_fail(driver, "Forward Button is Not  Displayed", test, test1);
		}

		System.out.println(
				"//***************************Testcase 292 Completed **************************************//");

	}
}
