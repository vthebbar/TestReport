package com.qa.pages;

import java.text.DecimalFormat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qa.utils.PropertyManager;
import com.qa.utils.TACManager;

public class SetDailyLimitVirtualCardPage extends BasePage {

	public SetDailyLimitVirtualCardPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//table/tbody/tr/td[count(//table/thead/tr/th/label[text()='LIMIT TYPE']/parent::th/preceding-sibling::th)+1]")
	private WebElement txtLimitType;
	@FindBy(xpath = "//table/tbody/tr/td[count(//table/thead/tr/th/label[text()='MAX DAILY LIMIT (USD)']/parent::th/preceding-sibling::th)+1]")
	private WebElement txtMaxDailyLimit;
	@FindBy(xpath = "//table/tbody/tr/td[count(//table/thead/tr/th/label[text()='CURRENT DAILY LIMIT (USD)']/parent::th/preceding-sibling::th)+1]")
	private WebElement txtCurrentDailyLimit;
	@FindBy(xpath = "//table/tbody/tr/td[count(//table/thead/tr/th/label[text()='NEW DAILY LIMIT (USD)']/parent::th/preceding-sibling::th)+1]")
	private WebElement txtNewDailyLimit;
	
	@FindBy(id="idNewlimitAmt") private WebElement txtNewLimit;
	@FindBy(id="idBtnNext") private WebElement btnNext;
	
	
	@FindBy(xpath="//input[@id='idFormCfmAckDtl:idTACAdd']") private WebElement txtTac;
	@FindBy(xpath="//input[@id='idFormCfmAckDtl:idBtnConfirm']") private WebElement btnSubmit;
	
	@FindBy(xpath="//li[@class='success-msg']") private WebElement lblresposneMsg;
	@FindBy(xpath="//label[normalize-space()='Debit Card']/following-sibling::span") private WebElement txtDebitCard;
	@FindBy(xpath="//label[normalize-space()='New Limit']/following-sibling::span") private WebElement txtNewLimitResult;
	@FindBy(xpath="//input[@name='idFormCfmAckDtl:j_idt246']") private WebElement btnDone;
	@FindBy(xpath="//li[@class='error-msg']") private WebElement errMsg;
	
	
	public void verifySetDailyLimitScreenEnterDetailsSectionFields() {
		
		boolean res = isDisplayed(txtLimitType,"") && isDisplayed(txtMaxDailyLimit,"") && isDisplayed(txtCurrentDailyLimit,"") && isDisplayed(txtNewDailyLimit, "");
		doAssertEqualsBoolean(res,true, "Set Daily Limit Screen fields are displayed ?");
	}
	
	public void KeyInNewLimit() {
		
		String currLimit = getText(txtCurrentDailyLimit, "Current Daily Limit");
		currLimit=currLimit.replace(",", "");
		String currLimitArr[]=currLimit.split("\\.");
		
		int curLimit = Integer.parseInt(currLimitArr[0]);
		double newLimit =  curLimit+1+Math.random();
		DecimalFormat format = new DecimalFormat("#0.00");
		String newLimitFinal=format.format(newLimit);
		doSendKeys(txtNewLimit,newLimitFinal, "New Limit Value");
		
		doClick(txtLimitType, "");
	}
	
	public void clickOnNextbtn() {
		try {
		doClick(btnNext, "Next button");
		}
		catch(Exception e) {
			doClick(btnNext, "Next button");
		}
	}
	
	public void KeyInTac() {
		String userName = PropertyManager.propertyLoader().getProperty("userName");
		TACManager tacManager = new TACManager();
		String tac =tacManager.getTacCode(driver, userName);
		doSendKeys(txtTac, tac, "TAC value");
	}
	
	public void clickOnSubmitBtn() {
		doClick(btnSubmit, "Submit button");
	}
	
	public void verifyResponseMsg(String expMsg) {
		String actMsg = getText(lblresposneMsg, "Response Message");
		doAssertEqualsStrings(actMsg, expMsg,"Limit Setup response message");
	}
	
	public void verifyLimitSetupResultDetails() {
		
		boolean res = isDisplayed(txtDebitCard,"") && isDisplayed(txtNewLimitResult,"");
		doAssertEqualsBoolean(res, true, "Response Details for Limit Setup");
	}
	
	public HomePage clickOnDoneBtn() {
		doClick(btnDone, "Done button");
		return new HomePage(driver);
	}
	
	public void keyInNewLimitValue(String newLimit) {
		doSendKeys(txtNewLimit,newLimit,"New Limit Value");
		doClick(txtLimitType, "");
	}
	
	public void verifyErrMsg(String expVal) {
		String actVal = getText(errMsg, "Error message");
		doAssertEqualsStrings(actVal, expVal, "Error message for Invalid Limit entry");
	}
	
	public void KeyInInvalidTacVal(String tac) {
		doSendKeys(txtTac,tac, "Invlaid TAC");
	}
}
