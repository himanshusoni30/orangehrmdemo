package com.crm.javascriptexecutil;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class JavaScriptEngine {
	@Test
	public void clickOnButton() {
		WebDriver driver = null;
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("button")));
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, (new File("target/screenshots/"+System.currentTimeMillis()+".png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
