package ERO_Deviation_report;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.Utils;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class TS_009_Tc_067toTc68_ERO_Deviation_report extends Keywords{
	public void Scenario009(WebDriver driver, ExtentTest test,ExtentTest test1,String url, int dataset) throws AWTException, IOException, InterruptedException {	
	
	System.out.println("url : "+url);
	
	String Username = Utils.getDataFromTestData("TS_009_Tc_067toTc68_ERO_Dataset"+dataset, "ERO_Deviation_report", "Username");
	String Password = Utils.getDataFromTestData("TS_009_Tc_067toTc68_ERO_Dataset"+dataset, "ERO_Deviation_report", "Password");
	String ID = Utils.getDataFromTestData("TS_009_Tc_067toTc68_ERO_Dataset"+dataset, "ERO_Deviation_report", "Id");
	String Filter_Value_Data = Utils.getDataFromTestData("TS_009_Tc_067toTc68_ERO_Dataset"+dataset, "ERO_Deviation_report", "Filter1value");
	String Filter_Value_Data1 = Utils.getDataFromTestData("TS_009_Tc_067toTc68_ERO_Dataset"+dataset, "ERO_Deviation_report", "Filter2value");
	String Filter_Value_Data2 = Utils.getDataFromTestData("TS_009_Tc_067toTc68_ERO_Dataset"+dataset, "ERO_Deviation_report", "Filter3value");
	String Filter_Value_Data3 = Utils.getDataFromTestData("TS_009_Tc_067toTc68_ERO_Dataset"+dataset, "ERO_Deviation_report", "Filter4value");
	String Filter_Data1 = Utils.getDataFromTestData("TS_009_Tc_067toTc68_ERO_Dataset"+dataset, "ERO_Deviation_report", "Filterdata1");
	String Filter_Data2 = Utils.getDataFromTestData("TS_009_Tc_067toTc68_ERO_Dataset"+dataset, "ERO_Deviation_report", "Filterdata2");
	String Filter_Data3 = Utils.getDataFromTestData("TS_009_Tc_067toTc68_ERO_Dataset"+dataset, "ERO_Deviation_report", "Filterdata3");
	String Filter_Data4 = Utils.getDataFromTestData("TS_009_Tc_067toTc68_ERO_Dataset"+dataset, "ERO_Deviation_report", "Filterdata4");



	WebDriverWait wait = new WebDriverWait(driver, 60);
	Actions act = new Actions(driver);
	
	 navigateUrl(driver, url);
		
		Fluentwait(driver, Username_input1);
		sendKeys(driver, Username_input1, Username);
		
		Fluentwait(driver, Password_input1);
		sendKeys(driver, Password_input1, Password);
		
		Fluentwait(driver, SignIn1);
		click(driver, SignIn1);
		
		wait(driver,"5");
		
		if(isDisplayed(driver, session_confirmation1)) {
			Fluentwait(driver, session_confirmation1);
			click(driver, session_confirmation1);
		}
		
		Fluentwait(driver, Searchbox1);
		sendKeys(driver, Searchbox1, "ERO Deviation report");
		
		Fluentwait(driver, Select_Deviation);
		click(driver, Select_Deviation);
		
		wait(driver,"3");
		
		
		Fluentwait(driver, Search1);
		click(driver, Search1);
		
		
		Fluentwait(driver, Globalserach_IDInput);
		sendKeys(driver, Globalserach_IDInput, ID);
		
		wait(driver,"2");
		
		Fluentwait(driver, Click_Search);
		click(driver, Click_Search);
		
		wait(driver,"3");
		
		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);
		
		wait(driver,"5");
		
		
		Fluentwait(driver, Search2);
		click(driver, Search2);
		
		wait(driver,"5");

		
		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);
		
		wait(driver,"5");
		
		Fluentwait(driver, Search3);
		click(driver, Search3);
		wait(driver,"5");

		
		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);
		
		wait(driver,"5");
		
		
		Fluentwait(driver, Search4);
		click(driver, Search4);
		wait(driver,"5");

		
		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);
		
		wait(driver,"5");
		
		
		
		
		
		
		Extent_cal(test, "Testcase 68 - Ensure DS grid allows Filter functionality");
		
		
		
		Extent_cal(test, "Filter1");


		
		Fluentwait(driver, Filter_1_Report);
		sendKeys(driver, Filter_1_Report, Filter_Data1);
		
		wait(driver,"3");

		String Filter1_Value = getText(driver,Grid_1_Report );

		System.out.println("Filter1_Value : "+Filter1_Value);	
		
		
		if (Filter1_Value.equals(Filter_Value_Data)) {
			System.out.println("Matched || Expected Filter Data was : " + Filter_Value_Data
					+ " Actual Filter Data was : " + Filter1_Value);
			Extent_pass(driver, "Matched || Expected Filter Data was : "
					+ Filter_Value_Data + " || Actual Filter Data was : " + Filter1_Value,
					test,test1);
		} else {
			System.out.println(
					"Not Matched || Expected Filter Data was : " + Filter_Value_Data
							+ " || Actual Filter Data was : " + Filter1_Value);
			Extent_fail2(driver, "Not Matched || Expected Filter Data was : "
					+ Filter_Value_Data + " || Actual Filter Data was : " + Filter1_Value,
					test);

		}
		
		wait(driver,"2");

		
		clear(driver, Filter_1_Report);
		
		
		wait(driver,"3");
		
		Extent_cal(test, "Filter2");


		Fluentwait(driver, Filter_2_Report);
		sendKeys(driver, Filter_2_Report, Filter_Data2);
		
		wait(driver,"3");

		String Filter2_Value = getText(driver,Grid_2_Report );

		System.out.println("Filter2_Value : "+Filter2_Value);	
		
		
		if (Filter2_Value.equals(Filter_Value_Data1)) {
			System.out.println("Matched || Expected Filter Data was : " + Filter_Value_Data1
					+ " || Actual Filter Data was : " + Filter2_Value);
			Extent_pass(driver, "Matched || Expected Filter Data was : "
					+ Filter_Value_Data1 + " || Actual Filter Data was : " + Filter2_Value,
					test,test1);
		} else {
			System.out.println(
					"Not Matched || Expected Filter Data was : " + Filter_Value_Data1
							+ " || Actual Filter Data was : " + Filter2_Value);
			Extent_fail2(driver, "Not Matched || Expected Version Number was : "
					+ Filter_Value_Data1 + " || Actual Version Number was : " + Filter2_Value,
					test);

		}
		
		wait(driver,"2");

		
		clear(driver, Filter_2_Report);
		
		
		wait(driver,"3");	
		
		
