package AutomationRestAPI.SeleniumAutomationRestAPI;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class AmazonIPhonePurchaseTest 
{
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() 
    {
        // Set up WebDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hp\\Downloads\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @Test
    public void testIPhonePurchase() throws InterruptedException 
    {
        // Search for iPhone
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("iPhone");
        
        WebElement searchButton = driver.findElement(By.id("nav-search-submit-button"));
        searchButton.click();
        
        WebElement secondExpensiveIPhone = driver.findElement(By.linkText("Apple iPhone 15 Plus (128 GB) - Black"));
        secondExpensiveIPhone.click();
        
        Set<String> s = driver.getWindowHandles();
        ArrayList<String> ar = new ArrayList<>(s);
        driver.switchTo().window(ar.get(1));
        
        WebElement addCard = driver.findElement(By.xpath("(//input[@id='add-to-cart-button'])[2]"));
        addCard.click();
        
        WebElement proceedToCheckOut = driver.findElement(By.xpath("(//input[@aria-labelledby='attach-sidesheet-checkout-button-announce'])[1]"));
        proceedToCheckOut.click();
        
        Thread.sleep(2000);
        WebElement enterEmail = driver.findElement(By.xpath("//input[@id='ap_email_login']"));
        enterEmail.sendKeys("vishwassv1995@gmail.com");
        
        Thread.sleep(2000);
        
        WebElement continueButton = driver.findElement(By.xpath("//input[@type='submit']"));
        continueButton.click();
        
        Thread.sleep(2000);
        
        WebElement enterPassword = driver.findElement(By.xpath("//input[@id='ap_password']"));
        enterPassword.sendKeys("Vishu@2024");
        
        Thread.sleep(2000);
        
        WebElement signInButton = driver.findElement(By.xpath("//input[@id='signInSubmit']"));
        signInButton.click();
        
        WebElement fullNameInput = driver.findElement(By.xpath("(//input[@id='address-ui-widgets-enterAddressFullName'])[1]"));
        fullNameInput.sendKeys("Vishwas Iyenagr");
        
        WebElement mobileNumberInput = driver.findElement(By.xpath("(//input[@id='address-ui-widgets-enterAddressPhoneNumber'])[1]"));
        mobileNumberInput.sendKeys("6361797204");
        
        WebElement postalCodeInput =  driver.findElement(By.xpath("(//input[@id='address-ui-widgets-enterAddressPostalCode'])[1]"));
        postalCodeInput.sendKeys("560072");
        
        WebElement flatHousenoBuildingCompanyApartmentInput =  driver.findElement(By.xpath("(//input[@id='address-ui-widgets-enterAddressLine1'])[1]"));
        flatHousenoBuildingCompanyApartmentInput.sendKeys("#20/21 Sri KrishnaVenu");
        
        WebElement areaStreetSectorVillageInput = driver.findElement(By.xpath("(//input[@id='address-ui-widgets-enterAddressLine2'])[1]"));
        areaStreetSectorVillageInput.sendKeys("Maruthi Nagar 5th cross Chandra Layout");
        
        WebElement landMark = driver.findElement(By.xpath("(//input[@id='address-ui-widgets-landmark'])[1]"));	
        landMark.sendKeys("Beside Deffodil Kid Center");
        
       WebElement City  = driver.findElement(By.xpath("(//input[@id='address-ui-widgets-enterAddressCity'])[1]"));
       City.sendKeys("BENGALURU");
        WebElement stateDropdown = driver.findElement(By.xpath("(//span[@role='button'])[2]"));
        stateDropdown.click(); // Assuming it's a custom dropdown that opens on click  
        WebElement karnatakaOption = driver.findElement(By.xpath("(//a[normalize-space()='KARNATAKA'])[1]"));
        try 
         {
        	karnatakaOption.click();
         } 
         catch (Exception e) 
         {          
        	 JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
             jsExecutor.executeScript("arguments[0].scrollIntoView(true);", karnatakaOption);         
         } 
        Thread.sleep(5000);
    }
    
      
    @AfterClass
    public void tearDown() 
    {       
        driver.quit();
    }	 
}

