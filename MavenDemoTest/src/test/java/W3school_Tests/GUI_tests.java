package W3school_Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.W3schools_home;

public class GUI_tests {
	
	WebDriver driver;
	
	@BeforeTest
	
	public void setup() {
		
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https:www.w3schools.com/");
		
	}
	
	/* this test case verifies 
	 * 
	 * w3schools home page title*/
	
	@Test(priority = 0)
	
	public void test_homepage_title() {
		
		W3schools_home obj = new W3schools_home(driver);
		Assert.assertEquals("W3Schools Online Web Tutorials", obj.gethomepagetitle());
	}
	
	/* this test case verifies
	 * 
	 * the search functionality in home page
	 */
	
	@Test
	public void test_searchoption() {
		W3schools_home obj = new W3schools_home(driver);
		Assert.assertEquals("W3Schools Online Web Tutorials", obj.getsearchresult());
	}


}
