package AutomationRestAPI.SeleniumAutomationRestAPI;

import java.util.Set; 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BrowserWindowsTest 
{
     WebDriver driver;
     String mainWindowHandle;

    @BeforeClass
    public void setUp() 
    {
        // Set the path to chromedriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\OneDrive\\Desktop\\Selenium3\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/browser-windows");
        mainWindowHandle = driver.getWindowHandle();
        driver.manage().window().maximize();
    }

    @Test
    public void testNewTab() throws InterruptedException 
    {
        // Click on the "New Tab" button
        WebElement newTabButton = driver.findElement(By.id("tabButton"));
        newTabButton.click();

        // Switch to the new tab
        Set<String> allWindowHandles = driver.getWindowHandles();
        for (String handle : allWindowHandles) 
        {
            if (!handle.equals(mainWindowHandle)) 
            {
                driver.switchTo().window(handle);
                break;
            }
        }

        // Assert the title of the new tab
        String expectedTitle = "This is a sample page";
        String actualTitle = driver.getTitle();
        Assert.assertNotEquals(actualTitle, expectedTitle);
        Thread.sleep(5000);
    }
    
	@AfterClass
    public void tearDown() 
	{
        // Close the new tab
        driver.close();

        // Switch back to the main window
        driver.switchTo().window(mainWindowHandle);

        // Close the main window
        driver.quit();
    }
}



