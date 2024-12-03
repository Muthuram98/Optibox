package ERO_Routing_Scripts;

import java.awt.Robot;
import java.io.IOException;
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

public class ERO_Routing_Scenario28_TC237toTC243 extends Keywords {
	@SuppressWarnings("deprecation")
	public void ERO_Routing_Scenario28(WebDriver driver, ExtentTest test, ExtentTest test1, String url, int dataset)
			throws Exception {

		String Username = Utils.getDataFromTestData("ERO_Scenario28_Dataset" + dataset, "ERO Routing", "Username");
		String Password = Utils.getDataFromTestData("ERO_Scenario28_Dataset" + dataset, "ERO Routing", "Password");
		String ID = Utils.getDataFromTestData("ERO_Scenario28_Dataset" + dataset, "ERO Routing", "Id");

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

		wait(driver, "10");

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

		wait(driver, "3");

		Extent_cal(test, "TC_237,Ensure the All Equipment Reposition for all size type Location column");

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
		Fluentwait(driver, ERo_SizeType_drop);
		click(driver, ERo_SizeType_drop);
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		wait(driver, "1");
		Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver, EPO_SelectFilterSearchBox);
		Fluentwait(driver, ERO_Size_Type_first);
		click(driver, ERO_Size_Type_first);
		wait(driver, "1");
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		wait(driver, "1");

		Actions actio11 = new Actions(driver);
		List<String> Origin_values11 = new ArrayList<String>();
		List<String> LoadCost_Values11 = new ArrayList<String>();

		List<WebElement> rowlists10 = driver
				.findElements(By.xpath("//div[@id='ERU-ERU_treeTable1_tbl']//div[@role='rowgroup']//div[@role='row']"));

