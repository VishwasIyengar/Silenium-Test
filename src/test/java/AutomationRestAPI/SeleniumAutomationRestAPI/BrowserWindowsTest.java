package AutomationRestAPI.SeleniumAutomationRestAPI;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class BrowserWindowsTest {

    WebDriver driver;
    String mainWindowHandle;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hp\\Downloads\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");  // Set a fixed window size for consistency in headless mode
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/browser-windows");
        mainWindowHandle = driver.getWindowHandle();
    }


    @Test
    public void testNewTab() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));  // Increase wait time

        // Ensure the "New Tab" button is scrolled into view
        WebElement newTabButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tabButton")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", newTabButton);
        wait.until(ExpectedConditions.elementToBeClickable(newTabButton));
        
        try {
            newTabButton.click();
        } catch (ElementClickInterceptedException e) {
            // Use JavaScript as a fallback
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", newTabButton);
        }

        // Switch to the new tab
        Set<String> allWindowHandles = driver.getWindowHandles();
        for (String handle : allWindowHandles) {
            if (!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }

        // Wait for the new tab to load content
        WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sampleHeading")));

        // Assert the heading of the new tab
        String expectedHeading = "This is a sample page";
        String actualHeading = heading.getText();
        Assert.assertEquals(actualHeading, expectedHeading);

        Thread.sleep(5000);
    }

    @AfterClass
    public void tearDown() {
        // Close all tabs except the main window
        Set<String> allWindowHandles = driver.getWindowHandles();
        for (String handle : allWindowHandles) {
            if (!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle);
                driver.close();
            }
        }

        // Switch back to the main window
        driver.switchTo().window(mainWindowHandle);

        // Close the main window
        driver.quit();
    }
}
