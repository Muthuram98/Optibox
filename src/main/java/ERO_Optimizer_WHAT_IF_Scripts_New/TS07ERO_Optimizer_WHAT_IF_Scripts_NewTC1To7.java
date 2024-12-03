package ERO_Optimizer_WHAT_IF_Scripts_New;

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

public class TS07ERO_Optimizer_WHAT_IF_Scripts_NewTC1To7 extends Keywords{
	
	public void Scenario7(WebDriver driver, ExtentTest test, ExtentTest test1, String url, int dataset) {
		
		System.out.println("url : " + url);
		String Username = Utils.getDataFromTestData("TS07_EroOptimizer_WHAT_IF_new_Dataset"+dataset, "ERO_Optimizer WHAT_IF",
				"Username");
		String Password = Utils.getDataFromTestData("TS07_EroOptimizer_WHAT_IF_new_Dataset"+dataset, "ERO_Optimizer WHAT_IF",
				"Password");
		String ID = Utils.getDataFromTestData("TS07_EroOptimizer_WHAT_IF_new_Dataset"+dataset, "ERO_Optimizer WHAT_IF", "Id");
		
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
		
		Extent_cal(test, "Testcase 7.1 -Ensure that Hire report displays record");	
		
	
		Fluentwait(driver, SelectOptimizer);
		click(driver, SelectOptimizer);
		Fluentwait(driver, Optimizer_Globalserach);
		click(driver, Optimizer_Globalserach);
		Fluentwait(driver, Globalserach_IDInput);
		
		sendKeys(driver, Globalserach_IDInput,ID );
		
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
		Fluentwait(driver, Optimizer_Hire_Report);
		click(driver, Optimizer_Hire_Report);
		wait(driver, "5");
		Actions action=new Actions(driver);
		
		List<String>hire=Arrays.asList("Load Location","Disch Location","Equipment Type","Quantity","Cost Per Box(USD)","Total Cost(USD)","Transit Days","Remarks");
		
		int val=hire.size();
		for(int i=0;i<val;i++) {	
			String val1=hire.get(i);	
			WebElement hireReport=driver.findElement(By.xpath("(//div[@id='OPT-OPT_treeTable4']//span[text()='"+val1+"'])[1]"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", hireReport);
			
			action.moveToElement(hireReport).build().perform();
			wait(driver,"5");	
			if(hireReport.isDisplayed()) {
				
				System.out.println("After click on Hire Report  "+val1+ " was displayed in the grid");
				Extent_pass(driver, "After click on Hire Report  "+val1+ " was displayed in the grid", test,test1);
			}else {
				System.out.println("After click on Hire Report "+val1+ " was not displayed in the grid");
				Extent_fail(driver, "After click on Hire Report" +val1+ " was not displayed in the grid", test,test1);
			}		
		}
 
		WebElement scroller = driver.findElement(By.xpath("(//div[@ref='eBodyHorizontalScrollViewport'])[5]"));
		int scrollAmount = 1000; //
		js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller, scrollAmount);	
		
     List<String>hire1=Arrays.asList("Load Region","Load Country","Disch Country","Disch Region","Main Service","Origin Mode","POL","POL Svc","Trans1","Trans1 Svc","Trans2","Trans2 Svc","Trans3","Trans3 Svc","POD","Delivery Mode","Load Cost","Disch Cost","TS1 Load Cost","TS2 Load Cost","TS3 Load Cost","TS1 Disch Cost","TS2 Disch Cost","TS3 Disch Cost","Feeder Cost 1","Feeder 1 Terms","Feeder Cost 2","Feeder 2 Terms","Feeder Cost 3","Feeder 3 Terms","Load Haulage Cost","Disch Haulage Cost","DPH Origin Cost","DPH Destination Cost","LCT Origin Cost","LCT Destination Cost","On-Hire Cost","Off-Hire Cost");
		
		int val1=hire1.size();
		for(int i=0;i<val1;i++) {	
			String val2=hire1.get(i);	
			WebElement hireReport=driver.findElement(By.xpath("(//div[@id='OPT-OPT_treeTable4']//span[text()='"+val2+"'])[1]"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", hireReport);
			
			action.moveToElement(hireReport).build().perform();
			wait(driver,"1");	
			if(hireReport.isDisplayed()) {
				
				System.out.println("After click on Hire Report  "+val2+ " was displayed in the grid");
				Extent_pass(driver, "After click on Hire Report  "+val2+ " was displayed in the grid", test,test1);
			}else {
				System.out.println("After click on Hire Report "+val2+ " was not displayed in the grid");
				Extent_fail(driver, "After click on Hire Report" +val2+ " was not displayed in the grid", test,test1);
			}		
		}
		
		
		
		System.out.println("**********Testcase_7.1**************");	
		
		
		Extent_cal(test, "Testcase 7.2 - Ensure that Total On-Hire Quantity displayed properly");
		
		js.executeScript("arguments[0].scrollLeft = 0;", scroller);	
		
		scrollBottom(driver);
		
		String total_onhire = getAttribute(driver, Total_onhire_quantity, "value");
		
		if(!total_onhire.isEmpty()) {
			
			System.out.println("On hire quantity is displayed properly");
			Extent_pass(driver, "On hire quantity is displayed properly", test, test1);
		}else {
			
			System.out.println("On hire quantity is not displayed properly");
			Extent_fail(driver, "On hire quantity is not displayed properly", test, test1);
		}
		
		System.out.println("Testcase 7.2 completed");
		
		
		Extent_cal(test, "Tesctase 7.3 - Ensure that Total Off-Hire Quantity displayed properly");
		
		
		String total_offhire = getAttribute(driver, Total_onhire_quantity, "value");
		
		if(!total_offhire.isEmpty()) {
			
			System.out.println("Off hire quantity is displayed properly");
			Extent_pass(driver, "Off hire quantity is displayed properly", test, test1);
		}else {
			
			System.out.println("Off hire quantity is not displayed properly");
			Extent_fail(driver, "Off hire quantity is not displayed properly", test, test1);
		}
		
		
		System.out.println("Testcase 7.3 completed");
		
		
		Extent_cal(test, "Testcase 7.4 - Ensure that Total Moved Quantity displayed properly");
		
		String total_movedquantity = getAttribute(driver, Total_moved_quantity, "value");
		
		if(!total_movedquantity.isEmpty()) {
			
			System.out.println("Total moved quantity is displayed properly");
			Extent_pass(driver, "Total moved quantity is displayed properly", test, test1);
		}else {
			
			System.out.println("Total moved quantity is not displayed properly");
			Extent_fail(driver, "Total moved quantity is not displayed properly", test, test1);
		}
		
		
		System.out.println("Testcase 7.4 completed");
		
		
		Extent_cal(test, "Testcase 7.5 - Ensure that Total Moved Quantity displayed properly");
		
		String Total_record = getText(driver, Hire_Total_records).trim();
		
		double moved = 0; // Initialize costs to 0
		
		for (int i = 0; i < Integer.parseInt(Total_record); i++) {

			WebElement totalmoved = driver.findElement(By.xpath("//div[@row-id='" + i + "']//div[@col-id='containercount']"));
					
		    Actions act = new Actions(driver);
		    act.moveToElement(totalmoved).build().perform();
				
		    String total_totalmoved = totalmoved.getText();
		    
		    // Add the value of total_cost to costs instead of replacing it
		    moved += Integer.parseInt(total_totalmoved);
		}		
		
		System.out.println("costs : "+moved);
		
		
		String[] Expected_values = String.valueOf(moved).split("\\.");
		
		if(total_movedquantity.equals(Expected_values[0])) {
			Extent_pass(driver, "Expected moved quantity : "+Expected_values[0]+" Actual moved quantity : "+total_movedquantity, test, test1);
			System.out.println("Total moved quantity is displayed correctly");
			Extent_pass(driver, "Total moved quantity is displayed correctly", test, test1);
		}else {
			Extent_fail(driver, "Expected moved quantity : "+Expected_values[0]+" Actual moved quantity : "+total_movedquantity, test, test1);
			System.out.println("Total moved quantity is displayed correctly");
			Extent_fail(driver, "Total moved quantity is displayed correctly", test, test1);
		}
		
		System.out.println("Testcase 7.5 completed");
		
		Extent_cal(test, "Testcase 7.6 - Ensure that Average Cost Per Box  displayed properly");
		
		double costs = 0;
		
		for (int i = 0; i < Integer.parseInt(Total_record); i++) {
		    // Modify the XPath to use 'i' for different row-ids dynamically
		    WebElement totalcosts = driver.findElement(By.xpath("//div[@row-id='" + i + "']//div[@col-id='totcost']"));
					
		    Actions act = new Actions(driver);
		    act.moveToElement(totalcosts).build().perform();
				
		    String total_cost = totalcosts.getText();
		    
		    // Add the value of total_cost to costs instead of replacing it
		    costs += Integer.parseInt(total_cost);
		}		
		
		System.out.println("costs : "+costs);
		
		mouseOverAndClick(driver, Total_moved_quantity);
		Fluentwait(driver, Total_moved_quantity);
	
		String Total_quantity = getAttribute(driver, Total_moved_quantity, "value");
		
		double qty = Double.valueOf(Total_quantity);
		
		double average_costs = costs / qty;
		
		String formattedValue = String.format("%.2f", average_costs);
		
		String Acutal_avg = getAttribute(driver, Hire_avg_cost, "value");
		
		if(Acutal_avg.equals(formattedValue)) {
			
			System.out.println("Average cost was calculated correctly and displayed in the field");
			Extent_pass(driver, "Average cost was calculated correctly and displayed in the field", test, test1);
			Extent_pass(driver, "Expected avg cost per box : "+formattedValue+" Actual avg cost per box : "+Acutal_avg , test, test1);
		}else {			
			System.out.println("Average cost was not calculated correctly");
			Extent_fail(driver, "Average cost was not calculated correctly", test, test1);
			Extent_fail(driver, "Expected avg cost per box : "+formattedValue+" Actual avg cost per box : "+Acutal_avg , test, test1);
		}
		
		System.out.println("Testcase 7.6 completed");
		
		
		Extent_cal(test, "Testcase 7.7 - Ensure that Grand total displayed properly");
		
		String total_cost = String.format("%.2f", costs);
		
		String actual_total = getAttribute(driver, Hire_grand_total, "value").replace(",", "");
		
		if(actual_total.equals(total_cost)) {
			
			System.out.println("Grand total cost was correctly calculated");
			Extent_pass(driver, "Grand total cost was correctly calculated", test, test1);
			Extent_pass(driver,  "Expected Total cost : "+total_cost+" Actual Total cost : "+actual_total, test, test1);
		}else {			
			System.out.println("Grand total cost was not correctly calculated");
			Extent_fail(driver, "Grand total cost was not correctly calculated", test, test1);
			Extent_fail(driver,  "Expected Total cost : "+total_cost+" Actual Total cost : "+actual_total, test, test1);
		}
		
		System.out.println("Testcase 7.7 completed");
		
		
}
}