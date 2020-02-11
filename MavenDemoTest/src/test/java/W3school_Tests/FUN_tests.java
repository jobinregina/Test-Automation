package W3school_Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.W3schools_home;

public class FUN_tests {
	
	WebDriver driver;
	
	@BeforeTest
	
	public void setup() {
		
		driver = new FirefoxDriver();
		driver.get("https://www.w3schools.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}
	
	/* this test case
	 * 
	 * checks email function*/
	
	@Test
	
	public void email_test() {
		W3schools_home emt = new W3schools_home(driver);
		Assert.assertEquals("E-mail address is not valid", emt.invalid_email());
	}
	
	/* this test case finds 
	 * 
	 * the broken links on the web page*/
	

	@Test
	
	public void test_webpagelinks() {
		W3schools_home obj = new W3schools_home(driver);
		Assert.assertEquals(0, obj.findbrokenlinks());
		
	}
	

}
