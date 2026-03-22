package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EVChangeRequest {
	
	WebDriver driver;
	public EVChangeRequest (WebDriver driver) {
		this.driver= driver;
	}
	// Locators
	By ClickonPlan = By.xpath("//span[@class='select2-selection select2-selection--single' and @role='combobox']");
	By ClickonOther = By.xpath("//li[contains(@class,'select2-results__option') and text()='Other']");
	By ClickonNewPlan = By.xpath("//input[@id='NewPlan']");
	By ClickonEVComment = By.xpath("//button[@id='idEVCommentsShows']");
	By EnterEVComment= By.xpath("//textarea[@id='EVVComment']");
	By ClickonChangeRequest = By.xpath("//button[@id='EvChangeRequest']");
	By ClickonYes = By.xpath("//button[contains(@class,'swal2-confirm') and contains(@class,'swal2-styled')]");
	By ClickonOK = By.xpath("//button[normalize-space()='OK']");

// Methods

public void ClickonPlanBtn () {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	WebElement element = wait.until(ExpectedConditions.elementToBeClickable(ClickonPlan));
	element.click();
}

public void ClickonOtherBtn () {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	WebElement element = wait.until(ExpectedConditions.elementToBeClickable(ClickonOther));
	element.click();
}

public void ClickonNewPlanBtn () {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	WebElement element = wait.until(ExpectedConditions.elementToBeClickable(ClickonNewPlan));
	element.sendKeys("Test");
}

public void ClickonEVCommentBtm () {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	WebElement element = wait.until(ExpectedConditions.elementToBeClickable(ClickonEVComment));
	//scroll to center
	((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
	//small wait for animations
	try {Thread.sleep(500);} catch (InterruptedException e) {}
	// JS click (bypass overlay issue)
	((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
}
public void EnterEVCommentBtn () {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	WebElement element = wait.until(ExpectedConditions.elementToBeClickable(EnterEVComment));
	element.sendKeys("Test");
}
public void ClickonChangeRequestBtn () {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	WebElement element= wait.until(ExpectedConditions.elementToBeClickable(ClickonChangeRequest));
	//scroll to center
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
		//small wait for animations
		try {Thread.sleep(500);} catch (InterruptedException e) {}
		// JS click (bypass overlay issue)
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);

}

public void ClickonYesBtn () {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	WebElement element = wait.until(ExpectedConditions.elementToBeClickable(ClickonYes));
	element.click();
}

public void ClickonOKBtn () {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.elementToBeClickable(ClickonOK));
	
}

}