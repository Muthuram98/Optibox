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

public class TS_019_Tc_079_ERO_Deviation_report extends Keywords{
	public void Scenario019(WebDriver driver, ExtentTest test,ExtentTest test1,String url, int dataset) throws AWTException, IOException, InterruptedException {	
	
	System.out.println("url : "+url);
	
	String Username = Utils.getDataFromTestData("TS_019_Tc_079_ERO_Dataset"+dataset, "ERO_Deviation_report", "Username");
	String Password = Utils.getDataFromTestData("TS_019_Tc_079_ERO_Dataset"+dataset, "ERO_Deviation_report", "Password");
	String ID = Utils.getDataFromTestData("TS_019_Tc_079_ERO_Dataset"+dataset, "ERO_Deviation_report", "Id");
	String ID2 = Utils.getDataFromTestData("TS_019_Tc_079_ERO_Dataset"+dataset, "ERO_Deviation_report", "ID_2");
	String EQ_Type = Utils.getDataFromTestData("TS_019_Tc_079_ERO_Dataset"+dataset, "ERO_Deviation_report", "EQU_Type");
	String ColorIndication1 = Utils.getDataFromTestData("TS_019_Tc_079_ERO_Dataset"+dataset, "ERO_Deviation_report", "Color_Indication1");
	String ColorIndication2 = Utils.getDataFromTestData("TS_019_Tc_079_ERO_Dataset"+dataset, "ERO_Deviation_report", "Color_Indication2");






	
	
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
		
wait(driver, "3");
		
		
		
		Extent_cal(test, "Testcase 79 - Ensure the color indication functionality");

		
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
				
				wait(driver,"3");
				
				List<WebElement> rowvalues = driver.findElements(By.xpath("//tbody[@id='ERD-ERD_Version1DGrid_data']//tr"));
				
				int iteration = 1;
				
				for(WebElement row_value : rowvalues){
					
					String row_color = row_value.getCssValue("background-color");
					String hexcolor = rgbToHex(row_color);
					//System.out.println("hexcolor : "+hexcolor);

					
					if(hexcolor.equals(ColorIndication1)) {
						
						String qty1 = driver.findElement(By.xpath("((//tbody[@id='ERD-ERD_Version1DGrid_data']//tr)["+iteration+"]//td)[3]")).getText();
						String cost1 = driver.findElement(By.xpath("((//tbody[@id='ERD-ERD_Version1DGrid_data']//tr)["+iteration+"]//td)[4]")).getText();	
					
						String qty2 = driver.findElement(By.xpath("((//tbody[@id='ERD-ERD_Version2DGrid_data']//tr)["+iteration+"]//td)[3]")).getText();
						String cost2 = driver.findElement(By.xpath("((//tbody[@id='ERD-ERD_Version2DGrid_data']//tr)["+iteration+"]//td)[4]")).getText();	

						if(!qty2.equals(qty1)||!cost2.equals(cost1)) {
							System.out.println("Color Induction Matched");
							Extent_pass(driver, "Color Induction Matched", test, test1);
							
						}else {
							System.out.println("Color Induction Not Matched");
							Extent_fail(driver, "Color Induction Not Matched", test,
									test1);
							
						}
						
						
					}else if(row_color.equals(ColorIndication1)){
						
						
					}
					
					iteration++;
					
				}
				
				wait(driver,"5");

				
List<WebElement> rowvalues1 = driver.findElements(By.xpath("//tbody[@id='ERD-ERD_Version2DGrid_data']//tr"));
				
				int iteration1 = 1;
				
				for(WebElement row_value : rowvalues1){
					
					String row_color1 = row_value.getCssValue("background-color");
					String hexcolor1 = rgbToHex(row_color1);
					
				//	System.out.println("row_color1 : "+row_color1);

					
					if(hexcolor1.equals(ColorIndication2)) {
						
						String qty1_1 = driver.findElement(By.xpath("((//tbody[@id='ERD-ERD_Version1DGrid_data']//tr)["+iteration1+"]//td)[3]")).getText();
						String cost1_1 = driver.findElement(By.xpath("((//tbody[@id='ERD-ERD_Version1DGrid_data']//tr)["+iteration1+"]//td)[4]")).getText();	
					
						String qty2_1 = driver.findElement(By.xpath("((//tbody[@id='ERD-ERD_Version2DGrid_data']//tr)["+iteration1+"]//td)[3]")).getText();
						String cost2_1 = driver.findElement(By.xpath("((//tbody[@id='ERD-ERD_Version2DGrid_data']//tr)["+iteration1+"]//td)[4]")).getText();	

						if(qty2_1.equals(qty1_1)||cost2_1.equals(cost1_1)) {
							System.out.println("Color Induction Matched");
							Extent_pass(driver, "Color Induction Matched", test, test1);
							
						}else {
							System.out.println("Color Induction Not Matched");
							Extent_fail(driver, "Color Induction Not Matched", test,
									test1);
							
						}
						
						
					}else if(row_color1.equals(ColorIndication2)){
						
						
					}
					
					iteration++;
					
				}
					
				
				wait(driver,"5");
				
				
				List<WebElement> Surplus_To_Deficient_Movement = driver.findElements(By.xpath("//tbody[@id='ERD-ERD_Version1DGrid_data']//tr//td[1]"));
				List<String> Surplus_Value1 = new ArrayList<String>();
				for (WebElement Surplus_Location :Surplus_To_Deficient_Movement) {
					String Surplus_Location1 = Surplus_Location.getText();
					Surplus_Value1.add(Surplus_Location1);
				}
				
				List<WebElement> Surplus_To_Deficient_Movement1 = driver.findElements(By.xpath("//tbody[@id='ERD-ERD_Version2DGrid_data']//tr//td[1]"));
				List<String> Surplus_Value2 = new ArrayList<String>();
				for (WebElement Surplus_Location :Surplus_To_Deficient_Movement1) {
					String Surplus_Location1 = Surplus_Location.getText();
					Surplus_Value2.add(Surplus_Location1);
				}	
				
					if(!Surplus_Value2.equals(Surplus_Value1)) {
							System.out.println("Matched || Expected Grid Value was : " + Surplus_Value1
									+ " || Actual Grid Value was : " + Surplus_Value2);
							Extent_pass(driver, "Matched || Expected Grid Value was : "
									+ Surplus_Value1 + " || Actual Grid Value was : " + Surplus_Value2,
									test,test1);
						} else {
							System.out.println(
									"Not Matched || Expected Grid Value was : " + Surplus_Value1
											+ " || Actual Grid Value was : " + Surplus_Value2);
							Extent_fail2(driver, "Not Matched || Expected Grid Value was : "
									+ Surplus_Value1 + " || Actual Grid Value was : " + Surplus_Value2,
									test);

						}
					
					
					
					
				

	}
}
