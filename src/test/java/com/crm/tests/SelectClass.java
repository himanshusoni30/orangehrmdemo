package com.crm.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectClass {
	
	@Test
	public void testSelectDropDown() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://the-internet.herokuapp.com/dropdown");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(3000);
		Select sel = new Select(driver.findElement(By.id("dropdown")));
		
		sel.selectByIndex(1);
		Thread.sleep(3000);
		sel.selectByValue("2");
		Thread.sleep(3000);
		sel.selectByVisibleText("Option 1");
		Thread.sleep(3000);
		
		driver.close();
		
	}
}
