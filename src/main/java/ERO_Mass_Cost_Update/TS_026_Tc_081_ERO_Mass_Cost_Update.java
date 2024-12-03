package ERO_Mass_Cost_Update;

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
import com.fasterxml.jackson.databind.PropertyNamingStrategies.UpperCamelCaseStrategy;
import com.gargoylesoftware.htmlunit.html.xpath.LowerCaseFunction;

import commonMethods.Keywords;
import commonMethods.Utils;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class TS_026_Tc_081_ERO_Mass_Cost_Update extends Keywords{
	public void Scenario026(WebDriver driver, ExtentTest test,ExtentTest test1,String url, int dataset) throws AWTException, IOException, InterruptedException {	
	
	System.out.println("url : "+url);
	
	String Username = Utils.getDataFromTestData("TS_026_Tc_081_ERO_Mass_Cost_Update_Dataset"+dataset, "ero_mass_cost_update", "Username");
	String Password = Utils.getDataFromTestData("TS_026_Tc_081_ERO_Mass_Cost_Update_Dataset"+dataset, "ero_mass_cost_update", "Password");
	String ID = Utils.getDataFromTestData("TS_026_Tc_081_ERO_Mass_Cost_Update_Dataset"+dataset, "ero_mass_cost_update", "Id");
	String StartDate = Utils.getDataFromTestData("TS_026_Tc_081_ERO_Mass_Cost_Update_Dataset"+dataset, "ero_mass_cost_update", "StartDate");

	 navigateUrl(driver, url);
		
		Fluentwait(driver, Username_input2);
		sendKeys(driver, Username_input2, Username);
		
		Fluentwait(driver, Password_input2);
		sendKeys(driver, Password_input2, Password);
		
		Fluentwait(driver, SignIn2);
		click(driver, SignIn2);
		
		wait(driver,"5");
		
		if(isDisplayed(driver, session_confirmation2)) {
			Fluentwait(driver, session_confirmation2);
			click(driver, session_confirmation2);
		}
		
		Fluentwait(driver, Searchbox2);
		sendKeys(driver, Searchbox2, "ERO Mass Cost Update");
		
		Fluentwait(driver, Select_MassCostUpdate);
		click(driver, Select_MassCostUpdate);
		
		wait(driver,"3");
click(driver, Cancel_Button);
		
		Fluentwait(driver, NewReport);
		click(driver, NewReport);
		
		
		Fluentwait(driver, Click_Confirm);
		click(driver, Click_Confirm);
		
		wait(driver,"5");

		
		
		Fluentwait(driver, Add_Plus_Button);
		click(driver, Add_Plus_Button);
		
		
		wait(driver,"3");

		Fluentwait(driver, Select_Loc);
		doubleClick(driver, Select_Loc);
		
		wait(driver,"3");

		
		click(driver, ShowButton);
		
		wait(driver,"3");
		
		
		
		Extent_cal(test,
				"Testcase 81 - To verify the Mass Cost update Start Date screen allow to edit the Start Date which equipment type is choosing");
		
			
		
		Extent_cal(test,"Start Date Edit(Cells or Cells");

		click(driver, EditButton);
		
		wait(driver,"3");
		
		
		String Start_Date_Data = getText(driver,StartDate_GridField );

		System.out.println("Start_Date_Data : "+Start_Date_Data);
		
		wait(driver,"5");

		doubleClick(driver, StartDate_GridField);
		wait(driver,"3");
		
		Fluentwait(driver, StartDate_EditField);
		click(driver, StartDate_EditField);
		
		sendKeys(driver, StartDate_EditField, StartDate);
		wait(driver,"3");

		click(driver, Apply_Button);
		
		wait(driver,"3");

		String EditStart_Date_Data = getText(driver,StartDate_GridField );

		System.out.println("EditStart_Date_Data : "+EditStart_Date_Data);
		
		
		wait(driver,"3");

		if (!Start_Date_Data.equals(EditStart_Date_Data)) {
			System.out.println("Matched || Before Edited Data was : " + Start_Date_Data
					+ " After Edited Data was : " + EditStart_Date_Data);
			Extent_pass(driver, "Matched || Before Edited Data was : "
					+ Start_Date_Data + " After Edited Data was : " + EditStart_Date_Data,
					test,test1);
		} else {
			System.out.println(
					"Not Matched || Before Edited Data was : " + Start_Date_Data
							+ " After Edited Data was : " + EditStart_Date_Data);
			Extent_fail2(driver, "Not Matched || Before Edited Data was : "
					+ Start_Date_Data + " After Edited Data was : " + EditStart_Date_Data,
					test);

		}
		
		
		wait(driver,"3");
		click(driver, Cancel_Button);
				
				Fluentwait(driver, NewReport);
				click(driver, NewReport);
				
				
				Fluentwait(driver, Click_Confirm);
				click(driver, Click_Confirm);
				
				wait(driver,"5");

				
				
				Fluentwait(driver, Add_Plus_Button);
				click(driver, Add_Plus_Button);
				
				
				wait(driver,"3");

				Fluentwait(driver, Select_Loc);
				doubleClick(driver, Select_Loc);
				
				wait(driver,"3");

				
				click(driver, ShowButton);
				
				wait(driver,"3");

				click(driver, EditButton);
				
				wait(driver,"3");
				
				Extent_cal(test,"Start Date Edit(Edit All Rows");

		
		click(driver, Edit_All_Rows);
		
		wait(driver,"2");
		
		
		List<WebElement> StartDate_Data = driver
				.findElements(By.xpath("(//tbody[@id='MCU-MCU_gridCostUp_data']//tr//td[4])"));
		List<String> Start_Date_Value = new ArrayList<String>();
		for (WebElement Data1 : StartDate_Data) {
			String Cost_Type1 = Data1.getText();
			Start_Date_Value.add(Cost_Type1);
			
		}

		System.out.println("Start_Date_Value : "+Start_Date_Value);
		
		wait(driver,"3");

		
		doubleClick(driver, StartDate_GridField);
		wait(driver,"3");
		
		Fluentwait(driver, StartDate_EditField);
		click(driver, StartDate_EditField);
		
		sendKeys(driver, StartDate_EditField, StartDate);
		wait(driver,"3");

		click(driver, Apply_Button);
		
		wait(driver,"3");
		
		
		List<WebElement> Edit_StartDate_Data = driver
				.findElements(By.xpath("(//tbody[@id='MCU-MCU_gridCostUp_data']//tr//td[4])"));
		List<String> EditStart_Date_Value = new ArrayList<String>();
		for (WebElement Data2 : Edit_StartDate_Data) {
			String Cost_Type2 = Data2.getText();
			EditStart_Date_Value.add(Cost_Type2);
			
		}

		System.out.println("EditStart_Date_Value : "+EditStart_Date_Value);
		
		wait(driver,"3");

		
		for (int i = 0; i < Start_Date_Value.size(); i++) {

			if (!Start_Date_Value.get(i).equals(EditStart_Date_Value.get(i))) {
				System.out.println("Matched || Before Edited Data was : " + Start_Date_Value.get(i)
						+ " After Edited Data was : " + EditStart_Date_Value.get(i));
				Extent_pass(driver, "Matched || Before Edited Data was : "
						+ Start_Date_Value.get(i) + " After Edited Data was : " + EditStart_Date_Value.get(i),
						test,test1);
			} else {
				System.out.println(
						"Not Matched || Before Edited Data was : " + Start_Date_Value.get(i)
								+ " After Edited Data was : " + EditStart_Date_Value.get(i));
				Extent_fail2(driver, "Not Matched || Before Edited Data was : "
						+ Start_Date_Value.get(i) + " After Edited Data was : " + EditStart_Date_Value.get(i),
						test);

			}
			
			}
		
		
		
	}
}
