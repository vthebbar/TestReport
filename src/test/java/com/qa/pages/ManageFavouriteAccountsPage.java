package com.qa.pages;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qa.utils.PropertyManager;
import com.qa.utils.TACManager;

public class ManageFavouriteAccountsPage extends BasePage {

	public ManageFavouriteAccountsPage(WebDriver driver) {
		super(driver);
	}
	
	
	//******** Details entry section
	@FindBy(xpath="//label[normalize-space()='Recipient Information']") private WebElement lblReceipientInfo;
	@FindBy(xpath="//label[@for='idBnk']/following-sibling::span/select") private WebElement dropDownTransactionType;
	@FindBy(xpath="//label[normalize-space()='Recipient Account Type']/following-sibling::span") private WebElement txtReceipientAcctType;
	@FindBy(xpath="//label[normalize-space()='Recipient Bank Address']/following-sibling::span/input") private WebElement txtReceipientBankAddress;
	@FindBy(xpath="//label[@for='idAcctNo']/following-sibling::span/input") private WebElement txtToAccount;
	@FindBy(xpath="//label[@for='idNickNm']/following-sibling::span/input") private WebElement txtFavouriteAcctName;
	@FindBy(id="idBtnSubmit") private WebElement btnNext;
	
	
	 //For local Transfer only
	
	@FindBy(xpath="//label[normalize-space()='Recipient Bank']/following-sibling::span/select") private WebElement dropDownRecipientBank;
	@FindBy(xpath="//label[normalize-space()='Recipient Bank Branch']/following-sibling::span/input") private WebElement txtRecipientBranch;
	@FindBy(xpath="//label[@for='idAcctNo2']/following-sibling::span/input") private WebElement txtToAcct;;
	
	//Local+Overseas
	@FindBy(xpath="//label[@for='idFullNm']/following-sibling::span/input") private WebElement txtRecipientName;
	@FindBy(xpath="//label[@for='idNickNm']/following-sibling::span/input") private WebElement txtFavAcctName;
	
	//For overseas Transfer Only
	@FindBy(xpath="//label[normalize-space()='Recipient Bank']/following-sibling::span/input") private WebElement txtRecipientBank;
	@FindBy(xpath="//label[normalize-space()='SWIFT Code']/following-sibling::span/input") private WebElement txtSwiftCode;
	@FindBy(xpath="//label[@for='idAcctNo3']/following-sibling::span/input") private WebElement txtToAcctOverseas;
	@FindBy(xpath="//label[@for='idCurrency']/following-sibling::span/select") private WebElement dropDownRecipientAcctCurrency;

	
	
	//****** Confirmation section
	@FindBy(id="idTACAdd") private WebElement txtTac;
	@FindBy(xpath="//input[@value='Submit']") private WebElement btnSUbmit;
	
	@FindBy(xpath="//label[normalize-space()='Recipient Bank']/following-sibling::span") private WebElement txtReceipientBankName;
	@FindBy(xpath="//label[normalize-space()='Recipient Account Type']/following-sibling::span") private WebElement txtReceipientAcctTypeConfirm;
	@FindBy(xpath="//label[normalize-space()='To Account']/following-sibling::span") private WebElement txtToAcctConfirm;
	@FindBy(xpath="//label[normalize-space()='Recipient Name']/following-sibling::span") private WebElement txtReceipientNameConfirm;
	@FindBy(xpath="//label[normalize-space()='Favourite Account Name']/following-sibling::span") private WebElement txtFavouriteAcctNameConfirm;
	@FindBy(xpath="idBtnResend") private WebElement linkTacResend;
	
	
	//******* Acknowledgement Section
	
	@FindBy(xpath="//li[@class='success-msg mb-0']") private WebElement txtMsgSuccess;
	@FindBy(xpath="//label[normalize-space()='Reference Number']/following-sibling::span") private WebElement txtRefNumAck;
	@FindBy(xpath="//label[normalize-space()='Transaction Date, Time']/following-sibling::span") private WebElement txtRansactionDateTimeAck;
	@FindBy(xpath="//label[normalize-space()='Recipient Bank']/following-sibling::span") private WebElement txtReceipientBankAck;
	
	@FindBy(xpath="//label[normalize-space()='Recipient Account Type']/following-sibling::span") private WebElement txtReceipientAcctTypeAck;
	
	@FindBy(xpath="//label[normalize-space()='To Account']/following-sibling::span") private WebElement txtToAccountAck;
	@FindBy(xpath="//label[normalize-space()='Recipient Name']/following-sibling::span") private WebElement txtReceipientNameAck;
	@FindBy(xpath="//label[normalize-space()='Favourite Account Name']/following-sibling::span") private WebElement txtFavouriteAcctNameAck;
	@FindBy(xpath="//input[@value='Done']") private WebElement btnDone;
	
	//For Local Transfer
	@FindBy(xpath="//label[normalize-space()='Recipient Bank Branch']/following-sibling::span") private WebElement txtRecipientBranchAck;
	@FindBy(xpath="//input[@name='j_idt314']") private WebElement btnDoneLocalTransfer;
	
