package DeficitAndSurflusLocationIdentification_Scripts;

import java.awt.Robot;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.Utils;
import testng.reports.logging.LogAs;

public class TS011_DeficitandSurplusLocationId_TC141to212 extends Keywords{

	@SuppressWarnings("deprecation")
	public void Scenario11_2(WebDriver driver, ExtentTest test,ExtentTest test1,String url, int dataset) throws Exception {
		
		String Username = Utils.getDataFromTestData("TS011_DeficitandSurplusLocationIdentification_Dataset"+dataset, "DeficitandSurplusLocationId", "Username");
		String Password = Utils.getDataFromTestData("TS011_DeficitandSurplusLocationIdentification_Dataset"+dataset, "DeficitandSurplusLocationId", "Password");
		 
		String EquimentType_Alphabets = System.getProperty("user.dir") + "\\uploads\\EquimentType_Alphabets.xlsx";
		
		String Import_alphabets = System.getProperty("user.dir") + "\\uploads\\Import_alphabet.xlsx";
		String Import_specialcharacter = System.getProperty("user.dir") + "\\uploads\\Import_specialcharacter.xlsx";
		
		Actions act = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		navigateUrl(driver, url);
		
		Fluentwait(driver, Username_input);
		sendKeys(driver, Username_input, Username);
		
		Fluentwait(driver, Password_input);
		sendKeys(driver, Password_input, Password);
		
		Fluentwait(driver, SignIn);
		click(driver, SignIn);
		
		wait(driver,"5");
		
		if(isDisplayed(driver, session_confirmation)) {
			Fluentwait(driver, session_confirmation);
			click(driver, session_confirmation);
		}
		
		wait(driver,"3");
		
		Fluentwait(driver, Searchbox);
		sendKeys(driver, Searchbox, "Deficit and Surplus Location Identification");
		
		Fluentwait(driver, Selectdeficit);
		click(driver, Selectdeficit);
		
		wait(driver,"5");
		
		Extent_cal(test, "Testcase 145 - Ensure in import from excel Country column allow alphabets");
		
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
		wait(driver,"2");
		
//		uploadFileRobot(driver,EquimentType_Alphabets);
		
		
		String upload_alphabets = System.getProperty("user.dir") + "/driver/MasterDownloadfile.exe " + EquimentType_Alphabets;

		try {
			Runtime.getRuntime().exec(upload_alphabets);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getLocalizedMessage());
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
		}
		
		wait(driver,"20");
		
		Fluentwait(driver, Location3);
		
		if(isDisplayed(driver, click_yes)) {
			
			click(driver, click_yes);
			
			Fluentwait(driver, Click_ok);
			click(driver, Click_ok);
		}
		
		wait(driver,"2");
		
		String Total_records1 = getText(driver, Total_record);
		
		int length2 = Integer.parseInt(Total_records1);
		
		waitForElement(driver, Total_record);
		
		boolean countryallPassedexport1=true;
		
		for (int i = 0; i < length2; i++) {
		
			WebElement element = driver.findElement(By.xpath("(//div[@row-id='"+i+"'])[2]//div[@col-id='country']"));
			
			act.moveToElement(element).click().build().perform();
			// Get the text from the element
			String text = element.getText();
			// Check if the text contains any alphabetic characters
			if (containsAlphabetic(text)) {
				System.out.println("The country column allowed to enter the alphabetic characters - "+text);
			} else {
				System.out.println("The country column does not allow alphabetic characters");
				countryallPassedexport1=false;
				
			} 
		}
		
		scrollBottom(driver);
		
		if (countryallPassedexport1) {
			Extent_pass(driver, "The country column allowed to enter the alphabetic characters", test,test1);
		} else {
			Extent_fail(driver, "The country column does not allow alphabetic characters", test,test1);
		}
		
		System.out.println("************Testcase 145 Completed***********");
	
		
		wait(driver,"2");

		Extent_cal(test, "Testcase 146 - Ensure in  import from excel Country column not allow numeric");
		
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
		
		wait(driver,"3");
		
//		uploadFileRobot(driver,EquimentType_Alphabets);

		
		String upload_Equipment = System.getProperty("user.dir") + "/driver/MasterDownloadfile.exe " + EquimentType_Alphabets;

		try {
			Runtime.getRuntime().exec(upload_Equipment);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getLocalizedMessage());
		}
		
		wait(driver,"3");
		
		Fluentwait(driver, Location3);
		
		if(isDisplayed(driver, click_yes)) {
			
			click(driver, click_yes);
			
			Fluentwait(driver, Click_ok);
			click(driver, Click_ok);
		}
	
		boolean countryallPassed=true;
		
		for (int i = 0; i < length2; i++) {
			
			WebElement element = driver.findElement(By.xpath("(//div[@row-id='"+i+"'])[2]//div[@col-id='country']"));
			
			act.moveToElement(element).click().build().perform();
			// Get the text from the element
			String text = element.getText();
			// Check if the text contains any alphabetic characters
			if (!containsNumeric(text)) {
				System.out.println("The country column does not allow numerical values");
				
			} else {
				System.out.println("The country column allowed to enter the numerical values - "+text);
				countryallPassed=false;
			} 
		}
	
		scrollBottom(driver);
		
		if (countryallPassed) {
			Extent_pass(driver, "The country column does not allow numerical values", test,test1);
		} else {
			Extent_fail(driver, "The country column allowed to enter the numerical values", test,test1);
		}
		
		System.out.println("************Testcase 146 Completed***********");
		
		wait(driver,"2");
	
	
		Extent_cal(test, "Testcase 147 - Ensure in  import from excel  Country column not allow Special character");	

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
		wait(driver,"2");
		
//		uploadFileRobot(driver,EquimentType_Alphabets);		
		
		String upload_Equipment_alphabets = System.getProperty("user.dir") + "/driver/MasterDownloadfile.exe " + EquimentType_Alphabets;

		try {
			Runtime.getRuntime().exec(upload_Equipment_alphabets);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getLocalizedMessage());
		}
		
		wait(driver,"20");
		
		Fluentwait(driver, Location3);
		
		if(isDisplayed(driver, click_yes)) {
			
			click(driver, click_yes);
			
			Fluentwait(driver, Click_ok);
			click(driver, Click_ok);
		}
		
		wait(driver,"2");
		
		boolean countryallPassed2=true;
		
		for (int i = 0; i < length2; i++) {
			
			WebElement element = driver.findElement(By.xpath("(//div[@row-id='"+i+"'])[2]//div[@col-id='country']"));
			
			act.moveToElement(element).click().build().perform();
			// Get the text from the element
			String text = element.getText();
			// Check if the text contains any alphabetic characters
			if (!containsSpecialCharacter(text)) {
				System.out.println("The country column does not allow Special characters");
				
			} else {
				System.out.println("The country column allowed to enter the Special characters - "+text);
				countryallPassed2=false;
				
			} 
		}
	
		scrollBottom(driver);
		
		if (countryallPassed2) {
			Extent_pass(driver, "The country column does not allow Special characters", test,test1);
		} else {
			Extent_fail(driver, "The country column allowed to enter the Special characters", test,test1);
		}
		
		System.out.println("************Testcase 147 Completed***********");
		

		Extent_cal(test, "Testcase 150 - Ensure in  import from excel Import column not allow alphabets");
		
		wait(driver,"2");
		
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
		wait(driver,"2");
		
