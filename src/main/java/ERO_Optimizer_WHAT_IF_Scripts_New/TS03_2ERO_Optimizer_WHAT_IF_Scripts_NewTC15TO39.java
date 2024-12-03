package ERO_Optimizer_WHAT_IF_Scripts_New;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.Utils;

public class TS03_2ERO_Optimizer_WHAT_IF_Scripts_NewTC15TO39 extends Keywords {
	
	public void Scenario03(WebDriver driver, ExtentTest test, ExtentTest test1, String url, int dataset)
			throws AWTException, IOException {
		System.out.println("url : " + url);
		String Username = Utils.getDataFromTestData("TS03_EroOptimizer_WHAT_IF_new_Dataset"+dataset, "ERO_Optimizer WHAT_IF",
				"Username");
		String Password = Utils.getDataFromTestData("TS03_EroOptimizer_WHAT_IF_new_Dataset"+dataset, "ERO_Optimizer WHAT_IF",
				"Password");
		String ID = Utils.getDataFromTestData("TS03_EroOptimizer_WHAT_IF_new_Dataset"+dataset, "ERO_Optimizer WHAT_IF", "Id");
		String Expected_Version_Xposition = Utils.getDataFromTestData("TS03_EroOptimizer_WHAT_IF_new_Dataset"+dataset,
				"ERO_Optimizer WHAT_IF", "Version_Xposition");
		String Expected_Version_Yposition = Utils.getDataFromTestData("TS03_EroOptimizer_WHAT_IF_new_Dataset"+dataset,
				"ERO_Optimizer WHAT_IF", "Version_Yposition");

		navigateUrl(driver, url);
		Robot rbt = new Robot();
		Actions action = new Actions(driver);

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

		Extent_cal(test, "Testcase 3.24 -When click ALT+C System should not allow to copy the selected data");

		Fluentwait(driver, Optimizer_Globalserach);
		click(driver, Optimizer_Globalserach);

		Fluentwait(driver, Globalserach_IDInput);
		sendKeys(driver, Globalserach_IDInput, ID);

		wait(driver, "2");

		Fluentwait(driver, Click_Search);
		click(driver, Click_Search);

		wait(driver, "5");

		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);
		wait(driver, "5");

		Fluentwait(driver, Optimizer_Grid_locationfield1);
		click(driver, Optimizer_Grid_locationfield1);

		wait(driver, "3");

		action.keyDown(Keys.ALT).sendKeys("c").keyUp(Keys.ALT).perform();

		wait(driver, "5");

		String copiedtext = getcopiedText(driver);

		System.out.println("copiedtext : " + copiedtext);

		if (copiedtext.isEmpty()) {
			Extent_pass(driver, "Shortcut key for Copy button(ALT+c) is functioning and  not copy  the last activity",
					test, test1);
		} else {
			Extent_fail(driver, "Shortcut key for Copy button(ALT+c) is functioning and  copy  the last activity", test,
					test1);
		}

		System.out.println("************Testcase 3.24*************");

		Extent_cal(test, "Testcase 3.25 -When click ALT+V System should not  allow to paste the copied data");

		Fluentwait(driver, Optimizer_cancle);
		click(driver, Optimizer_cancle);
		Fluentwait(driver, Optimizer_new);
		click(driver, Optimizer_new);
		wait(driver, "2");
		Fluentwait(driver, Optimizer_createnew_confirm);
		click(driver, Optimizer_createnew_confirm);

		Fluentwait(driver, Optimizer_Globalserach);
		click(driver, Optimizer_Globalserach);

		Fluentwait(driver, Globalserach_IDInput);
		sendKeys(driver, Globalserach_IDInput, copiedtext);

		action.keyDown(Keys.ALT).sendKeys("v").keyUp(Keys.ALT).perform();

		String paste = getText(driver, Globalserach_IDInput);
		System.out.println("paste :" + paste);

		if (paste.isEmpty()) {
			Extent_pass(driver, "Shortcut key for paste button(ALT+V) is functioning and  not paste  the last activity",
					test, test1);
		} else {
			Extent_fail(driver, "Shortcut key for paste button(ALT+V) is functioning and   paste  the last activity",
					test, test1);
		}

		System.out.println("************Testcase 3.25*************");

		Extent_cal(test, "Testcase 3.17 -Ensure that changed allocated container get updated in optimizer result");

