package com.qa.factory;

import org.openqa.selenium.WebDriver;

import com.qa.pages.BlockUnBlockEcommercePage;
import com.qa.pages.BlockUnblockOverseasATMPOSPage;
import com.qa.pages.BlockUnblockPhysicalDebitCardPage;
import com.qa.pages.BlockUnblockVirtualCardPage;
import com.qa.pages.CASAAccountOverviewPage;
import com.qa.pages.ChangeDebitingAccountPage;
import com.qa.pages.ChangeDebitingAcctVirtualCardPage;
import com.qa.pages.CreateUpdateNoteVirtualCardPage;
import com.qa.pages.ESaverCloseAccountPage;
import com.qa.pages.ESaverCreateAccountPage;
import com.qa.pages.ESaverPersonalizeAccountPage;
import com.qa.pages.FAQPage;
import com.qa.pages.FixedDepositOverviewPage;
import com.qa.pages.FixedDepositPlacementDetailPage;
import com.qa.pages.FixedDepositPlacementPage;
import com.qa.pages.FixedDepositWithdrawlPage;
import com.qa.pages.HomePage;
import com.qa.pages.LocalTransferPage;
import com.qa.pages.LoginPage;
import com.qa.pages.LogoutPage;
import com.qa.pages.ManageFavouriteAccountsPage;
import com.qa.pages.ManageStandingInstructionPage;
import com.qa.pages.MyQRPage;
import com.qa.pages.OverseasTransferPage;
import com.qa.pages.PhysicalDebitCardOverviewPage;
import com.qa.pages.PrivacyPolicyPage;
import com.qa.pages.RegisterForOnlineBankingPage;
import com.qa.pages.ResetHlbConnectPage;
import com.qa.pages.ResetPinPage;
import com.qa.pages.SecurityPolicyPage;
import com.qa.pages.SetDailyLimitPage;
import com.qa.pages.SetDailyLimitVirtualCardPage;
import com.qa.pages.StandingInstructionDetailsPage;
import com.qa.pages.TermsAndConditionsPage;
import com.qa.pages.TransactionDetailsPage;
import com.qa.pages.TransferToOtherAcctAtHLBCAMPage;
import com.qa.pages.TransferToOwnAccountPage;
import com.qa.pages.TravelNotificationServicePage;
import com.qa.pages.ViewHistoryPage;
import com.qa.pages.VirtualDebitCardOverviewPage;

public class PageObjectFactory {

	private static HomePage homePage;
	private static LoginPage loginPage;
	private static LogoutPage logoutPage;
	private static RegisterForOnlineBankingPage registerForOnlineBankingPage;
	private static ResetHlbConnectPage resetHlbConnectPage;
	private static FAQPage faqPage;
	private static SecurityPolicyPage securityPolicyPage;
	private static PrivacyPolicyPage privacyPolicyPage;
	private static TermsAndConditionsPage termsAndConditionsPage;
	private static CASAAccountOverviewPage cASAAccountOverviewPage;
	private static FixedDepositOverviewPage  fixedDepositOverviewPage;
	private static FixedDepositPlacementDetailPage fixedDepositPlacementDetailPage;
	private static FixedDepositWithdrawlPage fixedDepositWithdrawlPage;
	private static PhysicalDebitCardOverviewPage physicalDebitCardOverviewPage;
	private static FixedDepositPlacementPage  fixedDepositPlacementPage;
	private static BlockUnblockPhysicalDebitCardPage blockUnblockPhysicalDebitCardPage;
	private static BlockUnBlockEcommercePage blockUnBlockEcommercePage;
	private static BlockUnblockOverseasATMPOSPage blockUnblockOverseasATMPOSPage;
	private static ChangeDebitingAccountPage changeDebitingAccountPage;
	private static SetDailyLimitPage setDailyLimitPage;
	private static TravelNotificationServicePage travelNotificationServicePage;
	private static VirtualDebitCardOverviewPage virtualDebitCardOverviewPage;
	private static BlockUnblockVirtualCardPage  blockUnblockVirtualCardPage;
	private static ResetPinPage resetPinPage;
	private static ChangeDebitingAcctVirtualCardPage changeDebitingAcctVirtualCardPage;
	private static SetDailyLimitVirtualCardPage setDailyLimitVirtualCardPage;
	private static CreateUpdateNoteVirtualCardPage createUpdateNoteVirtualCardPage;
	private static TransferToOwnAccountPage transferToOwnAccountPage;
	private static TransferToOtherAcctAtHLBCAMPage transferToOtherAcctAtHLBCAMPage;
	private static ManageFavouriteAccountsPage manageFavouriteAccountsPage;
	private static LocalTransferPage localTransferPage;
	private static OverseasTransferPage overseasTransferPage;
	private static ViewHistoryPage viewHistoryPage;
	private static TransactionDetailsPage transactionDetailsPage;
	private static ManageStandingInstructionPage manageStandingInstructionPage;
	private static StandingInstructionDetailsPage standingInstructionDetailsPage;
	private static MyQRPage myQRPage;
	private static ESaverCreateAccountPage eSaverCreateAccountPage;
	private static ESaverPersonalizeAccountPage eSaverPersonalizeAccountPage;
	private static ESaverCloseAccountPage eSaverCloseAccountPage;
	
