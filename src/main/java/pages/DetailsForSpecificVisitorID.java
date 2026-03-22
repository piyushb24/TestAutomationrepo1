package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DetailsForSpecificVisitorID {

    WebDriver driver;
    WebDriverWait wait;

    public DetailsForSpecificVisitorID(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // Locator 
    By firstVisitId = By.xpath("//a[@class='visitid']");

    // -------- Dropdown CLICK locators --------
    By sourceDDClick = By.xpath("//select[@id='EvUid']");
    By policyActiveDDClick = By.xpath("//select[@id='EVPolicyActiveDOS']");
    By correctPayorDDClick = By.xpath("//select[@id='EVCorrectPayerDetails']");
    By cobDDClick = By.xpath("//select[@id='EvCOB']");
    By planDDClick = By.xpath("//span[@id='select2-PlanType-container']");
    By deductibleNetworkDDClick = By.xpath("//select[@id='EVRemainingDeductible']");

    // -------- Textbox locators --------
    By sourceDetailsTxt = By.xpath("//input[@id='SourceDetails']");
    By policyFromDate = By.xpath("//input[@id='EVPolicyActiveDateFrom']");
    By policyToDate = By.xpath("//input[@id='EVPolicyActiveDateTo']");
    By deductibleValueTxt = By.xpath("//input[@id='DeductibleValue']");

    // -------- EV Comment --------
    By evCommentAccordion = By.xpath("//button[@id='idEVCommentsShows']");
    By evCommentTxt = By.xpath("//textarea[@id='EVVComment']");

    // -------- Buttons --------
    By verifiedButton = By.xpath("//button[@id='EV_Verify']");

    // -------- Popup --------
    By evStatusValue = By.xpath("//input[@id='inpEVStatus']");
    By evActionValue = By.xpath("//input[@id='inpEVAction']");
    By submitPopupBtn = By.xpath("//button[@id='BtnEvSubmit']");

    // -------- Success popup --------
    By successMsg = By.xpath("//div[@id='swal2-html-container' and normalize-space()='EV submitted successfully!']");
    By okButton = By.xpath("//button[contains(@class,'swal2-confirm') and normalize-space()='OK']");

    // Methods

    private void click(By locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element); // JS click
    }

    private void enterText(By locator, String value) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(value);
    }

    private void selectByVisibleText(By locator, String value) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        Select select = new Select(element);
        select.selectByVisibleText(value);
    }

    private void selectFromSelect2(By dropdown, String value) {
        // Click the Select2 dropdown
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(dropdown));
        element.click();

        // Select value from dropdown list
        By option = By.xpath(
            "//li[contains(@class,'select2-results__option') and normalize-space()='" + value + "']"
        );

        wait.until(ExpectedConditions.elementToBeClickable(option)).click();
    }

    // Business Methods

    public void openFirstVisit() {
        click(firstVisitId);
    }

    public void fillEVDetails(
            String source,
            String sourceDetails,
            String policyActive,
            String correctPayor,
            String cob,
            String fromDate,
            String toDate,
            String plan,
            String deductibleNetwork,
            String deductibleValue) {

        // Source dropdown
        selectByVisibleText(sourceDDClick, source);
        enterText(sourceDetailsTxt, sourceDetails);

        // Policy Active dropdown
        selectByVisibleText(policyActiveDDClick, policyActive);

        // Correct Payor dropdown
        selectByVisibleText(correctPayorDDClick, correctPayor);

        // COB dropdown
        selectByVisibleText(cobDDClick, cob);

        // Dates
        enterText(policyFromDate, fromDate);
        enterText(policyToDate, toDate);

        // Plan (Select2 custom dropdown)
        selectFromSelect2(planDDClick, plan);

        // Deductible Network dropdown
        selectByVisibleText(deductibleNetworkDDClick, deductibleNetwork);

        // Deductible value
        enterText(deductibleValueTxt, deductibleValue);
    }

    public void addEVComment(String comment) {
        click(evCommentAccordion);
        enterText(evCommentTxt, comment);
    }

    public void clickVerified() {
        click(verifiedButton);
    }

    public void printQueueMovementDetails() {
        String status = wait.until(ExpectedConditions.visibilityOfElementLocated(evStatusValue)).getAttribute("value");
        String action = wait.until(ExpectedConditions.visibilityOfElementLocated(evActionValue)).getAttribute("value");

        System.out.println("EV Status  : " + status);
        System.out.println("EV Action  : " + action);
    }


    public void submitPopup() {
        click(submitPopupBtn);
    }

    public boolean isVerificationSuccessful() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successMsg)).isDisplayed();
    }

    public void clickOkOnSuccessPopup() {
        click(okButton);
    }
}
