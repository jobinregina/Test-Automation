package Demo_Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.ebgames.saf.pages.LoginPage;

public class Sel_Test {
	public WebDriver driver = new FirefoxDriver();

	@Test
	public void JenkinTest() throws InterruptedException {
		System.out.println("Welcome to Test");

		driver.navigate().to("https://assignmentautomation-myrobotcenter2.magexo.cloud/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		System.out.println("Url before: "+ driver.getCurrentUrl());

		List <WebElement> title = driver.findElements(By.xpath(".//*[@title= 'Haushaltsroboter']"));
		System.out.println("title"+title.size());
		title.get(0).click();
		Thread.sleep(3000);
		System.out.println("Url after: "+ driver.getCurrentUrl());


		for(int i=5; i>0; i-- ) {
			
			Actions action = new Actions(driver);
			//JavascriptExecutor js =(JavascriptExecutor)driver;
			List <WebElement> dropdown = driver.findElements(By.xpath(".//*[contains(@id, 'store-switch')]"));
			System.out.println("Dropdown: "+dropdown.size());
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			dropdown.get(1).click();
			Thread.sleep(3000);

			List <WebElement> dropdown1 = driver.findElements(By.xpath(".//a[@class='chosen-single']"));
			System.out.println("Dropdown1: "+dropdown1.size());
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			dropdown1.get(0).click();
			Thread.sleep(3000);
			
			List <WebElement> country = driver.findElements(By.xpath(".//*[contains(@class,'chosen-res')]/li"));
			System.out.println("country"+country.size());
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			action.moveToElement(country.get(i)).click().perform();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			WebElement sel = driver.findElement(By.xpath(".//button[contains(@class,'action primary')]"));
			action.moveToElement(sel).click().perform();
			Thread.sleep(15000);
		}


	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	driver.quit();


}
}
