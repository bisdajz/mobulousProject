package MyAutomation.maven;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.security.NoSuchAlgorithmException;
import java.time.Duration;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class EasyHealth {

	public static void main(String[] args) throws InterruptedException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, IOException {
		 WebDriver driver = new ChromeDriver();
		 
	        // Maximize the browser
	        driver.manage().window().maximize();
	        driver.get("http://13.127.181.252/easy_health");
	        Thread.sleep(2000);
	        String ActualTitle = driver.getTitle();
	        String ExpectedTitle = "Easy Health";
	        Assert.assertEquals(ExpectedTitle, ActualTitle);
  	        System.out.println("Title Matched");
  	      List<WebElement> images = driver.findElements(By.tagName("img"));
  	    System.out.println("The number of images at login page is " + images.size());
         

  	      Thread.sleep(3000);
  	     WebElement button=driver.findElement(By.xpath("/html/body/div/div/header/div[1]/nav/div/ul[2]/li/a"));
  	     button.click();

//     List<WebElement> image = driver.findElements(By.tagName("img"));
//	    System.out.println("The number of images at admin dashboard is " + image.size());
  	     WebElement emailbutton=driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div/div/div[1]/ul/li[2]/a"));
  	   emailbutton.click();
  	 WebElement emailField = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div/div/div[2]/div/div/div[1]/div[1]/div/input"));
     WebElement passwordField = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div/div/div[2]/div/div/div[1]/div[2]/div[1]/input"));

     // Send keys to the email field
     emailField.sendKeys("mohd21@gmail.com");

     // Send keys to the password fieldO
     passwordField.sendKeys("Qwerty@12");
     
//     String password = "your_password";
//     SecretKeySpec key = new SecretKeySpec("your_secret_key".getBytes(), "AES");
//     Cipher cipher = Cipher.getInstance("AES");
//     try {
//		cipher.init(Cipher.ENCRYPT_MODE, key);
//	} catch (InvalidKeyException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//     byte[] encryptedPasswordBytes = cipher.doFinal(password.getBytes());
//     String encryptedPassword = Base64.getEncoder().encodeToString(encryptedPasswordBytes);
//
//     // Send the encrypted password to the password field
//     passwordField.sendKeys(encryptedPassword);
//     
//     
     
     
     
     
     
     
     
     
     
     Thread.sleep(2000);
     WebElement emailloginbutton=driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div/div/div[2]/div/div/div[2]/button"));
     emailloginbutton.click(); 
   //  List<WebElement> images1 = driver.findElements(By.tagName("img"));
//     int timeout = 1000;
//	new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(By.id("checkoutLink")));
//     driver.findElement(By.id("checkoutLink")).click();
//   for (WebElement image1 : images1) {
//       String src = image1.getAttribute("src");
//       try {
//           URL url = new URL(src);
//           HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//           int responseCode = connection.getResponseCode();
//           if (responseCode == 404 || responseCode >= 500) {
//               System.out.println("Broken image: " + src);
//           }
//       } catch (Exception e) {
//           System.out.println("Error checking image: " + src);
//         
//       }
//   }
   
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
       
       WebElement sectionElement = driver.findElement(By.xpath("/html/body/div/div/section[3]/div")); // Replace with your section's CSS selector

       // Scroll to the section element
       jsExecutor.executeScript("arguments[0].scrollIntoView(true);", sectionElement);
       
      // WebElement section = driver.findElement(By.cssSelector(".doctor-section"));

    // Find all doctor card elements within the section
//    List<WebElement> doctorCards = section.findElements(By.cssSelector(".doctor-card"));
//
//    // Iterate over the doctor card elements and find the one that matches the desired doctor's name
//    for (WebElement doctorCard : doctorCards) {
//        String doctorName = doctorCard.findElement(By.cssSelector(".doctor-name")).getText();
//        if (doctorName.equals("Dr. John Smith")) { // Replace with the desired doctor's name
//            // Find the button element within the matching doctor card
//            WebElement button1 = doctorCard.findElement(By.cssSelector(".select-button"));
//            // Click on the button element to select the desired doctor
//            button1.click();
       
       File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
       System.out.println("Screenshot path: " + screenshot.getAbsolutePath());

       // Specify the location to save the screenshot
       File destinationDir = new File("src/resources/screenshot");
       if (!destinationDir.exists()) {
           destinationDir.mkdirs(); // Create the directory if it doesn't exist
       }
       File destination = new File(destinationDir, "screenshot.png");

       // Copy the screenshot to the specified location using Java NIO
       Files.copy(screenshot.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);


       System.out.println("Screenshot taken and saved as " + destination.getAbsolutePath());
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/section[3]/div")));

       // Get the list of doctor cards
       List<WebElement> doctorCards = driver.findElements(By.xpath("/html/body/div/div/section[3]/div/div[2]/div/div[1]/div/div[14]/div/div"));

       // Wait for the cards to move left to right every 3 seconds
       wait.until(ExpectedConditions.attributeToBe(By.xpath("/html/body/div/div/section[3]/div/div[2]/div/div[1]/div/div[11]/div/div"), "style", "transform: translateX(0px);"));

       // Select a doctor card (e.g., the first one)
       WebElement selectedDoctorCard = doctorCards.get(7);

       // Perform a click action on the selected doctor card
       Actions actions = new Actions(driver);
       actions.moveToElement(selectedDoctorCard).click().perform();
  
      
   }
  	    
	
}