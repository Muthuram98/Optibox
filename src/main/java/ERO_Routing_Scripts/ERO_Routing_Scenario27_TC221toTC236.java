package ERO_Routing_Scripts;

import java.awt.Robot;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.Utils;

public class ERO_Routing_Scenario27_TC221toTC236 extends Keywords {
	@SuppressWarnings("deprecation")
	public void ERO_Routing_Scenario27(WebDriver driver, ExtentTest test,  ExtentTest test1,String url, int dataset) throws Exception {

		String Username = Utils.getDataFromTestData("ERO_Scenario27_Dataset"+dataset, "ERO Routing", "Username");
		String Password = Utils.getDataFromTestData("ERO_Scenario27_Dataset"+dataset, "ERO Routing", "Password");
		String ID = Utils.getDataFromTestData("ERO_Scenario27_Dataset"+dataset, "ERO Routing", "Id");

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

		Extent_cal(test, "Testcase 236,Ensure the  Back button functionality single size type");
		wait(driver, "2");
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

		Fluentwait(driver, ERO_Popup_Ok);
		click(driver, ERO_Popup_Ok);

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

//		uploadFileRobot(driver, EquimentType_Alphabets);
		
		String upload_EquimentType_Alphabets = System.getProperty("user.dir") + "/driver/MasterDownloadfile.exe " + EquimentType_Alphabets;

		try {
			Runtime.getRuntime().exec(upload_EquimentType_Alphabets);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getLocalizedMessage());
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
		}		
		
		wait(driver,"10");
		
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
		Fluentwait(driver, ERO_Optimizer_Close);
		click(driver, ERO_Optimizer_Close);
		if (!isDisplayed(driver, ERO_40OT)) {
			Extent_pass(driver, "After click the close button optimizer screen is closed", test,test1);
		} else {
			Extent_fail(driver, "After click the close button optimizer screen  is not closed", test,test1);
		}
		System.out.println("Testcase_236,completed");

		Extent_cal(test, "Testcase 221,Ensure the  View Report button functionality  all size type");

		Fluentwait(driver, Optimizer);
		click(driver, Optimizer);
		wait(driver, "2");
		Fluentwait(driver, Optimizer_Ok);
		click(driver, Optimizer_Ok);
		wait(driver, "2");
		Fluentwait(driver, ERO_Equipment_Reposition_Report);
		click(driver, ERO_Equipment_Reposition_Report);

		List<String> Columnname3 = Arrays.asList("Load Location", "Disch Location", "Equipment Type", "Quantity",
				"Cost Per Box(USD)", "Total Cost(USD)", "Transit Days", "Remarks");
		int size = Columnname3.size();

		for (int i = 0; i < size; i++) {

			String columns3 = Columnname3.get(i);
			WebElement element = driver.findElement(
					By.xpath("//div[@id='OPT-OPT_treeTable1_tbl']//following::span[text()='" + columns3 + "']"));
			act.moveToElement(element).build().perform();
			wait(driver, "5");

			if (element.isDisplayed()) {

				System.out.println("Equipment reposition report " + columns3 + " was displayed in the grid");
				Extent_pass(driver, "Equipment reposition report " + columns3 + " was displayed in the grid", test,test1);
			} else {
				System.out.println("Equipment reposition report " + columns3 + " was not displayed in the grid");
				Extent_fail(driver, "Equipment reposition report " + columns3 + " was not displayed in the grid",
						test,test1);
			}
		}

		List<String> Columnname = Arrays.asList("Load Country", "Disch Country", "Disch Region",
				"Main Service", "Origin Mode", "POL Svc", "Trans1", "Trans1 Svc", "Trans2", "Trans2 Svc", "Trans3",
				"Trans3 Svc", "POD", "Delivery Mode", "Load Cost", "Disch Cost", "TS1 Load Cost", "TS2 Load Cost",
				"TS3 Load Cost", "TS1 Disch Cost", "TS2 Disch Cost", "TS3 Disch Cost", "Feeder Cost 1",
				"Feeder 1 Terms", "Feeder Cost 2", "Feeder 2 Terms", "Feeder Cost 3", "Feeder 3 Terms",
				"Load Haulage Cost", "Disch Haulage Cost", "DPH Origin Cost", "DPH Destination Cost", "LCT Origin Cost",
				"LCT Destination Cost", "In Service Destination Cost");
		int size1 = Columnname.size();
		WebElement scroller = driver.findElement(By.xpath("(//div[@ref='eBodyHorizontalScrollViewport'])[4]"));

