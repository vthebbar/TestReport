package com.qa.pages;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.qa.constants.MyConstants;
import com.qa.utils.DeleteFilesInDirectory;
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
	
	// Dropdown selection
	
	public void selectValueFromDropDowm(WebElement drpDown, String valueToSelect) {
		waitForVisibility(drpDown);
		utils.log().info("Selecting value from dropdown:"+ valueToSelect);
		
		Select drp = new Select(drpDown);
		drp.selectByVisibleText(valueToSelect);
		
	}
	
	public void selectDropDownByValue(WebElement drpDown, String valueToSelect) {
		waitForVisibility(drpDown);
		utils.log().info("Selecting value from dropdown:"+ valueToSelect);
		
		Select drp = new Select(drpDown);
		drp.selectByValue(valueToSelect);
		
	}
	
	public void selectDropDownyIndex(WebElement drpDown, int index) {
		waitForVisibility(drpDown);
		utils.log().info("Selecting Index from dropdown:"+ index);
		
		Select drp = new Select(drpDown);
		drp.selectByIndex(index);
	}
	
	// Select the day value
	
	public void selecTheDay(String dayValue) {
		
		char characters[]=dayValue.toCharArray();
		if(characters[0]=='0') {
			dayValue = dayValue.substring(1);
		}
		
		String fullXpath="//a[text()='"+dayValue+"']";
		WebElement dateVal = driver.findElement(By.xpath(fullXpath));
		doClick(dateVal,"Date");
	}
	
	// Calendar Date Selection : input dd/Mmm/yyyy
	public void selectDateFromCalendar(String fullDateValue, WebElement calendarIcon, WebElement monthDropDown, WebElement yearDropDown) {
		
		String dateMonthYear[] = fullDateValue.split("/");
		System.out.println("LENGTH="+dateMonthYear.length);
		for(int i=0; i<dateMonthYear.length;i++) {
			System.out.println(i +"=="+ dateMonthYear[i]);
		}
		
		doClick(calendarIcon, "Calendar Icon");
		selectValueFromDropDowm(monthDropDown,dateMonthYear[1]);
		selectValueFromDropDowm(yearDropDown,dateMonthYear[2]);
		String dayVal = dateMonthYear[0].toString().trim();
		selecTheDay(dayVal);
		
	}
	
	public String generateRandomString(int length) {
		
		Random random = new Random();
		StringBuilder sb = new StringBuilder();
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		
		for(int i=0; i<length;i++) {
			
			int index = random.nextInt(characters.length());
			char c = characters.charAt(index);
			sb.append(c);
		}
		
		return sb.toString();
	}
	
	//Get values from dropdown
	public List<String> getDropDownValues(WebElement dropDown) {
		
		List<String> options = new ArrayList<String>();
		
		Select s = new Select(dropDown);
		List<WebElement> ele=s.getOptions();
		for(WebElement e : ele) {		
			options.add(e.getText().trim());
		}
		
		return options;
	}
	
	//Verify File download to particular directory 
	public boolean performFileDownload() {
		
		File downloadDir = new File(System.getProperty("user.dir")+"/test-output/Downloads");
		File files[]=downloadDir.listFiles();
		boolean res = (files != null && files.length>0);
		
		return res;
		
		
		
	}
	//and delete files
	public void performDeleteFiles() {
		DeleteFilesInDirectory.deleteFiles();	
	}
	
	//scroll to bottom
	public void scrollToBottomOfPage(WebDriver driver) {
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
	}
	
	
	public void scrollToElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
