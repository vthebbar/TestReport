package com.qa.pages;

import java.text.DecimalFormat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qa.utils.PropertyManager;
import com.qa.utils.TACManager;

public class SetDailyLimitPage  extends BasePage {

	public SetDailyLimitPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//tbody/tr[1]/td[3]") private WebElement txtCurrentPurchaseLimit;
	@FindBy(xpath="//tbody/tr[1]/td[3]") private WebElement txtCurrentWithdrawlLimit;
	
	@FindBy(xpath="//input[@id='j_idt212']") private WebElement txtNewPurchaseLimit;
	@FindBy(xpath="//input[@id='j_idt220']") private WebElement txtNewWithdrawlLimit;


	@FindBy(id="idBtnSubmit") private WebElement btnNext;
	
	
	@FindBy(xpath="//input[@id='idFormCfmAckDtl:idTACAdd']") private WebElement txtTac;
	@FindBy(xpath="//input[@id='idFormCfmAckDtl:idBtnConfirmTrsf']") private WebElement btnSubmit;
	@FindBy(xpath="//li[@class='success-msg']") private WebElement msgSuccess;
	
	@FindBy(xpath="//li[@class='error-msg']") private WebElement errMsg;
	
	public void keyInValidPurchaseLimit() {
		
		
		String currentPurchaseLimit[] = getText(txtCurrentPurchaseLimit, "Current Purchase Limit").replace(",", "").split("\\.");
		
		int cplimit = Integer.parseInt(currentPurchaseLimit[0]);
		double newPLimit = cplimit + Math.random()+1;
		 DecimalFormat decimalFormat = new DecimalFormat("#0.00");

		String newPurchaseLimit=String.valueOf(decimalFormat.format(newPLimit));
		
		
		doSendKeys(txtNewPurchaseLimit, newPurchaseLimit, "New Purchase Limit" );
		
	}
	
	public void keyInNewWithDrawlLimit() {
		
		String currWithDrawlLimit[] = getText(txtCurrentWithdrawlLimit, "Current WithDrawl Limit").replace(",", "").split("\\.");
		
		double newWLimit = Integer.parseInt(currWithDrawlLimit[0]) + Math.random()+1;
		DecimalFormat decimalFormat = new DecimalFormat("#0.00");
		
		String newWithdrawalLimit = String.valueOf(decimalFormat.format(newWLimit));
		
		
		doSendKeys(txtNewWithdrawlLimit,newWithdrawalLimit,"New Withdrawal Limit" );
	}
	
	public void clickOnNextbtn() {
		try {
		doClick(btnNext, "Next button");
		}
		catch(Exception e) {
			doClick(btnNext, "Next button");
		}
	}
	
	public void keyInTac() {
		
		String userName = PropertyManager.propertyLoader().getProperty("userName");
		TACManager tacManager = new TACManager();
		String tac = tacManager.getTacCode(driver, userName);
		
		doSendKeys(txtTac, tac, "TAC");
	}
	
	public void clickOnSubmitBtn() {
		
		doClick(btnSubmit, "Submit button");
	}
	
	public void verifyResult(String expMsg) {
		
		String actMsg = getText(msgSuccess, "Success message");
		doAssertEqualsStrings(actMsg, expMsg, "Result message");
	}
	
	public void keyInPurchaseLimit(String pLimit) {
		doSendKeys(txtNewPurchaseLimit,pLimit,"Purchase Limit");
	}
	
	public void keyInWithdrawlLimit(String wLimit) {
		doSendKeys(txtNewWithdrawlLimit,wLimit,"Withdrawal Limit");

	}
	
	public void focusOnWithdrawalLimitBox() {
		doClick(txtNewWithdrawlLimit,"");
	}
	
	public void focusOnPurchaseLimitBox() {
		doClick(txtNewPurchaseLimit,"");
	}
	
	public void verifyErrorMsg(String expMsg) {
		String actMsg = getText(errMsg,"Error message");
		doAssertEqualsStrings(actMsg, expMsg, "Error message");
		
	}
	
	public void keyInInvalidTac(String inValidTac) {
		doSendKeys(txtTac,inValidTac," TAC Entry - Invalid");

	}
}
