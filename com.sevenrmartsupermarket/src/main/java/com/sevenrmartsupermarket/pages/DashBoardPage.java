package com.sevenrmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.PageUtility;

public class DashBoardPage {

	WebDriver driver;
	

	@FindBy(xpath = "//a[@class='d-block']")
	private WebElement profileName;
	@FindBy(xpath = "//p[text()='Admin Users']//following::a[1][@class='small-box-footer']")
	private WebElement adminDashboard;
	@FindBy(xpath = "(//a[@class='nav-link'])[2]")
	private WebElement loggedInUser;
	@FindBy(xpath = "(//a[@class='dropdown-item'])[2]")
	private WebElement logout;
	@FindBy(xpath = "(//a[@class='small-box-footer'])[7]")
	private WebElement manageNews;
	@FindBy(xpath = "(//a[@class='small-box-footer'])[3]")
	private WebElement manageContact;
	
	
    public DashBoardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getProfileName() {
		return profileName.getText();
	}

	public void clickMoreInfoOfAdminUser() {
		adminDashboard.click();
	}
	public void clickMoreInfoOfManageNews() {
		manageNews.click();
	}
	public void clickMoreInfoOfManageContacts() {
		manageContact.click();
	}

	public boolean logoutFromPage() {
		loggedInUser.click();
		logout.click();
		if(driver.getTitle().contains("Login | 7rmart supermarket"))
		{
			return true;
		}
		else
			return false;
		
	}

}