		Fluentwait(driver, Close_global);
		click(driver, Close_global);
		Fluentwait(driver, Optimizer_cancle);
		click(driver, Optimizer_cancle);
		Fluentwait(driver, Optimizer_new);
		click(driver, Optimizer_new);
		wait(driver, "2");
		Fluentwait(driver, Optimizer_createnew_confirm);
		click(driver, Optimizer_createnew_confirm);

		Fluentwait(driver, Optimizer_Globalserach);
		click(driver, Optimizer_Globalserach);

		Fluentwait(driver, Globalserach_IDInput);
		sendKeys(driver, Globalserach_IDInput, ID);

		wait(driver, "2");

		Fluentwait(driver, Click_Search);
		click(driver, Click_Search);

		wait(driver, "5");

		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);
		wait(driver, "8");

		Fluentwait(driver, Optimizer_cancle);
		click(driver, Optimizer_cancle);

		if (IsElementEnabled(driver, Optimizer_new)) {
			System.out.println("After click on cancle button, new option is enabled");
			Extent_pass(driver, "After click on cancle button, new option is enabled", test, test1);

		} else {
			System.out.println("After click on cancle button, new option is not enabled");
			Extent_fail(driver, "After click on cancle button, new option is not enabled", test, test1);
		}

		System.out.println("************Testcase 3.17*************");

		Fluentwait(driver, Optimizer_new);
		click(driver, Optimizer_new);
		wait(driver, "2");
		Fluentwait(driver, Optimizer_createnew_confirm);
		click(driver, Optimizer_createnew_confirm);

		Extent_cal(test, "Testcase 3.18 -Ensure that new option functionality works properly");

		Fluentwait(driver, Optimizer_Globalserach);
		click(driver, Optimizer_Globalserach);

		Fluentwait(driver, Globalserach_IDInput);
		sendKeys(driver, Globalserach_IDInput, ID);

		wait(driver, "2");

		Fluentwait(driver, Click_Search);
		click(driver, Click_Search);

		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);

		wait(driver, "7");

		Fluentwait(driver, Optimizer_cancle);
		click(driver, Optimizer_cancle);
		wait(driver, "2");
		if (!isDisplayed(driver, Optimizer_Allocate_Containers)) {
			System.out.println("After click on cancle button, Data are removed");
			Extent_pass(driver, "After click on cancle button, Data are removed", test, test1);
		} else {
			System.out.println("After click on cancle button, Data are not removed");
			Extent_fail(driver, "After click on cancle button, Data are not  removed", test, test1);
		}
		wait(driver, "2");
		if (IsElementEnabled(driver, Optimizer_surplus_location)) {
			System.out.println("After click on cancle button, Surplus location filed is enabled");
			Extent_pass(driver, "After click on cancle button, Surplus location filed is enabled", test, test1);
		} else {
			System.out.println("After click on cancle button, Surplus location filed is not enabled");
			Extent_fail(driver, "After click on cancle button, Surplus location filed is not enabled", test, test1);
		}
		wait(driver, "2");
		if (IsElementEnabled(driver, Optimizer_surplus_Count)) {
			System.out.println("After click on cancle button, Surplus count filed is enabled");
			Extent_pass(driver, "After click on cancle button, Surplus count filed is enabled", test, test1);
		} else {
			System.out.println("After click on cancle button, Surplus count filed is not enabled");
			Extent_fail(driver, "After click on cancle button, Surplus count filed is not enabled", test, test1);
		}

		wait(driver, "2");
		if (IsElementEnabled(driver, Optimizer_deficit_location)) {
			System.out.println("After click on cancle button, Deficit Location filed is enabled");
			Extent_pass(driver, "After click on cancle button, Deficit Location filed is enabled", test, test1);
		} else {
			System.out.println("After click on cancle button, Deficit Location filed is not enabled");
			Extent_fail(driver, "After click on cancle button, Deficit Location filed is not enabled", test, test1);
		}
		wait(driver, "2");
		if (IsElementEnabled(driver, Optimizer_deficit_Count)) {
			System.out.println("After click on cancle button, Deficit count filed is enabled");
			Extent_pass(driver, "After click on cancle button, Deficit count filed is enabled", test, test1);
		} else {
			System.out.println("After click on cancle button, Deficit count filed is not enabled");
			Extent_fail(driver, "After click on cancle button, Deficit count filed is not enabled", test, test1);
		}
		wait(driver, "2");
		if (IsElementEnabled(driver, Optimizer_result)) {
			System.out.println("After click on cancle button, Optimizer Result filed is enabled");
			Extent_pass(driver, "After click on cancle button, Optimizer Result filed is enabled", test, test1);
		} else {
			System.out.println("After click on cancle button, Optimizer Result filed is not enabled");
			Extent_fail(driver, "After click on cancle button, Optimizer Result filed is not enabled", test, test1);
		}

		wait(driver, "2");
		if (IsElementEnabled(driver, Optimizer_allocate_container)) {
			System.out.println("After click on cancle button, Allocate Containers filed is enabled");
			Extent_pass(driver, "After click on cancle button, Allocate Containers t filed is enabled", test, test1);
		} else {
			System.out.println("After click on cancle button, Allocate Containers  filed is not enabled");
			Extent_fail(driver, "After click on cancle button, Allocate Containers  filed is not enabled", test, test1);
		}
		wait(driver, "2");
		if (IsElementEnabled(driver, Optimizer_size_type)) {
			System.out.println("After click on cancle button,Size Type filed is enabled");
			Extent_pass(driver, "After click on cancle button, Size Type t filed is enabled", test, test1);
		} else {
			System.out.println("After click on cancle button,Size Type filed is not enabled");
			Extent_fail(driver, "After click on cancle button, Size Type filed is not enabled", test, test1);
		}

		wait(driver, "2");
		if (IsElementEnabled(driver, Optimizer_cost_unit)) {
			System.out.println("After click on cancle button, Cost/Unit(in USD) filed is enabled");
			Extent_pass(driver, "After click on cancle button, Cost/Unit(in USD) filed is enabled", test, test1);
		} else {
			System.out.println("After click on cancle button, Cost/Unit(in USD) filed is not enabled");
			Extent_fail(driver, "After click on cancle button, Cost/Unit(in USD) filed is not enabled", test, test1);
		}

		System.out.println("************Testcase 3.18*************");

		Fluentwait(driver, Optimizer_new);
		click(driver, Optimizer_new);
		wait(driver, "2");
		Fluentwait(driver, Optimizer_createnew_confirm);
		click(driver, Optimizer_createnew_confirm);

		Extent_cal(test, "Testcase 3.20 -When click ALT+I system should  not allow to edit the record");

		Fluentwait(driver, Optimizer_Globalserach);
		click(driver, Optimizer_Globalserach);

		Fluentwait(driver, Globalserach_IDInput);
		sendKeys(driver, Globalserach_IDInput, ID);

		wait(driver, "2");

		Fluentwait(driver, Click_Search);
		click(driver, Click_Search);

		wait(driver, "2");
		
		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);
		
		wait(driver, "2");

		Fluentwait(driver, Optimizer_Grid_locationfield1);
		click(driver, Optimizer_Grid_locationfield1);

		String data_val = getText(driver, Optimizer_Grid_locationfield1);
		System.out.println("data_val :" + data_val);

		wait(driver, "2");
		rbt.keyPress(KeyEvent.VK_ALT);
		rbt.delay(500);
		rbt.keyPress(KeyEvent.VK_I);
		rbt.delay(1000);
		rbt.keyRelease(KeyEvent.VK_I);
		rbt.keyRelease(KeyEvent.VK_ALT);
		wait(driver, "2");

		String data_val1 = getText(driver, Optimizer_Grid_locationfield1);
		System.out.println("data_val1 :" + data_val1);
		if (data_val1.equals(data_val)) {
			Extent_pass(driver, "Shortcut key for edit button(ALT+I) is functioning and  not Edit  the last activity",
					test, test1);
		} else {
			Extent_fail(driver, "Shortcut key for edit button(ALT+I) is functioning and  Edit  the last activity", test,
					test1);
		}

		System.out.println("************Testcase 3.20*************");

		Fluentwait(driver, Optimizer_cancle);
		click(driver, Optimizer_cancle);
		Fluentwait(driver, Optimizer_new);
		click(driver, Optimizer_new);
		wait(driver, "2");
		Fluentwait(driver, Optimizer_createnew_confirm);
		click(driver, Optimizer_createnew_confirm);

		Extent_cal(test, "Testcase 3.21 -When click ALT+E system should cancel the last activity");

		wait(driver, "5");

		Fluentwait(driver, Optimizer_Globalserach);
		click(driver, Optimizer_Globalserach);

		Fluentwait(driver, Globalserach_IDInput);
		sendKeys(driver, Globalserach_IDInput, ID);

		wait(driver, "2");

		Fluentwait(driver, Click_Search);
		click(driver, Click_Search);

		wait(driver, "5");

		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);

		wait(driver, "7");

		action.keyDown(Keys.ALT).sendKeys("e").keyUp(Keys.ALT).perform();
		wait(driver, "5");

		if (!IsElementEnabled(driver, first_col)) {

			Extent_pass(driver, "Shortcut key for `Save` button(ALT+E) is functioning and  cancel the last activity",
					test, test1);

		} else {
			Extent_fail(driver,
					"Shortcut key for `Save` button(ALT+E) is functioning and not  cancel the last activity", test,
					test1);
		}

		System.out.println("************Testcase 3.21*************");

		Fluentwait(driver, Optimizer_new);
		click(driver, Optimizer_new);
		wait(driver, "2");
		Fluentwait(driver, Optimizer_createnew_confirm);
		click(driver, Optimizer_createnew_confirm);

		Extent_cal(test, "Testcase 3.22 -When click ALT+H System should Not open Global search window");

		wait(driver, "2");

		action.keyDown(Keys.ALT).sendKeys("h").keyUp(Keys.ALT).perform();
		wait(driver, "5");
		wait(driver, "5");

		if (!IsElementEnabled(driver, Globalserach_IDInput)) {

			Extent_pass(driver, "Shortcut key for (ALT+H) is functioning and  not open global window", test, test1);

		} else {
			Extent_fail(driver, "Shortcut key for (ALT+H) is functioning and open global window", test, test1);
		}
		System.out.println("************Testcase 3.22*************");

		Extent_cal(test, "Testcase 3.23 -When click ALT+D System should not  delete the selected record ");

		Fluentwait(driver, Optimizer_Globalserach);
		click(driver, Optimizer_Globalserach);

		Fluentwait(driver, Globalserach_IDInput);
		sendKeys(driver, Globalserach_IDInput, ID);

		wait(driver, "2");

		Fluentwait(driver, Click_Search);
		click(driver, Click_Search);

		wait(driver, "5");

		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);

		wait(driver, "7");

		Fluentwait(driver, Optimizer_Grid_locationfield1);
		click(driver, Optimizer_Grid_locationfield1);

		String data_val2 = getText(driver, Optimizer_Grid_locationfield1);
		System.out.println("data_val :" + data_val2);

		action.keyDown(Keys.ALT).sendKeys("d").keyUp(Keys.ALT).perform();
		wait(driver, "5");
		String data_val3 = getText(driver, Optimizer_Grid_locationfield1);
		System.out.println("data_val1 :" + data_val3);

		if (data_val3.equals(data_val2)) {
			Extent_pass(driver,
					"Shortcut key for Delete button(ALT+D) is functioning and  not Delete  the last activity", test,
					test1);
		} else {
			Extent_fail(driver, "Shortcut key for Delete button(ALT+D) is functioning and  Delete  the last activity",
					test, test1);
		}
		System.out.println("************Testcase 3.23*************");

		Fluentwait(driver, Optimizer_cancle);
		click(driver, Optimizer_cancle);
		Fluentwait(driver, Optimizer_new);
		click(driver, Optimizer_new);
		wait(driver, "2");
		Fluentwait(driver, Optimizer_createnew_confirm);
		click(driver, Optimizer_createnew_confirm);

		Extent_cal(test,
				"Testcase 3.34 -Ensure while moving the cursor on the tool bar ,system should show the tool tips");

		Fluentwait(driver, Optimizer_Globalserach);
		click(driver, Optimizer_Globalserach);

		Fluentwait(driver, Globalserach_IDInput);
		sendKeys(driver, Globalserach_IDInput, ID);

		wait(driver, "2");

		Fluentwait(driver, Click_Search);
		click(driver, Click_Search);

		wait(driver, "5");

		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);

		wait(driver, "7");

		for (int i = 1; i <= 14; i++) {

			WebElement button = driver
					.findElement(By.xpath("((//div[@id='OWS-OWS_toolbar-tblComponent']//button)[" + i + "]//span)[1]"));

			wait(driver, "2");
			Actions act = new Actions(driver);
			act.moveToElement(button).build().perform();

			String buttonname = Utils.getDataFromTestData("TS03_EroOptimizer_WHAT_IF_new", "ERO_Optimizer WHAT_IF",
					"Button" + i);

			WebElement Tooltipfield = driver.findElement(By.xpath("(//div[@id='OWS-OWS_toolbar-tblComponent']//button)["
					+ i + "]//span[contains(text(),'" + buttonname + "')]"));

			if (isDisplayed1(driver, Tooltipfield)) {

				Extent_pass(driver, "Tool tip for " + buttonname + " is displayed", test, test1);

				getTextofWebelement(driver, Tooltipfield, "Tool tip");

			} else {

				Extent_fail(driver, "Tool tip for " + buttonname + " is not displayed", test, test1);
			}

		}
		System.out.println("************Testcase 3.34*************");
		Fluentwait(driver, Optimizermain_Tree_table);
		click(driver, Optimizermain_Tree_table);

		wait(driver, "5");
		Fluentwait(driver, Optimizer_delete_template);
		click(driver, Optimizer_delete_template);

		Extent_cal(test, "Testcase 3.36-Ensure that save template works properly");

		wait(driver, "2");
		Fluentwait(driver, Optimizermain_Tree_table);
		click(driver, Optimizermain_Tree_table);

		wait(driver, "5");
		Fluentwait(driver, Optimizer_save_template);
		click(driver, Optimizer_save_template);
		wait(driver, "3");
		sendKeys(driver, Optimizer_save_input, "3");

		Fluentwait(driver, Optimizer_save_input_save_option);
		click(driver, Optimizer_save_input_save_option);

		if (isDisplayed(driver, saveTemplate_popup)) {
			System.out.println("Template saved successfully");
			Extent_pass(driver, "Template saved successfully", test, test1);
		} else {
			System.out.println("Template not  saved successfully");
			Extent_fail(driver, "Template not  saved successfully", test, test1);
		}
		System.out.println("************Testcase 3.36*************");

		Extent_cal(test, "Testcase 3.37-Ensure that save as template works properly");

		wait(driver, "5");

		Fluentwait(driver, Optimizermain_Tree_table);
		click(driver, Optimizermain_Tree_table);

		wait(driver, "5");
		Fluentwait(driver, Optimizer_save_As_template);
		click(driver, Optimizer_save_As_template);
		wait(driver, "3");
		sendKeys(driver, Optimizer_save_input, "4");

		Fluentwait(driver, Optimizer_save_input_save_option);
		click(driver, Optimizer_save_input_save_option);

		if (isDisplayed(driver, saveTemplate_popup)) {
			System.out.println("Template saved successfully");
			Extent_pass(driver, "Template saved successfully", test, test1);
		} else {
			System.out.println("Template not  saved successfully");
			Extent_fail(driver, "Template not  saved successfully", test, test1);
		}

		System.out.println("************Testcase 3.37*************");

		Extent_cal(test, "Testcase 3.38-Ensure that delete  template works properly");

		wait(driver, "5");

		Fluentwait(driver, Optimizermain_Tree_table);
		click(driver, Optimizermain_Tree_table);
		wait(driver, "3");
		Fluentwait(driver, Optimizer_delete_template);
		click(driver, Optimizer_delete_template);
		Fluentwait(driver, Optimizer_delete_template_pop);
		click(driver, Optimizer_delete_template_pop);

		if (isDisplayed(driver, saveTemplate_popup)) {
			System.out.println("Template Deleted successfully");
			Extent_pass(driver, "Template Deleted successfully", test, test1);
		} else {
			System.out.println("Template not Deleted successfully");
			Extent_fail(driver, "Template not Deleted successfully", test, test1);
		}

		System.out.println("************Testcase 3.38*************");

		Extent_cal(test, "Testcase 3.39-Ensure that version get displayed in bottom of screen");

		Scrolltilltheelementvisible(driver, Optimizer_Verionfield);

		try {
			WebElement versionfield = driver.findElement(By.xpath("//label[contains(text(),'Version')]"));

			Point location = versionfield.getLocation();

			int xposition = location.getX();

			String actual_version_XPosition = String.valueOf(xposition);

			System.out.println("xposition :" + actual_version_XPosition);

			int yposition = location.getY();

			String actual_version_YPosition = String.valueOf(yposition);

			System.out.println("yposition :" + actual_version_YPosition);

			if (actual_version_XPosition.equals(Expected_Version_Xposition)
					&& actual_version_YPosition.equals(Expected_Version_Yposition)) {

				System.out.println("Version field is placed at the bottom of the left corner of the screen");
				Extent_pass(driver, "Version field is placed at the bottom of the left corner of the screen", test,
						test1);
				Extent_pass(driver, "Expected Version field X position is : " + Expected_Version_Xposition
						+ " || Actual Version field X position is : " + actual_version_XPosition, test, test1);
				Extent_pass(driver, "Expected Version field Y position is : " + Expected_Version_Yposition
						+ " || Actual Version field Y position is : " + actual_version_YPosition, test, test1);

			} else {

				System.out.println("Version field is not placed at the bottom of the left corner of the screen");
				Extent_fail(driver, "Version field is not placed at the bottom of the left corner of the screen", test,
						test1);
				Extent_fail(driver, "Expected Version field X position is : " + Expected_Version_Xposition
						+ " || Actual Version field X position is : " + actual_version_XPosition, test, test1);
				Extent_fail(driver, "Expected Version field Y position is : " + Expected_Version_Yposition
						+ " || Actual Version field Y position is : " + actual_version_YPosition, test, test1);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
		}

		System.out.println("************Testcase 3.39*************");

		Extent_cal(test, "Testcase 3.26-When click ALT+P System should not open the jasper window");

		String data_val4 = getText(driver, Optimizer_Grid_locationfield1);
		System.out.println("data_val4 :" + data_val4);

		action.keyDown(Keys.ALT).sendKeys("p").keyUp(Keys.ALT).perform();
		wait(driver, "5");
		String data_val5 = getText(driver, Optimizer_Grid_locationfield1);
		System.out.println("data_val5 :" + data_val5);

		if (data_val5.equals(data_val4)) {
			Extent_pass(driver,
					"Shortcut key for  jasper window button(ALT+P) is functioning and jasper window  the last activity",
					test, test1);
		} else {
			Extent_fail(driver,
					"Shortcut key for jasper window button(ALT+P) is functioning and  jasper window   the last activity",
					test, test1);
		}

		System.out.println("************Testcase 3.26*************");

		Extent_cal(test, "Testcase 3.27 -When click ALT+M System should not send mail/fax to mentioned ID");

		wait(driver, "5");

		action.keyDown(Keys.ALT).sendKeys("m").keyUp(Keys.ALT).perform();
		wait(driver, "5");

		if (isDisplayed(driver, Optimizer_IDField)) {
			Extent_pass(driver,
					"Shortcut key for  send mail/fax (ALT+M) is functioning and not send mail/fax to mentioned ID",
					test, test1);
		} else {
			Extent_fail(driver,
					"Shortcut key for send mail/fax  button(ALT+M) is functioning and  not send mail/fax to mentioned ID",
					test, test1);
		}

		System.out.println("************Testcase 3.27*************");

		Extent_cal(test, "Testcase 3.28 -When click ALT+O System should  not allow to export the data from Screen");

		wait(driver, "5");

		action.keyDown(Keys.ALT).sendKeys("o").keyUp(Keys.ALT).perform();
		wait(driver, "5");

		Set<String> oldFiles1 = getDirectoryFiles();

		wait(driver, "5");
		String baseFilename = "Optimizer what if -scenario";

		boolean isDownloaded = isNewFileDownloaded(oldFiles1, baseFilename);

		if (!isDownloaded == true) {

			System.out.println(
					"Shortcut key for not export the data(ALT+O) is functioning and not allow to export the data from Screen");
			Extent_pass(driver,
					"Shortcut key for not export the data(ALT+O) is functioning and not allow to export the data from Screen",
					test, test1);

		} else {
			System.out.println(
					"Shortcut key for not export the data(ALT+O) is functioning and allow to export the data from Screen");
			Extent_fail(driver,
					"Shortcut key for not export the data(ALT+O) is functioning and allow to export the data from Screen",
					test, test1);
		}

		System.out.println("************Testcase 3.28*************");

		Extent_cal(test,
				"Testcase 3.29 -When click ALT+F System's control should not  go to the first data of the screen");

		wait(driver, "2");
		scrollUp(driver);
		wait(driver, "2");
		mouseOverAndClick(driver, Optimizer_cancle);
		wait(driver, "2");
		mouseOverAndClick(driver, Optimizer_new);
		wait(driver, "2");
		Fluentwait(driver, Optimizer_createnew_confirm);
		click(driver, Optimizer_createnew_confirm);

		Fluentwait(driver, Optimizer_Globalserach);
		click(driver, Optimizer_Globalserach);

		Fluentwait(driver, Globalserach_IDInput);
		sendKeys(driver, Globalserach_IDInput, ID);

		wait(driver, "2");

		Fluentwait(driver, Click_Search);
		click(driver, Click_Search);

		wait(driver, "5");

		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);

		wait(driver, "7");

		String exp_val = getTextBackgroundColor(driver, Surplus_FirstVal);
		System.out.println("exp_val :" + exp_val);

		action.keyDown(Keys.ALT).sendKeys("f").keyUp(Keys.ALT).perform();
		wait(driver, "5");

		String Act_val = getTextBackgroundColor(driver, Surplus_FirstVal);
		System.out.println("exp_val :" + Act_val);

		if (Act_val.equals(exp_val)) {
			System.out.println(
					"Shortcut key for not  go to the first data (ALT+F) is functioning and not go to the first data from Screen");
			Extent_pass(driver,
					"Shortcut key for not  go to the first data (ALT+F) is functioning and not go to the first data from Screen",
					test, test1);

		} else {
			System.out.println(
					"Shortcut key for not  go to the first data (ALT+F) is functioning and  go to the first data from Screen");
			Extent_fail(driver,
					"Shortcut key for not  go to the first data (ALT+F) is functioning and  go to the first data from Screen",
					test, test1);
		}

		System.out.println("************Testcase 3.29*************");

		Extent_cal(test, "Testcase 3.31 -When click ALT+Z System should not open local search window");

		wait(driver, "2");

		action.keyDown(Keys.ALT).sendKeys("z").keyUp(Keys.ALT).perform();
		wait(driver, "5");

		if (!IsElementEnabled(driver, Optimizer_search)) {
			System.out.println(
					"Shortcut key for not open local search (ALT+Z) is functioning and not open local search ");
			Extent_pass(driver,
					"Shortcut key for not open local search  (ALT+Z) is functioning and not open local search ", test,
					test1);
		} else {
			System.out.println("Shortcut key for not open local search (ALT+Z) is functioning and  open local search ");
			Extent_fail(driver,
					"Shortcut key for not open local search  (ALT+Z) is functioning and  open local search ", test,
					test1);
		}
		System.out.println("************Testcase 3.31*************");

		Extent_cal(test, "Testcase 3.32 -When click ALT+J System should allow to save the record locally");

		wait(driver, "2");
		action.keyDown(Keys.ALT).sendKeys("j").keyUp(Keys.ALT).perform();
		wait(driver, "5");

		if (!IsElementEnabled(driver, Optimizer_save)) {
			System.out.println(
					"Shortcut key for not open local search (ALT+J) is functioning and  not allow to save the record locally ");
			Extent_pass(driver,
					"Shortcut key for not open local search  (ALT+J) is functioning and  not allow to save the record locally ",
					test, test1);
		} else {
			System.out.println(
					"Shortcut key for  open local search (ALT+J) is functioning and  allow to save the record locally ");
			Extent_fail(driver,
					"Shortcut key for  open local search  (ALT+J) is functioning and allow to save the record locally ",
					test, test1);
		}
		System.out.println("************Testcase 3.32*************");
		wait(driver, "2");
		scrollUp(driver);
		wait(driver, "2");
		mouseOverAndClick(driver, Optimizer_cancle);
		wait(driver, "2");
		mouseOverAndClick(driver, Optimizer_new);
		wait(driver, "2");
		Extent_cal(test, "Testcase 3.19 -Ensure that new option functionality works properly when ALT+N");

		wait(driver, "2");
		Fluentwait(driver, Optimizer_createnew_confirm);
		click(driver, Optimizer_createnew_confirm);

		Fluentwait(driver, Optimizer_Globalserach);
		click(driver, Optimizer_Globalserach);

		Fluentwait(driver, Globalserach_IDInput);
		sendKeys(driver, Globalserach_IDInput, ID);

		wait(driver, "2");

		Fluentwait(driver, Click_Search);
		click(driver, Click_Search);

		wait(driver, "5");

		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);

		wait(driver, "7");

		scrollUp(driver);
		wait(driver, "2");
		mouseOverAndClick(driver, Optimizer_cancle);
		wait(driver, "2");

		action.keyDown(Keys.ALT).sendKeys("n").keyUp(Keys.ALT).perform();
		wait(driver, "5");
		Fluentwait(driver, Optimizer_Ys_OPtion);
		click(driver, Optimizer_Ys_OPtion);

		if (!isDisplayed(driver, OPtimizer_SurplusCount)) {
			System.out.println("Shortcut key for new option functionality (ALT+N) is functioning working fine ");
			Extent_pass(driver, "Shortcut key for new option functionality(ALT+N) is functioning working fine", test,
					test1);
		} else {
			System.out.println("Shortcut key for new option functionality (ALT+N) is functioning not working  ");
			Extent_pass(driver, "Shortcut key for new option functionality(ALT+N) is functioning not working ", test,
					test1);
		}

		if (IsElementEnabled(driver, Optimizer_cancle)) {

			System.out.println("After opening Optimizer WHAT IF page , the cancle  button is  enable status");
			Extent_pass(driver, "After opening Optimizer WHAT IF page , the cancle  button is  enable status", test,
					test1);

		} else {

			System.out.println("After opening Optimizer WHAT IF page , the cancle  button is not enable status");
			Extent_fail(driver, "After opening Optimizer WHAT IF page , the cancle  button is not enable status", test,
					test1);
		}
		wait(driver, "2");

		if (IsElementEnabled(driver, Optimizer_Export)) {

			System.out.println("After opening Optimizer WHAT IF page , the Export  button is  enable status");
			Extent_pass(driver, "After opening Optimizer WHAT IF page , the Export  button is  enable status", test,
					test1);

		} else {

			System.out.println("After opening Optimizer WHAT IF page , the Export  button is  not enable status");
			Extent_fail(driver, "After opening Optimizer WHAT IF page , the Export  button is  not enable status", test,
					test1);
		}

		System.out.println("************Testcase 3.19*************");

		Extent_cal(test, "Testcase 3.30 -When click ALT+L  System's control should not go to last data of the screen");
		
		wait(driver, "2");
		Fluentwait(driver, Optimizer_Globalserach);
		click(driver, Optimizer_Globalserach);

		Fluentwait(driver, Globalserach_IDInput);
		sendKeys(driver, Globalserach_IDInput, ID);

		wait(driver, "2");

		Fluentwait(driver, Click_Search);
		click(driver, Click_Search);
		
		wait(driver, "2");

		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);

		wait(driver, "7");
		
		VerticalScrollFull(driver, Scroll_value);
		wait(driver, "2");
		List<WebElement> last = driver.findElements(
				By.xpath("//div[@id='OWS-OWS_treeTable_tbl']//div[@ref='eBodyViewport']//div[@role='row']/div"));

		int val = last.size() - 1;
		WebElement lastCell = last.get(val);
		String Before = lastCell.getText();
		System.out.println("last value :" + Before);
		wait(driver, "2");

		action.keyDown(Keys.ALT).sendKeys("l").keyUp(Keys.ALT).perform();
		wait(driver, "5");

		String After = lastCell.getText();
		System.out.println("After :" + After);
		if (After.equals(Before)) {
			System.out.println(
					"Shortcut key for not  go to the Last data (ALT+L) is functioning and not go to the first data from Screen");
			Extent_pass(driver,
					"Shortcut key for not  go to the Last data (ALT+L) is functioning and not go to the first data from Screen",
					test, test1);

		} else {
			System.out.println(
					"Shortcut key for not  go to the Last data (ALT+L) is functioning and  go to the first data from Screen");
			Extent_fail(driver,
					"Shortcut key for not  go to the Last data (ALT+L) is functioning and  go to the first data from Screen",
					test, test1);
		}

		System.out.println("************Testcase 3.30*************");

		Extent_cal(test, "Testcase 3.35 -Ensure that export excel works properly");

		Set<String> oldFiles = getDirectoryFiles();

		wait(driver, "5");

		Fluentwait(driver, Optimizermain_Tree_table);
		click(driver, Optimizermain_Tree_table);

		wait(driver, "4");
		Fluentwait(driver, Exel_2007);
		click(driver, Exel_2007);

		wait(driver, "7");

		String baseFilename1 = "Optimizer what if -scenario";

		boolean isDownloaded1 = isNewFileDownloaded(oldFiles, baseFilename1);

		if (isDownloaded1 == true) {

			System.out.println("New excel file is downloaded in the downloads folder");
			Extent_pass(driver, "New excel file is downloaded in the downloads folder", test, test1);

		} else {
			System.out.println("New excel file is not downloaded");
			Extent_fail(driver, "New excel file is not downloaded", test, test1);

		}

		System.out.println("************Testcase 3.35*************");

//		Extent_cal(test, "Testcase 3.33 -When click CRTL+F4 System should allow to close the screen ");
//
//		wait(driver, "5");
//
//		rbt.keyPress(KeyEvent.VK_CONTROL);
//		rbt.delay(500);
//		rbt.keyPress(KeyEvent.VK_F4);
//		rbt.delay(1000);
//		rbt.keyRelease(KeyEvent.VK_F4);
//		rbt.keyRelease(KeyEvent.VK_CONTROL);
//
//		wait(driver, "5");
//
//		if (!isDisplayed(driver, FieldDropdown_Inside)) {
//
//			System.out.println("Shortcut key for close the screen is functioning");
//			Extent_pass(driver, "Shortcut key for close the screen is functioning", test, test1);
//
//		} else {
//
//			System.out.println("Shortcut key for close the screen is not functioning");
//			Extent_fail(driver, "Shortcut key for close the screen is not functioning", test, test1);
//		}
//
//		System.out.println("************Testcase 3.33*************");

	}
}
