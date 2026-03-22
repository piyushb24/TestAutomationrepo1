package testcase;
//Verify the upload doc functionality.
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.EVListingPages;
import pages.LoginPages;
import pages.QueueListingPage;
import pages.UploadDocumentPage;
import utilities.Excelutil;
import utilities.configreader;

@Listeners(listeners.TestListener.class)
public class AgentLoginTC04 extends BaseClass {
	private static final Logger log = Logger.getLogger(AgentLoginTC07.class.getName());
    @Test
    public void uploadDocumentTest() throws InterruptedException {

        // ✅ Thread-safe Excelutil
        Excelutil excel = new Excelutil(
            "C:\\Users\\25605\\Downloads\\Automation Files\\EVQueue.xlsx",
            "TC04"
        );

        String documentType = excel.getCellData(1, 1);
        String pages = excel.getCellData(2, 1);
        String documentFormat = excel.getCellData(3, 2);
        String filePath = excel.getCellData(1, 3);

        // 1️⃣ Login
        LoginPages login = new LoginPages(getDriver());
        login.UnsafeURL();
        login.enterUsername(configreader.getProperty("username"));
        login.enterPassword(configreader.getProperty("password"));
        login.clickLogin();
        log.info("User Logged in Successfully");

        // 2️⃣ Navigate to EV SubModule
        QueueListingPage queue = new QueueListingPage(getDriver());
        queue.clickEVSubmodule();
        log.info("User navigated to the EV Submodule");

        // 3️⃣ Click first Visit ID
        UploadDocumentPage firstVisitID = new UploadDocumentPage(getDriver());
        firstVisitID.clickfirstVisitID();
        log.info("User clicked on the first visitID");

        // 4️⃣ Upload Document
        UploadDocumentPage uploadPage = new UploadDocumentPage(getDriver());
        uploadPage.clickUploadDocumentButton();
        uploadPage.selectDocumentType(documentType);
        uploadPage.enterPages(pages);
        uploadPage.selectDocumentFormat(documentFormat);
        uploadPage.selectDocumenttypepdf(documentFormat);
        uploadPage.chooseFile(filePath);
        uploadPage.clickSubmit();
        log.info("User Uploded the document sucessfully");

        // 5️⃣ Verify Success
        boolean isSuccess = uploadPage.verifySuccessPopupAndClickOK();
        Assert.assertTrue(isSuccess, "Document upload failed!");

        // 6️⃣ Navigate back
        EVListingPages evListing = new EVListingPages(getDriver());
        evListing.clickBackToMainButton();
        Thread.sleep(3000);
        evListing.clickBackToMainButton();

        // 7️⃣ Logout
        queue.clickProfileDropdown();
        queue.clickLogoutButton();
        log.info("User logged out successfully");

        // ✅ Close Excel workbook
        excel.closeWorkbook();
    }
}
