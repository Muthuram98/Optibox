package ERO_Mass_Cost_Update;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
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
import org.openqa.selenium.interactions.ClickAndHoldAction;
import org.openqa.selenium.interactions.DoubleClickAction;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.Utils;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class TS_005_Tc_043toTc_059_ERO_Mass_Cost_Update extends Keywords{
	public void Scenario005(WebDriver driver, ExtentTest test,ExtentTest test1,String url, int dataset) throws AWTException, IOException, InterruptedException {	
	
	System.out.println("url : "+url);
	
	String Username = Utils.getDataFromTestData("TS_005_Tc_043toTc_059_ERO_Mass_Cost_Update_Dataset"+dataset, "ero_mass_cost_update", "Username");
	String Password = Utils.getDataFromTestData("TS_005_Tc_043toTc_059_ERO_Mass_Cost_Update_Dataset"+dataset, "ero_mass_cost_update", "Password");
	String ID = Utils.getDataFromTestData("TS_005_Tc_043toTc_059_ERO_Mass_Cost_Update_Dataset"+dataset, "ero_mass_cost_update", "Id");
	
	
	WebDriverWait wait = new WebDriverWait(driver, 60);
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

		
Extent_cal(test, "Testcase 43 - when we click ALT+N,System should allow to create new record");

		
Fluentwait(driver, Cancel_Button);
click(driver, Cancel_Button);

		wait(driver, "5");

		Robot rbt = new Robot();

		
		act.keyDown(Keys.ALT).sendKeys("n").keyUp(Keys.ALT).build().perform();

		wait(driver, "5");

		if (isDisplayed(driver, Click_Confirm)) {
			System.out.println("Shortcut key for `New` button(ALT+N) is functioning and new record was created");
			Extent_pass(driver, "Shortcut key for `New` button(ALT+N) is functioning and new record was created", test,test1);
			click(driver, Click_Confirm);
		} else {
			System.out.println("Shortcut key for `New` button(ALT+N) is not functioning");
			Extent_fail(driver, "Shortcut key for `New` button(ALT+N) is not functioning", test,test1);
		}
		
		wait(driver, "5");


		System.out
				.println("//***************************Testcase 43 Completed **************************************//");
		
		
		
		
		Extent_cal(test, "Testcase 44 - When click ALT+S system should save/update the record");
		
		
		wait(driver, "5");
		
		
		Fluentwait(driver, Add_Plus_Button);
		click(driver, Add_Plus_Button);
		
		
		wait(driver,"3");

		Fluentwait(driver, Select_Loc);
		doubleClick(driver, Select_Loc);
		
		wait(driver,"3");

		
		click(driver, ShowButton);
		
		
		wait(driver,"3");
		
		
		Fluentwait(driver, EditButton);
		click(driver, EditButton);
		
		
		wait(driver,"3");

		act.keyDown(Keys.ALT).sendKeys("s").keyUp(Keys.ALT).build().perform();

		wait(driver, "5");

		if (isDisplayed(driver, Save_msg_popup)) {
			System.out.println("Shortcut key for `Save` button(ALT+S) is functioning and the records are saved");
			Extent_pass(driver, "Shortcut key for `Save` button(ALT+S) is functioning and the records are saved", test,test1);
			//click(driver, clickok);
		} else {
			System.out.println("Shortcut key for `Save` button(ALT+S) is not functioning");
			Extent_fail(driver, "Shortcut key for `Save` button(ALT+S) is not functioning", test,test1);
		}

		System.out
				.println("//***************************Testcase 43 Completed **************************************//");
		
		
click(driver, Close_Popup);


Extent_cal(test, "Testcase 46 - When click ALT+I system should allow to edit the record");



click(driver, Cancel_Button);

Fluentwait(driver, NewReport);
click(driver, NewReport);


Fluentwait(driver, Click_Confirm);
click(driver, Click_Confirm);

wait(driver,"5");



Fluentwait(driver, Add_Plus_Button);
click(driver, Add_Plus_Button);


wait(driver,"3");

Fluentwait(driver, Select_Loc);
doubleClick(driver, Select_Loc);

wait(driver,"3");


click(driver, ShowButton);


wait(driver,"3");



act.keyDown(Keys.ALT).sendKeys("i").keyUp(Keys.ALT).build().perform();

wait(driver, "5");

if (isDisplayed(driver, Click_Save)) {
	System.out.println("Shortcut key for `Edit` button(ALT+I) is functioning and the records are saved");
	Extent_pass(driver, "Shortcut key for `Edit` button(ALT+I) is functioning and the records are saved", test,test1);
	//click(driver, clickok);
} else {
	System.out.println("Shortcut key for `Edit` button(ALT+I) is not functioning");
	Extent_fail(driver, "Shortcut key for `Edit` button(ALT+I) is not functioning", test,test1);
}

System.out
		.println("//***************************Testcase 43 Completed **************************************//");


Extent_cal(test, "Testcase 47 - When click ALT+E system should cancel the last activity");

wait(driver, "5");



act.keyDown(Keys.ALT).sendKeys("e").keyUp(Keys.ALT).build().perform();

wait(driver, "5");

if (!IsElementEnabled(driver, Grid_Rec)) {

	System.out.println("Shortcut key for `Cancel` button (ALT+E) is functioning");
	Extent_pass(driver, "Shortcut key for `Cancel` button (ALT+E) is functioning", test,test1);

} else {

	System.out.println("Shortcut key for `Cancel` button (ALT+E) is not functioning");
	Extent_fail(driver, "Shortcut key for `Cancel` button (ALT+E) is not functioning", test,test1);
}



System.out
		.println("//***************************Testcase 47 Completed **************************************//");






Extent_cal(test, "Testcase 49 - When click ALT+C System should allow to copy the selected data");

Fluentwait(driver, NewReport);
click(driver, NewReport);


Fluentwait(driver, Click_Confirm);
click(driver, Click_Confirm);

wait(driver,"5");



Fluentwait(driver, Add_Plus_Button);
click(driver, Add_Plus_Button);


wait(driver,"3");

Fluentwait(driver, Select_Loc);
doubleClick(driver, Select_Loc);

wait(driver,"3");


click(driver, ShowButton);


wait(driver,"3");



Fluentwait(driver, Text_1);


doubleClick(driver, Text_1);



wait(driver,"3");



act.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();

wait(driver, "5");

String copiedtext = getcopiedText(driver);

System.out.println("copiedtext : " + copiedtext);

String gettext = getText(driver, Text_1);

//int textlength = gettext.length();

//String actualcopied = copiedtext.substring(0);

if (copiedtext.equals(gettext)) {

	System.out.println("Selected data was copied || Expected copied value was : " + gettext + " || Actual copied value was : "
			+ copiedtext);
	Extent_pass(driver,
			"Selected data was copied || Expected copied value was : " + gettext + " || Actual copied value was : " + copiedtext,
			test,test1);
} else {
	System.out.println("Selected data was not copied || Expected copied value was : " + gettext
			+ " || Actual copied value was : " + copiedtext);
	Extent_fail(driver, "Selected data was not copied || Expected copied value was : " + gettext
			+ " || Actual copied value was : " + copiedtext, test,test1);
}

System.out.println("Testcase 49 Completed");


Extent_cal(test, "Testcase 50 - When click ALT+V System should allow to paste the copied data");

try {

	StringSelection stringSelection = new StringSelection(gettext);
	Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	clipboard.setContents(stringSelection, null);
	System.out.println("Text copied to clipboard: " + gettext);

} catch (Exception e) {
	e.printStackTrace();
}



Fluentwait(driver, Searchbox2);
click(driver, Searchbox2);

wait(driver, "3");


act.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();

wait(driver, "3");

String value = getAttribute(driver, Search_module1, "value");

System.out.println("value : " + value);

if (value.equals(gettext)) {
	System.out.println(
			"Matched || Expected pasted value was : " + gettext + " || Actual pasted value was : " + value);
	Extent_pass(driver, "System allowed to paste the copied data by using shortcut key CTRL+V", test,test1);
	Extent_pass(driver,
			"Matched || Expected pasted value was : " + gettext + " || Actual pasted value was : " + value,
			test,test1);
} else {
	System.out.println(
			"Not Matched || Expected pasted value was : " + gettext + " || Actual pasted value was : " + value);
	Extent_fail(driver, "System not allowed to paste the copied data by using shortcut key CTRL+V", test,test1);
	Extent_fail(driver,
			"Not Matched || Expected pasted value was : " + gettext + " || Actual pasted value was : " + value,
			test,test1);
}






Extent_cal(test, "Testcase 51 - When click ALT+P System should open the jasper window");


//click(driver, Cancel_Button);

wait(driver,"3");



Fluentwait(driver, NewReport);
click(driver, NewReport);


Fluentwait(driver, Click_Confirm);
click(driver, Click_Confirm);

wait(driver,"5");



Fluentwait(driver, Add_Plus_Button);
click(driver, Add_Plus_Button);


wait(driver,"3");

Fluentwait(driver, Select_Loc);
doubleClick(driver, Select_Loc);

wait(driver,"3");


click(driver, ShowButton);


wait(driver,"3");




act.keyDown(Keys.ALT).sendKeys("p").keyUp(Keys.ALT).build().perform();

wait(driver, "5");

if (IsElementEnabled(driver, Jasper_popup)) {

	System.out.println("Shortcut key for Jasper_popup button is functioning");
	Extent_pass(driver, "Shortcut key for Jasper_popup button is functioning", test,test1);

} else {

	System.out.println("Shortcut key for Jasper_popup button is not functioning");
	Extent_fail(driver, "Shortcut key for Jasper_popup button is not functioning", test,test1);
}

System.out.println("//***************************Testcase 51 Completed **************************************//");

/*
Extent_cal(test, "Testcase 58 - When click CRTL+F4 System should allow to close the screen");

wait(driver,"5");

act.keyDown(Keys.CONTROL).sendKeys(Keys.F4).keyUp(Keys.CONTROL).build().perform();

wait(driver,"5");

if(!isDisplayed(driver, NewReport)) {
	
	System.out.println("Shortcut key for close the screen is functioning");
	Extent_pass(driver, "Shortcut key for close the screen is functioning", test,test1);
	
}else {
	
	System.out.println("Shortcut key for close the screen is not functioning");
	Extent_fail(driver,"Shortcut key for close the screen is not functioning", test,test1);
}


	*/	
		
		
}
}
