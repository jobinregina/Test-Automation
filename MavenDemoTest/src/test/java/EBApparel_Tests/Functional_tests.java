package EBApparel_Tests;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.EBApparel_home;

public class Functional_tests {
	
	WebDriver driver;
	
	@BeforeTest
	
	public void setup() {
		
		driver = new FirefoxDriver();
		driver.get("http://www.ebgames.ca/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	/* this test checks
	 * 
	 * invalid login of ebgames*/
	@Test
	public void invalidlogintest(){
		EBApparel_home hmpt = new EBApparel_home(driver);
		Assert.assertEquals(hmpt.getloginmsg(), "Unable to log on. Please make sure the username and password are for a valid user");
	}
	
	/*this test checks
	 * 
	 null login of eb games*/ 
	@Test
	public void nulllogintest() {
		EBApparel_home nlt = new EBApparel_home(driver);
		ArrayList <String> out = new ArrayList<String>();
		out.add("The Email field is required");
		out.add("The Password field is required");
		System.out.println(out);
		Assert.assertEquals(out, nlt.getnulllogin());
	}
	
	/* this test checks
	 * 
	 * broken links on web page*/
	@Test
	public void brokenlinktest() {
		EBApparel_home blt = new EBApparel_home(driver);
		Assert.assertEquals(blt.getlinkstatus(),0);
	}

	/*this test checks-- not a good assertion
	 * 
	 search option of eb games*/
	@Test
	public void searchtest() {
		EBApparel_home st = new EBApparel_home(driver);
		Assert.assertEquals(st.getserchresults(), "Found 959 items for your search of PS4.");
		
	}
}
