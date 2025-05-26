package com.sevenrmartsupermarket.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.WaitUtility;

public class ManageContactPage {

	WebDriver driver;
	WaitUtility waitUtility;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	// PageUtility pageUtility=new PageUtility(driver);

	@FindBy(xpath = "//i[@class='fas fa-edit']")
	private WebElement editContact;
	@FindBy(xpath = "//button[@name='Update']")
	private WebElement saveContact;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement updatedContactAlert;
	@FindBy(xpath = "//input[@name='phone']")
	private WebElement phoneNumber;
	@FindBy(xpath = "//textarea[@name='address']")
	private WebElement address;
	@FindBy(xpath = "//input[@name='email']")
	private WebElement email;
	@FindBy(xpath = "//textarea[@name='del_time']")
	private WebElement deliveryTime;
	@FindBy(xpath = "//input[@name='del_limit']")
	private WebElement deliveryChargeLimit;

	public ManageContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickEditContactInfo() {
		editContact.click();
	}

	public void updateContactInfoDetails(int column, String data) {
		if (column == 0) {
			phoneNumber.clear();
			phoneNumber.sendKeys(data);
		}
		if (column == 1) {
			email.clear();
			email.sendKeys(data);
		}
		if (column == 2) {
			address.clear();
			address.sendKeys(data);
		}
		if (column == 3) {
			js.executeScript("window.scrollBy(0,1000)");
			deliveryTime.clear();
			deliveryTime.sendKeys(data);
		}
		if (column == 4) {
			deliveryChargeLimit.clear();
			deliveryChargeLimit.sendKeys(data);

		} else {
			System.out.println("Invalid");
		}

	}

	public boolean saveContactDetails() {
		saveContact.click();
		return updatedContactAlert.getText().contains("Contact Updated Successfully");

	}

}
