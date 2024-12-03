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

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.Utils;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class TS_012_Tc_072_ERO_Deviation_report extends Keywords {
	public void Scenario012(WebDriver driver, ExtentTest test, ExtentTest test1, String url, int dataset)
			throws AWTException, IOException, InterruptedException {

		System.out.println("url : " + url);

		String Username = Utils.getDataFromTestData("TS_012_Tc_072_ERO_Dataset"+dataset, "ERO_Deviation_report", "Username");
		String Password = Utils.getDataFromTestData("TS_012_Tc_072_ERO_Dataset"+dataset, "ERO_Deviation_report", "Password");
		String ID = Utils.getDataFromTestData("TS_012_Tc_072_ERO_Dataset"+dataset, "ERO_Deviation_report", "Id");
		String ID2 = Utils.getDataFromTestData("TS_012_Tc_072_ERO_Dataset"+dataset, "ERO_Deviation_report", "ID_2");
		String EQ_Type = Utils.getDataFromTestData("TS_012_Tc_072_ERO_Dataset"+dataset, "ERO_Deviation_report", "EQU_Type");


		navigateUrl(driver, url);

		Fluentwait(driver, Username_input1);
		sendKeys(driver, Username_input1, Username);

		Fluentwait(driver, Password_input1);
		sendKeys(driver, Password_input1, Password);

		Fluentwait(driver, SignIn1);
		click(driver, SignIn1);

		wait(driver, "5");

		if (isDisplayed(driver, session_confirmation1)) {
			Fluentwait(driver, session_confirmation1);
			click(driver, session_confirmation1);
		}

		Fluentwait(driver, Searchbox1);
		sendKeys(driver, Searchbox1, "ERO Deviation report");

		Fluentwait(driver, Select_Deviation);
		click(driver, Select_Deviation);

		wait(driver, "3");
		
		
		
		Extent_cal(test, "Testcase 82 - Ensure in Equipment Deviation Report, System is allowing to Displaying the Total count .");

		
		click(driver, Cancel_Report);
				
				Fluentwait(driver, New_Report);
				click(driver, New_Report);
				
				
				Fluentwait(driver, Create_New_Confirm1);
				click(driver, Create_New_Confirm1);
				
				wait(driver,"5");
				
				
				Fluentwait(driver, ID_Deviation);
				click(driver, ID_Deviation);
				
				
				
				
				wait(driver,"5");

	
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

				
				click(driver, Filter_Search);
				sendKeys(driver, Filter_Search, EQ_Type);
				
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
				wait(driver,"5");

				
				Fluentwait(driver, Select_ID_2);
				doubleClick(driver, Select_ID_2);
				
				wait(driver,"5");
				
				
				
				String GridData1 = getText(driver,Grid_Data1 );

				System.out.println("GridData1 : "+GridData1);		
				
				
				Fluentwait(driver, Searchbox);
				sendKeys(driver, Searchbox, "Optimizer WHAT – IF Scenario");
				
				wait(driver,"3");


				Fluentwait(driver, SelectOptimizer);
				click(driver, SelectOptimizer);
				
				wait(driver,"5");
				Fluentwait(driver, Optimizer_Globalserach);
				click(driver, Optimizer_Globalserach);

				Fluentwait(driver, Globalserach_IDInput);
				sendKeys(driver, Globalserach_IDInput, ID);

				wait(driver, "2");

				Fluentwait(driver, Click_Search);
				click(driver, Click_Search);

				wait(driver, "5");

				Fluentwait(driver, SelectID);
				doubleClick(driver, SelectID);
				wait(driver, "5");
				
				
				click(driver, OPtimizer_option);
				
				wait(driver, "5");
				
				click(driver, Optimizer_Ok1);
				
				wait(driver, "3");


				
				Fluentwait(driver, Select_EQ);
				click(driver, Select_EQ);
				
				wait(driver, "5");

				
				String GridData2 = getText(driver,Data_Grid1 );

				System.out.println("GridData2 : "+GridData2);	
				
			
				 int startIndex = GridData2.indexOf("[");
				 int endIndex = GridData2.indexOf("]");
				 String act_Value = GridData2.substring(startIndex+1, endIndex);
				
//				String Filter_count_1 = splivalue[0].trim();
				
				System.out.println("act_Value : "+act_Value);
				
				
			
				
				
				
				if (GridData1.equals(act_Value)) {
					System.out.println("Matched || Expected Number was : " + act_Value
							+ " Actual Number was : " + GridData1);
					Extent_pass(driver, "Matched || Expected Number was : "
							+ act_Value + " Actual Number was : " + GridData1,
							test,test1);
				} else {
					System.out.println(
							"Not Matched || Expected Number was : " + act_Value
									+ " Actual Number was : " + GridData1);
					Extent_fail2(driver, "Not Matched || Expected  was : "
							+ act_Value + " Actual Number was : " + GridData1,
							test);

				}	
				
				
				
				
				
				
				
				
				
				
{

	
}
	}
}


