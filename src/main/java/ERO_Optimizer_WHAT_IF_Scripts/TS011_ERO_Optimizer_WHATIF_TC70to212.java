package ERO_Optimizer_WHAT_IF_Scripts;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.Utils;

public class TS011_ERO_Optimizer_WHATIF_TC70to212 extends  Keywords {

	public void Scenario11(WebDriver driver, ExtentTest test,ExtentTest test1,String url, int dataset) throws Exception {
		
		String Username = Utils.getDataFromTestData("TS11_EroOptimizer_WHAT_IF", "ERO_Optimizer WHAT_IF", "Username");
		String Password = Utils.getDataFromTestData("TS11_EroOptimizer_WHAT_IF", "ERO_Optimizer WHAT_IF", "Password");
		String ID = Utils.getDataFromTestData("TS11_EroOptimizer_WHAT_IF", "ERO_Optimizer WHAT_IF", "Id");
		String ID_value= Utils.getDataFromTestData("TS11_EroOptimizer_WHAT_IF", "ERO_Optimizer WHAT_IF", "Id_val");
		
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

		Fluentwait(driver, SelectOptimizer);
		click(driver, SelectOptimizer);
		wait(driver, "5");
		
		click(driver, Optimizer_Globalserach);

		Fluentwait(driver, Globalserach_IDInput);
		sendKeys(driver, Globalserach_IDInput, ID);

		wait(driver, "2");

		Fluentwait(driver, Click_Search);
		click(driver, Click_Search);

		wait(driver, "5");

		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);
		
		wait(driver,"7");
		
		String id=getAttribute(driver, Optimizer_id_filed, "value");
		
		
		if(id.equals(ID_value)) {
			System.out.println("Matched || Expected Id : "+ID_value+" || Actual Id : "+id);
			Extent_pass(driver, "Matched || Expected Id : "+ID_value+" || Actual Id : "+id, test,test1);
			Extent_pass(driver, "System allowed to auto generate the Id", test,test1);
			
		}else {
			System.out.println("Not Matched || Expected Id : "+ID_value+" || Actual Id : "+id);
			Extent_fail(driver, "Not Matched || Expected Id : "+ID_value+" || Actual Id : "+id, test,test1);
		}
		
		System.out.println("**************Testcase 112 -  Completed ************");
		
		Extent_cal(test, "Testcase 114 - Ensure in  ID  field un editable");
		
		Fluentwait(driver, Optimizer_cancle);
		click(driver, Optimizer_cancle);
		
		Fluentwait(driver, Optimizer_new);
		click(driver, Optimizer_new);
		
		Fluentwait(driver, Optimizer_createnew_confirm);
		click(driver, Optimizer_createnew_confirm);
		
		wait(driver,"3");
		
		click(driver, Optimizer_Globalserach);

		Fluentwait(driver, Globalserach_IDInput);
		sendKeys(driver, Globalserach_IDInput, ID);

		wait(driver, "2");

		Fluentwait(driver, Click_Search);
		click(driver, Click_Search);

		wait(driver, "5");

		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);
		
		wait(driver,"7");
          if(!isClear(driver, Optimizer_id_filed)){
			
			System.out.println("Unable to do the edit action in the ID Field");
			Extent_pass(driver, "Unable to do the edit action in the ID Field", test,test1);
			
		}else {
			
			System.out.println("Able to do the edit action in the ID Field");
			Extent_fail(driver, "Able to do the edit action in the ID Field", test,test1);
		}
          
      	System.out.println("**************Testcase 114 -  Completed ************");
          
          
          
	}
	
}
