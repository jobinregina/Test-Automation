package PageObjects;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EBApparel_home {
	
	WebDriver driver;
	String url = "";
	HttpURLConnection huc = null;
	int respcode = 200;
	int good = 0; int bad = 0;
	
	public EBApparel_home(WebDriver driver) {
		
		this.driver = driver;
	}
	
	// login check with wrong details
	public String getloginmsg(){
		
		driver.findElement(By.xpath(".//*[@class='accountDrop']")).click();
		driver.findElement(By.xpath(".//*[@class='navLogin']")).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.name("UserName")).sendKeys("jobinps@gmail.com");
		driver.findElement(By.name("Password")).sendKeys("jobin123");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		driver.findElement(By.xpath(".//*[@class='logonButton']")).click();
        return driver.findElement(By.xpath(".//*[@class='error message errorMessage']")).getText();
	}
	
	// check login with null values
	public ArrayList<String> getnulllogin() {
		
		driver.findElement(By.xpath(".//*[@class='accountDrop']")).click();
		driver.findElement(By.xpath(".//*[@class='navLogin']")).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		driver.findElement(By.xpath(".//*[@class='logonButton']")).click();
        ArrayList <String> links = new ArrayList<String>();
        driver.findElement(By.xpath(".//*[@data-valmsg-for='UserName']")).getText();
        links.add(driver.findElement(By.xpath(".//*[@data-valmsg-for='UserName']")).getText());
        System.out.println(links.get(0));
        links.add(driver.findElement(By.xpath(".//*[@data-valmsg-for='Password']")).getText());
        System.out.print(links.get(1));
        return links;
	}
	
	// check for broken links
	public int getlinkstatus() {
		List<WebElement> links = driver.findElements(By.tagName("a"));
		Iterator<WebElement> it = links.iterator();
		
		while(it.hasNext()) {
			
			url = it.next().getAttribute("href");
			
			if (url == null || url.isEmpty()) {
				System.out.println( url + "is either not configured or empty");
				continue;
			}
			
			try {
				
				huc = (HttpURLConnection)(new URL(url).openConnection());
				huc.setRequestMethod("HEAD");
				huc.connect();
				respcode = huc.getResponseCode();
				if(respcode >= 400)
				{
					bad+= 1;
					System.out.println(url);
				}
				else {
					good+= 1;
				}
			}catch(MalformedURLException e) {
				e.printStackTrace();
			}catch(IOException e) {
				e.printStackTrace();
			}
				
		}
		
		return bad;
		
	}
	
	// this returns search values of ebgames
	public String getserchresults() {
		driver.findElement(By.name("q")).sendKeys("PS4", Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return driver.findElement(By.xpath(".//*[@class= 'searchSum']")).getText();
	}

}
