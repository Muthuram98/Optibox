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

public class ERO_Routing_Scenario25_TC186toTC200 extends Keywords {
	@SuppressWarnings("deprecation")
	public void ERO_Scenario25(WebDriver driver, ExtentTest test, ExtentTest test1, String url, int dataset)
			throws Exception {

		String Username = Utils.getDataFromTestData("ERO_Scenario25_Dataset" + dataset, "ERO Routing", "Username");
		String Password = Utils.getDataFromTestData("ERO_Scenario25_Dataset" + dataset, "ERO Routing", "Password");
		String ID = Utils.getDataFromTestData("ERO_Scenario25_Dataset" + dataset, "ERO Routing", "Id");
		String Total_Count = Utils.getDataFromTestData("ERO_Scenario25_Dataset" + dataset, "ERO Routing",
				"Surplus_val");
		String Deficit_Count = Utils.getDataFromTestData("ERO_Scenario25_Dataset" + dataset, "ERO Routing",
				"Deficit_Val");
		String Surplus_Count = Utils.getDataFromTestData("ERO_Scenario25_Dataset" + dataset, "ERO Routing", "Surpls");

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

		Extent_cal(test,
				"Testcase 186,Ensure export excel button functionality with Remaining Deficit Location Details window records displayed");

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

//		uploadFileRobot(driver,EquimentType_Alphabets);.

		String upload_EquimentType_Alphabets = System.getProperty("user.dir") + "/driver/MasterDownloadfile.exe "
				+ EquimentType_Alphabets;

		try {
			Runtime.getRuntime().exec(upload_EquimentType_Alphabets);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getLocalizedMessage());
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
		}

		wait(driver, "10");

		Fluentwait(driver, Location3);

		if (isDisplayed(driver, click_yes)) {

			click(driver, click_yes);

			Fluentwait(driver, Click_ok);
			click(driver, Click_ok);
		}

		wait(driver, "2");
		Fluentwait(driver, ERO_Save);
		click(driver, ERO_Save);
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
		if (isDisplayed(driver, ERO_Equipment_Reposition_Solve)) {
			System.out.println("Equipment Reposition Solve page is displayed ");
			Extent_pass(driver, "Equipment Reposition Solve page is displayed ", test, test1);
		} else {

			System.out.println("Equipment Reposition Solve page is not displayed ");
			Extent_fail(driver, "Equipment Reposition Solve page is not displayed", test, test1);
		}

		Fluentwait(driver, ERO_Unsatisfied_Report);
		click(driver, ERO_Unsatisfied_Report);

		String Surplus_Val = getText(driver, Surplus_Total);
		System.out.println("Surplus_Val" + Surplus_Val);

		if (Surplus_Val.equals(Total_Count)) {
			System.out.println("Remaining surplus Location Detail Exported");
			Extent_pass(driver, "expected value was :" + Total_Count + "Actual value was :" + Surplus_Val, test, test1);
		} else {
			Extent_fail(driver, "expected value was :" + Total_Count + "Actual value was :" + Surplus_Val, test, test1);
		}

		System.out.println("Testcase 186, compleated");

		Fluentwait(driver, ERO_Optimizer_Close);
		click(driver, ERO_Optimizer_Close);

		Fluentwait(driver, Defic_cancle1);
		click(driver, Defic_cancle1);

		Fluentwait(driver, Defic_cancle);
		click(driver, Defic_cancle);

		Extent_cal(test,
				"Testcase 187,Ensure export excel button functionality with Remaining Surplus Location Details window records displayed");

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

		String upload_EquimentType_Alphabets1 = System.getProperty("user.dir") + "/driver/MasterDownloadfile.exe "
				+ EquimentType_Alphabets;

