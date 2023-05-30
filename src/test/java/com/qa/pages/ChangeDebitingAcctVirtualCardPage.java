package com.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ChangeDebitingAcctVirtualCardPage extends BasePage {

	public ChangeDebitingAcctVirtualCardPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//label[@for='idVirtualCard']/following-sibling::span/child::select") private WebElement txtDebitCardNumber;
	@FindBy(xpath="//label[normalize-space()='Current Debiting Account']/following-sibling::span") private WebElement txtCurrentDebitAccount;
	@FindBy(xpath="//label[@for='idAccountToLink']/following-sibling::span/child::select") private WebElement drpDownNewDebitAccount;
	@FindBy(xpath="//input[@id='idBtnNext']") private WebElement btnNext;
	@FindBy(css="form[id='idFormEntry'] li[class='error-msg']") private WebElement errMsg;
	
	@FindBy(xpath="//input[@id='idFormCfmAckDtl:idPswd']") private WebElement txtPwd;
	@FindBy(xpath="//input[@id='idFormCfmAckDtl:idBtnConfirm']") private WebElement btnSubmit;
	
	//Response
	@FindBy(xpath="//li[@class='success-msg']") private WebElement responseMsg;
	@FindBy(xpath="//label[normalize-space()='Debit Card']/following-sibling::span") private WebElement txtDebitCard;
	@FindBy(xpath="//label[normalize-space()='New Debiting Account']/following-sibling::span") private WebElement txtNewDebitAcct;
	@FindBy(xpath="//input[@name='idFormCfmAckDtl:j_idt231']") private WebElement btnDone;
	
	
	@FindBy(xpath="//li[@class='error-msg']") private WebElement txtIncorrectPwdErrMsg;
	
	public void verifyChangeDebitAcctEnterDetailsScreen() {
		
		boolean res=isDisplayed(txtDebitCardNumber,"") && isDisplayed(txtCurrentDebitAccount,"") && isDisplayed(drpDownNewDebitAccount,"") && isDisplayed(btnNext,"");
		doAssertEqualsBoolean(res,true, "Details are displayed in Change Debiting Account - Enter Details Section ?");
	}
	
	public void selectNewDebitAcct() {
		
		 Select s = new Select(drpDownNewDebitAccount);
		 List<WebElement> droDownElements = s.getOptions();
		 
		 selectDropDownyIndex(drpDownNewDebitAccount,droDownElements.size()-1);
		 doClick(btnNext, "Next button");
		
		 
		 
		 if(driver.findElements(By.cssSelector("form[id='idFormEntry'] li[class='error-msg']")).size()>0) {
		  
		
		 
			 selectDropDownyIndex(drpDownNewDebitAccount,droDownElements.size()-2);
			 doClick(btnNext, "Next button");
		 }
		 
	}
	
	public void keyInHLBConnectPwd(String pwd) {
		
		doSendKeys(txtPwd, pwd, "HLB Connect password");
	}
	
	public void clickOnSubmitBtn() {
		doClick(btnSubmit, "Submit button");
	}
	
	public void verifyResponseMsg(String expMsg) {
		
		String actMsg = getText(responseMsg, "Response Message");
		doAssertEqualsStrings(actMsg, expMsg, "Response Message");
	}
	
	public void verifyResponsePageElementsAreDisplayed() {
		boolean res = isDisplayed(txtDebitCard,"") && isDisplayed(txtNewDebitAcct,"");
		doAssertEqualsBoolean(res, true,"Debit Card and Debiting Account are displayed ?");
 	}
	
	public void clickOnDoneBtn() {
		
		doClick(btnDone,"Done button");
	}
	
	public void verifyErrMsg(String expMsg) {
		
		String actMsg = getText(txtIncorrectPwdErrMsg,"Error message");
		doAssertEqualsStrings(actMsg, expMsg, "Error message");
	}
}
