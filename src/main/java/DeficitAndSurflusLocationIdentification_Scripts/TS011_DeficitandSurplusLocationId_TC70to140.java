package DeficitAndSurflusLocationIdentification_Scripts;

import java.awt.Robot;
import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.Utils;

public class TS011_DeficitandSurplusLocationId_TC70to140 extends Keywords {

	@SuppressWarnings("deprecation")
	public void Scenario11(WebDriver driver, ExtentTest test, ExtentTest test1, String url, int dataset)
			throws Exception {

		String Username = Utils.getDataFromTestData("TS011_DeficitandSurplusLocationIdentification_Dataset" + dataset,
				"DeficitandSurplusLocationId", "Username");
		String Password = Utils.getDataFromTestData("TS011_DeficitandSurplusLocationIdentification_Dataset" + dataset,
				"DeficitandSurplusLocationId", "Password");
		String ID = Utils.getDataFromTestData("TS011_DeficitandSurplusLocationIdentification_Dataset" + dataset,
				"DeficitandSurplusLocationId", "Id");
		String Fromyear_alphabet = Utils.getDataFromTestData(
				"TS011_DeficitandSurplusLocationIdentification_Dataset" + dataset, "DeficitandSurplusLocationId",
				"Fromyear_alphabet");
		String From_Year = Utils.getDataFromTestData("TS011_DeficitandSurplusLocationIdentification_Dataset" + dataset,
				"DeficitandSurplusLocationId", "From_Year");
		String From_special = Utils.getDataFromTestData(
				"TS011_DeficitandSurplusLocationIdentification_Dataset" + dataset, "DeficitandSurplusLocationId",
				"From_special");
		String FromWeek = Utils.getDataFromTestData("TS011_DeficitandSurplusLocationIdentification_Dataset" + dataset,
				"DeficitandSurplusLocationId", "FromWeek");
		String FromWeek2 = Utils.getDataFromTestData("TS011_DeficitandSurplusLocationIdentification_Dataset" + dataset,
				"DeficitandSurplusLocationId", "FromWeek2");
		String Fromweek_alphabet = Utils.getDataFromTestData(
				"TS011_DeficitandSurplusLocationIdentification_Dataset" + dataset, "DeficitandSurplusLocationId",
				"Fromweek_alphabet");
		String Fromweek_special = Utils.getDataFromTestData(
				"TS011_DeficitandSurplusLocationIdentification_Dataset" + dataset, "DeficitandSurplusLocationId",
				"Fromweek_special");
		String Toyear_alphabet = Utils.getDataFromTestData(
				"TS011_DeficitandSurplusLocationIdentification_Dataset" + dataset, "DeficitandSurplusLocationId",
				"Toyear_alphabet");
		String To_year = Utils.getDataFromTestData("TS011_DeficitandSurplusLocationIdentification_Dataset" + dataset,
				"DeficitandSurplusLocationId", "To_year");
		String Toyear_special = Utils.getDataFromTestData(
				"TS011_DeficitandSurplusLocationIdentification_Dataset" + dataset, "DeficitandSurplusLocationId",
				"Toyear_special");
		String Toweek = Utils.getDataFromTestData("TS011_DeficitandSurplusLocationIdentification_Dataset" + dataset,
				"DeficitandSurplusLocationId", "Toweek");
		String Toweek_alphabet = Utils.getDataFromTestData(
				"TS011_DeficitandSurplusLocationIdentification_Dataset" + dataset, "DeficitandSurplusLocationId",
				"Toweek_alphabet");
		String Toweek_special = Utils.getDataFromTestData(
				"TS011_DeficitandSurplusLocationIdentification_Dataset" + dataset, "DeficitandSurplusLocationId",
				"Toweek_special");

		String appsurdef_alphabet = Utils.getDataFromTestData(
				"TS011_DeficitandSurplusLocationIdentification_Dataset" + dataset, "DeficitandSurplusLocationId",
				"appsurdef_alphabet");
		String appsurdef_value = Utils.getDataFromTestData(
				"TS011_DeficitandSurplusLocationIdentification_Dataset" + dataset, "DeficitandSurplusLocationId",
				"appsurdef_value");
		String appsurdef_special = Utils.getDataFromTestData(
				"TS011_DeficitandSurplusLocationIdentification_Dataset" + dataset, "DeficitandSurplusLocationId",
				"appsurdef_special");

		String Import_file = System.getProperty("user.dir") + "\\uploads\\Location_Alphabets.xlsx";
		String Numerical_Val = System.getProperty("user.dir") + "\\uploads\\Location_Numeric.xlsx";
		String Special_character = System.getProperty("user.dir") + "\\uploads\\Location_Specialcharacter.xlsx";
		String EquimentType_Alphabets = System.getProperty("user.dir") + "\\uploads\\EquimentType_Alphabets.xlsx";
		String EquimentType_specialcharacter = System.getProperty("user.dir")
				+ "\\uploads\\EquimentType_specialcharacter.xlsx";

		String Import_alphabets = System.getProperty("user.dir") + "\\uploads\\Import_alphabet.xlsx";
		String Import_specialcharacter = System.getProperty("user.dir") + "\\uploads\\Import_specialcharacter.xlsx";
		String EquimentType_Alphabets1 = System.getProperty("user.dir") + "\\uploads\\Budget_Flow_Applied.xlsx";

		Actions act = new Actions(driver);
		Robot rbt = new Robot();

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

		wait(driver, "3");

		Fluentwait(driver, Searchbox);
		sendKeys(driver, Searchbox, "Deficit and Surplus Location Identification");

		Fluentwait(driver, Selectdeficit);
		click(driver, Selectdeficit);

		wait(driver, "5");

		Fluentwait(driver, Cancel);
		click(driver, Cancel);

		wait(driver, "5");

		Fluentwait(driver, New);
		click(driver, New);

		Fluentwait(driver, createnew_confirm);
		click(driver, createnew_confirm);

		wait(driver, "3");

		Extent_cal(test, "Testcase 70 - Ensure in From Year field");

		Fluentwait(driver, From_Year_Field);

		String defaultyear = getAttribute(driver, From_Year_Field, "aria-valuenow");

		int default_year = Integer.parseInt(defaultyear);

		int Expected = default_year + 1;

		String Expectedyear = String.valueOf(Expected);

		Fluentwait(driver, IncreaseYear);
		click(driver, IncreaseYear);

		String actualyear = getAttribute(driver, From_Year_Field, "aria-valuenow");

		boolean fromy_ear = true;

		if (actualyear.equals(Expectedyear)) {

			Extent_pass(driver, "Increasing of the from year button is working fine", test, test1);
			System.out.println("Matched || Expected year : " + Expectedyear + " || Actual year : " + actualyear);
			Extent_pass(driver, "Matched || Expected year : " + Expectedyear + " || Actual year : " + actualyear, test,
					test1);
		} else {

			Extent_fail(driver, "Increasing of the from year button is not working", test, test1);
			System.out.println("Not Matched || Expected year : " + Expectedyear + " || Actual year : " + actualyear);
			Extent_fail(driver, "Not Matched || Expected year : " + Expectedyear + " || Actual year : " + actualyear,
					test, test1);
			fromy_ear = false;
		}

		Fluentwait(driver, From_Year_Field);
		String defaultyear2 = getAttribute(driver, From_Year_Field, "aria-valuenow");

		int default_year2 = Integer.parseInt(defaultyear2);

		int Expected2 = default_year2 - 1;

		String Expectedyear2 = String.valueOf(Expected2);

		Fluentwait(driver, DecreaseYear);
		click(driver, DecreaseYear);

		String actualyear2 = getAttribute(driver, From_Year_Field, "aria-valuenow");

		if (Expectedyear2.equals(actualyear2)) {

			Extent_pass(driver, "Decreasing of the from year button is working fine", test, test1);
			System.out.println("Matched || Expected year : " + Expectedyear2 + " || Actual year : " + actualyear2);
			Extent_pass(driver, "Matched || Expected year : " + Expectedyear2 + " || Actual year : " + actualyear2,
					test, test1);
		} else {

			Extent_fail(driver, "Decreasing of the from year button is not working", test, test1);
			System.out.println("Not Matched || Expected year : " + Expectedyear2 + " || Actual year : " + actualyear2);
			Extent_fail(driver, "Not Matched || Expected year : " + Expectedyear2 + " || Actual year : " + actualyear2,
					test, test1);
			fromy_ear = false;
		}

		if (fromy_ear) {
			Extent_pass(driver, "From year field is working fine", test, test1);
		} else {
			Extent_fail(driver, "From year field is not working fine", test, test1);
		}

		System.out.println("********************Testcase 70 Completed *******************");

		Extent_cal(test, "Testcase 73 - Ensure in  From Year field not allow alphabets");

		Fluentwait(driver, From_Year_Field);
		click(driver, From_Year_Field);

		act.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
		wait(driver, "1");
		act.sendKeys(Keys.BACK_SPACE).perform();

		wait(driver, "2");

		sendKeys(driver, From_Year_Field, Fromyear_alphabet);

		click(driver, Toyear_input);

		wait(driver, "5");

		if (isDisplayed(driver, Yearwarining_popup)) {

			String message = getText(driver, Yearwarining_popupmessage);
			System.out.println("Year field not allow the alphabet characters and got the warning popup " + message);
			Extent_pass(driver, "Year field not allow the alphabet characters and got the warning popup " + message,
					test, test1);

			Fluentwait(driver, Click_Okay);
			click(driver, Click_Okay);

		} else {

			System.out.println("Year field allowed the alphabet characters");
			Extent_fail(driver, "Year field allowed the alphabet characters", test, test1);

		}

		System.out.println("******************Testcase 73 completed************");

		Extent_cal(test, "Testcase 74 - Ensure in From Year  field allow numeric");

		Fluentwait(driver, From_Year_Field);
		click(driver, From_Year_Field);

		String fromyear = From_Year;
		wait(driver, "2");

		act.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
		wait(driver, "1");
		act.sendKeys(Keys.BACK_SPACE).perform();

		wait(driver, "2");

		sendKeys(driver, From_Year_Field, fromyear);

		click(driver, Toyear_input);

		wait(driver, "2");

		String Changedyear = getAttribute(driver, From_Year_Field, "aria-valuenow");

		System.out.println("Actualyear :" + Changedyear);

		if (Changedyear.equals(fromyear)) {

			System.out.println("Year field is allowing the numeric values");
			Extent_pass(driver, "Year field is allowing the numeric values", test, test1);

		} else {

			System.out.println("Year field is not allowing the numeric values");
			Extent_fail(driver, "Year field is not allowing the numeric values", test, test1);

		}

		System.out.println("******************Testcase 74 completed************");

		Extent_cal(test, "Testcase 75 - Ensure in From Year field not allow Special character");

		Fluentwait(driver, From_Year_Field);
		click(driver, From_Year_Field);

		wait(driver, "2");

		act.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
		wait(driver, "1");
		act.sendKeys(Keys.BACK_SPACE).perform();
		wait(driver, "2");

		sendKeys(driver, From_Year_Field, From_special);

		click(driver, Toyear_input);

		wait(driver, "5");

		if (isDisplayed(driver, Yearwarining_popup)) {

			String message = getText(driver, Yearwarining_popupmessage);

			System.out.println("Year field not allow the alphabet characters and got the warning popup " + message);
			Extent_pass(driver, "Year field not allow the alphabet characters and got the warning popup " + message,
					test, test1);

			Fluentwait(driver, Click_Okay);
			click(driver, Click_Okay);

		} else {

			System.out.println("Year field allowed the alphabet characters");
			Extent_fail(driver, "Year field allowed the alphabet characters", test, test1);

		}

		System.out.println("*************Testcase 75 Completed ********************");

		Extent_cal(test, "Testcase 76 - Ensure in From Week field");

		Fluentwait(driver, Fromweek_input);
		click(driver, Fromweek_input);

		wait(driver, "2");

		clear(driver, Fromweek_input);

		wait(driver, "2");
		sendKeys(driver, Fromweek_input, FromWeek);

		wait(driver, "5");

		String Changeweek = getAttribute(driver, Fromweek_input, "value");

		if (Changeweek.equals(FromWeek)) {

			System.out.println("Matched || Expected from week : " + FromWeek + " Actual from week : " + Changeweek);
			Extent_pass(driver, "Matched || Expected from week : " + FromWeek + " Actual from week : " + Changeweek,
					test, test1);
			Extent_pass(driver, "From week field is allow to enter the values", test, test1);

		} else {

			System.out.println("Not Matched || Expected from week : " + FromWeek + " Actual from week : " + Changeweek);
			Extent_fail(driver, "Not Matched || Expected from week : " + FromWeek + " Actual from week : " + Changeweek,
					test, test1);
		}

		System.out.println("************Testcase 76 Completed ****************");

		Extent_cal(test, "Testcase 79 - Ensure in  From Week field not allow alphabets");

		Fluentwait(driver, Fromweek_input);
		clear(driver, Fromweek_input);

		wait(driver, "2");
		sendKeys(driver, Fromweek_input, Fromweek_alphabet);

		wait(driver, "5");

		String Alphabet_input = getAttribute(driver, Fromweek_input, "value");

		if (!Alphabet_input.equals(Fromweek_alphabet)) {

			System.out.println("From week field is not allowing alphabets");
			Extent_pass(driver, "From week field is not allowing alphabets", test, test1);

		} else {

			System.out.println("From week field is allowed to enter the alphabets");
			Extent_fail(driver, "From week field is allowed to enter the alphabets", test, test1);
		}

		System.out.println("************Testcase 79 Completed ****************");

		Extent_cal(test, "Testcase 80 - Ensure in From Week  field allow numeric");

		Fluentwait(driver, Fromweek_input);
		clear(driver, Fromweek_input);

		wait(driver, "2");
		sendKeys(driver, Fromweek_input, FromWeek2);

		wait(driver, "5");

		String Numeric_input = getAttribute(driver, Fromweek_input, "value");

		if (Numeric_input.equals(FromWeek2)) {

			System.out.println("From week field is allowing numeric values");
			Extent_pass(driver, "From week field is allowing numeric values", test, test1);

		} else {

			System.out.println("From week field is not allowing numeric values");
			Extent_fail(driver, "From week field is not allowing numeric values", test, test1);
		}

		System.out.println("************Testcase 80 Completed ****************");

		Extent_cal(test, "Testcase 81 - Ensure in  From Week field not allow Special character");

		Fluentwait(driver, Fromweek_input);
		clear(driver, Fromweek_input);

		wait(driver, "2");
		sendKeys(driver, Fromweek_input, Fromweek_special);

		wait(driver, "5");

		String Specialcharacter = getAttribute(driver, Fromweek_input, "value");

		if (!Specialcharacter.equals(Fromweek_special)) {

			System.out.println("From week field is not allowing Special characters");
			Extent_pass(driver, "From week field is not allowing Special characters", test, test1);

		} else {

			System.out.println("From week field is allowing Special characters");
			Extent_fail(driver, "From week field is not allowing Special characters", test, test1);
		}

		System.out.println("************Testcase 81 Completed ****************");

		Extent_cal(test, "Testcase 88 - Ensure in To Year field");

		Fluentwait(driver, Toyear_input);

		String defaultToyear = getAttribute(driver, Toyear_input, "aria-valuenow");

		int default_Toyear = Integer.parseInt(defaultToyear);

		int Expected_To = default_Toyear + 1;

		String Expected_Toyear = String.valueOf(Expected_To);

		Fluentwait(driver, Increase_ToYear);
		click(driver, Increase_ToYear);

		String actual_toyear = getAttribute(driver, Toyear_input, "aria-valuenow");

		if (Expected_Toyear.equals(actual_toyear)) {

			Extent_pass(driver, "Increasing of the To year button is working fine", test, test1);
			System.out.println(
					"Matched || Expected To year : " + Expected_Toyear + " || Actual To year : " + actual_toyear);
			Extent_pass(driver,
					"Matched || Expected To year : " + Expected_Toyear + " || Actual To year : " + actual_toyear, test,
					test1);
		} else {

			Extent_fail(driver, "Increasing of the To year button is not working", test, test1);
			System.out.println(
					"Not Matched || Expected To year : " + Expected_Toyear + " || Actual To year : " + actual_toyear);
			Extent_fail(driver,
					"Not Matched || Expected To year : " + Expected_Toyear + " || Actual To year : " + actual_toyear,
					test, test1);
		}

		Fluentwait(driver, Toyear_input);

		String defaultToyear2 = getAttribute(driver, Toyear_input, "aria-valuenow");

		int default_Toyear2 = Integer.parseInt(defaultToyear2);

		int Expected_toyear2 = default_Toyear2 - 1;

		String Expected_Toyear2 = String.valueOf(Expected_toyear2);

		Fluentwait(driver, Decrease_ToYear);
		click(driver, Decrease_ToYear);

		String actual_toyear2 = getAttribute(driver, Toyear_input, "aria-valuenow");

		if (Expected_Toyear2.equals(actual_toyear2)) {

			Extent_pass(driver, "Decreasing of the To year button is working fine", test, test1);
			System.out.println(
					"Matched || Expected To year : " + Expected_Toyear2 + " || Actual To year : " + actual_toyear2);
			Extent_pass(driver,
					"Matched || Expected To year : " + Expected_Toyear2 + " || Actual To year : " + actual_toyear2,
					test, test1);
		} else {

			Extent_fail(driver, "Decreasing of the To year button is not working", test, test1);
			System.out.println(
					"Not Matched || Expected To year : " + Expected_Toyear2 + " || Actual To year : " + actual_toyear2);
			Extent_fail(driver,
					"Not Matched || Expected To year : " + Expected_Toyear2 + " || Actual To year : " + actual_toyear2,
					test, test1);
		}

		System.out.println("********************Testcase 88 Completed *******************");

		Extent_cal(test, "Testcase 91 - Ensure in  To Year field not allow alphabets");

		Fluentwait(driver, Toyear_input);
		click(driver, Toyear_input);

		wait(driver, "3");

		act.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
		wait(driver, "1");
		act.sendKeys(Keys.BACK_SPACE).perform();
		wait(driver, "2");

		sendKeys(driver, Toyear_input, Toyear_alphabet);

		click(driver, From_Year_Field);

		wait(driver, "5");

		if (isDisplayed(driver, Yearwarining_popup)) {

			String message = getText(driver, Yearwarining_popupmessage);
			System.out.println("To Year field not allow the alphabet characters and got the warning popup " + message);
			Extent_pass(driver, "To year field not allow the alphabet characters and got the warning popup " + message,
					test, test1);

			Fluentwait(driver, Click_Okay);
			click(driver, Click_Okay);

		} else {

			System.out.println("To year field allowed the alphabet characters");
			Extent_fail(driver, "To year field allowed the alphabet characters", test, test1);

		}

		System.out.println("******************Testcase 91 completed************");

		Extent_cal(test, "Testcase 92 - Ensure in To Year field allow numeric");

		Fluentwait(driver, Toyear_input);
		click(driver, Toyear_input);

		String Toyear = To_year;

		wait(driver, "3");

		act.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
		wait(driver, "1");
		act.sendKeys(Keys.BACK_SPACE).perform();
		wait(driver, "2");

		sendKeys(driver, Toyear_input, Toyear);

		click(driver, From_Year_Field);

		String ChangedToyear = getAttribute(driver, Toyear_input, "aria-valuenow");

//		int Changed_Toyear = Integer.parseInt(ChangedToyear);
//		
//		int Actual_Toyear = Changed_Toyear+1;
//		
//		String ActualToYear = String.valueOf(Actual_Toyear);

		if (ChangedToyear.equals(Toyear)) {

			System.out.println("To year field is allowing the numeric characters");
			Extent_pass(driver, "To year field is allowing the numeric characters", test, test1);

		} else {

			System.out.println("To year field is not allowing the numeric characters");
			Extent_fail(driver, "To year field is not allowing the numeric characters", test, test1);

		}

		System.out.println("******************Testcase " + " completed************");

		Extent_cal(test, "Testcase 93 - Ensure in To Year field not allow Special character");

		Fluentwait(driver, Toyear_input);
		click(driver, Toyear_input);

		wait(driver, "3");

		act.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
		wait(driver, "1");
		act.sendKeys(Keys.BACK_SPACE).perform();
		wait(driver, "2");

		sendKeys(driver, Toyear_input, Toyear_special);

		click(driver, From_Year_Field);

		wait(driver, "5");

		if (isDisplayed(driver, Yearwarining_popup)) {

			String message = getText(driver, Yearwarining_popupmessage);

			System.out.println("To year field not allow the alphabet characters and got the warning popup " + message);
			Extent_pass(driver, "To year field not allow the alphabet characters and got the warning popup " + message,
					test, test1);

			Fluentwait(driver, Click_Okay);
			click(driver, Click_Okay);

		} else {

			System.out.println("To year field allowed the alphabet characters");
			Extent_fail(driver, "To year field allowed the alphabet characters", test, test1);

		}

		System.out.println("*************Testcase 93 Completed ********************");

		Extent_cal(test, "Testcase 94 - Ensure in To Week field ");

		Fluentwait(driver, Toweek_input);
		clear(driver, Toweek_input);
		wait(driver, "2");
		sendKeys(driver, Toweek_input, Toweek);

		wait(driver, "5");

		String ChangeToweek = getAttribute(driver, Toweek_input, "value");

		if (ChangeToweek.equals(Toweek)) {

			System.out.println("Matched || Expected To week : " + Toweek + " Actual To week : " + ChangeToweek);
			Extent_pass(driver, "Matched || Expected To week : " + Toweek + " Actual To week : " + ChangeToweek, test,
					test1);
			Extent_pass(driver, "To week field is working fine", test, test1);
		} else {

			System.out.println("Not Matched || Expected To week : " + Toweek + " Actual To week : " + ChangeToweek);
			Extent_fail(driver, "Not Matched || Expected To week : " + Toweek + " Actual To week : " + ChangeToweek,
					test, test1);
		}

		System.out.println("************Testcase 94 Completed ****************");

		Extent_cal(test, "Testcase 97 - Ensure in  To Week field not allow alphabets");

		Fluentwait(driver, Toweek_input);
		clear(driver, Toweek_input);
		wait(driver, "2");
		sendKeys(driver, Toweek_input, Toweek_alphabet);

		wait(driver, "5");

		String ToWeek_Alphabet_input = getAttribute(driver, Toweek_input, "value");

		if (!ToWeek_Alphabet_input.equals(Toweek_alphabet)) {

			System.out.println(
					"Matched || Expected To week : " + Toweek_alphabet + " Actual To week : " + ToWeek_Alphabet_input);
			Extent_pass(driver,
					"Matched || Expected To week : " + Toweek_alphabet + " Actual To week : " + ToWeek_Alphabet_input,
					test, test1);
			Extent_pass(driver, "To week field not allow alphabets", test, test1);
		} else {

			System.out.println("Not Matched || Expected To week : " + Toweek_alphabet + " Actual To week : "
					+ ToWeek_Alphabet_input);
			Extent_fail(driver, "Not Matched || Expected To week : " + Toweek_alphabet + " Actual To week : "
					+ ToWeek_Alphabet_input, test, test1);
			Extent_fail(driver, "To week field allow alphabets", test, test1);
		}

		System.out.println("************Testcase 97 Completed ****************");

		Extent_cal(test, "Testcase 98 - Ensure in To Week  field allow numeric");

		Fluentwait(driver, Toweek_input);
		clear(driver, Toweek_input);

		wait(driver, "2");
		sendKeys(driver, Toweek_input, Toweek);

		wait(driver, "5");

		String Toweeknumeric = getAttribute(driver, Toweek_input, "value");

		if (Toweeknumeric.equals(Toweek)) {

			System.out.println("Matched || Expected To week : " + Toweek + " Actual To week : " + Toweeknumeric);
			Extent_pass(driver, "Matched || Expected To week : " + Toweek + " Actual To week : " + Toweeknumeric, test,
					test1);
			Extent_pass(driver, "To week field allowing numeric values", test, test1);

		} else {

			System.out.println("Not Matched || Expected To week : " + Toweek + " Actual To week : " + Toweeknumeric);
			Extent_fail(driver, "Not Matched || Expected To week : " + Toweek + " Actual To week : " + Toweeknumeric,
					test, test1);
			Extent_fail(driver, "To week field not allowing numeric values", test, test1);
		}

		System.out.println("************Testcase 98 Completed ****************");

		Extent_cal(test, "Testcase 99 - Ensure in  To Week field not allow Special character");

		Fluentwait(driver, Toweek_input);
		clear(driver, Toweek_input);

		wait(driver, "2");
		sendKeys(driver, Toweek_input, Toweek_special);

		wait(driver, "5");

		String ToweekSpecialcharacter = getAttribute(driver, Toweek_input, "value");

		if (!ToweekSpecialcharacter.equals(Toweek_special)) {

			System.out.println("To Week field not allowing special characters");
			Extent_pass(driver, "To Week field not allowing special characters", test, test1);

		} else {

			System.out.println("To Week field allowing special characters");
			Extent_fail(driver, "To Week field allowing special characters", test, test1);
		}

		System.out.println("************Testcase 99 Completed ****************");

		Extent_cal(test, "Testcase 106 - Ensure in rule imbalance text field ");

		Fluentwait(driver, Searchbox);
		sendKeys(driver, Searchbox, "Ero Rule Builder");

		Fluentwait(driver, Rulebuilder);
		click(driver, Rulebuilder);

		waitForElement(driver, EMS_Formula);
		String EmsFormula = getText(driver, EMS_Formula);

		System.out.println("EmsFormula : " + EmsFormula);

		if (EmsFormula.equals("#IMPORT#-#EXPORT#")) {

			System.out.println("Rule imbalance formula was displayed");
			Extent_pass(driver, "Rule imbalance formula was displayed", test, test1);
		} else {

			System.out.println("Rule imbalance formula was not displayed");
			Extent_fail(driver, "Rule imbalance formula was not displayed", test, test1);
		}

		if (!isClear(driver, EMS_Formula)) {

			System.out.println("Unable to edit the Ems rule imbalance formula");
			Extent_pass(driver, "Unable to edit the Ems rule imbalance formula", test, test1);

		} else {

			System.out.println("User can able to edit the Ems rule imbalance formula");
			Extent_fail(driver, "User can able to edit the Ems rule imbalance formula", test, test1);
		}

		System.out.println("Testcase 106 Completed");

		Extent_cal(test, "Testcase 109 - Ensure in Applied Surplus /Deficit field into the  grid");

		Fluentwait(driver, Deficittab);
		click(driver, Deficittab);

		Fluentwait(driver, Globalserach);
		click(driver, Globalserach);

		Fluentwait(driver, Globalserach_IDInput);
		sendKeys(driver, Globalserach_IDInput, ID);

		wait(driver, "2");

		Fluentwait(driver, Click_Search);
		click(driver, Click_Search);

		wait(driver, "5");

		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);

