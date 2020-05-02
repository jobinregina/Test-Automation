package com.ebgames.saf.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import configs.PropertiesFile;





public class TestCase {

	public static WebDriver driver;
	public static String browserName;
	public static String website;
	ExtentReports extent;
	ExtentTest logger;



	@BeforeTest
	public void setup() {

		String projectPath = System.getProperty("user.dir");
		PropertiesFile.getProperties();

		if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", projectPath+"/drivers/geckodriver/geckodriver.exe");
			driver = new FirefoxDriver();
			driver.get(website);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		}

	}


	@AfterSuite
	public void tearDown() {
		
		driver.close();
	}



}
