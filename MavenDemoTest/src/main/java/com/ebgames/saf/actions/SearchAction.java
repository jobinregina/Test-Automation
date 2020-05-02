package com.ebgames.saf.actions;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import com.ebgames.saf.pages.Searchbox;
import utils.ExcelUtils; 

public class SearchAction {

	WebDriver driver;

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

	public int datadrivensearch(){
		
		Searchbox.gettextbox(driver).clear();
		Searchbox.gettextbox(driver).sendKeys(ExcelUtils.excel().getStringCellValue());
		Searchbox.getsearchbutton(driver).click();
	    int out = Integer.parseInt(Searchbox.inventorytext(driver).getText().substring(6, 8));
		System.out.println("Count of product:" + out); 
		return out;

	}

}
