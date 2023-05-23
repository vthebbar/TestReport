package com.qa.pages;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qa.utils.PropertyManager;
import com.qa.utils.TACManager;

public class ESaverCreateAccountPage  extends BasePage {

	public ESaverCreateAccountPage(WebDriver driver) {
		super(driver);
	}
	
	
	//***** Enter details section ****
	@FindBy(xpath="//label[@for='idPAccountName']//following-sibling::span/input") private WebElement txtAccountName;
	@FindBy(xpath="//label[@for='idSOMTransferFrom']/following-sibling::span/select") private WebElement dropDownDebitingAcct;
	
	@FindBy(xpath="//label[@for='idAmt']/following-sibling::span/input") private WebElement txtAmtUSDKHR;
	
	
	@FindBy(xpath="//label[@for='idDesc']/following-sibling::span/input") private WebElement txtDesc;
	
	@FindBy(xpath="//input[@id='j_idt217']") private WebElement checkBoxProdTermSheet;
	@FindBy(xpath="//input[@id='j_idt225']") private WebElement checkBoxTnC;
	@FindBy(id="idBtnSubmit") private WebElement btnNext;
	
	//error message
	@FindBy(xpath="//li[@class='error-msg']") private WebElement txtErrMsg;
	@FindBy(xpath="//span[@class='text-danger']") private WebElement txtAcctNameErrMsg;
	
	//****** Confirm Details section *****
	@FindBy(xpath="//label[normalize-space()='Account Name']/following-sibling::span") private WebElement txtAcctNameConfirm;
	
	@FindBy(xpath="//label[normalize-space()='Debiting Account']/following-sibling::span") private WebElement txtDebitAcctConfirm;
	@FindBy(xpath="//label[normalize-space()='Amount (USD)']/following-sibling::span") private WebElement txtAmtUSDConfirm;
	@FindBy(xpath="//label[normalize-space()='Amount (KHR)']/following-sibling::span") private WebElement txtAmtKHRCOnfirm;
	
	@FindBy(xpath="//label[@for='idFormCfmAckDtl:idTACAdd']") private WebElement lblEnterTac;

	@FindBy(xpath="//input[@id='idFormCfmAckDtl:idTACAdd']") private WebElement txtTAC;
	@FindBy(xpath="//input[@id='idFormCfmAckDtl:idBtnConfirm']") private WebElement btnSubmit;
	
	
	// **** Acknowledgement section **
	
	@FindBy(xpath="//div[@class='success-msg']") private WebElement txtMsgSuccess;
	@FindBy(xpath="//label[normalize-space()='Reference Number']/following-sibling::span") private WebElement txtRefNumAck;
	@FindBy(xpath="//label[normalize-space()='Transaction Date, Time']/following-sibling::span") private WebElement txtTranDateAck;
	@FindBy(xpath="//label[normalize-space()='E-Saver Account No.']/following-sibling::span") private WebElement txtEsaverAcctNumAck;
	@FindBy(xpath="//label[normalize-space()='Account Name']/following-sibling::span") private WebElement txtAcctNameAck;
	@FindBy(xpath="//label[normalize-space()='Debiting Account']/following-sibling::span") private WebElement txtDebitAcctAck;
	
	@FindBy(xpath="//label[normalize-space()='Amount (USD)']/following-sibling::span") private WebElement txtAmtUSDAck;
	@FindBy(xpath="//label[normalize-space()='Amount (KHR)']/following-sibling::span") private WebElement txtAmtKHRAck;

	@FindBy(xpath="//label[normalize-space()='Transaction Status']/following-sibling::span") private WebElement txtTranStatusAck;
	
	@FindBy(xpath="//label[normalize-space()='Balance After Transfer (USD)']/following-sibling::span") private WebElement txtBalanceAfterTranUSDAck;
	@FindBy(xpath="//label[normalize-space()='Balance After Transfer (KHR)']/following-sibling::span") private WebElement txtBalanceAfterTranKHRAck;

	@FindBy(xpath="//input[@value='Done']") private WebElement btnDone;
	
	
	
