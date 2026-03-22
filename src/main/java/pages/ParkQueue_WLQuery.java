package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ParkQueue_WLQuery {
	
	WebDriver driver;
	public ParkQueue_WLQuery (WebDriver driver) {
		this.driver = driver;
	}
	// Locators
	
	By ClickParkQueue = By.xpath("//button[@data-bs-target='#ParkQueue']");
	By ClickSentToDropdown= By.xpath("//select[@id='EvSentTo']");
	//By ClickWLQuery = By.xpath("//option[@value='Work Later']");
	By ClickOnDescriptionBox= By.xpath("//textarea[@id='EvParkReason']");
	By ClickOnSubmitButton = By.xpath("//button[@id='btnEvParkCaseSave']");
	By ClickoOnOKButton = By.xpath("//button[contains(@class,'swal2-confirm') and normalize-space()='Ok']");

	//Methods
	
	public void ClickParkQueueButton () {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(ClickParkQueue));
		
		//scroll to the center (Better than true)
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
		// small wait for animation
		try {Thread.sleep(500);} catch (InterruptedException e) {}
		//JS Click (Bypass overlay Issue)
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}
	public void ClickSentToDropdownButton () {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(ClickSentToDropdown));
	}
	public void ClickWLQuerydropdown () {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(ClickSentToDropdown));
		Select select = new Select(dropdown);
		select.selectByVisibleText("Work Later");
	}
	public void ClickOnDescriptionBoxText () {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(ClickOnDescriptionBox));
		element.sendKeys("Test");
	}
	public void ClickOnSubmitButtons () {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(ClickOnSubmitButton));
		element.click();
	}
	public void ClickOnOKButtons () {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(ClickoOnOKButton));
		element.click();
	}

}
