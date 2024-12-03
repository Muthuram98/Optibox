package ERO_Routing_Scripts;

import java.awt.Robot;
import java.io.IOException;
import java.util.ArrayList;
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

public class ERO_Routing_Scenario23_TC180 extends Keywords {
	public void ERO_Routing_Scenario23(WebDriver driver, ExtentTest test, ExtentTest test1, String url, int dataset)
			throws Exception {
		String Username = Utils.getDataFromTestData("ERO_Scenario21_Dataset"+dataset, "ERO Routing", "Username");
		String Password = Utils.getDataFromTestData("ERO_Scenario21_Dataset"+dataset, "ERO Routing", "Password");
		String ID = Utils.getDataFromTestData("ERO_Scenario21_Dataset"+dataset, "ERO Routing", "Id");

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

		wait(driver, "5");

		if (isDisplayed(driver, session_confirmation)) {
			Fluentwait(driver, session_confirmation);
			click(driver, session_confirmation);
		}

		Extent_cal(test,
				"Testcase 180,Ensure Optimizer select the “check allocation” check box with all size type containers option");
		Fluentwait(driver, Searchbox);
		sendKeys(driver, Searchbox, "Deficit and Surplus Location Identification");

		Fluentwait(driver, Selectdeficit);
		click(driver, Selectdeficit);

		wait(driver, "5");

		Fluentwait(driver, Globalserach);
		click(driver, Globalserach);

		Fluentwait(driver, Globalserach_IDInput);
		sendKeys(driver, Globalserach_IDInput, ID);

		Fluentwait(driver, Click_Search);
		click(driver, Click_Search);

		wait(driver, "3");
		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);

		Fluentwait(driver, Editbutton);
		click(driver, Editbutton);

		Fluentwait(driver, Save);
		click(driver, Save);

		wait(driver, "3");

		Fluentwait(driver, Save_popup_ok);
		click(driver, Save_popup_ok);

		wait(driver, "3");

		Fluentwait(driver, Route);
		click(driver, Route);
		wait(driver, "3");
		Fluentwait(driver, ERO_Popup_Ok);
		click(driver, ERO_Popup_Ok);

		wait(driver, "2");
		Fluentwait(driver, EPO_Close);
		click(driver, EPO_Close);

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

//		uploadFileRobot(driver,EquimentType_Alphabets);

		String upload_EquimentType_Alphabets = System.getProperty("user.dir") + "/driver/MasterDownloadfile.exe "
				+ EquimentType_Alphabets;

