package MapView;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentTest;

import ch.qos.logback.core.joran.action.Action;
import commonMethods.Keywords;
import commonMethods.Utils;

public class TS06to10MapViewTC59to67 extends Keywords{
	public void Scenario06(WebDriver driver, ExtentTest test,ExtentTest test1, String url, int dataset) throws Exception {
		System.out.println("url : " + url);
		String Username = Utils.getDataFromTestData("TS06_Map_View_Dataset"+dataset, "Map view","Username");
		String Password = Utils.getDataFromTestData("TS06_Map_View_Dataset"+dataset, "Map view","Password");
		String ID = Utils.getDataFromTestData("TS06_Map_View_Dataset"+dataset, "Map view", "Id");	
		String Popup_Message = Utils.getDataFromTestData("TS06_Map_View_Dataset"+dataset,"Map view", "New_Confirmation_popup");	

		navigateUrl(driver, url);
        Actions act=new Actions(driver);
        
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

		Fluentwait(driver, Searchbox);
		sendKeys(driver, Searchbox, "Map View");

		Fluentwait(driver, Select_mapview);
		click(driver, Select_mapview);
		
		Fluentwait(driver, MapView_cancel);
		click(driver, MapView_cancel);
	
		Fluentwait(driver, MapView_new);
		click(driver, MapView_new);

		Fluentwait(driver, MapView_createnew_confirm);
		click(driver, MapView_createnew_confirm);

		wait(driver, "3");
		
		Extent_cal(test,"Testcase 59 - Ensure while moving the cursor on the tool bar ,system should show the tool tips");
		
		for(int i=1;i<=14;i++) {
			
			WebElement button=driver.findElement(By.xpath("((//div[@id='MAV-MAV_toolBar-tblComponent']//button)[1]//span)[1]"));
			wait(driver,"2");
		  act.moveToElement(button).build().perform();
		  String buttonname = Utils.getDataFromTestData("TS06_Map_View","Map view","Button"+ i);
		  WebElement Tooltipfield = driver.findElement(By.xpath("(//div[@id='MAV-MAV_toolBar-tblComponent']//button)["+i+"]//span[contains(text(),'"+buttonname+"')]"));
		  if (isDisplayed1(driver, Tooltipfield)) {

				Extent_pass(driver, "Tool tip for " + buttonname + " is displayed", test,test1);

				getTextofWebelement(driver, Tooltipfield, "Tool tip");
			
			} else {

				Extent_fail(driver, "Tool tip for " + buttonname + " is not displayed", test,test1);
			}

			wait(driver, "3");

		}

		System.out.println("**********Testcase 59 completed******************");

		Extent_cal(test, "Testcase 62 - Ensure Confirmation pop up window having proper messages with icon(?)");

		Fluentwait(driver, MapView_cancel);
		click(driver, MapView_cancel);
		
		Fluentwait(driver, MapView_new);
		click(driver, MapView_new);
		
		Fluentwait(driver, MapView_createnew_confirm);
		try {
			//elementScreenShot_new(driver, MapView_Question_Icon, "/Expected_screenshot/Elementscreenshot/Questionmark");
			wait(driver, "2");
			elementScreenShot_new(driver, MapView_Question_Icon, "/Actual_screenshot/Elementscreenshot/Questionmark");
			wait(driver, "2");
			imageComparison2(driver, "/Elementscreenshot/Questionmark", "/Elementscreenshot/Questionmark");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Extent_fail(driver, e.getLocalizedMessage(), test,test1);
		}

		String Confirmationpopup_text = getText(driver, MapView_createnew_confirm_message);

		if (Confirmationpopup_text.equals(Popup_Message)) {
			Extent_pass(driver, "Confirmation popup message having proper message with icon(?)", test,test1);
			System.out.println("Matched || Expected confirmation popup message of creating new was : " + Popup_Message
					+ " Actual confirmation popup message of creating new was : " + Confirmationpopup_text);
			Extent_pass(driver,
					"Matched || Expected confirmation popup message of creating new was : " + Popup_Message
							+ " Actual confirmation popup message of creating new was : " + Confirmationpopup_text,
					test,test1);
		} else {
			System.out
					.println("Not Matched || Expected confirmation popup message of creating new was : " + Popup_Message
							+ " Actual confirmation popup message of creating new was : " + Confirmationpopup_text);
			Extent_fail(driver,
					"Not Matched || Expected confirmation popup message of creating new was : " + Popup_Message
							+ " Actual confirmation popup message of creating new was : " + Confirmationpopup_text,
					test,test1);

		}

		Fluentwait(driver, MapView_createnew_confirm);
		click(driver, MapView_createnew_confirm);

		System.out.println("******************Testcase 62 Completed ***********************");
		
		
		
		
		
		
		
		
		
		}
}
