package com.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.qa.constants.MyConstants;

public class RegisterForOnlineBankingPage extends BasePage {

	
	public RegisterForOnlineBankingPage(WebDriver driver) {
		super(driver);
	}
	
	//Register Section
	@FindBy(css="div[class='card-header text-uppercase'] label") private WebElement txtPageTitle;
	@FindBy(xpath="//p[normalize-space()='Using an Account Number']") private WebElement txtHeadingUsingAcctNum;
	@FindBy(xpath="//p[normalize-space()='Using an ATM Card']") private WebElement txtHeadingUsingATM;
	@FindBy(xpath="//input[@name='idFrmStep1:j_idt65']") private WebElement btnProccedUsigAcctNum;
	@FindBy(xpath="//input[@name='idFrmStep1:j_idt78']") private WebElement btnProceedUsingATM;
	
	
	//Enter Details Section - Using Account Number
	@FindBy(xpath="//label[@for='idFrmStep2:idaccntType']") private WebElement lblAcctType;
	@FindBy(xpath="//select[@id='idFrmStep2:idaccntType']") private WebElement drpDwnAcctType;
	
	@FindBy(xpath="//label[@for='idFrmStep2:idAcctNum']") private WebElement lblAcctNum;
	@FindBy(xpath="//input[@id='idFrmStep2:idAcctNum']") private WebElement txtAcctNum;
	
	@FindBy(xpath="//label[@for='idFrmStep2:idCustIdType']") private WebElement lblIdType;
	@FindBy(xpath="//select[@id='idFrmStep2:idCustIdType']") private WebElement drpDownIdType;
	
	@FindBy(xpath="//label[@for='idFrmStep2:idCustIdNum']") private WebElement lblIdNum;
	@FindBy(xpath="//input[@id='idFrmStep2:idCustIdNum']") private WebElement txtIdNum;
	
	
	@FindBy(xpath="//label[@for='idFrmStep2:idRegTmpId']") private WebElement lblTempId;
	@FindBy(xpath="//input[@id='idFrmStep2:idRegTmpId']") private WebElement txtTempId;
	
	@FindBy(xpath="//label[@for='idcaptcha']") private WebElement lblCaptcha;
	@FindBy(xpath="//input[@id='idFrmStep2:idCaptcha']") private WebElement txtCaptcha;
	
	@FindBy(xpath="//input[@id='idFrmStep2:idBtnSubmitTempId2']") private WebElement btnNext;
	
	//Blank Field error messages
	@FindBy(xpath="//span[normalize-space()='Account Type is required']") private WebElement errMsgAcctType;
	@FindBy(xpath="//span[normalize-space()='Account Number is required']") private WebElement errMsgAcctNum;
	@FindBy(xpath="//span[normalize-space()='ID Type is required']") private WebElement errMsgIdType;
	@FindBy(xpath="//span[normalize-space()='ID Number is required']") private WebElement errMsgIDNum;;
	@FindBy(xpath="//span[normalize-space()='Temporary ID is required']") private WebElement errMsgTempId;
	@FindBy(xpath="//span[normalize-space()='Captcha is required']") private WebElement errMsgCaptcha;

	//Invalid Error Message
	@FindBy(xpath="//span[normalize-space()='Invalid Account Number format']") private WebElement errMsgInvalidAcctNum;
	@FindBy(xpath="//span[normalize-space()='Invalid Temporary ID format']") private WebElement errMsgInvalidTempId;;

	
	//S005 Enter Details Using an ATM Card
	@FindBy(xpath="//label[@for='idFrmStep2:idRegCardNum']") private WebElement lblCardNo;
	@FindBy(xpath="//input[@id='idFrmStep2:idRegCardNum']") private WebElement txtCardNo;

	@FindBy(xpath="//label[@for='idFrmStep2:idPin']") private WebElement lblCardPIN;
	@FindBy(xpath="//input[@id='idFrmStep2:idPin']") private WebElement txtCardPIN;

	// Remaining field - re-use from Account Number section
	
