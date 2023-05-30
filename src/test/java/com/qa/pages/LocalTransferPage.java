package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LocalTransferPage extends BasePage {

	public LocalTransferPage(WebDriver driver) {
		super(driver);
	}
	
	
	//******* Details ENtry section
	
	@FindBy(xpath="//label[normalize-space()='Transfer Details']") private WebElement lblTransferDetails;
	
	@FindBy(xpath="//select[@id='idFormEntry:idSOMTransferFrom']") private WebElement dropDownFrom;
	@FindBy(xpath="//select[@id='idFormEntry:idBnk']") private WebElement dropDownReceipientBank;
	@FindBy(xpath="//label[@for='idFormEntry:idAcctNo']/following-sibling::span/input") private WebElement txtToAccount;
	@FindBy(xpath="//label[@for='idFormEntry:idOneTimeFullNm']/following-sibling::span/input") private WebElement txtReceipientName;
	
	@FindBy(xpath="//label[@for='idFormEntry:idAmt']") private WebElement lblAmountUSD;
	@FindBy(xpath="//input[@id='idFormEntry:idAmt']") private WebElement txtAmount;
	
	
	@FindBy(xpath="//label[@for='idFormEntry:idOthInfo']/following-sibling::span/input") private WebElement txtDescription;
	
	@FindBy(xpath="//label[@class='col-4 text-end fw-semibold']") private WebElement lblWehnToTransfer;
	@FindBy(xpath="//input[@id='idFormEntry:idRecur:0']") private WebElement radioBtnOneTimeTransfer;
	
	@FindBy(xpath="//input[@id='idFormEntry:idRecur:1']") private WebElement radioBtnRecurringTransfer;
	
	
	
	@FindBy(xpath="//input[@id='idFormEntry:idRecurringDate']") private WebElement calendarIcon;
		
	//For recurring only
	@FindBy(xpath="//select[@id='idFormEntry:idFreq']") private WebElement dropDownRepeat;
	@FindBy(id="Occurrence") private WebElement txtNumberOfTimes;
	///
	
	@FindBy(xpath="//select[@class='ui-datepicker-month']") private WebElement dropDownMonth;
	@FindBy(xpath="//select[@class='ui-datepicker-year']") private WebElement dropDownYear;

	
	
	@FindBy(xpath="//label[@class='col-4 col-form-label text-end pt-3 fw-semibold']") private WebElement lblSMSNotification;
	@FindBy(xpath="//input[@id='idFormEntry:idSms']") private WebElement txtSMSMobile;
	@FindBy(xpath="//input[@id='idFormEntry:idBtnSubmit']") private WebElement btnNext;
	
	//Error message
	@FindBy(xpath="//span[@class='text-danger']") private WebElement errorMsg;
	
	// when all error are at same time
	@FindBy(xpath="//label[@for='idFormEntry:idAcctNo']/following-sibling::span/span") private WebElement txtToAcctErrMsg;
	@FindBy(xpath="//label[@for='idFormEntry:idOneTimeFullNm']/following-sibling::span/span") private WebElement txtRecNameErrMsg;
	@FindBy(xpath="//label[@for='idFormEntry:idAmt']/parent::span/following-sibling::div/span") private WebElement txtAmountErrMsg;
	@FindBy(xpath="//label[@for='idFormEntry:idOthInfo']/following-sibling::span/span") private WebElement txtDescErrMsg;

	
	//Add Favourite
	@FindBy(xpath="//span[@class='col px-0']") private WebElement menuAddFavourite;
	@FindBy(xpath="//img[@class='cursor']") private WebElement btnDelete;
	@FindBy(xpath="//input[@id='idFormEntry:chck_0']") private WebElement checkboxToSelectEntryToDelete;
 	@FindBy(xpath="//button[@class='btn btn-glow rounded-4 min-100 btn-primary']") private WebElement btnYes;
 	@FindBy(xpath="//button[@class='btn btn-outline-primary me-1 min-100 rounded-4'][normalize-space()='No']") private WebElement btnNo;
 	
	@FindBy(xpath="//span[@class='pd-acctno d-block']") private List<WebElement> favouriteRecords;
	
	//For delete
	@FindBy(xpath="//button[@class='btn btn-danger min-100 rounded-4 d-inline-block align-middle m-0 ms-3']//label[contains(text(),'Yes')]") private WebElement btnYesConfirmDelete;
	@FindBy(xpath="//button[contains(@class,'btn btn-outline-primary min-100 rounded-4 d-inline-block align-middle m-0')]") private WebElement btnNoForDelete;
 	
	
	//********  Confirmation Section
	@FindBy(xpath="//label[normalize-space()='From']/following-sibling::span") private WebElement txtFromConfirm;
	@FindBy(xpath="//label[normalize-space()='Recipient Bank']/following-sibling::span") private WebElement txtReceipientBankConfirm;
	@FindBy(xpath="//label[normalize-space()='To Account']/following-sibling::span") private WebElement txtToAcctConfirm;
	@FindBy(xpath="//label[normalize-space()='Recipient Name']/following-sibling::span") private WebElement txtReceipientNameConfirm;
	@FindBy(xpath="//label[normalize-space()='Amount (USD)']/following-sibling::span") private WebElement txtAmtUSDConfirm;
	@FindBy(xpath="//label[normalize-space()='Description']/following-sibling::span") private WebElement txtDescriptionConfirm;
	@FindBy(xpath="//label[@class='col-4 col-form-label text-end fw-semibold']/following-sibling::span") private WebElement txtWhenToTransferConfirm;
	@FindBy(xpath="//label[normalize-space()='Send SMS Notification']/following-sibling::span") private WebElement txtSendSMSNotification;
	
	@FindBy(xpath="//a[@class='btn btn-outline-primary ms-1 min-100 rounded-4']") private WebElement btnBack;
	@FindBy(xpath="//input[@id='idFormCfmAckDtl:idBtnConfirmTrsf']") private WebElement btnSubmit;


	
	//********* Acknowledgement Section
	
	@FindBy(xpath="//li[@class='success-msg']") private WebElement txtSuccessMsg;
	
	@FindBy(xpath="//label[normalize-space()='Reference Number']/following-sibling::span") private WebElement txtRefNumAck;
	@FindBy(xpath="//label[normalize-space()='Transaction Status']/following-sibling::span") private WebElement txtTranStatusAck;
	//@FindBy(xpath="//span[@class='col-8 col-form-label']") private WebElement txtTranDateAck;
	@FindBy(xpath="//label[normalize-space()='From']/following-sibling::span") private WebElement txtFromAcctAck;
	@FindBy(xpath="//label[normalize-space()='Recipient Bank']") private WebElement txtRecipientBankAck;
	@FindBy(xpath="//label[normalize-space()='To Account']/following-sibling::span") private WebElement txtToAcctAck;
	@FindBy(xpath="//label[normalize-space()='Recipient Name']/following-sibling::span") private WebElement txtRecipientNameAck;
	@FindBy(xpath="//label[normalize-space()='Amount (USD)']/following-sibling::span") private WebElement txtAmountAck;
	@FindBy(xpath="//label[normalize-space()='Description']/following-sibling::span") private WebElement txtDescriptionAck;
	@FindBy(xpath="//label[normalize-space()='When to Transfer']/following-sibling::span") private WebElement txtWhenToTransferAck;
	@FindBy(xpath="//label[normalize-space()='Send SMS Notification']/following-sibling::span") private WebElement txtSMSMobileNumAck;
	
	@FindBy(xpath="//input[@name='idFormCfmAckDtl:j_idt422']") private WebElement btnMakeAnotherTransfer;
	@FindBy(xpath="//input[@name='idFormCfmAckDtl:j_idt423']") private WebElement btnDone;




	
	public void selectFromAcct(String value) {
		
		selectDropDownByValue(dropDownFrom, value);
	}
	
	
	public void verifyAllFieldsAreDisplayedInDetailsEntrySectionOneTimeTransfer() {
		boolean flag= false;
		
		flag = isDisplayed(lblTransferDetails,"") && isDisplayed(dropDownFrom,"") && isDisplayed(dropDownReceipientBank,"") &&
				isDisplayed(txtToAccount,"") && isDisplayed(txtReceipientName,"") && isDisplayed(lblAmountUSD,"") &&
				isDisplayed(txtAmount,"") && isDisplayed(txtDescription,"") && isDisplayed(lblWehnToTransfer,"") &&
				isDisplayed(radioBtnOneTimeTransfer,"") && isDisplayed(radioBtnRecurringTransfer,"") && isDisplayed(calendarIcon,"") &&
				isDisplayed(lblSMSNotification,"") && isDisplayed(txtSMSMobile,"") && isDisplayed(btnNext,"");
		
		doAssertEqualsBoolean(flag, true, "All Fields are displayed in Details Entry section ?");
	}
	
	
	public void selectReceipientBank(String bankName) {
		selectValueFromDropDowm(dropDownReceipientBank, bankName);
	}
	
	public void keyInToAccount(String toAcct) {
		doSendKeys(txtToAccount,toAcct,"To Account");
	}
	
	public void keyInReceipientName(String recName) {
		doSendKeys(txtReceipientName, recName, "Receipient Name");
	}
	
	public void keyInAmount(String amt) {
		
		doSendKeys(txtAmount, amt, "Amount");
	}
	
	public void keyInDescription(String desc) {
		doSendKeys(txtDescription, desc, "Description");
	}
	
	public void selectWhenToTransfer(String whenToTransfer) {
		
		if(whenToTransfer.equalsIgnoreCase("One Time Transfer")) {
			doClick(radioBtnOneTimeTransfer, "One Time Transfer Radio buttonb");
		}
		else if(whenToTransfer.equalsIgnoreCase("Recurring Transfer")) {
			doClick(radioBtnRecurringTransfer, "Recurring Transfer Radio buttonb");
		}
		else {
			throw new IllegalStateException("Invlaid Value provided for When to Transfer");
		}
	}
	
	public void selectTransferDate(String date) {
		
		if(date.equalsIgnoreCase("Today")) {
			System.out.println("Today date selected");
		}
		else {
			selectDateFromCalendar(date,calendarIcon,dropDownMonth,dropDownYear );
		}
	}
	
	public void keyInMobileNumForSMS(String mobileNum) {
		doSendKeys(txtSMSMobile, mobileNum, "Mobile Number to receive SMS");
	}
	
	public void clickOnNextBtn() {
		doClick(btnNext,"Next button");
	}
	
	
	public void verifyDetailsAreDisplayedInConfirmSection() {
        boolean flag= false;
		
		flag = isDisplayed(txtFromConfirm,"") && isDisplayed(txtReceipientBankConfirm,"") && isDisplayed(txtToAcctConfirm,"") &&
				isDisplayed(txtReceipientNameConfirm,"") && isDisplayed(txtAmtUSDConfirm,"") && isDisplayed(txtDescriptionConfirm,"") &&
				isDisplayed(txtWhenToTransferConfirm,"") && isDisplayed(txtSendSMSNotification,"") && isDisplayed(btnBack,"") &&
				isDisplayed(btnSubmit,"") ;
		
		doAssertEqualsBoolean(flag, true, "All Fields are displayed in Confirm Details section ?");
	}
	
	public void clickOnSubmitBtn() {
		doClick(btnSubmit,"Submit button");
	}
	
	public void verifySuccessMessage(String expMsg) {
		String actMsg = getText(txtSuccessMsg,"Success message");
		doAssertEqualsStrings(actMsg, expMsg, "Success message");
	}
	
	public void verifyElementsAreDisplayedInAcknowledgementSection() {
		boolean flag= false;
		
		flag = isDisplayed(txtSuccessMsg,"") && isDisplayed(txtRefNumAck,"") && isDisplayed(txtTranStatusAck,"") &&
				 isDisplayed(txtFromAcctAck,"") && isDisplayed(txtRecipientBankAck,"") &&
				isDisplayed(txtToAcctAck,"") && isDisplayed(txtRecipientNameAck,"") && isDisplayed(txtAmountAck,"") &&
				isDisplayed(txtDescriptionAck,"") && isDisplayed(txtWhenToTransferAck,"") && isDisplayed(txtSMSMobileNumAck,"")
				&& isDisplayed(btnMakeAnotherTransfer,"") && isDisplayed(btnDone,"");
		
		doAssertEqualsBoolean(flag, true, "All Fields are displayed in Acknowledgement section ?");

	}
	
	public void clickOnMakeAnotherTransferBtn() {
		
		doClick(btnMakeAnotherTransfer, "Make Another Transfer button");
	}
	
	
	public void clickOnDoneBtn() {
		
		doClick(btnDone, "Done button");
	}
	public void verifyTransferDetailsLabelIsDisplayed() {
	
		doAssertEqualsBoolean(isDisplayed(lblTransferDetails, "Transfer Details Label"), true, "Transfer Details Label displayed?");
	}
	
	
	public void verifyAllFieldsAreDisplayedInDetailsEntrySectionRecurringTransfer() {
		boolean flag= false;
		
		flag = isDisplayed(lblTransferDetails,"") && isDisplayed(dropDownFrom,"") && isDisplayed(dropDownReceipientBank,"") &&
				isDisplayed(txtToAccount,"") && isDisplayed(txtReceipientName,"") && isDisplayed(lblAmountUSD,"") &&
				isDisplayed(txtAmount,"") && isDisplayed(txtDescription,"") && isDisplayed(lblWehnToTransfer,"") &&
				isDisplayed(radioBtnOneTimeTransfer,"") && isDisplayed(radioBtnRecurringTransfer,"") && isDisplayed(calendarIcon,"") &&
				isDisplayed(lblSMSNotification,"") && isDisplayed(txtSMSMobile,"") && isDisplayed(btnNext,"") &&
				isDisplayed(dropDownRepeat,"") && isDisplayed(txtNumberOfTimes,"");
		
		doAssertEqualsBoolean(flag, true, "All Fields are displayed in Details Entry section  - Recurring Payment ?");
	}
	
	public void selectRepatFrequency(String frequency) {
		
		selectValueFromDropDowm(dropDownRepeat, frequency);
		
	}
	
	public void KeyInNumberOfTimes(String num) {
		doSendKeys(txtNumberOfTimes, num, "Number of Times");
	}
	
	public void verifyDetailsAreDisplayedInConfirmSectionForRecurringTransfer() {
        boolean flag= false;
		
		flag = isDisplayed(txtFromConfirm,"") && isDisplayed(txtReceipientBankConfirm,"") && isDisplayed(txtToAcctConfirm,"") &&
				isDisplayed(txtReceipientNameConfirm,"") && isDisplayed(txtAmtUSDConfirm,"") && isDisplayed(txtDescriptionConfirm,"") &&
				isDisplayed(txtWhenToTransferConfirm,"") && isDisplayed(txtSendSMSNotification,"") && isDisplayed(btnBack,"") &&
				isDisplayed(btnSubmit,"") ;
		
		doAssertEqualsBoolean(flag, true, "All Fields are displayed in Confirm Details section  for Recurring Transfer?");
	}
	
	public void verifyErrorMessage(String expVal) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String actVal = getText(errorMsg, "Error message");
		doAssertEqualsStrings(actVal, expVal, "Verify error message");
	}
	
	public void clearToAcctField()
	{
		clearField(txtToAccount, "Clear To Acct");
	}
	
	public void clearAmtField() {
		clearField(txtAmount, "Clear Amount");

	}
	
	public void clearDescriptionField() {
		clearField(txtDescription,"Description");
		}
	
	public void verifyErrMsgToAccount(String expVal) {
		String actVal = getText(txtToAcctErrMsg,"To Account  field blank error message");
		doAssertEqualsStrings(actVal, expVal,"To Account  field blank error message");
	}
	
	public void verifyErrMsgRecName(String expVal) {
		String actVal = getText(txtRecNameErrMsg,"Receipient Name filed blank error message");
		doAssertEqualsStrings(actVal, expVal,"eceipient Name filed blank error message");
	}
	
	public void verifyErrMsgAmount(String expVal) {
		String actVal = getText(txtAmountErrMsg,"Amount field blank error message");
		doAssertEqualsStrings(actVal, expVal,"Amount field blank error message\"");
	}
	
	public void verifyErrorMsgDesc(String expVal) {
		String actVal = getText(txtDescErrMsg,"Description field blank error message");
		doAssertEqualsStrings(actVal, expVal,"Description field blank error message");
	}
	
	public void clickOnAddFavouriteMenu() {
		
		doClick(menuAddFavourite,"Add Favourite");
	}
	
	public ManageFavouriteAccountsPage clickOnYesBtn() {
		doClick(btnYes, "Yes buttom");
		return new ManageFavouriteAccountsPage(driver);
	}
	
	public void clickOnNoBtn() {
		doClick(btnNo, "No button");
	}
	
	public void verifyAddFavouriteMenuIsDisplayed() {
	
		doAssertEqualsBoolean(	isDisplayed(menuAddFavourite, "Add Favourite menu"), true, "Add Favourite menu");
	}
	
	public void verifyDeleteBtnIsDisplayed() {
		doAssertEqualsBoolean(	isDisplayed(btnDelete, "Delete button"), true, "Delete button");

	}
	
	int initialFavouriteRecordCount=0;
	public void clickOnDeleteBtn() {
		initialFavouriteRecordCount=favouriteRecords.size();
		doClick(btnDelete,"Delete button");
	}
	
	public void selectCheckBoxToDeleteFavRecord() {
		doClick(checkboxToSelectEntryToDelete, "Checkbox to selete the record to be deleted");
	}
	
	public void clickOnYesBtnToCOnfirmDelete() {
		doClick(btnYesConfirmDelete,"Yes button to confirm deletion");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void verifyFavouriteRecordCountAfterDeletion() {
		int favRecordCountAfter = favouriteRecords.size();
		doAssertEqualsBoolean(favRecordCountAfter==(initialFavouriteRecordCount-1), true, "Favourite Record count verification");
	}
}
