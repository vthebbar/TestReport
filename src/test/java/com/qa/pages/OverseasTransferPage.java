package com.qa.pages;

import java.util.List;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qa.utils.PropertyManager;
import com.qa.utils.TACManager;

public class OverseasTransferPage extends BasePage {

	public OverseasTransferPage(WebDriver driver) {
		super(driver);
	}
	
	//******* Details Entry section
	@FindBy(xpath="//label[normalize-space()='Transfer Details']") private WebElement lblTransferDetails;
	@FindBy(xpath="//label[@for='idFormEntry:idSOMTransferFrom']/following-sibling::span/select") private WebElement dropDownFrom;;
	@FindBy(xpath="//label[@for='idFormEntry:idBnk']/following-sibling::span/input") private WebElement txtRecipientBank;
	@FindBy(xpath="//label[@for='idFormEntry:idBnkAddress']/following-sibling::span/input") private WebElement txtRecipientBankAddress;
	@FindBy(xpath="//label[@for='idFormEntry:idSwiftCode']/following-sibling::span/input") private WebElement txtSwiftCode;
	@FindBy(xpath="//label[@for='idFormEntry:idAcctNo']/following-sibling::span/input") private WebElement txtToAcct;
	@FindBy(xpath="//label[@for='idFormEntry:idOneTimeFullNm']/following-sibling::span/input") private WebElement txtRecipientName;
	@FindBy(xpath="//label[@for='idFormEntry:idAmt']/parent::span/following-sibling::span/div/input") private WebElement txtAmount;
	@FindBy(xpath="//select[@id='idFormEntry:idCcy']") private WebElement dropDownCurrency;
	@FindBy(xpath="//label[normalize-space()='Equivalent Amount']") private WebElement lblEquivalentAmt;
	@FindBy(xpath="//label[@for='idFormEntry:idDescOpt']/following-sibling::span/input") private WebElement txtDescription;
	
	@FindBy(xpath="//label[@class='col-4 text-end fw-semibold']") private WebElement lblWhenToTransfer;
	@FindBy(xpath="//input[@id='idFormEntry:idRecur:0']") private WebElement radioBtnOneTimeTransfer;
	@FindBy(xpath="//input[@id='idFormEntry:idRecur:1']") private WebElement radioBtnRecurringTransfer;
	
	@FindBy(xpath="//input[@id='idFormEntry:idRecurringDate']") private WebElement calendarIcon;
	@FindBy(xpath="//select[@class='ui-datepicker-month']") private WebElement dropDownMonth;
	@FindBy(xpath="//select[@class='ui-datepicker-year']") private WebElement dropDownYear;

	//For Recurring transfer only
	
	@FindBy(xpath="//select[@id='idFormEntry:idFreq']") private WebElement dropDownRepeatFrequency;
	@FindBy(xpath="//input[@id='Occurrence']") private WebElement txtNumberOfTimes;
	//.....
	
	@FindBy(xpath="//input[@id='idFormEntry:idBtnSubmit']") private WebElement btnNext;
	
	
	//... Favourite Section
	
	@FindBy(xpath="//span[@class='col px-0']") private WebElement menuAddFavourite;
	@FindBy(xpath="//img[@class='cursor']") private WebElement btnDelete;
	@FindBy(xpath="//button[@class='btn btn-outline-primary me-1 min-100 rounded-4'][normalize-space()='No']") private WebElement btnNo;
	@FindBy(xpath="//button[@class='btn btn-glow rounded-4 min-100 btn-primary']//label[contains(text(),'Yes')]") private WebElement btnYes;
	
	@FindBy(xpath="//span[@class='fw-bold d-block']") private WebElement txtFavouriteAcctName;
	@FindBy(xpath="//img[@class='cursor']") private WebElement btnDeleteIcon;
	@FindBy(xpath="//input[@id='idFormEntry:chck_0']") private WebElement checkboxToSelectRecordForDelete;
	@FindBy(xpath="//button[@class='btn btn-danger min-100 rounded-4 d-inline-block align-middle m-0 ms-3']//label[contains(text(),'Yes')]") private WebElement btnYesConfirmDelete;;
	@FindBy(xpath="//button[contains(@class,'btn btn-outline-primary min-100 rounded-4 d-inline-block align-middle m-0')]") private WebElement btnNoForDelete;
	
	@FindBy(xpath="//span[text()='Overseas']") private List<WebElement> favRecordsList;
	
