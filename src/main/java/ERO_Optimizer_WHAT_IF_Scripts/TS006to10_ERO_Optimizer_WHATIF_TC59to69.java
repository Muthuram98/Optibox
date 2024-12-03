package ERO_Optimizer_WHAT_IF_Scripts;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.Utils;

public class TS006to10_ERO_Optimizer_WHATIF_TC59to69 extends Keywords{
	public void Scenario6to10(WebDriver driver, ExtentTest test,ExtentTest test1, String url, int dataset) throws Exception {
		
		System.out.println("url : " + url);
		String Username = Utils.getDataFromTestData("TS006_EroOptimizer_WHAT_IF", "ERO_Optimizer WHAT_IF","Username");
		String Password = Utils.getDataFromTestData("TS006_EroOptimizer_WHAT_IF", "ERO_Optimizer WHAT_IF","Password");
		String ID = Utils.getDataFromTestData("TS006_EroOptimizer_WHAT_IF", "ERO_Optimizer WHAT_IF", "Id");
		String Popup_Message = Utils.getDataFromTestData("TS006_EroOptimizer_WHAT_IF","ERO_Optimizer WHAT_IF", "New_Confirmation_popup");	
		String Popup_Message1 = Utils.getDataFromTestData("TS006_EroOptimizer_WHAT_IF","ERO_Optimizer WHAT_IF", "New_Confirmation_popup1");	
		
		Actions act = new Actions(driver);
		Robot rbt = new Robot();

		navigateUrl(driver, url);
		
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
		sendKeys(driver, Searchbox, "Optimizer WHAT – IF Scenario");

		Fluentwait(driver, SelectOptimizer);
		click(driver, SelectOptimizer);
		wait(driver, "5");
		
		Fluentwait(driver, Optimizer_cancle);
		click(driver, Optimizer_cancle);
		
		Fluentwait(driver, Optimizer_new);
		click(driver, Optimizer_new);
		
		Fluentwait(driver, Optimizer_createnew_confirm);
		click(driver, Optimizer_createnew_confirm);
		
		Extent_cal(test,"Testcase 59 - Ensure while moving the cursor on the tool bar ,system should show the tool tips");

		 for (int i = 1; i <= 14; i++) {

			WebElement button = driver.findElement(By.xpath("((//div[@id='OWS-OWS_toolbar-tblComponent']//button)["+i+"]//span)[1]"));

			wait(driver, "2");

			act.moveToElement(button).build().perform();

			String buttonname = Utils.getDataFromTestData("TS006_EroOptimizer_WHAT_IF","ERO_Optimizer WHAT_IF", "Button" + i);

			WebElement Tooltipfield = driver.findElement(By.xpath("(//div[@id='OWS-OWS_toolbar-tblComponent']//button)["+ i +"]//span[contains(text(),'" + buttonname + "')]"));

			if (isDisplayed1(driver, Tooltipfield)) {

				Extent_pass(driver, "Tool tip for " + buttonname + " is displayed", test,test1);

				getTextofWebelement(driver, Tooltipfield, "Tool tip");
			
			} else {

				Extent_fail(driver, "Tool tip for " + buttonname + " is not displayed", test,test1);
			}

//			wait(driver, "3");

		}

		System.out.println("**********Testcase 59 completed******************");

		Extent_cal(test, "Testcase 62 - Ensure Confirmation pop up window having proper messages with icon(?)");

		Fluentwait(driver, Optimizer_cancle);
		click(driver, Optimizer_cancle);
		
		Fluentwait(driver, Optimizer_new);
		click(driver, Optimizer_new);
		
		Fluentwait(driver, Optimizer_createnew_confirm);
		try {
		//	elementScreenShot_new(driver, Optimizer_Question_Icon, "/Expected_screenshot/Elementscreenshot/Questionmark");
			wait(driver, "2");
			elementScreenShot_new(driver, Optimizer_Question_Icon, "/Actual_screenshot/Elementscreenshot/Questionmark");
			wait(driver, "2");
			imageComparison2(driver, "/Elementscreenshot/Questionmark", "/Elementscreenshot/Questionmark");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Extent_fail(driver, e.getLocalizedMessage(), test,test1);
		}

		String Confirmationpopup_text = getText(driver, Optimizer_createnew_confirm_message);

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

		Fluentwait(driver, Optimizer_createnew_confirm);
		click(driver, Optimizer_createnew_confirm);

		System.out.println("******************Testcase 62 Completed ***********************");

		
		Extent_cal(test, "Testcase 66 - Ensure System allows to paste the copied data in Grid Itself");

		

		click(driver, Optimizer_Globalserach);

		Fluentwait(driver, Globalserach_IDInput);
		sendKeys(driver, Globalserach_IDInput, ID);

		wait(driver, "2");

		Fluentwait(driver, Click_Search);
		click(driver, Click_Search);

		wait(driver, "5");

		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);
		
