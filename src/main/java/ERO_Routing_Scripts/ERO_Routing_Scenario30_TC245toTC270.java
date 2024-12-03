package ERO_Routing_Scripts;

import java.awt.Robot;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.Utils;
import net.sourceforge.htmlunit.corejs.javascript.regexp.SubString;

public class ERO_Routing_Scenario30_TC245toTC270 extends Keywords {
	@SuppressWarnings("deprecation")
	public void ERO_Scenario30(WebDriver driver, ExtentTest test, ExtentTest test1, String url, int dataset) throws Exception {

		String Username = Utils.getDataFromTestData("ERO_Scenario30_Dataset"+dataset, "ERO Routing", "Username");
		String Password = Utils.getDataFromTestData("ERO_Scenario30_Dataset"+dataset, "ERO Routing", "Password");
		String ID = Utils.getDataFromTestData("ERO_Scenario30_Dataset"+dataset, "ERO Routing", "Id");
		String Green = Utils.getDataFromTestData("ERO_Scenario30_Dataset"+dataset, "ERO Routing", "green_color");
		String Red = Utils.getDataFromTestData("ERO_Scenario30_Dataset"+dataset, "ERO Routing", "Pink_Color");
		String blue = Utils.getDataFromTestData("ERO_Scenario30_Dataset"+dataset, "ERO Routing", "blue_color");

		String EquimentType_Alphabets = System.getProperty("user.dir") + "\\uploads\\Budget_Flow_Applied.xlsx";

		navigateUrl(driver, url);

		Robot rbt = new Robot();
		Actions act = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;

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
//		wait(driver, "10");
//		
//		Extent_cal(test, "Testcase 248,Ensure the  Surplus Qty field not allow alphabets.");
//
//		Fluentwait(driver, Searchbox);
//		sendKeys(driver, Searchbox, "Deficit and Surplus Location Identification");
//
//		Fluentwait(driver, Selectdeficit);
//		click(driver, Selectdeficit);
//
//		wait(driver, "5");
//
//		Fluentwait(driver, dropdown_option);
//		click(driver, dropdown_option);
//
//		Fluentwait(driver, Budget_Reposition);
//		click(driver, Budget_Reposition);
//
//		Fluentwait(driver, Budget);
//		click(driver, Budget);
//		wait(driver, "4");
//
////		uploadFileRobot(driver, EquimentType_Alphabets);
//		
//		String upload_EquimentType_Alphabets = System.getProperty("user.dir") + "/driver/MasterDownloadfile.exe " + EquimentType_Alphabets;
//
//		try {
//			Runtime.getRuntime().exec(upload_EquimentType_Alphabets);
//		} catch (IOException e) {
//			e.printStackTrace();
//			System.out.println(e.getLocalizedMessage());
//			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
//		}		
//		
//		wait(driver,"10");
//		
//		Fluentwait(driver, Location3);
//		
//		if (isDisplayed(driver, click_yes)) {
//
//			click(driver, click_yes);
//
//			Fluentwait(driver, Click_ok);
//			click(driver, Click_ok);
//		}
//
//		wait(driver, "2");
//		Fluentwait(driver, ERO_Save);
//		click(driver, ERO_Save);
//		Fluentwait(driver, ERO_Save_ok);
//		click(driver, ERO_Save_ok);
//
//		wait(driver, "3");
//
//		WebElement scroller_val = driver.findElement(By.xpath("(//div[@ref='eBodyHorizontalScrollViewport'])[1]"));
//
//		int scrollAmount_val = 2000;
//
//		js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller_val, scrollAmount_val);
//
//		Fluentwait(driver, Defi_Status);
//		click(driver, Defi_Status);
//
//		Fluentwait(driver, EPO_SelectFilterOption);
//		click(driver, EPO_SelectFilterOption);
//
//		Fluentwait(driver, EPO_SelectFilterSearchBox);
//		click(driver, EPO_SelectFilterSearchBox);
//		wait(driver, "1");
//		Fluentwait(driver, Defi_Status_surplus1);
//		click(driver, Defi_Status_surplus1);
//
//		Fluentwait(driver, EPO_SelectFilterOption);
//		click(driver, EPO_SelectFilterOption);
//
//		String Total = getText(driver, Deficit_Total);
//		System.out.println("Total :" + Total);
//
//		String str = Total.substring(0, 2);
//		System.out.println("str :" + str);
//
//		Fluentwait(driver, Route);
//		click(driver, Route);
//		wait(driver, "2");
//
//		Fluentwait(driver, Optimizer);
//		click(driver, Optimizer);
//		wait(driver, "2");
//		Fluentwait(driver, Optimizer_Ok);
//		click(driver, Optimizer_Ok);
//
//		wait(driver, "1");
//		mouseOverAndClick(driver, surplus_qty);
//		wait(driver, "2");
//
//		String surplus = getAttribute(driver, surplus_qty, "value");
//		System.out.println(surplus);
//
//		if (surplus.equals(str)) {
//			System.out.println("Surplus Qty count is equal");
//			Extent_pass(driver, "Expeted Surplus Qty count : " + str + "Acutal Surplus Qty count : " + surplus, test,
//					test1);
//		} else {
//			System.out.println("Surplus Qty count is not equal");
//			Extent_fail2(driver, "Expeted Surplus Qty count : " + str + "Acutal Surplus Qty count : " + surplus, test);
//			global = "Expeted Surplus Qty count :" + str + "Acutal Surplus Qty count : " + surplus;
//		}
//
//		System.out.println("Testcase 248, compleated");
//
//		Fluentwait(driver, Defic_cancle1);
//		mouseOverAndClick(driver, Defic_cancle1);
//
//		Fluentwait(driver, ERO_Optimizer_Close5);
//		click(driver, ERO_Optimizer_Close5);
//
//		Fluentwait(driver, Defi_close);
//		click(driver, Defi_close);
//
//		sendKeys(driver, Searchbox, "Deficit and Surplus Location Identification");
//
//		Fluentwait(driver, Selectdeficit);
//		click(driver, Selectdeficit);
//
//		Fluentwait(driver, Globalserach);
//		click(driver, Globalserach);
//
//		Fluentwait(driver, Globalserach_IDInput);
//		sendKeys(driver, Globalserach_IDInput, ID);
//
//		Fluentwait(driver, Click_Search);
//		click(driver, Click_Search);
//
//		wait(driver, "3");
//		Fluentwait(driver, SelectID);
//		doubleClick(driver, SelectID);
//
//		Fluentwait(driver, Editbutton);
//		click(driver, Editbutton);
//
//		Fluentwait(driver, Save);
//		click(driver, Save);
//
//		wait(driver, "3");
//
//		Fluentwait(driver, Save_popup_ok);
//		click(driver, Save_popup_ok);
//
//		wait(driver, "3");
//
//		WebElement scroller_val1 = driver.findElement(By.xpath("(//div[@ref='eBodyHorizontalScrollViewport'])[1]"));
//
//		int scrollAmount_val1 = 2000;
//
//		js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller_val1, scrollAmount_val1);
//
//		Fluentwait(driver, Defi_Status);
//		click(driver, Defi_Status);
//
//		Fluentwait(driver, EPO_SelectFilterOption);
//		click(driver, EPO_SelectFilterOption);
//
//		Fluentwait(driver, EPO_SelectFilterSearchBox);
//		click(driver, EPO_SelectFilterSearchBox);
//
//		Fluentwait(driver, Defi_Status_surplus1);
//		click(driver, Defi_Status_surplus1);
//
//		Fluentwait(driver, EPO_SelectFilterOption);
//		click(driver, EPO_SelectFilterOption);
//
//		Fluentwait(driver, Route);
//		click(driver, Route);
//		wait(driver, "2");
//		Fluentwait(driver, ERO_Popup_Ok);
//		click(driver, ERO_Popup_Ok);
//
//		Fluentwait(driver, ERO_Total_Count);
//		click(driver, ERO_Total_Count);
//
//		String alpha = getText(driver, ERO_Total_Count);
//		String Allignmenttype = determineType(alpha);
//
//		if (!Allignmenttype.equals("Alphabetic")) {
//			System.out.println("Surplus Qty  field not allow to set alphabets");
//			Extent_pass(driver, "Surplus Qty  field not allow to set alphabets ", test, test1);
//		} else {
//			System.out.println("Surplus Qty  field allow to set alphabets");
//			Extent_fail(driver, "Surplus Qty  field  allow to set alphabets  ", test, test1);
//			global = "Surplus Qty  field  allow to set alphabets ";
//		}
//
//		System.out.println("Testcase 248, completed");
//
//		Extent_cal(test, "Testcase 249,Ensure the  Surplus Qty field not allow alphabets.");
//
//		Fluentwait(driver, ERO_Total_Count);
//		click(driver, ERO_Total_Count);
//
//		String alpha1 = getText(driver, ERO_Total_Count);
//		String Allignmenttype1 = determineType(alpha1);
//
//		if (Allignmenttype1.equals("Numeric")) {
//			System.out.println("Surplus Qty  field not allow the numeric");
//			Extent_pass(driver, "Surplus Qty  field not allow the numeric ", test, test1);
//		} else {
//			System.out.println("Surplus Qty  field  allow the numeric");
//			Extent_fail(driver, "Surplus Qty  field  allow the numeric", test, test1);
//			global = "Surplus Qty  field  allow to the numeric ";
//		}
//		System.out.println(" Testcase 249,compleated");
//
//		Extent_cal(test, "Testcase 250,Ensure the Surplus Qty field not allow   Special character.");
//
//		String alpha2 = getText(driver, ERO_Total_Count);
//
//		String Allignmenttype2 = determineType(alpha2);
//		wait(driver, "2");
//
//		if (!Allignmenttype2.equals("Other")) {
//
//			System.out.println("Surplus Qty  field not allow the special char");
//			Extent_pass(driver, "Surplus Qty  field not allow the special char ", test, test1);
//		} else {
//			System.out.println("Surplus Qty  field  allow the special char");
//			Extent_fail(driver, "Surplus Qty  field  allow the special char", test, test1);	
//			global = "Surplus Qty  field  allow the special char";
//		}
//		System.out.println(" Testcase 250,compleated");
//
//		Fluentwait(driver, Defic_cancle2);
//		click(driver, Defic_cancle2);
//
//		Fluentwait(driver, ERO_Optimizer_Close);
//		click(driver, ERO_Optimizer_Close);
//
//		Extent_cal(test,
//				"Testcase 251,Ensure the “Green” color indicates Surplus Qty in all Equipment Reposition solve screen single equipment type and all size type");
//
//		sendKeys(driver, Searchbox, "Deficit and Surplus Location Identification");
//
//		Fluentwait(driver, Selectdeficit);
//		click(driver, Selectdeficit);
//
//		wait(driver, "5");
//
//		Fluentwait(driver, dropdown_option);
//		click(driver, dropdown_option);
//
//		Fluentwait(driver, Budget_Reposition);
//		click(driver, Budget_Reposition);
//
//		Fluentwait(driver, Budget);
//		click(driver, Budget);
//		wait(driver, "4");
//
////		uploadFileRobot(driver, EquimentType_Alphabets);
//		
//		String upload_EquimentType_Alphabets2 = System.getProperty("user.dir") + "/driver/MasterDownloadfile.exe " + EquimentType_Alphabets;
//
//		try {
//			Runtime.getRuntime().exec(upload_EquimentType_Alphabets2);
//		} catch (IOException e) {
//			e.printStackTrace();
//			System.out.println(e.getLocalizedMessage());
//			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
//		}		
//		
//		wait(driver,"10");
//		
//		Fluentwait(driver, Location3);
//		
//		if (isDisplayed(driver, click_yes)) {
//
//			click(driver, click_yes);
//
//			Fluentwait(driver, Click_ok);
//			click(driver, Click_ok);
//		}
//
//		wait(driver, "2");
//		Fluentwait(driver, ERO_Save);
//		click(driver, ERO_Save);
//		Fluentwait(driver, ERO_Save_ok);
//		click(driver, ERO_Save_ok);
//		Fluentwait(driver, Route);
//		click(driver, Route);
//		wait(driver, "2");
//		Fluentwait(driver, Optimizer);
//		click(driver, Optimizer);
//		wait(driver, "2");
//		Fluentwait(driver, Optimizer_Ok);
//		click(driver, Optimizer_Ok);
//		wait(driver, "1");
//		String color = getTextBackgroundColor(driver, Surplus_Color);
//		System.out.println("background color :" + color);
//		if (color.equals(Green)) {
//
//			System.out.println("surplus Qty green colour is display");
//			Extent_pass(driver, "Expeted Surplus Qty count colour was : " + Green, test, test1);
//		} else {
//			System.out.println("surplus Qty green colour is not  display");
//			Extent_pass(driver, "Expeted Surplus Qty count colour was : " + Green, test, test1);
//			global = "Expeted Surplus Qty count colour was : " + Green;
//		}
//
//		System.out.println(" Testcase 251,compleated");
//		Fluentwait(driver, ERO_Optimizer_Close8);
//		click(driver, ERO_Optimizer_Close8);
//
//		Fluentwait(driver, ERO_Optimizer_Close3);
//		click(driver, ERO_Optimizer_Close3);
//
//		Fluentwait(driver, Ero_cancle2);
//		click(driver, Ero_cancle2);
//
//		Extent_cal(test,
//				"Testcase 252,Ensure the Deficit Qty field in all Equipment Reposition solve single equipment type and all size type");
//
//		sendKeys(driver, Searchbox, "Deficit and Surplus Location Identification");
//
//		Fluentwait(driver, Selectdeficit);
//		click(driver, Selectdeficit);
//
//		wait(driver, "5");
//
//		Fluentwait(driver, dropdown_option);
//		click(driver, dropdown_option);
//
//		Fluentwait(driver, Budget_Reposition);
//		click(driver, Budget_Reposition);
//
//		Fluentwait(driver, Budget);
//		click(driver, Budget);
//		wait(driver, "4");
//
////		uploadFileRobot(driver, EquimentType_Alphabets);
//		
//		String upload_EquimentType_Alphabets3 = System.getProperty("user.dir") + "/driver/MasterDownloadfile.exe " + EquimentType_Alphabets;
//
//		try {
//			Runtime.getRuntime().exec(upload_EquimentType_Alphabets3);
//		} catch (IOException e) {
//			e.printStackTrace();
//			System.out.println(e.getLocalizedMessage());
//			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
//		}		
//		
//		wait(driver,"10");
//		
//		Fluentwait(driver, Location3);
//		
//		if (isDisplayed(driver, click_yes)) {
//
//			click(driver, click_yes);
//
//			Fluentwait(driver, Click_ok);
//			click(driver, Click_ok);
//		}
//
//		wait(driver, "2");
//		Fluentwait(driver, ERO_Save);
//		click(driver, ERO_Save);
//		wait(driver, "2");
//		Fluentwait(driver, ERO_Save_ok);
//		click(driver, ERO_Save_ok);
//
//		wait(driver, "3");
//
//		WebElement scroller_val2 = driver.findElement(By.xpath("(//div[@ref='eBodyHorizontalScrollViewport'])[1]"));
//
//		int scrollAmount_val2 = 2000;
//
//		js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller_val2, scrollAmount_val2);
//
//		Fluentwait(driver, Defi_Status);
//		click(driver, Defi_Status);
//
//		Fluentwait(driver, EPO_SelectFilterOption);
//		click(driver, EPO_SelectFilterOption);
//
//		Fluentwait(driver, EPO_SelectFilterSearchBox);
//		click(driver, EPO_SelectFilterSearchBox);
//		wait(driver, "1");
//		Fluentwait(driver, Deficit_Val);
//		click(driver, Deficit_Val);
//
//		Fluentwait(driver, EPO_SelectFilterOption);
//		click(driver, EPO_SelectFilterOption);
//
//		String Total1 = getText(driver, Deficit_Total);
//		System.out.println("Total :" + Total1);
//
//		String str1 = Total1.substring(0, 2);
//		System.out.println("str1 :" + str1);
//
//		Fluentwait(driver, Route);
//		click(driver, Route);
//		wait(driver, "2");
//
//		Fluentwait(driver, Optimizer);
//		click(driver, Optimizer);
//		wait(driver, "2");
//		Fluentwait(driver, Optimizer_Ok);
//		click(driver, Optimizer_Ok);
//		wait(driver, "2");
//
//		Fluentwait(driver, Deficit_qty);
//		mouseOverAndClick(driver, Deficit_qty);
//		wait(driver, "2");
//
//		String Deficit = getAttribute(driver, Deficit_qty, "value");
//
//		System.out.println(Deficit);
//
//		if (Deficit.equals(str1)) {
//			System.out.println("Deficit Qty count is equal");
//			Extent_pass(driver, "Expeted Deficit Qty count : " + str1 + "Acutal Deficit Qty count : " + Deficit, test,
//					test1);
//		} else {
//			System.out.println("Deficit Qty count is not equal");
//			Extent_fail2(driver, "Expeted Deficit Qty count : " + str1 + "Acutal Deficit Qty count : " + Deficit, test);
//			global = "Expeted Deficit Qty count : " + str1 + "Acutal Deficit Qty count : " + Deficit;
//		}
//
//		System.out.println("Testcase 252, completed");
//
//		Fluentwait(driver, Defi_close);
//		mouseOverAndClick(driver, Defi_close);
//
//		Fluentwait(driver, ERO_Optimizer_Close5);
//		mouseOverAndClick(driver, ERO_Optimizer_Close5);
//
//		Fluentwait(driver, Defic_cancle1);
//		mouseOverAndClick(driver, Defic_cancle1);
//
//		Extent_cal(test, "Testcase 255,Ensure the  Deficit Qty field not allow alphabets.");
//
//		sendKeys(driver, Searchbox, "Deficit and Surplus Location Identification");
//
//		Fluentwait(driver, Selectdeficit);
//		click(driver, Selectdeficit);
//
//		Fluentwait(driver, Globalserach);
//		click(driver, Globalserach);
//
//		Fluentwait(driver, Globalserach_IDInput);
//		sendKeys(driver, Globalserach_IDInput, ID);
//
//		Fluentwait(driver, Click_Search);
//		click(driver, Click_Search);
//
//		wait(driver, "3");
//		Fluentwait(driver, SelectID);
//		doubleClick(driver, SelectID);
//
//		Fluentwait(driver, Editbutton);
//		click(driver, Editbutton);
//
//		Fluentwait(driver, Save);
//		click(driver, Save);
//
//		wait(driver, "3");
//
//		Fluentwait(driver, Save_popup_ok);
//		click(driver, Save_popup_ok);
//
//		wait(driver, "3");
//
//		WebElement scroller_val3 = driver.findElement(By.xpath("(//div[@ref='eBodyHorizontalScrollViewport'])[1]"));
//
//		int scrollAmount_val3 = 2000;
//
//		js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller_val3, scrollAmount_val3);
//
//		Fluentwait(driver, Defi_Status);
//		click(driver, Defi_Status);
//
//		Fluentwait(driver, EPO_SelectFilterOption);
//		click(driver, EPO_SelectFilterOption);
//
//		Fluentwait(driver, EPO_SelectFilterSearchBox);
//		click(driver, EPO_SelectFilterSearchBox);
//		wait(driver, "1");
//		Fluentwait(driver, Deficit_Val);
//		click(driver, Deficit_Val);
//
//		Fluentwait(driver, EPO_SelectFilterOption);
//		click(driver, EPO_SelectFilterOption);
//
//		Fluentwait(driver, Route);
//		click(driver, Route);
//		wait(driver, "2");
//		Fluentwait(driver, ERO_Popup_Ok);
//		click(driver, ERO_Popup_Ok);
//
//		Fluentwait(driver, ERO_Total_Count);
//		click(driver, ERO_Total_Count);
//
//		String alpha3 = getText(driver, ERO_Total_Count);
//		String Allignmenttype3 = determineType(alpha3);
//
//		if (!Allignmenttype3.equals("Alphabetic")) {
//			System.out.println("Deficit Qty  field not allow to set alphabets");
//			Extent_pass(driver, "Deficit Qty  field not allow to set alphabets ", test, test1);
//		} else {
//			System.out.println("Deficits Qty  field allow to set alphabets");
//			Extent_fail(driver, "Deficit Qty  field  allow to set alphabets  ", test, test1);
//			global = "Deficit Qty  field  allow to set alphabets : ";
//		}
//
//		System.out.println("Testcase 255, completed");
//
//		Extent_cal(test, "Testcase 256,Ensure the Deficit Qty  field allow   numeric.");
//
//		Fluentwait(driver, ERO_Total_Count);
//		click(driver, ERO_Total_Count);
//
//		String numeric = getText(driver, ERO_Total_Count);
//		String numeric_val = determineType(numeric);
//
//		if (numeric_val.equals("Numeric")) {
//			System.out.println("Deficits Qty  field not allow the numeric");
//			Extent_pass(driver, "Deficits Qty  field not allow the numeric ", test, test1);
//		} else {
//			System.out.println("Deficits Qty  field  allow the numeric");
//			Extent_fail(driver, "Deficits Qty  field  allow the numeric", test, test1);
//			global = "Deficits Qty  field  allow the numeric ";
//		}
//		System.out.println(" Testcase 256,compleated");
//
//		Extent_cal(test, "Testcase 257,Ensure the Deficit Qty field not allow   Special character.");
//
//		String special = getText(driver, ERO_Total_Count);
//
//		String special_val = determineType(special);
//		wait(driver, "2");
//
//		if (!special_val.equals("Other")) {
//
//			System.out.println("Deficits Qty  field not allow the special char");
//			Extent_pass(driver, "Deficits Qty  field not allow the special char ", test, test1);
//		} else {
//			System.out.println("Deficits Qty  field  allow the special char");
//			Extent_fail(driver, "Deficits Qty  field  allow the special char", test, test1);
//			global = "Deficits Qty  field  allow the special char ";
//		}
//		System.out.println(" Testcase 257,compleated");
//
//		Fluentwait(driver, Ero_cancle1);
//		click(driver, Ero_cancle1);
//
//		Fluentwait(driver, Defic_cancle2);
//		click(driver, Defic_cancle2);
//		Extent_cal(test,
//				"Testcase 258,Ensure the “Red” color indicates Deficit Qty in all Equipment Reposition solve screen single equipment type and all size type");
//
//		sendKeys(driver, Searchbox, "Deficit and Surplus Location Identification");
//
//		Fluentwait(driver, Selectdeficit);
//		click(driver, Selectdeficit);
//
//		wait(driver, "5");
//
//		Fluentwait(driver, dropdown_option);
//		click(driver, dropdown_option);
//
//		Fluentwait(driver, Budget_Reposition);
//		click(driver, Budget_Reposition);
//
//		Fluentwait(driver, Budget);
//		click(driver, Budget);
//		wait(driver, "4");
//
////		uploadFileRobot(driver, EquimentType_Alphabets);
//		
//		String upload_EquimentType_Alphabets4 = System.getProperty("user.dir") + "/driver/MasterDownloadfile.exe " + EquimentType_Alphabets;
//
//		try {
//			Runtime.getRuntime().exec(upload_EquimentType_Alphabets4);
//		} catch (IOException e) {
//			e.printStackTrace();
//			System.out.println(e.getLocalizedMessage());
//			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
//		}		
//		
//		wait(driver,"10");
//		
//		Fluentwait(driver, Location3);
//		
//		if (isDisplayed(driver, click_yes)) {
//
//			click(driver, click_yes);
//
//			Fluentwait(driver, Click_ok);
//			click(driver, Click_ok);
//		}
//
//		wait(driver, "2");
//		Fluentwait(driver, ERO_Save);
//		click(driver, ERO_Save);
//		Fluentwait(driver, ERO_Save_ok);
//		click(driver, ERO_Save_ok);
//		Fluentwait(driver, Route);
//		click(driver, Route);
//		wait(driver, "2");
//		Fluentwait(driver, Optimizer);
//		click(driver, Optimizer);
//		wait(driver, "2");
//		Fluentwait(driver, Optimizer_Ok);
//		click(driver, Optimizer_Ok);
//		wait(driver, "3");
//
//		String color1 = getTextBackgroundColor(driver, deficit_color);
//		System.out.println("background color :" + color1);
//		if (color1.equals(Red)) {
//
//			System.out.println("surplus Qty green colour is display");
//			Extent_pass(driver, "Expeted Surplus Qty count colour was : " + Red, test, test1);
//		} else {
//			System.out.println("surplus Qty green colour is not  display");
//			Extent_fail2(driver, "Expeted Surplus Qty count colour was : " + Red, test);
//			global = "Expeted Surplus Qty count colour was : " + Red;
//		}
//		System.out.println(" Testcase 258,compleated");
//
//		Extent_cal(test,
//				"Testcase 259,Ensure the “Blue” color indicates allocated qty all equipment reposition solve screen single equipment type and all size type");
//
//		String color2 = getTextBackgroundColor(driver, Deficit_blue);
//		System.out.println("background color :" + color2);
//
//		if (color2.equals(blue)) {
//
//			System.out.println("surplus Qty blue colour is display");
//			Extent_pass(driver, "Expeted Surplus Qty count colour was : " + blue, test, test1);
//		} else {
//			System.out.println("surplus Qty blue colour is not  display");
//			Extent_fail2(driver, "Expeted Surplus Qty count colour was : " + blue, test);
//			global = "Expeted Surplus Qty count colour was : " + blue;
//
//		}
//		System.out.println(" Testcase 259,compleated");
//
//		Fluentwait(driver, Optimizer_Clo);
//		click(driver, Optimizer_Clo);
//
//		Extent_cal(test, "Testcase 261 - Ensure the Filter OFF button Functionality ");
//
//		Fluentwait(driver, Optimizer);
//		click(driver, Optimizer);
//		wait(driver, "2");
//
//		Fluentwait(driver, Optimizer_Ok);
//		click(driver, Optimizer_Ok);
//		wait(driver, "2");
//
//		Fluentwait(driver, ERO_Equipment_Reposition_Report);
//		click(driver, ERO_Equipment_Reposition_Report);
//		wait(driver, "2");
//		Fluentwait(driver, Optimizer_Equipment_Reposition_Report);
//		click(driver, Optimizer_Equipment_Reposition_Report);
//
//		Fluentwait(driver, Deficit_Condition_Filter);
//		click(driver, Deficit_Condition_Filter);
//
//		if (isDisplayed(driver, Optimizer_Equipment_Reposition_Report_Filter)) {
//			System.out.println("After click on Condition Filter option Filter button is working  ");
//			Extent_pass(driver, "After click on Filter option Filter button is working ", test, test1);
//		} else {
//			System.out.println("After click on Condition Filter option Filter button is not  working  ");
//			Extent_fail(driver, "After click on Filter option Filter button is not working ", test, test1);
//			global = "After click on Filter option Filter button is not working" ;
//
//		}
//
//		Fluentwait(driver, Optimizer_Equipment_Reposition_Report);
//		click(driver, Optimizer_Equipment_Reposition_Report);
//
//		Fluentwait(driver, OPtimizer_Condition_Filter);
//		click(driver, OPtimizer_Condition_Filter);
//
//		if (!isDisplayed(driver, Optimizer_Equipment_Reposition_Report_Filter)) {
//			System.out.println("After click on Condition Filter option Filter button is disable ");
//			Extent_pass(driver, "After click on Filter option Filter button is disable ", test, test1);
//		} else {
//			System.out.println("After click on Condition Filter option Filter button is not  disable  ");
//			Extent_fail(driver, "After click on Filter option Filter button is not disable ", test, test1);
//			global = "After click on Filter option Filter button is not disable " ;
//		}
//
//		System.out.println("Tetcase 261, completd");
//
//		Fluentwait(driver, Optimizer_Clo);
//		click(driver, Optimizer_Clo);
//
//		Extent_cal(test,
//				"Testcase 262 - Ensure  the Equipment reposition report screen select the carrier tree structure filter  ");
//
//		Fluentwait(driver, Optimizer);
//		click(driver, Optimizer);
//		wait(driver, "2");
//
//		Fluentwait(driver, Optimizer_Ok);
//		click(driver, Optimizer_Ok);
//		wait(driver, "2");
//
//		Fluentwait(driver, ERO_Equipment_Reposition_Repor1t);
//		click(driver, ERO_Equipment_Reposition_Repor1t);
//		wait(driver, "2");
//		String total = getText(driver, Optimizer_total);
//		System.out.println("total");
//
//		Fluentwait(driver, SVM_dropdown);
//		click(driver, SVM_dropdown);
//		wait(driver, "2");
//
//		String total1 = getText(driver, Optimizer_filter_Option);
//		System.out.println("total1");
//
//		if (!total.equals(total1)) {
//			System.out.println("After click on tree  structure filter  Carrier  record displayed into the grid  ");
//			Extent_pass(driver, "After click on tree  structure filter  Carrier  record displayed into the grid", test,
//					test1);
//		} else {
//			System.out.println("After click on tree  structure filter  Carrier  record not  displayed into the grid  ");
//			Extent_fail(driver, "After click on tree  structure filter  Carrier  record not displayed into the grid",
//					test, test1);
//			global = "After click on tree  structure filter  Carrier  record not displayed " ;
//		}
//
//		System.out.println("Tetcase 262, completd");
//		
//		Extent_cal(test,
//				"Testcase 263-Ensure  the Equipment reposition report screen Filter the records using tree structure Country ");
//
//		Fluentwait(driver, optimizer_png_dropdown);
//		click(driver, optimizer_png_dropdown);
//
//		Fluentwait(driver, Optimizer_pg_Dropdown);
//		click(driver, Optimizer_pg_Dropdown);
//
//		if (isDisplayed(driver, Pg_Option)) {
//
//			System.out.println("After click on tree  structure filter   displayed into the grid  ");
//			Extent_pass(driver, "After click on tree  structure filter   displayed into the grid", test, test1);
//		} else {
//			System.out.println("After click on tree  structure filter  not displayed into the grid  ");
//			Extent_fail(driver, "After click on tree  structure filter not  displayed into the grid", test, test1);
//			global = "After click on tree  structure filter not  displayed into the grid" ;
//		}
//
//		Fluentwait(driver, svm_close_drop);
//		click(driver, svm_close_drop);
//
//		System.out.println("Tetcase 263, completd");
//
//		Extent_cal(test,
//				"Testcase 264-Ensure  the Equipment reposition report screen Filter the records using tree structure Country ");
//
//		Fluentwait(driver, optimizer_png_dropdown);
//		click(driver, optimizer_png_dropdown);
//
//		Fluentwait(driver, Optimizer_pg_Dropdown);
//		click(driver, Optimizer_pg_Dropdown);
//
//		Fluentwait(driver, optimizer_pggur);
//		click(driver, optimizer_pggur);
//
//		List<WebElement> originList = driver.findElements(By.xpath("//div[@col-id='origin' and @role='gridcell']"));
//		boolean Filter = true;
//		for (int j = 0; j < originList.size(); j++) {
//			WebElement Load = originList.get(j);
//			String LoadString = Load.getText();
//
//			if (LoadString.equals("PGGUR")) {
//				Extent_pass(driver, "PGGUR value is displayed ", test, test1);
//			} else {
//				Extent_fail2(driver, "PGGUR value is not displayed ", test);
//				Filter = false;
//			}
//
//		}
//
//		if (Filter == true) {
//			Extent_pass(driver, "Country filter for PGGUR page is working", test, test1);
//
//		} else {
//			Extent_fail2(driver, "Country filter for PGGUR page is not working", test);
//			global = "Country filter for PGGUR page is not working" ;
//		}
//
//		System.out.println("Tetcase 264, completed");
//
//		Fluentwait(driver, Pg_close_dropdown);
//		click(driver, Pg_close_dropdown);
//
//		Extent_cal(test,
//				"Testcase 267-Ensure  the Equipment reposition report screen Filter the records using tree structure Location  ");
//
//		WebElement scrolle = driver.findElement(By.xpath("(//div[@ref='eBodyHorizontalScrollViewport'])[1]"));
//		int scrollAmoun = 1500; //
//		js.executeScript("arguments[0].scrollLeft += arguments[1];", scrolle, scrollAmoun);
//
//		List<WebElement> originList1 = driver
//				.findElements(By.xpath("//div[@col-id='loadregion' and @role='gridcell']"));
//		boolean Filter1 = true;
//		for (int j = 0; j < originList1.size(); j++) {
//			WebElement Load = originList1.get(j);
//			String LoadString = Load.getText();
//
//			if (LoadString.equals("PNG")) {
//				Extent_pass(driver, "PNG value is displayed ", test, test1);
//			} else {
//				Extent_fail2(driver, "PNG value is not displayed ", test);
//				Filter1 = false;
//			}
//
//		}
//
//		if (Filter == true) {
//			Extent_pass(driver, "Country filter for PNG page is working", test, test1);
//
//		} else {
//			Extent_fail2(driver, "Country filter for PNG page is not working", test);
//			global = "Country filter for PNG page is not working" ;
//		}
//
//		System.out.println("Tetcase 267, completed");
//
//		Fluentwait(driver, Pg_close_dropdown);
//		click(driver, Pg_close_dropdown);
//
//		Fluentwait(driver, png_close_dropdown);
//		click(driver, png_close_dropdown);
//
//		Extent_cal(test, "Testcase 268-Ensure  the Equipment reposition report screen  Total Quantity");
//
//		Fluentwait(driver, ERO_SVM1);
//		click(driver, ERO_SVM1);
//
//		String total_val = getText(driver, Optimizer_total);
//		System.out.println("total_val :" + total_val);
//		int totalval = Integer.valueOf(total_val);
//
//		int total_amount = 0;
//
//		for (int j = 0; j < totalval; j++) {
//
//			WebElement elements = driver
//					.findElement(By.xpath("//div[@row-id='" + j + "']//div[@col-id='containercount']"));
//			act.moveToElement(elements).build().perform();
//			String value = driver.findElement(By.xpath("//div[@row-id='" + j + "']//div[@col-id='containercount']"))
//					.getText();
//			System.out.println("value :" + value);
//			int amount = Integer.valueOf(value);
//			total_amount = total_amount + amount;
//		}
//
//		String TotalAmount = String.valueOf(total_amount);
//
//		System.out.println("TotalAmount : " + TotalAmount);
//		wait(driver, "1");
//		Scrolltilltheelementvisible(driver, Total_Quantity);
//
//		wait(driver, "2");
//
//		String quantity = getAttribute(driver, Total_Quantity, "value");
//		System.out.println("quantity :" + quantity);
//
//		if (TotalAmount.equals(quantity)) {
//			System.out.println("Total quantity value is display");
//			Extent_pass(driver, "Total quantity value is :" + TotalAmount, test, test1);
//		} else {
//			System.out.println("Total quantity value is not display");
//			Extent_fail2(driver, "Total quantity value is :" + TotalAmount, test);
//			global = "Total quantity value is :" + TotalAmount ;
//		}
//		wait(driver, "2");
//
//		System.out.println("Testcase 268, completed");
//
//		Extent_cal(test, "Testcase 269-Ensure  the Equipment reposition report screen  Average cost per box Quantity");
//
//		String averagecost = getAttribute(driver, AverageCost, "value");
//		System.out.println("averagecost :" + averagecost);
//
//		String Grandtotal = getAttribute(driver, Grand_Total, "value");
//		System.out.println("Grandtotal :" + Grandtotal);
//
//		String quantity1 = getAttribute(driver, Total_Quantity, "value");
//		System.out.println("quantity1 :" + quantity1);
//
//		double Grand_total = Double.valueOf(Grandtotal.replace(",", ""));
//		double Int_qty = Double.valueOf(quantity1);
//
//		double actual_value = Grand_total % Int_qty;
//
//		String ActualValue = String.valueOf(actual_value);
//
//		System.out.println("ActualValue : " + ActualValue);
//
//		if (ActualValue.equals(averagecost)) {
//			System.out.println("Total quantity value is display");
//			Extent_pass(driver, "Total quantity value is :" + averagecost, test, test1);
//		} else {
//			System.out.println("Total quantity value is not display");
//			Extent_fail2(driver, "Total quantity value is :" + averagecost, test);
//			global = "Total quantity value is :" + averagecost ;
//		}
//		scrollBottom(driver);
//		System.out.println("Testcase 269, completed");
//
//		Extent_cal(test, "Testcase 270 -Ensure  the Equipment reposition report screen  Grand Total ");
//		Fluentwait(driver, Optimizer_Clo);
//		click(driver, Optimizer_Clo);
//
//		Fluentwait(driver, Optimizer);
//		click(driver, Optimizer);
//		wait(driver, "2");
//		Fluentwait(driver, Optimizer_Ok);
//		click(driver, Optimizer_Ok);
//		wait(driver, "3");
//		Fluentwait(driver, ERO_Equipment_Reposition_Report);
//		click(driver, ERO_Equipment_Reposition_Report);
//
//		String total_val1 = getText(driver, Optimizer_total);
//		System.out.println("total_val :" + total_val1);
//		int totalval1 = Integer.valueOf(total_val1);
//
//		double total_amount1 = 0;
//
//		for (int j = 0; j < totalval1; j++) {
//
//			WebElement elements = driver.findElement(By.xpath("//div[@row-id='" + j + "']//div[@col-id='totcost']"));
//			act.moveToElement(elements).build().perform();
//			String value = driver.findElement(By.xpath("//div[@row-id='" + j + "']//div[@col-id='totcost']")).getText();
//			System.out.println("value :" + value);
//			double amount1 = Double.valueOf(value);
//			total_amount1 = total_amount1 + amount1;
//
//		}
//
//		String TotalAmount1 = String.valueOf(total_amount1);
//
//		System.out.println("TotalAmount : " + TotalAmount1);
//
//		Scrolltilltheelementvisible(driver, Grand_Total);
//
//		String grand_total = getAttribute(driver, Grand_Total, "value");
//
//		String GrandTotal = grand_total.replace(",", "");
//		System.out.println("GrandTotal :" + GrandTotal);
//
//		if (TotalAmount1.equals(GrandTotal)) {
//			System.out.println("Total quantity value is display");
//			Extent_pass(driver, "Total quantity value is :" + averagecost, test, test1);
//		} else {
//			System.out.println("Total quantity value is not display");
//			Extent_fail2(driver, "Total quantity value is :" + averagecost, test);
//			global = "Total quantity value is :" + averagecost ;
//		}
//		System.out.println("Testcase 270, completed");
//		
//		
//		
		
		

	}
}
