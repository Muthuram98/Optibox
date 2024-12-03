package MapView;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.Utils;

public class TS11to12MapView68to69 extends Keywords{
	
	public void Scenario11(WebDriver driver, ExtentTest test,ExtentTest test1, String url, int dataset) throws Exception {
		
		System.out.println("url : " + url);
		String Username = Utils.getDataFromTestData("TS11_Map_View_Dataset"+dataset, "Map view","Username");
		String Password = Utils.getDataFromTestData("TS11_Map_View_Dataset"+dataset, "Map view","Password");
		String ID = Utils.getDataFromTestData("TS11_Map_View_Dataset"+dataset, "Map view", "Id");	
		
		navigateUrl(driver, url);
        Actions act=new Actions(driver);
        
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
		Extent_cal(test, "Testcase 68 - Ensure all the field Functionality working");
		Fluentwait(driver, Searchbox);
		sendKeys(driver, Searchbox, "Map View");
		
		Fluentwait(driver, Select_mapview);
		click(driver, Select_mapview);
		
		Fluentwait(driver, Map_view_Globalserach);
		click(driver, Map_view_Globalserach);
        wait(driver,"2");
		if(isDisplayed(driver, global_screen)) {
			System.out.println("All the field Functionality working fine");
			Extent_pass(driver, "All the field Functionality working fine", test,test1);
		}else {
			System.out.println("All the field Functionality not working");
			Extent_fail(driver, "All the field Functionality not working", test,test1);
		}
		System.out.println("************************Testcase 68 - Completed *************************");
		Extent_cal(test, "Testcase 69 -Ensure all the Buttons Functionality working");
		Fluentwait(driver, Globalserach_IDInput);
		sendKeys(driver, Globalserach_IDInput,"B20240829-01-52-00016");

		wait(driver, "2");

		Fluentwait(driver, Click_Search);
		click(driver, Click_Search);

		wait(driver, "5");

		Fluentwait(driver, SelectID);
		doubleClick(driver, SelectID);
		Fluentwait(driver, Map_20HH);
		click(driver, Map_20HH);
		
		// takescreenshot(driver, "//Expected_screenshot//MapView20HH//20HHscreen");
		   takescreenshot(driver, "//Actual_screenshot//MapView20HH//20HHscreen");

		if (imageComparison2(driver, "//MapView20HH//20HHscreen", "//MapView20HH//20HHscreen") == true) {

			System.out.println("20HH windows have a consistent look and feel");
			Extent_pass(driver, "20HH windows have a consistent look and feel", test,test1);
		} else {

			System.out.println("20HH window will be showing different look and feel than the expected");
			Extent_fail(driver, "20HH window will be showing different look and feel than the expected", test,test1);
		}	
		
		wait(driver, "2");
		Fluentwait(driver, Map_20RF);
		click(driver, Map_20RF);
		
		 //takescreenshot(driver, "//Expected_screenshot//MapView20RF//20RFscreen");
		   takescreenshot(driver, "//Actual_screenshot//MapView20RF//20RFscreen");

		if (imageComparison2(driver, "//MapView20RF//20RFscreen", "//MapView20RF//20RFscreen") == true) {

			System.out.println("20RF windows have a consistent look and feel");
			Extent_pass(driver, "20RF windows have a consistent look and feel", test,test1);
		} else {

			System.out.println("20RF window will be showing different look and feel than the expected");
			Extent_fail(driver, "20RF window will be showing different look and feel than the expected", test,test1);
		}
	
		
		
		wait(driver, "7");
		Fluentwait(driver, ANZ_Dropdown);
		click(driver, ANZ_Dropdown);
		wait(driver, "2");

		Fluentwait(driver, Au_Dropdown);
		click(driver, Au_Dropdown);
		
		if(isDisplayed(driver, AUBNE_Option)) {
			System.out.println("After click on SVM Buttons Functionality working fine");
			Extent_pass(driver, "After click on SVM Buttons Functionality working fine", test,test1);

		}else {
			System.out.println("After click on SVM Buttons Functionality not working fine");
			Extent_fail(driver, "After click on SVM Buttons Functionality not working fine", test,test1);
		}
		
		wait(driver, "2");

		Fluentwait(driver, Map_ZoomOut);
		click(driver, Map_ZoomOut);	
		
		wait(driver, "2");

		Fluentwait(driver, Zoomout_fun);
		click(driver, Zoomout_fun);	
		wait(driver, "2");
		
		if(isDisplayed(driver, Map_location_details)) {
			System.out.println("Zoom out Buttons  Functionality working fine");
			Extent_pass(driver, "Zoom out  Buttons Functionality working fine", test,test1);
		}else {
			System.out.println("Zoom out Buttons  Functionality not working fine");
			Extent_fail(driver, "Zoom out  Buttons Functionality not working fine", test,test1);
		}

		wait(driver, "2");

		Fluentwait(driver, Map_20hc);
		mouseOverAndClick(driver, Map_20hc);	
		 wait(driver, "2");
		       //  takescreenshot(driver, "//Expected_screenshot//MapView20HC//20HCscreen");
				   takescreenshot(driver, "//Actual_screenshot//MapView20HC//20HCscreen");

				if (imageComparison2(driver, "//MapView20HC//20HCscreen", "//MapView20HC//20HCscreen") == true) {

					System.out.println("20Hc windows have a consistent look and feel");
					Extent_pass(driver, "20Hc windows have a consistent look and feel", test,test1);
				} else {

					System.out.println("20Hc window will be showing different look and feel than the expected");
					Extent_fail(driver, "20Hc window will be showing different look and feel than the expected", test,test1);
				}
				wait(driver, "2");
		
		Extent_cal(test, "Testcase 71 - Ensure the validation message displayed ");		
		
		Fluentwait(driver, MapView_cancel);
		click(driver, MapView_cancel);
		
		Fluentwait(driver, MapView_new);
		click(driver, MapView_new);	
		wait(driver,"2");
		
		if(isDisplayed(driver, Map_pop)) {
			System.out.println("Confirmation message  is display successfully");
			Extent_pass(driver, "Confirmation message  is display successfully", test,test1);
		}else {
			System.out.println("Confirmation message  is not display ");
			Extent_fail(driver, "Confirmation message  is not display ", test,test1);
		}
		Fluentwait(driver, MapView_createnew_confirm);
		click(driver, MapView_createnew_confirm);	
		
		System.out.println("************************Testcase  -71 Completed *************************");	
		
}
}