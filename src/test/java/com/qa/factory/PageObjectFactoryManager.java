package com.qa.factory;

import org.openqa.selenium.WebDriver;

import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.LogoutPage;

public class PageObjectFactoryManager {

	private static HomePage homePage;
	private static LoginPage loginPage;
	private static LogoutPage logoutPage;

	
	public static HomePage getHomePage(WebDriver driver) {
		
		return homePage == null ? new HomePage(driver) : homePage;
	}
	
	public static LoginPage getLoginPage(WebDriver driver) {
		
		return loginPage == null ? new LoginPage(driver) : loginPage;
	}
	
	public static LogoutPage getLogoutPage(WebDriver driver) {
		
		return logoutPage == null ? new LogoutPage(driver) : logoutPage ;
	}
}
