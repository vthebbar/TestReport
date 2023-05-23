package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qa.constants.MyConstants;

public class ResetHlbConnectPage extends BasePage {

	public ResetHlbConnectPage(WebDriver driver) {
		super(driver);
	}


	@FindBy(css="div[class='card-header text-uppercase'] label") private WebElement txtResetPageTitle;
	@FindBy(xpath="//p[normalize-space()='Using an Account Number']") private WebElement txtHeadingUsingAcctNum;
	@FindBy(xpath="//p[normalize-space()='Using an ATM Card']") private WebElement txtHeadingUsingATM;
	@FindBy(xpath="//input[@name='idFrmStep1:j_idt65']") private WebElement btnProccedUsigAcctNum;
	@FindBy(xpath="//input[@name='idFrmStep1:j_idt78']") private WebElement btnProceedUsingATM;
	
	
	
	public void verifyPageTitle() {
		String actVal=getText(txtResetPageTitle,"page Title");
		String expVal=MyConstants.ForgotUsernamePwdPageTitle;
		doAssertEqualsStrings(actVal,expVal,"Page Title");
	}
	
	public void verifyUsingAcctNumOptionIsDisplayed() {
		
		doAssertEqualsBoolean(isDisplayed(txtHeadingUsingAcctNum,"Using Account Number"), true,"Sub Heading: Using an Account Number");
	}
	
	public void verifyProceedBtnIsDisplayedForUsingAcctNum() {
		doAssertEqualsBoolean(isDisplayed(btnProccedUsigAcctNum, "Proceed button"), true,"Proceed button for Using an Account Number");

	}
	
	public void verifyUsingATMCardOptionIsDisplayed() {
		doAssertEqualsBoolean(isDisplayed(txtHeadingUsingATM,"Using ATM Card"), true,"Sub Heading: Using ATM Card");

	}
	
	public void verifyProceedBtnIsDisplayedForUsingATMCard() {
		doAssertEqualsBoolean(isDisplayed(btnProceedUsingATM, "Proceed button"), true,"Proceed button for Using ATM Card");

	}
}
