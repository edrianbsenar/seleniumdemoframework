package utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.BaseTest;

public class ElementFetch {

	public WebElement getXPATHWebElement(String identifierValue) {
		return BaseTest.driver.findElement(By.xpath(identifierValue));
	}

	public List<WebElement> getXPATHWebElements(String identifierValue) {
		return BaseTest.driver.findElements(By.xpath(identifierValue));
	}

	public WebElement getCSSWebElement(String identifierValue) {
		return BaseTest.driver.findElement(By.cssSelector(identifierValue));
	}

	public List<WebElement> getCSSWebElements(String identifierValue) {
		return BaseTest.driver.findElements(By.cssSelector(identifierValue));
	}

	public WebElement getIDWebElement(String identifierValue) {
		return BaseTest.driver.findElement(By.id(identifierValue));
	}

	public WebElement getNameWebElement(String identifierValue) {
		return BaseTest.driver.findElement(By.name(identifierValue));
	}

}
