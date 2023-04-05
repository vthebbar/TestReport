package com.qa.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.qa.constants.MyConstants;
import com.qa.utils.PropertyManager;
import com.qa.utils.TestUtils;

public class BasePage {

	protected WebDriver driver;
	protected WebDriverWait wait;
	
	TestUtils utils = new TestUtils();
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver,Duration.ofSeconds(MyConstants.EXPLICIT_WAIT));

	}
	
	public void launchAppBaseUrl() {
		
		utils.log().info("Launching the application URL");;
		
		String baseUrl=PropertyManager.propertyLoader().getProperty("publicBaseUrl");
		driver.get(baseUrl);
	}
	
	

	// Reusable functions
	
	public void waitForVisibility(WebElement e) {
		wait.until(ExpectedConditions.visibilityOf(e));
	}
	
	public void clearField(WebElement e, String fieldName) {
		utils.log().info("Clearing the Field:"+ fieldName);
		e.clear();
	}
	
	public void doSendKeys(WebElement e, String value, String fieldName) {
		
		clearField(e,fieldName);
		utils.log().info("Performing value key in, Field:"+ fieldName +", Value:"+ value);
		waitForVisibility(e);
		e.sendKeys(value);
		
	}
	
	public void doClick(WebElement e, String elementName) {
		utils.log().info("Performing click on element:"+ elementName);
		waitForVisibility(e);
		e.click();
	}
	
	public String getText(WebElement e, String elementName) {
		waitForVisibility(e);
		utils.log().info("Get text value of:"+ elementName);
		return e.getText();
	}
	
	public String getAttributeValue(WebElement e, String attributeName, String elementName) {
		waitForVisibility(e);
		utils.log().info("Get attribute value of:"+ elementName+", Attribute name:"+ attributeName);
		return e.getAttribute(attributeName);
	}
	
	public void doAssertEqualsStrings(String actual, String expected, String message) {
		utils.log().info("Performing assertion verification of:" +message+", Actual value="+actual +", Expected value="+expected);
		Assert.assertEquals(actual, expected);
	}
	
	
	public void doAssertEqualsBoolean(boolean actual, boolean expected, String message) {
		utils.log().info("Performing assertion verification of:" +message+", Actual value="+actual +", Expected value="+expected);
		Assert.assertEquals(actual, expected);
	}
	
	public boolean isDisplayed(WebElement e, String fieldName) {
		waitForVisibility(e);
		utils.log().info("Verify element is displayed, filed name:"+ fieldName);
		return e.isDisplayed();
	}
}