	//Error messages
	@FindBy(xpath="//input[@id='idFormEntry:idAcctNo']/following-sibling::span[contains(text(),'To Account is required')]") private WebElement errorMsgToAcct;
	@FindBy(xpath="//input[@id='idFormEntry:idAmt']/parent::div/following-sibling::span") private WebElement errorMsgAmount;
	@FindBy(xpath="//input[@id='idFormEntry:idDescOpt']/following-sibling::span[contains(text(),'Description is required')]") private WebElement errorMsgDesc;

	//******* Confirmation Section  **************
	
	@FindBy(xpath="//label[normalize-space()='From']/following-sibling::span") private WebElement txtFromConfirm;
	@FindBy(xpath="//label[normalize-space()='Recipient Bank']/following-sibling::span") private WebElement txtRecipientBankConfirm;
	@FindBy(xpath="//label[normalize-space()='Recipient Bank Address']/following-sibling::span") private WebElement txtRecipientBankAddrConfirm;
	@FindBy(xpath="//label[normalize-space()='SWIFT Code']/following-sibling::span") private WebElement txtSwiftCodeConfirm;
	@FindBy(xpath="//label[normalize-space()='To Account']/following-sibling::span") private WebElement txtToAcctConfirm;
	@FindBy(xpath="//label[normalize-space()='Recipient Name']/following-sibling::span") private WebElement txtRecipientNameConfirm;
	@FindBy(xpath="//label[contains(@for,'idFormEntry:idAmt')]/parent::span/following-sibling::span") private WebElement txtAmountConfirm;
	@FindBy(xpath="//label[normalize-space()='Equivalent Amount']/following-sibling::span") private WebElement txtEquivalentAmtConfirm;
	@FindBy(xpath="//label[normalize-space()='Description']/following-sibling::span") private WebElement txtDescriptionConfirm;
	@FindBy(xpath="//label[normalize-space()='When to Transfer']/following-sibling::span") private WebElement txtWhenToTransferConfirm;
	@FindBy(xpath="//label[contains(@for,'idFormCfmAckDtl:idTACAdd')]/following-sibling::span") private WebElement lblTacDetailsConfirm;
	@FindBy(xpath="//input[@id='idFormCfmAckDtl:idTACAdd']") private WebElement txtTac;

	@FindBy(xpath="//a[@class='btn btn-outline-primary min-100 px-4 rounded-4']") private WebElement btnBack;
	@FindBy(xpath="//input[@id='idFormCfmAckDtl:idBtnConfirmTrsf']") private WebElement btnSubmit;
	
	//Error msg
	@FindBy(xpath="//li[@class='error-msg']") private WebElement errMsgInvalidTac;
	
	//*******  Acknowledgement section **************
	@FindBy(xpath="//li[@class='success-msg']") private WebElement txtMsgSuccess;
	@FindBy(xpath="//label[normalize-space()='Reference Number']/following-sibling::span") private WebElement txtRefNumAck;
	@FindBy(xpath="//label[normalize-space()='Transaction Status']/following-sibling::span") private WebElement txtTranStatusAck;
	@FindBy(xpath="//label[normalize-space()='Transaction Date, Time']/following-sibling::span") private WebElement txtTranDateAck;
	@FindBy(xpath="//label[normalize-space()='From']/following-sibling::span") private WebElement txtFromAck;
	@FindBy(xpath="//label[normalize-space()='Recipient Bank']/following-sibling::span") private WebElement txtRecbankAck;
	@FindBy(xpath="//label[normalize-space()='Recipient Bank Address']/following-sibling::span") private WebElement txtRecBankAddrAck;
	@FindBy(xpath="//label[normalize-space()='SWIFT Code']/following-sibling::span") private WebElement txtSwiftCodeAck;
	@FindBy(xpath="//label[normalize-space()='To Account']/following-sibling::span") private WebElement txtToAcctAck;
	@FindBy(xpath="//label[normalize-space()='Recipient Name']/following-sibling::span") private WebElement txtRecNameAck;
	@FindBy(xpath="//label[contains(@for,'idFormEntry:idAmt')]/parent::span/following-sibling::span") private WebElement txtAmtAck;
	@FindBy(xpath="//label[normalize-space()='Equivalent Amount']/following-sibling::span") private WebElement txtEquivalentAmtAck;
	@FindBy(xpath="//label[normalize-space()='Description']/following-sibling::span") private WebElement txtDescAck;
	@FindBy(xpath="//label[normalize-space()='When to Transfer']/following-sibling::span") private WebElement txtWhenToTransferAck;
	@FindBy(xpath="//input[contains(@name,'idFormCfmAckDtl:j_idt438')]") private WebElement btnMakeAnotherTransfer;
	@FindBy(xpath="//input[@name='idFormCfmAckDtl:j_idt439']") private WebElement btnDone;

	
	
	
	
