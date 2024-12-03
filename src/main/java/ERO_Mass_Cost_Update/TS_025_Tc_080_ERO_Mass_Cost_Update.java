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



public class TS_025_Tc_080_ERO_Mass_Cost_Update extends Keywords{
	public void Scenario025(WebDriver driver, ExtentTest test,ExtentTest test1,String url, int dataset) throws AWTException, IOException, InterruptedException {	
	
	System.out.println("url : "+url);
	
	String Username = Utils.getDataFromTestData("TS_025_Tc_080_ERO_Mass_Cost_Update_Dataset"+dataset, "ero_mass_cost_update", "Username");
	String Password = Utils.getDataFromTestData("TS_025_Tc_080_ERO_Mass_Cost_Update_Dataset"+dataset, "ero_mass_cost_update", "Password");
	//String ID = Utils.getDataFromTestData("TS_025_Tc_080_ERO_Mass_Cost_Update_Dataset"+dataset, "ero_mass_cost_update", "Id");
	String Cost = Utils.getDataFromTestData("TS_025_Tc_080_ERO_Mass_Cost_Update_Dataset"+dataset, "ero_mass_cost_update", "Cost");
	String STVCost = Utils.getDataFromTestData("TS_025_Tc_080_ERO_Mass_Cost_Update_Dataset"+dataset, "ero_mass_cost_update", "STVCost");
	String WarCost = Utils.getDataFromTestData("TS_025_Tc_080_ERO_Mass_Cost_Update_Dataset"+dataset, "ero_mass_cost_update", "WarCost");

	
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
				"Testcase 80 - To verify the Mass Cost update cost screen allow to edit the cost which equipment type is choosing");
		
		
		Extent_cal(test,"QNT Cost Edit");
		
		
		Extent_cal(test,"QNT Cost Edit(Cells or Cells");


		click(driver, EditButton);
		
		wait(driver,"3");
		
		
		String Cost_Data = getText(driver,Grid_Rec );

		System.out.println("Cost_Data : "+Cost_Data);
		
		wait(driver,"5");

		
		Fluentwait(driver, Grid_Rec);
		doubleClick(driver, Grid_Rec);
		
		
		wait(driver,"5");

		
		
		Fluentwait(driver, Cost_Edit);
		click(driver, Cost_Edit);
		
		sendKeys(driver, Cost_Edit, Cost);
		
		wait(driver,"5");

		Fluentwait(driver, Grid_Rec);
		click(driver, Grid_Rec);
		
		wait(driver,"3");

		
		String Edit_Cost_Data = getText(driver,Grid_Rec );

		System.out.println("Edit_Cost_Data : "+Edit_Cost_Data);
		
		
		wait(driver,"3");

		if (!Cost_Data.equals(Edit_Cost_Data)) {
			System.out.println("Matched || Before Edited Data was : " + Cost_Data
					+ " After Edited Data was : " + Edit_Cost_Data);
			Extent_pass(driver, "Matched || Before Edited Data was : "
					+ Cost_Data + " After Edited Data was : " + Edit_Cost_Data,
					test,test1);
		} else {
			System.out.println(
					"Not Matched || Before Edited Data was : " + Cost_Data
							+ " After Edited Data was : " + Edit_Cost_Data);
			Extent_fail2(driver, "Not Matched || Before Edited Data was : "
					+ Cost_Data + " After Edited Data was : " + Edit_Cost_Data,
					test);

		}
	
	
		wait(driver,"3");
		
		
		scrollUp(driver);
		wait(driver,"3");

		click(driver, Cancel_Button);
		wait(driver,"3");

				
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
				
				
				Extent_cal(test,"QNT Cost Edit(Edit All Rows");


				click(driver, EditButton);
				
				wait(driver,"3");
				
				
		
		click(driver, Edit_All_Rows);
		
		wait(driver,"2");
		
		List<WebElement> QNT_Cost_Data = driver
				.findElements(By.xpath("(//tbody[@id='MCU-MCU_gridCostUp_data']//tr//td[6])"));
		List<String> Cost_Type = new ArrayList<String>();
		for (WebElement Data1 : QNT_Cost_Data) {
			String Cost_Type1 = Data1.getText();
			Cost_Type.add(Cost_Type1);
			
		}

