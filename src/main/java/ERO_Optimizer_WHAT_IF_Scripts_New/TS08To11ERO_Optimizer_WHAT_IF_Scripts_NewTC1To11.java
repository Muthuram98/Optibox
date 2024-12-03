package ERO_Optimizer_WHAT_IF_Scripts_New;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.Utils;

public class TS08To11ERO_Optimizer_WHAT_IF_Scripts_NewTC1To11 extends Keywords {

	public void Scenario8(WebDriver driver, ExtentTest test, ExtentTest test1, String url, int dataset) {
		System.out.println("url : " + url);
		String Username = Utils.getDataFromTestData("TS08_EroOptimizer_WHAT_IF_new_Dataset"+dataset, "ERO_Optimizer WHAT_IF",
				"Username");
		String Password = Utils.getDataFromTestData("TS08_EroOptimizer_WHAT_IF_new_Dataset"+dataset, "ERO_Optimizer WHAT_IF",
				"Password");
		String Id = Utils.getDataFromTestData("TS08_EroOptimizer_WHAT_IF_new_Dataset"+dataset, "ERO_Optimizer WHAT_IF", "Id");
		
		String Expected_Version_Xposition = Utils.getDataFromTestData("TS08_EroOptimizer_WHAT_IF_new_Dataset"+dataset, "ERO_Optimizer WHAT_IF","Version_Xposition");
		String Expected_Version_Yposition = Utils.getDataFromTestData("TS08_EroOptimizer_WHAT_IF_new_Dataset"+dataset, "ERO_Optimizer WHAT_IF","Version_Yposition");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
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
		Fluentwait(driver, Searchbox);
		sendKeys(driver, Searchbox, "Optimizer WHAT – IF Scenario");
		
		Extent_cal(test, "Testcase 8.1 -Ensure that lease report displays record");	
		
	
		Fluentwait(driver, SelectOptimizer);
		click(driver, SelectOptimizer);
		Fluentwait(driver, Optimizer_Globalserach);
		click(driver, Optimizer_Globalserach);
		Fluentwait(driver, Globalserach_IDInput);
		
		sendKeys(driver, Globalserach_IDInput, Id );
		
		wait(driver, "2");

		Fluentwait(driver, Click_Search);
		click(driver, Click_Search);

		wait(driver, "5");

		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);
		wait(driver, "8");
		
		Fluentwait(driver, Optimizer_button);
		click(driver, Optimizer_button);
		
		Fluentwait(driver, Optimizer_Ok1);
		click(driver, Optimizer_Ok1);
		
		wait(driver, "5");
		Fluentwait(driver, Optimizer_Lease_Report);
		click(driver, Optimizer_Lease_Report);
		wait(driver, "5");	
		Actions action=new Actions(driver);
		wait(driver,"2");
		List<String>lease=Arrays.asList("origin","delivery","sizetype","containercount","cost","totcost","transitTime","remarks","loadregion","loadcountry","dischcountry","dischregion","mainService","loadmmrsector","pOL","pOLService","trans1","trans1Svc","trans2","trans2Svc","trans3Svc","pOD","dischmmrsector","dLoadCost","dDischDCost","dTS1LoadCost","dTS2LoadCost","dTS3LoadCost","dTS1DischCost","dTS2DischCost","dTS3DischCost","dFdrCost1","loadsector","dFdrCost2","dischsector","dFdrCost3","loadtca","dLoadHlgCost","dDischHlgCost","dIntFdrCost1","dIntFdrCost2","dIntFdrCost3","dIntFdrCost4","dOthersCost");
		List<String>lease_header=Arrays.asList("Load Location","Disch Location","Equipment Type","Quantity","Cost Per Box(USD)","Total Cost(USD)","Transit Days","Remarks","Load Region","Load Country","Disch Country","Disch Region","Main Service","Origin Mode","POL","POL Svc","Trans1","Trans1 Svc","Trans2","Trans2 Svc","Trans3","Trans3 Svc","POD","Delivery Mode","Load Cost","Disch Cost","TS1 Load Cost","TS2 Load Cost","TS3 Load Cost","TS1 Disch Cost","TS2 Disch Cost","TS3 Disch Cost","Feeder Cost 1","Feeder 1 Terms","Feeder Cost 2","Feeder 2 Terms","Feeder Cost 3","Feeder 3 Terms","Load Haulage Cost","Disch Haulage Cost","DPH Origin Cost","DPH Destination Cost","LCT Origin Cost","LCT Destination Cost","In Service Destination Cost");
		int lease_val=lease.size();
		
