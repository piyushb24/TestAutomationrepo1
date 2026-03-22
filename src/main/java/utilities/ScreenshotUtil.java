package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

public class ScreenshotUtil {

    public static void takeScreenshot(WebDriver driver, String testName) {
        if (driver == null) {
            System.out.println("Driver is null. Cannot take screenshot.");
            return;
        }

        try {
            // Scroll to top to avoid overlay issues
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,0);");

            // Timestamp for unique screenshot names
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

            // Folder path
            String folderPath = "C:\\Users\\25605\\Downloads\\Automation Files\\Screenshot for the failed test cases\\";
            File folder = new File(folderPath);
            if (!folder.exists()) folder.mkdirs();

            // File path
            String screenshotPath = folderPath + testName + "_" + timestamp + ".png";

           
            // Take screenshot
            File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destination = new File(screenshotPath);
            FileUtils.copyFile(source, destination);

            System.out.println("Screenshot saved at: " + screenshotPath);

        } catch (WebDriverException e) {
            System.out.println("WebDriver exception while taking screenshot: " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
