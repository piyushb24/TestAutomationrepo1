package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.configreader;

public class BaseClass {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	public WebDriver getDriver() {
	    return driver.get();
	}

	@BeforeClass
	public void setUp() {
	    configreader.loadConfig();

	    String browser = configreader.getProperty("browser");
	    String url = configreader.getProperty("url");
	    String headless = configreader.getProperty("headless");

	    if (browser.equalsIgnoreCase("chrome")) {
	        WebDriverManager.chromedriver().setup();
	        ChromeOptions options = new ChromeOptions();
	        if ("true".equalsIgnoreCase(headless)) {
	            options.addArguments("--headless=new");
	            options.addArguments("--window-size=1920,1080");
	        }
	        driver.set(new ChromeDriver(options));
	    }

	    getDriver().manage().window().maximize();
	    getDriver().get(url);

	    System.out.println("Browser started in Thread ID: " + Thread.currentThread().getId());
	}

    @AfterClass
    public void tearDown() {
        if (getDriver() != null) {
            getDriver().quit();
            driver.remove();
        }
    }
}