	public void verifyElementsAreDisplayedInDetailEntrySectionOneTimeTransfer() {
		
		boolean flag = false;
		
		flag = isDisplayed(lblTransferDetails,"") && isDisplayed(dropDownFrom,"") && isDisplayed(txtRecipientBank,"") && 
				isDisplayed(txtRecipientBankAddress,"") && isDisplayed(txtSwiftCode,"") && isDisplayed(txtToAcct,"") && 
				isDisplayed(txtRecipientName,"") && isDisplayed(txtAmount,"") && isDisplayed(dropDownCurrency,"") && 
				isDisplayed(lblEquivalentAmt,"") && isDisplayed(txtDescription,"") && isDisplayed(lblWhenToTransfer,"") &&
				isDisplayed(radioBtnOneTimeTransfer,"") && isDisplayed(radioBtnRecurringTransfer,"") &&
				isDisplayed(calendarIcon,"") && isDisplayed(btnNext,"");
		
		doAssertEqualsBoolean(flag, true, "Details Are displayed in Overseas Transfer - Details Entry Screen - One Time Transfer ?");
	}
	
	
	public void selectFromAcct(String value) {
		
		selectDropDownByValue(dropDownFrom, value);
	}
	
	public void keyInRecipientBank(String bankName) {
		doSendKeys(txtRecipientBank, bankName, "Bank Name");
	}
	
	public void keyInRecipientBankAddress(String bankAddress) {
		doSendKeys(txtRecipientBankAddress, bankAddress, "Bank Address");

	}
	
	public void keyInSwiftCode(String swiftCode) {
		doSendKeys(txtSwiftCode,swiftCode, "SWIFT Code" );
	}
	
	public void keyInToAccount(String toAcct) {
		doSendKeys(txtToAcct, toAcct, "To Account");
	}
	
	public void keyInRecipientName(String recName) {
		doSendKeys(txtRecipientName,recName,"Recipient name");
	}
	
	public void keyInAmount(String amt) {
		doSendKeys(txtAmount, amt, "Amount");
	}
	
	public void keyInDescription(String desc) {
		doSendKeys(txtDescription, desc, "Description");
	}
	
	
	public void selectWhenToTransfer(String whenToTrf) {
		if(whenToTrf.equalsIgnoreCase("One Time Transfer")) {
			doClick(radioBtnOneTimeTransfer, "One Time Transfer");
		}
		else if(whenToTrf.equalsIgnoreCase("Recurring Transfer")) {
			doClick(radioBtnRecurringTransfer, "Recurring Transfer");

		}
		else {
			
			throw new IllegalStateException("Invalid value provided for When to Transfer:"+ whenToTrf);
		}
	}
	
