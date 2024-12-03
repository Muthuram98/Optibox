
package DeficitAndSurflusLocationIdentification_Scripts;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;
import commonMethods.Utils;

public class TS016_to_TS019_DeficitandSurplusLocationId_TC306to328 extends Keywords {

	@SuppressWarnings("deprecation")
	public void Scenario16to19(WebDriver driver, ExtentTest test, ExtentTest test1, String url, int dataset) throws Exception {

		String Username = Utils.getDataFromTestData("TS016to19_DeficitandSurplusLocationIdentification_Dataset"+dataset,
				"DeficitandSurplusLocationId", "Username");
		String Password = Utils.getDataFromTestData("TS016to19_DeficitandSurplusLocationIdentification_Dataset"+dataset,
				"DeficitandSurplusLocationId", "Password");
		String Appsurf_Color = Utils.getDataFromTestData("TS016to19_DeficitandSurplusLocationIdentification_Dataset"+dataset,
				"DeficitandSurplusLocationId", "Appsurf_Color");
		String ID_fieldcolor = Utils.getDataFromTestData("TS016to19_DeficitandSurplusLocationIdentification_Dataset"+dataset,
				"DeficitandSurplusLocationId", "ID_fieldcolor");
		String FromWeek1 = Utils.getDataFromTestData("TS016to19_DeficitandSurplusLocationIdentification_Dataset"+dataset,
				"DeficitandSurplusLocationId", "FromWeek1");
		String ToWeek1 = Utils.getDataFromTestData("TS016to19_DeficitandSurplusLocationIdentification_Dataset"+dataset,
				"DeficitandSurplusLocationId", "ToWeek1");
		String FromWeek2 = Utils.getDataFromTestData("TS016to19_DeficitandSurplusLocationIdentification_Dataset"+dataset,
				"DeficitandSurplusLocationId", "FromWeek2");
		String ToWeek2 = Utils.getDataFromTestData("TS016to19_DeficitandSurplusLocationIdentification_Dataset"+dataset,
				"DeficitandSurplusLocationId", "ToWeek2");
		
		String EquimentType_Alphabets1 = System.getProperty("user.dir") + "\\uploads\\Budget_Flow_Applied.xlsx";

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

		Fluentwait(driver, Selectdeficit);
		click(driver, Selectdeficit);

		wait(driver, "5");

		Extent_cal(test,
				"Testcase 306 - Ensure in system should not allow duplicate records in Deficit and Surplus Location Identification screen");

		Fluentwait(driver, Fromweek_input);
		clear(driver, Fromweek_input);
		sendKeys(driver, Fromweek_input, FromWeek1);

		wait(driver, "2");
		Fluentwait(driver, Toweek_input);
		clear(driver, Toweek_input);
		sendKeys(driver, Toweek_input, ToWeek1);

		wait(driver, "2");
		Fluentwait(driver, Show);
		click(driver, Show);

		wait(driver, "5");

		if (isDisplayed(driver, show_yes)) {

			System.out.println("The system shows warning message that the record is duplicate");
			Extent_pass(driver, "The system shows warning message that the record is duplicate", test, test1);

			Fluentwait(driver, show_yes);
			click(driver, show_yes);

		} else {
			System.out.println("The system allows to show the duplicate records");
			Extent_fail(driver, "The system allows to show the duplicate records", test, test1);
		}

		wait(driver, "2");

		if (isDisplayed(driver, click_yes)) {

			click(driver, click_yes);

			Fluentwait(driver, Click_ok);
			click(driver, Click_ok);
		}

		wait(driver, "2");
		Fluentwait(driver, Save);
		click(driver, Save);

		wait(driver, "2");
		Fluentwait(driver, Save_popup_ok);
		click(driver, Save_popup_ok);
		wait(driver, "2");

		System.out.println("Testcase 306 Completed");

		Extent_cal(test, "Testcase 308 - Ensure in Deficit and Surplus Location details tab wise functionality");

		while (isDisplayed(driver, delete_template)) {

			click(driver, delete_template);
			wait(driver, "2");

		}

		Fluentwait(driver, Cancel);
		click(driver, Cancel);

		wait(driver, "5");

		Fluentwait(driver, New);
		click(driver, New);

		Fluentwait(driver, New_Popup_Yes);
		click(driver, New_Popup_Yes);

		wait(driver, "2");

		Fluentwait(driver, Fromyear_input);

		String oldfromyear = getAttribute(driver, Fromyear_input, "aria-valuenow");
		System.out.println("Olde from year - " + oldfromyear);

		int oldfrom_year = Integer.parseInt(oldfromyear);

		int expected_FYear = oldfrom_year - 1;

		String Expected_fromYear = String.valueOf(expected_FYear);

		System.out.println("Expected_fromYear : " + Expected_fromYear);

		Fluentwait(driver, Year_Drop_Down);
		click(driver, Year_Drop_Down);

		boolean deficittab = true;

		String actualfromyear = getAttribute(driver, Fromyear_input, "aria-valuenow");

		if (actualfromyear.equals(Expected_fromYear)) {
			System.out.println("From year field is functioning correctly");
			Extent_pass(driver, "From year field is functioning correctly", test, test1);
		} else {
			System.out.println("From year field is not functioning correctly");
			Extent_fail(driver, "From year field is not functioning correctly", test, test1);

			deficittab = false;
		}

		String oldtoyear = getAttribute(driver, Toyear_input, "aria-valuenow");
		System.out.println("Olde to year - " + oldtoyear);

		int oldto_year = Integer.parseInt(oldtoyear);

		int expected_ToYear = oldto_year - 1;

		String Expected_ToYear = String.valueOf(expected_ToYear);

		System.out.println("Expected_fromYear : " + Expected_ToYear);

		Fluentwait(driver, Year_To_Drop_Down);
		click(driver, Year_To_Drop_Down);

		String actualtoyear = getAttribute(driver, Toyear_input, "aria-valuenow");

		if (actualtoyear.equals(Expected_ToYear)) {
			System.out.println("To year field is functioning correctly");
			Extent_pass(driver, "To year field is functioning correctly", test, test1);
		} else {
			System.out.println("To year field is not functioning correctly");
			Extent_fail(driver, "To year field is not functioning correctly", test, test1);
			deficittab = false;
		}

		Fluentwait1(driver, Fromweek_input);
		click(driver, Fromweek_input);
		clear(driver, Fromweek_input);
		wait(driver, "2");
		sendKeys(driver, Fromweek_input, FromWeek2);

		wait(driver, "2");

		String FromWeek = getAttribute(driver, fromweek_value, "value");

		System.out.println("FromWeek : " + FromWeek);

		if (FromWeek.equals(FromWeek2)) {

			System.out.println("From week field is functioning correctly");
			Extent_pass(driver, "From week field is functioning correctly", test, test1);
		} else {
			System.out.println("From week field is not functioning correctly");
			Extent_fail(driver, "From week field is not functioning correctly", test, test1);
			deficittab = false;
		}

		Fluentwait1(driver, Toweek_input);
		click(driver, Toweek_input);
		clear(driver, Toweek_input);
		wait(driver, "2");
		sendKeys(driver, Toweek_input, ToWeek2);

		wait(driver, "2");

		String ToWeek = getAttribute(driver, Toweek_value, "value");

		System.out.println("To Week : " + ToWeek);

		if (ToWeek.equals(ToWeek2)) {

			System.out.println("To week field is functioning correctly");
			Extent_pass(driver, "To week field is functioning correctly", test, test1);
		} else {
			System.out.println("To week field is not functioning correctly");
			Extent_fail(driver, "To week field is not functioning correctly", test, test1);
			deficittab = false;
		}

		Fluentwait(driver, Show);
		click(driver, Show);

		wait(driver, "2");
		if (isDisplayed(driver, show_yes)) {
			Fluentwait(driver, show_yes);
			click(driver, show_yes);
		}
		wait(driver, "5");
		
		if(isDisplayed(driver, click_yes)) {
			
			click(driver, click_yes);
			
			Fluentwait(driver, Click_ok);
			click(driver, Click_ok);
		}

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

//				uploadFileRobot(driver,EquimentType_Alphabets1);

			String upload_EquimentType_Alphabets1 = System.getProperty("user.dir") + "/driver/MasterDownloadfile.exe "
					+ EquimentType_Alphabets1;

			try {
				Runtime.getRuntime().exec(upload_EquimentType_Alphabets1);
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println(e.getLocalizedMessage());
				Extent_fail(driver, e.getLocalizedMessage(), test, test1);
			}

			wait(driver, "25");

			Fluentwait(driver, Location3);

			if (isDisplayed(driver, click_yes)) {

				click(driver, click_yes);

				Fluentwait(driver, Click_ok);
				click(driver, Click_ok);
			}

			wait(driver, "3");

			wait(driver, "3");
			Fluentwait(driver, ERO_Save);
			click(driver, ERO_Save);
			Fluentwait(driver, ERO_Save_ok);
			click(driver, ERO_Save_ok);
			wait(driver, "2");

		} else {
			System.out.println("popup not shown");
		}