	public void verifyEnterDetailsSectionElementsAreDisplayed() {
		
		boolean flag=false;
		
		flag = isDisplayed(txtAccountName,"") && isDisplayed(dropDownDebitingAcct,"") &&isDisplayed(txtAmtUSDKHR,"") && isDisplayed(txtDesc,"") &&
				isDisplayed(checkBoxProdTermSheet,"") && isDisplayed(checkBoxTnC,"") &&isDisplayed(btnNext,"")  ;
		
		doAssertEqualsBoolean(flag, true, "All fields displayed ?");
	}
	
	public void keyInAcctName(String acctName) {
		doSendKeys(txtAccountName,acctName,"Account name");
	}
	
	public void selectDebitingAcct(String value) {
		
		selectDropDownByValue(dropDownDebitingAcct, value);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void keyInAmount(String amt) {
		doSendKeys(txtAmtUSDKHR, amt, "Amount");
	}
	
	public void keyInDesc(String desc) {
		doSendKeys(txtDesc, desc, "Amount");

	}
	
	public void selectTermSheetCheckbkx() {
		doClick(checkBoxProdTermSheet, "Product Term Sheet checkbox");
	}
	
	public void selectTnCCheckbox() {
		doClick(checkBoxTnC, "Terms and Conditions checkbox");

	}
	
	public void clickOnNextBtn() {
		try {
			Thread.sleep(2000);
			doClick(btnNext, "Next button");
		}
		catch(Exception e) {
			doClick(btnNext, "Next button");

		}
	}
	
	public void verifyErrMsg(String expMsg) {
		
		String actMsg=getText(txtErrMsg, "error mesage");
		doAssertEqualsStrings(actMsg, expMsg, "Esaver value less than 100 USd error message");
	}
	
	public void verifyNoInputForFieldsErrMsg(String expMsg) {
		
		String actMsg=getText(txtAcctNameErrMsg, "Blank Input field error mesage");
		doAssertEqualsStrings(actMsg, expMsg, "Blank Input field error message");
	}
	
	
	public void verifyConfirmDetailsSection(){
		boolean flag1=false;
		
		flag1 = isDisplayed(txtAcctNameConfirm,"") && isDisplayed(txtDebitAcctConfirm,"") &&isDisplayed(lblEnterTac,"") && isDisplayed(txtTAC,"") &&
				isDisplayed(btnSubmit,"")  ;
		
		boolean flag2 =txtAmtUSDConfirm.isDisplayed() || txtAmtKHRCOnfirm.isDisplayed() ;
		
		boolean flag3 = flag1 && flag2;
		
		doAssertEqualsBoolean(flag3, true, "All fields displayed in Confirm Details section?");
	}
	
	public void keyInInvalidTac(String invaldiTac) {
		doSendKeys(txtTAC,invaldiTac, "Invaldi TAC" );
	}
	
	public void clickOnSubmitBtn() {
		doClick(btnSubmit, "Submit button");
	}
	
	public void keyInValidTac() {
		
		String userName = PropertyManager.propertyLoader().getProperty("userName");
		TACManager tacManager = new TACManager();
		String tac = tacManager.getTacCode(driver, userName);
		doSendKeys(txtTAC, tac, "TAC code");
	}
	
	public void verifySuccessMsg(String expVal) {
		String actVal = getText(txtMsgSuccess, "Success Mesage");
		doAssertEqualsStrings(actVal, expVal, "success message");
	}
	
	public void verifyActknowledgementSection() {
       boolean flag1=false;
		
		flag1 = isDisplayed(txtMsgSuccess,"") && isDisplayed(txtRefNumAck,"") &&isDisplayed(txtTranDateAck,"") && isDisplayed(txtEsaverAcctNumAck,"") &&
				isDisplayed(txtAcctNameAck,"")  && isDisplayed(txtDebitAcctAck,"") && isDisplayed(txtTranStatusAck,"") ;
		
		boolean flag2 =txtAmtUSDAck.isDisplayed() || txtAmtKHRAck.isDisplayed() ;
		
		boolean flag3 =txtBalanceAfterTranUSDAck.isDisplayed() || txtBalanceAfterTranKHRAck.isDisplayed() ;

		
		boolean flag4 = flag1 && flag2 && flag3;
		
		doAssertEqualsBoolean(flag4, true, "All fields displayed in Acknowledgement  section?");
	}
	
	public void clickOnDoneBtn() {
		doClick(btnDone, "Done button");
	}
}
