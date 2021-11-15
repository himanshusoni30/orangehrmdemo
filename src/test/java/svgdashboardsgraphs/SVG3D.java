package svgdashboardsgraphs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SVG3D {
	@Test
	public void test() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("http://debeissat.nicolas.free.fr/svg3d.php");
		driver.manage().window().maximize();

		driver.switchTo().frame(driver.findElement(By.id("logo")));
		int i = 0;
//		while (true) {
		while (i<10) {
			List<WebElement> dimensions = driver.findElements(By.xpath(
					".//*[name()='svg']//*[local-name()='g' and @id='g2']//*[local-name()='path' and contains(@id,'face')]"));

			for (WebElement e : dimensions) {
				System.out.println("Dimension: " + e.getAttribute("d"));
			}
			i++;
		}

		driver.close();
	}
}
