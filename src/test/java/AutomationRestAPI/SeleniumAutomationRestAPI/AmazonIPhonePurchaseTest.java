package AutomationRestAPI.SeleniumAutomationRestAPI;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class AmazonIPhonePurchaseTest {
    WebDriver driver;
    WebDriverWait wait;

    @SuppressWarnings("deprecation")
    @BeforeClass
    public void setUp() {
        // Set up WebDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hp\\Downloads\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));  // Increase wait time
    }

    @Test
    public void testIPhonePurchase() throws InterruptedException, IOException {
        try {
        // Search for iPhone
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='twotabsearchtextbox']")));
        searchBox.sendKeys("iPhone");

        WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='nav-search-submit-button']")));
        searchButton.click();

        WebElement secondExpensiveIPhone = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Apple iPhone 15 Plus (128 GB) - Black")));
        secondExpensiveIPhone.click();

        Set<String> s = driver.getWindowHandles();
        ArrayList<String> ar = new ArrayList<>(s);
        driver.switchTo().window(ar.get(1));

        WebElement addCard = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='add-to-cart-button'])[2]")));
        addCard.click();

        WebElement proceedToCheckOut = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@aria-labelledby='attach-sidesheet-checkout-button-announce'])[1]")));
        proceedToCheckOut.click();

        // Wait for the page to load completely
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='ap_email_login']")));

        
                // ... your test steps ...

                WebElement enterEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='ap_email_login']")));
                enterEmail.sendKeys("vishwassv1995@gmail.com");

                // ... other steps ...
           


        WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='submit']")));
        continueButton.click();

        WebElement enterPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='ap_password']")));
        enterPassword.sendKeys("Vishu@2024");

        WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='signInSubmit']")));
        signInButton.click();

        WebElement fullNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='address-ui-widgets-enterAddressFullName'])[1]")));
        fullNameInput.sendKeys("Vishwas Iyenagr");

        WebElement mobileNumberInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='address-ui-widgets-enterAddressPhoneNumber'])[1]")));
        mobileNumberInput.sendKeys("6361797204");

        WebElement postalCodeInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='address-ui-widgets-enterAddressPostalCode'])[1]")));
        postalCodeInput.sendKeys("560072");

        WebElement flatHousenoBuildingCompanyApartmentInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='address-ui-widgets-enterAddressLine1'])[1]")));
        flatHousenoBuildingCompanyApartmentInput.sendKeys("#20/21 Sri KrishnaVenu");

        WebElement areaStreetSectorVillageInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='address-ui-widgets-enterAddressLine2'])[1]")));
        areaStreetSectorVillageInput.sendKeys("Maruthi Nagar 5th cross Chandra Layout");

        WebElement landMark = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='address-ui-widgets-landmark'])[1]")));
        landMark.sendKeys("Beside Deffodil Kid Center");

        WebElement City = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='address-ui-widgets-enterAddressCity'])[1]")));
        City.sendKeys("BENGALURU");

        WebElement stateDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@role='button'])[2]")));
        stateDropdown.click();

        WebElement karnatakaOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[normalize-space()='KARNATAKA'])[1]")));
        try {
            karnatakaOption.click();
        } catch (Exception e) {
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            jsExecutor.executeScript("arguments[0].scrollIntoView(true);", karnatakaOption);
            jsExecutor.executeScript("arguments[0].click();", karnatakaOption);
        }

        Thread.sleep(5000);
        } catch (Exception e) {
            System.out.println(driver.getPageSource());  // Print page source for debugging
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, new File("error_screenshot.png"));  // Save screenshot
            throw e;  // Re-throw the exception to ensure test fails
        }
    }
    
        

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
