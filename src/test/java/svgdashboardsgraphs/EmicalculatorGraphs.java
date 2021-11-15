package svgdashboardsgraphs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EmicalculatorGraphs {
	
	WebDriver driver;
	JavascriptExecutor js;
	Actions act;
	
	private static By barLocator = By
			.xpath(".//*[name()='svg']//*[name()='g' and @class='highcharts-series-group']//*[name()='rect']");
	private static By toolTipLocator = By.xpath(
			".//*[name()='svg']//*[name()='g' and @class='highcharts-label highcharts-tooltip highcharts-color-undefined']//*[name()='text']");

	private static By pieChartLocator = By.xpath(
			".//*[name()='svg']//*[name()='g' and @class='highcharts-series-group']//*[name()='path' and @stroke-linejoin='round' and @opacity='1']");
	
	private static By pieChartTooltip = By.xpath(
			".//*[name()='svg']//*[name()='g' and contains(@class,'highcharts-label highcharts-tooltip') and @opacity='1']//*[name()='text']");

	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--headless");
		driver = new ChromeDriver(co);
		driver.get("https://emicalculator.net/");
		driver.manage().window().maximize();
		js = (JavascriptExecutor) driver;
		System.out.println("================================= TEST BEGINS =====================================");
	}

	@Test
	public void emicalculatorBarGraph() {
		WebElement ele = driver.findElement(By.xpath(".//div[@id='emibarchart']"));
		scrollTo(ele);

		List<WebElement> barsList = driver.findElements(barLocator);

		act = new Actions(driver);

		for (WebElement e : barsList) {
			act.moveToElement(e).perform();
			WebElement toolTip = driver.findElement(toolTipLocator);
			String barData = toolTip.getText();
			System.out.println("Bar Data: " + barData);
		}
	}

	@Test
	public void pieChart() {
		scrollTo(driver.findElement(By.id("emipiechart")));
		List<WebElement> pieChartList = driver.findElements(pieChartLocator);

		act = new Actions(driver);

		for (WebElement e : pieChartList) {
			act.moveToElement(e).perform();
			WebElement pctoolTip = driver.findElement(pieChartTooltip);
			String barData = pctoolTip.getText();
			System.out.println("Pie Chart Data: " + barData);
		}
	}

	public void scrollTo(WebElement ele) {
		js.executeScript("arguments[0].scrollIntoView(true);", ele);
	}
	
	@AfterMethod
	public void tearDown() {
		System.out.println("================================= TEST ENDS =====================================");
		driver.close();
	}
}
