package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DetailsForSpecificVisitorID2 {
	WebDriver driver;
	public DetailsForSpecificVisitorID2 (WebDriver driver) {
		this.driver = driver;
	}
	// locators
	By firstVisitId = By.xpath("//a[@class='visitid']");
	By ClickManualTab = By.xpath("//button[@id='btnEVMannualAssignTab']");
	
	//dropdown locators
	By SourceDDClick = By.xpath("//select[@id='EvUid']");
	By PolicyActiveDDClick = By.xpath("//select[@id='EVPolicyActiveDOS']");
	By CorrectPayorDDClick = By.xpath("//select[@id='EVCorrectPayerDetails']");
	By COBDDClick= By.xpath("//select[@id='EvCOB']");
	By PlanDDClick = By.xpath("//span[@id='select2-PlanType-container']");
	By DeductibileDDClick = By.xpath("//select[@id='EVRemainingDeductible']");
	
	// Textbox locators
	By SourceDetailsTxt = By.xpath("//input[@id='SourceDetails']");
	By PolicyFromDate = By.xpath("//input[@id='EVPolicyActiveDateFrom']");
	By PolicyToDate = By.xpath("//input[@id='EVPolicyActiveDateTo']");
	By DeductibleValueTxt = By.xpath("//input[@id='DeductibleValue']");
	
	// EVComment Locator
	By EVCommentClick = By.xpath("//button[@id='idEVCommentsShows']");
	By EVCommentTxt = By.xpath("//textarea[@id='EVVComment']");
	
	// Button Locator
	By VerifyBtn= By.xpath("//button[@id='EV_Verify']");
	
	// Popup locator for the info
	By evStatusValue = By.xpath("//input[@id='inpEVStatus']");
	By evActionValue = By.xpath("//input[@id='inpEVAction']");
	By SubmitBtn = By.xpath("//button[@id='BtnEvSubmit']");
	
	// Success Popup
	By SuccessMsg = By.xpath("//div[@id='swal2-html-container' and normalize-space()='EV submitted successfully!']");
	By OKBtn = By.xpath("//button[contains(@class,'swal2-confirm') and normalize-space()='OK']");
	
	// Method
	
	
	public void clickonmanualtab () throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(ClickManualTab));
		element.click();
		Thread.sleep(5000);
	}
	public void click (By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
	}
	public void enterText (By locator, String value) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.clear();
		element.sendKeys(value);
	}
	public void selectByVisibleText (By locator, String value) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		Select select = new Select (element);
		select.selectByVisibleText(value);
	}
	public void selectFromSelect2 (By dropdown, String value) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(dropdown));
		element.click();
		By option = By.xpath("//li[contains(@class,'select2-results__option') and normalize-space()='\" + value + \"']");
		wait.until(ExpectedConditions.elementToBeClickable(option)).click();	
	}
	

	 public void openFirstVisit() {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 WebElement element = wait.until(ExpectedConditions.elementToBeClickable(firstVisitId));
		 ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView({block:'center'});", element);
		 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
	    }
	
	public void fillEVDetails (
			String source,
			String sourceDetails,
            String policyActive,
            String correctPayor,
            String cob,
            String fromDate,
            String toDate,
            String plan,
            String deductibleNetwork,
            String deductibleValue){
		
		//source Dropdown
		selectByVisibleText(SourceDDClick, source);
		enterText(SourceDetailsTxt, sourceDetails);
		selectByVisibleText(PolicyActiveDDClick, policyActive);
		selectByVisibleText(CorrectPayorDDClick, correctPayor);
		selectByVisibleText(COBDDClick, cob);
		enterText(PolicyFromDate, fromDate);
        enterText(PolicyToDate, toDate);
        selectFromSelect2(PlanDDClick, plan);
        selectByVisibleText(DeductibileDDClick, deductibleNetwork);
        enterText(DeductibleValueTxt, deductibleValue);
      
}
	public void addEVComment (String comment) {
		click (EVCommentClick);
		enterText(EVCommentTxt, comment);
	}
	public void clickVerified() {
		click(VerifyBtn);
		
	}
	public void printQueueMomentDetails() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		String status = wait.until(ExpectedConditions.visibilityOfElementLocated(evStatusValue)).getAttribute("value");
		String action = wait.until(ExpectedConditions.visibilityOfElementLocated(evActionValue)).getAttribute("value");
		System.out.println("EV Status: " + status );
		System.out.println("EV Action: " + action);
	}
	public void submitPopup() {
		click(SubmitBtn);
	}
	public boolean isVerificationSuccessful() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(SuccessMsg)).isDisplayed();
	}
	public void clickOkOnSuccessPopup() {
		click(OKBtn);
	}
}
