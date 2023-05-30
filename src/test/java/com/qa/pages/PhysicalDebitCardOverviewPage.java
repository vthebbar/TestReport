package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PhysicalDebitCardOverviewPage extends BasePage {

	public PhysicalDebitCardOverviewPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//p[@class='mb-0']") private WebElement txtCardNumber;
	@FindBy(xpath="//div[@class='d-inline-block align-top']") private WebElement txtValidThrough;
	@FindBy(xpath="//div[normalize-space()='***']") private WebElement txtCVV;
	@FindBy(xpath="//label[normalize-space()='Account Balance']") private WebElement lblAcctBalancel;
	@FindBy(xpath="//label[normalize-space()='Account Balance']/parent::p/following-sibling::p") private WebElement txtAccountBalanceAmt;
	@FindBy(xpath="//label[normalize-space()='Linked Account']") private WebElement lblLinkedAccount;
	@FindBy(xpath="//label[normalize-space()='Linked Account']/parent::p/following-sibling::p") private WebElement txtLinkedAccount;
	@FindBy(xpath="//label[normalize-space()='Card Status']") private WebElement lblCardStatus;
	@FindBy(xpath="//label[normalize-space()='Card Status']/parent::p/following-sibling::p") private WebElement txtCardStatus;
	
	@FindBy(css=".fw-semibold.f16.text-grey.pt-1.pe-2.cursor.pointer") private WebElement menuManageCardSettings;
	@FindBy(xpath="//span[@class='d-inline-block me-2 text-black fw-bold']") private WebElement lblTransactionTimeline;
	
	// Transaction Timeline Table
	@FindBy(xpath="//th[@class='d-print-none']//span[@class='d-block text-uppercase'][normalize-space()='Ref No.']") private WebElement lblRefNo;
	@FindBy(xpath="//span[normalize-space()='Date']") private WebElement lblDate;
	@FindBy(xpath="//span[normalize-space()='Description']") private WebElement lblDescription;
	@FindBy(xpath="//span[normalize-space()='Incoming (USD)']") private WebElement lblIncoming;
	@FindBy(xpath="//span[normalize-space()='Outgoing (USD)']") private WebElement lblOutging;

	//Manage settings 
	@FindBy(xpath="//div[@class='col-9']//li[2]//a[1]//span[1]") private WebElement menuBlockUnblockPhysicalCard;
	@FindBy(xpath="//span[@class='d-inline-block align-top text-nowrap'][normalize-space()='Block/Unblock E-commerce']") private WebElement menuBlockUnblockEcommerce;
	@FindBy(xpath="//span[@class='d-inline-block align-top text-nowrap'][normalize-space()='Block/Unblock Overseas ATM/POS']") private WebElement menuBlockUnblockOverseasATMPOS;
	@FindBy(xpath="//a[@class='nav-link text-nowrap fw-normal']//span[@class='d-inline-block align-middle'][normalize-space()='Change Debiting Account']") private WebElement menuChangeDebitingAccount;
	@FindBy(xpath="//a[@class='nav-link text-nowrap fw-normal']/span[@class='d-inline-block align-middle'][normalize-space()='Set Daily Limit']") private WebElement menuSetDailyLimit;
	@FindBy(xpath="//a[@class='nav-link text-nowrap fw-normal']/span[@class='d-inline-block align-middle'][normalize-space()='Travel Notification Service']") private WebElement menuTravelNotification;
	@FindBy(xpath="//a[@class='nav-link text-nowrap fw-normal']/span[contains(text(),'Request Card Renewal')]") private WebElement menuRequestCardRenewal;
	@FindBy(xpath="//*[@id=\"j_idt151\"]/div/ul/li[9]/a/span") private WebElement menuReportCardLostStolen;
	@FindBy(xpath="//a[@class='nav-link text-nowrap fw-normal']/span[@class='d-inline-block align-middle'][normalize-space()='Reset PIN']") private WebElement menuResetPIN;


	
	
	public void verifyCardNumberIsDisplayed() {
		
		String cardNum = getText(txtCardNumber, "Card Number").trim();
		System.out.println("Card Number="+cardNum);
		doAssertEqualsBoolean(cardNum.length()>=16, true, "Card Number");
	}
	
	public void verifyValidThroughIsDisplayed() {
		String validThrough = getText(txtValidThrough,"Valid Through");
		System.out.println("Valid Through="+validThrough);
		doAssertEqualsBoolean(validThrough.length()>=5, true, "Valid Through");
	}
	
	public void verifyCvvIsDisplayed() {
		String cvv = getText(txtCVV, "CVV");
		doAssertEqualsBoolean(cvv.length()==3, true, "CVV");
	}
	
	public void verifyAccountBalanceIsDisplayed() {
		doAssertEqualsBoolean(isDisplayed(lblAcctBalancel, "Account Balance Label"), true, "Account Balance Label");
		doAssertEqualsBoolean(isDisplayed(txtAccountBalanceAmt, "Account Balance Value"), true, "Account Balance Value");

	}
	
	public void verifyLinkedAccountIsDisplayed() {
		doAssertEqualsBoolean(isDisplayed(lblLinkedAccount, "Linked Account Label"), true, "Linked Account Label");
		doAssertEqualsBoolean(isDisplayed(txtLinkedAccount, "Linked Account Value"), true, "Linked Account Value");
	}
	
	public void verifyCardStatusIsDisplayed() {
		doAssertEqualsBoolean(isDisplayed(lblCardStatus, "Card Status Label"), true, "Card Status Label");
		doAssertEqualsBoolean(isDisplayed(txtCardStatus, "Card Status Value"), true, "Card Status Value");

	}
	
	public void verifyManageSettinsgMenuIsDisplayed() {
		doAssertEqualsBoolean(isDisplayed(menuManageCardSettings, "Manage Card Settings"), true, "Manage Card Settings");
	}
	
	public void verifyTransactionTimeLineLabelIsDisplayed() {
		doAssertEqualsBoolean(isDisplayed(lblTransactionTimeline, "Transaction Timeline"), true, "Transaction Timeline");

	}
	
	// TC03
	public void verifyTransactionTimeLineTableHeadings() {
		
		boolean res = isDisplayed(lblRefNo,"") && isDisplayed(lblDate,"") && isDisplayed(lblDescription, "") && isDisplayed(lblIncoming, "") && isDisplayed(lblOutging, "");
		doAssertEqualsBoolean(res, true, "Transaction Timeline Table Headings");
	}
	
	//S10
	public void clickOnManageCardSettings() {
		doClick(menuManageCardSettings, "Manage Card Settings");
	}
	
	public void verifyManageCardSettingOptionsAreDisplayed() {
		
		Boolean res=false;
		
		res = isDisplayed(menuBlockUnblockPhysicalCard,"") && isDisplayed(menuBlockUnblockEcommerce,"") && isDisplayed(menuBlockUnblockOverseasATMPOS, "") &&
				isDisplayed(menuChangeDebitingAccount, "") && isDisplayed(menuSetDailyLimit,"") && isDisplayed(menuTravelNotification, "") && isDisplayed(menuRequestCardRenewal, "") &&
				isDisplayed(menuReportCardLostStolen, "") && isDisplayed(menuResetPIN, "");
		
		doAssertEqualsBoolean(res, true, "Card Settings menu options");
	}
	
	public BlockUnblockPhysicalDebitCardPage clickOnBlockUnBlockPhysicalDebitCard() {
		doClick(menuBlockUnblockPhysicalCard, "Block/Unblock Physical Debit Card");
		return new BlockUnblockPhysicalDebitCardPage(driver);
	}
	
	//S10_TC06
	public BlockUnBlockEcommercePage clickOnBlockUnblockEcommerce() {
		
		doClick(menuBlockUnblockEcommerce, "Block/Unblock E-commerce");
		return new BlockUnBlockEcommercePage(driver);
	}
	
	//S10_TC07
	public BlockUnblockOverseasATMPOSPage clickOnBlockUnblockOverseasATMPOS() {
		
		doClick(menuBlockUnblockOverseasATMPOS, "Block/Unblock Overseas ATM/POS");
		return new BlockUnblockOverseasATMPOSPage(driver);
	}
	
	//S010_TC08
	
	public ChangeDebitingAccountPage clickOnChangeDebitingAccount() {
		doClick(menuChangeDebitingAccount, "Change Debiting Account");
		return new ChangeDebitingAccountPage(driver);
	}
	
	//S10_TC10
	
	public SetDailyLimitPage clickOnSetDailyLimit() {
		
		doClick(menuSetDailyLimit, "Set Daily Limit menu");
		return new SetDailyLimitPage(driver);
	}
	
	public TravelNotificationServicePage clickOnTravelNotificationService() {
		
		doClick(menuTravelNotification, "Travel Notification Service");
		
		return new TravelNotificationServicePage(driver);
	}
	
	//S10_TC20
	
	public ResetPinPage clickOnResetPINMenu() {
		
		doClick(menuResetPIN, "Reset PIN");
		return new ResetPinPage(driver);
	}
}