		if (isDisplayed(driver, Grid_locationfield1)) {
			System.out.println("After entering the details, records are shown in the grid");
			Extent_pass(driver, "After click on show button, data's are showing in the grid", test, test1);
		} else {
			System.out.println("After entering the details, records are not shown in the grid");
			Extent_fail(driver, "After click on show button, data's are not showing in the grid", test, test1);
			deficittab = false;
		}

		if (deficittab) {

			System.out.println("Deficit and surplus tab is working fine");
			Extent_pass(driver, "Deficit and surplus tab is working fine", test, test1);
		} else {
			System.out.println("Deficit and surplus tab is not working fine");
			Extent_fail(driver, "Deficit and surplus tab is not working fine", test, test1);
		}

		System.out.println("Testcase 308 completed");

		Extent_cal(test,
				"Testcase 321 - Ensure in Filter the one way lease chart,Sub Lease chart,New Production Chart,Long Term Storage chart using tree structure Region wise");

		Fluentwait(driver, Tree_Region1);
		click(driver, Tree_Region1);

		String region2 = getText(driver, Region2_Text);
		String region1 = getText(driver, Region1_Text);

		System.out.println("region2 : " + region2);

		String region_total = getText(driver, Total_record);

		int regiontotal = Integer.parseInt(region_total);

