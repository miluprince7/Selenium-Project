package com.sevenrmartsupermarket.tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.dataprovider.DataProviders;
import com.sevenrmartsupermarket.pages.DashBoardPage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.ManageNewsPage;

public class ManageNewsTest extends Base {

	ManageNewsPage manageNewsPage;
	LoginPage loginPage;
	DashBoardPage dashBoardPage;
	
	@Test(dataProvider="Manage News",dataProviderClass=DataProviders.class)
	public void addNews(String news)
	{
		loginPage=new LoginPage(driver);
		dashBoardPage=loginPage.login();
		dashBoardPage.clickMoreInfoOfManageNews();
		manageNewsPage=new ManageNewsPage(driver);
		Assert.assertTrue(manageNewsPage.addNews(news));
	}
}
