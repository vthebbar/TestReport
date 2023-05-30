package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VirtualDebitCardOverviewPage extends BasePage {

	public VirtualDebitCardOverviewPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//p[@class='mb-0']")
	private WebElement txtCardNumber;
	@FindBy(xpath = "//div[@class='d-inline-block align-top']")
	private WebElement txtExpiryDate;
	@FindBy(xpath = "//span[normalize-space()='CVV']/parent::div/following-sibling::div")
	private WebElement txtCVV;;

	@FindBy(xpath = "//label[normalize-space()='Account Balance']/parent::p/following-sibling::p")
	private WebElement txtAcctBalance;
	@FindBy(xpath = "//label[normalize-space()='Linked Account']/parent::p/following-sibling::p")
	private WebElement txtLinkedAcct;
	@FindBy(xpath = "//label[normalize-space()='Card Status']/parent::p/following-sibling::p")
	private WebElement txtCardStatus;
	@FindBy(xpath = "//label[normalize-space()='Note']/parent::p/following-sibling::p")
	private WebElement txtNote;

	@FindBy(xpath = "//span[@class='d-inline-block me-2 text-black fw-bold']")
	private WebElement lblTransactionTimeline;
	@FindBy(xpath = "//th[@class='d-print-none']//span[@class='d-block text-uppercase'][normalize-space()='Ref No.']")
	private WebElement lblRefNo;
	@FindBy(xpath = "//span[normalize-space()='Date']")
	private WebElement lblDate;
	@FindBy(xpath = "//span[normalize-space()='Description']")
	private WebElement lblDescription;
	@FindBy(xpath = "//span[normalize-space()='Incoming (USD)']")
	private WebElement lblIncoming;
	@FindBy(xpath = "//span[normalize-space()='Outgoing (USD)']")
	private WebElement lblOutgoing;

	@FindBy(xpath="//div[@class='fw-semibold f16 text-grey pt-1 pe-2 cursor pointer']") private WebElement menuManageCardSettings;
	
	@FindBy(xpath="//div[@class='card-header text-uppercase']//li[1]//a[1]//span[1]") private WebElement menuBlockunblock;
	@FindBy(xpath="//a[@class='nav-link text-nowrap fw-normal']//span[@class='d-inline-block align-middle'][normalize-space()='Change Debiting Account']") private WebElement menuChanegDebitAcct;
	@FindBy(xpath="//a[@class='nav-link text-nowrap fw-normal']//span[@class='d-inline-block align-middle'][normalize-space()='Set Daily Limit']") private WebElement menuSetDailyLimit;
	@FindBy(xpath="//div[@class='col-9']//li[4]//a[1]//span[1]") private WebElement menuCreateUpdateNote;
	
	public void verifyCardNumberIsDisplayed() {

		doAssertEqualsBoolean(isDisplayed(txtCardNumber, "Card Number"), true, "Card Number");
	}

	public void verifyCardExpiryDateIsDisplayed() {

		doAssertEqualsBoolean(isDisplayed(txtExpiryDate, "Card Expiry Date"), true, "Card Expiry");

	}

	public void verifyCardCVVIsDisplayed() {

		doAssertEqualsBoolean(isDisplayed(txtCVV, "Card CVV"), true, "Card CVV");

	}

	public void verifyAcctBalanceIsDisplayed() {
		doAssertEqualsBoolean(isDisplayed(txtAcctBalance, "Account Balance"), true, "Account Balance");

	}
	
	public void verifyLinkedAcctIsDisplayed() {
		doAssertEqualsBoolean(isDisplayed(txtLinkedAcct, "Linked Account"), true, "Linked Account");

	}
	
	public void verifyCardStatusIsDisplayed() {
		doAssertEqualsBoolean(isDisplayed(txtCardStatus, "Card Status"), true, "Card Status");

	}
	
	public void verifyNoteIsDisplayed() {
		doAssertEqualsBoolean(isDisplayed(txtNote, "Note"), true, "Note");

		
	}
	
	public void verifyTransactionTimeLineHeadingIsDisplayed() {
		doAssertEqualsBoolean(isDisplayed(lblTransactionTimeline, "Transaction Timeline Heading"), true, "Transaction Timeline Heading");

	}
	
	public void verifyTransactionTimeLineTableHeadingsAreDisplayed() {
		
		boolean res = isDisplayed(lblRefNo,"") && isDisplayed(lblDate,"") && isDisplayed(lblDescription,"") && isDisplayed(lblIncoming,"") && isDisplayed(lblOutgoing,"");
	
		doAssertEqualsBoolean(res, true, "Transaction Timeline Table Headings");

	}
	
	public void clickOnManageCardSettings() {
		
		doClick(menuManageCardSettings, "Manage Card Settings");
	}
	
	public void verifyManageCardSettingOptionsAreDisplayed() {
		
		boolean res = isDisplayed(menuBlockunblock,"") & isDisplayed(menuChanegDebitAcct,"") && isDisplayed(menuSetDailyLimit,"") && isDisplayed(menuCreateUpdateNote,"");
		doAssertEqualsBoolean(res, true, "Manage Card Setting Options");
	}
	
	public void clickOnBlockUnblockVirtualCard() {
		
		doClick(menuBlockunblock, "Block Unblock Virtual Card");
	}
	
	public ChangeDebitingAcctVirtualCardPage clickOnChangeDebitingAcct() {
		
		doClick(menuChanegDebitAcct, "Change Debiting Account");
		return new ChangeDebitingAcctVirtualCardPage(driver);
	}
	
	public SetDailyLimitVirtualCardPage clickOnSetDailyLimit() {
		doClick(menuSetDailyLimit, "Set Daily Limit");
		return new SetDailyLimitVirtualCardPage(driver);
	}
	
	public CreateUpdateNoteVirtualCardPage clickOnCreateUpdateNoteMenu() {
		
		doClick(menuCreateUpdateNote,"Create/Update Notes");
		return new CreateUpdateNoteVirtualCardPage(driver);
	}
}