		if (rowlists10.size() > 1) {

			for (int row = 2; row <= 10; row++) {

				System.out.println("Loop started " + row);
				try {
					WebElement originRow = driver.findElement(By.xpath(
							"//div[@id='ERU-ERU_treeTable1_tbl']//div[@role='rowgroup']/div[@role='row' and @aria-rowindex='"
									+ row + "']//div[@role='gridcell' and @col-id='origin']"));
					String originRowValue = originRow.getText();
					originRowValue = getStringValue(originRowValue);
					Origin_values11.add(originRowValue);

					boolean ColumnLoop = true;
					int column = 2;
					while (ColumnLoop == true) {
						try {
							System.out.println("Column Loop started " + column);
							WebElement columnMove = driver.findElement(By.xpath(
									" //div[@id='ERU-ERU_treeTable1_tbl']//div[@role='rowgroup']/div[@role='row' and @aria-rowindex='"
											+ row + "']//div[@role='gridcell' and @aria-colindex='" + column + "']"));
							actio11.moveToElement(columnMove).build().perform();
							String col_type = columnMove.getAttribute("col-id");

							if (col_type.equals("origin")) {
								String loadValue = columnMove.getText();
								LoadCost_Values11.add(loadValue);
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
			}
		} else {
			System.out.println("No Rows Available to get the values");
		}

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
		wait(driver, "1");
		List<String> Origin_values12 = new ArrayList<String>();

		List<String> LoadCost_Values12 = new ArrayList<String>();
		List<WebElement> rowlists11 = driver
				.findElements(By.xpath("//tbody[@id='OPT-OPT_treeTable_data']//following::tr[@role='row']"));

		System.out.println("rowlists11.size(): " + rowlists11.size());

		if (rowlists11.size() > 1) {
			for (int row = 2; row <= 4; row++) {
				System.out.println("Loop started " + row);
				try {

					WebElement originRow = driver.findElement(By.xpath("((//tr[@data-ri='" + row + "'])[1]//td)[1]"));
					String originRowValue1 = originRow.getText();

					for (String expected1 : LoadCost_Values11) {

						if (expected1.contains(originRowValue1)) {
							System.out
									.println("Value passed for ->  Exp : " + expected1 + ", Act : " + originRowValue1);
							Extent_pass(driver, "Value passed for -> Exp : " + expected1 + ", Act : " + originRowValue1,
									test, test1);
						} else {
							System.out
									.println("Value Failed for ->  Exp : " + expected1 + ", Act : " + originRowValue1);
							Extent_fail(driver,
									"Value passed for ->  Exp : " + expected1 + ", Act : " + originRowValue1, test,
									test1);
						}
					}

					originRowValue1 = getStringValue(originRowValue1);
					Origin_values12.add(originRowValue1);

					System.out.println("check origin values " + Origin_values12);
				} catch (Exception e) {

				}
			}
		} else {
			System.out.println("No Rows Available to get the values");
		}
		wait(driver, "2");

		Fluentwait(driver, Defic_cancle1);
		click(driver, Defic_cancle1);

		Fluentwait(driver, ERo_SizeType_drop);
		click(driver, ERo_SizeType_drop);
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		wait(driver, "1");
		Fluentwait(driver, ERo_SizeType_drop);
		click(driver, ERo_SizeType_drop);
		Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver, EPO_SelectFilterSearchBox);
		Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver, EPO_SelectFilterSearchBox);
		wait(driver, "2");
		Fluentwait(driver, ERO_Size_Type_second);
		click(driver, ERO_Size_Type_second);
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);

		Actions action_val = new Actions(driver);
		List<String> Origin_val = new ArrayList<String>();
		List<String> LoadCost_Val = new ArrayList<String>();

		List<WebElement> rowlists_val = driver
				.findElements(By.xpath("//div[@id='ERU-ERU_treeTable1_tbl']//div[@role='rowgroup']//div[@role='row']"));

		if (rowlists_val.size() > 1) {

			for (int row = 2; row <= 4; row++) {

				System.out.println("Loop started " + row);
				try {
					WebElement originRow = driver.findElement(By.xpath(
							"//div[@id='ERU-ERU_treeTable1_tbl']//div[@role='rowgroup']/div[@role='row' and @aria-rowindex='"
									+ row + "']//div[@role='gridcell' and @col-id='origin']"));
					String originRowValue = originRow.getText();
					originRowValue = getStringValue(originRowValue);
					Origin_val.add(originRowValue);

					boolean ColumnLoop = true;
					int column = 2;
					while (ColumnLoop == true) {
						try {
							System.out.println("Column Loop started " + column);
							WebElement columnMove = driver.findElement(By.xpath(
									" //div[@id='ERU-ERU_treeTable1_tbl']//div[@role='rowgroup']/div[@role='row' and @aria-rowindex='"
											+ row + "']//div[@role='gridcell' and @aria-colindex='" + column + "']"));
							action_val.moveToElement(columnMove).build().perform();
							String col_type = columnMove.getAttribute("col-id");

							if (col_type.equals("origin")) {
								String loadValue = columnMove.getText();
								LoadCost_Val.add(loadValue);
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
			}
		} else {
			System.out.println("No Rows Available to get the values");
		}
		Fluentwait(driver, Optimizer);
		click(driver, Optimizer);
		wait(driver, "2");
		Fluentwait(driver, Optimizer_Ok);
		click(driver, Optimizer_Ok);

		wait(driver, "1");
		Fluentwait(driver, ERO_20HC);
		click(driver, ERO_20HC);

		List<String> Origin_val1 = new ArrayList<String>();

		List<String> LoadCost_Val1 = new ArrayList<String>();
		List<WebElement> rowlists_Val1 = driver
				.findElements(By.xpath("//tbody[@id='OPT-OPT_treeTable_data']//following::tr[@role='row']"));

		if (rowlists_Val1.size() > 1) {
			for (int row = 2; row <= 4; row++) {
				System.out.println("Loop started " + row);
				try {

					WebElement originRow = driver.findElement(By.xpath("((//tr[@data-ri='" + row + "'])[1]//td)[1]"));
					String Origin_valu1 = originRow.getText();

					for (String expected1 : LoadCost_Val) {

						if (expected1.contains(Origin_valu1)) {
							System.out.println("Value passed for ->  Exp : " + expected1 + ", Act : " + Origin_valu1);
							Extent_pass(driver, "Value passed for -> Exp : " + expected1 + ", Act : " + Origin_valu1,
									test, test1);
						} else {
							System.out.println("Value Failed for ->  Exp : " + expected1 + ", Act : " + Origin_valu1);
							Extent_fail(driver, "Value passed for ->  Exp : " + expected1 + ", Act : " + Origin_valu1,
									test, test1);
						}
					}

					Origin_valu1 = getStringValue(Origin_valu1);
					Origin_val1.add(Origin_valu1);

				} catch (Exception e) {

				}
			}
		} else {
			System.out.println("No Rows Available to get the values");
		}

		Fluentwait(driver, ERO_Optimizer_Close6);
		click(driver, ERO_Optimizer_Close6);

		Fluentwait(driver, ERo_SizeType_drop);
		click(driver, ERo_SizeType_drop);
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		wait(driver, "1");
		Fluentwait(driver, ERo_SizeType_drop);
		click(driver, ERo_SizeType_drop);
		Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver, EPO_SelectFilterSearchBox);
		Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver, EPO_SelectFilterSearchBox);
		wait(driver, "2");
		Fluentwait(driver, ERO_Size_Type_3);
		click(driver, ERO_Size_Type_3);
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);

		Actions action_val2 = new Actions(driver);
		List<String> Origin_val2 = new ArrayList<String>();
		List<String> LoadCost_Val2 = new ArrayList<String>();

		List<WebElement> rowlists_val2 = driver
				.findElements(By.xpath("//div[@id='ERU-ERU_treeTable1_tbl']//div[@role='rowgroup']//div[@role='row']"));

		if (rowlists_val2.size() > 1) {

			for (int row = 2; row <= 6; row++) {

				System.out.println("Loop started " + row);
				try {
					WebElement originRow = driver.findElement(By.xpath(
							"//div[@id='ERU-ERU_treeTable1_tbl']//div[@role='rowgroup']/div[@role='row' and @aria-rowindex='"
									+ row + "']//div[@role='gridcell' and @col-id='origin']"));
					String originRowValue = originRow.getText();
					originRowValue = getStringValue(originRowValue);
					Origin_val2.add(originRowValue);

					boolean ColumnLoop = true;
					int column = 2;
					while (ColumnLoop == true) {
						try {
							System.out.println("Column Loop started " + column);
							WebElement columnMove = driver.findElement(By.xpath(
									" //div[@id='ERU-ERU_treeTable1_tbl']//div[@role='rowgroup']/div[@role='row' and @aria-rowindex='"
											+ row + "']//div[@role='gridcell' and @aria-colindex='" + column + "']"));
							action_val2.moveToElement(columnMove).build().perform();
							String col_type = columnMove.getAttribute("col-id");

							if (col_type.equals("origin")) {
								String loadValue = columnMove.getText();
								LoadCost_Val2.add(loadValue);
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
			}
		} else {
			System.out.println("No Rows Available to get the values");
		}

		Fluentwait(driver, Optimizer);
		click(driver, Optimizer);
		wait(driver, "2");
		Fluentwait(driver, Optimizer_Ok);
		click(driver, Optimizer_Ok);

		wait(driver, "1");
		Fluentwait(driver, ERO_20HH);
		click(driver, ERO_20HH);

		List<String> Origin_val3 = new ArrayList<String>();
		List<String> LoadCost_Val3 = new ArrayList<String>();
		List<WebElement> rowlists_Val3 = driver
				.findElements(By.xpath("//tbody[@id='OPT-OPT_treeTable_data']//following::tr[@role='row']"));

		if (rowlists_Val3.size() > 1) {
			for (int row = 2; row <= 4; row++) {
				System.out.println("Loop started " + row);
				try {

					WebElement originRow = driver.findElement(By.xpath("((//tr[@data-ri='" + row + "'])[1]//td)[1]"));
					String Origin_valu3 = originRow.getText();

					for (String expected1 : LoadCost_Val2) {

						if (expected1.contains(Origin_valu3)) {
							System.out.println("Value passed for ->  Exp : " + expected1 + ", Act : " + Origin_valu3);
							Extent_pass(driver, "Value passed for -> Exp : " + expected1 + ", Act : " + Origin_valu3,
									test, test1);
						} else {
							System.out.println("Value Failed for ->  Exp : " + expected1 + ", Act : " + Origin_valu3);
							Extent_fail(driver, "Value passed for ->  Exp : " + expected1 + ", Act : " + Origin_valu3,
									test, test1);
						}
					}

					Origin_valu3 = getStringValue(Origin_valu3);
					Origin_val3.add(Origin_valu3);

				} catch (Exception e) {

				}
			}
		} else {
			System.out.println("No Rows Available to get the values");
		}

		Fluentwait(driver, Defic_cancle2);
		click(driver, Defic_cancle2);

		Fluentwait(driver, ERo_SizeType_drop);
		click(driver, ERo_SizeType_drop);
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		wait(driver, "1");
		Fluentwait(driver, ERo_SizeType_drop);
		click(driver, ERo_SizeType_drop);
		Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver, EPO_SelectFilterSearchBox);
		Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver, EPO_SelectFilterSearchBox);
		wait(driver, "2");
		Fluentwait(driver, ERO_Size_Type_4);
		click(driver, ERO_Size_Type_4);
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);

		Actions action_val3 = new Actions(driver);
		List<String> Origin_valu3 = new ArrayList<String>();
		List<String> LoadCost_Value3 = new ArrayList<String>();

		List<WebElement> rowlists_val3 = driver
				.findElements(By.xpath("//div[@id='ERU-ERU_treeTable1_tbl']//div[@role='rowgroup']//div[@role='row']"));

		if (rowlists_val3.size() > 1) {

			for (int row = 2; row <= 6; row++) {

				System.out.println("Loop started " + row);
				try {
					WebElement originRow = driver.findElement(By.xpath(
							"//div[@id='ERU-ERU_treeTable1_tbl']//div[@role='rowgroup']/div[@role='row' and @aria-rowindex='"
									+ row + "']//div[@role='gridcell' and @col-id='origin']"));
					String originRowValue = originRow.getText();
					originRowValue = getStringValue(originRowValue);
					Origin_valu3.add(originRowValue);

					boolean ColumnLoop = true;
					int column = 2;
					while (ColumnLoop == true) {
						try {
							System.out.println("Column Loop started " + column);
							WebElement columnMove = driver.findElement(By.xpath(
									" //div[@id='ERU-ERU_treeTable1_tbl']//div[@role='rowgroup']/div[@role='row' and @aria-rowindex='"
											+ row + "']//div[@role='gridcell' and @aria-colindex='" + column + "']"));
							action_val3.moveToElement(columnMove).build().perform();
							String col_type = columnMove.getAttribute("col-id");

							if (col_type.equals("origin")) {
								String loadValue = columnMove.getText();
								LoadCost_Value3.add(loadValue);
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
			}
		} else {
			System.out.println("No Rows Available to get the values");
		}
		Fluentwait(driver, Optimizer);
		click(driver, Optimizer);
		wait(driver, "2");
		Fluentwait(driver, Optimizer_Ok);
		click(driver, Optimizer_Ok);
		wait(driver, "1");
		Fluentwait(driver, ERO_20RF);
		click(driver, ERO_20RF);

		List<String> Origin_val4 = new ArrayList<String>();
		List<String> LoadCost_Val4 = new ArrayList<String>();
		List<WebElement> rowlists_Val4 = driver
				.findElements(By.xpath("//tbody[@id='OPT-OPT_treeTable_data']//following::tr[@role='row']"));

		if (rowlists_Val4.size() > 1) {
			for (int row = 2; row <= 4; row++) {
				System.out.println("Loop started " + row);
				try {

					WebElement originRow = driver.findElement(By.xpath("((//tr[@data-ri='" + row + "'])[1]//td)[1]"));
					String Origin_valu4 = originRow.getText();

					for (String expected1 : LoadCost_Value3) {

						if (expected1.contains(Origin_valu4)) {
							System.out.println("Value passed for ->  Exp : " + expected1 + ", Act : " + Origin_valu4);
							Extent_pass(driver, "Value passed for -> Exp : " + expected1 + ", Act : " + Origin_valu4,
									test, test1);
						} else {
							System.out.println("Value Failed for ->  Exp : " + expected1 + ", Act : " + Origin_valu4);
							Extent_fail(driver, "Value passed for ->  Exp : " + expected1 + ", Act : " + Origin_valu4,
									test, test1);
						}
					}

					Origin_valu4 = getStringValue(Origin_valu4);
					Origin_val4.add(Origin_valu4);

				} catch (Exception e) {

				}
			}
		} else {
			System.out.println("No Rows Available to get the values");
		}

		Fluentwait(driver, Ero_cancle2);
		click(driver, Ero_cancle2);

		Fluentwait(driver, ERo_SizeType_drop);
		click(driver, ERo_SizeType_drop);
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		wait(driver, "1");
		Fluentwait(driver, ERo_SizeType_drop);
		click(driver, ERo_SizeType_drop);
		Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver, EPO_SelectFilterSearchBox);
		Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver, EPO_SelectFilterSearchBox);
		wait(driver, "2");
		Fluentwait(driver, ERO_Size_Type_5);
		click(driver, ERO_Size_Type_5);
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);

		Actions action_val4 = new Actions(driver);
		List<String> Origin_valu4 = new ArrayList<String>();
		List<String> LoadCost_Value4 = new ArrayList<String>();

		List<WebElement> rowlists_val4 = driver
				.findElements(By.xpath("//div[@id='ERU-ERU_treeTable1_tbl']//div[@role='rowgroup']//div[@role='row']"));

		if (rowlists_val4.size() > 1) {

			for (int row = 2; row <= 6; row++) {

				System.out.println("Loop started " + row);
				try {
					WebElement originRow = driver.findElement(By.xpath(
							"//div[@id='ERU-ERU_treeTable1_tbl']//div[@role='rowgroup']/div[@role='row' and @aria-rowindex='"
									+ row + "']//div[@role='gridcell' and @col-id='origin']"));
					String originRowValue = originRow.getText();
					originRowValue = getStringValue(originRowValue);
					Origin_valu4.add(originRowValue);

					boolean ColumnLoop = true;
					int column = 2;
					while (ColumnLoop == true) {
						try {
							System.out.println("Column Loop started " + column);
							WebElement columnMove = driver.findElement(By.xpath(
									" //div[@id='ERU-ERU_treeTable1_tbl']//div[@role='rowgroup']/div[@role='row' and @aria-rowindex='"
											+ row + "']//div[@role='gridcell' and @aria-colindex='" + column + "']"));
							action_val4.moveToElement(columnMove).build().perform();
							String col_type = columnMove.getAttribute("col-id");

							if (col_type.equals("origin")) {
								String loadValue = columnMove.getText();
								LoadCost_Value4.add(loadValue);
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
			}
		} else {
			System.out.println("No Rows Available to get the values");
		}

		Fluentwait(driver, Optimizer);
		click(driver, Optimizer);
		wait(driver, "2");
		Fluentwait(driver, Optimizer_Ok);
		click(driver, Optimizer_Ok);
		wait(driver, "1");
		Fluentwait(driver, ERO_40DY);
		click(driver, ERO_40DY);

		List<String> Origin_val5 = new ArrayList<String>();
		List<String> LoadCost_Val5 = new ArrayList<String>();
		List<WebElement> rowlists_Val5 = driver
				.findElements(By.xpath("//tbody[@id='OPT-OPT_treeTable_data']//following::tr[@role='row']"));

		if (rowlists_Val5.size() > 1) {
			for (int row = 2; row <= 4; row++) {
				System.out.println("Loop started " + row);
				try {

					WebElement originRow = driver.findElement(By.xpath("((//tr[@data-ri='" + row + "'])[1]//td)[1]"));
					String Origin_valu5 = originRow.getText();

					for (String expected1 : LoadCost_Value4) {

						if (expected1.contains(Origin_valu5)) {
							System.out.println("Value passed for ->  Exp : " + expected1 + ", Act : " + Origin_valu5);
							Extent_pass(driver, "Value passed for -> Exp : " + expected1 + ", Act : " + Origin_valu5,
									test, test1);
						} else {
							System.out.println("Value Failed for ->  Exp : " + expected1 + ", Act : " + Origin_valu5);
							Extent_fail(driver, "Value passed for ->  Exp : " + expected1 + ", Act : " + Origin_valu5,
									test, test1);
						}
					}

					Origin_valu5 = getStringValue(Origin_valu5);
					Origin_val5.add(Origin_valu5);

				} catch (Exception e) {

				}
			}
		} else {
			System.out.println("No Rows Available to get the values");
		}

		Fluentwait(driver, ERO_Optimizer_Close3);
		click(driver, ERO_Optimizer_Close3);

		Fluentwait(driver, ERo_SizeType_drop);
		click(driver, ERo_SizeType_drop);
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		wait(driver, "1");
		Fluentwait(driver, ERo_SizeType_drop);
		click(driver, ERo_SizeType_drop);
		Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver, EPO_SelectFilterSearchBox);
		Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver, EPO_SelectFilterSearchBox);
		wait(driver, "2");
		Fluentwait(driver, ERO_Size_Type_6);
		click(driver, ERO_Size_Type_6);
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);

		Actions action_val6 = new Actions(driver);
		List<String> Origin_valu6 = new ArrayList<String>();
		List<String> LoadCost_Value6 = new ArrayList<String>();

		List<WebElement> rowlists_val6 = driver
				.findElements(By.xpath("//div[@id='ERU-ERU_treeTable1_tbl']//div[@role='rowgroup']//div[@role='row']"));

		if (rowlists_val6.size() > 1) {

			for (int row = 2; row <= 6; row++) {

				System.out.println("Loop started " + row);
				try {
					WebElement originRow = driver.findElement(By.xpath(
							"//div[@id='ERU-ERU_treeTable1_tbl']//div[@role='rowgroup']/div[@role='row' and @aria-rowindex='"
									+ row + "']//div[@role='gridcell' and @col-id='origin']"));
					String originRowValue = originRow.getText();
					originRowValue = getStringValue(originRowValue);
					Origin_valu6.add(originRowValue);

					boolean ColumnLoop = true;
					int column = 2;
					while (ColumnLoop == true) {
						try {
							System.out.println("Column Loop started " + column);
							WebElement columnMove = driver.findElement(By.xpath(
									" //div[@id='ERU-ERU_treeTable1_tbl']//div[@role='rowgroup']/div[@role='row' and @aria-rowindex='"
											+ row + "']//div[@role='gridcell' and @aria-colindex='" + column + "']"));
							action_val6.moveToElement(columnMove).build().perform();
							String col_type = columnMove.getAttribute("col-id");

							if (col_type.equals("origin")) {
								String loadValue = columnMove.getText();
								LoadCost_Value6.add(loadValue);
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
			}
		} else {
			System.out.println("No Rows Available to get the values");
		}
		Fluentwait(driver, Optimizer);
		click(driver, Optimizer);
		wait(driver, "2");
		Fluentwait(driver, Optimizer_Ok);
		click(driver, Optimizer_Ok);
		wait(driver, "1");
		Fluentwait(driver, ERO_40HC);
		click(driver, ERO_40HC);

		List<String> Origin_val7 = new ArrayList<String>();
		List<String> LoadCost_Val7 = new ArrayList<String>();
		List<WebElement> rowlists_Val7 = driver
				.findElements(By.xpath("//tbody[@id='OPT-OPT_treeTable_data']//following::tr[@role='row']"));

		if (rowlists_Val7.size() > 1) {
			for (int row = 2; row <= 4; row++) {
				System.out.println("Loop started " + row);
				try {

					WebElement originRow = driver.findElement(By.xpath("((//tr[@data-ri='" + row + "'])[1]//td)[1]"));
					String Origin_valu7 = originRow.getText();

					for (String expected1 : LoadCost_Value6) {

						if (expected1.contains(Origin_valu7)) {
							System.out.println("Value passed for ->  Exp : " + expected1 + ", Act : " + Origin_valu7);
							Extent_pass(driver, "Value passed for -> Exp : " + expected1 + ", Act : " + Origin_valu7,
									test, test1);
						} else {
							System.out.println("Value Failed for ->  Exp : " + expected1 + ", Act : " + Origin_valu7);
							Extent_fail(driver, "Value passed for ->  Exp : " + expected1 + ", Act : " + Origin_valu7,
									test, test1);
						}
					}

					Origin_valu7 = getStringValue(Origin_valu7);
					Origin_val7.add(Origin_valu7);

				} catch (Exception e) {

				}
			}
		} else {
			System.out.println("No Rows Available to get the values");
		}

		Fluentwait(driver, ERO_Optimizer_Close4);
		click(driver, ERO_Optimizer_Close4);

		Fluentwait(driver, ERo_SizeType_drop);
		click(driver, ERo_SizeType_drop);
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		wait(driver, "1");
		Fluentwait(driver, ERo_SizeType_drop);
		click(driver, ERo_SizeType_drop);
		Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver, EPO_SelectFilterSearchBox);
		Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver, EPO_SelectFilterSearchBox);
		wait(driver, "2");
		Fluentwait(driver, ERO_Size_Type_7);
		click(driver, ERO_Size_Type_7);
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);

		Actions action_val8 = new Actions(driver);
		List<String> Origin_valu8 = new ArrayList<String>();
		List<String> LoadCost_Value8 = new ArrayList<String>();

		List<WebElement> rowlists_val8 = driver
				.findElements(By.xpath("//div[@id='ERU-ERU_treeTable1_tbl']//div[@role='rowgroup']//div[@role='row']"));

		if (rowlists_val8.size() > 1) {

			for (int row = 2; row <= 6; row++) {

				System.out.println("Loop started " + row);
				try {
					WebElement originRow = driver.findElement(By.xpath(
							"//div[@id='ERU-ERU_treeTable1_tbl']//div[@role='rowgroup']/div[@role='row' and @aria-rowindex='"
									+ row + "']//div[@role='gridcell' and @col-id='origin']"));
					String originRowValue = originRow.getText();
					originRowValue = getStringValue(originRowValue);
					Origin_valu8.add(originRowValue);

					boolean ColumnLoop = true;
					int column = 2;
					while (ColumnLoop == true) {
						try {
							System.out.println("Column Loop started " + column);
							WebElement columnMove = driver.findElement(By.xpath(
									" //div[@id='ERU-ERU_treeTable1_tbl']//div[@role='rowgroup']/div[@role='row' and @aria-rowindex='"
											+ row + "']//div[@role='gridcell' and @aria-colindex='" + column + "']"));
							action_val8.moveToElement(columnMove).build().perform();
							String col_type = columnMove.getAttribute("col-id");

							if (col_type.equals("origin")) {
								String loadValue = columnMove.getText();
								LoadCost_Value8.add(loadValue);
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
			}
		} else {
			System.out.println("No Rows Available to get the values");
		}

		Fluentwait(driver, Optimizer);
		click(driver, Optimizer);
		wait(driver, "2");
		Fluentwait(driver, Optimizer_Ok);
		click(driver, Optimizer_Ok);
		wait(driver, "1");
		Fluentwait(driver, ERO_40HR);
		click(driver, ERO_40HR);

		List<String> Origin_val9 = new ArrayList<String>();
		List<String> LoadCost_Val9 = new ArrayList<String>();
		List<WebElement> rowlists_Val9 = driver
				.findElements(By.xpath("//tbody[@id='OPT-OPT_treeTable_data']//following::tr[@role='row']"));

		if (rowlists_Val9.size() > 1) {
			for (int row = 2; row <= 4; row++) {
				System.out.println("Loop started " + row);
				try {

					WebElement originRow = driver.findElement(By.xpath("((//tr[@data-ri='" + row + "'])[1]//td)[1]"));
					String Origin_valu9 = originRow.getText();

					for (String expected1 : LoadCost_Value8) {

						if (expected1.contains(Origin_valu9)) {
							System.out.println("Value passed for ->  Exp : " + expected1 + ", Act : " + Origin_valu9);
							Extent_pass(driver, "Value passed for -> Exp : " + expected1 + ", Act : " + Origin_valu9,
									test, test1);
						} else {
							System.out.println("Value Failed for ->  Exp : " + expected1 + ", Act : " + Origin_valu9);
							Extent_fail(driver, "Value passed for ->  Exp : " + expected1 + ", Act : " + Origin_valu9,
									test, test1);
						}
					}

					Origin_valu9 = getStringValue(Origin_valu9);
					Origin_val9.add(Origin_valu9);

				} catch (Exception e) {

				}
			}
		} else {
			System.out.println("No Rows Available to get the values");
		}

		Fluentwait(driver, Defic_cancle1);
		click(driver, Defic_cancle1);

		Fluentwait(driver, ERo_SizeType_drop);
		click(driver, ERo_SizeType_drop);
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		wait(driver, "1");
		Fluentwait(driver, ERo_SizeType_drop);
		click(driver, ERo_SizeType_drop);
		Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver, EPO_SelectFilterSearchBox);
		Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver, EPO_SelectFilterSearchBox);
		wait(driver, "5");
		sendKeys(driver, size_type_input, "40OT");
		click(driver, ERO_Size_Type_8);
		wait(driver, "1");
		clear(driver, size_type_input);
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);

		Actions action_val10 = new Actions(driver);
		List<String> Origin_valu10 = new ArrayList<String>();
		List<String> LoadCost_Value10 = new ArrayList<String>();

		List<WebElement> rowlists_val10 = driver
				.findElements(By.xpath("//div[@id='ERU-ERU_treeTable1_tbl']//div[@role='rowgroup']//div[@role='row']"));

		if (rowlists_val10.size() > 1) {

			for (int row = 2; row <= 6; row++) {

				System.out.println("Loop started " + row);
				try {
					WebElement originRow = driver.findElement(By.xpath(
							"//div[@id='ERU-ERU_treeTable1_tbl']//div[@role='rowgroup']/div[@role='row' and @aria-rowindex='"
									+ row + "']//div[@role='gridcell' and @col-id='origin']"));
					String originRowValue = originRow.getText();
					originRowValue = getStringValue(originRowValue);
					Origin_valu10.add(originRowValue);

					boolean ColumnLoop = true;
					int column = 2;
					while (ColumnLoop == true) {
						try {
							System.out.println("Column Loop started " + column);
							WebElement columnMove = driver.findElement(By.xpath(
									" //div[@id='ERU-ERU_treeTable1_tbl']//div[@role='rowgroup']/div[@role='row' and @aria-rowindex='"
											+ row + "']//div[@role='gridcell' and @aria-colindex='" + column + "']"));
							action_val10.moveToElement(columnMove).build().perform();
							String col_type = columnMove.getAttribute("col-id");

							if (col_type.equals("origin")) {
								String loadValue = columnMove.getText();
								LoadCost_Value10.add(loadValue);
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
			}
		} else {
			System.out.println("No Rows Available to get the values");
		}

		Fluentwait(driver, Optimizer);
		click(driver, Optimizer);
		wait(driver, "2");
		Fluentwait(driver, Optimizer_Ok);
		click(driver, Optimizer_Ok);
		wait(driver, "1");
		Fluentwait(driver, ERO_40OT);
		click(driver, ERO_40OT);

		List<String> Origin_val11 = new ArrayList<String>();
		List<String> LoadCost_Val11 = new ArrayList<String>();
		List<WebElement> rowlists_Val11 = driver
				.findElements(By.xpath("//tbody[@id='OPT-OPT_treeTable_data']//following::tr[@role='row']"));

		if (rowlists_Val11.size() > 1) {
			for (int row = 2; row <= 4; row++) {
				System.out.println("Loop started " + row);
				try {

					WebElement originRow = driver.findElement(By.xpath("((//tr[@data-ri='" + row + "'])[1]//td)[1]"));
					String Origin_valu11 = originRow.getText();

					for (String expected1 : LoadCost_Value10) {

						if (expected1.contains(Origin_valu11)) {
							System.out.println("Value passed for ->  Exp : " + expected1 + ", Act : " + Origin_valu11);
							Extent_pass(driver, "Value passed for -> Exp : " + expected1 + ", Act : " + Origin_valu11,
									test, test1);
						} else {
							System.out.println("Value Failed for ->  Exp : " + expected1 + ", Act : " + Origin_valu11);
							Extent_fail(driver, "Value passed for ->  Exp : " + expected1 + ", Act : " + Origin_valu11,
									test, test1);
						}
					}

					Origin_valu11 = getStringValue(Origin_valu11);
					Origin_val11.add(Origin_valu11);

				} catch (Exception e) {

				}
			}
		} else {
			System.out.println("No Rows Available to get the values");
		}
		System.out.println("Testcase_237,completed");

		Fluentwait(driver, Optimizer_Clo);
		click(driver, Optimizer_Clo);

		Extent_cal(test, "TC_239,Ensure the All Equipment Reposition for single size type Location column");

		Fluentwait(driver, All_20s_Option);
		click(driver, All_20s_Option);

		Fluentwait(driver, ERO_Size_Type_Label);
		click(driver, ERO_Size_Type_Label);
		wait(driver, "2");
		Fluentwait(driver, ERO_Size_Type_Label_1);
		click(driver, ERO_Size_Type_Label_1);

		Actions action_Val = new Actions(driver);
		List<String> OriginVal = new ArrayList<String>();
		List<String> LoadCostVal = new ArrayList<String>();

		List<WebElement> rowlists_Val = driver
				.findElements(By.xpath("//div[@id='ERU-ERU_treeTable1_tbl']//div[@role='rowgroup']//div[@role='row']"));

		if (rowlists_Val.size() > 1) {

			for (int row = 2; row <= 10; row++) {

				System.out.println("Loop started " + row);
				try {
					WebElement originRow = driver.findElement(By.xpath(
							"//div[@id='ERU-ERU_treeTable1_tbl']//div[@role='rowgroup']/div[@role='row' and @aria-rowindex='"
									+ row + "']//div[@role='gridcell' and @col-id='origin']"));
					String originRowValue = originRow.getText();
					originRowValue = getStringValue(originRowValue);
					OriginVal.add(originRowValue);

					boolean ColumnLoop = true;
					int column = 2;
					while (ColumnLoop == true) {
						try {
							System.out.println("Column Loop started " + column);
							WebElement columnMove = driver.findElement(By.xpath(
									" //div[@id='ERU-ERU_treeTable1_tbl']//div[@role='rowgroup']/div[@role='row' and @aria-rowindex='"
											+ row + "']//div[@role='gridcell' and @aria-colindex='" + column + "']"));
							action_Val.moveToElement(columnMove).build().perform();
							String col_type = columnMove.getAttribute("col-id");

							if (col_type.equals("origin")) {
								String loadValue = columnMove.getText();
								LoadCostVal.add(loadValue);
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
			}
		} else {
			System.out.println("No Rows Available to get the values");
		}

		Fluentwait(driver, Optimizer);
		click(driver, Optimizer);
		wait(driver, "2");
		Fluentwait(driver, Optimizer_Ok);
		click(driver, Optimizer_Ok);

		wait(driver, "1");
		List<String> OriginValue1 = new ArrayList<String>();

		List<String> LoadCostValues1 = new ArrayList<String>();
		List<WebElement> rowlists_val1 = driver
				.findElements(By.xpath("//tbody[@id='OPT-OPT_treeTable_data']//following::tr[@role='row']"));

		System.out.println("rowlists11.size(): " + rowlists_val1.size());

		if (rowlists_val1.size() > 1) {
			for (int row = 2; row <= 28; row++) {
				System.out.println("Loop started " + row);
				try {

					WebElement originRow = driver.findElement(By.xpath("((//tr[@data-ri='" + row + "'])[1]//td)[1]"));
					String originRowValue1 = originRow.getText();

					for (String expected1 : LoadCostVal) {

						if (expected1.contains(originRowValue1)) {
							System.out
									.println("Value passed for ->  Exp : " + expected1 + ", Act : " + originRowValue1);
							Extent_pass(driver, "Value passed for -> Exp : " + expected1 + ", Act : " + originRowValue1,
									test, test1);
						} else {
							System.out
									.println("Value Failed for ->  Exp : " + expected1 + ", Act : " + originRowValue1);
							Extent_fail(driver,
									"Value passed for ->  Exp : " + expected1 + ", Act : " + originRowValue1, test,
									test1);
						}
					}

					originRowValue1 = getStringValue(originRowValue1);
					OriginValue1.add(originRowValue1);

					System.out.println("check origin values " + OriginValue1);
				} catch (Exception e) {

				}
			}
		} else {
			System.out.println("No Rows Available to get the values");
		}
		wait(driver, "2");

		Fluentwait(driver, Optimizer_Clo);
		click(driver, Optimizer_Clo);
		wait(driver, "2");
		Fluentwait(driver, ERO_SVM);
		click(driver, ERO_SVM);
		wait(driver, "2");
		Fluentwait(driver, ERo_SizeType_drop);
		click(driver, ERo_SizeType_drop);
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		wait(driver, "1");
//		Fluentwait(driver, ERo_SizeType_drop);
//		click(driver, ERo_SizeType_drop);
		Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver, EPO_SelectFilterSearchBox);
		Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver, EPO_SelectFilterSearchBox);
		wait(driver, "2");
		Fluentwait(driver, ERO_Size_Type_second);
		click(driver, ERO_Size_Type_second);
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);

		Actions action_Val1 = new Actions(driver);
		List<String> OriginVal1 = new ArrayList<String>();
		List<String> LoadCostVal1 = new ArrayList<String>();

		List<WebElement> rowlistsVal1 = driver
				.findElements(By.xpath("//div[@id='ERU-ERU_treeTable1_tbl']//div[@role='rowgroup']//div[@role='row']"));

		if (rowlistsVal1.size() > 1) {

			for (int row = 2; row <= 4; row++) {

				System.out.println("Loop started " + row);
				try {
					WebElement originRow = driver.findElement(By.xpath(
							"//div[@id='ERU-ERU_treeTable1_tbl']//div[@role='rowgroup']/div[@role='row' and @aria-rowindex='"
									+ row + "']//div[@role='gridcell' and @col-id='origin']"));
					String originRowValue = originRow.getText();
					originRowValue = getStringValue(originRowValue);
					OriginVal1.add(originRowValue);

					boolean ColumnLoop = true;
					int column = 2;
					while (ColumnLoop == true) {
						try {
							System.out.println("Column Loop started " + column);
							WebElement columnMove = driver.findElement(By.xpath(
									" //div[@id='ERU-ERU_treeTable1_tbl']//div[@role='rowgroup']/div[@role='row' and @aria-rowindex='"
											+ row + "']//div[@role='gridcell' and @aria-colindex='" + column + "']"));
							action_Val1.moveToElement(columnMove).build().perform();
							String col_type = columnMove.getAttribute("col-id");

							if (col_type.equals("origin")) {
								String loadValue = columnMove.getText();
								LoadCostVal1.add(loadValue);
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
			}
		} else {
			System.out.println("No Rows Available to get the values");
		}
		Fluentwait(driver, Optimizer);
		click(driver, Optimizer);
		wait(driver, "2");
		Fluentwait(driver, Optimizer_Ok);
		click(driver, Optimizer_Ok);

		wait(driver, "1");

		List<String> OriginVal2 = new ArrayList<String>();
		List<String> LoadCostVal2 = new ArrayList<String>();
		List<WebElement> rowlistsVal2 = driver
				.findElements(By.xpath("//tbody[@id='OPT-OPT_treeTable_data']//following::tr[@role='row']"));

		if (rowlistsVal2.size() > 1) {
			for (int row = 2; row <= 4; row++) {
				System.out.println("Loop started " + row);
				try {
					WebElement originRow = driver.findElement(By.xpath("((//tr[@data-ri='" + row + "'])[1]//td)[1]"));
					String Origin_valu1 = originRow.getText();

					for (String expected1 : LoadCostVal1) {
						if (expected1.contains(Origin_valu1)) {
							System.out.println("Value passed for ->  Exp : " + expected1 + ", Act : " + Origin_valu1);
							Extent_pass(driver, "Value passed for -> Exp : " + expected1 + ", Act : " + Origin_valu1,
									test, test1);
						} else {
							System.out.println("Value Failed for ->  Exp : " + expected1 + ", Act : " + Origin_valu1);
							Extent_fail(driver, "Value passed for ->  Exp : " + expected1 + ", Act : " + Origin_valu1,
									test, test1);
						}
					}

					Origin_valu1 = getStringValue(Origin_valu1);
					OriginVal2.add(Origin_valu1);

				} catch (Exception e) {
				}
			}
		} else {
			System.out.println("No Rows Available to get the values");
		}

		Fluentwait(driver, Optimizer_Clo);
		click(driver, Optimizer_Clo);

		Fluentwait(driver, ERo_SizeType_drop);
		click(driver, ERo_SizeType_drop);
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		wait(driver, "1");
		Fluentwait(driver, ERo_SizeType_drop);
		click(driver, ERo_SizeType_drop);
		Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver, EPO_SelectFilterSearchBox);
		Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver, EPO_SelectFilterSearchBox);
		wait(driver, "2");
		Fluentwait(driver, ERO_Size_Type_3);
		click(driver, ERO_Size_Type_3);
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);

		Actions action_Val2 = new Actions(driver);
		List<String> OriginVal3 = new ArrayList<String>();
		List<String> LoadCostVal3 = new ArrayList<String>();

		List<WebElement> rowlistsVal3 = driver
				.findElements(By.xpath("//div[@id='ERU-ERU_treeTable1_tbl']//div[@role='rowgroup']//div[@role='row']"));

		if (rowlistsVal3.size() > 1) {

			for (int row = 2; row <= 6; row++) {

				System.out.println("Loop started " + row);
				try {
					WebElement originRow = driver.findElement(By.xpath(
							"//div[@id='ERU-ERU_treeTable1_tbl']//div[@role='rowgroup']/div[@role='row' and @aria-rowindex='"
									+ row + "']//div[@role='gridcell' and @col-id='origin']"));
					String originRowValue = originRow.getText();
					originRowValue = getStringValue(originRowValue);
					OriginVal3.add(originRowValue);

					boolean ColumnLoop = true;
					int column = 2;
					while (ColumnLoop == true) {
						try {
							System.out.println("Column Loop started " + column);
							WebElement columnMove = driver.findElement(By.xpath(
									" //div[@id='ERU-ERU_treeTable1_tbl']//div[@role='rowgroup']/div[@role='row' and @aria-rowindex='"
											+ row + "']//div[@role='gridcell' and @aria-colindex='" + column + "']"));
							action_val2.moveToElement(columnMove).build().perform();
							String col_type = columnMove.getAttribute("col-id");

							if (col_type.equals("origin")) {
								String loadValue = columnMove.getText();
								LoadCostVal3.add(loadValue);
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
			}
		} else {
			System.out.println("No Rows Available to get the values");
		}

		Fluentwait(driver, Optimizer);
		click(driver, Optimizer);
		wait(driver, "2");
		Fluentwait(driver, Optimizer_Ok);
		click(driver, Optimizer_Ok);

		wait(driver, "1");
		List<String> OriginVal4 = new ArrayList<String>();
		List<String> LoadCostValU = new ArrayList<String>();
		List<WebElement> rowlistsVal_3 = driver
				.findElements(By.xpath("//tbody[@id='OPT-OPT_treeTable_data']//following::tr[@role='row']"));

		if (rowlistsVal_3.size() > 1) {
			for (int row = 2; row <= 30; row++) {
				System.out.println("Loop started " + row);
				try {

					WebElement originRow = driver.findElement(By.xpath("((//tr[@data-ri='" + row + "'])[1]//td)[1]"));
					String Origin_Valu4 = originRow.getText();

					for (String expected1 : LoadCostVal3) {

						if (expected1.contains(Origin_Valu4)) {
							System.out.println("Value passed for ->  Exp : " + expected1 + ", Act : " + Origin_Valu4);
							Extent_pass(driver, "Value passed for -> Exp : " + expected1 + ", Act : " + Origin_Valu4,
									test, test1);
						} else {
							System.out.println("Value Failed for ->  Exp : " + expected1 + ", Act : " + Origin_Valu4);
							Extent_fail(driver, "Value passed for ->  Exp : " + expected1 + ", Act : " + Origin_Valu4,
									test, test1);
						}
					}

					Origin_Valu4 = getStringValue(Origin_Valu4);
					OriginVal4.add(Origin_Valu4);

				} catch (Exception e) {

				}
			}
		} else {
			System.out.println("No Rows Available to get the values");
		}

		Fluentwait(driver, Optimizer_Clo);
		click(driver, Optimizer_Clo);

		Fluentwait(driver, ERo_SizeType_drop);
		click(driver, ERo_SizeType_drop);
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		wait(driver, "1");
		Fluentwait(driver, ERo_SizeType_drop);
		click(driver, ERo_SizeType_drop);
		Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver, EPO_SelectFilterSearchBox);
		Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver, EPO_SelectFilterSearchBox);
		wait(driver, "2");
		Fluentwait(driver, ERO_Size_Type_4);
		click(driver, ERO_Size_Type_4);
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);

		Actions actionVal4 = new Actions(driver);
		List<String> OriginValu4 = new ArrayList<String>();
		List<String> LoadCostValue4 = new ArrayList<String>();

		List<WebElement> rowlistsVal4 = driver
				.findElements(By.xpath("//div[@id='ERU-ERU_treeTable1_tbl']//div[@role='rowgroup']//div[@role='row']"));

		if (rowlistsVal4.size() > 1) {

			for (int row = 2; row <= 6; row++) {

				System.out.println("Loop started " + row);
				try {
					WebElement originRow = driver.findElement(By.xpath(
							"//div[@id='ERU-ERU_treeTable1_tbl']//div[@role='rowgroup']/div[@role='row' and @aria-rowindex='"
									+ row + "']//div[@role='gridcell' and @col-id='origin']"));
					String originRowValue = originRow.getText();
					originRowValue = getStringValue(originRowValue);
					OriginValu4.add(originRowValue);

					boolean ColumnLoop = true;
					int column = 2;
					while (ColumnLoop == true) {
						try {
							System.out.println("Column Loop started " + column);
							WebElement columnMove = driver.findElement(By.xpath(
									" //div[@id='ERU-ERU_treeTable1_tbl']//div[@role='rowgroup']/div[@role='row' and @aria-rowindex='"
											+ row + "']//div[@role='gridcell' and @aria-colindex='" + column + "']"));
							actionVal4.moveToElement(columnMove).build().perform();
							String col_type = columnMove.getAttribute("col-id");

							if (col_type.equals("origin")) {
								String loadValue = columnMove.getText();
								LoadCostValue4.add(loadValue);
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
			}
		} else {
			System.out.println("No Rows Available to get the values");
		}
		Fluentwait(driver, Optimizer);
		click(driver, Optimizer);
		wait(driver, "2");
		Fluentwait(driver, Optimizer_Ok);
		click(driver, Optimizer_Ok);
		wait(driver, "1");

		List<String> OriginVal5 = new ArrayList<String>();
		List<String> LoadcostVal5 = new ArrayList<String>();
		List<WebElement> rowlistsVal5 = driver
				.findElements(By.xpath("//tbody[@id='OPT-OPT_treeTable_data']//following::tr[@role='row']"));

		if (rowlistsVal5.size() > 1) {
			for (int row = 2; row <= 25; row++) {
				System.out.println("Loop started " + row);
				try {

					WebElement originRow = driver.findElement(By.xpath("((//tr[@data-ri='" + row + "'])[1]//td)[1]"));
					String OriginValu5 = originRow.getText();

					for (String expected1 : LoadCostValue4) {

						if (expected1.contains(OriginValu5)) {
							System.out.println("Value passed for ->  Exp : " + expected1 + ", Act : " + OriginValu5);
							Extent_pass(driver, "Value passed for -> Exp : " + expected1 + ", Act : " + OriginValu5,
									test, test1);
						} else {
							System.out.println("Value Failed for ->  Exp : " + expected1 + ", Act : " + OriginValu5);
							Extent_fail(driver, "Value passed for ->  Exp : " + expected1 + ", Act : " + OriginValu5,
									test, test1);
						}
					}

					OriginValu5 = getStringValue(OriginValu5);
					OriginVal5.add(OriginValu5);

				} catch (Exception e) {

				}
			}
		} else {
			System.out.println("No Rows Available to get the values");
		}

		Fluentwait(driver, Optimizer_Clo);
		click(driver, Optimizer_Clo);

		Fluentwait(driver, ERo_SizeType_drop);
		click(driver, ERo_SizeType_drop);
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		wait(driver, "1");
		Fluentwait(driver, ERo_SizeType_drop);
		click(driver, ERo_SizeType_drop);
		Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver, EPO_SelectFilterSearchBox);
		Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver, EPO_SelectFilterSearchBox);
		wait(driver, "2");
		Fluentwait(driver, ERO_Size_Type_5);
		click(driver, ERO_Size_Type_5);
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);

		Actions actionVal5 = new Actions(driver);
		List<String> OriginValu5 = new ArrayList<String>();
		List<String> LoadCostValue5 = new ArrayList<String>();

		List<WebElement> rowlistVal5 = driver
				.findElements(By.xpath("//div[@id='ERU-ERU_treeTable1_tbl']//div[@role='rowgroup']//div[@role='row']"));

		if (rowlistVal5.size() > 1) {

			for (int row = 2; row <= 6; row++) {

				System.out.println("Loop started " + row);
				try {
					WebElement originRow = driver.findElement(By.xpath(
							"//div[@id='ERU-ERU_treeTable1_tbl']//div[@role='rowgroup']/div[@role='row' and @aria-rowindex='"
									+ row + "']//div[@role='gridcell' and @col-id='origin']"));
					String originRowValue = originRow.getText();
					originRowValue = getStringValue(originRowValue);
					OriginValu5.add(originRowValue);

					boolean ColumnLoop = true;
					int column = 2;
					while (ColumnLoop == true) {
						try {
							System.out.println("Column Loop started " + column);
							WebElement columnMove = driver.findElement(By.xpath(
									" //div[@id='ERU-ERU_treeTable1_tbl']//div[@role='rowgroup']/div[@role='row' and @aria-rowindex='"
											+ row + "']//div[@role='gridcell' and @aria-colindex='" + column + "']"));
							actionVal5.moveToElement(columnMove).build().perform();
							String col_type = columnMove.getAttribute("col-id");

							if (col_type.equals("origin")) {
								String loadValue = columnMove.getText();
								LoadCostValue5.add(loadValue);
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
			}
		} else {
			System.out.println("No Rows Available to get the values");
		}

		Fluentwait(driver, Optimizer);
		click(driver, Optimizer);
		wait(driver, "2");
		Fluentwait(driver, Optimizer_Ok);
		click(driver, Optimizer_Ok);
		wait(driver, "1");

		List<String> OriginVal6 = new ArrayList<String>();
		List<String> LoadCostVal6 = new ArrayList<String>();
		List<WebElement> rowlistsVal6 = driver
				.findElements(By.xpath("//tbody[@id='OPT-OPT_treeTable_data']//following::tr[@role='row']"));

		if (rowlistsVal6.size() > 1) {
			for (int row = 2; row <= 30; row++) {
				System.out.println("Loop started " + row);
				try {

					WebElement originRow = driver.findElement(By.xpath("((//tr[@data-ri='" + row + "'])[1]//td)[1]"));
					String Origin_valu5 = originRow.getText();

					for (String expected1 : LoadCostValue5) {

						if (expected1.contains(Origin_valu5)) {
							System.out.println("Value passed for ->  Exp : " + expected1 + ", Act : " + Origin_valu5);
							Extent_pass(driver, "Value passed for -> Exp : " + expected1 + ", Act : " + Origin_valu5,
									test, test1);
						} else {
							System.out.println("Value Failed for ->  Exp : " + expected1 + ", Act : " + Origin_valu5);
							Extent_fail(driver, "Value passed for ->  Exp : " + expected1 + ", Act : " + Origin_valu5,
									test, test1);
						}
					}

					Origin_valu5 = getStringValue(Origin_valu5);
					OriginVal6.add(Origin_valu5);

				} catch (Exception e) {

				}
			}
		} else {
			System.out.println("No Rows Available to get the values");
		}

		Fluentwait(driver, Optimizer_Clo);
		click(driver, Optimizer_Clo);

		Fluentwait(driver, ERo_SizeType_drop);
		click(driver, ERo_SizeType_drop);
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		wait(driver, "1");
		Fluentwait(driver, ERo_SizeType_drop);
		click(driver, ERo_SizeType_drop);
		Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver, EPO_SelectFilterSearchBox);
		Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver, EPO_SelectFilterSearchBox);
		wait(driver, "2");
		Fluentwait(driver, ERO_Size_Type_6);
		click(driver, ERO_Size_Type_6);
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);

		Actions action_Val6 = new Actions(driver);
		List<String> Origin_valu = new ArrayList<String>();
		List<String> LoadCostValue6 = new ArrayList<String>();

		List<WebElement> rowlists_Val6 = driver
				.findElements(By.xpath("//div[@id='ERU-ERU_treeTable1_tbl']//div[@role='rowgroup']//div[@role='row']"));

		if (rowlists_Val6.size() > 1) {

			for (int row = 2; row <= 6; row++) {

				System.out.println("Loop started " + row);
				try {
					WebElement originRow = driver.findElement(By.xpath(
							"//div[@id='ERU-ERU_treeTable1_tbl']//div[@role='rowgroup']/div[@role='row' and @aria-rowindex='"
									+ row + "']//div[@role='gridcell' and @col-id='origin']"));
					String originRowValue = originRow.getText();
					originRowValue = getStringValue(originRowValue);
					Origin_valu.add(originRowValue);

					boolean ColumnLoop = true;
					int column = 2;
					while (ColumnLoop == true) {
						try {
							System.out.println("Column Loop started " + column);
							WebElement columnMove = driver.findElement(By.xpath(
									" //div[@id='ERU-ERU_treeTable1_tbl']//div[@role='rowgroup']/div[@role='row' and @aria-rowindex='"
											+ row + "']//div[@role='gridcell' and @aria-colindex='" + column + "']"));
							action_Val6.moveToElement(columnMove).build().perform();
							String col_type = columnMove.getAttribute("col-id");

							if (col_type.equals("origin")) {
								String loadValue = columnMove.getText();
								LoadCostValue6.add(loadValue);
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
			}
		} else {
			System.out.println("No Rows Available to get the values");
		}
		Fluentwait(driver, Optimizer);
		click(driver, Optimizer);
		wait(driver, "2");
		Fluentwait(driver, Optimizer_Ok);
		click(driver, Optimizer_Ok);
		wait(driver, "1");

		List<String> Origin_Val7 = new ArrayList<String>();
		List<String> LoadCostva = new ArrayList<String>();
		List<WebElement> rowlistsVal7 = driver
				.findElements(By.xpath("//tbody[@id='OPT-OPT_treeTable_data']//following::tr[@role='row']"));

		if (rowlistsVal7.size() > 1) {
			for (int row = 2; row <= 30; row++) {
				System.out.println("Loop started " + row);
				try {

					WebElement originRow = driver.findElement(By.xpath("((//tr[@data-ri='" + row + "'])[1]//td)[1]"));
					String Origin_valu7 = originRow.getText();

					for (String expected1 : LoadCostValue6) {

						if (expected1.contains(Origin_valu7)) {
							System.out.println("Value passed for ->  Exp : " + expected1 + ", Act : " + Origin_valu7);
							Extent_pass(driver, "Value passed for -> Exp : " + expected1 + ", Act : " + Origin_valu7,
									test, test1);
						} else {
							System.out.println("Value Failed for ->  Exp : " + expected1 + ", Act : " + Origin_valu7);
							Extent_fail(driver, "Value passed for ->  Exp : " + expected1 + ", Act : " + Origin_valu7,
									test, test1);
						}
					}

					Origin_valu7 = getStringValue(Origin_valu7);
					Origin_Val7.add(Origin_valu7);

				} catch (Exception e) {

				}
			}
		} else {
			System.out.println("No Rows Available to get the values");
		}

		Fluentwait(driver, Optimizer_Clo);
		click(driver, Optimizer_Clo);

		Fluentwait(driver, ERo_SizeType_drop);
		click(driver, ERo_SizeType_drop);
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);
		wait(driver, "1");
		Fluentwait(driver, ERo_SizeType_drop);
		click(driver, ERo_SizeType_drop);
		Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver, EPO_SelectFilterSearchBox);
		Fluentwait(driver, EPO_SelectFilterSearchBox);
		click(driver, EPO_SelectFilterSearchBox);
		wait(driver, "2");
		Fluentwait(driver, ERO_Size_Type_7);
		click(driver, ERO_Size_Type_7);
		Fluentwait(driver, EPO_SelectFilterOption);
		click(driver, EPO_SelectFilterOption);

		Actions actionval8 = new Actions(driver);
		List<String> Originvalu8 = new ArrayList<String>();
		List<String> LoadCostValue8 = new ArrayList<String>();

		List<WebElement> rowlistsval8 = driver
				.findElements(By.xpath("//div[@id='ERU-ERU_treeTable1_tbl']//div[@role='rowgroup']//div[@role='row']"));

		if (rowlistsval8.size() > 1) {

			for (int row = 2; row <= 6; row++) {

				System.out.println("Loop started " + row);
				try {
					WebElement originRow = driver.findElement(By.xpath(
							"//div[@id='ERU-ERU_treeTable1_tbl']//div[@role='rowgroup']/div[@role='row' and @aria-rowindex='"
									+ row + "']//div[@role='gridcell' and @col-id='origin']"));
					String originRowValue = originRow.getText();
					originRowValue = getStringValue(originRowValue);
					Originvalu8.add(originRowValue);

					boolean ColumnLoop = true;
					int column = 2;
					while (ColumnLoop == true) {
						try {
							System.out.println("Column Loop started " + column);
							WebElement columnMove = driver.findElement(By.xpath(
									" //div[@id='ERU-ERU_treeTable1_tbl']//div[@role='rowgroup']/div[@role='row' and @aria-rowindex='"
											+ row + "']//div[@role='gridcell' and @aria-colindex='" + column + "']"));
							actionval8.moveToElement(columnMove).build().perform();
							String col_type = columnMove.getAttribute("col-id");

							if (col_type.equals("origin")) {
								String loadValue = columnMove.getText();
								LoadCostValue8.add(loadValue);
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
			}
		} else {
			System.out.println("No Rows Available to get the values");
		}

		Fluentwait(driver, Optimizer);
		click(driver, Optimizer);
		wait(driver, "2");
		Fluentwait(driver, Optimizer_Ok);
		click(driver, Optimizer_Ok);
		wait(driver, "1");

		List<String> Originval9 = new ArrayList<String>();
		List<String> LoadCost_val19 = new ArrayList<String>();
		List<WebElement> rowlistsVal9 = driver
				.findElements(By.xpath("//tbody[@id='OPT-OPT_treeTable_data']//following::tr[@role='row']"));

		if (rowlistsVal9.size() > 1) {
			for (int row = 2; row <= 24; row++) {
				System.out.println("Loop started " + row);
				try {

					WebElement originRow = driver.findElement(By.xpath("((//tr[@data-ri='" + row + "'])[1]//td)[1]"));
					String Origin_valu9 = originRow.getText();

					for (String expected1 : LoadCostValue8) {

						if (expected1.contains(Origin_valu9)) {
							System.out.println("Value passed for ->  Exp : " + expected1 + ", Act : " + Origin_valu9);
							Extent_pass(driver, "Value passed for -> Exp : " + expected1 + ", Act : " + Origin_valu9,
									test, test1);
						} else {
							System.out.println("Value Failed for ->  Exp : " + expected1 + ", Act : " + Origin_valu9);
							Extent_fail(driver, "Value passed for ->  Exp : " + expected1 + ", Act : " + Origin_valu9,
									test, test1);
						}
					}

					Origin_valu9 = getStringValue(Origin_valu9);
					Originval9.add(Origin_valu9);

				} catch (Exception e) {

				}
			}
		} else {
			System.out.println("No Rows Available to get the values");
		}

		Fluentwait(driver, Optimizer_Clo);
		click(driver, Optimizer_Clo);

		System.out.println("Testcase_239,completed");

		Fluentwait(driver, All_option);
		click(driver, All_option);

		Extent_cal(test,
				"TC_241,Ensure the All Equipment Reposition Report  for all size type and single size type  Load Location,Discharge Location,Equipment type,Quantity,Cost per Box (USD) columns records displayed");

		Fluentwait(driver, Optimizer);
		click(driver, Optimizer);
		wait(driver, "2");
		Fluentwait(driver, Optimizer_Ok);
		click(driver, Optimizer_Ok);
		wait(driver, "2");

		Fluentwait(driver, ERO_Equipment_Reposition_Repor1t);
		click(driver, ERO_Equipment_Reposition_Repor1t);

		if (isDisplayed(driver, Optimizer_LoadLocation)) {
			System.out.println("After click on Equipment Reposition Report button Load Location data is displayed ");
			Extent_pass(driver, "After click on Equipment Reposition Report button Load Location data is displayed",
					test, test1);
		} else {
			System.out
					.println("After click on Equipment Reposition Report button Load Location data is not displayed ");
			Extent_fail2(driver,
					"After click on Equipment Reposition Report button Load Location data is not displayed", test);
		}

		wait(driver, "1");
		if (isDisplayed(driver, Optimizer_DischLocation)) {
			System.out.println("After click on Equipment Reposition Report button Disch Location data is displayed ");
			Extent_pass(driver, "After click on Equipment Reposition Report button Disch Location data is displayed",
					test, test1);
		} else {
			System.out
					.println("After click on Equipment Reposition Report button Disch Location data is not displayed ");
			Extent_fail2(driver,
					"After click on Equipment Reposition Report button Disch Location data is not displayed ", test1);
		}

		wait(driver, "1");

		if (isDisplayed(driver, Optimizer_EquipmentType)) {
			System.out.println("After click on Equipment Reposition Report button Equipment Type data is displayed ");
			Extent_pass(driver, "After click on Equipment Reposition Report button Equipment Type data is displayed",
					test, test1);
		} else {
			System.out
					.println("After click on Equipment Reposition Report button Equipment Type data is not displayed ");
			Extent_fail2(driver,
					"After click on Equipment Reposition Report button Equipment Type data is not displayed", test);
		}

		wait(driver, "1");
		if (isDisplayed(driver, Optimizer_Quantity)) {
			System.out.println("After click on Equipment Reposition Report button Quantity data is displayed ");
			Extent_pass(driver, "After click on Equipment Reposition Report button Quantity data is displayed", test,
					test1);
		} else {
			System.out.println("After click on Equipment Reposition Report button Quantity data is not displayed ");
			Extent_fail2(driver, "After click on Equipment Reposition Report button Quantity data is not displayed",
					test);
		}

		wait(driver, "1");
		if (isDisplayed(driver, Optimizer_CostPerBox)) {
			System.out
					.println("After click on Equipment Reposition Report button Cost Per Box(USD) data is displayed ");
			Extent_pass(driver, "After click on Equipment Reposition Report button Cost Per Box(USD) data is displayed",
					test, test1);
		} else {
			System.out.println(
					"After click on Equipment Reposition Report button Cost Per Box(USD) data is not displayed ");
			Extent_fail2(driver,
					"After click on Equipment Reposition Report button Cost Per Box(USD) data is not displayed", test);
		}
		System.out.println("Testcase_241,completed");

		Extent_cal(test,
				"TC_242,Ensure the All Equipment Reposition Report  for all size type and single size type  Load Location,Discharge Location,Equipment type,Quantity,Cost per Box (USD) columns records displayed");

		int quantity = Integer.parseInt(getText(driver, Optimizer_Quantity1));
		System.out.println("quantity :" + quantity);

		String costString = getText(driver, Optimizer_Cost_Per);

		// Convert the String to a double
		double cost = Double.parseDouble(costString);
		System.out.println("Cost :" + cost);

		String TotalString = getText(driver, Optimizer_Total_Cost);
		double Total_Cost = Double.parseDouble(TotalString);
		System.out.println("Total_Cost :" + Total_Cost);

		double Actual = quantity * cost;

		if (Actual == Total_Cost) {
			System.out.println("After click on Equipment Reposition Report button Total cost data is displayed ");
			Extent_pass(driver, "Expected value :" + Total_Cost + "Actual value : " + Actual, test, test1);
		} else {
			System.out.println("After click on Equipment Reposition Report button Total cost data is not  displayed ");
			Extent_fail2(driver, "Expected value :" + Total_Cost + "Actual value : " + Actual, test);

			System.out.println("Testcase_242,completed");

			Extent_cal(test,
					"TC_243,Ensure the All Equipment Reposition Report  for all size type and single size type Transit Days,Load Region,Load Country,Discharge Country,Discharge Region,Main service,POL, POL Terminal, POL Service,Trans1,Trans1 Terminal,Trans1 Service,Trans2,Trans2 Terminal,Trans2 Service,Trans3,Trans3 Terminal,Trans3 Service,POD,POD Terminal columns records displayed");

			List<String> Columnname = Arrays.asList("origin", "delivery", "sizetype", "containercount", "cost",
					"totcost", "transitTime", "remarks");

			List<String> Names = Arrays.asList("Load Location", "Disch Location", "Equipment Type", "Quantity",
					"Cost Per Box(USD)", "Total Cost(USD)", "Transit Days", "Remarks");

			int size = Columnname.size();

			for (int i = 0; i < size; i++) {

				String columns = Columnname.get(i);

				String Column_Name = Names.get(i);
				wait(driver, "1");
				WebElement element = driver.findElement(
						By.xpath("((//div[@row-index='0'])[11]//following::div[@col-id='" + columns + "'])[1]"));

				act.moveToElement(element).build().perform();

				wait(driver, "5");

				if (element.isDisplayed()) {

					System.out.println(
							"After click on Equipment Reposition Report " + Column_Name + " was displayed in the grid");
					Extent_pass(driver,
							"After click on Equipment Reposition Report " + Column_Name + " was displayed in the grid",
							test, test1);
				} else {
					System.out.println("After click on Equipment Reposition Report" + Column_Name
							+ " was not displayed in the grid");
					Extent_fail2(driver, "After click on Equipment Reposition Report " + Column_Name
							+ " was not displayed in the grid", test);

				}
			}

			WebElement scroller = driver.findElement(By.xpath("(//div[@ref='eBodyHorizontalScrollViewport'])[4]"));

			int scrollAmount = 1450; // trans 1 svc

			js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller, scrollAmount);

			List<String> Columnname1 = Arrays.asList("loadregion", "loadcountry", "dischcountry", "dischregion",
					"mainService", "loadmmrsector", "pOL", "pOLService", "trans1");

			List<String> Names1 = Arrays.asList("Load Region", "Load Country", "Disch Country", "Disch Region",
					"Main Service", "Origin Mode", "POL", "POL Svc", "Trans1");

			int size1 = Columnname1.size();

			for (int i = 0; i < size1; i++) {

				String columns = Columnname1.get(i);

				String Column_Name = Names1.get(i);
				wait(driver, "1");
				WebElement element = driver.findElement(
						By.xpath("((//div[@row-index='0'])[11]//following::div[@col-id='" + columns + "'])[1]"));

				act.moveToElement(element).build().perform();

				wait(driver, "5");

				if (element.isDisplayed()) {

					System.out.println(
							"After click on Equipment Reposition Report " + Column_Name + " was displayed in the grid");
					Extent_pass(driver,
							"After click on Equipment Reposition Report " + Column_Name + " was displayed in the grid",
							test, test1);
				} else {
					System.out.println("After click on Equipment Reposition Report" + Column_Name
							+ " was not displayed in the grid");
					Extent_fail2(driver, "After click on Equipment Reposition Report " + Column_Name
							+ " was not displayed in the grid", test);
				}
			}

			WebElement scroller2 = driver.findElement(By.xpath("(//div[@ref='eBodyHorizontalScrollViewport'])[4]"));

			int scrollAmount2 = 1000; // trans 1 svc

			js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller2, scrollAmount2);
			List<String> Columnname3 = Arrays.asList("trans1Svc", "trans2", "trans2Svc", "trans3", "trans3Svc", "pOD",
					"dischmmrsector", "dLoadCost", "dDischDCost");

			List<String> Names3 = Arrays.asList("Trans1 Svc", "Trans2", "Trans2 Svc", "Trans3", "Trans3 Svc", "POD",
					"Delivery Mode", "Load Cost", "Disch Cost");

			int size3 = Columnname3.size();

			for (int i = 0; i < size3; i++) {

				String columns = Columnname3.get(i);

				String Column_Name = Names3.get(i);
				wait(driver, "1");
				WebElement element = driver.findElement(
						By.xpath("((//div[@row-index='0'])[11]//following::div[@col-id='" + columns + "'])[1]"));

				act.moveToElement(element).build().perform();

				wait(driver, "5");

				if (element.isDisplayed()) {

					System.out.println(
							"After click on Equipment Reposition Report " + Column_Name + " was displayed in the grid");
					Extent_pass(driver,
							"After click on Equipment Reposition Report " + Column_Name + " was displayed in the grid",
							test, test1);
				} else {
					System.out.println("After click on Equipment Reposition Report" + Column_Name
							+ " was not displayed in the grid");
					Extent_fail2(driver, "After click on Equipment Reposition Report " + Column_Name
							+ " was not displayed in the grid", test);
				}
			}

			WebElement scroller3 = driver.findElement(By.xpath("(//div[@ref='eBodyHorizontalScrollViewport'])[4]"));

			int scrollAmount3 = 1000; // trans 1 svc

			js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller3, scrollAmount3);

			List<String> Columnname4 = Arrays.asList("dTS1LoadCost", "dTS2LoadCost", "dTS3LoadCost", "dTS1DischCost",
					"dTS2DischCost", "dTS3DischCost", "dFdrCost1", "loadsector");

			List<String> Names4 = Arrays.asList("TS1 Load Cost", "TS2 Load Cost", "TS3 Load Cost", "TS1 Disch Cost",
					"TS2 Disch Cost", "TS3 Disch Cost", "Feeder Cost 1", "Feeder 1 Terms");

			int size4 = Columnname4.size();

			for (int i = 0; i < size4; i++) {

				String columns = Columnname4.get(i);

				String Column_Name = Names4.get(i);
				wait(driver, "1");
				WebElement element = driver.findElement(
						By.xpath("((//div[@row-index='0'])[11]//following::div[@col-id='" + columns + "'])[1]"));

				act.moveToElement(element).build().perform();

				wait(driver, "5");

				if (element.isDisplayed()) {

					System.out.println(
							"After click on Equipment Reposition Report " + Column_Name + " was displayed in the grid");
					Extent_pass(driver,
							"After click on Equipment Reposition Report " + Column_Name + " was displayed in the grid",
							test, test1);
				} else {
					System.out.println("After click on Equipment Reposition Report" + Column_Name
							+ " was not displayed in the grid");
					Extent_fail2(driver, "After click on Equipment Reposition Report " + Column_Name
							+ " was not displayed in the grid", test);
				}
			}

			WebElement scroller4 = driver.findElement(By.xpath("(//div[@ref='eBodyHorizontalScrollViewport'])[4]"));

			int scrollAmount4 = 1100; // trans 1 svc

			js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller4, scrollAmount4);

			List<String> Columnname5 = Arrays.asList("dFdrCost2", "dischsector", "dFdrCost3", "loadtca", "dLoadHlgCost",
					"dDischHlgCost", "dIntFdrCost1", "dIntFdrCost2", "dIntFdrCost3", "dIntFdrCost4", "dOthersCost");

			List<String> Names5 = Arrays.asList("Feeder Cost 2", "Feeder 2 Terms", "Feeder Cost 3", "Feeder 3 Terms",
					"Load Haulage Cost", "Disch Haulage Cost", "DPH Origin Cost", "DPH Destination Cost",
					"LCT Origin Cost", "LCT Destination Cost", "In Service Destination Cost");

			int size5 = Columnname5.size();

			for (int i = 0; i < size5; i++) {

				String columns = Columnname5.get(i);

				String Column_Name = Names5.get(i);
				wait(driver, "1");
				WebElement element = driver.findElement(
						By.xpath("((//div[@row-index='0'])[11]//following::div[@col-id='" + columns + "'])[1]"));

				act.moveToElement(element).build().perform();

				wait(driver, "5");

				if (element.isDisplayed()) {

					System.out.println(
							"After click on Equipment Reposition Report " + Column_Name + " was displayed in the grid");
					Extent_pass(driver,
							"After click on Equipment Reposition Report " + Column_Name + " was displayed in the grid",
							test, test1);
				} else {
					System.out.println("After click on Equipment Reposition Report" + Column_Name
							+ " was not displayed in the grid");
					Extent_fail2(driver, "After click on Equipment Reposition Report " + Column_Name
							+ " was not displayed in the grid", test);
				}
			}
			System.out.println("Testcase_243,completed");

		}

	}
}
