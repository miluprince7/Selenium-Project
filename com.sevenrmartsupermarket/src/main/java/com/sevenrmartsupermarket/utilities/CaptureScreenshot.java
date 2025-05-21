package com.sevenrmartsupermarket.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.sevenrmartsupermarket.constants.Constants;

public class CaptureScreenshot {

	// TakesScreenshot-interface to capture screenshot
	TakesScreenshot takesScreenshot;

	public void takeScreenShot(WebDriver driver, String imageName) {
		try {
			takesScreenshot = (TakesScreenshot) driver;
			File screenShot = takesScreenshot.getScreenshotAs(OutputType.FILE);// to capture screenshot
			String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());
			String path = Constants.SCREENSHOTS_FILE_PATH + imageName + "_" + timeStamp + ".png";// save in this path
			File destination = new File(path);
			FileHandler.copy(screenShot, destination);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
