package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GetTheCountOnEVListingPage {

    WebDriver driver;

    public GetTheCountOnEVListingPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By backToMainButton = By.xpath("//a[@class='btn btn-primary w-100 mb-3']");
    By entriesText = By.xpath("//div[@id='tblEVAutoAssigned_info']"); 

    // Methods
   
    public void clickBackToMainButton() {
        driver.findElement(backToMainButton).click();
    }

    public void printNumberOfEntries() {
        WebElement element = driver.findElement(entriesText);
        String text = element.getText(); // Example: "Showing 1 to 10 of 45 entries"
        System.out.println("EV Listing Info: " + text);

        // Optional: extract total count
        String totalEntries = text.split(" of ")[1].split(" entries")[0];
        System.out.println("Total number of entries: " + totalEntries);
    }
}