		wait(driver, "5");

		String Total_records = getText(driver, Total_record);

		int length = Integer.parseInt(Total_records);

		WebElement scroller = driver.findElement(By.xpath("//div[@ref='eBodyHorizontalScrollViewport']"));
		// Scroll to the specified coordinates (x, y)
		int scrollAmount = 1000; // Replace with the amount you want to scroll

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller, scrollAmount);

		boolean appsurf = true;

		for (int i = 0; i < 3; i++) {

			WebElement element = driver
					.findElement(By.xpath("(//div[@row-id='" + i + "'])[2]//div[@col-id='appsurdef']"));

			element.click();

			act.moveToElement(element).doubleClick().build().perform();

			act.moveToElement(element).click().keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
					.sendKeys(Keys.BACK_SPACE).build().perform();

			act.moveToElement(element).sendKeys(appsurdef_value).build().perform();

			enter(driver);

			String changedvalue = getText(driver, Appliedsurplus);

			System.out.println("changedvalue : " + changedvalue);

			if (changedvalue.equals(appsurdef_value)) {

				System.out
						.println("Applied surplus/deficit field is allowing to enter the value in the row " + (i + 1));
				Extent_pass(driver,
						"Applied surplus/deficit field is allowing to enter the value in the row " + (i + 1), test,
						test1);

			} else {

				System.out.println(
						"Applied surplus/deficit field is not allowing to enter the value in the row " + (i + 1));
				Extent_fail(driver,
						"Applied surplus/deficit field is not allowing to enter the value in the row " + (i + 1), test,
						test1);
				appsurf = false;
			}

		}

		if (appsurf) {

			System.out.println("Applied surplus/deficit field is allowing to enter the value in the grid");
			Extent_pass(driver, "Applied surplus/deficit field is allowing to enter the value in the grid", test,
					test1);

		} else {

			System.out.println("Applied surplus/deficit field is not allowing to enter the value in the grid");
			Extent_fail(driver, "Applied surplus/deficit field is not allowing to enter the value in the grid", test,
					test1);

		}

		System.out.println("*******************Testcase 109 completed*******************");

		Extent_cal(test, "Testcase 112 - Ensure in  Applied Surplus /Deficit field into the  grid not allow alphabets");

		boolean appsurf_alpha = true;

		for (int i = 0; i < 3; i++) {

			WebElement element = driver
					.findElement(By.xpath("(//div[@row-id='" + i + "'])[2]//div[@col-id='appsurdef']"));

			element.click();

			act.moveToElement(element).doubleClick().build().perform();

			act.moveToElement(element).click().keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
					.sendKeys(Keys.BACK_SPACE).build().perform();

			act.moveToElement(element).sendKeys(appsurdef_alphabet).build().perform();

			enter(driver);

			String changedvalue = getText(driver, Appliedsurplus);

			System.out.println("changedvalue : " + changedvalue);

			if (!changedvalue.equals(appsurdef_alphabet)) {

				System.out.println(
						"Applied surplus/deficit field is not allowing to enter the alphabet values in the row "
								+ (i + 1));
				Extent_pass(driver,
						"Applied surplus/deficit field is not allowing to enter the alphabet values in the row "
								+ (i + 1),
						test, test1);

			} else {

				System.out.println(
						"Applied surplus/deficit field is allowing to enter the alphabet values in the row " + (i + 1));
				Extent_fail(driver,
						"Applied surplus/deficit field is allowing to enter the alphabet values in the row " + (i + 1),
						test, test1);
				appsurf_alpha = false;
			}

		}

		if (appsurf_alpha) {

			Extent_pass(driver, "Applied surplus/deficit field is not allowing to enter the alphabet values", test,
					test1);

		} else {

			Extent_fail(driver, "Applied surplus/deficit field is allowing to enter the alphabet values", test, test1);
		}

		System.out.println("*****************Testcase 112 Completed **************************");

		Extent_cal(test, "Testcase 113 - Ensure in Applied Surplus /Deficit   field into the  grid allow numeric");

		boolean appsurf_numeric = true;

		for (int i = 0; i < 3; i++) {

			WebElement element = driver
					.findElement(By.xpath("(//div[@row-id='" + i + "'])[2]//div[@col-id='appsurdef']"));

			element.click();

			act.moveToElement(element).doubleClick().build().perform();

			act.moveToElement(element).click().keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
					.sendKeys(Keys.BACK_SPACE).build().perform();

			String value = "12";

			act.moveToElement(element).sendKeys(value).build().perform();

			enter(driver);

			String changedvalue = getText(driver, Appliedsurplus);

			System.out.println("changedvalue : " + changedvalue);

			if (changedvalue.equals(value)) {

				System.out.println("Applied surplus/deficit field is allowing to enter the Numerical values in the row "
						+ (i + 1));
				Extent_pass(driver,
						"Applied surplus/deficit field is allowing to enter the Numerical values in the row" + (i + 1),
						test, test1);

			} else {

				System.out.println(
						"Applied surplus/deficit field is not allowing to enter the Numerical values in the row"
								+ (i + 1));
				Extent_fail(driver,
						"Applied surplus/deficit field is not allowing to enter the Numerical values in the row"
								+ (i + 1),
						test, test1);
				appsurf_numeric = false;

			}

		}

		if (appsurf_numeric) {

			Extent_pass(driver, "Applied surplus/deficit field is allowing to enter the Numerical values", test, test1);
		} else {

			Extent_fail(driver, "Applied surplus/deficit field is not allowing to enter the Numerical values", test,
					test1);
		}

		System.out.println("******************Testcase 113 Completed ****************************");

		Extent_cal(test,
				"Testcase 114 - Ensure in  Applied Surplus /Deficit  field into the  grid not allow Special character");

		boolean appsurf_special = true;

		for (int i = 0; i < 3; i++) {

			WebElement element = driver
					.findElement(By.xpath("(//div[@row-id='" + i + "'])[2]//div[@col-id='appsurdef']"));

			element.click();

			act.moveToElement(element).doubleClick().build().perform();

			act.moveToElement(element).click().keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
					.sendKeys(Keys.BACK_SPACE).build().perform();

			act.moveToElement(element).sendKeys(appsurdef_special).build().perform();

			enter(driver);

			String changedvalue = getText(driver, Appliedsurplus);

			System.out.println("changedvalue : " + changedvalue);

			if (!changedvalue.equals(appsurdef_special)) {

				System.out.println(
						"Applied surplus/deficit field is not allowing to enter the Special characters in the row "
								+ (i + 1));
				Extent_pass(driver,
						"Applied surplus/deficit field is not allowing to enter the Special characters in the row"
								+ (i + 1),
						test, test1);

			} else {

				System.out
						.println("Applied surplus/deficit field is allowing to enter the Special characters in the row"
								+ (i + 1));
				Extent_fail(driver,
						"Applied surplus/deficit field is allowing to enter the Special characters in the row"
								+ (i + 1),
						test, test1);
				appsurf_special = false;
			}

		}

		if (appsurf_special) {

			Extent_pass(driver, "Applied surplus/deficit field is not allowing to enter the Special characters", test,
					test1);
		} else {

			Extent_fail(driver, "Applied surplus/deficit field is allowing to enter the Special characters", test,
					test1);
		}

		System.out.println("*****************Testcase 114 - Completed******************");

		Extent_cal(test, "Testcase 115 - Ensure in ID field");

		Fluentwait(driver, New);
		click(driver, New);

		Fluentwait(driver, createnew_confirm);
		click(driver, createnew_confirm);

		wait(driver, "5");

		Fluentwait(driver, Fromweek_input);
		clear(driver, Fromweek_input);
		wait(driver, "2");
		sendKeys(driver, Fromweek_input, FromWeek);

		Fluentwait(driver, Toweek_input);
		clear(driver, Toweek_input);
		wait(driver, "2");
		sendKeys(driver, Toweek_input, Toweek);

		wait(driver, "2");

		Fluentwait(driver, Show);
		click(driver, Show);

		wait(driver, "2");

		if (isDisplayed(driver, createnew_confirm)) {

			Fluentwait(driver, createnew_confirm);
			click(driver, createnew_confirm);
		}

		wait(driver, "3");

		Fluentwait(driver, Save);
		click(driver, Save);

		Fluentwait(driver, Click_ok);
		click(driver, Click_ok);

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

