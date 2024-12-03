package ERO_Routing_Scripts;

import java.awt.Robot;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.Utils;

public class ERO_Routing_Scenario31_TC271_280 extends Keywords {

	@SuppressWarnings("deprecation")
	public void ERO_Scenario31(WebDriver driver, ExtentTest test, ExtentTest test1, String url, int dataset)
			throws Exception {
		String Username = Utils.getDataFromTestData("ERO_Scenario31_Dataset" + dataset, "ERO Routing", "Username");
		String Password = Utils.getDataFromTestData("ERO_Scenario31_Dataset" + dataset, "ERO Routing", "Password");
		String ID = Utils.getDataFromTestData("ERO_Scenario31_Dataset" + dataset, "ERO Routing", "Id");

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

		wait(driver, "20");

		if (isDisplayed(driver, session_confirmation)) {
			Fluentwait(driver, session_confirmation);
			click(driver, session_confirmation);
		}

		wait(driver, "20");
		sendKeys(driver, Searchbox, "Deficit and Surplus Location Identification");

		Extent_cal(test,
				"Testcase 271,Ensure the “All Equipment Reposition solve” screen for all equipment type option and single equipment type option  navigate to View Report screen");

		Fluentwait(driver, Selectdeficit);
		click(driver, Selectdeficit);

		wait(driver, "5");

		Fluentwait(driver, dropdown_option);
		click(driver, dropdown_option);

		Fluentwait(driver, Budget_Reposition);
		click(driver, Budget_Reposition);

		Fluentwait(driver, Budget);
		click(driver, Budget);
		wait(driver, "4");

//		uploadFileRobot(driver, EquimentType_Alphabets);

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
		click(driver, ERO_Save);

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
		Fluentwait(driver, ERO_Chart);
		click(driver, ERO_Chart);

		wait(driver, "5");

		WebElement chart = driver.findElement(By.xpath("//object"));
		driver.switchTo().frame(chart);

		Jsclick(driver, By_Cost);

		driver.switchTo().defaultContent();

		wait(driver, "2");
		Fluentwait(driver, ERO_Equipment_Reposition_Report);
		click(driver, ERO_Equipment_Reposition_Report);

		List<String> Columnname = Arrays.asList("origin", "delivery", "sizetype", "containercount", "cost", "totcost",
				"transitTime", "remarks");

		List<String> Names = Arrays.asList("Load Location", "Disch Location", "Equipment Type", "Quantity",
				"Cost Per Box(USD)", "Total Cost(USD)", "Transit Days", "Remarks");

		int size = Columnname.size();

		for (int i = 0; i < size; i++) {

			String columns = Columnname.get(i);

			String Column_Name = Names.get(i);
			wait(driver, "1");
			WebElement element = driver
					.findElement(By.xpath("(//div[@row-id='0'])[11]//div[@col-id='" + columns + "']"));

			act.moveToElement(element).build().perform();

			wait(driver, "5");

			if (element.isDisplayed()) {

				System.out.println(
						"After click on Equipment Reposition Report " + Column_Name + " was displayed in the grid");
				Extent_pass(driver,
						"After click on Equipment Reposition Report " + Column_Name + " was displayed in the grid",
						test, test1);
			} else {
				System.out.println(
						"After click on Equipment Reposition Report" + Column_Name + " was not displayed in the grid");
				Extent_fail(driver,
						"After click on Equipment Reposition Report " + Column_Name + " was not displayed in the grid",
						test, test1);

			}
		}

		WebElement scroller = driver.findElement(By.xpath("(//div[@ref='eBodyHorizontalScrollViewport'])[4]"));

		int scrollAmount = 1450; // trans 1 svc

		js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller, scrollAmount);

		List<String> Columnname1 = Arrays.asList("loadregion", "loadcountry", "dischcountry", "dischregion",
				"mainService", "loadmmrsector", "pOL", "pOLService", "trans1");

		List<String> Names1 = Arrays.asList("Load Region", "Load Country", "Disch Country", "Disch Region",
				"Main Service", "Origin Mode", "POL", "POL Svc", "Trans1");

		int size1 = Columnname1.size();

