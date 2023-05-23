package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qa.utils.PropertyManager;
import com.qa.utils.TACManager;

public class BlockUnblockOverseasATMPOSPage extends BasePage {

	public BlockUnblockOverseasATMPOSPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="idBtnCnfirmBlock") private WebElement btnBlock;
	@FindBy(xpath="//li[@class='success-msg mb-0']") private WebElement txtMsgBlock;
	
	@FindBy(xpath="//input[@name='idFormCfmAckDtl:j_idt252']") private WebElement btnDone;
	@FindBy(id="idBtnCnfirmUnblock") private WebElement btnUnblock;
	
	@FindBy(xpath="//input[@id='idFormCfmAckDtl:idTACAdd']") private WebElement txtTac;
	@FindBy(xpath="//input[@name='idFormCfmAckDtl:j_idt250']") private WebElement btnSubmit;
	
	@FindBy(xpath="//li[@class='success-msg mb-0']") private WebElement txtMsgUnblock;
	
	public void clickOnBlockBtn() {
		doClick(btnBlock, "Block button");
	}
	
	public void verifyBlockOverseasATMPOSMessage(String expMsg) {
		
		String actMsg = getText(txtMsgBlock, "Block Overseas ATM POS message");
		doAssertEqualsStrings(actMsg, expMsg, "Block Overseas ATM POS message");
	}
	
	public void clickOnDoneBtn() {
		doClick(btnDone, "Done button");
	}
	
	public void clickOnUnblockBtn() {
		
		doClick(btnUnblock, "Unblock button");
	}
	
	public void keyInTac() {
		
		TACManager tacManager = new TACManager();
		String userName = PropertyManager.propertyLoader().getProperty("userName");
		String tacCode = tacManager.getTacCode(driver, userName);
		doSendKeys(txtTac, tacCode, "TAC");
	}
	
	
	public void clickOnSubmitBtn() {
		
		doClick(btnSubmit, "Submit button");
	}
	
	public void verifyUnblockMessage(String expMsg) {
		
		String actMsg = getText(txtMsgUnblock, "Unblock Message");
		doAssertEqualsStrings(actMsg, expMsg, "Unblock Message");
	}
}