//			uploadFileRobot(driver,EquimentType_Alphabets1);

			String upload_EquimentType_Alphabets1 = System.getProperty("user.dir") + "/driver/MasterDownloadfile.exe "
					+ EquimentType_Alphabets1;

			try {
				Runtime.getRuntime().exec(upload_EquimentType_Alphabets1);
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println(e.getLocalizedMessage());
				Extent_fail(driver, e.getLocalizedMessage(), test, test1);
			}

			wait(driver, "3");

			Fluentwait(driver, Location3);

			if (isDisplayed(driver, click_yes)) {

				click(driver, click_yes);

				Fluentwait(driver, Click_ok);
				click(driver, Click_ok);
			}

			wait(driver, "2");

			wait(driver, "3");
			Fluentwait(driver, ERO_Save);
			click(driver, ERO_Save);
			Fluentwait(driver, ERO_Save_ok);
			click(driver, ERO_Save_ok);
			wait(driver, "2");

		} else {
			System.out.println("popup not shown");
		}

		String Id = getAttribute(driver, IDField, "value");

		System.out.println("Auto Generated Id was : " + Id);

		String FromWeek_value = getAttribute(driver, Fromweek_input, "value");

		int fromweek = Integer.parseInt(FromWeek_value);

		String From_Week = "";

		if (fromweek < 10) {

			From_Week = "0" + String.valueOf(fromweek);
		} else {

			From_Week = FromWeek_value;
		}

		System.out.println("From_Week : " + From_Week);

		String ToWeek_value = getAttribute(driver, Toweek_input, "value");

		int To_week = Integer.parseInt(ToWeek_value);

		String To_Week = "";

		if (To_week < 10) {
			To_Week = "0" + String.valueOf(To_week);
		} else {
			To_Week = ToWeek_value;
		}

		System.out.println("To_Week : " + To_Week);

		Format formatter = new SimpleDateFormat("YYYYMMdd");
		Date date = new Date();
		String value = formatter.format(date);

		String Expected_ID = "B" + value + "-" + From_Week + "-" + To_Week + "-";

		int length1 = Id.length();

		String actual_Id = Id.substring(0, length1 - 5);

		if (actual_Id.equals(Expected_ID)) {

			System.out.println("Matched || Expected Id : " + Expected_ID + " || Actual Id : " + actual_Id);
			Extent_pass(driver, "Matched || Expected Id : " + Expected_ID + " || Actual Id : " + actual_Id, test,
					test1);
			Extent_pass(driver, "System allowed to auto generate the Id", test, test1);

		} else {
			System.out.println("Not Matched || Expected Id : " + Expected_ID + " || Actual Id : " + actual_Id);
			Extent_fail(driver, "Not Matched || Expected Id : " + Expected_ID + " || Actual Id : " + actual_Id, test,
					test1);
		}

		System.out.println("**************Testcase 115 -  Completed ************");

		Extent_cal(test, "Testcase 117 - Ensure in  ID  field un editable");

		Fluentwait(driver, Cancel);
		click(driver, Cancel);

		wait(driver, "3");
		Fluentwait(driver, New);
		click(driver, New);

		Fluentwait(driver, New_Popup_Yes);
		click(driver, New_Popup_Yes);

		wait(driver, "3");

		Fluentwait(driver, Show);
		click(driver, Show);

		wait(driver, "3");

		if (isDisplayed(driver, Show_Popup_Yes)) {

			Fluentwait(driver, Show_Popup_Yes);
			click(driver, Show_Popup_Yes);
		}

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

