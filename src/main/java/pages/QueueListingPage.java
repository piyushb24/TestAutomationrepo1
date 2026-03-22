package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class QueueListingPage {

    WebDriver driver;
    WebDriverWait wait;

    public QueueListingPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // Locators

    // EV Submodule button
    By evSubmodule = By.xpath("//a[@class='card-footer p-3 bg-card_1']");

    // Profile dropdown 
    By profileDropdown = By.xpath("//span[@class='text-muted f-12']");

    // Logout button
    By logoutButton = By.xpath("//a[contains(normalize-space(),'Log Out')]");

    // Methods
    // Click EV Submodule
    public void clickEVSubmodule() {

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(evSubmodule));

        // Scroll into view to avoid hidden / overlay issues
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
 
        wait.until(ExpectedConditions.elementToBeClickable(evSubmodule));

        element.click(); // normal click works here
    }

    // Click profile dropdown
    public void clickProfileDropdown() {

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(profileDropdown));

        // Scroll into view to avoid interception
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

        wait.until(ExpectedConditions.elementToBeClickable(profileDropdown));

        // JS click to avoid "ElementClickInterceptedException"
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    // Click Logout button
    public void clickLogoutButton() {

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(logoutButton));

        // Scroll into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

        wait.until(ExpectedConditions.elementToBeClickable(logoutButton));

        // JS click for stable logout
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
}
