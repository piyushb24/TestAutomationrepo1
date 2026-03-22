package testcase;
// Verify the Park Queue functionality work later.
import org.apache.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import base.BaseClass;
import pages.EVListingPages;
import pages.LoginPages;
import pages.ParkQueue_WLQuery;
import pages.QueueListingPage;
import pages.UploadDocumentPage;
import utilities.configreader;
@Listeners(listeners.TestListener.class)
public class AgentLoginTC06 extends BaseClass {
	private static final Logger log = Logger.getLogger(AgentLoginTC06.class.getName());
	
	@Test
	public void parkwithwlquery () {
		log.info("Starting to perform the Park Queue Functionality with WL Query");
		// login
		String username = configreader.getProperty("username");
		String password = configreader.getProperty("password");
		
		// Initialize POM using thread-safe driver
		LoginPages loginpage= new LoginPages(getDriver());
		loginpage.UnsafeURL();
		
		QueueListingPage queuelistpage = new QueueListingPage(getDriver());
		EVListingPages evlistingpage = new EVListingPages(getDriver());
		UploadDocumentPage uploaddocument = new UploadDocumentPage(getDriver());
		ParkQueue_WLQuery parkqueuewl= new ParkQueue_WLQuery(getDriver());
		
		//Login
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.clickLogin();
		log.info("Agent logged in sucessfully");
		
		// Click on EV Submodule
		queuelistpage.clickEVSubmodule();
		log.info("User clicked on the EV Module sucessfully");
		
		// click on the first visit ID
		uploaddocument.clickfirstVisitID();
		log.info("User clicked the 1st Visit ID sucessfully");
		
		// click on the Park Queue button
		parkqueuewl.ClickParkQueueButton();
		parkqueuewl.ClickSentToDropdownButton();
		parkqueuewl.ClickWLQuerydropdown();
		parkqueuewl.ClickOnDescriptionBoxText();
		parkqueuewl.ClickOnSubmitButtons();
		parkqueuewl.ClickOnOKButtons();	
		log.info("User sucessfully parked the visitID");
		
		// Logout
		queuelistpage.clickProfileDropdown();
		queuelistpage.clickLogoutButton();
		log.info("User logged out sucessfully");
	}
	
	
	

}
