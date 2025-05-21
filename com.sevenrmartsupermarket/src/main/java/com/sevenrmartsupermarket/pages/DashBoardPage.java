package com.sevenrmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoardPage {

	WebDriver driver;

	@FindBy(xpath = "//a[@class='d-block']")
	WebElement profileName;
	@FindBy(xpath = "//p[text()='Admin Users']//following::a[1][@class='small-box-footer']")
	WebElement adminDashboard;

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
}