//			uploadFileRobot(driver,EquimentType_Alphabets1);

			String upload_EquimentType_Alphabets2 = System.getProperty("user.dir") + "/driver/MasterDownloadfile.exe "
					+ EquimentType_Alphabets1;

			try {
				Runtime.getRuntime().exec(upload_EquimentType_Alphabets2);
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println(e.getLocalizedMessage());
				Extent_fail(driver, e.getLocalizedMessage(), test, test1);
			}

			wait(driver, "3");

			Fluentwait(driver, Location3);

			if (isDisplayed(driver, click_yes)) {

				click(driver, click_yes);

				Fluentwait(driver, Click_ok);
				click(driver, Click_ok);
			}

			wait(driver, "2");

			Fluentwait(driver, Save);
			click(driver, Save);

			Fluentwait(driver, Save_popup_ok);
			click(driver, Save_popup_ok);

		} else {
			System.out.println("popup not shown");
		}

		Fluentwait(driver, IDField);
		click(driver, IDField);

		if (!isClear(driver, IDField)) {

			System.out.println("Unable to do the edit action in the ID Field");
			Extent_pass(driver, "Unable to do the edit action in the ID Field", test, test1);

		} else {

			System.out.println("Able to do the edit action in the ID Field");
			Extent_fail(driver, "Able to do the edit action in the ID Field", test, test1);
		}

		System.out.println("**************Testcase 117 -  Completed ************");

		Extent_cal(test, "Testcase 120 - Ensure in  import from excel  Location column allow alphabets.");

		Fluentwait(driver, Cancel);
		click(driver, Cancel);

		wait(driver, "2");
		Fluentwait(driver, New);
		click(driver, New);

		Fluentwait(driver, New_Popup_Yes);
		click(driver, New_Popup_Yes);

		wait(driver, "3");
		Fluentwait(driver, dropdown_option);
		click(driver, dropdown_option);

		Fluentwait(driver, Budget_Reposition);
		click(driver, Budget_Reposition);

		Fluentwait(driver, Budget);
		click(driver, Budget);

		wait(driver, "2");