//		uploadFileRobot(driver,Import_alphabets);

		String upload_import = System.getProperty("user.dir") + "/driver/MasterDownloadfile.exe " + Import_alphabets;

		try {
			Runtime.getRuntime().exec(upload_import);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getLocalizedMessage());
		}
		
		wait(driver,"20");
		
		Fluentwait(driver, Location3);
		
		if(isDisplayed(driver, click_yes)) {
			
			click(driver, click_yes);
			
			Fluentwait(driver, Click_ok);
			click(driver, Click_ok);
		}
		
		wait(driver,"2");
		
		waitForElement(driver, Total_record);
	
		boolean allPassed = true;

		for (int i = 0; i < length2; i++) {
		
			WebElement element = driver.findElement(By.xpath("(//div[@row-id='" + i + "'])[2]//div[@col-id='importCnt']"));
		    act.moveToElement(element).click().build().perform();
		    String text = element.getText();

		    if (!containsAlphabetic(text)) {
		        System.out.println("The Import column does not allow alphabetic characters");
		       
		    } else {
		        System.out.println("The Import column allowed to enter the alphabetic characters - " + text);
		        allPassed = false; // Set the flag to false if any condition fails
		    }
		}

		// Print the summary result
		
		scrollBottom(driver);
		
		if (allPassed) {
			 Extent_pass(driver, "The Import column does not allow alphabetic characters", test,test1);
		} else {
		    System.out.println("Some conditions failed.");
	        Extent_fail(driver, "The Import column allowed to enter the alphabetic characters", test,test1);
		}


		System.out.println("************Testcase 150 Completed***********");
		
		wait(driver,"2");
		
		Extent_cal(test, "Testcase 151 - Ensure in import from excel Import column allow numeric");
		
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
		
		wait(driver,"3");
		
//		uploadFileRobot(driver,EquimentType_Alphabets);
		
		String upload_alphabtes = System.getProperty("user.dir") + "/driver/MasterDownloadfile.exe " + EquimentType_Alphabets;

		try {
			Runtime.getRuntime().exec(upload_alphabtes);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getLocalizedMessage());
		}
		
		wait(driver,"20");
		
		Fluentwait(driver, Location3);
		
		if(isDisplayed(driver, click_yes)) {
			
			click(driver, click_yes);
			
			Fluentwait(driver, Click_ok);
			click(driver, Click_ok);
		}
		
		wait(driver,"3");
	
		if(isDisplayed(driver, EquipmentType_column2)) {
			
			Extent_pass(driver,"import from excel Import column allow Numerical values ", test,test1);
		}else{
			
			Extent_fail(driver,"import from excel Import column not allow Numerical values", test,test1);
		}
		
		System.out.println("************Testcase 151 Completed***********");
	
		
		Extent_cal(test, "Testcase 152 - Ensure in import from excel  Import column not allow Special character");	
		
		Fluentwait(driver, Cancel);
		click(driver, Cancel);
		wait(driver, "2");
		
		Fluentwait(driver, New);
		click(driver, New);
		
		Fluentwait(driver, New_Popup_Yes);
		click(driver, New_Popup_Yes);
		
		wait(driver,"2");
		Fluentwait(driver, dropdown_option);
		click(driver, dropdown_option);
		
		Fluentwait(driver, Budget_Reposition);
		click(driver, Budget_Reposition);
		
		Fluentwait(driver, Budget);
		click(driver, Budget);
		wait(driver,"2");
		
//		uploadFileRobot(driver,Import_specialcharacter);
		
		String upload_specialcharacter = System.getProperty("user.dir") + "/driver/MasterDownloadfile.exe " + Import_specialcharacter;

		try {
			Runtime.getRuntime().exec(upload_specialcharacter);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getLocalizedMessage());
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
		}
		
		wait(driver,"20");
		
		Fluentwait(driver, Location3);
		
		if(isDisplayed(driver, click_yes)) {
			
			click(driver, click_yes);
			
			Fluentwait(driver, Click_ok);
			click(driver, Click_ok);
		}
		
		wait(driver,"2");
		
		boolean ImportallPassed = true; 
		
		for (int i = 0; i < length2; i++) {
			
			WebElement element = driver.findElement(By.xpath("(//div[@row-id='"+i+"'])[2]//div[@col-id='importCnt']"));
			
			act.moveToElement(element).click().build().perform();
			// Get the text from the element
			String text = element.getText();
			// Check if the text contains any alphabetic characters
			if (!containsSpecialCharacter(text)) {
				System.out.println("The Import column does not allow Special characters");
			} else {
				System.out.println("The Import column allowed to enter the Special characters - "+text);
				ImportallPassed=false;				
			} 
		}
		
		scrollBottom(driver);
		
		if (ImportallPassed) {
			 Extent_pass(driver, "The Import column does not allow Special characters", test,test1);
		} else {
	        Extent_fail(driver, "The Import column allowed to enter the Special characters", test,test1);
		}
	
		System.out.println("************Testcase 152 Completed***********");
		
		wait(driver,"2");
	
		Extent_cal(test, "Testcase 155 - Ensure in  import from excel Export column not allow alphabets");
		
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
		wait(driver,"2");
		
