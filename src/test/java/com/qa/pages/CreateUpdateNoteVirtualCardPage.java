package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateUpdateNoteVirtualCardPage extends BasePage {

	public CreateUpdateNoteVirtualCardPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//label[@for='idCardList']/following-sibling::span") private WebElement txtDebitCard;
	@FindBy(xpath="//label[normalize-space()='Current Note']/following-sibling::label") private WebElement txtCurrentNote;
	@FindBy(xpath="//label[@for='idNotesText']/following-sibling::span/input") private WebElement txtNewNote;
	@FindBy(id="idBtnNext") private WebElement btnSave;
	
	
	
	@FindBy(xpath="//li[@class='success-msg']") private WebElement lblResponseMsg;
	@FindBy(xpath="//label[normalize-space()='Debit Card']/following-sibling::label") private WebElement lblResponseDebitCard;
	@FindBy(xpath="//label[normalize-space()='New Note']/following-sibling::label") private WebElement lblResponseNote;
	
	@FindBy(xpath="//input[@name='idFormCfmAckDtl:j_idt211']") private WebElement btnDone;
	
	public void verifyCreateUpdateNoteScreenFields() {
		
		boolean res= isDisplayed(txtDebitCard,"") && isDisplayed(txtCurrentNote,"") && isDisplayed(txtNewNote,"");
		doAssertEqualsBoolean(res,true,"Create/Update Note - Enter Details section fields displaeyd ?");
	}
	
	public void keyInNewNote(String newNote) {
		
		doSendKeys(txtNewNote, newNote,"New note");
		doClick(txtCurrentNote,"");
	}
	
	public void clickOnSavebtn() {
	try {
	doClick(btnSave, "Save button");
	}
	catch(Exception e){
		doClick(btnSave, "Save button");

	}
	}
	
	public void verifyResponseMsg(String expMsg) {
		String actMsg = getText(lblResponseMsg, "Response");
		doAssertEqualsStrings(actMsg, expMsg, "Response after note update");
	}
	
	public void verifyResponseDetails() {
		
		boolean res = isDisplayed(lblResponseDebitCard,"") && isDisplayed(lblResponseNote,"");
		doAssertEqualsBoolean(res, true, "Response details displaeyd ?");
	}
	
	public void clickOnDoneBtn() {
		doClick(btnDone, "Done button");
	}
}
