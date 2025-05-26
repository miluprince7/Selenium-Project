package com.sevenrmartsupermarket.dataprovider;

import org.testng.annotations.DataProvider;

import com.sevenrmartsupermarket.utilities.ExcelRead;

public class DataProviders {
	ExcelRead excelRead = new ExcelRead();
	
	@DataProvider(name="Manage News")
	public Object[][] addNews()
	{
		excelRead.setExcelFile("AddNews");
	   return excelRead.getMultidimentionalData(3,1);	
	}

}