//		uploadFileRobot(driver,Import_alphabets);

		String upload_alpha = System.getProperty("user.dir") + "/driver/MasterDownloadfile.exe " + Import_alphabets;

		try {
			Runtime.getRuntime().exec(upload_alpha);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getLocalizedMessage());
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
		}
		
		wait(driver,"2");
		
		Fluentwait(driver, Location3);
		
		wait(driver,"2");
		
		Fluentwait(driver, Total_record);
		
		boolean allPassedexport1=true;
		
		for (int i = 0; i < length2; i++) {
		
			WebElement element = driver.findElement(By.xpath("(//div[@row-id='"+i+"'])[2]//div[@col-id='su']"));
			
			act.moveToElement(element).click().build().perform();
			// Get the text from the element
			String text = element.getText();
			// Check if the text contains any alphabetic characters
			if (!containsAlphabetic(text)) {
				System.out.println("The Export column does not allow alphabetic characters");
			} else {
				System.out.println("The Export column allowed to enter the alphabetic characters - "+text);
				allPassedexport1=false;
				
			} 
		}
		
		scrollBottom(driver);
		
		if (allPassedexport1) {
			Extent_pass(driver, "The Export column does not allow alphabetic characters", test,test1);
		} else {
			Extent_fail(driver, "The Export column allowed to enter the alphabetic characters", test,test1);
		}
		
		System.out.println("************Testcase 155 Completed***********");
	

		Extent_cal(test, "Testcase 156 - Ensure in  import from excel Export column allow numeric");
		
		Fluentwait(driver, Cancel);
		click(driver, Cancel);
	
		wait(driver, "2");
		Fluentwait(driver, New);
		click(driver, New);
		
		Fluentwait(driver, New_Popup_Yes);
		click(driver, New_Popup_Yes);
		wait(driver, "2");	
		
		
		wait(driver,"2");
		
		Fluentwait(driver, dropdown_option);
		click(driver, dropdown_option);
		
		Fluentwait(driver, Budget_Reposition);
		click(driver, Budget_Reposition);
		
		Fluentwait(driver, Budget);
		click(driver, Budget);
		
		wait(driver,"3");
		
//		uploadFileRobot(driver,EquimentType_Alphabets);
		
		String upload_EquimentType_Alphabets = System.getProperty("user.dir") + "/driver/MasterDownloadfile.exe " + EquimentType_Alphabets;

		try {
			Runtime.getRuntime().exec(upload_EquimentType_Alphabets);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getLocalizedMessage());
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
		}
		
		wait(driver,"3");
		
		Fluentwait(driver, Location3);
		
		wait(driver,"2");
	
		if(isDisplayed(driver, EquipmentType_column2)) {
			Extent_pass(driver,"import from excel Export column allow Numerical values ", test,test1);
		}else{
			Extent_fail(driver,"import from excel Export column not allow Numerical values", test,test1);
		}
		
		System.out.println("************Testcase 156 Completed***********");
		
		
		Extent_cal(test, "Testcase 157 - Ensure in  import from excel  Export column not allow Special character");	

		Fluentwait(driver, Cancel);
		click(driver, Cancel);
		wait(driver, "2");
		
		Fluentwait(driver, New);
		click(driver, New);
		
		Fluentwait(driver, New_Popup_Yes);
		click(driver, New_Popup_Yes);
		wait(driver, "2");	
		
		
		wait(driver,"2");
		Fluentwait(driver, dropdown_option);
		click(driver, dropdown_option);
		
		Fluentwait(driver, Budget_Reposition);
		click(driver, Budget_Reposition);
		
		Fluentwait(driver, Budget);
		click(driver, Budget);
		wait(driver,"2");
		
//		uploadFileRobot(driver,Import_specialcharacter);

		
		String upload_special = System.getProperty("user.dir") + "/driver/MasterDownloadfile.exe " + Import_specialcharacter;

		try {
			Runtime.getRuntime().exec(upload_special);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getLocalizedMessage());
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
		}
		
		wait(driver,"2");
		
		Fluentwait(driver, Location3);
		
		wait(driver,"2");
		
		boolean exportallPassed2=true;
		
		for (int i = 0; i < length2; i++) {
			
			WebElement element = driver.findElement(By.xpath("(//div[@row-id='"+i+"'])[2]//div[@col-id='export']"));
			
			act.moveToElement(element).click().build().perform();
			// Get the text from the element
			String text = element.getText();
			// Check if the text contains any alphabetic characters
			if (!containsSpecialCharacter(text)) {
				System.out.println("The Export column does not allow Special characters");
				
			} else {
				System.out.println("The Export column allowed to enter the Special characters - "+text);
				exportallPassed2=false;
				
			} 
		}
	
		scrollBottom(driver);
		
		if (exportallPassed2) {
			Extent_pass(driver, "The Export column does not allow Special characters", test,test1);
		} else {
			Extent_fail(driver, "The Export column allowed to enter the Special characters", test,test1);
		}
		
		System.out.println("************Testcase 157 Completed***********");
		
		
		
		Extent_cal(test, "Testcase 160 - Ensure in  import from excel Bench Mark Stock column not allow alphabets");
		
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
		wait(driver,"2");
		
//		uploadFileRobot(driver,Import_alphabets);
		
		String upload_Import_alphabets = System.getProperty("user.dir") + "/driver/MasterDownloadfile.exe " + Import_alphabets;

		try {
			Runtime.getRuntime().exec(upload_Import_alphabets);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getLocalizedMessage());
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
		}
		
		wait(driver,"20");
		
		Fluentwait(driver, Location3);
		
		if(isDisplayed(driver, click_yes)) {
			
			click(driver, click_yes);
			
			Fluentwait(driver, Click_ok);
			click(driver, Click_ok);
		}
		
		wait(driver,"2");
		
		waitForElement(driver, Total_record);
		
		boolean allPassedexport2=true;
		
		for (int i = 0; i < length2; i++) {
		
			WebElement element = driver.findElement(By.xpath("(//div[@row-id='"+i+"'])[2]//div[@col-id='su']"));
			
			act.moveToElement(element).click().build().perform();
			// Get the text from the element
			String text = element.getText();
			// Check if the text contains any alphabetic characters
			if (!containsAlphabetic(text)) {
				System.out.println("The Bench Mark Stock column does not allow alphabetic characters");
			} else {
				System.out.println("The Bench Mark Stock column allowed to enter the alphabetic characters - "+text);
				allPassedexport2=false;
				
			} 
		}
		
		scrollBottom(driver);
		
		if (allPassedexport2) {
			Extent_pass(driver, "The Bench Mark Stock column does not allow alphabetic characters", test,test1);
		} else {
			Extent_fail(driver, "The Bench Mark Stock column allowed to enter the alphabetic characters", test,test1);
		}
		
		System.out.println("************Testcase 160 Completed***********");
	

		Extent_cal(test, "Testcase 161 - Ensure in  import from excel Bench Mark Stock column  allow numeric");
		
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
		
		wait(driver,"3");
		
