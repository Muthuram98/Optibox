package ERO_Mass_Cost_Update;

import java.awt.AWTException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.Utils;



public class TS_027_Tc_082_ERO_Mass_Cost_Update extends Keywords{
	public void Scenario027(WebDriver driver, ExtentTest test,ExtentTest test1,String url, int dataset) throws AWTException, IOException, InterruptedException {	
	
	System.out.println("url : "+url);
	
	String Username = Utils.getDataFromTestData("TS_027_Tc_082_ERO_Mass_Cost_Update_Dataset"+dataset, "ero_mass_cost_update", "Username");
	String Password = Utils.getDataFromTestData("TS_027_Tc_082_ERO_Mass_Cost_Update_Dataset"+dataset, "ero_mass_cost_update", "Password");
	String ID = Utils.getDataFromTestData("TS_027_Tc_082_ERO_Mass_Cost_Update_Dataset"+dataset, "ero_mass_cost_update", "Id");
	String EndDate = Utils.getDataFromTestData("TS_027_Tc_082_ERO_Mass_Cost_Update_Dataset"+dataset, "ero_mass_cost_update", "EndDate");

	
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
				"Testcase 82 - To verify the Mass Cost update End Date screen allow to edit the Start Date which equipment type is choosing");
		
			
		
		Extent_cal(test,"End Date Edit(Cells or Cells");

		click(driver, EditButton);
		
		wait(driver,"3");
		
		
		String End_Date_Data = getText(driver,EndDate_GridField );

		System.out.println("End_Date_Data : "+End_Date_Data);
		
		wait(driver,"5");

		doubleClick(driver, EndDate_GridField);
		wait(driver,"3");
		
		Fluentwait(driver, EndDate_EditField);
		click(driver, EndDate_EditField);
		
		sendKeys(driver, EndDate_EditField, EndDate);
		wait(driver,"3");

		click(driver, Apply_Button);
		
		wait(driver,"3");

		String EditEnd_Date_Data = getText(driver,StartDate_GridField );

		System.out.println("EditStart_Date_Data : "+EditEnd_Date_Data);
		
		
		wait(driver,"3");

		if (!End_Date_Data.equals(EditEnd_Date_Data)) {
			System.out.println("Matched || Before Edited Data was : " + End_Date_Data
					+ " After Edited Data was : " + EditEnd_Date_Data);
			Extent_pass(driver, "Matched || Before Edited Data was : "
					+ End_Date_Data + " After Edited Data was : " + EditEnd_Date_Data,
					test,test1);
		} else {
			System.out.println(
					"Not Matched || Before Edited Data was : " + End_Date_Data
							+ " After Edited Data was : " + EditEnd_Date_Data);
			Extent_fail2(driver, "Not Matched || Before Edited Data was : "
					+ End_Date_Data + " After Edited Data was : " + EditEnd_Date_Data,
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
				
				
				Extent_cal(test,"End Date Edit(Edit All Rows");


				click(driver, EditButton);
				
				wait(driver,"3");
				
				
		
		click(driver, Edit_All_Rows);
		
		wait(driver,"2");
		
		
		List<WebElement> EndDate_Data = driver
				.findElements(By.xpath("(//tbody[@id='MCU-MCU_gridCostUp_data']//tr//td[5])"));
		List<String> End_Date_Value = new ArrayList<String>();
		for (WebElement Data1 : EndDate_Data) {
			String Cost_Type1 = Data1.getText();
			End_Date_Value.add(Cost_Type1);
			
		}

		System.out.println("Start_Date_Value : "+End_Date_Value);
		
		wait(driver,"3");

		
		doubleClick(driver, EndDate_GridField);
		wait(driver,"3");
		
		Fluentwait(driver, EndDate_EditField);
		click(driver, EndDate_EditField);
		
		sendKeys(driver, EndDate_EditField, EndDate);
		wait(driver,"3");

		click(driver, Apply_Button);
		
		wait(driver,"3");
		
		
		List<WebElement> Edit_EndDate_Data = driver
				.findElements(By.xpath("(//tbody[@id='MCU-MCU_gridCostUp_data']//tr//td[5])"));
		List<String> EditEnd_Date_Value = new ArrayList<String>();
		for (WebElement Data2 : Edit_EndDate_Data) {
			String Cost_Type2 = Data2.getText();
			EditEnd_Date_Value.add(Cost_Type2);
			
		}

		System.out.println("EditEnd_Date_Value : "+EditEnd_Date_Value);
		
		wait(driver,"3");

		
		for (int i = 0; i < End_Date_Value.size(); i++) {

			if (!End_Date_Value.get(i).equals(EditEnd_Date_Value.get(i))) {
				System.out.println("Matched || Before Edited Data was: " + End_Date_Value.get(i)
						+ " After Edited Data was: " + EditEnd_Date_Value.get(i));
				Extent_pass(driver, "Matched || Before Edited Data was: "
						+ End_Date_Value.get(i) + " After Edited Data was : " + EditEnd_Date_Value.get(i),
						test,test1);
			} else {
				System.out.println(
						"Not Matched || Before Edited Data was : " + End_Date_Value.get(i)
								+ " After Edited Data was : " + EditEnd_Date_Value.get(i));
				Extent_fail2(driver, "Not Matched || Before Edited Data was : "
						+ End_Date_Value.get(i) + " After Edited Data was : " + EditEnd_Date_Value.get(i),
						test);

			}
			
			}
		
		
		
	}
}


