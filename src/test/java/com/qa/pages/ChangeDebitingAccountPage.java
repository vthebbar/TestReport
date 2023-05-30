package com.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.qa.utils.PropertyManager;

public class ChangeDebitingAccountPage extends BasePage {

	public ChangeDebitingAccountPage(WebDriver driver) {
		super(driver);
	}

	// **** Details entry section ***
	
	@FindBy(xpath="//label[text()='Debit Card']/following-sibling::span") private WebElement txtDebitCard;
	@FindBy(xpath="//label[text()='Current Debiting Account']/following-sibling::span") private WebElement txtCurrentDebitingAcct;
	@FindBy(xpath="//label[text()='New Debiting Account']/following-sibling::span/select") private WebElement drpDownNewDebitAcct;
	@FindBy(id="idBtnSubmit") private WebElement btnNext;
	
	
	@FindBy(xpath="//li[@class='error-msg']") private WebElement txtErrMsg;
	
	
	//**** Confirmation section
	@FindBy(xpath="//label[normalize-space()='HLB Connect Password']") private WebElement lblPwd;
	@FindBy(xpath="//input[@id='idFormCfmAckDtl:idPswd']") private WebElement txtHLBCPwd;
	@FindBy(xpath="//label[text()='Debit Card']/following-sibling::span") private WebElement txtDebitCardConfirm;
	@FindBy(xpath="//label[text()='New Debiting Account']/following-sibling::span") private WebElement txtNewDebitAcctConfirm;
	@FindBy(xpath="//a[text()='Back']") private WebElement btnBack;	
	@FindBy(xpath="//input[@value='Submit']") private WebElement btnSubmit;

	//**** Acknowledgement section
	
	@FindBy(xpath="//li[@class='success-msg']") private WebElement txtSuccessMsg;
	@FindBy(xpath="//label[text()='Debit Card']/following-sibling::span") private WebElement txtDebitCardAck;
	@FindBy(xpath="//label[text()='New Debiting Account']/following-sibling::span") private WebElement txtNewDebitAcctAck;
	
	@FindBy(xpath="//input[@value='Done']") private WebElement btnDone;
	
	
	public void clickOnNextBtn() {
		
		doClick(btnNext, "Next button");
	}
	
	public void selectNewDebitAcct() {
		
		Select s = new Select(drpDownNewDebitAcct);
		List<WebElement> options = s.getOptions();
		s.selectByIndex(options.size()-1);
		
		doClick(btnNext, "Next button");
		
		if(driver.findElements(By.xpath("//li[@class='error-msg']")).size()>0)
		{
			s.selectByIndex(options.size()-2);
			doClick(btnNext, "Next button");

		}

	}
	
	public void keyInPassword() {
		
		String password = PropertyManager.propertyLoader().getProperty("password");
		doSendKeys(txtHLBCPwd, password, "HLB Connect Password");
	}
	
	public void clickOnSubmitBtn() {
		doClick(btnSubmit, "Submit button");
	}
	
	public void verifySuccessMsg(String expMsg) {
		String actMsg = getText(txtSuccessMsg, "Success Mesage");
		doAssertEqualsStrings(actMsg, expMsg, "Success Mesage");
	}
	
	public void keyInInvalidPassword(String InvalidPwd) {
		
		doSendKeys(txtHLBCPwd, InvalidPwd, "HLB Connect Invalid Password");

	}
	
	public void verifyErrorMsg(String expMsg) {
		
		String actMsg = getText(txtErrMsg, "Error Message");
		doAssertEqualsStrings(expMsg, actMsg, "Error message");
	}
	
	
	public void verifyDetailsEntrySection() {
		
		boolean flag=false;
		
		flag = isDisplayed(txtDebitCard,"") && isDisplayed(txtCurrentDebitingAcct,"") && isDisplayed(drpDownNewDebitAcct,"") && isDisplayed(btnNext,"");
		doAssertEqualsBoolean(flag, true, "Enter details section elements displayed?");
	}
	
	
	public void verifyConfirmDetailsSection() {
		
		boolean flag=false;
		
		flag = isDisplayed(lblPwd,"") && isDisplayed(txtHLBCPwd,"") && isDisplayed(txtDebitCardConfirm,"") && isDisplayed(txtNewDebitAcctConfirm,"")
				&& isDisplayed(btnBack,"") && isDisplayed(btnSubmit,"");
		doAssertEqualsBoolean(flag, true, "Confirm details section elements displayed?");
	}
	
	public void verifyAcknowledgenebtDetialsSection() {
		
		boolean flag=false;
		
		flag = isDisplayed(txtSuccessMsg,"") && isDisplayed(txtDebitCardAck,"") && isDisplayed(txtNewDebitAcctAck,"") && isDisplayed(btnDone,"");
		doAssertEqualsBoolean(flag, true, "Acknowledgement details section elements displayed?");
	}
	
	public void clickOnDoneBtn() {
		doClick(btnDone, "Done button");
	}
}
