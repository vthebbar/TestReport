package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qa.utils.PropertyManager;
import com.qa.utils.TACManager;

public class BlockUnBlockEcommercePage extends BasePage {

	public BlockUnBlockEcommercePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="idBtnCnfirmBlock") private WebElement btnBlock;
	@FindBy(xpath="//input[@name='idFormCfmAckDtl:j_idt251']") private WebElement btnDone;
	@FindBy(id="idBtnCnfirmUnblock") private WebElement btnUnblock;
	@FindBy(xpath="//input[@id='idFormCfmAckDtl:idTACAdd']") private WebElement txtTac;
	@FindBy(xpath="//input[@name='idFormCfmAckDtl:j_idt250']") private WebElement btnSubmit;
	@FindBy(xpath="//li[@class='success-msg mb-0']") private WebElement txtCardBlockMsg;
	@FindBy(xpath="//li[@class='success-msg mb-0']") private WebElement txtCardUnblockMsg;

	
	public void clickOnBlockBtn() {
		
		doClick(btnBlock, "Block button");
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
	
	public void verifyEcommerceBlockMessage(String expMsg) {
		
		String actMsg = getText(txtCardBlockMsg, "Ecommerce Block Message");
		doAssertEqualsStrings(actMsg, expMsg , "Ecommerce Block Mesage");
	}
	
	
	public void verifyEcommerceUnblockMessage(String expMsg) {
		String actMsg = getText(txtCardUnblockMsg, "Ecommerce UnBlock Message");
		doAssertEqualsStrings(actMsg, expMsg , "Ecommerce UnBlock Mesage");

	}
	
}
