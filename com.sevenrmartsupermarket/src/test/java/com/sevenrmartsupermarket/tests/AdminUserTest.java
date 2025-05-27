package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.listeners.RetryAnalyzer;
import com.sevenrmartsupermarket.pages.AdminUserPage;
import com.sevenrmartsupermarket.pages.DashBoardPage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.utilities.GeneralUtility;

public class AdminUserTest extends Base {
	LoginPage loginPage;
	DashBoardPage dashboardPage;
	AdminUserPage adminUserPage;
	GeneralUtility generalUtility;
	

	@Test(retryAnalyzer =RetryAnalyzer.class )
	public void verifyAddUser() {
		loginPage = new LoginPage(driver);
		loginPage.login();
		dashboardPage = new DashBoardPage(driver);
		dashboardPage.clickMoreInfoOfAdminUser();
		adminUserPage = new AdminUserPage(driver);
		generalUtility=new GeneralUtility();
		String name=generalUtility.getRandomName();
		String password=generalUtility.getRandomPassword();
		Assert.assertTrue(adminUserPage.validUserAddedAlert(name, password,"Staff"));
	}

	@Test
	public void verifyInvalidUserAdded() {
		loginPage = new LoginPage(driver);
		loginPage.login();
		dashboardPage = new DashBoardPage(driver);
		dashboardPage.clickMoreInfoOfAdminUser();
		adminUserPage = new AdminUserPage(driver);
		Assert.assertTrue(adminUserPage.checkInvalidUserIsAdded("Clyde", "jake@340","Staff"));

	}
	
	@Test
	public void verifySearchValidUser()
	{
		loginPage = new LoginPage(driver);
		loginPage.login();
		dashboardPage = new DashBoardPage(driver);
		dashboardPage.clickMoreInfoOfAdminUser();
		adminUserPage = new AdminUserPage(driver);
		String actualUsername=adminUserPage.searchUser("Clyde", "Staff");
		String expectedUserName="Clyde";
		Assert.assertEquals(actualUsername, expectedUserName);
			
	}
	
	@Test
	public void verifySearchInvalidUser()
	{
		loginPage = new LoginPage(driver);
		loginPage.login();
		dashboardPage = new DashBoardPage(driver);
		dashboardPage.clickMoreInfoOfAdminUser();
		adminUserPage = new AdminUserPage(driver);
		String actualUsername=adminUserPage.searchUser("rhea", "Staff");
		String expectedUserName=".........RESULT NOT FOUND.......";
		Assert.assertEquals(actualUsername, expectedUserName);
			
	}
	
	@Test
	public void verifyDeleteValidUser()
	{
		loginPage = new LoginPage(driver);
		loginPage.login();
		dashboardPage = new DashBoardPage(driver);
		dashboardPage.clickMoreInfoOfAdminUser();
		adminUserPage = new AdminUserPage(driver);
		Assert.assertTrue(adminUserPage.deleteUser("Dedrick","Admin"));
	}

}
