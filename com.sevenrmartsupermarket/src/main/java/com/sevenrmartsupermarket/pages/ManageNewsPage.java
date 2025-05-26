package com.sevenrmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	WebDriver driver;
	
	@FindBy(xpath="//a[@onclick='click_button(1)']")
	WebElement newNews;
	@FindBy(xpath="//textarea[@id='news']")
	WebElement newsText;
	@FindBy(xpath="//button[text()='Save']")
	WebElement save;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement savedNewsAlert;
	
	
	public ManageNewsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean addNews(String news)
	{
		newNews.click();
		newsText.sendKeys(news);
		save.click();
		return savedNewsAlert.getText().contains("News Created Successfully");
				
		
	}

}
