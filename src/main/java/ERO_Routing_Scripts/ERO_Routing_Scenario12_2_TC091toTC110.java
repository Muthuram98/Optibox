package ERO_Routing_Scripts;

import java.awt.Robot;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.Utils;

public class ERO_Routing_Scenario12_2_TC091toTC110 extends Keywords {
	@SuppressWarnings("deprecation")
	public void ERO_Scenario12_2(WebDriver driver, ExtentTest test, ExtentTest test1, String url, int dataset)
			throws Exception {

		String Username = Utils.getDataFromTestData("ERO_Scenario12_Dataset"+dataset, "ERO Routing", "Username");
		String Password = Utils.getDataFromTestData("ERO_Scenario12_Dataset"+dataset, "ERO Routing", "Password");
		String ID = Utils.getDataFromTestData("ERO_Scenario12_Dataset"+dataset, "ERO Routing", "Id");
		String Optimizers = Utils.getDataFromTestData("ERO_Scenario13", "ERO Routing", "Optimizer_Pop");
		String save = Utils.getDataFromTestData("ERO_Scenario12_Dataset"+dataset, "ERO Routing", "save_popup");

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

		Extent_cal(test, "Testcase 91,Ensure Optimizer button with all size type Functionality with feasible ");

		Fluentwait(driver, Searchbox);
		sendKeys(driver, Searchbox, "Deficit and Surplus Location Identification");

		Fluentwait(driver, Selectdeficit);
		click(driver, Selectdeficit);

		wait(driver, "5");

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

//			uploadFileRobot(driver, EquimentType_Alphabets);

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

		List<WebElement> OtimizerList = driver.findElements(By.xpath("(//tr[@data-ri='0'])[1]//td"));
		List<WebElement> header = driver.findElements(By.xpath("//thead[@id='OPT-OPT_treeTable_head']//th"));
		List<String> Columnname5 = new ArrayList<>();

		if (header.isEmpty()) {
			System.out.println("No header found");
		} else {
			for (WebElement headers : header) {
				if (headers.isDisplayed()) {
					Columnname5.add(headers.getText().trim());
				} else {
					System.out.println("No header is displayed");
				}
			}

			if (Columnname5.size() == header.size()) {
				System.out.println("All header displayed");
			} else {
				System.out.println("Not displayed");
			}

			boolean Filter2 = true;
			for (int j = 0; j < OtimizerList.size(); j++) {
				WebElement Disch = OtimizerList.get(j);

				String columnname = header.get(j).getText();

				System.out.println("columnname : " + columnname);

				if (Disch.isDisplayed()) {
					Extent_pass(driver, "After navigating to optimizer, " + columnname + " route datas are displayed  ",
							test, test1);
				} else {
					Extent_fail(driver,
							" After navigating to optimizer, " + columnname + "  route datas are  not displayed ", test,
							test1);
					Filter2 = false;
				}

			}
			for (int k = 0; k < OtimizerList.size(); k++) {
				WebElement Disch2 = OtimizerList.get(k);
				String Disch3 = OtimizerList.get(k).getText();

				if (Disch2.isDisplayed()) {
					Extent_pass(driver,
							"After navigating to optimizer, " + Disch3 + " route datas are displayed  in the grid",
							test, test1);
				} else {
					Extent_fail(driver, " After navigating to optimizer, " + Disch3
							+ "  route datas are  not displayed in the grid", test, test1);
					Filter2 = false;
				}
			}

			if (Filter2 == true) {
				Extent_pass(driver, "After navigating to optimizer route datas are displayed", test, test1);

			} else {
				Extent_fail(driver, "After navigating to optimizer route datas are  not displayed", test, test1);
			}
		}
		System.out.println("Testcase 91 completed");

		Fluentwait(driver, Optimizer_Clo);
		click(driver, Optimizer_Clo);

		Extent_cal(test, "Testcase 93,Ensure Optimizer button with all size type Functionality  with infeasible");
		wait(driver, "2");
		Fluentwait(driver, Optimizer);
		click(driver, Optimizer);
		wait(driver, "4");

		if (Optimizer_Pop.equals(Optimizers)) {

			System.out.println("validation message is displayed");
			Extent_pass(driver, "Expected poup message is displayed : '" + Optimizers + "'", test, test1);
		} else {
			System.out.println("validation message is not displayed");
			Extent_fail(driver, "Expected poup message is displayed : '" + Optimizers + "'", test, test1);
		}

		Fluentwait(driver, Optimizer_Ok);
		click(driver, Optimizer_Ok);

		System.out.println("Testcase 93, completed");

		Fluentwait(driver, Optimizer_Clo);
		click(driver, Optimizer_Clo);

		Fluentwait(driver, Ero_cancle);
		click(driver, Ero_cancle);
		Fluentwait(driver, Defi_close);
		click(driver, Defi_close);

		Extent_cal(test,
				"Testcase 94,Ensure Optimizer button with All size type Functionality system should not allow heap memory full ");
		Fluentwait(driver, Searchbox);
		sendKeys(driver, Searchbox, "Deficit and Surplus Location Identification");

		Fluentwait(driver, Selectdeficit);
		click(driver, Selectdeficit);

		wait(driver, "5");

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

//				uploadFileRobot(driver,EquimentType_Alphabets);

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

		wait(driver, "3");
		Fluentwait(driver, ERO_Save);
		click(driver, ERO_Save);
		Fluentwait(driver, ERO_Save_ok);
		click(driver, ERO_Save_ok);
		wait(driver, "2");
		Fluentwait(driver, ERO_route);
		click(driver, ERO_route);
		wait(driver, "6");
		Fluentwait(driver, Optimizer);
		click(driver, Optimizer);
		wait(driver, "4");
		Fluentwait(driver, Optimizer_Ok);
		click(driver, Optimizer_Ok);
		if (isDisplayed(driver, ERO_Equipment_Reposition_Solve)) {
			System.out.println("Equipment Reposition Solve page is displayed ");
			Extent_pass(driver, "Equipment Reposition Solve page is displayed ", test, test1);
		} else {

			System.out.println("Equipment Reposition Solve page is not displayed ");
			Extent_fail(driver, "Equipment Reposition Solve page is not displayed", test, test1);
		}

		wait(driver, "4");

		if (isDisplayed(driver, Opti_first)) {
			Extent_pass(driver, "After navigating to optimizer, route datas are displayed  ", test, test1);

		} else {
			Extent_fail(driver, " After navigating to optimizer,  route datas are  not displayed ", test, test1);
		}
		wait(driver, "2");

		if (isDisplayed(driver, Opti_first_Header)) {
			Extent_pass(driver, "After navigating to optimizer, route datas are displayed in the grid ", test, test1);

		} else {
			Extent_fail(driver, " After navigating to optimizer,  route datas are  not displayed in the grid ", test,
					test1);
		}
		System.out.println("Testcase 94 completed");

		Extent_cal(test, "Testcase 95,Ensure Optimizer button with single size type Functionality with feasible");

		if (isDisplayed(driver, ERO_Equipment_Reposition_Solve)) {
			System.out.println("Equipment Reposition Solve page is displayed");
			Extent_pass(driver, "Equipment Reposition Solve page is displayed ", test, test1);
		} else {
			System.out.println("Equipment Reposition Solve page is not displayed");
			Extent_fail(driver, "Equipment Reposition Solve page is  not displayed ", test, test1);
		}

		if (isDisplayed(driver, ERO_Equipment_Reposition_Report)) {
			System.out.println("Equipment Reposition report page is displayed");
			Extent_pass(driver, "Equipment Reposition report page is displayed ", test, test1);
		} else {
			System.out.println("Equipment Reposition report page is not displayed");
			Extent_fail(driver, "Equipment Reposition report page is  not displayed ", test, test1);
		}

		if (isDisplayed(driver, ERO_Unsatisfied_Report)) {
			System.out.println("Unsatisfied Report page is displayed");
			Extent_pass(driver, "Unsatisfied Report report page is displayed ", test, test1);
		} else {
			System.out.println("Unsatisfied Report page is not displayed");
			Extent_fail(driver, "Unsatisfied Report page is  not displayed ", test, test1);
		}

		if (isDisplayed(driver, ERO_Hire_Report)) {
			System.out.println("Hire Report page is displayed");
			Extent_pass(driver, "Hire Report page is displayed ", test, test1);
		} else {
			System.out.println("Hire Report page is not displayed");
			Extent_fail(driver, "Hire Report page is  not displayed ", test, test1);
		}

		if (isDisplayed(driver, ERO_Lease_Report)) {
			System.out.println("Lease Report page is displayed");
			Extent_pass(driver, "Lease Report page is displayed ", test, test1);
		} else {
			System.out.println("Lease Report page is not displayed");
			Extent_fail(driver, "Lease Report page is  not displayed ", test, test1);
		}

		if (isDisplayed(driver, ERO_Chat)) {
			System.out.println("ERO Chat page is displayed");
			Extent_pass(driver, "ERO Chat page is displayed ", test, test1);
		} else {
			System.out.println("ERO Chat page is not displayed");
			Extent_fail(driver, "ERO Chat page is  not displayed ", test, test1);
		}

		if (isDisplayed(driver, ERO_Hire_Summary)) {
			System.out.println("ERO Hire Summary page is displayed");
			Extent_pass(driver, "ERO Hire Summary page is displayed ", test, test1);
		} else {
			System.out.println("ERO Hire Summary page is not displayed");
			Extent_fail(driver, "ERO Hire Summary page is  not displayed ", test, test1);
		}
		if (isDisplayed(driver, ERO_Total_Summary)) {
			System.out.println("ERO Total Summary page is displayed");
			Extent_pass(driver, "ERO Total Summary page is displayed ", test, test1);
		} else {
			System.out.println("ERO Total Summary page is not displayed");
			Extent_fail(driver, "ERO Total Summary page is  not displayed ", test, test1);
		}
		System.out.println("Testcase 95, completed");

		Fluentwait(driver, Optimizer_Clo);
		click(driver, Optimizer_Clo);

		Extent_cal(test, "Testcase 96,Ensure Optimizer button with single size type Functionality with infeasible");

		Fluentwait(driver, All_20s_Option);
		click(driver, All_20s_Option);

		Fluentwait(driver, ERO_Size_Type_Label);
		click(driver, ERO_Size_Type_Label);
		wait(driver, "1");
		Fluentwait(driver, ERO_Size_Type_Label_1);
		click(driver, ERO_Size_Type_Label_1);

		Fluentwait(driver, Optimizer);
		click(driver, Optimizer);
		wait(driver, "2");
		Fluentwait(driver, Optimizer_Ok);
		click(driver, Optimizer_Ok);

		if (isDisplayed(driver, ERO_Equipment_Reposition_Solve)) {
			System.out.println("Equipment Reposition Solve page is displayed");
			Extent_pass(driver, "Equipment Reposition Solve page is displayed ", test, test1);
		} else {
			System.out.println("Equipment Reposition Solve page is not displayed");
			Extent_fail(driver, "Equipment Reposition Solve page is  not displayed ", test, test1);
		}

		if (isDisplayed(driver, ERO_Equipment_Reposition_Report)) {
			System.out.println("Equipment Reposition report page is displayed");
			Extent_pass(driver, "Equipment Reposition report page is displayed ", test, test1);
		} else {
			System.out.println("Equipment Reposition report page is not displayed");
			Extent_fail(driver, "Equipment Reposition report page is  not displayed ", test, test1);
		}

		if (isDisplayed(driver, ERO_Unsatisfied_Report)) {
			System.out.println("Unsatisfied Report page is displayed");
			Extent_pass(driver, "Unsatisfied Report report page is displayed ", test, test1);
		} else {
			System.out.println("Unsatisfied Report page is not displayed");
			Extent_fail(driver, "Unsatisfied Report page is  not displayed ", test, test1);
		}

		if (isDisplayed(driver, ERO_Hire_Report)) {
			System.out.println("Hire Report page is displayed");
			Extent_pass(driver, "Hire Report page is displayed ", test, test1);
		} else {
			System.out.println("Hire Report page is not displayed");
			Extent_fail(driver, "Hire Report page is  not displayed ", test, test1);
		}

		if (isDisplayed(driver, ERO_Lease_Report)) {
			System.out.println("Lease Report page is displayed");
			Extent_pass(driver, "Lease Report page is displayed ", test, test1);
		} else {
			System.out.println("Lease Report page is not displayed");
			Extent_fail(driver, "Lease Report page is  not displayed ", test, test1);
		}

		if (isDisplayed(driver, ERO_Chat)) {
			System.out.println("ERO Chat page is displayed");
			Extent_pass(driver, "ERO Chat page is displayed ", test, test1);
		} else {
			System.out.println("ERO Chat page is not displayed");
			Extent_fail(driver, "ERO Chat page is  not displayed ", test, test1);
		}

		Fluentwait(driver, Optimizer_Clo);
		click(driver, Optimizer_Clo);

		Fluentwait(driver, ERO_Size_Type_Label);
		click(driver, ERO_Size_Type_Label);
		wait(driver, "1");
		Fluentwait(driver, ERO_20Hc_Val);
		click(driver, ERO_20Hc_Val);

		Fluentwait(driver, Optimizer);
		click(driver, Optimizer);
		wait(driver, "2");
		Fluentwait(driver, Optimizer_Ok);
		click(driver, Optimizer_Ok);

		if (isDisplayed(driver, ERO_Equipment_Reposition_Solve)) {
			System.out.println("Equipment Reposition Solve page is displayed");
			Extent_pass(driver, "Equipment Reposition Solve page is displayed ", test, test1);
		} else {
			System.out.println("Equipment Reposition Solve page is not displayed");
			Extent_fail(driver, "Equipment Reposition Solve page is  not displayed ", test, test1);
		}

		if (isDisplayed(driver, ERO_Equipment_Reposition_Report)) {
			System.out.println("Equipment Reposition report page is displayed");
			Extent_pass(driver, "Equipment Reposition report page is displayed ", test, test1);
		} else {
			System.out.println("Equipment Reposition report page is not displayed");
			Extent_fail(driver, "Equipment Reposition report page is  not displayed ", test, test1);
		}

		if (isDisplayed(driver, ERO_Unsatisfied_Report)) {
			System.out.println("Unsatisfied Report page is displayed");
			Extent_pass(driver, "Unsatisfied Report report page is displayed ", test, test1);
		} else {
			System.out.println("Unsatisfied Report page is not displayed");
			Extent_fail(driver, "Unsatisfied Report page is  not displayed ", test, test1);
		}

		if (isDisplayed(driver, ERO_Hire_Report)) {
			System.out.println("Hire Report page is displayed");
			Extent_pass(driver, "Hire Report page is displayed ", test, test1);
		} else {
			System.out.println("Hire Report page is not displayed");
			Extent_fail(driver, "Hire Report page is  not displayed ", test, test1);
		}

		if (isDisplayed(driver, ERO_Lease_Report)) {
			System.out.println("Lease Report page is displayed");
			Extent_pass(driver, "Lease Report page is displayed ", test, test1);
		} else {
			System.out.println("Lease Report page is not displayed");
			Extent_fail(driver, "Lease Report page is  not displayed ", test, test1);
		}

		if (isDisplayed(driver, ERO_Chat)) {
			System.out.println("ERO Chat page is displayed");
			Extent_pass(driver, "ERO Chat page is displayed ", test, test1);
		} else {
			System.out.println("ERO Chat page is not displayed");
			Extent_fail(driver, "ERO Chat page is  not displayed ", test, test1);
		}

		Fluentwait(driver, Optimizer_Clo);
		click(driver, Optimizer_Clo);

		Fluentwait(driver, ERO_Size_Type_Label);
		click(driver, ERO_Size_Type_Label);
		wait(driver, "1");
		Fluentwait(driver, ERO_20_HH_Val);
		click(driver, ERO_20_HH_Val);
		Fluentwait(driver, Optimizer);
		click(driver, Optimizer);
		wait(driver, "2");
		Fluentwait(driver, Optimizer_Ok);
		click(driver, Optimizer_Ok);

		if (isDisplayed(driver, ERO_Equipment_Reposition_Solve)) {
			System.out.println("Equipment Reposition Solve page is displayed");
			Extent_pass(driver, "Equipment Reposition Solve page is displayed ", test, test1);
		} else {
			System.out.println("Equipment Reposition Solve page is not displayed");
			Extent_fail(driver, "Equipment Reposition Solve page is  not displayed ", test, test1);
		}

		if (isDisplayed(driver, ERO_Equipment_Reposition_Report)) {
			System.out.println("Equipment Reposition report page is displayed");
			Extent_pass(driver, "Equipment Reposition report page is displayed ", test, test1);
		} else {
			System.out.println("Equipment Reposition report page is not displayed");
			Extent_fail(driver, "Equipment Reposition report page is  not displayed ", test, test1);
		}

		if (isDisplayed(driver, ERO_Unsatisfied_Report)) {
			System.out.println("Unsatisfied Report page is displayed");
			Extent_pass(driver, "Unsatisfied Report report page is displayed ", test, test1);
		} else {
			System.out.println("Unsatisfied Report page is not displayed");
			Extent_fail(driver, "Unsatisfied Report page is  not displayed ", test, test1);
		}
		if (isDisplayed(driver, ERO_Hire_Report)) {
			System.out.println("Hire Report page is displayed");
			Extent_pass(driver, "Hire Report page is displayed ", test, test1);
		} else {
			System.out.println("Hire Report page is not displayed");
			Extent_fail(driver, "Hire Report page is  not displayed ", test, test1);
		}

		if (isDisplayed(driver, ERO_Lease_Report)) {
			System.out.println("Lease Report page is displayed");
			Extent_pass(driver, "Lease Report page is displayed ", test, test1);
		} else {
			System.out.println("Lease Report page is not displayed");
			Extent_fail(driver, "Lease Report page is  not displayed ", test, test1);
		}

		if (isDisplayed(driver, ERO_Chat)) {
			System.out.println("ERO Chat page is displayed");
			Extent_pass(driver, "ERO Chat page is displayed ", test, test1);
		} else {
			System.out.println("ERO Chat page is not displayed");
			Extent_fail(driver, "ERO Chat page is  not displayed ", test, test1);
		}
		Fluentwait(driver, Optimizer_Clo);
		click(driver, Optimizer_Clo);

		Fluentwait(driver, ERO_Size_Type_Label);
		click(driver, ERO_Size_Type_Label);
		wait(driver, "1");
		Fluentwait(driver, ERO_20RF_Val);
		click(driver, ERO_20RF_Val);
		Fluentwait(driver, Optimizer);
		click(driver, Optimizer);
		wait(driver, "2");
		Fluentwait(driver, Optimizer_Ok);
		click(driver, Optimizer_Ok);
		if (isDisplayed(driver, ERO_Equipment_Reposition_Solve)) {
			System.out.println("Equipment Reposition Solve page is displayed");
			Extent_pass(driver, "Equipment Reposition Solve page is displayed ", test, test1);
		} else {
			System.out.println("Equipment Reposition Solve page is not displayed");
			Extent_fail(driver, "Equipment Reposition Solve page is  not displayed ", test, test1);
		}

		if (isDisplayed(driver, ERO_Equipment_Reposition_Report)) {
			System.out.println("Equipment Reposition report page is displayed");
			Extent_pass(driver, "Equipment Reposition report page is displayed ", test, test1);
		} else {
			System.out.println("Equipment Reposition report page is not displayed");
			Extent_fail(driver, "Equipment Reposition report page is  not displayed ", test, test1);
		}

		if (isDisplayed(driver, ERO_Unsatisfied_Report)) {
			System.out.println("Unsatisfied Report page is displayed");
			Extent_pass(driver, "Unsatisfied Report report page is displayed ", test, test1);
		} else {
			System.out.println("Unsatisfied Report page is not displayed");
			Extent_fail(driver, "Unsatisfied Report page is  not displayed ", test, test1);
		}
		if (isDisplayed(driver, ERO_Hire_Report)) {
			System.out.println("Hire Report page is displayed");
			Extent_pass(driver, "Hire Report page is displayed ", test, test1);
		} else {
			System.out.println("Hire Report page is not displayed");
			Extent_fail(driver, "Hire Report page is  not displayed ", test, test1);
		}

		if (isDisplayed(driver, ERO_Lease_Report)) {
			System.out.println("Lease Report page is displayed");
			Extent_pass(driver, "Lease Report page is displayed ", test, test1);
		} else {
			System.out.println("Lease Report page is not displayed");
			Extent_fail(driver, "Lease Report page is  not displayed ", test, test1);
		}

		if (isDisplayed(driver, ERO_Chat)) {
			System.out.println("ERO Chat page is displayed");
			Extent_pass(driver, "ERO Chat page is displayed ", test, test1);
		} else {
			System.out.println("ERO Chat page is not displayed");
			Extent_fail(driver, "ERO Chat page is  not displayed ", test, test1);
		}

		System.out.println("Testcase 96, completed");

		Fluentwait(driver, Optimizer_Clo);
		click(driver, Optimizer_Clo);
		wait(driver, "2");

		Extent_cal(test, "Testcase 101 - Ensure View Map button functionality");

		Fluentwait(driver, EPO_map);
		click(driver, EPO_map);

		if (isDisplayed(driver, EPO_map_Id_Field)) {
			System.out.println("Graphical representation page is displayed ");
			Extent_pass(driver, "Graphical representation page is displayed ", test, test1);
		} else {

			System.out.println("Graphical representation page is not displayed ");
			Extent_fail(driver, "Graphical representation page is not  displayed ", test, test1);
		}

		System.out.println("Testcase 101 completed");

		Extent_cal(test, "Testcase 102 - Ensure View Map button functionality without navigate Graphical view screen");

		if (!isDisplayed(driver, ERO_Total_Count)) {

			System.out.println("Graphical representation page is not displayed ");
			Extent_pass(driver, "Graphical representation page is not displayed ", test, test1);
		} else {

			System.out.println("Graphical representation page is  displayed ");
			Extent_fail(driver, "Graphical representation page is   displayed ", test, test1);
		}

		System.out.println("Testcase 102 completed");

		Fluentwait(driver, Optimizer_Clo);
		click(driver, Optimizer_Clo);

		Fluentwait(driver, Ero_cancle2);
		click(driver, Ero_cancle2);

		Fluentwait(driver, Defic_cancle2);
		click(driver, Defic_cancle2);

		Extent_cal(test, "Testcase 104 - Ensure save button functionality");

		Fluentwait(driver, Searchbox);
		sendKeys(driver, Searchbox, "Deficit and Surplus Location Identification");

		Fluentwait(driver, Selectdeficit);
		click(driver, Selectdeficit);

		wait(driver, "5");

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

//			uploadFileRobot(driver,EquimentType_Alphabets);

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

		wait(driver, "3");
		Fluentwait(driver, ERO_Save);
		mouseOverAndClick(driver, ERO_Save);

		Fluentwait(driver, Save_popup_ok);
		click(driver, Save_popup_ok);

		Fluentwait(driver, Route);
		click(driver, Route);

		wait(driver, "5");
//			
//			Fluentwait(driver, ERO_Popup_Ok);
//			click(driver, ERO_Popup_Ok);

		Fluentwait(driver, ERO_Edit);
		click(driver, ERO_Edit);

		wait(driver, "5");

		Fluentwait(driver, ERO_save);
		click(driver, ERO_save);
		wait(driver, "2");

		String save_p = getText(driver, EPO_Save_Pop);
		if (save_p.equals(save)) {

			System.out.println("Expected value :" + save_p + "Actual Value:" + save);
			Extent_pass(driver, "Expected value : " + save_p + "Actual value:" + save, test, test1);
		} else {
			System.out.println("Expected value :" + save_p + "Actual Value:" + save);
			Extent_fail(driver, "Expected value : " + save_p + "Actual value:" + save, test, test1);
		}
		Fluentwait(driver, Epo_save_OK);
		click(driver, Epo_save_OK);

		System.out.println("Testcase 104 completed");

		Fluentwait(driver, ERO_Optimizer_Close8);
		click(driver, ERO_Optimizer_Close8);

		Fluentwait(driver, ERO_Optimizer_Close3);
		click(driver, ERO_Optimizer_Close3);

		Extent_cal(test, "Testcase 105 - Ensure export excel button functionality with records displayed");
		Fluentwait(driver, Searchbox);
		sendKeys(driver, Searchbox, "Deficit and Surplus Location Identification");

		Fluentwait(driver, Selectdeficit);
		click(driver, Selectdeficit);

		wait(driver, "5");

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

//		uploadFileRobot(driver,EquimentType_Alphabets);

		String upload_EquimentType_Alphabets4 = System.getProperty("user.dir") + "/driver/MasterDownloadfile.exe "
				+ EquimentType_Alphabets;

		try {
			Runtime.getRuntime().exec(upload_EquimentType_Alphabets4);
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

		wait(driver, "3");
		Fluentwait(driver, ERO_Save);
		mouseOverAndClick(driver, ERO_Save);

		Fluentwait(driver, Save_popup_ok);
		click(driver, Save_popup_ok);

		Fluentwait(driver, Route);
		click(driver, Route);
		wait(driver, "2");
		Fluentwait(driver, Optimizer);
		click(driver, Optimizer);

		wait(driver, "2");

		Fluentwait(driver, Optimizer_Ok);
		click(driver, Optimizer_Ok);

		Set<String> oldFiles = getDirectoryFiles();

		wait(driver, "5");

		Fluentwait(driver, optimizer_export);
		click(driver, optimizer_export);

		wait(driver, "10");

		String baseFilename = "ERO Routing";

		boolean isDownloaded = isNewFileDownloaded(oldFiles, baseFilename);

		if (isDownloaded == true) {

			System.out.println("New excel file is downloaded in the downloads folder");
			Extent_pass(driver, "New excel file is downloaded in the downloads folder", test, test1);

		} else {
			System.out.println("New excel file is not downloaded");
			Extent_fail(driver, "New excel file is not downloaded", test, test1);

		}
		System.out.println("Testcase 105 completed");

		Fluentwait(driver, Optimizer_Clo);
		click(driver, Optimizer_Clo);

		Fluentwait(driver, Ero_cancle1);
		click(driver, Ero_cancle1);
		Fluentwait(driver, Defic_cancle1);
		click(driver, Defic_cancle1);

		Extent_cal(test, "Testcase 119 - Ensure missing cost column records displayed and click on optimizer button");

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

		wait(driver, "3");

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

		wait(driver, "5");
		Fluentwait(driver, ERO_Popup_Ok);
		click(driver, ERO_Popup_Ok);

		Fluentwait(driver, EPO_Missing_cost);
		click(driver, EPO_Missing_cost);

		if (isDisplayed(driver, EPO_LOCATION_FIELD)) {
			System.out.println("Missing cost page location is displayed ");
			Extent_pass(driver, "Missing cost page location is displayed ", test, test1);
		} else {

			System.out.println("Missing cost page location is not displayed  ");
			Extent_fail(driver, "Missing cost page location is not displayed  ", test, test1);
		}

		if (isDisplayed(driver, EPO_equipment_Type)) {
			System.out.println("Missing cost page Equipment type is displayed ");
			Extent_pass(driver, "Missing cost page Equipment type is displayed ", test, test1);
		} else {

			System.out.println("Missing cost page Equipment type is is not displayed ");
			Extent_fail(driver, "Missing cost page Equipment type is not displayed ", test, test1);
		}
		Fluentwait(driver, missing_close);
		click(driver, missing_close);

		System.out.println("Testcase 119 completed");

		Extent_cal(test,
				"Testcase 120 - Ensure refresh records displayed into the grid without save the records and click on optimizer button");

		Fluentwait(driver, Routing_Edit);
		click(driver, Routing_Edit);

		Fluentwait(driver, EPO_RefreshRouting);
		click(driver, EPO_RefreshRouting);
		wait(driver, "3");

		if (isDisplayed(driver, ERO_Warning_Message)) {
			System.out.println("Kindly update the missing cost information and re calculate the Cost is displayed ");
			Extent_pass(driver, "Kindly update the missing cost information and re calculate the Cost is displayed ",
					test, test1);
		} else {

			System.out
					.println("Kindly update the missing cost information and re calculate the Cost is not displayed  ");
			Extent_fail(driver,
					"Kindly update the missing cost information and re calculate the Cost is not displayed  ", test,
					test1);
		}

		Fluentwait(driver, Pop_Size_Ok);
		click(driver, Pop_Size_Ok);
		wait(driver, "2");

		System.out.println("Testcase 120 completed");

		Fluentwait(driver, ERO_Optimizer_Close2);
		click(driver, ERO_Optimizer_Close2);

		Fluentwait(driver, Defi_close);
		click(driver, Defi_close);

		Extent_cal(test,
				"Testcase 97,Ensure Optimizer button with single size type Functionality system should not allow heap memory full ");

		Fluentwait(driver, Searchbox);
		sendKeys(driver, Searchbox, "Deficit and Surplus Location Identification");

		Fluentwait(driver, Selectdeficit);
		click(driver, Selectdeficit);

		wait(driver, "5");

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

//				uploadFileRobot(driver,EquimentType_Alphabets2);

		String upload_EquimentType_Alphabets5 = System.getProperty("user.dir") + "/driver/MasterDownloadfile.exe "
				+ EquimentType_Alphabets;

		try {
			Runtime.getRuntime().exec(upload_EquimentType_Alphabets5);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getLocalizedMessage());
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
		}

		wait(driver, "25");

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
		wait(driver, "2");
		Fluentwait(driver, ERO_route);
		click(driver, ERO_route);
		wait(driver, "6");
		Fluentwait(driver, Optimizer);
		click(driver, Optimizer);
		wait(driver, "4");
		Fluentwait(driver, Optimizer_Ok);
		click(driver, Optimizer_Ok);

		wait(driver, "4");

		if (isDisplayed(driver, Opti_first)) {
			Extent_pass(driver, "After navigating to optimizer, route datas are displayed  ", test, test1);

		} else {
			Extent_fail(driver, " After navigating to optimizer,  route datas are  not displayed ", test, test1);

		}
		wait(driver, "2");

		if (isDisplayed(driver, Opti_first_Header)) {
			Extent_pass(driver, "After navigating to optimizer, route datas are displayed in the grid ", test, test1);

		} else {
			Extent_fail(driver, " After navigating to optimizer,  route datas are  not displayed in the grid ", test,
					test1);

		}

		System.out.println("Testcase 97 completed");

	}
}
