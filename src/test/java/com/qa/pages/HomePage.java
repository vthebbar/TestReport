package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	@FindBy(xpath="//span[normalize-space()='Home']") private WebElement menuHome;
	@FindBy(xpath="//a[normalize-space()='Logout']") private WebElement btnLogout;
	
	@FindBy(xpath="//div[normalize-space()='Account Overview']") private WebElement sectionCASAAccountOverview;
	
	//Account details in acct over view section
	@FindBy(xpath="//*[@id=\"idDTCasa\"]/li[1]/a") private WebElement txtAcctDetails;
	
	
	//FD Section
	@FindBy(xpath="//div[@class='card-header text-uppercase mt-4 py-2 ps-3']") private WebElement lblFdSectionHeader;
	@FindBy(xpath="//div[@class='fw-bold'][normalize-space()='Fixed Deposit']") private WebElement lblFixedDeposit;
	
	@FindBy(xpath="//ul[@id='idDTFD']//small") private List<WebElement> txtCurrAcctNumMatDate;  // 3 elements in FD section
	
	// My Cards Section
	@FindBy(xpath="//div[normalize-space()='My Cards']") private WebElement lblMyCardsSectionHeading;
	@FindBy(xpath="//div[normalize-space()='Physical Debit Card']") private WebElement lblPhysicalDebitCard;
	@FindBy(xpath="//div[normalize-space()='Virtual Debit Card']") private WebElement lblVirtualDebitCard;
	@FindBy(xpath="//li[@class='list-group-item d-flex justify-content-between align-items-start px-0']//div[@class='col-auto text-end']//img[@class='col-auto']") private WebElement iconHideUnhide;
	@FindBy(css="li[class='list-group-item d-flex justify-content-between align-items-start px-0'] div[class='row align-items-center'] small") private WebElement txtCardNumber;
	
	// Left menus
	
	//Pay & Transact
	@FindBy(xpath="//span[normalize-space()='Pay & Transact']") private WebElement menuPayAndTransact;
	
	//Transfer
	@FindBy(xpath="//span[normalize-space()='Transfer']") private WebElement lblTransferHeader;
	@FindBy(xpath="//span[normalize-space()='Transfer to Own Account']") private WebElement menuTransferToOwnAcct;
	@FindBy(xpath="//span[normalize-space()='Transfer to Other Account at HLBCAM']") private WebElement menuTransferToOtherAcctAtHLBCAM;
	@FindBy(xpath="//ul[@class='list-unstyled']//span[@class='d-inline-block align-middle'][normalize-space()='Local Transfer']") private WebElement menuLocalTransfer;
	@FindBy(xpath="//ul[@class='list-unstyled']//span[@class='d-inline-block align-middle'][normalize-space()='Overseas Transfer']") private WebElement menuOverseasTransfer;
	
	//Online Transactions
	@FindBy(xpath="//span[normalize-space()='Online Transactions']") private WebElement lblOnlineTransactionHeader;
	@FindBy(xpath="//span[normalize-space()='View History']") private WebElement menuViewHistory;
	@FindBy(xpath="//span[normalize-space()='Manage Standing Instruction']") private WebElement menuManageStandingInstruction;
	@FindBy(xpath="//span[normalize-space()='My QR']") private WebElement menuMyQR;
	
	//Fixed Deposit
	@FindBy(xpath="//span[normalize-space()='Fixed Deposit']") private WebElement lblFixedDepositHeader;
	@FindBy(xpath="//span[normalize-space()='New Placement']") private WebElement menuNewPlacement;
	@FindBy(xpath="//span[normalize-space()='Withdraw Placement']") private WebElement menuWithDrawPlacement;

	//E-Saver
	@FindBy(xpath="//span[normalize-space()='E-Saver']") private WebElement menuESaver;
	@FindBy(xpath="//span[normalize-space()='Create Account']") private WebElement subMenuCreateAccount;;
	@FindBy(xpath="//span[normalize-space()='Personalize Account']") private WebElement subMenuPersonalizeAcct;;
	@FindBy(xpath="//span[normalize-space()='Re-activate Account']") private WebElement subMenuReactivateAcct;
	@FindBy(xpath="//span[normalize-space()='Close Account']") private WebElement subMenuCloseAcct;
	@FindBy(xpath="//span[normalize-space()='View Application History']") private WebElement subMenuViewApplicationHistory;

	
	//Physical & Virtual Card menu , submenus
	@FindBy(xpath="//span[normalize-space()='Physical & Virtual Card']") private WebElement menuPhysicalAndVirtualCard;
	
	@FindBy(xpath="//span[normalize-space()='Physical Card']") private WebElement lblPhysicalCard;
	@FindBy(xpath="//span[normalize-space()='Virtual Card']") private WebElement lblVirtualCard;
	
	//physical card
	@FindBy(xpath="//a[@href='/rib/app/fo/dbc/blockcard']//span[@class='d-inline-block align-middle']") private WebElement submenuBlockUnblockPhy;
	@FindBy(xpath="//span[normalize-space()='Block/Unblock E-commerce']") private WebElement subMenuBlockUnblockEcommerce;
	@FindBy(xpath="//span[normalize-space()='Block/Unblock Overseas ATM/POS']") private WebElement subMenuBlockUnblockOverseasATMPOS;
	@FindBy(xpath="//a[@href='/rib/app/fo/dbc/chgdefaultacct']//span[@class='d-inline-block align-middle'][normalize-space()='Change Debiting Account']") private WebElement subMenuChangeDebitingAcct;
	@FindBy(xpath="//a[@href='/rib/app/fo/dbc/maxpurchslmt']//span[@class='d-inline-block align-middle'][normalize-space()='Set Daily Limit']") private WebElement subMenuSetDailyLimitPhy;
	@FindBy(xpath="//span[normalize-space()='Travel Notification Service']") private WebElement subMenuTravelNotificationService;
	@FindBy(xpath="//span[contains(text(),'Request Card Renewal')]") private WebElement subMenuRequestCardRenewal;
	@FindBy(xpath="//span[normalize-space()='Report Card Lost/Stolen']") private WebElement subMenuReportCardLostStolen;
	@FindBy(xpath="//span[normalize-space()='Reset PIN']") private WebElement subMenuResetPIN;
	
	//virtual card
	@FindBy(xpath="//span[normalize-space()='Create']") private WebElement subMenuCreate;
	@FindBy(xpath="//a[@href='/rib/app/fo/dbc/blockvirtcard']//span[@class='d-inline-block align-middle']") private WebElement subMenuBlockUnblockVir;
	@FindBy(xpath="//a[@href='/rib/app/fo/dbc/blockvirtcard']//span[@class='d-inline-block align-middle']") private WebElement subMenuChangeDeibtingAcctVir;
	@FindBy(xpath="//a[@href='/rib/app/fo/dbc/maxvirtpurchslmt']//span[@class='d-inline-block align-middle'][normalize-space()='Set Daily Limit']") private WebElement subMenuSetDailiLimitVir;
	@FindBy(xpath="//span[normalize-space()='Create/Update Note']") private WebElement subMenuCreateUpdateNote;

		
	
	//Quick Access section
	
	@FindBy(xpath="//div[normalize-space()='Quick Access']") private WebElement lblQuickAccessHeader;
	@FindBy(xpath="//div[@class='fw-bold text-uppercase f16 text-black']") private WebElement lblTransferToSubHeader;
	@FindBy(xpath="//div[normalize-space()='Quick Access']") private WebElement menuQuickAccessOwnAcct;
	@FindBy(xpath="//div[normalize-space()='Quick Access']") private WebElement menuQuickAccessOtherAcctATHLB;
	@FindBy(xpath="//div[normalize-space()='Quick Access']") private WebElement menuQuickAccessLocalTransfer;
	@FindBy(xpath="//div[normalize-space()='Quick Access']") private WebElement menuQuickAccessOverseasTransfer;

	
	
	public HomePage(WebDriver driver) {
		super(driver);
	}

	//TC01
	
	public void clickOnPayAndTransact() {
		doClick(menuPayAndTransact, "Pay and Transact");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public FixedDepositPlacementPage clickOnNewPlacement() {
		doClick(menuNewPlacement, "New FD placement");
		return new FixedDepositPlacementPage(driver);
	}
	
	public void verifyHomeMenuIsDisplayed() {
		
		doAssertEqualsBoolean(isDisplayed(menuHome,"Home menu"), true,"Home menu");
	}
	
	
	public void verifyLogoutBtnIsDisplayed() {
		
		doAssertEqualsBoolean(isDisplayed(btnLogout,"Logout button"), true,"Logout button");
		}
	
	public LogoutPage clikLogoutBtn() {
		
		doClick(btnLogout, "Logout button");
		return new LogoutPage(driver);
	}
	
	public HomePage clikonHomeMenu() {
		doClick(menuHome, "Home menu");
		
		return this;
	}
	
	public void verifyCASAAcctOverViewSectionIsDisplayed() {
		
		doAssertEqualsBoolean(isDisplayed(sectionCASAAccountOverview,"CASA Account Overview Section"), true,"CASA Account Overview Section");
	}
	
	public void verifyAccountDetailsAreDisplayedInAcctOverViewSection() {
		
		String acctDetails=getText(txtAcctDetails,"Account Details");
		System.out.println("Account Details: "+acctDetails);
		
		doAssertEqualsBoolean(isDisplayed(txtAcctDetails,"Account Details"), true, "Account Details");
	}
	
	public CASAAccountOverviewPage clickOnAcctDetails() {
		doClick(txtAcctDetails,"Account Details Oveview for first account");
		return new CASAAccountOverviewPage(driver);
	}
	
	//S009_TC01
	public void verifyFDSectionHeaderIsDisplayed() {
		
		doAssertEqualsBoolean(isDisplayed(lblFdSectionHeader, "FD Section Heading"),true,"FD Section Header");
	}
	
	public void verifyFixedDepositIsDiaplyedInsideSection() {
		doAssertEqualsBoolean(isDisplayed(lblFixedDeposit,"Fixed Deposit label"), true, "Fixed Deposit label Inside the section");
	}
	
	public void verifyCurrencyFDAcctNumMaturiyDateAreDisplayed() {
		
	
		doAssertEqualsBoolean(txtCurrAcctNumMatDate.size()==3, true, "FD Account Number, Currency, Maturity Date");
	}
	
	//S009_TC02
	public FixedDepositOverviewPage clickOnFDSection() {
		doClick(lblFixedDeposit, "FD  text inside Section");
		return new FixedDepositOverviewPage(driver);
		
	}
	
	//S010
	public void verifyMyCardsSectionHeadingIsDisplayed() {
		
		doAssertEqualsBoolean(isDisplayed(lblMyCardsSectionHeading,"My Card Section Heading"), true, "My Card Section Heading");
	}
	
	public void verifyTypeOfCardIsDisplayed() {
		
		doAssertEqualsBoolean(isDisplayed(lblPhysicalDebitCard, "Type of Card"), true, "Type of Card");
		doAssertEqualsBoolean(isDisplayed(lblVirtualDebitCard, "Type of Card"), true, "Type of Card");
		
	}
	
	// Verify that 4 digits are displayed and remaining are masked
	public void verifyCardNumber() {
		String cardNum= getText(txtCardNumber,"Card Number");
		
		int maskCount=0;
		int digitCount=0;
		
		for(int i=0;i<cardNum.length();i++) {
			
			if(cardNum.charAt(i)=='x') {
				maskCount++;
			}
			
			//if(Character.isDigit(cardNum.charAt(i))) 
			else{
				digitCount++;
			}
		}
		
		doAssertEqualsBoolean(maskCount==12, true, "Masked digits count");
		doAssertEqualsBoolean(digitCount==4, true, "Displayed digits count");

	}
	
	public void verifyHideUnhideIconIsDisplayed() {
		
		doAssertEqualsBoolean(isDisplayed(iconHideUnhide,"Hide/Unide icon"), true, "Hide/Unhide Icon");
	}
	
	//S10_TC02_TC03
	
	public PhysicalDebitCardOverviewPage clickOnPhysicalDebitCard() {
		doClick(lblPhysicalDebitCard, "Physical Debit Card");
		return new PhysicalDebitCardOverviewPage(driver);
	}
	
	//S11_TC01
	public VirtualDebitCardOverviewPage clickOnVirtualDebitCard() {
		
		doClick(lblVirtualDebitCard, "Virtual Debit Card Under My Cards section");
		return new VirtualDebitCardOverviewPage(driver);
	}
	
	//S013
	
	public void verifyTransferMenuMenuOptions() {
		
		boolean res = isDisplayed(lblTransferHeader,"") && isDisplayed(menuTransferToOwnAcct,"") && isDisplayed(menuTransferToOtherAcctAtHLBCAM,"")
				&& isDisplayed(menuLocalTransfer, "") && isDisplayed(menuOverseasTransfer,"");
		
		doAssertEqualsBoolean(res, true, "Pay & Transact - Transfer Menu Options displayed ?");
	}
	
public void verifyOnlineTransactionMenuOptions() {
		
		boolean res = isDisplayed(lblOnlineTransactionHeader,"") && isDisplayed(menuViewHistory,"") && isDisplayed(menuManageStandingInstruction,"")
				&& isDisplayed(menuMyQR, "");
		
		doAssertEqualsBoolean(res, true, "Pay & Transact - Online Transction Menu options displayed ?");
	}

public void verifyFixedDepositmenuoptions() {
	
	boolean res = isDisplayed(lblFixedDepositHeader,"") && isDisplayed(menuNewPlacement,"") && isDisplayed(menuWithDrawPlacement,"");
			
	
	doAssertEqualsBoolean(res, true, "Pay & Transact - Fixed Deposit menu options displayed ?");
}

//S012

public void verifyQuickAccessSection() {
	
	boolean res = isDisplayed(lblQuickAccessHeader,"") && isDisplayed(lblTransferToSubHeader,"") && isDisplayed(menuQuickAccessOwnAcct,"") &&
			    isDisplayed(menuQuickAccessOtherAcctATHLB,"") && isDisplayed(menuQuickAccessLocalTransfer,"") && isDisplayed(menuQuickAccessOverseasTransfer,"") ;
}

//S014_TC1
public TransferToOwnAccountPage clickOnTransferToOwnAcct() {
	doClick(menuTransferToOwnAcct, "Transfer to Own Account");
	return new TransferToOwnAccountPage(driver);
}

//S015_TC01
public TransferToOtherAcctAtHLBCAMPage clickOnTransferToOtherAccountAtHLBCAM() {
	doClick(menuTransferToOtherAcctAtHLBCAM,"Transfer to Other Account at HLBCAM");
	
	return new TransferToOtherAcctAtHLBCAMPage(driver);
}

//S016
public LocalTransferPage clickOnLocalTransferMenu() {
	
	doClick(menuLocalTransfer, "Local Transfer Menu");
	return new LocalTransferPage(driver);
}

//S017
public OverseasTransferPage clickOnOverseasTransferMenu() {
	doClick(menuOverseasTransfer,"Overseas Transfer menu");
	return new OverseasTransferPage(driver);
}

//S018
public ViewHistoryPage clickOnViewHistory() {
	
	doClick(menuViewHistory,"View History menu");
	return new ViewHistoryPage(driver);
}

//S019
public ManageStandingInstructionPage clickOnManageStandingInstructionMenu() {
	doClick(menuManageStandingInstruction, "Manage Standing Instruction menu");
	return new ManageStandingInstructionPage(driver);
}

//S020
public MyQRPage clickOnMyQRMenu() {
	
	doClick(menuMyQR, "My QR menu");
	return new MyQRPage(driver);
}

//S022
public FixedDepositOverviewPage clickOnWithdrawPlacementMenu() {
	
	doClick(menuWithDrawPlacement,"Withdraw Placement menu");
	return new FixedDepositOverviewPage(driver);
}

//S023
public void clickonESaverMenu() {
	doClick(menuESaver, "E-Saver menu");
}

public void verifyESaverSubMenusAreDisplayed() {
	
	boolean flag = false;
	flag = isDisplayed(subMenuCreateAccount,"") && isDisplayed(subMenuPersonalizeAcct,"") && isDisplayed(subMenuReactivateAcct,"")
			&& isDisplayed(subMenuCloseAcct,"") && isDisplayed(subMenuViewApplicationHistory,"");
}
//S024
public ESaverCreateAccountPage clickOnEsaverCreateAccount() {
	doClick(subMenuCreateAccount, "E-Saver -Create Account");
	return new ESaverCreateAccountPage(driver);
	
}

//S025
public ESaverPersonalizeAccountPage clickOnEsaverPersonalizeAccount() {
	
	doClick(subMenuPersonalizeAcct, "Personalize Account");
	return new ESaverPersonalizeAccountPage(driver);
}
//S027

public ESaverCloseAccountPage clickOnEsaverCloseAccountSubMenu() {
	doClick(subMenuCloseAcct, "Personalize Account");

	return new ESaverCloseAccountPage(driver);
}
//S028
public ESaverViewApplicationHistoryPage clickOnViewApplicationHistorySubMenu() {
	doClick(subMenuViewApplicationHistory, "View Application History");

	return new ESaverViewApplicationHistoryPage(driver);
}

//S029
public void clickOnPhysicalAndVirtualCardMenu() {
	doClick(menuPhysicalAndVirtualCard, "Physical & Virtual Card menu");
}

public void verifyPhysicalAndVirtualCardSubMenus() {
	
	boolean flag = false;
	
	flag = isDisplayed(lblPhysicalCard,"") && isDisplayed(lblVirtualCard,"") && isDisplayed(submenuBlockUnblockPhy,"") && isDisplayed(subMenuBlockUnblockEcommerce,"") &&
			isDisplayed(subMenuBlockUnblockOverseasATMPOS,"") && isDisplayed(subMenuChangeDebitingAcct,"") && isDisplayed(subMenuSetDailyLimitPhy,"") &&
			isDisplayed(subMenuTravelNotificationService,"") && isDisplayed(subMenuRequestCardRenewal,"") && isDisplayed(subMenuReportCardLostStolen,"") &&
			isDisplayed(subMenuResetPIN,"")  && isDisplayed(subMenuCreate,"") && isDisplayed(subMenuBlockUnblockVir,"") && isDisplayed(subMenuChangeDeibtingAcctVir,"")
			&& isDisplayed(subMenuSetDailiLimitVir,"") && isDisplayed(subMenuCreateUpdateNote,"");
	
	doAssertEqualsBoolean(flag, true, "All sub menus and labels displayed ?");
}

public BlockUnblockPhysicalDebitCardPage clickOnBlockUnblockMenuPhysicalCard() {
	
	doClick(submenuBlockUnblockPhy,"Block/Unblock physical card");
	return new BlockUnblockPhysicalDebitCardPage(driver);
}

public BlockUnBlockEcommercePage clickOnBlockUnblockEcommercePhycialCard() {
	doClick(subMenuBlockUnblockEcommerce,"Block/Unblock E-commerce");
	return new BlockUnBlockEcommercePage(driver);
}

public BlockUnblockOverseasATMPOSPage clcikOnBlockUnBlockOverseasATMPOSPhysicalCard() {
	doClick(subMenuBlockUnblockOverseasATMPOS,"Block/Unblock Overseas ATM POS");
	return new BlockUnblockOverseasATMPOSPage(driver);
}

public ChangeDebitingAccountPage clickOnChangeDebitingAccountSubMenu() {
	doClick(subMenuChangeDebitingAcct,"Change Debiting Account");
	return new ChangeDebitingAccountPage(driver);
}

}
