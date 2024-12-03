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

public class TS_016_Tc_076_ERO_Deviation_report extends Keywords{
	public void Scenario016(WebDriver driver, ExtentTest test,ExtentTest test1,String url, int dataset) throws AWTException, IOException, InterruptedException {	
	
	System.out.println("url : "+url);
	
	String Username = Utils.getDataFromTestData("TS_016_Tc_076_ERO_Dataset"+dataset, "ERO_Deviation_report", "Username");
	String Password = Utils.getDataFromTestData("TS_016_Tc_076_ERO", "ERO_Deviation_report_Dataset"+dataset, "Password");
	String ID = Utils.getDataFromTestData("TS_016_Tc_076_ERO_Dataset"+dataset, "ERO_Deviation_report", "Id");
	String ID2 = Utils.getDataFromTestData("TS_016_Tc_076_ERO_Dataset"+dataset, "ERO_Deviation_report", "ID_2");
	String EQ_Type = Utils.getDataFromTestData("TS_016_Tc_076_ERO_Dataset"+dataset, "ERO_Deviation_report", "EQU_Type");
	String Messagetext = Utils.getDataFromTestData("TS_016_Tc_076_ERO_Dataset"+dataset, "ERO_Deviation_report", "Message_text");
	String Messagetext1 = Utils.getDataFromTestData("TS_016_Tc_076_ERO_Dataset"+dataset, "ERO_Deviation_report", "Message_text1");
	String Messagetext2 = Utils.getDataFromTestData("TS_016_Tc_076_ERO_Dataset"+dataset, "ERO_Deviation_report", "Message_text2");





	
	
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

Extent_cal(test,
		"Testcase 76 - Ensure the validation message displayed");


Extent_cal(test, "Validation1");



Fluentwait(driver, Cancel_Report);
click(driver, Cancel_Report);



Fluentwait(driver, New_Report);
click(driver, New_Report);


Fluentwait(driver, Create_New_Confirm1);
click(driver, Create_New_Confirm1);

wait(driver, "3");

click(driver, Search4);

wait(driver, "3");

String Message_text = getText(driver,Popup_Msg_Report );

System.out.println("Message_text : "+Message_text);
wait(driver, "3");



if (Message_text.equals(Messagetext)) {
	System.out.println("Matched || Expected Message Text was : " + Messagetext
			+ " || Actual Message Text was : " + Message_text);
	Extent_pass(driver, "Matched || Expected Message Text was : "
			+ Messagetext + " || Actual Message Text was : " + Message_text,
			test,test1);
} else {
	System.out.println(
			"Not Matched || Expected Message Text was : " + Messagetext
					+ " || Actual Message Text was : " + Message_text);
	Extent_fail2(driver, "Not Matched || Expected Message Text was : "
			+ Messagetext + " || Actual Message Text was : " + Message_text,
			test);

}

wait(driver, "3");

click(driver, Click_Ok_Report);


Extent_cal(test, "Validation2");



wait(driver, "3");

click(driver, Search2);

wait(driver, "5");

String Message_text1 = getText(driver,Popup_Msg_Report );

System.out.println("Message_text1 : "+Message_text1);
wait(driver, "3");



if (Message_text1.equals(Messagetext1)) {
	System.out.println("Matched || Expected Message Text was : " + Messagetext1
			+ " || Actual Message Text was : " + Message_text1);
	Extent_pass(driver, "Matched || Expected Message Text was : "
			+ Messagetext1 + " || Actual Message Text was : " + Message_text1,
			test,test1);
} else {
	System.out.println(
			"Not Matched || Expected Message Text was : " + Messagetext1
					+ " || Actual Message Text was : " + Message_text1);
	Extent_fail2(driver, "Not Matched || Expected Message Text was : "
			+ Messagetext1 + " || Actual Message Text was : " + Message_text1,
			test);

}


wait(driver, "3");

click(driver, Click_Ok_Report);	

Extent_cal(test, "Validation3");



wait(driver, "3");

click(driver, Search3);
wait(driver, "3");


String Message_text2 = getText(driver,Popup_Msg_Report );

System.out.println("Message_text2 : "+Message_text2);
wait(driver, "3");



if (Message_text2.equals(Messagetext2)) {
	System.out.println("Matched || Expected Message Text was : " + Messagetext2
			+ " || Actual Message Text was : " + Message_text2);
	Extent_pass(driver, "Matched || Expected Message Text was : "
			+ Messagetext2 + " || Actual Message Text was : " + Message_text2,
			test,test1);
} else {
	System.out.println(
			"Not Matched || Expected Message Text was : " + Messagetext2
					+ " || Actual Message Text was : " + Message_text2);
	Extent_fail2(driver, "Not Matched || Expected Message Text was : "
			+ Messagetext2 + " || Actual Message Text was : " + Message_text2,
			test);

}


wait(driver, "3");

click(driver, Click_Ok_Report);	








System.out
.println("//***************************Testcase 76 Completed **************************************//");


	}
}
