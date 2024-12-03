package ERO_Routing_Scripts;

import java.awt.Robot;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.Utils;

public class ERO_Routing_Scenario17_TC121toTC131 extends Keywords {
	
	public void ERO_Scenario17(WebDriver driver, ExtentTest test, ExtentTest test1,String url, int dataset) throws Exception {

		String Username = Utils.getDataFromTestData("ERO_Scenario17_Dataset"+dataset, "ERO Routing", "Username");
		String Password = Utils.getDataFromTestData("ERO_Scenario17_Dataset"+dataset, "ERO Routing", "Password");
		String ID = Utils.getDataFromTestData("ERO_Scenario17_Dataset"+dataset, "ERO Routing", "Id");

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

		Extent_cal(test,
				"Testcase 121 ,Ensure Origin,Delivery,Size type,Main service,Original Mode, POL, POL Terminal, POL Service,Trans1,Trans1 Terminal,Trans1 Service,Trans2,Trans2 Terminal,Trans2 Service,Trans3,Trans3 Terminal,Trans3 Service,POD,POD Terminal,Delivery,Transit Time columns records displayed  in Route Details tab");

		Fluentwait(driver, EPO_Route_Details);
		click(driver, EPO_Route_Details);

		List<String> Columnname3 = Arrays.asList("nfr_sel_col", "origin", "delivery", "sizetype", "cost", "mainservice",
				"sOrgMode", "pOL", "pOLter");

		List<String> Names3 = Arrays.asList("Select", "Origin", "Delivery", "Size Type", "Cost (USD)", "Main Service",
				"Origin Mode", "POL", "POL Terminal");

		int size = Columnname3.size();

		for (int i = 0; i < size; i++) {

			String columns3 = Columnname3.get(i);

			String Column_Name3 = Names3.get(i);

			WebElement element = driver.findElement(By.xpath("//div[@col-id='" + columns3 + "']"));
			waitForWebElement(driver, element, "Grid fields");
			act.moveToElement(element).build().perform();

			wait(driver, "5");

			if (element.isDisplayed()) {

				System.out.println("After click on Route details " + Column_Name3 + " was displayed in the grid");
				Extent_pass(driver, "After click on Route details " + Column_Name3 + " was displayed in the grid", test,
						test1);
			} else {
				System.out.println("After click on Route details " + Column_Name3 + " was not displayed in the grid");
				Extent_fail(driver, "After click on Route details " + Column_Name3 + " was not displayed in the grid",
						test, test1);
			}
		}

		List<String> Columnname = Arrays.asList("trans1", "trans1ser", "trans2", "trans2ser", "trans3", "trans3ser",
				"pOD", "pODter", "sDelMode", "transittime", "missingcost", "sRoutingFrom");

		List<String> Names = Arrays.asList("Trans1", "Trans1 Ser", "Trans2", "Trans2 Ser", "Trans3", "Trans3 Ser",
				"POD", "POD Terminal", "Delivery Mode", "Transit Days", "Missing Cost", "Routing From");

		int size1 = Columnname3.size();

		WebElement scroller = driver.findElement(By.xpath("(//div[@ref='eBodyHorizontalScrollViewport'])[2]"));

		int scrollAmount = 1000; //

		js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller, scrollAmount);

		for (int i = 0; i < size1; i++) {

			String columns3 = Columnname.get(i);

			String Column_Name3 = Names.get(i);

			WebElement element = driver.findElement(By.xpath("//div[@col-id='" + columns3 + "']"));
			waitForWebElement(driver, element, "Grid fields");
			act.moveToElement(element).build().perform();

			wait(driver, "5");

			if (element.isDisplayed()) {

				System.out.println("After click on show cost splitup " + Column_Name3 + " was displayed in the grid");
				Extent_pass(driver, "After click on show cost splitup " + Column_Name3 + " was displayed in the grid",
						test, test1);
			} else {
				System.out
						.println("After click on show cost splitup " + Column_Name3 + " was not displayed in the grid");
				Extent_fail(driver,
						"After click on show cost splitup " + Column_Name3 + " was not displayed in the grid", test,
						test1);
			}
		}

		List<String> Columnname4 = Arrays.asList("sDelMode", "transittime", "missingcost", "sRoutingFrom");

		List<String> Names4 = Arrays.asList("Delivery Mode", "Transit Days", "Missing Cost", "Routing From");

		int size4 = Columnname4.size();
		WebElement scroller4 = driver.findElement(By.xpath("(//div[@ref='eBodyHorizontalScrollViewport'])[2]"));

		int scrollAmount4 = 400; //