		try {
			Runtime.getRuntime().exec(upload_EquimentType_Alphabets);
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
		Fluentwait(driver, ERO_Save);
		mouseOverAndClick(driver, ERO_Save);
		Fluentwait(driver, ERO_Save_ok);
		click(driver, ERO_Save_ok);
		Fluentwait(driver, ERO_route);
		click(driver, ERO_route);
		wait(driver, "2");

		Fluentwait(driver, Optimizer);
		click(driver, Optimizer);
		wait(driver, "2");
		Fluentwait(driver, Optimizer_Ok);
		click(driver, Optimizer_Ok);
		wait(driver, "2");

		List<String> headerNames = new ArrayList<>();
		wait(driver, "5");
		List<WebElement> headers = driver.findElements(By.xpath("//thead[@id='OPT-OPT_treeTable_head']/tr/th"));

		for (WebElement header : headers) {
			String value = header.getText();
			if (!value.isEmpty() && header.isDisplayed()) {
				headerNames.add(value);
				System.out.println(value);
			}
		}

		// After collecting the header names, verify if headerNames list is populated
		if (!headerNames.isEmpty()) {
			System.out.println("After click the optimizer button optimizer screen is dispaly: " + headerNames);
		} else {
			System.out.println("No header names are displayed.");
		}
		wait(driver, "2");
		Fluentwait(driver, ERO_Equipment_Reposition_Report);
		click(driver, ERO_Equipment_Reposition_Report);

		List<String> Columnname3 = Arrays.asList("origin", "delivery", "sizetype", "containercount", "cost", "totcost",
				"transitTime", "remarks", "loadregion", "loadcountry", "dischcountry", "dischregion", "mainService",
				"loadmmrsector", "pOLService", "trans1", "trans1Svc", "trans2", "trans2Svc", "trans3", "trans3Svc",
				"pOD", "dischmmrsector", "dLoadCost", "dDischDCost", "dTS1LoadCost", "dTS2LoadCost", "dTS3LoadCost",
				"dTS1DischCost", "dTS2DischCost", "dTS3DischCost", "dFdrCost1", "loadsector", "dFdrCost2",
				"dischsector", "dFdrCost3", "loadtca", "dLoadHlgCost", "dDischHlgCost", "dIntFdrCost1", "dIntFdrCost2",
				"dIntFdrCost3", "dIntFdrCost4", "dOthersCost");
		List<String> Names3 = Arrays.asList("Load Location", "Disch Location", "Equipment Type", "Quantity",
				"Cost Per Box(USD)", "Total Cost(USD)", "Transit Days", "Remarks", "Load Region", "Load Country",
				"Disch Country", "Disch Region", "Main Service", "Origin Mode", "POL Svc", "Trans1", "Trans1 Svc",
				"Trans2", "Trans2 Svc", "Trans3", "Trans3 Svc", "POD", "Delivery Mode", "Load Cost", "Disch Cost",
				"TS1 Load Cost", "TS2 Load Cost", "TS3 Load Cost", "TS1 Disch Cost", "TS2 Disch Cost", "TS3 Disch Cost",
				"Feeder Cost 1", "Feeder 1 Terms", "Feeder Cost 2", "Feeder 2 Terms", "Feeder Cost 3", "Feeder 3 Terms",
				"Load Haulage Cost", "Disch Haulage Cost", "DPH Origin Cost", "DPH Destination Cost", "LCT Origin Cost",
				"LCT Destination Cost", "In Service Destination Cost");
		int size = Columnname3.size();

		for (int i = 0; i < size; i++) {

			String columns3 = Columnname3.get(i);

			String Column_Name3 = Names3.get(i);

			WebElement element = driver
					.findElement(By.xpath("(//div[@id='OPT-OPT_treeTable1_tbl']//div[@col-id='" + columns3 + "'])[1]"));

			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

			act.moveToElement(element).build().perform();

			wait(driver, "5");

			if (element.isDisplayed()) {

				System.out.println(
						"After click on Equipment reposition report " + Column_Name3 + " was displayed in the grid");
				Extent_pass(driver,
						"After click on Equipment reposition report " + Column_Name3 + " was displayed in the grid",
						test, test1);
			} else {
				System.out.println("After click on Equipment reposition report " + Column_Name3
						+ " was not displayed in the grid");
				Extent_fail(driver,
						"After click on Equipment reposition report " + Column_Name3 + " was not displayed in the grid",
						test, test1);
			}
		}

		Fluentwait(driver, ERO_Unsatisfied_Report);
		mouseOverAndClick(driver, ERO_Unsatisfied_Report);

		List<String> Columnname4 = Arrays.asList("Location Code", "Equipment Type", "Quantity", "Remarks");

		List<String> Names4 = Arrays.asList("locationcode", "eqptype", "quantity", "remarks");

		int size2 = Columnname4.size();

		for (int i = 0; i < size2; i++) {

			String columns3 = Columnname4.get(i);

			String Column_Name4 = Names4.get(i);

			WebElement element = driver.findElement(By.xpath("(//div[@col-id='" + Column_Name4 + "'])[1]"));

			act.moveToElement(element).build().perform();

			wait(driver, "5");

			if (element.isDisplayed()) {

				System.out.println("After click on Unsatisfied Report " + Column_Name4 + " was displayed in the grid");
				Extent_pass(driver, "After click on Unsatisfied Report " + Column_Name4 + " was displayed in the grid",
						test, test1);
			} else {
				System.out.println(
						"After click on Unsatisfied Report " + Column_Name4 + " was not displayed in the grid");
				Extent_fail(driver,
						"After click on Unsatisfied Report " + Column_Name4 + " was not displayed in the grid", test,
						test1);
			}
		}
		wait(driver, "2");

		Fluentwait(driver, ERO_Hire_Report);
		mouseOverAndClick(driver, ERO_Hire_Report);

		List<String> Columnname6 = Arrays.asList("Load Location", "Disch Location", "Equipment Type", "Quantity",
				"Cost Per Box(USD)", "Total Cost(USD)", "Transit Days", "Remarks");
		int size1 = Columnname6.size();

		for (int i = 0; i < size1; i++) {

			String columns3 = Columnname6.get(i);

			WebElement element = driver
					.findElement(By.xpath("(//div[@id='OPT-OPT_treeTable4_tbl']//span[text()='" + columns3 + "'])[1]"));

			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

			act.moveToElement(element).build().perform();

			wait(driver, "5");

			if (element.isDisplayed()) {

				System.out.println("After click on Hire Report " + columns3 + " was displayed in the grid");
				Extent_pass(driver, "After click on Hire Report " + columns3 + " was displayed in the grid", test,
						test1);
			} else {
				System.out.println("After click on Hire Report " + columns3 + " was not displayed in the grid");
				Extent_fail(driver, "After click on Hire Report " + columns3 + " was not displayed in the grid", test,
						test1);
			}
		}

		WebElement scroller = driver.findElement(By.xpath("(//div[@ref='eBodyHorizontalScrollViewport'])[7]"));
		int scrollAmount = 1100; //
		js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller, scrollAmount);
		wait(driver, "2");