		int scrollAmount = 1500; //

		js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller, scrollAmount);

		for (int i = 0; i < size1; i++) {

			String columns3 = Columnname.get(i);
			WebElement element = driver.findElement(
					By.xpath("//div[@id='OPT-OPT_treeTable1_tbl']//following::span[text()='" + columns3 + "']"));
			act.moveToElement(element).build().perform();
			wait(driver, "5");

			if (element.isDisplayed()) {

				System.out.println(" Equipment reposition report " + columns3 + " was displayed in the grid");
				Extent_pass(driver, " Equipment reposition report " + columns3 + " was displayed in the grid", test,test1);
			} else {
				System.out.println("Equipment reposition report " + columns3 + " was not displayed in the grid");
				Extent_fail(driver, "Equipment reposition report " + columns3 + " was not displayed in the grid",
						test,test1);
			}
		}

		wait(driver, "2");
		Fluentwait(driver, ERO_Unsatisfied_Report);
		click(driver, ERO_Unsatisfied_Report);

		List<String> Columnname4 = Arrays.asList("Location Code", "Equipment Type", "Quantity", "Remarks");
		int sizes = Columnname4.size();
		for (int i = 0; i < sizes; i++) {

			String columns3 = Columnname4.get(i);
			
			WebElement element = driver.findElement(By.xpath("(//div[@id='OPT-OPT_treeTable2']//following::span[text()='"+columns3+"'])[1]"));
			act.moveToElement(element).build().perform();
			wait(driver, "5");

			if (element.isDisplayed()) {

				System.out.println("Unsatisfied Report report " + columns3 + " was displayed in the grid");
				Extent_pass(driver, "Unsatisfied Report report " + columns3 + " was displayed in the grid", test,test1);
			} else {
				System.out.println("Unsatisfied Report report " + columns3 + " was not displayed in the grid");
				Extent_fail(driver, "Unsatisfied Report report " + columns3 + " was not displayed in the grid",test,test1);
			}
		}

		wait(driver, "2");
		Fluentwait(driver, ERO_Hire_Report);
		click(driver, ERO_Hire_Report);
		
		
		List<String> Columnname_va = Arrays.asList("Load Location","Disch Location","Equipment Type","Quantity","Cost Per Box(USD)","Total Cost(USD)","Transit Days","Remarks");
		int size2 = Columnname_va.size();

		for (int i = 0; i < size2; i++) {

			String columns3 = Columnname_va.get(i);
			
			WebElement element = driver.findElement(By.xpath("(//div[@id='OPT-OPT_treeTable4']//following::span[text()='"+columns3+"'])[1]"));
			act.moveToElement(element).build().perform();
			wait(driver, "5");

			if (element.isDisplayed()) {

				System.out.println(" Hire report " + columns3 + " was displayed in the grid");
				Extent_pass(driver, "Hire report " + columns3 + " was displayed in the grid", test,test1);
			} else {
				System.out.println("Hire report " + columns3 + " was not displayed in the grid");
				Extent_fail(driver, "Hire report " + columns3 + " was not displayed in the grid",test,test1);
		}
		}
		
		List<String> Columnname11 = Arrays.asList("Load Region","Load Country","Disch Country","Disch Region","Main Service","Origin Mode","POL","POL Svc","Trans1","Trans1 Svc","Trans2","Trans2 Svc","Trans3","Trans3 Svc","POD","Delivery Mode","Load Cost","Disch Cost","TS1 Load Cost","TS2 Load Cost","TS3 Load Cost","TS1 Disch Cost","TS2 Disch Cost","TS3 Disch Cost","Feeder Cost 1","Feeder 1 Terms","Feeder Cost 2","Feeder 2 Terms","Feeder Cost 3","Feeder 3 Terms","Load Haulage Cost","Disch Haulage Cost","DPH Origin Cost","DPH Destination Cost","LCT Origin Cost","LCT Destination Cost","On-Hire Cost","Off-Hire Cost");
		int size11 = Columnname11.size();
		WebElement scroller11 = driver.findElement(By.xpath("(//div[@ref='eBodyHorizontalScrollViewport'])[7]"));

		int scrollAmount11 = 1300; //

		js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller11, scrollAmount11);

		for (int i = 0; i < size11; i++) {

			String columns3 = Columnname11.get(i);
			WebElement element = driver.findElement(By.xpath("(//div[@id='OPT-OPT_treeTable4']//following::span[text()='"+columns3+"'])[1]"));
			act.moveToElement(element).build().perform();
			wait(driver, "5");

			if (element.isDisplayed()) {

				System.out.println(" Hire report" + columns3 + " was displayed in the grid");
				Extent_pass(driver, " Hire report " + columns3 + " was displayed in the grid", test,test1);
			} else {
				System.out.println("Hire report " + columns3 + " was not displayed in the grid");
				Extent_fail(driver, "Hire report " + columns3 + " was not displayed in the grid",
						test,test1);
			}
		}
		
		wait(driver, "2");
		Fluentwait(driver, ERO_Lease_Report);
		click(driver, ERO_Lease_Report);
		
		List<String> Columnname_va1 = Arrays.asList("Load Location","Disch Location","Equipment Type","Quantity","Cost Per Box(USD)","Total Cost(USD)","Transit Days","Remarks");
		int size3 = Columnname_va1.size();
		WebElement scroller2 = driver.findElement(By.xpath("(//div[@ref='eBodyHorizontalScrollViewport'])[8]"));

		int scrollAmount3 = 50; //

		js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller2, scrollAmount3);

		for (int i = 0; i < size3; i++) {

			String columns3 = Columnname_va1.get(i);
			WebElement element = driver.findElement(By.xpath("(//div[@id='OPT-OPT_treeTable5']//following::span[text()='"+columns3+"'])[1]"));
			act.moveToElement(element).build().perform();
			wait(driver, "5");

			if (element.isDisplayed()) {

				System.out.println("Lease Report  " + columns3 + " was displayed in the grid");
				Extent_pass(driver, "Lease Reportt " + columns3 + " was displayed in the grid", test,test1);
			} else {
				System.out.println("Lease Report " + columns3 + " was not displayed in the grid");
				Extent_fail(driver, "Lease Report " + columns3 + " was not displayed in the grid",test,test1);
		}
		}
		
		List<String> Columnname13 = Arrays.asList("Load Region","Load Country","Disch Country","Disch Region","Main Service","Origin Mode","POL","POL Svc","Trans1","Trans1 Svc","Trans2","Trans2 Svc","Trans3","Trans3 Svc","POD","Delivery Mode","Load Cost","Disch Cost","TS1 Load Cost","TS2 Load Cost","TS3 Load Cost","TS1 Disch Cost","TS2 Disch Cost","TS3 Disch Cost","Feeder Cost 1","Feeder 1 Terms","Feeder Cost 2","Feeder 2 Terms","Feeder Cost 3","Feeder 3 Terms","Load Haulage Cost","Disch Haulage Cost","DPH Origin Cost","DPH Destination Cost","LCT Origin Cost","LCT Destination Cost","In Service Destination Cost");
		int size13 = Columnname13.size();
		WebElement scroller13 = driver.findElement(By.xpath("(//div[@ref='eBodyHorizontalScrollViewport'])[8]"));

		int scrollAmount13 = 1300; //

		js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller13, scrollAmount13);

		for (int i = 0; i < size13; i++) {

			String columns3 = Columnname13.get(i);
			WebElement element = driver.findElement(By.xpath("(//div[@id='OPT-OPT_treeTable5']//following::span[text()='"+columns3+"'])[1]"));
			act.moveToElement(element).build().perform();
			wait(driver, "5");

			if (element.isDisplayed()) {

				System.out.println(" Lease Report " + columns3 + " was displayed in the grid");
				Extent_pass(driver, " Lease Report " + columns3 + " was displayed in the grid", test,test1);
			} else {
				System.out.println("Lease Report " + columns3 + " was not displayed in the grid");
				Extent_fail(driver, "Lease Report " + columns3 + " was not displayed in the grid",
						test,test1);
			}
		}
		
		System.out.println("Testcase_221,completed");
		
		Fluentwait(driver, Defic_cancle2);
		click(driver, Defic_cancle2);
		
		Extent_cal(test, "Testcase 222,Ensure the View Report button functionality  single size type");
		
		Fluentwait(driver, All_20s_Option);
		click(driver, All_20s_Option);
		Fluentwait(driver, ERO_Size_Type_Label);
		click(driver, ERO_Size_Type_Label);
		Fluentwait(driver, ERO_Size_Type_Label_1);
		click(driver, ERO_Size_Type_Label_1);
		Fluentwait(driver, Optimizer);
		click(driver, Optimizer);
		wait(driver, "2");
		Fluentwait(driver, Optimizer_Ok);
		click(driver, Optimizer_Ok);
		wait(driver, "2");
		
		Fluentwait(driver, ERO_Equipment_Reposition_Report);
		click(driver, ERO_Equipment_Reposition_Report);

		List<String> Columnname5 = Arrays.asList("Load Location", "Disch Location", "Equipment Type", "Quantity",
				"Cost Per Box(USD)", "Total Cost(USD)", "Transit Days", "Remarks");
		int size5 = Columnname5.size();

		for (int i = 0; i < size5; i++) {

			String columns3 = Columnname5.get(i);
			WebElement element = driver.findElement(By.xpath("//div[@id='OPT-OPT_treeTable1_tbl']//following::span[text()='" + columns3 + "']"));
			act.moveToElement(element).build().perform();
			wait(driver, "5");

			if (element.isDisplayed()) {

				System.out.println("Equipment reposition report " + columns3 + " was displayed in the grid");
				Extent_pass(driver, "Equipment reposition report " + columns3 + " was displayed in the grid", test,test1);
			} else {
				System.out.println("Equipment reposition report " + columns3 + " was not displayed in the grid");
				Extent_fail(driver, "Equipment reposition report " + columns3 + " was not displayed in the grid",
						test,test1);
			}
		}

		List<String> Columnname6 = Arrays.asList( "Load Country", "Disch Country", "Disch Region",
				"Main Service", "Origin Mode", "POL Svc", "Trans1", "Trans1 Svc", "Trans2", "Trans2 Svc", "Trans3",
				"Trans3 Svc", "POD", "Delivery Mode", "Load Cost", "Disch Cost", "TS1 Load Cost", "TS2 Load Cost",
				"TS3 Load Cost", "TS1 Disch Cost", "TS2 Disch Cost", "TS3 Disch Cost", "Feeder Cost 1",
				"Feeder 1 Terms", "Feeder Cost 2", "Feeder 2 Terms", "Feeder Cost 3", "Feeder 3 Terms",
				"Load Haulage Cost", "Disch Haulage Cost", "DPH Origin Cost", "DPH Destination Cost", "LCT Origin Cost",
				"LCT Destination Cost", "In Service Destination Cost");
		int size6 = Columnname6.size();
		WebElement scroller6 = driver.findElement(By.xpath("(//div[@ref='eBodyHorizontalScrollViewport'])[4]"));

		int scrollAmount6 = 1500; //

		js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller6, scrollAmount6);

		for (int i = 0; i < size6; i++) {

			String columns3 = Columnname6.get(i);
			WebElement element = driver.findElement(
					By.xpath("//div[@id='OPT-OPT_treeTable1_tbl']//following::span[text()='" + columns3 + "']"));
			act.moveToElement(element).build().perform();
			wait(driver, "5");

			if (element.isDisplayed()) {

				System.out.println(" Equipment reposition report " + columns3 + " was displayed in the grid");
				Extent_pass(driver, " Equipment reposition report " + columns3 + " was displayed in the grid", test,test1);
			} else {
				System.out.println("Equipment reposition report " + columns3 + " was not displayed in the grid");
				Extent_fail(driver, "Equipment reposition report " + columns3 + " was not displayed in the grid",
						test,test1);
			}
		}

		wait(driver, "2");
		Fluentwait(driver, ERO_Unsatisfied_Report);
		click(driver, ERO_Unsatisfied_Report);

		List<String> Columnname7= Arrays.asList("Location Code", "Equipment Type", "Quantity", "Remarks");
		int sizes7 = Columnname7.size();
		for (int i = 0; i < sizes7; i++) {

			String columns3 = Columnname7.get(i);
			
			WebElement element = driver.findElement(By.xpath("(//div[@id='OPT-OPT_treeTable2']//following::span[text()='"+columns3+"'])[1]"));
			act.moveToElement(element).build().perform();
			wait(driver, "5");

			if (element.isDisplayed()) {

				System.out.println("Unsatisfied Report " + columns3 + " was displayed in the grid");
				Extent_pass(driver, "Unsatisfied Report " + columns3 + " was displayed in the grid", test,test1);
			} else {
				System.out.println("Unsatisfied Report  " + columns3 + " was not displayed in the grid");
				Extent_fail(driver, "Unsatisfied Report  " + columns3 + " was not displayed in the grid",test,test1);
			}
		}

		wait(driver, "2");
		Fluentwait(driver, ERO_Hire_Report);
		click(driver, ERO_Hire_Report);
		
		
		List<String> Columnname_va8 = Arrays.asList("Load Location","Disch Location","Equipment Type","Quantity","Cost Per Box(USD)","Total Cost(USD)","Transit Days","Remarks");
		int size8 = Columnname_va8.size();
		WebElement scroller8 = driver.findElement(By.xpath("(//div[@ref='eBodyHorizontalScrollViewport'])[7]"));

		int scrollAmount8 = 50; //

		js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller8, scrollAmount8);

		  for (int i = 0; i < size8; i++) {

			String columns3 = Columnname_va8.get(i);
			WebElement element = driver.findElement(By.xpath("(//div[@id='OPT-OPT_treeTable4']//following::span[text()='"+columns3+"'])[1]"));
			act.moveToElement(element).build().perform();
			wait(driver, "5");

			if (element.isDisplayed()) {

				System.out.println(" Hire report " + columns3 + " was displayed in the grid");
				Extent_pass(driver, "Hire report " + columns3 + " was displayed in the grid", test,test1);
			} else {
				System.out.println("Hire report " + columns3 + " was not displayed in the grid");
				Extent_fail(driver, "Hire report " + columns3 + " was not displayed in the grid",test,test1);
		}
		}
		List<String> Columnname16 = Arrays.asList("Load Region","Load Country","Disch Country","Disch Region","Main Service","Origin Mode","POL","POL Svc","Trans1","Trans1 Svc","Trans2","Trans2 Svc","Trans3","Trans3 Svc","POD","Delivery Mode","Load Cost","Disch Cost","TS1 Load Cost","TS2 Load Cost","TS3 Load Cost","TS1 Disch Cost","TS2 Disch Cost","TS3 Disch Cost","Feeder Cost 1","Feeder 1 Terms","Feeder Cost 2","Feeder 2 Terms","Feeder Cost 3","Feeder 3 Terms","Load Haulage Cost","Disch Haulage Cost","DPH Origin Cost","DPH Destination Cost","LCT Origin Cost","LCT Destination Cost","On-Hire Cost","Off-Hire Cost");
		int size16 = Columnname16.size();
		WebElement scroller16 = driver.findElement(By.xpath("(//div[@ref='eBodyHorizontalScrollViewport'])[7]"));

		int scrollAmount113 = 1300; //

		js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller16, scrollAmount113);

		for (int i = 0; i < size16; i++) {

			String columns3 = Columnname16.get(i);
			WebElement element = driver.findElement(By.xpath("(//div[@id='OPT-OPT_treeTable4']//following::span[text()='"+columns3+"'])[1]"));
			act.moveToElement(element).build().perform();
			wait(driver, "5");

			if (element.isDisplayed()) {

				System.out.println(" Hire report" + columns3 + " was displayed in the grid");
				Extent_pass(driver, " Hire report " + columns3 + " was displayed in the grid", test,test1);
			} else {
				System.out.println("Hire report " + columns3 + " was not displayed in the grid");
				Extent_fail(driver, "Hire report " + columns3 + " was not displayed in the grid",
						test,test1);
			}
		}
