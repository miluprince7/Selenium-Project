package com.sevenrmartsupermarket.tests;

import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.DashBoardPage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.utilities.CaptureScreenshot;
import com.sevenrmartsupermarket.utilities.ExcelRead;

public class LoginTest extends Base {

	LoginPage loginPage;
	DashBoardPage dashBoardPage;
	ExcelRead excelRead=new ExcelRead();
	//CaptureScreenshot captureScreenshot=new CaptureScreenshot();
	
	

	@Test(groups="smoke")
	public void verifyValidLogin() {
		loginPage = new LoginPage(driver);
		loginPage.login();
		dashBoardPage = new DashBoardPage(driver);
		String actualProfileName = dashBoardPage.getProfileName();
		String expectedProfileName = "Admin";
		Assert.assertEquals(actualProfileName, expectedProfileName);
	}
	
	@Test(groups="smoke")
	public void verifyInvalidLogin()
	{
		loginPage = new LoginPage(driver);
		loginPage.login("milu", "milu123");
		Assert.assertTrue(loginPage.isErrorDisplayed());	
	}
	
	/*@Test
	public void dummyTestCase()
	{
		excelRead.setExcelFile("AdminUser");
		String data =excelRead.getCellData(1, 1);
		System.out.println(data);
		Assert.assertTrue(false);
	}*/
}
