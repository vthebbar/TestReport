package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

	@FindBy(xpath="//span[normalize-space()='Home']") private WebElement menuHome;
	@FindBy(xpath="//a[normalize-space()='Logout']") private WebElement btnLogout;

	
	public HomePage(WebDriver driver) {
		super(driver);
	}

	public void verifyHomeMenuIsDisplayed() {
		
		doAssertEqualsBoolean(isDisplayed(menuHome,"Home menu"), true,"Home menu");
	}
	
	
	public void verifyLogoutBtnIsDisplayed() {
		
		doAssertEqualsBoolean(isDisplayed(btnLogout,"Logout button"), true,"Logout button");
		}
	
	public LogoutPage clikLogoutBtn() {
		
		doClick(btnLogout, "Logout button");
		return new LogoutPage(driver);
	}
}
