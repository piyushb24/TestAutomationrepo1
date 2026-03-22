package testcase;
//Verify the Park Queue functionality TL Query.
import java.util.logging.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import base.BaseClass;
import pages.EVListingPages;
import pages.LoginPages;
import pages.ParkQueue_TLQuery;
import pages.QueueListingPage;
import pages.UploadDocumentPage;
import utilities.configreader;
@Listeners(listeners.TestListener.class)
public class AgentLoginTC05 extends BaseClass {
	private static final Logger log = Logger.getLogger(AgentLoginTC05.class.getName());
	  
	  
		  @Test
		  public void parkwithtlquery() throws Throwable {
			  log.info("Starting to perform the Park Queue Functionality With TL Query");
	 // Login
    String username = configreader.getProperty("username");
    String password = configreader.getProperty("password");
	
    // Initialize Page Objects using thread-safe driver
    LoginPages loginPage = new LoginPages(getDriver());
    loginPage.UnsafeURL();
    
    QueueListingPage workQueuePage = new QueueListingPage(getDriver());
    EVListingPages evListingPage = new EVListingPages(getDriver());
    
    // Step 1: Login
    loginPage.enterUsername(username);
    loginPage.enterPassword(password);
    loginPage.clickLogin();
    log.info("Agent logged in successfully");

    // Step 2: Click on EV Moodule
    workQueuePage.clickEVSubmodule();
    log.info("User Clicked on the EV Module Sucessfully");
    
    // Step 3: Click on the first Visit ID
    UploadDocumentPage firstVisitID = new UploadDocumentPage(getDriver());
    firstVisitID.clickfirstVisitID();
    log.info("User clicked the 1st Visit ID Successfully");
    
    // Step 4: Click on the Park Queue Button
    ParkQueue_TLQuery parkqueue = new ParkQueue_TLQuery (getDriver());
    parkqueue.clickParkQueueButton();
    parkqueue.clickonsenttodropdown();
    parkqueue.selectTLQuery();
    parkqueue.enterthevalueindescriptionbox();
    parkqueue.clickonthesubmitbutton();
    parkqueue.clickonokbutton();
    log.info("User Sucessfully parked the visitID");
    
    
    
    // Step 5: Logout
    workQueuePage.clickProfileDropdown();
    workQueuePage.clickLogoutButton();
    log.info("User Logged out Successfully");
    
}
}