		js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller4, scrollAmount4);

		for (int i = 0; i < size4; i++) {

			wait(driver, "2");
			String columns3 = Columnname4.get(i);

			String Column_Name3 = Names4.get(i);

			WebElement element = driver.findElement(By.xpath("//div[@col-id='" + columns3 + "']"));
			waitForWebElement(driver, element, "Grid fields");
			act.moveToElement(element).build().perform();

			wait(driver, "5");

			if (element.isDisplayed()) {

				System.out.println("After click on show cost splitup " + Column_Name3 + " was displayed in the grid");
				Extent_pass(driver, "After click on show cost splitup " + Column_Name3 + " was displayed in the grid",
						test, test1);
			} else {
				System.out
						.println("After click on show cost splitup " + Column_Name3 + " was not displayed in the grid");
				Extent_fail(driver,
						"After click on show cost splitup " + Column_Name3 + " was not displayed in the grid", test,
						test1);
			}
		}

		System.out.println("Testcase 121 completed");

		Extent_cal(test, "Testcase 122,Ensure Missing cost column records displayed in Route Details tab ");

		Fluentwait(driver, EPO_Route_Details);
		click(driver, EPO_Route_Details);
		wait(driver, "2");
		mouseOverAndClick(driver, EPO_Missing_coat);

		if (isDisplayed(driver, EPO_Missing_coat)) {
			System.out.println("Missing cost page  is displayed ");
			Extent_pass(driver, "Missing cost page  is displayed ", test, test1);
		} else {

			System.out.println("Missing cost page  is is not displayed ");
			Extent_fail(driver, "Missing cost page  is not displayed ", test, test1);
		}

		System.out.println("Testcase 122 completed");

		Extent_cal(test, "TestCase_TC_123, Ensure Load cost column records displayed in Route Details tab");

		Fluentwait(driver, View_Cost);
		click(driver, View_Cost);
		wait(driver, "2");

		Actions action = new Actions(driver);
		List<String> Origin_values = new ArrayList<String>();
		List<String> SizeType_Values = new ArrayList<String>();
		List<String> LoadCost_Values = new ArrayList<String>();
		List<WebElement> rowlists = driver
				.findElements(By.xpath("//div[@id='ERU-ERU_treeTable1_tbl']//div[@role='rowgroup']//div[@role='row']"));
		// click(driver, SignIn);
		if (rowlists.size() > 1) {
			for (int row = 2; row <= 10; row++) {
				System.out.println("Loop started " + row);
				try {
					WebElement rowMove = driver.findElement(By.xpath(
							"//div[@id='ERU-ERU_treeTable1_tbl']//div[@role='rowgroup']/div[@role='row' and @aria-rowindex='"
									+ row + "']"));
					action.moveToElement(rowMove).build().perform();
					WebElement originRow = driver.findElement(By.xpath(
							"//div[@id='ERU-ERU_treeTable1_tbl']//div[@role='rowgroup']/div[@role='row' and @aria-rowindex='"
									+ row + "']//div[@role='gridcell' and @col-id='origin']"));
					String originRowValue = originRow.getText();
					originRowValue = getStringValue(originRowValue);
					Origin_values.add(originRowValue);
					WebElement SizeTypeRow = driver.findElement(By.xpath(
							"//div[@id='ERU-ERU_treeTable1_tbl']//div[@role='rowgroup']/div[@role='row' and @aria-rowindex='"
									+ row + "']//div[@role='gridcell' and @col-id='sizetype']"));
					String SizeTypeRowValue = SizeTypeRow.getText();
					SizeType_Values.add(SizeTypeRowValue);

					boolean ColumnLoop = true;
					int column = 2;
					while (ColumnLoop == true) {
						try {
							System.out.println("Column Loop started " + column);
							WebElement columnMove = driver.findElement(By.xpath(
									" //div[@id='ERU-ERU_treeTable1_tbl']//div[@role='rowgroup']/div[@role='row' and @aria-rowindex='"
											+ row + "']//div[@role='gridcell' and @aria-colindex='" + column + "']"));
							action.moveToElement(columnMove).build().perform();
							String col_type = columnMove.getAttribute("col-id");
							if (col_type.equals("dLoadCost")) {
								String loadValue = columnMove.getText();
								LoadCost_Values.add(loadValue);
								ColumnLoop = false;
							}
							column++;
						} catch (Exception e) {
							ColumnLoop = false;

						}
						System.out.println("Column Loop Ended " + column);
					}

				} catch (Exception e) {

				}
				HorizontalScrollFull(driver, HorizontalScrollElement);
				System.out.println("Loop Ended " + row);
				wait(driver, "6");
				HorizontalScrollFull(driver, HorizontalScrollElement1);
			}
		} else {
			System.out.println("No Rows Available to get the values");

		}

		click(driver, Search_Input);
		sendKeys(driver, Search_Input, "ERO Load Cost");
		Fluentwait(driver, Ero_value);
		click(driver, Ero_value);
		wait(driver, "2");

		for (int k = 0; k < Origin_values.size(); k++) {
			Fluentwait1(driver, Gloal_search);
			mouseOverAndClick(driver, Gloal_search);
			// mouseo(driver,Gloal_search);
			wait(driver, "2");
			Fluentwait1(driver, Location_Search);
			click(driver, Location_Search);
			sendKeys(driver, Location_Search, Origin_values.get(k));
			Fluentwait1(driver, Equipment_Type);
			click(driver, Equipment_Type);
			sendKeys(driver, Equipment_Type, SizeType_Values.get(k));
			Fluentwait1(driver, Search_OK_button);
			click(driver, Search_OK_button);
			Fluentwait1(driver, last_Option);
			List<WebElement> lastvalues = driver.findElements(By.xpath("(//div[@col-id='C1'])"));
			int lastsize = lastvalues.size();
			lastvalues.get(lastsize - 1).click();
			// click(driver,last_Option);
			Fluentwait1(driver, select_val);
			click(driver, select_val);
			String Total_value;
			try {
				Total_value = getAttribute(driver, Total_val, "value");
			} catch (StaleElementReferenceException e) {
				Total_value = getAttribute(driver, Total_val, "value");
			}
			if (LoadCost_Values.get(k).equals(Total_value)) {
				System.out.println("Value passed for -> " + Origin_values.get(k) + "  " + SizeType_Values.get(k)
						+ " Exp : " + LoadCost_Values.get(k) + ", Act : " + Total_value);
				Extent_pass(driver, "Value passed for -> " + Origin_values.get(k) + "  " + SizeType_Values.get(k)
						+ " Exp : " + LoadCost_Values.get(k) + ", Act : " + Total_value, test, test1);
			} else {
				System.out.println("Value Failed for -> " + Origin_values.get(k) + "  " + SizeType_Values.get(k)
						+ " Exp : " + LoadCost_Values.get(k) + ", Act : " + Total_value);
				Extent_fail(driver, "Value passed for -> " + Origin_values.get(k) + "  " + SizeType_Values.get(k)
						+ " Exp : " + LoadCost_Values.get(k) + ", Act : " + Total_value, test, test1);
			}
		}
		System.out.println("TC_123 completed");

		Fluentwait(driver, Defic_cancle1);
		click(driver, Defic_cancle1);

		Extent_cal(test, "TC_124, Ensure Discharge cost column records displayed  in Route Details tab");

		wait(driver, "2");

		Actions action1 = new Actions(driver);
		List<String> Origin_values1 = new ArrayList<String>();
		List<String> SizeType_Values1 = new ArrayList<String>();
		List<String> LoadCost_Values1 = new ArrayList<String>();

		List<WebElement> rowlists1 = driver
				.findElements(By.xpath("//div[@id='ERU-ERU_treeTable1_tbl']//div[@role='rowgroup']//div[@role='row']"));

		if (rowlists1.size() > 1) {
			for (int row = 2; row <= 9; row++) {
				System.out.println("Loop started " + row);
				try {
					WebElement rowMove = driver.findElement(By.xpath(
							"//div[@id='ERU-ERU_treeTable1_tbl']//div[@role='rowgroup']/div[@role='row' and @aria-rowindex='"
									+ row + "']"));
					action1.moveToElement(rowMove).build().perform();
					WebElement originRow = driver.findElement(By.xpath(
							"//div[@id='ERU-ERU_treeTable1_tbl']//div[@role='rowgroup']/div[@role='row' and @aria-rowindex='"
									+ row + "']//div[@role='gridcell' and @col-id='origin']"));
					String originRowValue = originRow.getText();
					originRowValue = getStringValue(originRowValue);
					Origin_values1.add(originRowValue);
					WebElement SizeTypeRow = driver.findElement(By.xpath(
							"//div[@id='ERU-ERU_treeTable1_tbl']//div[@role='rowgroup']/div[@role='row' and @aria-rowindex='"
									+ row + "']//div[@role='gridcell' and @col-id='sizetype']"));
					String SizeTypeRowValue = SizeTypeRow.getText();
					SizeType_Values1.add(SizeTypeRowValue);

					boolean ColumnLoop = true;
					int column = 2;
					while (ColumnLoop == true) {
						try {
							System.out.println("Column Loop started " + column);
							WebElement columnMove = driver.findElement(By.xpath(
									" //div[@id='ERU-ERU_treeTable1_tbl']//div[@role='rowgroup']/div[@role='row' and @aria-rowindex='"
											+ row + "']//div[@role='gridcell' and @aria-colindex='" + column + "']"));
							action1.moveToElement(columnMove).build().perform();
							String col_type = columnMove.getAttribute("col-id");

							if (col_type.equals("dDischDCost")) {
								String loadValue = columnMove.getText();
								LoadCost_Values1.add(loadValue);
								ColumnLoop = false;
							}
							column++;
						} catch (Exception e) {
							ColumnLoop = false;

						}
						System.out.println("Column Loop Ended " + column);
					}

				} catch (Exception e) {

				}
				HorizontalScrollFull(driver, HorizontalScrollElement);
				System.out.println("Loop Ended " + row);
				wait(driver, "6");
				HorizontalScrollFull(driver, HorizontalScrollElement1);
			}
		} else {
			System.out.println("No Rows Available to get the values");
		}
		click(driver, Search_Input);
		sendKeys(driver, Search_Input, "ERO Discharge Cost");

		Fluentwait(driver, Ero_Discharge_Cost);
		click(driver, Ero_Discharge_Cost);
		wait(driver, "2");

		for (int k = 0; k < Origin_values1.size(); k++) {

			Fluentwait1(driver, ERO_Global_Haulage1);
			mouseOverAndClick(driver, ERO_Global_Haulage1);
			wait(driver, "2");

			Fluentwait1(driver, Location_Search);
			click(driver, Location_Search);
			sendKeys(driver, Location_Search, Origin_values1.get(k));
			Fluentwait1(driver, Equipment_Type);
			click(driver, Equipment_Type);
			sendKeys(driver, Equipment_Type, SizeType_Values1.get(k));
			Fluentwait1(driver, Search_OK_button);
			click(driver, Search_OK_button);
			Fluentwait1(driver, last_Option);
			List<WebElement> lastvalues = driver.findElements(By.xpath("(//div[@col-id='C1'])"));
			int lastsize = lastvalues.size();
			lastvalues.get(lastsize - 1).click();
			// click(driver,last_Option);
			Fluentwait1(driver, select_val);
			click(driver, select_val);
			String Total_value;
			try {
				Total_value = getAttribute(driver, Total_Val1, "value");
			} catch (StaleElementReferenceException e) {
				Total_value = getAttribute(driver, Total_Val1, "value");
			}

			if (LoadCost_Values1.get(k).equals(Total_value)) {
				wait(driver, "1");

				System.out.println("Value passed for -> " + Origin_values1.get(k) + "  " + SizeType_Values1.get(k)
						+ " Exp : " + LoadCost_Values1.get(k) + ", Act : " + Total_value);
				Extent_pass(driver, "Value passed for -> " + Origin_values1.get(k) + "  " + SizeType_Values1.get(k)
						+ " Exp : " + LoadCost_Values1.get(k) + ", Act : " + Total_value, test, test1);
			} else {
				System.out.println("Value Failed for -> " + Origin_values1.get(k) + "  " + SizeType_Values1.get(k)
						+ " Exp : " + LoadCost_Values1.get(k) + ", Act : " + Total_value);
				Extent_fail(driver, "Value passed for -> " + Origin_values1.get(k) + "  " + SizeType_Values1.get(k)
						+ " Exp : " + LoadCost_Values1.get(k) + ", Act : " + Total_value, test, test1);

			}
		}
		System.out.println("Testcase 124 completed");

		Fluentwait1(driver, Ero_cancle1);
		click(driver, Ero_cancle1);

		Extent_cal(test,
				"TC_125, Ensure Ts1 Load cost,Ts2 Load cost,Ts3 Load cost,Ts1 Discharge cost,Ts2 Discharge cost,Ts3 Discharge cost column records displayed  in Route Details tab");

