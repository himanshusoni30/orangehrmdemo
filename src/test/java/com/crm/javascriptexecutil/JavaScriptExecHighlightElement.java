package com.crm.javascriptexecutil;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecHighlightElement {
	JavascriptExecutor js;
	private By userName = By.id("txtUsername");
	private By pwd = By.id("txtPassword");	
	private By loginButton = By.id("btnLogin");
	private By logo = By.xpath("//div[@id='divLogo']/img");
	private By appleIcon = By.xpath("//img[@alt='Download on the App Store']");
	
	@Test
	public void testContextClickAndAlert() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.msn.com");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(3000);
		
//		createBorder(driver.findElement(logo), driver);
//		captureScreen(driver);
//		highLightElement(driver.findElement(loginButton), driver);
//		refreshPageJS(driver);
//		refreshPageJS(driver);
//		refreshPageJS(driver);
//		refreshPageJS(driver);
//		refreshPageJS(driver);
		generateAlert(driver, "Generating Pop-Up");
		Thread.sleep(5000);
		driver.switchTo().alert().accept();
		
//		driver.findElement(userName).sendKeys("opensourcecms");
//		driver.findElement(pwd).sendKeys("opensourcecms");
		scrollIntoView(driver, driver.findElement(appleIcon));
//		pageScroll(driver);
		Thread.sleep(5000);
		waitForFrame(driver);
//		driver.findElement(loginButton).click();
//		clickElement(driver, driver.findElement(loginButton));
		System.out.println(getTitle(driver));
		System.out.println(getHeightAndLength(driver));
		System.out.println(getInnerTextOfPage(driver));
		
		Thread.sleep(5000);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(""))));
		
		Wait<WebDriver> fw = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);
		
		
		
		driver.close();
	}
	
	public void highLightElement(WebElement ele, WebDriver driver) throws InterruptedException {
		js = (JavascriptExecutor) driver;
		String bgcolor = ele.getCssValue("backgroundColor");
		for(int i = 0; i < 50; i++) {
			changeColor("rgb(0,200,0)",ele,driver);
//			Thread.sleep(1000);
			changeColor(bgcolor,ele,driver);
//			Thread.sleep(1000);
		}
	}
	
	public void changeColor(String color, WebElement ele, WebDriver driver) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.backgroundColor = '"+color+"'", ele);
	}
	
	public void createBorder(WebElement ele, WebDriver driver) {
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.border='3px solid red'", ele);
	}
	
	public void captureScreen(WebDriver driver) {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File("target/screenshot/borderHighlight.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void generateAlert(WebDriver driver, String message) {
		js = (JavascriptExecutor)driver;
		js.executeScript("alert('"+message+"')");
	}
	
	public void clickElement(WebDriver driver, WebElement ele) {
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",ele);
	}
	
	public void refreshPageJS(WebDriver driver) {
		js = (JavascriptExecutor)driver;
		js.executeScript("history.go(0)");
	}
	
	public String getTitle(WebDriver driver) {
		js = (JavascriptExecutor)driver;
		return js.executeScript("return document.title;").toString();
	}
	
	public String getHeightAndLength(WebDriver driver) {
		js = (JavascriptExecutor)driver;
		String height = js.executeScript("return window.innerHeight;").toString();
		String width = js.executeScript("return window.innerWidth;").toString();
		return "Height: "+height+" | Width: "+width;
	}
	
	public String getInnerTextOfPage(WebDriver driver) {
		js = (JavascriptExecutor)driver;
		String innerText = js.executeScript("return document.documentElement.innerText;").toString();
		return "InnerText: "+innerText;
	}
	
	public void pageScroll(WebDriver driver) {
		js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
//		js.executeScript("window.scrollTo(0,250");
	}
	
	public void waitForFrame(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(driver.findElement(By.xpath("//iframe[contains(@src,'facebook')]"))));
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[starts-with(@title,'Like')]"))));
//		clickElement(driver, driver.findElement(By.xpath("//button[starts-with(@title,'Like')]")));
		driver.findElement(By.xpath("//button[starts-with(@title,'Like')]")).click();
	}
	
	public void scrollIntoView(WebDriver driver,WebElement ele) {
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);",ele);
	}
}