		for(int i=0;i<lease_val;i++) {
			String coloum=lease.get(i);
			String coloum_head=lease_header.get(i);
	        WebElement lease_report=driver.findElement(By.xpath("//div[@id='OPT-OPT_treeTable5']//div[@col-id='"+coloum+"']"));
	
             ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", lease_report);
			
			action.moveToElement(lease_report).build().perform();
//			wait(driver,"1");	
			if(lease_report.isDisplayed()) {
				
				System.out.println("After click on Hire Report  "+coloum_head+ " was displayed in the grid");
				Extent_pass(driver, "After click on Hire Report  "+coloum_head+ " was displayed in the grid", test,test1);
			}else {
				System.out.println("After click on Hire Report "+coloum_head+ " was not displayed in the grid");
				Extent_fail(driver, "After click on Hire Report" +coloum_head+ " was not displayed in the grid", test,test1);
			}		
		}
		
		System.out.println("**********Testcase_8.1**************");	
		
		Extent_cal(test, "Testcase 8.2 -Ensure that total Moved Quantity displayed properly");		
		
		wait(driver,"4");
		
		int total_moved=0;
		boolean loopRun=true;
	
		int l=0;
	
		while(loopRun) {
			try {
				WebElement cellEle=driver.findElement(By.xpath("//div[@row-id='"+l+"']//div[@col-id='containercount']"));
				String CellText = cellEle.getText();
				if (!CellText.isEmpty() || !CellText.equals("")) {
					int cellNum = Integer.parseInt(CellText);
					total_moved=total_moved+cellNum;
				}
				action.moveToElement(cellEle).build().perform();
				
			}catch(Exception e) {
				loopRun=false;
			}
			l++;
		}
				
		System.out.println("total_moved  : "+total_moved);
		
		int quantity = 0;
		
		String count = getText(driver, Onewaylease_count);
		
		WebElement scroller1 = driver.findElement(By.xpath("(//div[@ref='eBodyHorizontalScrollViewport'])[6]"));
		js.executeScript("arguments[0].scrollLeft = 0;", scroller1);	
				
		scrollBottom(driver);
		
		for (int i = 0; i < Integer.parseInt(count); i++) {
		    // Modify the XPath to use 'i' for different row-ids dynamically
		    WebElement totalquantity = driver.findElement(By.xpath("//div[@row-id='" + i + "']//div[@col-id='containercount']"));
					
		    Actions act = new Actions(driver);
		    act.moveToElement(totalquantity).build().perform();
				
		    String total_quantity = totalquantity.getText();
		    
		    // Add the value of total_cost to costs instead of replacing it
		    quantity += Integer.parseInt(total_quantity);
		}		
		
		System.out.println("quantity : "+quantity);
		
		wait(driver,"4");	
		mouseOverAndClick(driver, Optimizer_lease_total_qu);
		Fluentwait(driver, Optimizer_lease_total_qu);
		String Ave_Exe = getAttribute(driver, Optimizer_lease_total_qu, "value");
		int AveExe_val = Integer.parseInt(Ave_Exe);
		System.out.println("AveExe_val :" + AveExe_val);

		if (quantity == AveExe_val) {

			Extent_pass(driver, "Expected value was : " + AveExe_val + "Actual value was : " + quantity, test,test1);
		} else {

			Extent_fail(driver, "Expected value was : " + AveExe_val + "Actual value was : " + quantity, test,
					test1);
		}
		
		System.out.println("**********Testcase_8.2**************");		
		
		Extent_cal(test, "Testcase 8.3 - Ensure that Total One-Way Lease Quantity displayed properly");
		
		String Total_qty = getAttribute(driver, Onewaylease_total, "value");
		
		if(!Total_qty.isEmpty()) {
			
			System.out.println("Total one way lease quantity displayed properly");
			Extent_pass(driver, "Total one way lease quantity displayed properly", test, test1);
		}else {
			
			System.out.println("Total one way lease quantity not displayed properly");
			Extent_fail(driver, "Total one way lease quantity not displayed properly", test, test1);
		}
		
		System.out.println("Testcase 8.3 completed");
		
		
		Extent_cal(test, "Testcase 8.4 - Ensure that Average Cost Per Box  displayed properly");
		
		WebElement scroller = driver.findElement(By.xpath("(//div[@ref='eBodyHorizontalScrollViewport'])[6]"));
		js.executeScript("arguments[0].scrollLeft = 0;", scroller);	
		
