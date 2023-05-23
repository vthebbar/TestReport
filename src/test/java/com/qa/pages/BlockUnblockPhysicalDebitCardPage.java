package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qa.utils.PropertyManager;
import com.qa.utils.TACManager;

public class BlockUnblockPhysicalDebitCardPage  extends BasePage {

	public BlockUnblockPhysicalDebitCardPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="idBtnCnfirmBlock") private WebElement btnBlock;
	@FindBy(xpath="//li[@class='success-msg mb-0']") private WebElement txtblockMessage;
	
	@FindBy(xpath="//input[@name='idFormCfmAckDtl:j_idt253']") private WebElement btnDone;
	
	//
	@FindBy(id="idBtnCnfirmUnblock") private WebElement btnUnblock;
	@FindBy(xpath="//input[@id='idFormCfmAckDtl:idTACAdd']") private WebElement txtTac;
	@FindBy(xpath="//input[@name='idFormCfmAckDtl:j_idt251']") private WebElement btnSubmit;
	@FindBy(xpath="//li[@class='success-msg mb-0']") private WebElement txtUnblockMessage;
	
	public void clickOnBlockBtn() {
		doClick(btnBlock, "Block button");
	}
	
	public void verifyCardBlockMessage(String expMsg) {
		
		String actMsg = getText(txtblockMessage, "Block message");
		doAssertEqualsStrings(actMsg, expMsg, "Card block message");
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
		doSendKeys(txtTac,tacCode, "TAC code");
	}
	
	public void clickOnSubmitBtn() {
		doClick(btnSubmit, "Submit button");
	}
	
	
public void verifyCardUnBlockMessage(String expMsg) {
		
		String actMsg = getText(txtUnblockMessage, "UnBlock message");
		doAssertEqualsStrings(actMsg, expMsg, "Card Unblock message");
	}
}
