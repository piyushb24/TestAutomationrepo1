package testcase;
//Verify the Agent can submit the entered/selected details once click on verified & submit button from Mannually Assign tab claim. 
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import base.BaseClass;
import pages.DetailsForSpecificVisitorID2;
import pages.EVListingPages;
import pages.LoginPages;
import pages.QueueListingPage;
import pages.UploadDocumentPage;
import utilities.Excelutil;
import utilities.configreader;
@Listeners(listeners.TestListener.class)
// Verify the Agent can submit the entered/selected details once click on verified & submit button from Mannually Assign tab claim.
public class AgentLoginTC08 extends BaseClass {
	private static final Logger log = Logger.getLogger(AgentLoginTC07.class.getName());
	@Test
	public void verifymanualflow () throws Throwable {
		
		Excelutil excel = new Excelutil("C:\\Users\\25605\\Downloads\\Automation Files\\EVQueue.xlsx", "TC08");
		LoginPages login = new LoginPages(getDriver());
        login.UnsafeURL();
        login.enterUsername(configreader.getProperty("username"));
        login.enterPassword(configreader.getProperty("password"));
        login.clickLogin();
        log.info("User Logged in sucessfully");
        
        QueueListingPage queue = new QueueListingPage(getDriver());
        queue.clickEVSubmodule();
        log.info("User navigated to the EvListing Page");
        DetailsForSpecificVisitorID2 details2 = new DetailsForSpecificVisitorID2(getDriver());
        details2.clickonmanualtab();
        log.info("User is at the Manual allocation tab");
        details2.openFirstVisit();
        log.info("User is at the 1st visitID");
        EVListingPages evListing = new EVListingPages(getDriver());
        details2.fillEVDetails(
        		excel.getCellData(1, 1),
                excel.getCellData(2, 1),
                excel.getCellData(3, 1),
                excel.getCellData(4, 1),
                excel.getCellData(5, 1),
                excel.getCellData(6, 1),
                excel.getCellData(7, 1),
                excel.getCellData(8, 1),
                excel.getCellData(9, 1),
                excel.getCellData(10, 1)
        		);
        details2.addEVComment(excel.getCellData(11, 1));
        log.info("User Entered all the details");
        details2.clickVerified();
        details2.printQueueMomentDetails();
        details2.submitPopup();
        log.info("User submited details successfully");
        Assert.assertTrue(details2.isVerificationSuccessful(), "EV verification failed");
        System.out.println("Assertion Passed: Entry sucessfully verified");
        details2.clickOkOnSuccessPopup();
        
        Thread.sleep(3000);
        evListing.clickBackToMainButton();
        queue.clickProfileDropdown();
        queue.clickLogoutButton();
        log.info("User loggedout successfully");
        excel.closeWorkbook();
	}

}