		for (int i = 0; i < size1; i++) {

			String columns = Columnname1.get(i);

			String Column_Name = Names1.get(i);
			wait(driver, "1");
			WebElement element = driver
					.findElement(By.xpath("(//div[@row-id='0'])[11]//div[@col-id='" + columns + "']"));

			act.moveToElement(element).build().perform();

			wait(driver, "5");

			if (element.isDisplayed()) {

				System.out.println(
						"After click on Equipment Reposition Report " + Column_Name + " was displayed in the grid");
				Extent_pass(driver,
						"After click on Equipment Reposition Report " + Column_Name + " was displayed in the grid",
						test, test1);
			} else {
				System.out.println(
						"After click on Equipment Reposition Report" + Column_Name + " was not displayed in the grid");
				Extent_fail(driver,
						"After click on Equipment Reposition Report " + Column_Name + " was not displayed in the grid",
						test, test1);

			}
		}

		WebElement scroller2 = driver.findElement(By.xpath("(//div[@ref='eBodyHorizontalScrollViewport'])[4]"));

		int scrollAmount2 = 1000; // trans 1 svc

		js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller2, scrollAmount2);
		List<String> Columnname3 = Arrays.asList("trans1Svc", "trans2", "trans2Svc", "trans3", "trans3Svc", "pOD",
				"dischmmrsector", "dLoadCost", "dDischDCost");

		List<String> Names3 = Arrays.asList("Trans1 Svc", "Trans2", "Trans2 Svc", "Trans3", "Trans3 Svc", "POD",
				"Delivery Mode", "Load Cost", "Disch Cost");

		int size3 = Columnname3.size();

		for (int i = 0; i < size3; i++) {

			String columns = Columnname3.get(i);

			String Column_Name = Names3.get(i);
			wait(driver, "1");
			WebElement element = driver
					.findElement(By.xpath("(//div[@row-id='0'])[11]//div[@col-id='" + columns + "']"));

			act.moveToElement(element).build().perform();

			wait(driver, "5");

			if (element.isDisplayed()) {

				System.out.println(
						"After click on Equipment Reposition Report " + Column_Name + " was displayed in the grid");
				Extent_pass(driver,
						"After click on Equipment Reposition Report " + Column_Name + " was displayed in the grid",
						test, test1);
			} else {
				System.out.println(
						"After click on Equipment Reposition Report" + Column_Name + " was not displayed in the grid");
				Extent_fail(driver,
						"After click on Equipment Reposition Report " + Column_Name + " was not displayed in the grid",
						test, test1);

			}
		}

		WebElement scroller3 = driver.findElement(By.xpath("(//div[@ref='eBodyHorizontalScrollViewport'])[4]"));

		int scrollAmount3 = 1000; // trans 1 svc

		js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller3, scrollAmount3);

		List<String> Columnname4 = Arrays.asList("dTS1LoadCost", "dTS2LoadCost", "dTS3LoadCost", "dTS1DischCost",
				"dTS2DischCost", "dTS3DischCost", "dFdrCost1", "loadsector");

		List<String> Names4 = Arrays.asList("TS1 Load Cost", "TS2 Load Cost", "TS3 Load Cost", "TS1 Disch Cost",
				"TS2 Disch Cost", "TS3 Disch Cost", "Feeder Cost 1", "Feeder 1 Terms");

		int size4 = Columnname4.size();

		for (int i = 0; i < size4; i++) {

			String columns = Columnname4.get(i);

			String Column_Name = Names4.get(i);
			wait(driver, "1");
			WebElement element = driver
					.findElement(By.xpath("(//div[@row-id='0'])[11]//div[@col-id='" + columns + "']"));

			act.moveToElement(element).build().perform();

			wait(driver, "5");

			if (element.isDisplayed()) {

				System.out.println(
						"After click on Equipment Reposition Report " + Column_Name + " was displayed in the grid");
				Extent_pass(driver,
						"After click on Equipment Reposition Report " + Column_Name + " was displayed in the grid",
						test, test1);
			} else {
				System.out.println(
						"After click on Equipment Reposition Report" + Column_Name + " was not displayed in the grid");
				Extent_fail(driver,
						"After click on Equipment Reposition Report " + Column_Name + " was not displayed in the grid",
						test, test1);

			}
		}

		WebElement scroller4 = driver.findElement(By.xpath("(//div[@ref='eBodyHorizontalScrollViewport'])[4]"));

		int scrollAmount4 = 1100; // trans 1 svc

		js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller4, scrollAmount4);

		List<String> Columnname5 = Arrays.asList("dFdrCost2", "dischsector", "dFdrCost3", "loadtca", "dLoadHlgCost",
				"dDischHlgCost", "dIntFdrCost1", "dIntFdrCost2", "dIntFdrCost3", "dIntFdrCost4", "dOthersCost");

		List<String> Names5 = Arrays.asList("Feeder Cost 2", "Feeder 2 Terms", "Feeder Cost 3", "Feeder 3 Terms",
				"Load Haulage Cost", "Disch Haulage Cost", "DPH Origin Cost", "DPH Destination Cost", "LCT Origin Cost",
				"LCT Destination Cost", "In Service Destination Cost");

		int size5 = Columnname5.size();

		for (int i = 0; i < size5; i++) {

			String columns = Columnname5.get(i);

			String Column_Name = Names5.get(i);
			wait(driver, "1");
			WebElement element = driver
					.findElement(By.xpath("(//div[@row-id='0'])[11]//div[@col-id='" + columns + "']"));

			act.moveToElement(element).build().perform();

			wait(driver, "5");

			if (element.isDisplayed()) {

				System.out.println(
						"After click on Equipment Reposition Report " + Column_Name + " was displayed in the grid");
				Extent_pass(driver,
						"After click on Equipment Reposition Report " + Column_Name + " was displayed in the grid",
						test, test1);
			} else {
				System.out.println(
						"After click on Equipment Reposition Report" + Column_Name + " was not displayed in the grid");
				Extent_fail(driver,
						"After click on Equipment Reposition Report " + Column_Name + " was not displayed in the grid",
						test, test1);

			}
		}

		System.out.println("Testcase 271, completed");

		Fluentwait(driver, Optimizer_Clo);
		click(driver, Optimizer_Clo);

		Extent_cal(test,
				"Testcase 281,Ensure the “All Equipment Reposition solve” screen navigate to Equipment Reposition report screen for all size type and single size type option");

		wait(driver, "2");
		Fluentwait(driver, All_20s_Option);
		click(driver, All_20s_Option);
		Fluentwait(driver, ERO_Size_Type_Label);
		click(driver, ERO_Size_Type_Label);
		wait(driver, "1");
		Fluentwait(driver, ERO_Size_Type_Label_1);
		click(driver, ERO_Size_Type_Label_1);
		Fluentwait(driver, Optimizer);
		click(driver, Optimizer);
		wait(driver, "2");
		Fluentwait(driver, Optimizer_Ok);
		click(driver, Optimizer_Ok);
		Fluentwait(driver, ERO_Equipment_Reposition_Report);
		click(driver, ERO_Equipment_Reposition_Report);

		List<String> Columnname8 = Arrays.asList("origin", "delivery", "sizetype", "containercount", "cost", "totcost",
				"transitTime", "remarks");

		List<String> Names8 = Arrays.asList("Load Location", "Disch Location", "Equipment Type", "Quantity",
				"Cost Per Box(USD)", "Total Cost(USD)", "Transit Days", "Remarks");

		int size8 = Columnname8.size();

		for (int i = 0; i < size8; i++) {

			String columns = Columnname8.get(i);

			String Column_Name = Names8.get(i);
			wait(driver, "1");
			WebElement element = driver
					.findElement(By.xpath("(//div[@row-id='0'])[11]//div[@col-id='" + columns + "']"));

			act.moveToElement(element).build().perform();

			wait(driver, "5");

			if (element.isDisplayed()) {

				System.out.println(
						"After click on Equipment Reposition Report " + Column_Name + " was displayed in the grid");
				Extent_pass(driver,
						"After click on Equipment Reposition Report " + Column_Name + " was displayed in the grid",
						test, test1);
			} else {
				System.out.println(
						"After click on Equipment Reposition Report" + Column_Name + " was not displayed in the grid");
				Extent_fail(driver,
						"After click on Equipment Reposition Report " + Column_Name + " was not displayed in the grid",
						test, test1);

			}
		}
		WebElement scroller9 = driver.findElement(By.xpath("(//div[@ref='eBodyHorizontalScrollViewport'])[4]"));

		int scrollAmount9 = 1450; // trans 1 svc

		js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller9, scrollAmount9);

		List<String> Columnname9 = Arrays.asList("loadregion", "loadcountry", "dischcountry", "dischregion",
				"mainService", "loadmmrsector", "pOL", "pOLService", "trans1");

		List<String> Names9 = Arrays.asList("Load Region", "Load Country", "Disch Country", "Disch Region",
				"Main Service", "Origin Mode", "POL", "POL Svc", "Trans1");

		int size9 = Columnname9.size();

		for (int i = 0; i < size9; i++) {

			String columns = Columnname9.get(i);

			String Column_Name = Names9.get(i);
			wait(driver, "1");
			WebElement element = driver
					.findElement(By.xpath("(//div[@row-id='0'])[11]//div[@col-id='" + columns + "']"));

			act.moveToElement(element).build().perform();

			wait(driver, "5");

			if (element.isDisplayed()) {

				System.out.println(
						"After click on Equipment Reposition Report " + Column_Name + " was displayed in the grid");
				Extent_pass(driver,
						"After click on Equipment Reposition Report " + Column_Name + " was displayed in the grid",
						test, test1);
			} else {
				System.out.println(
						"After click on Equipment Reposition Report" + Column_Name + " was not displayed in the grid");
				Extent_fail(driver,
						"After click on Equipment Reposition Report " + Column_Name + " was not displayed in the grid",
						test, test1);

			}
		}
		WebElement scroller_val = driver.findElement(By.xpath("(//div[@ref='eBodyHorizontalScrollViewport'])[4]"));

		int scrollAmount_val = 1000; // trans 1 svc

		js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller_val, scrollAmount_val);
		List<String> Column_name = Arrays.asList("trans1Svc", "trans2", "trans2Svc", "trans3", "trans3Svc", "pOD",
				"dischmmrsector", "dLoadCost", "dDischDCost");

		List<String> Name = Arrays.asList("Trans1 Svc", "Trans2", "Trans2 Svc", "Trans3", "Trans3 Svc", "POD",
				"Delivery Mode", "Load Cost", "Disch Cost");

		int sizes = Column_name.size();

		for (int i = 0; i < sizes; i++) {

			String columns = Column_name.get(i);

			String Column_Name = Name.get(i);
			wait(driver, "1");
			WebElement element = driver
					.findElement(By.xpath("(//div[@row-id='0'])[11]//div[@col-id='" + columns + "']"));

			act.moveToElement(element).build().perform();

			wait(driver, "5");

			if (element.isDisplayed()) {

				System.out.println(
						"After click on Equipment Reposition Report " + Column_Name + " was displayed in the grid");
				Extent_pass(driver,
						"After click on Equipment Reposition Report " + Column_Name + " was displayed in the grid",
						test, test1);
			} else {
				System.out.println(
						"After click on Equipment Reposition Report" + Column_Name + " was not displayed in the grid");
				Extent_fail(driver,
						"After click on Equipment Reposition Report " + Column_Name + " was not displayed in the grid",
						test, test1);

			}
		}

		WebElement scroller_val1 = driver.findElement(By.xpath("(//div[@ref='eBodyHorizontalScrollViewport'])[4]"));

		int scrollAmount_val1 = 1000;

		js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller_val1, scrollAmount_val1);

		List<String> Column_Name2 = Arrays.asList("dTS1LoadCost", "dTS2LoadCost", "dTS3LoadCost", "dTS1DischCost",
				"dTS2DischCost", "dTS3DischCost", "dFdrCost1", "loadsector");

		List<String> Column_Name1 = Arrays.asList("TS1 Load Cost", "TS2 Load Cost", "TS3 Load Cost", "TS1 Disch Cost",
				"TS2 Disch Cost", "TS3 Disch Cost", "Feeder Cost 1", "Feeder 1 Terms");

		int sizes1 = Column_Name2.size();

		for (int i = 0; i < sizes1; i++) {

			String columns = Column_Name2.get(i);

			String Column_Name = Column_Name1.get(i);
			wait(driver, "1");
			WebElement element = driver
					.findElement(By.xpath("(//div[@row-id='0'])[11]//div[@col-id='" + columns + "']"));

			act.moveToElement(element).build().perform();

			wait(driver, "5");

			if (element.isDisplayed()) {

				System.out.println(
						"After click on Equipment Reposition Report " + Column_Name + " was displayed in the grid");
				Extent_pass(driver,
						"After click on Equipment Reposition Report " + Column_Name + " was displayed in the grid",
						test, test1);
			} else {
				System.out.println(
						"After click on Equipment Reposition Report" + Column_Name + " was not displayed in the grid");
				Extent_fail(driver,
						"After click on Equipment Reposition Report " + Column_Name + " was not displayed in the grid",
						test, test1);
				;

			}
		}

		WebElement scroller_val2 = driver.findElement(By.xpath("(//div[@ref='eBodyHorizontalScrollViewport'])[4]"));

		int scrollAmount_val2 = 1100; // trans 1 svc

		js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller_val2, scrollAmount_val2);

		List<String> Column_Name3 = Arrays.asList("dFdrCost2", "dischsector", "dFdrCost3", "loadtca", "dLoadHlgCost",
				"dDischHlgCost", "dIntFdrCost1", "dIntFdrCost2", "dIntFdrCost3", "dIntFdrCost4", "dOthersCost");

		List<String> Name5 = Arrays.asList("Feeder Cost 2", "Feeder 2 Terms", "Feeder Cost 3", "Feeder 3 Terms",
				"Load Haulage Cost", "Disch Haulage Cost", "DPH Origin Cost", "DPH Destination Cost", "LCT Origin Cost",
				"LCT Destination Cost", "In Service Destination Cost");

		int sizes5 = Column_Name3.size();

		for (int i = 0; i < sizes5; i++) {

			String columns = Column_Name3.get(i);

			String Column_Name = Name5.get(i);
			wait(driver, "1");
			WebElement element = driver
					.findElement(By.xpath("(//div[@row-id='0'])[11]//div[@col-id='" + columns + "']"));

			act.moveToElement(element).build().perform();

			wait(driver, "5");

			if (element.isDisplayed()) {

				System.out.println(
						"After click on Equipment Reposition Report " + Column_Name + " was displayed in the grid");
				Extent_pass(driver,
						"After click on Equipment Reposition Report " + Column_Name + " was displayed in the grid",
						test, test1);
			} else {
				System.out.println(
						"After click on Equipment Reposition Report" + Column_Name + " was not displayed in the grid");
				Extent_fail(driver,
						"After click on Equipment Reposition Report " + Column_Name + " was not displayed in the grid",
						test, test1);

			}
		}

		Fluentwait(driver, Optimizer_Clo);
		click(driver, Optimizer_Clo);
		wait(driver, "2");
		Fluentwait(driver, All_option);
		click(driver, All_option);
		Fluentwait(driver, Optimizer);
		click(driver, Optimizer);
		wait(driver, "2");
		Fluentwait(driver, Optimizer_Ok);
		click(driver, Optimizer_Ok);
		Fluentwait(driver, ERO_Equipment_Reposition_Report);
		click(driver, ERO_Equipment_Reposition_Report);

		List<String> Column_name8 = Arrays.asList("origin", "delivery", "sizetype", "containercount", "cost", "totcost",
				"transitTime", "remarks");

		List<String> Names_8 = Arrays.asList("Load Location", "Disch Location", "Equipment Type", "Quantity",
				"Cost Per Box(USD)", "Total Cost(USD)", "Transit Days", "Remarks");

		int size_8 = Column_name8.size();

		for (int i = 0; i < size_8; i++) {

			String columns = Column_name8.get(i);

			String Column_Name = Names_8.get(i);
			wait(driver, "1");
			WebElement element = driver
					.findElement(By.xpath("(//div[@row-id='0'])[11]//div[@col-id='" + columns + "']"));

			act.moveToElement(element).build().perform();

			wait(driver, "5");

			if (element.isDisplayed()) {

				System.out.println(
						"After click on Equipment Reposition Report " + Column_Name + " was displayed in the grid");
				Extent_pass(driver,
						"After click on Equipment Reposition Report " + Column_Name + " was displayed in the grid",
						test, test1);
			} else {
				System.out.println(
						"After click on Equipment Reposition Report" + Column_Name + " was not displayed in the grid");
				Extent_fail(driver,
						"After click on Equipment Reposition Report " + Column_Name + " was not displayed in the grid",
						test, test1);

			}
		}
		WebElement scroller_9 = driver.findElement(By.xpath("(//div[@ref='eBodyHorizontalScrollViewport'])[4]"));

		int scrollAmount_9 = 1450; // trans 1 svc

		js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller_9, scrollAmount_9);

		List<String> Columnname_9 = Arrays.asList("loadregion", "loadcountry", "dischcountry", "dischregion",
				"mainService", "loadmmrsector", "pOL", "pOLService", "trans1");

		List<String> Names_9 = Arrays.asList("Load Region", "Load Country", "Disch Country", "Disch Region",
				"Main Service", "Origin Mode", "POL", "POL Svc", "Trans1");

		int size_9 = Columnname_9.size();

		for (int i = 0; i < size_9; i++) {

			String columns = Columnname_9.get(i);

			String Column_Name = Names_9.get(i);
			wait(driver, "1");
			WebElement element = driver
					.findElement(By.xpath("(//div[@row-id='0'])[11]//div[@col-id='" + columns + "']"));

			act.moveToElement(element).build().perform();

			wait(driver, "5");

			if (element.isDisplayed()) {

				System.out.println(
						"After click on Equipment Reposition Report " + Column_Name + " was displayed in the grid");
				Extent_pass(driver,
						"After click on Equipment Reposition Report " + Column_Name + " was displayed in the grid",
						test, test1);
			} else {
				System.out.println(
						"After click on Equipment Reposition Report" + Column_Name + " was not displayed in the grid");
				Extent_fail(driver,
						"After click on Equipment Reposition Report " + Column_Name + " was not displayed in the grid",
						test, test1);

			}
		}
		WebElement scroller_val5 = driver.findElement(By.xpath("(//div[@ref='eBodyHorizontalScrollViewport'])[4]"));

		int scrollAmount_val5 = 1000; // trans 1 svc

		js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller_val5, scrollAmount_val5);
		List<String> Column_name5 = Arrays.asList("trans1Svc", "trans2", "trans2Svc", "trans3", "trans3Svc", "pOD",
				"dischmmrsector", "dLoadCost", "dDischDCost");

		List<String> Name7 = Arrays.asList("Trans1 Svc", "Trans2", "Trans2 Svc", "Trans3", "Trans3 Svc", "POD",
				"Delivery Mode", "Load Cost", "Disch Cost");

		int sizes7 = Column_name5.size();

		for (int i = 0; i < sizes7; i++) {

			String columns = Column_name5.get(i);

			String Column_Name = Name7.get(i);
			wait(driver, "1");
			WebElement element = driver
					.findElement(By.xpath("(//div[@row-id='0'])[11]//div[@col-id='" + columns + "']"));

			act.moveToElement(element).build().perform();

			wait(driver, "5");

			if (element.isDisplayed()) {

				System.out.println(
						"After click on Equipment Reposition Report " + Column_Name + " was displayed in the grid");
				Extent_pass(driver,
						"After click on Equipment Reposition Report " + Column_Name + " was displayed in the grid",
						test, test1);
			} else {
				System.out.println(
						"After click on Equipment Reposition Report" + Column_Name + " was not displayed in the grid");
				Extent_fail(driver,
						"After click on Equipment Reposition Report " + Column_Name + " was not displayed in the grid",
						test, test1);

			}
		}

		WebElement scroller_val10 = driver.findElement(By.xpath("(//div[@ref='eBodyHorizontalScrollViewport'])[4]"));

		int scrollAmount_val10 = 1000;

		js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller_val10, scrollAmount_val10);

		List<String> Column_Name20 = Arrays.asList("dTS1LoadCost", "dTS2LoadCost", "dTS3LoadCost", "dTS1DischCost",
				"dTS2DischCost", "dTS3DischCost", "dFdrCost1", "loadsector");

		List<String> Column_Name11 = Arrays.asList("TS1 Load Cost", "TS2 Load Cost", "TS3 Load Cost", "TS1 Disch Cost",
				"TS2 Disch Cost", "TS3 Disch Cost", "Feeder Cost 1", "Feeder 1 Terms");

		int sizes11 = Column_Name20.size();

		for (int i = 0; i < sizes11; i++) {

			String columns = Column_Name20.get(i);

			String Column_Name = Column_Name11.get(i);
			wait(driver, "1");
			WebElement element = driver
					.findElement(By.xpath("(//div[@row-id='0'])[11]//div[@col-id='" + columns + "']"));

			act.moveToElement(element).build().perform();

			wait(driver, "5");

			if (element.isDisplayed()) {

				System.out.println(
						"After click on Equipment Reposition Report " + Column_Name + " was displayed in the grid");
				Extent_pass(driver,
						"After click on Equipment Reposition Report " + Column_Name + " was displayed in the grid",
						test, test1);
			} else {
				System.out.println(
						"After click on Equipment Reposition Report" + Column_Name + " was not displayed in the grid");
				Extent_fail(driver,
						"After click on Equipment Reposition Report " + Column_Name + " was not displayed in the grid",
						test, test1);

			}
		}

		WebElement scroller_val12 = driver.findElement(By.xpath("(//div[@ref='eBodyHorizontalScrollViewport'])[4]"));

		int scrollAmount_val12 = 1100; // trans 1 svc

		js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller_val12, scrollAmount_val12);

		List<String> Column_Name13 = Arrays.asList("dFdrCost2", "dischsector", "dFdrCost3", "loadtca", "dLoadHlgCost",
				"dDischHlgCost", "dIntFdrCost1", "dIntFdrCost2", "dIntFdrCost3", "dIntFdrCost4", "dOthersCost");

		List<String> Name15 = Arrays.asList("Feeder Cost 2", "Feeder 2 Terms", "Feeder Cost 3", "Feeder 3 Terms",
				"Load Haulage Cost", "Disch Haulage Cost", "DPH Origin Cost", "DPH Destination Cost", "LCT Origin Cost",
				"LCT Destination Cost", "In Service Destination Cost");

		int sizes15 = Column_Name13.size();

		for (int i = 0; i < sizes15; i++) {

			String columns = Column_Name13.get(i);

			String Column_Name = Name15.get(i);
			wait(driver, "1");
			WebElement element = driver
					.findElement(By.xpath("(//div[@row-id='0'])[11]//div[@col-id='" + columns + "']"));

			act.moveToElement(element).build().perform();

			wait(driver, "5");

			if (element.isDisplayed()) {

				System.out.println(
						"After click on Equipment Reposition Report " + Column_Name + " was displayed in the grid");
				Extent_pass(driver,
						"After click on Equipment Reposition Report " + Column_Name + " was displayed in the grid",
						test, test1);
			} else {
				System.out.println(
						"After click on Equipment Reposition Report" + Column_Name + " was not displayed in the grid");
				Extent_fail(driver,
						"After click on Equipment Reposition Report " + Column_Name + " was not displayed in the grid",
						test, test1);

			}
		}
		System.out.println("Testcase 281, completed");

		Fluentwait(driver, Optimizer_Clo);
		click(driver, Optimizer_Clo);
		wait(driver, "2");

		Extent_cal(test, "Testcase 335,Ensure while clicking the optimizer button reference window should be display");

		Fluentwait(driver, Optimizer);
		click(driver, Optimizer);
		wait(driver, "2");
		Fluentwait(driver, Optimizer_Ok);
		click(driver, Optimizer_Ok);

		if (isDisplayed(driver, ERO_Equipment_Reposition_Solve)) {

			System.out.println("After click on Optimizer button Equipment Reposition Solve was displayed in the grid");
			Extent_pass(driver, "After click on Optimizer button Equipment Reposition Solve was displayed in the grid",
					test, test1);
		} else {
			System.out.println(
					"After click on Optimizer button Equipment Reposition Solve was not displayed in the grid");
			Extent_fail(driver,
					"After click on Optimizer button Equipment Reposition Solve was not displayed in the grid", test,
					test1);
		}
		wait(driver, "2");

		if (isDisplayed(driver, ERO_Equipment_Reposition_Report)) {

			System.out.println(
					"After click on Optimizer button Equipment Reposition Report page was displayed in the grid");
			Extent_pass(driver,
					"After click on Optimizer button Equipment Reposition Report page was displayed in the grid", test,
					test1);
		} else {
			System.out.println(
					"After click on Optimizer button Equipment Reposition Report page was not displayed in the grid");
			Extent_fail(driver,
					"After click on Optimizer button Equipment Reposition Report page was not displayed in the grid",
					test, test1);
		}
		wait(driver, "2");
		if (isDisplayed(driver, ERO_Unsatisfied_Report)) {

			System.out.println("After click on Optimizer button Unsatisfied Report page was displayed in the grid");
			Extent_pass(driver, "After click on Optimizer button Unsatisfied Report page was displayed in the grid",
					test, test1);
		} else {
			System.out.println("After click on Optimizer button Unsatisfied Report page was not displayed in the grid");
			Extent_fail(driver, "After click on Optimizer button Unsatisfied Report page was not displayed in the grid",
					test, test1);
		}
		wait(driver, "2");

		if (isDisplayed(driver, ERO_Hire_Report)) {

			System.out.println("After click on Optimizer button Hire Report  page was displayed in the grid");
			Extent_pass(driver, "After click on Optimizer button Hire Report page was displayed in the grid", test,
					test1);
		} else {
			System.out.println("After click on Optimizer button Hire Report page was not displayed in the grid");
			Extent_fail(driver, "After click on Optimizer button Hire Report page was not displayed in the grid", test,
					test1);
		}
		wait(driver, "2");
		if (isDisplayed(driver, ERO_Lease_Report)) {

			System.out.println("After click on Optimizer button Lease Report  page was displayed in the grid");
			Extent_pass(driver, "After click on Optimizer button Lease Report page was displayed in the grid", test,
					test1);
		} else {
			System.out.println("After click on Optimizer button Lease Report page was not displayed in the grid");
			Extent_fail(driver, "After click on Optimizer button Lease Report page was not displayed in the grid", test,
					test1);
		}

		wait(driver, "2");
		if (isDisplayed(driver, ERO_Chat)) {

			System.out.println("After click on Optimizer button ERO Chart  page was displayed in the grid");
			Extent_pass(driver, "After click on Optimizer button ERO Chart page was displayed in the grid", test,
					test1);
		} else {
			System.out.println("After click on Optimizer button ERO Chart page was not displayed in the grid");
			Extent_fail(driver, "After click on Optimizer button ERO Chart page was not displayed in the grid", test,
					test1);
		}
		wait(driver, "2");
		if (isDisplayed(driver, ERO_Hire_Summary)) {

			System.out.println("After click on Optimizer button On/Off-Hire Summary  page was displayed in the grid");
			Extent_pass(driver, "After click on Optimizer button On/Off-Hire Summary page was displayed in the grid",
					test, test1);
		} else {
			System.out
					.println("After click on Optimizer button On/Off-Hire Summary page was not displayed in the grid");
			Extent_fail(driver,
					"After click on Optimizer button On/Off-Hire Summary page was not displayed in the grid", test,
					test1);
		}
		wait(driver, "2");
		if (isDisplayed(driver, ERO_Total_Summary)) {

			System.out.println("After click on Optimizer button Total Summary page was displayed in the grid");
			Extent_pass(driver, "After click on Optimizer button Total Summary page was displayed in the grid", test,
					test1);
		} else {
			System.out.println("After click on Optimizer button Total Summary page was not displayed in the grid");
			Extent_fail(driver, "After click on Optimizer button Total Summary page was not displayed in the grid",
					test, test1);
		}

		System.out.println("Testcase 235, completed");

	}
}