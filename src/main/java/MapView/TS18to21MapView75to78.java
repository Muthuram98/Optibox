package MapView;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.Utils;
import net.sourceforge.htmlunit.corejs.javascript.regexp.SubString;

public class TS18to21MapView75to78 extends Keywords{
	public void Scenario18(WebDriver driver, ExtentTest test,ExtentTest test1, String url, int dataset) throws Exception {
		System.out.println("url : " + url);
		String Username = Utils.getDataFromTestData("TS18_Map_View_Dataset"+dataset, "Map view","Username");
		String Password = Utils.getDataFromTestData("TS18_Map_View_Dataset"+dataset, "Map view","Password");
		String ID = Utils.getDataFromTestData("TS18_Map_View_Dataset"+dataset, "Map view", "Id");	
		
		navigateUrl(driver, url);
        Actions act=new Actions(driver);
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
	
		Fluentwait(driver, Searchbox);
		sendKeys(driver, Searchbox, "Map View");
		
		Fluentwait(driver, Select_mapview);
		click(driver, Select_mapview);
		
		Fluentwait(driver, Map_view_Globalserach);
		click(driver, Map_view_Globalserach);
        wait(driver,"2");
        Fluentwait(driver, Globalserach_IDInput);
		sendKeys(driver, Globalserach_IDInput, ID);

		wait(driver, "2");

		Fluentwait(driver, Click_Search);
		click(driver, Click_Search);
		wait(driver,"2");
	    sendKeys(driver, Input_Filed, "B20240829-01-52-00016");
		wait(driver, "5");
		Extent_cal(test, "Testcase-75, Ensure in Map view system is allowing to display the surpluse record locations in map for respective equipments");
		
		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);   
		wait(driver, "2");

		Fluentwait(driver, Map_surplus);
		click(driver, Map_surplus);
		 wait(driver,"2");
		 
		 Fluentwait(driver, surplus_details);
	     click(driver, surplus_details);
	     wait(driver, "2");
	     
		 String Location=getText(driver,Location_val);
		 System.out.println("Location_val :"+Location);
		 wait(driver, "2");
		 
		 int endIndext=Location.indexOf("~");
		 String loc=Location.substring(0, endIndext);
		 System.out.println("Location_val Act :"+loc);
		 wait(driver, "2");
	     String surplus=getText(driver, surplus_count);
	     System.out.println("surplus :"+surplus);
	
	     wait(driver, "2");
	     String import_co=getText(driver,import_count);
		 System.out.println("import_count :"+import_co);
		 
		 wait(driver, "2");
		 String Bench=getText(driver,BenchMarkStock_count);
		 System.out.println("BenchMarkStock_count :"+Bench);
	     
		 wait(driver, "2");
		 String stock=getText(driver,StockStatus_count);
		 System.out.println("StockStatus_count :"+stock);
	     
		 wait(driver, "2");
		 String onewayoutload=getText(driver,OneWayOutLoad_count);
		 System.out.println("OneWayOutLoad_count :"+onewayoutload);
		 
		 wait(driver, "2");
		 String onewayoutreturn=getText(driver,OneWayOutreturn_count);
		 System.out.println("OneWayOutreturn_count :"+onewayoutreturn);
		 
		 wait(driver, "2");
		 String OneWayInLOadcount=getText(driver,OneWayInLOad_count);
		 System.out.println("OneWayOutreturn_count :"+OneWayInLOadcount); 
		 
		 wait(driver, "2");
		 String OneWayInTran=getText(driver,OneWayInTrans);
		 System.out.println("OneWayInTrans :"+OneWayInTran);
		 
		 wait(driver, "2");
		 String OneWayInRetu=getText(driver,OneWayInReturn);
		 System.out.println("OneWayInReturn :"+OneWayInRetu);
		 
		 wait(driver, "2");
		 
		 Fluentwait(driver, Searchbox);
	   sendKeys(driver, Searchbox, "Deficit and Surplus Location Identification"); 
	   
	   Fluentwait(driver, Selectdeficit);
		click(driver, Selectdeficit);
	    	
		Fluentwait(driver, Globalserach);
		click(driver, Globalserach);
		
		Fluentwait(driver, Globalserach_IDInput);
		sendKeys(driver, Globalserach_IDInput, "B20240829-01-52-00016");
		

		wait(driver,"2");
		
		Fluentwait(driver, Click_Search);
		click(driver, Click_Search);
		
