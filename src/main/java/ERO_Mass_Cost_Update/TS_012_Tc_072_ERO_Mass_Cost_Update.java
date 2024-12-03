package ERO_Mass_Cost_Update;

import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.AWTException;
import java.io.IOException;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.Utils;



public class TS_012_Tc_072_ERO_Mass_Cost_Update extends Keywords{
	public void Scenario012(WebDriver driver, ExtentTest test,ExtentTest test1,String url, int dataset) throws AWTException, IOException, InterruptedException {	
	
	System.out.println("url : "+url);
	
	String Username = Utils.getDataFromTestData("TS_012_Tc_072_ERO_Mass_Cost_Update_Dataset"+dataset, "ero_mass_cost_update", "Username");
	String Password = Utils.getDataFromTestData("TS_012_Tc_072_ERO_Mass_Cost_Update_Dataset"+dataset, "ero_mass_cost_update", "Password");
	String ID = Utils.getDataFromTestData("TS_012_Tc_072_ERO_Mass_Cost_Update_Dataset"+dataset, "ero_mass_cost_update", "Id");
	String EQU_Type = Utils.getDataFromTestData("TS_012_Tc_072_ERO_Mass_Cost_Update_Dataset"+dataset, "ero_mass_cost_update", "Equipment Type");

	
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
		
		click(driver, Grid_Textbox1);
		
		sendKeys(driver, Grid_Textbox1, "AEAUH");
		
		wait(driver,"3");

		
		
		click(driver, Textfield2);
		sendKeys(driver, Textfield2, "20DY");
		
		wait(driver,"3");

		
		String STV_Cost_Data = getText(driver,STV_Cost );

		System.out.println("STV_Cost_Data : "+STV_Cost_Data);
		
		wait(driver,"5");
		
		Fluentwait(driver, Searchbox2);
		sendKeys(driver, Searchbox2, "ERO Load Cost");
		
		Fluentwait(driver, ERO_Cost_Update_Tab);
		click(driver, ERO_Cost_Update_Tab);
		
		wait(driver,"3");	
		
		
		click(driver, ERO_COst_Update_Globalsearch);
		
		wait(driver,"2");	

		sendKeys(driver, Globalserach_IDInput, ID);
		
		

		wait(driver, "2");

		Fluentwait(driver, Click_Search);
		click(driver, Click_Search);

		wait(driver, "3");
		
		sendKeys(driver, Equ_Type_Input, "20DY");
		wait(driver, "3");


		Fluentwait(driver, SelectID_Grid);
		doubleClick(driver, SelectID_Grid);
		
		wait(driver, "3");
		
		String STV_Cost_Data1 = getText(driver,STV_Grid_Cost_Data );

		System.out.println("STV_Cost_Data1 : "+STV_Cost_Data1);
		
		wait(driver,"5");

		
		if (STV_Cost_Data.equals(STV_Cost_Data1)) {
			System.out.println("Matched || Expected STV Cost Value was : " + STV_Cost_Data
					+ " Actual STV Cost Value was : " + STV_Cost_Data1);
			Extent_pass(driver, "Matched || Expected STV Cost Value was : "
					+ STV_Cost_Data + " Actual STV Cost Value was : " + STV_Cost_Data1,
					test,test1);
		} else {
			System.out.println(
					"Not Matched || Expected STV Cost Value was : " + STV_Cost_Data
							+ " Actual STV Cost Value was : " + STV_Cost_Data1);
			Extent_fail2(driver, "Not Matched || Expected STV Cost Value was : "
					+ STV_Cost_Data + " Actual STV Cost Value was : " + STV_Cost_Data1,
					test);

		}
		
	}

}
