package com.crm.tests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChallengingDOM {
	@Test
	public void testBasicAuth() throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://the-internet.herokuapp.com/challenging_dom");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(3000);
		if (driver.findElement(By.xpath("//div[starts-with(@class,'large-2')]//a[1]")).isDisplayed()) {
			WebElement b1 = driver.findElement(By.xpath("//div[starts-with(@class,'large-2')]//a[1]"));
			WebElement b2 = driver.findElement(By.xpath("//div[starts-with(@class,'large-2')]//a[2]"));
			WebElement b3 = driver.findElement(By.xpath("//div[starts-with(@class,'large-2')]//a[3]"));
			Thread.sleep(3000);
			b1.click();
			b1 = driver.findElement(By.xpath("//div[starts-with(@class,'large-2')]//a[1]"));
			File src1 = ((TakesScreenshot)b1).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src1, new File("target/screenshot/b1"+System.currentTimeMillis()+".png"));
			
			Thread.sleep(3000);
			b2 = driver.findElement(By.xpath("//div[starts-with(@class,'large-2')]//a[2]"));
			b2.click();
			b2 = driver.findElement(By.xpath("//div[starts-with(@class,'large-2')]//a[2]"));
			File src2 = ((TakesScreenshot)b2).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src1, new File("target/screenshot/b2"+System.currentTimeMillis()+".png"));
			
			Thread.sleep(3000);
			b3 = driver.findElement(By.xpath("//div[starts-with(@class,'large-2')]//a[3]"));
			b3.click();
			b3 = driver.findElement(By.xpath("//div[starts-with(@class,'large-2')]//a[3]"));
			File src3 = ((TakesScreenshot)b3).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src1, new File("target/screenshot/b3"+System.currentTimeMillis()+".png"));
		}

		driver.close();

	}
}
