package PageObjects;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class W3schools_home {
	
	WebDriver driver;
	String url = "";
	HttpURLConnection huc = null;
	int respCode = 200;
	int bad=0; int good = 0;
	
	public W3schools_home(WebDriver driver) {
		this.driver = driver;
		
	}
	// returns homepage title
	public String gethomepagetitle() {
		return driver.getTitle();
	}
	// returns the page title of searched page
	public String getsearchresult() {
		driver.findElement(By.xpath(".//div[@class = 'w3-right']/a[1]")).click();
		driver.findElement(By.name("search")).sendKeys("HTML",Keys.ENTER);
		driver.findElement(By.xpath(".//*[@class='gs-title']/a[@href = \"https://www.w3schools.com/html/\"]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"\t");
		return driver.getTitle();
		
	}
	// returns the number of broken links
	public int findbrokenlinks() {
		List<WebElement> links = driver.findElements(By.tagName("a"));
		Iterator<WebElement> it = links.iterator();
		
		while(it.hasNext()) {
			
			url = it.next().getAttribute("href");
			//System.out.println(url);
			
			if(url == null || url.isEmpty()) {
				
			System.out.println("Url is either not configured or empty");
			
			continue;
			}
					
			try {
				
				huc = (HttpURLConnection)(new URL(url).openConnection());
						
				huc.setRequestMethod("HEAD");
				
				huc.connect();
				
				respCode = huc.getResponseCode();
				
				if (respCode >= 400) {
					bad += 1;
				}
				else {
					
					good+= 1;
			
				}
				
				
			}catch (MalformedURLException e) {
				
				e.printStackTrace();
			}catch (IOException e) {
				e.printStackTrace();
			}
			
			
	}
		//System.out.println(links.size()+" total links");
		//System.out.println(good+" good links");
		//System.out.println(bad+" bad links");
		return bad;
	}
   // find invalid email address at payment gateway
	public String invalid_email() {
		WebElement certificate = driver.findElement(By.partialLinkText("WEB CERTIFICATES"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", certificate);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		certificate.click();
		WebElement button = driver.findElement(By.xpath(".//div[@id = 'main']/a[1]"));
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		button.click();
		driver.findElement(By.xpath(".//*[@name='os0']")).sendKeys("jobinps", Keys.ENTER);
		Alert alertDialog = driver.switchTo().alert();
		String alertText = alertDialog.getText();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		alertDialog.accept();
		return alertText;
	}
	
}
