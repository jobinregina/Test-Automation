package com.ebgames.saf.actions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.ebgames.saf.pages.LoginPage;

public class LoginAction {

	WebDriver driver;

	public LoginAction(WebDriver driver) {
		this.driver = driver;
	}

	public String login(final String username, final String password) {
		LoginPage.getAccountbutton(driver).click();
		LoginPage.getlogindropdown(driver).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		LoginPage.getusername(driver).sendKeys(username);
		LoginPage.getpassword(driver).sendKeys(password);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		LoginPage.getloginbutton(driver).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		if(username.isEmpty()) {
			return LoginPage.getloginnullmessageuser(driver).getText();
		}
		else if(password.isEmpty()) {
			return LoginPage.getloginnullmessagepass(driver).getText();
		}
		return LoginPage.getloginmessage(driver).getText();

	}

	public String forgot(final String username) {
		LoginPage.getAccountbutton(driver).click();
		LoginPage.getlogindropdown(driver).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		LoginPage.forgotpasswordlink(driver).click();
		if(username.isEmpty()) {
			LoginPage.forogotpasswordlogonbutton(driver).click();
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			return LoginPage.getloginbutton(driver).getAttribute("value");
		}
		else {
			LoginPage.forogotpasswordusername(driver).sendKeys(username);
			LoginPage.forogotpasswordbutton(driver).click();
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			return LoginPage.forogotpassworderrormsg(driver).getText();
		}

	}
	
	public String resendverification(final String username) {
		LoginPage.getAccountbutton(driver).click();
		LoginPage.getlogindropdown(driver).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		LoginPage.resendemailverificationlink(driver).click();
		if(username.isEmpty()) {
			LoginPage.resendemailverificationbutton(driver).click();
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			return LoginPage.resendemailverificationnullmsg(driver).getText();
		}
		else {
			LoginPage.forogotpasswordusername(driver).sendKeys(username);
			LoginPage.resendemailverificationbutton(driver).click();
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			return LoginPage.resendemailverificationerrormsg(driver).getText();
		}

	}
	
	
	public String storeenrolment(final String email1, String email2, String CardNumber) {
		LoginPage.getAccountbutton(driver).click();
		LoginPage.getlogindropdown(driver).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		LoginPage.changewroglink(driver).click();
		if(email1.isEmpty()) {
			LoginPage.correctEmail(driver).sendKeys(email2);
			LoginPage.cardnumber(driver).sendKeys(CardNumber);
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			LoginPage.confirmbutton(driver).click();
			return LoginPage.correctemailmsg(driver).getText();
		}
		else if(email2.isEmpty()){
			LoginPage.incorrectEmail(driver).sendKeys(email1);
			LoginPage.cardnumber(driver).sendKeys(CardNumber);
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			LoginPage.confirmbutton(driver).click();
			return LoginPage.incorrectemailmsg(driver).getText();
		}
		else {
			LoginPage.incorrectEmail(driver).sendKeys(email1);
			LoginPage.correctEmail(driver).sendKeys(email2);
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			LoginPage.confirmbutton(driver).click();
			return LoginPage.correctnumbermsg(driver).getText();
			
		}

	}
	
	public String registerdropdown() {
	
		LoginPage.getAccountbutton(driver).click();
		LoginPage.getregisterdropdown(driver).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		LoginPage.getmonthdropdown(driver).click();
		
		String element;
		for(int i=0; i<LoginPage.getmonths(driver).size(); i++) {
			element = LoginPage.getmonths(driver).get(i).getAttribute("value");
			if(element.equals("7")) {
				LoginPage.getmonths(driver).get(i).click();
				break;
			}
		}
		return LoginPage.getmonths(driver).get(7).getText();
	}


}
