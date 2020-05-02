package com.ebgames.saf.actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ebgames.saf.pages.Searchbox;

public class SearchAction {

	WebDriver driver;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFCell cell;

	public SearchAction(WebDriver driver) {
		this.driver = driver;
	}

	public String searchfunction(final String keyword, final int test) throws IOException {

		if(test ==1) {
			Searchbox.gettextbox(driver).sendKeys(keyword);
			Searchbox.getsearchbutton(driver).click();
			Searchbox.gameconsolelink(driver).click();
			driver.navigate().back();
			driver.navigate().forward();
			driver.navigate().refresh();
			Searchbox.homepagelink(driver).click();
			return driver.getTitle();
		}
		Searchbox.gettextbox(driver).sendKeys(keyword);
		Searchbox.getsearchbutton(driver).click();
		return Searchbox.inventorycountnull(driver).getText().substring(6, 7);
	}

	public ArrayList<Integer> datadrivensearch() throws IOException, InterruptedException{
		// Import excel sheet.
		File src = new File(System.getProperty("user.dir") +"\\src\\main\\java\\com\\ebgames\\saf\\testdata\\Test.xlsx");   
		// Load the file.
		FileInputStream fis = new FileInputStream(src);
		// Load he workbook.
		workbook = new XSSFWorkbook(fis);
		// Load the sheet in which data is stored.
		sheet= workbook.getSheetAt(0);

		ArrayList<Integer> list = new ArrayList<Integer>();
	
		for(int i=1; i<=sheet.getLastRowNum(); i++){
			/*I have added test data in the cell A2 as "testemailone@test.com" and B2 as "password"
			 Cell A2 = row 1 and column 0. It reads first row as 0, second row as 1 and so on 
			 and first column (A) as 0 and second column (B) as 1 and so on*/ 

			// Import data for Email.
			cell = sheet.getRow(i).getCell(0);
			Searchbox.gettextbox(driver).clear();
			Searchbox.gettextbox(driver).sendKeys(cell.getStringCellValue());
			Searchbox.getsearchbutton(driver).click();
			Thread.sleep(5000);
			
			list.add(Integer.parseInt(Searchbox.inventorytext(driver).getText().substring(6, 8)));
			
		}
		System.out.println("Count of products:" + list); 
		return list;

	}

}
