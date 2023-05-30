package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qa.utils.PropertyManager;
import com.qa.utils.TACManager;

public class BlockUnblockVirtualCardPage extends BasePage {

	public BlockUnblockVirtualCardPage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(xpath="//div[@role='alert']") private WebElement lblAlert;
	@FindBy(xpath="//label[normalize-space()='Card Details']") private WebElement lblCardDetails;
	@FindBy(xpath="//label[normalize-space()='Card Status']") private WebElement lblCardStatus;
	@FindBy(xpath="//label[normalize-space()='Action']") private WebElement lblAction;
	
	@FindBy(css="td[class='ps-2'] label:nth-child(1)") private WebElement txtCardNumber;
	@FindBy(css="td[class='text-center align-middle col-auto'] label") private WebElement txtStatus;
	@FindBy(xpath="//input[@id='j_idt201:0:idBtnCnfirmBlock']") private WebElement btnBlock;
	
	@FindBy(xpath="//li[@class='success-msg mb-0']") private WebElement lblResponseMsg;
	@FindBy(xpath="//input[@name='idFormCfmAckDtl:j_idt259']") private WebElement btnDone;
	
	//Screen element after block
	@FindBy(xpath="//input[@id='j_idt201:0:idBtnCnfirmUnblock']") private WebElement btnUnblock;
	@FindBy(xpath="//input[@id='idFormCfmAckDtl:idTACAdd']") private WebElement txtTac;
	@FindBy(xpath="//input[@name='idFormCfmAckDtl:j_idt257']") private WebElement btnSubmit;
	
	@FindBy(xpath="//li[@class='error-msg mb-0']") private WebElement lblErrmsg;
	
	public void verifyBlockUnblockVirtualCardScreenElements() {
		
		boolean res = isDisplayed(lblAlert,"") && isDisplayed(lblCardDetails,"") && isDisplayed(lblCardStatus,"") && isDisplayed(lblAction,"") && 
				isDisplayed(txtCardNumber,"") && isDisplayed(txtStatus,"") && isDisplayed(btnBlock,"") ;
		
		doAssertEqualsBoolean(res, true, "Block/Unblock Virtual Card Screen Elements");
	}
	
	public void clickOnBlockBtn() {
		
		doClick(btnBlock, "Block button");
	}
	
	public void verifyResponseMessage(String expMsg) {
		
		String actMsg = getText(lblResponseMsg,"Response Message");
		doAssertEqualsStrings(actMsg, expMsg,"Card Block Response");
	}
	
	public void clickOnDoneBtn() {
		doClick(btnDone, "Done button");
	}
	
	public void verifyUnblockBtnIsDisplayed() {
		
		doAssertEqualsBoolean(isDisplayed(btnUnblock, "Unblock button"), true, "Unblock button displayed ?");
	}
	
	public void verifyCardStatus() {
		String actStatus = getText(txtStatus, "Actual Status of Card");
		doAssertEqualsStrings(actStatus, "Blocked", "Card status");
	}
	
	public void clickOnUnblockBtn() {
		doClick(btnUnblock, "Unblock button");
	}
	
	public void keyInInvalidTac(String tac) {
		doSendKeys(txtTac, tac, "Invaldi TAC code");
	}
	
	public void clickOnSubmit() {
		doClick(btnSubmit, "Submit button");
	}
	
	public void verifyErrMsgForInvalidTac(String expMsg) {
		String actMsg = getText(lblErrmsg, "Error message for invalid TAC");
		doAssertEqualsStrings(actMsg, expMsg, "Error message for invaldi TAC");
	}
	
	public void keyInValidTAC() {
		String userName = PropertyManager.propertyLoader().getProperty("userName");
		TACManager tacManager = new TACManager();
		String tac = tacManager.getTacCode(driver, userName);
		doSendKeys(txtTac, tac, "Invaldi TAC code");
	}
}