//		uploadFileRobot(driver,Import_file);

		String upload_Import_file = System.getProperty("user.dir") + "/driver/MasterDownloadfile.exe " + Import_file;

		try {
			Runtime.getRuntime().exec(upload_Import_file);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getLocalizedMessage());
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
		}

		wait(driver, "10");

		Fluentwait(driver, Location3);

		if (isDisplayed(driver, click_yes)) {

			click(driver, click_yes);

			Fluentwait(driver, Click_ok);
			click(driver, Click_ok);
		}

		wait(driver, "2");

		if (isDisplayed(driver, Location3)) {
			Extent_pass(driver, "import from excel Location column allow  alphabets", test, test1);
		} else {
			Extent_fail(driver, "import from excel Location column not allow  alphabets", test, test1);
		}

		System.out.println("************120***********");

		Extent_cal(test, "Testcase 121 - Ensure in  import from excel  Location column not allow numeric");

		wait(driver, "2");

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

//		uploadFileRobot(driver,Numerical_Val);

		String upload_Numerical_Val = System.getProperty("user.dir") + "/driver/MasterDownloadfile.exe "
				+ Numerical_Val;

		try {
			Runtime.getRuntime().exec(upload_Numerical_Val);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getLocalizedMessage());
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
		}

		wait(driver, "25");

		if (isDisplayed(driver, click_yes)) {

			click(driver, click_yes);

			Fluentwait(driver, Click_ok);
			click(driver, Click_ok);
		}

		if (!isDisplayed(driver, Location3)) {
			Extent_pass(driver, "import from excel Location column  not allow Numerical values ", test, test1);
		} else {
			Extent_fail(driver, "import from excel Location column  allow  Numerical values", test, test1);
		}
		System.out.println("************121 Completed***********");

		Extent_cal(test, "Testcase 122 - Ensure in  import from excel  Location column not allow  Special character");

		wait(driver, "2");

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

