package commonMethods;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.image.RasterFormatException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import com.sun.jna.platform.win32.KnownFolders;
import com.sun.jna.platform.win32.Shell32Util;

import Extent_Report.extend_report;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.CellType;
import java.util.Properties;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.DateUtil;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.sikuli.script.FindFailed;
//import org.sikuli.script.Pattern;
//import org.sikuli.script.Screen;
import org.sikuli.script.SikuliException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import javax.imageio.ImageIO;
import javax.swing.filechooser.FileSystemView;

import org.apache.commons.io.FileUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.regex.Matcher;
//import java.awt.Color;
//import java.awt.image.BufferedImage;
//import javax.imageio.ImageIO;
//import java.io.File;
//import java.io.IOException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.server.handler.SendKeys;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.IClass;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import bsh.commands.dir;
import locators.DeficitAndSurplusLocationIdentificarion_Locators;
import locators.ERO_Cost_View_Locators;
import locators.ERO_Deviation_Report_Locators;
import locators.ERO_Mass_cost_update;
import locators.ERO_Optimizer_WHATIF_Locators;
import locators.ERO_Routing_Locators;
import locators.Map_view_locators;
import locators.Optimizer_Report_Gate_locators;
import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import testng.reports.logging.LogAs;

public class Keywords extends extend_report
		implements DeficitAndSurplusLocationIdentificarion_Locators,ERO_Deviation_Report_Locators,ERO_Routing_Locators,ERO_Optimizer_WHATIF_Locators,Map_view_locators,Optimizer_Report_Gate_locators,ERO_Mass_cost_update,ERO_Cost_View_Locators {

	public static List<String> global=new ArrayList<>();
		public String ElementWait = Utils.getDataFromTestConfig("Wait Time");
	public int WaitElementSeconds = new Integer(ElementWait);
	public String Main_Window = "";
	public ArrayList<String> tabs;
	public WebElement fromElement;
	public ITestResult result;
	public String report_Filepath = Utils.getDataFromTestConfig("Reports  path");
	public String date = getCurrentDate();
	public String folder_name = report_Filepath.concat(date);
	public String folder_name_subfolder = folder_name.concat("/");
	public String report_folder_create = folder_name_subfolder;
	public String report_name = "PocReport";
	public String filepath_date_concat = folder_name_subfolder.concat(report_name).concat(".html");
	public String screenshot_folder_name = folder_name_subfolder.concat("Screenshot");
	public String screenshot_folder_path = screenshot_folder_name.concat("/");
	public String screenshot_folder_create = screenshot_folder_path;
	public String firstValue;
	public String secondValue;
	public static ExtentTest test;
	public static ExtentTest test1;

	List<String> Encryptedpassword = new ArrayList<>();
	
	public static String testExecutionFile=System.getProperty("user.dir") +Utils.getDataFromTestConfig("TestExeFile");

	public String getCurrentDate() {
		Format formatter = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date date = new Date();
		String value = formatter.format(date);
		return value;
	}

	public static String[] splitXpath(String path) {
		String[] a = path.split(">");
		return a;
	}

	@SuppressWarnings("serial")
	public static class CustomTestResult implements ITestResult {
		public int status;

		@Override
		public int getStatus() {
			return status;
		}

		public void setStatus(int status) {
			this.status = status;
		}

		@Override
		public Object getAttribute(String name) {
			// TODO Auto-generated method stub
			return name;
		}

		@Override
		public void setAttribute(String name, Object value) {
			// TODO Auto-generated method stub

		}

		@Override
		public Set<String> getAttributeNames() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Object removeAttribute(String name) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int compareTo(ITestResult o) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public ITestNGMethod getMethod() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Object[] getParameters() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void setParameters(Object[] parameters) {
			// TODO Auto-generated method stub

		}

		@Override
		public IClass getTestClass() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Throwable getThrowable() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void setThrowable(Throwable throwable) {
			// TODO Auto-generated method stub

		}

		@Override
		public long getStartMillis() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public long getEndMillis() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public void setEndMillis(long millis) {
			// TODO Auto-generated method stub

		}

		@Override
		public String getName() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean isSuccess() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public String getHost() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Object getInstance() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getTestName() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getInstanceName() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ITestContext getTestContext() {
			// TODO Auto-generated method stub
			return null;
		}

		// Other methods from ITestResult interface can be implemented as needed
		// For simplicity, we only include methods required for setting status in this
		// example
	}

	public String screenshot(WebDriver driver, String screenshotName) {
		String image_dest = null;
		try {

			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			String currenttime = new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime());
			image_dest = System.getProperty("user.dir").concat("\\snaptrude\\" + currenttime + screenshotName)
					.concat(".png");
			System.out.println(image_dest);
			File destination = new File(image_dest);
			FileUtils.copyFile(source, destination);
			return image_dest;
		} catch (Exception e) {
			System.out.println("Exception while taking Screenshot" + e.getMessage());
			return e.getMessage();
		}
	}

	public void wait(WebDriver driver, String inputData) {
		try {
			int time = Integer.parseInt(inputData);
			int seconds = time * 1000;
			Thread.sleep(seconds);
		} catch (InterruptedException e) {
			Extent_fail(driver, "Unable to wait ", test, test1);
			Assert.fail();
		}
	}

	public void waitForElement(WebDriver driver, String xpath) {
		String[] values = splitXpath(xpath);
		try {
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(values[1])));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(values[1])));
		} catch (Exception e) {
			Extent_fail(driver, "Element is not present ' " + values[0] + " ' || " + e.getLocalizedMessage(), test,
					test1);
			Assert.fail();
		}
	}

	public void Fluentwait(WebDriver driver, String xpath) {

		String[] values = splitXpath(xpath);

		try {
			// Declare and initialize a fluent wait
			FluentWait<WebDriver> wait = new FluentWait<>(driver).withTimeout(60, TimeUnit.SECONDS)
					.pollingEvery(3, TimeUnit.SECONDS) ; // Specify exceptions to ignore

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(values[1])));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(values[1])));

		} catch (Exception e) {
			e.printStackTrace();
			Extent_fail(driver, "Element '' " + values[0] + " '' is not present || " + e.getLocalizedMessage(), test,
					test1);
		}
	}

	public void Fluentwait1(WebDriver driver, String xpath) {

		String[] values = splitXpath(xpath);

		try {

			FluentWait<WebDriver> wait = new FluentWait<>(driver).withTimeout(200, TimeUnit.SECONDS) // Specify the
																										// timeout of
																										// the wait
					.pollingEvery(30, TimeUnit.SECONDS) // Specify polling time
					.ignoring(NoSuchElementException.class); // Specify exceptions to ignore

			// Wait until the element is present
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(values[1])));
		} catch (Exception e) {
			e.printStackTrace();
			Extent_fail(driver, "Element '' " + values[0] + " '' is not present || " + e.getLocalizedMessage(), test,
					test1);
		}
	}

	public void Fluentwait2(WebDriver driver, String xpath) {
		String[] values = splitXpath(xpath);
		// Declare and initialise a fluent wait
		try {
			// Declare and initialize a fluent wait
			FluentWait<WebDriver> wait = new FluentWait<>(driver).withTimeout(200, TimeUnit.SECONDS) // Specify the
																										// timeout of
																										// the wait
					.pollingEvery(30, TimeUnit.SECONDS) // Specify polling time
					.ignoring(NoSuchElementException.class); // Specify exceptions to ignore

			// Wait until the element is present

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(values[1])));
		} catch (Exception e) {
			e.printStackTrace();
			Extent_fail(driver, "Element '' " + values[0] + " '' is not present || " + e.getLocalizedMessage(), test,
					test1);
		}
	}

	public void Movetoelement(WebDriver driver, String xpath) {
		String[] values = splitXpath(xpath);
		// Declare and initialise a fluent wait

		try {
			Actions act = new Actions(driver);

			WebElement element = driver.findElement(By.xpath(values[1]));
			act.moveToElement(element).build().perform();
			wait(driver, "1");
			act.release(element).build().perform();
			wait(driver, "1");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
		}

	}

	public void waitForElement1(WebDriver driver, String xpath) {
		String[] values = splitXpath(xpath);
		try {
			WebDriverWait wait = new WebDriverWait(driver, 150);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(values[1])));
		} catch (Exception e) {
			Extent_fail(driver, "Element '' " + values[0] + " is not present || " + e.getLocalizedMessage(), test,
					test1);
		}
	}

	@SuppressWarnings("deprecation")
	public void waitForWebElement(WebDriver driver, WebElement element, String Name) {
		try {

			FluentWait<WebDriver> wait = new FluentWait<>(driver).withTimeout(120, TimeUnit.SECONDS)
					.pollingEvery(30, TimeUnit.SECONDS) // Specify polling time
					.ignoring(NoSuchElementException.class);

			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Extent_fail(driver, "Element '' " + Name + " is Not clickable || " + e.getLocalizedMessage(), test, test1);
		}
	}

	public void waitForElement5(WebDriver driver, String xpath) {
		String[] values = splitXpath(xpath);
		try {
			WebDriverWait wait = new WebDriverWait(driver, 120);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(values[1])));
			Extent_pass(driver, "Wait for the Element " + values[0] + values[0], test, test1);

		} catch (Exception e) {
			e.printStackTrace();
			Extent_fail(driver, "Element '' " + values[0] + " '' is not found || " + e.getLocalizedMessage(), test,
					test1);
		}
	}

	public void click(WebDriver driver, String Xpath) {
		String[] values = splitXpath(Xpath);
		try {

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			WebDriverWait wait = new WebDriverWait(driver, 60);

			wait.until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd)
					.executeScript("return document.readyState").equals("complete"));
			wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath(values[1]))));

			WebElement element = driver.findElement(By.xpath(values[1]));
			element.click();

			Extent_pass(driver, "Element ''" + values[0] + " '' is present on the screen and the element is clicked",
					test, test1);
			System.out.println("Element ''" + values[0] + " '' is present on the screen and the element is clicked");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Unable to click on " + values[0] + " || " + e.getLocalizedMessage());
			Extent_fail(driver, "Unable to click on " + values[0] + " || " + e.getLocalizedMessage(), test, test1);
			}

	}

	public void waitclick(WebDriver driver, String Xpath) {

		String[] values = splitXpath(Xpath);

		try {

			int attempts = 0;
			while (attempts < 4) {
				try {
					driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
					WebDriverWait wait = new WebDriverWait(driver, 30);
					wait.until(ExpectedConditions
							.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath(values[1]))));
					wait.until(
							ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath(values[1]))));
					WebElement element = driver.findElement(By.xpath(values[1]));
					element.click();
					break;
				} catch (ElementClickInterceptedException e) {
					attempts++;
					// Optional: add a small wait here before retrying
					Thread.sleep(500);
				}
			}

			Extent_pass(driver, "Element ''" + values[0] + " '' is present on the screen and the element is clicked",
					test, test1);
			System.out.println("Element ''" + values[0] + " '' is present on the screen and the element is clicked");

		} catch (Exception e) {
			e.printStackTrace();

			Extent_fail(driver, "Unable to click on " + values[0] + " || " + e.getLocalizedMessage(), test, test1);
			System.out.println("Unable to click on " + values[0] + " || " + e.getLocalizedMessage());
			Assert.fail();
		}

	}

	public void WebElementClick(WebDriver driver, WebElement element, String field) {

		try {

			WebDriverWait wait = new WebDriverWait(driver, 30);

			wait.until(ExpectedConditions.elementToBeClickable(element));

			element.click();

			Extent_pass(driver, "Clicked on the " + field, test, test1);

		} catch (Exception e) {

			e.printStackTrace();

			Extent_fail(driver, "Unable to click on " + e.getLocalizedMessage(), test, test1);
		}
	}

	public void WebElementJsClick(WebDriver driver, WebElement element, String field) {

		try {

			WebDriverWait wait = new WebDriverWait(driver, 30);

			wait.until(ExpectedConditions.elementToBeClickable(element));

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", element);

			Extent_pass(driver, "Clicked on the " + field, test, test1);

		} catch (Exception e) {

			e.printStackTrace();

			Extent_fail(driver, "Unable to click on " + e.getLocalizedMessage(), test, test1);
			//// add1(driver, "Unable to click on " + field + "- " +
			//// e.getLocalizedMessage(), true,
//					field);
		}
	}

	public void Jsclick(WebDriver driver, String path) {
		String[] values = splitXpath(path);
		try {
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			WebElement webElement = driver.findElement(By.xpath(values[1]));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", webElement);
			System.out.println(values[0] + " clicked");

			Extent_pass(driver, "Element " + values[0] + " is present on the screen and the element is clicked", test,
					test1);
		} catch (Exception e) {
			System.out.println(" Exception " + e);
			Extent_fail(driver, "Unable to click on " + values[0] + e.getLocalizedMessage(), test, test1);
		}
	}

	public void switchToActiveElement(WebDriver driver) {
		try {
			driver.switchTo().activeElement();
		} catch (Exception e) {
		}
	}

	@SuppressWarnings("deprecation")
	public void Actionclick(WebDriver driver, String path) {
		String[] values = splitXpath(path);
		try {
			WebElement webElement = driver.findElement(By.xpath(values[1]));
			Actions actions = new Actions(driver);
			actions.moveToElement(webElement).click().build().perform();
			Extent_pass(driver, "Element " + values[0] + " is present on the screen and the element is clicked", test,
					test1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Extent_fail(driver, "Unable to click on " + values[0] + e.getLocalizedMessage(), test, test1);
		}
	}

	@SuppressWarnings("deprecation")
	public void waitForTexttopresent(WebDriver driver, String xpath, String text) {
		String[] values = splitXpath(xpath);
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			// int WaitElementSeconds1 = new Integer(ElementWait);
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(values[1])));
			wait.until(ExpectedConditions.textToBePresentInElement(By.xpath(values[1]), text));
