package com.crm.base;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Base {
	public WebDriver driver;
	
	protected WebDriverWait wait;
	
	public Base(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(this.driver,Duration.ofSeconds(20));
	}
	
	public abstract WebElement getElement(By locator);
	
	public abstract String getPageTitle();
	
	public abstract String getPageHeader(By locator);
	
	public abstract List<WebElement> getElements(By locator);
	
	public abstract void waitForElementPresent(By locator);
	
	public abstract void waitForElementDisplayed(By locator);
	
	public abstract void waitForElementClickable(By locator);
	
	public abstract void waitForPageTitle(String title);
	
	public <T extends Base> T getInstance(Class<T> pageClass){
		try {
			return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
