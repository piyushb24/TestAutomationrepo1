package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPages {

	WebDriver driver;

    public LoginPages(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By usernameField = By.id("UserID");
    By passwordField = By.id("Password");
    By loginButton = By.id("btnsubmit");
    By Advbtn =By.xpath("//*[@id='details-button']");
    By linkclick =By.xpath("//*[@id='proceed-link']");
    

    // Methods
    public void UnsafeURL() {
    	 driver.findElement(Advbtn).click();
    	 driver.findElement(linkclick).click();	
    }
        
    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }
}