		String Actual_Avg_cost = getAttribute(driver, Avg_costperbox, "value");
		
		scrollBottom(driver);
		
		double costs = 0;
		
//		String count = getText(driver, Onewaylease_count);
		
		for (int i = 0; i < Integer.parseInt(count); i++) {
		    // Modify the XPath to use 'i' for different row-ids dynamically
		    WebElement totalcosts = driver.findElement(By.xpath("//div[@row-id='" + i + "']//div[@col-id='totcost']"));
					
		    Actions act = new Actions(driver);
		    act.moveToElement(totalcosts).build().perform();
				
		    String total_cost = totalcosts.getText();
		    
		    // Add the value of total_cost to costs instead of replacing it
		    costs += Integer.parseInt(total_cost);
		}		
		
		System.out.println("costs : "+costs);
		
		mouseOverAndClick(driver, Optimizer_lease_total_qu);
		Fluentwait(driver, Optimizer_lease_total_qu);
	
		String Total_quantity = getAttribute(driver, Optimizer_lease_total_qu, "value");
		
		double qty = Double.valueOf(Total_quantity);
		
		double average_costs = costs / qty;
		
		String formattedValue = String.format("%.2f", average_costs);
		
		
		if(Actual_Avg_cost.equals(formattedValue)) {
			
			System.out.println("Average cost was calculated correctly and displayed in the field");
			Extent_pass(driver, "Average cost was calculated correctly and displayed in the field", test, test1);
			Extent_pass(driver, "Expected avg cost per box : "+formattedValue+" Actual avg cost per box : "+Actual_Avg_cost , test, test1);
		}else {			
			System.out.println("Average cost was not calculated correctly");
			Extent_fail(driver, "Average cost was not calculated correctly", test, test1);
			Extent_fail(driver, "Expected avg cost per box : "+formattedValue+" Actual avg cost per box : "+Actual_Avg_cost , test, test1);
		}
		
		System.out.println("Testcase 8.4 completed");
		
		Extent_cal(test, "Testcase 8.5 -Ensure that Grand total displayed properly");	
		
		wait(driver,"4");
		double Grand_Total=0;
		boolean loopRun1=true;
		int k=0;
		while(loopRun1) {
			try {
				WebElement cellEle=driver.findElement(By.xpath("//div[@ref='eCenterContainer']//div[@row-id='"+k+"']/div[@col-id='totcost']"));
				String CellText = cellEle.getText();
				if (!CellText.isEmpty() || !CellText.equals("")) {
					double cellNum = Double.parseDouble(CellText);
					Grand_Total=Grand_Total+cellNum;
				}
				action.moveToElement(cellEle).build().perform();
				
			}catch(Exception e) {
				loopRun1=false;
			}
			k++;
		}
				
		System.out.println("total_moved  : "+Grand_Total);
		wait(driver,"4");	
		mouseOverAndClick(driver, Optimizer_lease_Grand_total);
		Fluentwait(driver, Optimizer_lease_Grand_total);
		String Ave_Exe1 = getAttribute(driver, Optimizer_lease_Grand_total, "value");
		if(Ave_Exe1.contains(",")) {
			Ave_Exe1=Ave_Exe1.replace(",", "");
		}
		double AveExe_val2 = Double.parseDouble(Ave_Exe1);
		
		System.out.println("AveExe_val :" + AveExe_val2);
		

		if (Grand_Total == AveExe_val2) {

			Extent_pass(driver, "Expected value was : " + AveExe_val2 + "Actual value was : " + Grand_Total, test,test1);
		} else {

			Extent_fail(driver, "Expected value was : " + AveExe_val2 + "Actual value was : " + Grand_Total, test,
					test1);
		}
		
		System.out.println("**********Testcase_8.5**************");		
		
		
		Extent_cal(test, "Testcase 9.1 - Ensure that ERO Chart displays record");
		
		scrollBottom(driver);
		
		Fluentwait(driver, Optimizer_Ero_Chart);
		click(driver, Optimizer_Ero_Chart);
		
		wait(driver,"5");
		
		if(isDisplayed(driver, Ero_Chart1)) {			
			System.out.println("ERO Charts are displayed");
			Extent_pass(driver, "ERO Charts are displayed", test, test1);
		}else {
			System.out.println("ERO Charts are not displayed");
			Extent_fail(driver, "ERO Charts are not displayed", test, test1);
			
		}
		
		System.out.println("Testcase 9.1 completed");
		
	
		Extent_cal(test, "Testcase 10.1 - Ensure that on/off hire summary displays record");
		