	//For overseas Transfer only
	@FindBy(xpath="//label[normalize-space()='Recipient Bank Address']/following-sibling::span") private WebElement txtRecipientBankAddrAck;
	@FindBy(xpath="//label[@class='col-3 col-form-label text-nowrap text-end fw-semibold']/following-sibling::span") private WebElement txtRecipientBankCurrency;
	
	
	public void selectTransactionTypeDropDownValue(String visibleText) {
		selectValueFromDropDowm(dropDownTransactionType, visibleText);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void keyInRecipientBankAddress(String bankAddress) {
		doSendKeys(txtReceipientBankAddress,bankAddress, "Receipient Bank Addess" );
	}
	
	public void keyInToAccountNumber(String toAcct) {
		doSendKeys(txtToAccount,toAcct, "To Account number");
	}
	
	public void keyInFavouriteAcctName(String favAcctName) {
		
		favAcctName= favAcctName+generateRandomString(5);
		
		doSendKeys(txtFavouriteAcctName,favAcctName, "Favourite Account name");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		doClick(lblReceipientInfo,"");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickOnNextBtn() {
		
		
		try {
		doClick(btnNext, "Next button");
		}
		catch(StaleElementReferenceException e){
			doClick(btnNext, "Next button");
		}
		
		
		
		
	}
	
	public void keyInTac() {
		
		String userName = PropertyManager.propertyLoader().getProperty("userName");
		TACManager tacManager = new TACManager();
		String tac =tacManager.getTacCode(driver, userName);
		doSendKeys(txtTac, tac, "TAC code");
	}
	
	public void clickOnSubmitBtn() {
		doClick(btnSUbmit, "Submit button");
	}
	
	public void verifySuccessMessage(String expMsg) {
		String actMsg = getText(txtMsgSuccess, "Success message");
		doAssertEqualsStrings(actMsg, expMsg, "Success message");
	}
	
	public void verifyAcknowledgementDetailsAreDisplayed() {
		boolean flag = false;
		flag = isDisplayed(txtMsgSuccess,"") && isDisplayed(txtRefNumAck,"") && isDisplayed(txtRansactionDateTimeAck,"") &&
				isDisplayed(txtReceipientBankAck,"") && isDisplayed(txtReceipientAcctTypeAck,"") && isDisplayed(txtToAccountAck,"") &&
				isDisplayed(txtReceipientNameAck,"") && isDisplayed(txtFavouriteAcctNameAck,"") && isDisplayed(btnDone,"");
		
		doAssertEqualsBoolean(flag, true, "Acknowledgement detaisl displayed?");
	}
	
	public void clickOnDonebtn() {
		doClick(btnDone, "Done button");
	}
	
	//****For Local Transfer
	public void selectRecipientBank(String bankName) {
		selectValueFromDropDowm(dropDownRecipientBank,bankName );
	}
	
	public void keyInRecipientBankBranch(String branchName) {
		doSendKeys(txtRecipientBranch,branchName,"Bank Branch name");
	}
	
	public void keyInToLocalAcctNum(String localAcctNum) {
		doSendKeys(txtToAcct, localAcctNum, "Local Account number");
	}
	
	public void keyInLocalRecipientName(String localRecName) {
		doSendKeys(txtRecipientName, localRecName, "Local Recipient name");
	}
	
	public void keyInLocalRecFavName(String favName) {
		doSendKeys(txtFavAcctName, favName, "Favourite name for local recipient");
		doClick(lblReceipientInfo,"");
	}
	
	public void verifyAcknowledgementDetailsAreDisplayedLocalAddFav() {
		boolean flag = false;
		flag = isDisplayed(txtMsgSuccess,"") && isDisplayed(txtRefNumAck,"") && isDisplayed(txtRansactionDateTimeAck,"") &&
				isDisplayed(txtReceipientBankAck,"") && isDisplayed(txtRecipientBranchAck,"") && isDisplayed(txtToAccountAck,"") &&
				isDisplayed(txtReceipientNameAck,"") && isDisplayed(txtFavouriteAcctNameAck,"") && isDisplayed(btnDone,"");
		
		doAssertEqualsBoolean(flag, true, "Acknowledgement details displayed for Local Transfer Add Favourite?");
	}
	
	
	public void verifyAcknowledgementDetailsAreDisplayedOverseasAddFav() {
		boolean flag = false;
		flag = isDisplayed(txtMsgSuccess,"") && isDisplayed(txtRefNumAck,"") && isDisplayed(txtRansactionDateTimeAck,"") &&
				isDisplayed(txtReceipientBankAck,"") && isDisplayed(txtRecipientBankAddrAck,"") && isDisplayed(txtToAccountAck,"") &&
				isDisplayed(txtReceipientNameAck,"") && isDisplayed(txtFavouriteAcctNameAck,"") && isDisplayed(btnDone,"") &&
				isDisplayed(txtRecipientBankCurrency,"");
		
		doAssertEqualsBoolean(flag, true, "Acknowledgement details displayed for Overseas Transfer Add Favourite?");
	}
	
	public void keyInRecipientBank(String recBank) {
		doSendKeys(txtRecipientBank, recBank, "Recipient Bank name");
	}
	
	public void keyInSwiftCode(String swiftcode) {
		doSendKeys(txtSwiftCode, swiftcode, "SWIFT code");
	}
	
	public void keyInToAcctOverseas(String toAcctOverseas) {
		doSendKeys(txtToAcctOverseas, toAcctOverseas, "To Account Overseas");

	}
	
	public void selectRecipientCurrency(String currency) {
		selectValueFromDropDowm(dropDownRecipientAcctCurrency,currency);
	}
	
	public void keyInRecipientName(String recName) {
		doSendKeys(txtRecipientName, recName, "Recipient Name");

	}
	
public void keyInRecipientFavName(String recFavName) {
	doSendKeys(txtFavAcctName, recFavName, "Recipient Favourite Name");

	}
}
