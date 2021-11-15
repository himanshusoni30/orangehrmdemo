package com.crm.tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.crm.base.TestBase;
import com.crm.pages.LoginPage;

public class LoginPageTest extends TestBase {
	@Test(priority = 1, enabled = false)
	public void titleTest() {
		String title = base.getInstance(LoginPage.class).validateLoginPageTitle();
		AssertJUnit.assertEquals(title, "OrangeHRM");
	}

	@Test
	//(retryAnalyzer = com.crm.analyzer.RetryAnalyzer.class)
	public void crmLogoTest() {
		boolean flag = base.getInstance(LoginPage.class).validateCrmLogo();
		AssertJUnit.assertEquals(flag, true);
	}

	@Test(priority = 3, enabled = false)
	public void loginTest() {
		base.getInstance(LoginPage.class).login(prop.getProperty("username"), prop.getProperty("password"));
	}
}
