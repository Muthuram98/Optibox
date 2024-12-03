package Mail;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import Extent_Report.extend_report;
import commonMethods.Keywords;
import commonMethods.Utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CustomTestListener implements ITestListener{
	
	String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
	
	
	String mailID = Utils.getDataFromTestConfig("Receiver");
	String reportname = Utils.getDataFromTestConfig("Name");
	private int totalTests = 0;
    private int passedTests = 0;
    private int failedTests = 0;
    private List<String> passedTestNames = new ArrayList<>();
    private List<String> failedTestNames = new ArrayList<>();
    private List<String> failedreason = new ArrayList<>();

    @Override
    public void onTestStart(ITestResult result) {
        totalTests++;
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        passedTests++;
        passedTestNames.add(result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        failedTests++;
        failedTestNames.add(result.getName());
        failedreason=Keywords.global;
    }
    

    @Override
    public void onTestSkipped(ITestResult result) {
        // Handle skipped tests if needed
    }

    @Override
    public void onFinish(ITestContext context) {
        // You can access the totalTests, passedTests, failedTests, and failedTestNames here
        StringBuilder emailContent = new StringBuilder();
        emailContent.append("<div style=\"font-family: Arial, sans-serif; text-align: center;\">"); // Center align content and set font-family
        emailContent.append("<h2 style=\"color: #34568B;\">"+ reportname +" Test Summary Report - ").append(timeStamp).append("</h2>");
        emailContent.append("</div>");
        emailContent.append("<br>");
        emailContent.append("<table style=\"border-collapse: collapse; width: 80%; margin: auto;\">"); // Table with 80% width and centered
        emailContent.append("<tr>");
        emailContent.append("<th style=\"border: 1px solid #dddddd; text-align: center; padding: 8px;\">Testcases</th>");
        emailContent.append("<th style=\"border: 1px solid #dddddd; text-align: center; padding: 8px;\">Count</th>");
        emailContent.append("</tr>");

        emailContent.append("<tr>");
        emailContent.append("<td style=\"border: 1px solid #dddddd; text-align: left; padding: 8px;\"><b>Total No of Executed</b></td>");
        emailContent.append("<td style=\"border: 1px solid #dddddd; text-align: center; padding: 8px;\">").append("<b>"+totalTests+"</b>").append("</td>");
        emailContent.append("</tr>");
        
        emailContent.append("<tr>");
        emailContent.append("<td style=\"border: 1px solid #dddddd; text-align: left; padding: 8px;\"><b>No of Passed Cases</b></td>");
        emailContent.append("<td style=\"border: 1px solid #dddddd; text-align: center; padding: 8px;\">").append("<b>"+passedTests+"</b>").append("</td>");
        emailContent.append("</tr>");

        emailContent.append("<tr>");
        emailContent.append("<td style=\"border: 1px solid #dddddd; text-align: left; padding: 8px;\"><b>No of Failed Cases</b></td>");
        emailContent.append("<td style=\"border: 1px solid #dddddd; text-align: center; padding: 8px;\">").append("<b>"+failedTests+"</b>").append("</td>");
        emailContent.append("</tr>");
        
        
        
        emailContent.append("</table>");
        
        emailContent.append("<br>");
        emailContent.append("<table style=\"border-collapse: collapse; width: 80%; margin: auto;\">"); // Table with 80% width and centered

        if (!passedTestNames.isEmpty() || !failedTestNames.isEmpty()) {
            emailContent.append("<tr>");
            emailContent.append("<td style=\"border: 1px solid #dddddd; text-align: center; padding: 8px;\"><b>Testcases Names</b></td>");
            emailContent.append("<td style=\"border: 1px solid #dddddd; text-align: center; padding: 8px;\"><b>Reason for Failure</b></td>");
            emailContent.append("</tr>");

            for (String testName : passedTestNames) {
                emailContent.append("<tr>");
                emailContent.append("<td style=\"border: 1px solid #dddddd; color: #4CAF50; text-align: left; padding: 8px;\">").append(testName).append("</td>");
                emailContent.append("<td style=\"border: 1px solid #dddddd; color: #4CAF50; text-align: left; padding: 8px;\">").append("Passed").append("</td>");
                emailContent.append("</tr>");
            }

            for (int i = 0; i < failedTestNames.size(); i++) {
                emailContent.append("<tr>");
                emailContent.append("<td style=\"border: 1px solid #dddddd; color: #DD4124; text-align: left; padding: 8px;\">").append(failedTestNames.get(i)).append("</td>");
                emailContent.append("<td style=\"border: 1px solid #dddddd; color: #DD4124; text-align: left; padding: 8px;\">").append(failedreason.get(i)).append("</td>");
                emailContent.append("</tr>");
            }
        }
        emailContent.append("</table>");
        emailContent.append("</div>");

        
        // Send email with the content
        try {
            EmailSender.sendTestSummaryEmail(mailID, "Solverminds Test Summary Report - " + timeStamp, emailContent.toString(),extend_report.path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
}