	public void selectDate(String date) {
		if(date.equalsIgnoreCase("Today")) {
			System.out.println("Today date selected by default");
		}
		
		else {
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			
		selectDateFromCalendar(date, calendarIcon, dropDownMonth, dropDownYear);
		
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void clickOnNextBtn() {
		doClick(btnNext, "Next button");
	}
	
	public void verifyConfirmScreenOneTimeTransfer() {
			boolean flag = false;
		
		flag = isDisplayed(txtFromConfirm,"") && isDisplayed(txtRecipientBankConfirm,"") && isDisplayed(txtRecipientBankAddrConfirm,"") && 
				isDisplayed(txtSwiftCodeConfirm,"") && isDisplayed(txtToAcctConfirm,"") && isDisplayed(txtRecipientNameConfirm,"") && 
				isDisplayed(txtAmountConfirm,"") && isDisplayed(txtEquivalentAmtConfirm,"") && isDisplayed(txtDescriptionConfirm,"") && 
				isDisplayed(txtWhenToTransferConfirm,"") && isDisplayed(lblTacDetailsConfirm,"") && isDisplayed(txtTac,"") &&

				isDisplayed(btnBack,"") && isDisplayed(btnSubmit,"");
		
		doAssertEqualsBoolean(flag, true, "Details Are displayed in Overseas Transfer - Confirm Screen - One Time Transfer ?");
	}
	
	public void keyInTac() {
		
		String userName = PropertyManager.propertyLoader().getProperty("userName");
		TACManager tacManager = new TACManager();
		String tac = tacManager.getTacCode(driver, userName);
		doSendKeys(txtTac, tac,"TAC code");
		
	}
	
	public void clickOnSubmitBtn() {
		doClick(btnSubmit, "Submit button");
	}
	
	

	
	public void verifySuccessMessage(String expMsg) {
		String actMsg = getText(txtMsgSuccess, "Success message");
		doAssertEqualsStrings(actMsg, expMsg, "Success message");
		
	}
	
	public void verifyAcknowledgmentScreenOneTimeTransfer() {
		boolean flag = false;
	
	flag = isDisplayed(txtRefNumAck,"") && isDisplayed(txtTranStatusAck,"") && isDisplayed(txtTranDateAck,"") && 
			isDisplayed(txtFromAck,"") && isDisplayed(txtRecbankAck,"") && isDisplayed(txtRecBankAddrAck,"") && 
			isDisplayed(txtSwiftCodeAck,"") && isDisplayed(txtToAcctAck,"") && isDisplayed(txtRecNameAck,"") && 
			isDisplayed(txtAmtAck,"") && isDisplayed(txtEquivalentAmtAck,"") && isDisplayed(txtDescAck,"") &&
			isDisplayed(txtWhenToTransferAck,"") &&
			isDisplayed(btnMakeAnotherTransfer,"") && isDisplayed(btnDone,"");
	
	doAssertEqualsBoolean(flag, true, "Details Are displayed in Overseas Transfer - Acknowledgement Screen - One Time Transfer ?");
}
	
	public OverseasTransferPage clickOnMakeAnotherTransferBtn() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
		try {
			doClick(btnMakeAnotherTransfer, "Make Anoter Transfer button");

		} catch (ElementClickInterceptedException e) {
			js.executeScript("arguments[0].scrollIntoView();",btnMakeAnotherTransfer);
			doClick(btnMakeAnotherTransfer, "Make Anoter Transfer button");

		}
		
		return this;
	}
	
	public HomePage clickOnDoneBtn() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
		try {
			doClick(btnDone, "Done button");
		} catch (ElementClickInterceptedException e) {
			js.executeScript("arguments[0].scrollIntoView();", btnDone);
			doClick(btnDone, "Done button");
		}
		
		return new HomePage(driver);
	}
	
	public void verifyTransferDetailsLabelIsDisplayed() {
		
		
		doAssertEqualsBoolean(isDisplayed(lblTransferDetails,"Transfer Details sub heading label"), true, "Transfer detaisl subheading displaeyd?");
	}
	
	
public void verifyElementsAreDisplayedInDetailEntrySectionRecurringTransfer() {
		
		boolean flag = false;
		
		flag = isDisplayed(lblTransferDetails,"") && isDisplayed(dropDownFrom,"") && isDisplayed(txtRecipientBank,"") && 
				isDisplayed(txtRecipientBankAddress,"") && isDisplayed(txtSwiftCode,"") && isDisplayed(txtToAcct,"") && 
				isDisplayed(txtRecipientName,"") && isDisplayed(txtAmount,"") && isDisplayed(dropDownCurrency,"") && 
				isDisplayed(lblEquivalentAmt,"") && isDisplayed(txtDescription,"") && isDisplayed(lblWhenToTransfer,"") &&
				isDisplayed(radioBtnOneTimeTransfer,"") && isDisplayed(radioBtnRecurringTransfer,"") &&
				isDisplayed(calendarIcon,"") && isDisplayed(btnNext,"")  && isDisplayed(dropDownRepeatFrequency,"") && isDisplayed(txtNumberOfTimes,"");
		
		doAssertEqualsBoolean(flag, true, "Details Are displayed in Overseas Transfer - Details Entry Screen - Recurring Transfer ?");
	}


	public void selectFrequencyOfTransfer(String freq) {
		
		try {
		selectValueFromDropDowm(dropDownRepeatFrequency, freq);
		}
		catch(StaleElementReferenceException e) {
			
			selectValueFromDropDowm(dropDownRepeatFrequency, freq);

		}
	}
	
	public void keyInNumberOfTimes(String numberOfTimes) {
		doSendKeys(txtNumberOfTimes,numberOfTimes, "Number of Times transfer to be done" );
	}
	
	public void verifyConfirmScreenRecurringTransfer() {
		boolean flag = false;
	
	flag = isDisplayed(txtFromConfirm,"") && isDisplayed(txtRecipientBankConfirm,"") && isDisplayed(txtRecipientBankAddrConfirm,"") && 
			isDisplayed(txtSwiftCodeConfirm,"") && isDisplayed(txtToAcctConfirm,"") && isDisplayed(txtRecipientNameConfirm,"") && 
			isDisplayed(txtAmountConfirm,"") && isDisplayed(txtEquivalentAmtConfirm,"") && isDisplayed(txtDescriptionConfirm,"") && 
			isDisplayed(txtWhenToTransferConfirm,"") && isDisplayed(lblTacDetailsConfirm,"") && isDisplayed(txtTac,"") &&

			isDisplayed(btnBack,"") && isDisplayed(btnSubmit,"");
	
	doAssertEqualsBoolean(flag, true, "Details Are displayed in Overseas Transfer - Confirm Screen - Recurring Transfer ?");
}
	