		wait(driver,"7");
		
		Fluentwait(driver, surplus_location);
		click(driver, surplus_location);
		

		Fluentwait(driver, OPtimizer_Filter_Location);
		click(driver, OPtimizer_Filter_Location);
		
		Fluentwait(driver, OPtimizer_location3);
		click(driver, OPtimizer_location3);

//		rbt.keyPress(KeyEvent.VK_CONTROL);
//		rbt.delay(500);
//		rbt.keyPress(KeyEvent.VK_C);
		act.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();
		
		
		Fluentwait(driver, OPtimizer_location3);
//		click(driver, Location3);

		String locationname = getText(driver, OPtimizer_location3);

		wait(driver, "2");

//		rbt.keyPress(KeyEvent.VK_CONTROL);
//		rbt.delay(500);
//		rbt.keyPress(KeyEvent.VK_V);
//		rbt.delay(500);
//		rbt.keyRelease(KeyEvent.VK_V);
//		rbt.delay(500);
//		rbt.keyRelease(KeyEvent.VK_CONTROL);
		
		act.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();

		wait(driver, "2");

		Fluentwait(driver, OPtimizer_location3);
		click(driver, OPtimizer_location3);

		String locationname2 = getText(driver, OPtimizer_location3);

		if (locationname2.equals(locationname)) {

			System.out.println("System not allow to paste the copied data in the grid");
			Extent_pass(driver, "System not allow to paste the copied data in the grid", test,test1);

		} else {

			System.out.println("System allowed to paste the copied data in the grid");
			Extent_fail(driver, "System allowed to paste the copied data in the grid", test,test1);
		}

		System.out.println(" ************************Testcase 66 - Completed *************************");
		
		Extent_cal(test, "Testcase 63 - Ensure Warning pop up window having proper messages with icon(!)");	
		
		wait(driver, "7");
		Fluentwait(driver, Refresh_result);
		click(driver, Refresh_result);
		try {
		//	elementScreenShot_new(driver, warning_sym, "/Expected_screenshot/Elementscreenshot/exclamationmark");
			wait(driver, "2");
			elementScreenShot_new(driver, warning_sym, "/Actual_screenshot/Elementscreenshot/exclamationmark");
			wait(driver, "2");
			imageComparison2(driver, "/Elementscreenshot/exclamationmark", "/Elementscreenshot/exclamationmark");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Extent_fail(driver, e.getLocalizedMessage(), test,test1);
		}

		String Confirmationpopup_text1 = getText(driver, warning_sym_text);

		if (Confirmationpopup_text1.equals(Popup_Message1)) {
			Extent_pass(driver, "Confirmation popup message having proper message with icon(?)", test,test1);
			System.out.println("Matched || Expected confirmation popup message of creating new was : " + Popup_Message1
					+ " Actual confirmation popup message of creating new was : " + Confirmationpopup_text1);
			Extent_pass(driver,
					"Matched || Expected confirmation popup message of creating new was : " + Popup_Message1
							+ " Actual confirmation popup message of creating new was : " + Confirmationpopup_text1,
					test,test1);
		} else {
			System.out
					.println("Not Matched || Expected confirmation popup message of creating new was : " + Popup_Message1
							+ " Actual confirmation popup message of creating new was : " + Confirmationpopup_text1);
			Extent_fail(driver,
					"Not Matched || Expected confirmation popup message of creating new was : " + Popup_Message1
							+ " Actual confirmation popup message of creating new was : " + Confirmationpopup_text1,
					test,test1);

		}

		Fluentwait(driver, warning_sym_ok);
		click(driver, warning_sym_ok);
		
		System.out.println(" ************************Testcase 63 - Completed *************************");
		
		Extent_cal(test, "Testcase 67 - Ensure DS grid allows Filter functionality");

		Fluentwait(driver, Optimizermain_Tree_table);
		click(driver, Optimizermain_Tree_table);

		Fluentwait(driver, Optimizer_Condition_filter);
		click(driver, Optimizer_Condition_filter);

		Fluentwait(driver, Optimizer_filter_input);

		String locatio1 = getText(driver, OPtimizer_location3);

		sendKeys(driver, Optimizer_filter_input, locatio1);

		WebElement last_location = driver.findElement(By.xpath("(//div[@ref='eBodyViewport']//div[@col-id='origin'])[1]"));

		String lastlocation = last_location.getText();

		if (lastlocation.equals(locatio1)) {

			System.out.println("DS grid filter is working fine");
			Extent_pass(driver, "DS grid filter is working fine", test,test1);

		} else {

			System.out.println("DS grid filter is not working fine");
			Extent_fail(driver, "DS grid filter is not working fine", test,test1);
		}
		
		act.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
		wait(driver, "2");
		act.sendKeys(Keys.BACK_SPACE).perform();
		

