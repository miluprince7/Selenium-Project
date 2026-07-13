package com.sevenrmartsupermarket.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.PageUtility;

public class ManageCategoryPage {
	
WebDriver driver;
PageUtility pageUtility;

@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")
WebElement searchCategory;

@FindBy(xpath="//input[@class='form-control']")
WebElement categoryName;

@FindBy(xpath="//button[@name='Search']")
WebElement search;

@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td[1]")
WebElement foundElements;

@FindBy(xpath="//a[@class='btn btn-sm btn btn-primary btncss']")
WebElement edit;

@FindBy(xpath="//input[@id='category']")
WebElement editCategoryName;

@FindBy(xpath="//button[text()='Update']")
WebElement saveEdit;

@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
WebElement updateAlert;

@FindBy(xpath="//ul[@class='pagination pagination-sm m-0 float-right']//li")
List<WebElement> toatalPages;


public ManageCategoryPage(WebDriver driver)
	{
	this.driver = driver;
	PageFactory.initElements(driver, this);
	}
	
	
	public String searchValidCategory(String category)
	{
	searchCategory.click();
	categoryName.sendKeys(category);
	search.click();
	
		if(foundElements.getText().contains(category))
		{
			return foundElements.getText();
			
		}
		else
			return ".........RESULT NOT FOUND.......";
		

		
		
	}
	
	
	public String updateTitle()
	{
		String result=searchValidCategory("BerryUpdated");
		pageUtility = new PageUtility(driver);
		pageUtility.scrollPage();
		if(result.equals("BerryUpdated"))
				{
			           edit.click();
			           editCategoryName.sendKeys("Berry");
			           pageUtility.scrollAndClick(saveEdit);
			           //saveEdit.click();
			           return updateAlert.getText();
				}
				
		
		else
			return ".........RESULT NOT FOUND.......";
	}
	
	public int getTotalPages()
	{
		int totalPage=toatalPages.size()-2;
		return totalPage;
	}
	

}