		List<String> Columnnam6 = Arrays.asList("Load Region", "Load Country", "Disch Country", "Disch Region",
				"Main Service", "Origin Mode", "POL", "POL Svc", "Trans1", "Trans1 Svc", "Trans2", "Trans2 Svc",
				"Trans3", "Trans3 Svc", "POD", "Delivery Mode", "Load Cost", "Disch Cost", "TS1 Load Cost",
				"TS2 Load Cost", "TS3 Load Cost", "TS1 Disch Cost", "TS2 Disch Cost", "TS3 Disch Cost", "Feeder Cost 1",
				"Feeder 1 Terms", "Feeder Cost 2", "Feeder 2 Terms", "Feeder Cost 3", "Feeder 3 Terms",
				"Load Haulage Cost", "Disch Haulage Cost", "DPH Origin Cost", "DPH Destination Cost", "LCT Origin Cost",
				"LCT Destination Cost", "On-Hire Cost", "Off-Hire Cost");
		int siz1 = Columnnam6.size();

		for (int i = 0; i < siz1; i++) {

			String columns3 = Columnnam6.get(i);

			WebElement element = driver
					.findElement(By.xpath("(//div[@id='OPT-OPT_treeTable4_tbl']//span[text()='" + columns3 + "'])[1]"));

			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

			act.moveToElement(element).build().perform();

			wait(driver, "5");

			if (element.isDisplayed()) {

				System.out.println("After click on Hire Report " + columns3 + " was displayed in the grid");
				Extent_pass(driver, "After click on Hire Report " + columns3 + " was displayed in the grid", test,
						test1);
			} else {
				System.out.println("After click on Hire Report " + columns3 + " was not displayed in the grid");
				Extent_fail(driver, "After click on Hire Report " + columns3 + " was not displayed in the grid", test,
						test1);
			}
		}

		wait(driver, "2");
		Fluentwait(driver, ERO_Lease_Report);
		mouseOverAndClick(driver, ERO_Lease_Report);

		List<String> Names7 = Arrays.asList("Load Location", "Disch Location", "Equipment Type", "Quantity",
				"Cost Per Box(USD)", "Total Cost(USD)", "Transit Days", "Remarks", "Load Region", "Load Country",
				"Disch Country", "Disch Region", "Main Service", "Origin Mode", "POL", "POL Svc", "Trans1",
				"Trans1 Svc", "Trans2", "Trans2 Svc", "Trans3", "Trans3 Svc", "POD", "Delivery Mode", "Load Cost",
				"Disch Cost", "TS1 Load Cost", "TS2 Load Cost", "TS3 Load Cost", "TS1 Disch Cost", "TS2 Disch Cost",
				"TS3 Disch Cost", "Feeder Cost 1", "Feeder 1 Terms", "Feeder Cost 2", "Feeder 2 Terms", "Feeder Cost 3",
				"Feeder 3 Terms", "Load Haulage Cost", "Disch Haulage Cost", "DPH Origin Cost", "DPH Destination Cost",
				"LCT Origin Cost", "LCT Destination Cost", "In Service Destination Cost");