		System.out.println("Cost_Type : "+Cost_Type);

		
wait(driver,"5");

		
		Fluentwait(driver, Grid_Rec);
		doubleClick(driver, Grid_Rec);
		
		
		wait(driver,"5");

		
		
		Fluentwait(driver, Cost_Edit);
		click(driver, Cost_Edit);
		
		sendKeys(driver, Cost_Edit, Cost);
		
		wait(driver,"5");

		Fluentwait(driver, Grid_Rec);
		click(driver, Grid_Rec);
		
		wait(driver,"3");

		
		List<WebElement> QNT_Cost1 = driver
				.findElements(By.xpath("(//tbody[@id='MCU-MCU_gridCostUp_data']//tr//td[6])"));
		List<String> Edit_Cost_Type = new ArrayList<String>();
		for (WebElement Data2 : QNT_Cost1) {
			String Edit_Cost_Type1 = Data2.getText();
			Edit_Cost_Type.add(Edit_Cost_Type1);
			
		
		}
		
		System.out.println("Edit_Cost_Type : "+Edit_Cost_Type);

		
		wait(driver,"3");
		
		
		for (int i = 0; i < Cost_Type.size(); i++) {

		if (!Cost_Type.get(i).equals(Edit_Cost_Type.get(i))) {
			System.out.println("Matched || Before Edited Data was : " + Cost_Type.get(i)
					+ " After Edited Data was : " + Edit_Cost_Type.get(i));
			Extent_pass(driver, "Matched || Before Edited Data was : "
					+ Cost_Type.get(i) + " After Edited Data was : " + Edit_Cost_Type.get(i),
					test,test1);
		} else {
			System.out.println(
					"Not Matched || Before Edited Data was : " + Cost_Type.get(i)
							+ " After Edited Data was : " + Edit_Cost_Type.get(i));
			Extent_fail2(driver, "Not Matched || Before Edited Data was : "
					+ Cost_Type.get(i) + " After Edited Data was : " + Edit_Cost_Type.get(i),
					test);

		}
		
		}
		
		
wait(driver,"3");
		
		
		scrollUp(driver);
		wait(driver,"3");

		click(driver, Cancel_Button);
		wait(driver,"3");

				
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
					
		
		
		
		
		
		
		
		Extent_cal(test,"STV Cost Edit");

		Extent_cal(test,"STV Cost Edit(Cells or Cells)");
		
		
		
wait(driver,"3");
		
click(driver, EditButton);
		
		wait(driver,"3");
		
		click(driver, Edit_Cellbycells);
		wait(driver,"3");

		
		String STVCost_Data = getText(driver,STV_Cost );

		System.out.println("STVCost_Data : "+STVCost_Data);
		
		wait(driver,"5");

		
		Fluentwait(driver, STV_Cost);
		doubleClick(driver, STV_Cost);
		
		
		wait(driver,"5");

		
		
		Fluentwait(driver, Cost_Edit);
		click(driver, Cost_Edit);
		
		sendKeys(driver, Cost_Edit, STVCost);
		
		wait(driver,"5");

		Fluentwait(driver, STV_Cost);
		click(driver, STV_Cost);
		
		wait(driver,"3");

		
		String Edit_STVCost_Data = getText(driver,STV_Cost );

		System.out.println("Edit_STVCost_Data : "+Edit_STVCost_Data);
		
		
		wait(driver,"3");

		if (!STVCost_Data.equals(Edit_STVCost_Data)) {
			System.out.println("Matched || Before Edited Data was : " + STVCost_Data
					+ " After Edited Data was : " + Edit_STVCost_Data);
			Extent_pass(driver, "Matched || Before Edited Data was : "
					+ STVCost_Data + " After Edited Data was : " + Edit_STVCost_Data,
					test,test1);
		} else {
			System.out.println(
					"Not Matched || Before Edited Data was : " + STVCost_Data
							+ " After Edited Data was : " + Edit_STVCost_Data);
			Extent_fail2(driver, "Not Matched || Before Edited Data was : "
					+ STVCost_Data + " After Edited Data was : " + Edit_STVCost_Data,
					test);

		}
	
	
wait(driver,"3");
		
		
		scrollUp(driver);
		wait(driver,"3");

