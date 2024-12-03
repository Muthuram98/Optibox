package commonMethods;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.IClass;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import DeficitAndSurflusLocationIdentification_Scripts.*;
import ERO_Cost_View.TS_001_Tc001toTc015_ERO_Cost_View;
import ERO_Cost_View.TS_002_Tc016toTc036_ERO_Cost_View;
import ERO_Cost_View.TS_003_Tc037toTc040_ERO_Cost_View;
import ERO_Cost_View.TS_004_Tc041toTc042_ERO_Cost_View;
import ERO_Cost_View.TS_005_Tc043toTc059_ERO_Cost_View;
import ERO_Cost_View.TS_006_Tc060_ERO_Cost_View;
import ERO_Cost_View.TS_007_Tc061toTc62_ERO_Cost_View;
import ERO_Cost_View.TS_008_Tc063toTc66_ERO_Cost_View;
import ERO_Cost_View.TS_009_Tc067toTc68_ERO_Cost_View;
import ERO_Cost_View.TS_010_Tc069toTc070_ERO_Cost_View;
import ERO_Cost_View.TS_011_Tc071_ERO_Cost_View;
import ERO_Deviation_report.*;
import ERO_Mass_Cost_Update.TS_014_Tc_074_ERO_Mass_Cost_Update;
import ERO_Mass_Cost_Update.TS1_002_Tc_016toTc_036_ERO_Mass_Cost_Update;
import ERO_Mass_Cost_Update.TS_001_Tc_001toTc_015_ERO_Mass_Cost_Update;
import ERO_Mass_Cost_Update.TS_003_Tc_037toTc_040_ERO_Mass_Cost_Update;
import ERO_Mass_Cost_Update.TS_004_Tc_041toTc042_ERO_Mass_Cost_Update;
import ERO_Mass_Cost_Update.TS_005_Tc_043toTc_059_ERO_Mass_Cost_Update;
import ERO_Mass_Cost_Update.TS_006_Tc_060_ERO_Mass_Cost_Update;
import ERO_Mass_Cost_Update.TS_007_Tc_061toTc_062_ERO_Mass_Cost_Update;
import ERO_Mass_Cost_Update.TS_008_Tc_063toTc_066_ERO_Mass_Cost_Update;
import ERO_Mass_Cost_Update.TS_009_Tc_067_ERO_Mass_Cost_Update;
import ERO_Mass_Cost_Update.TS_010_Tc_069toTc70_ERO_Mass_Cost_Update;
import ERO_Mass_Cost_Update.TS_011_Tc_071_ERO_Mass_Cost_Update;
import ERO_Mass_Cost_Update.TS_012_Tc_072_ERO_Mass_Cost_Update;
import ERO_Mass_Cost_Update.TS_019_Tc_079_ERO_Mass_Cost_Update;
import ERO_Mass_Cost_Update.TS_025_Tc_080_ERO_Mass_Cost_Update;
import ERO_Mass_Cost_Update.TS_026_Tc_081_ERO_Mass_Cost_Update;
import ERO_Mass_Cost_Update.TS_027_Tc_082_ERO_Mass_Cost_Update;
import ERO_Mass_Cost_Update.TS_028_Tc_083_ERO_Mass_Cost_Update;
import ERO_Optimizer_WHAT_IF_Scripts.*;
import ERO_Optimizer_WHAT_IF_Scripts_New.*;
import ERO_Optimizer_reportGate.*;
import ERO_Routing_Scripts.*;
import Extent_Report.extend_report;
import MapView.*;

public class Testcases extends Config {

	public WebDriver driver;
	public ChromeOptions options = null;

	TS001_DeficitandSurplusLocationId_TC01to14 ts1 = new TS001_DeficitandSurplusLocationId_TC01to14();
	TS002toTS004_DeficitandSurplusLocationId_TC15to41 ts2 = new TS002toTS004_DeficitandSurplusLocationId_TC15to41();
	TS005_DeficitandSurplusLocationId_TC_42toTC_58 ts5 = new TS005_DeficitandSurplusLocationId_TC_42toTC_58();
	TS006to10_DeficitandSurplusLocationId_TC59to69 ts6 = new TS006to10_DeficitandSurplusLocationId_TC59to69();
	TS011_DeficitandSurplusLocationId_TC70to140 ts11 = new TS011_DeficitandSurplusLocationId_TC70to140();
	TS011_DeficitandSurplusLocationId_TC141to212 ts11_2 = new TS011_DeficitandSurplusLocationId_TC141to212();
	TS012_TS013_DeficitandSurplusLocationId_TC213to262 ts12 = new TS012_TS013_DeficitandSurplusLocationId_TC213to262();
	TS014_DeficitandSurplusLocationId_TC263to288 ts14 = new TS014_DeficitandSurplusLocationId_TC263to288();
	TS015_DeficitandSurplusLocationId_TC289o305 ts15 = new TS015_DeficitandSurplusLocationId_TC289o305();
	TS016_to_TS019_DeficitandSurplusLocationId_TC306to328 ts16to19 = new TS016_to_TS019_DeficitandSurplusLocationId_TC306to328();
	TS020_TS021_DeficitandSurplusLocationId_TC329to339 ts20 = new TS020_TS021_DeficitandSurplusLocationId_TC329to339();
	TS022_DeficitandSurplusLocationId_TC340to400 ts22 = new TS022_DeficitandSurplusLocationId_TC340to400();
	TS023toTS029_DeficitandSurplusLocationId_TC401to424 ts23 = new TS023toTS029_DeficitandSurplusLocationId_TC401to424();
	TS30_DeficitandSurplusLocationId tc24 = new TS30_DeficitandSurplusLocationId();

	ERO_Routing_Scenario01_TC001toTC014 ero1 = new ERO_Routing_Scenario01_TC001toTC014();
	ERO_Routing_Scenario02to04_TC015toTC041 ero2 = new ERO_Routing_Scenario02to04_TC015toTC041();
	ERO_Routing_Scenario05to07_TC042toTC061 ero5 = new ERO_Routing_Scenario05to07_TC042toTC061();
	ERO_Routing_Scenario08to11_TC062toTC073 ero8 = new ERO_Routing_Scenario08to11_TC062toTC073();
	ERO_Routing_Scenario12_TC074toTC110 ero12 = new ERO_Routing_Scenario12_TC074toTC110();
	ERO_Routing_Scenario19_TC134toTC147 ero19 = new ERO_Routing_Scenario19_TC134toTC147();
	ERO_Routing_Scenario26_TC201toTC220 ero26 = new ERO_Routing_Scenario26_TC201toTC220();
	ERO_Routing_Scenario20_TC148toTC154 ero20 = new ERO_Routing_Scenario20_TC148toTC154();
	ERO_Routing_Scenario21_TC155toTC173 ero21 = new ERO_Routing_Scenario21_TC155toTC173();
	ERO_Routing_Scenario24_TC181toTC185 ero24 = new ERO_Routing_Scenario24_TC181toTC185();
	ERO_Routing_Scenario25_TC186toTC200 ero25 = new ERO_Routing_Scenario25_TC186toTC200();
	ERO_Routing_Scenario13_TC111toTC112 ero13 = new ERO_Routing_Scenario13_TC111toTC112();
	ERO_Routing_Scenario17_TC121toTC131 ero17 = new ERO_Routing_Scenario17_TC121toTC131();
	ERO_Routing_Scenario28_TC237toTC243 ero28 = new ERO_Routing_Scenario28_TC237toTC243();
	ERO_Routing_Scenario27_TC221toTC236 ero27 = new ERO_Routing_Scenario27_TC221toTC236();
	ERO_Routing_Scenario23_TC180 ero23 = new ERO_Routing_Scenario23_TC180();
	ERO_Routing_Scenario15_TC114toTC115 ero15 = new ERO_Routing_Scenario15_TC114toTC115();
	ERO_Routing_Scenario30_TC245toTC270 ero30 = new ERO_Routing_Scenario30_TC245toTC270();
	ERO_Routing_Scenario31_TC271_280 ero31 = new ERO_Routing_Scenario31_TC271_280();
	ERO_Routing_Scenario12_2_TC091toTC110 ero12_2 = new ERO_Routing_Scenario12_2_TC091toTC110();
	ERO_Routing_Scenario32_TC281 ero32 = new ERO_Routing_Scenario32_TC281();

	TS001_ERO_Optimizer_WHATIF_TC01to14 owt1 = new TS001_ERO_Optimizer_WHATIF_TC01to14();
	TS002_ERO_Optimizer_WHATIF_TC15to35 owt2 = new TS002_ERO_Optimizer_WHATIF_TC15to35();
	TS005_ERO_Optimizer_WHATIF_TC42to58 owt5 = new TS005_ERO_Optimizer_WHATIF_TC42to58();
	TS006to10_ERO_Optimizer_WHATIF_TC59to69 owt6 = new TS006to10_ERO_Optimizer_WHATIF_TC59to69();
	TS011_ERO_Optimizer_WHATIF_TC70to212 owt11 = new TS011_ERO_Optimizer_WHATIF_TC70to212();
	TS012_ERO_Optimizer_WHATIF_TC213to253 owt12 = new TS012_ERO_Optimizer_WHATIF_TC213to253();
	TS015_ERO_Optimizer_WHATIF_TC289to305 owt15 = new TS015_ERO_Optimizer_WHATIF_TC289to305();
	TS019_ERO_Optimizer_WHATIF_TC326to328 owt19 = new TS019_ERO_Optimizer_WHATIF_TC326to328();

	TS01Map_View_TC001to014 mv01 = new TS01Map_View_TC001to014();
	TS02Map_View_TC0015to35 mv02 = new TS02Map_View_TC0015to35();
	TS05_MapViewTC42to58 mv05 = new TS05_MapViewTC42to58();
	TS06to10MapViewTC59to67 mv06 = new TS06to10MapViewTC59to67();
	TS11to12MapView68to69 mv11 = new TS11to12MapView68to69();
	TS18to21MapView75to78 mv18 = new TS18to21MapView75to78();

