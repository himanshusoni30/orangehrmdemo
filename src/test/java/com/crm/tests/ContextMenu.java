package com.crm.tests;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ContextMenu {
	@Test
	public void testContextClickAndAlert() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://the-internet.herokuapp.com/context_menu");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(3000);
		WebElement element = driver.findElement(By.id("hot-spot"));
		if (element.isDisplayed()) {
			Actions action = new Actions(driver);
			action.contextClick(element).build().perform();
			Thread.sleep(3000);
			Alert alt = driver.switchTo().alert();
			System.out.println(alt.getText());
			alt.accept();
			Thread.sleep(3000);
		}

		driver.close();

	}
}
