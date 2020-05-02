package listeners;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.ebgames.saf.tests.TestCase;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestNGlisteners implements ITestListener{

	ExtentReports extent;
	ExtentTest logger;

	public void onStart(ITestContext context) {	

		//ExtentReports(String filePath,Boolean replaceExisting) 
		extent = new ExtentReports(System.getProperty("user.dir") +"/test-output/STMExtentReport.html", true);
		//extent.addSystemInfo("Environment","Environment Name")
		extent
		.addSystemInfo("Host Name", "UI Tests")
		.addSystemInfo("Environment", "Automation Testing")
		.addSystemInfo("User Name", "Jobin Sunny");
		//loading the external xml file (i.e., extent-config.xml) which was placed under the base directory
		extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
	}

	public void onTestStart(ITestResult result) {

		logger = extent.startTest("Test Case started is "+result.getName());
	}

	public void onTestSuccess(ITestResult result) {	

		logger.log(LogStatus.PASS, "Test Case Passed is "+result.getName());
		// ending test
		//endTest(logger) : It ends the current test and prepares to create HTML report
		extent.endTest(logger);
	}

	public void onTestFailure(ITestResult result) {

		logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
		logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
		try{
			// To create reference of TakesScreenshot
			TakesScreenshot screenshot=(TakesScreenshot)TestCase.driver;
			// Call method to capture screenshot
			File src=screenshot.getScreenshotAs(OutputType.FILE);
			// Copy files to specific location 
			// result.getName() will return name of test case so that screenshot name will be same as test case name
			//FileHandler.copy(src, new File("D:\\"+result.getName()+".png"));
			FileHandler.copy(src, new File(System.getProperty("user.dir") +"/FailedTestScreenshots/Searchtests/"+result.getName()+".png"));
			System.out.println("Successfully captured a screenshot");
		}catch (Exception e){
			System.out.println("Exception while taking screenshot "+e.getMessage());
		}
		// ending test
		//endTest(logger) : It ends the current test and prepares to create HTML report
		extent.endTest(logger);
		
	}


	public void onTestSkipped(ITestResult result) {

		logger.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
		// ending test
		//endTest(logger) : It ends the current test and prepares to create HTML report
		extent.endTest(logger);
	}

	public void onFinish(ITestContext context) {

		extent.flush();
		extent.close();
	}

}