		boolean regionfilter = true;

		for (int i = 0; i < regiontotal; i++) {

			WebElement element2 = driver.findElement(By.xpath("//div[@row-id='" + i + "']//div[@col-id='region']"));
			act.moveToElement(element2).build().perform();

			String regions = element2.getText();

			if (!regions.equals(region2) && regions.equals(region1)) {

				System.out.println("Region tree filter is working fine");

			} else {

				System.out.println("Region tree filter is not working fine");
				regionfilter = false;

			}

		}

	


		System.out.println("Testcase 321 - Completed");

		Extent_cal(test,
				"Testcase 324 - Ensure in Filter the one way lease chart,Sub Lease chart,New Production Chart,Long Term Storage chart using tree structure Country wise");

		scrollBottom(driver);

		Fluentwait(driver, Cancel);
		click(driver, Cancel);

		wait(driver, "2");
		Fluentwait(driver, New);
		click(driver, New);

		Fluentwait(driver, New_Popup_Yes);
		click(driver, New_Popup_Yes);
		wait(driver, "2");

		Fluentwait(driver, Fromweek_input);
		clear(driver, Fromweek_input);
		sendKeys(driver, Fromweek_input, FromWeek1);

		wait(driver, "2");
		Fluentwait(driver, Toweek_input);
		clear(driver, Toweek_input);
		sendKeys(driver, Toweek_input, ToWeek1);

		wait(driver, "2");
		Fluentwait(driver, Show);
		click(driver, Show);

		wait(driver, "2");

		if (isDisplayed(driver, show_yes)) {
			Fluentwait(driver, show_yes);
			click(driver, show_yes);
		}
		
