package utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.BaseTest;

public class ElementFetch {
	
	public WebElement getWebElement(String locType, String locValue) {
		
		switch(locType) {
		
		case "XPATH":
			return BaseTest.driver.findElement(By.xpath(locValue));
			
		case "ID":
			return BaseTest.driver.findElement(By.id(locValue));
			
		case "NAME":
			return BaseTest.driver.findElement(By.name(locValue));
			
		case "CSS":
			return BaseTest.driver.findElement(By.cssSelector(locValue));
			
		default:
			return null;
		}
	}
	
public List<WebElement> getWebElements(String locType, String locValue) {
		
		switch(locType) {
		
		case "XPATH":
			return BaseTest.driver.findElements(By.xpath(locValue));
			
		case "ID":
			return BaseTest.driver.findElements(By.id(locValue));
			
		case "NAME":
			return BaseTest.driver.findElements(By.name(locValue));
			
		case "CSS":
			return BaseTest.driver.findElements(By.cssSelector(locValue));
			
		default:
			return null;
		}
	}
}
