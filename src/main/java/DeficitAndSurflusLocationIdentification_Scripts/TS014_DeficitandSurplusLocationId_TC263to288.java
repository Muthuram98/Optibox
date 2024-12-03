package DeficitAndSurflusLocationIdentification_Scripts;

import java.awt.Robot;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.Utils;
import testng.reports.logging.LogAs;

public class TS014_DeficitandSurplusLocationId_TC263to288 extends Keywords {

	@SuppressWarnings("deprecation")
	public void Scenario14(WebDriver driver, ExtentTest test, ExtentTest test1, String url, int dataset) throws Exception {
 
		String Username = Utils.getDataFromTestData("TS014_DeficitandSurplusLocationIdentification_Dataset"+dataset,
				"DeficitandSurplusLocationId", "Username");
		String Password = Utils.getDataFromTestData("TS014_DeficitandSurplusLocationIdentification_Dataset"+dataset,
				"DeficitandSurplusLocationId", "Password");
		String FromWeek = Utils.getDataFromTestData("TS014_DeficitandSurplusLocationIdentification_Dataset"+dataset,
				"DeficitandSurplusLocationId", "From_week");
		String ToWeek = Utils.getDataFromTestData("TS014_DeficitandSurplusLocationIdentification_Dataset"+dataset,
				"DeficitandSurplusLocationId", "To_Week");
		String Currentweek = Utils.getDataFromTestData("TS014_DeficitandSurplusLocationIdentification_Dataset"+dataset,
				"DeficitandSurplusLocationId", "Current_Week");
		String Current_year_po = Utils.getDataFromTestData("TS014_DeficitandSurplusLocationIdentification_Dataset"+dataset,
				"DeficitandSurplusLocationId", "From_year");
		String same_week = Utils.getDataFromTestData("TS014_DeficitandSurplusLocationIdentification_Dataset"+dataset,
				"DeficitandSurplusLocationId", "Same_week");
		String current_pop = Utils.getDataFromTestData("TS014_DeficitandSurplusLocationIdentification_Dataset"+dataset,
				"DeficitandSurplusLocationId", "Week_pop_1");

		String FromWeek1 = Utils.getDataFromTestData("TS014_DeficitandSurplusLocationIdentification_Dataset"+dataset,
				"DeficitandSurplusLocationId", "FromWeek1");
		String ToWeek1 = Utils.getDataFromTestData("TS014_DeficitandSurplusLocationIdentification_Dataset"+dataset,
				"DeficitandSurplusLocationId", "ToWeek1");
		String FromWeek2 = Utils.getDataFromTestData("TS014_DeficitandSurplusLocationIdentification_Dataset"+dataset,
				"DeficitandSurplusLocationId", "FromWeek2");
		String ToWeek2 = Utils.getDataFromTestData("TS014_DeficitandSurplusLocationIdentification_Dataset"+dataset,
				"DeficitandSurplusLocationId", "ToWeek2");

		String Import_file = System.getProperty("user.dir") + "\\uploads\\Location1.xlsx";
		String EquipmentType = System.getProperty("user.dir") + "\\uploads\\Equipment_Type.xlsx";

		Actions act = new Actions(driver);

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

		wait(driver, "3");
		Fluentwait(driver, Searchbox);
		sendKeys(driver, Searchbox, "Deficit and Surplus Location Identification");

		wait(driver, "2");
		Fluentwait(driver, Selectdeficit);
		click(driver, Selectdeficit);

		wait(driver, "5");

		Extent_cal(test, "Testcase 263- Ensure in without Enter the From Week ");

		Fluentwait(driver, Fromweek_input);
		clear(driver, Fromweek_input);

		wait(driver, "2");
		Fluentwait(driver, Show);
		click(driver, Show);

		wait(driver, "3");

		String from = getText(driver, From_week_Pop);
		if (from.equals(FromWeek)) {

			Extent_pass(driver, "when the from week is empty and click the show button, warning popup got displayed",
					test, test1);
			System.out.println(
					"Matched || Expected popup message was : " + FromWeek + " Actual Popup message was : " + from);
			Extent_pass(driver,
					"Matched || Expected popup message was : " + FromWeek + " Actual Popup message was : " + from, test,
					test1);

		} else {
			System.out.println(
					"Not Matched || Expected popup message was : " + FromWeek + " Actual Popup message was : " + from);
			Extent_fail(driver,
					"Not Matched || Expected popup message was: " + FromWeek + " Actual Popup message was : " + from,
					test, test1);
		}

		wait(driver, "2");

		Fluentwait(driver, From_week_pop_ok1);
		click(driver, From_week_pop_ok1);

		System.out.println("*******************263**************");

		Extent_cal(test, "Testcase 264- Ensure in without Enter the To Week ");

		Fluentwait(driver, Fromweek_input);
		wait(driver, "2");
		sendKeys(driver, Fromweek_input, FromWeek1);

		wait(driver, "5");
		clear(driver, Toweek_input);
		Fluentwait(driver, Show);
		click(driver, Show);

		wait(driver, "2");
		String To_week = getText(driver, To_week_Pop);

		if (To_week.equals(ToWeek)) {
			Extent_pass(driver, "when the To week is empty and click the show button, warning popup got displayed",
					test, test1);
			System.out.println(
					"Matched || Expected popup message was  : " + ToWeek + " Actual  popup message was  : " + To_week);
			Extent_pass(driver,
					"Matched || Expected popup message was: " + ToWeek + "Actual  popup message was : " + To_week, test,
					test1);
		} else {
			System.out.println("Not Matched || Expected popup message was  : " + ToWeek + " Actual popup message was : "
					+ To_week);
			Extent_fail(driver,
					"Not Matched || Expected popup message was: " + ToWeek + " Actual popup message was: " + To_week,
					test, test1);
		}

		wait(driver, "2");
		Fluentwait(driver, To_week_Pop_ok);
		click(driver, To_week_Pop_ok);

		System.out.println("*************************264*************");

		Extent_cal(test, "Testcase 265- Ensure in Enter the From week and To Week future date ");

		wait(driver, "3");
		Fluentwait(driver, Fromweek_input);
		clear(driver, Fromweek_input);
		sendKeys(driver, Fromweek_input, ToWeek1);

		wait(driver, "2");
		Fluentwait(driver, Toweek_input);
		clear(driver, Toweek_input);
		sendKeys(driver, Toweek_input, FromWeek1);

		wait(driver, "2");
		Fluentwait(driver, Show);
		click(driver, Show);

		wait(driver, "2");
		String From_week1 = getText(driver, To_week_opt);

		if (From_week1.equals(Currentweek)) {
			Extent_pass(driver,
					"when the from week and To week is future date and click the show button, warning popup got displayed",
					test, test1);
			System.out.println("Matched ||  Expected popup message was   : " + Currentweek
					+ " Actual popup message was: " + From_week1);
			Extent_pass(driver, "Matched || Expected popup message was   : " + Currentweek
					+ " Actual popup message was: " + From_week1, test, test1);
		} else {
			System.out.println("Not Matched || Expected popup message was  : " + Currentweek
					+ " Actual popup message was : " + From_week1);
			Extent_fail(driver, "Not Matched ||  Expected popup message was   : " + Currentweek
					+ " Actual popup message was: " + From_week1, test, test1);
		}

		Fluentwait(driver, From_week_pop_ok1);
		click(driver, From_week_pop_ok1);

		System.out.println("*********************265**********");

		Extent_cal(test, "Testcase 266- Ensure in Enter the From year and To Year is lesser then from year");

		wait(driver, "2");

		Fluentwait(driver, Year_Drop_Down);
		click(driver, Year_Drop_Down);

		Fluentwait(driver, Fromweek_input);
		clear(driver, Fromweek_input);
		sendKeys(driver, Fromweek_input, FromWeek1);

		wait(driver, "2");
		Fluentwait(driver, Year_Drop_Down);
		click(driver, Year_To_Drop_Down);

		wait(driver, "2");
		click(driver, Year_To_Drop_Down);
		wait(driver, "2");
		click(driver, Year_To_Drop_Down);

		Fluentwait(driver, Toweek_input);
		clear(driver, Toweek_input);
		sendKeys(driver, Toweek_input, ToWeek1);

		wait(driver, "2");
		Fluentwait(driver, Show);
		click(driver, Show);

		wait(driver, "2");
		String Current_year = getText(driver, From_year_pop);
		if (Current_year.equals(Current_year_po)) {
			Extent_pass(driver,
					"when the from week is lesser than the two week and click the show button, warning popup got displayed",
					test, test1);
			System.out.println("Matched ||  Expected popup message was   : " + Current_year_po
					+ " Actual popup message was: " + Current_year);
			Extent_pass(driver, "Matched ||  Expected popup message was : " + Current_year_po
					+ " Actual popup message was:  " + Current_year, test, test1);
		} else {
			System.out.println("Not Matched || Expected popup message was   : " + Current_year_po
					+ " Actual popup message was: " + Current_year);
			Extent_fail(driver, "Not Matched || Expected popup message was : " + Current_year_po
					+ " Actual popup message was:" + Current_year, test, test1);
		}

		Fluentwait(driver, From_week_pop_ok1);
		click(driver, From_week_pop_ok1);

		System.out.println("*********************266************");

		Extent_cal(test, "Testcase 267- From Week and To Week Should not be greater than 26 weeks");

		wait(driver, "3");

		Fluentwait(driver, Fromweek_input);
		clear(driver, Fromweek_input);
		sendKeys(driver, Fromweek_input, FromWeek2);

		Fluentwait(driver, Year_To_drop_down_Up);
		click(driver, Year_To_drop_down_Up);

		wait(driver, "2");
		click(driver, Year_To_drop_down_Up);
		wait(driver, "2");

		Fluentwait(driver, Toweek_input);
		clear(driver, Toweek_input);
		sendKeys(driver, Toweek_input, ToWeek2);

		wait(driver, "2");
		Fluentwait(driver, Show);
		click(driver, Show);

		wait(driver, "2");
		String pop1 = getText(driver, current_pop2);
		if (pop1.equals(current_pop)) {
			Extent_pass(driver,
					"Warning popup message was displayed when the difference between from and to week is grater than '26'",
					test, test1);
			System.out.println("Matched || Expected value  : " + current_pop + " Actual value: " + pop1);
			Extent_pass(driver, "Matched || Expected value: " + current_pop + " Actual value : " + pop1, test, test1);
		} else {
			System.out.println("Not Matched || Expected value  : " + current_pop + " Actual value: " + pop1);
			Extent_fail(driver, "Not Matched || Expected value: " + current_pop + " Actual value : " + pop1, test,
					test1);
		}

		Fluentwait(driver, From_week_pop_ok1);
		click(driver, From_week_pop_ok1);

		System.out.println("*****************267************");

		Extent_cal(test, "Testcase 268- Ensure in already calculated deficit and surplus count for same week range  ");

		wait(driver, "2");
		Fluentwait(driver, Year_drop_up_pop);
		click(driver, Year_drop_up_pop);

		Fluentwait(driver, Fromweek_input);
		clear(driver, Fromweek_input);
		sendKeys(driver, Fromweek_input, FromWeek2);

		wait(driver, "2");
		Fluentwait(driver, Year_To_drop_down_Up);
		click(driver, Year_To_drop_down_Up);

		Fluentwait(driver, Toweek_input);
		clear(driver, Toweek_input);
		sendKeys(driver, Toweek_input, ToWeek2);

		wait(driver, "2");
		Fluentwait(driver, Show);
		click(driver, Show);
		wait(driver, "2");
		String same_we = getText(driver, Same_week_pop);
		if (same_we.equals(same_week)) {
			Extent_pass(driver,
					"Warning popup message was displayed when the difference between from and to week is grater than '0'",
					test, test1);
			System.out.println("Matched || Expected value  : " + same_week + " Actual value: " + same_we);
			Extent_pass(driver, "Matched || Expected value: " + same_week + " Actual value : " + same_we, test, test1);
		} else {
			System.out.println("NOt Matched || Expected value  : " + same_week + " Actual value: " + same_we);
			Extent_fail(driver, "Not Matched || Expected value: " + same_week + " Actual value : " + same_we, test,
					test1);
		}
		Fluentwait(driver, Same_week_pop_No);
		click(driver, Same_week_pop_No);

		System.out.println("**********************268*************");

		Extent_cal(test,
				"Testcase 269- Ensure in already calculated deficit and surplus count for same week range  and click on yes button  ");

		wait(driver, "2");

		Fluentwait(driver, Show);
		click(driver, Show);
		wait(driver, "2");
		String same_we1 = getText(driver, Same_week_pop);
		if (same_we1.equals(same_week)) {
			Extent_pass(driver,
					"Warning popup message was displayed when the difference between from and to week is grater than '0'",
					test, test1);
			System.out.println("Matched || Expected value  : " + same_week + " Actual value: " + same_we1);
			Extent_pass(driver, "Matched || Expected popup message text was: " + same_week
					+ " Actual popup message text was : " + same_we1, test, test1);

		} else {
			System.out.println("Not Matched || Expected popup message text was : " + same_week
					+ " Actual popup message text was: " + same_we1);
			Extent_fail(driver, "Not Matched || Expected popup message text was : " + same_week
					+ " Actual popup message text was : " + same_we1, test, test1);
		}
		Fluentwait(driver, Same_week_pop_Yes);
		click(driver, Same_week_pop_Yes);
		wait(driver, "2");

		wait(driver, "5");
		if (isDisplayed(driver, Warning_popup)) {
			System.out.println("popup shown");
			Fluentwait(driver, click_yes);
			click(driver, click_yes);

			Fluentwait(driver, Click_ok);
			click(driver, Click_ok);

			Fluentwait(driver, Cancel);
			click(driver, Cancel);

			wait(driver, "2");
			Fluentwait(driver, New);
			click(driver, New);

			Fluentwait(driver, New_Popup_Yes);
			click(driver, New_Popup_Yes);
			wait(driver, "2");

			Fluentwait(driver, dropdown_option);
			click(driver, dropdown_option);

			Fluentwait(driver, Budget_Reposition);
			click(driver, Budget_Reposition);

			Fluentwait(driver, Budget);
			click(driver, Budget);

			wait(driver, "4");

//				uploadFileRobot(driver,EquipmentType);

			String upload_EquipmentType1 = System.getProperty("user.dir") + "/driver/MasterDownloadfile.exe "
					+ EquipmentType;

			try {
				Runtime.getRuntime().exec(upload_EquipmentType1);
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println(e.getLocalizedMessage());
				Extent_fail(driver, e.getLocalizedMessage(), test, test1);
			}

			wait(driver, "10");

			Fluentwait(driver, Location3);
			
			if(isDisplayed(driver, click_yes)) {
				
				click(driver, click_yes);
				
				Fluentwait(driver, Click_ok);
				click(driver, Click_ok);
			}
			

			wait(driver, "3");

			Fluentwait(driver, ERO_Save);
			click(driver, ERO_Save);
//				Fluentwait(driver, ERO_Save_ok);
//				click(driver, ERO_Save_ok);
			wait(driver, "2");

		} else {
			System.out.println("popup not shown");
		}

		wait(driver, "2");

		List<String> columnnames = Arrays.asList("location", "eqp", "region", "country", "importCnt", "export",
				"imbalance", "weeks", "weeklyimbal", "su", "appsurdef", "calsurdef", "defsurstatusflag", "stock",
				"onewayoutload", "onewayoutreturn", "onewaylease", "tboh", "sali");
		
		int size = columnnames.size();

		boolean displayed = true;

		for (int i = 0; i < size; i++) {

			String columnname = columnnames.get(i);

			WebElement columns = driver.findElement(By.xpath("(//div[@col-id='" + columnname + "'])[4]"));

			act.moveToElement(columns).build().perform();

			if (isDisplayed1(driver, columns)) {

				System.out.println("After click on show button, Records of the " + columnname + " was displayed");
				Extent_pass(driver, "After click on show button, Records of the " + columnname + " was displayed", test,
						test1);

			} else {

				System.out.println("After click on show button, Records of the " + columnname + " was not displayed");
				Extent_fail(driver, "After click on show button, Records of the " + columnname + " was not displayed",
						test, test1);
				displayed = false;
			}

		}

		if (displayed) {

			Extent_pass(driver, "After click on show button, Records are displayed", test, test1);
		} else {

			Extent_fail(driver, "After click on show button, Records are not displayed", test, test1);
		}

		Extent_cal(test, "Testcase 270- Ensure in import form excel, when Location  length exceeds 5 character ");

		Fluentwait(driver, Cancel);
		click(driver, Cancel);

		wait(driver, "2");
		Fluentwait(driver, New);
		click(driver, New);

		Fluentwait(driver, New_Popup_Yes);
		click(driver, New_Popup_Yes);
		wait(driver, "2");

		Fluentwait(driver, dropdown_option);
		click(driver, dropdown_option);

		Fluentwait(driver, Budget_Reposition);
		click(driver, Budget_Reposition);

		Fluentwait(driver, Budget);
		click(driver, Budget);

		wait(driver, "2");
		
//		uploadFileRobot(driver, Import_file);
		
		String upload_Import_file1 = System.getProperty("user.dir") + "/driver/MasterDownloadfile.exe " + Import_file;

		try {
			Runtime.getRuntime().exec(upload_Import_file1);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getLocalizedMessage());
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
		}		
		
