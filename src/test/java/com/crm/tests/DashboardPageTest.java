package com.crm.tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.base.TestBase;
import com.crm.pages.DashboardPage;
import com.crm.pages.LoginPage;

public class DashboardPageTest extends TestBase {
	@Test(priority=2)
	public void dashboardScreenHeadingTest() {
		DashboardPage dbp = base.getInstance(LoginPage.class).login(prop.getProperty("username"), prop.getProperty("password"));
		AssertJUnit.assertEquals(dbp.validateHeading(), "DashBoard");
	}

	@Test(priority=3)
	public void pieChartDisplayTest() {
		DashboardPage dbp = base.getInstance(LoginPage.class).login(prop.getProperty("username"), prop.getProperty("password"));
		AssertJUnit.assertEquals(dbp.isPieChartDisplayed(), true);
	}

	@Test(priority=4)
	public void legendDisplayTest() {
		DashboardPage dbp = base.getInstance(LoginPage.class).login(prop.getProperty("username"), prop.getProperty("password"));
		AssertJUnit.assertEquals(dbp.isLegendDisplayed(), true);
	}

	@Test(priority=5)
	public void leaveRequestDisplayTest() {
		DashboardPage dbp = base.getInstance(LoginPage.class).login(prop.getProperty("username"), prop.getProperty("password"));
		AssertJUnit.assertEquals(dbp.isLeaveRequestDisplayed(), true);
	}
}