	@FindBy(xpath="//input[@id='idFrmStep2:idBtnSubmit']") private WebElement btnNextForATM;
	
	//S005 - error messages
	@FindBy(xpath="//span[normalize-space()='ATM Card is required']") private WebElement errMsgCardNo;
	@FindBy(xpath="//span[@id='idFrmStep2:idPinMsg']") private WebElement errMsgCardPIN;;

	@FindBy(xpath="//span[@class='text-danger']") private WebElement errMsgInvalidCardNo;

	
	public void verifyPageTitle() {
		String actVal=getText(txtPageTitle,"page Title");
		String expVal=MyConstants.RegisterForOnlineBankingPageTitle;
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
	
	public void verifyAcctNumOptionIsDisplayed(String expVal) {
		String actVal= getText(txtHeadingUsingAcctNum,"Account Number option");
		doAssertEqualsStrings(actVal, expVal,"Account Number option");
	}
	
	public void verifyATMOptionIsDisplayed(String expVal) {
		String actVal= getText(txtHeadingUsingATM,"ATM Card Option");
		doAssertEqualsStrings(actVal, expVal,"ATM Card Option");

	}
	
	public void clickOnProeedBtnForUsingAccountNumber() {
		doClick(btnProccedUsigAcctNum,"Procced button Under Using Account Number");
		
	}
	
	//TC02
	
	public void verifyAllLablesAndInputFieldsAreDisplayed() {
		
		boolean res = isDisplayed(lblAcctType,"") && isDisplayed(drpDwnAcctType,"") && isDisplayed(lblAcctNum,"") && 
				isDisplayed(txtAcctNum,"") && isDisplayed(lblIdType,"")&& isDisplayed(drpDownIdType,"") && 
				isDisplayed(lblIdNum,"") && isDisplayed(txtIdNum,"") && isDisplayed(lblTempId,"") && 
				isDisplayed(txtTempId,"") && isDisplayed(lblCaptcha,"") && isDisplayed(txtCaptcha,"");
		
		doAssertEqualsBoolean(res,true,"Registration Using Account Number - Enter Details Section");
	}
	
	public void verifyAccountTypeDropDownOptions(List<String> expValues) {
		
		Boolean res=false;
		Select dropdown = new Select(drpDwnAcctType);
		List<WebElement> actWebElements= dropdown.getOptions();
		List<String> actDropDownValues = new ArrayList<String>();
		
		System.out.println("Expected="+ expValues);

		
		for(WebElement e : actWebElements) {
			
			actDropDownValues.add(e.getText().trim());
		}
		
		System.out.println("Actual="+ actDropDownValues);
		
		if(actDropDownValues.equals(expValues)) {
			res=true;
		}
		
		doAssertEqualsBoolean(res,true,"Account Type Dropdown value verification, Actual Values="+actDropDownValues +"Expected values:"+ expValues);

	}
	
	public void verifyIDTypeDropDownValues(List<String> expValues) {
		
		Boolean res= false;
		Select dropdown = new Select(drpDownIdType);
		List<WebElement> actElements = dropdown.getOptions();
		System.out.println("Expected="+ expValues);
		
		List<String> actValues = new ArrayList<String>();
		
		for(WebElement e: actElements)
		{
			actValues.add(e.getText().trim());
		}
		
		if(actValues.equals(expValues)) {
			res=true;
		}
		
		doAssertEqualsBoolean(res,true,"ID Type drop down values:"+ actValues +"Expected="+expValues);
	}
	
	public void clickOnNextBtn() {
		doClick(btnNext, "Next button");
	}
	
	//TC05 , S005_TC03
	
	public void verifyBlankFieldErrorMessageForAcctType(String expVal) {
		String actVal=getText(errMsgAcctType,"Account Type field error message");
		doAssertEqualsStrings(actVal, expVal,"Account Type field error message");
		
	}
	
	public void verifyBlankFieldErrorMessageForAcctNum(String expVal) {
		String actVal=getText(errMsgAcctNum,"Account Number field error message");
		doAssertEqualsStrings(actVal, expVal,"Account Number field error message");
	}
	
	//S005_TC03
	public void verifyBlankFieldErrorMessageForIDType(String expVal) {
		String actVal=getText(errMsgIdType,"ID Type field error message");
		doAssertEqualsStrings(actVal, expVal,"ID Type field error message");
	}
	
	//S005_TC03
	public void verifyBlankFieldErrorMessageForIdNum(String expVal) {
		String actVal=getText(errMsgIDNum,"ID Number  field error message");
		doAssertEqualsStrings(actVal, expVal,"ID Number  field error message");
	}
	
	public void verifyBlankFieldErrorMessageForTempId(String expVal) {
		String actVal=getText(errMsgTempId,"Temporary ID  field error message");
		doAssertEqualsStrings(actVal, expVal,"Temporary ID  field error message");
	}
	
	//S005_TC03
	public void verifyBlankFieldErrorMessageForCaptcha(String expVal) {
		String actVal=getText(errMsgCaptcha,"Captcha  field error message");
		doAssertEqualsStrings(actVal, expVal,"Captcha  field error message");
	}
	
	// key in value
	public void keyInAccountNumber(String value) {
		doSendKeys(txtAcctNum,value,"Account Number");
		doClick(txtCaptcha,"Captch field");
	}
	
	public void keyInTemporaryID(String value) {
		doSendKeys(txtTempId,value,"Temporary ID");
		doClick(txtCaptcha,"Captch field");
	}
	
	public void verifyErrMsgForAcctNumField(String expVal) {
		String actVal= getText(errMsgInvalidAcctNum,"Invalid Account Number error message");
		doAssertEqualsStrings(actVal, expVal,"Invalid Account Number error message");
	}
	
	public void verifyErrMsgForTempIdField(String expVal) {
		String actVal= getText(errMsgInvalidTempId,"Invalid Temporary ID error message");
		doAssertEqualsStrings(actVal, expVal,"Invalid Temporary ID error message");

	}
	
	//S005
	public void clickOnProceedBtnUsingATMCard() {
		doClick(btnProceedUsingATM, "Proceed button using an ATM Card");
	}
	
	
	public void verifyAllLablesAndInputFieldsAreDisplayedForRegUsingATMCard() {
		
		boolean res = isDisplayed(lblCardNo,"") && isDisplayed(txtCardNo,"") && isDisplayed(lblCardPIN,"") && 
				isDisplayed(txtCardPIN,"") && isDisplayed(lblIdType,"")&& isDisplayed(drpDownIdType,"") && 
				isDisplayed(lblIdNum,"") && isDisplayed(txtIdNum,"") && isDisplayed(lblCaptcha,"") && isDisplayed(txtCaptcha,"");
		
		doAssertEqualsBoolean(res,true,"Registration Using an ATM Card - Enter Details Section");
	}
	
	//S005_TC03
	public void verifyBlankFieldErrMsgForCardNo(String expVal) {
		String actVal=getText(errMsgCardNo,"Error Message for Blank Card Number");
		doAssertEqualsStrings(actVal, expVal, "Error Message for Blank Card Number");

	}
	//S005_TC03
	public void verifyBlankFieldErrMsgForCardPIN(String expVal) {
		String actVal = getText(errMsgCardPIN, "Error Mesage for Blank Card PIN");
		doAssertEqualsStrings(actVal, expVal, "Error Mesage for Blank Card PIN");
	}
	
	public void keyInValueToCardNo(String value) {
		doSendKeys(txtCardNo,value, "Card No");
		doClick(txtCardPIN, "Card PIn field");
	}
	
	public void verifyErrorMessageForInvalidCardNumber(String expVal) {
		String actVal=getText(errMsgInvalidCardNo,"Error Message for Invalid Card Number");
		doAssertEqualsStrings(actVal, expVal, "Error Message for Invalid Card Number");
	}
	
	public void clickOnNextBtnForRegisterUsingATMCard() {
		doClick(btnNextForATM,"Next button");
	}
}
