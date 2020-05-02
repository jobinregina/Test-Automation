package com.ebgames.saf.pages;

import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*this java class finds webelements for searchbox*/

public class Searchbox {
	
	public static WebElement gettextbox(final WebDriver driver) {
		List <WebElement> element = driver.findElements(By.name("q"));
		return element.get(0);
	}
	
	public static WebElement getsearchbutton(final WebDriver driver) {
		return driver.findElement(By.className("bigButton"));
	}
	
	public static WebElement gameconsolelink(final WebDriver driver) {
		return driver.findElement(By.xpath(".//*[@href='/PS4/Games/777383/playstation-4-pro-1tb-console-glacier-white']"));
	}
	
	public static WebElement homepagelink(final WebDriver driver) {
		return driver.findElement(By.xpath(".//*[@class='head1']"));
	}
	public static WebElement inventorycount(final WebDriver driver) {
		return driver.findElement(By.xpath(".//*[contains(strong,'1')]"));
	}
	public static WebElement inventorycountnull(final WebDriver driver) {
		return driver.findElement(By.xpath(".//*[contains(strong,'0')]"));
	}
	public static WebElement inventorytext(final WebDriver driver) {
		return driver.findElement(By.xpath(".//*[@class='searchSum']"));
	}

}
