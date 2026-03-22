package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EVListingPages {

    WebDriver driver;

    public EVListingPages(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By requestClaimsButton = By.xpath("//button[@id='BtnEVRequestClaims']");
    By backToMainButton = By.xpath("//a[@class='btn btn-primary w-100 mb-3']");

    // Methods
    public void clickRequestClaimsButton() {
        driver.findElement(requestClaimsButton).click();
    }

    public void clickBackToMainButton() {
        driver.findElement(backToMainButton).click();
    }
}
