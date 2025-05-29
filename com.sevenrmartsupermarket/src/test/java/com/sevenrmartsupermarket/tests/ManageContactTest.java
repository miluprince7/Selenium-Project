package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.DashBoardPage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.ManageContactPage;
import com.sevenrmartsupermarket.utilities.ExcelRead;

public class ManageContactTest extends Base {

	LoginPage loginPage;
	DashBoardPage dashboardPage;
	ManageContactPage manageContactPage;
	ExcelRead excelRead = new ExcelRead();

	@Test
	public void verifyUpdateOfContactDetail() {
		loginPage = new LoginPage(driver);
		dashboardPage=loginPage.login();
		dashboardPage.clickMoreInfoOfManageContacts();
		manageContactPage = new ManageContactPage(driver);
		manageContactPage.clickEditContactInfo();
		excelRead.setExcelFile("ContactDetails");
		for (int i = 0; i < 5; i++) {
			String data = excelRead.getCellData(0, i);
			manageContactPage.updateContactInfoDetails(i, data);

		}
		Assert.assertTrue(manageContactPage.saveContactDetails());
	}
}