		wait(driver, "2");
		
		if(isDisplayed(driver, click_yes)) {
			
			click(driver, click_yes);
			
			Fluentwait(driver, Click_ok);
			click(driver, Click_ok);
		}

		Fluentwait(driver, TreeRegion1);
		click(driver, TreeRegion1);

		wait(driver, "3");
		Fluentwait(driver, Country);
		click(driver, Country);

		String Country2 = getText(driver, Country2_Text);
		String Country1 = getText(driver, Country1_Text);

		wait(driver, "5");

		String country_total = getText(driver, Total_record);
		
		// Replace with the amount you want to scroll

		JavascriptExecutor js = (JavascriptExecutor) driver;

		List<String> Onewayfields = Arrays.asList("onewayoutload", "onewayoutreturn", "onewaylease", "tboh", "sali");
		List<String> Column_Names = Arrays.asList("one way out load", "one way out return", "oneway in load",
				"Oneway in trans", "Oneway in return");

		int size = Onewayfields.size();

		int countrytotal = Integer.parseInt(country_total);

		boolean Countryfilter = true;

		for (int i = 0; i < countrytotal; i++) {

			WebElement element3 = driver.findElement(By.xpath("//div[@row-id='" + i + "']//div[@col-id='country']"));

			act.moveToElement(element3).build().perform();

			String Countries = element3.getText();

			if (!Countries.equals(Country2) && Countries.equals(Country1)) {

				System.out.println("Country tree filter is working fine");

			} else {

				System.out.println("Country tree filter is not working fine");
				Countryfilter = false;

			}

		}

		WebElement scroller3 = driver.findElement(By.xpath("//div[@ref='eBodyHorizontalScrollViewport']"));
		int scrollAmount3 = 1500; // Replace with the amount you want to scroll