//		uploadFileRobot(driver,EquimentType_Alphabets);

		String upload_EquimentType_Alphabets1 = System.getProperty("user.dir") + "/driver/MasterDownloadfile.exe " + EquimentType_Alphabets;

		try {
			Runtime.getRuntime().exec(upload_EquimentType_Alphabets1);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getLocalizedMessage());
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
		}
		
		wait(driver,"20");
		
		Fluentwait(driver, Location3);
		
		if(isDisplayed(driver, click_yes)) {
			
			click(driver, click_yes);
			
			Fluentwait(driver, Click_ok);
			click(driver, Click_ok);
		}
		
		wait(driver,"2");
	
		if(isDisplayed(driver, EquipmentType_column2)) {
			Extent_pass(driver,"import from excel Bench Mark Stock column allow Numerical values ", test,test1);
		}else{
			Extent_fail(driver,"import from excel Bench Mark Stock column not allow Numerical values", test,test1);
		}
		
		System.out.println("************Testcase 161 Completed***********");
		
		
		Extent_cal(test, "Testcase 162 - Ensure in  import from excel  Bench Mark Stock column not allow Special character");	

		Fluentwait(driver, Cancel);
		click(driver, Cancel);
		wait(driver, "2");
		
		Fluentwait(driver, New);
		click(driver, New);
		
		Fluentwait(driver, New_Popup_Yes);
		click(driver, New_Popup_Yes);
		wait(driver, "2");	
		
		
		wait(driver,"2");
		Fluentwait(driver, dropdown_option);
		click(driver, dropdown_option);
		
		Fluentwait(driver, Budget_Reposition);
		click(driver, Budget_Reposition);
		
		Fluentwait(driver, Budget);
		click(driver, Budget);
		wait(driver,"2");
		
//		uploadFileRobot(driver,Import_specialcharacter);
		
		String upload_Import_specialcharacter = System.getProperty("user.dir") + "/driver/MasterDownloadfile.exe " + Import_specialcharacter;

		try {
			Runtime.getRuntime().exec(upload_Import_specialcharacter);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getLocalizedMessage());
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
		}
		
		wait(driver,"20");
		
		Fluentwait(driver, Location3);
		
		if(isDisplayed(driver, click_yes)) {
			
			click(driver, click_yes);
			
			Fluentwait(driver, Click_ok);
			click(driver, Click_ok);
		}
		
		wait(driver,"2");
		
		boolean exportallPassed3=true;
		
		for (int i = 0; i < length2; i++) {
			
			WebElement element = driver.findElement(By.xpath("(//div[@row-id='"+i+"'])[2]//div[@col-id='su']"));
			
			act.moveToElement(element).click().build().perform();
			// Get the text from the element
			String text = element.getText();
			// Check if the text contains any alphabetic characters
			if (!containsSpecialCharacter(text)) {
				System.out.println("The Bench Mark Stock column does not allow Special characters");
				
			} else {
				System.out.println("The Bench Mark Stock column allowed to enter the Special characters - "+text);
				exportallPassed3=false;
				
			} 
		}
	
		scrollBottom(driver);
		
		if (exportallPassed3) {
			Extent_pass(driver, "The Bench Mark Stock column does not allow Special characters", test,test1);
		} else {
			Extent_fail(driver, "The Bench Mark Stock column allowed to enter the Special characters", test,test1);
		}
		
		System.out.println("************Testcase 162 Completed***********");
		
		
		
		Extent_cal(test, "Testcase 165 - Ensure in  import from excel Applied Surplus/Deficit column not allow alphabets");
		
		wait(driver,"2");
		
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
		wait(driver,"2");
		
//		uploadFileRobot(driver,Import_alphabets);
		
		String upload_Import_alphabets2 = System.getProperty("user.dir") + "/driver/MasterDownloadfile.exe " + Import_alphabets;

		try {
			Runtime.getRuntime().exec(upload_Import_alphabets2);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getLocalizedMessage());
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
		}
		
		wait(driver,"20");
		
		Fluentwait(driver, Location3);
		
		if(isDisplayed(driver, click_yes)) {
			
			click(driver, click_yes);
			
			Fluentwait(driver, Click_ok);
			click(driver, Click_ok);
		}
		
		wait(driver,"2");
		
		waitForElement(driver, Total_record);
		
		String Total_records5 = getText(driver, Total_record);
		
		int length5 = Integer.parseInt(Total_records5);	
		
		boolean appsurf_alpha = true;

		for (int i = 0; i < length5; i++) {
		
			WebElement element = driver.findElement(By.xpath("(//div[@row-id='" + i + "'])[2]//div[@col-id='appsurdef']"));
		    act.moveToElement(element).click().build().perform();
		    String text = element.getText();

		    if (!containsAlphabetic(text)) {
		        System.out.println("The Applied Surplus/Deficit column does not allow alphabetic characters");
		       
		    } else {
		        System.out.println("The Applied Surplus/Deficit column allow alphabetic characters - " + text);
		        appsurf_alpha = false; // Set the flag to false if any condition fails
		    }
		}

		// Print the summary result
		
		scrollBottom(driver);
		
		if (appsurf_alpha) {
			 Extent_pass(driver, "The Applied Surplus/Deficit column does not allow alphabetic characters", test,test1);
		} else {
	        Extent_fail(driver, "The Applied Surplus/Deficit column allow alphabetic characters", test,test1);
		}


		System.out.println("************Testcase 165 Completed***********");
		
		wait(driver,"2");
		
		Extent_cal(test, "Testcase 166 - Ensure in  import from excel Applied Surplus/Deficit column allow numeric");
		
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
		
		wait(driver,"3");
		
//		uploadFileRobot(driver,Import_specialcharacter);
		
		String upload_Import_specialcharacter3 = System.getProperty("user.dir") + "/driver/MasterDownloadfile.exe " + Import_specialcharacter;

		try {
			Runtime.getRuntime().exec(upload_Import_specialcharacter3);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getLocalizedMessage());
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
		}
		
		wait(driver,"20");
		
		Fluentwait(driver, Location3);
		
		if(isDisplayed(driver, click_yes)) {
			
			click(driver, click_yes);
			
			Fluentwait(driver, Click_ok);
			click(driver, Click_ok);
		}
		
		wait(driver,"2");
	
		boolean appsurf_number = true;

		for (int i = 0; i < length2; i++) {
		
			WebElement element = driver.findElement(By.xpath("(//div[@row-id='" + i + "'])[2]//div[@col-id='appsurdef']"));
		    act.moveToElement(element).click().build().perform();
		    String text = element.getText();

		    if (containsNumeric(text)||text.isEmpty()) {
		        System.out.println("The Applied Surplus/Deficit column allow numeric values");
		       
		    } else {
		        System.out.println("The Applied Surplus/Deficit column does not allow numeric values - " + text);
		        appsurf_number = false; // Set the flag to false if any condition fails
		    }
		}
		
		scrollBottom(driver);
		
		if (appsurf_number) {
			 Extent_pass(driver, "The Applied Surplus/Deficit column allow numeric values", test,test1);
		} else {
	        Extent_fail(driver, "The Applied Surplus/Deficit column does not allow numeric values", test,test1);
		}
		
		
		System.out.println("************Testcase 166 Completed***********");
	
		
		Extent_cal(test, "Testcase 167 - Ensure in  import from excel  Applied Surplus/Deficit column not allow Special character");	
		
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
		wait(driver,"2");
		
