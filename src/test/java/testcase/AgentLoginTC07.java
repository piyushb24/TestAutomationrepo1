package testcase;
// verify the Change Request functionality.
import org.apache.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import base.BaseClass;
import pages.EVChangeRequest;
import pages.EVListingPages;
import pages.LoginPages;
import pages.ParkQueue_WLQuery;
import pages.QueueListingPage;
import pages.UploadDocumentPage;
import utilities.configreader;
@Listeners(listeners.TestListener.class)
public class AgentLoginTC07 extends BaseClass {
	private static final Logger log = Logger.getLogger(AgentLoginTC07.class.getName());
	
	@Test
	
	public void EVChangeRequest () {
		log.info("Starting to perform the EV Change Request Functionality");
		
		// login
		String username = configreader.getProperty("username");
		String password = configreader.getProperty("password");
				
		// Initialize POM using thread-safe driver
		
		LoginPages loginpage = new LoginPages(getDriver());
		loginpage.UnsafeURL();
	
		
		QueueListingPage queuelistpage = new QueueListingPage(getDriver());
		EVListingPages evlistingpage = new EVListingPages(getDriver());
		UploadDocumentPage uploaddocument = new UploadDocumentPage(getDriver());
		EVChangeRequest evchangerequests = new EVChangeRequest(getDriver());
	
		// Login
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.clickLogin();
		log.info("Agent logged in sucessfully");
		
		//click on the Ev Submodule
		
		queuelistpage.clickEVSubmodule();
		log.info("User clicked on the EV Module sucessfully");
		
		// click on the 1st visitID
		
		uploaddocument.clickfirstVisitID();
		log.info("user clicked the 1st VisitID");
		
		// click on the Change Request Button
		evchangerequests.ClickonPlanBtn();
		evchangerequests.ClickonOtherBtn();
		evchangerequests.ClickonNewPlanBtn();
		evchangerequests.ClickonEVCommentBtm();
		evchangerequests.EnterEVCommentBtn();
		evchangerequests.ClickonChangeRequestBtn();
		evchangerequests.ClickonYesBtn();
		evchangerequests.ClickonOKBtn();
		log.info("User sucessfully sent the request to the Change Request");
		
		// logout
		queuelistpage.clickProfileDropdown();
		queuelistpage.clickLogoutButton();
		log.info("User logged out sucessfully");
	
		
	}
	
	
	
	
	

}