//		uploadFileRobot(driver,Special_character);

		String upload_Special_character2 = System.getProperty("user.dir") + "/driver/MasterDownloadfile.exe "
				+ Special_character;

		try {
			Runtime.getRuntime().exec(upload_Special_character2);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getLocalizedMessage());
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
		}

		wait(driver, "25");

//		Fluentwait(driver, Location3);

		if (isDisplayed(driver, click_yes)) {

			click(driver, click_yes);

			Fluentwait(driver, Click_ok);
			click(driver, Click_ok);
		}

		if (!isDisplayed(driver, Location3)) {

			Extent_pass(driver, "import from excel Location column  not allow Special character ", test, test1);
		} else {

			Extent_fail(driver, "import from excel Location column  allow  Special character", test, test1);
		}

		System.out.println("************122***********");

		wait(driver, "2");

		Extent_cal(test, "Testcase 125 - Ensure in  import from excel Equipment Type column allow alphabets");

		Fluentwait(driver, Cancel);
		click(driver, Cancel);
		wait(driver, "2");

		Fluentwait(driver, New);
		click(driver, New);

		Fluentwait(driver, New_Popup_Yes);
		click(driver, New_Popup_Yes);

		wait(driver, "3");
		Fluentwait(driver, dropdown_option);
		click(driver, dropdown_option);

		Fluentwait(driver, Budget_Reposition);
		click(driver, Budget_Reposition);

		Fluentwait(driver, Budget);
		click(driver, Budget);

		wait(driver, "2");

