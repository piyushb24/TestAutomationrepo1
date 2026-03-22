package testcase;
//Verify the Agent can submit the entered/selected details once click on verified & submit button from Auto Assign tab claim.
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.DetailsForSpecificVisitorID;
import pages.EVListingPages;
import pages.LoginPages;
import pages.QueueListingPage;
import utilities.Excelutil;
import utilities.configreader;

@Listeners(listeners.TestListener.class)
public class AgentLoginTC03 extends BaseClass {
	private static final Logger log = Logger.getLogger(AgentLoginTC07.class.getName());
    @Test
    public void verifyEVFlow() throws InterruptedException {

        // ✅ Use new instance of Excelutil per thread
        Excelutil excel = new Excelutil(
            "C:\\Users\\25605\\Downloads\\Automation Files\\EVQueue.xlsx",
            "TC03"
        );

        // Login
        LoginPages login = new LoginPages(getDriver());
        login.UnsafeURL();
        login.enterUsername(configreader.getProperty("username"));
        login.enterPassword(configreader.getProperty("password"));
        login.clickLogin();
        log.info("User logged in Sucessfuly");

        // Navigate to EV Listing
        QueueListingPage queue = new QueueListingPage(getDriver());
        queue.clickEVSubmodule();
        log.info("User navigated to EV Submodule");

        EVListingPages evListing = new EVListingPages(getDriver());

        // EV Details
        DetailsForSpecificVisitorID evDetails = new DetailsForSpecificVisitorID(getDriver());
        evDetails.openFirstVisit();
        log.info("User is at 1st VisitID");

        evDetails.fillEVDetails(
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

        evDetails.addEVComment(excel.getCellData(11, 1));
        log.info("User sucessfully filled the details");

        // Verification
        evDetails.clickVerified();
        evDetails.printQueueMovementDetails();
        evDetails.submitPopup();

        Assert.assertTrue(evDetails.isVerificationSuccessful(), "EV verification failed");

        System.out.println("ASSERTION PASSED: Entry successfully verified");

        evDetails.clickOkOnSuccessPopup();
        log.info("User clicked on the Successful btn");

        // Logout
        Thread.sleep(3000); // ideally use WebDriverWait
        evListing.clickBackToMainButton();
        queue.clickProfileDropdown();
        queue.clickLogoutButton();
        log.info("User successfuly logged out");

        // ✅ Close Excel workbook
        excel.closeWorkbook();
    }
}
