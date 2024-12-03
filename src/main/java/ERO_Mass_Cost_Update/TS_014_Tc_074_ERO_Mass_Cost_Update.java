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
import java.util.Arrays;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.Utils;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class TS_014_Tc_074_ERO_Mass_Cost_Update extends Keywords {
	public void Scenario014(WebDriver driver, ExtentTest test, ExtentTest test1, String url, int dataset)
			throws AWTException, IOException, InterruptedException {

		System.out.println("url : " + url);

		String Username = Utils.getDataFromTestData("TS_014_Tc_074_ERO_Mass_Cost_Update_Dataset" + dataset,
				"ero_mass_cost_update", "Username");
		String Password = Utils.getDataFromTestData("TS_014_Tc_074_ERO_Mass_Cost_Update_Dataset" + dataset,
				"ero_mass_cost_update", "Password");

		Actions act = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 30);

		navigateUrl(driver, url);

		Fluentwait(driver, Username_input2);
		sendKeys(driver, Username_input2, Username);

		Fluentwait(driver, Password_input2);
		sendKeys(driver, Password_input2, Password);

		Fluentwait(driver, SignIn2);
		click(driver, SignIn2);

		wait(driver, "5");

		if (isDisplayed(driver, session_confirmation2)) {
			Fluentwait(driver, session_confirmation2);
			click(driver, session_confirmation2);
		}

		Fluentwait(driver, Searchbox2);
		sendKeys(driver, Searchbox2, "ERO Mass Cost Update");

		Fluentwait(driver, Select_MassCostUpdate);
		click(driver, Select_MassCostUpdate);

		wait(driver, "3");

		Extent_cal(test, "Testcase 75 - Ensure the tab wise functionality working");

		click(driver, Cancel_Button);

		Fluentwait(driver, NewReport);
		click(driver, NewReport);

		Fluentwait(driver, Click_Confirm);
		click(driver, Click_Confirm);

		wait(driver, "5");

		Fluentwait(driver, Add_Plus_Button);
		click(driver, Add_Plus_Button);

		wait(driver, "3");

		Fluentwait(driver, Select_Loc);
		doubleClick(driver, Select_Loc);

		wait(driver, "3");

		click(driver, ShowButton);

		wait(driver, "3");

		List<WebElement> Location_Mass_Cost_Update = driver
				.findElements(By.xpath("(//tbody[@id='MCU-MCU_gridCostUp_data']//tr//td[1])"));
		List<String> Data1 = new ArrayList<String>();
		for (WebElement Data_1 : Location_Mass_Cost_Update) {
			String Data_loc1 = Data_1.getText();
			Data1.add(Data_loc1);
		}

		//sendKeys(driver, Grid_Textbox1, Location1);

		List<WebElement> Type_Location = driver
				.findElements(By.xpath("(//tbody[@id='MCU-MCU_gridCostUp_data']//tr//td[2])"));
		List<String> Location_Type = new ArrayList<String>();
		for (WebElement Data2 : Type_Location) {
			String Location_Type1 = Data2.getText();
			Location_Type.add(Location_Type1);
		}
		
		boolean flag= true;

		int size = Data1.size();

		for (int i = 0; i < size; i++) {

			String Get_Location = Data1.get(i);

			String Get_LocationType = Location_Type.get(i);

			//clearAndType(driver, Grid_Textbox1, Get_Location);
			
			sendKeys(driver, Grid_Textbox1, Get_Location);
			wait(driver,"3");

			//clearAndType(driver, Textfield2, Get_LocationType);
			sendKeys(driver, Textfield2, Get_LocationType);

			
			if(!isDisplayed(driver, Location2)) {
				
				System.out.println("Grid values are not duplicate : "+Get_Location);
				Extent_pass(driver, "Grid values are not duplicate :"+Get_Location,
						test,test1);
				
			}else {
				flag=false;
				System.out.println("Grid allows duplicate values : "+Get_Location);
				Extent_fail(driver, "Grid allows duplicate values :"+Get_Location,
						test,test1);
			}
			clear(driver, Grid_Textbox1);
			clear(driver, Textfield2);					
		}
		
		
		if(flag==true) {
			System.out.println("Grid values are not duplicate");
		}else {
			
			System.out.println("Grid allows duplicate values");
		}
		
		

	}

}
