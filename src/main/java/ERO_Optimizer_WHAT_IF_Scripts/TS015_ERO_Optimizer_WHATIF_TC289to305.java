package ERO_Optimizer_WHAT_IF_Scripts;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.python.antlr.PythonParser.list_for_return;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.Utils;

public class TS015_ERO_Optimizer_WHATIF_TC289to305 extends Keywords {
	
	public void Scenario15(WebDriver driver, ExtentTest test, ExtentTest test1, String url, int dataset) throws Exception {

		String Username = Utils.getDataFromTestData("TS12_EroOptimizer_WHAT_IF", "ERO_Optimizer WHAT_IF", "Username");
		String Password = Utils.getDataFromTestData("TS12_EroOptimizer_WHAT_IF", "ERO_Optimizer WHAT_IF", "Password");
		String ID = Utils.getDataFromTestData("TS12_EroOptimizer_WHAT_IF", "ERO_Optimizer WHAT_IF", "Id");	
		
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
		
		Extent_cal(test, "Testcase 289 - Ensure in Location,Equipment Type,Region,Country,Import,actual Export,supply, export columns records displayed");

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
		wait(driver,"4");
		
	List<String> Gridfields =Arrays.asList("origin","origincontainers","delivery","deliverycontainers","iAlloc","allocatecntr","sizetype","optcost");
		
	int size=Gridfields.size();
	
	for(int i=0;i<size;i++) {
		
		String column = Gridfields.get(i);
		
		WebElement fieldpath = driver.findElement(By.xpath("(//div[@col-id='"+column+"'])[1]"));
		
		if (isDisplayed1(driver, fieldpath)) {

			System.out.println(column + " field values are showing in the grid");
			Extent_pass(driver, column + " field values are showing in the grid", test,test1);

		} else {

			System.out.println(column + " field values are not showing in the grid");
			Extent_fail(driver, column + " field values are not showing in the grid", test,test1);
		}
	}
	
	System.out.println("*************Testcase 289 Completed************************");

	
	
	
}
}