//		Fluentwait(driver, View_Cost);
//		click(driver, View_Cost);
		wait(driver, "2");

		Actions action4 = new Actions(driver);
		List<String> Origin_values4 = new ArrayList<String>();
		List<String> SizeType_Values4 = new ArrayList<String>();
		List<String> LoadCost_Values4 = new ArrayList<String>();
		List<String> LoadCost_Values5 = new ArrayList<String>();
		List<String> LoadCost_Values6 = new ArrayList<String>();

		List<WebElement> rowlists4 = driver
				.findElements(By.xpath("//div[@id='ERU-ERU_treeTable1_tbl']//div[@role='rowgroup']//div[@role='row']"));

		if (rowlists4.size() > 1) {
			for (int row = 2; row <= 4; row++) {
				System.out.println("Loop started " + row);
				try {
					WebElement rowMove = driver.findElement(By.xpath(
							"//div[@id='ERU-ERU_treeTable1_tbl']//div[@role='rowgroup']/div[@role='row' and @aria-rowindex='"
									+ row + "']"));
					action4.moveToElement(rowMove).build().perform();
					WebElement originRow = driver.findElement(By.xpath(
							"//div[@id='ERU-ERU_treeTable1_tbl']//div[@role='rowgroup']/div[@role='row' and @aria-rowindex='"
									+ row + "']//div[@role='gridcell' and @col-id='origin']"));
					String originRowValue = originRow.getText();
					originRowValue = getStringValue(originRowValue);
					Origin_values4.add(originRowValue);
					WebElement SizeTypeRow = driver.findElement(By.xpath(
							"//div[@id='ERU-ERU_treeTable1_tbl']//div[@role='rowgroup']/div[@role='row' and @aria-rowindex='"
									+ row + "']//div[@role='gridcell' and @col-id='sizetype']"));
					String SizeTypeRowValue = SizeTypeRow.getText();
					SizeType_Values4.add(SizeTypeRowValue);

					boolean ColumnLoop = true;
					int column = 2;
					while (ColumnLoop == true) {
						try {
							System.out.println("Column Loop started " + column);
							WebElement columnMove = driver.findElement(By.xpath(
									"//div[@id='ERU-ERU_treeTable1_tbl']//div[@role='rowgroup']/div[@role='row' and @aria-rowindex='"
											+ row + "']//div[@role='gridcell' and @aria-colindex='" + column + "']"));
							action4.moveToElement(columnMove).build().perform();
							String col_type = columnMove.getAttribute("col-id");

							if (col_type.equals("dTS1LoadCost")) {
								String loadValue = columnMove.getText();
								LoadCost_Values4.add(loadValue);
								ColumnLoop = false;
							}
							if (col_type.equals("dTS2LoadCost")) {
								String loadValue = columnMove.getText();
								LoadCost_Values5.add(loadValue);
								ColumnLoop = false;
							}
							if (col_type.equals("dTS3LoadCost")) {
								String loadValue = columnMove.getText();
								LoadCost_Values6.add(loadValue);
								ColumnLoop = false;
							}
							column++;
						} catch (Exception e) {
							ColumnLoop = false;

						}
						System.out.println("Column Loop Ended " + column);
					}

				} catch (Exception e) {

				}
				HorizontalScrollFull(driver, HorizontalScrollElement);
				System.out.println("Loop Ended " + row);
				wait(driver, "6");
				HorizontalScrollFull(driver, HorizontalScrollElement1);
			}
		} else {
			System.out.println("No Rows Available to get the values");
		}
		System.out.println("value check " + LoadCost_Values5);
		click(driver, Search_Input);
		sendKeys(driver, Search_Input, "ERO Transhipment Cost");
		Fluentwait(driver, ERO_Transhipment);
		click(driver, ERO_Transhipment);
		wait(driver, "2");
		Fluentwait(driver, ERO_Type);
		click(driver, ERO_Type);
		Fluentwait(driver, ERO_Load_Transhipment);
		click(driver, ERO_Load_Transhipment);

		System.out.println("LoadCost_Values4 : " + LoadCost_Values4);

		for (int k = 0; k < Origin_values4.size(); k++) {
			Fluentwait1(driver, ERO_Transhipment_GlobalSearch);
			mouseOverAndClick(driver, ERO_Transhipment_GlobalSearch);
			// mouseo(driver,Gloal_search);
			wait(driver, "2");
			Fluentwait1(driver, Location_Search);
			click(driver, Location_Search);
			sendKeys(driver, Location_Search, Origin_values4.get(k));
			Fluentwait1(driver, Equipment_Type);
			click(driver, Equipment_Type);
			sendKeys(driver, Equipment_Type, SizeType_Values4.get(k));
			Fluentwait1(driver, Search_OK_button);
			click(driver, Search_OK_button);
			Fluentwait1(driver, last_Option);
			List<WebElement> lastvalues = driver.findElements(By.xpath("(//div[@col-id='C1'])"));
			int lastsize = lastvalues.size();
			lastvalues.get(lastsize - 1).click();
			wait(driver, "1");
			Fluentwait1(driver, select_val);
			click(driver, select_val);
			String Total_value;
			try {
				Total_value = getAttribute(driver, ERO_Transhipment_Total, "value");
			} catch (StaleElementReferenceException e) {
				Total_value = getAttribute(driver, ERO_Transhipment_Total, "value");
			}

			if (LoadCost_Values4.get(k).equals(Total_value)) {
				System.out.println("Value passed for -> " + Origin_values4.get(k) + "  " + SizeType_Values4.get(k)
						+ " Exp : " + LoadCost_Values4.get(k) + ", Act : " + Total_value);
				Extent_pass(driver, "Value passed for -> " + Origin_values4.get(k) + "  " + SizeType_Values4.get(k)
						+ " Exp : " + LoadCost_Values4.get(k) + ", Act : " + Total_value, test, test1);
			} else {
				System.out.println("Value Failed for -> " + Origin_values4.get(k) + "  " + SizeType_Values4.get(k)
						+ " Exp : " + LoadCost_Values4.get(k) + ", Act : " + Total_value);
				Extent_fail(driver, "Value passed for -> " + Origin_values4.get(k) + "  " + SizeType_Values4.get(k)
						+ " Exp : " + LoadCost_Values4.get(k) + ", Act : " + Total_value, test, test1);

			}
		}
		System.out.println("TC_125,completed");

		Fluentwait(driver, Optimizer_Clo);
		click(driver, Optimizer_Clo);

		Extent_cal(test,
				"TC_126, Ensure Feeder cost1,Feeder cost2,Feeder cost3 cost column records displayed  in Route Details tab");

		Fluentwait(driver, View_Cost);

		click(driver, View_Cost);
		wait(driver, "2");

		Actions action7 = new Actions(driver);
		List<String> Origin_values7 = new ArrayList<String>();
		List<String> SizeType_Values7 = new ArrayList<String>();
		List<String> LoadCost_Values7 = new ArrayList<String>();
		List<String> LoadCost_Values8 = new ArrayList<String>();
		List<String> LoadCost_Values9 = new ArrayList<String>();
		List<WebElement> rowlists7 = driver
				.findElements(By.xpath("//div[@id='ERU-ERU_treeTable1_tbl']//div[@role='rowgroup']//div[@role='row']"));

		if (rowlists7.size() > 1) {
			for (int row = 2; row <= 4; row++) {
				System.out.println("Loop started " + row);
				try {
					WebElement rowMove = driver.findElement(By.xpath(
							"//div[@id='ERU-ERU_treeTable1_tbl']//div[@role='rowgroup']/div[@role='row' and @aria-rowindex='"
									+ row + "']"));
					action7.moveToElement(rowMove).build().perform();
					WebElement originRow = driver.findElement(By.xpath(
							"//div[@id='ERU-ERU_treeTable1_tbl']//div[@role='rowgroup']/div[@role='row' and @aria-rowindex='"
									+ row + "']//div[@role='gridcell' and @col-id='origin']"));
					String originRowValue = originRow.getText();
					originRowValue = getStringValue(originRowValue);
					Origin_values7.add(originRowValue);
					WebElement SizeTypeRow = driver.findElement(By.xpath(
							"//div[@id='ERU-ERU_treeTable1_tbl']//div[@role='rowgroup']/div[@role='row' and @aria-rowindex='"
									+ row + "']//div[@role='gridcell' and @col-id='sizetype']"));
					String SizeTypeRowValue = SizeTypeRow.getText();
					SizeType_Values7.add(SizeTypeRowValue);

					boolean ColumnLoop = true;
					int column = 2;
					while (ColumnLoop == true) {
						try {
							System.out.println("Column Loop started " + column);
							WebElement columnMove = driver.findElement(By.xpath(
									" //div[@id='ERU-ERU_treeTable1_tbl']//div[@role='rowgroup']/div[@role='row' and @aria-rowindex='"
											+ row + "']//div[@role='gridcell' and @aria-colindex='" + column + "']"));
							action7.moveToElement(columnMove).build().perform();
							String col_type = columnMove.getAttribute("col-id");

							if (col_type.equals("dFdrCost1")) {
								String loadValue = columnMove.getText();
								LoadCost_Values7.add(loadValue);
								ColumnLoop = false;
							}

							column++;
						} catch (Exception e) {
							ColumnLoop = false;

						}
						System.out.println("Column Loop Ended " + column);
					}

				} catch (Exception e) {

				}
				HorizontalScrollFull(driver, HorizontalScrollElement);
				System.out.println("Loop Ended " + row);
				wait(driver, "6");
				HorizontalScrollFull(driver, HorizontalScrollElement1);
			}
		} else {
			System.out.println("No Rows Available to get the values");
		}

		click(driver, Search_Input);
		sendKeys(driver, Search_Input, "ERO External Feeder Cost");
		Fluentwait(driver, ERO_External_Feeder_Cost);
		click(driver, ERO_External_Feeder_Cost);
		wait(driver, "2");
