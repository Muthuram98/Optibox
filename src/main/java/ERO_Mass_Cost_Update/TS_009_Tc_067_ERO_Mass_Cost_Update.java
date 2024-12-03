package ERO_Mass_Cost_Update;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
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

public class TS_009_Tc_067_ERO_Mass_Cost_Update extends Keywords{
	public void Scenario009(WebDriver driver, ExtentTest test,ExtentTest test1,String url, int dataset) throws AWTException, IOException, InterruptedException {	
	
	System.out.println("url : "+url);
	
	String Username = Utils.getDataFromTestData("TS_009_Tc_067_ERO_Mass_Cost_Update_Dataset"+dataset, "ero_mass_cost_update", "Username");
	String Password = Utils.getDataFromTestData("TS_009_Tc_067_ERO_Mass_Cost_Update_Dataset"+dataset, "ero_mass_cost_update", "Password");
	String FieldInput_name = Utils.getDataFromTestData("TS_009_Tc_067_ERO_Mass_Cost_Update_Dataset"+dataset,
			"ero_mass_cost_update", "Fieldvalue_1");
	String FieldInput_name1 = Utils.getDataFromTestData("TS_009_Tc_067_ERO_Mass_Cost_Update_Dataset"+dataset,
			"ero_mass_cost_update", "Fieldvalue_2");
	String FieldInput_name2 = Utils.getDataFromTestData("TS_009_Tc_067_ERO_Mass_Cost_Update_Dataset"+dataset,
			"ero_mass_cost_update", "Fieldvalue_3");
	String FieldInput_name3 = Utils.getDataFromTestData("TS_009_Tc_067_ERO_Mass_Cost_Update_Dataset"+dataset,
			"ero_mass_cost_update", "Fieldvalue_4");
	String FieldInput_name4 = Utils.getDataFromTestData("TS_009_Tc_067_ERO_Mass_Cost_Update_Dataset"+dataset,
			"ero_mass_cost_update", "Fieldvalue_5");
	String FieldInput_name5 = Utils.getDataFromTestData("TS_009_Tc_067_ERO_Mass_Cost_Update_Dataset"+dataset,
			"ero_mass_cost_update", "Fieldvalue_6");
	String FieldInput_name6 = Utils.getDataFromTestData("TS_009_Tc_067_ERO_Mass_Cost_Update_Dataset"+dataset,
			"ero_mass_cost_update", "Fieldvalue_7");
	String FieldInput_name7 = Utils.getDataFromTestData("TS_009_Tc_067_ERO_Mass_Cost_Update_Dataset"+dataset,
			"ero_mass_cost_update", "Fieldvalue_8");
	String FieldInput_name8 = Utils.getDataFromTestData("TS_009_Tc_067_ERO_Mass_Cost_Update_Dataset"+dataset,
			"ero_mass_cost_update", "Fieldvalue_9");
	String FieldInput_name9 = Utils.getDataFromTestData("TS_009_Tc_067_ERO_Mass_Cost_Update_Dataset"+dataset,
			"ero_mass_cost_update", "Fieldvalue_10");
	String FieldInput_name10 = Utils.getDataFromTestData("TS_009_Tc_067_ERO_Mass_Cost_Update_Dataset"+dataset,
			"ero_mass_cost_update", "Fieldvalue_11");
	String LocationName1 = Utils.getDataFromTestData("TS_009_Tc_067_ERO_Mass_Cost_Update_Dataset"+dataset,
			"ero_mass_cost_update", "Location_Data1");
	String LocationName2 = Utils.getDataFromTestData("TS_009_Tc_067_ERO_Mass_Cost_Update_Dataset"+dataset,
			"ero_mass_cost_update", "Location_Data2");
	
	
	
	Actions act = new Actions(driver);

	
	
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
		
		
		Extent_cal(test, "Testcase 67 - Ensure System allows to paste the copied data in Grid Itself ");


		
		Fluentwait(driver, Grid_Rec1);
		click(driver, Grid_Rec1);

		String textToCopy = "20FF";
		
		
		
		// Create a StringSelection object with the text
		StringSelection stringSelection = new StringSelection(textToCopy);

		// Get the system clipboard
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

		// Set the content of the clipboard to the string
		clipboard.setContents(stringSelection, null);

		System.out.println("Text copied to clipboard: " + textToCopy);


		wait(driver, "2");


Fluentwait(driver, Textfield2);
		click(driver,Textfield2 );

		wait(driver, "2");

		act.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();

		wait(driver, "2");

	
		
		try {
			String inputvalue = getText(driver, Past_Grid1);

			System.out.println("inputvalue : " + inputvalue);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		String inputvalue = getText(driver, Past_Grid1);

		System.out.println("inputvalue : " + inputvalue);


		if (textToCopy.equals(inputvalue)) {

			System.out.println("Grid filter accept to paste the copied data");
			Extent_pass(driver, "Grid filter accept to paste the copied data", test,test1);

		} else {

			System.out.println("Grid filter not accept to paste the copied data");
			Extent_fail(driver, "Grid filter not accept to paste the copied data", test,test1);
			
		}
		
		act.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
		wait(driver, "2");
		act.sendKeys(Keys.BACK_SPACE).perform();

		System.out.println(" ************************Testcase 67 - Completed *************************");
				
		
		Extent_cal(test, "Testcase 68 - Ensure DS grid allows Filter functionality ");

		wait(driver, "2");

		
click(driver, EditButton);
		
		wait(driver, "2");

		
click(driver, Cancel_Button);
		
		Fluentwait(driver, NewReport);
		click(driver, NewReport);
		
		
		Fluentwait(driver, Click_Confirm);
		click(driver, Click_Confirm);
		
		wait(driver,"5");

		
		
		Fluentwait(driver, Add_Plus_Button);
		click(driver, Add_Plus_Button);
		
		
		wait(driver,"5");
		
		

		Fluentwait(driver, Loc_Search);
		click(driver, Loc_Search);
		wait(driver,"3");

		sendKeys(driver, Loc_Search, LocationName1);
		
		wait(driver,"2");

		
		doubleClick(driver, Select_Loc1);
		
		wait(driver,"2");

		
		Fluentwait(driver, Add_Plus_Button);
		click(driver, Add_Plus_Button);
		
		
		wait(driver,"5");
		
		
		click(driver, Loc_Search);
        wait(driver,"2");


		sendKeys(driver, Loc_Search, LocationName2);
		
         wait(driver,"2");

		
		doubleClick(driver, Select_Loc1);
		wait(driver,"2");

		
		
		wait(driver,"3");

		
		click(driver, ShowButton);
		
		
		wait(driver,"3");
		
	
		Extent_cal(test, "Grid1");


			Fluentwait(driver, Grid_Textbox1);
			click(driver, Grid_Textbox1);
			
			
			sendKeys(driver, Grid_Textbox1, FieldInput_name);
			
			

		
			wait(driver, "3");


		List<WebElement> Location_Mass_Cost_Update = driver.findElements(By.xpath("(//tbody[@id='MCU-MCU_gridCostUp_data']//tr//td[1])"));
		for (WebElement Location :Location_Mass_Cost_Update) {
			String Location1 = Location.getText();
			if(Location1.equals(FieldInput_name)) {
				System.out.println("Matched ||DS grid allows Filter functionality|| Expected Grid Value was : " + Location1
						+ "  || Actual Grid Value was : " + FieldInput_name);
				Extent_pass(driver, "Matched ||Grid is Capturing both Upper case and lower case letters|| Expected Grid Value was : "
						+ Location1 + "  || Actual Grid Value was : " + FieldInput_name,
						test,test1);
			} else {
				System.out.println(
						"Not Matched || DS grid not allows Filter functionality|| Expected Grid Value was : " + Location1
								+ "  || Actual Grid Value was : " + FieldInput_name);
				Extent_fail2(driver, "Not Matched || DS grid not allows Filter functionality|| Expected Grid Value was : "
						+ Location1 + "  || Actual Grid Value was : " + FieldInput_name,
						test);

			}
		}
					
				
		clear(driver, Grid_Textbox1);
		
	
		Extent_cal(test, "Grid2");
		
		wait(driver, "3");

		Fluentwait(driver, Textfield2);
		click(driver, Textfield2);
		
		
		sendKeys(driver, Textfield2, FieldInput_name1);
		
		

	
		wait(driver, "3");


	List<WebElement> Location_Mass_Cost_Update1 = driver.findElements(By.xpath("(//tbody[@id='MCU-MCU_gridCostUp_data']//tr//td[2])"));
	for (WebElement Location_1 :Location_Mass_Cost_Update1) {
		String Location2 = Location_1.getText();
		if(Location2.equals(FieldInput_name1)) {
			System.out.println("Matched ||DS grid allows Filter functionality|| Expected Grid Value was : " + Location2
					+ "  || Actual Grid Value was : " + FieldInput_name1);
			Extent_pass(driver, "Matched ||DS grid allows Filter functionality|| Expected Grid Value was : "
					+ Location2 + "  || Actual Grid Value was : " + FieldInput_name1,
					test,test1);
		} else {
			System.out.println(
					"Not Matched || DS grid not allows Filter functionality|| Expected Grid Value was : " + Location2
							+ "  || Actual Grid Value was : " + FieldInput_name1);
			Extent_fail2(driver, "Not Matched || DS grid not allows Filter functionality|| Expected Grid Value was : "
					+ Location2 + "  || Actual Grid Value was : " + FieldInput_name1,
					test);

		}
	}
				
			
	clear(driver, Textfield2);
	
	
	Extent_cal(test, "Grid3");
	
	Fluentwait(driver, Grid_Textbox3_1);
	click(driver, Grid_Textbox3_1);
	
	
	sendKeys(driver, Grid_Textbox3_1, FieldInput_name2);
	
	


	wait(driver, "3");


List<WebElement> Location_Mass_Cost_Update2 = driver.findElements(By.xpath("(//tbody[@id='MCU-MCU_gridCostUp_data']//tr//td[3])"));
for (WebElement Location_2 :Location_Mass_Cost_Update2) {
	String Location3 = Location_2.getText();
	if(Location3.equals(FieldInput_name2)) {
		System.out.println("Matched ||DS grid allows Filter functionality|| Expected Grid Value was : " + Location3
				+ "  || Actual Grid Value was : " + FieldInput_name2);
		Extent_pass(driver, "Matched ||DS grid not allows Filter functionality|| Expected Grid Value was : "
				+ Location3 + "  || Actual Grid Value was : " + FieldInput_name2,
				test,test1);
	} else {
		System.out.println(
				"Not Matched || DS grid not allows Filter functionality|| Expected Grid Value was : " + Location3
						+ "  || Actual Grid Value was : " + FieldInput_name2);
		Extent_fail2(driver, "Not Matched || DS grid not allows Filter functionality|| Expected Grid Value was : "
				+ Location3 + "  || Actual Grid Value was : " + FieldInput_name2,
				test);

	}
}
			
		
clear(driver, Grid_Textbox3_1);
	

	
Extent_cal(test, "Grid4");

wait(driver, "3");


Fluentwait(driver, Grid_Textbox4_1);
click(driver, Grid_Textbox4_1);


sendKeys(driver, Grid_Textbox4_1, FieldInput_name3);




wait(driver, "3");


List<WebElement> Location_Mass_Cost_Update3 = driver.findElements(By.xpath("(//tbody[@id='MCU-MCU_gridCostUp_data']//tr//td[4])"));
for (WebElement Location_3 :Location_Mass_Cost_Update3) {
String Location4 = Location_3.getText();
if(Location4.equals(FieldInput_name3)) {
	System.out.println("Matched ||DS grid allows Filter functionality|| Expected Grid Value was : " + Location4
			+ "  || Actual Grid Value was : " + FieldInput_name3);
	Extent_pass(driver, "Matched ||DS grid allows Filter functionality|| Expected Grid Value was : "
			+ Location4 + "  || Actual Grid Value was : " + FieldInput_name3,
			test,test1);
} else {
	System.out.println(
			"Not Matched || DS grid not allows Filter functionality|| Expected Grid Value was : " + Location4
					+ "  || Actual Grid Value was : " + FieldInput_name3);
	Extent_fail2(driver, "Not Matched || DS grid not allows Filter functionality|| Expected Grid Value was : "
			+ Location4 + "  || Actual Grid Value was : " + FieldInput_name3,
			test);

}
}
		

clear(driver, Grid_Textbox4_1);

	
		
Extent_cal(test, "Grid5");

wait(driver, "3");


Fluentwait(driver, Grid_Textbox5);
click(driver, Grid_Textbox5);


sendKeys(driver, Grid_Textbox5, FieldInput_name4);




wait(driver, "3");


List<WebElement> Location_Mass_Cost_Update4 = driver.findElements(By.xpath("(//tbody[@id='MCU-MCU_gridCostUp_data']//tr//td[5])"));
for (WebElement Location_4 :Location_Mass_Cost_Update4) {
String Location5 = Location_4.getText();
if(Location5.equals(FieldInput_name4)) {
	System.out.println("Matched ||DS grid allows Filter functionality|| Expected Grid Value was : " + Location5
			+ "  || Actual Grid Value was : " + FieldInput_name4);
	Extent_pass(driver, "Matched ||DS grid allows Filter functionality|| Expected Grid Value was : "
			+ Location5 + "  || Actual Grid Value was : " + FieldInput_name4,
			test,test1);
} else {
	System.out.println(
			"Not Matched || DS grid not allows Filter functionality|| Expected Grid Value was : " + Location5
					+ "  || Actual Grid Value was : " + FieldInput_name4);
	Extent_fail2(driver, "Not Matched || DS grid not allows Filter functionality|| Expected Grid Value was : "
			+ Location5 + "  || Actual Grid Value was : " + FieldInput_name4,
			test);

}
}
		

clear(driver, Grid_Textbox5);

			
		
Extent_cal(test, "Grid6");

wait(driver, "3");


Fluentwait(driver, Grid_Textbox6);
click(driver, Grid_Textbox6);


sendKeys(driver, Grid_Textbox6, FieldInput_name5);




wait(driver, "5");


List<WebElement> Location_Mass_Cost_Update5 = driver.findElements(By.xpath("(//tbody[@id='MCU-MCU_gridCostUp_data']//tr//td[8])"));
for (WebElement Location_5 :Location_Mass_Cost_Update5) {
String Location6 = Location_5.getText();
if(Location6.equals(FieldInput_name5)) {
	System.out.println("Matched ||DS grid allows Filter functionality|| Expected Grid Value was : " + Location6
			+ "  || Actual Grid Value was : " + FieldInput_name5);
	Extent_pass(driver, "Matched ||DS grid allows Filter functionality|| Expected Grid Value was : "
			+ Location6 + "  || Actual Grid Value was : " + FieldInput_name5,
			test,test1);
} else {
	System.out.println(
			"Not Matched || DS grid not allows Filter functionality|| Expected Grid Value was : " + Location6
					+ "  || Actual Grid Value was : " + FieldInput_name5);
	Extent_fail2(driver, "Not Matched || DS grid not allows Filter functionality|| Expected Grid Value was : "
			+ Location6 + "  || Actual Grid Value was : " + FieldInput_name5,
			test);

}
}
		
	
clear(driver, Grid_Textbox6);

			
			
		
		
	
		
		System.out.println(" ************************Testcase 68 - Completed *************************");

		
		
	}
}
