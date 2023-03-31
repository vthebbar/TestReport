package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LogoutPage extends BasePage {

	@FindBy(css=".fw-bold") private WebElement txtLogoutMsg;
	
	public LogoutPage(WebDriver driver) {
		super(driver);
	}
	
	public void verifyLogoutMessage(String expMsg) {
		String actMsg = getText(txtLogoutMsg, "Logout message");
		//Assert.assertEquals(actMsg,expMsg);
		doAssertEqualsStrings(actMsg, expMsg,"Logout Message");
	}
}
