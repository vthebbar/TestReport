package com.qa.pages;

import java.text.DecimalFormat;
import java.util.List;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qa.utils.PropertyManager;
import com.qa.utils.TACManager;

public class SetDailyLimitPage extends BasePage {

	public SetDailyLimitPage(WebDriver driver) {
		super(driver);
	}

	// *** Enter Details section
	@FindBy(xpath = "//span[text()='Debit Card']/parent::td/following-sibling::td")
	private WebElement txtDebitCard;
	@FindBy(xpath = "//label[normalize-space()='Transaction Type']")
	private WebElement lblTranType;

	@FindBy(xpath = "//label[normalize-space()='Max Daily Limit (USD)']")
	private WebElement lblMaxDailyLimitUSD;
	// @FindBy(xpath="//label[normalize-space()='Max Daily Limit (KHR)']") private
	// WebElement lblMaxDailyLimitKHR;

	@FindBy(xpath = "//label[normalize-space()='Current Daily Limit (USD)']")
	private WebElement lblCurDailyLimitUSD;
	// @FindBy(xpath="//label[normalize-space()='Current Daily Limit (KHR)']")
	// private WebElement lblCurDailyLimitKHR;

	@FindBy(xpath = "//label[normalize-space()='New Daily Limit (USD)']")
	private WebElement lblNewDailyLimitUSD;
	// @FindBy(xpath="//label[normalize-space()='New Daily Limit (KHR)']") private
	// WebElement lblNewDailyLimitKHR;

	@FindBy(id = "idBtnSubmit")
	private WebElement btnNext;

	@FindBy(xpath = "//td[normalize-space()='Purchase Limit']/following-sibling::td")
	private List<WebElement> txtPurLimitColValues;
	@FindBy(xpath = "//td[normalize-space()='Withdrawal Limit']/following-sibling::td")
	private List<WebElement> txtWithdrLimitColValues;

	@FindBy(xpath = "//tbody/tr[1]/td[3]")
	private WebElement txtCurrentPurchaseLimit;
	@FindBy(xpath = "//tbody/tr[1]/td[3]")
	private WebElement txtCurrentWithdrawlLimit;

	@FindBy(xpath = "//input[@id='j_idt212']")
	private WebElement txtNewPurchaseLimit;
	@FindBy(xpath = "//input[@id='j_idt220']")
	private WebElement txtNewWithdrawlLimit;

	@FindBy(xpath = "//li[@class='error-msg']")
	private WebElement errMsg;

	// ***** Confirm Details section

	@FindBy(xpath = "//input[@id='idFormCfmAckDtl:idTACAdd']")
	private WebElement txtTac;
	@FindBy(xpath = "//input[@id='idFormCfmAckDtl:idBtnConfirmTrsf']")
	private WebElement btnSubmit;

	// **** Acknowledgement section
	@FindBy(xpath = "//li[@class='success-msg']")
	private WebElement msgSuccess;
	@FindBy(xpath = "//table/tbody/tr/td[text()='Debit Card']/following-sibling::td")
	private WebElement txtDebitCardConfirm;
	@FindBy(xpath = "//table/tbody/tr/td[text()='Purchase Limit']/following-sibling::td")
	private WebElement txtPurchaseLimitConfirm;
	@FindBy(xpath = "//table/tbody/tr/td[text()='Withdrawal Limit']/following-sibling::td")
	private WebElement txtWithdrawlLimitConfirm;
	@FindBy(xpath = "//label[normalize-space()='Transaction Type']")
	private WebElement lblTranTypeConfirm;
	@FindBy(xpath = "//label[normalize-space()='New Daily Limit (USD)']")
	private WebElement lblNewDailyLimitConfirm;

	@FindBy(xpath = "//input[@value='Done']")
	private WebElement btnDone;

	public void keyInValidPurchaseLimit() {

		String currentPurchaseLimit[] = getText(txtCurrentPurchaseLimit, "Current Purchase Limit").replace(",", "")
				.split("\\.");

		int cplimit = Integer.parseInt(currentPurchaseLimit[0]);
		double newPLimit = cplimit + Math.random() + 1;
		DecimalFormat decimalFormat = new DecimalFormat("#0.00");

		String newPurchaseLimit = String.valueOf(decimalFormat.format(newPLimit));

		doSendKeys(txtNewPurchaseLimit, newPurchaseLimit, "New Purchase Limit");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		doClick(txtDebitCard, "");
	}