//			//add(driver, "Wait for the Text " + //values[0], LogAs.PASSED, true, //values[0]);
			Extent_pass(driver, "Expected Text Found on - " + values[0], test, test1);
		} catch (Exception e) {
//			////add1(driver, "Text Not Found - " + //values[0] + "- " + e.getLocalizedMessage() + e,  true,
//					//values[0]);
			Extent_fail(driver, "Expected Text Not Found on- " + values[0], test, test1);
		}
	}

	public String clearAndType(WebDriver driver, String xpaths, String keysToSend) {
		String[] values = splitXpath(xpaths);
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebDriverWait wait1 = new WebDriverWait(driver, 20);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(values[1])));

			WebElement webElement = driver.findElement(By.xpath(values[1]));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].value='';", webElement);
			js.executeScript("arguments[0].click();", webElement);

			wait(driver, "1");
			js.executeScript("arguments[0].value=" + "\'" + keysToSend + "\'" + ";", webElement);

			Extent_pass(driver, "Clear and Type on " + values[0], test, test1);
		} catch (Exception e) {

			Extent_fail(driver, "Unable to type on " + values[0] + "- " + e.getLocalizedMessage(), test, test1);
		}
		return keysToSend;
	}

	public void doubleClick(WebDriver driver, String element) {

		String[] values = splitXpath(element);
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement webElement = driver.findElement(By.xpath(values[1]));
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			
			wait.until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd)
					.executeScript("return document.readyState").equals("complete"));
			wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath(values[1]))));
			
			Actions action = new Actions(driver).doubleClick(webElement);
			action.build().perform();
			// add(driver, "Double click on " + //values[0], LogAs.PASSED, true,
			// //values[0]);
			Extent_pass(driver, "Double click on " + values[0], test, test1);
		} catch (Exception e) {

			Extent_fail(driver, "Unable to do a double click on " + values[0], test, test1);

		}
	}

	public String sendKeys(WebDriver driver, String xpaths, String keysToSend) {
		String[] values = splitXpath(xpaths);

		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebDriverWait wait1 = new WebDriverWait(driver, 20);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(values[1])));

			WebElement webElement = driver.findElement(By.xpath(values[1]));
			webElement.sendKeys(keysToSend);

			Extent_pass(driver, "Type on " + values[0], test, test1);
			wait(driver, "1");
		} catch (Exception e) {
			e.printStackTrace();
			Extent_fail(driver, "Unable to type on " + values[0] + e.getLocalizedMessage(), test, test1);
		}
		return keysToSend;

	}

	public String ActionsendKeys(WebDriver driver, String xpaths, String keysToSend) {
		String[] values = splitXpath(xpaths);

		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement webElement = driver.findElement(By.xpath(values[1]));
			Actions act = new Actions(driver);

			act.sendKeys(webElement, keysToSend).build().perform();

			Extent_pass(driver, "Type on " + values[0], test, test1);
			wait(driver, "1");
		} catch (Exception e) {
			e.printStackTrace();
			Extent_fail(driver, "Unable to type on " + values[0] + e.getLocalizedMessage(), test, test1);
		}
		return keysToSend;

	}

	public void clear(WebDriver driver, String xpaths) {
		String[] values = splitXpath(xpaths);
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement webElement = driver.findElement(By.xpath(values[1]));
			webElement.clear();
			Extent_pass(driver, "Clear on " + values[0], test, test1);
		} catch (Exception e) {
			Extent_fail(driver, "Unable to clear the text on " + values[0] + "- " + e.getLocalizedMessage(), test,
					test1);
		}
	}

	public void selectByIndex(WebDriver driver, String xpaths, String inputData) {
		String[] values = splitXpath(xpaths);
		try {
			WebElement webElement = driver.findElement(By.xpath(values[1]));
			Integer index = new Integer(inputData);
			Select selectBox = new Select(webElement);
			selectBox.selectByIndex(index);
			Extent_pass(driver, "Select the Dropdown by Index " + values[0], test, test1);
		} catch (Exception e) {
			Extent_fail(driver, "Unable to select the Dropdown by Index " + values[0], test, test1);
		}
	}

	public void selectByText(WebDriver driver, String xpaths, String inputData) {
		String[] values = splitXpath(xpaths);
		try {
			Select selectBox = new Select(driver.findElement(By.xpath(values[1])));
			selectBox.selectByVisibleText(inputData);
			Extent_pass(driver, "Select the Dropdown by text " + values[0], test, test1);
		} catch (Exception e) {
			Extent_fail(driver, "Unable to select the Dropdown by text " + values[0], test, test1);
		}
	}

	public void selectByValue(WebDriver driver, String xpaths, String inputData) {
		String[] values = splitXpath(xpaths);
		try {

			WebElement webElement = driver.findElement(By.xpath(values[1]));
			Select selectBox = new Select(webElement);
			selectBox.selectByValue(inputData);
			Extent_pass(driver, "Select the Dropdown by Value " + values[0], test, test1);
		} catch (Exception e) {
			Extent_fail(driver, "Unable to select the Dropdown by Value " + values[0], test, test1);
		}
	}

	public String getText(WebDriver driver, String xpath) {
		String[] values = splitXpath(xpath);
		try {
			WebElement webElement = driver.findElement(By.xpath(values[1]));
			String text = webElement.getText();
			Extent_pass(driver, "The value ' " + text + " ' is retrieved from the element ' " + values[0], test, test1);
			return text;

		} catch (Exception e) {
			Extent_fail(driver, "Unable to retrieve the text " + values[0] + "- " + e.getLocalizedMessage(), test,
					test1);
			return null;
		}
	}

	public String getcopiedText(WebDriver driver) {

		String storedValue = "";
		try {
			// Get the system clipboard
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

			// Get the clipboard contents
			Transferable contents = clipboard.getContents(null);

			// Check if clipboard content is of type String
			if (contents != null && contents.isDataFlavorSupported(DataFlavor.stringFlavor)) {
				// Get the copied value as a string
				String copiedValue = (String) contents.getTransferData(DataFlavor.stringFlavor);

				// Store the copied value in a string variable
				storedValue = copiedValue;

				// Print the stored value
//                System.out.println("Stored Value: " + storedValue);
			} else {
				System.out.println("No string data in clipboard.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
		}
		return storedValue;
	}

	public String getTextofWebelement(WebDriver driver, WebElement element, String Text) {

		try {
			String text = element.getText();
//			Extent_pass(driver, "The value ' " + text + " ' is retrieved from the element ' " + Text,test,test1);
			return text;

		} catch (Exception e) {
			Extent_fail(driver, "Unable to retrieve the text " + Text + "- " + e.getLocalizedMessage(), test, test1);

			//// add1(driver, "Unable to retrieve the text " + Text + "- " +
			//// e.getLocalizedMessage(), true,
//					Text);
			return null;
		}
	}

	public void newTab2(WebDriver driver) {

		try {
			((JavascriptExecutor) driver).executeScript("window.open()");

			// Switch to the new tab
			ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
			wait(driver, "1");
			driver.switchTo().window(tab.get(tab.size() - 1));
			wait(driver, "2");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
		}

	}

	public static void waitTime(WebDriver driver, String waitSeconds) {
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(waitSeconds), TimeUnit.SECONDS);
	}

	 public  void scrollUp(WebDriver driver) {
		 try {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.scrollBy(0, -1000)","");
	        wait(driver,"2");
		 }catch  (Exception e){
			 Assert.fail(); 
		 }
	    }
	
	
	public void scrollBottom(WebDriver driver) {
		try {

			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scroll(0,-10000)", "");
			waitTime(driver, "5");
			// //add(driver, "Scrolled to the bottom ", LogAs.PASSED, true, "Not");
		} catch (Exception e) {
			// ////add1(driver, "Unable to scroll to the bottom", true, "Not");
			Assert.fail();
		}
	}

	
	public boolean verifyElementIsPresent(WebDriver driver, String xpath) {
		String[] values = splitXpath(xpath);
		try {
			WebElement element = driver.findElement(By.xpath(values[1]));
			element.isDisplayed();
			// add(driver, "Element '" + //values[0] + "' is verified ", LogAs.PASSED, true,
			// //values[0]);
			Extent_pass(driver, "Element '" + values[0] + "' is present ", test, test1);
			return true;
		} catch (NoSuchElementException e) {
			//// add1(driver, "Element is Not Present " + //values[0] + "- " +
			//// e.getLocalizedMessage(), true,
			// values[0]);
			Extent_fail(driver, "Element is Not Present " + values[0], test, test1);
			return true;
		}
	}

	public void verifyElementHasText(WebDriver driver, String xpath) {
		String[] values = splitXpath(xpath);
		try {
			String text = driver.findElement(By.xpath(values[1])).getText();
			if (!text.equals("")) {
				// add(driver, "Element '" + //values[0] + "' has text " + text, LogAs.PASSED,
				// true, //values[0]);
			} else {
				//// add1(driver, "No text on the element " + //values[0], true, //values[0]);
				Assert.fail();
			}
		} catch (NoSuchElementException e) {
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
		}
	}

	public boolean isDisplayed(WebDriver driver, String xpath) {
		String[] values = splitXpath(xpath);
		try {
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			WebElement webElement = driver.findElement(By.xpath(values[1]));
			return webElement.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isClear(WebDriver driver, String xpath) {
		String[] values = splitXpath(xpath);
		try {
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			WebElement webElement = driver.findElement(By.xpath(values[1]));
			webElement.clear();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isDisplayed1(WebDriver driver, WebElement element) {
		try {
			return element.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isClickable(WebDriver driver, String xpath) {
		String[] values = splitXpath(xpath);
		try {
			WebElement webElement = driver.findElement(By.xpath(values[1]));
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
			return webElement.isEnabled();
		} catch (Exception e) {
			return false;
		}
	}

	public void elementnotvisible(WebDriver driver, String xpath) {
		String[] values = splitXpath(xpath);
		try {

			WebElement webElement = driver.findElement(By.xpath(values[1]));
			for (int i = 1; i <= 100; i++) {

				boolean flag = webElement.isDisplayed();

				if (flag == true) {
					Thread.sleep(3000);
				} else {
					break;
				}
			}

		} catch (Exception e) {
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
		}
	}

	public void closetab(WebDriver driver) {

		try {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_W);
			wait(driver, "2");
			r.keyRelease(KeyEvent.VK_CONTROL);
			r.keyRelease(KeyEvent.VK_W);
			wait(driver, "2");
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(0));
			wait(driver, "5");

		} catch (Exception e) {
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
		}
	}

	public void horizontalscroll(WebDriver driver, String xpath, int input) {
		String[] values = splitXpath(xpath);
		try {
			WebElement element = driver.findElement(By.xpath(values[1]));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollLeft += " + input + ";", element);

		} catch (Exception e) {

			Extent_fail(driver, "Unable to Scroll - " + values[0] + "- " + e.getLocalizedMessage(), test, test1);
		}
	}

	public void scrolltill(WebDriver driver) {
		try {

			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scroll(-3000)", "");
			waitTime(driver, "5");
		} catch (Exception e) {
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
		}
	}

	public void goBack(WebDriver driver) {

		try {
			driver.navigate().back();
			Extent_pass(driver, "Go Back", test, test1);

		} catch (Exception e) {

			Extent_fail(driver, "Unable to Go Back" + e.getLocalizedMessage(), test, test1);
			Assert.fail();

		}
	}

	public void waitTillVisibilityElement(WebDriver driver, String xpath) {
		String[] values = splitXpath(xpath);

		try {
			driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			WebElement webElement = driver.findElement(By.xpath(values[1]));
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(webElement));
			Extent_pass(driver, "Waited till the element is visible" + values[0], test, test1);
		} catch (Exception e) {
			Extent_fail(driver, "Unable to wait till an element is visible" + values[0] + e.getLocalizedMessage(), test,
					test1);
		}
	}

	public boolean IsElementEnabled(WebDriver driver, String xpath) {
		String[] values = splitXpath(xpath);
		try {
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			WebElement webElement = driver.findElement(By.xpath(values[1]));
			webElement.isEnabled();
			// add(driver, "Element is enabled" + values[0], LogAs.PASSED, true,
			// //values[0]);
			return webElement.isEnabled();
		} catch (Exception e) {
			// add(driver, "Element is not enabled", true, //values[0]);
//			Extent_fail(driver, "Element ' " + values[0] + " ' is not enabled " + e.getLocalizedMessage(), test, test1);
//			global = "Element not in enable status " + values[0] + " - " + e.getLocalizedMessage();
			return false;
		}

	}

	public int getRandomNum(WebDriver driver, int upperlimit) {
		List<Integer> randomZeroToSeven = new ArrayList<>();
		for (int i = 1; i <= upperlimit; i++) {
			randomZeroToSeven.add(i);
		}
		Collections.shuffle(randomZeroToSeven);

		return randomZeroToSeven.get(0);

	}

	public void deSelectByIndex(WebDriver driver, String xpath, String inputData) {
		String[] values = splitXpath(xpath);
		try {
			WebElement webElement = driver.findElement(By.xpath(values[1]));
			Integer index = new Integer(inputData);
			Select selectBox = new Select(webElement);
			selectBox.deselectByIndex(index);
			// add(driver, "Deselect the dropdown by index " + //values[0], LogAs.PASSED,
			// true, values[1]);
			Extent_pass(driver, "Deselect the dropdown by index " + values[0], test, test1);
		} catch (Exception e) {
			//// add1(driver, "Unable to deselect the dropdown by index" + values[0], true,
			//// values[1]);
			Extent_fail(driver, "Unable to deselect the dropdown by index of " + values[0] + e.getLocalizedMessage(),
					test, test1);
		}
	}

	public void deSelectByValue(WebDriver driver, String xpath, String inputData) {
		String[] values = splitXpath(xpath);
		try {
			WebElement webElement = driver.findElement(By.xpath(values[1]));
			Select selectBox = new Select(webElement);
			selectBox.deselectByValue(inputData);
			// add(driver, "Deselect the dropdown by index " + //values[0], LogAs.PASSED,
			// true, values[1]);
			Extent_pass(driver, "Deselect the dropdown by value " + values[0], test, test1);
		} catch (Exception e) {
			// add(driver, "Unable to deselect the dropdown by index" + //values[0], true,
			// values[1]);
			Extent_fail(driver, "Unable to deselect the dropdown by value" + values[0] + e.getLocalizedMessage(), test,
					test1);
		}
	}

	public void getWindow(WebDriver driver, String path) {
		try {
			waitTime(driver, "5");
			Main_Window = driver.getWindowHandle();
			System.out.println("Main_Window:" + Main_Window);
			String[] values = splitXpath(path);
			WebElement webElement = driver.findElement(By.xpath(values[1]));
			webElement.click();
			Thread.sleep(500);
			ArrayList<String> allWindows = new ArrayList<String>(driver.getWindowHandles());
			System.out.println("2nd Window:" + allWindows.get(1));
			driver.switchTo().window(allWindows.get(1));
		} catch (InterruptedException e) {
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
		}
	}

	public void switchWindow(WebDriver driver) {
		try {
			driver.switchTo().window(Main_Window);
		} catch (Exception e) {
		}
	}

	public void switchDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	public void dragElement(WebDriver driver, String xpath) {
		String[] values = splitXpath(xpath);
		try {
			WebElement webElement = driver.findElement(By.xpath(values[1]));
			fromElement = webElement;
			Extent_pass(driver, "Drag an element " + values[0], test, test1);
		} catch (Exception e) {
			Extent_fail(driver, "Unable to drag an element " + values[0], test, test1);
		}

	}

	public void dropElement(WebDriver driver, String xpath) {
		String[] values = splitXpath(xpath);
		try {
			WebElement webElement = driver.findElement(By.xpath(values[1]));
			Actions action = new Actions(driver);
			Action dragDrop = action.dragAndDrop(fromElement, webElement).build();
			dragDrop.perform();
			Extent_pass(driver, "Drop an element " + values[0], test, test1);
		} catch (Exception e) {
			Extent_fail(driver, "Unable to drag an element " + values[0], test, test1);
		}
	}

	public void DragAndDrop(WebDriver driver, String drag, String drop) {
		String[] values = splitXpath(drag);
		String[] values2 = splitXpath(drop);
		try {
			WebElement webElement = driver.findElement(By.xpath(values[1]));
			WebElement webElement1 = driver.findElement(By.xpath(values2[1]));
			Actions action = new Actions(driver);
			action.moveToElement(webElement).clickAndHold();
			wait(driver, "3");
			action.moveToElement(webElement).release(webElement1).build().perform();
			Extent_pass(driver, "Drag and Drop an element " + values[0], test, test1);
		} catch (Exception e) {
			//// add1(driver, "Unable to drag and drop an element " + //values[0], true,
			//// //values[0]);
			Extent_fail(driver, "Unable to drag and drop an element " + values[0] + e.getLocalizedMessage(), test,
					test1);
		}
	}

	public void DragAndDrop_Webelement(WebDriver driver, WebElement element1, WebElement element2) {

		try {
			Actions action = new Actions(driver);
			action.moveToElement(element1).clickAndHold();
			wait(driver, "2");
			action.moveToElement(element1).release(element2).build().perform();
			Extent_pass(driver, "Drag and Drop an element ", test, test1);
		} catch (Exception e) {
			Extent_fail(driver, "Unable to drag and drop an element " + e.getLocalizedMessage(), test, test1);
		}
	}

	public boolean isElementSelected(WebDriver driver, String xpaths) {
		String[] values = splitXpath(xpaths);
		try {
			WebElement webElement = driver.findElement(By.xpath(values[1]));
			webElement.isSelected();
			// add(driver, "Verified Element is selected " + //values[0], LogAs.PASSED,
			// true, //values[0]);
			Extent_pass(driver, "Verified Element is selected " + values[0], test, test1);
			return true;
		} catch (NoSuchElementException e) {

			//// add1(driver, "Element is not selected " + //values[0], true, //values[0]);
			Extent_fail(driver, "Element is not selected " + values[0] + e.getAdditionalInformation(), test, test1);
			return false;
		}
	}

	public void IstextPresent(WebDriver driver, String inputData) {
		if (driver.getPageSource().contains(inputData)) {
			// add(driver, "Text is Present " + inputData, LogAs.PASSED, true, inputData);
		} else {
			//// add1(driver, "Text is not Present " + inputData, true, inputData);
			Extent_fail(driver, "Text is not Present " + inputData, test, test1);
		}
	}

	public void waitTillTextIsLoaded(WebDriver driver, String xpath, String inputData) {
		String[] values = splitXpath(xpath);
		try {
			WebElement webElement = driver.findElement(By.xpath(values[1]));
			WebDriverWait waits = new WebDriverWait(driver, WaitElementSeconds);
			waits.until(ExpectedConditions.textToBePresentInElement(webElement, inputData));
			// add(driver, "Waited till the text " + inputData + " is loaded", LogAs.PASSED,
			// true, inputData);
			Extent_pass(driver, "Waited till the text " + inputData + " is loaded", test, test1);
		} catch (Exception e) {
			//// add1(driver, "Unable to Wait till the text " + inputData + "- " +
			//// e.getLocalizedMessage() + " is loaded",
//					 true, inputData);
			Extent_fail(driver, "Unable to Wait till the text " + inputData + "- " + e.getLocalizedMessage(), test,
					test1);
		}
	}

	public void verifyTextIsNotPresent(WebDriver driver, String NormalXpath, String inputData) {
		try {
			WebDriverWait waits = new WebDriverWait(driver, WaitElementSeconds);
			waits.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath(NormalXpath), inputData));
			// add(driver, "Text is not present" + inputData, LogAs.PASSED, true,
			// inputData);
		} catch (Exception e) {
			//// add1(driver, "Text is present" + inputData + "- " +
			//// e.getLocalizedMessage(), true, inputData);
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
		}

	}

	public void isElementClickable(WebDriver driver, String xpath) {
		String[] values = splitXpath(xpath);
		try {
			WebElement webElement = driver.findElement(By.xpath(values[1]));
			WebDriverWait waits = new WebDriverWait(driver, WaitElementSeconds);
			waits.until(ExpectedConditions.elementToBeClickable(webElement));
			// add(driver, "Element is clickable " + //values[0], LogAs.PASSED, true,
			// //values[0]);
			Extent_pass(driver, "Element is clickable " + values[0], test, test1);
		} catch (Exception e) {
			Extent_fail(driver, "Element is not clickable " + values[0] + "- " + e.getLocalizedMessage(), test, test1);
		}
	}

	public void isElementSelectable(WebDriver driver, String xpath) {
		String[] values = splitXpath(xpath);
		try {
			WebElement webElement = driver.findElement(By.xpath(values[1]));
			WebDriverWait waits = new WebDriverWait(driver, WaitElementSeconds);
			waits.until(ExpectedConditions.elementToBeSelected(webElement));
			// add(driver, "Element is selectable " + //values[0], LogAs.PASSED, true,
			// //values[0]);
			Extent_pass(driver, "Element is selectable " + values[0], test, test1);
		} catch (Exception e) {
			Extent_fail(driver, "Element is not selectable " + values[0], test, test1);
		}
	}

	public void waitUntilVisibilityOfElement(WebDriver driver, String xpath) {
		String[] values = splitXpath(xpath);
		try {
			WebElement webElement = driver.findElement(By.xpath(values[1]));
			WebDriverWait wait = new WebDriverWait(driver, WaitElementSeconds);
			wait.until(ExpectedConditions.visibilityOf(webElement));
			// add(driver, "Wait till the Element is visible " + //values[0], LogAs.PASSED,
			// true, //values[0]);
			Extent_pass(driver, "Wait till the Element is visible " + values[0], test, test1);
		} catch (Exception e) {
			Extent_fail(driver, "Element is not visible " + values[0] + "- " + e.getLocalizedMessage(), test, test1);
		}

	}

	public void waitForElementNotpresent(WebDriver driver, String xpath) {
		String[] values = splitXpath(xpath);
		try {
			WebDriverWait wait = new WebDriverWait(driver, WaitElementSeconds);
			wait.until(ExpectedConditions.not(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))));
			Extent_pass(driver, "Wait till the Element is visible " + values[0], test, test1);
		} catch (Exception e) {
			Extent_fail(driver, "Element is not visible " + values[0] + e.getLocalizedMessage(), test, test1);
		}
	}

	public void quit(WebDriver driver) {
		try {
			driver.quit();
		} catch (Exception e) {
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
		}
	}

	public void refreshPage(WebDriver driver) {
		try {
			waitTime(driver, "5");
			driver.navigate().refresh();
			waitTime(driver, "5");
		} catch (Exception e) {
			Assert.fail();
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
		}
	}

	public void maximize(WebDriver driver) {
		try {
			driver.manage().window().maximize();
		} catch (Exception e) {
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
			Assert.fail();
		}
	}

	public void keyTab(WebDriver driver) {
		try {
			Actions action = new Actions(driver);
			action.sendKeys(Keys.TAB).build().perform();

		} catch (Exception e) {
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
			Assert.fail();
		}
	}

	public void enter(WebDriver driver) {
		try {
			Actions actionObject = new Actions(driver);
			actionObject.sendKeys(Keys.ENTER).build().perform();
		} catch (Exception e) {
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
			Assert.fail();
		}
	}

	public String alertAccept(WebDriver driver, String path) {
		String[] values = splitXpath(path);

		try {
			WebElement webElement = driver.findElement(By.xpath(values[1]));
			webElement.click();
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			alert.accept();
			return alertText;
		} catch (Exception e) {
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
			return null;
		}
	}

	public boolean isAlertPresent(WebDriver driver) {
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	
	public void dismissAlert(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	public String promptBox(WebDriver driver, String path, String inputData) {
		String[] values = splitXpath(path);
		try {

			WebElement element = driver.findElement(By.xpath(values[1]));
			element.click();
			Alert alert = driver.switchTo().alert();
			driver.switchTo().alert().sendKeys(inputData);
			String alertText = alert.getText();
			alert.accept();
			return alertText;
		} catch (Exception e) {
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
			return null;
		}
	}

	public void switchToFrame(WebDriver driver, String frameName) {
		String[] values = splitXpath(frameName);
		try {
			WebElement element = driver.findElement(By.xpath(values[1]));
			driver.switchTo().frame(element);

		} catch (NoSuchFrameException e) {
			Extent_fail(driver, e.getAdditionalInformation(), test, test1);
		}
	}

	public void switchToDefaultFrame(WebDriver driver) {
		try {
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
			Assert.fail();
		}
	}

	public void escape(WebDriver driver) {

		Robot key;
		try {
			key = new Robot();

			key.keyPress(KeyEvent.VK_ESCAPE);
			key.delay(500);
			key.keyRelease(KeyEvent.VK_ESCAPE);
		} catch (Exception e) {
			e.printStackTrace();
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
		}

	}

	public void keyDown(WebDriver driver) {
		Actions actionObject = new Actions(driver);
		actionObject = actionObject.sendKeys(Keys.ARROW_DOWN);
		actionObject.perform();
	}

	public void keyUp(WebDriver driver) {
		Actions actionObject = new Actions(driver);
		actionObject = actionObject.sendKeys(Keys.ARROW_UP);
		actionObject.perform();
	}

	public void keyboardPageUp(WebDriver driver) {
		Actions actionObject = new Actions(driver);
		actionObject.keyDown(Keys.CONTROL).sendKeys(Keys.PAGE_UP).perform();
	}

	public void refreshUsingKeys(WebDriver driver) {
		Actions actionObject = new Actions(driver);
		actionObject.sendKeys(Keys.F5).perform();
	}

	public void keyboardPageDown(WebDriver driver) {
		Actions actionObject = new Actions(driver);
		actionObject.keyDown(Keys.CONTROL).sendKeys(Keys.PAGE_DOWN).perform();
		waitTime(driver, "5");
	}

	public void keyboardEnd(WebDriver driver) {
		Actions actionObject = new Actions(driver);
		actionObject.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		waitTime(driver, "5");
	}

	public void keyboardHome(WebDriver driver) {
		Actions actionObject = new Actions(driver);
		actionObject.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).perform();
		waitTime(driver, "5");
	}

	public void keyboardArrowUp(WebDriver driver) {
		Actions actionObject = new Actions(driver);
		actionObject.keyDown(Keys.CONTROL).sendKeys(Keys.ARROW_UP).perform();
	}

	public void keyboardArrowDown(WebDriver driver) {
		Actions actionObject = new Actions(driver);
		actionObject.keyDown(Keys.CONTROL).sendKeys(Keys.ARROW_DOWN).perform();
	}

	public void keyboardArrowLeft(WebDriver driver) {
		Actions actionObject = new Actions(driver);
		actionObject.keyDown(Keys.CONTROL).sendKeys(Keys.ARROW_LEFT).perform();
	}

	public void keyboardArrowRight(WebDriver driver) {
		Actions actionObject = new Actions(driver);
		actionObject.keyDown(Keys.CONTROL).sendKeys(Keys.ARROW_RIGHT).perform();
	}

	public void pageMaximizeUsingKey(WebDriver driver) {
		Actions actionObject = new Actions(driver);
		actionObject = actionObject.sendKeys(Keys.F11);
		actionObject.perform();
	}

	public void deleteAllCookies(WebDriver driver) {
		driver.manage().deleteAllCookies();

	}

	public void navigateUrl(WebDriver driver, String inputData) {
		try {
			if (inputData == null) {
//				//add(driver, " Navigated to " + inputData,  true, inputData);
				Extent_fail(driver, " Navigated to " + inputData, test, test1);
				Assert.fail(inputData);
			} else {
				driver.navigate().to(inputData);
//				//add(driver, " Navigated to " + inputData, LogAs.PASSED, true, inputData);
				Extent_pass(driver, " Navigated to " + inputData, test, test1);
				driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
		}

	}

	public void highLightElement(WebDriver driver, String xpath) {
		try {
			String[] values = splitXpath(xpath);
			WebElement webElement = driver.findElement(By.xpath(values[1]));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].setAttribute('style', arguments[1]);", webElement,
					"color: red; border: 3px solid red;");
			js.executeScript("arguments[0].setAttribute('style', arguments[1]);", webElement, "");
		} catch (Exception e) {
			e.printStackTrace();
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
		}
	}

	public void newTab(WebDriver driver) {
		try {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_T);
			r.keyRelease(KeyEvent.VK_CONTROL);
			wait(driver, "1");
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));
			wait(driver, "2");
		} catch (Exception e) {
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
		}
	}

	public void newTabpaste(WebDriver driver) {
		try {
			wait(driver, "5");
			Robot r = new Robot();
			r.delay(1000);
			r.keyPress(KeyEvent.VK_CONTROL);

			r.keyPress(KeyEvent.VK_T);
			wait(driver, "5");
			r.keyRelease(KeyEvent.VK_T);
			r.keyRelease(KeyEvent.VK_CONTROL);

			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));
			wait(driver, "5");
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_V);
			wait(driver, "5");
			r.keyPress(KeyEvent.VK_ENTER);
		} catch (Exception e) {
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
		}
	}

	public void closeTab(WebDriver driver) {
		try {
			driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "w");
			// tabs.remove(tabs.get(0));
			driver.switchTo().defaultContent();

			ArrayList<String> tabs1 = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs1.get(0));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
			
		}
	}

	public void closeTab1(WebDriver driver, int input) {
		try {
			driver.findElement(By.xpath("body")).sendKeys(Keys.CONTROL + "w");
			driver.switchTo().defaultContent();
			ArrayList<String> tabs1 = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs1.get(input));
		} catch (Exception e) {
			e.printStackTrace();
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
		}
	}

	public void switchtotab(WebDriver driver, int inputData) {
		try {
			Capabilities localCapabilities = ((RemoteWebDriver) driver).getCapabilities();
			String BROWSER_NAME = localCapabilities.getBrowserName().toLowerCase();
			if (BROWSER_NAME.equalsIgnoreCase("firefox")) {
				driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "\t");
				driver.switchTo().defaultContent();
				ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
				driver.switchTo().window(tabs.get(inputData));
			}
			if (BROWSER_NAME.equalsIgnoreCase("chrome")) {
				driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "\t");
				driver.switchTo().defaultContent();
				ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
				driver.switchTo().window(tabs.get(inputData));
				wait(driver, "2");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
		}
	}

	private static Object parse(String json) {
		// TODO Auto-generated method stub
		return null;
	}

	// Click to given day
	public static void clickGivenDay(List<WebElement> elementList, String day) {
		elementList.stream().filter(element -> element.getText().contains(day)).findFirst()
				.ifPresent(WebElement::click);
	}

	public static String getCurrentDay() {
		// Create a Calendar Object
		Calendar calendar = Calendar.getInstance(TimeZone.getDefault());

		// Get Current Day as a number
		int todayInt = calendar.get(Calendar.DAY_OF_MONTH);
		System.out.println("Today Int: " + todayInt + "\n");

		// Integer to String Conversion
		String todayStr = Integer.toString(todayInt);
		System.out.println("Today Str: " + todayStr + "\n");

		return todayStr;
	}

	public void Alert1(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public void takescreenshot(WebDriver driver, String screenshot_path) {
		try {
			File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			File dest = new File(System.getProperty("user.dir") + "/Screenshots" + screenshot_path + ".png");
			try {
				FileUtils.copyFile(scr, dest);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// add(driver, "Captured the screenshot " + "", LogAs.PASSED, true, "");
			Extent_pass(driver, "Click on " + "Screenshot", test, test1);
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Extent_fail(driver, e.getAdditionalInformation(), test, test1);
		}
		
	}

	public void takescreenshot1(WebDriver driver, String screenshot_path) {
		try {
			Robot robot = new Robot();

			// Define the region to capture using top-left and bottom-right coordinates
			int x1 = 0; // x-coordinate of the top-left corner
			int y1 = 230; // y-coordinate of the top-left corner
			int x2 = 1350; // x-coordinate of the bottom-right corner
			int y2 = 500; // y-coordinate of the bottom-right corner

			Rectangle captureRect = new Rectangle(x1, y1, x2, y2);

			BufferedImage screenCapture = robot.createScreenCapture(captureRect);

			// Save the screenshot
			File dest = new File(System.getProperty("user.dir") + "/Screenshots" + screenshot_path + ".png");
			ImageIO.write(screenCapture, "png", dest);

			System.out.println("Screenshot captured successfully!");

			// add(driver, "Captured the screenshot " + "", LogAs.PASSED, true, "");
			Extent_pass(driver, "Taken Screenshot for " + screenshot_path, test, test1);

		} catch (AWTException | IOException e) {
			e.printStackTrace();
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
		}

	}

	public String imageComparision(WebDriver driver, String ExpectedImage_path, String actualImage_path)
			throws IOException {
		String image_res = null;
		try {
			BufferedImage img1 = ImageIO.read(new File(
					System.getProperty("user.dir") + "/Screenshots/Expected_screenshot" + ExpectedImage_path + ".png"));
			BufferedImage img2 = ImageIO.read(new File(
					System.getProperty("user.dir") + "/Screenshots/Actual_screenshot" + actualImage_path + ".png"));
			int w1 = img1.getWidth();
			int w2 = img2.getWidth();
			int h1 = img1.getHeight();
			int h2 = img2.getHeight();
			long diff = 0;
			if ((w1 != w2) || (h1 != h2)) {
				System.out.println("Both images should have same dimwnsions");
			} else {

				for (int j = 0; j < h1; j++) {
					for (int i = 0; i < w1; i++) {
						// Getting the RGB values of a pixel
						int pixel1 = img1.getRGB(i, j);
						Color color1 = new Color(pixel1, true);
						int r1 = color1.getRed();
						int g1 = color1.getGreen();
						int b1 = color1.getBlue();
						int pixel2 = img2.getRGB(i, j);
						Color color2 = new Color(pixel2, true);
						int r2 = color2.getRed();
						int g2 = color2.getGreen();
						int b2 = color2.getBlue();
						// sum of differences of RGB values of the two images
						long data = Math.abs(r1 - r2) + Math.abs(g1 - g2) + Math.abs(b1 - b2);
						diff = diff + data;
					}
				}
				String s[] = ExpectedImage_path.split("/");
				double avg = diff / (w1 * h1 * 3);
				double percentage = (avg / 255) * 100;
				System.out.println("Difference: " + percentage);
				if (percentage < 0.5) {
					image_res = "Pass";

					// add(driver, s[1] + " - " + s[2] + " - Image compared sucessfully" + "",
					// LogAs.PASSED, true,
//							"diff.hasDiff()");
					System.out.println(s[1] + " - " + s[2] + " - Image compared sucessfully");

					Extent_pass(driver, "Click on " + " Expected and Actual images are same", test, test1);

				} else {
					//// add1(driver, s[1] + " - " + s[2] + " - Expected and Actual images are not
					//// same " + "",
//							true, "diff.hasDiff()");
					System.out.println(s[1] + " - " + s[2] + " - Expected and Actual images are not same ");
					Extent_fail(driver, "Unable to click on " + "Expected and Actual images are not same", test, test1);
					Assert.fail();

				}

			}
		} catch (Exception e) {
			System.out.println("Exception while taking Screenshot" + e.getMessage());
			return e.getMessage();
		}
		return image_res;

	}

	public static void disableToast(WebDriver driver) {

		try {

			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			Object de = js1.executeScript("store.exposed.autoSaveConfig.disableToasts()");
			System.out.println(de);

		}

		catch (Exception e1) {
			Assert.fail();
		}

	}


	public static boolean imageComparison(WebDriver driver, String expectedImagePath, String actualImagePath)
			throws IOException {
		try {
			BufferedImage img1 = ImageIO
					.read(new File("./Screenshots/Expected_screenshot" + expectedImagePath + ".png"));
			BufferedImage img2 = ImageIO.read(new File("./Screenshots/Actual_screenshot" + actualImagePath + ".png"));

			int w1 = img1.getWidth();
			int w2 = img2.getWidth();
			int h1 = img1.getHeight();
			int h2 = img2.getHeight();
			long diff = 0;

			if (w1 != w2 || h1 != h2) {
				System.out.println("Both images should have the same dimensions");
				return false;
			}

			for (int j = 0; j < h1; j++) {
				for (int i = 0; i < w1; i++) {
					int pixel1 = img1.getRGB(i, j);
					Color color1 = new Color(pixel1, true);
					int r1 = color1.getRed();
					int g1 = color1.getGreen();
					int b1 = color1.getBlue();

					int pixel2 = img2.getRGB(i, j);
					Color color2 = new Color(pixel2, true);
					int r2 = color2.getRed();
					int g2 = color2.getGreen();
					int b2 = color2.getBlue();

					long data = Math.abs(r1 - r2) + Math.abs(g1 - g2) + Math.abs(b1 - b2);
					diff += data;
				}
			}

			String[] s = expectedImagePath.split("/");
			double avg = (double) diff / (w1 * h1 * 3);
			double percentage = (avg / 255) * 100;
			System.out.println("Difference: " + percentage);

			if (percentage < 0.4) {
				System.out.println(s[1] + " - " + s[2] + " - Image compared successfully");
				return true;
			} else {
				System.out.println(s[1] + " - " + s[2] + " - Expected and Actual images are not the same");
				return false;
			}
		} catch (Exception e) {
			System.out.println("Exception while taking Screenshot: " + e.getMessage());
			e.printStackTrace(); 
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
			return false;
		}
	}

	public void uploadfile(WebDriver driver, String path) {
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement element = driver.findElement(By.xpath("(//input[@type='file'])[2]"));
			File file = new File(path);
			System.out.println(file.getAbsolutePath());
			element.sendKeys(file.getAbsolutePath());
			// add(driver, "uploaded the file " + path, LogAs.PASSED, true, path);
			wait(driver, "2");
		} catch (Exception e) {
			e.printStackTrace();
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
		}
	}
	
	public void uploadfile_xpath(WebDriver driver, String path,String xpath) {
		
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement element = driver.findElement(By.xpath(xpath));
			File file = new File(path);
			System.out.println(file.getAbsolutePath());
			element.sendKeys(file.getAbsolutePath());
			// add(driver, "uploaded the file " + path, LogAs.PASSED, true, path);
			wait(driver, "2");
		} catch (Exception e) {
			e.printStackTrace();

			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
		}
	}

	public void uploadfile1(WebDriver driver, String path) {
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement element = driver.findElement(By.xpath("//input[contains(@type,'file')]"));
			File file = new File(path);
			System.out.println(file.getAbsolutePath());
			element.sendKeys(file.getAbsolutePath());
			wait(driver, "2");
		} catch (Exception e) {
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
			e.printStackTrace();
			Assert.fail();
		}
	}

	public void uploadFileRobot(WebDriver driver, String fileLocation) {
		try {

			wait(driver, "10");
			StringSelection stringSelection = new StringSelection(fileLocation);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

		} catch (Exception e) {
			Extent_fail(driver,e.getLocalizedMessage() , test, test1);
		}
	}

	public void Upload_File(WebDriver driver, String Location, String xpaths) {
		String[] values = splitXpath(xpaths);
		Robot rb1;
		try {
			rb1 = new Robot();
			rb1.delay(1000);
			StringSelection ss = new StringSelection(Location);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

			rb1.keyPress(KeyEvent.VK_CONTROL);
			rb1.keyPress(KeyEvent.VK_V);
			rb1.keyRelease(KeyEvent.VK_V);
			rb1.keyRelease(KeyEvent.VK_CONTROL);
			wait(driver, "2");
			rb1.keyPress(KeyEvent.VK_ENTER);
			wait(driver, "10");
			WebElement webElement = driver.findElement(By.xpath(values[1]));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
					webElement);
			webElement.click();
			wait(driver, "2");
		} catch (AWTException e) {
			e.printStackTrace();
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
		}

	}

	public static void ActionTest(ExtentTest extentTest, ExtentTest extentTest1) throws Exception {
		test = extentTest;
		test1 = extentTest1;
	}

	public void Downloadedfile(String filename) {
		String os = System.getProperty("os.name").toLowerCase();
		String downloadPath = "";
		if (os.contains("win")) {
			// For Windows, using Shell32Util
			downloadPath = Paths.get(System.getProperty("user.home"), "Downloads").toString();
		} else {
			// Defaulting to user home directory if OS is not recognized
			downloadPath = System.getProperty("user.home");
		}

//		String downloadsPath = "C:\\Users\\TRACK\\Downloads";
		String downloadDir = downloadPath;
		File dir = new File(downloadDir);
		String Downloadedfile = "";

		if (dir.exists() && dir.isDirectory()) {
			File[] files = dir.listFiles((dir1, name) -> name.contains("" + filename + ".csv"));
			if (files != null && files.length > 0) {
				// Sort files by last modified timestamp in descending order
				Arrays.sort(files, Comparator.comparingLong(File::lastModified).reversed());
				// Get the first (latest) file
				File latestFile = files[0];
				Downloadedfile = latestFile.getAbsolutePath();
				System.out
						.println("Downloaded file was present in the downloads folder " + latestFile.getAbsolutePath());
				Extent_pass1(test,
						"Downloaded file was present in the downloads folder " + latestFile.getAbsolutePath());
			} else {
				System.out.println("Downloaded file was not present in the downloads folder ");
				Extent_fail1(test, "Downloaded file was present in the downloads folder ");
			}
		} else {
			System.out.println("Directory does not exist or is not a directory.");
			Extent_fail1(test, "Directory does not exist or is not a directory.");
		}

		System.out.println("Latestdownloaded_Zipfile :" + Downloadedfile);
		Extent_pass1(test, "Latestdownloaded_Zipfile :" + Downloadedfile);
		
	}

	public void click2(WebDriver driver, String path) {
		String[] values = splitXpath(path);
		try {

			WebElement parentElement = driver.findElement(By.xpath(values[1]));

			boolean flag = true;

			flag = parentElement.isSelected();

			System.out.println("flag : " + flag);

			if (flag == false) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", parentElement);
			}


		} catch (Exception e) {
			System.out.println(" Exception " + e);
			Assert.fail();
		}
	}
	
	public void write_data(String columnName, String str) {

		String filePath = System.getProperty("user.dir") + "\\uploads\\Script_Data's.xlsx";

		// Specify the sheet name
		String sheetName = "Sheet1";

		// New value to be set in the cell
		String newValue = str;

		try (FileInputStream fis = new FileInputStream(filePath);

				Workbook workbook = new XSSFWorkbook(fis)) {

			// Get the sheet
			Sheet sheet = workbook.getSheet(sheetName);

			// Get the row index (assuming you want to write to the first available row)
			int rowIndex = 1; // Row index

			// Get the row, create if it doesn't exist
			Row row = sheet.getRow(rowIndex);
			if (row == null) {
				row = sheet.createRow(rowIndex);
			}

			// Get the column index based on the column name
			int columnIndex = getColumnIndexByName(sheet, columnName);

			// Get the cell, create if it doesn't exist
			Cell cell = row.getCell(columnIndex);
			if (cell == null) {
				cell = row.createCell(columnIndex);
			}

			// Set the new value
			cell.setCellValue(newValue);

			// Write the changes back to the Excel file
			try (FileOutputStream fos = new FileOutputStream(filePath)) {
				workbook.write(fos);
			}

			System.out.println("Value updated successfully!");

		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}

	// Method to get the column index by column name

	public String Readdata(String Columnname) throws Exception {

		String filePath = System.getProperty("user.dir") + "\\uploads\\Script_Data's.xlsx";

		// Specify the sheet name
		String sheetName = "Sheet1";

		// Specify the row index (0-based)
		int rowIndex = 1; // Row index

		// Specify the column name
		String columnName = Columnname; // Column name

		FileInputStream fis = new FileInputStream(filePath);
		Workbook workbook = new XSSFWorkbook(fis);

		// Get the sheet
		Sheet sheet = workbook.getSheet(sheetName);

		// Get the row
		Row row = sheet.getRow(rowIndex);

		// Get the column index based on the column name
		int columnIndex = getColumnIndexByName(sheet, columnName);

		// Get the cell
		Cell cell = row.getCell(columnIndex);

		// Get the value from the cell
		String cellValue = cell.getStringCellValue(); // Assuming the cell contains string value

		// Print the cell value
		System.out.println("Cell Value: " + cellValue);

		return cellValue;
	}

	// Method to get the column index by column name
	public static int getColumnIndexByName(Sheet sheet, String columnName) {
		Row row = sheet.getRow(0); // Assuming the column names are in the first row
		for (int i = 0; i < row.getLastCellNum(); i++) {
			Cell cell = row.getCell(i);
			if (cell.getStringCellValue().equals(columnName)) {
				return i;
			}
		}
		throw new IllegalArgumentException("Column with name '" + columnName + "' not found.");
	}

	public String getTextColor(WebDriver driver, String Xpath) {
		String[] values = splitXpath(Xpath);
		try {
			WebElement eleSearch = driver.findElement(By.xpath(values[1]));
			String rgbFormat = eleSearch.getCssValue("color");
			String hexcolor = rgbToHex(rgbFormat);
			Extent_pass(driver, "Get the Text Color of " + values[0], test, test1);
			return hexcolor;
		} catch (Exception e) {
			System.out.println("Unable to get color of the element..!");
			Extent_fail(driver, "Unable to Get the Text Color of " + values[0], test, test1);
			return "";
		}

	}

	public static String rgbToHex(String rgb) {
		String[] rgbValues = rgb.replace("rgba(", "").replace(")", "").split(", ");
		int red = Integer.parseInt(rgbValues[0]);
		int green = Integer.parseInt(rgbValues[1]);
		int blue = Integer.parseInt(rgbValues[2]);

		return String.format("#%02X%02X%02X", red, green, blue);
	}

	public String getTextBackgroundColor(WebDriver driver, String Xpath) {
		String[] values = splitXpath(Xpath);
		try {
			WebElement eleSearch = driver.findElement(By.xpath(values[1]));

			String rgbFormat = eleSearch.getCssValue("background-color");

//					System.out.println(rgbFormat);     //In RGB Format the value will be print => rgba(254, 189, 105, 1)

			String hexcolor = rgbToHex(rgbFormat);
//					System.out.println(hexcolor);
			Extent_pass(driver, "Get the Text Background Color of " + values[0], test, test1);
			return hexcolor;
		} catch (Exception e) {
			System.out.println("Unable to get color of the element..!");
			Extent_fail(driver, "Unable to Get the Text Background Color of " + values[0], test, test1);
			return "";
		}

	}

	public String getTextBackgroundColor_element(WebDriver driver, WebElement element, String field) {

		try {

			String rgbFormat = element.getCssValue("background-color");

			String hexcolor = rgbToHex(rgbFormat);
			return hexcolor;
		} catch (Exception e) {
			System.out.println("Unable to get color of the element..!");
			Extent_fail(driver, "Unable to Get the Text Background Color of " + field, test, test1);
			return "";
		}

	}

	public String getAttribute(WebDriver driver, String xpath, String attribute) {
		String[] values = splitXpath(xpath);
		try {
			WebElement inputBox = driver.findElement(By.xpath(values[1]));
			String textInsideInputBox = inputBox.getAttribute(attribute);
			Extent_pass(driver, "Get the Attribute value of " + values[0], test, test1);
			return textInsideInputBox;
		} catch (NoSuchElementException e) {
			Extent_fail(driver, "Unable to Get the Attribute value of " + values[0], test, test1);
			return null;
		}
	}

	public String getAttribute_webelement(WebDriver driver, WebElement element, String attribute) {

		try {
			String textInsideInputBox = element.getAttribute(attribute);
			return textInsideInputBox;
		} catch (NoSuchElementException e) {
			Extent_fail(driver, "Unable to Get the Attribute value "+e.getAdditionalInformation(), test, test1);
			return null;

		}
	}

	public List<String> getUrl(WebDriver driver, String Testcasename, String Sheetname) {

		String excelFilePath = testExecutionFile;

		List<String> testCaseData = new ArrayList<>();
		// Add more lists if you have more test cases

		try {
			// Load the Excel file
			FileInputStream fis = new FileInputStream(excelFilePath);
			Workbook workbook = new XSSFWorkbook(fis);
			Sheet sheet = workbook.getSheet(Sheetname);

			// Iterate through each row in the sheet
			for (Row row : sheet) {
				// Get the first column (TestCase identifier)
				Cell testCaseCell = row.getCell(0);
				Cell conditionCell = row.getCell(1); // Column with condition ("yes")
				Cell dataCell = row.getCell(2); // Data to read if condition is "yes"

				// Check if the cells are not null and the condition is "yes"
				if (testCaseCell != null && conditionCell != null && dataCell != null
						&& "yes".equalsIgnoreCase(getCellValueAsString(conditionCell))) {
					String testCaseName = getCellValueAsString(testCaseCell);
					String dataValue = getCellValueAsString(dataCell);

					// Add the data value to the corresponding test case list
					if (Testcasename.equalsIgnoreCase(testCaseName)) {
						testCaseData.add(dataValue);
					}
					// Add more conditions if you have more test cases
				}
			}

			// Close the workbook and input stream
			workbook.close();
			fis.close();

			// Print the lists (for testing purposes)
			System.out.println("Test Case 1 Data: " + testCaseData);

		} catch (IOException e) {
			e.printStackTrace();
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
		}

		return testCaseData;

	}
	
	public List<String> getDataset(WebDriver driver, String Testcasename, String Sheetname) {

		String excelFilePath = testExecutionFile;

		List<String> testCaseData = new ArrayList<>();
		// Add more lists if you have more test cases

		try {
			// Load the Excel file
			FileInputStream fis = new FileInputStream(excelFilePath);
			Workbook workbook = new XSSFWorkbook(fis);
			Sheet sheet = workbook.getSheet(Sheetname);

			// Iterate through each row in the sheet
			for (Row row : sheet) {
				// Get the first column (TestCase identifier)
				Cell testCaseCell = row.getCell(0);
				Cell conditionCell = row.getCell(1); // Column with condition ("yes")
				Cell dataCell = row.getCell(3); // Data to read if condition is "yes"

				// Check if the cells are not null and the condition is "yes"
				if (testCaseCell != null && conditionCell != null && dataCell != null
						&& "yes".equalsIgnoreCase(getCellValueAsString(conditionCell))) {
					String testCaseName = getCellValueAsString(testCaseCell);
					String dataValue = getCellValueAsString(dataCell);

					// Add the data value to the corresponding test case list
					if (Testcasename.equalsIgnoreCase(testCaseName)) {
						testCaseData.add(dataValue);
					}
					// Add more conditions if you have more test cases
				}
			}

			// Close the workbook and input stream
			workbook.close();
			fis.close();

			// Print the lists (for testing purposes)
			System.out.println("Test Case 1 Data: " + testCaseData);

		} catch (IOException e) {
			e.printStackTrace();
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
		}

		return testCaseData;

	}

	private static String getCellValueAsString(Cell cell) {
		switch (cell.getCellType()) {
		case STRING:
			return cell.getStringCellValue();
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				return cell.getDateCellValue().toString();
			} else {
				return String.valueOf(cell.getNumericCellValue());
			}
		case BOOLEAN:
			return String.valueOf(cell.getBooleanCellValue());
		case FORMULA:
			return cell.getCellFormula();
		case BLANK:
			return "";
		default:
			return "";
		}
	}

	public String Getcssvalue(WebDriver driver, String xpath, String value) {

		String[] values = splitXpath(xpath);
		String Cssvalue = "";
		try {
			WebElement webElement = driver.findElement(By.xpath(values[1]));
			WebDriverWait wait = new WebDriverWait(driver, WaitElementSeconds);
			Cssvalue = webElement.getCssValue(value);
			Extent_pass(driver, "Css value of the " + value + " is " + Cssvalue, test, test1);
		} catch (Exception e) {
			e.printStackTrace();

			// TODO Auto-generated catch block
			Extent_fail(driver, "Css value is not present in the field " + e.getLocalizedMessage(), test, test1);
			
		}

		return Cssvalue;

	}

	public String Getcssvalue_webelement(WebDriver driver, WebElement element, String value) {

//		String[] values = splitXpath(xpath);
		String Cssvalue = "";
		try {
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			Cssvalue = element.getCssValue(value);
			Extent_pass(driver, "Css value of the " + value + " is " + Cssvalue, test, test1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Extent_fail(driver, "Css value is not present in the field " + e.getLocalizedMessage(), test, test1);
			e.printStackTrace();
		}

		return Cssvalue;

	}

	public void write_newdata(String Sheetname, String columnName, String value) {

		String filePath = System.getProperty("user.dir") + "\\data\\TestData.xlsx";

		// New value to be set in the cell
		String newValue = value;

		try {

			FileInputStream fis = new FileInputStream(filePath);

			Workbook workbook = new XSSFWorkbook(fis);

			// Get the sheet
			Sheet sheet = workbook.getSheet(Sheetname);

			// Get the row index (assuming you want to write to the first available row)
			int columnIndex = getColumnIndexByName(sheet, columnName);
			int rowIndex = findNextEmptyRow(sheet, columnIndex);

			// Get the row, create if it doesn't exist
			Row row = sheet.getRow(rowIndex);
			if (row == null) {
				row = sheet.createRow(rowIndex);
			}

			// Get the cell, create if it doesn't exist
			Cell cell = row.getCell(columnIndex);
			if (cell == null) {
				cell = row.createCell(columnIndex);
			}

			// Set the new value
			cell.setCellValue(newValue);

			// Write the changes back to the Excel file
			try (FileOutputStream fos = new FileOutputStream(filePath)) {
				workbook.write(fos);
			}

			workbook.close();

			System.out.println("Value updated successfully!");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static int findNextEmptyRow(Sheet sheet, int columnIndex) {
		int rowIndex = 1; // Start after the header row
		while (true) {
			Row row = sheet.getRow(rowIndex);
			if (row == null) {
				return rowIndex;
			}
			Cell cell = row.getCell(columnIndex);
			if (cell == null || cell.getCellType() == CellType.BLANK) {
				return rowIndex;
			}
			rowIndex++;
		}
		// TODO Auto-generated method stub
	}

	public String Readlastrowdata(String Sheetname, String Columnname) throws Exception {

		String cellValue = "";

		try {
			String filePath = System.getProperty("user.dir") + "\\data\\TestData.xlsx";

			// Specify the sheet name
			String sheetName = "Sheet2";

			// Specify the column name
			String columnName = "Email"; // Column name

			FileInputStream fis = new FileInputStream(filePath);
			Workbook workbook = new XSSFWorkbook(fis);

			// Get the sheet
			Sheet sheet = workbook.getSheet(sheetName);

			// Get the column index based on the column name
			int columnIndex = getColumnIndexByName(sheet, columnName);

			// Find the last row with data in the specified column
			int rowIndex = findLastRow(sheet, columnIndex);

			// Get the row, create if it doesn't exist
			Row row = sheet.getRow(rowIndex);
			if (row == null) {
				row = sheet.createRow(rowIndex);
			}

			// Get the cell
			Cell cell = row.getCell(columnIndex);

			// Check if cell is not null and handle appropriately
			if (cell != null) {
				// Get the value from the cell
				cellValue = cell.getStringCellValue(); // Assuming the cell contains string value

				// Print the cell value
				System.out.println("Cell Value: " + cellValue);
			} else {
				System.out.println("Cell is null or empty.");
			}

			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cellValue;

	}

	public static int findLastRow(Sheet sheet, int columnIndex) {
		int lastRowIndex = -1;
		for (int rowIndex = 0; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
			Row row = sheet.getRow(rowIndex);
			if (row != null) {
				Cell cell = row.getCell(columnIndex);
				if (cell != null && cell.getCellType() != CellType.BLANK) {
					lastRowIndex = rowIndex;
				}
			}
		}
		return lastRowIndex;
	}

	public void ScrollBarValidation1(WebDriver driver, String Xpath, String fieldname) {

		String[] values = splitXpath(Xpath);

		try {
			WebElement dropdown = driver.findElement(By.xpath(values[1]));
			Actions builder = new Actions(driver);
			builder.moveToElement(dropdown).build().perform();
			wait(driver, "3");
			elementScreenShot_new(driver, Xpath, "/Expected_screenshot/ScrollbarValidation/" + fieldname);

			Boolean isScrollbarPresent = (Boolean) ((JavascriptExecutor) driver)
					.executeScript("return arguments[0].scrollHeight > arguments[0].offsetHeight;", dropdown);

			if (isScrollbarPresent) {
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollTop = arguments[0].scrollHeight;",
						dropdown);
				builder.moveToElement(dropdown).build().perform();
				wait(driver, "1");
				elementScreenShot_new(driver, Xpath, "/Actual_screenshot/ScrollbarValidation/" + fieldname);

				boolean scrollImageCheck;
				try {
					scrollImageCheck = imageComparison2(driver, "/ScrollbarValidation/" + fieldname,
							"/ScrollbarValidation/" + fieldname);
					if (scrollImageCheck) {
						Extent_fail1(test, "Scroll not working properly in the " + fieldname);
					} else {
						Extent_pass(driver, "Scroll works properly in " + fieldname, test, test1);
					}
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollTop = 0;", dropdown);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else {
				Extent_fail1(test, "Scrollbar is not present on the " + fieldname);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}

	}

	public boolean imageComparison2(WebDriver driver, String ExpectedImage_path, String actualImage_path)
			throws IOException {
	
		String image_res = null;

		try {
			BufferedImage img1 = ImageIO
					.read(new File("./Screenshots/Expected_screenshot" + ExpectedImage_path + ".png"));
			BufferedImage img2 = ImageIO.read(new File("./Screenshots/Actual_screenshot" + actualImage_path + ".png"));

			int w1 = img1.getWidth();
			int w2 = img2.getWidth();
			int h1 = img1.getHeight();
			int h2 = img2.getHeight();
			long diff = 0;

			if ((w1 != w2) || (h1 != h2)) {
				System.out.println("Both images should have the same dimensions");
				return false;
			} else {
				for (int j = 0; j < h1; j++) {
					for (int i = 0; i < w1; i++) {
						int pixel1 = img1.getRGB(i, j);
						Color color1 = new Color(pixel1, true);
						int r1 = color1.getRed();
						int g1 = color1.getGreen();
						int b1 = color1.getBlue();

						int pixel2 = img2.getRGB(i, j);
						Color color2 = new Color(pixel2, true);
						int r2 = color2.getRed();
						int g2 = color2.getGreen();
						int b2 = color2.getBlue();

						long data = Math.abs(r1 - r2) + Math.abs(g1 - g2) + Math.abs(b1 - b2);
						diff = diff + data;
					}
				}

				String[] s = ExpectedImage_path.split("/");
				double avg = (double) diff / (w1 * h1 * 3);
				double percentage = (avg / 255) * 100;
				System.out.println("Difference: " + percentage);

				if (percentage < 0.2) {
					image_res = "Pass";
//					//add(driver, s[1] + " - " + s[2] + " - Image compared successfully", LogAs.PASSED, true,
//							"");
					System.out.println(s[1] + " - " + s[2] + " - Image compared successfully");
					Extent_pass(driver, s[1] + " - " + s[2] + " - Image compared successfully", test, test1);
					return true;
				} else {
//					////add1(driver, s[1] + " - " + s[2] + " - Expected and Actual images are not the same", 
//							true, "");
					System.out.println(s[1] + " - " + s[2] + " - Expected and Actual images are not the same ");
					return false;
				
				}
			}
		} catch (Exception e) {
			System.out.println("Exception while taking Screenshot: " + e.getMessage());
			return false;
		}

	}

	public void elementScreenShot_new(WebDriver driver, String xpath, String screenshot_path) {

		String[] elementPath = splitXpath(xpath);

		// Get the zoom level of the window
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Object zoomObject = js.executeScript("return window.devicePixelRatio * 100");
		long zoomLevel = Math.round((long) zoomObject);

		// Wait for the WebElement to be clickable
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elementPath[1])));

		if (element != null) {
			// Get the location and size of the WebElement
			Point point = element.getLocation();
			int width = element.getSize().getWidth();
			int height = element.getSize().getHeight();

			System.out.println("Location: (" + point.getX() + ", " + point.getY() + ")");
			System.out.println("Size: (" + width + "x" + height + ")");

			// Adjust coordinates and dimensions based on zoom level
			double zoomFactor = zoomLevel / 100.0;
			int adjustedX = (int) (point.getX() * zoomFactor);
			int adjustedY = (int) (point.getY() * zoomFactor);
			int adjustedWidth = (int) (width * zoomFactor);
			int adjustedHeight = (int) (height * zoomFactor);

			// Take a screenshot of the entire page
			File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			try {
				BufferedImage fullImg = ImageIO.read(screenshotFile);

				// Ensure the cropped dimensions are within the bounds of the full image
				adjustedWidth = Math.min(adjustedWidth, fullImg.getWidth() - adjustedX);
				adjustedHeight = Math.min(adjustedHeight, fullImg.getHeight() - adjustedY);

				BufferedImage elementImg = fullImg.getSubimage(adjustedX, adjustedY, adjustedWidth, adjustedHeight);
				File croppedFile = new File(System.getProperty("user.dir") + "/Screenshots" + screenshot_path + ".png");
				ImageIO.write(elementImg, "png", croppedFile);
				System.out.println("Screenshot saved successfully.");
			} catch (IOException | RasterFormatException e) {
				e.printStackTrace();

				Extent_fail(driver, e.getLocalizedMessage(), test, test1);
			}
		} else {
			System.out.println("Element not found or not clickable.");
			
		}
	}

	public static String determineType(String value) {
		// Check if the string contains only alphabetic characters
		if (Pattern.matches("^[a-zA-Z()]+$", value)) {
			return "Alphabetic";
		}
		// Check if the string contains only numeric characters
		else if (Pattern.matches("^[0-9]+$", value)) {
			return "Numeric";
		}
		// Check if the string contains only alphanumeric characters
		else if (Pattern.matches("^[a-zA-Z0-9]+$", value)) {
			return "Alphanumeric";
		}
		// If none of the above conditions are met, return "Other"
		else {
			return "Other";
		}
	}

	public static String extractDirection(String text) {
		// Define the regular expression pattern to find 'left' or 'right'
		String pattern = "\\b(left|right|middle)\\b";

		// Compile the pattern
		Pattern compiledPattern = Pattern.compile(pattern);

		// Create a matcher from the pattern and the input text
		Matcher matcher = compiledPattern.matcher(text);

		// Check if a match is found
		if (matcher.find()) {
			return matcher.group(0);
		} else {
			return null;
		}
	}

	public static String extractstatus(String text) {
		// Define the regular expression pattern to find 'left' or 'right'
		String pattern = "\\b(focus)\\b";

		// Compile the pattern
		Pattern compiledPattern = Pattern.compile(pattern);

		// Create a matcher from the pattern and the input text
		Matcher matcher = compiledPattern.matcher(text);

		// Check if a match is found
		if (matcher.find()) {
			return matcher.group(0);
		} else {
			return null;
		}
	}
	
	
	
	
	public static String extractstatus1(String text) {
		// Define the regular expression pattern to find 'left' or 'right'
		String pattern = "\\b(ui-state-hover)\\b";

		// Compile the pattern
		Pattern compiledPattern = Pattern.compile(pattern);

		// Create a matcher from the pattern and the input text
		Matcher matcher = compiledPattern.matcher(text);

		// Check if a match is found
		if (matcher.find()) {
			return matcher.group(0);
		} else {
			return null;
		}
	}

	public void Scrolltilltheelementvisible(WebDriver driver, String xpath) {

		String[] elementPath = splitXpath(xpath);

		try {
			WebElement element = driver.findElement(By.xpath(elementPath[1]));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
		}

	}

	public void HorizontalScrollFull(WebDriver driver, String Xpath) {
		String[] values = splitXpath(Xpath);
		try {
			WebElement element = driver.findElement(By.xpath(values[1]));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollLeft = 0;", element);
		} catch (Exception e) {
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
		}
	}

	public void HorizontalScrollTop(WebDriver driver, String Xpath) {
		String[] values = splitXpath(Xpath);
		try {
			WebElement element = driver.findElement(By.xpath(values[1]));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollTop = 0;", element);
		} catch (Exception e) {
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
		}
	}
	
	public static String downloadspath() {

		String os = System.getProperty("os.name").toLowerCase();
		String downloadsPath = "";

		if (os.contains("win")) {
			// For Windows, using Shell32Util
			downloadsPath = Shell32Util.getKnownFolderPath(KnownFolders.FOLDERID_Downloads);
		} else if (os.contains("mac")) {
			// For macOS, using user home directory and "Downloads" folder
			downloadsPath = System.getProperty("user.home") + "/Downloads";
		}

		String downloadDir = downloadsPath;

		File dir = new File(downloadDir);

		System.out.println("downloadDir :" + downloadDir);

		return downloadDir;

	}

	public void Verifydownload(WebDriver driver, String filename) {

		String os = System.getProperty("os.name").toLowerCase();
		String downloadsPath = "";

		if (os.contains("win")) {
			// For Windows, using Shell32Util
			downloadsPath = Shell32Util.getKnownFolderPath(KnownFolders.FOLDERID_Downloads);
		} else if (os.contains("mac")) {
			// For macOS, using user home directory and "Downloads" folder
			downloadsPath = System.getProperty("user.home") + "/Downloads";
		}

		String downloadDir = downloadsPath;

		File dir = new File(downloadDir);

		System.out.println("downloadDir :" + downloadDir);

		String Latestdownloaded_File = "";

		if (dir.exists() && dir.isDirectory()) {
			File[] files = dir.listFiles((dir1, name) -> name.contains(filename));

			if (files != null && files.length > 0) {
				// Sort files by last modified timestamp in descending order
				Arrays.sort(files, Comparator.comparingLong(File::lastModified).reversed());

				// Get the first (latest) file
				File latestFile = files[0];

				Latestdownloaded_File = latestFile.getAbsolutePath();

				System.out.println("Latest file containing 'filename': " + latestFile.getAbsolutePath());

				Extent_pass(driver, "Downloaded file was present in the downloads folder", test, test1);

			} else {
				System.out.println("No files found with 'filename' in the directory.");
				Extent_fail(driver, "No files found with '" + filename + "' in the directory.", test, test1);
			}
		} else {
			System.out.println("Directory does not exist or is not a directory.");
		}

	}
	public void mouseOverToElement(WebDriver driver, String element) {
		String[] values = splitXpath(element);
		try {
			WebElement webElement = driver.findElement(By.xpath(values[1]));
			Actions builder = new Actions(driver);
			builder.moveToElement(webElement).build().perform();
         wait(driver,"1");
		} catch (Exception e) {

		}
	}


	public void Exceldatacomparison(WebDriver driver, List<String> grid_location) throws Exception {

		Workbook workbook = WorkbookFactory.create(new File("D:\\Optibox\\uploads\\Budget Flow.xlsx"));
		Sheet sheet = workbook.getSheetAt(0);

		int LocationColumnIndex = 3;

		List<String> Location_names = new ArrayList<>();

		for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
			Row row = sheet.getRow(rowIndex); // Get the row at the current index

			if (row != null) { // Check if row is not null
				// Get the cell in the "Patient ID" column
				Cell LocationCell = row.getCell(LocationColumnIndex);

				String LocationCellValue = null;
				if (LocationCell != null) {
					CellType cellType = LocationCell.getCellType();
					if (cellType == CellType.STRING) {
						LocationCellValue = LocationCell.getStringCellValue();
					} else if (cellType == CellType.NUMERIC) {
						double numericValue = LocationCell.getNumericCellValue();
						// Convert double to integer for printing
						LocationCellValue = String.valueOf((int) numericValue); // Cast to int to remove decimal
																				// places
					} else if (cellType == CellType.BLANK) {
						// Handle blank cells
						LocationCellValue = ""; // Or any default value you want to use
					} else if (cellType == CellType.FORMULA) {
						// Handle formula cells
						LocationCellValue = ""; // Or evaluate the formula if needed
					}
				} else {
					// Cell is null, handle accordingly
					LocationCellValue = ""; // Or any default value you want to use
				}

				Location_names.add(LocationCellValue);

			}

		}

		int size = Location_names.size();

		for (int i = 0; i < size; i++) {

			String ActualLocation = Location_names.get(i);

			if (grid_location.contains(ActualLocation)) {

				System.out.println("Location " + ActualLocation + " was present on the grid");

			} else {

				System.out.println("Location " + ActualLocation + " was not present on the grid");
				Extent_fail1(test, "Location " + ActualLocation + " was not present on the grid");
			}

		}

		System.out.println("Location_names : " + Location_names);

	}

	public static String generateUniqueString() {
		Random random = new Random();

		// Generate a random alphabet character (A-Z, a-z)
		// Generate three random digits
		int digit1 = random.nextInt(10);
		int digit2 = random.nextInt(10);
		int digit3 = random.nextInt(10);

		// Combine the alphabet character with the three digits
		return "" + digit1;
	}

	public static boolean containsAlphabetic(String text) {
		Pattern pattern = Pattern.compile("[a-zA-Z]");
		Matcher matcher = pattern.matcher(text);
		return matcher.find();
	}

	public static boolean containsSpecialCharacter(String text) {
		Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
		Matcher matcher = pattern.matcher(text);
		return matcher.find();
	}

	public static boolean containsNumeric(String text) {
		Pattern pattern = Pattern.compile("[0-9]");
		Matcher matcher = pattern.matcher(text);
		return matcher.find();
	}

	public static Set<String> getDirectoryFiles() {

		String downloads = downloadspath();

		File dir = new File(downloads);
		Set<String> files = new HashSet<>();
		if (dir.isDirectory()) {
			files.addAll(Arrays.asList(dir.list()));
		}
		return files;
	}

	public static boolean isNewFileDownloaded(Set<String> oldFiles, String baseFilename) {

		Set<String> newFiles = getDirectoryFiles();
		newFiles.removeAll(oldFiles); // Get only new files

		Pattern pattern = Pattern.compile(Pattern.quote(baseFilename) + "(\\(\\d+\\))?$");

		for (String file : newFiles) {
			Matcher matcher = pattern.matcher(file);
			if (file.contains(baseFilename)) {
				System.out.println("Found new downloaded file: " + file);
				return true;
			}
		}
		System.out.println("No new matching file found for base filename: " + baseFilename);
		return false;
	}

	public static void deleteFiles(String baseFilename) {

		String downloads = downloadspath();

		File dir = new File(downloads);
		if (dir.isDirectory()) {
			for (File file : dir.listFiles()) {
				if (file.getName().contains(baseFilename)) {
					System.out.println("Deleting file: " + file.getName());
					if (file.delete()) {
						System.out.println("File deleted successfully");
					} else {
						System.out.println("Failed to delete file");
					}
				}
			}
		}

	}

	public void iframe(WebDriver driver, String xpath) {

		try {
			WebElement elementInsideIframe = driver.findElement(By.xpath("(//i[@class='fa fa-times'])[1]"));
			elementInsideIframe.click();

			// Switch back to the main content
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
			e.printStackTrace();
		}

	}

	public void mouseOverAndClick(WebDriver driver, String element) {
		String[] values = splitXpath(element);
		WebElement webElement = driver.findElement(By.xpath(values[1]));
		try {
			Actions builder = new Actions(driver);
			builder.moveToElement(webElement).pause(Duration.ofSeconds(2)).build().perform();
			builder.click(webElement).build().perform();
			Extent_pass(driver, "Mouse hover and Clicked on the web element", test, test1);
		} catch (Exception e) {
			System.out.println("not clicked : " + values[0]);
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
		}
	}

	public String getStringValue(String text) {

		String Value = text;
		if (Value.contains("(")) {
			int bracketIndex = Value.indexOf('(');
			Value = text.substring(0, bracketIndex).trim();
		}

		return Value.trim();
	}

	public List<String> getdata(WebDriver driver, String Testcasename, String Sheetname, String testcasecolumn,
			String conditioncolumnname, String data) {

		String excelFilePath = testExecutionFile;

		List<String> testCaseData = new ArrayList<>();

		try {
			// Load the Excel file
			FileInputStream fis = new FileInputStream(excelFilePath);
			Workbook workbook = new XSSFWorkbook(fis);
			Sheet sheet = workbook.getSheet(Sheetname);

			// Create a map to store column names and their corresponding indices
			Map<String, Integer> columnIndices = new HashMap<>();

			// Assuming the first row is the header
			Row headerRow = sheet.getRow(0);
			if (headerRow != null) {
				for (Cell cell : headerRow) {
					columnIndices.put(getCellValueAsString(cell), cell.getColumnIndex());
				}
			}

			// Iterate through each row in the sheet, starting from the second row
			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				Row row = sheet.getRow(i);
				if (row == null)
					continue;

				// Get cells by column names
				Cell testCaseCell = row.getCell(columnIndices.get(testcasecolumn));
				Cell conditionCell = row.getCell(columnIndices.get(conditioncolumnname));
				Cell dataCell = row.getCell(columnIndices.get(data));

				// Check if the cells are not null and the condition is "yes"
				if (testCaseCell != null && conditionCell != null && dataCell != null
						&& "yes".equalsIgnoreCase(getCellValueAsString(conditionCell))) {
					String testCaseName = getCellValueAsString(testCaseCell);
					String dataValue = getCellValueAsString(dataCell);

					// Add the data value to the corresponding test case list
					if (Testcasename.equalsIgnoreCase(testCaseName)) {
						testCaseData.add(dataValue);
					}
				}
			}

			// Close the workbook and input stream
			workbook.close();
			fis.close();

			// Print the lists (for testing purposes)
			System.out.println("Test Case Data: " + testCaseData);

		} catch (IOException e) {
			e.printStackTrace();
		}

		return testCaseData;
	}

	public List<String> getSheetname(WebDriver driver, String Testcasename, String Sheetname) {

		String excelFilePath = testExecutionFile;

		List<String> testCaseData = new ArrayList<>();
		// Add more lists if you have more test cases

		try {
			// Load the Excel file
			FileInputStream fis = new FileInputStream(excelFilePath);
			Workbook workbook = new XSSFWorkbook(fis);
			Sheet sheet = workbook.getSheet(Sheetname);

			// Iterate through each row in the sheet
			for (Row row : sheet) {
				// Get the first column (TestCase identifier)
				Cell testCaseCell = row.getCell(0);
				Cell conditionCell = row.getCell(1); // Column with condition ("yes")
				Cell dataCell = row.getCell(3); // Data to read if condition is "yes"

				// Check if the cells are not null and the condition is "yes"
				if (testCaseCell != null && conditionCell != null && dataCell != null
						&& "yes".equalsIgnoreCase(getCellValueAsString(conditionCell))) {
					String testCaseName = getCellValueAsString(testCaseCell);
					String dataValue = getCellValueAsString(dataCell);

					// Add the data value to the corresponding test case list
					if (Testcasename.equalsIgnoreCase(testCaseName)) {
						testCaseData.add(dataValue);
					}
					// Add more conditions if you have more test cases
				}
			}

			// Close the workbook and input stream
			workbook.close();
			fis.close();

			// Print the lists (for testing purposes)
			System.out.println("Test Case 1 Data: " + testCaseData);

		} catch (IOException e) {
			e.printStackTrace();
		}

		return testCaseData;

	}

	public List<String> getdataset(WebDriver driver, String Testcasename, String Sheetname) {

		String excelFilePath = testExecutionFile;

		List<String> testCaseData = new ArrayList<>();
		// Add more lists if you have more test cases

		try {
			// Load the Excel file
			FileInputStream fis = new FileInputStream(excelFilePath);
			Workbook workbook = new XSSFWorkbook(fis);
			Sheet sheet = workbook.getSheet(Sheetname);

			// Iterate through each row in the sheet
			for (Row row : sheet) {
				// Get the first column (TestCase identifier)
				Cell testCaseCell = row.getCell(0);
				Cell conditionCell = row.getCell(1); // Column with condition ("yes")
				Cell dataCell = row.getCell(4); // Data to read if condition is "yes"

				// Check if the cells are not null and the condition is "yes"
				if (testCaseCell != null && conditionCell != null && dataCell != null
						&& "yes".equalsIgnoreCase(getCellValueAsString(conditionCell))) {
					String testCaseName = getCellValueAsString(testCaseCell);
					String dataValue = getCellValueAsString(dataCell);

					// Add the data value to the corresponding test case list
					if (Testcasename.equalsIgnoreCase(testCaseName)) {
						testCaseData.add(dataValue);
					}
					// Add more conditions if you have more test cases
				}
			}

			// Close the workbook and input stream
			workbook.close();
			fis.close();

			// Print the lists (for testing purposes)
			System.out.println("Test Case 1 Data: " + testCaseData);

		} catch (IOException e) {
			e.printStackTrace();
		}

		return testCaseData;

	}
	
	
	
	


	public static Set<String> getDirectoryFiles1() {

		String downloads = downloadspath();

		File dir = new File(downloads);
		Set<String> files = new HashSet<>();
		if (dir.isDirectory()) {
			files.addAll(Arrays.asList(dir.list()));
		}
		return files;
	}

	public void Verify_FileDownloaded(WebDriver driver, String baseFilename, String Xpath) {
		String value [] = splitXpath(Xpath);
		String downloads = downloadspath();

		File dir = new File(downloads);
		Set<String> files = new HashSet<>();
		if (dir.isDirectory()) {
			files.addAll(Arrays.asList(dir.list()));
		}

		try {
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			WebDriverWait wait = new WebDriverWait(driver, 60);

			// Wait for the element to be present and clickable
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(value[1])));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath((value[1]))));

			WebElement element = driver.findElement(By.xpath(value[1]));
			element.click();

			Extent_pass(driver, "Click on the element " + name, test,test1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Extent_fail(driver, "Click on the element " + name, test,test1);
		}
		wait(driver, "5");

		Set<String> newFiles = getDirectoryFiles();
		newFiles.removeAll(files); // Get only new files

		boolean flag = false;

		for (String file : newFiles) {

			if (file.contains(baseFilename)) {
				System.out.println("New file was downloaded in the download firectoy with the name of : " + file);
				Extent_pass(driver, "New file was downloaded in the download firectoy with the name of : " + file,
						test, test1);
				flag = true;
			}
		}

		if (flag == false) {
			System.out.println(
					"New file was not  downloaded in the download firectoy with the name of : " + baseFilename);
			Extent_fail(driver,
					"New file was not downloaded in the download firectoy with the name of : " + baseFilename, test,test1);
		

	}
		}

	
	
	
	//Perform Right Click action
			public void rightClick(WebDriver driver, String element) {
				String[] values = splitXpath(element);
				try {
					WebElement webElement = driver.findElement(By.xpath(values[1]));
					Actions builder = new Actions(driver);
					builder.contextClick(webElement).build().perform();
		         wait(driver,"1");
				} catch (Exception e) {
		
				}
			}
			
	
	public String defaultSelectedValue(WebDriver driver,String Xpath) {
    	
   	    String[] values=splitXpath(Xpath);
   	    try {
        	WebElement show=driver.findElement(By.xpath(values[1]));
            Select select = new Select(show);
            WebElement selectedOption = select.getFirstSelectedOption();
            String selectedOptionText = selectedOption.getText();
            return selectedOptionText;
        
   	    }catch(Exception e) {
   	    	return "";
   	    }
    }

	public static List<String> expandRange(String rangeStr) {
		List<String> result = new ArrayList<>();
		String[] parts = rangeStr.split("-");
		int start = Integer.parseInt(parts[0]);
		int end = Integer.parseInt(parts[1]);
		for (int i = start; i <= end; i++) {
			result.add(String.valueOf(i));
		}
		return result;
	}

	public static List<String> splitAndExpand(String input) {
		List<String> result = new ArrayList<>();
		String[] parts = input.split(",");
		for (String part : parts) {
			if (part.contains("-")) {
				result.addAll(expandRange(part));
			} else {
				result.add(part);
			}
		}
		return result;
	}
	
	
	public void VerticalScrollFull(WebDriver driver, String Xpath) {
		String[] values = splitXpath(Xpath);
		try {
			WebElement element = driver.findElement(By.xpath(values[1]));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollTop = arguments[0].scrollHeight;",
					element);
		} catch (Exception e) {
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
		}
	}
	
	
	
	
	public static boolean validateColumnValueFromPdf(String pdfPath, String gridValue) throws IOException {
        File pdfFile = new File(pdfPath);
        PDDocument document = PDDocument.load(pdfFile);

        // Extract text from the entire PDF
        PDFTextStripper pdfStripper = new PDFTextStripper();
        String pdfText = pdfStripper.getText(document);

        document.close();

        // Assuming PDF content is organized by rows, split text by lines
        String[] rows = pdfText.split("\n");

        for (String row : rows) {
            // Split each row by whitespace (or specific delimiter if available)
            String[] columns = row.split("\\s+"); // Adjust if columns are separated by another delimiter

            // Example: Check if any column matches grid value (adjust index as needed)
            for (String column : columns) {
                if (column.equals(gridValue)) {
                    return true; // Found a match
                }
            }
        }

        return false; // No match found
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
