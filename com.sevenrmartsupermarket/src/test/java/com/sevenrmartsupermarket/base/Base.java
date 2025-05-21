package com.sevenrmartsupermarket.base;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.sevenrmartsupermarket.constants.Constants;
import com.sevenrmartsupermarket.utilities.CaptureScreenshot;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public WebDriver driver;
	CaptureScreenshot captureScreenshot = new CaptureScreenshot();
	// to read from config.properties file
	Properties properties = new Properties();

	public Base() {
		try {
			FileInputStream ip = new FileInputStream(Constants.CONFIG_FILE_PATH);
			properties.load(ip);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** initialize browser **/
	public void initialize(String browser, String url) {
		if (browser.contains("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.contains("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browser.contains("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT));
	}

	@BeforeMethod
	public void launchBrowser() {
		String url = properties.getProperty("url");
		String browser = properties.getProperty("browser");
		initialize(browser, url);

	}

	@AfterMethod
	public void terminateSession(ITestResult itestresult) {
		// listener=interface used to monitor testcase status
		// ITestResult-listener
		if (itestresult.getStatus() == ITestResult.FAILURE) {
			captureScreenshot.takeScreenShot(driver, itestresult.getName());
		}

	}

}
