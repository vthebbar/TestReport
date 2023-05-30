package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qa.utils.PropertyManager;
import com.qa.utils.TACManager;

public class FixedDepositWithdrawlPage extends BasePage {

	public FixedDepositWithdrawlPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="idBtnSubmit") private WebElement btnNext;
	@FindBy(id="idTACAdd") private WebElement txtEnterTac;
	@FindBy(id="idBtnConfirm") private WebElement btnSubmit;
	@FindBy(xpath="//a[@class='btn btn-outline-primary btn-glow ms-1 min-100 rounded-4']") private WebElement btnBack;

	@FindBy(xpath="//label[normalize-space()='Transaction Status']") private WebElement lblTransactionStatus;
	@FindBy(xpath="//label[normalize-space()='Transaction Status']/following-sibling::span") private WebElement txtResult;
	
	
	public void clickOnNextBtn() {
		doClick(btnNext, "Next button");
	}
	
	public void enterTac() {
		
		TACManager tacManager = new TACManager();
		
		String userName = PropertyManager.propertyLoader().getProperty("userName");
		String tacCode = tacManager.getTacCode(driver, userName);
		doSendKeys(txtEnterTac,tacCode, "TAC code");
	}
	
	
	public void clickOnSubmitBtm() {
		doClick(btnSubmit, "Submit button");
	}
	
	public void verifyTransactionStatus() {
		
		String result = getText(txtResult,"Transaction Status").trim();
		doAssertEqualsStrings(result,"Successful","FD withdrawl transaction status");
	}
}
