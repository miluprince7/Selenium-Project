package com.sevenrmartsupermarket.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.DashBoardPage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.ManageCategoryPage;

public class ManageCategoryTest extends Base {

LoginPage loginPage;
DashBoardPage dashboardPage;
ManageCategoryPage manageCategoryPage;


@Test
public void verifySearchValidCategory()
{
	loginPage = new LoginPage(driver);
	dashboardPage=loginPage.login();
	manageCategoryPage=dashboardPage.clickMoreInfoOfManageCategory();
	String actualCategory=manageCategoryPage.searchValidCategory("Berry");
	String expectedCategory="Berry";
	Assert.assertEquals(actualCategory,expectedCategory);
	
}

@Test
public void verifySearchInvalidValidCategory()
{
	loginPage = new LoginPage(driver);
	dashboardPage=loginPage.login();
	manageCategoryPage=dashboardPage.clickMoreInfoOfManageCategory();
	String actualCategory=manageCategoryPage.searchValidCategory("Berryss");
	String expectedCategory=".........RESULT NOT FOUND.......";
	Assert.assertEquals(actualCategory,expectedCategory);
	
}

@Test
public void editTitleName()
{
	loginPage = new LoginPage(driver);
	dashboardPage=loginPage.login();
	manageCategoryPage=dashboardPage.clickMoreInfoOfManageCategory();
	String actualUpdateAlert=manageCategoryPage.updateTitle();
	Assert.assertTrue(actualUpdateAlert.contains("Category Updated Successfully"));
}

@Test
public void verifyTotalPage()
{
	loginPage = new LoginPage(driver);
	dashboardPage=loginPage.login();
	manageCategoryPage=dashboardPage.clickMoreInfoOfManageCategory();
	int actualPages=manageCategoryPage.getTotalPages();
	int expectedPages=55;
	Assert.assertEquals(actualPages,expectedPages);
}

}
