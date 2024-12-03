package ERO_Routing_Scripts;

import java.awt.Robot;
import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.Utils;

public class ERO_Routing_Scenario24_TC181toTC185 extends Keywords {
	@SuppressWarnings("deprecation")
	public void ERO_Scenario24(WebDriver driver, ExtentTest test, ExtentTest test1,String url, int dataset) throws Exception{
		
		String Username = Utils.getDataFromTestData("ERO_Scenario24_Dataset"+dataset, "ERO Routing", "Username");
		String Password = Utils.getDataFromTestData("ERO_Scenario24_Dataset"+dataset, "ERO Routing", "Password");
		String ID = Utils.getDataFromTestData("ERO_Scenario24_Dataset"+dataset, "ERO Routing", "Id");
		String Total_Defi= Utils.getDataFromTestData("ERO_Scenario24_Dataset"+dataset, "ERO Routing", "Deficit_Val");
		
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
		wait(driver,"4");
		
//		uploadFileRobot(driver,EquimentType_Alphabets);
		
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
		
		wait(driver,"2");
		Fluentwait(driver, ERO_Save);
		click(driver, ERO_Save);
		Fluentwait(driver, ERO_Save_ok);
		click(driver, ERO_Save_ok);
		Fluentwait(driver, ERO_route);
		click(driver, ERO_route);
		wait(driver,"2");
		Fluentwait(driver, Optimizer);
		click(driver, Optimizer);
		wait(driver,"2");
		Fluentwait(driver, Optimizer_Ok);
		click(driver, Optimizer_Ok);
		if(isDisplayed(driver, ERO_Equipment_Reposition_Solve)) {
			System.out.println("Equipment Reposition Solve page is displayed ");
			Extent_pass(driver, "Equipment Reposition Solve page is displayed ", test,test1);
		}else {
			
			System.out.println("Equipment Reposition Solve page is not displayed ");
			Extent_fail(driver, "Equipment Reposition Solve page is not displayed", test,test1);
		}
		
		Fluentwait(driver, ERO_Unsatisfied_Report);
		click(driver, ERO_Unsatisfied_Report);
		
		wait(driver,"2");
		String deficit_Val=getText(driver, ERO_Deficit_Val);
		System.out.println("deficit_Val :"+deficit_Val);
		
		if(deficit_Val.equals(Total_Defi)) {
			System.out.println("Deficit report count is display");
			Extent_fail(driver, "expected Deficit report count is :"+Total_Defi+" Actual Deficit report count is : "+deficit_Val, test,test1);
			
		}else {
			System.out.println("Deficit report count is not display");
			Extent_fail(driver, "expected Deficit report count is :"+Total_Defi+" Actual Deficit report count is : "+deficit_Val, test,test1);
		}
		
		
		 Extent_cal(test, "Testcase 182, Ensure Optimizer the records and after successful reposition below location still remain as deficit for all size type");
			
		 
		 
		 
   	       Set<String> oldFiles = getDirectoryFiles();
	 
	 		wait(driver, "5");
	 
	 		
	 		Fluentwait(driver, optimizer_export);
	 		click(driver, optimizer_export);
	 
	 		wait(driver, "5");
	 
	 		String baseFilename = "OPT";
	 
	 		boolean isDownloaded = isNewFileDownloaded(oldFiles, baseFilename);
	 
	 		if (isDownloaded == true) {
	 
	 			System.out.println("New excel file is downloaded in the downloads folder");
	 			Extent_pass(driver, "New excel file is downloaded in the downloads folder", test,test1);
	 
	 		} else {
	 			System.out.println("New excel file is not downloaded");
	 			Extent_fail(driver, "New excel file is not downloaded", test,test1);
	 		}
	 
	      System.out.println("Testcase 182 - completed");
	      
		
		
		
	}

}
