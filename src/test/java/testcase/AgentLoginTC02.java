package testcase;
// Verify the Request Claim Button functionality in Auto Assigned Claim page.
import java.util.logging.Logger;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.EVListingPages;
import pages.LoginPages;
import pages.QueueListingPage;
import utilities.configreader;

@Listeners(listeners.TestListener.class)
public class AgentLoginTC02 extends BaseClass {

    private static final Logger log = Logger.getLogger(AgentLoginTC02.class.getName());

    @Test
    public void RequestClaimButtonFlow() {

        log.info("Starting to perform the Request Claims");

        // Load credentials from config
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

        // Step 2: Navigate to Work Queue
        workQueuePage.clickEVSubmodule();

        // Step 3: EV Listing Page - Request Claim
        evListingPage.clickRequestClaimsButton();
        evListingPage.clickBackToMainButton();
        log.info("Request Claims successful");

        // Step 4: Logout
        workQueuePage.clickProfileDropdown();
        workQueuePage.clickLogoutButton();
    }
}
