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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EBApparel_home {

	WebDriver driver;


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
		String url = "";
		HttpURLConnection huc = null;
		int respcode = 200;
		int good = 0; int bad = 0;
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
		String s = driver.findElement(By.xpath(".//*[@class= 'searchSum']")).getText();
		return s.substring(10);
	}

	// return broken image files
	public int getimageresult() {
		String pic = "";
		HttpURLConnection huc = null;
		int respcode = 200;
		int good = 0; int bad = 0;
		List<WebElement> img = driver.findElements(By.tagName("img"));
		Iterator<WebElement> it = img.iterator();

		while(it.hasNext()) {

			pic = it.next().getAttribute("src");

			if (pic == null || pic.isEmpty()) {
				System.out.println( pic + "is either not configured or empty");
				continue;
			}

			try {

				huc = (HttpURLConnection)(new URL(pic).openConnection());
				huc.setRequestMethod("HEAD");
				huc.connect();
				respcode = huc.getResponseCode();
				if(respcode >= 400)
				{
					bad+= 1;
					System.out.println(pic);
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

	//return invalid gift card or pin number message- check out workflow
	public String invalidgiftcard() {
		driver.findElement(By.xpath(".//*[@class='PlayStation 4']")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement element = driver.findElement(By.xpath(".//a[@href='/PS4/Games/767322/tom-clancys-ghost-recon-breakpoint']"));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();" , element);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Actions action = new Actions(driver);
		WebElement cart = driver.findElement(By.xpath(".//*[@id='btnAddToCart']"));
		action.moveToElement(cart).click().perform();
		
		/*List<WebElement> list1 = driver.findElements(By.xpath(".//*[@class='customRadio']"));

		for(WebElement e: list1) {
			System.out.println(e.getAttribute("value"));
			System.out.println(e.isSelected());

			if(e.getAttribute("value").equals("83000")) {
				e.click();// ----------------------------------------------------------------------------------radio button
			}
		}*/
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver,10);
		JavascriptExecutor js =(JavascriptExecutor)driver;
		//presence in DOM
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//button[contains(.,\"Go To cart\")]")));
		//scrolling
		WebElement pop = driver.findElement(By.xpath(".//button[contains(.,\"Go To cart\")]"));
		js.executeScript("arguments[0].scrollIntoView(true);", pop);
		//clickable
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//button[contains(.,\"Go To cart\")]")));
		action.moveToElement(pop).click().perform();


		//presence in DOM
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//button[contains(.,\"Go to checkout\")]")));
		//scrolling
		WebElement ckout = driver.findElement(By.xpath(".//button[contains(.,\"Go to checkout\")]"));
		js.executeScript("arguments[0].scrollIntoView(true);", ckout);
		//clickable
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//button[contains(.,\"Go to checkout\")]")));
		action.moveToElement(ckout).click().perform();


		//presence in DOM
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//button[contains(.,\"Continue as Guest\")]")));
		//scrolling
		WebElement guest = driver.findElement(By.xpath(".//button[contains(.,\"Continue as Guest\")]"));
		js.executeScript("arguments[0].scrollIntoView(true);", guest);
		//clickable
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//button[contains(.,\"Continue as Guest\")]")));
		action.moveToElement(guest).click().perform();
		
		/*List<WebElement> list2 = driver.findElements(By.xpath(".//*[@id='deliveryRadioOptions_6']"));
		for(WebElement e: list2) {
			System.out.println(e.getAttribute("value"));
			System.out.println(e.isSelected());

			if(e.getAttribute("value").equals("6")) {
				e.click();// ----------------------------------------------------------------------------------radio button
			}
		}*/

		driver.findElement(By.name("firstName")).sendKeys("dddddddd");
		driver.findElement(By.name("surname")).sendKeys("dddddddd");
		driver.findElement(By.name("phone")).sendKeys("555555555");
		driver.findElement(By.name("address1")).sendKeys("dddddddd");
		driver.findElement(By.xpath(".//*[@id='addressZip']")).sendKeys("L6S 2B7");
		driver.findElement(By.name("city")).sendKeys("brampton");
		
		List<WebElement> province = driver.findElements(By.tagName("option"));  //---------------------------------select from dropdown
		String addprov;
		for(int i = 0; i<province.size(); i++) {
			addprov = province.get(i).getAttribute("value");
			if(addprov.equals("9: 9")) {
				province.get(i).click();
			}
		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		List<WebElement> country = driver.findElements(By.tagName("option"));  //---------------------------------select from dropdown
		String adcou;
		for(int j = 0; j<country.size(); j++) {
			adcou = country.get(j).getAttribute("value");
			if(adcou.equals("Canada")) {
				country.get(j).click();
			}
		}

		//presence in DOM
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//button[contains(.,\"Next: Shipping Options\")]")));
		//scrolling
		WebElement ship = driver.findElement(By.xpath(".//button[contains(.,\"Next: Shipping Options\")]"));
		js.executeScript("arguments[0].scrollIntoView(true);", ship);
		//clickable
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//button[contains(.,\"Next: Shipping Options\")]")));
		action.moveToElement(ship).click().perform();
	    driver.findElement(By.xpath(".//button[contains(.,\"Save Anyway\")]")).click();
	    driver.findElement(By.xpath(".//button[contains(.,\"Next: Payment Options\")]")).click();
		driver.findElement(By.xpath(".//*[@id='gcn']")).sendKeys("12345", Keys.ENTER);
		driver.findElement(By.xpath(".//*[@id='gcp']")).sendKeys("12345", Keys.ENTER);
		String txt = driver.findElement(By.xpath(".//*[@id='cdk-overlay-0']")).getText();
		driver.findElement(By.xpath(".//button[contains(.,\"Ok\")]")).click();
        System.out.println(txt);
		return txt;
	}




}