//		uploadFileRobot(driver,Import_specialcharacter);
		
		String upload_Import_specialcharacter2 = System.getProperty("user.dir") + "/driver/MasterDownloadfile.exe " + Import_specialcharacter;

		try {
			Runtime.getRuntime().exec(upload_Import_specialcharacter2);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getLocalizedMessage());
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
		}
		
		wait(driver,"20");
		
		Fluentwait(driver, Location3);
		
		if(isDisplayed(driver, click_yes)) {
			
			click(driver, click_yes);
			
			Fluentwait(driver, Click_ok);
			click(driver, Click_ok);
		}
		
		wait(driver,"2");
		
		boolean region_special = true; 
		
		for (int i = 0; i < length2; i++) {
			
			WebElement element = driver.findElement(By.xpath("(//div[@row-id='"+i+"'])[2]//div[@col-id='appsurdef']"));
			
			act.moveToElement(element).click().build().perform();
			// Get the text from the element
			String text = element.getText();
			// Check if the text contains any alphabetic characters
			if (!containsSpecialCharacter(text)) {
				System.out.println("The Applied Surplus/Deficit column does not allow Special characters");
			} else {
				System.out.println("The Applied Surplus/Deficit column allowed to enter the Special characters - "+text);
				region_special=false;				
			} 
		}
		
		scrollBottom(driver);
		
		if (region_special) {
			 Extent_pass(driver, "The Applied Surplus/Deficit column does not allow Special characters", test,test1);
		} else {
	        Extent_fail(driver, "The Applied Surplus/Deficit column allowed to enter the Special characters", test,test1);
		}
	
		System.out.println("************Testcase 167 Completed***********");
	
		
		Extent_cal(test, "Testcase 180 - Ensure in  import from excel One Way Qty column not allow alphabets");
		
		wait(driver,"2");
		
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
		wait(driver,"2");
		
//		uploadFileRobot(driver,Import_alphabets);

		String upload_Import_specialcharacter4 = System.getProperty("user.dir") + "/driver/MasterDownloadfile.exe " + Import_alphabets;

		try {
			Runtime.getRuntime().exec(upload_Import_specialcharacter4);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getLocalizedMessage());
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
		}
		
		wait(driver,"20");
		
		Fluentwait(driver, Location3);
		
		if(isDisplayed(driver, click_yes)) {
			
			click(driver, click_yes);
			
			Fluentwait(driver, Click_ok);
			click(driver, Click_ok);
		}
		
		wait(driver,"2");		
		
		waitForElement(driver, Total_record);
		
		String Total_records6 = getText(driver, Total_record);
		
		int length6 = Integer.parseInt(Total_records6);	
		
		WebElement scroller = driver.findElement(By.xpath("//div[@ref='eBodyHorizontalScrollViewport']"));
		
		int scrollAmount = 1000; // 
		
		js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller, scrollAmount);
		
		boolean Onewayload_alpha = true;

		for (int i = 0; i < length6; i++) {
		
			WebElement element = driver.findElement(By.xpath("(//div[@row-id='" + i + "'])[2]//div[@col-id='onewayoutload']"));
		    act.moveToElement(element).click().build().perform();
		    String text = element.getText();

		    if (!containsAlphabetic(text)) {
		        System.out.println("The onewayoutload column does not allow alphabetic characters");
		       
		    } else {
		        System.out.println("The onewayoutload column allow alphabetic characters - " + text);
		        Onewayload_alpha = false; // Set the flag to false if any condition fails
		    }
		}
		
		scrollBottom(driver);
		
		for (int i = 0; i < length6; i++) {
			
			WebElement element = driver.findElement(By.xpath("(//div[@row-id='" + i + "'])[2]//div[@col-id='onewayoutreturn']"));
		    act.moveToElement(element).click().build().perform();
		    String text = element.getText();

		    if (!containsAlphabetic(text)) {
		        System.out.println("The onewayoutload column does not allow alphabetic characters");
		       
		    } else {
		        System.out.println("The onewayoutload column allow alphabetic characters - " + text);
		        Onewayload_alpha = false; // Set the flag to false if any condition fails
		    }
		}
		
		scrollBottom(driver);
		
		for (int i = 0; i < length6; i++) {
			
			WebElement element = driver.findElement(By.xpath("(//div[@row-id='" + i + "'])[2]//div[@col-id='onewaylease']"));
		    act.moveToElement(element).click().build().perform();
		    String text = element.getText();

		    if (!containsAlphabetic(text)) {
		        System.out.println("The onewayoutload column does not allow alphabetic characters");
		       
		    } else {
		        System.out.println("The onewayoutload column allow alphabetic characters - " + text);
		        Onewayload_alpha = false; // Set the flag to false if any condition fails
		    }
		}
		
		scrollBottom(driver);
		
		for (int i = 0; i < length6; i++) {
			
			WebElement element = driver.findElement(By.xpath("(//div[@row-id='" + i + "'])[2]//div[@col-id='tboh']"));
		    act.moveToElement(element).click().build().perform();
		    String text = element.getText();

		    if (!containsAlphabetic(text)) {
		        System.out.println("The onewayoutload column does not allow alphabetic characters");
		       
		    } else {
		        System.out.println("The onewayoutload column allow alphabetic characters - " + text);
		        Onewayload_alpha = false; // Set the flag to false if any condition fails
		    }
		}
		
		scrollBottom(driver);

		for (int i = 0; i < length6; i++) {
			
			WebElement element = driver.findElement(By.xpath("(//div[@row-id='" + i + "'])[2]//div[@col-id='sali']"));
		    act.moveToElement(element).click().build().perform();
		    String text = element.getText();

		    if (!containsAlphabetic(text)) {
		        System.out.println("The onewayoutload column does not allow alphabetic characters");
		       
		    } else {
		        System.out.println("The onewayoutload column allow alphabetic characters - " + text);
		        Onewayload_alpha = false; // Set the flag to false if any condition fails
		    }
		}

		// Print the summary result
		
		scrollBottom(driver);
		
		if (Onewayload_alpha) {
			 Extent_pass(driver, "The onewayoutload column does not allow alphabetic characters", test,test1);
		} else {
	        Extent_fail(driver, "The onewayoutload column allow alphabetic characters", test,test1);
		}


		System.out.println("************Testcase 180 Completed***********");
		
		
		
		wait(driver,"2");
		
		Extent_cal(test, "Testcase 181 - Ensure in  import from excel  One Way Qty column  allow  numeric");
		
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
		
		wait(driver,"3");
		