//			
		wait(driver, "2");
		Fluentwait(driver, ERO_Lease_Report);
		click(driver, ERO_Lease_Report);
		
		List<String> Columnname_va3 = Arrays.asList("Load Location","Disch Location","Equipment Type","Quantity","Cost Per Box(USD)","Total Cost(USD)","Transit Days","Remarks");
		int size7 = Columnname_va3.size();
		WebElement scroller7 = driver.findElement(By.xpath("(//div[@ref='eBodyHorizontalScrollViewport'])[8]"));

		int scrollAmount7 = 50; //

		js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller7, scrollAmount7);

		for (int i = 0; i < size7; i++) {

			String columns3 = Columnname_va3.get(i);
			WebElement element = driver.findElement(By.xpath("(//div[@id='OPT-OPT_treeTable5']//following::span[text()='"+columns3+"'])[1]"));
			act.moveToElement(element).build().perform();
			
			wait(driver, "5");

			if (element.isDisplayed()) {

				System.out.println("Lease Report  " + columns3 + " was displayed in the grid");
				Extent_pass(driver, "Lease Reportt " + columns3 + " was displayed in the grid", test,test1);
			} else {
				System.out.println("Lease Report " + columns3 + " was not displayed in the grid");
				Extent_fail(driver, "Lease Report " + columns3 + " was not displayed in the grid",test,test1);
		}
		}
		
		List<String> Columnname18 = Arrays.asList("Load Region","Load Country","Disch Country","Disch Region","Main Service","Origin Mode","POL","POL Svc","Trans1","Trans1 Svc","Trans2","Trans2 Svc","Trans3","Trans3 Svc","POD","Delivery Mode","Load Cost","Disch Cost","TS1 Load Cost","TS2 Load Cost","TS3 Load Cost","TS1 Disch Cost","TS2 Disch Cost","TS3 Disch Cost","Feeder Cost 1","Feeder 1 Terms","Feeder Cost 2","Feeder 2 Terms","Feeder Cost 3","Feeder 3 Terms","Load Haulage Cost","Disch Haulage Cost","DPH Origin Cost","DPH Destination Cost","LCT Origin Cost","LCT Destination Cost","In Service Destination Cost");
		int size18 = Columnname18.size();
		WebElement scroller18= driver.findElement(By.xpath("(//div[@ref='eBodyHorizontalScrollViewport'])[8]"));

		int scrollAmount18 = 1300; //

		js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller18, scrollAmount18);

		for (int i = 0; i < size18; i++) {

			String columns3 = Columnname18.get(i);
			WebElement element = driver.findElement(By.xpath("(//div[@id='OPT-OPT_treeTable5']//following::span[text()='"+columns3+"'])[1]"));
			act.moveToElement(element).build().perform();
			wait(driver, "5");

			if (element.isDisplayed()) {

				System.out.println(" Lease Report" + columns3 + " was displayed in the grid");
				Extent_pass(driver, " Lease Report " + columns3 + " was displayed in the grid", test,test1);
			} else {
				System.out.println("Lease Report " + columns3 + " was not displayed in the grid");
				Extent_fail(driver, "Lease Report " + columns3 + " was not displayed in the grid",
						test,test1);
			}
		}
		System.out.println("Testcase_222,completed");
		
		Extent_cal(test, "TC_232,Ensure the export excel button functionality for single size type it displayed equipment reposition report"); 	
		
		Fluentwait(driver, ERO_Equipment_Reposition_Report);
		click(driver, ERO_Equipment_Reposition_Report);
		
		Set<String> old_Files = getDirectoryFiles();

		wait(driver, "5");

		Fluentwait(driver, optimizer_export);
		click(driver, optimizer_export);

		wait(driver, "10");

		String baseFilenames = "OPT";

		boolean isDownloaded = isNewFileDownloaded(old_Files, baseFilenames);

		if (isDownloaded == true) {

			System.out.println("New excel file is downloaded in the downloads folder");
			Extent_pass(driver, "New excel file is downloaded in the downloads folder", test,test1);

		} else {
			System.out.println("New excel file is not downloaded");
			Extent_fail(driver, "New excel file is not downloaded", test,test1);
		}

		System.out.println("Testcase_232,completed");
		
		Extent_cal(test, "TC_224,Ensure the export excel button functionality for all size type it displayed equipment reposition solve and equipment reposition report "); 			
		
		Fluentwait(driver, ERO_Equipment_Reposition_Solve);
		click(driver, ERO_Equipment_Reposition_Solve);
		
		Set<String> old_Files1 = getDirectoryFiles();

		wait(driver, "5");

		Fluentwait(driver, optimizer_export);
		click(driver, optimizer_export);

		wait(driver, "10");

		String baseFilenames1 = "OPT";

		boolean isDownloaded1 = isNewFileDownloaded(old_Files1, baseFilenames1);

		if (isDownloaded1 == true) {

			System.out.println("New excel file is downloaded in the downloads folder");
			Extent_pass(driver, "New excel file is downloaded in the downloads folder", test,test1);

		} else {
			System.out.println("New excel file is not downloaded");
			Extent_fail(driver, "New excel file is not downloaded", test,test1);
		}
		System.out.println("Testcase_224,completed");
		
		Fluentwait(driver, Ero_cancle2);
		click(driver, Ero_cancle2);
		
		Extent_cal(test,"Testcase_228 Ensure the export excel button functionality for single size type it displayed equipment reposition solve");
		
		Fluentwait(driver, All_40s_Option);
		click(driver, All_40s_Option);
		
		Fluentwait(driver, ERO_Size_Type_Label);
		click(driver, ERO_Size_Type_Label);
		
		Fluentwait(driver, ERO_Size_Type_Label_1);
		click(driver, ERO_Size_Type_Label_1);
		
		Fluentwait(driver, Optimizer);
		click(driver, Optimizer);
		wait(driver, "2");
		
		Fluentwait(driver, Optimizer_Ok);
		click(driver, Optimizer_Ok);
		wait(driver, "2");
		Fluentwait(driver, ERO_Equipment_Reposition_Report);
		click(driver, ERO_Equipment_Reposition_Report);
		wait(driver, "2");
		
		Set<String> old_Files2= getDirectoryFiles();

		wait(driver, "5");

		Fluentwait(driver, optimizer_export);
		click(driver, optimizer_export);

		wait(driver, "10");

		String baseFilenames2 = "OPT";

		boolean isDownloaded2 = isNewFileDownloaded(old_Files2, baseFilenames2);

		if (isDownloaded2 == true) {

			System.out.println("New excel file is downloaded in the downloads folder");
			Extent_pass(driver, "New excel file is downloaded in the downloads folder", test,test1);

		} else {
			System.out.println("New excel file is not downloaded");
			Extent_fail(driver, "New excel file is not downloaded", test,test1);
		}
		
		System.out.println("Testcase_228,completed");
		
		
		
	}

}