		Fluentwait(driver, On_off_hiresummary);
		click(driver, On_off_hiresummary);
		
		if(isDisplayed(driver, On_off_hire_table)) {
			
			System.out.println("On off hire table is displayed");
			Extent_pass(driver, "On off hire table is displayed", test, test1);
		}else {
			
			System.out.println("On off hire table is not displayed");
			Extent_pass(driver, "On off hire table is not displayed", test, test1);
		}
		
		
		Extent_cal(test, "Testcase 11.1 -Ensure that total summary displays record");
		
		wait(driver,"4");
		
		Scrolltilltheelementvisible(driver, Optimizer_Total_summary);
		click(driver, Optimizer_Total_summary);
		
		wait(driver,"4");	
		
		if(isDisplayed(driver, Optimizer_oneWayLease)) {
			
			System.out.println("After click on Total Summary, One-Way Lease Details  was displayed in the grid");
			Extent_pass(driver, "After click on Total Summary, One-Way Lease Details  was displayed in the grid", test,test1);
		}else {
			System.out.println("After click on Total Summary, One-Way Lease Details  was not displayed in the grid");
			Extent_fail(driver, "After click on Total Summary, One-Way Lease Details  was not displayed in the grid", test,test1);
		}	
		
		wait(driver,"4");	
		if(isDisplayed(driver, Optimizer_Summary_Details)) {
			
			System.out.println("After click on Total Summary ,Summary Details  was displayed in the grid");
			Extent_pass(driver, "After click on Total Summary, Summary Details  was displayed in the grid", test,test1);
		}else {
			System.out.println("After click on Total Summary, Summary Details  was not displayed in the grid");
			Extent_fail(driver, "After click on Total Summary, Summary Details  was not displayed in the grid", test,test1);
		}		
		wait(driver,"2");
       if(isDisplayed(driver, Optimizer_GrandTotalVal)) {
			
			System.out.println("After click on Total Summary ,Grand Total  was displayed in the grid");
			Extent_pass(driver, "After click on Total Summary, Grand Total   was displayed in the grid", test,test1);
		}else {
			System.out.println("After click on Total Summary, Grand Total  was not displayed in the grid");
			Extent_fail(driver, "After click on Total Summary, Grand Total   was not displayed in the grid", test,test1);
		}	
		
   	System.out.println("**********Testcase_11.1**************");		
	
   	Extent_cal(test, "Testcase 11.2 -Ensure that version get displayed in bottom of screen");	
   	
	wait(driver,"3");
	Scrolltilltheelementvisible(driver, Optimizer_version);

	try {
		WebElement versionfield = driver.findElement(By.xpath("//label[contains(text(),'Version')]"));

		Point location = versionfield.getLocation();

		int xposition = location.getX();

		String actual_version_XPosition = String.valueOf(xposition);

		System.out.println("xposition :" + actual_version_XPosition);

		int yposition = location.getY();

		String actual_version_YPosition = String.valueOf(yposition);

		System.out.println("yposition :" + actual_version_YPosition);

		if (actual_version_XPosition.equals(Expected_Version_Xposition)
				&& actual_version_YPosition.equals(Expected_Version_Yposition)) {

			System.out.println("Version field is placed at the bottom of the left corner of the screen");
			Extent_pass(driver, "Version field is placed at the bottom of the left corner of the screen", test,test1);
			Extent_pass(driver, "Expected Version field X position is : " + Expected_Version_Xposition
					+ " || Actual Version field X position is : " + actual_version_XPosition, test,test1);
			Extent_pass(driver, "Expected Version field Y position is : " + Expected_Version_Yposition
					+ " || Actual Version field Y position is : " + actual_version_YPosition, test,test1);

		} else {

			System.out.println("Version field is not placed at the bottom of the left corner of the screen");
			Extent_fail(driver, "Version field is not placed at the bottom of the left corner of the screen", test,test1);
			Extent_fail(driver, "Expected Version field X position is : " + Expected_Version_Xposition
					+ " || Actual Version field X position is : " + actual_version_XPosition, test,test1);
			Extent_fail(driver, "Expected Version field Y position is : " + Expected_Version_Yposition
					+ " || Actual Version field Y position is : " + actual_version_YPosition, test,test1);
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		Extent_fail(driver, e.getLocalizedMessage(), test,test1);
	}
	
	System.out.println("************Testcase 11.2*************");
	
	
	
	
	
	
	
	
	
	
	}
	
}
