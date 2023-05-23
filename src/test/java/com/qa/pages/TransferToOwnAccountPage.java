package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TransferToOwnAccountPage extends BasePage {

	public TransferToOwnAccountPage(WebDriver driver) {
		super(driver);
		
	}
	
	//*****Enter Details Section
	@FindBy(xpath="//select[@id='idFormEntry:idSOMTransferFrom']") private WebElement dropDownFrom;
	@FindBy(xpath="//select[@id='idFormEntry:idSOMTransferTo']") private WebElement dropDownTo;
	@FindBy(xpath="//label[@for='idFormEntry:idAmt']/parent::span/following-sibling::span/input") private WebElement txtAmtUSD;
	@FindBy(xpath="//label[normalize-space()='Equivalent Amount']") private WebElement lblEquivalemtAmt;
	@FindBy(xpath="//label[@for='idFormEntry:idDesc']/following-sibling::span/input") private WebElement txtDescription;
	@FindBy(xpath="//label[@class='col-3 text-end fw-semibold']") private WebElement lblWhenToTransfer;
	@FindBy(xpath="//input[@id='idFormEntry:idRecur:0']") private WebElement radioOneTimeTransfer;
	@FindBy(xpath="//input[@id='idFormEntry:idRecur:1']") private WebElement radioRecurringTransfer;
	
	@FindBy(xpath="//input[@id='idFormEntry:idRecurringDate']") private WebElement calendarDate;
	@FindBy(xpath="//select[@class='ui-datepicker-month']") private WebElement calendarMonthDropDown;
	@FindBy(xpath="//select[@class='ui-datepicker-year']") private WebElement calendarYearDropDown;

	
	@FindBy(xpath="//input[@id='idFormEntry:idBtnSubmit']") private WebElement btnNext;
	
	@FindBy(xpath="//label[text()='TRANSFER DETAILS']") private WebElement lblTransferDetailsSecHeader;
	
	       //Recurring transfer options
	@FindBy(xpath="//label[normalize-space()='Starting From']/parent::div/following-sibling::div/input") private WebElement dateStartingFrom;
	@FindBy(xpath="//label[normalize-space()='Repeat']/parent::div/following-sibling::div/select") private WebElement drpDowmRepeatFreq;
	@FindBy(xpath="//input[@id='Occurrence']") private WebElement txtNumberOfTimes;
	
	//Error messages
	@FindBy(xpath="//span[@class='text-danger']") private WebElement txtErrorMsg;
	
	
	// ******Confirm Details Section
	@FindBy(xpath="//label[normalize-space()='From']/following-sibling::span") private WebElement txtFrom;
	@FindBy(xpath="//label[normalize-space()='To']/following-sibling::span") private WebElement txtTo;
	@FindBy(xpath="//label[normalize-space()='Amount (USD)']/following-sibling::span") private WebElement txtAmt;
	@FindBy(xpath="//label[normalize-space()='Equivalent Amount (USD)']/following-sibling::span") private WebElement txtEquivalentAmt;
	@FindBy(xpath="//label[normalize-space()='Description']/following-sibling::span") private WebElement txtDesc;
	@FindBy(xpath="//label[normalize-space()='When to Transfer']/following-sibling::span") private WebElement txtWhenToTransfer;
	@FindBy(xpath="//input[@id='idFormCfmAckDtl:idBtnConfirm']") private WebElement btnSubmit;

	//*****Acknowledgement section
	@FindBy(xpath="//li[@class='success-msg']") private WebElement txtAcknowledgementMsg;
	@FindBy(xpath="//label[normalize-space()='Reference Number']/following-sibling::span") private WebElement txtRefNum;
	@FindBy(xpath="//label[normalize-space()='Transaction Status']/following-sibling::span") private WebElement txtTransactionStatus;
	@FindBy(xpath="//label[normalize-space()='Transaction Date, Time']/following-sibling::span") private WebElement txtTranDateTime;
	@FindBy(xpath="//label[normalize-space()='From']/following-sibling::span") private WebElement txtFromAckn;
	@FindBy(xpath="//label[normalize-space()='To']/following-sibling::span") private WebElement txtToAck;
	@FindBy(xpath="//label[normalize-space()='Amount (USD)']/following-sibling::span") private WebElement txtAmount;
	@FindBy(xpath="//label[normalize-space()='Equivalent Amount (USD)']/following-sibling::span") private WebElement txtEquivalentAmtAck;
	@FindBy(xpath="//label[normalize-space()='Description']/following-sibling::span") private WebElement txtDescriptionAck;
	@FindBy(xpath="//label[normalize-space()='When to Transfer']/following-sibling::span") private WebElement txtWhenToTransferAck;
	@FindBy(xpath="//input[@name='idFormCfmAckDtl:j_idt310']") private WebElement btnMakeAnotherTransfer;
	@FindBy(xpath="//input[@name='idFormCfmAckDtl:j_idt311']") private WebElement btnDone;

	//For Recurring
	@FindBy(xpath="//label[normalize-space()='Transaction Date, Time']/following-sibling::label") private WebElement txtTranDateTimeRecurring;
	
	
	
	
	public void seletFromDropDown(String visibleText) {
		selectValueFromDropDowm(dropDownFrom, visibleText);
	}
	
	public void selectToDropDown(String visibleText) {
		selectValueFromDropDowm(dropDownTo, visibleText);
	}
	
	public void verifyTransferToOwnAccountEnterDetailsSection() {
		boolean res = false;
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		try {
		 res =  isDisplayed(txtAmtUSD,"")
					&& isDisplayed(lblEquivalemtAmt,"") && isDisplayed(txtDescription,"") && isDisplayed(lblWhenToTransfer,"") &&
					isDisplayed(radioOneTimeTransfer,"") && isDisplayed(radioRecurringTransfer,"") && 
					isDisplayed(calendarDate,"") && isDisplayed(btnNext,"");
		}
		catch (Exception e){
			res =  isDisplayed(txtAmtUSD,"")
					&& isDisplayed(lblEquivalemtAmt,"") && isDisplayed(txtDescription,"") && isDisplayed(lblWhenToTransfer,"") &&
					isDisplayed(radioOneTimeTransfer,"") && isDisplayed(radioRecurringTransfer,"") && 
					isDisplayed(calendarDate,"") && isDisplayed(btnNext,"");
		}
		doAssertEqualsBoolean(res, true, "Transfer to Own Account - Enter Details Section fields displayed ?");
	}
	
	//S014_TC02
	public void keyInAmount(String amt) {
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		doSendKeys(txtAmtUSD, amt, "Amount");
		doClick(lblTransferDetailsSecHeader,"");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	
	
		
	}
	
	public void keyInDesc(String desc) {
		try {
			Thread.sleep(2000);
		doSendKeys(txtDescription,desc, "Own Account Transfer");
		Thread.sleep(2000);
		}
		catch(Exception e) {
			//doSendKeys(txtDescription,desc, "Own Account Transfer");
		}
	}
	
	public void selectOneTimeTransferRadioBtn() {
		doClick(radioOneTimeTransfer,"One Tine Transfer");
	}
	
	public void selectRecurringTransferRadioBtn() {
		doClick(radioRecurringTransfer,"Recurring Transfer");
		try {
			Thread.sleep(2000);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void keyInDate(String date) {
		
		try {
			Thread.sleep(2000);
		doSendKeys(calendarDate,date, "");
		Thread.sleep(2000);
		}
		catch(Exception e) {
			//doSendKeys(calendarDate,date, "");
		}
	}
	
	public void clickOnNextBtn() {
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		doClick(btnNext, "Next button");
	}
	
	public void verifyConfirmDetailsSectionElementsAreDisplayed() {
		
		boolean res = isDisplayed(txtFrom,"") && isDisplayed(txtTo, "") && isDisplayed(txtAmt,"")
						&& isDisplayed(txtEquivalentAmt,"") 
						&& isDisplayed(txtDesc,"") && isDisplayed(txtWhenToTransfer,"") && isDisplayed(btnSubmit,"");
		
		doAssertEqualsBoolean(res, true, "Transfer to Own Account - Confirm Details Section fields displayed");
		
	}
	
	public void clickOnSubmitBtn() {
		
		doClick(btnSubmit, "Submit button");
	}
	
	public void verifyAcknowledgmentMessage(String expMsg) {
		String actMsg = getText(txtAcknowledgementMsg, "Acknowledgement message");
		doAssertEqualsStrings(actMsg, expMsg, "Acknowledgment message");
		
	}
	
	public void verifyAcknowledgementDetailsAreDisplayed() {
		
		boolean flag = false;
		
		flag = isDisplayed(txtAcknowledgementMsg,"") && isDisplayed(txtRefNum,"") && isDisplayed(txtTransactionStatus,"")
				&& isDisplayed(txtTranDateTime,"") && isDisplayed(txtFromAckn,"") && isDisplayed(txtToAck,"") && isDisplayed(txtAmount,"")
				&& isDisplayed(txtEquivalentAmtAck,"") && isDisplayed(txtDescriptionAck,"") && isDisplayed(txtWhenToTransferAck,"") &&
				isDisplayed(btnMakeAnotherTransfer,"") && isDisplayed(btnDone,"");
	}
	
	public void clickOnDoneBtn() {
		doClick(btnDone,"Done button");
	}
	
	public void clickOnMakeAnotherTransferBtn() {
		
		doClick(btnMakeAnotherTransfer,"Make Another Transfer button");
	}
	
	public void verifyEnterDetailsSectionHeaderIsDisplayed() {
	
		
		doAssertEqualsBoolean(isDisplayed(lblTransferDetailsSecHeader,"Enter Details Section Heading"), true, "Enter Details Section Heading displayed?");
	}
	
	public void verifyTransferToOwnAccountEnterDetailsSectionRecurring() {
		boolean res = false;
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		try {
		 res =  isDisplayed(txtAmtUSD,"")
					&& isDisplayed(lblEquivalemtAmt,"") && isDisplayed(txtDescription,"") && isDisplayed(lblWhenToTransfer,"") &&
					isDisplayed(radioOneTimeTransfer,"") && isDisplayed(radioRecurringTransfer,"") && 
					isDisplayed(calendarDate,"") && isDisplayed(btnNext,"") &&
					isDisplayed(dateStartingFrom, "") && isDisplayed(drpDowmRepeatFreq,"") && isDisplayed(txtNumberOfTimes,"");
		}
		catch (Exception e){
			res =  isDisplayed(txtAmtUSD,"")
					&& isDisplayed(lblEquivalemtAmt,"") && isDisplayed(txtDescription,"") && isDisplayed(lblWhenToTransfer,"") &&
					isDisplayed(radioOneTimeTransfer,"") && isDisplayed(radioRecurringTransfer,"") && 
					isDisplayed(calendarDate,"") && isDisplayed(btnNext,"") &&
					isDisplayed(dateStartingFrom, "") && isDisplayed(drpDowmRepeatFreq,"") && isDisplayed(txtNumberOfTimes,"");;
		}
		doAssertEqualsBoolean(res, true, "Transfer to Own Account - Enter Details Section - Recurring Payment fields displayed ?");
	}
	
	//S014_TC06
	
	public void selectStartingFromDate(String expDate) {
		
	}
	
	public void selectRepeatFrequency(String freq) {
		
		selectValueFromDropDowm(drpDowmRepeatFreq, freq);
	}
	
	public void KeyInNumberOfTimes(String num) {
		
		doSendKeys(txtNumberOfTimes, num, "Number of Times - Recurring Transfer");
	}
	
    public void verifyRecurringConfirmDetailsSectionElementsAreDisplayed() {
		
		boolean res = isDisplayed(txtFrom,"") && isDisplayed(txtTo, "") && isDisplayed(txtAmt,"")
						&& isDisplayed(txtEquivalentAmt,"") 
						&& isDisplayed(txtDesc,"") && isDisplayed(txtWhenToTransfer,"") && isDisplayed(btnSubmit,"");
		
		doAssertEqualsBoolean(res, true, "Transfer to Own Account Recurring - Confirm Details Section fields displayed");
		
	}
    
    
	public void verifyRecurringTransferAcknowledgementDetailsAreDisplayed() {
		
		boolean flag = false;
		
		flag = isDisplayed(txtAcknowledgementMsg,"") && isDisplayed(txtRefNum,"") && isDisplayed(txtTransactionStatus,"")
				&& isDisplayed(txtTranDateTimeRecurring,"") && isDisplayed(txtFromAckn,"") && isDisplayed(txtToAck,"") && isDisplayed(txtAmount,"")
				&& isDisplayed(txtEquivalentAmtAck,"") && isDisplayed(txtDescriptionAck,"") && isDisplayed(txtWhenToTransferAck,"") &&
				isDisplayed(btnMakeAnotherTransfer,"") && isDisplayed(btnDone,"");
	}
	
	public void verifyErrorMsg(String expVal) {
		String actVal = getText(txtErrorMsg, "Error message");
		
		doAssertEqualsStrings(actVal, expVal, "Verify error message");
		
	}
	
	public void selectDate(String fullDateValue) {
		selectDateFromCalendar(fullDateValue, calendarDate, calendarMonthDropDown, calendarYearDropDown);
	}
}