		wait(driver,"25");
		
//		Fluentwait(driver, Location3);
		
		if(isDisplayed(driver, click_yes)) {
			
			click(driver, click_yes);
			
			Fluentwait(driver, Click_ok);
			click(driver, Click_ok);
		}
		

		wait(driver,"3");

		if (!isDisplayed(driver, Location3)) {

			System.out.println("When location length is exceeds 5 character, Values are not updated in the grid");
			Extent_pass(driver, "When location length is exceeds 5 character, Values are not updated in the grid", test,
					test1);
		} else {

			System.out.println("Location field is allows the values which is more than 5 characters");
			Extent_fail(driver, "Location field is allows the values which is more than 5 characters", test, test1);
		}

		System.out.println("**************270**************");

		Extent_cal(test, "Testcase 271- Ensure in import form excel, when Equipment Type length exceeds 4 characterr ");

		wait(driver, "5");

		Fluentwait(driver, Cancel);
		click(driver, Cancel);

		wait(driver, "2");
		Fluentwait(driver, New);
		click(driver, New);

		Fluentwait(driver, New_Popup_Yes);
		click(driver, New_Popup_Yes);
		wait(driver, "2");

		wait(driver, "3");
		Fluentwait(driver, dropdown_option);
		click(driver, dropdown_option);

