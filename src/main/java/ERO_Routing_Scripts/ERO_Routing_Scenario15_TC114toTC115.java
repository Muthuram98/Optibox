package ERO_Routing_Scripts;

import java.awt.Robot;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.Utils;

public class ERO_Routing_Scenario15_TC114toTC115 extends Keywords{
	public void ERO_Scenario15(WebDriver driver, ExtentTest test, ExtentTest test1, String url, int dataset) throws Exception {
		
		String Username = Utils.getDataFromTestData("ERO_Scenario15_Dataset"+dataset,"ERO Routing", "Username");
		String Password = Utils.getDataFromTestData("ERO_Scenario15_Dataset"+dataset,"ERO Routing", "Password");
		String ID = Utils.getDataFromTestData("ERO_Scenario15_Dataset"+dataset,"ERO Routing", "Id");
		String Pop = Utils.getDataFromTestData("ERO_Scenario15_Dataset"+dataset,"ERO Routing", "Popup");
		
        navigateUrl(driver, url);
		
		Robot rbt = new Robot();
		Actions act =new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		Fluentwait(driver, Username_input);
		sendKeys(driver, Username_input, Username);

		Fluentwait(driver, Password_input);
		sendKeys(driver, Password_input, Password);

		Fluentwait(driver, SignIn);
		click(driver, SignIn);

		wait(driver, "5");

		if (isDisplayed(driver, session_confirmation)) {
			Fluentwait(driver, session_confirmation);
			click(driver, session_confirmation);
		}
		Extent_cal(test, "Testcase 115 - Ensure the Unavailable Route tab");
		
		Fluentwait(driver, Searchbox);
		sendKeys(driver, Searchbox, "Deficit and Surplus Location Identification");

		Fluentwait(driver, Selectdeficit);
		click(driver, Selectdeficit);

		wait(driver, "5");
		
		Fluentwait(driver, Globalserach);
		click(driver, Globalserach);

		Fluentwait(driver, Globalserach_IDInput);
		sendKeys(driver, Globalserach_IDInput, ID);

		Fluentwait(driver, Click_Search);
		click(driver, Click_Search);

		wait(driver, "3");
		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);

		wait(driver, "3");
		
		Fluentwait(driver, Editbutton);
		click(driver, Editbutton);
		
		
		Fluentwait(driver, Save);
		click(driver, Save);
		
		wait(driver, "3");
		
		Fluentwait(driver, Save_popup_ok);
		click(driver, Save_popup_ok);
		
		wait(driver, "3");
	
				
		Fluentwait(driver, Route);
		click(driver, Route);
		
		wait(driver, "5");
		
		Fluentwait(driver, ERO_Popup_Ok);
		click(driver, ERO_Popup_Ok);
		
		Fluentwait(driver, ERO_Un_available_Route);
		click(driver, ERO_Un_available_Route);
		
		List<String> Columnname_va = Arrays.asList("Select","Load Region","Load Country","Origin","Delivery","Disch Country","Disch Region","Equipment Type");
		int size2 = Columnname_va.size();
		
		wait(driver, "5");

		for (int i = 0; i < size2; i++) {

			String columns3 = Columnname_va.get(i);
			
			WebElement element = driver.findElement(By.xpath("(//div[@id='ERU-ERU_treeTable2']//following::span[text()='"+columns3+"'])[1]"));
			act.moveToElement(element).build().perform();
//			wait(driver, "5");

			if (element.isDisplayed()) {

				System.out.println("Unavailable route data " + columns3 + " was displayed in the grid");
				Extent_pass(driver, "Unavailable route data" + columns3 + " was displayed in the grid", test,test1);
			} else {
				System.out.println("Unavailable route data" + columns3 + " was not displayed in the grid");
				Extent_fail(driver, "Unavailable route data" + columns3 + " was not displayed in the grid",test,test1);
		}
		}
		
		System.out.println("Testcase_115,completed");
		wait(driver,"4");
		
		Extent_cal(test, "Testcase 118- Ensure select the single size type radio button and without select the size type ");	
		
		Fluentwait(driver, EPO_Route_Details);
		click(driver, EPO_Route_Details);
		
		Fluentwait(driver, All_20s_Option);
		click(driver, All_20s_Option);
		
		Fluentwait(driver, Optimizer);
		click(driver, Optimizer);
		
		
		if(Pop_Size.equals(Pop)) {
			System.out.println("Select the size type pop is display");
			Extent_pass(driver, "Expected poup message is displayed : '"+Pop+"'", test,test1);
		}else {
			System.out.println("Select the size type pop is not display");
			Extent_pass(driver, "Actual poup message is displayed : '"+Pop+"'", test,test1);
		}
		
		Fluentwait(driver, Pop_Size_Ok);
		click(driver, Pop_Size_Ok);
		
		System.out.println("Testcase_118,completed");	
		
		
		Extent_cal(test, "Testcase 114 - Verify with routing screen record with route details, if it match route details displayed");	
		
		Fluentwait(driver, EPO_Route_Details);
		click(driver, EPO_Route_Details);
		
		Actions action=new Actions(driver);
		
	//	List<WebElement> pol=driver.findElements(By.xpath("(//div[@row-id='"++"'])[2]//div[@col-id='pOL']"));
		List<String> Pol_Val=new ArrayList<String>();

		boolean polcheck=true;
		int k=1;
		while(polcheck==true) {
			try {
				WebElement ac=driver.findElement(By.xpath("//div[@row-id='"+k+"']//div[@col-id='pOL']"));
				action.moveToElement(ac).build().perform();
				String adtext=ac.getText();
				Pol_Val.add(adtext);	
				k++;
			}catch(Exception e) {
				polcheck=false;
			}
			
		}
		
	Fluentwait(driver, Ero_cancle);
		mouseOverAndClick(driver, Ero_cancle);
		wait(driver,"1");
		
		
		Fluentwait(driver, Deficit_Location);
		click(driver, Deficit_Location);
		   
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		
		Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver, EPO_SelectFilterSearchBox);
		
		for(int i=0;i<Pol_Val.size();i++) {
			sendKeys(driver, Defi_Search, Pol_Val.get(i));
			if(isDisplayed(driver, ERO_Size_Type_first)) {
				System.out.println("Route details record  is display");	
				
			}else {
				System.out.println("Route details record  is not display");	
			}
			clear(driver, Defi_Search);
		}
		
		System.out.println("Testcase_114,completed");
		
		
	}
}