		wait(driver,"5");
		
		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);
		
		wait(driver,"2");

		Fluentwait(driver, locationDeficit);
		click(driver, locationDeficit);
		
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		
		Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver, EPO_SelectFilterSearchBox);
		wait(driver,"2");
		Fluentwait(driver, deficit_Location_INput);
		sendKeys(driver, deficit_Location_INput, loc);
		enter(driver);
		wait(driver,"2");
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		
		 String bench_deficit=getText(driver,benchDeficit);
		 System.out.println("bench_deficit :"+bench_deficit);
		 wait(driver,"2");
		 if(bench_deficit.equals(Bench)) {
					System.out.println("Matched || Expected value was : "+Bench+" Actual value was : "+bench_deficit);
					Extent_pass(driver, "Matched || Expected value was : "+Bench+" Actual value was : "+bench_deficit, test,test1);
			
				}else {
					
					System.out.println("Not Matched || Expected value was : "+Bench+" Actual value was : "+bench_deficit);
					Extent_fail(driver, "Not Matched || Expected value was : "+Bench+" Actual value was : "+bench_deficit, test,test1);
				}
		
		    WebElement scroller11= driver.findElement(By.xpath("(//div[@ref='eBodyHorizontalScrollViewport'])[1]"));
			int scrollAmount11= 2000; //
			js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller11, scrollAmount11); 
			wait(driver,"2");
			
			 wait(driver, "2");
			 String stock1=getText(driver,StockDeficit);
			 System.out.println("StockStatus_count :"+stock1);	
			
			
			if(stock1.equals(stock)) {
				System.out.println("Matched || Expected value was : "+stock+" Actual value was : "+stock1);
				Extent_pass(driver, "Matched || Expected value was : "+stock+" Actual value was : "+stock1, test,test1);
		
			}else {
				
				System.out.println("Not Matched || Expected value was : "+stock+" Actual value was : "+stock1);
				Extent_fail(driver, "Not Matched || Expected value was : "+stock+" Actual value was : "+stock1, test,test1);
			}
		 
			
		 
			 wait(driver, "2");
			 String onewayoutload1=getText(driver,onewayoutloadDeficit);
			 System.out.println("OneWayOutLoad_count :"+onewayoutload1);	
			 wait(driver, "2");
			 if(onewayoutload1.equals(onewayoutload)) {
					System.out.println("Matched || Expected value was : "+onewayoutload+" Actual value was : "+onewayoutload1);
					Extent_pass(driver, "Matched || Expected value was : "+onewayoutload+" Actual value was : "+onewayoutload1, test,test1);
			
				}else {
					
					System.out.println("Not Matched || Expected value was : "+onewayoutload+" Actual value was : "+onewayoutload1);
					Extent_fail(driver, "Not Matched || Expected value was : "+onewayoutload+" Actual value was : "+onewayoutload1, test,test1);
				}
			 	
			
			 wait(driver, "2");
			 String onewayoutreturn1=getText(driver,onewayoutreturnDeficit);
			 System.out.println("OneWayOutreturn_count :"+onewayoutreturn1);
			 	 
			 if(onewayoutreturn1.equals(onewayoutreturn)) {
					System.out.println("Matched || Expected value was : "+onewayoutreturn+" Actual value was : "+onewayoutreturn1);
					Extent_pass(driver, "Matched || Expected value was : "+onewayoutreturn+" Actual value was : "+onewayoutreturn1, test,test1);
			
				}else {
					
					System.out.println("Not Matched || Expected value was : "+onewayoutreturn+" Actual value was : "+onewayoutreturn1);
					Extent_fail(driver, "Not Matched || Expected value was : "+onewayoutreturn+" Actual value was : "+onewayoutreturn1, test,test1);
				} 
			 wait(driver, "2");
			 
			 String OneWayInLOadcount1=getText(driver,onewayinLoadDeficit);
			 System.out.println("OneWayOutreturn_count :"+OneWayInLOadcount1);
			 if(OneWayInLOadcount1.equals(OneWayInLOadcount)) {
					System.out.println("Matched || Expected value was : "+OneWayInLOadcount+" Actual value was : "+OneWayInLOadcount1);
					Extent_pass(driver, "Matched || Expected value was : "+OneWayInLOadcount+" Actual value was : "+OneWayInLOadcount1, test,test1);
			
				}else {
					
					System.out.println("Not Matched || Expected value was : "+OneWayInLOadcount+" Actual value was : "+OneWayInLOadcount1);
					Extent_fail(driver, "Not Matched || Expected value was : "+OneWayInLOadcount+" Actual value was : "+OneWayInLOadcount1, test,test1);
				} 
			 
			 wait(driver, "2");
			 String OneWayInTran1=getText(driver,onewayInTransDeficit);
			 System.out.println("OneWayInTrans :"+OneWayInTran1);	
			 
			 if(OneWayInTran1.equals(OneWayInTran)) {
					System.out.println("Matched || Expected value was : "+OneWayInTran+" Actual value was : "+OneWayInTran1);
					Extent_pass(driver, "Matched || Expected value was : "+OneWayInTran+" Actual value was : "+OneWayInTran1, test,test1);
			
				}else {
					
					System.out.println("Not Matched || Expected value was : "+OneWayInTran+" Actual value was : "+OneWayInTran1);
					Extent_fail(driver, "Not Matched || Expected value was : "+OneWayInTran+" Actual value was : "+OneWayInTran1, test,test1);
				}  
			 
			 wait(driver, "2");
			 String OneWayInRetu1=getText(driver,onewayInreturnDeficit);
			 System.out.println("OneWayInReturn :"+OneWayInRetu1);	 
			 
			 if(OneWayInRetu1.equals(OneWayInRetu)) {
					System.out.println("Matched || Expected value was : "+OneWayInRetu+" Actual value was : "+OneWayInRetu1);
					Extent_pass(driver, "Matched || Expected value was : "+OneWayInRetu+" Actual value was : "+OneWayInRetu1, test,test1);
			
				}else {
					
					System.out.println("Not Matched || Expected value was : "+OneWayInRetu+" Actual value was : "+OneWayInRetu1);
					Extent_fail(driver, "Not Matched || Expected value was : "+OneWayInRetu+" Actual value was : "+OneWayInRetu1, test,test1);
				}  
			 
		wait(driver,"2");
		Fluentwait(driver, Close_2Option);
		click(driver, Close_2Option);
		wait(driver,"5");
		
		
		wait(driver,"2");
		
		System.out.println("*************Testcase 75 - Completed **************");
		
		Extent_cal(test, "Testcase-76, Ensure in Map view system is allowing to display the Deficit record locations in map for respective equipments");
		
		Fluentwait(driver, Map_deficit);
		click(driver, Map_deficit);
		wait(driver,"7");
		Fluentwait(driver, Map_20DY);
		click(driver, Map_20DY);
		
		 Fluentwait(driver, deficitDetails);
	     click(driver, deficitDetails);
	     wait(driver, "2");

	     
	     String Location3=getText(driver,Location_val);
		 System.out.println("Location_val :"+Location3);
		 wait(driver, "2");
		 
		 int endIndext3=Location.indexOf("~");
		 String loc3=Location3.substring(0, endIndext3);
		 System.out.println("Location_val Act :"+loc3);
		 wait(driver, "2");
	     String surplus3=getText(driver, deficit_count);
	     System.out.println("deficit :"+surplus3);
	
	     wait(driver, "2");
	     String import_co3=getText(driver,import_count);
		 System.out.println("import_count :"+import_co3);
		 
		 wait(driver, "2");
		 String Bench3=getText(driver,BenchMarkStock_count);
		 System.out.println("BenchMarkStock_count :"+Bench3);
	     
		 wait(driver, "2");
		 String stock3=getText(driver,StockStatus_count);
		 System.out.println("StockStatus_count :"+stock3);
	     
		 wait(driver, "2");
		 String onewayoutload3=getText(driver,OneWayOutLoad_count);
		 System.out.println("OneWayOutLoad_count :"+onewayoutload3);
		 
		 wait(driver, "2");
		 String onewayoutreturn3=getText(driver,OneWayOutreturn_count);
		 System.out.println("OneWayOutreturn_count :"+onewayoutreturn3);
		 
		 wait(driver, "2");
		 String OneWayInLOadcount3=getText(driver,OneWayInLOad_count);
		 System.out.println("OneWayOutreturn_count :"+OneWayInLOadcount3); 
		 
		 wait(driver, "2");
		 String OneWayInTran3=getText(driver,OneWayInTrans);
		 System.out.println("OneWayInTrans :"+OneWayInTran3);
		 
		 wait(driver, "2");
		 String OneWayInRetu3=getText(driver,OneWayInReturn);
		 System.out.println("OneWayInReturn :"+OneWayInRetu3);
		 
		 wait(driver, "2");
		 
		 Fluentwait(driver, Searchbox);
	   sendKeys(driver, Searchbox, "Deficit and Surplus Location Identification"); 
	   
	   Fluentwait(driver, Selectdeficit);
		click(driver, Selectdeficit);
	    	
		Fluentwait(driver, Globalserach);
		click(driver, Globalserach);
		
		Fluentwait(driver, Globalserach_IDInput);
		sendKeys(driver, Globalserach_IDInput, "B20240829-01-52-00016");
		

		wait(driver,"2");
		
		Fluentwait(driver, Click_Search);
		click(driver, Click_Search);
		
		wait(driver,"5");
		
		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);
		
		wait(driver,"2");

		Fluentwait(driver, locationDeficit);
		click(driver, locationDeficit);
		
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		
		Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver, EPO_SelectFilterSearchBox);
		wait(driver,"2");
		Fluentwait(driver, deficit_Location_INput);
		sendKeys(driver, deficit_Location_INput, loc3);
		enter(driver);
		wait(driver,"2");
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		
		 String bench_deficit4=getText(driver,benchDeficit);
		 System.out.println("bench_deficit :"+bench_deficit4);
		 wait(driver,"2");
		 if(bench_deficit4.equals(Bench3)) {
					System.out.println("Matched || Expected value was : "+Bench3+" Actual value was : "+bench_deficit4);
					Extent_pass(driver, "Matched || Expected value was : "+Bench3+" Actual value was : "+bench_deficit4, test,test1);
			
				}else {
					
					System.out.println("Not Matched || Expected value was : "+Bench3+" Actual value was : "+bench_deficit4);
					Extent_fail(driver, "Not Matched || Expected value was : "+Bench3+" Actual value was : "+bench_deficit4, test,test1);
				}
		
		    WebElement scroller1= driver.findElement(By.xpath("(//div[@ref='eBodyHorizontalScrollViewport'])[1]"));
			int scrollAmount1= 2000; //
			js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller1, scrollAmount1); 
			wait(driver,"2");
			
			 wait(driver, "2");
			 String stock4=getText(driver,StockDeficit);
			 System.out.println("StockStatus_count :"+stock1);	
			
			
			if(stock4.equals(stock3)) {
				System.out.println("Matched || Expected value was : "+stock3+" Actual value was : "+stock4);
				Extent_pass(driver, "Matched || Expected value was : "+stock3+" Actual value was : "+stock4, test,test1);
		
			}else {
				
				System.out.println("Not Matched || Expected value was : "+stock3+" Actual value was : "+stock4);
				Extent_fail(driver, "Not Matched || Expected value was : "+stock3+" Actual value was : "+stock4, test,test1);
			}
		 
			
		 
			 wait(driver, "2");
			 String onewayoutload4=getText(driver,onewayoutloadDeficit);
			 System.out.println("OneWayOutLoad_count :"+onewayoutload4);	
			 wait(driver, "2");
			 if(onewayoutload4.equals(onewayoutload3)) {
					System.out.println("Matched || Expected value was : "+onewayoutload3+" Actual value was : "+onewayoutload4);
					Extent_pass(driver, "Matched || Expected value was : "+onewayoutload3+" Actual value was : "+onewayoutload4, test,test1);
			
				}else {
					
					System.out.println("Not Matched || Expected value was : "+onewayoutload3+" Actual value was : "+onewayoutload4);
					Extent_fail(driver, "Not Matched || Expected value was : "+onewayoutload3+" Actual value was : "+onewayoutload4, test,test1);
				}
			 	
			
			 wait(driver, "2");
			 String onewayoutreturn4=getText(driver,onewayoutreturnDeficit);
			 System.out.println("OneWayOutreturn_count :"+onewayoutreturn1);
			 	 
			 if(onewayoutreturn4.equals(onewayoutreturn3)) {
					System.out.println("Matched || Expected value was : "+onewayoutreturn3+" Actual value was : "+onewayoutreturn4);
					Extent_pass(driver, "Matched || Expected value was : "+onewayoutreturn3+" Actual value was : "+onewayoutreturn4, test,test1);
			
				}else {
					
					System.out.println("Not Matched || Expected value was : "+onewayoutreturn3+" Actual value was : "+onewayoutreturn4);
					Extent_fail(driver, "Not Matched || Expected value was : "+onewayoutreturn3+" Actual value was : "+onewayoutreturn4, test,test1);
				} 
			 wait(driver, "2");
			 
			 String OneWayInLOadcount4=getText(driver,onewayinLoadDeficit);
			 System.out.println("OneWayOutreturn_count :"+OneWayInLOadcount4);
			 if(OneWayInLOadcount4.equals(OneWayInLOadcount3)) {
					System.out.println("Matched || Expected value was : "+OneWayInLOadcount3+" Actual value was : "+OneWayInLOadcount4);
					Extent_pass(driver, "Matched || Expected value was : "+OneWayInLOadcount3+" Actual value was : "+OneWayInLOadcount4, test,test1);
			
				}else {
					
					System.out.println("Not Matched || Expected value was : "+OneWayInLOadcount3+" Actual value was : "+OneWayInLOadcount4);
					Extent_fail(driver, "Not Matched || Expected value was : "+OneWayInLOadcount3+" Actual value was : "+OneWayInLOadcount4, test,test1);
				} 
			 
			 wait(driver, "2");
			 String OneWayInTran4=getText(driver,onewayInTransDeficit);
			 System.out.println("OneWayInTrans :"+OneWayInTran4);	
			 
			 if(OneWayInTran4.equals(OneWayInTran3)) {
					System.out.println("Matched || Expected value was : "+OneWayInTran3+" Actual value was : "+OneWayInTran4);
					Extent_pass(driver, "Matched || Expected value was : "+OneWayInTran3+" Actual value was : "+OneWayInTran4, test,test1);
			
				}else {
					
					System.out.println("Not Matched || Expected value was : "+OneWayInTran3+" Actual value was : "+OneWayInTran4);
					Extent_fail(driver, "Not Matched || Expected value was : "+OneWayInTran3+" Actual value was : "+OneWayInTran4, test,test1);
				}  
			 
			 wait(driver, "2");
			 String OneWayInRetu4=getText(driver,onewayInreturnDeficit);
			 System.out.println("OneWayInReturn :"+OneWayInRetu4);	 
			 
			 if(OneWayInRetu4.equals(OneWayInRetu3)) {
					System.out.println("Matched || Expected value was : "+OneWayInRetu3+" Actual value was : "+OneWayInRetu4);
					Extent_pass(driver, "Matched || Expected value was : "+OneWayInRetu3+" Actual value was : "+OneWayInRetu4, test,test1);
			
				}else {
					
					System.out.println("Not Matched || Expected value was : "+OneWayInRetu3+" Actual value was : "+OneWayInRetu4);
					Extent_fail(driver, "Not Matched || Expected value was : "+OneWayInRetu3+" Actual value was : "+OneWayInRetu4, test,test1);
				}  
			 
		wait(driver,"2");
		Fluentwait(driver, Close_2Option);
		click(driver, Close_2Option);
		wait(driver,"5");
	
		
		wait(driver,"2");
		System.out.println("*************Testcase 76 - Completed **************");
		
		Extent_cal(test, "Testcase-77, Ensure in Map view system is allowing to display the Neutral record locations in map for respective equipments");
		
		Fluentwait(driver, Map_neutral);
		click(driver, Map_neutral);
		wait(driver,"7");
		
		 Fluentwait(driver, deficitDetails);
	     click(driver, deficitDetails);
	     wait(driver, "2");
	     Fluentwait(driver, deficitDetails1);
	     click(driver, deficitDetails1);
	     
	     String Location5=getText(driver,Location_val);
		 System.out.println("Location_val :"+Location5);
		 wait(driver, "2");
		 
		 int endIndext5=Location.indexOf("~");
		 String loc5=Location5.substring(0, endIndext5);
		 System.out.println("Location_val Act :"+loc5);
		 wait(driver, "2");
	     String surplus5=getText(driver, deficit_count);
	     System.out.println("neutral :"+surplus5);
	
	     wait(driver, "2");
	     String import_co5=getText(driver,import_count);
		 System.out.println("import_count :"+import_co5);
		 
		 wait(driver, "2");
		 String Bench5=getText(driver,BenchMarkStock_count);
		 System.out.println("BenchMarkStock_count :"+Bench5);
	     
		 wait(driver, "2");
		 String stock5=getText(driver,StockStatus_count);
		 System.out.println("StockStatus_count :"+stock5);
	     
		 wait(driver, "2");
		 String onewayoutload5=getText(driver,OneWayOutLoad_count);
		 System.out.println("OneWayOutLoad_count :"+onewayoutload5);
		 
		 wait(driver, "2");
		 String onewayoutreturn5=getText(driver,OneWayOutreturn_count);
		 System.out.println("OneWayOutreturn_count :"+onewayoutreturn5);
		 
		 wait(driver, "2");
		 String OneWayInLOadcount5=getText(driver,OneWayInLOad_count);
		 System.out.println("OneWayOutreturn_count :"+OneWayInLOadcount5); 
		 
		 wait(driver, "2");
		 String OneWayInTran5=getText(driver,OneWayInTrans);
		 System.out.println("OneWayInTrans :"+OneWayInTran5);
		 
		 wait(driver, "2");
		 String OneWayInRetu5=getText(driver,OneWayInReturn);
		 System.out.println("OneWayInReturn :"+OneWayInRetu5);
		 
		 wait(driver, "2");
		 
		 Fluentwait(driver, Searchbox);
	   sendKeys(driver, Searchbox, "Deficit and Surplus Location Identification"); 
	   
	   Fluentwait(driver, Selectdeficit);
		click(driver, Selectdeficit);
	    	
		Fluentwait(driver, Globalserach);
		click(driver, Globalserach);
		
		Fluentwait(driver, Globalserach_IDInput);
		sendKeys(driver, Globalserach_IDInput, "B20240829-01-52-00016");
		

		wait(driver,"2");
		
		Fluentwait(driver, Click_Search);
		click(driver, Click_Search);
		
		wait(driver,"5");
		
		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);
		
		wait(driver,"2");

		Fluentwait(driver, locationDeficit);
		click(driver, locationDeficit);
		
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		
		Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver, EPO_SelectFilterSearchBox);
		wait(driver,"2");
		Fluentwait(driver, deficit_Location_INput);
		sendKeys(driver, deficit_Location_INput, loc5);
		enter(driver);
		wait(driver,"2");
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		
		 String bench_deficit6=getText(driver,benchDeficit);
		 System.out.println("bench_deficit :"+bench_deficit6);
		 wait(driver,"2");
		 if(bench_deficit6.equals(Bench5)) {
					System.out.println("Matched || Expected value was : "+Bench5+" Actual value was : "+bench_deficit6);
					Extent_pass(driver, "Matched || Expected value was : "+Bench5+" Actual value was : "+bench_deficit6, test,test1);
			
				}else {
					
					System.out.println("Not Matched || Expected value was : "+Bench5+" Actual value was : "+bench_deficit6);
					Extent_fail(driver, "Not Matched || Expected value was : "+Bench5+" Actual value was : "+bench_deficit6, test,test1);
				}
		
		    WebElement scroller2= driver.findElement(By.xpath("(//div[@ref='eBodyHorizontalScrollViewport'])[1]"));
			int scrollAmount2= 2000; //
			js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller2, scrollAmount2); 
			wait(driver,"2");
			
			 wait(driver, "2");
			 String stock6=getText(driver,StockDeficit);
			 System.out.println("StockStatus_count :"+stock6);	
			
			
			if(stock6.equals(stock5)) {
				System.out.println("Matched || Expected value was : "+stock5+" Actual value was : "+stock6);
				Extent_pass(driver, "Matched || Expected value was : "+stock5+" Actual value was : "+stock6, test,test1);
		
			}else {
				
				System.out.println("Not Matched || Expected value was : "+stock5+" Actual value was : "+stock6);
				Extent_fail(driver, "Not Matched || Expected value was : "+stock5+" Actual value was : "+stock6, test,test1);
			}
		  
			 wait(driver, "2");
			 String onewayoutload6=getText(driver,onewayoutloadDeficit);
			 System.out.println("OneWayOutLoad_count :"+onewayoutload6);	
			 wait(driver, "2");
			 if(onewayoutload6.equals(onewayoutload5)) {
					System.out.println("Matched || Expected value was : "+onewayoutload5+" Actual value was : "+onewayoutload6);
					Extent_pass(driver, "Matched || Expected value was : "+onewayoutload5+" Actual value was : "+onewayoutload6, test,test1);
			
				}else {
					
					System.out.println("Not Matched || Expected value was : "+onewayoutload5+" Actual value was : "+onewayoutload6);
					Extent_fail(driver, "Not Matched || Expected value was : "+onewayoutload5+" Actual value was : "+onewayoutload6, test,test1);
				}
			 	
			
			 wait(driver, "2");
			 String onewayoutreturn6=getText(driver,onewayoutreturnDeficit);
			 System.out.println("OneWayOutreturn_count :"+onewayoutreturn6);
			 	 
			 if(onewayoutreturn6.equals(onewayoutreturn5)) {
					System.out.println("Matched || Expected value was : "+onewayoutreturn5+" Actual value was : "+onewayoutreturn6);
					Extent_pass(driver, "Matched || Expected value was : "+onewayoutreturn5+" Actual value was : "+onewayoutreturn6, test,test1);
			
				}else {
					
					System.out.println("Not Matched || Expected value was : "+onewayoutreturn5+" Actual value was : "+onewayoutreturn6);
					Extent_fail(driver, "Not Matched || Expected value was : "+onewayoutreturn5+" Actual value was : "+onewayoutreturn6, test,test1);
				} 
			 wait(driver, "2");
			 
			 String OneWayInLOadcount6=getText(driver,onewayinLoadDeficit);
			 System.out.println("OneWayOutreturn_count :"+OneWayInLOadcount6);
			 if(OneWayInLOadcount6.equals(OneWayInLOadcount5)) {
					System.out.println("Matched || Expected value was : "+OneWayInLOadcount5+" Actual value was : "+OneWayInLOadcount6);
					Extent_pass(driver, "Matched || Expected value was : "+OneWayInLOadcount5+" Actual value was : "+OneWayInLOadcount6, test,test1);
			
				}else {
					
					System.out.println("Not Matched || Expected value was : "+OneWayInLOadcount5+" Actual value was : "+OneWayInLOadcount6);
					Extent_fail(driver, "Not Matched || Expected value was : "+OneWayInLOadcount5+" Actual value was : "+OneWayInLOadcount6, test,test1);
				} 
			 
			 wait(driver, "2");
			 String OneWayInTran6=getText(driver,onewayInTransDeficit);
			 System.out.println("OneWayInTrans :"+OneWayInTran6);	
			 
			 if(OneWayInTran6.equals(OneWayInTran5)) {
					System.out.println("Matched || Expected value was : "+OneWayInTran5+" Actual value was : "+OneWayInTran6);
					Extent_pass(driver, "Matched || Expected value was : "+OneWayInTran5+" Actual value was : "+OneWayInTran6, test,test1);
			
				}else {
					
					System.out.println("Not Matched || Expected value was : "+OneWayInTran5+" Actual value was : "+OneWayInTran6);
					Extent_fail(driver, "Not Matched || Expected value was : "+OneWayInTran5+" Actual value was : "+OneWayInTran6, test,test1);
				}  
			 
			 wait(driver, "2");
			 String OneWayInRetu6=getText(driver,onewayInreturnDeficit);
			 System.out.println("OneWayInReturn :"+OneWayInRetu6);	 
			 
			 if(OneWayInRetu6.equals(OneWayInRetu6)) {
					System.out.println("Matched || Expected value was : "+OneWayInRetu5+" Actual value was : "+OneWayInRetu6);
					Extent_pass(driver, "Matched || Expected value was : "+OneWayInRetu5+" Actual value was : "+OneWayInRetu6, test,test1);
			
				}else {
					
					System.out.println("Not Matched || Expected value was : "+OneWayInRetu5+" Actual value was : "+OneWayInRetu6);
					Extent_fail(driver, "Not Matched || Expected value was : "+OneWayInRetu5+" Actual value was : "+OneWayInRetu6, test,test1);
				}  
			 
		wait(driver,"2");
		Fluentwait(driver, Close_2Option);
		click(driver, Close_2Option);
		wait(driver,"5");

		System.out.println("*************Testcase 77 - Completed **************");
		
		Extent_cal(test, "Testcase-78, Ensure in Map view system is allowing to display for All (surpluse, Deficit, Neutral) record locations in map for respective equipments");	
		wait(driver,"7");
		
		Fluentwait(driver, Map_All);
		click(driver, Map_All);
		
		Fluentwait(driver, Map_blue);
		click(driver,Map_blue);
		
		 String Location7=getText(driver,Location_val);
		 System.out.println("Location_val :"+Location7);
		 wait(driver, "2");
		 
		 int endIndext7=Location7.indexOf("~");
		 String loc7=Location7.substring(0, endIndext);
		 System.out.println("Location_val Act :"+loc7);
		 wait(driver, "2");
	     String surplus7=getText(driver, surplus_count);
	     System.out.println("surplus :"+surplus7);
	
	     wait(driver, "2");
	     String import_co7=getText(driver,import_count);
		 System.out.println("import_count :"+import_co7);
		 
		 wait(driver, "2");
		 String Bench7=getText(driver,BenchMarkStock_count);
		 System.out.println("BenchMarkStock_count :"+Bench7);
	     
		 wait(driver, "2");
		 String stock7=getText(driver,StockStatus_count);
		 System.out.println("StockStatus_count :"+stock7);
	     
		 wait(driver, "2");
		 String onewayoutload7=getText(driver,OneWayOutLoad_count);
		 System.out.println("OneWayOutLoad_count :"+onewayoutload7);
		 
		 wait(driver, "2");
		 String onewayoutreturn7=getText(driver,OneWayOutreturn_count);
		 System.out.println("OneWayOutreturn_count :"+onewayoutreturn7);
		 
		 wait(driver, "2");
		 String OneWayInLOadcount7=getText(driver,OneWayInLOad_count);
		 System.out.println("OneWayOutreturn_count :"+OneWayInLOadcount7); 
		 
		 wait(driver, "2");
		 String OneWayInTran7=getText(driver,OneWayInTrans);
		 System.out.println("OneWayInTrans :"+OneWayInTran7);
		 
		 wait(driver, "2");
		 String OneWayInRetu7=getText(driver,OneWayInReturn);
		 System.out.println("OneWayInReturn :"+OneWayInRetu7);
		 
		 wait(driver, "2");
		 
		 Fluentwait(driver, Searchbox);
	   sendKeys(driver, Searchbox, "Deficit and Surplus Location Identification"); 
	   
	   Fluentwait(driver, Selectdeficit);
		click(driver, Selectdeficit);
	    	
		Fluentwait(driver, Globalserach);
		click(driver, Globalserach);
		
		Fluentwait(driver, Globalserach_IDInput);
		sendKeys(driver, Globalserach_IDInput, "B20240829-01-52-00016");
		

		wait(driver,"2");
		
		Fluentwait(driver, Click_Search);
		click(driver, Click_Search);
		
		wait(driver,"5");
		
		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);
		
		wait(driver,"2");

		Fluentwait(driver, locationDeficit);
		click(driver, locationDeficit);
		
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		
		Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver, EPO_SelectFilterSearchBox);
		wait(driver,"2");
		Fluentwait(driver, deficit_Location_INput);
		sendKeys(driver, deficit_Location_INput, loc7);
		enter(driver);
		wait(driver,"2");
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		
		 String bench_deficit8=getText(driver,benchDeficit);
		 System.out.println("bench_deficit :"+bench_deficit8);
		 wait(driver,"2");
		 if(bench_deficit8.equals(Bench7)) {
					System.out.println("Matched || Expected value was : "+Bench7+" Actual value was : "+bench_deficit8);
					Extent_pass(driver, "Matched || Expected value was : "+Bench7+" Actual value was : "+bench_deficit8, test,test1);
			
				}else {
					
					System.out.println("Not Matched || Expected value was : "+Bench7+" Actual value was : "+bench_deficit8);
					Extent_fail(driver, "Not Matched || Expected value was : "+Bench7+" Actual value was : "+bench_deficit8, test,test1);
				}
		
		    WebElement scroller3= driver.findElement(By.xpath("(//div[@ref='eBodyHorizontalScrollViewport'])[1]"));
			int scrollAmount3= 2000; //
			js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller3, scrollAmount3); 
			wait(driver,"2");
			
			 wait(driver, "2");
			 String stock8=getText(driver,StockDeficit);
			 System.out.println("StockStatus_count :"+stock8);	
			
			
			if(stock8.equals(stock7)) {
				System.out.println("Matched || Expected value was : "+stock7+" Actual value was : "+stock8);
				Extent_pass(driver, "Matched || Expected value was : "+stock7+" Actual value was : "+stock8, test,test1);
		
			}else {
				
				System.out.println("Not Matched || Expected value was : "+stock7+" Actual value was : "+stock8);
				Extent_fail(driver, "Not Matched || Expected value was : "+stock7+" Actual value was : "+stock8, test,test1);
			}
		 
			
		 
			 wait(driver, "2");
			 String onewayoutload8=getText(driver,onewayoutloadDeficit);
			 System.out.println("OneWayOutLoad_count :"+onewayoutload8);	
			 wait(driver, "2");
			 if(onewayoutload8.equals(onewayoutload7)) {
					System.out.println("Matched || Expected value was : "+onewayoutload7+" Actual value was : "+onewayoutload8);
					Extent_pass(driver, "Matched || Expected value was : "+onewayoutload7+" Actual value was : "+onewayoutload8, test,test1);
			
				}else {
					
					System.out.println("Not Matched || Expected value was : "+onewayoutload7+" Actual value was : "+onewayoutload8);
					Extent_fail(driver, "Not Matched || Expected value was : "+onewayoutload7+" Actual value was : "+onewayoutload8, test,test1);
				}
			 	
			
			 wait(driver, "2");
			 String onewayoutreturn8=getText(driver,onewayoutreturnDeficit);
			 System.out.println("OneWayOutreturn_count :"+onewayoutreturn8);
			 	 
			 if(onewayoutreturn8.equals(onewayoutreturn7)) {
					System.out.println("Matched || Expected value was : "+onewayoutreturn7+" Actual value was : "+onewayoutreturn8);
					Extent_pass(driver, "Matched || Expected value was : "+onewayoutreturn7+" Actual value was : "+onewayoutreturn8, test,test1);
			
				}else {
					
					System.out.println("Not Matched || Expected value was : "+onewayoutreturn7+" Actual value was : "+onewayoutreturn8);
					Extent_fail(driver, "Not Matched || Expected value was : "+onewayoutreturn7+" Actual value was : "+onewayoutreturn8, test,test1);
				} 
			 wait(driver, "2");
			 
			 String OneWayInLOadcount8=getText(driver,onewayinLoadDeficit);
			 System.out.println("OneWayOutreturn_count :"+OneWayInLOadcount8);
			 if(OneWayInLOadcount8.equals(OneWayInLOadcount7)) {
					System.out.println("Matched || Expected value was : "+OneWayInLOadcount7+" Actual value was : "+OneWayInLOadcount8);
					Extent_pass(driver, "Matched || Expected value was : "+OneWayInLOadcount7+" Actual value was : "+OneWayInLOadcount8, test,test1);
			
				}else {
					
					System.out.println("Not Matched || Expected value was : "+OneWayInLOadcount7+" Actual value was : "+OneWayInLOadcount8);
					Extent_fail(driver, "Not Matched || Expected value was : "+OneWayInLOadcount7+" Actual value was : "+OneWayInLOadcount8, test,test1);
				} 
			 
			 wait(driver, "2");
			 String OneWayInTran8=getText(driver,onewayInTransDeficit);
			 System.out.println("OneWayInTrans :"+OneWayInTran8);	
			 
			 if(OneWayInTran8.equals(OneWayInTran7)) {
					System.out.println("Matched || Expected value was : "+OneWayInTran7+" Actual value was : "+OneWayInTran8);
					Extent_pass(driver, "Matched || Expected value was : "+OneWayInTran7+" Actual value was : "+OneWayInTran8, test,test1);
			
				}else {
					
					System.out.println("Not Matched || Expected value was : "+OneWayInTran7+" Actual value was : "+OneWayInTran8);
					Extent_fail(driver, "Not Matched || Expected value was : "+OneWayInTran7+" Actual value was : "+OneWayInTran8, test,test1);
				}  
			 
			 wait(driver, "2");
			 String OneWayInRetu8=getText(driver,onewayInreturnDeficit);
			 System.out.println("OneWayInReturn :"+OneWayInRetu8);	 
			 
			 if(OneWayInRetu8.equals(OneWayInRetu7)) {
					System.out.println("Matched || Expected value was : "+OneWayInRetu7+" Actual value was : "+OneWayInRetu8);
					Extent_pass(driver, "Matched || Expected value was : "+OneWayInRetu7+" Actual value was : "+OneWayInRetu8, test,test1);
			
				}else {
					
					System.out.println("Not Matched || Expected value was : "+OneWayInRetu7+" Actual value was : "+OneWayInRetu8);
					Extent_fail(driver, "Not Matched || Expected value was : "+OneWayInRetu7+" Actual value was : "+OneWayInRetu8, test,test1);
				}  
			 
		wait(driver,"2");
		Fluentwait(driver, Close_2Option);
		click(driver, Close_2Option);
		wait(driver,"5");
		
		Fluentwait(driver, Map_surplus);
		click(driver, Map_surplus);
		wait(driver,"2");
		Fluentwait(driver, Map_20hc);
		click(driver, Map_20hc);
		
		Fluentwait(driver, surplus_20Hc);
		click(driver, surplus_20Hc);
		
		String Location9=getText(driver,Location_val);
		 System.out.println("Location_val :"+Location9);
		 wait(driver, "2");
		 
		 int endIndext9=Location9.indexOf("~");
		 String loc9=Location9.substring(0, endIndext);
		 System.out.println("Location_val Act :"+loc9);
		 wait(driver, "2");
	     String surplus9=getText(driver, surplus_count);
	     System.out.println("surplus :"+surplus9);
	
	     wait(driver, "2");
	     String import_co9=getText(driver,import_count);
		 System.out.println("import_count :"+import_co9);
		 
		 wait(driver, "2");
		 String Bench9=getText(driver,BenchMarkStock_count);
		 System.out.println("BenchMarkStock_count :"+Bench9);
	     
		 wait(driver, "2");
		 String stock9=getText(driver,StockStatus_count);
		 System.out.println("StockStatus_count :"+stock9);
	     
		 wait(driver, "2");
		 String onewayoutload9=getText(driver,OneWayOutLoad_count);
		 System.out.println("OneWayOutLoad_count :"+onewayoutload9);
		 
		 wait(driver, "2");
		 String onewayoutreturn9=getText(driver,OneWayOutreturn_count);
		 System.out.println("OneWayOutreturn_count :"+onewayoutreturn9);
		 
		 wait(driver, "2");
		 String OneWayInLOadcount9=getText(driver,OneWayInLOad_count);
		 System.out.println("OneWayOutreturn_count :"+OneWayInLOadcount9); 
		 
		 wait(driver, "2");
		 String OneWayInTran9=getText(driver,OneWayInTrans);
		 System.out.println("OneWayInTrans :"+OneWayInTran9);
		 
		 wait(driver, "2");
		 String OneWayInRetu9=getText(driver,OneWayInReturn);
		 System.out.println("OneWayInReturn :"+OneWayInRetu9);
		 
		 wait(driver, "2");
		 
		 Fluentwait(driver, Searchbox);
	   sendKeys(driver, Searchbox, "Deficit and Surplus Location Identification"); 
	   
	   Fluentwait(driver, Selectdeficit);
		click(driver, Selectdeficit);
	    	
		Fluentwait(driver, Globalserach);
		click(driver, Globalserach);
		
		Fluentwait(driver, Globalserach_IDInput);
		sendKeys(driver, Globalserach_IDInput, "B20240829-01-52-00016");
		

		wait(driver,"2");
		
		Fluentwait(driver, Click_Search);
		click(driver, Click_Search);
		
		wait(driver,"5");
		
		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);
		
		wait(driver,"2");

		Fluentwait(driver, locationDeficit);
		click(driver, locationDeficit);
		
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		
		Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver, EPO_SelectFilterSearchBox);
		wait(driver,"2");
		Fluentwait(driver, deficit_Location_INput);
		sendKeys(driver, deficit_Location_INput, loc9);
		enter(driver);
		wait(driver,"2");
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		
		 String bench_deficit10=getText(driver,benchDeficit);
		 System.out.println("bench_deficit :"+bench_deficit10);
		 wait(driver,"2");
		 if(bench_deficit10.equals(Bench9)) {
					System.out.println("Matched || Expected value was : "+Bench9+" Actual value was : "+bench_deficit10);
					Extent_pass(driver, "Matched || Expected value was : "+Bench9+" Actual value was : "+bench_deficit10, test,test1);
			
				}else {
					
					System.out.println("Not Matched || Expected value was : "+Bench9+" Actual value was : "+bench_deficit10);
					Extent_fail(driver, "Not Matched || Expected value was : "+Bench9+" Actual value was : "+bench_deficit10, test,test1);
				}
		
		    WebElement scroller4= driver.findElement(By.xpath("(//div[@ref='eBodyHorizontalScrollViewport'])[1]"));
			int scrollAmount4= 2000; //
			js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller4, scrollAmount4); 
			wait(driver,"2");
			
			 wait(driver, "2");
			 String stock10=getText(driver,StockDeficit);
			 System.out.println("StockStatus_count :"+stock10);	
			
			
			if(stock10.equals(stock9)) {
				System.out.println("Matched || Expected value was : "+stock9+" Actual value was : "+stock10);
				Extent_pass(driver, "Matched || Expected value was : "+stock9+" Actual value was : "+stock10, test,test1);
		
			}else {
				
				System.out.println("Not Matched || Expected value was : "+stock9+" Actual value was : "+stock10);
				Extent_fail(driver, "Not Matched || Expected value was : "+stock9+" Actual value was : "+stock10, test,test1);
			}
		 
			
		 
			 wait(driver, "2");
			 String onewayoutload10=getText(driver,onewayoutloadDeficit);
			 System.out.println("OneWayOutLoad_count :"+onewayoutload10);	
			 wait(driver, "2");
			 if(onewayoutload10.equals(onewayoutload9)) {
					System.out.println("Matched || Expected value was : "+onewayoutload9+" Actual value was : "+onewayoutload10);
					Extent_pass(driver, "Matched || Expected value was : "+onewayoutload9+" Actual value was : "+onewayoutload10, test,test1);
			
				}else {
					
					System.out.println("Not Matched || Expected value was : "+onewayoutload9+" Actual value was : "+onewayoutload10);
					Extent_fail(driver, "Not Matched || Expected value was : "+onewayoutload9+" Actual value was : "+onewayoutload10, test,test1);
				}
			 	
			
			 wait(driver, "2");
			 String onewayoutreturn10=getText(driver,onewayoutreturnDeficit);
			 System.out.println("OneWayOutreturn_count :"+onewayoutreturn10);
			 	 
			 if(onewayoutreturn10.equals(onewayoutreturn9)) {
					System.out.println("Matched || Expected value was : "+onewayoutreturn9+" Actual value was : "+onewayoutreturn10);
					Extent_pass(driver, "Matched || Expected value was : "+onewayoutreturn9+" Actual value was : "+onewayoutreturn10, test,test1);
			
				}else {
					
					System.out.println("Not Matched || Expected value was : "+onewayoutreturn9+" Actual value was : "+onewayoutreturn10);
					Extent_fail(driver, "Not Matched || Expected value was : "+onewayoutreturn9+" Actual value was : "+onewayoutreturn10, test,test1);
				} 
			 wait(driver, "2");
			 
			 String OneWayInLOadcount10=getText(driver,onewayinLoadDeficit);
			 System.out.println("OneWayOutreturn_count :"+OneWayInLOadcount10);
			 if(OneWayInLOadcount10.equals(OneWayInLOadcount9)) {
					System.out.println("Matched || Expected value was : "+OneWayInLOadcount9+" Actual value was : "+OneWayInLOadcount10);
					Extent_pass(driver, "Matched || Expected value was : "+OneWayInLOadcount9+" Actual value was : "+OneWayInLOadcount10, test,test1);
			
				}else {
					
					System.out.println("Not Matched || Expected value was : "+OneWayInLOadcount9+" Actual value was : "+OneWayInLOadcount10);
					Extent_fail(driver, "Not Matched || Expected value was : "+OneWayInLOadcount9+" Actual value was : "+OneWayInLOadcount10, test,test1);
				} 
			 
			 wait(driver, "2");
			 String OneWayInTran10=getText(driver,onewayInTransDeficit);
			 System.out.println("OneWayInTrans :"+OneWayInTran10);	
			 
			 if(OneWayInTran10.equals(OneWayInTran7)) {
					System.out.println("Matched || Expected value was : "+OneWayInTran9+" Actual value was : "+OneWayInTran10);
					Extent_pass(driver, "Matched || Expected value was : "+OneWayInTran9+" Actual value was : "+OneWayInTran10, test,test1);
			
				}else {
					
					System.out.println("Not Matched || Expected value was : "+OneWayInTran9+" Actual value was : "+OneWayInTran10);
					Extent_fail(driver, "Not Matched || Expected value was : "+OneWayInTran9+" Actual value was : "+OneWayInTran10, test,test1);
				}  
			 
			 wait(driver, "2");
			 String OneWayInRetu10=getText(driver,onewayInreturnDeficit);
			 System.out.println("OneWayInReturn :"+OneWayInRetu10);	 
			 
			 if(OneWayInRetu10.equals(OneWayInRetu9)) {
					System.out.println("Matched || Expected value was : "+OneWayInRetu9+" Actual value was : "+OneWayInRetu10);
					Extent_pass(driver, "Matched || Expected value was : "+OneWayInRetu9+" Actual value was : "+OneWayInRetu10, test,test1);
			
				}else {
					
					System.out.println("Not Matched || Expected value was : "+OneWayInRetu9+" Actual value was : "+OneWayInRetu10);
					Extent_fail(driver, "Not Matched || Expected value was : "+OneWayInRetu9+" Actual value was : "+OneWayInRetu10, test,test1);
				}  
			 
		wait(driver,"2");
		Fluentwait(driver, Close_2Option);
		click(driver, Close_2Option);
		wait(driver,"5");
		
		Fluentwait(driver, Map_deficit);
		click(driver, Map_deficit);
		wait(driver,"7");
		Fluentwait(driver, Map_20hc);
		click(driver, Map_20hc);
		
		 Fluentwait(driver, deficitDetails);
	     click(driver, deficitDetails);
	     wait(driver, "2");

	     
	     String Location11=getText(driver,Location_val);
		 System.out.println("Location_val :"+Location11);
		 wait(driver, "2");
		 
		 int endIndext11=Location11.indexOf("~");
		 String loc11=Location3.substring(0, endIndext11);
		 System.out.println("Location_val Act :"+loc11);
		 wait(driver, "2");
	     String surplus11=getText(driver, deficit_count);
	     System.out.println("deficit :"+surplus11);
	
	     wait(driver, "2");
	     String import_co11=getText(driver,import_count);
		 System.out.println("import_count :"+import_co11);
		 
		 wait(driver, "2");
		 String Bench11=getText(driver,BenchMarkStock_count);
		 System.out.println("BenchMarkStock_count :"+Bench11);
	     
		 wait(driver, "2");
		 String stock11=getText(driver,StockStatus_count);
		 System.out.println("StockStatus_count :"+stock11);
	     
		 wait(driver, "2");
		 String onewayoutload11=getText(driver,OneWayOutLoad_count);
		 System.out.println("OneWayOutLoad_count :"+onewayoutload11);
		 
		 wait(driver, "2");
		 String onewayoutreturn11=getText(driver,OneWayOutreturn_count);
		 System.out.println("OneWayOutreturn_count :"+onewayoutreturn11);
		 
		 wait(driver, "2");
		 String OneWayInLOadcount11=getText(driver,OneWayInLOad_count);
		 System.out.println("OneWayOutreturn_count :"+OneWayInLOadcount11); 
		 
		 wait(driver, "2");
		 String OneWayInTran11=getText(driver,OneWayInTrans);
		 System.out.println("OneWayInTrans :"+OneWayInTran11);
		 
		 wait(driver, "2");
		 String OneWayInRetu11=getText(driver,OneWayInReturn);
		 System.out.println("OneWayInReturn :"+OneWayInRetu11);
		 
		 wait(driver, "2");
		 
		 Fluentwait(driver, Searchbox);
	   sendKeys(driver, Searchbox, "Deficit and Surplus Location Identification"); 
	   
	   Fluentwait(driver, Selectdeficit);
		click(driver, Selectdeficit);
	    	
		Fluentwait(driver, Globalserach);
		click(driver, Globalserach);
		
		Fluentwait(driver, Globalserach_IDInput);
		sendKeys(driver, Globalserach_IDInput, "B20240829-01-52-00016");
		

		wait(driver,"2");
		
		Fluentwait(driver, Click_Search);
		click(driver, Click_Search);
		
		wait(driver,"5");
		
		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);
		
		wait(driver,"2");

		Fluentwait(driver, locationDeficit);
		click(driver, locationDeficit);
		
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		
		Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver, EPO_SelectFilterSearchBox);
		wait(driver,"2");
		Fluentwait(driver, deficit_Location_INput);
		sendKeys(driver, deficit_Location_INput, loc11);
		enter(driver);
		wait(driver,"2");
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		
		 String bench_deficit12=getText(driver,benchDeficit);
		 System.out.println("bench_deficit :"+bench_deficit12);
		 wait(driver,"2");
		 if(bench_deficit12.equals(Bench11)) {
					System.out.println("Matched || Expected value was : "+Bench11+" Actual value was : "+bench_deficit12);
					Extent_pass(driver, "Matched || Expected value was : "+Bench11+" Actual value was : "+bench_deficit12, test,test1);
			
				}else {
					
					System.out.println("Not Matched || Expected value was : "+Bench11+" Actual value was : "+bench_deficit12);
					Extent_fail(driver, "Not Matched || Expected value was : "+Bench11+" Actual value was : "+bench_deficit12, test,test1);
				}
		
		    WebElement scroller5= driver.findElement(By.xpath("(//div[@ref='eBodyHorizontalScrollViewport'])[1]"));
			int scrollAmount5= 2000; //
			js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller5, scrollAmount5); 
			wait(driver,"2");
			
			 wait(driver, "2");
			 String stock12=getText(driver,StockDeficit);
			 System.out.println("StockStatus_count :"+stock12);	
			
			
			if(stock12.equals(stock11)) {
				System.out.println("Matched || Expected value was : "+stock11+" Actual value was : "+stock12);
				Extent_pass(driver, "Matched || Expected value was : "+stock11+" Actual value was : "+stock12, test,test1);
		
			}else {
				
				System.out.println("Not Matched || Expected value was : "+stock11+" Actual value was : "+stock12);
				Extent_fail(driver, "Not Matched || Expected value was : "+stock11+" Actual value was : "+stock12, test,test1);
			}
		 
			
		 
			 wait(driver, "2");
			 String onewayoutload12=getText(driver,onewayoutloadDeficit);
			 System.out.println("OneWayOutLoad_count :"+onewayoutload12);	
			 wait(driver, "2");
			 if(onewayoutload12.equals(onewayoutload11)) {
					System.out.println("Matched || Expected value was : "+onewayoutload11+" Actual value was : "+onewayoutload12);
					Extent_pass(driver, "Matched || Expected value was : "+onewayoutload11+" Actual value was : "+onewayoutload12, test,test1);
			
				}else {
					
					System.out.println("Not Matched || Expected value was : "+onewayoutload11+" Actual value was : "+onewayoutload12);
					Extent_fail(driver, "Not Matched || Expected value was : "+onewayoutload11+" Actual value was : "+onewayoutload12, test,test1);
				}
			 	
			
			 wait(driver, "2");
			 String onewayoutreturn12=getText(driver,onewayoutreturnDeficit);
			 System.out.println("OneWayOutreturn_count :"+onewayoutreturn12);
			 	 
			 if(onewayoutreturn12.equals(onewayoutreturn11)) {
					System.out.println("Matched || Expected value was : "+onewayoutreturn11+" Actual value was : "+onewayoutreturn12);
					Extent_pass(driver, "Matched || Expected value was : "+onewayoutreturn11+" Actual value was : "+onewayoutreturn12, test,test1);
			
				}else {
					
					System.out.println("Not Matched || Expected value was : "+onewayoutreturn11+" Actual value was : "+onewayoutreturn12);
					Extent_fail(driver, "Not Matched || Expected value was : "+onewayoutreturn11+" Actual value was : "+onewayoutreturn12, test,test1);
				} 
			 wait(driver, "2");
			 
			 String OneWayInLOadcount12=getText(driver,onewayinLoadDeficit);
			 System.out.println("OneWayOutreturn_count :"+OneWayInLOadcount12);
			 if(OneWayInLOadcount12.equals(OneWayInLOadcount11)) {
					System.out.println("Matched || Expected value was : "+OneWayInLOadcount11+" Actual value was : "+OneWayInLOadcount12);
					Extent_pass(driver, "Matched || Expected value was : "+OneWayInLOadcount11+" Actual value was : "+OneWayInLOadcount12, test,test1);
			
				}else {
					
					System.out.println("Not Matched || Expected value was : "+OneWayInLOadcount11+" Actual value was : "+OneWayInLOadcount12);
					Extent_fail(driver, "Not Matched || Expected value was : "+OneWayInLOadcount11+" Actual value was : "+OneWayInLOadcount12, test,test1);
				} 
			 
			 wait(driver, "2");
			 String OneWayInTran12=getText(driver,onewayInTransDeficit);
			 System.out.println("OneWayInTrans :"+OneWayInTran12);	
			 
			 if(OneWayInTran12.equals(OneWayInTran11)) {
					System.out.println("Matched || Expected value was : "+OneWayInTran11+" Actual value was : "+OneWayInTran12);
					Extent_pass(driver, "Matched || Expected value was : "+OneWayInTran11+" Actual value was : "+OneWayInTran12, test,test1);
			
				}else {
					
					System.out.println("Not Matched || Expected value was : "+OneWayInTran11+" Actual value was : "+OneWayInTran12);
					Extent_fail(driver, "Not Matched || Expected value was : "+OneWayInTran11+" Actual value was : "+OneWayInTran12, test,test1);
				}  
			 
			 wait(driver, "2");
			 String OneWayInRetu12=getText(driver,onewayInreturnDeficit);
			 System.out.println("OneWayInReturn :"+OneWayInRetu12);	 
			 
			 if(OneWayInRetu12.equals(OneWayInRetu11)) {
					System.out.println("Matched || Expected value was : "+OneWayInRetu11+" Actual value was : "+OneWayInRetu12);
					Extent_pass(driver, "Matched || Expected value was : "+OneWayInRetu11+" Actual value was : "+OneWayInRetu12, test,test1);
			
				}else {
					
					System.out.println("Not Matched || Expected value was : "+OneWayInRetu11+" Actual value was : "+OneWayInRetu12);
					Extent_fail(driver, "Not Matched || Expected value was : "+OneWayInRetu11+" Actual value was : "+OneWayInRetu12, test,test1);
				}  
			 
		wait(driver,"2");
		Fluentwait(driver, Close_2Option);
		click(driver, Close_2Option);
		wait(driver,"5");
	
		
		
		wait(driver,"2");
		System.out.println("*************Testcase 78 - Completed **************");	
		
		
		
		
}
}