		Fluentwait(driver, Budget_Reposition);
		click(driver, Budget_Reposition);

		Fluentwait(driver, Budget);
		click(driver, Budget);
		wait(driver, "2");

//		uploadFileRobot(driver, EquipmentType);
		
		String upload_EquipmentType1 = System.getProperty("user.dir") + "/driver/MasterDownloadfile.exe " + EquipmentType;

		try {
			Runtime.getRuntime().exec(upload_EquipmentType1);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getLocalizedMessage());
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
		}		
		
		wait(driver,"10");
		
		Fluentwait(driver, Location3);
		
		if(isDisplayed(driver, click_yes)) {
			
			click(driver, click_yes);
			
			Fluentwait(driver, Click_ok);
			click(driver, Click_ok);
		}
		

		wait(driver, "5");

		String Total_records = getText(driver, Total_record);

		int length = Integer.parseInt(Total_records);

		boolean allPassed = true;

		for (int i = 0; i < length; i++) {

			WebElement element = driver.findElement(By.xpath("(//div[@row-id='" + i + "'])[2]//div[@col-id='eqp']"));
			act.moveToElement(element).click().build().perform();

			String text = element.getText();

			int length1 = text.length();

			if (length1 <= 4) {
				System.out.println("The text has 4 or fewer characters");
			} else {
				System.out.println("The equipment type column allowed more than 4 characters in the line - " + (i + 1)
						+ " and the value was " + text);
				Extent_fail(driver, "The equipment type column allowed more than 4 characters in the line - " + (i + 1)
						+ " and the value was " + text, test, test1);
				allPassed = false;
			}

		}

		// Print the summary result

		scrollBottom(driver);

		if (allPassed) {
			Extent_pass1(test, "The Equipment Type column not allowed more than 4 characters");
		} else {
			System.out.println("Some conditions failed.");
			Extent_fail(driver, "The Equipment Type column allowed more than 4 characters", test, test1);
		}

		System.out.println("*******************271***********");

		Extent_cal(test, "Testcase 272 - Ensure in import form excel, when Region length exceeds 4 character");

		boolean regionstatus = true;

		for (int i = 0; i < length; i++) {

			WebElement element = driver.findElement(By.xpath("(//div[@row-id='" + i + "'])[2]//div[@col-id='region']"));
			act.moveToElement(element).click().build().perform();

			String text = element.getText();

			int length1 = text.length();

			if (length1 <= 4) {
				System.out.println("The text has 4 or fewer characters");
			} else {
				System.out.println("The region column allowed more than 4 characters in the line - " + (i + 1)
						+ " and the value was " + text);
				Extent_fail(driver, "The region column allowed more than 4 characters in the line - " + (i + 1)
						+ " and the value was " + text, test, test1);
				regionstatus = false;
			}

		}

		if (regionstatus) {
			Extent_pass1(test, "The region column  not allowed more than 4 characters");
		} else {
			System.out.println("Some conditions failed.");
			Extent_fail(driver, "The region column  allowed more than 4 characters", test, test1);
		}

		scrollBottom(driver);

		Extent_cal(test, "Testcase 275 - Ensure in import form excel, when Country length exceeds 2 character");

		boolean Countrystatus = true;

		for (int i = 0; i < length; i++) {

			WebElement element = driver
					.findElement(By.xpath("(//div[@row-id='" + i + "'])[2]//div[@col-id='country']"));
			act.moveToElement(element).click().build().perform();

			String text = element.getText();

			int length1 = text.length();

			if (length1 <= 2) {
				System.out.println("The text has 2 or fewer characters");
			} else {
				System.out.println("The Country column allowed more than 4 characters in the line - " + (i + 1)
						+ " and the value was " + text);
				Extent_fail(driver, "The Country column allowed more than 4 characters in the line - " + (i + 1)
						+ " and the value was " + text, test, test1);
				Countrystatus = false;
			}

		}

		if (Countrystatus) {
			Extent_pass1(test, "The Country column not allowed more than 2 characters");
		} else {
			System.out.println("Some conditions failed.");
			Extent_fail(driver, "The Country column allowed more than 2 characters", test, test1);
		}

		System.out.println("Testcase 275 Completed");

		scrollBottom(driver);

		Extent_cal(test, "Testcase 276 - Ensure in import form excel, when Import  length exceeds 7 character");

		boolean Importstatus = true;

		for (int i = 0; i < length; i++) {

			WebElement element = driver
					.findElement(By.xpath("(//div[@row-id='" + i + "'])[2]//div[@col-id='importCnt']"));
			act.moveToElement(element).click().build().perform();

			String text = element.getText();

			int length1 = text.length();

			if (length1 <= 7) {
				System.out.println("The text has 7 or fewer characters");
			} else {
				System.out.println("The Import column allowed more than 7 characters in the line - " + (i + 1)
						+ " and the value was " + text);
				Extent_fail(driver, "The Import column allowed more than 7 characters in the line - " + (i + 1)
						+ " and the value was " + text, test, test1);
				Importstatus = false;
			}

		}

		if (Importstatus) {
			Extent_pass1(test, "The Import column not allowed more than 7 characters");
		} else {
			System.out.println("Some conditions failed.");
			Extent_fail(driver, "The Import allowed more than 7 characters", test, test1);
		}

		System.out.println("Testcase 276 Completed");

		scrollBottom(driver);

		Extent_cal(test, "Testcase 277 - Ensure in import form excel, when export length exceeds 7 character");

		boolean Exportstatus = true;

		for (int i = 0; i < length; i++) {

			WebElement element = driver.findElement(By.xpath("(//div[@row-id='" + i + "'])[2]//div[@col-id='export']"));
			act.moveToElement(element).click().build().perform();

			String text = element.getText();

			int length1 = text.length();

			if (length1 <= 7) {
				System.out.println("The text has 7 or fewer characters");
				Extent_pass(driver, "The Export column not allowed more than 7 characters in the line - " + (i + 1)
						+ " and the value was " + text, test, test1);
			} else {
				System.out.println("The Export column allowed more than 7 characters in the line - " + (i + 1)
						+ " and the value was " + text);
				Extent_fail(driver, "The Export column allowed more than 7 characters in the line - " + (i + 1)
						+ " and the value was " + text, test, test1);
				Exportstatus = false;
			}

		}

		if (Exportstatus) {
			Extent_pass1(test, "The Export column not allowed more than 7 characters");
		} else {
			System.out.println("Some conditions failed.");
			Extent_fail(driver, "The Export column allowed more than 7 characters", test, test1);
		}

		System.out.println("Testcase 277 Completed");

		scrollBottom(driver);

		Extent_cal(test,
				"Testcase 278 - Ensure in import form excel, when Bench Mark Stock length exceeds 7 character");

		boolean Benchstatus = true;

		for (int i = 0; i < length; i++) {

			WebElement element = driver.findElement(By.xpath("(//div[@row-id='" + i + "'])[2]//div[@col-id='export']"));
			act.moveToElement(element).click().build().perform();

			String text = element.getText();

			int length1 = text.length();

			if (length1 <= 7) {
				System.out.println("The text has 7 or fewer characters");
				Extent_pass(driver, "The Benchmark stock column not allowed more than 7 characters in the line - "
						+ (i + 1) + " and the value was " + text, test, test1);
			} else {
				System.out.println("The Benchmark stock column allowed more than 7 characters in the line - " + (i + 1)
						+ " and the value was " + text);
				Extent_fail(driver, "The Benchmark stock column allowed more than 7 characters in the line - " + (i + 1)
						+ " and the value was " + text, test, test1);
				Benchstatus = false;
			}

		}

		if (Benchstatus) {
			Extent_pass1(test, "The Benchmark stock column not allowed more than 7 characters");
		} else {
			System.out.println("Some conditions failed.");
			Extent_fail(driver, "The Benchmark stock column allowed more than 7 characters", test, test1);
		}

		System.out.println("Testcase 278 Completed");

		Extent_cal(test,
				"Testcae 279 - Ensure in import form excel, when Applied Surplus/Deficit length exceeds 7 character");

		String Total_records2 = getText(driver, Total_record);

		int length2 = Integer.parseInt(Total_records2);

		boolean appliedstatus = true;

		for (int i = 0; i < length2; i++) {

			WebElement element = driver
					.findElement(By.xpath("(//div[@row-id='" + i + "'])[2]//div[@col-id='appsurdef']"));
			act.moveToElement(element).click().build().perform();

			String text = element.getText();

			int length1 = text.length();

			if (length1 <= 7) {
				System.out.println("The text has 7 or fewer characters");
			} else {
				System.out.println("The Applied surplus/deficit column allowed more than 7 characters in the line - "
						+ (i + 1) + " and the value was " + text);
				Extent_fail(driver, "The Applied surplus/deficit column allowed more than 7 characters in the line - "
						+ (i + 1) + " and the value was " + text, test, test1);
				appliedstatus = false;
			}

		}

		scrollBottom(driver);

		if (appliedstatus) {
			Extent_pass1(test, "The Applied surplus/deficit column not allowed more than 7 characters");
		} else {
			System.out.println("Some conditions failed.");
			Extent_fail(driver, "The Applied surplus/deficit column allowed more than 7 characters", test, test1);
		}

		System.out.println("Testcase 279 Completed");

		Extent_cal(test, "Testcase 282 - Ensure in import form excel, when One Way Qty length exceeds 7 character");

		boolean Oneway = true;

		List<String> filter_columnnames = Arrays.asList("onewayoutload", "onewayoutreturn", "onewaylease", "tboh",
				"sali");
		List<String> column_names = Arrays.asList("onewayoutload", "onewayout return", "One way in load",
				"One way in trans", "One way in return");

		WebElement scroller = driver.findElement(By.xpath("//div[@ref='eBodyHorizontalScrollViewport']"));
		// Scroll to the specified coordinates (x, y)
		int scrollAmount = 1500; // Replace with the amount you want to scroll

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller, scrollAmount);

		for (int j = 0; j < 5; j++) {

			String column_name = filter_columnnames.get(j);
			String Columns = column_names.get(j);

			for (int i = 0; i < length2; i++) {

				WebElement element = driver
						.findElement(By.xpath("(//div[@row-id='" + i + "'])[2]//div[@col-id='" + column_name + "']"));
				act.moveToElement(element).click().build().perform();

				String text = element.getText();

				int length1 = text.length();

				if (length1 <= 7) {
					System.out.println("The text has 7 or fewer characters");
				} else {
					System.out.println("The One Way Qty column allowed more than 7 characters in the line - " + (i + 1)
							+ " and the value was " + text);
					Extent_fail(driver, "The One Way Qty column allowed more than 7 characters in the line - " + (i + 1)
							+ " and the value was " + text, test, test1);
					appliedstatus = false;
				}

			}

			WebElement Scroller = driver.findElement(By.xpath("(//div[@ref='eBodyViewport'])[1]"));

			((JavascriptExecutor) driver).executeScript("arguments[0].scrollTop = 0;", Scroller);

			if (Oneway) {
				Extent_pass(driver, Columns + " column not allowed more than 7 characters", test, test1);
			} else {
				System.out.println("Some conditions failed.");
				Extent_fail(driver, Columns + " column allowed more than 7 characters", test, test1);
			}

		}

		System.out.println("Testcase 282 Completed");

		Extent_cal(test, "Testcase 287 - Ensure in import form excel, when Stock Status length exceeds 7 character");

		boolean Stockstatus = true;

		HorizontalScrollFull(driver, Horizontal_gridscroll);

		String Total_records3 = getText(driver, Total_record);

		int length3 = Integer.parseInt(Total_records3);

		for (int i = 0; i < length3; i++) {

			WebElement element = driver
					.findElement(By.xpath("(//div[@row-id='" + i + "'])[2]//div[@col-id='appsurdef']"));
			act.moveToElement(element).click().build().perform();

			String text = element.getText();

			int length1 = text.length();

			if (length1 <= 7) {
				System.out.println("The text has 7 or fewer characters");
			} else {
				System.out.println("The Stockstatus column allowed more than 7 characters in the line - " + (i + 1)
						+ " and the value was " + text);
				Extent_fail(driver, "The Stockstatus column allowed more than 7 characters in the line - " + (i + 1)
						+ " and the value was " + text, test, test1);
				Stockstatus = false;
			}

		}

		scrollBottom(driver);

		if (Stockstatus) {
			Extent_pass1(test, "The Stockstatus column not allowed more than 7 characters");
		} else {
			System.out.println("Some conditions failed.");
			Extent_fail(driver, "The Stockstatus column allowed more than 7 characters", test, test1);

		}

		System.out.println("Testcase 287 Completed");

		Extent_cal(test,
				"Testcase 280 - Ensure in import form excel, when MLA ONHI length exceeds 7 character & Testcase 283 - Ensure in import form excel, when TBOH/OFHI  length exceeds 7 character");

		Fluentwait(driver, Searchbox);
		sendKeys(driver, Searchbox, "On Off Hire Stock");

		Fluentwait(driver, OnOFF_Hire);
		click(driver, OnOFF_Hire);

		Fluentwait(driver, Total_columnrecord);
		String OnOFF_Total_records = getText(driver, Total_columnrecord);

		int OnOFF_length = Integer.parseInt(OnOFF_Total_records);

		boolean OnOffhire_length = true;

		for (int i = 0; i < 10; i++) {

			WebElement element = driver.findElement(By.xpath(
					"//div[@id='OHS-OHS_aggrid_tbl']//following::div[@row-id='" + i + "']//div[@col-id='count']"));

			act.moveToElement(element).click().build().perform();

			String text = element.getText();

			int length1 = text.length();

			if (length1 <= 7) {
				System.out.println("The text has 7 or fewer characters");
			} else {
				System.out.println("The On/Off hire column allowed more than 7 characters in the line - " + (i + 1)
						+ " and the value was " + text);
				Extent_fail(driver, "The On/Off hire column allowed more than 7 characters in the line - " + (i + 1)
						+ " and the value was " + text, test, test1);
				OnOffhire_length = false;
			}

		}

		scrollBottom(driver);

		if (OnOffhire_length) {
			Extent_pass1(test, "The On/Off hire column not allowed more than 7 characters");
		} else {
			System.out.println("Some conditions failed.");
			Extent_fail(driver, "The On/Off hire column allowed more than 7 characters", test, test1);
		}

		System.out.println("Testcase 280 & 283 Completed");

	}

}
