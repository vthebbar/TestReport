package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qa.utils.PropertyManager;
import com.qa.utils.TACManager;

public class ResetPinPage extends BasePage {

	public ResetPinPage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(id="idPin") private WebElement txtNewPin;
	@FindBy(id="idCfrmNewPin") private WebElement txtConfirmPin;
	@FindBy(id="idBtnNext") private WebElement btnNext;
	@FindBy(xpath="//input[@id='idFormCfmAckDtl:idTACAdd']") private WebElement txtTac;
	@FindBy(xpath="//input[@name='idFormCfmAckDtl:j_idt253']") private WebElement btnConfirm;
	@FindBy(xpath="//li[@class='success-msg']") private WebElement lblResultMsg;
	@FindBy(xpath="//label[normalize-space()='Debit Card']/following-sibling::span") private WebElement txtDebitCard;
	@FindBy(xpath="//label[normalize-space()='PIN Status']/following-sibling::span") private WebElement txtPinStatus;
	@FindBy(xpath="//input[@name='idFormCfmAckDtl:j_idt255']") private WebElement btnDone;
	
	@FindBy(xpath="//li[@class='error-msg']") private WebElement lblErrorMsgTac;
	@FindBy(xpath="//li[@class='error-msg mb-0']") private WebElement lblErrMsgPin;
	
	public void keyInNewPin(String newPin) {
		
		doSendKeys(txtNewPin,newPin, "New Pin");
	}
	
	public void keyInConfirmPin(String confirmPin) {
		
		doSendKeys(txtConfirmPin,confirmPin, "Confirm New Pin");

	}
	
	public void clickOnNextbtn() {
		
		doClick(btnNext, "Next button");
	}
	
	public void keyInTac() {
		String userName = PropertyManager.propertyLoader().getProperty("userName");
		TACManager tacManager = new TACManager();
		String tacCode = tacManager.getTacCode(driver, userName);
		
		doSendKeys(txtTac, tacCode, "TAC code");
	}
	
	public void clickOnConfirmBtn() {
		doClick(btnConfirm, "Confirm button");
	}
	
	public void verifyResultMessage(String expMsg) {
		String actMsg = getText(lblResultMsg, "Result message");
		doAssertEqualsStrings(actMsg, expMsg, "Result");
	}
	
	public void verifyDebitCardAndPinStatusAreDisplayed() {
		boolean res = isDisplayed(txtDebitCard, "Debit Card") && isDisplayed(txtPinStatus, "PIN Status");

		doAssertEqualsBoolean(res, true, "Debit Card and Pin Status are displayed ?");
		
	}
	
	public void clickOnDoneBtn() {
		doClick(btnDone, "Done button");
	}
	
	public void KeyInInvalidTac(String inValidTac) {
		doSendKeys(txtTac,inValidTac, "Invlaid TAC");
	}
	
	
	public void verifyErrorMsgTac(String expVal) {
		String actVal = getText(lblErrorMsgTac, "Error message TAC");
		doAssertEqualsStrings(actVal, expVal, "Error message TAC");
		
	}
	
	public void verifyErrorMsgPin(String expVal) {
		String actVal = getText(lblErrMsgPin, "Error message PIN");
		doAssertEqualsStrings(actVal, expVal, "Error message PIN");
		
	}
}