	TS01To02ERO_Optimizer_WHAT_IF_Scripts_New ons1 = new TS01To02ERO_Optimizer_WHAT_IF_Scripts_New();
	TS03ERO_Optimizer_WHAT_IF_Scripts_New ons3 = new TS03ERO_Optimizer_WHAT_IF_Scripts_New();
	TS03_2ERO_Optimizer_WHAT_IF_Scripts_NewTC15TO39 ons15 = new TS03_2ERO_Optimizer_WHAT_IF_Scripts_NewTC15TO39();
	TS04ERO_Optimizer_WHAT_IF_Scripts_NewTC4To16 ons4 = new TS04ERO_Optimizer_WHAT_IF_Scripts_NewTC4To16();
	TS05ERO_Optimizer_WHAT_IF_Scripts_NewTC1To4 ons5 = new TS05ERO_Optimizer_WHAT_IF_Scripts_NewTC1To4();
	TS07ERO_Optimizer_WHAT_IF_Scripts_NewTC1To7 ons7 = new TS07ERO_Optimizer_WHAT_IF_Scripts_NewTC1To7();
	TS08To11ERO_Optimizer_WHAT_IF_Scripts_NewTC1To11 ons8 = new TS08To11ERO_Optimizer_WHAT_IF_Scripts_NewTC1To11();

	TS_01_TC01to03_ERO_Optimization_ReportGate ero01_03 = new TS_01_TC01to03_ERO_Optimization_ReportGate();
	TS_02_TC04to12_ERO_Optimization_ReportGate ero4_9 = new TS_02_TC04to12_ERO_Optimization_ReportGate();
	TS_03_TC013to016_ERO_Optimization_ReportGate ero13_16 = new TS_03_TC013to016_ERO_Optimization_ReportGate();
	TS_04_TC017to018_ERO_Optimization_ReportGate ero17_18 = new TS_04_TC017to018_ERO_Optimization_ReportGate();
	TS_05_TC019_ERO_Optimization_ReportGate ero_19 = new TS_05_TC019_ERO_Optimization_ReportGate();
	TS_06_TC020_ERO_Optimization_ReportGate ero_20 = new TS_06_TC020_ERO_Optimization_ReportGate();
	TS_07_TC021_ERO_Optimization_ReportGate ero_21 = new TS_07_TC021_ERO_Optimization_ReportGate();
	TS_07toTS14_ReportGate RG07 = new TS_07toTS14_ReportGate();
	TS_15toTS020_ReportGate RG15 = new TS_15toTS020_ReportGate();
	TS_24_TC040_ERO_Optimization_ReportGate ero_40 = new TS_24_TC040_ERO_Optimization_ReportGate();
	TS_25_TC041_042ERO_Optimization_ReportGate ero41_42 = new TS_25_TC041_042ERO_Optimization_ReportGate();
	TS_26_TC043_ERO_Optimization_ReportGate ero_43 = new TS_26_TC043_ERO_Optimization_ReportGate();
	TS_27_TC044to046_ERO_Optimization_ReportGate ero44_46 = new TS_27_TC044to046_ERO_Optimization_ReportGate();
	TS_28_TC047ERO_Optimization_ReportGate ero_47 = new TS_28_TC047ERO_Optimization_ReportGate();
	TS_29_TC048ERO_Optimization_ReportGate ero_48 = new TS_29_TC048ERO_Optimization_ReportGate();
	TS_30_TC049to051_ERO_Optimization_ReportGate ero_49_51 = new TS_30_TC049to051_ERO_Optimization_ReportGate();
	TS_31_TC052_ERO_Optimization_ReportGate ero_52 = new TS_31_TC052_ERO_Optimization_ReportGate();
	TS_32_TC053_ERO_Optimization_ReportGate ero_53 = new TS_32_TC053_ERO_Optimization_ReportGate();
	TS_33_TC054_ERO_Optimization_ReportGate ero_54 = new TS_33_TC054_ERO_Optimization_ReportGate();
	ERO_Routing_Scenario33_TC286_328 ero286_328 = new ERO_Routing_Scenario33_TC286_328();
	ERO_Routing_Scenario33_TC289_292 ero289_292 = new ERO_Routing_Scenario33_TC289_292();
	ERO_Routing_Scenario31_TC278 ero_278 = new ERO_Routing_Scenario31_TC278();
	ERO_Routing_Scenario33_TC287_288 ero287_288 = new ERO_Routing_Scenario33_TC287_288();

	Tc_001_DeficitandSurplusLocationId ero_001 = new Tc_001_DeficitandSurplusLocationId();
	TS_008_Tc_063toTc_066_ERO_Deviation_report ero_63to66 = new TS_008_Tc_063toTc_066_ERO_Deviation_report();
	TS_005_Tc_043toTc_059_ERO_Deviation_report ero_43to59 = new TS_005_Tc_043toTc_059_ERO_Deviation_report();

	// ERO Deviation

	TS_001_Tc_001toTc_015_ERO_Deviation_report ero_1to15 = new TS_001_Tc_001toTc_015_ERO_Deviation_report();
	TS_003_Tc_037toTc_040_ERO_Deviation_report ero_37to40 = new TS_003_Tc_037toTc_040_ERO_Deviation_report();
	TS_004_Tc_041toTc_042_ERO_Deviation_report ero_41to42 = new TS_004_Tc_041toTc_042_ERO_Deviation_report();
	TS_002_Tc_016toTc_036_ERO_Deviation_report ero_16_36 = new TS_002_Tc_016toTc_036_ERO_Deviation_report();
	TS_010_Tc_069to70_ERO_Deviation_report ero_69to70 = new TS_010_Tc_069to70_ERO_Deviation_report();
	TS_006_Tc_060_ERO_Deviation_report ero_60 = new TS_006_Tc_060_ERO_Deviation_report();
	TS_009_Tc_067toTc68_ERO_Deviation_report ero_67to68 = new TS_009_Tc_067toTc68_ERO_Deviation_report();
	TS_011_Tc_071_ERO_Deviation_report ero_71 = new TS_011_Tc_071_ERO_Deviation_report();
	TS_012_Tc_072_ERO_Deviation_report ero_72 = new TS_012_Tc_072_ERO_Deviation_report();
	TS_013_Tc_073_ERO_Deviation_report ero_73 = new TS_013_Tc_073_ERO_Deviation_report();
	TS_016_Tc_076_ERO_Deviation_report ero_76 = new TS_016_Tc_076_ERO_Deviation_report();
	TS_019_Tc_079_ERO_Deviation_report ero_79 = new TS_019_Tc_079_ERO_Deviation_report();
	TS_020_Tc_080_ERO_Deviation_report ero_80 = new TS_020_Tc_080_ERO_Deviation_report();
	TS_021_Tc_081_ERO_Deviation_report ero_81 = new TS_021_Tc_081_ERO_Deviation_report();
	TS_022_Tc_082_ERO_Deviation_report ero_82 = new TS_022_Tc_082_ERO_Deviation_report();
	TS_023_Tc_083_ERO_Deviation_report ero_83 = new TS_023_Tc_083_ERO_Deviation_report();
	TS_024_Tc_084_ERO_Deviation_report ero_84 = new TS_024_Tc_084_ERO_Deviation_report();

	// Mass Cost Update
	TS_001_Tc_001toTc_015_ERO_Mass_Cost_Update ero_01to015 = new TS_001_Tc_001toTc_015_ERO_Mass_Cost_Update();
	TS1_002_Tc_016toTc_036_ERO_Mass_Cost_Update ero_016to036 = new TS1_002_Tc_016toTc_036_ERO_Mass_Cost_Update();
	TS_003_Tc_037toTc_040_ERO_Mass_Cost_Update ero_037to040 = new TS_003_Tc_037toTc_040_ERO_Mass_Cost_Update();
	TS_005_Tc_043toTc_059_ERO_Mass_Cost_Update ero_043to059 = new TS_005_Tc_043toTc_059_ERO_Mass_Cost_Update();
	TS_006_Tc_060_ERO_Mass_Cost_Update ero_060 = new TS_006_Tc_060_ERO_Mass_Cost_Update();
	TS_008_Tc_063toTc_066_ERO_Mass_Cost_Update ero_063to066 = new TS_008_Tc_063toTc_066_ERO_Mass_Cost_Update();
	TS_007_Tc_061toTc_062_ERO_Mass_Cost_Update ero_061to062 = new TS_007_Tc_061toTc_062_ERO_Mass_Cost_Update();
	TS_011_Tc_071_ERO_Mass_Cost_Update ero_071 = new TS_011_Tc_071_ERO_Mass_Cost_Update();
	TS_010_Tc_069toTc70_ERO_Mass_Cost_Update ero_069to070 = new TS_010_Tc_069toTc70_ERO_Mass_Cost_Update();
	TS_009_Tc_067_ERO_Mass_Cost_Update ero_067 = new TS_009_Tc_067_ERO_Mass_Cost_Update();
	TS_004_Tc_041toTc042_ERO_Mass_Cost_Update ero_041to042 = new TS_004_Tc_041toTc042_ERO_Mass_Cost_Update();
	TS_019_Tc_079_ERO_Mass_Cost_Update ero_079 = new TS_019_Tc_079_ERO_Mass_Cost_Update();
	TS_014_Tc_074_ERO_Mass_Cost_Update ero_074 = new TS_014_Tc_074_ERO_Mass_Cost_Update();
	TS_025_Tc_080_ERO_Mass_Cost_Update ero_080 = new TS_025_Tc_080_ERO_Mass_Cost_Update();
	TS_026_Tc_081_ERO_Mass_Cost_Update ero_081 = new TS_026_Tc_081_ERO_Mass_Cost_Update();
	TS_027_Tc_082_ERO_Mass_Cost_Update ero_082 = new TS_027_Tc_082_ERO_Mass_Cost_Update();
	TS_012_Tc_072_ERO_Mass_Cost_Update ero_072 = new TS_012_Tc_072_ERO_Mass_Cost_Update();
	TS_028_Tc_083_ERO_Mass_Cost_Update ero_083 = new TS_028_Tc_083_ERO_Mass_Cost_Update();

	// Cost View

	TS_001_Tc001toTc015_ERO_Cost_View ero_001_001to015 = new TS_001_Tc001toTc015_ERO_Cost_View();
	TS_002_Tc016toTc036_ERO_Cost_View ero_002_016to036 = new TS_002_Tc016toTc036_ERO_Cost_View();
	TS_003_Tc037toTc040_ERO_Cost_View ero_003_037to040 = new TS_003_Tc037toTc040_ERO_Cost_View();
	TS_004_Tc041toTc042_ERO_Cost_View ero_004_041to042 = new TS_004_Tc041toTc042_ERO_Cost_View();
	TS_005_Tc043toTc059_ERO_Cost_View ero_005_043to059 = new TS_005_Tc043toTc059_ERO_Cost_View();
	TS_006_Tc060_ERO_Cost_View ero_006_060 = new TS_006_Tc060_ERO_Cost_View();
	TS_007_Tc061toTc62_ERO_Cost_View ero_007_061to062 = new TS_007_Tc061toTc62_ERO_Cost_View();
	TS_008_Tc063toTc66_ERO_Cost_View ero_008_063to066 = new TS_008_Tc063toTc66_ERO_Cost_View();
	TS_009_Tc067toTc68_ERO_Cost_View ero_009_067to068 = new TS_009_Tc067toTc68_ERO_Cost_View();
	TS_010_Tc069toTc070_ERO_Cost_View ero_010_069to070 = new TS_010_Tc069toTc070_ERO_Cost_View();
	TS_011_Tc071_ERO_Cost_View ero_011_071 = new TS_011_Tc071_ERO_Cost_View();

