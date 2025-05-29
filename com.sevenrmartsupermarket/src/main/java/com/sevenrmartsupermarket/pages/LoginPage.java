package com.sevenrmartsupermarket.pages;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.constants.Constants;
import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.WaitUtility;

public class LoginPage {

	WebDriver driver;
	GeneralUtility generalUtility = new GeneralUtility();
	Properties properties = new Properties();

	@FindBy(xpath = "//input[@name='username']")
	private WebElement userNameField;
	@FindBy(xpath = "//input[@name='password']")
	private WebElement passwordField;
	@FindBy(xpath = "//button[text()='Sign In']")
	private WebElement signInButton;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement invalidUserLogin;

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
		WaitUtility waitUtility=new WaitUtility(driver);
		waitUtility.elementToBeClickable(signInButton, 30);
		signInButton.click();
		
	}

	// to pass username and password that user provide
	public DashBoardPage login(String userName, String password) {
		enterUserName(userName);
		enterPassword(password);
		clickOnSignInButton();
		return new DashBoardPage(driver);
	}

	public DashBoardPage login() {
		String userName = properties.getProperty("username");
		String password = properties.getProperty("password");
		enterUserName(userName);
		enterPassword(password);
		clickOnSignInButton();
		return new DashBoardPage(driver);
	}

	public boolean isErrorDisplayed() {
		return generalUtility.isDataPresent(invalidUserLogin, "Invalid Username/Password"); 
			
	}
}