//
//		for (int k = 0; k < Origin_values7.size(); k++) {
//			Fluentwait1(driver, ERO_External_Feeder_Cost_GlobalSearch);
//			mouseOverAndClick(driver, ERO_External_Feeder_Cost_GlobalSearch);
//			// mouseo(driver,Gloal_search);
//			wait(driver, "2");
//			Fluentwait1(driver, Location_Search);
//			click(driver, Location_Search);
//			sendKeys(driver, Location_Search, Origin_values7.get(k));
//			Fluentwait1(driver, Equipment_Type);
//			click(driver, Equipment_Type);
//			sendKeys(driver, Equipment_Type, SizeType_Values7.get(k));
//			Fluentwait1(driver, Search_OK_button);
//			click(driver, Search_OK_button);
//			Fluentwait1(driver, last_Option);
//			List<WebElement> lastvalues = driver.findElements(By.xpath("(//div[@col-id='C1'])"));
//			int lastsize = lastvalues.size();
//			lastvalues.get(lastsize - 1).click();
//			wait(driver, "1");
//			Fluentwait1(driver, select_val);
//			click(driver, select_val);
//			String Total_value;
//			try {
//				Total_value = getAttribute(driver, ERO_External_Feeder_Cost_Total, "value");
//			} catch (StaleElementReferenceException e) {
//				Total_value = getAttribute(driver, ERO_External_Feeder_Cost_Total, "value");
//			}
//			if (LoadCost_Values7.get(k).equals(Total_value)) {
//				System.out.println("Value passed for -> " + Origin_values7.get(k) + "  " + SizeType_Values7.get(k)
//						+ " Exp : " + LoadCost_Values7.get(k) + ", Act : " + Total_value);
//				Extent_pass(driver, "Value passed for -> " + Origin_values7.get(k) + "  " + SizeType_Values7.get(k)
//						+ " Exp : " + LoadCost_Values7.get(k) + ", Act : " + Total_value, test, test1);
//			} else {
//				System.out.println("Value Failed for -> " + Origin_values7.get(k) + "  " + SizeType_Values7.get(k)
//						+ " Exp : " + LoadCost_Values7.get(k) + ", Act : " + Total_value);
//				Extent_fail(driver, "Value passed for -> " + Origin_values7.get(k) + "  " + SizeType_Values7.get(k)
//						+ " Exp : " + LoadCost_Values7.get(k) + ", Act : " + Total_value, test, test1);
//				
//				global = "Value passed for ->"+ Origin_values7.get(k) +""+SizeType_Values7.get(k)+" Exp : " + LoadCost_Values7.get(k) + ", Act : " + Total_value;
//			}
//		}
		System.out.println("TC_126,completed");

		Extent_cal(test,
				"TC_128, Ensure Load Haulage cost, Discharge Haulage cost, column records displayed  in Route Details tab");

		Fluentwait(driver, Routing_Tab);
		click(driver, Routing_Tab);

		Fluentwait(driver, View_Cost);
		click(driver, View_Cost);
		wait(driver, "2");

		Actions action2 = new Actions(driver);
		List<String> Origin_values2 = new ArrayList<String>();
		List<String> SizeType_Values2 = new ArrayList<String>();
		List<String> LoadCost_Values2 = new ArrayList<String>();
		List<String> LoadCost_Values3 = new ArrayList<String>();
		List<WebElement> rowlists2 = driver
				.findElements(By.xpath("//div[@id='ERU-ERU_treeTable1_tbl']//div[@role='rowgroup']//div[@role='row']"));

		if (rowlists2.size() > 1) {
			for (int row = 2; row <= 4; row++) {
				System.out.println("Loop started " + row);
				try {
					WebElement rowMove = driver.findElement(By.xpath(
							"//div[@id='ERU-ERU_treeTable1_tbl']//div[@role='rowgroup']/div[@role='row' and @aria-rowindex='"
									+ row + "']"));
					action2.moveToElement(rowMove).build().perform();
					WebElement originRow = driver.findElement(By.xpath(
							"//div[@id='ERU-ERU_treeTable1_tbl']//div[@role='rowgroup']/div[@role='row' and @aria-rowindex='"
									+ row + "']//div[@role='gridcell' and @col-id='origin']"));
					String originRowValue = originRow.getText();
					originRowValue = getStringValue(originRowValue);
					Origin_values2.add(originRowValue);
					WebElement SizeTypeRow = driver.findElement(By.xpath(
							"//div[@id='ERU-ERU_treeTable1_tbl']//div[@role='rowgroup']/div[@role='row' and @aria-rowindex='"
									+ row + "']//div[@role='gridcell' and @col-id='sizetype']"));
					String SizeTypeRowValue = SizeTypeRow.getText();
					SizeType_Values2.add(SizeTypeRowValue);

					boolean ColumnLoop = true;
					int column = 2;
					while (ColumnLoop == true) {
						try {
							System.out.println("Column Loop started " + column);
							WebElement columnMove = driver.findElement(By.xpath(
									" //div[@id='ERU-ERU_treeTable1_tbl']//div[@role='rowgroup']/div[@role='row' and @aria-rowindex='"
											+ row + "']//div[@role='gridcell' and @aria-colindex='" + column + "']"));
							action2.moveToElement(columnMove).build().perform();
							String col_type = columnMove.getAttribute("col-id");

							if (col_type.equals("dLoadHlgCost")) {
								String loadValue = columnMove.getText();
								LoadCost_Values2.add(loadValue);
								ColumnLoop = false;
							}
							if (col_type.equals("dDischHlgCost")) {
								String loadValue = columnMove.getText();
								LoadCost_Values3.add(loadValue);
								ColumnLoop = false;
							}
							column++;

						} catch (Exception e) {
							ColumnLoop = false;

						}
						System.out.println("Column Loop Ended " + column);
					}

				} catch (Exception e) {

				}
				HorizontalScrollFull(driver, HorizontalScrollElement);
				System.out.println("Loop Ended " + row);
				wait(driver, "6");
				HorizontalScrollFull(driver, HorizontalScrollElement1);
			}
		} else {
			System.out.println("No Rows Available to get the values");
		}
		click(driver, Search_Input);
		sendKeys(driver, Search_Input, "ERO Haulage Cost");
		Fluentwait(driver, ERO_Haulage_Cost);
		click(driver, ERO_Haulage_Cost);
		wait(driver, "2");

		for (int k = 0; k < Origin_values2.size(); k++) {
			Fluentwait1(driver, ERO_Global_Haulage);
			mouseOverAndClick(driver, ERO_Global_Haulage);
			// mouseo(driver,Gloal_search);
			wait(driver, "2");

			Fluentwait1(driver, Location_Search);
			click(driver, Location_Search);
			sendKeys(driver, Location_Search, Origin_values2.get(k));

			Fluentwait1(driver, Equipment_Type);
			click(driver, Equipment_Type);
			sendKeys(driver, Equipment_Type, SizeType_Values2.get(k));

			Fluentwait1(driver, Search_OK_button);
			click(driver, Search_OK_button);

			Fluentwait1(driver, last_Option);
			List<WebElement> lastvalues = driver.findElements(By.xpath("(//div[@col-id='C1'])"));
			int lastsize = lastvalues.size();
			lastvalues.get(lastsize - 1).click();
			// click(driver,last_Option);
			Fluentwait1(driver, select_val);
			click(driver, select_val);
			String Total_value;
			try {
				Total_value = getAttribute(driver, ERO_Haulage_Total, "value");
			} catch (StaleElementReferenceException e) {
				Total_value = getAttribute(driver, ERO_Haulage_Total, "value");
			}
			if (LoadCost_Values2.get(k).equals(Total_value)) {
				System.out.println("Value passed for -> " + Origin_values2.get(k) + "  " + SizeType_Values2.get(k)
						+ " Exp : " + LoadCost_Values2.get(k) + ", Act : " + Total_value);
				Extent_pass(driver, "Value passed for -> " + Origin_values2.get(k) + "  " + SizeType_Values2.get(k)
						+ " Exp : " + LoadCost_Values2.get(k) + ", Act : " + Total_value, test, test1);
			} else {
				System.out.println("Value Failed for -> " + Origin_values2.get(k) + "  " + SizeType_Values2.get(k)
						+ " Exp : " + LoadCost_Values2.get(k) + ", Act : " + Total_value);
				Extent_fail(driver, "Value passed for -> " + Origin_values2.get(k) + "  " + SizeType_Values2.get(k)
						+ " Exp : " + LoadCost_Values2.get(k) + ", Act : " + Total_value, test, test1);
			}
			if (LoadCost_Values3.get(k).equals(Total_value)) {
				System.out.println("Value passed for -> " + Origin_values2.get(k) + "  " + SizeType_Values2.get(k)
						+ " Exp : " + LoadCost_Values3.get(k) + ", Act : " + Total_value);
				Extent_pass(driver, "Value passed for -> " + Origin_values2.get(k) + "  " + SizeType_Values2.get(k)
						+ " Exp : " + LoadCost_Values3.get(k) + ", Act : " + Total_value, test, test1);
			} else {
				System.out.println("Value Failed for -> " + Origin_values2.get(k) + "  " + SizeType_Values2.get(k)
						+ " Exp : " + LoadCost_Values3.get(k) + ", Act : " + Total_value);
				Extent_fail(driver, "Value passed for -> " + Origin_values2.get(k) + "  " + SizeType_Values2.get(k)
						+ " Exp : " + LoadCost_Values3.get(k) + ", Act : " + Total_value, test, test1);

			}
		}
		System.out.println("TC_128,completed");

		Fluentwait(driver, Optimizer_Clo);
		click(driver, Optimizer_Clo);

		Extent_cal(test, "Testcase 130,Ensure Cost (Amount in USD) column records displayed in Route Details tab");

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

		Fluentwait(driver, ERO_Popup_Ok);
		click(driver, ERO_Popup_Ok);

		Fluentwait(driver, View_Cost);
		click(driver, View_Cost);
		wait(driver, "2");

		String cost_value = driver.findElement(By.xpath("(//div[@col-id='cost' and @role='gridcell'])[1]")).getText();
		System.out.println("cost_value " + cost_value);

		wait(driver, "1");

		WebElement scroller5 = driver.findElement(By.xpath("(//div[@ref='eBodyHorizontalScrollViewport'])[2]"));

		int scrollAmount1 = 2000;

		js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller5, scrollAmount1);

		String Load_Cost = driver.findElement(By.xpath("//div[@row-index='0']//div[@col-id='dLoadCost']")).getText();
		double LoadCost = 0;
		if (!Load_Cost.isEmpty()) {
			LoadCost = Double.valueOf(Load_Cost);
			System.out.println("cost_value " + Load_Cost);
		}

		String Disch_Cost = driver.findElement(By.xpath("//div[@row-index='0']//div[@col-id='dDischDCost']")).getText();
		double DischCost = 0;
		if (!Disch_Cost.isEmpty()) {
			DischCost = Double.valueOf(Disch_Cost);
			System.out.println("cost_value " + Disch_Cost);
		}

		String Ts1_Load_Cost = driver.findElement(By.xpath("//div[@row-index='0']//div[@col-id='dTS1LoadCost']"))
				.getText();
		double Ts1Load_Cost = 0;
		if (!Ts1_Load_Cost.isEmpty()) {
			Ts1Load_Cost = Double.valueOf(Ts1_Load_Cost);
			System.out.println("cost_value " + Ts1_Load_Cost);
		}

		String Ts2_Load_Cost = driver.findElement(By.xpath("//div[@row-index='0']//div[@col-id='dTS2LoadCost']"))
				.getText();
		double Ts2Load_Cost = 0;
		if (!Ts2_Load_Cost.isEmpty()) {
			Ts2Load_Cost = Double.valueOf(Ts2_Load_Cost);
			System.out.println("cost_value " + Ts2_Load_Cost);
		}

		String Ts3_Load_Cost = driver.findElement(By.xpath("//div[@row-index='0']//div[@col-id='dTS3LoadCost']"))
				.getText();
		double Ts3Load_Cost = 0;
		if (!Ts3_Load_Cost.isEmpty()) {
			Ts3Load_Cost = Double.valueOf(Ts3_Load_Cost);
			System.out.println("cost_value " + Ts3_Load_Cost);
		}

		int scrollAmount2 = 1500;
		js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller, scrollAmount2);

		String Ts1_Disch_Cost = driver.findElement(By.xpath("//div[@row-index='0']//div[@col-id='dTS1DischCost']"))
				.getText();
		double Ts1Disch_Cost = 0;
		if (!Ts1_Disch_Cost.isEmpty()) {
			Ts1Disch_Cost = Double.valueOf(Ts1_Disch_Cost);
			System.out.println("cost_value " + Ts1_Disch_Cost);
		}

		String Ts2_Disch_Cost = driver.findElement(By.xpath("//div[@row-index='0']//div[@col-id='dTS2DischCost']"))
				.getText();
		double Ts2Disch_Cost = 0;
		if (!Ts2_Disch_Cost.isEmpty()) {
			Ts2Disch_Cost = Double.valueOf(Ts2_Disch_Cost);
			System.out.println("cost_value " + Ts2_Disch_Cost);
		}

		String Ts3_Disch_Cost = driver.findElement(By.xpath("//div[@row-index='0']//div[@col-id='dTS3DischCost']"))
				.getText();
		double Ts3Disch_Cost = 0;
		if (!Ts3_Disch_Cost.isEmpty()) {
			Ts3Disch_Cost = Double.valueOf(Ts3_Disch_Cost);
			System.out.println("cost_value " + Ts3_Disch_Cost);
		}
		wait(driver, "2");
		int scrollAmount3 = 500;
		js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller, scrollAmount3);

		String Feeder_Cost1 = driver.findElement(By.xpath("//div[@row-index='0']//div[@col-id='dFdrCost1']")).getText();
		double FeederCost1 = 0;
		if (!Feeder_Cost1.isEmpty()) {
			FeederCost1 = Double.valueOf(Feeder_Cost1);
			System.out.println("cost_value " + Feeder_Cost1);
		}

		String Feeder_1_terms = driver.findElement(By.xpath("//div[@row-index='0']//div[@col-id='sLoadSector']"))
				.getText();
		double Feeder1terms = 0;
		if (!Feeder_1_terms.isEmpty()) {
			Feeder1terms = Double.valueOf(Feeder_1_terms);
			System.out.println("cost_value " + Feeder_1_terms);
		}

		String Feeder_Cost2 = driver.findElement(By.xpath("//div[@row-index='0']//div[@col-id='dFdrCost2']")).getText();
		double FeederCost2 = 0;
		if (!Feeder_Cost2.isEmpty()) {
			FeederCost2 = Double.valueOf(Feeder_Cost2);
			System.out.println("cost_value " + Feeder_Cost2);
		}

		// line
		String Feeder_2_terms = driver.findElement(By.xpath("//div[@row-index='0']//div[@col-id='sDischSector']"))
				.getText();
		double Feeder2_terms = 0;
		if (!Feeder_2_terms.isEmpty()) {
			Feeder2_terms = Double.valueOf(Feeder_2_terms);
			System.out.println("cost_value " + Feeder_2_terms);
		}

		wait(driver, "2");
		int scrollAmount5 = 500;
		js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller, scrollAmount5);

		String Feeder_Cost3 = driver.findElement(By.xpath("//div[@row-index='0']//div[@col-id='dFdrCost3']")).getText();
		double FeederCost3 = 0;
		if (!Feeder_Cost3.isEmpty()) {
			FeederCost3 = Double.valueOf(Feeder_Cost3);
			System.out.println("cost_value " + Feeder_Cost3);
		}

		// line
		String Feeder_3_terms = driver.findElement(By.xpath("//div[@row-index='0']//div[@col-id='sLoadTCA']"))
				.getText();
		double Feeder3_terms = 0;
		if (!Feeder_3_terms.isEmpty()) {
			Feeder3_terms = Double.valueOf(Feeder_3_terms);
			System.out.println("cost_value " + Feeder_3_terms);
		}

		String Load_Haulage_Cost = driver.findElement(By.xpath("//div[@row-index='0']//div[@col-id='dLoadHlgCost']"))
				.getText();
		double LoadHaulage_Cost = 0;
		if (!Load_Haulage_Cost.isEmpty()) {
			LoadHaulage_Cost = Double.valueOf(Load_Haulage_Cost);
			System.out.println("cost_value " + Load_Haulage_Cost);
		}

		String Disch_Haulage_Cost = driver.findElement(By.xpath("//div[@row-index='0']//div[@col-id='dDischHlgCost']"))
				.getText();
		double DischHaulage_Cost = 0;
		if (!Disch_Haulage_Cost.isEmpty()) {
			DischHaulage_Cost = Double.valueOf(Disch_Haulage_Cost);
			System.out.println("cost_value " + Disch_Haulage_Cost);
		}

		int scrollAmount15 = 500;
		js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller, scrollAmount15);

		String DPH_Origin_Cost = driver.findElement(By.xpath("//div[@row-index='0']//div[@col-id='dIntFdrCost1']"))
				.getText();
		double DPHOrigin_Cost = 0;
		if (!DPH_Origin_Cost.isEmpty()) {
			DPHOrigin_Cost = Double.valueOf(DPH_Origin_Cost);
			System.out.println("cost_value " + DPH_Origin_Cost);
		}

		String DPH_Destination_Cost = driver.findElement(By.xpath("//div[@row-index='0']//div[@col-id='dIntFdrCost2']"))
				.getText();
		double DPHDestination_Cost = 0;
		if (!DPH_Destination_Cost.isEmpty()) {
			DPHDestination_Cost = Double.valueOf(DPH_Destination_Cost);
			System.out.println("cost_value " + DPH_Destination_Cost);
		}

		String LTC_Origin_Cost = driver.findElement(By.xpath("//div[@row-index='0']//div[@col-id='dIntFdrCost3']"))
				.getText();
		double LTCOrigin_Cost = 0;
		if (!LTC_Origin_Cost.isEmpty()) {
			LTCOrigin_Cost = Double.valueOf(LTC_Origin_Cost);
			System.out.println("cost_value " + LTC_Origin_Cost);
		}

		String LTC_Destination_Cost = driver.findElement(By.xpath("//div[@row-index='0']//div[@col-id='dIntFdrCost4']"))
				.getText();
		double LTCDestination_Cost = 0;
		if (!LTC_Destination_Cost.isEmpty()) {
			LTCDestination_Cost = Double.valueOf(LTC_Destination_Cost);
			System.out.println("cost_value " + LTC_Destination_Cost);
		}

		int scrollAmount6 = 500;
		js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller, scrollAmount6);

		String On_Hire_Cost = driver.findElement(By.xpath("//div[@row-index='0']//div[@col-id='dITT1Cost']")).getText();
		double OnHire_Cost = 0;
		if (!On_Hire_Cost.isEmpty()) {
			OnHire_Cost = Double.valueOf(On_Hire_Cost);
			System.out.println("cost_value " + On_Hire_Cost);
		}

		String Off_Hire_Cost = driver.findElement(By.xpath("//div[@row-index='0']//div[@col-id='dITT2Cost']"))
				.getText();
		double OffHire_Cost = 0;
		if (!Off_Hire_Cost.isEmpty()) {
			OffHire_Cost = Double.valueOf(Off_Hire_Cost);
			System.out.println("cost_value " + Off_Hire_Cost);
		}

		String In_Service_Destination_Cost = driver
				.findElement(By.xpath("//div[@row-index='0']//div[@col-id='dOthersCost']")).getText();
		double InService_Destination_Cost = 0;
		if (!In_Service_Destination_Cost.isEmpty()) {
			InService_Destination_Cost = Double.valueOf(In_Service_Destination_Cost);
			System.out.println("cost_value " + In_Service_Destination_Cost);
		}

		double overallcost = LoadCost + DischCost + Ts1Load_Cost + Ts2Load_Cost + Ts3Load_Cost + Ts1Disch_Cost
				+ Ts2Disch_Cost + Ts3Disch_Cost + FeederCost1 + FeederCost2 + Feeder2_terms + FeederCost3
				+ Feeder3_terms + LoadHaulage_Cost + DischHaulage_Cost + DPHOrigin_Cost + DPHDestination_Cost
				+ LTCOrigin_Cost + LTCDestination_Cost + OnHire_Cost + OffHire_Cost + InService_Destination_Cost
				+ Feeder1terms;

		String additioncost = String.valueOf(overallcost);

		if (additioncost.equals(cost_value)) {

			Extent_pass(driver, "expetced value:" + cost_value + "actual value was:" + additioncost, test, test1);

		} else {

			Extent_fail(driver, "expetced value:" + cost_value + "actual value was:" + additioncost, test, test1);
		}
		System.out.println("Testcase 130, completed");

		Extent_cal(test,
				"Testcase 131,Ensure Load region,Load Country,Origin,Delivery,Discharge country,Discharge Region,Equipment type column records displayed in unavailable  route tab");

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

		Fluentwait(driver, ERO_Popup_Ok);
		click(driver, ERO_Popup_Ok);
		Fluentwait(driver, EPO_unavailable);
		click(driver, EPO_unavailable);

		if (isDisplayed(driver, ERO_Unavailable_Load_Region)) {

			System.out.println("After click on Un available button  Load region was displayed in the grid");
			Extent_pass(driver, "After click on Un available button  Load region was displayed in the grid", test,
					test1);
		} else {
			System.out.println("After click on Un available button  Load region was not displayed in the grid");
			Extent_fail(driver, "After click on Un available button  Load region was not displayed in the grid", test,
					test1);
		}

		if (isDisplayed(driver, ERO_Unavailable_Load_Country)) {

			System.out.println("After click on Un available button  Load region was displayed in the grid");
			Extent_pass(driver, "After click on Un available button  Load region was displayed in the grid", test,
					test1);
		} else {
			System.out.println("After click on Un available button  Load region was not displayed in the grid");
			Extent_fail(driver, "After click on Un available button  Load region was not displayed in the grid", test,
					test1);
		}
		if (isDisplayed(driver, ERO_Unavailable_Load_Origin)) {

			System.out.println("After click on Un available button  Load region was displayed in the grid");
			Extent_pass(driver, "After click on Un available button  Load region was displayed in the grid", test,
					test1);
		} else {
			System.out.println("After click on Un available button  Load region was not displayed in the grid");
			Extent_fail(driver, "After click on Un available button  Load region was not displayed in the grid", test,
					test1);
		}
		if (isDisplayed(driver, ERO_Unavailable_Load_Delivery)) {

			System.out.println("After click on Un available button  Load region was displayed in the grid");
			Extent_pass(driver, "After click on Un available button  Load region was displayed in the grid", test,
					test1);
		} else {
			System.out.println("After click on Un available button  Load region was not displayed in the grid");
			Extent_fail(driver, "After click on Un available button  Load region was not displayed in the grid", test,
					test1);
		}
		if (isDisplayed(driver, ERO_Unavailable_Load_Disch)) {

			System.out.println("After click on Un available button  Load region was displayed in the grid");
			Extent_pass(driver, "After click on Un available button  Load region was displayed in the grid", test,
					test1);
		} else {
			System.out.println("After click on Un available button  Load region was not displayed in the grid");
			Extent_fail(driver, "After click on Un available button  Load region was not displayed in the grid", test,
					test1);
		}
		if (isDisplayed(driver, ERO_Unavailable_Load_Disch_Region)) {

			System.out.println("After click on Un available button  Load region was displayed in the grid");
			Extent_pass(driver, "After click on Un available button  Load region was displayed in the grid", test,
					test1);
		} else {
			System.out.println("After click on Un available button  Load region was not displayed in the grid");
			Extent_fail(driver, "After click on Un available button  Load region was not displayed in the grid", test,
					test1);
		}

		System.out.println("Testcase 131 completed");
		
		
		
		
		
	}

}