		List<String> Columnname7 = Arrays.asList("origin", "delivery", "sizetype", "containercount", "cost", "totcost",
				"transitTime", "remarks", "loadregion", "loadcountry", "dischcountry", "dischregion", "mainService",
				"loadmmrsector", "pOL", "pOLService", "trans1", "trans1Svc", "trans2", "trans2Svc", "trans3",
				"trans3Svc", "pOD", "dischmmrsector", "dLoadCost", "dDischDCost", "dTS1LoadCost", "dTS2LoadCost",
				"dTS3LoadCost", "dTS1DischCost", "dTS2DischCost", "dTS3DischCost", "dFdrCost1", "loadsector",
				"dFdrCost2", "dischsector", "dFdrCost3", "loadtca", "dLoadHlgCost", "dDischHlgCost", "dIntFdrCost1",
				"dIntFdrCost2", "dIntFdrCost3", "dIntFdrCost4", "dOthersCost");

		int size3 = Columnname7.size();

		for (int i = 0; i < size3; i++) {

			String columns3 = Columnname7.get(i);

			String Column_Name7 = Names7.get(i);

			WebElement element = driver.findElement(
					By.xpath("(//div[@id='OPT-OPT_treeTable5_tbl']//following::div[@col-id='" + columns3 + "'])[1]"));

			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			act.moveToElement(element).build().perform();

			wait(driver, "5");

			if (element.isDisplayed()) {

				System.out.println("After click on Lease Report " + Column_Name7 + " was displayed in the grid");
				Extent_pass(driver, "After click on Lease Report " + Column_Name7 + " was displayed in the grid", test,
						test1);
			} else {
				System.out.println("After click on Lease Report" + Column_Name7 + " was not displayed in the grid");
				Extent_fail(driver, "After click on Lease Report " + Column_Name7 + " was not displayed in the grid",
						test, test1);
			}
		}
		wait(driver, "2");
		Fluentwait(driver, ERO_Total_Summary);
		mouseOverAndClick(driver, ERO_Total_Summary);

		if (isDisplayed(driver, ERO_One_Way)) {
			Extent_pass(driver, "After click on Total summary  data was displayed in the grid", test, test1);
		} else {
			Extent_fail(driver, "After click on Total summary  data was displayed in the grid", test, test1);
		}

		if (isDisplayed(driver, ERO_One_Way_Lease)) {
			Extent_pass(driver, "After click on Total summary  data was displayed in the grid", test, test1);
		} else {
			Extent_fail(driver, "After click on Total summary  data was displayed in the grid", test, test1);
		}
		if (isDisplayed(driver, ERO_Total_One_Way_Lease)) {
			Extent_pass(driver, "After click on Total summary  data was displayed in the grid", test, test1);
		} else {
			Extent_fail(driver, "After click on Total summary  data was displayed in the grid", test, test1);
		}
		if (isDisplayed(driver, ERO_Summary_Details)) {
			Extent_pass(driver, "After click on Total summary  data was displayed in the grid", test, test1);
		} else {
			Extent_fail(driver, "After click on Total summary  data was displayed in the grid", test, test1);
		}
		if (isDisplayed(driver, ERO_Total_Reposition)) {
			Extent_pass(driver, "After click on Total summary  data was displayed in the grid", test, test1);
		} else {
			Extent_fail(driver, "After click on Total summary  data was displayed in the grid", test, test1);
		}
		if (isDisplayed(driver, ERO_Total_lease)) {
			Extent_pass(driver, "After click on Total summary  data was displayed in the grid", test, test1);
		} else {
			Extent_fail(driver, "After click on Total summary  data was displayed in the grid", test, test1);

		}

		System.out.println("Testcase 180, completed");

	}

}