	public static HomePage getHomePage(WebDriver driver) {
		
		return homePage == null ? new HomePage(driver) : homePage;
	}
	
	public static LoginPage getLoginPage(WebDriver driver) {
		
		return loginPage == null ? new LoginPage(driver) : loginPage;
	}
	
	public static LogoutPage getLogoutPage(WebDriver driver) {
		
		return logoutPage == null ? new LogoutPage(driver) : logoutPage ;
	}
	
	
	public static RegisterForOnlineBankingPage getRegisterForOnlineBankingPage(WebDriver driver) {
		
		return registerForOnlineBankingPage == null ? new RegisterForOnlineBankingPage(driver) : registerForOnlineBankingPage ;
	}


	public static ResetHlbConnectPage getRresetHlbConnectPage(WebDriver driver) {
	
		return resetHlbConnectPage == null ? new ResetHlbConnectPage(driver) : resetHlbConnectPage ;
	
	
}

	
	public static FAQPage getFAQPage(WebDriver driver) {
		
		return faqPage == null ? new FAQPage(driver) : faqPage ;
	
	
}
	
	public static SecurityPolicyPage getSecurityPolicyPage(WebDriver driver) {
		
		return securityPolicyPage == null ? new SecurityPolicyPage(driver) : securityPolicyPage ;
	
	
}

	public static PrivacyPolicyPage getPrivacyPolicyPage(WebDriver driver) {
		
		return privacyPolicyPage == null ? new PrivacyPolicyPage(driver) : privacyPolicyPage ;
	
	
}
	
	
	public static TermsAndConditionsPage getTermsAndConditionsPage(WebDriver driver) {
		
		return termsAndConditionsPage == null ? new TermsAndConditionsPage(driver) : termsAndConditionsPage ;
	
	
}

	public static CASAAccountOverviewPage getCASAAccountOverviewPage(WebDriver driver) {
		
		return cASAAccountOverviewPage == null ? new CASAAccountOverviewPage(driver) : cASAAccountOverviewPage;
	}

	public static FixedDepositOverviewPage getFixedDepositOverviewPage(WebDriver driver) {
		
		return fixedDepositOverviewPage == null ? new FixedDepositOverviewPage(driver) : fixedDepositOverviewPage;
	}
	
	public static FixedDepositPlacementDetailPage getFixedDepositPlacementDetailPage(WebDriver driver) {
		return fixedDepositPlacementDetailPage == null ? new FixedDepositPlacementDetailPage(driver) : fixedDepositPlacementDetailPage;
	}
	
	public static FixedDepositWithdrawlPage getFixedDepositWithdrawlPage(WebDriver driver) {
		
		return fixedDepositWithdrawlPage == null ? new FixedDepositWithdrawlPage(driver) : fixedDepositWithdrawlPage ;
	}
	
	public static PhysicalDebitCardOverviewPage getPhysicalDebitCardOverviewPage(WebDriver driver) {
		
		return physicalDebitCardOverviewPage == null ? new PhysicalDebitCardOverviewPage(driver) :physicalDebitCardOverviewPage;
	}
	
	public static FixedDepositPlacementPage getFixedDepositPlacementPage(WebDriver driver) {
		return fixedDepositPlacementPage == null ? new FixedDepositPlacementPage(driver) : fixedDepositPlacementPage;
	}
	
	public static BlockUnblockPhysicalDebitCardPage getBlockUnblockPhysicalDebitCardPage(WebDriver driver) {
		return blockUnblockPhysicalDebitCardPage == null ? new BlockUnblockPhysicalDebitCardPage(driver) : blockUnblockPhysicalDebitCardPage;
	}
	
	public static BlockUnBlockEcommercePage getBlockUnBlockEcommercePage(WebDriver driver) {
		
		return blockUnBlockEcommercePage == null ? new BlockUnBlockEcommercePage(driver) : blockUnBlockEcommercePage;
	}
	
	public static BlockUnblockOverseasATMPOSPage getBlockUnblockOverseasATMPOSPage(WebDriver driver) {
		return blockUnblockOverseasATMPOSPage == null ? new BlockUnblockOverseasATMPOSPage(driver) : blockUnblockOverseasATMPOSPage;
	}
	
	public static ChangeDebitingAccountPage getChangeDebitingAccountPage(WebDriver driver) {
		
		return changeDebitingAccountPage == null ? new ChangeDebitingAccountPage(driver) : changeDebitingAccountPage ;
	}
	
	public static SetDailyLimitPage getSetDailyLimitPage(WebDriver driver) {
		
		return setDailyLimitPage == null ? new SetDailyLimitPage(driver) : setDailyLimitPage;
	}
	