//		uploadFileRobot(driver,Import_specialcharacter);
		
		String upload_Import_specialcharacter5 = System.getProperty("user.dir") + "/driver/MasterDownloadfile.exe " + Import_specialcharacter;

		try {
			Runtime.getRuntime().exec(upload_Import_specialcharacter5);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getLocalizedMessage());
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
		}
		
		wait(driver,"20");
		
		Fluentwait(driver, Location3);
		
		if(isDisplayed(driver, click_yes)) {
			
			click(driver, click_yes);
			
			Fluentwait(driver, Click_ok);
			click(driver, Click_ok);
		}
		
		wait(driver,"2");
		
		String Total_records2 = getText(driver, Total_record);
		
		int length3 = Integer.parseInt(Total_records2);	
		
		int scrollAmount2 = 1000; // 
		
		WebElement scroller1 = driver.findElement(By.xpath("//div[@ref='eBodyHorizontalScrollViewport']"));
		wait.until(ExpectedConditions.elementToBeClickable(scroller1));
		
		js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller1, scrollAmount2);
	
		boolean Oneway_number = true;

		for (int i = 0; i < length3; i++) {
		
			WebElement element = driver.findElement(By.xpath("(//div[@row-id='" + i + "'])[2]//div[@col-id='onewayoutload']"));
		    act.moveToElement(element).click().build().perform();
		    String text = element.getText();

		    if (containsNumeric(text)||text.isEmpty()) {
		        System.out.println("The onewayoutload column allow numeric values");
		       
		    } else {
		        System.out.println("The onewayoutload column does not allow numeric values - " + text);
		        Oneway_number = false; // Set the flag to false if any condition fails
		    }
		}
		
		scrollBottom(driver);
		
		for (int i = 0; i < length3; i++) {
			
			WebElement element = driver.findElement(By.xpath("(//div[@row-id='" + i + "'])[2]//div[@col-id='onewayoutreturn']"));
		    act.moveToElement(element).click().build().perform();
		    String text = element.getText();
		    
		    if (containsNumeric(text)||text.isEmpty()) {
		        System.out.println("The oneway out return column allow numeric values");
		       
		    } else {
		        System.out.println("The oneway out return column does not allow numeric values - " + text);
		        Oneway_number = false; // Set the flag to false if any condition fails
		    }

		}
		
		scrollBottom(driver);
		
		for (int i = 0; i < length3; i++) {
			
			WebElement element = driver.findElement(By.xpath("(//div[@row-id='" + i + "'])[2]//div[@col-id='onewaylease']"));
		    act.moveToElement(element).click().build().perform();
		    String text = element.getText();


		    if (containsNumeric(text)||text.isEmpty()) {
		        System.out.println("The oneway In load column allow numeric values");
		       
		    } else {
		        System.out.println("The oneway In load column does not allow numeric values - " + text);
		        Oneway_number = false; // Set the flag to false if any condition fails
		    }
		    
		 
		}
		
		scrollBottom(driver);
		
		
		for (int i = 0; i < length3; i++) {
			
			WebElement element = driver.findElement(By.xpath("(//div[@row-id='" + i + "'])[2]//div[@col-id='tboh']"));
		    act.moveToElement(element).click().build().perform();
		    String text = element.getText();

		    if (containsNumeric(text)||text.isEmpty()) {
		        System.out.println("The oneway In trans column allow numeric values");
		       
		    } else {
		        System.out.println("The oneway In trans column does not allow numeric values - " + text);
		        Oneway_number = false; // Set the flag to false if any condition fails
		    }
		    
		   
		}
		
		scrollBottom(driver);
		
		for (int i = 0; i < length3; i++) {
			
			WebElement element = driver.findElement(By.xpath("(//div[@row-id='" + i + "'])[2]//div[@col-id='sali']"));
		    act.moveToElement(element).click().build().perform();
		    String text = element.getText();

		    if (containsNumeric(text)||text.isEmpty()) {
		        System.out.println("The oneway In Return column allow numeric values");
		       
		    } else {
		        System.out.println("The oneway In Return column does not allow numeric values - " + text);
		        Oneway_number = false; // Set the flag to false if any condition fails
		    }
		    
		   
		}
		
		scrollBottom(driver);
		
		
		if (Oneway_number) {
			 Extent_pass(driver, "The Applied Surplus/Deficit column allow numeric values", test,test1);
		} else {
	        Extent_fail(driver, "The Applied Surplus/Deficit column does not allow numeric values", test,test1);
		}
		
		
		System.out.println("******************Testcase 181 - Completed **********************");
		
	
		
		Extent_cal(test, "Testcase 182 - Ensure in  import from excel   One Way Qty column not allow Special character");
		
		wait(driver,"2");
		
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
		wait(driver,"2");
		
//		uploadFileRobot(driver,Import_alphabets);
		
		String upload_Import_alphabets4 = System.getProperty("user.dir") + "/driver/MasterDownloadfile.exe " + Import_alphabets;

		try {
			Runtime.getRuntime().exec(upload_Import_alphabets4);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getLocalizedMessage());
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
		}
		
		wait(driver,"20");
		
		Fluentwait(driver, Location3);
		
