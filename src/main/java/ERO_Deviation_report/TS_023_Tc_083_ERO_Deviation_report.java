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

public class TS_023_Tc_083_ERO_Deviation_report extends Keywords{
	public void Scenario023(WebDriver driver, ExtentTest test,ExtentTest test1,String url, int dataset) throws AWTException, IOException, InterruptedException {	
	
	System.out.println("url : "+url);
	
	String Username = Utils.getDataFromTestData("TS_023_Tc_083_ERO_Dataset"+dataset, "ERO_Deviation_report", "Username");
	String Password = Utils.getDataFromTestData("TS_023_Tc_083_ERO_Dataset"+dataset, "ERO_Deviation_report", "Password");
	String ID = Utils.getDataFromTestData("TS_023_Tc_083_ERO_Dataset"+dataset, "ERO_Deviation_report", "Id");
	String ID2 = Utils.getDataFromTestData("TS_023_Tc_083_ERO_Dataset"+dataset, "ERO_Deviation_report", "ID_2");




	
	
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
		
		
		
		Extent_cal(test, "Testcase 82 - Ensure system is allowing to display the Total count foe both the Version No and ID's");
		
		
		Extent_cal(test, " Ensure system is allowing to display the Total count for ID");

		
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

		Fluentwait(driver, Select_ID_1);
		doubleClick(driver, Select_ID_1);
		
		wait(driver,"5");
		
		
		Fluentwait(driver, Search4);
		click(driver, Search4);
		wait(driver,"3");

		
		Fluentwait(driver, Select_ID_1);
		doubleClick(driver, Select_ID_1);
		
		wait(driver,"5");
		
		
		int Total_Quantity = 0;
		List<WebElement> Quantity1 = driver.findElements(By.xpath("//tbody[@id='ERD-ERD_Version1DGrid_data']//tr//td[3]"));
		for (WebElement Quantity :Quantity1) {
			String Qty = Quantity.getText();
			Total_Quantity=Total_Quantity+Integer.parseInt(Qty);
		}	
		
		int Total_Quantity1 = 0;
		List<WebElement> Quantity2 = driver.findElements(By.xpath("//tbody[@id='ERD-ERD_Version2DGrid_data']//tr//td[3]"));
		for (WebElement Quantity_1 :Quantity2) {
			String Qty1 = Quantity_1.getText();
			Total_Quantity1=Total_Quantity1+Integer.parseInt(Qty1);
		}		
		
		
		
		String Quantity1_Grid = Integer.toString(Total_Quantity);
		
		String Quantity2Grid = Integer.toString(Total_Quantity1);
		
		
Scrolltilltheelementvisible(driver, Total_QTY_1);
		
		if (!Quantity1_Grid.equals(Quantity2Grid)) {
			System.out.println("Matched || Expected Both Value was not  matched : " + Quantity2Grid
					+ " || Actual Both Value was not : " + Quantity1_Grid);
			Extent_pass(driver, "Matched || Expected Both Value was not matched : "
					+ Quantity2Grid + " || Actual Both Value was not was not matched : " + Quantity1_Grid,
					test,test1);
		} else {
			System.out.println(
					"Not Matched || Expected Both Value was matched : " + Quantity2Grid
							+ "|| Actual Both Value was matched : " + Quantity1_Grid);
			Extent_fail2(driver, "Not Matched || Expected Both Value was matched : "
					+ Quantity2Grid + " || Actual Both Value was matched : " + Quantity1_Grid,
					test);

		}

		
		Extent_cal(test, " Ensure system is allowing to display the Total count for Version No");
		
		
		scrollUp(driver);
		
click(driver, Cancel_Report);
		
		Fluentwait(driver, New_Report);
		click(driver, New_Report);
		
		
		Fluentwait(driver, Create_New_Confirm1);
		click(driver, Create_New_Confirm1);
		
		wait(driver,"5");
		
		
		Fluentwait(driver, Search1);
		click(driver, Search1);

		Fluentwait(driver, Globalserach_IDInput);
		sendKeys(driver, Globalserach_IDInput, ID);

		wait(driver, "2");

		Fluentwait(driver, Click_Search);
		click(driver, Click_Search);

		wait(driver, "3");

		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);

		wait(driver, "5");

		Fluentwait(driver, Search2);
		click(driver, Search2);

		wait(driver, "3");

		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);

		wait(driver, "5");

		Fluentwait(driver, Search3);
		click(driver, Search3);

		wait(driver, "3");

		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);

		wait(driver, "5");

		Fluentwait(driver, Search4);
		click(driver, Search4);
		wait(driver, "3");

		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);

		wait(driver, "5");
		
		int Total_Quantity1_1 = 0;
		List<WebElement> Quantity_Version1 = driver.findElements(By.xpath("//tbody[@id='ERD-ERD_Version1DGrid_data']//tr//td[3]"));
		for (WebElement Quantity_Version :Quantity_Version1) {
			String Qty_1 = Quantity_Version.getText();
			Total_Quantity1_1=Total_Quantity1_1+Integer.parseInt(Qty_1);
		}	
		
		int Total_Quantity2 = 0;
		List<WebElement> Quantity_Version2 = driver.findElements(By.xpath("//tbody[@id='ERD-ERD_Version2DGrid_data']//tr//td[3]"));
		for (WebElement Quantity_2 :Quantity_Version2) {
			String Qty_2 = Quantity_2.getText();
			Total_Quantity2=Total_Quantity2+Integer.parseInt(Qty_2);
		}		
		
		
		
		String Quantity2_Grid = Integer.toString(Total_Quantity1_1);
		
		String Quantity3Grid = Integer.toString(Total_Quantity2);
		
		
Scrolltilltheelementvisible(driver, Total_QTY_1);
		
		if (!Quantity2_Grid.equals(Quantity3Grid)) {
			System.out.println("Matched || Expected Both Value was not  matched : " + Quantity3Grid
					+ " || Actual Both Value was not : " + Quantity2_Grid);
			Extent_pass(driver, "Matched || Expected Both Value was not matched : "
					+ Quantity3Grid + " || Actual Both Value was not was not matched : " + Quantity2_Grid,
					test,test1);
		} else {
			System.out.println(
					"Not Matched || Expected Both Value was matched : " + Quantity3Grid
							+ "|| Actual Both Value was matched : " + Quantity2_Grid);
			Extent_fail2(driver, "Not Matched || Expected Both Value was matched : "
					+ Quantity3Grid + " || Actual Both Value was matched : " + Quantity2_Grid,
					test);

		}
	
		
		
		

		

}
}