		try {
			Runtime.getRuntime().exec(upload_EquimentType_Alphabets1);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getLocalizedMessage());
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
		}

		wait(driver, "10");

		Fluentwait(driver, Location3);

		if (isDisplayed(driver, click_yes)) {

			click(driver, click_yes);

			Fluentwait(driver, Click_ok);
			click(driver, Click_ok);
		}

		wait(driver, "2");
		Fluentwait(driver, ERO_Save);
		click(driver, ERO_Save);
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

		Fluentwait(driver, ERO_Unsatisfied_Report);
		click(driver, ERO_Unsatisfied_Report);

		Set<String> old_Files = getDirectoryFiles();

		wait(driver, "5");

		Fluentwait(driver, optimizer_export);
		click(driver, optimizer_export);

		wait(driver, "10");

		String baseFilenames = "OPT";

		boolean isDownloaded = isNewFileDownloaded(old_Files, baseFilenames);

		if (isDownloaded == true) {

			System.out.println("New excel file is downloaded in the downloads folder");
			Extent_pass(driver, "New excel file is downloaded in the downloads folder", test, test1);

		} else {
			System.out.println("New excel file is not downloaded");
			Extent_fail(driver, "New excel file is not downloaded", test, test1);
		}

		System.out.println("Testcase 187, completed");

		Fluentwait(driver, ERO_Optimizer_Close8);
		click(driver, ERO_Optimizer_Close8);

		Extent_cal(test,
				"Testcase 191,Ensure Optimizer the records and after successful reposition below location still remain as Deficit for single size type");

		Fluentwait(driver, All_40s_Option);
		click(driver, All_40s_Option);

		Fluentwait(driver, ERO_Size_Type_Label);
		click(driver, ERO_Size_Type_Label);

		Fluentwait(driver, ERO_Size_Type_Label_1);
		click(driver, ERO_Size_Type_Label_1);

		wait(driver, "2");
		Fluentwait(driver, Optimizer);
		click(driver, Optimizer);
		wait(driver, "2");
		Fluentwait(driver, Optimizer_Ok);
		click(driver, Optimizer_Ok);
		wait(driver, "2");
		Fluentwait(driver, ERO_Unsatisfied_Report);
		click(driver, ERO_Unsatisfied_Report);

		wait(driver, "2");

		String Deficit_count_va = getText(driver, ERO_Deficit_Val);
		System.out.println("Deficit_count_va :" + Deficit_count_va);

		if (Deficit_count_va.equals(Deficit_Count)) {
			System.out.println("Remaining Deficit Location Detail Exported");
			Extent_pass(driver, "expected value was :" + Deficit_Count + "Actual value was :" + Deficit_count_va, test,
					test1);
		} else {
			Extent_fail(driver, "expected value was :" + Deficit_Count + "Actual value was :" + Deficit_count_va, test,
					test1);
		}

		System.out.println("Testcase 191, completed");

		Extent_cal(test,
				"Testcase 192,Ensure export excel button functionality with Remaining Deficit Location Details window records displayed");

		Set<String> old_Files1 = getDirectoryFiles();

		wait(driver, "5");

		Fluentwait(driver, optimizer_export);
		click(driver, optimizer_export);

		wait(driver, "10");

		String baseFilenames1 = "OPT";

		boolean isDownloaded1 = isNewFileDownloaded(old_Files1, baseFilenames1);

		if (isDownloaded1 == true) {

			System.out.println("New excel file is downloaded in the downloads folder");
			Extent_pass(driver, "New excel file is downloaded in the downloads folder", test, test1);

		} else {
			System.out.println("New excel file is not downloaded");
			Extent_fail(driver, "New excel file is not downloaded", test, test1);
		}

		System.out.println("Testcase 192, completed");

		Extent_cal(test,
				"Testcase 196,Ensure Optimizer the records and after successful reposition below location still remain as Surplus for single size type");

		Fluentwait(driver, Ero_cancle);
		click(driver, Ero_cancle);

		Fluentwait(driver, ERO_Optimizer_Close3);
		click(driver, ERO_Optimizer_Close3);

		Fluentwait(driver, Defic_cancle2);
		click(driver, Defic_cancle2);

		Fluentwait(driver, Searchbox);
		sendKeys(driver, Searchbox, "Deficit and Surplus Location Identification");

		Fluentwait(driver, Selectdeficit);
		click(driver, Selectdeficit);

		wait(driver, "5");

		Fluentwait(driver, dropdown_option);
		click(driver, dropdown_option);

		Fluentwait(driver, Budget_Reposition);
		click(driver, Budget_Reposition);

		Fluentwait(driver, Budget);
		click(driver, Budget);
		wait(driver, "4");

//		uploadFileRobot(driver, EquimentType_Alphabets);

		String upload_EquimentType_Alphabets3 = System.getProperty("user.dir") + "/driver/MasterDownloadfile.exe "
				+ EquimentType_Alphabets;

		try {
			Runtime.getRuntime().exec(upload_EquimentType_Alphabets3);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getLocalizedMessage());
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
		}

		wait(driver, "10");

		Fluentwait(driver, Location3);

		if (isDisplayed(driver, click_yes)) {

			click(driver, click_yes);

			Fluentwait(driver, Click_ok);
			click(driver, Click_ok);
		}

		wait(driver, "2");
		Fluentwait(driver, ERO_Save);
		click(driver, ERO_Save);
		Fluentwait(driver, ERO_Save_ok);
		click(driver, ERO_Save_ok);
		Fluentwait(driver, ERO_route);
		click(driver, ERO_route);
		wait(driver, "2");
		Fluentwait(driver, All_40s_Option);
		click(driver, All_40s_Option);

		Fluentwait(driver, ERO_Size_Type_Label);
		click(driver, ERO_Size_Type_Label);

		Fluentwait(driver, ERO_Size_Type_Label_1);
		click(driver, ERO_Size_Type_Label_1);

		wait(driver, "2");
		Fluentwait(driver, Optimizer);
		click(driver, Optimizer);
		wait(driver, "2");
		Fluentwait(driver, Optimizer_Ok);
		click(driver, Optimizer_Ok);
		wait(driver, "2");
		Fluentwait(driver, ERO_Unsatisfied_Report);
		click(driver, ERO_Unsatisfied_Report);

		wait(driver, "2");
		String surplus_val = getText(driver, Surplus_Total);
		System.out.println(surplus_val);

		if (Surplus_Val.equals(Surplus_Count)) {
			System.out.println("Remaining surplus Location Detail Exported");
			Extent_pass(driver, "expected value was :" + Surplus_Count + "Actual value was :" + Surplus_Val, test,
					test1);
		} else {
			Extent_fail(driver, "expected value was :" + Surplus_Count + "Actual value was :" + Surplus_Val, test,
					test1);
		}
		System.out.println("Testcase 196, completed");

		Extent_cal(test,
				"Testcase 197,Ensure export excel button functionality with Remaining Surplus Location Details window records displayed");

		Set<String> old_Files2 = getDirectoryFiles();

		wait(driver, "5");

		Fluentwait(driver, optimizer_export);
		click(driver, optimizer_export);

		wait(driver, "10");

		String baseFilenames2 = "OPT";

		boolean isDownloaded2 = isNewFileDownloaded(old_Files2, baseFilenames2);

		if (isDownloaded2 == true) {

			System.out.println("New excel file is downloaded in the downloads folder");
			Extent_pass(driver, "New excel file is downloaded in the downloads folder", test, test1);

		} else {
			System.out.println("New excel file is not downloaded");
			Extent_fail(driver, "New excel file is not downloaded", test, test1);
		}

		System.out.println("Testcase 197, completed");

	}

}
