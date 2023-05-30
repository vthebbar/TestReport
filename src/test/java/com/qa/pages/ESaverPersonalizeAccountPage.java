package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ESaverPersonalizeAccountPage  extends BasePage {

	public ESaverPersonalizeAccountPage(WebDriver driver) {
		super(driver);
	}

	//**** Detail entry section ****
	@FindBy(xpath="//label[@for='idAccount']/following-sibling::span/select") private WebElement dropDownAccount;
	@FindBy(xpath="//label[normalize-space()='Current Account Name']/following-sibling::span") private WebElement txtCurrentAcctName;
	@FindBy(xpath="//label[@for='idPersonalizedName']/following-sibling::span/input") private WebElement txtNewAcctName;

	@FindBy(id="idBtnSubmit") private WebElement btnNext;

	@FindBy(xpath="//span[@class='text-danger']") private WebElement txtErrMsg;
	
	//*** Acknowledgement section ***
	
	@FindBy(xpath="//li[@class='success-msg']") private WebElement txtSuccessMsg;
	@FindBy(xpath="//label[normalize-space()='Account']/following-sibling::span") private WebElement txtAcctNumAck;
	@FindBy(xpath="//label[normalize-space()='Old Account Name']/following-sibling::span") private WebElement txtOldAcctNameAck;
	@FindBy(xpath="//label[normalize-space()='New Account Name']/following-sibling::span") private WebElement txtNewAcctNameAck;
	@FindBy(xpath="//input[@value='Done']") private WebElement btnDone;

	
	public void verifyDetailEntrySection() {
		
		boolean flag=false;
		
		flag = isDisplayed(dropDownAccount,"") && isDisplayed(txtCurrentAcctName,"") && isDisplayed(txtNewAcctName,"") && isDisplayed(btnNext,"");
		
		doAssertEqualsBoolean(flag, true,"All fields displayed?");
	}
	
	public void selectAccountNum(String value) {
		selectDropDownByValue(dropDownAccount, value);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickOnNextBtn() {
		doClick(btnNext, "Next button");
	}
	
	public void verifyErrorMsg(String expVal) {
		String actVal = getText(txtErrMsg, "Error message");
		doAssertEqualsStrings(actVal, expVal, "Error message");
	}
	
	public void keyInAcctName(String acctName) {
		
		acctName = acctName + generateRandomString(4);
		
		try {
		doSendKeys(txtNewAcctName, acctName, "Account name");
		}
		catch(Exception e) {
			doSendKeys(txtNewAcctName, acctName, "Account name");
		}
	}
	
	public void verifySuccessMessage(String expVal) {
		
		String actVal = getText(txtSuccessMsg, "Success message");
		doAssertEqualsStrings(actVal, expVal, "Success message");
	}
	
public void verifyAcknowledgementDetails() {
		
		boolean flag=false;
		
		flag = isDisplayed(txtSuccessMsg,"") && isDisplayed(txtAcctNumAck,"") && isDisplayed(txtOldAcctNameAck,"") && isDisplayed(txtNewAcctNameAck,"")
				&& isDisplayed(btnDone,"");
		
		doAssertEqualsBoolean(flag, true,"All fields displayed?");
	}


public void clickOnDoneBtn() {
	doClick(btnDone,"");
}
}
