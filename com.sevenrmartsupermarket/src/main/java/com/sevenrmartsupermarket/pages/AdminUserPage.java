package com.sevenrmartsupermarket.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class AdminUserPage {

	WebDriver driver;
	Select select;
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	WebElement newUser;
	@FindBy(xpath="//input[@id='username']")
	WebElement userNameField;
	@FindBy(xpath="//input[@id='password']")
	WebElement passwordField;
	@FindBy(xpath="//select[@id='user_type']")
	WebElement userTypeField;
	@FindBy(xpath="//button[@name='Create']")
	WebElement saveUser;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement userAddedAlert;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	WebElement existingUserAlert;
	@FindBy(xpath="//input[@id='un']")
	WebElement searchByUserName;
	@FindBy(xpath="//select[@id='ut']")
	WebElement searchByUserType;
	@FindBy(xpath="//button[@name='Search']")
	WebElement searchUser;
	@FindBy(xpath="//a[@onclick='click_button(2)']")
	WebElement searchButton;
	@FindBy(xpath="//table//tbody//tr[1]//td[1]")
	WebElement userData;
	@FindBy(xpath="//a[@class='btn btn-sm btn btn-danger btncss']")
	WebElement deleteUser;
	//@FindBy(xpath="//table//tbody//tr//td[1]")
	List<WebElement> specificUser;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement deleteUserMessage;
	
	
	
	
	public AdminUserPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void setUserName(String username)
	{
		userNameField.sendKeys(username);
	}
	
	public void setPassword(String password)
	{
		passwordField.sendKeys(password);
	}
	public void setUserType(String userType)
	{
		select=new Select(userTypeField);
		if(userType.equals("Staff")||userType.equals("Admin")||userType.equals("Partner")||userType.equals("Delivery Boy"))
		{
		select.selectByVisibleText(userType);
		}
		else 
			System.out.println("invalid userType");
		
	}
	
	public boolean validUserAddedAlert(String userName, String password,String userType)
	{
		addNewUser(userName,password,userType);
		return userAddedAlert.getText().contains("User Created Successfully");
		
	}
	
	public boolean checkInvalidUserIsAdded(String userName, String password,String userType)
	{
		addNewUser(userName,password,userType);
		return existingUserAlert.getText().contains("Username already exists.");
	}
	
	public void addNewUser(String userName, String password,String userType)
	{
		newUser.click();
		setUserName(userName);
		setPassword(password);
		setUserType(userType);
		saveUser.click();
	}
	
	public String searchUser(String userName,String userType)
	{
		searchButton.click();
		searchByUserName.sendKeys(userName);
		select=new Select(searchByUserType);
		select.selectByVisibleText(userType);
		searchUser.click();
		//return userData.getText();
		if(userData.getText().contains(userName))
		{
			return userData.getText();
		}
		
		else
			return ".........RESULT NOT FOUND.......";
	}
	
	
	
	public boolean deleteUser(String userName)
	{
		specificUser=driver.findElements(By.xpath("//table//tbody//tr//td[1]"));
		
		for(int i=0;i<specificUser.size();i++)
		{
		if (specificUser.get(i).getText().contains(userName))
		{
			//Actions actions=new Actions(driver);
			//actions.click(deleteUser.).build().perform();
			deleteUser.click();
			driver.switchTo().alert().accept();
			return true;
			
		}
		}
		return false;
		
	}
}
