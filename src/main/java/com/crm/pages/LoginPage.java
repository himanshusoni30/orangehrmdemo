package com.crm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.crm.base.BasePage;

public class LoginPage extends BasePage {
	public LoginPage(WebDriver driver) {
		super(driver);
	}
//	@FindBy(id = "txtUsername")
//	WebElement userName;

//	@FindBy(id = "txtPassword")
//	WebElement pwd;
//
//	@FindBy(id = "btnLogin")
//	WebElement loginButton;
//
//	@FindBy(xpath = "//div[@id='divLogo']/img")
//	WebElement logo;
	
	private By userName = By.id("txtUsername");
	
	public By getUserName() {
		return userName;
	}

	public By getPwd() {
		return pwd;
	}

	public By getLoginButton() {
		return loginButton;
	}

	public By getLogo() {
		return logo;
	}

	private By pwd = By.id("txtPassword");
	
	private By loginButton = By.id("btnLogin");
	
	private By logo = By.xpath("//div[@id='divLogo']/im");

	public String validateLoginPageTitle() {
		return getPageTitle();
	}

	public boolean validateCrmLogo() {
		return getElement(getLogo()).isDisplayed();
	}

	public DashboardPage login(String username, String password) {
		waitForElementDisplayed(getUserName());
		getElement(getUserName()).sendKeys(username);
		waitForElementDisplayed(getPwd());
		getElement(getPwd()).sendKeys(password);
		waitForElementClickable(loginButton);
		getElement(getLoginButton()).click();

		return getInstance(DashboardPage.class);
	}
}