	public void verifyAcknowledgmentScreenRecurringTransfer() {
		boolean flag = false;
	
	flag = isDisplayed(txtRefNumAck,"") && isDisplayed(txtTranStatusAck,"") &&  
			isDisplayed(txtFromAck,"") && isDisplayed(txtRecbankAck,"") && isDisplayed(txtRecBankAddrAck,"") && 
			isDisplayed(txtSwiftCodeAck,"") && isDisplayed(txtToAcctAck,"") && isDisplayed(txtRecNameAck,"") && 
			isDisplayed(txtAmtAck,"") && isDisplayed(txtEquivalentAmtAck,"") && isDisplayed(txtDescAck,"") &&
			isDisplayed(txtWhenToTransferAck,"") &&
			isDisplayed(btnMakeAnotherTransfer,"") && isDisplayed(btnDone,"");
	
	doAssertEqualsBoolean(flag, true, "Details Are displayed in Overseas Transfer - Acknowledgement Screen - One Time Transfer ?");
}
	
	public void verifyErrorMsgToAcctFieldBlank(String expVal) {
		String actVal=getText(errorMsgToAcct,"To Account field blank error message");
		doAssertEqualsStrings(actVal, expVal, "To Account field blank error message displayed ?");
	}
	
	public void verifyErrorMsgAmountFieldBlank(String expVal) {
		String actVal=getText(errorMsgAmount,"Amount field blank error message");
		doAssertEqualsStrings(actVal, expVal, "Amount field blank error message displayed ?");
	}
	
	public void verifyErrorMsgDescriptionFieldBlank(String expVal) {
		String actVal=getText(errorMsgDesc,"Description field blank error message");
		doAssertEqualsStrings(actVal, expVal, "Description field blank error message displayed ?");
	}
	
	public void verifyErrorMsgInvalidTac(String expVal) {
		String actVal=getText(errMsgInvalidTac,"Invalid TAC error message").trim();
		doAssertEqualsStrings(actVal, expVal, "Invalid TAC error message displayed ?");
	}
	
	public void keyInInvalidTac(String invalidTac) {
		doSendKeys(txtTac, invalidTac, "Invalid Tac");
	}
	
	public void clickOnAddFavouriteMenu() {
		doClick(menuAddFavourite, "Add Favourite menu");
	}
	
	public void clickOnNoBtn() {
		doClick(btnNo, "No button");
	}
	
	public ManageFavouriteAccountsPage clickOnYesBtn() {
		doClick(btnYes, "No button");
		return new ManageFavouriteAccountsPage(driver);
	}
	
	public void verifyFavouriteAccountIsDisplayed() {
		doAssertEqualsBoolean(isDisplayed(txtFavouriteAcctName, "Favourite Account name"), true,"Favourite Account name displayed?");

	}
	
	public void verifyDeleteBinIconIsDisplayed() {
		doAssertEqualsBoolean(isDisplayed(btnDeleteIcon, "Delete / Bin Icon"), true, "Delete Icon displayed?");
	}
	
	int initialRecordCount=0;
	public void clickOnDeleteIcon() {
		initialRecordCount=favRecordsList.size();
		doClick(btnDeleteIcon, "Delete / Bin Icon");
	}
	
	public void clickOnCheckBoxToSelectRecordToDelete() {
		doClick(checkboxToSelectRecordForDelete, "Check box for selecting record to be deleted");
	}
	
	public void clickOnBtnNoForDeleteConfirmation() {
		doClick(btnNoForDelete, "No button for Delete confirmation pop up");
	}
	
	public void clickOnBtnYesForDeleteConfirmation() {
		doClick(btnYesConfirmDelete, "No button for Delete confirmation pop up");
	}
	
	public void verifyRecordIsDeleted() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		int countAfterDelete = favRecordsList.size();
		doAssertEqualsBoolean(countAfterDelete == (initialRecordCount-1), true, "Record deleted successfully ?");
	}
	
	public void verifyRecordIsNotDeleted() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		int countAfterDelete = favRecordsList.size();
		doAssertEqualsBoolean(countAfterDelete == initialRecordCount, true, "Record is NOT deleted  ?");
	}
	
}
