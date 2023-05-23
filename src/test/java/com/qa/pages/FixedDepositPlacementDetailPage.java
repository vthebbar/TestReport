package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FixedDepositPlacementDetailPage extends BasePage {

	public FixedDepositPlacementDetailPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//label[normalize-space()='Account']") private WebElement lblAccount;
	@FindBy(xpath="//label[normalize-space()='Account']/parent::td/following-sibling::td") private WebElement txtAccountNo;
	
	@FindBy(xpath="//label[normalize-space()='Account Status']") private WebElement lblAcctStatus;
	@FindBy(xpath="//label[normalize-space()='Account Status']/parent::td/following-sibling::td") private WebElement txtAcctStatus;
	
	@FindBy(xpath="//label[normalize-space()='Principal Amount (KHR)']") private WebElement lblPrincipalAmtKhr;
	@FindBy(xpath="//label[normalize-space()='Principal Amount (KHR)']/parent::td/following-sibling::td") private WebElement txtPrincipalAmtKhr;
	@FindBy(xpath="//label[normalize-space()='Principal Amount (USD)']/parent::td/following-sibling::td") private WebElement txtPrincipalAmtUSD;

	
	@FindBy(xpath="//label[normalize-space()='Tenure']") private WebElement lblTenure;
	@FindBy(xpath="//label[normalize-space()='Tenure']/parent::td/following-sibling::td") private WebElement txtTenure;
	
	
	@FindBy(xpath="//td[normalize-space()='Rate (%)']") private WebElement lblRate;
	@FindBy(xpath="//td[normalize-space()='Rate (%)']/following-sibling::td") private WebElement txtRate;
	
	@FindBy(xpath="//label[normalize-space()='Last Renewal Date']") private WebElement lblLastRenewalDate;
	
	
	@FindBy(xpath="//label[normalize-space()='Placement Date']") private WebElement lblPlacementDate;
	@FindBy(xpath="//label[normalize-space()='Placement Date']/parent::td/following-sibling::td") private WebElement txtPlacementDate;

	
	@FindBy(xpath="//label[normalize-space()='Maturity Date']") private WebElement lblMaturityDate;
	@FindBy(xpath="//label[normalize-space()='Maturity Date']/parent::td/following-sibling::td") private WebElement txtmaturityDate;
	
	@FindBy(xpath="//label[normalize-space()='Renewal Instruction']") private WebElement lblRenewalInstruction;
	@FindBy(xpath="//label[normalize-space()='Renewal Instruction']/parent::td/following-sibling::td") private WebElement txtRenewalInstruction;

	@FindBy(xpath="//label[normalize-space()='Interest Payment Account']") private WebElement lblInterestPaymentAccount;
	@FindBy(xpath="//label[normalize-space()='Interest Payment Account']/parent::td/following-sibling::td") private WebElement txtInterestPaymentAccount;

	@FindBy(xpath="//label[normalize-space()='Accrued Interest (KHR)']") private WebElement lblAccurredInterestKhr;
	@FindBy(xpath="//label[normalize-space()='Accrued Interest (KHR)']/parent::td/following-sibling::td") private WebElement txtAccurredInterestKhr;
	@FindBy(xpath="//label[normalize-space()='Accrued Interest (USD)']/parent::td/following-sibling::td") private WebElement txtAccurredInterestUSD;


	@FindBy(xpath="//label[normalize-space()='Auto Renewal']") private WebElement lblAutoRenewal;
	@FindBy(xpath="//label[normalize-space()='Auto Renewal']/parent::td/following-sibling::td") private WebElement txtAutoRenewal;
	
	@FindBy(xpath="//a[@class='btn btn-outline-primary min-100 rounded-4']") private WebElement btnBack;
	@FindBy(xpath="//a[@class='btn btn-primary rounded-4 ms-2 px-4 min-100']") private WebElement btnWithdraw;

	
	
	public void verifyAccountNumberIsDisplayed() {
		//doAssertEqualsBoolean(isDisplayed(lblAccount,"Account Number label"), true, "Account Number label");
		doAssertEqualsBoolean(isDisplayed(txtAccountNo,"Account Number value"), true, "Account Number value");

	}
	
	public void verifyAccountStatusIsDisplayed() {
		//doAssertEqualsBoolean(isDisplayed(lblAcctStatus,"Account Status label"), true, "Account Status label");
		doAssertEqualsBoolean(isDisplayed(txtAcctStatus,"Account Status value"), true, "Account Status value");

	}
	
	public void verifyPrincipalAmtIsDIsplayed() {
		//doAssertEqualsBoolean(isDisplayed(lblPrincipalAmtKhr,"Principal Amount KHR  label"), true, "Principal Amount KHR label");
		//doAssertEqualsBoolean(isDisplayed(txtPrincipalAmtKhr,"Principal Amount KHR value"), true, "Principal Amount KHR value");
		
		if(txtPrincipalAmtKhr.isDisplayed() || txtPrincipalAmtUSD.isDisplayed()) {
			doAssertEqualsBoolean(true, true,"Principal Amount displayed?");

		}
		else {
			doAssertEqualsBoolean(false, true,"Principal Amount displayed?");

		}

	}
	
	public void verifyTenureIsDisplayed() {
		//doAssertEqualsBoolean(isDisplayed(lblTenure,"Tenure  label"), true, "Tenure label");
		doAssertEqualsBoolean(isDisplayed(txtTenure,"Tenure value"), true, "Tenure value");

	}
	
	public void verifyRateIsDisplayed() {
		//doAssertEqualsBoolean(isDisplayed(lblRate,"Rate  label"), true, "Rate label");
		doAssertEqualsBoolean(isDisplayed(txtRate,"Rate value"), true, "Rate value");

	}
	
	public void verifylastRenewalDateIsDisplayed() {
		doAssertEqualsBoolean(isDisplayed(lblLastRenewalDate,"Last Renewal Date  label"), true, "Last Renewal Date label");
		// value may not present if not renewed
	}
	
	public void verifyPlacementDateIsDisplayed() {
		//doAssertEqualsBoolean(isDisplayed(lblPlacementDate,"Placement Date  label"), true, "Placement Date label");
		doAssertEqualsBoolean(isDisplayed(txtPlacementDate,"Placement Date value"), true, "Placement Date value");

	}
	
	
	public void verifyMaturityDateIsDisplayed() {
		//doAssertEqualsBoolean(isDisplayed(lblMaturityDate,"Maturity Date  label"), true, "Maturity Date label");
		doAssertEqualsBoolean(isDisplayed(txtmaturityDate,"Maturity Date value"), true, "Maturity Date value");

	}
	
	
	public void verifyRenewalInstructionIsDisplayed() {
		//doAssertEqualsBoolean(isDisplayed(lblRenewalInstruction,"Renewal Instruction   label"), true, "Renewal Instruction label");
		doAssertEqualsBoolean(isDisplayed(txtRenewalInstruction,"Renewal Instruction  value"), true, "Renewal Instruction value");

	}
	
	
	public void verifyInterestPaymentAccountIsDisplayed() {
		//doAssertEqualsBoolean(isDisplayed(lblInterestPaymentAccount,"Interest Payment Account  label"), true, "Interest Payment Account label");
		doAssertEqualsBoolean(isDisplayed(txtInterestPaymentAccount,"Interest Payment Account  value"), true, "Interest Payment Account value");

	}
	
	public void verifyAccurredInterestKhrIsDisplayed() {
		//doAssertEqualsBoolean(isDisplayed(lblAccurredInterestKhr,"Accurred Interest KHR label"), true, "Accurred Interest KHR label");
		//doAssertEqualsBoolean(isDisplayed(txtAccurredInterestKhr,"Accurred Interest KHR  value"), true, "Accurred Interest KHR value");
		
		if(txtAccurredInterestKhr.isDisplayed() || txtAccurredInterestUSD.isDisplayed()) {
			doAssertEqualsBoolean(true, true,"Accurred Interest displayed?");
		}
		else {
			doAssertEqualsBoolean(false, true,"Accurred Interest displayed?");

		}

	}
	
	public void verifyAutoRenewalIsDisplayed() {
		//doAssertEqualsBoolean(isDisplayed(lblAutoRenewal,"Auto Renewal label"), true, "Auto Renewal label");
		doAssertEqualsBoolean(isDisplayed(txtAutoRenewal,"Auto Renewal  value"), true, "Auto Renewal value");

	}
	
	public void clickOnWithdrawBtn() {
		doClick(btnWithdraw, "Witthdraw button");
	}
}
