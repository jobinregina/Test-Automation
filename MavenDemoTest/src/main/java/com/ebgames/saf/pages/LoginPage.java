package com.ebgames.saf.pages;

import java.util.List;

/*this java program finds all the web elements for 
 * login page 
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public static WebElement getAccountbutton(final WebDriver driver) {
		return driver.findElement(By.xpath(".//*[@class='accountDrop']"));
	}
	
	public static WebElement getlogindropdown(final WebDriver driver) {
		return driver.findElement(By.xpath(".//*[@class='navLogin']"));
	}
	
	public static WebElement getregisterdropdown(final WebDriver driver) {
		return driver.findElement(By.xpath(".//*[contains(@class,'navRegister')]"));
	}
	
	public static WebElement getmonthdropdown(final WebDriver driver) {
		return driver.findElement(By.xpath(".//*[contains(@id,'MonthOfBirth')]"));
	}
	
	public static List <WebElement> getmonths(final WebDriver driver) {
		return driver.findElement(By.xpath(".//*[contains(@id,'MonthOfBirth')]")).findElements(By.tagName("option"));
	}
	
	public static WebElement getusername(final WebDriver driver) {
		return driver.findElement(By.name("UserName"));
	}
	
	public static WebElement getpassword(final WebDriver driver) {
		return driver.findElement(By.name("Password"));
	}
	
	public static WebElement getloginbutton(final WebDriver driver) {
		return driver.findElement(By.xpath(".//*[@class='logonButton']"));
	}
	
	public static WebElement getloginmessage(final WebDriver driver) {
		return driver.findElement(By.xpath(".//*[@class='error message errorMessage']"));
	}
	
	public static WebElement getloginnullmessageuser(final WebDriver driver) {
		return driver.findElement(By.xpath(".//*[@data-valmsg-for='UserName']"));
	}
	
	public static WebElement getloginnullmessagepass(final WebDriver driver) {
		return driver.findElement(By.xpath(".//*[@data-valmsg-for='Password']"));
	}
	
	public static WebElement forgotpasswordlink(final WebDriver driver) {
		return driver.findElement(By.partialLinkText("Forgot your password?"));
	}
	
	public static WebElement forogotpasswordusername(final WebDriver driver) {
		return driver.findElement(By.name("UserName"));
	}
	
	public static WebElement forogotpasswordbutton(final WebDriver driver) {
		return driver.findElement(By.xpath(".//*[@id='btnResetPassword']"));
	}
	
	public static WebElement forogotpassworderrormsg(final WebDriver driver) {
		return driver.findElement(By.xpath(".//div[text()='An email has been sent to you with a link to reset your password.']"));
	}
	
	public static WebElement forogotpasswordlogonbutton(final WebDriver driver) {
		return driver.findElement(By.xpath(".//*[@class='loadLog bigButton']/span"));
	}
	
	public static WebElement resendemailverificationlink(final WebDriver driver) {
		return driver.findElement(By.partialLinkText("Resend Verification Email"));
	}
	
	public static WebElement resendemailverificationbutton(final WebDriver driver) {
		return driver.findElement(By.xpath(".//span[text()='Resend Verification Email']"));
	}
	
	public static WebElement resendemailverificationerrormsg(final WebDriver driver) {
		return driver.findElement(By.xpath(".//*[@class='error message']"));
	}
	
	public static WebElement resendemailverificationnullmsg(final WebDriver driver) {
		return driver.findElement(By.xpath(".//span[text()='The E-mail field is required.']"));
	}
	
	public static WebElement changewroglink(final WebDriver driver) {
		return driver.findElement(By.partialLinkText("Change wrong email by store enrolment"));
	}
	
	public static WebElement incorrectEmail(final WebDriver driver) {
		return driver.findElement(By.name("IncorretEmail"));
	}
	
	public static WebElement correctEmail(final WebDriver driver) {
		return driver.findElement(By.id("CorrectEmail"));
	}
	
	public static WebElement cardnumber(final WebDriver driver) {
		return driver.findElement(By.name("CardNumber"));
	}

	public static WebElement confirmbutton(final WebDriver driver) {
		return driver.findElement(By.xpath(".//span[text()='Confirm']"));
	}
	
	public static WebElement incorrectemailmsg(final WebDriver driver) {
		return driver.findElement(By.xpath(".//span[text()='The IncorrectEmail field is required.']"));
	}
	
	public static WebElement correctemailmsg(final WebDriver driver) {
		return driver.findElement(By.xpath(".//span[text()='The CorrectEmail field is required']"));
	}
	
	public static WebElement correctnumbermsg(final WebDriver driver) {
		return driver.findElement(By.xpath(".//span[text()='The CardNumber field is required']"));
	}
}
