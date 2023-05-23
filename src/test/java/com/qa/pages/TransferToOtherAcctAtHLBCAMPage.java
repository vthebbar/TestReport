package com.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TransferToOtherAcctAtHLBCAMPage extends BasePage {

	public TransferToOtherAcctAtHLBCAMPage(WebDriver driver) {
		super(driver);
	}

	// *** Details Entry Section

	@FindBy(xpath = "//label[normalize-space()='Transfer Details']")
	private WebElement lblTransferDetails;

	@FindBy(xpath = "//label[@for='idFormEntry:idSOMTransferFrom']/following-sibling::span/select")
	private WebElement dropDownFrom;
	@FindBy(xpath = "//label[@for='idFormEntry:idAcctNo']/following-sibling::span/input")
	private WebElement txtToAccount;
	@FindBy(xpath = "//input[@id='idFormEntry:idAmt']")
	private WebElement txtAmount;
	@FindBy(xpath = "//label[@class='col-4 col-form-label text-end fw-semibold text-now']")
	private WebElement lblEquivalentAmount;
	@FindBy(xpath = "//label[@for='idFormEntry:idDescOpt']/following-sibling::span/input")
	private WebElement txtDescription;
	@FindBy(xpath = "//label[@class='col-4 text-end fw-semibold']")
	private WebElement lblWhenToTransfer;
	@FindBy(xpath = "//input[@id='idFormEntry:idRecur:0']")
	private WebElement radioBtnOneTimeTransfer;
	@FindBy(xpath = "//input[@id='idFormEntry:idRecur:1']")
	private WebElement radioBtnRecurringTransfer;
	@FindBy(xpath = "//input[@id='idFormEntry:idRecurringDate']")
	private WebElement calendarIcon;
	@FindBy(xpath = "//label[@class='col-4 col-form-label text-end pt-3 fw-semibold']")
	private WebElement lblSendSMSNotification;
	@FindBy(xpath = "//input[@id='idFormEntry:idSms']")
	private WebElement txtSMSMobileNum;
	@FindBy(id = "idFormEntry:idBtnSubmit")
	private WebElement btnNext;

	@FindBy(xpath = "//select[@class='ui-datepicker-month']")
	private WebElement monthDropDown;
	@FindBy(xpath = "//select[@class='ui-datepicker-year']")
	private WebElement yearDropDown;

	// For recurring transfer
	@FindBy(xpath = "//label[normalize-space()='Starting From']/parent::div/following-sibling::div/input")
	private WebElement calendarStartingFrom;
	@FindBy(xpath = "//label[normalize-space()='Repeat']/parent::div/following-sibling::div/select")
	private WebElement dropDownRepeatFrequency;
	@FindBy(id = "Occurrence")
	private WebElement txtOccurrence;

	// Error messages
	@FindBy(xpath = "//span[contains(text(),'To Account is required')]")
	private WebElement txtErrorMsgToAcct;
	@FindBy(xpath = "//span[contains(text(),'Amount is required')]")
	private WebElement txtErrorMsgAmount;
	@FindBy(xpath = "//span[contains(text(),'Description is required')]")
	private WebElement txtErrorMsgDescription;

	
	//Add favourite
	@FindBy(xpath="//span[text()='Add Favourite']") private WebElement menuAddFavourite;
	@FindBy(xpath="//button[@class='btn btn-outline-primary me-1 min-100 rounded-4'][normalize-space()='No']") private WebElement btnNo;
	@FindBy(xpath="//button[@class='btn btn-glow rounded-4 min-100 btn-primary']//label[contains(text(),'Yes')]") private WebElement btnYes;
	
		//delete favourite
	@FindBy(xpath="//img[@class='cursor']") private WebElement btnDelete;
	@FindBy(xpath="//input[@id='idFormEntry:chck_0']") private WebElement checkboxForDeleteEntry;
	@FindBy(xpath="//button[@class='btn btn-danger min-100 rounded-4 d-inline-block align-middle m-0 ms-3']") private WebElement btnDeleteConfirmYes;
	@FindBy(xpath="//button[@class='btn btn-outline-primary min-100 rounded-4 d-inline-block align-middle m-0 ']") private WebElement btnDeleteNo;

	@FindBy(xpath="//span[@class='pd-acctno d-block']") private List<WebElement> favouriteRecords;
	
	
	// *** Confirmation Section
	@FindBy(xpath = "//label[normalize-space()='From']/following-sibling::span")
	private WebElement txtFromConfirm;
	@FindBy(xpath = "//label[normalize-space()='Recipient Bank']/following-sibling::span")
	private WebElement txtReceipientBankConfirm;
	@FindBy(xpath = "//label[normalize-space()='To Account']/following-sibling::span")
	private WebElement txtToAccountConfirm;
	@FindBy(xpath = "//label[normalize-space()='Recipient Name']/following-sibling::span")
	private WebElement txtReceipientNameConfirm;
	@FindBy(xpath = "//label[normalize-space()='Amount (USD)']/following-sibling::span")
	private WebElement txtAmountUSDConfirm;
	@FindBy(xpath = "//label[normalize-space()='Description']/following-sibling::span")
	private WebElement txtDescriptionConfirm;
	@FindBy(xpath = "//label[normalize-space()='When to Transfer']/following-sibling::span")
	private WebElement txtWhenToTransferConfirm;
	@FindBy(xpath = "//label[normalize-space()='Send SMS Notification']/following-sibling::span")
	private WebElement txtSMSMobileConfirm;
	@FindBy(css = "input[value='Submit']")
	private WebElement btnSubmit;

	// *** Acknowledgement Section
	@FindBy(xpath = "//li[@class='success-msg']")
	private WebElement txtSuccessMsgAck;
	@FindBy(xpath = "//label[normalize-space()='Transaction Status']/following-sibling::span")
	private WebElement txtTransactionStatusAck;
	// @FindBy(xpath="//span[@class='col-8 col-form-label']") private WebElement
	// txtTranDateTimeAck;
	@FindBy(xpath = "//label[normalize-space()='From']/following-sibling::span")
	private WebElement txtFromAck;
	@FindBy(xpath = "//label[normalize-space()='Recipient Bank']/following-sibling::span")
	private WebElement txtReceipientBankAck;
	@FindBy(xpath = "//label[normalize-space()='To Account']/following-sibling::span")
	private WebElement txtToAccountAck;
	@FindBy(xpath = "//label[normalize-space()='Recipient Name']/following-sibling::span")
	private WebElement txtReceipientnameAck;
	@FindBy(xpath = "//label[normalize-space()='Amount (USD)']/following-sibling::span")
	private WebElement txtAmountUSDAck;;
	@FindBy(xpath = "//label[normalize-space()='Description']/following-sibling::span")
	private WebElement txtDescriptionAck;;
	// @FindBy(xpath="//label[@id='idFormCfmAckDtl:idBalLabelIgnorePrint']/following-sibling::span")
	// private WebElement txtBalanceAfterTransferUSDAck;;
	@FindBy(xpath = "//label[normalize-space()='When to Transfer']/following-sibling::span")
	private WebElement txtWhenToTransferAck;;
	@FindBy(xpath = "//a[contains(@class,'btn btn-outline-primary ms-2 min-100 px-4 rounded-4')]")
	private WebElement btnMakeAnotherTransferAck;
	@FindBy(css = "input[value='Done']")
	private WebElement btnDoneAck;

	public void verifyDetailsEntrySectionsElementsAreDisplayedOneTimeTransfer() {

		boolean flag = false;

		flag = isDisplayed(dropDownFrom, "") && isDisplayed(txtToAccount, "") && isDisplayed(txtAmount, "")
				&& isDisplayed(lblEquivalentAmount, "") && isDisplayed(txtDescription, "")
				&& isDisplayed(lblWhenToTransfer, "") && isDisplayed(radioBtnOneTimeTransfer, "")
				&& isDisplayed(radioBtnRecurringTransfer, "") && isDisplayed(calendarIcon, "")
				&& isDisplayed(lblSendSMSNotification, "") && isDisplayed(txtSMSMobileNum, "")
				&& isDisplayed(btnNext, "");

		doAssertEqualsBoolean(flag, true, "Detail Entry section elements are displayed for one time transfer?");

	}

	public void selectFromAccount(String value) {
		selectDropDownByValue(dropDownFrom, value);
	}

	public void keyInToAccount(String toAcct) {

		doSendKeys(txtToAccount, toAcct, "To Account number");
	}

	public void keyInAmount(String amt) {

		doSendKeys(txtAmount, amt, "Amount to transfer");

	}

	public void keyInDescription(String desc) {
		try {
			Thread.sleep(1000);
			doSendKeys(txtDescription, desc, "Transfer description");
			Thread.sleep(2000);
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}

	}

	public void selectWhenToTransfer(String when) {

		if (when.equalsIgnoreCase("One Time Transfer")) {
			doClick(radioBtnOneTimeTransfer, "One Time Transfer");
		} else if (when.equalsIgnoreCase("Recurring Transfer")) {
			try {
				doClick(radioBtnRecurringTransfer, "One Time Transfer");
			} catch (StaleElementReferenceException e) {
				doClick(radioBtnRecurringTransfer, "One Time Transfer");
			}

		} else {
			throw new IllegalStateException("Not valid value given for When to select:" + when);
		}
	}

	public void selectDate(String dateValue) {
		/*
		 * String dateMontYear[]= dateValue.split("/");
		 * doClick(calendarIcon,"Calendar Icon");
		 * selectValueFromDropDowm(monthDropDown,dateMontYear[1]);
		 * selectValueFromDropDowm(yearDropDown,dateMontYear[2]);
		 * 
		 * String fullXpath="//a[text()='"+dateMontYear[0]+"']"; WebElement dateVal =
		 * driver.findElement(By.xpath(fullXpath)); doClick(dateVal,"Date");
		 */
		try {
		selectDateFromCalendar(dateValue, calendarIcon, monthDropDown, yearDropDown);
		}
		catch(Exception e){
			selectDateFromCalendar(dateValue, calendarIcon, monthDropDown, yearDropDown);

		}
	}

	public void keyInSMSMobileNum(String smsMobile) {

		doSendKeys(txtSMSMobileNum, smsMobile, "Mobile Number to Receive SMS");
	}

	public void clickOnNextBtn() {

		doClick(btnNext, "Next button");

	}

	public void verifyConfirmationScreenElementsOneTimeTransfer() {
		boolean flag = false;

		flag = isDisplayed(txtFromConfirm, "") && isDisplayed(txtReceipientBankConfirm, "")
				&& isDisplayed(txtToAccountConfirm, "") && isDisplayed(txtReceipientNameConfirm, "")
				&& isDisplayed(txtAmountUSDConfirm, "") && isDisplayed(txtDescriptionConfirm, "")
				&& isDisplayed(txtWhenToTransferConfirm, "") && isDisplayed(txtSMSMobileConfirm, "")
				&& isDisplayed(btnSubmit, "");

		doAssertEqualsBoolean(flag, true, "Detail Confirmation section elements are displayed for one time transfer?");
	}

	public void clickOnSubmitButton() {

		doClick(btnSubmit, "Submit button");
	}

	public void verifyTransferSuccessMsg(String expVal) {
		String actVal = getText(txtSuccessMsgAck, "Transfer success message");
		doAssertEqualsStrings(actVal, expVal, "Transfer success message displayed correctly?");
	}

	public void verifyAcknowledgementSectionOneTimeTransferUSDtoUSD() {
		boolean flag = false;

		flag = isDisplayed(txtTransactionStatusAck, "") && isDisplayed(txtFromAck, "")
				&& isDisplayed(txtReceipientBankAck, "") && isDisplayed(txtToAccountAck, "")
				&& isDisplayed(txtReceipientnameAck, "") && isDisplayed(txtAmountUSDAck, "")
				&& isDisplayed(txtDescriptionAck, "") && isDisplayed(txtWhenToTransferAck, "")
				&& isDisplayed(btnMakeAnotherTransferAck, "") && isDisplayed(btnDoneAck, "");

		doAssertEqualsBoolean(flag, true,
				"Acknowledgement section elements are displayed for one time transfer USD to USD A/C ?");
	}

	public HomePage clickOnDoneBtn() {
		doClick(btnDoneAck, "");
		return new HomePage(driver);
	}

	public void clickOnMakeAnotherTransferBtn() {
		doClick(btnMakeAnotherTransferAck, "Make Anotehr Transfer button");
	}

	public void verifyTransferDetailsLabelIsDisplayed() {

		doAssertEqualsBoolean(isDisplayed(lblTransferDetails, "TRANSFER DETAILS label"), true,
				"Transfer Details label isdisplayed?");
	}

	public void verifyDetailsEntrySectionsElementsAreDisplayedRecurringTransfer() {

		boolean flag = false;

		flag = isDisplayed(dropDownFrom, "") && isDisplayed(txtToAccount, "") && isDisplayed(txtAmount, "")
				&& isDisplayed(lblEquivalentAmount, "") && isDisplayed(txtDescription, "")
				&& isDisplayed(lblWhenToTransfer, "") && isDisplayed(radioBtnOneTimeTransfer, "")
				&& isDisplayed(radioBtnRecurringTransfer, "") && isDisplayed(calendarStartingFrom, "")
				&& isDisplayed(lblSendSMSNotification, "") && isDisplayed(txtSMSMobileNum, "")
				&& isDisplayed(btnNext, "") && isDisplayed(dropDownRepeatFrequency, "")
				&& isDisplayed(txtOccurrence, "");

		doAssertEqualsBoolean(flag, true, "Detail Entry section elements are displayed for Recurring transfer?");

	}

	public void selectStartFromDate(String dateValue) {
		/*
		 * String dateMontYear[]= dateValue.split("/");
		 * doClick(calendarIcon,"Calendar Icon");
		 * selectValueFromDropDowm(monthDropDown,dateMontYear[1]);
		 * selectValueFromDropDowm(yearDropDown,dateMontYear[2]);
		 * 
		 * String fullXpath="//a[text()='"+dateMontYear[0]+"']"; WebElement dateVal =
		 * driver.findElement(By.xpath(fullXpath)); doClick(dateVal,"Date");
		 */
		selectDateFromCalendar(dateValue, calendarStartingFrom, monthDropDown, yearDropDown);

	}

	public void selectRepeatFrequency(String visibleText) {

		selectValueFromDropDowm(dropDownRepeatFrequency, visibleText);
	}

	public void keyInNumberOfTimes(String numbeOfTimes) {
		doSendKeys(txtOccurrence, numbeOfTimes, "Number of Times");
	}

	public void verifyConfirmationScreenElementsRecurringTransfer() {
		boolean flag = false;

		flag = isDisplayed(txtFromConfirm, "") && isDisplayed(txtReceipientBankConfirm, "")
				&& isDisplayed(txtToAccountConfirm, "") && isDisplayed(txtReceipientNameConfirm, "")
				&& isDisplayed(txtAmountUSDConfirm, "") && isDisplayed(txtDescriptionConfirm, "")
				&& isDisplayed(txtWhenToTransferConfirm, "") && isDisplayed(txtSMSMobileConfirm, "")
				&& isDisplayed(btnSubmit, "");

		doAssertEqualsBoolean(flag, true, "Detail Confirmation section elements are displayed for Recurring Transfer?");
	}

	public void verifyErrorMsgToAcctField(String expVal) {

		String actVal = getText(txtErrorMsgToAcct, "To Account field error message");
		doAssertEqualsStrings(actVal, expVal, "To Account field error message");
	}

	public void verifyErrorMsgAmountField(String expVal) {
		String actVal = getText(txtErrorMsgAmount, "Amount field error message");
		doAssertEqualsStrings(actVal, expVal, "Amount field error message");

	}

	public void verifyErrorMsgDescriptionField(String expVal) {
		String actVal = getText(txtErrorMsgDescription, "Description field error message");
		doAssertEqualsStrings(actVal, expVal, "Description field error message\"");

	}
	
	public void clickOnAddFavouriteMenu() {
		doClick(menuAddFavourite, "Add Favourite menu");
		
	}
	
	public ManageFavouriteAccountsPage clickOnYesBtnInAddFavouritePopUp() {
		doClick(btnYes,"Yes button in Add Favourite Pop up");
		return new ManageFavouriteAccountsPage(driver);
	}
	
	public void clickOnNoBtninAddFavouritePopUp() {
		doClick(btnNo, "No button in Add Favourite pop up");
	}
	
	
	public void verifyAddFavouriteMenuIsDisplayed() {
		
		doAssertEqualsBoolean(isDisplayed(menuAddFavourite, "Add Favourote Menu"), true, "Add Favourote Menu is displayed?");

	}
	
	public void verifyDeleteButtonIconIsDisplayed() {
		
		doAssertEqualsBoolean(isDisplayed(btnDelete, "Delete/Bin Icon"), true, "Delete/Bin Icon is displayed?");
	}
	
	int initialFavouriteRecordCount=0;
	public void clickOnDeleteBtn() {
		initialFavouriteRecordCount = favouriteRecords.size();
		doClick(btnDelete,"Delete button");
	}
	
	public void clickOnCheckBoxForDeleteEntry() {
		
		doClick(checkboxForDeleteEntry, "Checkbox to select record to be deleted");
	}
	
	public void clickOnYesBtnToConfirmDelete() {
		
		doClick(btnDeleteConfirmYes,"Yes button to confirm delete");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void verifyFavouriteRecordCount() {
		
			System.out.println("Records count after delete==="+ favouriteRecords.size());
			int favouriteRecordCountAfterDelete=favouriteRecords.size();
				doAssertEqualsBoolean(favouriteRecordCountAfterDelete == (initialFavouriteRecordCount-1), true, "No Favourite Records present?");
	}
}