	public static List<String> passedDatasets = new ArrayList<>();
	public static List<String> failedDatasets = new ArrayList<>();
	public static int dataset_size;
	public static int size;
	public static int failCount;
	public static int passCount;
	public static int totalCount;

	boolean exceptionError = false;

	static ExtentSparkReporter spark;
	static ExtentTest test;
	static ExtentReports extent;
	static ExtentSparkReporter spark1;
	static ExtentTest test1;
	static ExtentReports extent1;
	String resultReoprtpath;
	boolean log = false;

	@BeforeSuite
	public void Extentreport() throws Exception {
		extent = extend_report.reportsetup();
		extent1 = extend_report.reportsetup1();
		setUpShutdownHook();
	}

	@AfterTest
	public void aftertest() throws Throwable {
		extend_report.Aftertest(test);
		extend_report.Aftertest(test1);
	}

	public void runTestScenario(String testName, List<String> urlList, List<String> datasetList,
			ScenarioRunner scenarioMethod) throws Throwable {
		int size = urlList.size();

		for (int i = 0; i < size; i++) {
			String url = urlList.get(i);
			String index = datasetList.get(i);
			List<String> expandedList = splitAndExpand(index);
			int datasetSize = expandedList.size();

			for (int j = 0; j < datasetSize; j++) {
				String numberOfDataset = expandedList.get(j);
				int datasetCount = Integer.parseInt(numberOfDataset);

				ITestResult result = createTestResult(ITestResult.FAILURE);
				test = extent.createTest(testName + " and environment is : " + url).assignAuthor("Optibox")
						.assignCategory("E2E");
				test1 = extent1.createTest(testName + " report and environment is : " + url).assignAuthor("Optibox")
						.assignCategory("E2E");

				try {
					Keywords.ActionTest(test, test1);
					driver = getWebDriver(Utils.getDataFromTestConfig("AppBrowser"));

					// Call the specific scenario method
					scenarioMethod.run(driver, test, test1, url, datasetCount);

					test.log(Status.PASS, "Test case Passed for environment: " + url);
					result.setStatus(ITestResult.SUCCESS);
					result.setAttribute("dataset", "Dataset" + numberOfDataset);
					passedDatasets.add("_Dataset " + numberOfDataset + " passed in environment: " + url);
					passCount++;
				} catch (Throwable e) {
					System.out.println("Execution failed for environment: " + url);
					e.printStackTrace();
					exceptionError = true;
					result.setStatus(ITestResult.FAILURE);
					result.setThrowable(e);
					result.setAttribute("dataset", "Dataset" + numberOfDataset);
					failedDatasets.add("_Dataset " + numberOfDataset + " failed in environment: " + url);
					failCount++;
				} finally {
					try {
						Teardown(result, test, test1);
					} catch (Exception e) {
						System.out.println("Teardown failed for environment: " + url);
						e.printStackTrace();
					}
					if (driver != null) {
						continue;
					}
				}
			}

			totalCount = passCount + failCount;
			System.out.println("Total cases: " + totalCount);
		}

		System.out.println("Passed cases: " + passCount);
		passedDatasets.forEach(System.out::println);

		System.out.println("Failed cases: " + failCount);
		failedDatasets.forEach(System.out::println);

		if (exceptionError) {
			Assert.fail("Test failed due to error");
		}
	}

	@FunctionalInterface
	public interface ScenarioRunner {
		void run(WebDriver driver, ExtentTest test, ExtentTest test1, String url, int dataset) throws Throwable;
	}

