package ERO_Optimizer_reportGate;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.python.antlr.ast.keyword;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.Utils;

public class TS_15toTS020_ReportGate extends Keywords {

	public void Tc031toTc036(WebDriver driver, ExtentTest test, ExtentTest test1, String url, int dataset) throws AWTException {

		String Username = Utils.getDataFromTestData("TS015_ReportGate_Dataset"+dataset, "ReportGate", "Username");
		String Password = Utils.getDataFromTestData("TS015_ReportGate_Dataset"+dataset, "ReportGate", "Password");
		String ID = Utils.getDataFromTestData("TS015_ReportGate_Dataset"+dataset, "ReportGate", "Id");
		
		Actions act = new Actions(driver);
		Robot rbt = new Robot();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
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
		sendKeys(driver, Searchbox, "ERO Optimization Report Gate");
		
		Extent_cal(test, "Testcase 31 - Ensure that while clicking the show button after select a ID a system is allow to display total quantity,agency allocated and balance quantity");
		
		Fluentwait(driver, SelectOptimizer_ERO);
		click(driver, SelectOptimizer_ERO);

		Fluentwait(driver, Optimizer_cancle_Report_Gate);
		click(driver, Optimizer_cancle_Report_Gate);

		Fluentwait(driver, Optimizer_new_ERO);
		click(driver, Optimizer_new_ERO);

		Fluentwait(driver, Optimizer_createnew_confirm_ERO);
		click(driver, Optimizer_createnew_confirm_ERO);

		Fluentwait(driver, Globalserach_ERO);
		click(driver, Globalserach_ERO);

		Fluentwait(driver, Globalserach_IDInput_ERO);
		sendKeys(driver, Globalserach_IDInput_ERO, ID);

		Fluentwait(driver, Click_Search_ERO);
		click(driver, Click_Search_ERO);

		wait(driver, "3");
		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);

		wait(driver, "3");

		click(driver, Show_Button_ERO);

		wait(driver, "3");

		if(isDisplayed(driver, Total_qty)) {
			
			System.out.println("After click on show button, Total quantity field was displayed");
			Extent_pass(driver, "After click on show button, Total quantity field was displayed", test, test1);
		}else {
			
			System.out.println("After click on show button, Total quantity field was not displayed");
			Extent_fail(driver, "After click on show button, Total quantity field was not displayed", test, test1);
		}
		
		
		if(isDisplayed(driver, Agency_allocated)) {
			
			System.out.println("After click on show button, Agency allocated field was displayed");
			Extent_pass(driver, "After click on show button, Agency allocated field was displayed", test, test1);
		}else {
			
			System.out.println("After click on show button, Agency allocated field was not displayed");
			Extent_fail(driver, "After click on show button, Agency allocated field was not displayed", test, test1);
		}
		
		
		if(isDisplayed(driver, Balance_Quantity)) {
			
			System.out.println("After click on show button, Balance quantity field was displayed");
			Extent_pass(driver, "After click on show button, Balance quantity field was displayed", test, test1);
		}else {
			
			System.out.println("After click on show button, Balance quantity field was not displayed");
			Extent_fail(driver, "After click on show button, Balance quantity field was not displayed", test, test1);
		}
		
		System.out.println("Testcase 31 completed");
		
		
		Extent_cal(test, "Testcase 32 - Ensure the total quantity count is shown from detalited view screen in the filed of quantity");
		
		Fluentwait(driver, Detailed_view_ERO);
		click(driver, Detailed_view_ERO);
		
		if(isDisplayed(driver, Detailedview_Quantity)) {
			
			System.out.println("Total quantity count was shown in the detailed view screen");
			Extent_pass(driver, "Total quantity count was shown in the detailed view screen", test, test1);
			
		}else {
			
			System.out.println("Total quantity count was not shown in the detailed view screen");
			Extent_fail(driver, "Total quantity count was not shown in the detailed view screen", test, test1);
		}
		
		System.out.println("Testcase 32 completed");
		
	
		
		Extent_cal(test, "Testcase 34 - Ensure the balance quantity count is shown in detailed view screen in the field of balance quantity");
		
		if(isDisplayed(driver, Grid_Balance_Quantity)) {
			
			System.out.println("Balance quantity count was shown in the detailed view screen");
			Extent_pass(driver, "Balance quantity count was shown in the detailed view screen", test, test1);
			
		}else {
			
			System.out.println("Balance quantity count was not shown in the detailed view screen");
			Extent_fail(driver, "Balance quantity count was not shown in the detailed view screen", test, test1);
		}
		
		System.out.println("Testcase 34 completed");
		
	
		
		Extent_cal(test, "Testcase 33 - Ensure the agency allocated count is shown from detalied view screen in the fileld of planned quantity");
		
		int scrollAmount4 = 1000; 
		
		WebElement scroller4 = driver.findElement(By.xpath("(//div[@id='ORG-ORG_treeOPE']//table)[2]/.."));
		wait.until(ExpectedConditions.elementToBeClickable(scroller4));
		
