package ERO_Deviation_report;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.Utils;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class TS_024_Tc_084_ERO_Deviation_report extends Keywords{
	public void Scenario024(WebDriver driver, ExtentTest test,ExtentTest test1,String url, int dataset) throws AWTException, IOException, InterruptedException {	
	
	System.out.println("url : "+url);
	
	String Username = Utils.getDataFromTestData("TS_024_Tc_084_ERO_Dataset"+dataset, "ERO_Deviation_report", "Username");
	String Password = Utils.getDataFromTestData("TS_024_Tc_084_ERO_Dataset"+dataset, "ERO_Deviation_report", "Password");
	String ID = Utils.getDataFromTestData("TS_024_Tc_084_ERO_Dataset"+dataset, "ERO_Deviation_report", "Id");
	String ID2 = Utils.getDataFromTestData("TS_024_Tc_084_ERO_Dataset"+dataset, "ERO_Deviation_report", "ID_2");




	
	
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
		
		
		
		Extent_cal(test, "Testcase 82 - Ensure system is allowing to display the Total Quatity and Grand total for both the Version No and ID's");

		
click(driver, Cancel_Report);
		
		Fluentwait(driver, New_Report);
		click(driver, New_Report);
		
		
		Fluentwait(driver, Create_New_Confirm1);
		click(driver, Create_New_Confirm1);
		
		wait(driver,"5");
		
		
		Fluentwait(driver, ID_Deviation);
		click(driver, ID_Deviation);
		
		
		
		
		

		
		
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
		
		
		
		
		Fluentwait(driver, Search_Optim);
		click(driver, Search_Optim);
		
		
		Fluentwait(driver, Globalserach_IDInput);
		sendKeys(driver, Globalserach_IDInput, ID2);
		
		wait(driver,"2");
		
		Fluentwait(driver, Click_Search);
		click(driver, Click_Search);
		
		wait(driver,"3");
		
		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);
		
		wait(driver,"5");
		
		
		
		
		
		
		
		Fluentwait(driver, Search2);
		click(driver, Search2);
		
		wait(driver,"3");

		
		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);
		
		wait(driver,"5");
		
		Fluentwait(driver, Search3);
		click(driver, Search3);
		
		wait(driver,"3");

		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);
		
		wait(driver,"5");
		
		
		Fluentwait(driver, Search4);
		click(driver, Search4);
		wait(driver,"3");

		
		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);
		
		wait(driver,"5");
		
		Extent_cal(test, "Grid1");

		
		int Total_Quantity = 0;
		List<WebElement> Quantity1 = driver.findElements(By.xpath("//tbody[@id='ERD-ERD_Version1DGrid_data']//tr//td[3]"));
		for (WebElement Quantity :Quantity1) {
			String Qty = Quantity.getText();
			Total_Quantity=Total_Quantity+Integer.parseInt(Qty);
		}	

		String Quantity1_Grid = Integer.toString(Total_Quantity);
		Scrolltilltheelementvisible(driver, Total_QTY_1);

		
		String TotalQuantity_Data1 = getAttribute(driver,Total_QTY1, "value" );
		
	     System.out.println("TotalQuantity_Data : "+TotalQuantity_Data1);
	     String[] splivalue = TotalQuantity_Data1.split("\\.");
			
			
			String TotalQuantity_Data = splivalue[0].trim();
			
			System.out.println("TotalQuantity_Data : "+TotalQuantity_Data);
		
		
		if (Quantity1_Grid.equals(TotalQuantity_Data)) {
			System.out.println("Matched || Expected Both Value was matched : " + TotalQuantity_Data
					+ " || Actual Both Value was matched : " + Quantity1_Grid);
			Extent_pass(driver, "Matched || Expected Both Value was matched : "
					+ TotalQuantity_Data + " || Actual Both Value was not was matched : " + Quantity1_Grid,
					test,test1);
		} else {
			System.out.println(
					"Not Matched || Expected Both Value was not matched : " + TotalQuantity_Data
							+ "|| Actual Both Value was not matched : " + Quantity1_Grid);
			Extent_fail2(driver, "Not Matched || Expected Both Value was not matched : "
					+ TotalQuantity_Data + " || Actual Both Value was not matched : " + Quantity1_Grid,
					test);

		}

		
		/////
		
wait(driver,"5");
		
		
scrollBottom(driver);

