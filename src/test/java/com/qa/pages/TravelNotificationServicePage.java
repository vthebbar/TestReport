package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TravelNotificationServicePage extends BasePage {

	public TravelNotificationServicePage(WebDriver driver) {
		super(driver);
	}
	
	//Existing notificaiton setup details
	@FindBy(xpath="//span[normalize-space()='Card Details']") private WebElement lblCardDetails;
	@FindBy(xpath="//span[normalize-space()='Card Details']") private WebElement lblSetDateRanges;
	@FindBy(xpath="//span[normalize-space()='Card Details']") private WebElement lblSetDestionations;
	@FindBy(xpath="//span[@class='text-uppercase d-block text-center']") private WebElement lblAction;
	
	@FindBy(xpath="//tbody/tr[1]/td[4]/a[1]/img[1]") private WebElement iconDelete;
	//Delete pop up
	@FindBy(xpath="//div[@id='confirmDelModal0']//button[@id='idCancelDelBtn']") private WebElement btnNo;
	@FindBy(xpath="//input[@id='j_idt191:0:idBtnDelete']") private WebElement btnYes;
	
	
	
	@FindBy(xpath="//span[@class='btn rounded-4 min-100 ms-2 px-4 btn-primary']") private WebElement btnCreateTravelNotification;
	
	//Enter Details Section
	@FindBy(xpath="//label[normalize-space()='Card']") private WebElement lblCard;
	@FindBy(xpath="//label[normalize-space()='Date Range']") private WebElement lblDateRange;
	@FindBy(xpath="//label[normalize-space()='Destination(s)']") private WebElement lblDestionation;

	
	@FindBy(id="idDtStart") private WebElement dateStart;
	@FindBy(id="idDtEnd") private WebElement dateEnd;
	
	@FindBy(xpath="//a[@data-toggle='modal']") private WebElement popUpDestination;
	@FindBy(id="searchInput") private WebElement txtSearchCountry;
	@FindBy(xpath="//input[@id='j_idt247']") private WebElement btnNext;
	
	@FindBy(id="idBtnSubmit") private WebElement btnNextEnterDetailsSection;
	
	@FindBy(id="idBtnConfirm") private WebElement btnSubmit;
	
	// Create and Delete result section
	@FindBy(xpath="//li[@class='success-msg']") private WebElement txtResultMsg;
	@FindBy(xpath="//label[normalize-space()='Debit Card']/following-sibling::span") private WebElement lblDebitCard;
	@FindBy(xpath="//label[normalize-space()='Travel Notification Service']/following-sibling::span") private WebElement lblTraveNotificationService;
	@FindBy(xpath="//label[normalize-space()='From']/following-sibling::span") private WebElement lblFrom;
	@FindBy(xpath="//label[normalize-space()='To']/following-sibling::span") private WebElement lblTo;
	@FindBy(xpath="//label[normalize-space()='Destination Countries']/following-sibling::span") private WebElement lblDestination;
	
	@FindBy(xpath="//span[@class='btn rounded-4 min-100 ms-2 px-4 btn-primary']") private WebElement btnDone;
	
	//Delete screen result element
	@FindBy(xpath="//label[normalize-space()='Travel Notification Status']/following-sibling::span") private WebElement lblTraveNotificationStatus;

	
	public void clickOnCreateTravelNotificationBtn() {
		
		if(btnCreateTravelNotification.isDisplayed()) {
			
			doClick(btnCreateTravelNotification, "Create Travel Notification button");
		}
	}
	
	
	public void keyInStartDate(String sDate) {
		
		doSendKeys(dateStart, sDate, "Start Date");
	}
	
	public void keyInEndDate(String eDate) {
		
		doSendKeys(dateEnd, eDate, "End Date");
	}
	
	public void clickOnDestination() {
		
		doClick(popUpDestination, "Destination");
	}
	
	public void keyInSearchCountry(String country) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		doSendKeys(txtSearchCountry, country, "Search Country");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void selectCountry(String cNumber) {
		
		String fullXpath = "//input[@id='idCtryList:"+cNumber+":j_idt244']";
		WebElement country = driver.findElement(By.xpath(fullXpath));
		doClick(country, "Select Country");
	}
	
	public void clickOnNextBtnInPopUp() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		doClick(btnNext, "Next button");
		
	}
	
	public void clickOnNextBtnInEnterDetailsSection() {
		try {
		doClick(btnNextEnterDetailsSection, "Next button");
		}
		catch(Exception e) {
			doClick(btnNextEnterDetailsSection, "Next button");

		}
	}
	
	public void clickOnSubmitBtn() {
		doClick(btnSubmit, "Submit button");
	}
	
	//create and delete results
	public void verifyResultMsg(String expMsg) {
		String actMsg = getText(txtResultMsg, "Result message");
		doAssertEqualsStrings(actMsg, expMsg, "Result message");
	}
	
	//S10_TC15
	public void verifyCreateTravelNotificationResultDetails() {
		
		boolean res = isDisplayed(lblDebitCard,"") && isDisplayed(lblTraveNotificationService,"") && isDisplayed(lblFrom,"") && isDisplayed(lblTo, "")&&isDisplayed(lblDestination,"");
		
		doAssertEqualsBoolean(res, true, "Travel Notification Result Details displayed correctly");
	}
	
	//S10_TC19
	public void clickOnDoneBtn() {
		doClick(btnDone, "Done button");
	}
	
	//S10_TC16
	public void verifyLabelsInEnterDetailsSection() {
		
		boolean res = isDisplayed(lblCard,"") && isDisplayed(lblDateRange,"") && isDisplayed(lblDestionation,"");
		doAssertEqualsBoolean(res, true, "Labels  displayed in Enter Details Section");

	}
	//S10_TC17
	public void verifyExistingNotificationDetailsScreen() {
		
		boolean res = isDisplayed(lblCardDetails,"") && isDisplayed(lblSetDateRanges,"") && isDisplayed(lblSetDestionations,"") && isDisplayed(lblAction,"") ;
		doAssertEqualsBoolean(res, true, "Labels  displayed for Existing Notification setups");

	}
	
	//S10_TC18
	public void clickOnDeleteIcon() {
		doClick(iconDelete, "Deleet Icon");
	}
	
	public void clickOnNoBtnInPopUp() {
		doClick(btnNo, "No button in popup -for delete action");
	}
	
	public void clickOnYesBtnInPopUp() {
		
		doClick(btnYes, "Yes button in popup-for delete action");
	}
	
	//S10_TC19
	public void verifyDeleteTravelNotificationResultDetails() {
		
		boolean res = isDisplayed(lblDebitCard,"") && isDisplayed(lblTraveNotificationStatus,"") && isDisplayed(lblFrom,"") && isDisplayed(lblTo, "")&&isDisplayed(lblDestination,"");
		
		doAssertEqualsBoolean(res, true, "Travel Notification Result Details displayed correctly");
	}
}
