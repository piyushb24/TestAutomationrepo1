package testcase;
//Verify the count on Work Queue page.
import org.apache.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import base.BaseClass;
import pages.LoginPages;
import pages.QueueListingPage;
import pages.GetTheCountOnEVListingPage;
@Listeners(listeners.TestListener.class)
public class AgentLoginTC01 extends BaseClass {
	private static final Logger log = Logger.getLogger(AgentLoginTC07.class.getName());
    @Test 
    public void testEVListingAndLogout() {

        LoginPages loginPage = new LoginPages(getDriver());
        loginPage.UnsafeURL();

        QueueListingPage queuePage = new QueueListingPage(getDriver());
        GetTheCountOnEVListingPage evPage = new GetTheCountOnEVListingPage(getDriver());

        loginPage.enterUsername(utilities.configreader.getProperty("username"));
        loginPage.enterPassword(utilities.configreader.getProperty("password"));
        loginPage.clickLogin();
        log.info("User Logged in Successfuly");

        queuePage.clickEVSubmodule();
        evPage.printNumberOfEntries();
        evPage.clickBackToMainButton();
        log.info("User is at the EV Submodule");

        queuePage.clickProfileDropdown();
        queuePage.clickLogoutButton();
        log.info("User Logged out sucessfully");
    }
}