		click(driver, Cancel_Button);
		wait(driver,"3");

				
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
				
				
				Extent_cal(test,"STV Cost Edit(Edit All Rows)");


				click(driver, EditButton);
				
				wait(driver,"3");
				
				
		
		click(driver, Edit_All_Rows);
		
		wait(driver,"2");
		
		List<WebElement> STV_Cost_Data = driver
				.findElements(By.xpath("(//tbody[@id='MCU-MCU_gridCostUp_data']//tr//td[8])"));
		List<String> STVCost_Type = new ArrayList<String>();
		for (WebElement Data1 : STV_Cost_Data) {
			String STVCost_Type1 = Data1.getText();
			STVCost_Type.add(STVCost_Type1);
			
		}

		System.out.println("STVCost_Type : "+STVCost_Type);

		
wait(driver,"5");

		
		Fluentwait(driver, STV_Cost);
		doubleClick(driver, STV_Cost);
		
		
		wait(driver,"5");

		
		
		Fluentwait(driver, Cost_Edit);
		click(driver, Cost_Edit);
		
		sendKeys(driver, Cost_Edit, STVCost);
		
		wait(driver,"5");

		Fluentwait(driver, STV_Cost);
		click(driver, STV_Cost);
		
		wait(driver,"3");

		
		List<WebElement> EditSTV_Cost_Data = driver
				.findElements(By.xpath("(//tbody[@id='MCU-MCU_gridCostUp_data']//tr//td[8])"));
		List<String> Edit_STVCost_Type = new ArrayList<String>();
		for (WebElement Data2 : EditSTV_Cost_Data) {
			String EditSTV_Cost_Type1 = Data2.getText();
			Edit_STVCost_Type.add(EditSTV_Cost_Type1);
			
		
		}
		
		System.out.println("Edit_STVCost_Type : "+Edit_STVCost_Type);

		
		wait(driver,"3");
		
		
		for (int i = 0; i < STVCost_Type.size(); i++) {

		if (!STVCost_Type.get(i).equals(Edit_STVCost_Type.get(i))) {
			System.out.println("Matched || Before Edited Data was : " + STVCost_Type.get(i)
					+ " After Edited Data was : " + Edit_STVCost_Type.get(i));
			Extent_pass(driver, "Matched || Before Edited Data was : "
					+ STVCost_Type.get(i) + " After Edited Data was : " + Edit_STVCost_Type.get(i),
					test,test1);
		} else {
			System.out.println(
					"Not Matched || Before Edited Data was : " + STVCost_Type.get(i)
							+ " After Edited Data was : " + Edit_STVCost_Type.get(i));
			Extent_fail2(driver, "Not Matched || Before Edited Data was : "
					+ STVCost_Type.get(i) + " After Edited Data was : " + Edit_STVCost_Type.get(i),
					test);

		}
		
		}
		
		

	
		
		Extent_cal(test,"War Cost Edit");

		Extent_cal(test,"War Cost Edit(Cells or Cells)");
		
		wait(driver,"3");

		scrollUp(driver);
		
		
		click(driver, Cancel_Button);
		wait(driver,"3");

				
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
				
				
				Extent_cal(test,"War Cost Edit(Cell by cell)");


				click(driver, EditButton);
				
				wait(driver,"3");
		
		
		
		wait(driver,"3");
		
		click(driver, Edit_Cellbycells);
		wait(driver,"3");

		
		String WarCost_Data = getText(driver,War_Cost_Grid_data );

		System.out.println("WarCost_Data : "+WarCost_Data);
		
		wait(driver,"5");

		
		Fluentwait(driver, War_Cost_Grid_data);
		doubleClick(driver, War_Cost_Grid_data);
		
		
		wait(driver,"5");

		
		
		Fluentwait(driver, Cost_Edit);
		click(driver, Cost_Edit);
		
		sendKeys(driver, Cost_Edit, WarCost);
		
		wait(driver,"5");

		Fluentwait(driver, War_Cost_Grid_data);
		click(driver, War_Cost_Grid_data);
		