		js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller3, scrollAmount3);

		for (int j = 0; j < size; j++) {

			for (int i = 0; i < countrytotal; i++) {

				String column = Onewayfields.get(j);

				String name = Column_Names.get(j);

				WebElement element3 = driver
						.findElement(By.xpath("//div[@row-id='" + i + "']//div[@col-id='" + column + "']"));

				act.moveToElement(element3).build().perform();

				String onewayvalue = element3.getText();

				if (onewayvalue.equals("0")) {

					System.out.println(name + " is filtered as per the tree structure filter country wise");
					Extent_pass(driver, name + " is filtered as per the tree structure filter country wise", test,
							test1);

				} else {

					System.out.println(name + " is filtered as per the tree structure filter country wise");
					Extent_fail(driver, name + " is filtered as per the tree structure filter country wise", test,
							test1);
					Countryfilter = false;

				}
			}

		}

		if (Countryfilter) {
			System.out.println(
					"The oneway lease chart fields are filtered as per the tree structure filter country wise");
			Extent_pass(driver,
					"The oneway lease chart fields are filtered as per the tree structure filter country wise", test,
					test1);
		} else {
			System.out.println(
					"The oneway lease chart fields are not filtered as per the tree structure filter country wise");
			Extent_fail(driver,
					"The oneway lease chart fields are not filtered as per the tree structure filter country wise",
					test, test1);
		}

		System.out.println("Testcase 324 completed");

		Extent_cal(test,
				"Testcase 325 - Ensure in Filter the one way lease chart,Sub Lease chart,New Production Chart,Long Term Storage chart using tree structure Location wise");

		Fluentwait(driver, Cancel);
		click(driver, Cancel);

		wait(driver, "2");
		Fluentwait(driver, New);
		click(driver, New);

		Fluentwait(driver, New_Popup_Yes);
		click(driver, New_Popup_Yes);
		wait(driver, "2");

		Fluentwait(driver, Fromweek_input);
		clear(driver, Fromweek_input);
		sendKeys(driver, Fromweek_input, FromWeek1);

		wait(driver, "2");
		Fluentwait(driver, Toweek_input);
		clear(driver, Toweek_input);
		sendKeys(driver, Toweek_input, ToWeek1);

		wait(driver, "2");
		Fluentwait(driver, Show);
		click(driver, Show);

		wait(driver, "2");

		if (isDisplayed(driver, show_yes)) {
			Fluentwait(driver, show_yes);
			click(driver, show_yes);
		}
		
		wait(driver, "2");
		
		if(isDisplayed(driver, click_yes)) {
			
			click(driver, click_yes);
			
			Fluentwait(driver, Click_ok);
			click(driver, Click_ok);
		}

		Fluentwait(driver, TreeRegion1);
		click(driver, TreeRegion1);

		wait(driver, "3");
		Fluentwait(driver, Country);
		click(driver, Country);

		Fluentwait(driver, TreeLocation1);
		click(driver, TreeLocation1);

		wait(driver, "3");
		Fluentwait(driver, Location1_Text);
		click(driver, Location1_Text);

		String Location2 = getText(driver, Location2_Text);
		String Location1 = getText(driver, Location1_Text);

		String Location_total = getText(driver, Total_record);

		int Locationtotal = Integer.parseInt(Location_total);

		boolean Locationfilter = true;

		for (int i = 0; i < Locationtotal; i++) {

			WebElement element4 = driver.findElement(By.xpath("//div[@row-id='" + i + "']//div[@col-id='location']"));

			String Locations = element4.getText();

			if (!Locations.equals(Location2) && Locations.equals(Location1)) {

				System.out.println("Country tree filter is working fine");

			} else {

				System.out.println("Country tree filter is not working fine");
				Locationfilter = false;

			}

		}

		WebElement scroller2 = driver.findElement(By.xpath("//div[@ref='eBodyHorizontalScrollViewport']"));
		
		int scrollAmount = 1500; 

		js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller2, scrollAmount);

		for (int j = 0; j < size; j++) {

			for (int i = 0; i < Locationtotal; i++) {

				String column = Onewayfields.get(j);

				String name = Column_Names.get(j);

				WebElement element3 = driver
						.findElement(By.xpath("//div[@row-id='" + i + "']//div[@col-id='" + column + "']"));

				act.moveToElement(element3).build().perform();

				String onewayvalue = element3.getText();

				if (onewayvalue.equals("0")) {

					System.out.println(name + " is filtered as per the tree structure filter location wise");
					Extent_pass(driver, name + " is filtered as per the tree structure filter location wise", test,
							test1);

				} else {

					System.out.println(name + " is filtered as per the tree structure filter location wise");
					Extent_fail(driver, name + " is filtered as per the tree structure filter location wise", test,
							test1);
					Countryfilter = false;

				}
			}

		}

		if (Locationfilter) {
			System.out.println(
					"The oneway lease chart fields are filtered as per the tree structure filter location wise");
			Extent_pass(driver,
					"The oneway lease chart fields are filtered as per the tree structure filter location wise", test,
					test1);
		} else {
			System.out.println(
					"The oneway lease chart fields are not filtered as per the tree structure filter location wise");
			Extent_fail(driver,
					"The oneway lease chart fields are not filtered as per the tree structure filter location wise",
					test, test1);
		}

		Extent_cal(test, "Testcase 326 - Ensure in blue color indicates Records into the grid ");

		wait(driver, "2");

		Fluentwait(driver, Cancel);
		click(driver, Cancel);

		wait(driver, "2");
		Fluentwait(driver, New);
		click(driver, New);

		Fluentwait(driver, New_Popup_Yes);
		click(driver, New_Popup_Yes);
		wait(driver, "2");

		Fluentwait(driver, Fromweek_input);
		clear(driver, Fromweek_input);
		sendKeys(driver, Fromweek_input, FromWeek1);

		wait(driver, "2");
		Fluentwait(driver, Toweek_input);
		clear(driver, Toweek_input);
		sendKeys(driver, Toweek_input, ToWeek1);

		wait(driver, "2");
		Fluentwait(driver, Show);
		click(driver, Show);

		wait(driver, "2");
		if (isDisplayed(driver, show_yes)) {
			Fluentwait(driver, show_yes);
			click(driver, show_yes);
		}

		wait(driver, "2");
		if(isDisplayed(driver, click_yes)) {
			
			click(driver, click_yes);
			
			Fluentwait(driver, Click_ok);
			click(driver, Click_ok);
		}
		
		wait(driver, "2");
		Fluentwait(driver, Save);
		click(driver, Save);

		wait(driver, "2");
		Fluentwait(driver, Save_popup_ok);
		click(driver, Save_popup_ok);
		wait(driver, "2");

		String Total_records = getText(driver, Total_record);

		int length = Integer.parseInt(Total_records);

		WebElement scroller4 = driver.findElement(By.xpath("//div[@ref='eBodyHorizontalScrollViewport']"));
		// Scroll to the specified coordinates (x, y)
		int scrollAmount4 = 1000; // Replace with the amount you want to scroll

		js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller4, scrollAmount4);

		boolean appsurdef_Color = true;

		for (int i = 0; i < length; i++) {

			WebElement element = driver
					.findElement(By.xpath("((//*[@row-id='" + i + "'])[2]//following::div[@col-id='appsurdef'])[1]"));

			act.moveToElement(element).click().build().perform();

			String Appsurp_color = getTextBackgroundColor_element(driver, element, "Applied surplus/deficit");

			System.out.println("Appsurf_color " + i + " : " + Appsurp_color);

			if (Appsurp_color.equals(Appsurf_Color)) {
				System.out.println("Applied surplus/deficit field indicated as blue color in the grid");
			} else {
				System.out.println("Applied surplus/deficit field not indicated as blue color in the grid");
				appsurdef_Color = false;
			}

		}

		if (appsurdef_Color) {

			Extent_pass(driver, "Applied surplus/deficit field indicated as blue color in the grid", test, test1);
		} else {
			Extent_fail(driver, "Applied surplus/deficit field not indicated as blue color in the grid", test, test1);
		}

		System.out.println("Testcase 326 - Completed");

		Extent_cal(test, "Testcase 327 - Ensure in Yellow color indicates Deficit and Surplus screen ID");

		scrollBottom(driver);

		Fluentwait(driver, Closetab);
		click(driver, Closetab);

		Fluentwait(driver, Searchbox);
		sendKeys(driver, Searchbox, "Deficit and Surplus Location Identification");

		Fluentwait(driver, Selectdeficit);
		click(driver, Selectdeficit);

		wait(driver, "5");

		Fluentwait(driver, Fromweek_input);
		clear(driver, Fromweek_input);
		sendKeys(driver, Fromweek_input, FromWeek1);

		wait(driver, "2");
		Fluentwait(driver, Toweek_input);
		clear(driver, Toweek_input);
		sendKeys(driver, Toweek_input, ToWeek1);

		wait(driver, "2");
		Fluentwait(driver, Show);
		click(driver, Show);

		wait(driver, "2");
		if (isDisplayed(driver, show_yes)) {
			Fluentwait(driver, show_yes);
			click(driver, show_yes);
		}

		wait(driver, "2");
		if(isDisplayed(driver, click_yes)) {
			
			click(driver, click_yes);
			
			Fluentwait(driver, Click_ok);
			click(driver, Click_ok);
		}
		
		wait(driver, "2");
		Fluentwait(driver, Save);
		click(driver, Save);

		wait(driver, "2");
		Fluentwait(driver, Save_popup_ok);
		click(driver, Save_popup_ok);

		wait(driver, "3");

		String Idfield = getTextBackgroundColor(driver, IDField);

		System.out.println("Idfield color : " + Idfield);

		if (Idfield.equals(ID_fieldcolor)) {

			System.out.println("Deficit and Surplus screen ID field indicated in yellow color");
			Extent_pass(driver, "Deficit and Surplus screen ID field indicated in yellow color", test, test1);
		} else {
			System.out.println("Deficit and Surplus screen ID field not indicated in yellow color");
			Extent_fail(driver, "Deficit and Surplus screen ID field not indicated in yellow color", test, test1);

		}

		System.out.println("Testcase 327 - Completed");

	}

}
