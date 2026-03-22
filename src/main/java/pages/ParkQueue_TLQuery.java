package pages;

import java.awt.TextArea;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class ParkQueue_TLQuery {
	
	WebDriver driver;
	
	public ParkQueue_TLQuery (WebDriver driver) {
		this.driver = driver;
	}
	
	// Locators
	By ClickParkQueue = By.xpath("//button[@data-bs-target='#ParkQueue']");
	By ClicSentToDropdown = By.xpath("//select[@id='EvSentTo']");
	By ClickTLQuery= By.xpath("//select[@id='EvSentTo']/option[@value='TL Query']");
	By ClickOnDescriptionBox= By.xpath("//textarea[@id='EvParkReason']");
	By ClickOnSubmitButton = By.xpath("//button[@id='btnEvParkCaseSave']");
	By ClickOnOKButton = By.xpath("//button[contains(@class,'swal2-confirm') and normalize-space()='Ok']");
	
	// Methods
	
	public void clickParkQueueButton() {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	    WebElement element = wait.until(
	            ExpectedConditions.elementToBeClickable(ClickParkQueue));

	    // Scroll to center (better than true)
	    ((JavascriptExecutor) driver).executeScript(
	            "arguments[0].scrollIntoView({block: 'center'});", element);

	    // Small wait for animation
	    try { Thread.sleep(500); } catch (InterruptedException e) {}

	    // JS Click (bypasses overlay issue)
	    ((JavascriptExecutor) driver).executeScript(
	            "arguments[0].click();", element);
	}
	public void clickonsenttodropdown () {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(ClicSentToDropdown));
	}
	public void selectTLQuery () {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(ClicSentToDropdown));
		Select select = new Select(dropdown);
		select.selectByVisibleText("TL Query");
	}
	public void enterthevalueindescriptionbox() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement textarea = wait.until(ExpectedConditions.visibilityOfElementLocated(ClickOnDescriptionBox));
		textarea.clear();
		textarea.sendKeys("Test");
	}
	public void clickonthesubmitbutton () {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement submit = wait.until(ExpectedConditions.visibilityOfElementLocated(ClickOnSubmitButton));
		submit.click();
	}
	public void clickonokbutton() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement okbtn = wait.until(ExpectedConditions.visibilityOfElementLocated(ClickOnOKButton));
		okbtn.click();
	}

}
