package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.AdminUserPage;
import com.sevenrmartsupermarket.pages.DashBoardPage;
import com.sevenrmartsupermarket.pages.LoginPage;

public class AdminUserTest extends Base {
	LoginPage loginPage;
	DashBoardPage dashboardPage;
	AdminUserPage adminUserPage;

	@Test
	public void verifyAddUser() {
		loginPage = new LoginPage(driver);
		loginPage.login();
		dashboardPage = new DashBoardPage(driver);
		dashboardPage.clickMoreInfoOfAdminUser();
		adminUserPage = new AdminUserPage(driver);
		Assert.assertTrue(adminUserPage.validUserAddedAlert("jess", "jess@190","Staff"));
	}

	@Test
	public void verifyInvalidUserAdded() {
		loginPage = new LoginPage(driver);
		loginPage.login();
		dashboardPage = new DashBoardPage(driver);
		dashboardPage.clickMoreInfoOfAdminUser();
		adminUserPage = new AdminUserPage(driver);
		Assert.assertTrue(adminUserPage.checkInvalidUserIsAdded("jake", "resh@340","Staff"));

	}
	
	@Test
	public void verifySearchValidUser()
	{
		loginPage = new LoginPage(driver);
		loginPage.login();
		dashboardPage = new DashBoardPage(driver);
		dashboardPage.clickMoreInfoOfAdminUser();
		adminUserPage = new AdminUserPage(driver);
		String actualUsername=adminUserPage.searchUser("rheanj", "Staff");
		String expectedUserName="rheanj";
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
		//String actualAlertText=adminUserPage.deleteUser("efg");
		//String expectedAlertText="User Deleted Successfully";
		Assert.assertTrue(adminUserPage.deleteUser("real"));
	}

}