//		uploadFileRobot(driver,EquimentType_Alphabets);

		String upload_EquimentType_Alphabets5 = System.getProperty("user.dir") + "/driver/MasterDownloadfile.exe "
				+ EquimentType_Alphabets;

		try {
			Runtime.getRuntime().exec(upload_EquimentType_Alphabets5);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getLocalizedMessage());
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
		}

		wait(driver, "25");

		if (isDisplayed(driver, click_yes)) {

			click(driver, click_yes);

			Fluentwait(driver, Click_ok);
			click(driver, Click_ok);
		}

		wait(driver, "2");

		if (isDisplayed(driver, EquipmentType_column2)) {
			Extent_pass(driver, "import from excel Equipment type column allow  alphabets", test, test1);
		} else {
			Extent_fail(driver, "import from excel Equipment type column not allow  alphabets", test, test1);
		}

		System.out.println("************Testcase 125 Completed***********");

		Extent_cal(test, "Testcase 126 - Ensure in  import from excel  Equipment Type column allow numeric");

		wait(driver, "2");

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

//		uploadFileRobot(driver,EquimentType_Alphabets);

		String upload_EquimentType_Alphabets2 = System.getProperty("user.dir") + "/driver/MasterDownloadfile.exe "
				+ EquimentType_Alphabets;

		try {
			Runtime.getRuntime().exec(upload_EquimentType_Alphabets2);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getLocalizedMessage());
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
		}

		wait(driver, "10");

		Fluentwait(driver, Location3);

		if (isDisplayed(driver, click_yes)) {

			click(driver, click_yes);

			Fluentwait(driver, Click_ok);
			click(driver, Click_ok);
		}

		wait(driver, "3");

		if (isDisplayed(driver, EquipmentType_column2)) {
			Extent_pass(driver, "import from excel Equipment type column allow Numerical values ", test, test1);
		} else {
			Extent_fail(driver, "import from excel Equipment type column not allow Numerical values", test, test1);
		}

		System.out.println("************Testcase 126 Completed***********");

		Extent_cal(test,
				"Testcase 127 - Ensure in  import from excel Equipment Type column not allow Special character");

		wait(driver, "2");

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

