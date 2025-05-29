package com.sevenrmartsupermarket.tests;

import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.DashBoardPage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.utilities.CaptureScreenshot;
import com.sevenrmartsupermarket.utilities.ExcelRead;
import com.sevenrmartsupermarket.utilities.GeneralUtility;

public class LoginTest extends Base {

	LoginPage loginPage;
	DashBoardPage dashBoardPage;
	ExcelRead excelRead = new ExcelRead();
	GeneralUtility generalUtility;
	CaptureScreenshot captureScreenshot=new CaptureScreenshot();

	@Test(groups = "smoke")
	public void verifyValidLogin() {
		loginPage = new LoginPage(driver);
		dashBoardPage= loginPage.login();
		String actualProfileName = dashBoardPage.getProfileName();
		String expectedProfileName = "Admin";
		Assert.assertEquals(actualProfileName, expectedProfileName);

	}

	@Test(groups = "smoke")
	public void verifyInvalidLogin() {
		loginPage = new LoginPage(driver);
		loginPage.login("milu", "milu123");
		Assert.assertTrue(loginPage.isErrorDisplayed());
		captureScreenshot.takeScreenShot(driver, "error");
	}
}