wait(driver,"3");
		
		Extent_cal(test, "Filter3");


		Fluentwait(driver, Filter_3_Report);
		sendKeys(driver, Filter_3_Report, Filter_Data3);
		
		wait(driver,"3");

		String Filter3_Value = getText(driver,Grid_3_Report );

		System.out.println("Filter3_Value : "+Filter3_Value);	
		
		
		if (Filter3_Value.equals(Filter_Value_Data2)) {
			System.out.println("Matched || Expected Filter Data was : " + Filter_Value_Data2
					+ " || Actual Version Number was : " + Filter3_Value);
			Extent_pass(driver, "Matched || Expected Filter Data was : "
					+ Filter_Value_Data2 + " || Actual Filter Data was : " + Filter3_Value,
					test,test1);
		} else {
			System.out.println(
					"Not Matched || Expected Filter Data was : " + Filter_Value_Data2
							+ " || Actual Filter Data was : " + Filter3_Value);
			Extent_fail2(driver, "Not Matched || Expected Filter Data was : "
					+ Filter_Value_Data2 + " || Actual Filter Data was : " + Filter3_Value,
					test);

		}
		
		wait(driver,"2");
clear(driver, Filter_3_Report);


		
wait(driver,"3");
		
		Extent_cal(test, "Filter4");


		Fluentwait(driver, Filter_4_Report);
		sendKeys(driver, Filter_4_Report, Filter_Data4);
		
		wait(driver,"3");

		String Filter4_Value = getText(driver,Grid_4_Report );

		System.out.println("Filter4_Value : "+Filter4_Value);	
		
		String[] splivalue = Filter4_Value.split("\\.");
		
		
		String Filter_count_1 = splivalue[0].trim();
		
		System.out.println("Filter_count_1 : "+Filter_count_1);
		
		
		if (Filter_count_1.equals(Filter_Value_Data3)) {
			System.out.println("Matched || Expected Filter Data was : " + Filter_Value_Data3
					+ " Actual Filter Data was : " + Filter_count_1);
			Extent_pass(driver, "Matched || Expected Filter Data was : "
					+ Filter_Value_Data3 + " || Actual Filter Data was : " + Filter_count_1,
					test,test1);
		} else {
			System.out.println(
					"Not Matched || Expected Filter Data was : " + Filter_Value_Data3
							+ " Actual Filter Data was : " + Filter_count_1);
			Extent_fail2(driver, "Not Matched || Expected Filter Data was : "
					+ Filter_Value_Data3 + " Actual Filter Data was : " + Filter_count_1,
					test);

		}
		
		wait(driver,"2");
		
		
		clear(driver, Filter_4_Report);
		
		
	}
}