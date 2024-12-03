package ERO_Optimizer_WHAT_IF_Scripts_New;

import java.awt.Robot;
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

public class TS05ERO_Optimizer_WHAT_IF_Scripts_NewTC1To4 extends Keywords{
	public void Scenario5(WebDriver driver, ExtentTest test, ExtentTest test1, String url, int dataset) {

		System.out.println("url : " + url);
		String Username = Utils.getDataFromTestData("TS05_EroOptimizer_WHAT_IF_new_Dataset"+dataset, "ERO_Optimizer WHAT_IF",
				"Username");
		String Password = Utils.getDataFromTestData("TS05_EroOptimizer_WHAT_IF_new_Dataset"+dataset, "ERO_Optimizer WHAT_IF",
				"Password");
		String ID = Utils.getDataFromTestData("TS05_EroOptimizer_WHAT_IF_new_Dataset"+dataset, "ERO_Optimizer WHAT_IF", "Id");
		
		
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

		Extent_cal(test, "Testcase 5.1 -Ensure that equipment reposition report displays record");	
		
		Fluentwait(driver, SelectOptimizer);
		click(driver, SelectOptimizer);
		Fluentwait(driver, Optimizer_Globalserach);
		click(driver, Optimizer_Globalserach);

		Fluentwait(driver, Globalserach_IDInput);
		sendKeys(driver, Globalserach_IDInput, "B20240829-01-52-00016");
		
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

		Fluentwait(driver, Optimizer_Equipment_Report);
		click(driver, Optimizer_Equipment_Report);
		
		List<String> coloum=Arrays.asList("origin","delivery","sizetype","containercount","cost","totcost","transitTime","remarks","loadregion","loadcountry","dischcountry","dischregion","mainService","loadmmrsector","pOL","pOLService","trans1","trans1Svc","trans2","trans2Svc","trans3","trans3Svc","pOD","dischmmrsector","dLoadCost","dDischDCost","dTS1LoadCost","dTS2LoadCost","dTS3LoadCost","dTS1DischCost","dTS2DischCost","dTS3DischCost","dFdrCost1","loadsector","dFdrCost2","dischsector","dFdrCost3","loadtca","dLoadHlgCost","dDischHlgCost","dIntFdrCost1","dIntFdrCost2","dIntFdrCost3","dIntFdrCost4","dOthersCost");
		List<String> coloum_header=Arrays.asList("Load Location","Disch Location","Equipment Type","Quantity","Cost Per Box(USD)","Total Cost(USD)","Transit Days","Remarks","Load Region","Load Country","Disch Country","Disch Region","Main Service","Origin Mode","POL","POL Svc","Trans1","Trans1 Svc","Trans2","Trans2 Svc","Trans3","Trans3 Svc","POD","Delivery Mode","Load Cost","Disch Cost","TS1 Load Cost","TS2 Load Cost","TS3 Load Cost","TS1 Disch Cost","TS2 Disch Cost","TS3 Disch Cost","Feeder Cost 1","Feeder 1 Terms","Feeder Cost 2","Feeder 2 Terms","Feeder Cost 3","Feeder 3 Terms","Load Haulage Cost","Disch Haulage Cost","DPH Origin Cost","DPH Destination Cost","LCT Origin Cost","LCT Destination Cost","In Service Destination Cost");
		
		int size=coloum.size();
		for(int i=0;i<size;i++) {
		
			String col=coloum.get(i);
			String col_head=coloum_header.get(i);
			
			WebElement element=driver.findElement(By.xpath("//div[@id='OPT-OPT_treeTable1_tbl']//div[@col-id='"+col+"']"));
			
			 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			 Actions act = new Actions(driver);
				act.moveToElement(element).build().perform();

				wait(driver,"5");
				
				if(element.isDisplayed()) {
					
					System.out.println("After click on Equipment reposition report "+col_head+ " was displayed in the grid");
					Extent_pass(driver, "After click on Equipment reposition report "+col_head+ " was displayed in the grid", test,test1);
				}else {
					System.out.println("After click on Equipment reposition report "+col_head+ " was not displayed in the grid");
					Extent_fail(driver, "After click on Equipment reposition report "+col_head+ " was not displayed in the grid", test,test1);
				}		
			}

		System.out.println("**********Testcase_5.1**************");	
		
		Extent_cal(test, "Testcase 5.2 -Ensure that total quantity displayed properly");	
		Actions action=new Actions(driver);
	
		int ave_totalval=0;

		boolean loopRun=true;
		int l=0;
		while(loopRun) {
			try {
				WebElement cellEle=driver.findElement(By.xpath("//div[@ref='eCenterContainer']//div[@row-id='"+l+"']/div[@col-id='containercount']"));
				String CellText = cellEle.getText();
				if (!CellText.isEmpty() || !CellText.equals("")) {
					int cellNum = Integer.parseInt(CellText);
					ave_totalval=ave_totalval+cellNum;
				}
				action.moveToElement(cellEle).build().perform();
				
			}catch(Exception e) {
				loopRun=false;
			}
			l++;
		}
				
		System.out.println("ave_totalval  : "+ave_totalval);
		wait(driver, "2");
		mouseOverAndClick(driver, optimizer_EquipmentReport);
		Fluentwait(driver, optimizer_EquipmentReport);
		String Ave_Exe = getAttribute(driver, optimizer_EquipmentReport, "value");
		int AveExe_val = Integer.parseInt(Ave_Exe);
		System.out.println("AveExe_val :" + AveExe_val);

		if (ave_totalval == AveExe_val) {

			Extent_pass(driver, "Expected value was:" + AveExe_val + "Actual value was :" + ave_totalval, test,test1);
		} else {

			Extent_fail(driver, "Expected value was:" + AveExe_val + "Actual value was :" + ave_totalval, test,
					test1);
		}
		
		System.out.println("**********Testcase_5.2**************");
		
		Extent_cal(test, "Testcase 5.3 - Ensure that Average Cost Per Box  displayed properly");
		
		scrollBottom(driver);
		
		String Total_record = getText(driver, Total_records).trim();
		
		WebElement scroller = driver.findElement(By.xpath("(//div[@ref='eBodyHorizontalScrollViewport'])[2]"));
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollLeft = 0;", scroller);
		
		wait(driver,"2");
		
		double costs = 0; // Initialize costs to 0
		
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
		
		mouseOverAndClick(driver, optimizer_EquipmentReport);
		Fluentwait(driver, optimizer_EquipmentReport);
	
		String Total_quantity = getAttribute(driver, optimizer_EquipmentReport, "value");
		
		double qty = Double.valueOf(Total_quantity);
		
		double average_costs = costs / qty;
		
		String formattedValue = String.format("%.2f", average_costs);
		
		String Acutal_avg = getAttribute(driver, Average_cost, "value");
		
		if(Acutal_avg.equals(formattedValue)) {
			
			System.out.println("Average cost was calculated correctly and displayed in the field");
			Extent_pass(driver, "Average cost was calculated correctly and displayed in the field", test, test1);
			Extent_pass(driver, "Expected avg cost per box : "+formattedValue+" Actual avg cost per box : "+Acutal_avg , test, test1);
		}else {			
			System.out.println("Average cost was not calculated correctly");
			Extent_fail(driver, "Average cost was not calculated correctly", test, test1);
			Extent_fail(driver, "Expected avg cost per box : "+formattedValue+" Actual avg cost per box : "+Acutal_avg , test, test1);
		}
		
		
		Extent_cal(test, "Testcase 5.4 -Ensure that Grand total displayed properly");	

		String total_cost = String.valueOf(costs);
		
		String actual_total = getAttribute(driver, Optimizer_Equipment_GrandTotal, "value");
		
		
		if(actual_total.equals(total_cost)) {
			
			System.out.println("Grand total cost was correctly calculated");
			Extent_pass(driver, "Grand total cost was correctly calculated", test, test1);
			Extent_pass(driver,  "Expected Total cost : "+total_cost+" Actual Total cost : "+actual_total, test, test1);
		}else {			
			System.out.println("Grand total cost was not correctly calculated");
			Extent_fail(driver, "Grand total cost was not correctly calculated", test, test1);
			Extent_fail(driver,  "Expected Total cost : "+total_cost+" Actual Total cost : "+actual_total, test, test1);
		}
		
		System.out.println("Testcase 5.3 completed");
		
//		Extent_cal(test, "Testcase 6.1 -Ensure that Unstatisfied report displays record");	
//		
//		wait(driver, "2");
//		
//		Fluentwait(driver, Optimizer_Unsatisfied_Report);
//		click(driver, Optimizer_Unsatisfied_Report);
//		
//		
//		List<String> Unsatisfied=Arrays.asList("locationcode","eqptype","quantity","remarks");
//		List<String> Unsatisfied_header=Arrays.asList("Location Code","Equipment Type","Quantity","Remarks");
//		
//		int val=Unsatisfied.size();
//		for(int i=0;i<val;i++) {
//			 
//			String un_satisdied=Unsatisfied.get(i);
//			String Un_satisfied_header=Unsatisfied_header.get(i);
//			
//			WebElement element=driver.findElement(By.xpath("//div[@id='OPT-OPT_treeTable2_tbl']//div[@col-id='"+un_satisdied+"']"));
//			
//			if(element.isDisplayed()) {
//				
//				System.out.println("After click on  Unsatisfied Surplus Report  "+Un_satisfied_header+ " was displayed in the grid");
//				Extent_pass(driver, "After click on Unsatisfied Surplus Report "+Un_satisfied_header+ " was displayed in the grid", test,test1);
//			}else {
//				System.out.println("After click on Unsatisfied Surplus Report "+Un_satisfied_header+ " was not displayed in the grid");
//				Extent_fail(driver, "After click on Unsatisfied Surplus Report "+Un_satisfied_header+ " was not displayed in the grid", test,test1);
//				global = "After click on Unsatisfied Surplus Report "+Un_satisfied_header+ " was not displayed in the grid";
//			}		
//		}
//		
//		wait(driver, "2");
//		
//		List<String>deficit_unsatisfied=Arrays.asList("locationcode","eqptype","quantity","remarks");
//		List<String>deficit_unsatisfied_Header=Arrays.asList("Location Code","Equipment Type","Quantity","Remarks");
//		 
//		int deficit=deficit_unsatisfied.size();
//		
//		for(int i=0;i<deficit;i++) {
//			String deficitunsatisfied=deficit_unsatisfied.get(i);
//			String deficit_unsatisfiedHeader=deficit_unsatisfied_Header.get(i);
//			try {
//				WebElement ele1=driver.findElement(By.xpath("//fieldset[@id='OPT-OPT_fieldSetDef']//div[@col-id='"+deficitunsatisfied+"']"));
//				
//				if(ele1.isDisplayed()) {
//					
//					System.out.println("After click on  Unsatisfied Deficit Report  "+deficit_unsatisfiedHeader+ " was displayed in the grid");
//					Extent_pass(driver, "After click on Unsatisfied Deficit Report "+deficit_unsatisfiedHeader+ " was displayed in the grid", test,test1);
//				}else {
//					System.out.println("After click on Unsatisfied Deficit Report "+deficit_unsatisfiedHeader+ " was not displayed in the grid");
//					Extent_fail(driver, "After click on Unsatisfied Deficit Report "+deficit_unsatisfiedHeader+ " was not displayed in the grid", test,test1);
//					global = "After click on Unsatisfied Deficit Report "+deficit_unsatisfiedHeader+ " was not displayed in the grid";
//				}	
//			}catch(Exception e) {
//				System.out.println("After click on Unsatisfied Deficit Report "+deficit_unsatisfiedHeader+ " was not displayed in the grid");
//				Extent_fail(driver, "After click on Unsatisfied Deficit Report "+deficit_unsatisfiedHeader+ " was not displayed in the grid", test,test1);
//				global = "After click on Unsatisfied Deficit Report "+deficit_unsatisfiedHeader+ " was not displayed in the grid";
//			
//			}
//				
//	}
//		
//		System.out.println("**********Testcase_6.1**************");	
//		
//		Extent_cal(test, "Testcase 6.2 -Ensure that columns avialable in sections");		
//		
//		wait(driver,"2");
//		
//		if(isDisplayed(driver, Optimizer_LocationCode)) {
//			
//			System.out.println("After click on  Unsatisfied Deficit Report  Location code was displayed in the grid");
//			Extent_pass(driver, "After click on Unsatisfied Deficit Report Location code was displayed in the grid", test,test1);
//		}else {
//			System.out.println("After click on Unsatisfied Deficit Report Location code was not displayed in the grid");
//			Extent_fail(driver, "After click on Unsatisfied Deficit Report Location code was not displayed in the grid", test,test1);
//			global = "After click on Unsatisfied Deficit Report Location code was not displayed in the grid";
//		}	
//		
//		wait(driver,"2");
//        if(isDisplayed(driver, Optimizer_EquipmentType1)) {
//			
//			System.out.println("After click on  Unsatisfied Report  Equipment was displayed in the grid");
//			Extent_pass(driver, "After click on Unsatisfied  Report Equipment was displayed in the grid", test,test1);
//		}else {
//			System.out.println("After click on Unsatisfied  Report  Equipment was not displayed in the grid");
//			Extent_fail(driver, "After click on Unsatisfied  Report Equipment was not displayed in the grid", test,test1);
//			global = "After click on Unsatisfied  Report Equipment was not displayed in the grid";
//		}
//        wait(driver,"2");
//     if(isDisplayed(driver, Optimizer_Quantity1v)) {
//			
//			System.out.println("After click on  Unsatisfied Report  Quantity was displayed in the grid");
//			Extent_pass(driver, "After click on Unsatisfied  Report Quantity was displayed in the grid", test,test1);
//		}else {
//			System.out.println("After click on Unsatisfied  Report  Quantity was not displayed in the grid");
//			Extent_fail(driver, "After click on Unsatisfied  Report Quantity was not displayed in the grid", test,test1);
//			global = "After click on Unsatisfied  Report Quantity was not displayed in the grid";
//		}  	
//        
//     wait(driver,"2");
//     if(isDisplayed(driver, Optimizer_Remarks_va)) {
//			
//			System.out.println("After click on  Unsatisfied Report  Remarks was displayed in the grid");
//			Extent_pass(driver, "After click on Unsatisfied  Report Remarks was displayed in the grid", test,test1);
//		}else {
//			System.out.println("After click on Unsatisfied  Report  Remarks was not displayed in the grid");
//			Extent_fail(driver, "After click on Unsatisfied  Report Remarks was not displayed in the grid", test,test1);
//			global = "After click on Unsatisfied  Report Remarks was not displayed in the grid";
//		}  	 
//        
//     System.out.println("**********Testcase_6.2**************");	
//		  
//        
//     Extent_cal(test, "Testcase 5.3 -Ensure that Average Cost Per Box  displayed properly");	     
//        wait(driver,"3");
//     Fluentwait(driver, Optimizer_Equipment_Report);
//	click(driver, Optimizer_Equipment_Report); 
//        
//        
//	      double Avg=0;
//
//	
//			boolean loopRun=true;
//			int m=0;
//			while(loopRun) {
//				try {
//					WebElement cellEle=driver.findElement(By.xpath("//div[@ref='eCenterContainer']//div[@row-id='"+m+"']/div[@col-id='containercount']"));
//					String CellText = cellEle.getText();
//					if (!CellText.isEmpty() || !CellText.equals("")) {
//						double cellNum = Double.parseDouble(CellText);
//						Avg=Avg+cellNum;
//					}
//					action.moveToElement(cellEle).build().perform();
//					
//				}catch(Exception e) {
//					loopRun=false;
//				}
//				m++;
//			}
//					
//			System.out.println("Avg  : "+Avg);
//        
//			HorizontalScrollTop(driver,Scroll_val);
//			wait(driver,"2");
//			double  total_val=0;
//			boolean loop=true;
//			
//			int n=0;
//			while(loop) {
//				try {
//					WebElement cellEle=driver.findElement(By.xpath("//div[@ref='eCenterContainer']//div[@row-id='"+n+"']/div[@col-id='totcost']"));
//					String CellText = cellEle.getText();
//					if (!CellText.isEmpty() && !CellText.equals("")) {
//						double  cellNum = Double.parseDouble(CellText);
//						total_val=total_val+cellNum;
//					}
//					action.moveToElement(cellEle).build().perform();
//					
//				}catch(Exception e) {
//					loop=false;
//				}
//				n++;
//			}
//			wait(driver, "2");
//			
//			Fluentwait(driver, Optimizer_Equipment_GrandTotal);
//			String Grand_Exe = getAttribute(driver, Optimizer_Equipment_GrandTotal, "value");
//			System.out.println("Grand_Exe :"+Grand_Exe);
//			if(Grand_Exe.contains(",")) {
//				Grand_Exe=Grand_Exe.replace(",", "");
//			}
//			System.out.println("Grand_Exe :" + Grand_Exe);
//			double  Grand_val =Double.parseDouble(Grand_Exe);
//			System.out.println("Grand_val :" + Grand_val);
//			System.out.println("total_val :" + total_val);
//			
//		 double act_val=Avg/Grand_val;
//        System.out.println("act_val :"+act_val);      
//        
//          if (act_val == Grand_val) {
//    		
//    					Extent_pass(driver, "Expected value was:" + Grand_val + "Actual value was :" + act_val, test,test1);
//    				} else {
//    		
//    					Extent_fail(driver, "Expected value was:" + Grand_val + "Actual value was :" + act_val, test,
//    							test1);
//    					global = "Expected value was:" + Grand_val + "Actual value was :" + total_val;
//    				}
//    		    
//          System.out.println("**********Testcase_5.3**************");	
//        
//        
//        
        
        
        
		}
			
	
	
	
		}
		

