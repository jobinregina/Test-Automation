package com.ebgames.saf.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ebgames.saf.actions.LoginAction;
import com.relevantcodes.extentreports.LogStatus;


public class LoginTestCase extends TestCase{
	
	
	
	/* this test checks
	 * 
	 * invalid login of ebgames account*/
	//@Test
	public void invalidlogintest(){
		String username = "jobinps";
		String password = "jobinps";
		String message = "Unable to log on. Please make sure the username and password are for a valid user";
		LoginAction iln = new LoginAction(driver);
		Assert.assertEquals(iln.login(username, password), message);
	}
	
	//@Test
	public void nulllogintestuser(){
		String username = "";
		String password = "jobinps";
		String message = "The Email field is required";
		LoginAction nlu = new LoginAction(driver);
		Assert.assertEquals(nlu.login(username, password), message);
	}
	
	//@Test
	public void nulllogintestpass(){
		String username = "jobinps";
		String password = "";
		String message = "The Password field is required";
		LoginAction nlp = new LoginAction(driver);
		Assert.assertEquals(nlp.login(username, password), message);
	}
	
	//@Test
	public void forgotpasword(){
		String username = "jolly";
		String message = "An email has been sent to you with a link to reset your password.";
		LoginAction fgp = new LoginAction(driver);
		Assert.assertEquals(fgp.forgot(username), message);
	}
	
	//@Test
	public void forgotpaswordloginbuttoncheck(){
		String username = "";
		String value = "Login";
		LoginAction fgpl = new LoginAction(driver);
		Assert.assertEquals(fgpl.forgot(username), value);
	}
	
	//@Test
	public void resendemailverificationbutton(){
		String username = "";
		String message = "The E-mail field is required.";
		LoginAction revb = new LoginAction(driver);
		Assert.assertEquals(revb.resendverification(username), message);
	}
	
	//@Test
	public void resendemailverification(){
		String username = "jobin";
		String message = "User does not exist";
		LoginAction revb = new LoginAction(driver);
		Assert.assertEquals(revb.resendverification(username), message);
	}
	
	//@Test
		public void storeemailchangetest1(){
			String email1 = "";
			String email2 = "jobin";
			String CardNumber = Integer.toString(123);
			String message = "The IncorrectEmail field is required";
			LoginAction sec1 = new LoginAction(driver);
			Assert.assertEquals(sec1.storeenrolment(email1, email2, CardNumber), message);
		}
		
		@Test
		public void dropdown(){
			logger = extent.startTest("Date drop down-month");
			String mesg = "7";
			LoginAction dd = new LoginAction(driver);
			Assert.assertEquals(dd.registerdropdown(),mesg);
			logger.log(LogStatus.PASS, "Dropdown month ok");
		}
	

}
