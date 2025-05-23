package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.DashBoardPage;
import com.sevenrmartsupermarket.pages.LoginPage;

public class DashBoardTest extends Base
{
	DashBoardPage dashBoardPage;
	LoginPage loginPage;

	@Test(groups={"regression","smoke"})
	public void verifyAdminDashboard()
	{
		loginPage=new LoginPage(driver);
		loginPage.login();
		dashBoardPage=new DashBoardPage(driver);
		dashBoardPage.clickMoreInfoOfAdminUser();
	}
	
	@Test(groups={"regression","smoke"})
	public void verifyLogout()
	{
		loginPage=new LoginPage(driver);
		loginPage.login();
		dashBoardPage=new DashBoardPage(driver);
	    Assert.assertTrue(dashBoardPage.logoutFromPage());
			
	}
}
