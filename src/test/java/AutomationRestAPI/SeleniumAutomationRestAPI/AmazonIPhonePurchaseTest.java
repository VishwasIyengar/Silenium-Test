package AutomationRestAPI.SeleniumAutomationRestAPI;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class AmazonIPhonePurchaseTest 
{
     WebDriver driver;
     WebDriverWait wait;
    
    @SuppressWarnings("deprecation")
	@BeforeClass
    public void setUp() 
    {
        // Set up WebDriver
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\OneDrive\\Desktop\\Selenium3\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	driver.manage().deleteAllCookies();
        
    }
        

    @Test
    public void testIPhonePurchase() throws InterruptedException 
    {
    	// Search for iPhone
        WebElement searchBox = driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]"));
        searchBox.sendKeys("iPhone");
        
        WebElement searchButton = driver.findElement(By.xpath("//input[@id=\"nav-search-submit-button\"]"));
        searchButton.click();
        
        WebElement secondExpensiveIPhone = driver.findElement(By.linkText("Apple iPhone 15 Plus (128 GB) - Black"));
        secondExpensiveIPhone.click();
        
        Set<String> s = driver.getWindowHandles();
        ArrayList ar = new ArrayList(s);
        System.out.println(ar.get(0));
        System.out.println(ar.get(1));
        driver.switchTo().window((String)ar.get(1));
        
        WebElement addCard = driver.findElement(By.xpath("(//input[@id='add-to-cart-button'])[2]"));
        addCard.click();
        
        WebElement proceedToCheckOut = driver.findElement(By.xpath("(//input[@aria-labelledby='attach-sidesheet-checkout-button-announce'])[1]"));
        proceedToCheckOut.click();
        
        WebElement enterEmail = driver.findElement(By.xpath("(//input[@id='ap_email'])[1]"));
        enterEmail.sendKeys("vishwassv1995@gmail.com");
        
        WebElement continueButton = driver.findElement(By.xpath("(//input[@id='continue'])[1]"));
        continueButton.click();
        
        WebElement enterPassword = driver.findElement(By.xpath("(//input[@id='ap_password'])[1]"));
        enterPassword.sendKeys("Vishu@2024");
        
        WebElement signInButton = driver.findElement(By.xpath("(//input[@id='signInSubmit'])[1]"));
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
