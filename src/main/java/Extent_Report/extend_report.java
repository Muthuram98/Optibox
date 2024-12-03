package Extent_Report;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;

import commonMethods.Utils;
import testng.reports.logging.LogAs;
import testng.reports.utils.Steps;

public class extend_report {
	
	static ExtentSparkReporter spark;
	static ExtentTest test;
	static ExtentReports extent;
	
	static ExtentSparkReporter spark1;
	public static ExtentTest test1;
	static ExtentReports extent1;
    static LogAs logAs;
	 public static String path;
	static long StartTime;
	public static String name = "Optibox";
	
	public static String Condition = Utils.getDataFromTestConfig("Report_Pass_Image");
	
	public static ExtentReports reportsetup() throws IOException {
		String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("ddMMyyyy_HHmm"));

		spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/Extent_Report/Optibox_" + timeStamp + ".html");
		extent = new ExtentReports();
		extent.attachReporter(spark);
		extent.setSystemInfo("OS", System.getProperty("os.name"));
		extent.setSystemInfo("JAVA", System.getProperty("java.version"));
		extent.setSystemInfo("APP Name", name);
		extent.setSystemInfo("Bowser", "Chrome");
		spark.viewConfigurer().viewOrder()
				.as(new ViewName[] { ViewName.DASHBOARD, ViewName.TEST, ViewName.CATEGORY, ViewName.AUTHOR });
		StartTime = System.currentTimeMillis();
		
		return extent;
	}
	
	public static ExtentReports reportsetup1() throws IOException {
		
		String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("ddMMyyyy_HHmm"));
		path = System.getProperty("user.dir") + "/Extent_Report_For_Mail/Optibox_Mailreport_" + timeStamp + ".html";
		spark1 = new ExtentSparkReporter(path);
		extent1 = new ExtentReports();
		extent1.attachReporter(spark1);
		extent1.setSystemInfo("OS", System.getProperty("os.name"));
		extent1.setSystemInfo("JAVA", System.getProperty("java.version"));
		extent1.setSystemInfo("APP Name", name);
		extent1.setSystemInfo("Bowser", "Chrome");
		spark1.viewConfigurer().viewOrder()
				.as(new ViewName[] { ViewName.DASHBOARD, ViewName.TEST, ViewName.CATEGORY, ViewName.AUTHOR });
		StartTime = System.currentTimeMillis();
		
		return extent1;
	}

	public static void teardown(ITestResult result, ExtentTest test) throws Throwable {
	    if (result.getStatus() == ITestResult.FAILURE) {
	        System.out.println("Test is failed");
	        test.log(Status.FAIL, "<b><i>Test execution Failed " + "</i></b>");
	        test.log(Status.FAIL, "Test execution Failed " );
	    } else if (result.getStatus() == ITestResult.SKIP) {
	        test.log(Status.SKIP, "<b><i>Test execution Skipped " + "</i></b>");
	        System.out.println("Test execution Skipped");
	    } else if (result.getStatus() == ITestResult.SUCCESS) {
	        test.log(Status.PASS, "<b><i>Test execution completed " + "</i></b>");
	        System.out.println("Test execution completed");
	    }
	    extent.flush();
	    extent1.flush();
	}


	public static void Aftertest(ExtentTest test) {

		long EndTime = System.currentTimeMillis();
		double executionTime = (EndTime - StartTime) / 1000;
		test.log(Status.INFO, "Total Execution time: " + executionTime);
		extent.flush();
		extent1.flush();
	}
	
	public static String takescreenshot2(WebDriver driver, String screenshot_path) {
		File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir") + "/Screenshots1" + screenshot_path + ".png");
		try {
			FileUtils.copyFile(scr, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dest.getAbsolutePath();
	}

	public static String base64(WebDriver driver) {
		String scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
		return scr;
	}



	public static void Extent_pass(WebDriver driver, String values, ExtentTest test, ExtentTest test1) {

	    if (driver != null) {
	        String aligned = "<div style='text-align: left; color: green;font-weight: bold;font-family: Times New Roman'>" 
	                        + values + "</div>";

	        if (Condition.equals("Yes")) {
	            test.pass(aligned, MediaEntityBuilder.createScreenCaptureFromBase64String(base64(driver)).build());
	        } else {
	            test.pass(aligned);
	        }

	        // Log to test1
	        test1.pass(aligned);
	    } else {
	        System.out.println("driver is null");
	    }
	}

	
	
	public void setLogAs(LogAs paramLogAs) {
		this.logAs = paramLogAs;
	}


	public static void Extent_fail(WebDriver driver, String values, ExtentTest test, ExtentTest test1) {
		String aligned = "<div style='text-align: " + "left; color: red;font-weight: bold;font-family: "
				+ "Times New Roman'>" + values + "</div>";

		test.fail(aligned, MediaEntityBuilder.createScreenCaptureFromBase64String(base64(driver)).build());
		test1.fail(aligned, MediaEntityBuilder.createScreenCaptureFromBase64String(base64(driver)).build());

	}
	

	public static void Extent_pass1(ExtentTest test, String values) {

		String aligned = "<div style='text-align: left; " + "color: green;font-weight: bold;"
				+ "font-family: Times New Roman'>" + values + "</div>";

		test.pass(aligned);

	}
	
	

	public static void Extent_fail1(ExtentTest test, String values) {
		String aligned = "<div style='text-align: " + "left; color: red;font-weight: bold;font-family: "
				+ "Times New Roman'>" + values + "</div>";
		

		test.fail(aligned);

		
	}

	
	public static void Extent_cal(ExtentTest test, String values) {

		String aligned = "<div style='text-align: " + "centre ;color: orange;font-weight: bold;"
				+ "font-family: Times New Roman'>" + values + "</div>";

		test.info(aligned);

	}

	public static void Extent_fail2(WebDriver driver, String values, ExtentTest test) {
		String aligned = "<div style='text-align: " + "left; color: red;font-weight: bold;font-family: "
				+ "Times New Roman'>" + values + "</div>";

		test.fail(aligned, MediaEntityBuilder.createScreenCaptureFromBase64String(base64(driver)).build());

		
	}
	
	public static void Info(String values) {
		String aligned = "<div style='text-align: " + "left; color: blue;font-weight: bold;font-family: "
				+ "Times New Roman'>" + values + "</div>";

		test.info(aligned);

	}
	
	public static void setUpShutdownHook() {
	    Runtime.getRuntime().addShutdownHook(new Thread(() -> {
	        try {
	            if (extent != null) {
	                extent.flush(); 
	            }
	            if (extent1 != null) {
	                extent1.flush(); 
	            }
	        } catch (Exception e) {
	            System.out.println("Error while flushing reports on shutdown: " + e.getMessage());
	        }
	    }));
	}
	
	

}
