package com.crm.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasicAuth {
	@Test
	public void testBasicAuth() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(3000);
		if (driver.findElement(By.id("content")).isDisplayed()) {
			Assert.assertEquals("Basic Auth", driver.findElement(By.xpath("//div[@id='content']//h3")).getText());
			Assert.assertEquals("Congratulations! You must have the proper credentials.",
					driver.findElement(By.xpath("//div[@id='content']//p")).getText());
		}

		driver.close();

	}
}
