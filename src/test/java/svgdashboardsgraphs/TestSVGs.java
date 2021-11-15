package svgdashboardsgraphs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestSVGs {
	@Test
	public void test() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath(".//div[@class='_2QfC02']//*[local-name()='button' and contains(text(),'✕')]")).click();

		List<WebElement> dimensions = driver
				.findElements(By.xpath(".//*[name()='svg']//*[local-name()='g']//*[local-name()='path']"));
		
		for(WebElement e:dimensions) {
			System.out.println(e.getAttribute("d"));
		}
		
		driver.close();
	}
}
