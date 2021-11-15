package com.crm.base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class BasePage extends Base {

	public BasePage(WebDriver driver) {
		super(driver);
	}

	@Override
	public WebElement getElement(By locator) {
		WebElement ele = null;

		try {
			return ele = driver.findElement(locator);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			return ele;
		}
	}

	@Override
	public String getPageTitle() {
		return driver.getTitle();
	}

	@Override
	public String getPageHeader(By locator) {
		return getElement(locator).getText();
	}

	@Override
	public List<WebElement> getElements(By locator) {
		List<WebElement> listOfElement = null;
		try {
			return listOfElement = driver.findElements(locator);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			return listOfElement;
		}
	}

	@Override
	public void waitForElementPresent(By locator) {
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void waitForPageTitle(String title) {
		try {
			wait.until(ExpectedConditions.titleContains(title));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void waitForElementDisplayed(By locator) {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		}catch(Exception e) {
			e.printStackTrace();
		}		
	}

	@Override
	public void waitForElementClickable(By locator) {
		// TODO Auto-generated method stub
		try {
			wait.until(ExpectedConditions.elementToBeClickable(locator));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
