package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ESaverCloseAccountPage extends BasePage {

	public ESaverCloseAccountPage(WebDriver driver) {
		super(driver);
	}

	// ***** Enter Details section ****

	@FindBy(xpath = "//label[@for='idAccount']/following-sibling::span/select")
	private WebElement dropDownAcctNum;
	@FindBy(xpath = "//label[normalize-space()='Product']/following-sibling::span")
	private WebElement txtProduct;
	@FindBy(xpath = "//label[normalize-space()='Status']/following-sibling::span")
	private WebElement txtStatus;
	@FindBy(xpath = "//label[normalize-space()='Settlement Balance (USD)']/following-sibling::span")
	private WebElement txtSettlementBalanceUSD;
	@FindBy(xpath = "//label[normalize-space()='Closing Fee (USD)']/following-sibling::span")
	private WebElement txtClosingFeeUSD;
	@FindBy(xpath = "//label[normalize-space()='Total Amount (USD)']/following-sibling::span")
	private WebElement txtTotalAmtUSD;
	@FindBy(xpath = "//label[@for='idSOMReasonCode']/following-sibling::span/select")
	private WebElement dropDownReasonForClosing;
	@FindBy(xpath = "//label[@for='idSOMTranferType']/following-sibling::span/select")
	private WebElement dropDownTransferType;
	@FindBy(xpath = "//label[@for='idSOMOwnAcct']/following-sibling::span/select")
	private WebElement dropDownOwnAcctNum;
	@FindBy(id = "idBtnSubmit")
	private WebElement btnNext;

	// 3rd party transfer

	@FindBy(xpath = "//input[@id='idSOMThirdPartyAcct:0']")
	private WebElement radioBtnFavourite;
	@FindBy(xpath = "//input[@id='idSOMThirdPartyAcct:1']")
	private WebElement radioBtnNonFavourite;
	@FindBy(xpath = "//label[normalize-space()='Account Number']/following-sibling::span/select")
	private WebElement dropDownThirdPartyAcctNum;
	@FindBy(xpath = "//label[normalize-space()='Recipient Reference']/following-sibling::span/input")
	private WebElement txtRecipientRef;
	@FindBy(xpath = "//label[normalize-space()='Description']/following-sibling::span/input")
	private WebElement txtDescription;

	// Error messages
	@FindBy(xpath = "//span[@class='text-danger']")
	private WebElement txtErrMsg;

	// *** Confirm Details section ***

	@FindBy(xpath = "//label[normalize-space()='Account']/following-sibling::span")
	private WebElement txtAccountConfirm;
	@FindBy(xpath = "//label[normalize-space()='Product']/following-sibling::span")
	private WebElement txtProductConfirm;
	@FindBy(xpath = "//label[normalize-space()='Settlement Balance (USD)']/following-sibling::span")
	private WebElement txtSettlementBalanceUSDConfirm;
	@FindBy(xpath = "//label[normalize-space()='Closing Fee (USD)']/following-sibling::span")
	private WebElement txtClosingFeeUSDConfirm;
	@FindBy(xpath = "//label[normalize-space()='Total Amount (USD)']/following-sibling::span")
	private WebElement txtTotalAmtUSDConfirm;
	@FindBy(xpath = "//label[normalize-space()='Reason For Closing']/following-sibling::span")
	private WebElement txtReasonForClosingConfirm;
	@FindBy(xpath = "//label[normalize-space()='Transfer Type']/following-sibling::span")
	private WebElement txtTransferTypeConfirm;
	@FindBy(xpath = "//label[normalize-space()='To Account']/following-sibling::span")
	private WebElement txtToAcctConfirm;
	@FindBy(xpath = "//input[@value='Submit']")
	private WebElement btnSubmit;

	//3rd party transfer
	@FindBy(xpath="//label[normalize-space()='Recipient Reference']/following-sibling::span") private WebElement txtRecipientRefTPConfirm;
	@FindBy(xpath="//input[@type='password']") private WebElement txtTAC;
	
	
	// **** Acknowledgement section ****

	@FindBy(xpath = "//li[@class='success-msg']")
	private WebElement txtSuccessMsg;
	@FindBy(xpath = "//label[normalize-space()='Reference Number']/following-sibling::span")
	private WebElement txtRefNumAck;
	@FindBy(xpath = "//label[normalize-space()='Account']/following-sibling::span")
	private WebElement txtAcctNumAck;
	@FindBy(xpath = "//label[normalize-space()='Product']/following-sibling::span")
	private WebElement txtProductAck;
	@FindBy(xpath = "//label[normalize-space()='Settlement Balance (USD)']/following-sibling::span")
	private WebElement txtSettlementBalanceUSDAck;
	@FindBy(xpath = "//label[normalize-space()='Closing Fee (USD)']/following-sibling::span")
	private WebElement txtClosingFeeUSDAck;
	@FindBy(xpath = "//label[normalize-space()='Total Amount (USD)']/following-sibling::span")
	private WebElement txtTotalAmtUSDAck;
	@FindBy(xpath = "//label[normalize-space()='Reason For Closing']/following-sibling::span")
	private WebElement txtReasonForClosingAck;
	@FindBy(xpath = "//label[normalize-space()='Transfer Type']/following-sibling::span")
	private WebElement txtTransferTypeAck;
	@FindBy(xpath = "//label[normalize-space()='To Account']/following-sibling::span")
	private WebElement txtToAcctAck;
	@FindBy(xpath = "//input[@value='Done']")
	private WebElement btnDone;
	
	//3rd party
	@FindBy(xpath="//label[normalize-space()='Recipient Reference']/following-sibling::span") private WebElement txtRecipientRefTPAck;
	

	public void selectTransferType(String transferType) {
		selectValueFromDropDowm(dropDownTransferType, transferType);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void verifyEnterDetailsSection() {

		boolean flag = false;

		flag = isDisplayed(dropDownAcctNum, "") && isDisplayed(txtProduct, "") && isDisplayed(txtStatus, "")
				&& isDisplayed(txtSettlementBalanceUSD, "") && isDisplayed(txtClosingFeeUSD, "")
				&& isDisplayed(txtTotalAmtUSD, "") && isDisplayed(dropDownReasonForClosing, "")
				&& isDisplayed(dropDownTransferType, "") && isDisplayed(dropDownOwnAcctNum, "")
				&& isDisplayed(btnNext, "");

		doAssertEqualsBoolean(flag, true, "All fields displayed ?");
	}

	public void selectAccountNum(int index) {
		selectDropDownyIndex(dropDownAcctNum, index);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void seletOwnAcctNumForTransfer(int val) {
		selectDropDownyIndex(dropDownOwnAcctNum, val);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickOnNextBtn() {
		doClick(btnNext, "Next button");
	}

	public void verifyErrorMessage(String expVal) {
		String actVal = getText(txtErrMsg, "Error message");

		doAssertEqualsStrings(actVal, expVal, "Error message");
	}

	public void selectReasonForClosing(String reason) {
		selectValueFromDropDowm(dropDownReasonForClosing, reason);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void verifyConfirmDetailsSection() {

		boolean flag = false;

		flag = isDisplayed(txtAccountConfirm, "") && isDisplayed(txtProductConfirm, "")
				&& isDisplayed(txtSettlementBalanceUSDConfirm, "") && isDisplayed(txtClosingFeeUSDConfirm, "")
				&& isDisplayed(txtTotalAmtUSDConfirm, "") && isDisplayed(txtReasonForClosingConfirm, "")
				&& isDisplayed(txtTransferTypeConfirm, "") && isDisplayed(txtToAcctConfirm, "")
				&& isDisplayed(btnSubmit, "");

		doAssertEqualsBoolean(flag, true, "All fields displayed ?");
	}

	public void clickOnSubmitBtn() {
		doClick(btnSubmit, "Submit button");
	}

	public void verifySuccessMesage(String expVal) {
		String actVal = getText(txtSuccessMsg, "Success message");
		doAssertEqualsStrings(actVal, expVal, "Success message");
	}

	public void verifyAcknowledgementDetailsAreDisplayed() {
		boolean flag = false;

		flag = isDisplayed(txtSuccessMsg, "") && isDisplayed(txtRefNumAck, "") && isDisplayed(txtAcctNumAck, "")
				&& isDisplayed(txtProductAck, "") && isDisplayed(txtSettlementBalanceUSDAck, "")
				&& isDisplayed(txtClosingFeeUSDAck, "") && isDisplayed(txtTotalAmtUSDAck, "")
				&& isDisplayed(txtReasonForClosingAck, "") && isDisplayed(txtTransferTypeAck, "")
				&& isDisplayed(txtToAcctAck, "") && isDisplayed(btnDone, "");

		doAssertEqualsBoolean(flag, true, "All fields displayed ?");
	}

	public void clickOnDoneBtn() {
		doClick(btnDone, "");
	}

	public void verifyEnterDetailsThirdPartyTransfer() {
		boolean flag = false;

		flag = isDisplayed(dropDownAcctNum, "") && isDisplayed(txtProduct, "") && isDisplayed(txtStatus, "")
				&& isDisplayed(txtSettlementBalanceUSD, "") && isDisplayed(txtClosingFeeUSD, "")
				&& isDisplayed(txtTotalAmtUSD, "") && isDisplayed(dropDownReasonForClosing, "")
				&& isDisplayed(dropDownTransferType, "") && isDisplayed(radioBtnFavourite,"") && isDisplayed(radioBtnNonFavourite,"")
				&& isDisplayed(dropDownThirdPartyAcctNum,"") && isDisplayed(txtRecipientRef,"") && isDisplayed(txtDescription,"")
				&& isDisplayed(btnNext, "");

		doAssertEqualsBoolean(flag, true, "All fields displayed ?");
	}
}