if(isDisplayed(driver, click_yes)) {
			
			click(driver, click_yes);
			
			Fluentwait(driver, Click_ok);
			click(driver, Click_ok);
		}
		
		wait(driver,"2");
		
		waitForElement(driver, Total_record);
		
		String Oneway_Special_records = getText(driver, Total_record);
		
		int Oneway_Special_recordslength = Integer.parseInt(Oneway_Special_records);	
		
		WebElement scroller3 = driver.findElement(By.xpath("//div[@ref='eBodyHorizontalScrollViewport']"));
		
		int scrollAmount3 = 1000; 
		
		js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller3, scrollAmount3);
		
		boolean Onewayload_special = true;

		for (int i = 0; i < Oneway_Special_recordslength; i++) {
		
			WebElement element = driver.findElement(By.xpath("(//div[@row-id='" + i + "'])[2]//div[@col-id='onewayoutload']"));
		    act.moveToElement(element).click().build().perform();
		    String text = element.getText();

		    if (!containsAlphabetic(text)) {
		        System.out.println("The onewayoutload column does not allow special characters");
		       
		    } else {
		        System.out.println("The onewayoutload column allow special characters - " + text);
		        Onewayload_special = false; // Set the flag to false if any condition fails
		    }
		}
		
		scrollBottom(driver);
		
		for (int i = 0; i < Oneway_Special_recordslength; i++) {
			
			WebElement element = driver.findElement(By.xpath("(//div[@row-id='" + i + "'])[2]//div[@col-id='onewayoutreturn']"));
		    act.moveToElement(element).click().build().perform();
		    String text = element.getText();

		    if (!containsAlphabetic(text)) {
		        System.out.println("The onewayoutload column does not allow special characters");
		       
		    } else {
		        System.out.println("The onewayoutload column allow special characters - " + text);
		        Onewayload_special = false; // Set the flag to false if any condition fails
		    }
		}
		
		scrollBottom(driver);
		
		for (int i = 0; i < Oneway_Special_recordslength; i++) {
			
			WebElement element = driver.findElement(By.xpath("(//div[@row-id='" + i + "'])[2]//div[@col-id='onewaylease']"));
		    act.moveToElement(element).click().build().perform();
		    String text = element.getText();

		    if (!containsAlphabetic(text)) {
		        System.out.println("The onewayoutload column does not allow special characters");
		       
		    } else {
		        System.out.println("The onewayoutload column allow special characters - " + text);
		        Onewayload_special = false; // Set the flag to false if any condition fails
		    }
		}
		
		scrollBottom(driver);
		
		for (int i = 0; i < Oneway_Special_recordslength; i++) {
			
			WebElement element = driver.findElement(By.xpath("(//div[@row-id='" + i + "'])[2]//div[@col-id='tboh']"));
		    act.moveToElement(element).click().build().perform();
		    String text = element.getText();

		    if (!containsAlphabetic(text)) {
		        System.out.println("The onewayoutload column does not allow special characters");
		       
		    } else {
		        System.out.println("The onewayoutload column allow special characters - " + text);
		        Onewayload_special = false; // Set the flag to false if any condition fails
		    }
		}
		
		scrollBottom(driver);

		for (int i = 0; i < Oneway_Special_recordslength; i++) {
			
			WebElement element = driver.findElement(By.xpath("(//div[@row-id='" + i + "'])[2]//div[@col-id='sali']"));
		    act.moveToElement(element).click().build().perform();
		    String text = element.getText();

		    if (!containsAlphabetic(text)) {
		        System.out.println("The onewayoutload column does not allow special characters");
		       
		    } else {
		        System.out.println("The onewayoutload column allow special characters - " + text);
		        Onewayload_special = false; // Set the flag to false if any condition fails
		    }
		}

		// Print the summary result
		
		scrollBottom(driver);
		
		if (Onewayload_special) {
			 Extent_pass(driver, "The onewayoutload column does not allow special characters", test,test1);
		} else {
	        Extent_fail(driver, "The onewayoutload column allow special characters", test,test1);
		}


		System.out.println("************Testcase 182 Completed***********");
		
		Extent_cal(test, "Testcase 185 - Ensure in  import from excel TBOH/OFHI column not allow alphabets");
		
		Fluentwait(driver, Searchbox);
		sendKeys(driver, Searchbox, "On Off Hire Stock");
		
		Fluentwait(driver, OnOFF_Hire);
		click(driver, OnOFF_Hire);

		Fluentwait(driver, Total_columnrecord);
		String OnOFF_Total_records = getText(driver, Total_columnrecord);
		
		int OnOFF_length = Integer.parseInt(OnOFF_Total_records);
		
		boolean onhire_alpha = true;
		
		for (int i = 0; i < 10; i++) {
			
				WebElement element = driver.findElement(By.xpath("(//div[@row-id='" + i + "'])[5]//div[@col-id='count']"));
			    act.moveToElement(element).click().build().perform();
			    String text = element.getText();
	
			    if (!containsAlphabetic(text)) {
			        System.out.println("The On hire column does not allow alphabetic characters");
			       
			    } else {
			        System.out.println("The On hire column allowed to enter the alphabetic characters - " + text);
			        Extent_fail(driver, "The On hire column allowed to enter the alphabetic characters - " + text,  test,test1);
			        onhire_alpha = false; 
			    }
			}
		
		
		if(onhire_alpha) {
			
			System.out.println("On hire Column not allow alphabet characters");
			Extent_pass(driver, "On hire Column not allow alphabet characters", test,test1);
		}else {
			
			System.out.println("On hire column allows alphabet characters");
			Extent_fail(driver, "On hire column allows alphabet characters", test,test1);
		}
		
		scrollBottom(driver);
		
		System.out.println("Testcase 185 Completed");
		
		
		Extent_cal(test, "Testcase 186 - Ensure in  import from excel  TBOH/OFHI column  allow numeric");
		
		
		boolean onhire_numeric = true;
		
		for (int i = 0; i < 10; i++) {
			
				WebElement element = driver.findElement(By.xpath("(//div[@row-id='" + i + "'])[5]//div[@col-id='count']"));
			    act.moveToElement(element).click().build().perform();
			    String text = element.getText();
	
			    if (containsNumeric(text)) {
			        System.out.println("The On hire column allowed to enter the numeric values - " + text);
			       
			    } else {
			        System.out.println("The On hire column does not allow numeric values - "+text);
			        Extent_fail(driver, "The On hire column does not allow numeric values - " + text, test,test1);
			        onhire_numeric = false; 
			    }
			}
		
		
		if(onhire_numeric) {
			
			System.out.println("On hire column allows numeric values");
			Extent_pass(driver, "On hire column allows numeric values", test,test1);
		
		}else {
			System.out.println("On hire Column not allow numeric values");
			Extent_fail(driver, "On hire Column not allow numeric values", test,test1);
			
		}
		
		scrollBottom(driver);
		
		System.out.println("Testcase 186 Completed");
		
		
		Extent_cal(test, "Testcase 187 - Ensure in  import from excel   TBOH/OFHI column not allow Special character");
		
		boolean onhire_special = true;
		
		for (int i = 0; i < 10; i++) {
			
				WebElement element = driver.findElement(By.xpath("(//div[@row-id='" + i + "'])[5]//div[@col-id='count']"));
			    act.moveToElement(element).click().build().perform();
			    String text = element.getText();
	
			    if (!containsAlphabetic(text)) {
			        System.out.println("The On hire column does not allow special characters");
			       
			    } else {
			        System.out.println("The On hire column allowed to enter the special characters - " + text);
			        Extent_fail(driver, "The On hire column allowed to enter the special characters - " + text,  test,test1);
			        onhire_special = false; // Set the flag to false if any condition fails
			    }
			}
		
		
		if(onhire_special) {
			
			System.out.println("On hire Column not allow special characters");
			Extent_pass(driver, "On hire Column not allow special characters", test,test1);
		}else {
			
			System.out.println("On hire column allows special characters");
			Extent_fail(driver, "On hire column allows special characters", test,test1);
		}
		
		scrollBottom(driver);
		
		System.out.println("Testcase 187 Completed");
		
		
		Extent_cal(test, "Testcase 205 - Ensure in  import from excel Stock Status column not allow alphabets");
		
		Fluentwait(driver, Deficittab);
		click(driver, Deficittab);
		
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
		wait(driver,"2");
		