	public void keyInNewWithDrawlLimit() {

		String currWithDrawlLimit[] = getText(txtCurrentWithdrawlLimit, "Current WithDrawl Limit").replace(",", "")
				.split("\\.");

		double newWLimit = Integer.parseInt(currWithDrawlLimit[0]) + Math.random() + 1;
		DecimalFormat decimalFormat = new DecimalFormat("#0.00");

		String newWithdrawalLimit = String.valueOf(decimalFormat.format(newWLimit));
		
		try {
		doSendKeys(txtNewWithdrawlLimit, newWithdrawalLimit, "New Withdrawal Limit");
		}
		catch(StaleElementReferenceException e) {
			doSendKeys(txtNewWithdrawlLimit, newWithdrawalLimit, "New Withdrawal Limit");

		}

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		doClick(txtDebitCard, "");
	}

	public void clickOnNextbtn() {
		try {
			doClick(btnNext, "Next button");
		} catch (Exception e) {
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
		doSendKeys(txtNewPurchaseLimit, pLimit, "Purchase Limit");
		doClick(txtDebitCard, "");
	}

	public void keyInWithdrawlLimit(String wLimit) {
		doSendKeys(txtNewWithdrawlLimit, wLimit, "Withdrawal Limit");
		doClick(txtDebitCard, "");

	}

	public void focusOnWithdrawalLimitBox() {
		doClick(txtNewWithdrawlLimit, "");
	}

	public void focusOnPurchaseLimitBox() {
		doClick(txtNewPurchaseLimit, "");
	}

	public void verifyErrorMsg(String expMsg) {
		String actMsg = getText(errMsg, "Error message");
		doAssertEqualsStrings(actMsg, expMsg, "Error message");

	}

	public void keyInInvalidTac(String inValidTac) {
		doSendKeys(txtTac, inValidTac, " TAC Entry - Invalid");

	}

	public void verifyDebitCardIsDisplayed() {

		doAssertEqualsBoolean(isDisplayed(txtDebitCard, "Debit Card"), true, "Debit Card is displayed?");
	}

	public void verifyTableHeadersAreDisplayed() {

		boolean flag = false;
		flag = isDisplayed(lblTranType, "") && isDisplayed(lblMaxDailyLimitUSD, "")
				&& isDisplayed(lblCurDailyLimitUSD, "") && isDisplayed(lblNewDailyLimitUSD, "");

		doAssertEqualsBoolean(flag, true, "Table headers displayed ?");

	}

	public void verifyPurchaseLimitValuesDisplayed() {
		if (txtPurLimitColValues.size() == 3) {

			doAssertEqualsBoolean(true, true, "Purchase Limit values displayed ?");
		} else {
			doAssertEqualsBoolean(false, true, "Purchase Limit values displayed ?");

		}
	}

	public void verifyWithdrawlLimitValuesDisplayed() {
		if (txtWithdrLimitColValues.size() == 3) {

			doAssertEqualsBoolean(true, true, "Withdrawl Limit values displayed ?");
		} else {
			doAssertEqualsBoolean(false, true, "Withdrawl Limit values displayed ?");

		}
	}

	public void verifyConfirmDetailsSection() {

		boolean flag = false;
		flag = isDisplayed(txtDebitCard, "") && isDisplayed(lblTranType, "") && isDisplayed(lblMaxDailyLimitUSD, "")
				&& isDisplayed(lblCurDailyLimitUSD, "") && isDisplayed(lblNewDailyLimitUSD, "")
				&& isDisplayed(txtTac, "") && isDisplayed(btnSubmit, "");

		boolean flag1 = txtPurLimitColValues.size() == 3 && txtWithdrLimitColValues.size() == 3;

		boolean finalFlag = flag && flag1;

		doAssertEqualsBoolean(finalFlag, true, "All Details displayed in Confirm Detail section ?");

	}

	public void verifyAcknowledgementSection() {
		boolean flag = false;
		flag = isDisplayed(msgSuccess, "") && isDisplayed(txtDebitCardConfirm, "")
				&& isDisplayed(txtPurchaseLimitConfirm, "") && isDisplayed(txtWithdrawlLimitConfirm, "")
				&& isDisplayed(lblTranTypeConfirm, "") && isDisplayed(lblNewDailyLimitConfirm, "")
				&& isDisplayed(btnDone, "");
	}

	public void clickOnDoneBtn() {

		doClick(btnDone, "Done button");
	}

}
