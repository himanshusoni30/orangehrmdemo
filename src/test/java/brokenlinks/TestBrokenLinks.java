package brokenlinks;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBrokenLinks {
	WebDriver driver;
	JavascriptExecutor js;
	Actions act;
	String link = "";
	String homePage = "https://www.zlti.com";
	int respCode = 0;

	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--headless");
		driver = new ChromeDriver(co);
		driver.get(homePage);
		driver.manage().window().maximize();
		js = (JavascriptExecutor) driver;
		System.out.println("================================= TEST BEGINS =====================================");
	}

	@Test
	public void testBrokenURL(){
		List<WebElement> urlList = driver.findElements(By.tagName("a"));
		httpConnectionSetUp(urlList);
	}

	public void httpConnectionSetUp(List<WebElement> urlList) {
		for (WebElement url : urlList) {
			link = url.getAttribute("href");

			if (link.isEmpty() || link.equals(null)) {
				System.out.println("URL is either not configured for anchor tag or it is empty");
				continue;
			}

			if (!link.startsWith(homePage)) {
				System.out.println("URL belongs to another domain, skipping it.");
				continue;
			}

			try {
				HttpURLConnection huc = (HttpURLConnection) new URL(link).openConnection();
				huc.setRequestMethod("HEAD");
				huc.connect();
				respCode = huc.getResponseCode();

				if (respCode >= 400) {
					System.out.println(link + " is a broken link. Status Code: " + respCode);
					Assert.assertNotEquals(200, respCode);
				} else {
					System.out.println(link + " is a valid link. Status Code: " + respCode);
					Assert.assertEquals(200, respCode);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@AfterMethod
	public void tearDown() {
		System.out.println("================================= TEST ENDS =====================================");
		driver.close();
	}
}
