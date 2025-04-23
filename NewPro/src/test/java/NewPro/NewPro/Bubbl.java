package NewPro.NewPro;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Bubbl {

	private static final String actions = null;

	public static void main(String[] args) throws InterruptedException {
		 WebDriver driver = new ChromeDriver();
		 
	        // Maximize the browser
	        driver.manage().window().maximize();
	        driver.get("http://15.206.16.230/Bubbl/Website/");
	        String ActualTitle = driver.getTitle();
	        String ExpectedTitle = "Bubbl";
	        Assert.assertEquals(ExpectedTitle, ActualTitle);
	        System.out.println("Title Matched");
	      List<WebElement> images = driver.findElements(By.tagName("img"));
	    System.out.println("The number of images at login page is " + images.size());
      
	    try {
         WebElement loginElement = driver.findElement(By.xpath("/html/body/div/header/div/div/nav/div/ul[2]/li[1]/a"));
         assertTrue(loginElement.isDisplayed(), "Text 'Log In' is not present on the page");           
         System.out.println("Text 'Login' is present on the page");
     } catch (org.openqa.selenium.NoSuchElementException e) {
         System.out.println("Text 'Login' is not present on the page");
     }
	    
	
	     WebElement button=driver.findElement(By.xpath("/html/body/div/header/div/div/nav/div/ul[2]/li[1]/a"));
	     button.click();
	  	 WebElement emailField = driver.findElement(By.xpath("/html/body/div/div/div[2]/form/div[1]/input"));
	     WebElement passwordField = driver.findElement(By.xpath("/html/body/div/div/div[2]/form/div[2]/input"));
	     // Send keys to the email field
	     emailField.sendKeys("emee@getnada.com");
	     // Send keys to the password field
	     passwordField.sendKeys("Qwerty@12");   
	     Thread.sleep(2000);
	     WebElement loginbutton=driver.findElement(By.xpath("/html/body/div/div/div[2]/form/button"));
	     loginbutton.click(); 
	     
	     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
         WebElement toastMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/section/div/div"))); // Replace with actual ID or locator

         // Check if the toast message is displayed
         if (toastMessage.isDisplayed()) {
             System.out.println("Success toast message is displayed: " + toastMessage.getText());
         } else {
             System.out.println("Success toast message is NOT displayed.");
         }
         int[][] screenSizes = {
                 {375, 667},  // Mobile (iPhone 6/7/8)
                 {768, 1024}, // Tablet (iPad)
                 {1024, 768}, // Desktop (Small)
                 {1440, 900}, // Desktop (Medium)
                 {1920, 1080} // Desktop (Large)
             };
         for (int[] size : screenSizes) {
             int width = size[0];
             int height = size[1];

             // Resize the browser window
             driver.manage().window().setSize(new org.openqa.selenium.Dimension(width, height));
             System.out.println("Testing screen size: " + width + "x" + height);
             WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
             try {
                 // Replace with an actual element that should be visible on the page
                 WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div[2]/div[2]/a"))); // Replace with actual ID
                 System.out.println("Element is visible at " + width + "x" + height + ": " + element.isDisplayed());
             } catch (Exception e) {
                 System.out.println("Element not found or not visible at " + width + "x" + height);
             }
             JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

             // Scroll the page slowly
             int scrollHeight = Integer.parseInt(jsExecutor.executeScript("return document.body.scrollHeight").toString());
             int scrollStep = 100; // adjust this value to control the scroll speed
             int scrollDelay = 500; // adjust this value to control the scroll delay

             for (int i = 0; i < scrollHeight; i += scrollStep) {
                 jsExecutor.executeScript("window.scrollTo(0, " + i + ")");
                 try {
                     Thread.sleep(scrollDelay);
                 } catch (InterruptedException e) {
                     Thread.currentThread().interrupt();
                 }
             }
                 for (int i = scrollHeight; i >= 0; i -= scrollStep) {
                     jsExecutor.executeScript("window.scrollTo(0, " + i + ")");
                     try {
                         Thread.sleep(scrollDelay);
                     } catch (InterruptedException e) {
                         Thread.currentThread().interrupt();
                     }
              }
                
     }
         WebElement mycars=driver.findElement(By.xpath("/html/body/div/div/div[1]/div[2]/ul/li[2]/a"));
	     mycars.click(); 
	     try {
	            
	            WebElement addCarbutton = driver.findElement(By.xpath("/html/body/div/div/div[3]/a"));

	            // Check if it's displayed
	            if (addCarbutton.isDisplayed()) {
	                System.out.println("✅ Button is visible on the page.");
	            } else {
	                System.out.println("❌ Button is NOT visible on the page.");
	            }
	        } catch (Exception e) {
	            System.out.println("⚠️ Button not found or not visible.");
	        }

	     WebElement addCar=driver.findElement(By.xpath("/html/body/div/div/div[3]/a"));
	     addCar.click(); 
	     
	     Thread.sleep(5000);
	     
	     WebElement logo=driver.findElement(By.xpath("/html/body/div/div/div[1]/div[2]/figure/a/img"));
	     logo.click();  
	     
	     Actions actions = new Actions(driver);
	     WebElement profile = driver.findElement(By.xpath("/html/body/div/div/div[1]/div[1]/ul/li[1]/a/img"));
	        actions.moveToElement(profile).perform();
	        System.out.println("✅ Hovered over profile");

	        // Wait a bit 
	        Thread.sleep(3000);

	        
	        WebElement notification = driver.findElement(By.xpath("/html/body/div/div/div[1]/div[1]/ul/li[2]/a/img"));
	        actions.moveToElement(notification).perform();
	        System.out.println("✅ Hovered over notifications");
         }
  }
