package ERO_Optimizer_WHAT_IF_Scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.Utils;

public class TS019_ERO_Optimizer_WHATIF_TC326to328 extends Keywords{
	public void Scenario19(WebDriver driver, ExtentTest test, ExtentTest test1, String url, int dataset) throws Exception {


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

		wait(driver, "7");
		
		String Total_records=getText(driver, Optimizer_Total_record);
		int length = Integer.parseInt(Total_records);
		
		Actions act=new Actions(driver);
		boolean appsurdef_Color = true;
		
		for(int i=0;i<length;i++) {
			try {
				WebElement element = driver.findElement(By.xpath("//div[@ref='eCenterContainer']/*[@row-id='"+i+"' and @role='row']"));
				String Appsurp_color = getTextBackgroundColor_element(driver, element, "");
				act.moveToElement(element).build().perform();
				System.out.println("Appsurf_color "+i+" : "+Appsurp_color);
				
				if(Appsurp_color.equalsIgnoreCase("#FFFFFF") || Appsurp_color.equalsIgnoreCase("#deebf7") ) {
					System.out.println("Optimizer WHAT IF Scenario field indicated as blue color in the grid");
				}else {
					System.out.println("Optimizer WHAT IF Scenario field not indicated as blue color in the grid");
					appsurdef_Color=false;
				}
			}catch(Exception e) {
				
			}
			
		}
		
		if(appsurdef_Color) {
			
			Extent_pass(driver, "Optimizer WHAT IF Scenario field indicated as blue color in the grid", test,test1);
		}else {
			Extent_fail(driver, "Optimizer WHAT IF Scenario field not indicated as blue color in the grid", test,test1);
		}
		
		
}
}