		js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller4, scrollAmount4);

		wait(driver,"3");
		
		if(isDisplayed(driver, Planned_Quantity)) {
			
			System.out.println("Planned quantity count was shown in the detailed view screen");
			Extent_pass(driver, "Planned quantity count was shown in the detailed view screen", test, test1);
			
		}else {
			
			System.out.println("Planned quantity count was not shown in the detailed view screen");
			Extent_fail(driver, "Planned quantity count was not shown in the detailed view screen", test, test1);
		}
		
		System.out.println("Testcase 33 completed");

		Extent_cal(test, "Testcase 35 - Ensure  the agency allocated is displayed in the AG grid of POL,POD");
		
		Fluentwait(driver, Summary_ERO);
		click(driver, Summary_ERO);
		
		if(isDisplayed(driver, POL)) {
			
			System.out.println("AG Grid was displayed with POL field");
			Extent_pass(driver, "AG Grid was displayed with POL field", test, test1);
		}else {
			System.out.println("AG Grid was not displayed with POL field");
			Extent_fail(driver, "AG Grid was not displayed with POL field", test, test1);
			
		}
		
		if(isDisplayed(driver, POD)) {
			
			System.out.println("AG Grid was displayed with POD field");
			Extent_pass(driver, "AG Grid was displayed with POD field", test, test1);
		}else {
			System.out.println("AG Grid was not displayed with POD field");
			Extent_fail(driver, "AG Grid was not displayed with POD field", test, test1);
		}
		
		System.out.println("Testcase 35 completed");
		
		
		Extent_cal(test, "Testcase 36 - Ensure the AG grid is allow to copy,paste in the filter field");
//		
//		Fluentwait(driver, POL_1);
//		click(driver, POL_1);
//		
//		wait(driver,"2");

//		
//		rbt.keyPress(KeyEvent.VK_CONTROL);
//		rbt.delay(500);
//		rbt.keyPress(KeyEvent.VK_C);
//
//		Fluentwait(driver, POL_1);
//		String polname = getText(driver, POL_1);
//
//		wait(driver, "2");
//
//		rbt.keyPress(KeyEvent.VK_CONTROL);
//		rbt.delay(500);
//		rbt.keyPress(KeyEvent.VK_V);
//		rbt.delay(500);
//		rbt.keyRelease(KeyEvent.VK_V);
//		rbt.delay(500);
//		rbt.keyRelease(KeyEvent.VK_CONTROL);
//
//		wait(driver, "2");
//
//		Fluentwait(driver, POL_2);
//		doubleClick(driver, POL_2);
//
//		String Polname2 = getText(driver, POL_2);
//
//		if (!Polname2.equals(polname)) {
//
//			System.out.println("System not allow to paste the copied data in the grid");
//			Extent_pass(driver, "System not allow to paste the copied data in the grid", test,test1);
//
//		} else {
//
//			System.out.println("System allowed to paste the copied data in the grid");
//			Extent_fail(driver, "System allowed to paste the copied data in the grid", test,test1);
//		}
//		
//		
		
		
		Fluentwait(driver, Tree_table_ERO);
		click(driver, Tree_table_ERO);
		
		Fluentwait(driver, Condition_Filter);
		click(driver, Condition_Filter);
		
		Fluentwait(driver, Grid_locationfield_ERO);
		click(driver, Grid_locationfield_ERO);

		wait(driver, "3");

		rbt.keyPress(KeyEvent.VK_CONTROL);
		rbt.delay(500);
		rbt.keyPress(KeyEvent.VK_C);
		rbt.delay(1000);
		rbt.keyRelease(KeyEvent.VK_C);
		rbt.keyRelease(KeyEvent.VK_CONTROL);

		wait(driver, "5");

		String copiedtext = getcopiedText(driver);

		System.out.println("copiedtext : " + copiedtext);

		String gettext = getText(driver, Grid_locationfield_ERO);
		
		int textlength = gettext.length();
		
		String actualcopied = copiedtext.substring(0, textlength);

		if (actualcopied.equals(gettext)) {

			System.out.println("Selected data was copied || Expected copied value was : " + gettext + " || Actual copied value was : "
					+ actualcopied);
			Extent_pass(driver,
					"Selected data was copied || Expected copied value was : " + gettext + " || Actual copied value was : " + actualcopied,
					test,test1);
		} else {
			System.out.println("Selected data was not copied || Expected copied value was : " + gettext
					+ " || Actual copied value was : " + actualcopied);
			Extent_fail(driver, "Selected data was not copied || Expected copied value was : " + gettext
					+ " || Actual copied value was : " + actualcopied, test,test1);
		}
	
		
		try {

			StringSelection stringSelection = new StringSelection(gettext);
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			clipboard.setContents(stringSelection, null);
			System.out.println("Text copied to clipboard: " + gettext);

		} catch (Exception e) {
			e.printStackTrace();
		}

		Fluentwait(driver,Grid_txt_field_ERO );
		click(driver, Grid_txt_field_ERO);

		wait(driver, "3");
		act.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();
 
		enter(driver);

		wait(driver, "3");
		
		String Pastetext = getText(driver, Grid_locationfield_ERO);

		System.out.println("Pastetext : " + Pastetext);

		if (Pastetext.equals(gettext)) {
			System.out.println(
					"Matched || Expected pasted value was : " + gettext + " || Actual pasted value was : " + Pastetext);
			Extent_pass(driver, "System allowed to paste the copied data by using shortcut key CTRL+V", test,test1);
			Extent_pass(driver,
					"Matched || Expected pasted value was : " + gettext + " || Actual pasted value was : " + Pastetext,
					test,test1);
		} else {
			System.out.println(
					"Not Matched || Expected pasted value was : " + gettext + " || Actual pasted value was : " + Pastetext);
			Extent_fail(driver, "System not allowed to paste the copied data by using shortcut key CTRL+V", test,test1);
			Extent_fail(driver,
					"Not Matched || Expected pasted value was : " + gettext + " || Actual pasted value was : " + Pastetext,
					test,test1);

		}
	
		System.out.println("Testcase 36 completed");
		
		Extent_cal(test, "Testcase 37 - Ensure that while clicking the condition filter a system is allow to filter the data POL,POD,20s,40s,HC and total");

		
		wait(driver, "3");
		act.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
		
		wait(driver, "3");
		act.keyDown(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).keyUp(Keys.CONTROL).build().perform();

		
	}

}
