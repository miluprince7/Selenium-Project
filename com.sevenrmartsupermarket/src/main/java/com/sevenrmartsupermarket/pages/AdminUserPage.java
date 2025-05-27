package com.sevenrmartsupermarket.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.sevenrmartsupermarket.utilities.PageUtility;

public class AdminUserPage {

	WebDriver driver;
	Select select;
	PageUtility pageUtility;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement newUser;
	@FindBy(xpath = "//input[@id='username']")
	private WebElement userNameField;
	@FindBy(xpath = "//input[@id='password']")
	private WebElement passwordField;
	@FindBy(xpath = "//select[@id='user_type']")
	private WebElement userTypeField;
	@FindBy(xpath = "//button[@name='Create']")
	private WebElement saveUser;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement userAddedAlert;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement existingUserAlert;
	@FindBy(xpath = "//input[@id='un']")
	private WebElement searchByUserName;
	@FindBy(xpath = "//select[@id='ut']")
	private WebElement searchByUserType;
	@FindBy(xpath = "//button[@name='Search']")
	private WebElement searchUser;
	@FindBy(xpath = "//a[@onclick='click_button(2)']")
	private WebElement searchButton;
	@FindBy(xpath = "//table//tbody//tr[1]//td[1]")
	private WebElement userData;
	@FindBy(xpath = "//a[@class='btn btn-sm btn btn-danger btncss']")
	private WebElement deleteUser;
	List<WebElement> specificUser;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement deleteUserMessage;

	public AdminUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void setUserName(String username) {
		userNameField.sendKeys(username);
	}

	public void setPassword(String password) {
		passwordField.sendKeys(password);
	}

	public void setUserType(String userType) {
		select = new Select(userTypeField);
		if (userType.equals("Staff") || userType.equals("Admin") || userType.equals("Partner")
				|| userType.equals("Delivery Boy")) {
			select.selectByVisibleText(userType);
		} else
			System.out.println("invalid userType");

	}

	public boolean validUserAddedAlert(String userName, String password, String userType) {
		addNewUser(userName, password, userType);
		return userAddedAlert.getText().contains("User Created Successfully");

	}

	public boolean checkInvalidUserIsAdded(String userName, String password, String userType) {
		addNewUser(userName, password, userType);
		return existingUserAlert.getText().contains("Username already exists.");
	}

	public void addNewUser(String userName, String password, String userType) {
		newUser.click();
		setUserName(userName);
		setPassword(password);
		setUserType(userType);
		saveUser.click();
	}

	public String searchUser(String userName, String userType) {
		searchButton.click();
		searchByUserName.sendKeys(userName);
		select = new Select(searchByUserType);
		select.selectByVisibleText(userType);
		searchUser.click();
		// return userData.getText();
		if (userData.getText().contains(userName)) {
			return userData.getText();
		}

		else
			return ".........RESULT NOT FOUND.......";
	}

	public boolean deleteUser(String userName, String userType) {
		specificUser = driver.findElements(By.xpath("//table//tbody//tr//td[1]"));
		for (int i = 0; i < specificUser.size(); i++) {
			if (specificUser.get(i).getText().contains(userName)) {
				searchUser(userName, userType);
				pageUtility = new PageUtility(driver);
				pageUtility.scrollPage();
				deleteUser.click();
				driver.switchTo().alert().accept();
				return true;
			}
		}
		return false;

	}
}
