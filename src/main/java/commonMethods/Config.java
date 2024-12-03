package commonMethods;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
//import com.gargoylesoftware.htmlunit.javascript.host.URL;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Config extends Keywords {
	public WebDriver driver;

	public WebDriver getDriver() throws MalformedURLException {
		return this.driver;

	}

	public void setDriver(WebDriver paramDriver) throws MalformedURLException {
		this.driver = paramDriver;
	}

	public static String Headless = Utils.getDataFromTestConfig("Execute Headless");

	public WebDriver getWebDriver(String browserName) throws Exception {

		WebDriver driver = null;

		if (browserName.equalsIgnoreCase("Chrome")) {

			ChromeOptions options = new ChromeOptions();
			WebDriverManager.chromedriver().setup();

			options.addArguments("disable-notifications");

			if (Headless.equals("Yes")) {
				options.addArguments("--no-sandbox");
				options.addArguments("--disable-dev-shm-usage");
				options.addArguments("--headless", "--disable-gpu");
				options.addArguments("window-size=1024,768"); 
			}

			LoggingPreferences logPrefs = new LoggingPreferences();
			logPrefs.enable(LogType.BROWSER, Level.ALL);
			options.setCapability("goog:loggingPrefs", logPrefs);

			Map<String, Object> prefs = new HashMap<>();
			prefs.put("profile.default_content_setting_values.notifications", 1);
			prefs.put("download.default_directory", System.getProperty("user.dir") + "\\DownloadedFiles");
			options.setExperimentalOption("prefs", prefs);

			driver = new ChromeDriver(options);
			System.out.println("Chrome Browser launched...");

		} else if (browserName.equalsIgnoreCase("Firefox")) {

			FirefoxOptions options = new FirefoxOptions();
			WebDriverManager.firefoxdriver().setup();

			if (Headless.equals("Yes")) {
				options.addArguments("--headless", "--disable-gpu");
			}

			options.addArguments("--disable-popup-blocking");
			options.addPreference("dom.webnotifications.enabled", false);
			options.addPreference("browser.download.folderList", 2);
			options.addPreference("browser.download.dir", System.getProperty("user.dir") + "\\DownloadedFiles");
			options.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf");

			LoggingPreferences logPrefs = new LoggingPreferences();
			logPrefs.enable(LogType.BROWSER, Level.ALL);
			options.setCapability("moz:firefoxOptions", logPrefs);

			driver = new FirefoxDriver(options);
			System.out.println("Firefox Browser launched...");

		} else if (browserName.equalsIgnoreCase("Edge")) {

			EdgeOptions options = new EdgeOptions();
			WebDriverManager.edgedriver().setup();

			options.setCapability("disable-popup-blocking", true);

			Map<String, Object> prefs = new HashMap<>();
			prefs.put("profile.default_content_setting_values.notifications", 1);
			prefs.put("download.default_directory", System.getProperty("user.dir") + "\\DownloadedFiles");

			LoggingPreferences logPrefs = new LoggingPreferences();
			logPrefs.enable(LogType.BROWSER, Level.ALL);
			options.setCapability("goog:loggingPrefs", logPrefs);

			driver = new EdgeDriver(options);
			System.out.println("Edge Browser launched...");
		}

		if (driver != null) {
			setDriver(driver);
			driver.manage().window().maximize();
		}

		return driver;
	}

}
