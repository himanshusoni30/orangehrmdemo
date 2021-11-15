package com.crm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.crm.base.BasePage;

public class DashboardPage extends BasePage{
	
	private By heading = By.xpath("//div[@class='head']/h1");
	private By pieChart = By.id("div_graph_display_emp_distribution");
	private By legend = By.xpath("panel_resizable_1_1");
	private By leaveRequest = By.xpath("panel_resizable_1_2");
	
	public By getHeading() {
		return heading;
	}

	public By getPieChart() {
		return pieChart;
	}

	public By getLegend() {
		return legend;
	}

	public By getLeaveRequest() {
		return leaveRequest;
	}
	
	public DashboardPage(WebDriver driver) {
		super(driver);
	}
	
	public String validateHeading() {
		return getElement(getHeading()).getText();
	}
	
	public boolean isPieChartDisplayed() {
		return getElement(getPieChart()).isDisplayed();
	}
	
	public boolean isLegendDisplayed() {
		return getElement(getLegend()).isDisplayed();
	}
	
	public boolean isLeaveRequestDisplayed() {
		return getElement(getLeaveRequest()).isDisplayed();
	}
}