//		uploadFileRobot(driver,EquimentType_Alphabets);
		
		String upload_EquimentType_Alphabets3 = System.getProperty("user.dir") + "/driver/MasterDownloadfile.exe " + EquimentType_Alphabets;

		try {
			Runtime.getRuntime().exec(upload_EquimentType_Alphabets3);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getLocalizedMessage());
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
		}
		
		wait(driver,"20");
		
		Fluentwait(driver, Location3);
		
if(isDisplayed(driver, click_yes)) {
			
			click(driver, click_yes);
			
			Fluentwait(driver, Click_ok);
			click(driver, Click_ok);
		}
		
		wait(driver,"2");
	
		String Total_records4 = getText(driver, Total_record);
		
		int length4 = Integer.parseInt(Total_records4);
		
		boolean Stock_alpha = true;
		
		int scrollAmount4 = 1000; 
		
		WebElement scroller4 = driver.findElement(By.xpath("//div[@ref='eBodyHorizontalScrollViewport']"));
		wait.until(ExpectedConditions.elementToBeClickable(scroller4));
		
		js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller4, scrollAmount4);


		for (int i = 0; i < length4; i++) {
		
			WebElement element = driver.findElement(By.xpath("(//div[@row-id='" + i + "'])[2]//div[@col-id='stock']"));
		    act.moveToElement(element).click().build().perform();
		    String text = element.getText();

		    if (!containsAlphabetic(text)) {
		        System.out.println("The Stock status column does not allow alphabetic characters");
		       
		    } else {
		        System.out.println("The Stock status column allowed to enter the alphabetic characters - " + text);
		        Extent_fail(driver, "The Stock status column allowed to enter the alphabetic characters - " + text,  test,test1);
		        Stock_alpha = false; // Set the flag to false if any condition fails
		    }
		}

		// Print the summary result
		
		scrollBottom(driver);
		
		if (Stock_alpha) {
			 Extent_pass(driver, "The Stock status column does not allow alphabetic characters", test,test1);
		} else {
		    System.out.println("Some conditions failed.");
	        Extent_fail(driver, "The Stock status column allowed to enter the alphabetic characters", test,test1);
		}


		System.out.println("************Testcase 205 Completed***********");
		
		wait(driver,"2");
		
		Extent_cal(test, "Testcase 206 - Ensure in  import from excel Stock Status column allow numeric");
		
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
		
		wait(driver,"3");
		
//		uploadFileRobot(driver,EquimentType_Alphabets);
		
		String upload_EquimentType_Alphabets4 = System.getProperty("user.dir") + "/driver/MasterDownloadfile.exe " + EquimentType_Alphabets;

		try {
			Runtime.getRuntime().exec(upload_EquimentType_Alphabets4);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getLocalizedMessage());
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
		}
		
		wait(driver,"20");
		
		Fluentwait(driver, Location3);
		
if(isDisplayed(driver, click_yes)) {
			
			click(driver, click_yes);
			
			Fluentwait(driver, Click_ok);
			click(driver, Click_ok);
		}
		
		wait(driver,"5");
		
		boolean stock_num = true;
		
		WebElement scroller5 = driver.findElement(By.xpath("//div[@ref='eBodyHorizontalScrollViewport']"));
		wait.until(ExpectedConditions.elementToBeClickable(scroller5));
		
		js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller5, scrollAmount3);
		
		
		for (int i = 0; i < length4; i++) {
			
			WebElement element = driver.findElement(By.xpath("(//div[@row-id='" + i + "'])[2]//div[@col-id='stock']"));
		    act.moveToElement(element).click().build().perform();
		    String text = element.getText();

		    if (containsNumeric(text)||text.isEmpty()) {
		        System.out.println("The Stock status column allow to import numeric values");
		       
		    } else {
		        System.out.println("The Stock status column allow to import numeric values - " + text);
		        Extent_fail(driver, "The Stock status column allow to import numeric values - " + text,  test,test1);
		        stock_num = false; // Set the flag to false if any condition fails
		    }
		    
		   
		}
		
		scrollBottom(driver);
		
		if (stock_num) {
			 Extent_pass(driver, "The Stock status column allow to import numeric values", test,test1);
		} else {
		    System.out.println("Some conditions failed.");
	        Extent_fail(driver, "The Stock status column allow to import numeric values", test,test1);
		}
		
		System.out.println("************Testcase 206 Completed***********");
	
		
		Extent_cal(test, "Testcase 207 - Ensure in  import from excel   Stock Status column not allow Special character.");	
		
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
		wait(driver,"2");
		
//		uploadFileRobot(driver,Import_specialcharacter);
		
		String upload_Import_specialcharacter6 = System.getProperty("user.dir") + "/driver/MasterDownloadfile.exe " + Import_specialcharacter;

		try {
			Runtime.getRuntime().exec(upload_Import_specialcharacter6);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getLocalizedMessage());
			Extent_fail(driver, e.getLocalizedMessage(), test, test1);
		}
		
		wait(driver,"20");
		
		Fluentwait(driver, Location3);
		
if(isDisplayed(driver, click_yes)) {
			
			click(driver, click_yes);
			
			Fluentwait(driver, Click_ok);
			click(driver, Click_ok);
		}
		
		wait(driver,"2");
		
		boolean Stock_special = true; 
		
		WebElement scroller6 = driver.findElement(By.xpath("//div[@ref='eBodyHorizontalScrollViewport']"));
		wait.until(ExpectedConditions.elementToBeClickable(scroller6));
		
		js.executeScript("arguments[0].scrollLeft += arguments[1];", scroller6, scrollAmount3);
		
		for (int i = 0; i < length4; i++) {
			
			WebElement element = driver.findElement(By.xpath("(//div[@row-id='"+i+"'])[2]//div[@col-id='stock']"));
			
			act.moveToElement(element).click().build().perform();
			// Get the text from the element
			String text = element.getText();
			// Check if the text contains any alphabetic characters
			if (!containsSpecialCharacter(text)) {
				System.out.println("The Stock status column does not allow Special characters");
			} else {
				System.out.println("The Stock status column allowed to enter the Special characters - "+text);
				Extent_fail(driver, "The Stock status column allowed to enter the Special characters - "+text, test,test1);
				Stock_special=false;				
			} 
		}
		
		scrollBottom(driver);
		
		if (Stock_special) {
			 Extent_pass(driver, "The Stock status column does not allow Special characters", test,test1);
		} else {
	        Extent_fail(driver, "The Stock status column allowed to enter the Special characters", test,test1);
		}
	
		System.out.println("************Testcase 207 Completed***********");
		
		
		
	}	
}