	@Test
	public void TS001_DeficitandSurplusLocationId_TC01to14() throws Throwable {
		List<String> selectedUrl = getUrl(driver, "TS001_DeficitandSurplusLocationId_TC01to14", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS001_DeficitandSurplusLocationId_TC01to14", "Testcaseurl");

		runTestScenario("TS001_DeficitandSurplusLocationId_TC01to14", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ts1.Scenario1(driver, test, test1, url, dataset));
	}

	@Test
	public void TS002toTS004_DeficitandSurplusLocationId_TC15to41() throws Throwable {
		List<String> selectedUrl = getUrl(driver, "TS002toTS004_DeficitandSurplusLocationId_TC15to41", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS002toTS004_DeficitandSurplusLocationId_TC15to41",
				"Testcaseurl");

		runTestScenario("TS002toTS004_DeficitandSurplusLocationId_TC15to41", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ts2.Scenario2(driver, test, test1, url, dataset));
	}

	@Test
	public void TS005_DeficitandSurplusLocationId_TC_42toTC_58() throws Throwable {
		List<String> selectedUrl = getUrl(driver, "TS005_DeficitandSurplusLocationId_TC_42toTC_58", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS005_DeficitandSurplusLocationId_TC_42toTC_58", "Testcaseurl");

		runTestScenario("TS005_DeficitandSurplusLocationId_TC_42toTC_58", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ts5.Scenario5(driver, test, test1, url, dataset));
	}

	@Test
	public void TS006to10_DeficitandSurplusLocationId_TC59to69() throws Throwable {
		List<String> selectedUrl = getUrl(driver, "TS006to10_DeficitandSurplusLocationId_TC59to69", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS006to10_DeficitandSurplusLocationId_TC59to69", "Testcaseurl");

		runTestScenario("TS006to10_DeficitandSurplusLocationId_TC59to69", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ts6.Scenario6to10(driver, test, test1, url, dataset));
	}

	@Test
	public void TS011_DeficitandSurplusLocationId_TC70to140() throws Throwable {
		List<String> selectedUrl = getUrl(driver, "TS011_DeficitandSurplusLocationId_TC70to140", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS011_DeficitandSurplusLocationId_TC70to140", "Testcaseurl");

		runTestScenario("TS011_DeficitandSurplusLocationId_TC70to140", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ts11.Scenario11(driver, test, test1, url, dataset));
	}

	@Test
	public void TS011_DeficitandSurplusLocationId_TC141to212() throws Throwable {
		List<String> selectedUrl = getUrl(driver, "TS011_DeficitandSurplusLocationId_TC141to212", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS011_DeficitandSurplusLocationId_TC141to212", "Testcaseurl");

		runTestScenario("TS011_DeficitandSurplusLocationId_TC141to212", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ts11_2.Scenario11_2(driver, test, test1, url, dataset));
	}

	@Test
	public void TS012_TS013_DeficitandSurplusLocationId_TC213to262() throws Throwable {
		List<String> selectedUrl = getUrl(driver, "TS012_TS013_DeficitandSurplusLocationId_TC213to262", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS012_TS013_DeficitandSurplusLocationId_TC213to262",
				"Testcaseurl");

		runTestScenario("TS012_TS013_DeficitandSurplusLocationId_TC213to262", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ts12.Scenario12(driver, test, test1, url, dataset));
	}

	@Test
	public void TS014_DeficitandSurplusLocationId_TC263to288() throws Throwable {
		List<String> selectedUrl = getUrl(driver, "TS014_DeficitandSurplusLocationId_TC263to288", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS014_DeficitandSurplusLocationId_TC263to288", "Testcaseurl");

		runTestScenario("TS014_DeficitandSurplusLocationId_TC263to288", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ts14.Scenario14(driver, test, test1, url, dataset));
	}

	@Test
	public void TS015_DeficitandSurplusLocationId_TC289o305() throws Throwable {
		List<String> selectedUrl = getUrl(driver, "TS015_DeficitandSurplusLocationId_TC289o305", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS015_DeficitandSurplusLocationId_TC289o305", "Testcaseurl");

		runTestScenario("TS015_DeficitandSurplusLocationId_TC289o305", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ts15.Scenario15(driver, test, test1, url, dataset));
	}

	@Test
	public void TS016_to_TS019_DeficitandSurplusLocationId_TC306to328() throws Throwable {
		List<String> selectedUrl = getUrl(driver, "TS016_to_TS019_DeficitandSurplusLocationId_TC306to328",
				"Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS016_to_TS019_DeficitandSurplusLocationId_TC306to328",
				"Testcaseurl");

		runTestScenario("TS016_to_TS019_DeficitandSurplusLocationId_TC306to328", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ts16to19.Scenario16to19(driver, test, test1, url, dataset));
	}

	@Test
	public void TS020_TS021_DeficitandSurplusLocationId_TC329to339() throws Throwable {
		List<String> selectedUrl = getUrl(driver, "TS020_TS021_DeficitandSurplusLocationId_TC329to339", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS020_TS021_DeficitandSurplusLocationId_TC329to339",
				"Testcaseurl");

		runTestScenario("TS020_TS021_DeficitandSurplusLocationId_TC329to339", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ts20.Scenario20(driver, test, test1, url, dataset));
	}

	@Test
	public void TS022_DeficitandSurplusLocationId_TC340to400() throws Throwable {
		List<String> selectedUrl = getUrl(driver, "TS022_DeficitandSurplusLocationId_TC340to400", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS022_DeficitandSurplusLocationId_TC340to400", "Testcaseurl");

		runTestScenario("TS022_DeficitandSurplusLocationId_TC340to400", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ts22.Scenario22(driver, test, test1, url, dataset));
	}

	@Test
	public void TS023toTS029_DeficitandSurplusLocationId_TC401to424() throws Throwable {
		List<String> selectedUrl = getUrl(driver, "TS023toTS029_DeficitandSurplusLocationId_TC401to424", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS023toTS029_DeficitandSurplusLocationId_TC401to424",
				"Testcaseurl");

		runTestScenario("TS023toTS029_DeficitandSurplusLocationId_TC401to424", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ts23.Scenario23(driver, test, test1, url, dataset));
	}

	@Test
	public void TS30_DeficitandSurplusLocationId() throws Throwable {
		List<String> selectedUrl = getUrl(driver, "TS30_DeficitandSurplusLocationId", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS30_DeficitandSurplusLocationId", "Testcaseurl");

		runTestScenario("TS30_DeficitandSurplusLocationId", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> tc24.Scenario30(driver, test, test1, url, dataset));
	}

	@Test
	public void Tc_001_DeficitandSurplusLocationId() throws Throwable {
		List<String> selectedUrl = getUrl(driver, "Tc_001_DeficitandSurplusLocationId", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "Tc_001_DeficitandSurplusLocationId", "Testcaseurl");

		runTestScenario("Tc_001_DeficitandSurplusLocationId", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ero_001.Scenario001(driver, test, test1, url, dataset));
	}

	// ***************************************** ERO Routing testcases
	// ***********************************************************//

	@Test
	public void ERO_Routing_Scenario01_TC001toTC014() throws Throwable {
		List<String> selectedUrl = getUrl(driver, "ERO_Routing_Scenario01_TC001toTC014", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "ERO_Routing_Scenario01_TC001toTC014", "Testcaseurl");

		runTestScenario("ERO_Routing_Scenario01_TC001toTC014", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ero1.ERO_Scenario1(driver, test, test1, url, dataset));
	}

	@Test
	public void ERO_Routing_Scenario02to04_TC015toTC041() throws Throwable {
		List<String> selectedUrl = getUrl(driver, "ERO_Routing_Scenario02to04_TC015toTC041", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "ERO_Routing_Scenario02to04_TC015toTC041", "Testcaseurl");

		runTestScenario("ERO_Routing_Scenario02to04_TC015toTC041", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ero2.ERO_Scenario2(driver, test, test1, url, dataset));
	}

	@Test
	public void ERO_Routing_Scenario05to07_TC042toTC061() throws Throwable {
		List<String> selectedUrl = getUrl(driver, "ERO_Routing_Scenario05to07_TC042toTC061", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "ERO_Routing_Scenario05to07_TC042toTC061", "Testcaseurl");

		runTestScenario("ERO_Routing_Scenario05to07_TC042toTC061", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ero5.ERO_Scenario5(driver, test, test1, url, dataset));
	}

	@Test
	public void ERO_Routing_Scenario08to11_TC062toTC073() throws Throwable {
		List<String> selectedUrl = getUrl(driver, "ERO_Routing_Scenario08to11_TC062toTC073", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "ERO_Routing_Scenario08to11_TC062toTC073", "Testcaseurl");

		runTestScenario("ERO_Routing_Scenario08to11_TC062toTC073", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ero8.ERO_Scenario8to11(driver, test, test1, url, dataset));
	}

	@Test
	public void ERO_Routing_Scenario12_TC074toTC110() throws Throwable {
		List<String> selectedUrl = getUrl(driver, "ERO_Routing_Scenario12_TC074toTC110", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "ERO_Routing_Scenario12_TC074toTC110", "Testcaseurl");

		runTestScenario("ERO_Routing_Scenario12_TC074toTC110", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ero12.ERO_Scenario12(driver, test, test1, url, dataset));
	}

	@Test
	public void ERO_Routing_Scenario12_2_TC091toTC110() throws Throwable {
		List<String> selectedUrl = getUrl(driver, "ERO_Routing_Scenario12_2_TC091toTC110", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "ERO_Routing_Scenario12_2_TC091toTC110", "Testcaseurl");

		runTestScenario("ERO_Routing_Scenario12_2_TC091toTC110", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ero12_2.ERO_Scenario12_2(driver, test, test1, url, dataset));
	}

	@Test
	public void ERO_Routing_Scenario13_TC111toTC112() throws Throwable {
		List<String> selectedUrl = getUrl(driver, "ERO_Routing_Scenario13_TC111toTC112", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "ERO_Routing_Scenario13_TC111toTC112", "Testcaseurl");

		runTestScenario("ERO_Routing_Scenario13_TC111toTC112", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ero13.ERO_Scenario13(driver, test, test1, url, dataset));
	}

	@Test
	public void ERO_Routing_Scenario15_TC114toTC115() throws Throwable {
		List<String> selectedUrl = getUrl(driver, "ERO_Routing_Scenario15_TC114toTC115", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "ERO_Routing_Scenario15_TC114toTC115", "Testcaseurl");

		runTestScenario("ERO_Routing_Scenario15_TC114toTC115", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ero15.ERO_Scenario15(driver, test, test1, url, dataset));
	}

	@Test
	public void ERO_Routing_Scenario17_TC121toTC131() throws Throwable {
		List<String> selectedUrl = getUrl(driver, "ERO_Routing_Scenario17_TC121toTC131", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "ERO_Routing_Scenario17_TC121toTC131", "Testcaseurl");

		runTestScenario("ERO_Routing_Scenario17_TC121toTC131", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ero17.ERO_Scenario17(driver, test, test1, url, dataset));
	}

	@Test
	public void ERO_Routing_Scenario19_TC134toTC147() throws Throwable {
		List<String> selectedUrl = getUrl(driver, "ERO_Routing_Scenario19_TC134toTC147", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "ERO_Routing_Scenario19_TC134toTC147", "Testcaseurl");

		runTestScenario("ERO_Routing_Scenario19_TC134toTC147", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ero19.ERO_Routing_Scenario19(driver, test, test1, url, dataset));
	}

	@Test
	public void ERO_Routing_Scenario20_TC148toTC154() throws Throwable {
		List<String> selectedUrl = getUrl(driver, "ERO_Routing_Scenario20_TC148toTC154", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "ERO_Routing_Scenario20_TC148toTC154", "Testcaseurl");

		runTestScenario("ERO_Routing_Scenario20_TC148toTC154", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ero20.ERO_Scenario20(driver, test, test1, url, dataset));
	}

	@Test
	public void ERO_Routing_Scenario21_TC155toTC173() throws Throwable {
		List<String> selectedUrl = getUrl(driver, "ERO_Routing_Scenario21_TC155toTC173", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "ERO_Routing_Scenario21_TC155toTC173", "Testcaseurl");

		runTestScenario("ERO_Routing_Scenario21_TC155toTC173", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ero21.ERO_Routing_Scenario21(driver, test, test1, url, dataset));
	}

	@Test
	public void ERO_Routing_Scenario23_TC180() throws Throwable {
		List<String> selectedUrl = getUrl(driver, "ERO_Routing_Scenario23_TC180", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "ERO_Routing_Scenario23_TC180", "Testcaseurl");

		runTestScenario("ERO_Routing_Scenario23_TC180", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ero23.ERO_Routing_Scenario23(driver, test, test1, url, dataset));
	}

	@Test
	public void ERO_Routing_Scenario24_TC181toTC185() throws Throwable {
		List<String> selectedUrl = getUrl(driver, "ERO_Routing_Scenario24_TC181toTC185", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "ERO_Routing_Scenario24_TC181toTC185", "Testcaseurl");

		runTestScenario("ERO_Routing_Scenario24_TC181toTC185", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ero24.ERO_Scenario24(driver, test, test1, url, dataset));
	}

	@Test
	public void ERO_Routing_Scenario25_TC186toTC200() throws Throwable {
		List<String> selectedUrl = getUrl(driver, "ERO_Routing_Scenario25_TC186toTC200", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "ERO_Routing_Scenario25_TC186toTC200", "Testcaseurl");

		runTestScenario("ERO_Routing_Scenario25_TC186toTC200", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ero25.ERO_Scenario25(driver, test, test1, url, dataset));
	}

	@Test
	public void ERO_Routing_Scenario26_TC201toTC220() throws Throwable {
		List<String> selectedUrl = getUrl(driver, "ERO_Routing_Scenario26_TC201toTC220", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "ERO_Routing_Scenario26_TC201toTC220", "Testcaseurl");

		runTestScenario("ERO_Routing_Scenario26_TC201toTC220", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ero26.ERO_Scenario26(driver, test, test1, url, dataset));
	}

	@Test
	public void ERO_Routing_Scenario27_TC221toTC236() throws Throwable {
		List<String> selectedUrl = getUrl(driver, "ERO_Routing_Scenario27_TC221toTC236", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "ERO_Routing_Scenario27_TC221toTC236", "Testcaseurl");

		runTestScenario("ERO_Routing_Scenario27_TC221toTC236", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ero27.ERO_Routing_Scenario27(driver, test, test1, url, dataset));
	}

	@Test
	public void ERO_Routing_Scenario28_TC237toTC243() throws Throwable {
		List<String> selectedUrl = getUrl(driver, "ERO_Routing_Scenario28_TC237toTC243", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "ERO_Routing_Scenario28_TC237toTC243", "Testcaseurl");

		runTestScenario("ERO_Routing_Scenario28_TC237toTC243", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ero28.ERO_Routing_Scenario28(driver, test, test1, url, dataset));
	}

	@Test
	public void ERO_Routing_Scenario30_TC245toTC270() throws Throwable {
		List<String> selectedUrl = getUrl(driver, "ERO_Routing_Scenario30_TC245toTC270", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "ERO_Routing_Scenario30_TC245toTC270", "Testcaseurl");

		runTestScenario("ERO_Routing_Scenario30_TC245toTC270", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ero30.ERO_Scenario30(driver, test, test1, url, dataset));
	}

	@Test
	public void ERO_Routing_Scenario31_TC271_280() throws Throwable {
		List<String> selectedUrl = getUrl(driver, "ERO_Routing_Scenario31_TC271_280", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "ERO_Routing_Scenario31_TC271_280", "Testcaseurl");

		runTestScenario("ERO_Routing_Scenario31_TC271_280", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ero31.ERO_Scenario31(driver, test, test1, url, dataset));
	}

	@Test
	public void ERO_Routing_Scenario31_TC278() throws Throwable {
		List<String> selectedUrl = getUrl(driver, "ERO_Routing_Scenario31_TC278", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "ERO_Routing_Scenario31_TC278", "Testcaseurl");

		runTestScenario("ERO_Routing_Scenario31_TC278", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ero_278.ERO_Scenario31(driver, test, test1, url, dataset));
	}

	@Test
	public void ERO_Routing_Scenario32_TC281() throws Throwable {
		List<String> selectedUrl = getUrl(driver, "ERO_Routing_Scenario32_TC281", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "ERO_Routing_Scenario32_TC281", "Testcaseurl");

		runTestScenario("ERO_Routing_Scenario32_TC281", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ero32.Scenario32(driver, test, test1, url, dataset));
	}

	@Test
	public void ERO_Routing_Scenario33_TC286_328() throws Throwable {
		List<String> selectedUrl = getUrl(driver, "ERO_Routing_Scenario33_TC286_328", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "ERO_Routing_Scenario33_TC286_328", "Testcaseurl");

		runTestScenario("ERO_Routing_Scenario33_TC286_328", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ero286_328.ERO_Scenario33(driver, test, test1, url, dataset));
	}

	@Test
	public void ERO_Routing_Scenario33_TC289_292() throws Throwable {
		List<String> selectedUrl = getUrl(driver, "ERO_Routing_Scenario33_TC289_292", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "ERO_Routing_Scenario33_TC289_292", "Testcaseurl");

		runTestScenario("ERO_Routing_Scenario33_TC289_292", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ero289_292.ERO_Scenario33(driver, test, test1, url, dataset));
	}

	@Test
	public void ERO_Routing_Scenario33_TC287_288() throws Throwable {
		List<String> selectedUrl = getUrl(driver, "ERO_Routing_Scenario33_TC287_288", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "ERO_Routing_Scenario33_TC287_288", "Testcaseurl");

		runTestScenario("ERO_Routing_Scenario33_TC287_288", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ero287_288.ERO_Scenario33(driver, test, test1, url, dataset));
	}

	// **********************************ERO OPTIMIZER WHAT-IF SCENARIO old
	// testcases********************************************//

	@Test
	public void TS001_ERO_Optimizer_WHATIF_TC01to14() throws Throwable {
		List<String> selectedUrl = getUrl(driver, "TS001_ERO_Optimizer_WHATIF_TC01to14", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS001_ERO_Optimizer_WHATIF_TC01to14", "Testcaseurl");

		runTestScenario("TS001_ERO_Optimizer_WHATIF_TC01to14", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> owt1.Scenario001(driver, test, test1, url, dataset));
	}

	@Test
	public void TS002_ERO_Optimizer_WHATIF_TC15to35() throws Throwable {
		List<String> selectedUrl = getUrl(driver, "TS002_ERO_Optimizer_WHATIF_TC15to35", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS002_ERO_Optimizer_WHATIF_TC15to35", "Testcaseurl");

		runTestScenario("TS002_ERO_Optimizer_WHATIF_TC15to35", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> owt2.Scenario002(driver, test, test1, url, dataset));
	}

	@Test
	public void TS005_ERO_Optimizer_WHATIF_TC42to58() throws Throwable {
		List<String> selectedUrl = getUrl(driver, "TS005_ERO_Optimizer_WHATIF_TC42to58", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS005_ERO_Optimizer_WHATIF_TC42to58", "Testcaseurl");

		runTestScenario("TS005_ERO_Optimizer_WHATIF_TC42to58", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> owt5.Scenario005(driver, test, test1, url, dataset));
	}

	@Test
	public void TS006to10_ERO_Optimizer_WHATIF_TC59to69() throws Throwable {
		List<String> selectedUrl = getUrl(driver, "TS006to10_ERO_Optimizer_WHATIF_TC59to69", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS006to10_ERO_Optimizer_WHATIF_TC59to69", "Testcaseurl");

		runTestScenario("TS006to10_ERO_Optimizer_WHATIF_TC59to69", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> owt6.Scenario6to10(driver, test, test1, url, dataset));
	}

	@Test
	public void TS011_ERO_Optimizer_WHATIF_TC70to212() throws Throwable {
		List<String> selectedUrl = getUrl(driver, "TS011_ERO_Optimizer_WHATIF_TC70to212", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS011_ERO_Optimizer_WHATIF_TC70to212", "Testcaseurl");

		runTestScenario("TS011_ERO_Optimizer_WHATIF_TC70to212", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> owt11.Scenario11(driver, test, test1, url, dataset));
	}

	@Test
	public void TS012_ERO_Optimizer_WHATIF_TC213to253() throws Throwable {
		List<String> selectedUrl = getUrl(driver, "TS012_ERO_Optimizer_WHATIF_TC213to253", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS012_ERO_Optimizer_WHATIF_TC213to253", "Testcaseurl");

		runTestScenario("TS012_ERO_Optimizer_WHATIF_TC213to253", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> owt12.Scenario12(driver, test, test1, url, dataset));
	}

	@Test
	public void TS015_ERO_Optimizer_WHATIF_TC289to305() throws Throwable {
		List<String> selectedUrl = getUrl(driver, "TS015_ERO_Optimizer_WHATIF_TC289to305", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS015_ERO_Optimizer_WHATIF_TC289to305", "Testcaseurl");

		runTestScenario("TS015_ERO_Optimizer_WHATIF_TC289to305", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> owt15.Scenario15(driver, test, test1, url, dataset));
	}

	@Test
	public void TS019_ERO_Optimizer_WHATIF_TC326to328() throws Throwable {
		List<String> selectedUrl = getUrl(driver, "TS019_ERO_Optimizer_WHATIF_TC326to328", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS019_ERO_Optimizer_WHATIF_TC326to328", "Testcaseurl");

		runTestScenario("TS019_ERO_Optimizer_WHATIF_TC326to328", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> owt19.Scenario19(driver, test, test1, url, dataset));
	}

	// ******************************************MAP VIEW
	// Testcases******************************************************//

	@Test
	public void TS01Map_View_TC001to014() throws Throwable {
		List<String> selectedUrl = getUrl(driver, "TS01Map_View_TC001to014", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS01Map_View_TC001to014", "Testcaseurl");

		runTestScenario("TS01Map_View_TC001to014", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> mv01.Scenario01(driver, test, test1, url, dataset));
	}

	@Test
	public void TS02Map_View_TC0015to35() throws Throwable {
		List<String> selectedUrl = getUrl(driver, "TS02Map_View_TC0015to35", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS02Map_View_TC0015to35", "Testcaseurl");

		runTestScenario("TS02Map_View_TC0015to35", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> mv02.Scenario02(driver, test, test1, url, dataset));
	}

	@Test
	public void TS05_MapViewTC42to58() throws Throwable {
		List<String> selectedUrl = getUrl(driver, "TS05_MapViewTC42to58", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS05_MapViewTC42to58", "Testcaseurl");

		runTestScenario("TS05_MapViewTC42to58", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> mv05.Scenario05(driver, test, test1, url, dataset));
	}

	@Test
	public void TS06to10MapViewTC59to67() throws Throwable {
		List<String> selectedUrl = getUrl(driver, "TS06to10MapViewTC59to67", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS06to10MapViewTC59to67", "Testcaseurl");

		runTestScenario("TS06to10MapViewTC59to67", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> mv06.Scenario06(driver, test, test1, url, dataset));
	}

	@Test
	public void TS11to12MapView68to69() throws Throwable {
		List<String> selectedUrl = getUrl(driver, "TS11to12MapView68to69", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS11to12MapView68to69", "Testcaseurl");

		runTestScenario("TS11to12MapView68to69", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> mv11.Scenario11(driver, test, test1, url, dataset));
	}

	@Test
	public void TS18to21MapView75to78() throws Throwable {
		List<String> selectedUrl = getUrl(driver, "TS18to21MapView75to78", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS18to21MapView75to78", "Testcaseurl");

		runTestScenario("TS18to21MapView75to78", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> mv18.Scenario18(driver, test, test1, url, dataset));
	}

	// **********************ERO Optimizer What - if scenario new testcases
	// **********************************************//

	@Test
	public void TS01To02ERO_Optimizer_WHAT_IF_Scripts_New() throws Throwable {
		List<String> selectedUrl = getUrl(driver, "TS01To02ERO_Optimizer_WHAT_IF_Scripts_New", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS01To02ERO_Optimizer_WHAT_IF_Scripts_New", "Testcaseurl");

		runTestScenario("TS01To02ERO_Optimizer_WHAT_IF_Scripts_New", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ons1.Scenario1(driver, test, test1, url, dataset));
	}

	@Test
	public void TS03ERO_Optimizer_WHAT_IF_Scripts_New() throws Throwable {
		List<String> selectedUrl = getUrl(driver, "TS03ERO_Optimizer_WHAT_IF_Scripts_New", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS03ERO_Optimizer_WHAT_IF_Scripts_New", "Testcaseurl");

		runTestScenario("TS03ERO_Optimizer_WHAT_IF_Scripts_New", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ons3.Scenario3(driver, test, test1, url, dataset));
	}

	@Test
	public void TS03_2ERO_Optimizer_WHAT_IF_Scripts_NewTC15TO39() throws Throwable {
		List<String> selectedUrl = getUrl(driver, "TS03_2ERO_Optimizer_WHAT_IF_Scripts_NewTC15TO39", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS03_2ERO_Optimizer_WHAT_IF_Scripts_NewTC15TO39",
				"Testcaseurl");

		runTestScenario("TS03_2ERO_Optimizer_WHAT_IF_Scripts_NewTC15TO39", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ons15.Scenario03(driver, test, test1, url, dataset));
	}

	@Test
	public void TS04ERO_Optimizer_WHAT_IF_Scripts_NewTC4To16() throws Throwable {
		List<String> selectedUrl = getUrl(driver, "TS04ERO_Optimizer_WHAT_IF_Scripts_NewTC4To16", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS04ERO_Optimizer_WHAT_IF_Scripts_NewTC4To16", "Testcaseurl");

		runTestScenario("TS04ERO_Optimizer_WHAT_IF_Scripts_NewTC4To16", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ons4.Scenario4(driver, test, test1, url, dataset));
	}

	@Test
	public void TS05ERO_Optimizer_WHAT_IF_Scripts_NewTC1To4() throws Throwable {
		List<String> selectedUrl = getUrl(driver, "TS05ERO_Optimizer_WHAT_IF_Scripts_NewTC1To4", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS05ERO_Optimizer_WHAT_IF_Scripts_NewTC1To4", "Testcaseurl");

		runTestScenario("TS05ERO_Optimizer_WHAT_IF_Scripts_NewTC1To4", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ons5.Scenario5(driver, test, test1, url, dataset));
	}

	@Test
	public void TS07ERO_Optimizer_WHAT_IF_Scripts_NewTC1To7() throws Throwable {
		List<String> selectedUrl = getUrl(driver, "TS07ERO_Optimizer_WHAT_IF_Scripts_NewTC1To7", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS07ERO_Optimizer_WHAT_IF_Scripts_NewTC1To7", "Testcaseurl");

		runTestScenario("TS07ERO_Optimizer_WHAT_IF_Scripts_NewTC1To7", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ons7.Scenario7(driver, test, test1, url, dataset));
	}

	@Test
	public void TS08To11ERO_Optimizer_WHAT_IF_Scripts_NewTC1To11() throws Throwable {
		List<String> selectedUrl = getUrl(driver, "TS08To11ERO_Optimizer_WHAT_IF_Scripts_NewTC1To11", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS08To11ERO_Optimizer_WHAT_IF_Scripts_NewTC1To11",
				"Testcaseurl");

		runTestScenario("TS08To11ERO_Optimizer_WHAT_IF_Scripts_NewTC1To11", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ons8.Scenario8(driver, test, test1, url, dataset));
	}

	// ***********************************ERO Optimization report gate
	// ****************************************************//

	@Test
	public void TS_01_TC01to03_ERO_Optimization_ReportGate() throws Throwable {
		List<String> selectedUrl = getUrl(driver, "TS_01_TC01to03_ERO_Optimization_ReportGate", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS_01_TC01to03_ERO_Optimization_ReportGate", "Testcaseurl");

		runTestScenario("TS_01_TC01to03_ERO_Optimization_ReportGate", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ero01_03.Scenario1(driver, test, test1, url, dataset));
	}

	@Test
	public void TS_02_TC04to12_ERO_Optimization_ReportGate() throws Throwable {
		List<String> selectedUrl = getUrl(driver, "TS_02_TC04to12_ERO_Optimization_ReportGate", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS_02_TC04to12_ERO_Optimization_ReportGate", "Testcaseurl");

		runTestScenario("TS_02_TC04to12_ERO_Optimization_ReportGate", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ero4_9.Scenario2(driver, test, test1, url, dataset));
	}

	@Test
	public void TS_03_TC013to016_ERO_Optimization_ReportGate() throws Throwable {
		List<String> selectedUrl = getUrl(driver, "TS_03_TC013to016_ERO_Optimization_ReportGate", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS_03_TC013to016_ERO_Optimization_ReportGate", "Testcaseurl");

		runTestScenario("TS_03_TC013to016_ERO_Optimization_ReportGate", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ero13_16.Scenario3(driver, test, test1, url, dataset));
	}

	@Test
	public void TS_04_TC017to018_ERO_Optimization_ReportGate() throws Throwable {
		List<String> selectedUrl = getUrl(driver, "TS_04_TC017to018_ERO_Optimization_ReportGate", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS_04_TC017to018_ERO_Optimization_ReportGate", "Testcaseurl");

		runTestScenario("TS_04_TC017to018_ERO_Optimization_ReportGate", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ero17_18.Scenario4(driver, test, test1, url, dataset));
	}

	@Test
	public void TS_05_TC019_ERO_Optimization_ReportGate() throws Throwable {
		List<String> selectedUrl = getUrl(driver, "TS_05_TC019_ERO_Optimization_ReportGate", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS_05_TC019_ERO_Optimization_ReportGate", "Testcaseurl");

		runTestScenario("TS_05_TC019_ERO_Optimization_ReportGate", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ero_19.Scenario5(driver, test, test1, url, dataset));
	}

	@Test
	public void TS_06_TC020_ERO_Optimization_ReportGate() throws Throwable {
		List<String> selectedUrl = getUrl(driver, "TS_06_TC020_ERO_Optimization_ReportGate", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS_06_TC020_ERO_Optimization_ReportGate", "Testcaseurl");

		runTestScenario("TS_06_TC020_ERO_Optimization_ReportGate", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ero_20.Scenario6(driver, test, test1, url, dataset));
	}

	@Test
	public void TS_07_TC021_ERO_Optimization_ReportGate() throws Throwable {
		List<String> selectedUrl = getUrl(driver, "TS_07_TC021_ERO_Optimization_ReportGate", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS_07_TC021_ERO_Optimization_ReportGate", "Testcaseurl");

		runTestScenario("TS_07_TC021_ERO_Optimization_ReportGate", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ero_21.Scenario7(driver, test, test1, url, dataset));
	}

	@Test
	public void TS_07toTS14_ReportGate() throws Throwable {

		List<String> selectedUrl = getUrl(driver, "TS_07toTS14_ReportGate", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS_07toTS14_ReportGate", "Testcaseurl");

		runTestScenario("TS_07toTS14_ReportGate", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> RG07.Testcase07(driver, test, test1, url, dataset));
	}

	@Test
	public void TS_15toTS020_ReportGate() throws Throwable {

		List<String> selectedUrl = getUrl(driver, "TS_15toTS020_ReportGate", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS_15toTS020_ReportGate", "Testcaseurl");

		runTestScenario("TS_15toTS020_ReportGate", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> RG15.Tc031toTc036(driver, test, test1, url, dataset));
	}

	@Test
	public void TS_24_TC040_ERO_Optimization_ReportGate() throws Throwable {

		List<String> selectedUrl = getUrl(driver, "TS_24_TC040_ERO_Optimization_ReportGate", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS_24_TC040_ERO_Optimization_ReportGate", "Testcaseurl");

		runTestScenario("TS_24_TC040_ERO_Optimization_ReportGate", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ero_40.Scenario32(driver, test, test1, url, dataset));
	}

	@Test
	public void TS_25_TC041_042ERO_Optimization_ReportGate() throws Throwable {

		List<String> selectedUrl = getUrl(driver, "TS_25_TC041_042ERO_Optimization_ReportGate", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS_25_TC041_042ERO_Optimization_ReportGate", "Testcaseurl");

		runTestScenario("TS_25_TC041_042ERO_Optimization_ReportGate", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ero41_42.Scenario25(driver, test, test1, url, dataset));
	}

	@Test
	public void TS_26_TC043_ERO_Optimization_ReportGate() throws Throwable {

		List<String> selectedUrl = getUrl(driver, "TS_26_TC043_ERO_Optimization_ReportGate", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS_26_TC043_ERO_Optimization_ReportGate", "Testcaseurl");

		runTestScenario("TS_26_TC043_ERO_Optimization_ReportGate", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ero_43.Scenario26(driver, test, test1, url, dataset));
	}

	@Test
	public void TS_27_TC044to046_ERO_Optimization_ReportGate() throws Throwable {

		List<String> selectedUrl = getUrl(driver, "TS_27_TC044to046_ERO_Optimization_ReportGate", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS_27_TC044to046_ERO_Optimization_ReportGate", "Testcaseurl");

		runTestScenario("TS_27_TC044to046_ERO_Optimization_ReportGate", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ero44_46.Scenario27(driver, test, test1, url, dataset));
	}

	@Test
	public void TS_28_TC047ERO_Optimization_ReportGate() throws Throwable {

		List<String> selectedUrl = getUrl(driver, "TS_28_TC047ERO_Optimization_ReportGate", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS_28_TC047ERO_Optimization_ReportGate", "Testcaseurl");

		runTestScenario("TS_28_TC047ERO_Optimization_ReportGate", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ero_47.Scenario28(driver, test, test1, url, dataset));
	}

	@Test
	public void TS_29_TC048ERO_Optimization_ReportGate() throws Throwable {

		List<String> selectedUrl = getUrl(driver, "TS_29_TC048ERO_Optimization_ReportGate", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS_29_TC048ERO_Optimization_ReportGate", "Testcaseurl");

		runTestScenario("TS_29_TC048ERO_Optimization_ReportGate", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ero_48.Scenario29(driver, test, test1, url, dataset));
	}

	@Test
	public void TS_030_TC049to051_ERO_Optimization_ReportGate() throws Throwable {

		List<String> selectedUrl = getUrl(driver, "TS_030_TC049to051_ERO_Optimization_ReportGate", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS_030_TC049to051_ERO_Optimization_ReportGate", "Testcaseurl");

		runTestScenario("TS_030_TC049to051_ERO_Optimization_ReportGate", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ero_49_51.Scenario30(driver, test, test1, url, dataset));
	}

	@Test
	public void TS_31_TC052_ERO_Optimization_ReportGate() throws Throwable {

		List<String> selectedUrl = getUrl(driver, "TS_31_TC052_ERO_Optimization_ReportGate", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS_31_TC052_ERO_Optimization_ReportGate", "Testcaseurl");

		runTestScenario("TS_31_TC052_ERO_Optimization_ReportGate", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ero_52.Scenario31(driver, test, test1, url, dataset));
	}

	@Test
	public void TS_32_TC053_ERO_Optimization_ReportGate() throws Throwable {

		List<String> selectedUrl = getUrl(driver, "TS_32_TC053_ERO_Optimization_ReportGate", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS_32_TC053_ERO_Optimization_ReportGate", "Testcaseurl");

		runTestScenario("TS_32_TC053_ERO_Optimization_ReportGate", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ero_53.Scenario32(driver, test, test1, url, dataset));
	}

	@Test
	public void TS_33_TC054_ERO_Optimization_ReportGate() throws Throwable {

		List<String> selectedUrl = getUrl(driver, "TS_33_TC054_ERO_Optimization_ReportGate", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS_33_TC054_ERO_Optimization_ReportGate", "Testcaseurl");

		runTestScenario("TS_33_TC054_ERO_Optimization_ReportGate", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ero_54.Scenario33(driver, test, test1, url, dataset));
	}

	// ********************************ERO Deviation
	// Report***************************************//

	@Test
	public void TS_001_Tc_001toTc_015_ERO_Deviation_report() throws Throwable {

		List<String> selectedUrl = getUrl(driver, "TS_001_Tc_001toTc_015_ERO_Deviation_report", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS_001_Tc_001toTc_015_ERO_Deviation_report", "Testcaseurl");

		runTestScenario("TS_001_Tc_001toTc_015_ERO_Deviation_report", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ero_1to15.Scenario01to15(driver, test, test1, url, dataset));
	}

	@Test
	public void TS_002_Tc_016toTc_036_ERO_Deviation_report() throws Throwable {

		List<String> selectedUrl = getUrl(driver, "TS_002_Tc_016toTc_036_ERO_Deviation_report", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS_002_Tc_016toTc_036_ERO_Deviation_report", "Testcaseurl");

		runTestScenario("TS_002_Tc_016toTc_036_ERO_Deviation_report", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ero_16_36.Scenario002(driver, test, test1, url, dataset));
	}

	@Test
	public void TS_003_Tc_037toTc_040_ERO_Deviation_report() throws Throwable {

		List<String> selectedUrl = getUrl(driver, "TS_003_Tc_037toTc_040_ERO_Deviation_report", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS_003_Tc_037toTc_040_ERO_Deviation_report", "Testcaseurl");

		runTestScenario("TS_003_Tc_037toTc_040_ERO_Deviation_report", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ero_37to40.Scenario03(driver, test, test1, url, dataset));
	}

	@Test
	public void TS_004_Tc_041toTc_042_ERO_Deviation_report() throws Throwable {

		List<String> selectedUrl = getUrl(driver, "TS_004_Tc_041toTc_042_ERO_Deviation_report", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS_004_Tc_041toTc_042_ERO_Deviation_report", "Testcaseurl");

		runTestScenario("TS_004_Tc_041toTc_042_ERO_Deviation_report", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ero_41to42.Scenario04(driver, test, test1, url, dataset));
	}

	@Test
	public void TS_005_Tc_043toTc_059_ERO_Deviation_report() throws Throwable {

		List<String> selectedUrl = getUrl(driver, "TS_005_Tc_043toTc_059_ERO_Deviation_report", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS_005_Tc_043toTc_059_ERO_Deviation_report", "Testcaseurl");

		runTestScenario("TS_005_Tc_043toTc_059_ERO_Deviation_report", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ero_43to59.Scenario005(driver, test, test1, url, dataset));
	}

	@Test
	public void TS_008_Tc_063toTc_066_ERO_Deviation_report() throws Throwable {

		List<String> selectedUrl = getUrl(driver, "TS_008_Tc_063toTc_066_ERO_Deviation_report", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS_008_Tc_063toTc_066_ERO_Deviation_report", "Testcaseurl");

		runTestScenario("TS_008_Tc_063toTc_066_ERO_Deviation_report", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ero_63to66.Scenario08(driver, test, test1, url, dataset));
	}

	@Test
	public void TS_010_Tc_069to70_ERO_Deviation_report() throws Throwable {

		List<String> selectedUrl = getUrl(driver, "TS_010_Tc_069to70_ERO_Deviation_report", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS_010_Tc_069to70_ERO_Deviation_report", "Testcaseurl");

		runTestScenario("TS_010_Tc_069to70_ERO_Deviation_report", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ero_69to70.Scenario10(driver, test, test1, url, dataset));
	}

	@Test
	public void TS_006_Tc_060_ERO_Deviation_report() throws Throwable {

		List<String> selectedUrl = getUrl(driver, "TS_006_Tc_060_ERO_Deviation_report", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS_006_Tc_060_ERO_Deviation_report", "Testcaseurl");

		runTestScenario("TS_010_Tc_069to70_ERO_Deviation_report", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ero_60.Scenario006(driver, test, test1, url, dataset));
	}

	@Test
	public void TS_009_Tc_067toTc68_ERO_Deviation_report() throws Throwable {

		List<String> selectedUrl = getUrl(driver, "TS_009_Tc_067toTc68_ERO_Deviation_report", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS_009_Tc_067toTc68_ERO_Deviation_report", "Testcaseurl");

		runTestScenario("TS_009_Tc_067toTc68_ERO_Deviation_report", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ero_67to68.Scenario009(driver, test, test1, url, dataset));
	}

	@Test
	public void TS_011_Tc_071_ERO_Deviation_report() throws Throwable {

		List<String> selectedUrl = getUrl(driver, "TS_011_Tc_071_ERO_Deviation_report", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS_011_Tc_071_ERO_Deviation_report", "Testcaseurl");

		runTestScenario("TS_011_Tc_071_ERO_Deviation_report", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ero_71.Scenario011(driver, test, test1, url, dataset));
	}

	@Test
	public void TS_012_Tc_072_ERO_Deviation_report() throws Throwable {

		List<String> selectedUrl = getUrl(driver, "TS_012_Tc_072_ERO_Deviation_report", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS_012_Tc_072_ERO_Deviation_report", "Testcaseurl");

		runTestScenario("TS_011_Tc_071_ERO_Deviation_report", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ero_72.Scenario012(driver, test, test1, url, dataset));
	}

	@Test
	public void TS_013_Tc_073_ERO_Deviation_report() throws Throwable {

		List<String> selectedUrl = getUrl(driver, "TS_013_Tc_073_ERO_Deviation_report", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS_013_Tc_073_ERO_Deviation_report", "Testcaseurl");

		runTestScenario("TS_013_Tc_073_ERO_Deviation_report", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ero_73.Scenario013(driver, test, test1, url, dataset));
	}

	@Test
	public void TS_016_Tc_076_ERO_Deviation_report() throws Throwable {

		List<String> selectedUrl = getUrl(driver, "TS_016_Tc_076_ERO_Deviation_report", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS_016_Tc_076_ERO_Deviation_report", "Testcaseurl");

		runTestScenario("TS_016_Tc_076_ERO_Deviation_report", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ero_76.Scenario016(driver, test, test1, url, dataset));
	}

	@Test
	public void TS_019_Tc_079_ERO_Deviation_report() throws Throwable {

		List<String> selectedUrl = getUrl(driver, "TS_019_Tc_079_ERO_Deviation_report", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS_019_Tc_079_ERO_Deviation_report", "Testcaseurl");

		runTestScenario("TS_019_Tc_079_ERO_Deviation_report", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ero_79.Scenario019(driver, test, test1, url, dataset));
	}

	@Test
	public void TS_020_Tc_080_ERO_Deviation_report() throws Throwable {

		List<String> selectedUrl = getUrl(driver, "TS_020_Tc_080_ERO_Deviation_report", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS_020_Tc_080_ERO_Deviation_report", "Testcaseurl");

		runTestScenario("TS_020_Tc_080_ERO_Deviation_report", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ero_80.Scenario020(driver, test, test1, url, dataset));
	}

	@Test
	public void TS_021_Tc_081_ERO_Deviation_report() throws Throwable {

		List<String> selectedUrl = getUrl(driver, "TS_021_Tc_081_ERO_Deviation_report", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS_021_Tc_081_ERO_Deviation_report", "Testcaseurl");

		runTestScenario("TS_021_Tc_081_ERO_Deviation_report", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ero_81.Scenario021(driver, test, test1, url, dataset));
	}

	@Test
	public void TS_022_Tc_082_ERO_Deviation_report() throws Throwable {

		List<String> selectedUrl = getUrl(driver, "TS_022_Tc_082_ERO_Deviation_report", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS_022_Tc_082_ERO_Deviation_report", "Testcaseurl");

		runTestScenario("TS_022_Tc_082_ERO_Deviation_report", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ero_82.Scenario022(driver, test, test1, url, dataset));
	}

	@Test
	public void TS_023_Tc_083_ERO_Deviation_report() throws Throwable {

		List<String> selectedUrl = getUrl(driver, "TS_023_Tc_083_ERO_Deviation_report", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS_023_Tc_083_ERO_Deviation_report", "Testcaseurl");

		runTestScenario("TS_023_Tc_083_ERO_Deviation_report", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ero_83.Scenario023(driver, test, test1, url, dataset));
	}

	@Test
	public void TS_024_Tc_084_ERO_Deviation_report() throws Throwable {

		List<String> selectedUrl = getUrl(driver, "TS_024_Tc_084_ERO_Deviation_report", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS_024_Tc_084_ERO_Deviation_report", "Testcaseurl");

		runTestScenario("TS_024_Tc_084_ERO_Deviation_report", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ero_84.Scenario024(driver, test, test1, url, dataset));
	}

	// ********************************ERO Mass Cost
	// Update***************************************//

	@Test
	public void TS_001_Tc_001toTc_015_ERO_Mass_Cost_Update() throws Throwable {

		List<String> selectedUrl = getUrl(driver, "TS_001_Tc_001toTc_015_ERO_Mass_Cost_Update", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS_001_Tc_001toTc_015_ERO_Mass_Cost_Update", "Testcaseurl");

		runTestScenario("TS_001_Tc_001toTc_015_ERO_Mass_Cost_Update", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ero_01to015.Scenario001(driver, test, test1, url, dataset));
	}

	@Test
	public void TS_002_Tc_016toTc_036_ERO_Mass_Cost_Update() throws Throwable {

		List<String> selectedUrl = getUrl(driver, "TS_002_Tc_016toTc_036_ERO_Mass_Cost_Update", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS_002_Tc_016toTc_036_ERO_Mass_Cost_Update", "Testcaseurl");

		runTestScenario("TS_001_Tc_001toTc_015_ERO_Mass_Cost_Update", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ero_01to015.Scenario001(driver, test, test1, url, dataset));
	}

	@Test
	public void TS1_002_Tc_016toTc_036_ERO_Mass_Cost_Update() throws Throwable {

		List<String> selectedUrl = getUrl(driver, "TS1_002_Tc_016toTc_036_ERO_Mass_Cost_Update", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS1_002_Tc_016toTc_036_ERO_Mass_Cost_Update", "Testcaseurl");

		runTestScenario("TS1_002_Tc_016toTc_036_ERO_Mass_Cost_Update", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ero_016to036.Scenario002(driver, test, test1, url, dataset));
	}

	@Test
	public void TS_003_Tc_037toTc_040_ERO_Mass_Cost_Update() throws Throwable {

		List<String> selectedUrl = getUrl(driver, "TS_003_Tc_037toTc_040_ERO_Mass_Cost_Update", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS_003_Tc_037toTc_040_ERO_Mass_Cost_Update", "Testcaseurl");

		runTestScenario("TS_003_Tc_037toTc_040_ERO_Mass_Cost_Update", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ero_037to040.Scenario003(driver, test, test1, url, dataset));
	}

	@Test
	public void TS_005_Tc_043toTc_059_ERO_Mass_Cost_Update() throws Throwable {

		List<String> selectedUrl = getUrl(driver, "TS_005_Tc_043toTc_059_ERO_Mass_Cost_Update", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS_005_Tc_043toTc_059_ERO_Mass_Cost_Update", "Testcaseurl");

		runTestScenario("TS_005_Tc_043toTc_059_ERO_Mass_Cost_Update", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ero_043to059.Scenario005(driver, test, test1, url, dataset));
	}

	@Test
	public void TS_006_Tc_060_ERO_Mass_Cost_Update() throws Throwable {

		List<String> selectedUrl = getUrl(driver, "TS_006_Tc_060_ERO_Mass_Cost_Update", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS_006_Tc_060_ERO_Mass_Cost_Update", "Testcaseurl");

		runTestScenario("TS_006_Tc_060_ERO_Mass_Cost_Update", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ero_060.Scenario006(driver, test, test1, url, dataset));
	}

	@Test
	public void TS_008_Tc_063toTc_066_ERO_Mass_Cost_Update() throws Throwable {

		List<String> selectedUrl = getUrl(driver, "TS_008_Tc_063toTc_066_ERO_Mass_Cost_Update", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS_008_Tc_063toTc_066_ERO_Mass_Cost_Update", "Testcaseurl");

		runTestScenario("TS_008_Tc_063toTc_066_ERO_Mass_Cost_Update", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ero_063to066.Scenario008(driver, test, test1, url, dataset));
	}

	@Test
	public void TS_007_Tc_061toTc_062_ERO_Mass_Cost_Update() throws Throwable {

		List<String> selectedUrl = getUrl(driver, "TS_007_Tc_061toTc_062_ERO_Mass_Cost_Update", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS_007_Tc_061toTc_062_ERO_Mass_Cost_Update", "Testcaseurl");

		runTestScenario("TS_007_Tc_061toTc_062_ERO_Mass_Cost_Update", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ero_061to062.Scenario007(driver, test, test1, url, dataset));
	}

	@Test
	public void TS_011_Tc_071_ERO_Mass_Cost_Update() throws Throwable {

		List<String> selectedUrl = getUrl(driver, "TS_011_Tc_071_ERO_Mass_Cost_Update", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS_011_Tc_071_ERO_Mass_Cost_Update", "Testcaseurl");

		runTestScenario("TS_011_Tc_071_ERO_Mass_Cost_Update", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ero_071.Scenario011(driver, test, test1, url, dataset));
	}

	@Test
	public void TS_010_Tc_069toTc70_ERO_Mass_Cost_Update() throws Throwable {

		List<String> selectedUrl = getUrl(driver, "TS_010_Tc_069toTc70_ERO_Mass_Cost_Update", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS_010_Tc_069toTc70_ERO_Mass_Cost_Update", "Testcaseurl");

		runTestScenario("TS_010_Tc_069toTc70_ERO_Mass_Cost_Update", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ero_069to070.Scenario010(driver, test, test1, url, dataset));
	}

	@Test
	public void TS_014_Tc_074_ERO_Mass_Cost_Update() throws Throwable {

		List<String> selectedUrl = getUrl(driver, "TS_014_Tc_074_ERO_Mass_Cost_Update", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS_014_Tc_074_ERO_Mass_Cost_Update", "Testcaseurl");

		runTestScenario("TS_014_Tc_074_ERO_Mass_Cost_Update", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ero_074.Scenario014(driver, test, test1, url, dataset));
	}

	@Test
	public void TS_009_Tc_067_ERO_Mass_Cost_Update() throws Throwable {

		List<String> selectedUrl = getUrl(driver, "TS_009_Tc_067_ERO_Mass_Cost_Update", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS_009_Tc_067_ERO_Mass_Cost_Update", "Testcaseurl");

		runTestScenario("TS_009_Tc_067_ERO_Mass_Cost_Update", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ero_067.Scenario009(driver, test, test1, url, dataset));
	}

	@Test
	public void TS_004_Tc_041toTc042_ERO_Mass_Cost_Update() throws Throwable {

		List<String> selectedUrl = getUrl(driver, "TS_004_Tc_041toTc042_ERO_Mass_Cost_Update", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS_004_Tc_041toTc042_ERO_Mass_Cost_Update", "Testcaseurl");

		runTestScenario("TS_004_Tc_041toTc042_ERO_Mass_Cost_Update", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ero_041to042.Scenario004(driver, test, test1, url, dataset));
	}

	@Test
	public void TS_019_Tc_079_ERO_Mass_Cost_Update() throws Throwable {

		List<String> selectedUrl = getUrl(driver, "TS_019_Tc_079_ERO_Mass_Cost_Update", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS_019_Tc_079_ERO_Mass_Cost_Update", "Testcaseurl");

		runTestScenario("TS_019_Tc_079_ERO_Mass_Cost_Update", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ero_079.Scenario019(driver, test, test1, url, dataset));
	}

	@Test
	public void TS_025_Tc_080_ERO_Mass_Cost_Update() throws Throwable {

		List<String> selectedUrl = getUrl(driver, "TS_025_Tc_080_ERO_Mass_Cost_Update", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS_025_Tc_080_ERO_Mass_Cost_Update", "Testcaseurl");

		runTestScenario("TS_025_Tc_080_ERO_Mass_Cost_Update", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ero_080.Scenario025(driver, test, test1, url, dataset));
	}

	@Test
	public void TS_026_Tc_081_ERO_Mass_Cost_Update() throws Throwable {

		List<String> selectedUrl = getUrl(driver, "TS_026_Tc_081_ERO_Mass_Cost_Update", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS_026_Tc_081_ERO_Mass_Cost_Update", "Testcaseurl");

		runTestScenario("TS_026_Tc_081_ERO_Mass_Cost_Update", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ero_081.Scenario026(driver, test, test1, url, dataset));
	}

	@Test
	public void TS_027_Tc_082_ERO_Mass_Cost_Update() throws Throwable {

		List<String> selectedUrl = getUrl(driver, "TS_027_Tc_082_ERO_Mass_Cost_Update", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS_027_Tc_082_ERO_Mass_Cost_Update", "Testcaseurl");

		runTestScenario("TS_027_Tc_082_ERO_Mass_Cost_Update", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ero_082.Scenario027(driver, test, test1, url, dataset));
	}

	@Test
	public void TS_012_Tc_072_ERO_Mass_Cost_Update() throws Throwable {

		List<String> selectedUrl = getUrl(driver, "TS_012_Tc_072_ERO_Mass_Cost_Update", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS_012_Tc_072_ERO_Mass_Cost_Update", "Testcaseurl");

		runTestScenario("TS_012_Tc_072_ERO_Mass_Cost_Update", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ero_072.Scenario012(driver, test, test1, url, dataset));
	}

	@Test
	public void TS_028_Tc_083_ERO_Mass_Cost_Update() throws Throwable {

		List<String> selectedUrl = getUrl(driver, "TS_028_Tc_083_ERO_Mass_Cost_Update", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS_028_Tc_083_ERO_Mass_Cost_Update", "Testcaseurl");

		runTestScenario("TS_028_Tc_083_ERO_Mass_Cost_Update", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ero_083.Scenario028(driver, test, test1, url, dataset));
	}

	// ********************************ERO Cost
	// View***************************************//

	@Test
	public void TS_001_Tc001toTc015_ERO_Cost_View() throws Throwable {

		List<String> selectedUrl = getUrl(driver, "TS_001_Tc001toTc015_ERO_Cost_View", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS_001_Tc001toTc015_ERO_Cost_View", "Testcaseurl");

		runTestScenario("TS_001_Tc001toTc015_ERO_Cost_View", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ero_001_001to015.Scenario001(driver, test, test1, url, dataset));
	}

	@Test
	public void TS_002_Tc016toTc036_ERO_Cost_View() throws Throwable {

		List<String> selectedUrl = getUrl(driver, "TS_002_Tc016toTc036_ERO_Cost_View", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS_002_Tc016toTc036_ERO_Cost_View", "Testcaseurl");

		runTestScenario("TS_002_Tc016toTc036_ERO_Cost_View", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ero_002_016to036.Scenario002(driver, test, test1, url, dataset));
	}

	@Test
	public void TS_003_Tc037toTc040_ERO_Cost_View() throws Throwable {

		List<String> selectedUrl = getUrl(driver, "TS_003_Tc037toTc040_ERO_Cost_View", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS_003_Tc037toTc040_ERO_Cost_View", "Testcaseurl");

		runTestScenario("TS_003_Tc037toTc040_ERO_Cost_View", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ero_003_037to040.Scenario003(driver, test, test1, url, dataset));
	}

	@Test
	public void TS_004_Tc041toTc042_ERO_Cost_View() throws Throwable {

		List<String> selectedUrl = getUrl(driver, "TS_004_Tc041toTc042_ERO_Cost_View", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS_004_Tc041toTc042_ERO_Cost_View", "Testcaseurl");

		runTestScenario("TS_004_Tc041toTc042_ERO_Cost_View", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ero_004_041to042.Scenario004(driver, test, test1, url, dataset));
	}

	@Test
	public void TS_005_Tc043toTc059_ERO_Cost_View() throws Throwable {

		List<String> selectedUrl = getUrl(driver, "TS_005_Tc043toTc059_ERO_Cost_View", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS_005_Tc043toTc059_ERO_Cost_View", "Testcaseurl");

		runTestScenario("TS_005_Tc043toTc059_ERO_Cost_View", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ero_005_043to059.Scenario005(driver, test, test1, url, dataset));
	}

	@Test
	public void TS_006_Tc060_ERO_Cost_View() throws Throwable {

		List<String> selectedUrl = getUrl(driver, "TS_006_Tc060_ERO_Cost_View", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS_006_Tc060_ERO_Cost_View", "Testcaseurl");

		runTestScenario("TS_006_Tc060_ERO_Cost_View", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ero_006_060.Scenario006(driver, test, test1, url, dataset));
	}

	@Test
	public void TS_007_Tc061toTc62_ERO_Cost_View() throws Throwable {

		List<String> selectedUrl = getUrl(driver, "TS_007_Tc061toTc62_ERO_Cost_View", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS_007_Tc061toTc62_ERO_Cost_View", "Testcaseurl");

		runTestScenario("TS_007_Tc061toTc62_ERO_Cost_View", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ero_007_061to062.Scenario007(driver, test, test1, url, dataset));
	}

	@Test
	public void TS_008_Tc063toTc66_ERO_Cost_View() throws Throwable {

		List<String> selectedUrl = getUrl(driver, "TS_008_Tc063toTc66_ERO_Cost_View", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS_008_Tc063toTc66_ERO_Cost_View", "Testcaseurl");

		runTestScenario("TS_008_Tc063toTc66_ERO_Cost_View", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ero_008_063to066.Scenario008(driver, test, test1, url, dataset));
	}

	@Test
	public void TS_009_Tc067toTc68_ERO_Cost_View() throws Throwable {

		List<String> selectedUrl = getUrl(driver, "TS_009_Tc067toTc68_ERO_Cost_View", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS_009_Tc067toTc68_ERO_Cost_View", "Testcaseurl");

		runTestScenario("TS_009_Tc067toTc68_ERO_Cost_View", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ero_009_067to068.Scenario009(driver, test, test1, url, dataset));
	}

	@Test
	public void TS_010_Tc069toTc070_ERO_Cost_View() throws Throwable {

		List<String> selectedUrl = getUrl(driver, "TS_010_Tc069toTc070_ERO_Cost_View", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS_010_Tc069toTc070_ERO_Cost_View", "Testcaseurl");

		runTestScenario("TS_010_Tc069toTc070_ERO_Cost_View", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ero_010_069to070.Scenario010(driver, test, test1, url, dataset));
	}

	@Test
	public void TS_011_Tc071_ERO_Cost_View() throws Throwable {

		List<String> selectedUrl = getUrl(driver, "TS_011_Tc071_ERO_Cost_View", "Testcaseurl");
		List<String> datasetCount = getDataset(driver, "TS_011_Tc071_ERO_Cost_View", "Testcaseurl");

		runTestScenario("TS_011_Tc071_ERO_Cost_View", selectedUrl, datasetCount,
				(driver, test, test1, url, dataset) -> ero_011_071.Scenario011(driver, test, test1, url, dataset));
	}

	public void Teardown(ITestResult result, ExtentTest test, ExtentTest test1) throws Throwable {
		extend_report.teardown(result, test);
		extend_report.teardown(result, test1);
		System.out.println("******************Script Execution completed******************");
		if (driver != null) {
			driver.quit();
		}
	}

	public ITestResult createTestResult(int status) {
		ITestResult result = new CustomTestResult();
		result.setStatus(status);
		return result;
	}
}
