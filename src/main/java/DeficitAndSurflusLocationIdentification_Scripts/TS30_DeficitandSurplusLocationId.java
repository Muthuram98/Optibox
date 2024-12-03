package DeficitAndSurflusLocationIdentification_Scripts;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.Utils;

public class TS30_DeficitandSurplusLocationId extends Keywords {
	
	public void Scenario30(WebDriver driver, ExtentTest test, ExtentTest test1, String url, int dataset) {

		System.out.println("url : " + url);

		String Username = Utils.getDataFromTestData("TS30_DeficitandSurplusLocationId_Dataset"+dataset, "DeficitandSurplusLocationId",
				"Username");
		String Password = Utils.getDataFromTestData("TS30_DeficitandSurplusLocationId_Dataset"+dataset, "DeficitandSurplusLocationId",
				"Password");
		String ID = Utils.getDataFromTestData("TS30_DeficitandSurplusLocationId_Dataset"+dataset, "DeficitandSurplusLocationId", "Id");
		String save_template_pop = Utils.getDataFromTestData("TS30_DeficitandSurplusLocationId_Dataset"+dataset,
				"DeficitandSurplusLocationId", "Save_popup");
		String delete_template_pop = Utils.getDataFromTestData("TS30_DeficitandSurplusLocationId_Dataset"+dataset,
				"DeficitandSurplusLocationId", "Delete_pop");
		String Templatename = Utils.getDataFromTestData("TS30_DeficitandSurplusLocationId_Dataset"+dataset,
				"DeficitandSurplusLocationId", "Templatename");

		navigateUrl(driver, url);

		Fluentwait(driver, Username_input);
		sendKeys(driver, Username_input, Username);

		Fluentwait(driver, Password_input);
		sendKeys(driver, Password_input, Password);

		Fluentwait(driver, SignIn);
		click(driver, SignIn);

//		wait(driver, "5");
//
//		if (isDisplayed(driver, session_confirmation)) {
//			Fluentwait(driver, session_confirmation);
//			click(driver, session_confirmation);
//		}
//		Extent_cal(test,
//				"Testcase 425 - Ensure while clicking save template button, templated buttons should be in Enable status");
//		Fluentwait(driver, Searchbox);
//		sendKeys(driver, Searchbox, "Deficit and Surplus Location Identification");
//
//		Fluentwait(driver, Selectdeficit);
//		click(driver, Selectdeficit);
//		wait(driver, "2");
//		Fluentwait(driver, Globalserach);
//		click(driver, Globalserach);
//
//		Fluentwait(driver, Globalserach_IDInput);
//		sendKeys(driver, Globalserach_IDInput, ID);
//
//		wait(driver, "2");
//
//		Fluentwait(driver, Click_Search);
//		click(driver, Click_Search);
//
//		wait(driver, "5");
//
//		Fluentwait(driver, SelectID);
//		doubleClick(driver, SelectID);
//
//		wait(driver, "5");
//		
//		Fluentwait(driver, Close_template);
//		click(driver, Close_template);
//		
//		Fluentwait(driver, Tree_table);
//		click(driver, Tree_table);
//
//		wait(driver, "2");
//
//		Fluentwait(driver, SaveTemplate);
//		click(driver, SaveTemplate);
//
//		if (isDisplayed(driver, saveTemplate_screen)) {
//			System.out.println("After click on save template button , template screen is enable");
//			Extent_pass(driver, "After click on save template button , template screen is enable", test, test1);
//
//		} else {
//			System.out.println("After click on save template button , template screen is not enable");
//			Extent_pass(driver, "After click on save template button , template screen is not enable", test, test1);
//
//		}
//		System.out.println("**************425*************");
//
//		Extent_cal(test,
//				"Testcase 426 - Ensure while clicking save template cancle button, templated buttons should be in cancle");
//		
//		wait(driver, "5");
////		Fluentwait(driver, Tree_table);
////		click(driver, Tree_table);
////		
////		wait(driver, "2");
////
////		Fluentwait(driver, SaveTemplate);
////		click(driver, SaveTemplate);
//
//		wait(driver, "2");
//		Fluentwait(driver, SaveTemplateInput);
//		sendKeys(driver, SaveTemplateInput, Templatename);
//		
//		wait(driver, "2");
//		Fluentwait(driver, SaveTemplateCancel);
//		click(driver, SaveTemplateCancel);
//		
//		wait(driver, "5");
//
//		if (!isDisplayed(driver, SaveTemplateInput)) {
//			System.out.println("After click on save template  cancle button , template screen is cancle sucessfully");
//			Extent_pass(driver, "After click on save template  cancle button , template screen is cancle sucessfully",
//					test, test1);
//
//		} else {
//			System.out.println("After click on save template  cancle button , template screen is not cancle");
//			Extent_pass(driver, "After click on save template  cancle button , template screen is not cancle", test,
//					test1);
//
//		}
//
//		System.out.println("**************426*************");
//
//		Extent_cal(test,
//				"Testcase 427 - Ensure while clicking save template save button, templated buttons should be in save");
//
//		Fluentwait(driver, Tree_table);
//		click(driver, Tree_table);
//
//		wait(driver, "2");
//
//		Fluentwait(driver, SaveTemplate);
//		click(driver, SaveTemplate);
//		sendKeys(driver, SaveTemplateInput, Templatename);
//
//		wait(driver, "2");
//
//		Fluentwait(driver, save_template);
//		click(driver, save_template);
//
//		if (isDisplayed(driver, saveTemplate_popup)) {
//			System.out.println("After click on save template , sucessfully template saved");
//			Extent_pass(driver, "After click on save template pop is :" + save_template_pop + " displayed", test,
//					test1);
//
//		} else {
//			System.out.println("After click on save template ,notsaved");
//			Extent_fail(driver, "After click on save template pop is :" + save_template_pop + " not displayed", test,
//					test1);
//			global = "After click on save template ,not saved";
//		}
//		
//		wait(driver, "2");
//
//		System.out.println("**************427*************");
//
//		Extent_cal(test,
//				"Testcase 428 - Ensure while clicking save template delete button, templated buttons should be in delete");
//
//		wait(driver, "4");
//
//		Fluentwait(driver, cancle_saveTemplate);
//		click(driver, cancle_saveTemplate);
//		wait(driver, "2");
//
//		if (isDisplayed(driver, saveTemplate_popup)) {
//			System.out.println("After click on delete template , sucessfully templat deleted");
//			Extent_pass(driver, "After click on delete template pop is :" + delete_template_pop + " displayed", test,
//					test1);
//
//		} else {
//			System.out.println("After click on delete template ,notsaved");
//			Extent_fail(driver, "After click on delete template pop is :" + delete_template_pop + " not displayed",
//					test, test1);
//			global = "After click on delete template ,notsaved";
//		}
//		System.out.println("**************428*************");
//
//		Extent_cal(test,
//				"Testcase 429 - Ensure while clicking save as template button, templated buttons should be in Enable status");
//
//		wait(driver, "5");
//		Fluentwait(driver, Tree_table);
//		click(driver, Tree_table);
//
//		wait(driver, "2");
//
//		Fluentwait(driver, save_template_as);
//		click(driver, save_template_as);
//
//		if (isDisplayed(driver, saveTemplate_screen)) {
//			System.out.println("After click on save as template button , template screen is enable");
//			Extent_pass(driver, "After click on save template button , template screen is enable", test, test1);
//
//		} else {
//			System.out.println("After click on save template button , template screen is not enable");
//			Extent_fail(driver, "After click on save template button , template screen is not enable", test, test1);
//			global = "After click on save template button , template screen is not enable";
//		}
//		
//		wait(driver, "2");
//		Fluentwait(driver, SaveTemplateCancel);
//		click(driver, SaveTemplateCancel);
//
//		System.out.println("**************429*************");
//
//		Extent_cal(test,
//				"Testcase 430- Ensure while clicking save template save button, templated buttons should be in save");
//
//		wait(driver, "5");
//		Fluentwait(driver, Tree_table);
//		click(driver, Tree_table);
//
//		wait(driver, "2");
//
//		Fluentwait(driver, save_template_as);
//		click(driver, save_template_as);
//
//		sendKeys(driver, SaveTemplateInput, Templatename);
//
//		wait(driver, "2");
//
//		Fluentwait(driver, save_template);
//		click(driver, save_template);
//		
//		wait(driver, "5");
//
//		if (isDisplayed(driver, saveTemplate_popup)) {
//			System.out.println("After click on save template , sucessfully template saved");
//			Extent_pass(driver, "After click on save template pop is :" + save_template_pop + " displayed", test,
//					test1);
//
//		} else {
//			System.out.println("After click on save template ,notsaved");
//			Extent_fail(driver, "After click on save template pop is :" + save_template_pop + " not displayed", test,
//					test1);
//			global = "After click on save template ,not saved";
//
//		}
//		System.out.println("**************430*************");
//
//		Extent_cal(test,
//				"Testcase 431- Ensure while provide duplicate value  and click on  save template save button, templated buttons should be in save");
//
//		wait(driver, "5");
//		Fluentwait(driver, Tree_table);
//		click(driver, Tree_table);
//
//		wait(driver, "2");
//
//		Fluentwait(driver, save_template_as);
//		click(driver, save_template_as);
//
//		sendKeys(driver, SaveTemplateInput, Templatename);
//
//		wait(driver, "2");
//
//		Fluentwait(driver, save_template);
////		click(driver, save_template);
//		
//		WebElement save_confirm = driver.findElement(By.xpath("(//input[@value='Save'])[1]"));
//		save_confirm.click();
//		
//		wait(driver, "5");
//		boolean errorAlert = isAlertPresent(driver);
//		
//		if (errorAlert == true) {
//			System.out.println("After provide duplicate value, duplicate value not accept the value sucessfully");
//		} else {
//			System.out.println("After provide duplicate value, duplicate value  accept the value sucessfully");
//		}
//		
//		wait(driver, "2");
//		Fluentwait(driver, SaveTemplateCancel);
//		click(driver, SaveTemplateCancel);
//
//		System.out.println("**************431*************");
//
//		Extent_cal(test, "Testcase 430 Ensure in Import From Excel  window, when click on select the CSV file button");
//		
//		wait(driver, "5");
//		Fluentwait(driver, Tree_table);
//		click(driver, Tree_table);
//
//		wait(driver, "2");
//
//		Set<String> old_Files = getDirectoryFiles();
//
//		wait(driver, "5");
//
//		Fluentwait(driver, Csv_sheet);
//		click(driver, Csv_sheet);
//
//		wait(driver, "10");
//
//		String baseFilenames = "Deficit and Surplus Location Identification";
//
//		boolean isDownloaded = isNewFileDownloaded(old_Files, baseFilenames);
//
//		if (isDownloaded == true) {
//
//			System.out.println("New excel file is downloaded in the downloads folder");
//			Extent_pass(driver, "New excel file is downloaded in the downloads folder", test, test1);
//
//		} else {
//			System.out.println("New excel file is not downloaded");
//			Extent_fail(driver, "New excel file is not downloaded", test, test1);
//			global = "New excel file is not downloaded";
//		}
//		System.out.println("**************430*************");

	}
}