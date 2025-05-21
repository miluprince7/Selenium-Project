package com.sevenrmartsupermarket.pages;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.constants.Constants;
import com.sevenrmartsupermarket.utilities.GeneralUtility;

public class LoginPage {

	WebDriver driver;
	GeneralUtility generalUtility = new GeneralUtility();
	Properties properties = new Properties();

	@FindBy(xpath = "//input[@name='username']")
	WebElement userNameField;
	@FindBy(xpath = "//input[@name='password']")
	WebElement passwordField;
	@FindBy(xpath = "//button[text()='Sign In']")
	WebElement signInButton;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement invalidUserLogin;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		try {
			FileInputStream ip = new FileInputStream(Constants.CONFIG_FILE_PATH);
			properties.load(ip);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterUserName(String userName) {
		userNameField.sendKeys(userName);
	}

	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}

	public void clickOnSignInButton() {
		signInButton.click();
	}

	// to pass username and password that user provide
	public void login(String userName, String password) {
		enterUserName(userName);
		enterPassword(password);
		clickOnSignInButton();
	}

	// to read username and password from config.properties
	public void login() {
		String userName = properties.getProperty("username");
		String password = properties.getProperty("password");
		enterUserName(userName);
		enterPassword(password);
		clickOnSignInButton();
	}

	public boolean invalidLogin() {
		if (generalUtility.isDataPresent(invalidUserLogin, "Invalid Username/Password")) {
			return true;
		}
		return true;

	}
}
