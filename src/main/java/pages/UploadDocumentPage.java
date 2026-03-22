package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UploadDocumentPage {

    WebDriver driver;
    WebDriverWait wait;

    public UploadDocumentPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // Locators
    By firstVisitId = By.xpath("//a[@class='visitid']");
    By uploadDocumentButton = By.xpath("//button[@id='EvDocumentManagement']");
    By documentTypeDropdown = By.xpath("//select[@id='EVDocumentType']"); // example, adjust with real locator
    By pagesField = By.xpath("//input[@id='EVPages']"); // example
    By documentFormatDropdown = By.xpath("//select[@id='EVDocumentFormat']"); // example
    By selectdocumenttypepdf = By.xpath("//option[@value='PDF' and normalize-space()='PDF']");
    By chooseFileButton = By.xpath("//input[@id='EVUploadDocument']"); // example
    By submitButton = By.xpath("//button[@id='BtnSubmitDoc']");
    By successPopup = By.xpath("//div[@id='swal2-html-container' and normalize-space()='Document Uploaded Successfully!']"); // example
    By okButtonOnPopup = By.xpath("//button[normalize-space(text())='OK']");

    // Methods
    
    public void clickfirstVisitID() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(firstVisitId));
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});", element
            );

            // JS click to avoid interception
            ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();", element
            );
        }
    
    public void clickUploadDocumentButton() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(uploadDocumentButton));
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});", element
            );

            ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();", element
            );
        }

    public void selectDocumentType(String docType) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(documentTypeDropdown));
        element.click();
        element.findElement(By.xpath("//option[text()='" + docType + "']")).click();
    }

    public void enterPages(String pages) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(pagesField));
        element.clear();
        element.sendKeys(pages);
    }

    public void selectDocumentFormat(String format) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(documentFormatDropdown));
        element.click();
        //element.findElement(By.xpath("//option[text()='" + format + "']")).click();
    }

    public void selectDocumenttypepdf(String format) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(selectdocumenttypepdf));
        element.click();
        //element.findElement(By.xpath("//option[text()='" + format + "']")).click();
    }
    
    
    public void chooseFile(String filePath) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(chooseFileButton));
        element.sendKeys(filePath);
    }

    public void clickSubmit() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        element.click();
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();", element
            );
        }
    

    public boolean verifySuccessPopupAndClickOK() {
    	WebElement popup = wait.until(
    	        ExpectedConditions.visibilityOfElementLocated(successPopup)
    	    );

    	    boolean isDisplayed = popup.isDisplayed();

    	    WebElement okBtn = wait.until(
    	        ExpectedConditions.elementToBeClickable(okButtonOnPopup)
    	    );

    	    ((JavascriptExecutor) driver).executeScript(
    	        "arguments[0].click();", okBtn
    	    );

    	    return isDisplayed;
    	}
}