	public static TravelNotificationServicePage getTravelNotificationServicePage(WebDriver driver) {
		
		return travelNotificationServicePage == null ? new TravelNotificationServicePage(driver) : travelNotificationServicePage;
		
	}
	
	public static VirtualDebitCardOverviewPage getVirtualDebitCardOverviewPage(WebDriver driver) {
		
		return virtualDebitCardOverviewPage == null ? new VirtualDebitCardOverviewPage(driver) : virtualDebitCardOverviewPage;
	}
	
	public static BlockUnblockVirtualCardPage getBlockUnblockVirtualCardPage(WebDriver driver) {
		
		return blockUnblockVirtualCardPage == null ? new BlockUnblockVirtualCardPage(driver) : blockUnblockVirtualCardPage;
	}
	
	public static ResetPinPage getResetPinPage(WebDriver driver) {
		
		return resetPinPage == null ? new ResetPinPage(driver) : resetPinPage;
	}
	
	public static ChangeDebitingAcctVirtualCardPage getChangeDebitingAcctVirtualCardPage(WebDriver driver) {
		return changeDebitingAcctVirtualCardPage == null ? new ChangeDebitingAcctVirtualCardPage(driver) : changeDebitingAcctVirtualCardPage;
	}
	
	public static SetDailyLimitVirtualCardPage getSetDailyLimitVirtualCardPage(WebDriver driver) {
		
		return setDailyLimitVirtualCardPage == null ? new SetDailyLimitVirtualCardPage(driver) : setDailyLimitVirtualCardPage;
	}
	
	public static CreateUpdateNoteVirtualCardPage getCreateUpdateNoteVirtualCardPage(WebDriver driver) {
		
		return createUpdateNoteVirtualCardPage == null ? new CreateUpdateNoteVirtualCardPage(driver) : createUpdateNoteVirtualCardPage;
	}
	
	public static TransferToOwnAccountPage getTransferToOwnAccountPage(WebDriver driver) {
		
		return transferToOwnAccountPage == null ? new TransferToOwnAccountPage(driver) : transferToOwnAccountPage;
	}
	
	public static TransferToOtherAcctAtHLBCAMPage getTransferToOtherAcctAtHLBCAMPage(WebDriver driver) {
		
		return transferToOtherAcctAtHLBCAMPage == null ? new TransferToOtherAcctAtHLBCAMPage(driver) : transferToOtherAcctAtHLBCAMPage;
	}
	
	public static ManageFavouriteAccountsPage getManageFavouriteAccountsPage(WebDriver driver) {
		
		return manageFavouriteAccountsPage == null ? new ManageFavouriteAccountsPage(driver) : manageFavouriteAccountsPage;
	}
	
	public static LocalTransferPage getLocalTransferPage(WebDriver driver) {
		
		return localTransferPage == null ? new LocalTransferPage(driver) : localTransferPage;
	}
	
	public static OverseasTransferPage getOverseasTransferPage(WebDriver driver) {
		
		return overseasTransferPage == null ? new OverseasTransferPage(driver) : overseasTransferPage;
	}
	
	public static ViewHistoryPage getViewHistoryPage(WebDriver driver) {
		
		return viewHistoryPage == null ? new ViewHistoryPage(driver) : viewHistoryPage;
	}
	
	public static TransactionDetailsPage getTransactionDetailsPage(WebDriver driver) {
		
		return transactionDetailsPage == null ? new TransactionDetailsPage(driver) : transactionDetailsPage;
	}
	
	public static ManageStandingInstructionPage getManageStandingInstructionPage(WebDriver driver) {
	
		return manageStandingInstructionPage == null ? new ManageStandingInstructionPage(driver) : manageStandingInstructionPage;
	}
	
	public static StandingInstructionDetailsPage getStandingInstructionDetailsPage(WebDriver driver) {
		
		return standingInstructionDetailsPage == null ? new StandingInstructionDetailsPage(driver) : standingInstructionDetailsPage;
	}
	
	public static MyQRPage getMyQRPage(WebDriver driver) {
		return myQRPage == null ? new MyQRPage(driver) : myQRPage;
	}
	
	public static ESaverCreateAccountPage getESaverCreateAccountPage(WebDriver driver) {
		return eSaverCreateAccountPage == null ? new ESaverCreateAccountPage(driver) : eSaverCreateAccountPage;
	}
	
	public static ESaverPersonalizeAccountPage getESaverPersonalizeAccountPage(WebDriver driver) {
		
		return eSaverPersonalizeAccountPage == null ? new ESaverPersonalizeAccountPage(driver) : eSaverPersonalizeAccountPage;
	}
	
	public static ESaverCloseAccountPage getESaverCloseAccountPage(WebDriver driver) {
		
		return eSaverCloseAccountPage == null ? new ESaverCloseAccountPage(driver) :eSaverCloseAccountPage;
	}
}
