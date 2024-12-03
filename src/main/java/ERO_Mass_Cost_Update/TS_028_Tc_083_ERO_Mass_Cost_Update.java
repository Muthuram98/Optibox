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
import java.util.Collections;
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

public class TS_028_Tc_083_ERO_Mass_Cost_Update extends Keywords{
	public void Scenario028(WebDriver driver, ExtentTest test,ExtentTest test1,String url, int dataset) throws AWTException, IOException, InterruptedException {	
	
	System.out.println("url : "+url);
	
	String Username = Utils.getDataFromTestData("TS_010_Tc_069toTc_070_ERO_Mass_Cost_Update_Dataset"+dataset, "ero_mass_cost_update", "Username");
	String Password = Utils.getDataFromTestData("TS_010_Tc_069toTc_070_ERO_Mass_Cost_Update_Dataset"+dataset, "ero_mass_cost_update", "Password");
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
		
		
		wait(driver,"5");
		
		

		Fluentwait(driver, Loc_Search);
		click(driver, Loc_Search);
		wait(driver,"3");

		sendKeys(driver, Loc_Search, "AEAUH");
		
		wait(driver,"2");

		
		doubleClick(driver, Select_Loc1);
		
		wait(driver,"2");

		
		Fluentwait(driver, Add_Plus_Button);
		click(driver, Add_Plus_Button);
		
		
		wait(driver,"5");
		
		
		click(driver, Loc_Search);
        wait(driver,"2");


		sendKeys(driver, Loc_Search, "AUSYD");
		
         wait(driver,"2");

		
		doubleClick(driver, Select_Loc1);
		wait(driver,"2");

		
		wait(driver,"3");
		click(driver, ShowButton);
		
	Extent_cal(test, "Testcase 83 - Ensure Scientific grid allows Filter functionality according to the conditions and inputs (Descending)");
	wait(driver,"3");

	Extent_cal(test, "Filter functionality1");
	
		List<WebElement> Before_Data = driver
				.findElements(By.xpath("(//tbody[@id='MCU-MCU_gridCostUp_data']//tr//td[1])"));
		List<String> BeforeGridData1 = new ArrayList<String>();
		for (WebElement Data1 : Before_Data) {
			String Data_Grid1 = Data1.getText();
			BeforeGridData1.add(Data_Grid1);
			
		}
		
		Collections.sort(BeforeGridData1);


        Collections.sort(BeforeGridData1, Collections.reverseOrder());
		
		wait(driver,"3");

		Fluentwait(driver, LocationFilter);
		click(driver, LocationFilter);
		
		wait(driver,"3");
		click(driver, LocationFilter);

		wait(driver,"3");

		
		List<WebElement> After_Data = driver
				.findElements(By.xpath("(//tbody[@id='MCU-MCU_gridCostUp_data']//tr//td[1])"));
		List<String> After_Grid_Data1 = new ArrayList<String>();
		for (WebElement Data2 : After_Data) {
			String Data_Grid2 = Data2.getText();
			After_Grid_Data1.add(Data_Grid2);
			
		}	
		
		for (int i = 0; i < BeforeGridData1.size(); i++) {

		if (BeforeGridData1.get(i).equals(After_Grid_Data1.get(i))) {
			System.out.println("Matched || Before Sorted Gird value was : " + BeforeGridData1.get(i)
					+ " || After Sorted Gird value was : " + After_Grid_Data1.get(i));
			Extent_pass(driver, "Matched || Before Sorted Gird value was : "
					+ BeforeGridData1.get(i) + "|| After Sorted Gird value was : " + After_Grid_Data1.get(i),
					test,test1);
		} else {
			System.out.println(
					"Not Matched || Before Sorted Gird value was : " + BeforeGridData1.get(i)
							+ "|| After Sorted Gird value was : " + After_Grid_Data1.get(i));
			Extent_fail2(driver, "Not Matched || Before Sorted Gird value was : "
					+ BeforeGridData1.get(i) + "|| After Sorted Gird value was : " + After_Grid_Data1.get(i),
					test);

		}
		
		}
		
		
		Extent_cal(test, "Filter functionality2");
	
		wait(driver,"3");

		
			List<WebElement> Before_Data1 = driver
					.findElements(By.xpath("(//tbody[@id='MCU-MCU_gridCostUp_data']//tr//td[2])"));
			List<String> BeforeGridData11 = new ArrayList<String>();
			for (WebElement Data1 : Before_Data1) {
				String Data_Grid1 = Data1.getText();
				BeforeGridData11.add(Data_Grid1);
				
			}
			
			
			Collections.sort(BeforeGridData11);
			wait(driver,"2");
			
	        Collections.sort(BeforeGridData11, Collections.reverseOrder());

			
			wait(driver,"3");

			Fluentwait(driver, Equ_Type_Filter);
			click(driver, Equ_Type_Filter);
			
			wait(driver,"3");
			
			click(driver, Equ_Type_Filter);
			wait(driver,"3");


			
			List<WebElement> After_Data1 = driver
					.findElements(By.xpath("(//tbody[@id='MCU-MCU_gridCostUp_data']//tr//td[2])"));
			List<String> After_Grid_Data11 = new ArrayList<String>();
			for (WebElement Data2 : After_Data1) {
				String Data_Grid2 = Data2.getText();
				After_Grid_Data11.add(Data_Grid2);
				
			}	
			
			for (int i = 0; i < BeforeGridData11.size(); i++) {

			if (BeforeGridData11.get(i).equals(After_Grid_Data11.get(i))) {
				System.out.println("Matched || Before Sorted Gird value was : " + BeforeGridData11.get(i)
						+ " || After Sorted Gird value was : " + After_Grid_Data11.get(i));
				Extent_pass(driver, "Matched || Before Sorted Gird value was : "
						+ BeforeGridData11.get(i) + "|| After Sorted Gird value was : " + After_Grid_Data11.get(i),
						test,test1);
			} else {
				System.out.println(
						"Not Matched || Before Sorted Gird value was : " + BeforeGridData11.get(i)
								+ "|| After Sorted Gird value was : " + After_Grid_Data11.get(i));
				Extent_fail2(driver, "Not Matched || Before Sorted Gird value was : "
						+ BeforeGridData11.get(i) + "|| After Sorted Gird value was : " + After_Grid_Data11.get(i),
						test);

			}
			
			}	
		
			
			
			Extent_cal(test, "Filter functionality3");
			
			wait(driver,"3");

			
				List<WebElement> Before_Start_DateData1 = driver
						.findElements(By.xpath("(//tbody[@id='MCU-MCU_gridCostUp_data']//tr//td[4])"));
				List<String> Before_Start_Date_GridData1 = new ArrayList<String>();
				for (WebElement Data1 : Before_Start_DateData1) {
					String Start_Date_Data_Grid1 = Data1.getText();
					Before_Start_Date_GridData1.add(Start_Date_Data_Grid1);
					
				}
				
				
				Collections.sort(Before_Start_Date_GridData1);
				wait(driver,"2");
		        Collections.sort(Before_Start_Date_GridData1, Collections.reverseOrder());

				
				wait(driver,"3");

				Fluentwait(driver, Start_Date_Filter);
				click(driver, Start_Date_Filter);
				
				wait(driver,"3");
				click(driver, Start_Date_Filter);

				wait(driver,"3");

				List<WebElement> After_Start_DateData1 = driver
						.findElements(By.xpath("(//tbody[@id='MCU-MCU_gridCostUp_data']//tr//td[4])"));
				List<String> After_StartGrid_Data11 = new ArrayList<String>();
				for (WebElement Data2 : After_Start_DateData1) {
					String Start_Date_Data_Grid = Data2.getText();
					After_StartGrid_Data11.add(Start_Date_Data_Grid);
					
				}	
				
				for (int i = 0; i < Before_Start_Date_GridData1.size(); i++) {

				if (Before_Start_Date_GridData1.get(i).equals(After_StartGrid_Data11.get(i))) {
					System.out.println("Matched || Before Sorted Gird value was : " + Before_Start_Date_GridData1.get(i)
							+ " || After Sorted Gird value was : " + After_StartGrid_Data11.get(i));
					Extent_pass(driver, "Matched || Before Sorted Gird value was : "
							+ Before_Start_Date_GridData1.get(i) + "|| After Sorted Gird value was : " + After_StartGrid_Data11.get(i),
							test,test1);
				} else {
					System.out.println(
							"Not Matched || Before Sorted Gird value was : " + Before_Start_Date_GridData1.get(i)
									+ "|| After Sorted Gird value was : " + After_StartGrid_Data11.get(i));
					Extent_fail2(driver, "Not Matched || Before Sorted Gird value was : "
							+ Before_Start_Date_GridData1.get(i) + "|| After Sorted Gird value was : " + After_StartGrid_Data11.get(i),
							test);

				}
				
				}	
			
			
			
			
			
				Extent_cal(test, "Filter functionality4");
				
				wait(driver,"3");

				
					List<WebElement> STV_Cost_Data1 = driver
							.findElements(By.xpath("(//tbody[@id='MCU-MCU_gridCostUp_data']//tr//td[8])"));
					List<String> Before_STV_Cost_Data1 = new ArrayList<String>();
					for (WebElement STVData1 : STV_Cost_Data1) {
						String STV_Cost_Data = STVData1.getText();
						Before_STV_Cost_Data1.add(STV_Cost_Data);
						
					}
					
					Collections.sort(Before_STV_Cost_Data1);
					wait(driver,"2");			
			        Collections.sort(Before_STV_Cost_Data1, Collections.reverseOrder());

					
					wait(driver,"3");

					Fluentwait(driver, STV_Filter);
					click(driver, STV_Filter);
					
					wait(driver,"3");
					click(driver, STV_Filter);
					wait(driver,"3");

					
					List<WebElement> STV_Cost_Data2 = driver
							.findElements(By.xpath("(//tbody[@id='MCU-MCU_gridCostUp_data']//tr//td[8])"));
					List<String> After_STV_Cost_Data1 = new ArrayList<String>();
					for (WebElement Data2 : STV_Cost_Data2) {
						String STV_Cost_Data = Data2.getText();
						After_STV_Cost_Data1.add(STV_Cost_Data);
						
					}	
					
					for (int i = 0; i < Before_STV_Cost_Data1.size(); i++) {

					if (Before_STV_Cost_Data1.get(i).equals(After_STV_Cost_Data1.get(i))) {
						System.out.println("Matched || Before Sorted Gird value was : " + Before_STV_Cost_Data1.get(i)
								+ " || After Sorted Gird value was : " + After_STV_Cost_Data1.get(i));
						Extent_pass(driver, "Matched || Before Sorted Gird value was : "
								+ Before_STV_Cost_Data1.get(i) + "|| After Sorted Gird value was : " + After_STV_Cost_Data1.get(i),
								test,test1);
					} else {
						System.out.println(
								"Not Matched || Before Sorted Gird value was : " + Before_STV_Cost_Data1.get(i)
										+ "|| After Sorted Gird value was : " + After_STV_Cost_Data1.get(i));
						Extent_fail2(driver, "Not Matched || Before Sorted Gird value was : "
								+ Before_STV_Cost_Data1.get(i) + "|| After Sorted Gird value was : " + After_STV_Cost_Data1.get(i),
								test);

					}
					
					}	
				
		
	
		System.out.println(" ************************Testcase 69 - Completed *************************");

		
		
		
		
		
		
		
		
		
		
		
		
		
	}	

}