scrollUp(driver);

		int Grand_Total = 0;
		List<WebElement> Grand_Total1 = driver.findElements(By.xpath("//tbody[@id='ERD-ERD_Version1DGrid_data']//tr//td[5]"));
		for (WebElement Grand :Grand_Total1) {
			String TotalQty1 = Grand.getText();
			double addvalue=Double.parseDouble(TotalQty1);
			Grand_Total=(int) (Grand_Total+addvalue);
		}	

		String TotalQuantity_Grid1 = Integer.toString(Grand_Total);

		
		String Grand_Total1_Data = getAttribute(driver,Grand_Data_Total1, "value" );

		System.out.println("Grand_Total1_Data : "+Grand_Total1_Data);	
		String[] Total = Grand_Total1_Data.split("\\.");
		String total_Value = Total[0].replace(",", "");
		System.out.println("total_Value : "+total_Value);	

		
		if (total_Value.equals(TotalQuantity_Grid1)) {
			System.out.println("Matched || Expected Both Value was matched : " + total_Value
					+ " || Actual Both Value was mathed : " + TotalQuantity_Grid1);
			Extent_pass(driver, "Matched || Expected Both Value was matched : "
					+ total_Value + " || Actual Both Value was not was matched : " + TotalQuantity_Grid1,
					test,test1);
		} else {
			System.out.println(
					"Not Matched || Expected Both Value was not matched : " + total_Value
							+ "|| Actual Both Value was not matched : " + TotalQuantity_Grid1);
			Extent_fail2(driver, "Not Matched || Expected Both Value was not matched : "
					+ total_Value + " || Actual Both Value was not matched : " + TotalQuantity_Grid1,
					test);

		}

		
		Extent_cal(test, "Grid2");
		
		wait(driver,"5");

		int Total_Quantity1 = 0;
		List<WebElement> Quantity11 = driver.findElements(By.xpath("//tbody[@id='ERD-ERD_Version2DGrid_data']//tr//td[3]"));
		for (WebElement Quantity :Quantity11) {
			String Qty = Quantity.getText();
			Total_Quantity1=Total_Quantity1+Integer.parseInt(Qty);
		}	

		String Quantity1_Grid1 = Integer.toString(Total_Quantity1);
		Scrolltilltheelementvisible(driver, Total_QTY_2);

		
		String TotalQuantity_Data11 = getAttribute(driver,Total_QTY_2, "value" );
		
	     System.out.println("TotalQuantity_Data : "+TotalQuantity_Data11);
	     String[] splivalue1 = TotalQuantity_Data11.split("\\.");
			
			
			String TotalQuantity_Data2 = splivalue1[0].trim();
			
			System.out.println("TotalQuantity_Data : "+TotalQuantity_Data2);
		
		
		if (Quantity1_Grid1.equals(TotalQuantity_Data2)) {
			System.out.println("Matched || Expected Both Value was matched : " + TotalQuantity_Data2
					+ " || Actual Both Value was matched : " + Quantity1_Grid1);
			Extent_pass(driver, "Matched || Expected Both Value was matched : "
					+ TotalQuantity_Data2 + " || Actual Both Value was matched : " + Quantity1_Grid1,
					test,test1);
		} else {
			System.out.println(
					"Not Matched || Expected Both Value was not matched : " + TotalQuantity_Data2
							+ "|| Actual Both Value was not matched : " + Quantity1_Grid1);
			Extent_fail2(driver, "Not Matched || Expected Both Value was not matched : "
					+ TotalQuantity_Data2 + " || Actual Both Value was not matched : " + Quantity1_Grid1,
					test);

		}

		
		/////
		
wait(driver,"5");
		
		
scrollBottom(driver);

scrollUp(driver);

		int Grand_Total2 = 0;
		List<WebElement> Grand_Total11 = driver.findElements(By.xpath("//tbody[@id='ERD-ERD_Version2DGrid_data']//tr//td[5]"));
		for (WebElement Grand :Grand_Total11) {
			String TotalQty1 = Grand.getText();
			double addvalue=Double.parseDouble(TotalQty1);
			Grand_Total2=(int) (Grand_Total2+addvalue);
		}	

		String TotalQuantity_Grid11 = Integer.toString(Grand_Total2);

		
		String Grand_Total1_Data_Grid = getAttribute(driver,Grand_DataTotal2, "value" );

		System.out.println("Grand_Total1_Data_Grid : "+Grand_Total1_Data_Grid);	
		String[] Total1 = Grand_Total1_Data_Grid.split("\\.");
		String total_Value1 = Total1[0].replace(",", "");
		System.out.println("total_Value1 : "+total_Value1);	

		
		if (total_Value1.equals(TotalQuantity_Grid11)) {
			System.out.println("Matched || Expected Both Value matched : " + total_Value1
					+ " || Actual Both Value was not : " + TotalQuantity_Grid11);
			Extent_pass(driver, "Matched || Expected Both Value was matched : "
					+ total_Value1 + " || Actual Both Value was matched : " + TotalQuantity_Grid11,
					test,test1);
		} else {
			System.out.println(
					"Not Matched || Expected Both Value was not matched : " + total_Value1
							+ "|| Actual Both Value was not matched : " + TotalQuantity_Grid11);
			Extent_fail2(driver, "Not Matched || Expected Both Value was not matched : "
					+ total_Value1 + " || Actual Both Value was not matched : " + TotalQuantity_Grid11,
					test);

		}

		
	}
}