		System.out.println(" ************************Testcase 67 - Completed *************************");

		Extent_cal(test,"Testcase 68 - Ensure Scientific grid allows Filter functionality according to the conditions and inputs");


		Fluentwait(driver, Optimizer_cancle);
		click(driver, Optimizer_cancle);
		
		Fluentwait(driver, Optimizer_new);
		click(driver, Optimizer_new);
		
		Fluentwait(driver, Optimizer_createnew_confirm);
		click(driver, Optimizer_createnew_confirm);
		
		wait(driver,"3");
		
		click(driver, Optimizer_Globalserach);

		Fluentwait(driver, Globalserach_IDInput);
		sendKeys(driver, Globalserach_IDInput, ID);

		wait(driver, "2");

		Fluentwait(driver, Click_Search);
		click(driver, Click_Search);

		wait(driver, "5");

		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);
		
		wait(driver,"7");
		
		Fluentwait(driver, surplus_location);
		click(driver, surplus_location);

		Fluentwait(driver, OPtimizer_Filter_Location);
		click(driver, OPtimizer_Filter_Location);
		wait(driver,"4");
       
        Fluentwait(driver, Optimizer_Filteroption1);
		String Option1 = getText(driver, Optimizer_Filteroption1);
		System.out.println("Option1 :"+Option1);
		wait(driver,"2");
		
//		String Option2 = getText(driver, Optimizer_Filteroption2);
//		System.out.println("Option2 :"+Option2);
//		
		//WebElement location1 = driver.findElement(By.xpath("//div[@col-id='origin' and text()='" + Option2 + "']"));

		
		Fluentwait(driver, Optimizer_Search_input);
		sendKeys(driver, Optimizer_Search_input, Option1);

		wait(driver, "2");

		enter(driver);

		wait(driver, "2");
		List<WebElement> filteredCells=driver.findElements(By.xpath("(//div[@ref='eBodyViewport']//div[@col-id='origin'])"));
		
		boolean filter=true;
		for(WebElement filtercell:filteredCells) {
			String celltext=filtercell.getText();
			if(!celltext.equalsIgnoreCase(Option1)) {
				filter=false;
				break;
			}
		}
		
		if(filter==true) {
			System.out.println("Grid Filter is working fine and the given filter value was : " + Option1);
			Extent_pass(driver, "Grid Filter is working fine and the given filter value was : " + Option1, test,test1);
		}else {
			System.out.println("Grid Filter is not working and the given filter value was : " + Option1);
			Extent_fail(driver, "Grid Filter is not working and the given filter value was : " + Option1, test,test1);
		}
		
		wait(driver, "5");

		act.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
		wait(driver, "2");
		act.sendKeys(Keys.BACK_SPACE).perform();

		wait(driver, "5");
		Fluentwait(driver, Selectall);
		click(driver, Selectall);

		Fluentwait(driver, Optimizer_filter_menu);
		click(driver, Optimizer_filter_menu);

		wait(driver, "5");

		System.out.println("******************Testcase 68 Completed ***********************");
		
		Extent_cal(test, "Testcase 69 - Ensure Scientific grid allows to paste the copied record in grid itself");

		Fluentwait(driver, OPtimizer_location3);
		click(driver, OPtimizer_location3);

//		rbt.keyPress(KeyEvent.VK_CONTROL);
//		rbt.delay(500);
//		rbt.keyPress(KeyEvent.VK_C);
		
		act.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();

		Fluentwait(driver, Optmizer_Location_filter);
		click(driver, Optmizer_Location_filter);

//		Fluentwait(driver, filterMenu);
//		click(driver, filterMenu);

		Fluentwait(driver, Optimizer_Search_input);
		click(driver, Optimizer_Search_input);

		wait(driver, "2");

//		rbt.keyPress(KeyEvent.VK_CONTROL);
//		rbt.delay(500);
//		rbt.keyPress(KeyEvent.VK_V);
//		rbt.delay(500);
//		rbt.keyRelease(KeyEvent.VK_V);
//		rbt.delay(500);
//		rbt.keyRelease(KeyEvent.VK_CONTROL);
		
		act.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();

		wait(driver, "2");

		try {
			String inputvalue = getText(driver, Optimizer_Search_input);

			System.out.println("inputvalue : " + inputvalue);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (!isDisplayed(driver, Selectall)) {

			System.out.println("Grid filter accept to paste the copied data");
			Extent_pass(driver, "Grid filter accept to paste the copied data", test,test1);

		} else {

			System.out.println("Grid filter not accept to paste the copied data");
			Extent_fail(driver, "Grid filter not accept to paste the copied data", test,test1);
			
		}
		
		act.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
		wait(driver, "2");
		act.sendKeys(Keys.BACK_SPACE).perform();

		System.out.println(" ************************Testcase 69 - Completed *************************");


		
		
	}

}
