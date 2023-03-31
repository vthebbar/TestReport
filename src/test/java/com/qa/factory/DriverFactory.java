package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	
	
public static WebDriver initializeDriver(String browser) {
	WebDriver driver;
	
	switch(browser) {
	
	case "chrome":
		ChromeOptions cOpt = new ChromeOptions();
		cOpt.setAcceptInsecureCerts(true);	
		driver = WebDriverManager.chromedriver().capabilities(cOpt).create();
		break;
		
	case "safari":		
		SafariOptions sOpt = new SafariOptions();
		sOpt.setAcceptInsecureCerts(true);
		driver = WebDriverManager.safaridriver().capabilities(sOpt).create();
		break;
		
	case "firefox":
		FirefoxOptions fOpt = new FirefoxOptions();
		fOpt.setAcceptInsecureCerts(true);
		driver = WebDriverManager.firefoxdriver().capabilities(fOpt).create();
		break;
		
		default:
		throw new IllegalStateException("Invalid browser name:"+ browser);
			
	}
		
		DriverFactory.driver.set(driver);
		driver.manage().window().maximize();
		return driver;
		
	}

	public static WebDriver getDriver() {
		
		return driver.get();
	}

}