		wait(driver,"3");

		
		String Edit_WarCost_Data = getText(driver,War_Cost_Grid_data );

		System.out.println("Edit_WarCost_Data : "+Edit_WarCost_Data);
		
		
		wait(driver,"3");

		if (!WarCost_Data.equals(Edit_WarCost_Data)) {
			System.out.println("Matched || Before Edited Data was : " + WarCost_Data
					+ " After Edited Data was : " + Edit_WarCost_Data);
			Extent_pass(driver, "Matched || Before Edited Data was : "
					+ WarCost_Data + " After Edited Data was : " + Edit_WarCost_Data,
					test,test1);
		} else {
			System.out.println(
					"Not Matched || Before Edited Data was : " + WarCost_Data
							+ " After Edited Data was : " + Edit_WarCost_Data);
			Extent_fail2(driver, "Not Matched || Before Edited Data was : "
					+ WarCost_Data + " After Edited Data was : " + Edit_WarCost_Data,
					test);

		}
	
	
wait(driver,"3");
		
		
		scrollUp(driver);
		wait(driver,"3");

		click(driver, Cancel_Button);
		wait(driver,"3");

				
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
				
				
				Extent_cal(test,"War Cost Edit(Edit All Rows)");

				wait(driver,"3");
				click(driver, EditButton);
				
				wait(driver,"3");
				
				
		
		click(driver, Edit_All_Rows);
		
		wait(driver,"2");
		
		List<WebElement> War_Cost_Data1 = driver
				.findElements(By.xpath("(//tbody[@id='MCU-MCU_gridCostUp_data']//tr//td[10])"));
		List<String> WarCost_Type1 = new ArrayList<String>();
		for (WebElement Data2 : War_Cost_Data1) {
			String War_Cost_Type1 = Data2.getText();
			WarCost_Type1.add(War_Cost_Type1);
			
		}

		System.out.println("WarCost_Type1 : "+WarCost_Type1);

		
wait(driver,"5");

		
		Fluentwait(driver, War_Cost_Grid_data);
		doubleClick(driver, War_Cost_Grid_data);
		
		
		wait(driver,"5");

		
		
		Fluentwait(driver, Cost_Edit);
		click(driver, Cost_Edit);
		
		sendKeys(driver, Cost_Edit, WarCost);
		
		wait(driver,"5");

		Fluentwait(driver, War_Cost_Grid_data);
		click(driver, War_Cost_Grid_data);
		
		wait(driver,"3");

		
		List<WebElement> EditWar_Cost_Data1 = driver
				.findElements(By.xpath("(//tbody[@id='MCU-MCU_gridCostUp_data']//tr//td[10])"));
		List<String> Edit_WarCost_Type1 = new ArrayList<String>();
		for (WebElement Data2 : EditWar_Cost_Data1) {
			String Edit_War_Cost_Type1 = Data2.getText();
			Edit_WarCost_Type1.add(Edit_War_Cost_Type1);
			
		
		}
		
		System.out.println("Edit_WarCost_Type1 : "+Edit_WarCost_Type1);

		
		wait(driver,"3");
		
		
		for (int i = 0; i < WarCost_Type1.size(); i++) {

		if (!WarCost_Type1.get(i).equals(Edit_WarCost_Type1.get(i))) {
			System.out.println("Matched || Before Edited Data was : " + WarCost_Type1.get(i)
					+ " After Edited Data was : " + Edit_WarCost_Type1.get(i));
			Extent_pass(driver, "Matched || Before Edited Data was : "
					+ WarCost_Type1.get(i) + " After Edited Data was : " + Edit_WarCost_Type1.get(i),
					test,test1);
		} else {
			System.out.println(
					"Not Matched || Before Edited Data was : " + WarCost_Type1.get(i)
							+ " After Edited Data was : " + Edit_WarCost_Type1.get(i));
			Extent_fail2(driver, "Not Matched || Before Edited Data was : "
					+ WarCost_Type1.get(i) + " After Edited Data was : " + Edit_WarCost_Type1.get(i),
					test);

		}
		
		}
			
		
		System.out
		.println("//***************************Testcase 80 Completed **************************************//");	
		
		
		
		
	}
}