//		uploadFileRobot(driver,EquimentType_specialcharacter);

		String upload_EquimentType_specialcharacter = System.getProperty("user.dir") + "/driver/MasterDownloadfile.exe "
				+ EquimentType_specialcharacter;

		try {
			Runtime.getRuntime().exec(upload_EquimentType_specialcharacter);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getLocalizedMessage());
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
		}

		wait(driver, "10");

		Fluentwait(driver, Location3);

		if (isDisplayed(driver, click_yes)) {

			click(driver, click_yes);

			Fluentwait(driver, Click_ok);
			click(driver, Click_ok);
		}

		wait(driver, "2");

		if (!isDisplayed(driver, EquipmentType_column2)) {

			Extent_pass(driver, "import from excel Equipment type column  not allow Special character ", test, test1);
		} else {

			Extent_fail(driver, "import from excel Equipment type column  allow  Special character", test, test1);
		}

		System.out.println("************Testcase 127 - Completed***********");

		Extent_cal(test, "Testcase 130 - Ensure in  import from excel Region column allow alphabets");

		wait(driver, "2");

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

//		uploadFileRobot(driver,Import_alphabets);

		String upload_Import_alphabets = System.getProperty("user.dir") + "/driver/MasterDownloadfile.exe "
				+ Import_alphabets;

		try {
			Runtime.getRuntime().exec(upload_Import_alphabets);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getLocalizedMessage());
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
		}

		wait(driver, "10");

		Fluentwait(driver, Location3);

		if (isDisplayed(driver, click_yes)) {

			click(driver, click_yes);

			Fluentwait(driver, Click_ok);
			click(driver, Click_ok);
		}

		wait(driver, "2");

		waitForElement(driver, Total_record);

		String Total_records1 = getText(driver, Total_record);

		int length2 = Integer.parseInt(Total_records1);

		boolean allPassed = true;

		for (int i = 0; i < length2; i++) {

			WebElement element = driver.findElement(By.xpath("(//div[@row-id='" + i + "'])[2]//div[@col-id='region']"));
			act.moveToElement(element).click().build().perform();
			String text = element.getText();

			if (containsAlphabetic(text)) {
				System.out.println("The Region column allowed to enter the alphabetic characters");

			} else {
				System.out.println("The Region column does not allow alphabetic characters - " + text);
				allPassed = false; // Set the flag to false if any condition fails
			}
		}

		// Print the summary result

		scrollBottom(driver);

		if (allPassed) {
			Extent_pass(driver, "The Region column allow the alphabetic characters", test, test1);
		} else {
			Extent_fail(driver, "The Region column does not allow alphabetic characters", test, test1);
		}

		System.out.println("************Testcase 130 Completed***********");

		wait(driver, "2");

		Extent_cal(test, "Testcase 131 - Ensure in  import from excel Region column not allow numeric");

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

		wait(driver, "3");

//		uploadFileRobot(driver,Import_specialcharacter);

		String upload_Import_specialcharacter = System.getProperty("user.dir") + "/driver/MasterDownloadfile.exe "
				+ Import_specialcharacter;

		try {
			Runtime.getRuntime().exec(upload_Import_specialcharacter);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getLocalizedMessage());
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
		}

		wait(driver, "10");

		Fluentwait(driver, Location3);

		if (isDisplayed(driver, click_yes)) {

			click(driver, click_yes);

			Fluentwait(driver, Click_ok);
			click(driver, Click_ok);
		}

		wait(driver, "3");

		boolean region_number = true;

		for (int i = 0; i < length2; i++) {

			WebElement element = driver.findElement(By.xpath("(//div[@row-id='" + i + "'])[2]//div[@col-id='region']"));
			act.moveToElement(element).click().build().perform();
			String text = element.getText();

			if (!containsNumeric(text)) {
				System.out.println("The Region column does not allow numeric values");

			} else {
				System.out.println("The Region column allow numeric values - " + text);
				region_number = false; // Set the flag to false if any condition fails
			}
		}

		scrollBottom(driver);

		if (region_number) {
			Extent_pass(driver, "The Region column does not allow numeric values", test, test1);
		} else {
			Extent_fail(driver, "The Region column allow numeric values", test, test1);
		}

		System.out.println("************Testcase 131 Completed***********");

		Extent_cal(test, "Testcase 132 - Ensure in  import from excel Region column not allow Special character");

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

//		uploadFileRobot(driver,Import_specialcharacter);

		String upload_Import_specialcharacter2 = System.getProperty("user.dir") + "/driver/MasterDownloadfile.exe "
				+ Import_specialcharacter;

		try {
			Runtime.getRuntime().exec(upload_Import_specialcharacter2);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getLocalizedMessage());
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
		}

		wait(driver, "10");

		Fluentwait(driver, Location3);

		if (isDisplayed(driver, click_yes)) {

			click(driver, click_yes);

			Fluentwait(driver, Click_ok);
			click(driver, Click_ok);
		}

		wait(driver, "2");

		boolean region_special = true;

		for (int i = 0; i < length2; i++) {

			WebElement element = driver.findElement(By.xpath("(//div[@row-id='" + i + "'])[2]//div[@col-id='region']"));

			act.moveToElement(element).click().build().perform();
			// Get the text from the element
			String text = element.getText();
			// Check if the text contains any alphabetic characters
			if (!containsSpecialCharacter(text)) {
				System.out.println("The Region column does not allow Special characters");
			} else {
				System.out.println("The Region column allowed to enter the Special characters - " + text);
				region_special = false;
			}
		}

		scrollBottom(driver);

		if (region_special) {
			Extent_pass(driver, "The Region column does not allow Special characters", test, test1);
		} else {
			Extent_fail(driver, "The Region column allowed to enter the Special characters", test, test1);
		}

		System.out.println("************Testcase 132 Completed***********");

	}

}
