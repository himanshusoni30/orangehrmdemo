package com.crm.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.crm.base.BasePage;
import com.crm.base.TestBase;

public class WebDriverEventListener extends TestBase implements org.openqa.selenium.support.events.WebDriverEventListener{
	public void beforeAlertAccept(WebDriver driver) {
		System.out.println("Before Alert Accept");
	}

	public void afterAlertAccept(WebDriver driver) {
		System.out.println("After Alert Accept");
	}

	public void afterAlertDismiss(WebDriver driver) {
		System.out.println("Before Alert Dismiss");
	}

	public void beforeAlertDismiss(WebDriver driver) {
		System.out.println("After Alert Accept");
	}

	public void beforeNavigateTo(String url, WebDriver driver) {
		System.out.println("Before Navigate to url: "+url);
	}

	public void afterNavigateTo(String url, WebDriver driver) {
		System.out.println("After Navigate to url: "+url);
	}

	public void beforeNavigateBack(WebDriver driver) {
		System.out.println("Before Navigate Back");
	}

	public void afterNavigateBack(WebDriver driver) {
		System.out.println("After Navigate Back");
	}

	public void beforeNavigateForward(WebDriver driver) {
		System.out.println("Before Navigate Forward");
	}

	public void afterNavigateForward(WebDriver driver) {
		System.out.println("After Navigate Forward");
	}

	public void beforeNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeClickOn(WebElement element, WebDriver driver) {
		System.out.println("Before clicking on an element: "+element);
	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		System.out.println("After clicking on an element: "+element);
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub
		
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub
		
	}

	public void beforeScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void onException(Throwable throwable, WebDriver driver) {
		System.out.println("Exception stack trace: "+throwable.getStackTrace());
		CommonUtils cu = new CommonUtils(driver);
		cu.takeScreenShot();
	}

	public <X> void beforeGetScreenshotAs(OutputType<X> target) {
		// TODO Auto-generated method stub
		
	}

	public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
		// TODO Auto-generated method stub
		
	}

	public void beforeGetText(WebElement element, WebDriver driver) {
		System.out.println("Before get text of an element: "+element);
	}

	public void afterGetText(WebElement element, WebDriver driver, String text) {
		System.out.println("After get text of an element: "+element);
	}

}
